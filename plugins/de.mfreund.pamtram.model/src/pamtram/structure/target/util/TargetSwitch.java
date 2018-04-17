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
package pamtram.structure.target.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pamtram.NamedElement;

import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.target.*;

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
 * @see pamtram.structure.target.TargetPackage
 * @generated
 */
public class TargetSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TargetPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSwitch() {
		if (modelPackage == null) {
			modelPackage = TargetPackage.eINSTANCE;
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
			case TargetPackage.TARGET_SECTION: {
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
			case TargetPackage.FILE_ATTRIBUTE: {
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
			case TargetPackage.TARGET_SECTION_CLASS: {
				TargetSectionClass targetSectionClass = (TargetSectionClass)theEObject;
				T result = caseTargetSectionClass(targetSectionClass);
				if (result == null) result = caseClass(targetSectionClass);
				if (result == null) result = caseMetaModelElement(targetSectionClass);
				if (result == null) result = caseNamedElement(targetSectionClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.TARGET_SECTION_REFERENCE: {
				TargetSectionReference targetSectionReference = (TargetSectionReference)theEObject;
				T result = caseTargetSectionReference(targetSectionReference);
				if (result == null) result = caseReference(targetSectionReference);
				if (result == null) result = caseMetaModelElement(targetSectionReference);
				if (result == null) result = caseNamedElement(targetSectionReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE: {
				TargetSectionCompositeReference targetSectionCompositeReference = (TargetSectionCompositeReference)theEObject;
				T result = caseTargetSectionCompositeReference(targetSectionCompositeReference);
				if (result == null) result = caseCompositeReference(targetSectionCompositeReference);
				if (result == null) result = caseTargetSectionReference(targetSectionCompositeReference);
				if (result == null) result = caseActualReference(targetSectionCompositeReference);
				if (result == null) result = caseReference(targetSectionCompositeReference);
				if (result == null) result = caseMetaModelElement(targetSectionCompositeReference);
				if (result == null) result = caseNamedElement(targetSectionCompositeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.TARGET_SECTION_CROSS_REFERENCE: {
				TargetSectionCrossReference targetSectionCrossReference = (TargetSectionCrossReference)theEObject;
				T result = caseTargetSectionCrossReference(targetSectionCrossReference);
				if (result == null) result = caseCrossReference(targetSectionCrossReference);
				if (result == null) result = caseTargetSectionReference(targetSectionCrossReference);
				if (result == null) result = caseActualReference(targetSectionCrossReference);
				if (result == null) result = caseReference(targetSectionCrossReference);
				if (result == null) result = caseMetaModelElement(targetSectionCrossReference);
				if (result == null) result = caseNamedElement(targetSectionCrossReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.TARGET_SECTION_ATTRIBUTE: {
				TargetSectionAttribute targetSectionAttribute = (TargetSectionAttribute)theEObject;
				T result = caseTargetSectionAttribute(targetSectionAttribute);
				if (result == null) result = caseAttribute(targetSectionAttribute);
				if (result == null) result = caseMetaModelElement(targetSectionAttribute);
				if (result == null) result = caseNamedElement(targetSectionAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.ACTUAL_TARGET_SECTION_ATTRIBUTE: {
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
			case TargetPackage.VIRTUAL_TARGET_SECTION_ATTRIBUTE: {
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
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Section Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionClass(TargetSectionClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionReference(TargetSectionReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section Composite Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionCompositeReference(TargetSectionCompositeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section Cross Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetSectionCrossReference(TargetSectionCrossReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section Attribute</em>'.
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
	 * Returns the result of interpreting the object as an instance of '<em>Actual Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actual Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseActualReference(ActualReference<S, C, R, A> object) {
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

} //TargetSwitch
