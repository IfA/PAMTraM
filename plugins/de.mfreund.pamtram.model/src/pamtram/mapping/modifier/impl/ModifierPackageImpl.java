/**
 */
package pamtram.mapping.modifier.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pamtram.PamtramPackage;

import pamtram.condition.ConditionPackage;

import pamtram.condition.impl.ConditionPackageImpl;

import pamtram.impl.PamtramPackageImpl;

import pamtram.mapping.MappingPackage;

import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.impl.ExtendedPackageImpl;
import pamtram.mapping.impl.MappingPackageImpl;

import pamtram.mapping.modifier.ExpressionModifier;
import pamtram.mapping.modifier.ToLowerCaseConverter;
import pamtram.mapping.modifier.ToUpperCaseConverter;
import pamtram.mapping.modifier.ModifierFactory;
import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.NumericModifier;
import pamtram.mapping.modifier.StringAppender;
import pamtram.mapping.modifier.StringModifier;
import pamtram.mapping.modifier.StringPrepender;
import pamtram.mapping.modifier.SubstringReplacer;
import pamtram.mapping.modifier.UniqueNumberAppender;
import pamtram.mapping.modifier.ValueModifier;
import pamtram.mapping.modifier.ValueModifierSet;

import pamtram.structure.StructurePackage;

import pamtram.structure.constraint.ConstraintPackage;

import pamtram.structure.constraint.impl.ConstraintPackageImpl;

import pamtram.structure.generic.GenericPackage;

import pamtram.structure.generic.impl.GenericPackageImpl;

