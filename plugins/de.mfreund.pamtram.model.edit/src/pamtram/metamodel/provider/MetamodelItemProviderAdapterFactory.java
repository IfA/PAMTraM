/**
 */
package pamtram.metamodel.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import pamtram.metamodel.util.MetamodelAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelItemProviderAdapterFactory extends MetamodelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.SourceSectionClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionClassItemProvider sourceSectionClassItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.SourceSectionClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSourceSectionClassAdapter() {
		if (sourceSectionClassItemProvider == null) {
			sourceSectionClassItemProvider = new SourceSectionClassItemProvider(this);
		}

		return sourceSectionClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.TargetSectionClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionClassItemProvider targetSectionClassItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.TargetSectionClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTargetSectionClassAdapter() {
		if (targetSectionClassItemProvider == null) {
			targetSectionClassItemProvider = new TargetSectionClassItemProvider(this);
		}

		return targetSectionClassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.ContainmentReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainmentReferenceItemProvider containmentReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.ContainmentReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContainmentReferenceAdapter() {
		if (containmentReferenceItemProvider == null) {
			containmentReferenceItemProvider = new ContainmentReferenceItemProvider(this);
		}

		return containmentReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.NonContainmentReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonContainmentReferenceItemProvider nonContainmentReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.NonContainmentReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNonContainmentReferenceAdapter() {
		if (nonContainmentReferenceItemProvider == null) {
			nonContainmentReferenceItemProvider = new NonContainmentReferenceItemProvider(this);
		}

		return nonContainmentReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.ActualAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActualAttributeItemProvider actualAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.ActualAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActualAttributeAdapter() {
		if (actualAttributeItemProvider == null) {
			actualAttributeItemProvider = new ActualAttributeItemProvider(this);
		}

		return actualAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.VirtualAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualAttributeItemProvider virtualAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.VirtualAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVirtualAttributeAdapter() {
		if (virtualAttributeItemProvider == null) {
			virtualAttributeItemProvider = new VirtualAttributeItemProvider(this);
		}

		return virtualAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.AttributeValueSpecification} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueSpecificationItemProvider attributeValueSpecificationItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.AttributeValueSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeValueSpecificationAdapter() {
		if (attributeValueSpecificationItemProvider == null) {
			attributeValueSpecificationItemProvider = new AttributeValueSpecificationItemProvider(this);
		}

		return attributeValueSpecificationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.EqualityMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EqualityMatcherItemProvider equalityMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.EqualityMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEqualityMatcherAdapter() {
		if (equalityMatcherItemProvider == null) {
			equalityMatcherItemProvider = new EqualityMatcherItemProvider(this);
		}

		return equalityMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.SubstringMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstringMatcherItemProvider substringMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.SubstringMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubstringMatcherAdapter() {
		if (substringMatcherItemProvider == null) {
			substringMatcherItemProvider = new SubstringMatcherItemProvider(this);
		}

		return substringMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.BeginningMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BeginningMatcherItemProvider beginningMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.BeginningMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBeginningMatcherAdapter() {
		if (beginningMatcherItemProvider == null) {
			beginningMatcherItemProvider = new BeginningMatcherItemProvider(this);
		}

		return beginningMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.EndingMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndingMatcherItemProvider endingMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.EndingMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEndingMatcherAdapter() {
		if (endingMatcherItemProvider == null) {
			endingMatcherItemProvider = new EndingMatcherItemProvider(this);
		}

		return endingMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.RegExMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegExMatcherItemProvider regExMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.RegExMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRegExMatcherAdapter() {
		if (regExMatcherItemProvider == null) {
			regExMatcherItemProvider = new RegExMatcherItemProvider(this);
		}

		return regExMatcherItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (sourceSectionClassItemProvider != null) sourceSectionClassItemProvider.dispose();
		if (targetSectionClassItemProvider != null) targetSectionClassItemProvider.dispose();
		if (containmentReferenceItemProvider != null) containmentReferenceItemProvider.dispose();
		if (nonContainmentReferenceItemProvider != null) nonContainmentReferenceItemProvider.dispose();
		if (actualAttributeItemProvider != null) actualAttributeItemProvider.dispose();
		if (virtualAttributeItemProvider != null) virtualAttributeItemProvider.dispose();
		if (attributeValueSpecificationItemProvider != null) attributeValueSpecificationItemProvider.dispose();
		if (equalityMatcherItemProvider != null) equalityMatcherItemProvider.dispose();
		if (substringMatcherItemProvider != null) substringMatcherItemProvider.dispose();
		if (beginningMatcherItemProvider != null) beginningMatcherItemProvider.dispose();
		if (endingMatcherItemProvider != null) endingMatcherItemProvider.dispose();
		if (regExMatcherItemProvider != null) regExMatcherItemProvider.dispose();
	}

}
