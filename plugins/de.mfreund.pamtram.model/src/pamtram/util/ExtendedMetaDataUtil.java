/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package pamtram.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

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
	private static synchronized void initMetaData() {

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

		return parentClass.getEAttributes().stream().anyMatch(ExtendedMetaDataUtil::isAnyContentAttribute);
	}

	/**
	 * Returns whether the given {@link EAttribute} is based on an XSD element with 'xs:any'-content.
	 *
	 * @param eAttribute
	 *            The {@link EAttribute} to check.
	 * @return '<em>true</em>' if equipped with 'xs:any'-content.
	 */
	public static boolean isAnyContentAttribute(EAttribute eAttribute) {

		return "any".equals(eAttribute.getName())
				&& eAttribute.getEAttributeType().equals(EcorePackage.Literals.EFEATURE_MAP_ENTRY);
	}

	/**
	 * This allows to add the given <em>childElement</em> as child of the given <em>parentElement</em> that represents
	 * an 'xs:any' element.
	 * <p />
	 * Therefore, a new (virtual) reference is created on the fly.
	 * <p />
	 * Note: A suitable {@link #isAnyContentAttribute(EAttribute) 'any-content attribute'} is determined automatically
	 * before redirecting to {@link #addAnyConent(EObject, EAttribute, EObject)}.
	 *
	 * @param parentElement
	 *            The parent {@link EObject}.
	 * @param childElement
	 *            The child {@link EObject} to add.
	 * @return '<em>true</em>' if the element was successfully added; '<em>false</em>' otherwise.
	 */
	public static boolean addAnyConent(EObject parentElement, EObject childElement) {

		return ExtendedMetaDataUtil.addAnyConent(parentElement, Arrays.asList(childElement));

	}

	/**
	 * This allows to add the given <em>childElements</em> as children of the given <em>parentElement</em> that
	 * represents an 'xs:any' element.
	 * <p />
	 * Therefore, a new (virtual) reference is created on the fly.
	 * <p />
	 * Note: A suitable {@link #isAnyContentAttribute(EAttribute) 'any-content attribute'} is determined automatically
	 * before redirecting to {@link #addAnyConent(EObject, EAttribute, EObject)}.
	 *
	 * @param parentElement
	 *            The parent {@link EObject}.
	 * @param childElements
	 *            The child {@link EObject EObjects} to add.
	 * @return '<em>true</em>' if the elements were successfully added; '<em>false</em>' otherwise.
	 */
	public static boolean addAnyConent(EObject parentElement, Collection<EObject> childElements) {

		Optional<EAttribute> anyContentAttribute = parentElement.eClass().getEAllAttributes().stream()
				.filter(ExtendedMetaDataUtil::isAnyContentAttribute).findAny();

		if (!anyContentAttribute.isPresent()) {
			return false;
		} else {
			return ExtendedMetaDataUtil.addAnyConent(parentElement, anyContentAttribute.get(), childElements);
		}

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
	 * @return '<em>true</em>' if the element was successfully added; '<em>false</em>' otherwise.
	 */
	public static boolean addAnyConent(EObject parentElement, EAttribute anyFeature, EObject childElement) {

		return ExtendedMetaDataUtil.addAnyConent(parentElement, anyFeature, Arrays.asList(childElement));
	}

	/**
	 * This allows to add the given <em>childElements</em> as children of the given <em>parentElement</em> via the given
	 * {@link EAttribute} that represents a {@link FeatureMap} created based on an 'xs:any' element.
	 * <p />
	 * Therefore, a new (virtual) reference is created on the fly
	 *
	 * @param parentElement
	 *            The parent {@link EObject}.
	 * @param anyFeature
	 *            The {@link EAttribute} representing the 'xs:any' element.
	 * @param childElements
	 *            The child {@link EObject EObjects} to add.
	 * @return '<em>true</em>' if the elements were successfully added; '<em>false</em>' otherwise.
	 */
	public static boolean addAnyConent(EObject parentElement, EAttribute anyFeature,
			Collection<EObject> childElements) {

		if (!ExtendedMetaDataUtil.isAnyContentAttribute(anyFeature)) {
			return false;
		}

		FeatureMap rootMixed = (FeatureMap) parentElement.eGet(anyFeature);

		for (EObject childElement : childElements) {

			EReference virtualReference = ExtendedMetaDataUtil.createVirtualReference(childElement.eClass());

			Internal featureMapEntry = FeatureMapUtil.createRawEntry(virtualReference, childElement);

			rootMixed.add(anyFeature, featureMapEntry);
		}

		return true;
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
