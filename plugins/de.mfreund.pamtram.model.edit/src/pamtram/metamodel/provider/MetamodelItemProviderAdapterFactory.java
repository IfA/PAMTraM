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
	public MetamodelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IItemStyledLabelProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.SourceSection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionItemProvider sourceSectionItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.SourceSection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSourceSectionAdapter() {
		if (sourceSectionItemProvider == null) {
			sourceSectionItemProvider = new SourceSectionItemProvider(this);
		}

		return sourceSectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.TargetSection} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionItemProvider targetSectionItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.TargetSection}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.FileAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileAttributeItemProvider fileAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.FileAttribute}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.AttributeParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeParameterItemProvider attributeParameterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.AttributeParameter}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.ContainerParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerParameterItemProvider containerParameterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.ContainerParameter}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.ExternalReferenceParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalReferenceParameterItemProvider externalReferenceParameterItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.ExternalReferenceParameter}.
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
	 * This creates an adapter for a {@link pamtram.metamodel.LibraryEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLibraryEntryAdapter() {
		return new LibraryEntryItemProvider(this);
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.TargetSectionContainmentReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionContainmentReferenceItemProvider targetSectionContainmentReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.TargetSectionContainmentReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTargetSectionContainmentReferenceAdapter() {
		if (targetSectionContainmentReferenceItemProvider == null) {
			targetSectionContainmentReferenceItemProvider = new TargetSectionContainmentReferenceItemProvider(this);
		}

		return targetSectionContainmentReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.TargetSectionNonContainmentReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetSectionNonContainmentReferenceItemProvider targetSectionNonContainmentReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.TargetSectionNonContainmentReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTargetSectionNonContainmentReferenceAdapter() {
		if (targetSectionNonContainmentReferenceItemProvider == null) {
			targetSectionNonContainmentReferenceItemProvider = new TargetSectionNonContainmentReferenceItemProvider(this);
		}

		return targetSectionNonContainmentReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.SourceSectionContainmentReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionContainmentReferenceItemProvider sourceSectionContainmentReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.SourceSectionContainmentReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSourceSectionContainmentReferenceAdapter() {
		if (sourceSectionContainmentReferenceItemProvider == null) {
			sourceSectionContainmentReferenceItemProvider = new SourceSectionContainmentReferenceItemProvider(this);
		}

		return sourceSectionContainmentReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.MetaModelSectionReference} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaModelSectionReferenceItemProvider metaModelSectionReferenceItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.MetaModelSectionReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetaModelSectionReferenceAdapter() {
		if (metaModelSectionReferenceItemProvider == null) {
			metaModelSectionReferenceItemProvider = new MetaModelSectionReferenceItemProvider(this);
		}

		return metaModelSectionReferenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.SourceSectionAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionAttributeItemProvider sourceSectionAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.SourceSectionAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSourceSectionAttributeAdapter() {
		if (sourceSectionAttributeItemProvider == null) {
			sourceSectionAttributeItemProvider = new SourceSectionAttributeItemProvider(this);
		}

		return sourceSectionAttributeItemProvider;
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
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.RangeConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeConstraintItemProvider rangeConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.RangeConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRangeConstraintAdapter() {
		if (rangeConstraintItemProvider == null) {
			rangeConstraintItemProvider = new RangeConstraintItemProvider(this);
		}

		return rangeConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.RangeBound} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeBoundItemProvider rangeBoundItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.RangeBound}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRangeBoundAdapter() {
		if (rangeBoundItemProvider == null) {
			rangeBoundItemProvider = new RangeBoundItemProvider(this);
		}

		return rangeBoundItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.AttributeValueConstraintSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueConstraintSourceElementItemProvider attributeValueConstraintSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.AttributeValueConstraintSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeValueConstraintSourceElementAdapter() {
		if (attributeValueConstraintSourceElementItemProvider == null) {
			attributeValueConstraintSourceElementItemProvider = new AttributeValueConstraintSourceElementItemProvider(this);
		}

		return attributeValueConstraintSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.AttributeValueConstraintExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueConstraintExternalSourceElementItemProvider attributeValueConstraintExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.AttributeValueConstraintExternalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeValueConstraintExternalSourceElementAdapter() {
		if (attributeValueConstraintExternalSourceElementItemProvider == null) {
			attributeValueConstraintExternalSourceElementItemProvider = new AttributeValueConstraintExternalSourceElementItemProvider(this);
		}

		return attributeValueConstraintExternalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.InstancePointer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerItemProvider instancePointerItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.InstancePointer}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.InstancePointerSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerSourceElementItemProvider instancePointerSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.InstancePointerSourceElement}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.metamodel.InstancePointerExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerExternalSourceElementItemProvider instancePointerExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.metamodel.InstancePointerExternalSourceElement}.
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
