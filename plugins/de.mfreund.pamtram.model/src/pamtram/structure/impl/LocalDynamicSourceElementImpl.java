/**
 */
package pamtram.structure.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import pamtram.MatchSpecElement;
import pamtram.PamtramPackage;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceSection;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Local
 * Modified Attribute Element Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.LocalDynamicSourceElementImpl#getReferenceMatchSpec <em>Reference Match Spec</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LocalDynamicSourceElementImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends DynamicSourceElementImpl<S, C, R, A> implements LocalDynamicSourceElement<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getReferenceMatchSpec() <em>Reference Match Spec</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceMatchSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<R> referenceMatchSpec;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalDynamicSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.LOCAL_DYNAMIC_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<R> getReferenceMatchSpec() {
		if (referenceMatchSpec == null) {
			referenceMatchSpec = new EObjectResolvingEList<R>(Reference.class, this, StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC);
		}
		return referenceMatchSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceAttributeMatchesSectionOrContainedSection(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		if(this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null
						|| !(this.source.getContainingSection() instanceof SourceSection)) {
			return true;
		}
		
		SourceSection sourceSection = this.getMapping().getSourceSection();
		SourceSection containingSourceSection = (SourceSection) this.source.getContainingSection();
		
		boolean result = sourceSection == containingSourceSection 
				|| sourceSection.getExtend().parallelStream().filter(e -> e.equals(containingSourceSection)).findAny().isPresent()
				|| sourceSection.getExtend().parallelStream().filter(e -> containingSourceSection.isReferencedBy(e, null)).findAny().isPresent()
				|| containingSourceSection.isReferencedBy(sourceSection, null);
		
		if (!result && diagnostics != null) {
			
			String errorMessage = "The source attribute '" +
					 this.source.getName() + "' is not referenced by the source section of the parent mapping '" +
					 sourceSection.getName() + "' or in one of its extended sections/sub-sections!'";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 StructureValidator.DIAGNOSTIC_SOURCE,
					 StructureValidator.LOCAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION,
					 errorMessage,
					 new Object [] { this, StructurePackage.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				return getReferenceMatchSpec();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				getReferenceMatchSpec().addAll((Collection<? extends R>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				return referenceMatchSpec != null && !referenceMatchSpec.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MatchSpecElement.class) {
			switch (derivedFeatureID) {
				case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC: return PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MatchSpecElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC: return StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceAttributeMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // LocalDynamicSourceElementImpl
