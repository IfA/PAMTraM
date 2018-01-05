/**
 *
 */
package pamtram.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry.Internal;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

/**
 * A utility class to simplify handling of {@link ExtendedMetaData} elements during a transformaiton.
 *
 * @author mfreund
 */
public class ExtendedMetaDataUtil {

	/**
	 * The single instance of {@link ExtendedMetaData} that we use to create/read/set metadata.
	 */
	private static ExtendedMetaData extendedMetaData;

	/**
	 * This initializes the {@link #extendedMetaData}.
	 */
	private static void initMetaData() {

		ExtendedMetaDataUtil.extendedMetaData = new BasicExtendedMetaData(EPackageRegistryImpl.INSTANCE);

	}

	/**
	 * Returns the {@link #extendedMetaData}.
	 *
	 * @return the {@link #extendedMetaData}}
	 */
	private static ExtendedMetaData getMetaData() {

		if (ExtendedMetaDataUtil.extendedMetaData == null) {
			ExtendedMetaDataUtil.initMetaData();
		}

		return ExtendedMetaDataUtil.extendedMetaData;
	}

	/**
	 * Returns whether the given class is based on an XSD element with 'xs:any'-content.
	 *
	 * @param parentClass
	 *            The {@link EClass} to check.
	 * @return '<em>true</em>' if equipped with 'xs:any'-content.
	 */
	public static boolean allowsAnyContent(EClass parentClass) {

		return parentClass.getEAttributes().stream().anyMatch(a -> "any".equals(a.getName())
				&& a.getEAttributeType().equals(EcorePackage.Literals.EFEATURE_MAP_ENTRY));
	}

	/**
	 * This allows to add the given <em>childElement</em> as child of the given <em>parentElement</em> via the given
	 * {@link EAttribute} that represents a {@link FeatureMap} created based on an 'xs:any' element.
	 * <p />
	 * Therefore, a new (virtual) reference is created on the fly
	 *
	 * @param parentElement
	 *            The parent {@link EObject}.
	 * @param anyFeature
	 *            The {@link EAttribute} representing the 'xs:any' element.
	 * @param childElement
	 *            The child {@link EObject} to add.
	 * @return The new virtual reference via that the child element has been added.
	 */
	public static EReference addAnyConent(EObject parentElement, EAttribute anyFeature, EObject childElement) {

		EReference virtualReference = ExtendedMetaDataUtil.createVirtualReference(childElement.eClass());

		Internal featureMapEntry = FeatureMapUtil.createRawEntry(virtualReference, childElement);

		FeatureMap rootMixed = (FeatureMap) parentElement.eGet(anyFeature);

		rootMixed.add(anyFeature, featureMapEntry);

		return virtualReference;
	}

	/**
	 * Create a new (virtual) reference of the given type that can be used to add content to 'xs:any'-based elements.
	 *
	 * @param referenceType
	 *            The type of the new reference.
	 * @return The created {@link EReference}.
	 */
	public static EReference createVirtualReference(EClass referenceType) {

		EReference virtualReference = (EReference) ExtendedMetaDataUtil.getMetaData()
				.demandFeature(referenceType.getEPackage().getNsURI(), referenceType.getName(), true);
		virtualReference.setEType(referenceType);
		virtualReference.setContainment(true);
		return virtualReference;
	}

}
