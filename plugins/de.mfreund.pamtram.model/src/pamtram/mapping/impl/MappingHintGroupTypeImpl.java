/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.mfreund.pamtram.properties.PropertySupplier;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import pamtram.impl.NamedElementImpl;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.util.MappingValidator;
import pamtram.structure.source.SourceSection;
import pamtram.structure.target.TargetSection;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Hint Group Type</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getTargetSection <em>Target Section</em>}</li>
 * <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getMappingHints <em>Mapping Hints</em>}</li>
 * <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getExtend <em>Extend</em>}</li>
 * <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getAttributeMappings <em>Attribute Mappings</em>}</li>
 * <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getCardinalityMappings <em>Cardinality Mappings</em>}</li>
 * <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getReferenceTargetSelectors <em>Reference Target
 * Selectors</em>}</li>
 * <li>{@link pamtram.mapping.impl.MappingHintGroupTypeImpl#getContainerSelectors <em>Container Selectors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingHintGroupTypeImpl extends NamedElementImpl implements MappingHintGroupType {

	/**
	 * The cached value of the '{@link #getTargetSection() <em>Target Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetSection()
	 * @generated
	 * @ordered
	 */
	protected TargetSection targetSection;

	/**
	 * The cached value of the '{@link #getMappingHints() <em>Mapping Hints</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMappingHints()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHint> mappingHints;

	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingHintGroupType> extend;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSection getTargetSection() {
	
		  if (targetSection != null && targetSection.eIsProxy()) {
			InternalEObject oldTargetSection = (InternalEObject)targetSection;
			targetSection = (TargetSection)eResolveProxy(oldTargetSection);
			if (targetSection != oldTargetSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION, oldTargetSection, targetSection));
			}
		}
		return targetSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSection basicGetTargetSection() {
		return targetSection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetSectionGen(TargetSection newTargetSection) {
	
		TargetSection oldTargetSection = targetSection;
		targetSection = newTargetSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION, oldTargetSection, targetSection));
	
	}

	/**
	 * Before setting the {@link newTargetMMSection}, update the name.
	 */
	@Override
	public void setTargetSection(TargetSection newTargetMMSection) {

		this.setNameDerived(this.targetSection, newTargetMMSection, null, null);
		this.setTargetSectionGen(newTargetMMSection);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHint> getMappingHints() {
	
		if (mappingHints == null) {
			mappingHints = new EObjectContainmentEList<MappingHint>(MappingHint.class, this, MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS);
		}
		return mappingHints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintGroupType> getExtend() {
	
		if (extend == null) {
			extend = new EObjectResolvingEList<MappingHintGroupType>(MappingHintGroupType.class, this, MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMapping> getAttributeMappings() {
	
		List<AttributeMapping> attributeMappings = this.getAllMappingHints().stream()
						.filter(hint -> hint instanceof AttributeMapping).map(hint -> (AttributeMapping) hint)
						.collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS,
				attributeMappings.size(),attributeMappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CardinalityMapping> getCardinalityMappings() {
	
		List<CardinalityMapping> cardinalityMappings = this.getAllMappingHints().stream()
						.filter(hint -> hint instanceof CardinalityMapping).map(hint -> (CardinalityMapping) hint)
						.collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS,
				cardinalityMappings.size(),cardinalityMappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ReferenceTargetSelector> getReferenceTargetSelectors() {
	
		List<ReferenceTargetSelector> referenceTargetSelectors = this.getAllMappingHints().stream()
						.filter(hint -> hint instanceof ReferenceTargetSelector).map(hint -> (ReferenceTargetSelector) hint)
						.collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS,
				referenceTargetSelectors.size(),referenceTargetSelectors.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ContainerSelector> getContainerSelectors() {
	
		List<ContainerSelector> containerSelectors = this.getAllMappingHints().stream()
						.filter(hint -> hint instanceof ContainerSelector).map(hint -> (ContainerSelector) hint)
						.collect(Collectors.toList());
		return new EcoreEList.UnmodifiableEList<>(this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS,
				containerSelectors.size(),containerSelectors.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHint> getAllMappingHints() {
	
		Set<MappingHint> ret = new LinkedHashSet<>();
		
		ret.addAll(this.getAllExtend().stream().flatMap(s -> s.getMappingHints().stream())
				.collect(Collectors.toList()));
		
			ret.addAll(this.getMappingHints());
		
			// Filter those MappingHints that are overridden by more concrete hints
				//
				Set<MappingHint> overridenHints = ret.parallelStream().filter(h -> h.getOverwrite() != null).map(MappingHint::getOverwrite).collect(Collectors.toSet());
				ret.removeAll(overridenHints);
		
				return new EcoreEList.UnmodifiableEList<>(this,
								MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__ALL_MAPPING_HINTS, ret.size(), ret.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintGroupType> getAllExtend() {
	
		Set<Object> ret = new LinkedHashSet<>();
		
		List<MappingHintGroupType> toCheck = new ArrayList<>();
		toCheck.add(this);
		
		while (!toCheck.isEmpty()) {
			MappingHintGroupType next = toCheck.remove(0);
		
			List<MappingHintGroupType> localToCheck = next.getExtend().stream().filter(e -> !ret.contains(e))
					.collect(Collectors.toList());
			ret.addAll(localToCheck);
			toCheck.addAll(localToCheck);
		}
		
		return new EcoreEList.UnmodifiableEList<>(this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__ALL_EXTEND,
				ret.size(), ret.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHintGroupType> getAllExtending() {
	
		Set<Object> extendingSections = new HashSet<>();
				Iterator<Notifier> it = this.eResource().getResourceSet().getAllContents();
				while (it.hasNext()) {
					Notifier next = it.next();
					if (next instanceof MappingHintGroupType && ((MappingHintGroupType) next).getAllExtend().contains(this)) {
						extendingSections.add(next);
					}
				}
		
			return new EcoreEList.UnmodifiableEList<>(this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__ALL_EXTENDING,
						extendingSections.size(), extendingSections.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExtendsOnlyValidHintGroups(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		SourceSection sourceSection = ((Mapping) this.eContainer()).getSourceSection();
		
		if (sourceSection == null) {
			return true;
		}
		
		List<SourceSection> validExtends = new ArrayList<>();
		validExtends.add(sourceSection);
		validExtends.addAll(sourceSection.getAllExtend());
		
		Optional<MappingHintGroupType> result = this.getExtend().stream()
				.filter(hg -> !validExtends.contains(((Mapping) hg.eContainer()).getSourceSection())).findFirst();
		
		if (result.isPresent() && diagnostics != null) {
		
			String errorMessage = "The MappingHintGroup '" + result.get().getName() + "' may not be extended by this MappingHintGroup because the referenced SourceSections are not compatible!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND }));
		
		}
		
		return !result.isPresent();	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingHint> getActiveMappingHints() {
		Object[] hints = getAllMappingHints().stream().filter(h -> !h.isDeactivated()).toArray();
		return new BasicEList.UnmodifiableEList<>(hints.length, hints);	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateDoNotUseLibraryElementsWithoutLibraryNature(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		if (this.getTargetSection() == null || !this.getTargetSection().isLibraryEntry()) {
			return true;
		}
		
		// Check if the 'PAMTraM Library Nature' is set for the project
		//
		IFile file = ResourceHelper.getFileForResource(this.eResource());
		if (file == null || file.getProject() == null) {
			return true;
		}
		
		String errorMessage = "The 'PAMTraM Library Nature' is not activated for this project. Thus, LibraryEntries may not be used as TargetSections! You can activate the nature in the project properties...";
		
		try {
			if (!Boolean.parseBoolean(PropertySupplier.getResourceProperty(PropertySupplier.PROP_HAS_LIBRARY_NATURE,
					file.getProject()))) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_DO_NOT_USE_LIBRARY_ELEMENTS_WITHOUT_LIBRARY_NATURE,
							errorMessage,
							new Object[] { this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION }));
				}
				return false;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return true;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetSectionIsNotAbstract(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(!(this.eContainer() instanceof Mapping)) {
			return true;
		}
		
		Mapping mapping = (Mapping) this.eContainer();
		
		boolean result = this.getTargetSection() == null || mapping.isAbstract() || !this.getTargetSection().isAbstract();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Only MappingHintGroups in abstract Mappings may reference abstract TargetSections!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_TARGET_SECTION_IS_NOT_ABSTRACT,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNotExtendSelf(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		boolean result = !this.getAllExtend().contains(this);
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "A MappingHintGroup must not extend itself (neither directly nor indirectly)!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR, 
					MappingValidator.DIAGNOSTIC_SOURCE,
						MappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_NOT_EXTEND_SELF, 
						errorMessage,
					new Object[] { this, MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				return ((InternalEList<?>)getMappingHints()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION:
				if (resolve) return getTargetSection();
				return basicGetTargetSection();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				return getMappingHints();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				return getExtend();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS:
				return getAttributeMappings();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS:
				return getCardinalityMappings();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS:
				return getReferenceTargetSelectors();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS:
				return getContainerSelectors();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ALL_MAPPING_HINTS:
				return getAllMappingHints();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ALL_EXTEND:
				return getAllExtend();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ALL_EXTENDING:
				return getAllExtending();
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION:
				setTargetSection((TargetSection)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				getMappingHints().clear();
				getMappingHints().addAll((Collection<? extends MappingHint>)newValue);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends MappingHintGroupType>)newValue);
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION:
				setTargetSection((TargetSection)null);
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				getMappingHints().clear();
				return;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				getExtend().clear();
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
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION:
				return targetSection != null;
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				return mappingHints != null && !mappingHints.isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__EXTEND:
				return extend != null && !extend.isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS:
				return !getAttributeMappings().isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS:
				return !getCardinalityMappings().isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS:
				return !getReferenceTargetSelectors().isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS:
				return !getContainerSelectors().isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ALL_MAPPING_HINTS:
				return !getAllMappingHints().isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ALL_EXTEND:
				return !getAllExtend().isEmpty();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__ALL_EXTENDING:
				return !getAllExtending().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.MAPPING_HINT_GROUP_TYPE___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP:
				return validateExtendsOnlyValidHintGroups((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.MAPPING_HINT_GROUP_TYPE___GET_ACTIVE_MAPPING_HINTS:
				return getActiveMappingHints();
			case MappingPackage.MAPPING_HINT_GROUP_TYPE___VALIDATE_DO_NOT_USE_LIBRARY_ELEMENTS_WITHOUT_LIBRARY_NATURE__DIAGNOSTICCHAIN_MAP:
				return validateDoNotUseLibraryElementsWithoutLibraryNature((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.MAPPING_HINT_GROUP_TYPE___VALIDATE_TARGET_SECTION_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP:
				return validateTargetSectionIsNotAbstract((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.MAPPING_HINT_GROUP_TYPE___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP:
				return validateNotExtendSelf((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // MappingHintGroupTypeImpl
