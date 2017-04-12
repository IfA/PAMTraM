/**
 */
package pamtram.mapping.extended.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.ContainerSelectorTargetAttribute;
import pamtram.mapping.util.MappingValidator;
import pamtram.structure.StructurePackage;
import pamtram.structure.impl.DynamicSourceElementImpl;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Connection Hint Target Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ContainerSelectorTargetAttributeImpl extends DynamicSourceElementImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> implements ContainerSelectorTargetAttribute {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorTargetAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CONTAINER_SELECTOR_TARGET_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setSource(TargetSectionAttribute newSource) {
		super.setSource(newSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceMatchesPossibleContainerType(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(!(this.eContainer().eContainer() instanceof MappingHintGroupType) || this.getSource() == null || !(this.getSource().eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)) {
			return true;
		}
		
		TargetSection targetSection = ((MappingHintGroupType) this.eContainer().eContainer()).getTargetSection();
		
		boolean result = this.getSource() == null || targetSection == null ? true : ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getSource().eContainer()).getEClass().getEAllContainments().parallelStream().anyMatch(r -> r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The type of the parent hint group's target section ('" + 
				((MappingHintGroupType) this.eContainer().eContainer()).getTargetSection().getEClass().getName() + 
				"') cannot be connected to (contained in) the type of the class containing the target attribute ('" + 
				((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getSource().eContainer()).getName() + "')!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.CONTAINER_SELECTOR_TARGET_ATTRIBUTE__VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE,
							errorMessage,
					new Object[] { this, StructurePackage.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));
		
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
			case MappingPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE___VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP:
				return validateSourceMatchesPossibleContainerType((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModelConnectionHintTargetAttributeImpl
