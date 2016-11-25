/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.util.MappingValidator;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class LocalModifiedAttributeElementTypeImpl<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ModifiedAttributeElementTypeImpl<S, C, R, A> implements LocalModifiedAttributeElementType<S, C, R, A> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalModifiedAttributeElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSourceAttributeMatchesSectionOrContainedSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null
						|| !(this.source.getContainingSection() instanceof SourceSection)) {
			return true;
		}
		
		SourceSection sourceSection = this.getMapping().getSourceSection();
		SourceSection containingSourceSection = (SourceSection) this.source.getContainingSection();
		
		boolean result = sourceSection == containingSourceSection 
				|| containingSourceSection.isReferencedBy(sourceSection, null)
				|| sourceSection.getExtend().parallelStream().filter(e -> e.equals(containingSourceSection)).findAny().isPresent()
				|| sourceSection.getExtend().parallelStream().filter(e -> containingSourceSection.isReferencedBy(e, null)).findAny().isPresent();
		
		if (!result && diagnostics != null) {
			
			String errorMessage = "The source attribute '" +
					 this.source.getName() + "' is not referenced by the source section of the parent mapping '" +
					 sourceSection.getName() + "' or in one of its extended sections/sub-sections!'";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 MappingValidator.DIAGNOSTIC_SOURCE,
					 MappingValidator.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION,
					 errorMessage,
					 new Object [] { this, MappingPackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE }));
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
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceAttributeMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LocalModifiedAttributeElementTypeImpl
