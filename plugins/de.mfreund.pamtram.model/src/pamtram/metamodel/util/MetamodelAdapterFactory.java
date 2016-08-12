/**
 */
package pamtram.metamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import pamtram.NamedElement;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.ActualTargetSectionAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintExternalSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceElement;
import pamtram.metamodel.AttributeValueConstraintSourceInterface;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.FileAttribute;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerExternalSourceElement;
import pamtram.metamodel.InstancePointerSourceElement;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MultipleReferencesAttributeValueConstraint;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.Section;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.metamodel.VirtualAttribute;
import pamtram.metamodel.VirtualTargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.metamodel.MetamodelPackage
 * @generated
 */
public class MetamodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetamodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetamodelSwitch<Adapter> modelSwitch =
		new MetamodelSwitch<Adapter>() {
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseMetaModelElement(MetaModelElement<S, C, R, A> object) {
				return createMetaModelElementAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseClass(pamtram.metamodel.Class<S, C, R, A> object) {
				return createClassAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseSection(Section<S, C, R, A> object) {
				return createSectionAdapter();
			}
			@Override
			public Adapter caseSourceSection(SourceSection object) {
				return createSourceSectionAdapter();
			}
			@Override
			public Adapter caseTargetSection(TargetSection object) {
				return createTargetSectionAdapter();
			}
			@Override
			public Adapter caseFileAttribute(FileAttribute object) {
				return createFileAttributeAdapter();
			}
			@Override
			public Adapter caseSourceSectionClass(SourceSectionClass object) {
				return createSourceSectionClassAdapter();
			}
			@Override
			public Adapter caseTargetSectionClass(TargetSectionClass object) {
				return createTargetSectionClassAdapter();
			}
			@Override
			public <ParameterType> Adapter caseLibraryParameter(LibraryParameter<ParameterType> object) {
				return createLibraryParameterAdapter();
			}
			@Override
			public Adapter caseAttributeParameter(AttributeParameter object) {
				return createAttributeParameterAdapter();
			}
			@Override
			public Adapter caseContainerParameter(ContainerParameter object) {
				return createContainerParameterAdapter();
			}
			@Override
			public Adapter caseExternalReferenceParameter(ExternalReferenceParameter object) {
				return createExternalReferenceParameterAdapter();
			}
			@Override
			public Adapter caseLibraryEntry(LibraryEntry object) {
				return createLibraryEntryAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseReference(Reference<S, C, R, A> object) {
				return createReferenceAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseContainmentReference(ContainmentReference<S, C, R, A> object) {
				return createContainmentReferenceAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseNonContainmentReference(NonContainmentReference<S, C, R, A> object) {
				return createNonContainmentReferenceAdapter();
			}
			@Override
			public Adapter caseSourceSectionReference(SourceSectionReference object) {
				return createSourceSectionReferenceAdapter();
			}
			@Override
			public Adapter caseTargetSectionReference(TargetSectionReference object) {
				return createTargetSectionReferenceAdapter();
			}
			@Override
			public Adapter caseTargetSectionContainmentReference(TargetSectionContainmentReference object) {
				return createTargetSectionContainmentReferenceAdapter();
			}
			@Override
			public Adapter caseTargetSectionNonContainmentReference(TargetSectionNonContainmentReference object) {
				return createTargetSectionNonContainmentReferenceAdapter();
			}
			@Override
			public Adapter caseSourceSectionContainmentReference(SourceSectionContainmentReference object) {
				return createSourceSectionContainmentReferenceAdapter();
			}
			@Override
			public Adapter caseMetaModelSectionReference(MetaModelSectionReference object) {
				return createMetaModelSectionReferenceAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseAttribute(Attribute<S, C, R, A> object) {
				return createAttributeAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseActualAttribute(ActualAttribute<S, C, R, A> object) {
				return createActualAttributeAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseVirtualAttribute(VirtualAttribute<S, C, R, A> object) {
				return createVirtualAttributeAdapter();
			}
			@Override
			public Adapter caseSourceSectionAttribute(ActualSourceSectionAttribute object) {
				return createSourceSectionAttributeAdapter();
			}
			@Override
			public Adapter caseTargetSectionAttribute(TargetSectionAttribute object) {
				return createTargetSectionAttributeAdapter();
			}
			@Override
			public Adapter caseActualTargetSectionAttribute(ActualTargetSectionAttribute object) {
				return createActualTargetSectionAttributeAdapter();
			}
			@Override
			public Adapter caseVirtualTargetSectionAttribute(VirtualTargetSectionAttribute object) {
				return createVirtualTargetSectionAttributeAdapter();
			}
			@Override
			public Adapter caseEqualityMatcher(EqualityMatcher object) {
				return createEqualityMatcherAdapter();
			}
			@Override
			public Adapter caseAttributeValueConstraint(AttributeValueConstraint object) {
				return createAttributeValueConstraintAdapter();
			}
			@Override
			public Adapter caseSubstringMatcher(SubstringMatcher object) {
				return createSubstringMatcherAdapter();
			}
			@Override
			public Adapter caseBeginningMatcher(BeginningMatcher object) {
				return createBeginningMatcherAdapter();
			}
			@Override
			public Adapter caseEndingMatcher(EndingMatcher object) {
				return createEndingMatcherAdapter();
			}
			@Override
			public Adapter caseRegExMatcher(RegExMatcher object) {
				return createRegExMatcherAdapter();
			}
			@Override
			public Adapter caseCaseSensitiveConstraint(CaseSensitiveConstraint object) {
				return createCaseSensitiveConstraintAdapter();
			}
			@Override
			public Adapter caseRangeConstraint(RangeConstraint object) {
				return createRangeConstraintAdapter();
			}
			@Override
			public Adapter caseMultipleReferencesAttributeValueConstraint(MultipleReferencesAttributeValueConstraint object) {
				return createMultipleReferencesAttributeValueConstraintAdapter();
			}
			@Override
			public Adapter caseInstancePointer(InstancePointer object) {
				return createInstancePointerAdapter();
			}
			@Override
			public Adapter caseInstancePointerSourceInterface(InstancePointerSourceInterface object) {
				return createInstancePointerSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseInstancePointerSourceElement(InstancePointerSourceElement object) {
				return createInstancePointerSourceElementAdapter();
			}
			@Override
			public Adapter caseInstancePointerExternalSourceElement(InstancePointerExternalSourceElement object) {
				return createInstancePointerExternalSourceElementAdapter();
			}
			@Override
			public Adapter caseRangeBound(RangeBound object) {
				return createRangeBoundAdapter();
			}
			@Override
			public Adapter caseSingleReferenceAttributeValueConstraint(SingleReferenceAttributeValueConstraint object) {
				return createSingleReferenceAttributeValueConstraintAdapter();
			}
			@Override
			public Adapter caseAttributeValueConstraintSourceInterface(AttributeValueConstraintSourceInterface object) {
				return createAttributeValueConstraintSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseAttributeValueConstraintSourceElement(AttributeValueConstraintSourceElement object) {
				return createAttributeValueConstraintSourceElementAdapter();
			}
			@Override
			public Adapter caseAttributeValueConstraintExternalSourceElement(AttributeValueConstraintExternalSourceElement object) {
				return createAttributeValueConstraintExternalSourceElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseExpressionHint(ExpressionHint object) {
				return createExpressionHintAdapter();
			}
			@Override
			public Adapter caseModifiableHint(ModifiableHint object) {
				return createModifiableHintAdapter();
			}
			@Override
			public Adapter caseMappingHintSourceInterface(MappingHintSourceInterface object) {
				return createMappingHintSourceInterfaceAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseModifiedAttributeElementType(ModifiedAttributeElementType<S, C, R, A> object) {
				return createModifiedAttributeElementTypeAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<S, C, R, A> object) {
				return createLocalModifiedAttributeElementTypeAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<S, C, R, A> object) {
				return createExternalModifiedAttributeElementTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.MetaModelElement <em>Meta Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.MetaModelElement
	 * @generated
	 */
	public Adapter createMetaModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.Section
	 * @generated
	 */
	public Adapter createSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SourceSection <em>Source Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SourceSection
	 * @generated
	 */
	public Adapter createSourceSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.TargetSection <em>Target Section</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.TargetSection
	 * @generated
	 */
	public Adapter createTargetSectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.FileAttribute <em>File Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.FileAttribute
	 * @generated
	 */
	public Adapter createFileAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SourceSectionClass <em>Source Section Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SourceSectionClass
	 * @generated
	 */
	public Adapter createSourceSectionClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.TargetSectionClass <em>Target Section Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.TargetSectionClass
	 * @generated
	 */
	public Adapter createTargetSectionClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.LibraryParameter <em>Library Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.LibraryParameter
	 * @generated
	 */
	public Adapter createLibraryParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.AttributeParameter <em>Attribute Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.AttributeParameter
	 * @generated
	 */
	public Adapter createAttributeParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.ContainerParameter <em>Container Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.ContainerParameter
	 * @generated
	 */
	public Adapter createContainerParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.ExternalReferenceParameter <em>External Reference Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.ExternalReferenceParameter
	 * @generated
	 */
	public Adapter createExternalReferenceParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.LibraryEntry <em>Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.LibraryEntry
	 * @generated
	 */
	public Adapter createLibraryEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.ContainmentReference <em>Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.ContainmentReference
	 * @generated
	 */
	public Adapter createContainmentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.NonContainmentReference <em>Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.NonContainmentReference
	 * @generated
	 */
	public Adapter createNonContainmentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SourceSectionReference <em>Source Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SourceSectionReference
	 * @generated
	 */
	public Adapter createSourceSectionReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.TargetSectionReference <em>Target Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.TargetSectionReference
	 * @generated
	 */
	public Adapter createTargetSectionReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.TargetSectionContainmentReference <em>Target Section Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.TargetSectionContainmentReference
	 * @generated
	 */
	public Adapter createTargetSectionContainmentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.TargetSectionNonContainmentReference <em>Target Section Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.TargetSectionNonContainmentReference
	 * @generated
	 */
	public Adapter createTargetSectionNonContainmentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SourceSectionContainmentReference <em>Source Section Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SourceSectionContainmentReference
	 * @generated
	 */
	public Adapter createSourceSectionContainmentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.MetaModelSectionReference <em>Meta Model Section Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.MetaModelSectionReference
	 * @generated
	 */
	public Adapter createMetaModelSectionReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.ActualAttribute <em>Actual Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.ActualAttribute
	 * @generated
	 */
	public Adapter createActualAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.VirtualAttribute <em>Virtual Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.VirtualAttribute
	 * @generated
	 */
	public Adapter createVirtualAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.ActualSourceSectionAttribute <em>Source Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.ActualSourceSectionAttribute
	 * @generated
	 */
	public Adapter createSourceSectionAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.TargetSectionAttribute <em>Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.TargetSectionAttribute
	 * @generated
	 */
	public Adapter createTargetSectionAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.ActualTargetSectionAttribute <em>Actual Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.ActualTargetSectionAttribute
	 * @generated
	 */
	public Adapter createActualTargetSectionAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.VirtualTargetSectionAttribute <em>Virtual Target Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.VirtualTargetSectionAttribute
	 * @generated
	 */
	public Adapter createVirtualTargetSectionAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.EqualityMatcher <em>Equality Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.EqualityMatcher
	 * @generated
	 */
	public Adapter createEqualityMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.AttributeValueConstraint <em>Attribute Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.AttributeValueConstraint
	 * @generated
	 */
	public Adapter createAttributeValueConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SubstringMatcher <em>Substring Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SubstringMatcher
	 * @generated
	 */
	public Adapter createSubstringMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.BeginningMatcher <em>Beginning Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.BeginningMatcher
	 * @generated
	 */
	public Adapter createBeginningMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.EndingMatcher <em>Ending Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.EndingMatcher
	 * @generated
	 */
	public Adapter createEndingMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.RegExMatcher <em>Reg Ex Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.RegExMatcher
	 * @generated
	 */
	public Adapter createRegExMatcherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.CaseSensitiveConstraint <em>Case Sensitive Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.CaseSensitiveConstraint
	 * @generated
	 */
	public Adapter createCaseSensitiveConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.RangeConstraint <em>Range Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.RangeConstraint
	 * @generated
	 */
	public Adapter createRangeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SingleReferenceAttributeValueConstraint <em>Single Reference Attribute Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SingleReferenceAttributeValueConstraint
	 * @generated
	 */
	public Adapter createSingleReferenceAttributeValueConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.AttributeValueConstraintSourceInterface <em>Attribute Value Constraint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.AttributeValueConstraintSourceInterface
	 * @generated
	 */
	public Adapter createAttributeValueConstraintSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.AttributeValueConstraintSourceElement <em>Attribute Value Constraint Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.AttributeValueConstraintSourceElement
	 * @generated
	 */
	public Adapter createAttributeValueConstraintSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.AttributeValueConstraintExternalSourceElement <em>Attribute Value Constraint External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.AttributeValueConstraintExternalSourceElement
	 * @generated
	 */
	public Adapter createAttributeValueConstraintExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.MultipleReferencesAttributeValueConstraint <em>Multiple References Attribute Value Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.MultipleReferencesAttributeValueConstraint
	 * @generated
	 */
	public Adapter createMultipleReferencesAttributeValueConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.InstancePointer <em>Instance Pointer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.InstancePointer
	 * @generated
	 */
	public Adapter createInstancePointerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.InstancePointerSourceInterface <em>Instance Pointer Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.InstancePointerSourceInterface
	 * @generated
	 */
	public Adapter createInstancePointerSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.InstancePointerSourceElement <em>Instance Pointer Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.InstancePointerSourceElement
	 * @generated
	 */
	public Adapter createInstancePointerSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.InstancePointerExternalSourceElement <em>Instance Pointer External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.InstancePointerExternalSourceElement
	 * @generated
	 */
	public Adapter createInstancePointerExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.RangeBound <em>Range Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.RangeBound
	 * @generated
	 */
	public Adapter createRangeBoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExpressionHint <em>Expression Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExpressionHint
	 * @generated
	 */
	public Adapter createExpressionHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModifiableHint <em>Modifiable Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModifiableHint
	 * @generated
	 */
	public Adapter createModifiableHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintSourceInterface <em>Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintSourceInterface
	 * @generated
	 */
	public Adapter createMappingHintSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ModifiedAttributeElementType <em>Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.LocalModifiedAttributeElementType <em>Local Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.LocalModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createLocalModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalModifiedAttributeElementType <em>External Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createExternalModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MetamodelAdapterFactory
