/**
 */
package pamtram.structure.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.Disposable;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import pamtram.structure.target.provider.ActualTargetSectionAttributeItemProvider;
import pamtram.structure.target.provider.FileAttributeItemProvider;
import pamtram.structure.target.provider.TargetSectionClassItemProvider;
import pamtram.structure.target.provider.TargetSectionCompositeReferenceItemProvider;
import pamtram.structure.target.provider.TargetSectionCrossReferenceItemProvider;
import pamtram.structure.target.provider.TargetSectionItemProvider;
import pamtram.structure.target.provider.VirtualTargetSectionAttributeItemProvider;
import pamtram.structure.util.StructureAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StructureItemProviderAdapterFactory extends StructureAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	 * This keeps track of all the item providers created, so that they can be {@link #dispose disposed}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Disposable disposable = new Disposable();

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
	public StructureItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IItemStyledLabelProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.target.TargetSection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionItemProvider targetSectionItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.target.TargetSection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTargetSectionAdapter() {
		if (targetSectionItemProvider == null) {
			targetSectionItemProvider = new TargetSectionItemProvider(this);
		}

		return targetSectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.target.FileAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileAttributeItemProvider fileAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.target.FileAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFileAttributeAdapter() {
		if (fileAttributeItemProvider == null) {
			fileAttributeItemProvider = new FileAttributeItemProvider(this);
		}

		return fileAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.target.TargetSectionClass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionClassItemProvider targetSectionClassItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.target.TargetSectionClass}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.AttributeParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeParameterItemProvider attributeParameterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.AttributeParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeParameterAdapter() {
		if (attributeParameterItemProvider == null) {
			attributeParameterItemProvider = new AttributeParameterItemProvider(this);
		}

		return attributeParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.ContainerParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerParameterItemProvider containerParameterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.ContainerParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContainerParameterAdapter() {
		if (containerParameterItemProvider == null) {
			containerParameterItemProvider = new ContainerParameterItemProvider(this);
		}

		return containerParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.ExternalReferenceParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalReferenceParameterItemProvider externalReferenceParameterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.ExternalReferenceParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExternalReferenceParameterAdapter() {
		if (externalReferenceParameterItemProvider == null) {
			externalReferenceParameterItemProvider = new ExternalReferenceParameterItemProvider(this);
		}

		return externalReferenceParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.ResourceParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceParameterItemProvider resourceParameterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.ResourceParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceParameterAdapter() {
		if (resourceParameterItemProvider == null) {
			resourceParameterItemProvider = new ResourceParameterItemProvider(this);
		}

		return resourceParameterItemProvider;
	}

	/**
	 * This creates an adapter for a {@link pamtram.structure.LibraryEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLibraryEntryAdapter() {
		return new LibraryEntryItemProvider(this);
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.target.TargetSectionCompositeReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionCompositeReferenceItemProvider targetSectionCompositeReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.target.TargetSectionCompositeReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTargetSectionCompositeReferenceAdapter() {
		if (targetSectionCompositeReferenceItemProvider == null) {
			targetSectionCompositeReferenceItemProvider = new TargetSectionCompositeReferenceItemProvider(this);
		}

		return targetSectionCompositeReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.target.TargetSectionCrossReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionCrossReferenceItemProvider targetSectionCrossReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.target.TargetSectionCrossReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTargetSectionCrossReferenceAdapter() {
		if (targetSectionCrossReferenceItemProvider == null) {
			targetSectionCrossReferenceItemProvider = new TargetSectionCrossReferenceItemProvider(this);
		}

		return targetSectionCrossReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.target.ActualTargetSectionAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActualTargetSectionAttributeItemProvider actualTargetSectionAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.target.ActualTargetSectionAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActualTargetSectionAttributeAdapter() {
		if (actualTargetSectionAttributeItemProvider == null) {
			actualTargetSectionAttributeItemProvider = new ActualTargetSectionAttributeItemProvider(this);
		}

		return actualTargetSectionAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.target.VirtualTargetSectionAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualTargetSectionAttributeItemProvider virtualTargetSectionAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.target.VirtualTargetSectionAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVirtualTargetSectionAttributeAdapter() {
		if (virtualTargetSectionAttributeItemProvider == null) {
			virtualTargetSectionAttributeItemProvider = new VirtualTargetSectionAttributeItemProvider(this);
		}

		return virtualTargetSectionAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.InstancePointer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerItemProvider instancePointerItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstancePointerAdapter() {
		if (instancePointerItemProvider == null) {
			instancePointerItemProvider = new InstancePointerItemProvider(this);
		}

		return instancePointerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.InstancePointerSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerSourceElementItemProvider instancePointerSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.InstancePointerSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstancePointerSourceElementAdapter() {
		if (instancePointerSourceElementItemProvider == null) {
			instancePointerSourceElementItemProvider = new InstancePointerSourceElementItemProvider(this);
		}

		return instancePointerSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.InstancePointerExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerExternalSourceElementItemProvider instancePointerExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.InstancePointerExternalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstancePointerExternalSourceElementAdapter() {
		if (instancePointerExternalSourceElementItemProvider == null) {
			instancePointerExternalSourceElementItemProvider = new InstancePointerExternalSourceElementItemProvider(this);
		}

		return instancePointerExternalSourceElementItemProvider;
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
	 * Associates an adapter with a notifier via the base implementation, then records it to ensure it will be disposed.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void associate(Adapter adapter, Notifier target) {
		super.associate(adapter, target);
		if (adapter != null) {
			disposable.add(adapter);
		}
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
		disposable.dispose();
	}

}
