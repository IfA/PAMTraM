/**
 */
package pamtram.metamodel.util;

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
			case MetamodelPackage.META_MODEL_ELEMENT: {
				MetaModelElement<?, ?, ?, ?> metaModelElement = (MetaModelElement<?, ?, ?, ?>)theEObject;
				T result = caseMetaModelElement(metaModelElement);
				if (result == null) result = caseNamedElement(metaModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CLASS: {
				pamtram.metamodel.Class<?, ?, ?, ?> class_ = (pamtram.metamodel.Class<?, ?, ?, ?>)theEObject;
				T result = caseClass(class_);
				if (result == null) result = caseMetaModelElement(class_);
				if (result == null) result = caseNamedElement(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SECTION: {
				Section<?, ?, ?, ?> section = (Section<?, ?, ?, ?>)theEObject;
				T result = caseSection(section);
				if (result == null) result = caseClass(section);
				if (result == null) result = caseMetaModelElement(section);
				if (result == null) result = caseNamedElement(section);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SOURCE_SECTION: {
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
			case MetamodelPackage.TARGET_SECTION: {
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
			case MetamodelPackage.FILE_ATTRIBUTE: {
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
				Reference<?, ?, ?, ?> reference = (Reference<?, ?, ?, ?>)theEObject;
				T result = caseReference(reference);
				if (result == null) result = caseMetaModelElement(reference);
				if (result == null) result = caseNamedElement(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CONTAINMENT_REFERENCE: {
				ContainmentReference<?, ?, ?, ?> containmentReference = (ContainmentReference<?, ?, ?, ?>)theEObject;
				T result = caseContainmentReference(containmentReference);
				if (result == null) result = caseReference(containmentReference);
				if (result == null) result = caseMetaModelElement(containmentReference);
				if (result == null) result = caseNamedElement(containmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE: {
				NonContainmentReference<?, ?, ?, ?> nonContainmentReference = (NonContainmentReference<?, ?, ?, ?>)theEObject;
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
				Attribute<?, ?, ?, ?> attribute = (Attribute<?, ?, ?, ?>)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseMetaModelElement(attribute);
				if (result == null) result = caseNamedElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ACTUAL_ATTRIBUTE: {
				ActualAttribute<?, ?, ?, ?> actualAttribute = (ActualAttribute<?, ?, ?, ?>)theEObject;
				T result = caseActualAttribute(actualAttribute);
				if (result == null) result = caseAttribute(actualAttribute);
				if (result == null) result = caseMetaModelElement(actualAttribute);
				if (result == null) result = caseNamedElement(actualAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.VIRTUAL_ATTRIBUTE: {
				VirtualAttribute<?, ?, ?, ?> virtualAttribute = (VirtualAttribute<?, ?, ?, ?>)theEObject;
				T result = caseVirtualAttribute(virtualAttribute);
				if (result == null) result = caseAttribute(virtualAttribute);
				if (result == null) result = caseMetaModelElement(virtualAttribute);
				if (result == null) result = caseNamedElement(virtualAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE: {
				ActualSourceSectionAttribute actualSourceSectionAttribute = (ActualSourceSectionAttribute)theEObject;
				T result = caseActualSourceSectionAttribute(actualSourceSectionAttribute);
				if (result == null) result = caseAttribute(actualSourceSectionAttribute);
				if (result == null) result = caseMetaModelElement(actualSourceSectionAttribute);
				if (result == null) result = caseNamedElement(actualSourceSectionAttribute);
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
			case MetamodelPackage.ACTUAL_TARGET_SECTION_ATTRIBUTE: {
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
			case MetamodelPackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE: {
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
			case MetamodelPackage.EQUALITY_MATCHER: {
				EqualityMatcher equalityMatcher = (EqualityMatcher)theEObject;
				T result = caseEqualityMatcher(equalityMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(equalityMatcher);
				if (result == null) result = caseSingleReferenceAttributeValueConstraint(equalityMatcher);
				if (result == null) result = caseAttributeValueConstraint(equalityMatcher);
				if (result == null) result = caseExpressionHint(equalityMatcher);
				if (result == null) result = caseModifiableHint(equalityMatcher);
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
				if (result == null) result = caseSingleReferenceAttributeValueConstraint(substringMatcher);
				if (result == null) result = caseAttributeValueConstraint(substringMatcher);
				if (result == null) result = caseExpressionHint(substringMatcher);
				if (result == null) result = caseModifiableHint(substringMatcher);
				if (result == null) result = caseNamedElement(substringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.BEGINNING_MATCHER: {
				BeginningMatcher beginningMatcher = (BeginningMatcher)theEObject;
				T result = caseBeginningMatcher(beginningMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(beginningMatcher);
				if (result == null) result = caseSingleReferenceAttributeValueConstraint(beginningMatcher);
				if (result == null) result = caseAttributeValueConstraint(beginningMatcher);
				if (result == null) result = caseExpressionHint(beginningMatcher);
				if (result == null) result = caseModifiableHint(beginningMatcher);
				if (result == null) result = caseNamedElement(beginningMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ENDING_MATCHER: {
				EndingMatcher endingMatcher = (EndingMatcher)theEObject;
				T result = caseEndingMatcher(endingMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(endingMatcher);
				if (result == null) result = caseSingleReferenceAttributeValueConstraint(endingMatcher);
				if (result == null) result = caseAttributeValueConstraint(endingMatcher);
				if (result == null) result = caseExpressionHint(endingMatcher);
				if (result == null) result = caseModifiableHint(endingMatcher);
				if (result == null) result = caseNamedElement(endingMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.REG_EX_MATCHER: {
				RegExMatcher regExMatcher = (RegExMatcher)theEObject;
				T result = caseRegExMatcher(regExMatcher);
				if (result == null) result = caseSingleReferenceAttributeValueConstraint(regExMatcher);
				if (result == null) result = caseAttributeValueConstraint(regExMatcher);
				if (result == null) result = caseExpressionHint(regExMatcher);
				if (result == null) result = caseModifiableHint(regExMatcher);
				if (result == null) result = caseNamedElement(regExMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CASE_SENSITIVE_CONSTRAINT: {
				CaseSensitiveConstraint caseSensitiveConstraint = (CaseSensitiveConstraint)theEObject;
				T result = caseCaseSensitiveConstraint(caseSensitiveConstraint);
				if (result == null) result = caseSingleReferenceAttributeValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseAttributeValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseExpressionHint(caseSensitiveConstraint);
				if (result == null) result = caseModifiableHint(caseSensitiveConstraint);
				if (result == null) result = caseNamedElement(caseSensitiveConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.RANGE_CONSTRAINT: {
				RangeConstraint rangeConstraint = (RangeConstraint)theEObject;
				T result = caseRangeConstraint(rangeConstraint);
				if (result == null) result = caseMultipleReferencesAttributeValueConstraint(rangeConstraint);
				if (result == null) result = caseAttributeValueConstraint(rangeConstraint);
				if (result == null) result = caseNamedElement(rangeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.MULTIPLE_REFERENCES_ATTRIBUTE_VALUE_CONSTRAINT: {
				MultipleReferencesAttributeValueConstraint multipleReferencesAttributeValueConstraint = (MultipleReferencesAttributeValueConstraint)theEObject;
				T result = caseMultipleReferencesAttributeValueConstraint(multipleReferencesAttributeValueConstraint);
				if (result == null) result = caseAttributeValueConstraint(multipleReferencesAttributeValueConstraint);
				if (result == null) result = caseNamedElement(multipleReferencesAttributeValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.INSTANCE_POINTER: {
				InstancePointer instancePointer = (InstancePointer)theEObject;
				T result = caseInstancePointer(instancePointer);
				if (result == null) result = caseExpressionHint(instancePointer);
				if (result == null) result = caseModifiableHint(instancePointer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.INSTANCE_POINTER_SOURCE_INTERFACE: {
				InstancePointerSourceInterface instancePointerSourceInterface = (InstancePointerSourceInterface)theEObject;
				T result = caseInstancePointerSourceInterface(instancePointerSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(instancePointerSourceInterface);
				if (result == null) result = caseNamedElement(instancePointerSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.INSTANCE_POINTER_SOURCE_ELEMENT: {
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
			case MetamodelPackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT: {
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
			case MetamodelPackage.RANGE_BOUND: {
				RangeBound rangeBound = (RangeBound)theEObject;
				T result = caseRangeBound(rangeBound);
				if (result == null) result = caseExpressionHint(rangeBound);
				if (result == null) result = caseModifiableHint(rangeBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT: {
				SingleReferenceAttributeValueConstraint singleReferenceAttributeValueConstraint = (SingleReferenceAttributeValueConstraint)theEObject;
				T result = caseSingleReferenceAttributeValueConstraint(singleReferenceAttributeValueConstraint);
				if (result == null) result = caseAttributeValueConstraint(singleReferenceAttributeValueConstraint);
				if (result == null) result = caseExpressionHint(singleReferenceAttributeValueConstraint);
				if (result == null) result = caseModifiableHint(singleReferenceAttributeValueConstraint);
				if (result == null) result = caseNamedElement(singleReferenceAttributeValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_SOURCE_INTERFACE: {
				AttributeValueConstraintSourceInterface attributeValueConstraintSourceInterface = (AttributeValueConstraintSourceInterface)theEObject;
				T result = caseAttributeValueConstraintSourceInterface(attributeValueConstraintSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(attributeValueConstraintSourceInterface);
				if (result == null) result = caseNamedElement(attributeValueConstraintSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_SOURCE_ELEMENT: {
				AttributeValueConstraintSourceElement attributeValueConstraintSourceElement = (AttributeValueConstraintSourceElement)theEObject;
				T result = caseAttributeValueConstraintSourceElement(attributeValueConstraintSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(attributeValueConstraintSourceElement);
				if (result == null) result = caseAttributeValueConstraintSourceInterface(attributeValueConstraintSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeValueConstraintSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeValueConstraintSourceElement);
				if (result == null) result = caseNamedElement(attributeValueConstraintSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT: {
				AttributeValueConstraintExternalSourceElement attributeValueConstraintExternalSourceElement = (AttributeValueConstraintExternalSourceElement)theEObject;
				T result = caseAttributeValueConstraintExternalSourceElement(attributeValueConstraintExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(attributeValueConstraintExternalSourceElement);
				if (result == null) result = caseAttributeValueConstraintSourceInterface(attributeValueConstraintExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeValueConstraintExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeValueConstraintExternalSourceElement);
				if (result == null) result = caseNamedElement(attributeValueConstraintExternalSourceElement);
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseMetaModelElement(MetaModelElement<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseClass(pamtram.metamodel.Class<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseSection(Section<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseReference(Reference<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseContainmentReference(ContainmentReference<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseNonContainmentReference(NonContainmentReference<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseAttribute(Attribute<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseActualAttribute(ActualAttribute<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseVirtualAttribute(VirtualAttribute<S, C, R, A> object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Multiple References Attribute Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple References Attribute Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleReferencesAttributeValueConstraint(MultipleReferencesAttributeValueConstraint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Single Reference Attribute Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Reference Attribute Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleReferenceAttributeValueConstraint(SingleReferenceAttributeValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Constraint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Constraint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueConstraintSourceInterface(AttributeValueConstraintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Constraint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Constraint Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueConstraintSourceElement(AttributeValueConstraintSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Constraint External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Constraint External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueConstraintExternalSourceElement(AttributeValueConstraintExternalSourceElement object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseModifiedAttributeElementType(ModifiedAttributeElementType<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<S, C, R, A> object) {
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