import pamtram.structure.impl.StructurePackageImpl;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.library.impl.LibraryPackageImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.impl.SourcePackageImpl;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.impl.TargetPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifierPackageImpl extends EPackageImpl implements ModifierPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueModifierSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass substringReplacerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringAppenderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueNumberAppenderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringPrependerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toLowerCaseConverterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toUpperCaseConverterEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see pamtram.mapping.modifier.ModifierPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModifierPackageImpl() {
		super(eNS_URI, ModifierFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModifierPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModifierPackage init() {
		if (isInited) return (ModifierPackage)EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI);

		// Obtain or create and register package
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModifierPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) : GenericPackage.eINSTANCE);
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) : ConstraintPackage.eINSTANCE);
		SourcePackageImpl theSourcePackage = (SourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) instanceof SourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) : SourcePackage.eINSTANCE);
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) : TargetPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		theModifierPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		theModifierPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theExtendedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModifierPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModifierPackage.eNS_URI, theModifierPackage);
		return theModifierPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueModifierSet() {
		return valueModifierSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueModifierSet_Modifiers() {
		return (EReference)valueModifierSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueModifier() {
		return valueModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getValueModifier__ModifyValue__String() {
		return valueModifierEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubstringReplacer() {
		return substringReplacerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubstringReplacer_Regex() {
		return (EAttribute)substringReplacerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubstringReplacer_Replacement() {
		return (EAttribute)substringReplacerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringAppender() {
		return stringAppenderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringAppender_String() {
		return (EAttribute)stringAppenderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueNumberAppender() {
		return uniqueNumberAppenderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericModifier() {
		return numericModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionModifier() {
		return expressionModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringModifier() {
		return stringModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringPrepender() {
		return stringPrependerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringPrepender_String() {
		return (EAttribute)stringPrependerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToLowerCaseConverter() {
		return toLowerCaseConverterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToLowerCaseConverter_Regex() {
		return (EAttribute)toLowerCaseConverterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToUpperCaseConverter() {
		return toUpperCaseConverterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToUpperCaseConverter_Regex() {
		return (EAttribute)toUpperCaseConverterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierFactory getModifierFactory() {
		return (ModifierFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		valueModifierSetEClass = createEClass(VALUE_MODIFIER_SET);
		createEReference(valueModifierSetEClass, VALUE_MODIFIER_SET__MODIFIERS);

		valueModifierEClass = createEClass(VALUE_MODIFIER);
		createEOperation(valueModifierEClass, VALUE_MODIFIER___MODIFY_VALUE__STRING);

		uniqueNumberAppenderEClass = createEClass(UNIQUE_NUMBER_APPENDER);

		numericModifierEClass = createEClass(NUMERIC_MODIFIER);

		expressionModifierEClass = createEClass(EXPRESSION_MODIFIER);

		stringModifierEClass = createEClass(STRING_MODIFIER);

		substringReplacerEClass = createEClass(SUBSTRING_REPLACER);
		createEAttribute(substringReplacerEClass, SUBSTRING_REPLACER__REGEX);
		createEAttribute(substringReplacerEClass, SUBSTRING_REPLACER__REPLACEMENT);

		stringAppenderEClass = createEClass(STRING_APPENDER);
		createEAttribute(stringAppenderEClass, STRING_APPENDER__STRING);

		stringPrependerEClass = createEClass(STRING_PREPENDER);
		createEAttribute(stringPrependerEClass, STRING_PREPENDER__STRING);

		toLowerCaseConverterEClass = createEClass(TO_LOWER_CASE_CONVERTER);
		createEAttribute(toLowerCaseConverterEClass, TO_LOWER_CASE_CONVERTER__REGEX);

		toUpperCaseConverterEClass = createEClass(TO_UPPER_CASE_CONVERTER);
		createEAttribute(toUpperCaseConverterEClass, TO_UPPER_CASE_CONVERTER__REGEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		valueModifierSetEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		valueModifierEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		uniqueNumberAppenderEClass.getESuperTypes().add(this.getValueModifier());
		numericModifierEClass.getESuperTypes().add(this.getValueModifier());
		expressionModifierEClass.getESuperTypes().add(this.getNumericModifier());
		expressionModifierEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		stringModifierEClass.getESuperTypes().add(this.getValueModifier());
		substringReplacerEClass.getESuperTypes().add(this.getStringModifier());
		stringAppenderEClass.getESuperTypes().add(this.getStringModifier());
		stringPrependerEClass.getESuperTypes().add(this.getStringModifier());
		toLowerCaseConverterEClass.getESuperTypes().add(this.getStringModifier());
		toUpperCaseConverterEClass.getESuperTypes().add(this.getStringModifier());

		// Initialize classes, features, and operations; add parameters
		initEClass(valueModifierSetEClass, ValueModifierSet.class, "ValueModifierSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueModifierSet_Modifiers(), this.getValueModifier(), null, "modifiers", null, 0, -1, ValueModifierSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueModifierEClass, ValueModifier.class, "ValueModifier", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getValueModifier__ModifyValue__String(), ecorePackage.getEString(), "modifyValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(uniqueNumberAppenderEClass, UniqueNumberAppender.class, "UniqueNumberAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericModifierEClass, NumericModifier.class, "NumericModifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionModifierEClass, ExpressionModifier.class, "ExpressionModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringModifierEClass, StringModifier.class, "StringModifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(substringReplacerEClass, SubstringReplacer.class, "SubstringReplacer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubstringReplacer_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, SubstringReplacer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubstringReplacer_Replacement(), ecorePackage.getEString(), "replacement", null, 1, 1, SubstringReplacer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringAppenderEClass, StringAppender.class, "StringAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringAppender_String(), ecorePackage.getEString(), "string", "", 1, 1, StringAppender.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringPrependerEClass, StringPrepender.class, "StringPrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringPrepender_String(), ecorePackage.getEString(), "string", "", 1, 1, StringPrepender.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toLowerCaseConverterEClass, ToLowerCaseConverter.class, "ToLowerCaseConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToLowerCaseConverter_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, ToLowerCaseConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toUpperCaseConverterEClass, ToUpperCaseConverter.class, "ToUpperCaseConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToUpperCaseConverter_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, ToUpperCaseConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "This package contains elements related to the modification of values (e.g. determined values for a TargetSection attribute). "
		   });	
		addAnnotation
		  (valueModifierSetEClass, 
		   source, 
		   new String[] {
			 "documentation", "A reusable set of ValueModifiers that can be attached to a ModifiableElement in order to modify its \'value\'.\r\n<br /><br />\r\nFor example, when attached this to an AttributeMapping, the value resulting from evaluating the AttributeMapping is modified by applying the specified ValueModifers before setting the value of the associated TargetSectionAttribute."
		   });	
		addAnnotation
		  (getValueModifierSet_Modifiers(), 
		   source, 
		   new String[] {
			 "documentation", "The set of ValueModifiers that will be used to modify the \'value\'."
		   });	
		addAnnotation
		  (valueModifierEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common super-type of all elements that will modify a \'value\'."
		   });	
		addAnnotation
		  (uniqueNumberAppenderEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueModifier will add a unique number to the \'value\'.\r\n<br />\r\nIt can be used to ensure unique values e.g. when setting values of a TargetSectionAttribute."
		   });	
		addAnnotation
		  (numericModifierEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common super-type of all elements that will modify a numeric \'value\'."
		   });	
		addAnnotation
		  (expressionModifierEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueModifier will modify the (numeric) \'value\' by applying the given \'expression\'.\r\n<br /><br />\r\nNote: The \'value\' to be modfied can be referenced in the \'expression\' via the variable \'x\'. For example, a valid expression to duplicate the given value would be \"2*x\"."
		   });	
		addAnnotation
		  (stringModifierEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common super-type of all elements that will modify a String-based \'value\'."
		   });	
		addAnnotation
		  (substringReplacerEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueModifier will modify the (String-based) \'value\' by replacing the sub-string identified by the given \'regex\' by the given \'replacement\'."
		   });	
		addAnnotation
		  (getSubstringReplacer_Regex(), 
		   source, 
		   new String[] {
			 "documentation", "The regular expression identifying the string to be replaced."
		   });	
		addAnnotation
		  (getSubstringReplacer_Replacement(), 
		   source, 
		   new String[] {
			 "documentation", "The replacement."
		   });	
		addAnnotation
		  (stringAppenderEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueModifier will modify the (String-based) \'value\' by appending the given \'string\'."
		   });	
		addAnnotation
		  (getStringAppender_String(), 
		   source, 
		   new String[] {
			 "documentation", "The String to be appended."
		   });	
		addAnnotation
		  (stringPrependerEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueModifier will modify the (String-based) \'value\' by prepending the given \'string\'."
		   });	
		addAnnotation
		  (getStringPrepender_String(), 
		   source, 
		   new String[] {
			 "documentation", "The String to be prepended."
		   });	
		addAnnotation
		  (toLowerCaseConverterEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueModifier will modify the (String-based) \'value\' by converting the sub-string identified by the given \'regex\' to lower case."
		   });	
		addAnnotation
		  (getToLowerCaseConverter_Regex(), 
		   source, 
		   new String[] {
			 "documentation", "The regular expression identifying the string to be converted."
		   });	
		addAnnotation
		  (toUpperCaseConverterEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueModifier will modify the (String-based) \'value\' by converting the sub-string identified by the given \'regex\' to upper case."
		   });	
		addAnnotation
		  (getToUpperCaseConverter_Regex(), 
		   source, 
		   new String[] {
			 "documentation", "The regular expression identifying the string to be converted."
		   });
	}

} //ModifierPackageImpl
