/**
 */
package pamtram.mapping.provider;

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
import pamtram.mapping.util.MappingAdapterFactory;
import pamtram.provider.FixedValueItemProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingItemProviderAdapterFactory extends MappingAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public MappingItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IItemStyledLabelProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.Mapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingItemProvider mappingItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappingAdapter() {
		if (mappingItemProvider == null) {
			mappingItemProvider = new MappingItemProvider(this);
		}

		return mappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingItemProvider attributeMappingItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMappingAdapter() {
		if (attributeMappingItemProvider == null) {
			attributeMappingItemProvider = new AttributeMappingItemProvider(this);
		}

		return attributeMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.CardinalityMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityMappingItemProvider cardinalityMappingItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.CardinalityMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCardinalityMappingAdapter() {
		if (cardinalityMappingItemProvider == null) {
			cardinalityMappingItemProvider = new CardinalityMappingItemProvider(this);
		}

		return cardinalityMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ReferenceTargetSelector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceTargetSelectorItemProvider referenceTargetSelectorItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ReferenceTargetSelector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReferenceTargetSelectorAdapter() {
		if (referenceTargetSelectorItemProvider == null) {
			referenceTargetSelectorItemProvider = new ReferenceTargetSelectorItemProvider(this);
		}

		return referenceTargetSelectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMatcherItemProvider attributeMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMatcherAdapter() {
		if (attributeMatcherItemProvider == null) {
			attributeMatcherItemProvider = new AttributeMatcherItemProvider(this);
		}

		return attributeMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMatcherSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMatcherSourceElementItemProvider attributeMatcherSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMatcherSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMatcherSourceElementAdapter() {
		if (attributeMatcherSourceElementItemProvider == null) {
			attributeMatcherSourceElementItemProvider = new AttributeMatcherSourceElementItemProvider(this);
		}

		return attributeMatcherSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ClassMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassMatcherItemProvider classMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ClassMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createClassMatcherAdapter() {
		if (classMatcherItemProvider == null) {
			classMatcherItemProvider = new ClassMatcherItemProvider(this);
		}

		return classMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.MappingHintGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupItemProvider mappingHintGroupItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.MappingHintGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappingHintGroupAdapter() {
		if (mappingHintGroupItemProvider == null) {
			mappingHintGroupItemProvider = new MappingHintGroupItemProvider(this);
		}

		return mappingHintGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.MappingHintGroupImporter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingHintGroupImporterItemProvider mappingHintGroupImporterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.MappingHintGroupImporter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappingHintGroupImporterAdapter() {
		if (mappingHintGroupImporterItemProvider == null) {
			mappingHintGroupImporterItemProvider = new MappingHintGroupImporterItemProvider(this);
		}

		return mappingHintGroupImporterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ExportedMappingHintGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExportedMappingHintGroupItemProvider exportedMappingHintGroupItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ExportedMappingHintGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExportedMappingHintGroupAdapter() {
		if (exportedMappingHintGroupItemProvider == null) {
			exportedMappingHintGroupItemProvider = new ExportedMappingHintGroupItemProvider(this);
		}

		return exportedMappingHintGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ContainerSelector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorItemProvider containerSelectorItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ContainerSelector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContainerSelectorAdapter() {
		if (containerSelectorItemProvider == null) {
			containerSelectorItemProvider = new ContainerSelectorItemProvider(this);
		}

		return containerSelectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMappingSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingSourceElementItemProvider attributeMappingSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMappingSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMappingSourceElementAdapter() {
		if (attributeMappingSourceElementItemProvider == null) {
			attributeMappingSourceElementItemProvider = new AttributeMappingSourceElementItemProvider(this);
		}

		return attributeMappingSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ContainerSelectorSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorSourceElementItemProvider containerSelectorSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ContainerSelectorSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContainerSelectorSourceElementAdapter() {
		if (containerSelectorSourceElementItemProvider == null) {
			containerSelectorSourceElementItemProvider = new ContainerSelectorSourceElementItemProvider(this);
		}

		return containerSelectorSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ContainerSelectorTargetAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorTargetAttributeItemProvider containerSelectorTargetAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ContainerSelectorTargetAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContainerSelectorTargetAttributeAdapter() {
		if (containerSelectorTargetAttributeItemProvider == null) {
			containerSelectorTargetAttributeItemProvider = new ContainerSelectorTargetAttributeItemProvider(this);
		}

		return containerSelectorTargetAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.LocalMappedAttributeValueExpander} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocalMappedAttributeValueExpanderItemProvider localMappedAttributeValueExpanderItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.LocalMappedAttributeValueExpander}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLocalMappedAttributeValueExpanderAdapter() {
		if (localMappedAttributeValueExpanderItemProvider == null) {
			localMappedAttributeValueExpanderItemProvider = new LocalMappedAttributeValueExpanderItemProvider(this);
		}

		return localMappedAttributeValueExpanderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.MappedAttributeValuePrepender} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedAttributeValuePrependerItemProvider mappedAttributeValuePrependerItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.MappedAttributeValuePrepender}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappedAttributeValuePrependerAdapter() {
		if (mappedAttributeValuePrependerItemProvider == null) {
			mappedAttributeValuePrependerItemProvider = new MappedAttributeValuePrependerItemProvider(this);
		}

		return mappedAttributeValuePrependerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.MappedAttributeValueAppender} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedAttributeValueAppenderItemProvider mappedAttributeValueAppenderItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.MappedAttributeValueAppender}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappedAttributeValueAppenderAdapter() {
		if (mappedAttributeValueAppenderItemProvider == null) {
			mappedAttributeValueAppenderItemProvider = new MappedAttributeValueAppenderItemProvider(this);
		}

		return mappedAttributeValueAppenderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.FixedValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedValueItemProvider fixedValueItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.FixedValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFixedValueAdapter() {
		if (fixedValueItemProvider == null) {
			fixedValueItemProvider = new FixedValueItemProvider(this);
		}

		return fixedValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.GlobalAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalAttributeItemProvider globalAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.GlobalAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGlobalAttributeAdapter() {
		if (globalAttributeItemProvider == null) {
			globalAttributeItemProvider = new GlobalAttributeItemProvider(this);
		}

		return globalAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.GlobalAttributeImporter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalAttributeImporterItemProvider globalAttributeImporterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.GlobalAttributeImporter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGlobalAttributeImporterAdapter() {
		if (globalAttributeImporterItemProvider == null) {
			globalAttributeImporterItemProvider = new GlobalAttributeImporterItemProvider(this);
		}

		return globalAttributeImporterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMappingExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingExternalSourceElementItemProvider attributeMappingExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMappingExternalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMappingExternalSourceElementAdapter() {
		if (attributeMappingExternalSourceElementItemProvider == null) {
			attributeMappingExternalSourceElementItemProvider = new AttributeMappingExternalSourceElementItemProvider(this);
		}

		return attributeMappingExternalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ContainerSelectorExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorExternalSourceElementItemProvider containerSelectorExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ContainerSelectorExternalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContainerSelectorExternalSourceElementAdapter() {
		if (containerSelectorExternalSourceElementItemProvider == null) {
			containerSelectorExternalSourceElementItemProvider = new ContainerSelectorExternalSourceElementItemProvider(this);
		}

		return containerSelectorExternalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMatcherExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMatcherExternalSourceElementItemProvider attributeMatcherExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMatcherExternalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMatcherExternalSourceElementAdapter() {
		if (attributeMatcherExternalSourceElementItemProvider == null) {
			attributeMatcherExternalSourceElementItemProvider = new AttributeMatcherExternalSourceElementItemProvider(this);
		}

		return attributeMatcherExternalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ExternalMappedAttributeValuePrepender} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalMappedAttributeValuePrependerItemProvider externalMappedAttributeValuePrependerItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ExternalMappedAttributeValuePrepender}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExternalMappedAttributeValuePrependerAdapter() {
		if (externalMappedAttributeValuePrependerItemProvider == null) {
			externalMappedAttributeValuePrependerItemProvider = new ExternalMappedAttributeValuePrependerItemProvider(this);
		}

		return externalMappedAttributeValuePrependerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ExternalMappedAttributeValueAppender} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalMappedAttributeValueAppenderItemProvider externalMappedAttributeValueAppenderItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ExternalMappedAttributeValueAppender}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExternalMappedAttributeValueAppenderAdapter() {
		if (externalMappedAttributeValueAppenderItemProvider == null) {
			externalMappedAttributeValueAppenderItemProvider = new ExternalMappedAttributeValueAppenderItemProvider(this);
		}

		return externalMappedAttributeValueAppenderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMatcherGlobalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMatcherGlobalSourceElementItemProvider attributeMatcherGlobalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMatcherGlobalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMatcherGlobalSourceElementAdapter() {
		if (attributeMatcherGlobalSourceElementItemProvider == null) {
			attributeMatcherGlobalSourceElementItemProvider = new AttributeMatcherGlobalSourceElementItemProvider(this);
		}

		return attributeMatcherGlobalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeMappingGlobalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingGlobalSourceElementItemProvider attributeMappingGlobalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeMappingGlobalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeMappingGlobalSourceElementAdapter() {
		if (attributeMappingGlobalSourceElementItemProvider == null) {
			attributeMappingGlobalSourceElementItemProvider = new AttributeMappingGlobalSourceElementItemProvider(this);
		}

		return attributeMappingGlobalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ContainerSelectorGlobalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerSelectorGlobalSourceElementItemProvider containerSelectorGlobalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ContainerSelectorGlobalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createContainerSelectorGlobalSourceElementAdapter() {
		if (containerSelectorGlobalSourceElementItemProvider == null) {
			containerSelectorGlobalSourceElementItemProvider = new ContainerSelectorGlobalSourceElementItemProvider(this);
		}

		return containerSelectorGlobalSourceElementItemProvider;
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
		if (mappingItemProvider != null) mappingItemProvider.dispose();
		if (mappingHintGroupItemProvider != null) mappingHintGroupItemProvider.dispose();
		if (attributeMappingItemProvider != null) attributeMappingItemProvider.dispose();
		if (cardinalityMappingItemProvider != null) cardinalityMappingItemProvider.dispose();
		if (referenceTargetSelectorItemProvider != null) referenceTargetSelectorItemProvider.dispose();
		if (attributeMatcherItemProvider != null) attributeMatcherItemProvider.dispose();
		if (attributeMatcherSourceElementItemProvider != null) attributeMatcherSourceElementItemProvider.dispose();
		if (classMatcherItemProvider != null) classMatcherItemProvider.dispose();
		if (mappingHintGroupImporterItemProvider != null) mappingHintGroupImporterItemProvider.dispose();
		if (exportedMappingHintGroupItemProvider != null) exportedMappingHintGroupItemProvider.dispose();
		if (containerSelectorItemProvider != null) containerSelectorItemProvider.dispose();
		if (attributeMappingSourceElementItemProvider != null) attributeMappingSourceElementItemProvider.dispose();
		if (containerSelectorSourceElementItemProvider != null) containerSelectorSourceElementItemProvider.dispose();
		if (containerSelectorTargetAttributeItemProvider != null) containerSelectorTargetAttributeItemProvider.dispose();
		if (localMappedAttributeValueExpanderItemProvider != null) localMappedAttributeValueExpanderItemProvider.dispose();
		if (mappedAttributeValuePrependerItemProvider != null) mappedAttributeValuePrependerItemProvider.dispose();
		if (mappedAttributeValueAppenderItemProvider != null) mappedAttributeValueAppenderItemProvider.dispose();
		if (fixedValueItemProvider != null) fixedValueItemProvider.dispose();
		if (globalAttributeItemProvider != null) globalAttributeItemProvider.dispose();
		if (globalAttributeImporterItemProvider != null) globalAttributeImporterItemProvider.dispose();
		if (attributeMappingExternalSourceElementItemProvider != null) attributeMappingExternalSourceElementItemProvider.dispose();
		if (containerSelectorExternalSourceElementItemProvider != null) containerSelectorExternalSourceElementItemProvider.dispose();
		if (attributeMatcherExternalSourceElementItemProvider != null) attributeMatcherExternalSourceElementItemProvider.dispose();
		if (externalMappedAttributeValuePrependerItemProvider != null) externalMappedAttributeValuePrependerItemProvider.dispose();
		if (externalMappedAttributeValueAppenderItemProvider != null) externalMappedAttributeValueAppenderItemProvider.dispose();
		if (attributeMatcherGlobalSourceElementItemProvider != null) attributeMatcherGlobalSourceElementItemProvider.dispose();
		if (attributeMappingGlobalSourceElementItemProvider != null) attributeMappingGlobalSourceElementItemProvider.dispose();
		if (containerSelectorGlobalSourceElementItemProvider != null) containerSelectorGlobalSourceElementItemProvider.dispose();
	}

}
