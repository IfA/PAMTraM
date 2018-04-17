/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.mapping.extended.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMappingExternalSourceElement;
import pamtram.mapping.extended.AttributeMappingGlobalSourceElement;
import pamtram.mapping.extended.AttributeMappingSourceElement;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingExternalSourceElement;
import pamtram.mapping.extended.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceElement;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ExternalMappedAttributeValueAppender;
import pamtram.mapping.extended.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.extended.MappedAttributeValueAppender;
import pamtram.mapping.extended.MappedAttributeValuePrepender;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.StructureFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ExtendedFactoryImpl extends EFactoryImpl implements ExtendedFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ExtendedFactory init() {
		try {
			ExtendedFactory theExtendedFactory = (ExtendedFactory)EPackage.Registry.INSTANCE.getEFactory(ExtendedPackage.eNS_URI);
			if (theExtendedFactory != null) {
				return theExtendedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExtendedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER: return createGlobalAttributeImporter();
			case ExtendedPackage.ATTRIBUTE_MAPPING: return createAttributeMapping();
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT: return createAttributeMappingSourceElement();
			case ExtendedPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT: return createAttributeMappingExternalSourceElement();
			case ExtendedPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT: return createAttributeMappingGlobalSourceElement();
			case ExtendedPackage.CARDINALITY_MAPPING: return createCardinalityMapping();
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_ELEMENT: return createCardinalityMappingSourceElement();
			case ExtendedPackage.CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT: return createCardinalityMappingExternalSourceElement();
			case ExtendedPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT: return createCardinalityMappingGlobalSourceElement();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR: return createReferenceTargetSelector();
			case ExtendedPackage.CONTAINER_SELECTOR: return createContainerSelector();
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER: return createMappedAttributeValuePrepender();
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER: return createMappedAttributeValueAppender();
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER: return createExternalMappedAttributeValuePrepender();
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER: return createExternalMappedAttributeValueAppender();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedPackage getExtendedPackage() {
		return (ExtendedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeMapping createAttributeMapping() {
		AttributeMappingImpl attributeMapping = new AttributeMappingImpl();
		return attributeMapping;
	}

	/**
	 */
	@Override
	public AttributeMapping createAttributeMappingWithSource() {

		AttributeMapping attributeMapping = this.createAttributeMapping();
		attributeMapping.getSourceElements().add(new AttributeMappingSourceElementImpl());
		return attributeMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeMappingSourceElement createAttributeMappingSourceElement() {
		AttributeMappingSourceElementImpl attributeMappingSourceElement = new AttributeMappingSourceElementImpl();
		return attributeMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeMappingExternalSourceElement createAttributeMappingExternalSourceElement() {
		AttributeMappingExternalSourceElementImpl attributeMappingExternalSourceElement = new AttributeMappingExternalSourceElementImpl();
		return attributeMappingExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeMappingGlobalSourceElement createAttributeMappingGlobalSourceElement() {
		AttributeMappingGlobalSourceElementImpl attributeMappingGlobalSourceElement = new AttributeMappingGlobalSourceElementImpl();
		return attributeMappingGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMapping createCardinalityMapping() {
		CardinalityMappingImpl cardinalityMapping = new CardinalityMappingImpl();
		return cardinalityMapping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMappingSourceElement createCardinalityMappingSourceElement() {
		CardinalityMappingSourceElementImpl cardinalityMappingSourceElement = new CardinalityMappingSourceElementImpl();
		return cardinalityMappingSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMappingExternalSourceElement createCardinalityMappingExternalSourceElement() {
		CardinalityMappingExternalSourceElementImpl cardinalityMappingExternalSourceElement = new CardinalityMappingExternalSourceElementImpl();
		return cardinalityMappingExternalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityMappingGlobalSourceElement createCardinalityMappingGlobalSourceElement() {
		CardinalityMappingGlobalSourceElementImpl cardinalityMappingGlobalSourceElement = new CardinalityMappingGlobalSourceElementImpl();
		return cardinalityMappingGlobalSourceElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferenceTargetSelector createReferenceTargetSelector() {
		ReferenceTargetSelectorImpl referenceTargetSelector = new ReferenceTargetSelectorImpl();
		return referenceTargetSelector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContainerSelector createContainerSelector() {
		ContainerSelectorImpl containerSelector = new ContainerSelectorImpl();
		return containerSelector;
	}

	/**
	 */
	@Override
	public ContainerSelector createContainerSelectorWithSource() {

		ContainerSelector modelConnectionHint = this.createContainerSelector();
		modelConnectionHint.getSourceElements().add(StructureFactory.eINSTANCE.createInstanceSelectorSourceElement());
		return modelConnectionHint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedAttributeValuePrepender createMappedAttributeValuePrepender() {
		MappedAttributeValuePrependerImpl mappedAttributeValuePrepender = new MappedAttributeValuePrependerImpl();
		return mappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedAttributeValueAppender createMappedAttributeValueAppender() {
		MappedAttributeValueAppenderImpl mappedAttributeValueAppender = new MappedAttributeValueAppenderImpl();
		return mappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValuePrepender createExternalMappedAttributeValuePrepender() {
		ExternalMappedAttributeValuePrependerImpl externalMappedAttributeValuePrepender = new ExternalMappedAttributeValuePrependerImpl();
		return externalMappedAttributeValuePrepender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalMappedAttributeValueAppender createExternalMappedAttributeValueAppender() {
		ExternalMappedAttributeValueAppenderImpl externalMappedAttributeValueAppender = new ExternalMappedAttributeValueAppenderImpl();
		return externalMappedAttributeValueAppender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GlobalAttributeImporter createGlobalAttributeImporter() {
		GlobalAttributeImporterImpl globalAttributeImporter = new GlobalAttributeImporterImpl();
		return globalAttributeImporter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExtendedPackage getPackage() {
		return ExtendedPackage.eINSTANCE;
	}

} // ExtendedFactoryImpl
