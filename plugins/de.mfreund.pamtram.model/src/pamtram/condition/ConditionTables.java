/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   /de.mfreund.pamtram.model/model/pamtram.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package pamtram.condition;

import java.lang.String;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.condition.ConditionPackage;
import pamtram.condition.ConditionTables;
import pamtram.metamodel.MetamodelPackage;

/**
 * ConditionTables provides the dispatch tables for the condition for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class ConditionTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final /*@NonNull*/ EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(ConditionPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final /*@NonNull*/ ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, PamtramPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/condition", null, ConditionPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/metamodel", null, MetamodelPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AttributeValueConstraint = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("AttributeValueConstraint", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ComplexCondition = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("ComplexCondition", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ConditionModel = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("ConditionModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ConditionalElement = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("ConditionalElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_InstancePointer = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("InstancePointer", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MultipleConditionOperator = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("MultipleConditionOperator", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Not = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("Not", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SingleConditionOperator = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("SingleConditionOperator", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SourceSectionAttribute = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionAttribute", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SourceSectionClass = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionClass", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ DataTypeId DATAid_EInt = ConditionTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ EnumerationId ENUMid_ComparatorEnum = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getEnumerationId("ComparatorEnum");
    public static final /*@NonNull*/ /*@NonInvalid*/ EnumerationId ENUMid_CondSettingEnum = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getEnumerationId("CondSettingEnum");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_4 = ValueUtil.integerValueOf("4");
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_MultipleConditionOperator_c_c_minimalNumberOfArgs = "MultipleConditionOperator::minimalNumberOfArgs";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Not_c_c_referenceOnlyConditionsFromConditionModelOrFromConditionalE = "Not::referenceOnlyConditionsFromConditionModelOrFromConditionalElements";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Reference_32_only_32_Conditions_32_that_32_placed_32_inside_32_ConditionModel_32_or_32_w = "Reference only Conditions that placed inside ConditionModel or where the Container is Kind of ConditionalElement!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_SingleConditionOperator_c_c_exactlyOneArg = "SingleConditionOperator::exactlyOneArg";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_required_32_subparts_32_of_32_this_32_Not_m_Condition_32_are_32_not_32_modeled_32_or_32_n = "The required subparts of this Not-Condition are not modeled or not referenced or both done but not allowed!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_required_32_subparts_32_of_32_this_32_condition_32_are_32_not_32_modeled_32_or_32_not_32_r = "The required subparts of this condition are not modeled or not referenced !";
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_ConditionalElement = TypeId.BAG.getSpecializedId(ConditionTables.CLSSid_ConditionalElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_MultipleConditionOperator = TypeId.BAG.getSpecializedId(ConditionTables.CLSSid_MultipleConditionOperator);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_SingleConditionOperator = TypeId.BAG.getSpecializedId(ConditionTables.CLSSid_SingleConditionOperator);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_AttributeValueConstraint = TypeId.ORDERED_SET.getSpecializedId(ConditionTables.CLSSid_AttributeValueConstraint);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ComplexCondition = TypeId.ORDERED_SET.getSpecializedId(ConditionTables.CLSSid_ComplexCondition);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_InstancePointer = TypeId.ORDERED_SET.getSpecializedId(ConditionTables.CLSSid_InstancePointer);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ComplexCondition = TypeId.SET.getSpecializedId(ConditionTables.CLSSid_ComplexCondition);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			ConditionTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final /*@NonNull*/ EcoreExecutorType _And = new EcoreExecutorType(ConditionPackage.Literals.AND, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeCondition = new EcoreExecutorType(ConditionPackage.Literals.ATTRIBUTE_CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _ComparatorEnum = new EcoreExecutorEnumeration(ConditionPackage.Literals.COMPARATOR_ENUM, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ComplexCondition = new EcoreExecutorType(ConditionPackage.Literals.COMPLEX_CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _CondSettingEnum = new EcoreExecutorEnumeration(ConditionPackage.Literals.COND_SETTING_ENUM, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Condition = new EcoreExecutorType(ConditionPackage.Literals.CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MultipleConditionOperator = new EcoreExecutorType(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Not = new EcoreExecutorType(ConditionPackage.Literals.NOT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Or = new EcoreExecutorType(ConditionPackage.Literals.OR, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SectionCondition = new EcoreExecutorType(ConditionPackage.Literals.SECTION_CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SingleConditionOperator = new EcoreExecutorType(ConditionPackage.Literals.SINGLE_CONDITION_OPERATOR, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType[] types = {
			_And,
			_AttributeCondition,
			_ComparatorEnum,
			_ComplexCondition,
			_CondSettingEnum,
			_Condition,
			_MultipleConditionOperator,
			_Not,
			_Or,
			_SectionCondition,
			_SingleConditionOperator
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final /*@NonNull*/ ExecutorFragment _And__And = new ExecutorFragment(Types._And, ConditionTables.Types._And);
		private static final /*@NonNull*/ ExecutorFragment _And__ComplexCondition = new ExecutorFragment(Types._And, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _And__MultipleConditionOperator = new ExecutorFragment(Types._And, ConditionTables.Types._MultipleConditionOperator);
		private static final /*@NonNull*/ ExecutorFragment _And__NamedElement = new ExecutorFragment(Types._And, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _And__OclAny = new ExecutorFragment(Types._And, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _And__OclElement = new ExecutorFragment(Types._And, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__AttributeCondition = new ExecutorFragment(Types._AttributeCondition, ConditionTables.Types._AttributeCondition);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__ComplexCondition = new ExecutorFragment(Types._AttributeCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__Condition = new ExecutorFragment(Types._AttributeCondition, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__NamedElement = new ExecutorFragment(Types._AttributeCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__OclAny = new ExecutorFragment(Types._AttributeCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__OclElement = new ExecutorFragment(Types._AttributeCondition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Class = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__ComparatorEnum = new ExecutorFragment(Types._ComparatorEnum, ConditionTables.Types._ComparatorEnum);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__DataType = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._DataType);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Element = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Element);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Enumeration = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Enumeration);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Nameable = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Nameable);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__NamedElement_1 = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Namespace = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Namespace);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclAny = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclElement = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclType = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclType);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__TemplateableElement = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._TemplateableElement);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Type = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Type);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Visitable = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Visitable);

		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__ComplexCondition = new ExecutorFragment(Types._ComplexCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__NamedElement = new ExecutorFragment(Types._ComplexCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__OclAny = new ExecutorFragment(Types._ComplexCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__OclElement = new ExecutorFragment(Types._ComplexCondition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__Class = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__CondSettingEnum = new ExecutorFragment(Types._CondSettingEnum, ConditionTables.Types._CondSettingEnum);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__DataType = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._DataType);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__Element = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._Element);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__Enumeration = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._Enumeration);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__Nameable = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._Nameable);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__NamedElement_1 = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__Namespace = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._Namespace);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__OclAny = new ExecutorFragment(Types._CondSettingEnum, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__OclElement = new ExecutorFragment(Types._CondSettingEnum, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__OclType = new ExecutorFragment(Types._CondSettingEnum, OCLstdlibTables.Types._OclType);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__TemplateableElement = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._TemplateableElement);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__Type = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._Type);
		private static final /*@NonNull*/ ExecutorFragment _CondSettingEnum__Visitable = new ExecutorFragment(Types._CondSettingEnum, PivotTables.Types._Visitable);

		private static final /*@NonNull*/ ExecutorFragment _Condition__ComplexCondition = new ExecutorFragment(Types._Condition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Condition__Condition = new ExecutorFragment(Types._Condition, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _Condition__NamedElement = new ExecutorFragment(Types._Condition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Condition__OclAny = new ExecutorFragment(Types._Condition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Condition__OclElement = new ExecutorFragment(Types._Condition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MultipleConditionOperator__ComplexCondition = new ExecutorFragment(Types._MultipleConditionOperator, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _MultipleConditionOperator__MultipleConditionOperator = new ExecutorFragment(Types._MultipleConditionOperator, ConditionTables.Types._MultipleConditionOperator);
		private static final /*@NonNull*/ ExecutorFragment _MultipleConditionOperator__NamedElement = new ExecutorFragment(Types._MultipleConditionOperator, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MultipleConditionOperator__OclAny = new ExecutorFragment(Types._MultipleConditionOperator, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MultipleConditionOperator__OclElement = new ExecutorFragment(Types._MultipleConditionOperator, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Not__ComplexCondition = new ExecutorFragment(Types._Not, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Not__NamedElement = new ExecutorFragment(Types._Not, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Not__Not = new ExecutorFragment(Types._Not, ConditionTables.Types._Not);
		private static final /*@NonNull*/ ExecutorFragment _Not__OclAny = new ExecutorFragment(Types._Not, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Not__OclElement = new ExecutorFragment(Types._Not, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Not__SingleConditionOperator = new ExecutorFragment(Types._Not, ConditionTables.Types._SingleConditionOperator);

		private static final /*@NonNull*/ ExecutorFragment _Or__ComplexCondition = new ExecutorFragment(Types._Or, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Or__MultipleConditionOperator = new ExecutorFragment(Types._Or, ConditionTables.Types._MultipleConditionOperator);
		private static final /*@NonNull*/ ExecutorFragment _Or__NamedElement = new ExecutorFragment(Types._Or, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Or__OclAny = new ExecutorFragment(Types._Or, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Or__OclElement = new ExecutorFragment(Types._Or, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Or__Or = new ExecutorFragment(Types._Or, ConditionTables.Types._Or);

		private static final /*@NonNull*/ ExecutorFragment _SectionCondition__ComplexCondition = new ExecutorFragment(Types._SectionCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _SectionCondition__Condition = new ExecutorFragment(Types._SectionCondition, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _SectionCondition__NamedElement = new ExecutorFragment(Types._SectionCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SectionCondition__OclAny = new ExecutorFragment(Types._SectionCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SectionCondition__OclElement = new ExecutorFragment(Types._SectionCondition, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SectionCondition__SectionCondition = new ExecutorFragment(Types._SectionCondition, ConditionTables.Types._SectionCondition);

		private static final /*@NonNull*/ ExecutorFragment _SingleConditionOperator__ComplexCondition = new ExecutorFragment(Types._SingleConditionOperator, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _SingleConditionOperator__NamedElement = new ExecutorFragment(Types._SingleConditionOperator, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SingleConditionOperator__OclAny = new ExecutorFragment(Types._SingleConditionOperator, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SingleConditionOperator__OclElement = new ExecutorFragment(Types._SingleConditionOperator, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SingleConditionOperator__SingleConditionOperator = new ExecutorFragment(Types._SingleConditionOperator, ConditionTables.Types._SingleConditionOperator);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		public static final /*@NonNull*/ ParameterTypes _ = TypeUtil.createParameterTypes();
		public static final /*@NonNull*/ ParameterTypes _ComplexCondition = TypeUtil.createParameterTypes(ConditionTables.Types._ComplexCondition);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		public static final /*@NonNull*/ ExecutorOperation _Condition__checkCondition = new ExecutorOperation("checkCondition", Parameters._ComplexCondition, Types._Condition,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _MultipleConditionOperator__referencesOnlyValidConditions = new ExecutorOperation("referencesOnlyValidConditions", Parameters._, Types._MultipleConditionOperator,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _Not__referencesOnlyValidConditions = new ExecutorOperation("referencesOnlyValidConditions", Parameters._, Types._Not,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}


		public static final /*@NonNull*/ ExecutorProperty _AttributeCondition__conditionAttributeRef = new EcoreExecutorProperty(ConditionPackage.Literals.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF, Types._AttributeCondition, 0);
		public static final /*@NonNull*/ ExecutorProperty _AttributeCondition__valueConstraint = new EcoreExecutorProperty(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT, Types._AttributeCondition, 1);

		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__MultipleConditionOperator__condParts = new ExecutorPropertyWithImplementation("MultipleConditionOperator", Types._ComplexCondition, 0, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__MultipleConditionOperator__condPartsRef = new ExecutorPropertyWithImplementation("MultipleConditionOperator", Types._ComplexCondition, 1, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__SingleConditionOperator__condPart = new ExecutorPropertyWithImplementation("SingleConditionOperator", Types._ComplexCondition, 2, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.SINGLE_CONDITION_OPERATOR__COND_PART));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__SingleConditionOperator__condPartRef = new ExecutorPropertyWithImplementation("SingleConditionOperator", Types._ComplexCondition, 3, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.SINGLE_CONDITION_OPERATOR__COND_PART_REF));

		public static final /*@NonNull*/ ExecutorProperty _Condition__additionalConditionSpecification = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION, Types._Condition, 0);
		public static final /*@NonNull*/ ExecutorProperty _Condition__comparator = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__COMPARATOR, Types._Condition, 1);
		public static final /*@NonNull*/ ExecutorProperty _Condition__defaultSetting = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__DEFAULT_SETTING, Types._Condition, 2);
		public static final /*@NonNull*/ ExecutorProperty _Condition__value = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__VALUE, Types._Condition, 3);

		public static final /*@NonNull*/ ExecutorProperty _MultipleConditionOperator__condParts = new EcoreExecutorProperty(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS, Types._MultipleConditionOperator, 0);
		public static final /*@NonNull*/ ExecutorProperty _MultipleConditionOperator__condPartsRef = new EcoreExecutorProperty(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF, Types._MultipleConditionOperator, 1);

		public static final /*@NonNull*/ ExecutorProperty _SectionCondition__conditionSectionRef = new EcoreExecutorProperty(ConditionPackage.Literals.SECTION_CONDITION__CONDITION_SECTION_REF, Types._SectionCondition, 0);

		public static final /*@NonNull*/ ExecutorProperty _SingleConditionOperator__condPart = new EcoreExecutorProperty(ConditionPackage.Literals.SINGLE_CONDITION_OPERATOR__COND_PART, Types._SingleConditionOperator, 0);
		public static final /*@NonNull*/ ExecutorProperty _SingleConditionOperator__condPartRef = new EcoreExecutorProperty(ConditionPackage.Literals.SINGLE_CONDITION_OPERATOR__COND_PART_REF, Types._SingleConditionOperator, 1);
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final /*@NonNull*/ ExecutorFragment[] _And =
		{
			Fragments._And__OclAny /* 0 */,
			Fragments._And__OclElement /* 1 */,
			Fragments._And__NamedElement /* 2 */,
			Fragments._And__ComplexCondition /* 3 */,
			Fragments._And__MultipleConditionOperator /* 4 */,
			Fragments._And__And /* 5 */
		};
		private static final /*@NonNull*/ int[] __And = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _AttributeCondition =
		{
			Fragments._AttributeCondition__OclAny /* 0 */,
			Fragments._AttributeCondition__OclElement /* 1 */,
			Fragments._AttributeCondition__NamedElement /* 2 */,
			Fragments._AttributeCondition__ComplexCondition /* 3 */,
			Fragments._AttributeCondition__Condition /* 4 */,
			Fragments._AttributeCondition__AttributeCondition /* 5 */
		};
		private static final /*@NonNull*/ int[] __AttributeCondition = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _ComparatorEnum =
		{
			Fragments._ComparatorEnum__OclAny /* 0 */,
			Fragments._ComparatorEnum__OclElement /* 1 */,
			Fragments._ComparatorEnum__Nameable /* 2 */,
			Fragments._ComparatorEnum__OclType /* 2 */,
			Fragments._ComparatorEnum__Visitable /* 2 */,
			Fragments._ComparatorEnum__Element /* 3 */,
			Fragments._ComparatorEnum__NamedElement_1 /* 4 */,
			Fragments._ComparatorEnum__TemplateableElement /* 4 */,
			Fragments._ComparatorEnum__Namespace /* 5 */,
			Fragments._ComparatorEnum__Type /* 5 */,
			Fragments._ComparatorEnum__Class /* 6 */,
			Fragments._ComparatorEnum__DataType /* 7 */,
			Fragments._ComparatorEnum__Enumeration /* 8 */,
			Fragments._ComparatorEnum__ComparatorEnum /* 9 */
		};
		private static final /*@NonNull*/ int[] __ComparatorEnum = { 1,1,3,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _ComplexCondition =
		{
			Fragments._ComplexCondition__OclAny /* 0 */,
			Fragments._ComplexCondition__OclElement /* 1 */,
			Fragments._ComplexCondition__NamedElement /* 2 */,
			Fragments._ComplexCondition__ComplexCondition /* 3 */
		};
		private static final /*@NonNull*/ int[] __ComplexCondition = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _CondSettingEnum =
		{
			Fragments._CondSettingEnum__OclAny /* 0 */,
			Fragments._CondSettingEnum__OclElement /* 1 */,
			Fragments._CondSettingEnum__Nameable /* 2 */,
			Fragments._CondSettingEnum__OclType /* 2 */,
			Fragments._CondSettingEnum__Visitable /* 2 */,
			Fragments._CondSettingEnum__Element /* 3 */,
			Fragments._CondSettingEnum__NamedElement_1 /* 4 */,
			Fragments._CondSettingEnum__TemplateableElement /* 4 */,
			Fragments._CondSettingEnum__Namespace /* 5 */,
			Fragments._CondSettingEnum__Type /* 5 */,
			Fragments._CondSettingEnum__Class /* 6 */,
			Fragments._CondSettingEnum__DataType /* 7 */,
			Fragments._CondSettingEnum__Enumeration /* 8 */,
			Fragments._CondSettingEnum__CondSettingEnum /* 9 */
		};
		private static final /*@NonNull*/ int[] __CondSettingEnum = { 1,1,3,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Condition =
		{
			Fragments._Condition__OclAny /* 0 */,
			Fragments._Condition__OclElement /* 1 */,
			Fragments._Condition__NamedElement /* 2 */,
			Fragments._Condition__ComplexCondition /* 3 */,
			Fragments._Condition__Condition /* 4 */
		};
		private static final /*@NonNull*/ int[] __Condition = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _MultipleConditionOperator =
		{
			Fragments._MultipleConditionOperator__OclAny /* 0 */,
			Fragments._MultipleConditionOperator__OclElement /* 1 */,
			Fragments._MultipleConditionOperator__NamedElement /* 2 */,
			Fragments._MultipleConditionOperator__ComplexCondition /* 3 */,
			Fragments._MultipleConditionOperator__MultipleConditionOperator /* 4 */
		};
		private static final /*@NonNull*/ int[] __MultipleConditionOperator = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Not =
		{
			Fragments._Not__OclAny /* 0 */,
			Fragments._Not__OclElement /* 1 */,
			Fragments._Not__NamedElement /* 2 */,
			Fragments._Not__ComplexCondition /* 3 */,
			Fragments._Not__SingleConditionOperator /* 4 */,
			Fragments._Not__Not /* 5 */
		};
		private static final /*@NonNull*/ int[] __Not = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Or =
		{
			Fragments._Or__OclAny /* 0 */,
			Fragments._Or__OclElement /* 1 */,
			Fragments._Or__NamedElement /* 2 */,
			Fragments._Or__ComplexCondition /* 3 */,
			Fragments._Or__MultipleConditionOperator /* 4 */,
			Fragments._Or__Or /* 5 */
		};
		private static final /*@NonNull*/ int[] __Or = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SectionCondition =
		{
			Fragments._SectionCondition__OclAny /* 0 */,
			Fragments._SectionCondition__OclElement /* 1 */,
			Fragments._SectionCondition__NamedElement /* 2 */,
			Fragments._SectionCondition__ComplexCondition /* 3 */,
			Fragments._SectionCondition__Condition /* 4 */,
			Fragments._SectionCondition__SectionCondition /* 5 */
		};
		private static final /*@NonNull*/ int[] __SectionCondition = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SingleConditionOperator =
		{
			Fragments._SingleConditionOperator__OclAny /* 0 */,
			Fragments._SingleConditionOperator__OclElement /* 1 */,
			Fragments._SingleConditionOperator__NamedElement /* 2 */,
			Fragments._SingleConditionOperator__ComplexCondition /* 3 */,
			Fragments._SingleConditionOperator__SingleConditionOperator /* 4 */
		};
		private static final /*@NonNull*/ int[] __SingleConditionOperator = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._And.initFragments(_And, __And);
			Types._AttributeCondition.initFragments(_AttributeCondition, __AttributeCondition);
			Types._ComparatorEnum.initFragments(_ComparatorEnum, __ComparatorEnum);
			Types._ComplexCondition.initFragments(_ComplexCondition, __ComplexCondition);
			Types._CondSettingEnum.initFragments(_CondSettingEnum, __CondSettingEnum);
			Types._Condition.initFragments(_Condition, __Condition);
			Types._MultipleConditionOperator.initFragments(_MultipleConditionOperator, __MultipleConditionOperator);
			Types._Not.initFragments(_Not, __Not);
			Types._Or.initFragments(_Or, __Or);
			Types._SectionCondition.initFragments(_SectionCondition, __SectionCondition);
			Types._SingleConditionOperator.initFragments(_SingleConditionOperator, __SingleConditionOperator);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final /*@NonNull*/ ExecutorOperation[] _And__And = {};
		private static final /*@NonNull*/ ExecutorOperation[] _And__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _And__MultipleConditionOperator = {
			ConditionTables.Operations._MultipleConditionOperator__referencesOnlyValidConditions /* referencesOnlyValidConditions() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _And__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _And__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _And__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _AttributeCondition__AttributeCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeCondition__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeCondition__Condition = {
			ConditionTables.Operations._Condition__checkCondition /* checkCondition(ComplexCondition[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeCondition__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__ComparatorEnum = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__Class = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__DataType = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__Nameable = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__NamedElement_1 = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__Namespace = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__TemplateableElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__Visitable = {};

		private static final /*@NonNull*/ ExecutorOperation[] _ComplexCondition__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComplexCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ComplexCondition__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ComplexCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__CondSettingEnum = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__Class = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__DataType = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__Nameable = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__NamedElement_1 = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__Namespace = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__TemplateableElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CondSettingEnum__Visitable = {};

		private static final /*@NonNull*/ ExecutorOperation[] _Condition__Condition = {
			ConditionTables.Operations._Condition__checkCondition /* checkCondition(ComplexCondition[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Condition__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Condition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Condition__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Condition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _MultipleConditionOperator__MultipleConditionOperator = {
			ConditionTables.Operations._MultipleConditionOperator__referencesOnlyValidConditions /* referencesOnlyValidConditions() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _MultipleConditionOperator__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _MultipleConditionOperator__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _MultipleConditionOperator__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _MultipleConditionOperator__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _Not__Not = {
			ConditionTables.Operations._Not__referencesOnlyValidConditions /* referencesOnlyValidConditions() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Not__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Not__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Not__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Not__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Not__SingleConditionOperator = {};

		private static final /*@NonNull*/ ExecutorOperation[] _Or__Or = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Or__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Or__MultipleConditionOperator = {
			ConditionTables.Operations._MultipleConditionOperator__referencesOnlyValidConditions /* referencesOnlyValidConditions() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Or__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Or__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Or__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SectionCondition__SectionCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SectionCondition__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SectionCondition__Condition = {
			ConditionTables.Operations._Condition__checkCondition /* checkCondition(ComplexCondition[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SectionCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SectionCondition__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SectionCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SingleConditionOperator__SingleConditionOperator = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SingleConditionOperator__ComplexCondition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SingleConditionOperator__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SingleConditionOperator__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[?]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SingleConditionOperator__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._And__And.initOperations(_And__And);
			Fragments._And__ComplexCondition.initOperations(_And__ComplexCondition);
			Fragments._And__MultipleConditionOperator.initOperations(_And__MultipleConditionOperator);
			Fragments._And__NamedElement.initOperations(_And__NamedElement);
			Fragments._And__OclAny.initOperations(_And__OclAny);
			Fragments._And__OclElement.initOperations(_And__OclElement);

			Fragments._AttributeCondition__AttributeCondition.initOperations(_AttributeCondition__AttributeCondition);
			Fragments._AttributeCondition__ComplexCondition.initOperations(_AttributeCondition__ComplexCondition);
			Fragments._AttributeCondition__Condition.initOperations(_AttributeCondition__Condition);
			Fragments._AttributeCondition__NamedElement.initOperations(_AttributeCondition__NamedElement);
			Fragments._AttributeCondition__OclAny.initOperations(_AttributeCondition__OclAny);
			Fragments._AttributeCondition__OclElement.initOperations(_AttributeCondition__OclElement);

			Fragments._ComparatorEnum__Class.initOperations(_ComparatorEnum__Class);
			Fragments._ComparatorEnum__ComparatorEnum.initOperations(_ComparatorEnum__ComparatorEnum);
			Fragments._ComparatorEnum__DataType.initOperations(_ComparatorEnum__DataType);
			Fragments._ComparatorEnum__Element.initOperations(_ComparatorEnum__Element);
			Fragments._ComparatorEnum__Enumeration.initOperations(_ComparatorEnum__Enumeration);
			Fragments._ComparatorEnum__Nameable.initOperations(_ComparatorEnum__Nameable);
			Fragments._ComparatorEnum__NamedElement_1.initOperations(_ComparatorEnum__NamedElement_1);
			Fragments._ComparatorEnum__Namespace.initOperations(_ComparatorEnum__Namespace);
			Fragments._ComparatorEnum__OclAny.initOperations(_ComparatorEnum__OclAny);
			Fragments._ComparatorEnum__OclElement.initOperations(_ComparatorEnum__OclElement);
			Fragments._ComparatorEnum__OclType.initOperations(_ComparatorEnum__OclType);
			Fragments._ComparatorEnum__TemplateableElement.initOperations(_ComparatorEnum__TemplateableElement);
			Fragments._ComparatorEnum__Type.initOperations(_ComparatorEnum__Type);
			Fragments._ComparatorEnum__Visitable.initOperations(_ComparatorEnum__Visitable);

			Fragments._ComplexCondition__ComplexCondition.initOperations(_ComplexCondition__ComplexCondition);
			Fragments._ComplexCondition__NamedElement.initOperations(_ComplexCondition__NamedElement);
			Fragments._ComplexCondition__OclAny.initOperations(_ComplexCondition__OclAny);
			Fragments._ComplexCondition__OclElement.initOperations(_ComplexCondition__OclElement);

			Fragments._CondSettingEnum__Class.initOperations(_CondSettingEnum__Class);
			Fragments._CondSettingEnum__CondSettingEnum.initOperations(_CondSettingEnum__CondSettingEnum);
			Fragments._CondSettingEnum__DataType.initOperations(_CondSettingEnum__DataType);
			Fragments._CondSettingEnum__Element.initOperations(_CondSettingEnum__Element);
			Fragments._CondSettingEnum__Enumeration.initOperations(_CondSettingEnum__Enumeration);
			Fragments._CondSettingEnum__Nameable.initOperations(_CondSettingEnum__Nameable);
			Fragments._CondSettingEnum__NamedElement_1.initOperations(_CondSettingEnum__NamedElement_1);
			Fragments._CondSettingEnum__Namespace.initOperations(_CondSettingEnum__Namespace);
			Fragments._CondSettingEnum__OclAny.initOperations(_CondSettingEnum__OclAny);
			Fragments._CondSettingEnum__OclElement.initOperations(_CondSettingEnum__OclElement);
			Fragments._CondSettingEnum__OclType.initOperations(_CondSettingEnum__OclType);
			Fragments._CondSettingEnum__TemplateableElement.initOperations(_CondSettingEnum__TemplateableElement);
			Fragments._CondSettingEnum__Type.initOperations(_CondSettingEnum__Type);
			Fragments._CondSettingEnum__Visitable.initOperations(_CondSettingEnum__Visitable);

			Fragments._Condition__ComplexCondition.initOperations(_Condition__ComplexCondition);
			Fragments._Condition__Condition.initOperations(_Condition__Condition);
			Fragments._Condition__NamedElement.initOperations(_Condition__NamedElement);
			Fragments._Condition__OclAny.initOperations(_Condition__OclAny);
			Fragments._Condition__OclElement.initOperations(_Condition__OclElement);

			Fragments._MultipleConditionOperator__ComplexCondition.initOperations(_MultipleConditionOperator__ComplexCondition);
			Fragments._MultipleConditionOperator__MultipleConditionOperator.initOperations(_MultipleConditionOperator__MultipleConditionOperator);
			Fragments._MultipleConditionOperator__NamedElement.initOperations(_MultipleConditionOperator__NamedElement);
			Fragments._MultipleConditionOperator__OclAny.initOperations(_MultipleConditionOperator__OclAny);
			Fragments._MultipleConditionOperator__OclElement.initOperations(_MultipleConditionOperator__OclElement);

			Fragments._Not__ComplexCondition.initOperations(_Not__ComplexCondition);
			Fragments._Not__NamedElement.initOperations(_Not__NamedElement);
			Fragments._Not__Not.initOperations(_Not__Not);
			Fragments._Not__OclAny.initOperations(_Not__OclAny);
			Fragments._Not__OclElement.initOperations(_Not__OclElement);
			Fragments._Not__SingleConditionOperator.initOperations(_Not__SingleConditionOperator);

			Fragments._Or__ComplexCondition.initOperations(_Or__ComplexCondition);
			Fragments._Or__MultipleConditionOperator.initOperations(_Or__MultipleConditionOperator);
			Fragments._Or__NamedElement.initOperations(_Or__NamedElement);
			Fragments._Or__OclAny.initOperations(_Or__OclAny);
			Fragments._Or__OclElement.initOperations(_Or__OclElement);
			Fragments._Or__Or.initOperations(_Or__Or);

			Fragments._SectionCondition__ComplexCondition.initOperations(_SectionCondition__ComplexCondition);
			Fragments._SectionCondition__Condition.initOperations(_SectionCondition__Condition);
			Fragments._SectionCondition__NamedElement.initOperations(_SectionCondition__NamedElement);
			Fragments._SectionCondition__OclAny.initOperations(_SectionCondition__OclAny);
			Fragments._SectionCondition__OclElement.initOperations(_SectionCondition__OclElement);
			Fragments._SectionCondition__SectionCondition.initOperations(_SectionCondition__SectionCondition);

			Fragments._SingleConditionOperator__ComplexCondition.initOperations(_SingleConditionOperator__ComplexCondition);
			Fragments._SingleConditionOperator__NamedElement.initOperations(_SingleConditionOperator__NamedElement);
			Fragments._SingleConditionOperator__OclAny.initOperations(_SingleConditionOperator__OclAny);
			Fragments._SingleConditionOperator__OclElement.initOperations(_SingleConditionOperator__OclElement);
			Fragments._SingleConditionOperator__SingleConditionOperator.initOperations(_SingleConditionOperator__SingleConditionOperator);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final /*@NonNull*/ ExecutorProperty[] _And = {
			ConditionTables.Properties._MultipleConditionOperator__condParts,
			ConditionTables.Properties._MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _AttributeCondition = {
			ConditionTables.Properties._Condition__additionalConditionSpecification,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._AttributeCondition__conditionAttributeRef,
			ConditionTables.Properties._Condition__defaultSetting,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._AttributeCondition__valueConstraint,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _ComparatorEnum = {};

		private static final /*@NonNull*/ ExecutorProperty[] _ComplexCondition = {
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _CondSettingEnum = {};

		private static final /*@NonNull*/ ExecutorProperty[] _Condition = {
			ConditionTables.Properties._Condition__additionalConditionSpecification,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._Condition__defaultSetting,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _MultipleConditionOperator = {
			ConditionTables.Properties._MultipleConditionOperator__condParts,
			ConditionTables.Properties._MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Not = {
			ConditionTables.Properties._SingleConditionOperator__condPart,
			ConditionTables.Properties._SingleConditionOperator__condPartRef,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Or = {
			ConditionTables.Properties._MultipleConditionOperator__condParts,
			ConditionTables.Properties._MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SectionCondition = {
			ConditionTables.Properties._Condition__additionalConditionSpecification,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._SectionCondition__conditionSectionRef,
			ConditionTables.Properties._Condition__defaultSetting,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SingleConditionOperator = {
			ConditionTables.Properties._SingleConditionOperator__condPart,
			ConditionTables.Properties._SingleConditionOperator__condPartRef,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condParts,
			ConditionTables.Properties._ComplexCondition__MultipleConditionOperator__condPartsRef,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPart,
			ConditionTables.Properties._ComplexCondition__SingleConditionOperator__condPartRef
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._And__And.initProperties(_And);
			Fragments._AttributeCondition__AttributeCondition.initProperties(_AttributeCondition);
			Fragments._ComparatorEnum__ComparatorEnum.initProperties(_ComparatorEnum);
			Fragments._ComplexCondition__ComplexCondition.initProperties(_ComplexCondition);
			Fragments._CondSettingEnum__CondSettingEnum.initProperties(_CondSettingEnum);
			Fragments._Condition__Condition.initProperties(_Condition);
			Fragments._MultipleConditionOperator__MultipleConditionOperator.initProperties(_MultipleConditionOperator);
			Fragments._Not__Not.initProperties(_Not);
			Fragments._Or__Or.initProperties(_Or);
			Fragments._SectionCondition__SectionCondition.initProperties(_SectionCondition);
			Fragments._SingleConditionOperator__SingleConditionOperator.initProperties(_SingleConditionOperator);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _ComparatorEnum__EQ = new EcoreExecutorEnumerationLiteral(ConditionPackage.Literals.COMPARATOR_ENUM.getEEnumLiteral("EQ"), Types._ComparatorEnum, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _ComparatorEnum__GT = new EcoreExecutorEnumerationLiteral(ConditionPackage.Literals.COMPARATOR_ENUM.getEEnumLiteral("GT"), Types._ComparatorEnum, 1);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _ComparatorEnum__LT = new EcoreExecutorEnumerationLiteral(ConditionPackage.Literals.COMPARATOR_ENUM.getEEnumLiteral("LT"), Types._ComparatorEnum, 2);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _ComparatorEnum__GE = new EcoreExecutorEnumerationLiteral(ConditionPackage.Literals.COMPARATOR_ENUM.getEEnumLiteral("GE"), Types._ComparatorEnum, 3);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _ComparatorEnum__LE = new EcoreExecutorEnumerationLiteral(ConditionPackage.Literals.COMPARATOR_ENUM.getEEnumLiteral("LE"), Types._ComparatorEnum, 4);
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral[] _ComparatorEnum = {
			_ComparatorEnum__EQ,
			_ComparatorEnum__GT,
			_ComparatorEnum__LT,
			_ComparatorEnum__GE,
			_ComparatorEnum__LE
		};

		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CondSettingEnum__MatchingRequired = new EcoreExecutorEnumerationLiteral(ConditionPackage.Literals.COND_SETTING_ENUM.getEEnumLiteral("MatchingRequired"), Types._CondSettingEnum, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CondSettingEnum__NoMatchingAccepted = new EcoreExecutorEnumerationLiteral(ConditionPackage.Literals.COND_SETTING_ENUM.getEEnumLiteral("NoMatchingAccepted"), Types._CondSettingEnum, 1);
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral[] _CondSettingEnum = {
			_CondSettingEnum__MatchingRequired,
			_CondSettingEnum__NoMatchingAccepted
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._ComparatorEnum.initLiterals(_ComparatorEnum);
			Types._CondSettingEnum.initLiterals(_CondSettingEnum);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of ConditionTables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual cobstruction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual cobstruction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {}
}
