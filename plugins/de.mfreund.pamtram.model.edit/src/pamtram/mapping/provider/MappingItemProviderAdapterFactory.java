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
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import pamtram.mapping.util.MappingAdapterFactory;

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
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.MappingInstanceSelector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingInstanceSelectorItemProvider mappingInstanceSelectorItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.MappingInstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappingInstanceSelectorAdapter() {
		if (mappingInstanceSelectorItemProvider == null) {
			mappingInstanceSelectorItemProvider = new MappingInstanceSelectorItemProvider(this);
		}

		return mappingInstanceSelectorItemProvider;
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
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.SubstringReplacer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubstringReplacerItemProvider substringReplacerItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.SubstringReplacer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubstringReplacerAdapter() {
		if (substringReplacerItemProvider == null) {
			substringReplacerItemProvider = new SubstringReplacerItemProvider(this);
		}

		return substringReplacerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.StringAppender} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringAppenderItemProvider stringAppenderItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.StringAppender}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringAppenderAdapter() {
		if (stringAppenderItemProvider == null) {
			stringAppenderItemProvider = new StringAppenderItemProvider(this);
		}

		return stringAppenderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.UniqueNumberAppender} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UniqueNumberAppenderItemProvider uniqueNumberAppenderItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.UniqueNumberAppender}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUniqueNumberAppenderAdapter() {
		if (uniqueNumberAppenderItemProvider == null) {
			uniqueNumberAppenderItemProvider = new UniqueNumberAppenderItemProvider(this);
		}

		return uniqueNumberAppenderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.StringPrepender} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringPrependerItemProvider stringPrependerItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.StringPrepender}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStringPrependerAdapter() {
		if (stringPrependerItemProvider == null) {
			stringPrependerItemProvider = new StringPrependerItemProvider(this);
		}

		return stringPrependerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.AttributeValueModifierSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeValueModifierSetItemProvider attributeValueModifierSetItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAttributeValueModifierSetAdapter() {
		if (attributeValueModifierSetItemProvider == null) {
			attributeValueModifierSetItemProvider = new AttributeValueModifierSetItemProvider(this);
		}

		return attributeValueModifierSetItemProvider;
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
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ModelConnectionHint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelConnectionHintItemProvider modelConnectionHintItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ModelConnectionHint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModelConnectionHintAdapter() {
		if (modelConnectionHintItemProvider == null) {
			modelConnectionHintItemProvider = new ModelConnectionHintItemProvider(this);
		}

		return modelConnectionHintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ConnectionHintTargetAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionHintTargetAttributeItemProvider connectionHintTargetAttributeItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ConnectionHintTargetAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConnectionHintTargetAttributeAdapter() {
		if (connectionHintTargetAttributeItemProvider == null) {
			connectionHintTargetAttributeItemProvider = new ConnectionHintTargetAttributeItemProvider(this);
		}

		return connectionHintTargetAttributeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.SimpleAttributeMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleAttributeMappingItemProvider simpleAttributeMappingItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.SimpleAttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSimpleAttributeMappingAdapter() {
		if (simpleAttributeMappingItemProvider == null) {
			simpleAttributeMappingItemProvider = new SimpleAttributeMappingItemProvider(this);
		}

		return simpleAttributeMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ComplexAttributeMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttributeMappingItemProvider complexAttributeMappingItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ComplexAttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComplexAttributeMappingAdapter() {
		if (complexAttributeMappingItemProvider == null) {
			complexAttributeMappingItemProvider = new ComplexAttributeMappingItemProvider(this);
		}

		return complexAttributeMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ComplexAttribueMappingSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttribueMappingSourceElementItemProvider complexAttribueMappingSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ComplexAttribueMappingSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComplexAttribueMappingSourceElementAdapter() {
		if (complexAttribueMappingSourceElementItemProvider == null) {
			complexAttribueMappingSourceElementItemProvider = new ComplexAttribueMappingSourceElementItemProvider(this);
		}

		return complexAttribueMappingSourceElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.CalculatorMapping} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CalculatorMappingItemProvider calculatorMappingItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.CalculatorMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCalculatorMappingAdapter() {
		if (calculatorMappingItemProvider == null) {
			calculatorMappingItemProvider = new CalculatorMappingItemProvider(this);
		}

		return calculatorMappingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ExpressionVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionVariableItemProvider expressionVariableItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ExpressionVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionVariableAdapter() {
		if (expressionVariableItemProvider == null) {
			expressionVariableItemProvider = new ExpressionVariableItemProvider(this);
		}

		return expressionVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ComplexAttributeMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttributeMatcherItemProvider complexAttributeMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ComplexAttributeMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComplexAttributeMatcherAdapter() {
		if (complexAttributeMatcherItemProvider == null) {
			complexAttributeMatcherItemProvider = new ComplexAttributeMatcherItemProvider(this);
		}

		return complexAttributeMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.SimpleAttributeMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleAttributeMatcherItemProvider simpleAttributeMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.SimpleAttributeMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSimpleAttributeMatcherAdapter() {
		if (simpleAttributeMatcherItemProvider == null) {
			simpleAttributeMatcherItemProvider = new SimpleAttributeMatcherItemProvider(this);
		}

		return simpleAttributeMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link pamtram.mapping.ComplexAttributeMatcherSourceElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexAttributeMatcherSourceElementItemProvider complexAttributeMatcherSourceElementItemProvider;

	/**
	 * This creates an adapter for a {@link pamtram.mapping.ComplexAttributeMatcherSourceElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createComplexAttributeMatcherSourceElementAdapter() {
		if (complexAttributeMatcherSourceElementItemProvider == null) {
			complexAttributeMatcherSourceElementItemProvider = new ComplexAttributeMatcherSourceElementItemProvider(this);
		}

		return complexAttributeMatcherSourceElementItemProvider;
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
		if (cardinalityMappingItemProvider != null) cardinalityMappingItemProvider.dispose();
		if (mappingInstanceSelectorItemProvider != null) mappingInstanceSelectorItemProvider.dispose();
		if (classMatcherItemProvider != null) classMatcherItemProvider.dispose();
		if (substringReplacerItemProvider != null) substringReplacerItemProvider.dispose();
		if (stringAppenderItemProvider != null) stringAppenderItemProvider.dispose();
		if (uniqueNumberAppenderItemProvider != null) uniqueNumberAppenderItemProvider.dispose();
		if (stringPrependerItemProvider != null) stringPrependerItemProvider.dispose();
		if (attributeValueModifierSetItemProvider != null) attributeValueModifierSetItemProvider.dispose();
		if (mappingHintGroupItemProvider != null) mappingHintGroupItemProvider.dispose();
		if (modelConnectionHintItemProvider != null) modelConnectionHintItemProvider.dispose();
		if (connectionHintTargetAttributeItemProvider != null) connectionHintTargetAttributeItemProvider.dispose();
		if (simpleAttributeMappingItemProvider != null) simpleAttributeMappingItemProvider.dispose();
		if (complexAttributeMappingItemProvider != null) complexAttributeMappingItemProvider.dispose();
		if (complexAttribueMappingSourceElementItemProvider != null) complexAttribueMappingSourceElementItemProvider.dispose();
		if (calculatorMappingItemProvider != null) calculatorMappingItemProvider.dispose();
		if (expressionVariableItemProvider != null) expressionVariableItemProvider.dispose();
		if (complexAttributeMatcherItemProvider != null) complexAttributeMatcherItemProvider.dispose();
		if (simpleAttributeMatcherItemProvider != null) simpleAttributeMatcherItemProvider.dispose();
		if (complexAttributeMatcherSourceElementItemProvider != null) complexAttributeMatcherSourceElementItemProvider.dispose();
	}

}
