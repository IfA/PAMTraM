/**
 */
package pamtram.metamodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import pamtram.NamedElement;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see pamtram.metamodel.MetamodelPackage
 * @generated
 */
public class MetamodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = MetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MetamodelPackage.META_MODEL_ELEMENT: {
				MetaModelElement<?> metaModelElement = (MetaModelElement<?>)theEObject;
				T result = caseMetaModelElement(metaModelElement);
				if (result == null) result = caseNamedElement(metaModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CLASS: {
				pamtram.metamodel.Class<?, ?, ?> class_ = (pamtram.metamodel.Class<?, ?, ?>)theEObject;
				T result = caseClass(class_);
				if (result == null) result = caseMetaModelElement(class_);
				if (result == null) result = caseNamedElement(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SOURCE_SECTION_CLASS: {
				SourceSectionClass sourceSectionClass = (SourceSectionClass)theEObject;
				T result = caseSourceSectionClass(sourceSectionClass);
				if (result == null) result = caseClass(sourceSectionClass);
				if (result == null) result = caseMetaModelElement(sourceSectionClass);
				if (result == null) result = caseNamedElement(sourceSectionClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.TARGET_SECTION_CLASS: {
				TargetSectionClass targetSectionClass = (TargetSectionClass)theEObject;
				T result = caseTargetSectionClass(targetSectionClass);
				if (result == null) result = caseClass(targetSectionClass);
				if (result == null) result = caseMetaModelElement(targetSectionClass);
				if (result == null) result = caseNamedElement(targetSectionClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.LIBRARY_PARAMETER: {
				LibraryParameter<?> libraryParameter = (LibraryParameter<?>)theEObject;
				T result = caseLibraryParameter(libraryParameter);
				if (result == null) result = caseNamedElement(libraryParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE_PARAMETER: {
				AttributeParameter attributeParameter = (AttributeParameter)theEObject;
				T result = caseAttributeParameter(attributeParameter);
				if (result == null) result = caseLibraryParameter(attributeParameter);
				if (result == null) result = caseNamedElement(attributeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CONTAINER_PARAMETER: {
				ContainerParameter containerParameter = (ContainerParameter)theEObject;
				T result = caseContainerParameter(containerParameter);
				if (result == null) result = caseLibraryParameter(containerParameter);
				if (result == null) result = caseNamedElement(containerParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.EXTERNAL_REFERENCE_PARAMETER: {
				ExternalReferenceParameter externalReferenceParameter = (ExternalReferenceParameter)theEObject;
				T result = caseExternalReferenceParameter(externalReferenceParameter);
				if (result == null) result = caseLibraryParameter(externalReferenceParameter);
				if (result == null) result = caseNamedElement(externalReferenceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.LIBRARY_ENTRY: {
				LibraryEntry libraryEntry = (LibraryEntry)theEObject;
				T result = caseLibraryEntry(libraryEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.REFERENCE: {
				Reference<?> reference = (Reference<?>)theEObject;
				T result = caseReference(reference);
				if (result == null) result = caseMetaModelElement(reference);
				if (result == null) result = caseNamedElement(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CONTAINMENT_REFERENCE: {
				ContainmentReference<?> containmentReference = (ContainmentReference<?>)theEObject;
				T result = caseContainmentReference(containmentReference);
				if (result == null) result = caseReference(containmentReference);
				if (result == null) result = caseMetaModelElement(containmentReference);
				if (result == null) result = caseNamedElement(containmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE: {
				NonContainmentReference<?> nonContainmentReference = (NonContainmentReference<?>)theEObject;
				T result = caseNonContainmentReference(nonContainmentReference);
				if (result == null) result = caseReference(nonContainmentReference);
				if (result == null) result = caseMetaModelElement(nonContainmentReference);
				if (result == null) result = caseNamedElement(nonContainmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SOURCE_SECTION_REFERENCE: {
				SourceSectionReference sourceSectionReference = (SourceSectionReference)theEObject;
				T result = caseSourceSectionReference(sourceSectionReference);
				if (result == null) result = caseReference(sourceSectionReference);
				if (result == null) result = caseMetaModelElement(sourceSectionReference);
				if (result == null) result = caseNamedElement(sourceSectionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.TARGET_SECTION_REFERENCE: {
				TargetSectionReference targetSectionReference = (TargetSectionReference)theEObject;
				T result = caseTargetSectionReference(targetSectionReference);
				if (result == null) result = caseReference(targetSectionReference);
				if (result == null) result = caseMetaModelElement(targetSectionReference);
				if (result == null) result = caseNamedElement(targetSectionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.TARGET_SECTION_CONTAINMENT_REFERENCE: {
				TargetSectionContainmentReference targetSectionContainmentReference = (TargetSectionContainmentReference)theEObject;
				T result = caseTargetSectionContainmentReference(targetSectionContainmentReference);
				if (result == null) result = caseContainmentReference(targetSectionContainmentReference);
				if (result == null) result = caseTargetSectionReference(targetSectionContainmentReference);
				if (result == null) result = caseReference(targetSectionContainmentReference);
				if (result == null) result = caseMetaModelElement(targetSectionContainmentReference);
				if (result == null) result = caseNamedElement(targetSectionContainmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.TARGET_SECTION_NON_CONTAINMENT_REFERENCE: {
				TargetSectionNonContainmentReference targetSectionNonContainmentReference = (TargetSectionNonContainmentReference)theEObject;
				T result = caseTargetSectionNonContainmentReference(targetSectionNonContainmentReference);
				if (result == null) result = caseNonContainmentReference(targetSectionNonContainmentReference);
				if (result == null) result = caseTargetSectionReference(targetSectionNonContainmentReference);
				if (result == null) result = caseReference(targetSectionNonContainmentReference);
				if (result == null) result = caseMetaModelElement(targetSectionNonContainmentReference);
				if (result == null) result = caseNamedElement(targetSectionNonContainmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE: {
				SourceSectionContainmentReference sourceSectionContainmentReference = (SourceSectionContainmentReference)theEObject;
				T result = caseSourceSectionContainmentReference(sourceSectionContainmentReference);
				if (result == null) result = caseContainmentReference(sourceSectionContainmentReference);
				if (result == null) result = caseSourceSectionReference(sourceSectionContainmentReference);
				if (result == null) result = caseReference(sourceSectionContainmentReference);
				if (result == null) result = caseMetaModelElement(sourceSectionContainmentReference);
				if (result == null) result = caseNamedElement(sourceSectionContainmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE: {
				MetaModelSectionReference metaModelSectionReference = (MetaModelSectionReference)theEObject;
				T result = caseMetaModelSectionReference(metaModelSectionReference);
				if (result == null) result = caseSourceSectionReference(metaModelSectionReference);
				if (result == null) result = caseReference(metaModelSectionReference);
				if (result == null) result = caseMetaModelElement(metaModelSectionReference);
				if (result == null) result = caseNamedElement(metaModelSectionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE: {
				Attribute<?> attribute = (Attribute<?>)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseMetaModelElement(attribute);
				if (result == null) result = caseNamedElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE: {
				SourceSectionAttribute sourceSectionAttribute = (SourceSectionAttribute)theEObject;
				T result = caseSourceSectionAttribute(sourceSectionAttribute);
				if (result == null) result = caseAttribute(sourceSectionAttribute);
				if (result == null) result = caseMetaModelElement(sourceSectionAttribute);
				if (result == null) result = caseNamedElement(sourceSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.TARGET_SECTION_ATTRIBUTE: {
				TargetSectionAttribute targetSectionAttribute = (TargetSectionAttribute)theEObject;
				T result = caseTargetSectionAttribute(targetSectionAttribute);
				if (result == null) result = caseAttribute(targetSectionAttribute);
				if (result == null) result = caseMetaModelElement(targetSectionAttribute);
				if (result == null) result = caseNamedElement(targetSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ACTUAL_ATTRIBUTE: {
				ActualAttribute actualAttribute = (ActualAttribute)theEObject;
				T result = caseActualAttribute(actualAttribute);
				if (result == null) result = caseTargetSectionAttribute(actualAttribute);
				if (result == null) result = caseAttribute(actualAttribute);
				if (result == null) result = caseMetaModelElement(actualAttribute);
				if (result == null) result = caseNamedElement(actualAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.VIRTUAL_ATTRIBUTE: {
				VirtualAttribute virtualAttribute = (VirtualAttribute)theEObject;
				T result = caseVirtualAttribute(virtualAttribute);
				if (result == null) result = caseTargetSectionAttribute(virtualAttribute);
				if (result == null) result = caseAttribute(virtualAttribute);
				if (result == null) result = caseMetaModelElement(virtualAttribute);
				if (result == null) result = caseNamedElement(virtualAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.EQUALITY_MATCHER: {
				EqualityMatcher equalityMatcher = (EqualityMatcher)theEObject;
				T result = caseEqualityMatcher(equalityMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(equalityMatcher);
				if (result == null) result = caseAttributeValueConstraint(equalityMatcher);
				if (result == null) result = caseNamedElement(equalityMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT: {
				AttributeValueConstraint attributeValueConstraint = (AttributeValueConstraint)theEObject;
				T result = caseAttributeValueConstraint(attributeValueConstraint);
				if (result == null) result = caseNamedElement(attributeValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SUBSTRING_MATCHER: {
				SubstringMatcher substringMatcher = (SubstringMatcher)theEObject;
				T result = caseSubstringMatcher(substringMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(substringMatcher);
				if (result == null) result = caseAttributeValueConstraint(substringMatcher);
				if (result == null) result = caseNamedElement(substringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.BEGINNING_MATCHER: {
				BeginningMatcher beginningMatcher = (BeginningMatcher)theEObject;
				T result = caseBeginningMatcher(beginningMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(beginningMatcher);
				if (result == null) result = caseAttributeValueConstraint(beginningMatcher);
				if (result == null) result = caseNamedElement(beginningMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ENDING_MATCHER: {
				EndingMatcher endingMatcher = (EndingMatcher)theEObject;
				T result = caseEndingMatcher(endingMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(endingMatcher);
				if (result == null) result = caseAttributeValueConstraint(endingMatcher);
				if (result == null) result = caseNamedElement(endingMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.REG_EX_MATCHER: {
				RegExMatcher regExMatcher = (RegExMatcher)theEObject;
				T result = caseRegExMatcher(regExMatcher);
				if (result == null) result = caseAttributeValueConstraint(regExMatcher);
				if (result == null) result = caseNamedElement(regExMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CASE_SENSITIVE_CONSTRAINT: {
				CaseSensitiveConstraint caseSensitiveConstraint = (CaseSensitiveConstraint)theEObject;
				T result = caseCaseSensitiveConstraint(caseSensitiveConstraint);
				if (result == null) result = caseAttributeValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseNamedElement(caseSensitiveConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends pamtram.metamodel.Class<?, ?, ?>> T caseMetaModelElement(MetaModelElement<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C>, A extends Attribute<C>> T caseClass(pamtram.metamodel.Class<C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Section Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Section Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceSectionClass(SourceSectionClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Section Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionClass(TargetSectionClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <ParameterType> T caseLibraryParameter(LibraryParameter<ParameterType> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeParameter(AttributeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerParameter(ContainerParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Reference Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Reference Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalReferenceParameter(ExternalReferenceParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryEntry(LibraryEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <V extends pamtram.metamodel.Class<?, ?, ?>> T caseReference(Reference<V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <V extends pamtram.metamodel.Class<?, ?, ?>> T caseContainmentReference(ContainmentReference<V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Containment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <V extends pamtram.metamodel.Class<?, ?, ?>> T caseNonContainmentReference(NonContainmentReference<V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Section Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceSectionReference(SourceSectionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionReference(TargetSectionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Section Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section Containment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionContainmentReference(TargetSectionContainmentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Section Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section Non Containment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionNonContainmentReference(TargetSectionNonContainmentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Section Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Section Containment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceSectionContainmentReference(SourceSectionContainmentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Model Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Model Section Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaModelSectionReference(MetaModelSectionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends pamtram.metamodel.Class<?, ?, ?>> T caseAttribute(Attribute<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Section Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceSectionAttribute(SourceSectionAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionAttribute(TargetSectionAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actual Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actual Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActualAttribute(ActualAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualAttribute(VirtualAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualityMatcher(EqualityMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueConstraint(AttributeValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substring Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstringMatcher(SubstringMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Beginning Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Beginning Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeginningMatcher(BeginningMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ending Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ending Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndingMatcher(EndingMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reg Ex Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reg Ex Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegExMatcher(RegExMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Sensitive Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Sensitive Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseSensitiveConstraint(CaseSensitiveConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MetamodelSwitch
