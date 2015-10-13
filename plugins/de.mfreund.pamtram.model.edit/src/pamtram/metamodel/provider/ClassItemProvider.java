/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.SectionModel;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.Class} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassItemProvider
extends MetaModelElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addEClassPropertyDescriptor(object);
			addCardinalityPropertyDescriptor(object);
			addContainerPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the EClass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEClassPropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Class_eClass_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Class_eClass_feature", "_UI_Class_type"),
						MetamodelPackage.Literals.CLASS__ECLASS,
						true,
						false,
						true,
						null,
						null,
						null));
	}

	/**
	 * This adds a property descriptor for the EClass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addEClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Class_eClass_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Class_eClass_feature", "_UI_Class_type"),
						MetamodelPackage.Literals.CLASS__ECLASS,
						true,
						false,
						true,
						null,
						null,
						null)
		{
			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				Class section = ((pamtram.metamodel.Class) object).getContainingSection();
				SectionModel sectionModel = section.getContainingSectionModel();

				List<EClass> choiceOfValues = new LinkedList<EClass>();

				/*
				 * If we have a container parameter with a specified source, we do not need to scan package contents.
				 * Instead, the user may only select the eClass of the specified source element. 
				 */
				if(section.eContainer() instanceof ContainerParameter &&
						((ContainerParameter) section.eContainer()).getSource() != null) {
					choiceOfValues.add(((ContainerParameter) section.eContainer()).getSource().eClass());
					return choiceOfValues;
				}

				List<EPackage> packagesToScan=new LinkedList<EPackage>();

				packagesToScan.add(sectionModel.getMetaModelPackage());

				List<EClass> documentRoot=new LinkedList<EClass>();//this should only contain one element but we need to implement this in a generic way...												

				while(packagesToScan.size()>0){
					EPackage pkg=packagesToScan.remove(0);
					EClass docroot=ExtendedMetaData.INSTANCE.getDocumentRoot(pkg);
					if(docroot!=null){
						documentRoot.add(docroot);
					}

					packagesToScan.addAll(pkg.getESubpackages());
					for(EClassifier c : pkg.getEClassifiers()){
						if(c instanceof EClass){
							EClass cl=(EClass)c;
							if(!documentRoot.contains(cl)){
								// abstract EClasses are only allowed for abstract sections
								if(!cl.isAbstract() || (object instanceof Section<?, ?, ?, ?> && ((Section<?,?,?,?>) object).isAbstract())) {
									choiceOfValues.add((EClass) c);
								}
							}
						}
					}
				}

				if(section.equals(object)){ // top level-section
					return choiceOfValues;
				} else { //not a top-level section
					List<EClass> newChoiceOfValues = new LinkedList<EClass>();
					pamtram.metamodel.Reference ref=(Reference) ((pamtram.metamodel.Class)object).eContainer();
					if(ref.getEReference() != null){
						if(!(ref.getEReference().getEType() instanceof EClass)) {
							throw new RuntimeException("Type checks can only be performed for instances of type 'EClass'");
						} else {
							EClass refClass=(EClass) ref.getEReference().getEType();

							for(EClass c : choiceOfValues){
								if(refClass.isSuperTypeOf(c)) {
									newChoiceOfValues.add(c);
								}
							}
							return newChoiceOfValues;

						}

					}

				} 
				return super.getChoiceOfValues(object);
			}

		});
	}

	/**
	 * This adds a property descriptor for the Cardinality feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCardinalityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Class_cardinality_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Class_cardinality_feature", "_UI_Class_type"),
						MetamodelPackage.Literals.CLASS__CARDINALITY,
						true,
						false,
						false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
						null,
						null));
	}

	/**
	 * This adds a property descriptor for the Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Class_container_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Class_container_feature", "_UI_Class_type"),
						MetamodelPackage.Literals.CLASS__CONTAINER,
						true,
						false,
						true,
						null,
						null,
						null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MetamodelPackage.Literals.CLASS__REFERENCES);
			childrenFeatures.add(MetamodelPackage.Literals.CLASS__ATTRIBUTES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Class.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Class"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc -->
	 * The label of the class is composed of its name and the 
	 * name of the associated eClass.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((pamtram.metamodel.Class)object).getName();
		EClass eClass = ((pamtram.metamodel.Class)object).getEClass();

		StyledString styledLabel = new StyledString();

		if (label != null && label.length() > 0) {
			styledLabel.append(label); 
		} 

		if(eClass != null && eClass.getEPackage() != null) {
			styledLabel.append(styledLabel.toString().equals("") ?
					"(" + eClass.getEPackage().getNsPrefix() + "::" + eClass.getName() + ")" :
						" (" + eClass.getEPackage().getNsPrefix() + "::" + eClass.getName() + ")", StyledString.Style.QUALIFIER_STYLER);
		}

		return styledLabel;

	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(pamtram.metamodel.Class.class)) {
		case MetamodelPackage.CLASS__CARDINALITY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case MetamodelPackage.CLASS__REFERENCES:
		case MetamodelPackage.CLASS__ATTRIBUTES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.CLASS__REFERENCES,
						MetamodelFactory.eINSTANCE.createTargetSectionContainmentReference()));

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.CLASS__REFERENCES,
						MetamodelFactory.eINSTANCE.createTargetSectionNonContainmentReference()));

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.CLASS__REFERENCES,
						MetamodelFactory.eINSTANCE.createSourceSectionContainmentReference()));

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.CLASS__REFERENCES,
						MetamodelFactory.eINSTANCE.createMetaModelSectionReference()));

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.CLASS__ATTRIBUTES,
						MetamodelFactory.eINSTANCE.createSourceSectionAttribute()));

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.CLASS__ATTRIBUTES,
						MetamodelFactory.eINSTANCE.createActualAttribute()));

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.CLASS__ATTRIBUTES,
						MetamodelFactory.eINSTANCE.createVirtualAttribute()));
	}

}
