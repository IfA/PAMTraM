/**
 */
package pamtram.structure.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.structure.FileAttribute;
import pamtram.structure.MetamodelPackage;
import pamtram.structure.Section;
import pamtram.structure.TargetSection;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.TargetSectionImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.structure.impl.TargetSectionImpl#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.structure.impl.TargetSectionImpl#getReferencingMappingHintGroups <em>Referencing Mapping Hint Groups</em>}</li>
 *   <li>{@link pamtram.structure.impl.TargetSectionImpl#getFile <em>File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetSectionImpl extends TargetSectionClassImpl implements TargetSection {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSection> extend;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected FileAttribute file;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TARGET_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.TARGET_SECTION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSection> getExtend() {
		if (extend == null) {
			extend = new EObjectResolvingEList<TargetSection>(TargetSection.class, this, MetamodelPackage.TARGET_SECTION__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<MappingHintGroupType> getReferencingMappingHintGroups() {
		
		List<Mapping> mappings = new ArrayList<>();
		
		if (this.eResource() != null) {
		
			mappings = this.eResource().getResourceSet().getResources().stream()
					.filter(r -> r.getContents().get(0) instanceof pamtram.PAMTraM)
					.flatMap(r -> ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().parallelStream())
					.collect(Collectors.toList());
		}
		
		List<MappingHintGroupType> referencingHintGroups = mappings.parallelStream().flatMap(m -> m.getMappingHintGroups().parallelStream()).filter(m -> this.equals(m.getTargetSection())).collect(Collectors.toList());
		
		return new UnmodifiableEList<>(this, MetamodelPackage.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS,
				referencingHintGroups.size(), referencingHintGroups.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileAttribute getFile() {
		if (file != null && file.eIsProxy()) {
			InternalEObject oldFile = (InternalEObject)file;
			file = (FileAttribute)eResolveProxy(oldFile);
			if (file != oldFile) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.TARGET_SECTION__FILE, oldFile, file));
			}
		}
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileAttribute basicGetFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFile(FileAttribute newFile) {
		FileAttribute oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.TARGET_SECTION__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsReferencedByMappingHintGroup(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = !this.getReferencingMappingHintGroups().isEmpty();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The section is not referenced by any hint group and will not be instantiated!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.WARNING,
					StructureValidator.DIAGNOSTIC_SOURCE,
							StructureValidator.TARGET_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP,
							errorMessage,
					new Object[] { this, MetamodelPackage.Literals.TARGET_SECTION }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateContainerMatchesExtendContainer(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(this.getContainer() == null) {
			return true;
		}
		
		boolean result = this.getExtend().parallelStream().allMatch(
				e -> e.getContainer() == null || e.getContainer() == this.getContainer());
		
		if (!result && diagnostics != null) {
			
			String errorMessage = "The section extends a section that specifies a different container!";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 StructureValidator.DIAGNOSTIC_SOURCE,
					StructureValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,
					 errorMessage,
					 new Object [] { this, MetamodelPackage.Literals.SECTION__EXTEND }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExtendsValidSections(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.getEClass() == null) {
			return true;
		}
		
		boolean result = this.getExtend().parallelStream().noneMatch(e -> !e.isAbstract() || e.getEClass() != null
				&& this.getEClass() != e.getEClass() && !this.getEClass().getEAllSuperTypes().contains(e.getEClass()));
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The section extends a section that is either not abstract or that references an EClass of a different (super-)type!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					StructureValidator.DIAGNOSTIC_SOURCE,
							StructureValidator.SECTION__VALIDATE_EXTENDS_VALID_SECTIONS,
							errorMessage,
					new Object[] { this, MetamodelPackage.Literals.SECTION__EXTEND }));
		
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
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				return isAbstract();
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				return getExtend();
			case MetamodelPackage.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS:
				return getReferencingMappingHintGroups();
			case MetamodelPackage.TARGET_SECTION__FILE:
				if (resolve) return getFile();
				return basicGetFile();
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
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends TargetSection>)newValue);
				return;
			case MetamodelPackage.TARGET_SECTION__FILE:
				setFile((FileAttribute)newValue);
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
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				getExtend().clear();
				return;
			case MetamodelPackage.TARGET_SECTION__FILE:
				setFile((FileAttribute)null);
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
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case MetamodelPackage.TARGET_SECTION__EXTEND:
				return extend != null && !extend.isEmpty();
			case MetamodelPackage.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS:
				return !getReferencingMappingHintGroups().isEmpty();
			case MetamodelPackage.TARGET_SECTION__FILE:
				return file != null;
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
		if (baseClass == Section.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.TARGET_SECTION__ABSTRACT: return MetamodelPackage.SECTION__ABSTRACT;
				case MetamodelPackage.TARGET_SECTION__EXTEND: return MetamodelPackage.SECTION__EXTEND;
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
		if (baseClass == Section.class) {
			switch (baseFeatureID) {
				case MetamodelPackage.SECTION__ABSTRACT: return MetamodelPackage.TARGET_SECTION__ABSTRACT;
				case MetamodelPackage.SECTION__EXTEND: return MetamodelPackage.TARGET_SECTION__EXTEND;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (baseOperationID) {
				case MetamodelPackage.SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP: return MetamodelPackage.TARGET_SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP;
				case MetamodelPackage.SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP: return MetamodelPackage.TARGET_SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case MetamodelPackage.TARGET_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP:
				return validateIsReferencedByMappingHintGroup((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.TARGET_SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP:
				return validateContainerMatchesExtendContainer((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.TARGET_SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return validateExtendsValidSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //TargetSectionImpl
