/**
 */
package pamtram.structure.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import pamtram.NamedElement;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.structure.*;
import pamtram.structure.constraint.BeginningMatcher;
import pamtram.structure.constraint.CaseSensitiveConstraint;
import pamtram.structure.constraint.EndingMatcher;
import pamtram.structure.constraint.EqualityMatcher;
import pamtram.structure.constraint.MultipleReferencesValueConstraint;
import pamtram.structure.constraint.RangeBound;
import pamtram.structure.constraint.RangeConstraint;
import pamtram.structure.constraint.RegExMatcher;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.SubstringMatcher;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceInterface;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;

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
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public class StructureSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StructurePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureSwitch() {
		if (modelPackage == null) {
			modelPackage = StructurePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case StructurePackage.SOURCE_SECTION: {
				SourceSection sourceSection = (SourceSection)theEObject;
				T result = caseSourceSection(sourceSection);
				if (result == null) result = caseSourceSectionClass(sourceSection);
				if (result == null) result = caseSection(sourceSection);
				if (result == null) result = caseClass(sourceSection);
				if (result == null) result = caseMetaModelElement(sourceSection);
				if (result == null) result = caseNamedElement(sourceSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.TARGET_SECTION: {
				TargetSection targetSection = (TargetSection)theEObject;
				T result = caseTargetSection(targetSection);
				if (result == null) result = caseTargetSectionClass(targetSection);
				if (result == null) result = caseSection(targetSection);
				if (result == null) result = caseClass(targetSection);
				if (result == null) result = caseMetaModelElement(targetSection);
				if (result == null) result = caseNamedElement(targetSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.FILE_ATTRIBUTE: {
				FileAttribute fileAttribute = (FileAttribute)theEObject;
				T result = caseFileAttribute(fileAttribute);
				if (result == null) result = caseVirtualTargetSectionAttribute(fileAttribute);
				if (result == null) result = caseTargetSectionAttribute(fileAttribute);
				if (result == null) result = caseVirtualAttribute(fileAttribute);
				if (result == null) result = caseAttribute(fileAttribute);
				if (result == null) result = caseMetaModelElement(fileAttribute);
				if (result == null) result = caseNamedElement(fileAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SOURCE_SECTION_CLASS: {
				SourceSectionClass sourceSectionClass = (SourceSectionClass)theEObject;
				T result = caseSourceSectionClass(sourceSectionClass);
				if (result == null) result = caseClass(sourceSectionClass);
				if (result == null) result = caseMetaModelElement(sourceSectionClass);
				if (result == null) result = caseNamedElement(sourceSectionClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.TARGET_SECTION_CLASS: {
				TargetSectionClass targetSectionClass = (TargetSectionClass)theEObject;
				T result = caseTargetSectionClass(targetSectionClass);
				if (result == null) result = caseClass(targetSectionClass);
				if (result == null) result = caseMetaModelElement(targetSectionClass);
				if (result == null) result = caseNamedElement(targetSectionClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.LIBRARY_PARAMETER: {
				LibraryParameter<?> libraryParameter = (LibraryParameter<?>)theEObject;
				T result = caseLibraryParameter(libraryParameter);
				if (result == null) result = caseNamedElement(libraryParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.ATTRIBUTE_PARAMETER: {
				AttributeParameter attributeParameter = (AttributeParameter)theEObject;
				T result = caseAttributeParameter(attributeParameter);
				if (result == null) result = caseLibraryParameter(attributeParameter);
				if (result == null) result = caseNamedElement(attributeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.CONTAINER_PARAMETER: {
				ContainerParameter containerParameter = (ContainerParameter)theEObject;
				T result = caseContainerParameter(containerParameter);
				if (result == null) result = caseLibraryParameter(containerParameter);
				if (result == null) result = caseNamedElement(containerParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER: {
				ExternalReferenceParameter externalReferenceParameter = (ExternalReferenceParameter)theEObject;
				T result = caseExternalReferenceParameter(externalReferenceParameter);
				if (result == null) result = caseLibraryParameter(externalReferenceParameter);
				if (result == null) result = caseNamedElement(externalReferenceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.RESOURCE_PARAMETER: {
				ResourceParameter resourceParameter = (ResourceParameter)theEObject;
				T result = caseResourceParameter(resourceParameter);
				if (result == null) result = caseNamedElement(resourceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.LIBRARY_ENTRY: {
				LibraryEntry libraryEntry = (LibraryEntry)theEObject;
				T result = caseLibraryEntry(libraryEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SOURCE_SECTION_REFERENCE: {
				SourceSectionReference sourceSectionReference = (SourceSectionReference)theEObject;
				T result = caseSourceSectionReference(sourceSectionReference);
				if (result == null) result = caseReference(sourceSectionReference);
				if (result == null) result = caseMetaModelElement(sourceSectionReference);
				if (result == null) result = caseNamedElement(sourceSectionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.TARGET_SECTION_REFERENCE: {
				TargetSectionReference targetSectionReference = (TargetSectionReference)theEObject;
				T result = caseTargetSectionReference(targetSectionReference);
				if (result == null) result = caseReference(targetSectionReference);
				if (result == null) result = caseMetaModelElement(targetSectionReference);
				if (result == null) result = caseNamedElement(targetSectionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.TARGET_SECTION_COMPOSITE_REFERENCE: {
				TargetSectionCompositeReference targetSectionCompositeReference = (TargetSectionCompositeReference)theEObject;
				T result = caseTargetSectionCompositeReference(targetSectionCompositeReference);
				if (result == null) result = caseCompositeReference(targetSectionCompositeReference);
				if (result == null) result = caseTargetSectionReference(targetSectionCompositeReference);
				if (result == null) result = caseReference(targetSectionCompositeReference);
				if (result == null) result = caseMetaModelElement(targetSectionCompositeReference);
				if (result == null) result = caseNamedElement(targetSectionCompositeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.TARGET_SECTION_CROSS_REFERENCE: {
				TargetSectionCrossReference targetSectionCrossReference = (TargetSectionCrossReference)theEObject;
				T result = caseTargetSectionCrossReference(targetSectionCrossReference);
				if (result == null) result = caseCrossReference(targetSectionCrossReference);
				if (result == null) result = caseTargetSectionReference(targetSectionCrossReference);
				if (result == null) result = caseReference(targetSectionCrossReference);
				if (result == null) result = caseMetaModelElement(targetSectionCrossReference);
				if (result == null) result = caseNamedElement(targetSectionCrossReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SOURCE_SECTION_COMPOSITE_REFERENCE: {
				SourceSectionCompositeReference sourceSectionCompositeReference = (SourceSectionCompositeReference)theEObject;
				T result = caseSourceSectionCompositeReference(sourceSectionCompositeReference);
				if (result == null) result = caseCompositeReference(sourceSectionCompositeReference);
				if (result == null) result = caseSourceSectionReference(sourceSectionCompositeReference);
				if (result == null) result = caseReference(sourceSectionCompositeReference);
				if (result == null) result = caseMetaModelElement(sourceSectionCompositeReference);
				if (result == null) result = caseNamedElement(sourceSectionCompositeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SOURCE_SECTION_CROSS_REFERENCE: {
				SourceSectionCrossReference sourceSectionCrossReference = (SourceSectionCrossReference)theEObject;
				T result = caseSourceSectionCrossReference(sourceSectionCrossReference);
				if (result == null) result = caseCrossReference(sourceSectionCrossReference);
				if (result == null) result = caseSourceSectionReference(sourceSectionCrossReference);
				if (result == null) result = caseReference(sourceSectionCrossReference);
				if (result == null) result = caseMetaModelElement(sourceSectionCrossReference);
				if (result == null) result = caseNamedElement(sourceSectionCrossReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SOURCE_SECTION_ATTRIBUTE: {
				SourceSectionAttribute sourceSectionAttribute = (SourceSectionAttribute)theEObject;
				T result = caseSourceSectionAttribute(sourceSectionAttribute);
				if (result == null) result = caseAttribute(sourceSectionAttribute);
				if (result == null) result = caseMetaModelElement(sourceSectionAttribute);
				if (result == null) result = caseNamedElement(sourceSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE: {
				ActualSourceSectionAttribute actualSourceSectionAttribute = (ActualSourceSectionAttribute)theEObject;
				T result = caseActualSourceSectionAttribute(actualSourceSectionAttribute);
				if (result == null) result = caseSourceSectionAttribute(actualSourceSectionAttribute);
				if (result == null) result = caseActualAttribute(actualSourceSectionAttribute);
				if (result == null) result = caseAttribute(actualSourceSectionAttribute);
				if (result == null) result = caseMetaModelElement(actualSourceSectionAttribute);
				if (result == null) result = caseNamedElement(actualSourceSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.TARGET_SECTION_ATTRIBUTE: {
				TargetSectionAttribute targetSectionAttribute = (TargetSectionAttribute)theEObject;
				T result = caseTargetSectionAttribute(targetSectionAttribute);
				if (result == null) result = caseAttribute(targetSectionAttribute);
				if (result == null) result = caseMetaModelElement(targetSectionAttribute);
				if (result == null) result = caseNamedElement(targetSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.ACTUAL_TARGET_SECTION_ATTRIBUTE: {
				ActualTargetSectionAttribute actualTargetSectionAttribute = (ActualTargetSectionAttribute)theEObject;
				T result = caseActualTargetSectionAttribute(actualTargetSectionAttribute);
				if (result == null) result = caseTargetSectionAttribute(actualTargetSectionAttribute);
				if (result == null) result = caseActualAttribute(actualTargetSectionAttribute);
				if (result == null) result = caseAttribute(actualTargetSectionAttribute);
				if (result == null) result = caseMetaModelElement(actualTargetSectionAttribute);
				if (result == null) result = caseNamedElement(actualTargetSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE: {
				VirtualTargetSectionAttribute virtualTargetSectionAttribute = (VirtualTargetSectionAttribute)theEObject;
				T result = caseVirtualTargetSectionAttribute(virtualTargetSectionAttribute);
				if (result == null) result = caseTargetSectionAttribute(virtualTargetSectionAttribute);
				if (result == null) result = caseVirtualAttribute(virtualTargetSectionAttribute);
				if (result == null) result = caseAttribute(virtualTargetSectionAttribute);
				if (result == null) result = caseMetaModelElement(virtualTargetSectionAttribute);
				if (result == null) result = caseNamedElement(virtualTargetSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.EQUALITY_MATCHER: {
				EqualityMatcher equalityMatcher = (EqualityMatcher)theEObject;
				T result = caseEqualityMatcher(equalityMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(equalityMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(equalityMatcher);
				if (result == null) result = caseValueConstraint(equalityMatcher);
				if (result == null) result = caseExpressionHint(equalityMatcher);
				if (result == null) result = caseModifiableHint(equalityMatcher);
				if (result == null) result = caseNamedElement(equalityMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.VALUE_CONSTRAINT: {
				ValueConstraint valueConstraint = (ValueConstraint)theEObject;
				T result = caseValueConstraint(valueConstraint);
				if (result == null) result = caseNamedElement(valueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SUBSTRING_MATCHER: {
				SubstringMatcher substringMatcher = (SubstringMatcher)theEObject;
				T result = caseSubstringMatcher(substringMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(substringMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(substringMatcher);
				if (result == null) result = caseValueConstraint(substringMatcher);
				if (result == null) result = caseExpressionHint(substringMatcher);
				if (result == null) result = caseModifiableHint(substringMatcher);
				if (result == null) result = caseNamedElement(substringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.BEGINNING_MATCHER: {
				BeginningMatcher beginningMatcher = (BeginningMatcher)theEObject;
				T result = caseBeginningMatcher(beginningMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(beginningMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(beginningMatcher);
				if (result == null) result = caseValueConstraint(beginningMatcher);
				if (result == null) result = caseExpressionHint(beginningMatcher);
				if (result == null) result = caseModifiableHint(beginningMatcher);
				if (result == null) result = caseNamedElement(beginningMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.ENDING_MATCHER: {
				EndingMatcher endingMatcher = (EndingMatcher)theEObject;
				T result = caseEndingMatcher(endingMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(endingMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(endingMatcher);
				if (result == null) result = caseValueConstraint(endingMatcher);
				if (result == null) result = caseExpressionHint(endingMatcher);
				if (result == null) result = caseModifiableHint(endingMatcher);
				if (result == null) result = caseNamedElement(endingMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.REG_EX_MATCHER: {
				RegExMatcher regExMatcher = (RegExMatcher)theEObject;
				T result = caseRegExMatcher(regExMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(regExMatcher);
				if (result == null) result = caseValueConstraint(regExMatcher);
				if (result == null) result = caseExpressionHint(regExMatcher);
				if (result == null) result = caseModifiableHint(regExMatcher);
				if (result == null) result = caseNamedElement(regExMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.CASE_SENSITIVE_CONSTRAINT: {
				CaseSensitiveConstraint caseSensitiveConstraint = (CaseSensitiveConstraint)theEObject;
				T result = caseCaseSensitiveConstraint(caseSensitiveConstraint);
				if (result == null) result = caseSingleReferenceValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseExpressionHint(caseSensitiveConstraint);
				if (result == null) result = caseModifiableHint(caseSensitiveConstraint);
				if (result == null) result = caseNamedElement(caseSensitiveConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.RANGE_CONSTRAINT: {
				RangeConstraint rangeConstraint = (RangeConstraint)theEObject;
				T result = caseRangeConstraint(rangeConstraint);
				if (result == null) result = caseMultipleReferencesValueConstraint(rangeConstraint);
				if (result == null) result = caseValueConstraint(rangeConstraint);
				if (result == null) result = caseNamedElement(rangeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT: {
				MultipleReferencesValueConstraint multipleReferencesValueConstraint = (MultipleReferencesValueConstraint)theEObject;
				T result = caseMultipleReferencesValueConstraint(multipleReferencesValueConstraint);
				if (result == null) result = caseValueConstraint(multipleReferencesValueConstraint);
				if (result == null) result = caseNamedElement(multipleReferencesValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER: {
				InstancePointer instancePointer = (InstancePointer)theEObject;
				T result = caseInstancePointer(instancePointer);
				if (result == null) result = caseExpressionHint(instancePointer);
				if (result == null) result = caseModifiableHint(instancePointer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER_SOURCE_INTERFACE: {
				InstancePointerSourceInterface instancePointerSourceInterface = (InstancePointerSourceInterface)theEObject;
				T result = caseInstancePointerSourceInterface(instancePointerSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(instancePointerSourceInterface);
				if (result == null) result = caseNamedElement(instancePointerSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER_SOURCE_ELEMENT: {
				InstancePointerSourceElement instancePointerSourceElement = (InstancePointerSourceElement)theEObject;
				T result = caseInstancePointerSourceElement(instancePointerSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(instancePointerSourceElement);
				if (result == null) result = caseInstancePointerSourceInterface(instancePointerSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(instancePointerSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(instancePointerSourceElement);
				if (result == null) result = caseNamedElement(instancePointerSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT: {
				InstancePointerExternalSourceElement instancePointerExternalSourceElement = (InstancePointerExternalSourceElement)theEObject;
				T result = caseInstancePointerExternalSourceElement(instancePointerExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(instancePointerExternalSourceElement);
				if (result == null) result = caseInstancePointerSourceInterface(instancePointerExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(instancePointerExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(instancePointerExternalSourceElement);
				if (result == null) result = caseNamedElement(instancePointerExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.RANGE_BOUND: {
				RangeBound rangeBound = (RangeBound)theEObject;
				T result = caseRangeBound(rangeBound);
				if (result == null) result = caseExpressionHint(rangeBound);
				if (result == null) result = caseModifiableHint(rangeBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SINGLE_REFERENCE_VALUE_CONSTRAINT: {
				SingleReferenceValueConstraint singleReferenceValueConstraint = (SingleReferenceValueConstraint)theEObject;
				T result = caseSingleReferenceValueConstraint(singleReferenceValueConstraint);
				if (result == null) result = caseValueConstraint(singleReferenceValueConstraint);
				if (result == null) result = caseExpressionHint(singleReferenceValueConstraint);
				if (result == null) result = caseModifiableHint(singleReferenceValueConstraint);
				if (result == null) result = caseNamedElement(singleReferenceValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.VALUE_CONSTRAINT_SOURCE_INTERFACE: {
				ValueConstraintSourceInterface valueConstraintSourceInterface = (ValueConstraintSourceInterface)theEObject;
				T result = caseValueConstraintSourceInterface(valueConstraintSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintSourceInterface);
				if (result == null) result = caseNamedElement(valueConstraintSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.VALUE_CONSTRAINT_SOURCE_ELEMENT: {
				ValueConstraintSourceElement valueConstraintSourceElement = (ValueConstraintSourceElement)theEObject;
				T result = caseValueConstraintSourceElement(valueConstraintSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(valueConstraintSourceElement);
				if (result == null) result = caseValueConstraintSourceInterface(valueConstraintSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(valueConstraintSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintSourceElement);
				if (result == null) result = caseNamedElement(valueConstraintSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT: {
				ValueConstraintExternalSourceElement valueConstraintExternalSourceElement = (ValueConstraintExternalSourceElement)theEObject;
				T result = caseValueConstraintExternalSourceElement(valueConstraintExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(valueConstraintExternalSourceElement);
				if (result == null) result = caseValueConstraintSourceInterface(valueConstraintExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(valueConstraintExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintExternalSourceElement);
				if (result == null) result = caseNamedElement(valueConstraintExternalSourceElement);
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseMetaModelElement(MetaModelElement<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseClass(pamtram.structure.generic.Class<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseSection(Section<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceSection(SourceSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSection(TargetSection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileAttribute(FileAttribute object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceParameter(ResourceParameter object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseReference(Reference<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseCompositeReference(CompositeReference<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseCrossReference(CrossReference<S, C, R, A> object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Target Section Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section Composite Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionCompositeReference(TargetSectionCompositeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Section Cross Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionCrossReference(TargetSectionCrossReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Section Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Section Composite Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceSectionCompositeReference(SourceSectionCompositeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Section Cross Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceSectionCrossReference(SourceSectionCrossReference object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseAttribute(Attribute<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseActualAttribute(ActualAttribute<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseVirtualAttribute(VirtualAttribute<S, C, R, A> object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Actual Source Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actual Source Section Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActualSourceSectionAttribute(ActualSourceSectionAttribute object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Actual Target Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actual Target Section Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActualTargetSectionAttribute(ActualTargetSectionAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Target Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Target Section Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualTargetSectionAttribute(VirtualTargetSectionAttribute object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraint(ValueConstraint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Range Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeConstraint(RangeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple References Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple References Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleReferencesValueConstraint(MultipleReferencesValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointer(InstancePointer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointerSourceInterface(InstancePointerSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointerSourceElement(InstancePointerSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointerExternalSourceElement(InstancePointerExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeBound(RangeBound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Reference Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Reference Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleReferenceValueConstraint(SingleReferenceValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintSourceInterface(ValueConstraintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintSourceElement(ValueConstraintSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintExternalSourceElement(ValueConstraintExternalSourceElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Expression Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionHint(ExpressionHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiableHint(ModifiableHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintSourceInterface(MappingHintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseModifiedAttributeElementType(ModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<S, C, R, A> object) {
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

} //StructureSwitch
