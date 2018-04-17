/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
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
package de.mfreund.pamtram.transformation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.mfreund.pamtram.transformation.TransformationFactory
 * @model kind="package"
 * @generated
 */
public interface TransformationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "transformation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mfreund.de/pamtram/transformation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "transformation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransformationPackage eINSTANCE = de.mfreund.pamtram.transformation.impl.TransformationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.mfreund.pamtram.transformation.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.mfreund.pamtram.transformation.impl.TransformationImpl
	 * @see de.mfreund.pamtram.transformation.impl.TransformationPackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__START_DATE = 0;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__END_DATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__ID = 3;

	/**
	 * The feature id for the '<em><b>Pamtram Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__PAMTRAM_INSTANCES = 4;

	/**
	 * The feature id for the '<em><b>Library Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__LIBRARY_ENTRIES = 5;

	/**
	 * The feature id for the '<em><b>Source Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__SOURCE_MODELS = 6;

	/**
	 * The feature id for the '<em><b>Target Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__TARGET_MODELS = 7;

	/**
	 * The feature id for the '<em><b>Transformation Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__TRANSFORMATION_MAPPINGS = 8;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.mfreund.pamtram.transformation.impl.TransformationMappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.mfreund.pamtram.transformation.impl.TransformationMappingImpl
	 * @see de.mfreund.pamtram.transformation.impl.TransformationPackageImpl#getTransformationMapping()
	 * @generated
	 */
	int TRANSFORMATION_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING__SOURCE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Associated Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Transformation Hint Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING__TRANSFORMATION_HINT_GROUPS = 2;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.mfreund.pamtram.transformation.impl.TransformationMappingHintGroupImpl <em>Mapping Hint Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.mfreund.pamtram.transformation.impl.TransformationMappingHintGroupImpl
	 * @see de.mfreund.pamtram.transformation.impl.TransformationPackageImpl#getTransformationMappingHintGroup()
	 * @generated
	 */
	int TRANSFORMATION_MAPPING_HINT_GROUP = 2;

	/**
	 * The feature id for the '<em><b>Target Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Associated Mapping Hint Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP = 1;

	/**
	 * The number of structural features of the '<em>Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING_HINT_GROUP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Mapping Hint Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MAPPING_HINT_GROUP_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.mfreund.pamtram.transformation.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the attribute '{@link de.mfreund.pamtram.transformation.Transformation#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getStartDate()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link de.mfreund.pamtram.transformation.Transformation#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getEndDate()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_EndDate();

	/**
	 * Returns the meta object for the attribute '{@link de.mfreund.pamtram.transformation.Transformation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getName()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.mfreund.pamtram.transformation.Transformation#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getId()
	 * @see #getTransformation()
	 * @generated
	 */
	EAttribute getTransformation_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link de.mfreund.pamtram.transformation.Transformation#getPamtramInstances <em>Pamtram Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pamtram Instances</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getPamtramInstances()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_PamtramInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link de.mfreund.pamtram.transformation.Transformation#getLibraryEntries <em>Library Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Library Entries</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getLibraryEntries()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_LibraryEntries();

	/**
	 * Returns the meta object for the containment reference list '{@link de.mfreund.pamtram.transformation.Transformation#getSourceModels <em>Source Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Models</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getSourceModels()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_SourceModels();

	/**
	 * Returns the meta object for the containment reference list '{@link de.mfreund.pamtram.transformation.Transformation#getTargetModels <em>Target Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Models</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getTargetModels()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_TargetModels();

	/**
	 * Returns the meta object for the containment reference list '{@link de.mfreund.pamtram.transformation.Transformation#getTransformationMappings <em>Transformation Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformation Mappings</em>'.
	 * @see de.mfreund.pamtram.transformation.Transformation#getTransformationMappings()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_TransformationMappings();

	/**
	 * Returns the meta object for class '{@link de.mfreund.pamtram.transformation.TransformationMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see de.mfreund.pamtram.transformation.TransformationMapping
	 * @generated
	 */
	EClass getTransformationMapping();

	/**
	 * Returns the meta object for the reference '{@link de.mfreund.pamtram.transformation.TransformationMapping#getSourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Element</em>'.
	 * @see de.mfreund.pamtram.transformation.TransformationMapping#getSourceElement()
	 * @see #getTransformationMapping()
	 * @generated
	 */
	EReference getTransformationMapping_SourceElement();

	/**
	 * Returns the meta object for the reference '{@link de.mfreund.pamtram.transformation.TransformationMapping#getAssociatedMapping <em>Associated Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Mapping</em>'.
	 * @see de.mfreund.pamtram.transformation.TransformationMapping#getAssociatedMapping()
	 * @see #getTransformationMapping()
	 * @generated
	 */
	EReference getTransformationMapping_AssociatedMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link de.mfreund.pamtram.transformation.TransformationMapping#getTransformationHintGroups <em>Transformation Hint Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformation Hint Groups</em>'.
	 * @see de.mfreund.pamtram.transformation.TransformationMapping#getTransformationHintGroups()
	 * @see #getTransformationMapping()
	 * @generated
	 */
	EReference getTransformationMapping_TransformationHintGroups();

	/**
	 * Returns the meta object for class '{@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup <em>Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Hint Group</em>'.
	 * @see de.mfreund.pamtram.transformation.TransformationMappingHintGroup
	 * @generated
	 */
	EClass getTransformationMappingHintGroup();

	/**
	 * Returns the meta object for the reference list '{@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup#getTargetElements <em>Target Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Elements</em>'.
	 * @see de.mfreund.pamtram.transformation.TransformationMappingHintGroup#getTargetElements()
	 * @see #getTransformationMappingHintGroup()
	 * @generated
	 */
	EReference getTransformationMappingHintGroup_TargetElements();

	/**
	 * Returns the meta object for the reference '{@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup#getAssociatedMappingHintGroup <em>Associated Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Mapping Hint Group</em>'.
	 * @see de.mfreund.pamtram.transformation.TransformationMappingHintGroup#getAssociatedMappingHintGroup()
	 * @see #getTransformationMappingHintGroup()
	 * @generated
	 */
	EReference getTransformationMappingHintGroup_AssociatedMappingHintGroup();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TransformationFactory getTransformationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.mfreund.pamtram.transformation.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.mfreund.pamtram.transformation.impl.TransformationImpl
		 * @see de.mfreund.pamtram.transformation.impl.TransformationPackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__START_DATE = eINSTANCE.getTransformation_StartDate();

		/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__END_DATE = eINSTANCE.getTransformation_EndDate();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__NAME = eINSTANCE.getTransformation_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORMATION__ID = eINSTANCE.getTransformation_Id();

		/**
		 * The meta object literal for the '<em><b>Pamtram Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__PAMTRAM_INSTANCES = eINSTANCE.getTransformation_PamtramInstances();

		/**
		 * The meta object literal for the '<em><b>Library Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__LIBRARY_ENTRIES = eINSTANCE.getTransformation_LibraryEntries();

		/**
		 * The meta object literal for the '<em><b>Source Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__SOURCE_MODELS = eINSTANCE.getTransformation_SourceModels();

		/**
		 * The meta object literal for the '<em><b>Target Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__TARGET_MODELS = eINSTANCE.getTransformation_TargetModels();

		/**
		 * The meta object literal for the '<em><b>Transformation Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__TRANSFORMATION_MAPPINGS = eINSTANCE.getTransformation_TransformationMappings();

		/**
		 * The meta object literal for the '{@link de.mfreund.pamtram.transformation.impl.TransformationMappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.mfreund.pamtram.transformation.impl.TransformationMappingImpl
		 * @see de.mfreund.pamtram.transformation.impl.TransformationPackageImpl#getTransformationMapping()
		 * @generated
		 */
		EClass TRANSFORMATION_MAPPING = eINSTANCE.getTransformationMapping();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MAPPING__SOURCE_ELEMENT = eINSTANCE.getTransformationMapping_SourceElement();

		/**
		 * The meta object literal for the '<em><b>Associated Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING = eINSTANCE.getTransformationMapping_AssociatedMapping();

		/**
		 * The meta object literal for the '<em><b>Transformation Hint Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MAPPING__TRANSFORMATION_HINT_GROUPS = eINSTANCE.getTransformationMapping_TransformationHintGroups();

		/**
		 * The meta object literal for the '{@link de.mfreund.pamtram.transformation.impl.TransformationMappingHintGroupImpl <em>Mapping Hint Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.mfreund.pamtram.transformation.impl.TransformationMappingHintGroupImpl
		 * @see de.mfreund.pamtram.transformation.impl.TransformationPackageImpl#getTransformationMappingHintGroup()
		 * @generated
		 */
		EClass TRANSFORMATION_MAPPING_HINT_GROUP = eINSTANCE.getTransformationMappingHintGroup();

		/**
		 * The meta object literal for the '<em><b>Target Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS = eINSTANCE.getTransformationMappingHintGroup_TargetElements();

		/**
		 * The meta object literal for the '<em><b>Associated Mapping Hint Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP = eINSTANCE.getTransformationMappingHintGroup_AssociatedMappingHintGroup();

	}

} //TransformationPackage
