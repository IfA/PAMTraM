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
package pamtram.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.ConditionModel;
import pamtram.FixedValue;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>PAM Tra M</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSectionModels <em>Source Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedSourceSectionModels <em>Shared Source Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSectionModels <em>Target Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedTargetSectionModels <em>Shared Target Section Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappingModels <em>Mapping Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedMappingModels <em>Shared Mapping Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSourceSections <em>Source Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getTargetSections <em>Target Sections</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getActiveMappings <em>Active Mappings</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getGlobalValues <em>Global Values</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getGlobalAttributes <em>Global Attributes</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getModifierSets <em>Modifier Sets</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getConditionModels <em>Condition Models</em>}</li>
 *   <li>{@link pamtram.impl.PAMTraMImpl#getSharedConditionModels <em>Shared Condition Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PAMTraMImpl extends MinimalEObjectImpl.Container implements PAMTraM {

	/**
	 * The cached value of the '{@link #getSourceSectionModels() <em>Source Section Models</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionModel> sourceSectionModels;

	/**
	 * The cached value of the '{@link #getSharedSourceSectionModels() <em>Shared Source Section Models</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSharedSourceSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionModel> sharedSourceSectionModels;

	/**
	 * The cached value of the '{@link #getTargetSectionModels() <em>Target Section Models</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTargetSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionModel> targetSectionModels;

	/**
	 * The cached value of the '{@link #getSharedTargetSectionModels() <em>Shared Target Section Models</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSharedTargetSectionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetSectionModel> sharedTargetSectionModels;

	/**
	 * The cached value of the '{@link #getMappingModels() <em>Mapping Models</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMappingModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingModel> mappingModels;

	/**
	 * The cached value of the '{@link #getSharedMappingModels() <em>Shared Mapping Models</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSharedMappingModels()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingModel> sharedMappingModels;

	/**
	 * The cached value of the '{@link #getConditionModels() <em>Condition Models</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConditionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionModel> conditionModels;

	/**
	 * The cached value of the '{@link #getSharedConditionModels() <em>Shared Condition Models</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSharedConditionModels()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionModel> sharedConditionModels;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PAMTraMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.PAM_TRA_M;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionModel> getSourceSectionModels() {
	
		if (sourceSectionModels == null) {
			sourceSectionModels = new EObjectContainmentEList<SourceSectionModel>(SourceSectionModel.class, this, PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS);
		}
		return sourceSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionModel> getSharedSourceSectionModels() {
	
		if (sharedSourceSectionModels == null) {
			sharedSourceSectionModels = new EObjectResolvingEList<SourceSectionModel>(SourceSectionModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS);
		}
		return sharedSourceSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSectionModel> getTargetSectionModels() {
	
		if (targetSectionModels == null) {
			targetSectionModels = new EObjectContainmentEList<TargetSectionModel>(TargetSectionModel.class, this, PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS);
		}
		return targetSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSectionModel> getSharedTargetSectionModels() {
	
		if (sharedTargetSectionModels == null) {
			sharedTargetSectionModels = new EObjectResolvingEList<TargetSectionModel>(TargetSectionModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS);
		}
		return sharedTargetSectionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingModel> getMappingModels() {
	
		if (mappingModels == null) {
			mappingModels = new EObjectContainmentEList<MappingModel>(MappingModel.class, this, PamtramPackage.PAM_TRA_M__MAPPING_MODELS);
		}
		return mappingModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingModel> getSharedMappingModels() {
	
		if (sharedMappingModels == null) {
			sharedMappingModels = new EObjectResolvingEList<MappingModel>(MappingModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS);
		}
		return sharedMappingModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getSourceSections() {
	
		List<SourceSection> sourceSections = Stream
				.concat(this.getSourceSectionModels().stream(),
						this.getSharedSourceSectionModels().stream())
				.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS,
				sourceSections.size(), sourceSections.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TargetSection> getTargetSections() {
	
		List<TargetSection> targetSections = Stream
				.concat(this.getTargetSectionModels().stream(),
						this.getSharedTargetSectionModels().stream())
				.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS,
				targetSections.size(), targetSections.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getMappings() {
	
		List<Mapping> mappings = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getMappings().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__MAPPINGS,
				mappings.size(), mappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Mapping> getActiveMappings() {
	
		List<Mapping> mappings = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.filter(m -> !m.isDeactivated()).flatMap(s -> s.getActiveMappings().stream())
				.filter(m -> m.getSourceSection() == null || !m.getSourceSection().isDeactivated())
				.collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__ACTIVE_MAPPINGS,
				mappings.size(), mappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<FixedValue> getGlobalValues() {
	
		List<FixedValue> globalValues = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getGlobalValues().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__GLOBAL_VALUES,
				globalValues.size(), globalValues.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GlobalAttribute> getGlobalAttributes() {
	
		List<GlobalAttribute> globalAttributes = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getGlobalAttributes().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__GLOBAL_ATTRIBUTES,
				globalAttributes.size(), globalAttributes.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<ValueModifierSet> getModifierSets() {
	
		List<ValueModifierSet> modifierSets = Stream.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())
				.flatMap(s -> s.getModifierSets().stream()).collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__MODIFIER_SETS,
				modifierSets.size(), modifierSets.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConditionModel> getConditionModels() {
	
		if (conditionModels == null) {
			conditionModels = new EObjectContainmentEList<ConditionModel>(ConditionModel.class, this, PamtramPackage.PAM_TRA_M__CONDITION_MODELS);
		}
		return conditionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConditionModel> getSharedConditionModels() {
	
		if (sharedConditionModels == null) {
			sharedConditionModels = new EObjectResolvingEList<ConditionModel>(ConditionModel.class, this, PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS);
		}
		return sharedConditionModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionModel> getActiveSourceSectionModels() {
		Object[] sourceSectionModels = Stream.concat(this.getSourceSectionModels().stream(), this.getSharedSourceSectionModels().stream()).filter(s -> !s.isDeactivated()).toArray();
		return new BasicEList.UnmodifiableEList<>(sourceSectionModels.length, sourceSectionModels);	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getActiveSourceSections() {
		Object[] sourceSections = getActiveSourceSectionModels().stream().flatMap(s -> s.getSections().stream()).filter(s -> !s.isDeactivated()).toArray();
		return new BasicEList.UnmodifiableEList<>(sourceSections.length, sourceSections);	
	}

	/**
	 * This merges the given {@link TargetSectionAttribute} 'copy' into the the given {@link TargetSection}
	 * 'targetSection'. Merging in this case means that before adding the attribute, the algorithm checks whether the
	 * 'same' attribute is already present. If this is the case, the attribute is not added but all references to it are
	 * redirected to the attribute already present in the target section.
	 *
	 * @param targetSection
	 * @param att
	 */
	// private void merge(TargetSection targetSection, TargetSectionAttribute
	// att) {
	// for (TargetSectionAttribute targetSectionAttribute :
	// targetSection.getAttributes()) {
	// if(checkEquality(targetSectionAttribute, att)) {
	// Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(this,
	// att);
	// for (Setting setting : refs) {
	// setting.set(targetSectionAttribute);
	// }
	// return;
	// }
	// }
	// }

	/**
	 * This merges the given {@link TargetSectionReference} 'copy' into the the given {@link TargetSection}
	 * 'targetSection'. Merging in this case means that before adding the reference, the algorithm checks whether the
	 * 'same' reference is already present. If this is the case, the reference is not added but all references to it are
	 * redirected to the attribute already present in the target section.
	 *
	 * @param targetSection
	 * @param att
	 */
	// private void merge(TargetSection targetSection, TargetSectionReference
	// ref) {
	// for (TargetSectionReference targetSectionReference :
	// targetSection.getReferences()) {
	// if(checkEquality(targetSectionReference, ref)) {
	// Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.findAll(ref.,
	// this);
	// for (Setting setting : refs) {
	// setting.set(targetSectionReference);
	// }
	// return;
	// }
	// }
	// }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				return ((InternalEList<?>)getSourceSectionModels()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				return ((InternalEList<?>)getTargetSectionModels()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				return ((InternalEList<?>)getMappingModels()).basicRemove(otherEnd, msgs);
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				return ((InternalEList<?>)getConditionModels()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				return getSourceSectionModels();
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				return getSharedSourceSectionModels();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				return getTargetSectionModels();
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				return getSharedTargetSectionModels();
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				return getMappingModels();
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				return getSharedMappingModels();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTIONS:
				return getSourceSections();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTIONS:
				return getTargetSections();
			case PamtramPackage.PAM_TRA_M__MAPPINGS:
				return getMappings();
			case PamtramPackage.PAM_TRA_M__ACTIVE_MAPPINGS:
				return getActiveMappings();
			case PamtramPackage.PAM_TRA_M__GLOBAL_VALUES:
				return getGlobalValues();
			case PamtramPackage.PAM_TRA_M__GLOBAL_ATTRIBUTES:
				return getGlobalAttributes();
			case PamtramPackage.PAM_TRA_M__MODIFIER_SETS:
				return getModifierSets();
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				return getConditionModels();
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				return getSharedConditionModels();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				getSourceSectionModels().clear();
				getSourceSectionModels().addAll((Collection<? extends SourceSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				getSharedSourceSectionModels().clear();
				getSharedSourceSectionModels().addAll((Collection<? extends SourceSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				getTargetSectionModels().clear();
				getTargetSectionModels().addAll((Collection<? extends TargetSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				getSharedTargetSectionModels().clear();
				getSharedTargetSectionModels().addAll((Collection<? extends TargetSectionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				getMappingModels().clear();
				getMappingModels().addAll((Collection<? extends MappingModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				getSharedMappingModels().clear();
				getSharedMappingModels().addAll((Collection<? extends MappingModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				getConditionModels().clear();
				getConditionModels().addAll((Collection<? extends ConditionModel>)newValue);
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				getSharedConditionModels().clear();
				getSharedConditionModels().addAll((Collection<? extends ConditionModel>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				getSourceSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				getSharedSourceSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				getTargetSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				getSharedTargetSectionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				getMappingModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				getSharedMappingModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				getConditionModels().clear();
				return;
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				getSharedConditionModels().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
				return sourceSectionModels != null && !sourceSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS:
				return sharedSourceSectionModels != null && !sharedSourceSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
				return targetSectionModels != null && !targetSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS:
				return sharedTargetSectionModels != null && !sharedTargetSectionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
				return mappingModels != null && !mappingModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODELS:
				return sharedMappingModels != null && !sharedMappingModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTIONS:
				return !getSourceSections().isEmpty();
			case PamtramPackage.PAM_TRA_M__TARGET_SECTIONS:
				return !getTargetSections().isEmpty();
			case PamtramPackage.PAM_TRA_M__MAPPINGS:
				return !getMappings().isEmpty();
			case PamtramPackage.PAM_TRA_M__ACTIVE_MAPPINGS:
				return !getActiveMappings().isEmpty();
			case PamtramPackage.PAM_TRA_M__GLOBAL_VALUES:
				return !getGlobalValues().isEmpty();
			case PamtramPackage.PAM_TRA_M__GLOBAL_ATTRIBUTES:
				return !getGlobalAttributes().isEmpty();
			case PamtramPackage.PAM_TRA_M__MODIFIER_SETS:
				return !getModifierSets().isEmpty();
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
				return conditionModels != null && !conditionModels.isEmpty();
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODELS:
				return sharedConditionModels != null && !sharedConditionModels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PamtramPackage.PAM_TRA_M___GET_ACTIVE_SOURCE_SECTION_MODELS:
				return getActiveSourceSectionModels();
			case PamtramPackage.PAM_TRA_M___GET_ACTIVE_SOURCE_SECTIONS:
				return getActiveSourceSections();
		}
		return super.eInvoke(operationID, arguments);
	}

} // PAMTraMImpl
