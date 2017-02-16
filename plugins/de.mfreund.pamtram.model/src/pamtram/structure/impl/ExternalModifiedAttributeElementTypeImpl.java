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

import pamtram.mapping.MappingPackage;
import pamtram.mapping.util.MappingValidator;
import pamtram.structure.ExternalModifiedAttributeElementType;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ExternalModifiedAttributeElementTypeImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementTypeImpl<S, C, R, A> implements ExternalModifiedAttributeElementType<S, C, R, A> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceAttributeMatchesContainerSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.getMapping() == null || this.getSource() == null) {
			return true;
		}
		
		SourceSection sourceSection = this.getMapping().getSourceSection();
		
		boolean result = sourceSection == null || !(this.getSource().getContainingSection() instanceof SourceSection) ? true : ((SourceSection) this.getSource().getContainingSection()).isContainerFor(sourceSection);
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The source attribute '" + this.getSource().getName() + "' is not part of a container section of the source section of the parent mapping '" + this.getMapping().getSourceSection().getName() + "'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceAttributeMatchesContainerSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ExternalModifiedAttributeElementTypeImpl
