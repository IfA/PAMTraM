/**
 *
 */
package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;

import de.mfreund.gentrans.transformation.core.TransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.generic.VirtualReference;
import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.structure.source.VirtualSourceSectionCrossReference;
import pamtram.util.OCLUtil;

/**
 * A helper class that provides various utility methods concerned with traversing models via {@link Reference
 * References} or getting values of {@link Attribute Attributes}.
 *
 * @author mfreund
 */
public class ModelTraversalUtil extends TransformationAsset {

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public ModelTraversalUtil(TransformationAssetManager assetManager) {

		super(assetManager);
	}

	/**
	 * For the given {@link EObject source model element}, this returns the value or values held via the given
	 * {@link Reference}.
	 * <p />
	 * Note: This will either redirect to
	 * {@link AgteleEcoreUtil#getStructuralFeatureValueAsList(EObject, EStructuralFeature)} (for {@link ActualReference
	 * ActualReferences} or to {@link OCLUtil#evaluteQuery(String, EObject)} (for {@link VirtualReference
	 * VirtualReferences}.
	 * <p />
	 * Note: As EStructuralFeatures can be {@link EStructuralFeature#isMany() many-valued}, this will return either no
	 * value, a single value, or a list of values. Note: The type of the entries inside the list will match the type of
	 * the given {@link EAttribute#getEAttributeType() EAttribute} or {@link EReference#getEReferenceType() EReference}.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the values shall be returned.
	 * @param reference
	 *            The {@link Reference} for that the values shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public List<EObject> getReferenceValueAsList(EObject eObject, Reference<?, ?, ?, ?> reference) {

		List<Object> ret = new ArrayList<>();

		if (reference instanceof ActualReference<?, ?, ?, ?>) {

			if (((ActualReference<?, ?, ?, ?>) reference).getEReference() == null) {
				return new ArrayList<>();
			}

			ret = AgteleEcoreUtil.getStructuralFeatureValueAsList(eObject,
					((ActualReference<?, ?, ?, ?>) reference).getEReference());

		} else if (reference instanceof VirtualSourceSectionCrossReference) {

			if (((VirtualSourceSectionCrossReference) reference).getDerivation() == null) {
				return new ArrayList<>();
			}

			Object value = null;
			try {
				value = OCLUtil.evaluteQuery(((VirtualSourceSectionCrossReference) reference).getDerivation(), eObject);
			} catch (ParserException e) {
				this.logger.severe(() -> "Unable to evaluate OCL query '"
						+ ((VirtualSourceSectionCrossReference) reference).getDerivation()
						+ "' for SourceSectionCrossReference '" + reference.getName() + "'!");
				this.logger.severe(() -> "The following error occurred: " + e.getMessage());
				e.printStackTrace();
			}

			if (value == null) {
				// nothing to be done
				//
			} else if (value instanceof Collection<?>) {
				ret = new ArrayList<>((Collection<?>) value);
			} else {
				ret = new ArrayList<>(Arrays.asList(value));
			}

		} else {
			this.assetManager.getLogger().severe(() -> "Unsupported Reference type '" + reference.eClass().getName()
					+ "' encountered! Skipping evaluation...");
		}

		return ret.stream().filter(e -> e instanceof EObject).map(e -> (EObject) e).collect(Collectors.toList());
	}

	/**
	 * For the given {@link EObject source model element}, this returns the value or values held via the given
	 * {@link Attribute}.
	 * <p />
	 * Note: This will either redirect to
	 * {@link AgteleEcoreUtil#getStructuralFeatureValueAsList(EObject, EStructuralFeature)} (for {@link ActualAttribute
	 * ActualAttributes} or to {@link OCLUtil#evaluteQuery(String, EObject)} (for {@link VirtualAttribute
	 * VirtualAttributes}.
	 * <p />
	 * Note: As EStructuralFeatures can be {@link EStructuralFeature#isMany() many-valued}, this will return either no
	 * value, a single value, or a list of values. Note: The type of the entries inside the list will match the type of
	 * the given {@link EAttribute#getEAttributeType() EAttribute} or {@link EReference#getEReferenceType() EReference}.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the values shall be returned.
	 * @param attribute
	 *            The {@link Attribute} for that the values shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public List<Object> getAttributeValueAsList(EObject eObject, Attribute<?, ?, ?, ?> attribute) {

		if (attribute instanceof ActualAttribute<?, ?, ?, ?>) {

			return ((ActualAttribute<?, ?, ?, ?>) attribute).getAttribute() == null ? new ArrayList<>()
					: AgteleEcoreUtil.getStructuralFeatureValueAsList(eObject,
							((ActualAttribute<?, ?, ?, ?>) attribute).getAttribute());

		} else if (attribute instanceof VirtualSourceSectionAttribute) {

			if (((VirtualSourceSectionAttribute) attribute).getDerivation() == null) {
				return new ArrayList<>();
			}

			Object value;
			try {
				value = OCLUtil.evaluteQuery(((VirtualSourceSectionAttribute) attribute).getDerivation(), eObject);
			} catch (ParserException e) {
				this.logger.severe(() -> "Unable to evaluate OCL query '"
						+ ((VirtualSourceSectionAttribute) attribute).getDerivation()
						+ "' for VirtualSourceSectionAttribute '" + attribute.getName() + "'!");
				this.logger.severe(() -> "The following error occurred: " + e.getMessage());
				e.printStackTrace();
				return new ArrayList<>();
			}

			if (value == null) {
				return new ArrayList<>();
			} else if (value instanceof Collection<?>) {
				return new ArrayList<>((Collection<?>) value);
			} else {
				return new ArrayList<>(Arrays.asList(value));
			}

		} else {
			this.assetManager.getLogger().severe(() -> "Unsupported Attribute type '" + attribute.eClass().getName()
					+ "' encountered! Skipping evaluation...");
			return new ArrayList<>();
		}

	}
}
