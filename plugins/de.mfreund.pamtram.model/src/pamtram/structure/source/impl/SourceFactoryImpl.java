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
package pamtram.structure.source.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.structure.source.VirtualSourceSectionCrossReference;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class SourceFactoryImpl extends EFactoryImpl implements SourceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static SourceFactory init() {
		try {
			SourceFactory theSourceFactory = (SourceFactory)EPackage.Registry.INSTANCE.getEFactory(SourcePackage.eNS_URI);
			if (theSourceFactory != null) {
				return theSourceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SourceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public SourceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SourcePackage.SOURCE_SECTION: return createSourceSection();
			case SourcePackage.SOURCE_SECTION_CLASS: return createSourceSectionClass();
			case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE: return createSourceSectionCompositeReference();
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE: return createSourceSectionCrossReference();
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE: return createVirtualSourceSectionCrossReference();
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE: return createActualSourceSectionAttribute();
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE: return createVirtualSourceSectionAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSection createSourceSection() {
		SourceSectionImpl sourceSection = new SourceSectionImpl();
		return sourceSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionClass createSourceSectionClass() {
		SourceSectionClassImpl sourceSectionClass = new SourceSectionClassImpl();
		return sourceSectionClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionCompositeReference createSourceSectionCompositeReference() {
		SourceSectionCompositeReferenceImpl sourceSectionCompositeReference = new SourceSectionCompositeReferenceImpl();
		return sourceSectionCompositeReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionCrossReference createSourceSectionCrossReference() {
		SourceSectionCrossReferenceImpl sourceSectionCrossReference = new SourceSectionCrossReferenceImpl();
		return sourceSectionCrossReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VirtualSourceSectionCrossReference createVirtualSourceSectionCrossReference() {
		VirtualSourceSectionCrossReferenceImpl virtualSourceSectionCrossReference = new VirtualSourceSectionCrossReferenceImpl();
		return virtualSourceSectionCrossReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActualSourceSectionAttribute createActualSourceSectionAttribute() {
		ActualSourceSectionAttributeImpl actualSourceSectionAttribute = new ActualSourceSectionAttributeImpl();
		return actualSourceSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VirtualSourceSectionAttribute createVirtualSourceSectionAttribute() {
		VirtualSourceSectionAttributeImpl virtualSourceSectionAttribute = new VirtualSourceSectionAttributeImpl();
		return virtualSourceSectionAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourcePackage getSourcePackage() {
		return (SourcePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SourcePackage getPackage() {
		return SourcePackage.eINSTANCE;
	}

} // SourceFactoryImpl
