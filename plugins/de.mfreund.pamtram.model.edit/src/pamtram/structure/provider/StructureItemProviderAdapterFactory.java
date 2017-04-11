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
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.SourceInstanceSelector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceInstanceSelectorItemProvider sourceInstanceSelectorItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.SourceInstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSourceInstanceSelectorAdapter() {
		if (sourceInstanceSelectorItemProvider == null) {
			sourceInstanceSelectorItemProvider = new SourceInstanceSelectorItemProvider(this);
		}

		return sourceInstanceSelectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.TargetInstanceSelector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetInstanceSelectorItemProvider targetInstanceSelectorItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.TargetInstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTargetInstanceSelectorAdapter() {
		if (targetInstanceSelectorItemProvider == null) {
			targetInstanceSelectorItemProvider = new TargetInstanceSelectorItemProvider(this);
		}

		return targetInstanceSelectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.InstanceSelectorSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSelectorSourceElementItemProvider instanceSelectorSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.InstanceSelectorSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceSelectorSourceElementAdapter() {
		if (instanceSelectorSourceElementItemProvider == null) {
			instanceSelectorSourceElementItemProvider = new InstanceSelectorSourceElementItemProvider(this);
		}

		return instanceSelectorSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.InstanceSelectorExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSelectorExternalSourceElementItemProvider instanceSelectorExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.InstanceSelectorExternalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceSelectorExternalSourceElementAdapter() {
		if (instanceSelectorExternalSourceElementItemProvider == null) {
			instanceSelectorExternalSourceElementItemProvider = new InstanceSelectorExternalSourceElementItemProvider(this);
		}

		return instanceSelectorExternalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.InstanceSelectorGlobalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceSelectorGlobalSourceElementItemProvider instanceSelectorGlobalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.InstanceSelectorGlobalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceSelectorGlobalSourceElementAdapter() {
		if (instanceSelectorGlobalSourceElementItemProvider == null) {
			instanceSelectorGlobalSourceElementItemProvider = new InstanceSelectorGlobalSourceElementItemProvider(this);
		}

		return instanceSelectorGlobalSourceElementItemProvider;
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
		if (sourceInstanceSelectorItemProvider != null) sourceInstanceSelectorItemProvider.dispose();
		if (targetInstanceSelectorItemProvider != null) targetInstanceSelectorItemProvider.dispose();
		if (instanceSelectorSourceElementItemProvider != null) instanceSelectorSourceElementItemProvider.dispose();
		if (instanceSelectorExternalSourceElementItemProvider != null) instanceSelectorExternalSourceElementItemProvider.dispose();
		if (instanceSelectorGlobalSourceElementItemProvider != null) instanceSelectorGlobalSourceElementItemProvider.dispose();
	}

}