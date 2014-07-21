/**
 */
package pamtram.metamodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import pamtram.NamedElement;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionNonContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.metamodel.VirtualAttribute;

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
			public Adapter caseMetaModelElement(MetaModelElement object) {
				return createMetaModelElementAdapter();
			}
			@Override
			public Adapter caseClass(pamtram.metamodel.Class object) {
				return createClassAdapter();
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
			public Adapter caseReference(Reference object) {
				return createReferenceAdapter();
			}
			@Override
			public Adapter caseContainmentReference(ContainmentReference object) {
				return createContainmentReferenceAdapter();
			}
			@Override
			public Adapter caseNonContainmentReference(NonContainmentReference object) {
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
			public Adapter caseSourceSectionNonContainmentReference(SourceSectionNonContainmentReference object) {
				return createSourceSectionNonContainmentReferenceAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseSourceSectionAttribute(SourceSectionAttribute object) {
				return createSourceSectionAttributeAdapter();
			}
			@Override
			public Adapter caseTargetSectionAttribute(TargetSectionAttribute object) {
				return createTargetSectionAttributeAdapter();
			}
			@Override
			public Adapter caseActualAttribute(ActualAttribute object) {
				return createActualAttributeAdapter();
			}
			@Override
			public Adapter caseVirtualAttribute(VirtualAttribute object) {
				return createVirtualAttributeAdapter();
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
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SourceSectionNonContainmentReference <em>Source Section Non Containment Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SourceSectionNonContainmentReference
	 * @generated
	 */
	public Adapter createSourceSectionNonContainmentReferenceAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.metamodel.SourceSectionAttribute <em>Source Section Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.metamodel.SourceSectionAttribute
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
