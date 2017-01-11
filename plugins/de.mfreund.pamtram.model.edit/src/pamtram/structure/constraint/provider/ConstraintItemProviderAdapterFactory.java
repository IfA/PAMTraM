/**
 */
package pamtram.structure.constraint.provider;

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

import pamtram.structure.constraint.util.ConstraintAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintItemProviderAdapterFactory extends ConstraintAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public ConstraintItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
		supportedTypes.add(IItemStyledLabelProvider.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.EqualityMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EqualityMatcherItemProvider equalityMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.EqualityMatcher}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.SubstringMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstringMatcherItemProvider substringMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.SubstringMatcher}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.BeginningMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BeginningMatcherItemProvider beginningMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.BeginningMatcher}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.EndingMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndingMatcherItemProvider endingMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.EndingMatcher}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.RegExMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegExMatcherItemProvider regExMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.RegExMatcher}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.RangeConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeConstraintItemProvider rangeConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.RangeConstraint}.
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
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.ValueConstraintSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueConstraintSourceElementItemProvider valueConstraintSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.ValueConstraintSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValueConstraintSourceElementAdapter() {
		if (valueConstraintSourceElementItemProvider == null) {
			valueConstraintSourceElementItemProvider = new ValueConstraintSourceElementItemProvider(this);
		}

		return valueConstraintSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.ValueConstraintExternalSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueConstraintExternalSourceElementItemProvider valueConstraintExternalSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.ValueConstraintExternalSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createValueConstraintExternalSourceElementAdapter() {
		if (valueConstraintExternalSourceElementItemProvider == null) {
			valueConstraintExternalSourceElementItemProvider = new ValueConstraintExternalSourceElementItemProvider(this);
		}

		return valueConstraintExternalSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.structure.constraint.RangeBound} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeBoundItemProvider rangeBoundItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.structure.constraint.RangeBound}.
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
		if (equalityMatcherItemProvider != null) equalityMatcherItemProvider.dispose();
		if (substringMatcherItemProvider != null) substringMatcherItemProvider.dispose();
		if (beginningMatcherItemProvider != null) beginningMatcherItemProvider.dispose();
		if (endingMatcherItemProvider != null) endingMatcherItemProvider.dispose();
		if (regExMatcherItemProvider != null) regExMatcherItemProvider.dispose();
		if (rangeConstraintItemProvider != null) rangeConstraintItemProvider.dispose();
		if (valueConstraintSourceElementItemProvider != null) valueConstraintSourceElementItemProvider.dispose();
		if (valueConstraintExternalSourceElementItemProvider != null) valueConstraintExternalSourceElementItemProvider.dispose();
		if (rangeBoundItemProvider != null) rangeBoundItemProvider.dispose();
	}

}
