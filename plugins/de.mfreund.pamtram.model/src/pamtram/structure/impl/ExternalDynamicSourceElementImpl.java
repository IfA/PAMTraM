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
package pamtram.structure.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceSection;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>External Modified Attribute Element
 * Type</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ExternalDynamicSourceElementImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends DynamicSourceElementImpl<S, C, R, A> implements ExternalDynamicSourceElement<S, C, R, A> {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalDynamicSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.EXTERNAL_DYNAMIC_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceAttributeMatchesContainerSection(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		if (this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null
						|| !(this.source.getContainingSection() instanceof SourceSection)) {
					return true;
				}
		
			SourceSection sourceSection = this.getMapping().getSourceSection();
				SourceSection containingSection = (SourceSection) this.getSource().getContainingSection();
		
			boolean result = containingSection.isContainerFor(sourceSection);
		
			if (!result && diagnostics != null) {
		
				String errorMessage = "The source attribute '" + this.getSource().getName()
							+ "' is not part of a container section of the source section of the parent mapping '"
							+ this.getMapping().getSourceSection().getName() + "'!";
		
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, StructureValidator.DIAGNOSTIC_SOURCE,
							StructureValidator.EXTERNAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION,
							errorMessage, new Object[] { this, StructurePackage.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));
		
			}
		
			return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceAttributeMatchesContainerSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // ExternalDynamicSourceElementImpl
