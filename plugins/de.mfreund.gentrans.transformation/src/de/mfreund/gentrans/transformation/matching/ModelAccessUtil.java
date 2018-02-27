/**
 *
 */
package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.structure.source.VirtualSourceSectionCrossReference;
import pamtram.util.OCLUtil;

/**
 * A helper class that provides various utility methods concerned with accessing models resp. retrieving values of
 * {@link Reference References} or {@link Attribute Attributes}.
 * <p />
 * Note: All model access should be performed via this class because:
 * <ol>
 * <li>All relevant methods are synchronized and can thus safely be used by parallelized processes.</li>
 * <li>Retrieved values are {@link #bufferedValues buffered} in order to prevent the multiple (time-consuming) reading
 * of the same values.
 * </ol>
 *
 * @author mfreund
 */
public class ModelAccessUtil extends TransformationAsset {

	/**
	 * The map were retrieved {@link EStructuralFeature feature} values are stored in order to prevent duplicate model
	 * access operation.
	 */
	private final ConcurrentHashMap<ObjectFeaturePair, List<Object>> bufferedValues;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public ModelAccessUtil(TransformationAssetManager assetManager) {

		super(assetManager);

		this.bufferedValues = new ConcurrentHashMap<>();
	}

	/**
	 * For the given {@link EObject source model element}, this returns the value or values held via the given
	 * {@link Reference}.
	 * <p />
	 * Note: This will just redirect to {@link #getFeatureValueAsListBuffered(EObject, MetaModelElement)}.
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

		return this.getFeatureValueAsListBuffered(eObject, reference).stream().filter(e -> e instanceof EObject)
				.map(e -> (EObject) e).collect(Collectors.toList());
	}

	/**
	 * For the given list of {@link EObject source model elements}, this returns the values held via the given
	 * {@link Attribute}.
	 * <p />
	 * Note: This will just redirect to {@link #getAttributeValueAsList(EObject, Attribute)} for each of the given
	 * eObject and combine the results.
	 *
	 * @param eObjects
	 *            The list of {@link EObject EObjects} for that the values shall be returned.
	 * @param attribute
	 *            The {@link Attribute} for that the values shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public List<Object> getAttributeValueAsList(List<EObject> eObjects, Attribute<?, ?, ?, ?> attribute) {

		return eObjects.stream().flatMap(e -> this.getAttributeValueAsList(e, attribute).stream())
				.collect(Collectors.toList());
	}

	/**
	 * For the given {@link EObject source model element}, this returns the value or values held via the given
	 * {@link Attribute}.
	 * <p />
	 * Note: This will just redirect to {@link #getFeatureValueAsListBuffered(EObject, MetaModelElement)}.
	 * <p />
	 * Note: As EStructuralFeatures can be {@link EStructuralFeature#isMany() many-valued}, this will return either no
	 * value, a single value, or a list of values.
	 * <p />
	 * Note: The type of the entries inside the list will match the type of the given
	 * {@link EAttribute#getEAttributeType() EAttribute}.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the values shall be returned.
	 * @param attribute
	 *            The {@link Attribute} for that the values shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public List<Object> getAttributeValueAsList(EObject eObject, Attribute<?, ?, ?, ?> attribute) {

		return this.getFeatureValueAsListBuffered(eObject, attribute);
	}

	/**
	 * For the given list of {@link EObject source model elements}, this returns the values held via the given
	 * {@link Attribute} as Strings.
	 * <p />
	 * Note: This will just redirect to {@link #getAttributeValueAsStringList(EObject, Attribute)} for each of the given
	 * eObject and combine the results.
	 *
	 * @param eObjects
	 *            The list of {@link EObject EObjects} for that the values shall be returned.
	 * @param attribute
	 *            The {@link Attribute} for that the values shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public List<String> getAttributeValueAsStringList(List<EObject> eObjects, Attribute<?, ?, ?, ?> attribute) {

		return eObjects.stream().flatMap(e -> this.getAttributeValueAsStringList(e, attribute).stream())
				.collect(Collectors.toList());
	}

	/**
	 * For the given {@link EObject source model element}, this returns the value or values held via the given
	 * {@link Attribute} as Strings. Therefore, the values returned by
	 * {@link ModelAccessUtil#getAttributeValueAsList(EObject, Attribute)} are converted to a String representation.
	 * <p />
	 * Note: As EStructuralFeatures can be {@link EStructuralFeature#isMany() many-valued}, this will return either no
	 * value, a single value, or a list of values.
	 * <p />
	 * Note: The type of the entries inside the list will match the type of the given
	 * {@link EAttribute#getEAttributeType() EAttribute}.
	 *
	 * @param eObject
	 *            The {@link EObject} for that the values shall be returned.
	 * @param attribute
	 *            The {@link Attribute} for that the values shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public List<String> getAttributeValueAsStringList(EObject eObject, Attribute<?, ?, ?, ?> attribute) {

		List<Object> srcAttrValues = this.getAttributeValueAsList(eObject, attribute);

		EAttribute eAttribute = attribute instanceof ActualSourceSectionAttribute
				? ((ActualSourceSectionAttribute) attribute).getAttribute()
				: null;

		List<String> srcAttrValuesAsString = new ArrayList<>();

		for (Object srcAttrValue : srcAttrValues) {

			// convert Attribute value to String
			String srcAttrAsString = eAttribute != null ? eAttribute.getEType().getEPackage().getEFactoryInstance()
					.convertToString(eAttribute.getEAttributeType(), srcAttrValue) : srcAttrValue.toString();
			srcAttrValuesAsString.add(srcAttrAsString);
		}

		return srcAttrValuesAsString;
	}

	/**
	 * For the given {@link EObject source model element}, this returns the value or values held via the given
	 * {@link MetaModelElement} (either an {@link Attribute} or a {@link Reference}.
	 * <p />
	 * Note: If present, this will use the associated {@link #bufferedValues} in order to prevent multiple
	 * (time-consuming) reading/computation of the same values.
	 * <p />
	 * Note: If new values have to be computed, this will either redirect to
	 * {@link AgteleEcoreUtil#getStructuralFeatureValueAsList(EObject, EStructuralFeature)} (for {@link ActualAttribute
	 * ActualAttributes} or to {@link OCLUtil#evaluteQuery(String, EObject)} (for {@link VirtualAttribute
	 * VirtualAttributes}.
	 *
	 * @see #getFeatureValueAsListRaw(EObject, MetaModelElement)
	 *
	 * @param eObject
	 *            The {@link EObject} for that the values shall be returned.
	 * @param feature
	 *            The {@link MetaModelElement} (either an {@link Attribute} or a {@link Reference} for that the values
	 *            shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	private List<Object> getFeatureValueAsListBuffered(EObject eObject, MetaModelElement<?, ?, ?, ?> feature) {

		ObjectFeaturePair pair = new ObjectFeaturePair(eObject, feature);

		return this.bufferedValues.computeIfAbsent(pair, p -> this.getFeatureValueAsListRaw(p.eObject, p.feature));

	}

	/**
	 * For the given {@link EObject source model element}, this returns the value or values held via the given
	 * {@link MetaModelElement} (either an {@link Attribute} or a {@link Reference}.
	 * <p />
	 * Note: If new values have to be computed, this will either redirect to
	 * {@link AgteleEcoreUtil#getStructuralFeatureValueAsList(EObject, EStructuralFeature)} (for {@link ActualAttribute
	 * ActualAttributes} or to {@link OCLUtil#evaluteQuery(String, EObject)} (for {@link VirtualAttribute
	 * VirtualAttributes}.
	 *
	 * @see #getFeatureValueAsListBuffered(EObject, MetaModelElement)
	 *
	 * @param eObject
	 *            The {@link EObject} for that the values shall be returned.
	 * @param feature
	 *            The {@link MetaModelElement} (either an {@link Attribute} or a {@link Reference} for that the values
	 *            shall be returned.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	private synchronized List<Object> getFeatureValueAsListRaw(EObject eObject, MetaModelElement<?, ?, ?, ?> feature) {

		List<Object> ret = new ArrayList<>();

		if (feature instanceof ActualReference<?, ?, ?, ?> || feature instanceof ActualAttribute<?, ?, ?, ?>) {

			EStructuralFeature eFeature = feature instanceof ActualReference<?, ?, ?, ?>
					? ((ActualReference<?, ?, ?, ?>) feature).getEReference()
					: ((ActualAttribute<?, ?, ?, ?>) feature).getAttribute();

			ret = AgteleEcoreUtil.getStructuralFeatureValueAsList(eObject, eFeature);

		} else if (feature instanceof VirtualSourceSectionCrossReference
				|| feature instanceof VirtualSourceSectionAttribute) {

			String derivation = feature instanceof VirtualSourceSectionCrossReference
					? ((VirtualSourceSectionCrossReference) feature).getDerivation()
					: ((VirtualSourceSectionAttribute) feature).getDerivation();

			Object value = null;
			try {
				value = OCLUtil.evaluteQuery(derivation, eObject);
			} catch (ParserException e) {
				this.logger.severe(() -> "Unable to evaluate OCL query '" + derivation + "' for the "
						+ feature.eClass().getName() + " '" + feature.getName() + "'!");
				this.logger.severe(() -> "The following error occurred: " + e.getMessage());
			}

			if (value instanceof Collection<?>) {
				ret = new ArrayList<>((Collection<?>) value);
			} else if (value != null) {
				ret = new ArrayList<>(Arrays.asList(value));
			}

		} else {
			this.assetManager.getLogger().severe(() -> "Unsupported MetaModelElement type '"
					+ feature.eClass().getName() + "' encountered for feature value retrieval! Skipping evaluation...");
		}

		return ret;
	}

	/**
	 * Instances of this represent a pair consisting of an {@link EObject} and a {@link MetaModelElement} representing a
	 * StructuralFeature.
	 *
	 * @author mfreund
	 */
	private class ObjectFeaturePair {

		/**
		 * The {@link EObject} of this pair.
		 */
		private EObject eObject;

		/**
		 * The {@link MetaModelElement} representing the feature of this pair (this should be either an
		 * {@link Attribute} or a {@link Reference}).
		 */
		private MetaModelElement<?, ?, ?, ?> feature;

		/**
		 * This creates an instance.
		 *
		 * @param eObject
		 *            The {@link EObject} for the new pair.
		 * @param feature
		 *            The {@link EStructuralFeature} for the new pair (this should be either an {@link Attribute} or a
		 *            {@link Reference}).
		 */
		public ObjectFeaturePair(EObject eObject, MetaModelElement<?, ?, ?, ?> feature) {

			this.eObject = eObject;
			this.feature = feature;
		}

		@Override
		public boolean equals(Object o) {

			if (this == o) {
				return true;
			}

			if (!(o instanceof ObjectFeaturePair)) {
				return false;
			}

			ObjectFeaturePair key = (ObjectFeaturePair) o;

			return this.eObject == key.eObject && this.feature == key.feature;
		}

		@Override
		public int hashCode() {

			return this.eObject.hashCode() + this.feature.hashCode();
		}
	}
}
