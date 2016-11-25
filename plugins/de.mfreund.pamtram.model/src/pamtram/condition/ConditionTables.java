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

import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import pamtram.PamtramTables;
import pamtram.condition.ConditionTables;

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
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, pamtram.PamtramPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/condition", null, pamtram.condition.ConditionPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/metamodel", null, pamtram.metamodel.MetamodelPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ActualSourceSectionAttribute = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ActualSourceSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ComplexCondition = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("ComplexCondition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ConditionModel = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("ConditionModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ConditionalElement = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("ConditionalElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_InstancePointer = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("InstancePointer", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSectionClass = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionClass", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_UnaryCondition = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("UnaryCondition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ValueConstraint = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ValueConstraint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_VariadicCondition = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("VariadicCondition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.DataTypeId DATAid_EInt = pamtram.condition.ConditionTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.EnumerationId ENUMid_ComparatorEnum = pamtram.condition.ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getEnumerationId("ComparatorEnum");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_ConditionalElement = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.condition.ConditionTables.CLSSid_ConditionalElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_UnaryCondition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.condition.ConditionTables.CLSSid_UnaryCondition);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_VariadicCondition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.condition.ConditionTables.CLSSid_VariadicCondition);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ComplexCondition = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.condition.ConditionTables.CLSSid_ComplexCondition);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_InstancePointer = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.condition.ConditionTables.CLSSid_InstancePointer);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ValueConstraint = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.condition.ConditionTables.CLSSid_ValueConstraint);

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
		public static final /*@NonNull*/ EcoreExecutorType _ApplicationDependency = new EcoreExecutorType(ConditionPackage.Literals.APPLICATION_DEPENDENCY, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeCondition = new EcoreExecutorType(ConditionPackage.Literals.ATTRIBUTE_CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _CardinalityCondition = new EcoreExecutorType(ConditionPackage.Literals.CARDINALITY_CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _ComparatorEnum = new EcoreExecutorEnumeration(ConditionPackage.Literals.COMPARATOR_ENUM, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ComplexCondition = new EcoreExecutorType(ConditionPackage.Literals.COMPLEX_CONDITION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _Condition = new EcoreExecutorType(ConditionPackage.Literals.CONDITION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _Not = new EcoreExecutorType(ConditionPackage.Literals.NOT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Or = new EcoreExecutorType(ConditionPackage.Literals.OR, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _UnaryCondition = new EcoreExecutorType(ConditionPackage.Literals.UNARY_CONDITION, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _VariadicCondition = new EcoreExecutorType(ConditionPackage.Literals.VARIADIC_CONDITION, PACKAGE, 0 | ExecutorType.ABSTRACT);

		private static final /*@NonNull*/ EcoreExecutorType /*@NonNull*/ [] types = {
			_And,
			_ApplicationDependency,
			_AttributeCondition,
			_CardinalityCondition,
			_ComparatorEnum,
			_ComplexCondition,
			_Condition,
			_Not,
			_Or,
			_UnaryCondition,
			_VariadicCondition
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
		private static final /*@NonNull*/ ExecutorFragment _And__NamedElement = new ExecutorFragment(Types._And, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _And__OclAny = new ExecutorFragment(Types._And, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _And__OclElement = new ExecutorFragment(Types._And, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _And__VariadicCondition = new ExecutorFragment(Types._And, ConditionTables.Types._VariadicCondition);

		private static final /*@NonNull*/ ExecutorFragment _ApplicationDependency__ApplicationDependency = new ExecutorFragment(Types._ApplicationDependency, ConditionTables.Types._ApplicationDependency);
		private static final /*@NonNull*/ ExecutorFragment _ApplicationDependency__ComplexCondition = new ExecutorFragment(Types._ApplicationDependency, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _ApplicationDependency__Condition = new ExecutorFragment(Types._ApplicationDependency, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _ApplicationDependency__NamedElement = new ExecutorFragment(Types._ApplicationDependency, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ApplicationDependency__OclAny = new ExecutorFragment(Types._ApplicationDependency, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ApplicationDependency__OclElement = new ExecutorFragment(Types._ApplicationDependency, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__AttributeCondition = new ExecutorFragment(Types._AttributeCondition, ConditionTables.Types._AttributeCondition);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__ComplexCondition = new ExecutorFragment(Types._AttributeCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__Condition = new ExecutorFragment(Types._AttributeCondition, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__NamedElement = new ExecutorFragment(Types._AttributeCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__OclAny = new ExecutorFragment(Types._AttributeCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeCondition__OclElement = new ExecutorFragment(Types._AttributeCondition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _CardinalityCondition__CardinalityCondition = new ExecutorFragment(Types._CardinalityCondition, ConditionTables.Types._CardinalityCondition);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityCondition__ComplexCondition = new ExecutorFragment(Types._CardinalityCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityCondition__Condition = new ExecutorFragment(Types._CardinalityCondition, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityCondition__NamedElement = new ExecutorFragment(Types._CardinalityCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityCondition__OclAny = new ExecutorFragment(Types._CardinalityCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityCondition__OclElement = new ExecutorFragment(Types._CardinalityCondition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__ComparatorEnum = new ExecutorFragment(Types._ComparatorEnum, ConditionTables.Types._ComparatorEnum);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclAny = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclElement = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclEnumeration = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclEnumeration);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclType = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclType);

		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__ComplexCondition = new ExecutorFragment(Types._ComplexCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__NamedElement = new ExecutorFragment(Types._ComplexCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__OclAny = new ExecutorFragment(Types._ComplexCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__OclElement = new ExecutorFragment(Types._ComplexCondition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Condition__ComplexCondition = new ExecutorFragment(Types._Condition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Condition__Condition = new ExecutorFragment(Types._Condition, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _Condition__NamedElement = new ExecutorFragment(Types._Condition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Condition__OclAny = new ExecutorFragment(Types._Condition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Condition__OclElement = new ExecutorFragment(Types._Condition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Not__ComplexCondition = new ExecutorFragment(Types._Not, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Not__NamedElement = new ExecutorFragment(Types._Not, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Not__Not = new ExecutorFragment(Types._Not, ConditionTables.Types._Not);
		private static final /*@NonNull*/ ExecutorFragment _Not__OclAny = new ExecutorFragment(Types._Not, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Not__OclElement = new ExecutorFragment(Types._Not, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Not__UnaryCondition = new ExecutorFragment(Types._Not, ConditionTables.Types._UnaryCondition);

		private static final /*@NonNull*/ ExecutorFragment _Or__ComplexCondition = new ExecutorFragment(Types._Or, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Or__NamedElement = new ExecutorFragment(Types._Or, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Or__OclAny = new ExecutorFragment(Types._Or, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Or__OclElement = new ExecutorFragment(Types._Or, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Or__Or = new ExecutorFragment(Types._Or, ConditionTables.Types._Or);
		private static final /*@NonNull*/ ExecutorFragment _Or__VariadicCondition = new ExecutorFragment(Types._Or, ConditionTables.Types._VariadicCondition);

		private static final /*@NonNull*/ ExecutorFragment _UnaryCondition__ComplexCondition = new ExecutorFragment(Types._UnaryCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _UnaryCondition__NamedElement = new ExecutorFragment(Types._UnaryCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _UnaryCondition__OclAny = new ExecutorFragment(Types._UnaryCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _UnaryCondition__OclElement = new ExecutorFragment(Types._UnaryCondition, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _UnaryCondition__UnaryCondition = new ExecutorFragment(Types._UnaryCondition, ConditionTables.Types._UnaryCondition);

		private static final /*@NonNull*/ ExecutorFragment _VariadicCondition__ComplexCondition = new ExecutorFragment(Types._VariadicCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _VariadicCondition__NamedElement = new ExecutorFragment(Types._VariadicCondition, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _VariadicCondition__OclAny = new ExecutorFragment(Types._VariadicCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _VariadicCondition__OclElement = new ExecutorFragment(Types._VariadicCondition, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _VariadicCondition__VariadicCondition = new ExecutorFragment(Types._VariadicCondition, ConditionTables.Types._VariadicCondition);

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

		public static final /*@NonNull*/ ExecutorOperation _ComplexCondition__isConditionModelCondition = new ExecutorOperation("isConditionModelCondition", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ComplexCondition,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _ComplexCondition__isLocalCondition = new ExecutorOperation("isLocalCondition", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ComplexCondition,
			1, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _ComplexCondition__isMappingCondition = new ExecutorOperation("isMappingCondition", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ComplexCondition,
			2, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _Condition__checkCondition = new ExecutorOperation("checkCondition", Parameters._ComplexCondition, Types._Condition,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _VariadicCondition__referencesOnlyValidConditions = new ExecutorOperation("referencesOnlyValidConditions", TypeUtil.EMPTY_PARAMETER_TYPES, Types._VariadicCondition,
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


		public static final /*@NonNull*/ ExecutorProperty _ApplicationDependency__conditionalElement = new EcoreExecutorProperty(ConditionPackage.Literals.APPLICATION_DEPENDENCY__CONDITIONAL_ELEMENT, Types._ApplicationDependency, 0);

		public static final /*@NonNull*/ ExecutorProperty _AttributeCondition__conditionAttributeRef = new EcoreExecutorProperty(ConditionPackage.Literals.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF, Types._AttributeCondition, 0);
		public static final /*@NonNull*/ ExecutorProperty _AttributeCondition__valueConstraint = new EcoreExecutorProperty(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT, Types._AttributeCondition, 1);

		public static final /*@NonNull*/ ExecutorProperty _CardinalityCondition__conditionSectionRef = new EcoreExecutorProperty(ConditionPackage.Literals.CARDINALITY_CONDITION__CONDITION_SECTION_REF, Types._CardinalityCondition, 0);

		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__UnaryCondition__localCondPart = new ExecutorPropertyWithImplementation("UnaryCondition", Types._ComplexCondition, 0, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.UNARY_CONDITION__LOCAL_COND_PART));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__UnaryCondition__sharedCondPart = new ExecutorPropertyWithImplementation("UnaryCondition", Types._ComplexCondition, 1, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.UNARY_CONDITION__SHARED_COND_PART));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__VariadicCondition__localCondParts = new ExecutorPropertyWithImplementation("VariadicCondition", Types._ComplexCondition, 2, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.VARIADIC_CONDITION__LOCAL_COND_PARTS));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__VariadicCondition__sharedCondParts = new ExecutorPropertyWithImplementation("VariadicCondition", Types._ComplexCondition, 3, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.VARIADIC_CONDITION__SHARED_COND_PARTS));

		public static final /*@NonNull*/ ExecutorProperty _Condition__additionalConditionSpecification = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__ADDITIONAL_CONDITION_SPECIFICATION, Types._Condition, 0);
		public static final /*@NonNull*/ ExecutorProperty _Condition__comparator = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__COMPARATOR, Types._Condition, 1);
		public static final /*@NonNull*/ ExecutorProperty _Condition__value = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__VALUE, Types._Condition, 2);

		public static final /*@NonNull*/ ExecutorProperty _UnaryCondition__localCondPart = new EcoreExecutorProperty(ConditionPackage.Literals.UNARY_CONDITION__LOCAL_COND_PART, Types._UnaryCondition, 0);
		public static final /*@NonNull*/ ExecutorProperty _UnaryCondition__sharedCondPart = new EcoreExecutorProperty(ConditionPackage.Literals.UNARY_CONDITION__SHARED_COND_PART, Types._UnaryCondition, 1);

		public static final /*@NonNull*/ ExecutorProperty _VariadicCondition__localCondParts = new EcoreExecutorProperty(ConditionPackage.Literals.VARIADIC_CONDITION__LOCAL_COND_PARTS, Types._VariadicCondition, 0);
		public static final /*@NonNull*/ ExecutorProperty _VariadicCondition__sharedCondParts = new EcoreExecutorProperty(ConditionPackage.Literals.VARIADIC_CONDITION__SHARED_COND_PARTS, Types._VariadicCondition, 1);
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

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _And =
		{
			Fragments._And__OclAny /* 0 */,
			Fragments._And__OclElement /* 1 */,
			Fragments._And__NamedElement /* 2 */,
			Fragments._And__ComplexCondition /* 3 */,
			Fragments._And__VariadicCondition /* 4 */,
			Fragments._And__And /* 5 */
		};
		private static final int /*@NonNull*/ [] __And = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ApplicationDependency =
		{
			Fragments._ApplicationDependency__OclAny /* 0 */,
			Fragments._ApplicationDependency__OclElement /* 1 */,
			Fragments._ApplicationDependency__NamedElement /* 2 */,
			Fragments._ApplicationDependency__ComplexCondition /* 3 */,
			Fragments._ApplicationDependency__Condition /* 4 */,
			Fragments._ApplicationDependency__ApplicationDependency /* 5 */
		};
		private static final int /*@NonNull*/ [] __ApplicationDependency = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeCondition =
		{
			Fragments._AttributeCondition__OclAny /* 0 */,
			Fragments._AttributeCondition__OclElement /* 1 */,
			Fragments._AttributeCondition__NamedElement /* 2 */,
			Fragments._AttributeCondition__ComplexCondition /* 3 */,
			Fragments._AttributeCondition__Condition /* 4 */,
			Fragments._AttributeCondition__AttributeCondition /* 5 */
		};
		private static final int /*@NonNull*/ [] __AttributeCondition = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _CardinalityCondition =
		{
			Fragments._CardinalityCondition__OclAny /* 0 */,
			Fragments._CardinalityCondition__OclElement /* 1 */,
			Fragments._CardinalityCondition__NamedElement /* 2 */,
			Fragments._CardinalityCondition__ComplexCondition /* 3 */,
			Fragments._CardinalityCondition__Condition /* 4 */,
			Fragments._CardinalityCondition__CardinalityCondition /* 5 */
		};
		private static final int /*@NonNull*/ [] __CardinalityCondition = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ComparatorEnum =
		{
			Fragments._ComparatorEnum__OclAny /* 0 */,
			Fragments._ComparatorEnum__OclElement /* 1 */,
			Fragments._ComparatorEnum__OclType /* 2 */,
			Fragments._ComparatorEnum__OclEnumeration /* 3 */,
			Fragments._ComparatorEnum__ComparatorEnum /* 4 */
		};
		private static final int /*@NonNull*/ [] __ComparatorEnum = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ComplexCondition =
		{
			Fragments._ComplexCondition__OclAny /* 0 */,
			Fragments._ComplexCondition__OclElement /* 1 */,
			Fragments._ComplexCondition__NamedElement /* 2 */,
			Fragments._ComplexCondition__ComplexCondition /* 3 */
		};
		private static final int /*@NonNull*/ [] __ComplexCondition = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Condition =
		{
			Fragments._Condition__OclAny /* 0 */,
			Fragments._Condition__OclElement /* 1 */,
			Fragments._Condition__NamedElement /* 2 */,
			Fragments._Condition__ComplexCondition /* 3 */,
			Fragments._Condition__Condition /* 4 */
		};
		private static final int /*@NonNull*/ [] __Condition = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Not =
		{
			Fragments._Not__OclAny /* 0 */,
			Fragments._Not__OclElement /* 1 */,
			Fragments._Not__NamedElement /* 2 */,
			Fragments._Not__ComplexCondition /* 3 */,
			Fragments._Not__UnaryCondition /* 4 */,
			Fragments._Not__Not /* 5 */
		};
		private static final int /*@NonNull*/ [] __Not = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Or =
		{
			Fragments._Or__OclAny /* 0 */,
			Fragments._Or__OclElement /* 1 */,
			Fragments._Or__NamedElement /* 2 */,
			Fragments._Or__ComplexCondition /* 3 */,
			Fragments._Or__VariadicCondition /* 4 */,
			Fragments._Or__Or /* 5 */
		};
		private static final int /*@NonNull*/ [] __Or = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _UnaryCondition =
		{
			Fragments._UnaryCondition__OclAny /* 0 */,
			Fragments._UnaryCondition__OclElement /* 1 */,
			Fragments._UnaryCondition__NamedElement /* 2 */,
			Fragments._UnaryCondition__ComplexCondition /* 3 */,
			Fragments._UnaryCondition__UnaryCondition /* 4 */
		};
		private static final int /*@NonNull*/ [] __UnaryCondition = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _VariadicCondition =
		{
			Fragments._VariadicCondition__OclAny /* 0 */,
			Fragments._VariadicCondition__OclElement /* 1 */,
			Fragments._VariadicCondition__NamedElement /* 2 */,
			Fragments._VariadicCondition__ComplexCondition /* 3 */,
			Fragments._VariadicCondition__VariadicCondition /* 4 */
		};
		private static final int /*@NonNull*/ [] __VariadicCondition = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._And.initFragments(_And, __And);
			Types._ApplicationDependency.initFragments(_ApplicationDependency, __ApplicationDependency);
			Types._AttributeCondition.initFragments(_AttributeCondition, __AttributeCondition);
			Types._CardinalityCondition.initFragments(_CardinalityCondition, __CardinalityCondition);
			Types._ComparatorEnum.initFragments(_ComparatorEnum, __ComparatorEnum);
			Types._ComplexCondition.initFragments(_ComplexCondition, __ComplexCondition);
			Types._Condition.initFragments(_Condition, __Condition);
			Types._Not.initFragments(_Not, __Not);
			Types._Or.initFragments(_Or, __Or);
			Types._UnaryCondition.initFragments(_UnaryCondition, __UnaryCondition);
			Types._VariadicCondition.initFragments(_VariadicCondition, __VariadicCondition);

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

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _And__And = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _And__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _And__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _And__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _And__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _And__VariadicCondition = {
			ConditionTables.Operations._VariadicCondition__referencesOnlyValidConditions /* referencesOnlyValidConditions() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ApplicationDependency__ApplicationDependency = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ApplicationDependency__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ApplicationDependency__Condition = {
			ConditionTables.Operations._Condition__checkCondition /* checkCondition(ComplexCondition[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ApplicationDependency__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ApplicationDependency__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ApplicationDependency__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeCondition__AttributeCondition = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeCondition__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeCondition__Condition = {
			ConditionTables.Operations._Condition__checkCondition /* checkCondition(ComplexCondition[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeCondition__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityCondition__CardinalityCondition = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityCondition__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityCondition__Condition = {
			ConditionTables.Operations._Condition__checkCondition /* checkCondition(ComplexCondition[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityCondition__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComparatorEnum__ComparatorEnum = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComparatorEnum__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComparatorEnum__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComparatorEnum__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComparatorEnum__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComplexCondition__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComplexCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComplexCondition__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ComplexCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Condition__Condition = {
			ConditionTables.Operations._Condition__checkCondition /* checkCondition(ComplexCondition[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Condition__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Condition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Condition__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Condition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Not__Not = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Not__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Not__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Not__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Not__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Not__UnaryCondition = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Or__Or = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Or__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Or__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Or__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Or__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Or__VariadicCondition = {
			ConditionTables.Operations._VariadicCondition__referencesOnlyValidConditions /* referencesOnlyValidConditions() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UnaryCondition__UnaryCondition = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UnaryCondition__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UnaryCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UnaryCondition__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UnaryCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VariadicCondition__VariadicCondition = {
			ConditionTables.Operations._VariadicCondition__referencesOnlyValidConditions /* referencesOnlyValidConditions() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VariadicCondition__ComplexCondition = {
			ConditionTables.Operations._ComplexCondition__isConditionModelCondition /* isConditionModelCondition() */,
			ConditionTables.Operations._ComplexCondition__isLocalCondition /* isLocalCondition() */,
			ConditionTables.Operations._ComplexCondition__isMappingCondition /* isMappingCondition() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VariadicCondition__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VariadicCondition__OclAny = {
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
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VariadicCondition__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._And__And.initOperations(_And__And);
			Fragments._And__ComplexCondition.initOperations(_And__ComplexCondition);
			Fragments._And__NamedElement.initOperations(_And__NamedElement);
			Fragments._And__OclAny.initOperations(_And__OclAny);
			Fragments._And__OclElement.initOperations(_And__OclElement);
			Fragments._And__VariadicCondition.initOperations(_And__VariadicCondition);

			Fragments._ApplicationDependency__ApplicationDependency.initOperations(_ApplicationDependency__ApplicationDependency);
			Fragments._ApplicationDependency__ComplexCondition.initOperations(_ApplicationDependency__ComplexCondition);
			Fragments._ApplicationDependency__Condition.initOperations(_ApplicationDependency__Condition);
			Fragments._ApplicationDependency__NamedElement.initOperations(_ApplicationDependency__NamedElement);
			Fragments._ApplicationDependency__OclAny.initOperations(_ApplicationDependency__OclAny);
			Fragments._ApplicationDependency__OclElement.initOperations(_ApplicationDependency__OclElement);

			Fragments._AttributeCondition__AttributeCondition.initOperations(_AttributeCondition__AttributeCondition);
			Fragments._AttributeCondition__ComplexCondition.initOperations(_AttributeCondition__ComplexCondition);
			Fragments._AttributeCondition__Condition.initOperations(_AttributeCondition__Condition);
			Fragments._AttributeCondition__NamedElement.initOperations(_AttributeCondition__NamedElement);
			Fragments._AttributeCondition__OclAny.initOperations(_AttributeCondition__OclAny);
			Fragments._AttributeCondition__OclElement.initOperations(_AttributeCondition__OclElement);

			Fragments._CardinalityCondition__CardinalityCondition.initOperations(_CardinalityCondition__CardinalityCondition);
			Fragments._CardinalityCondition__ComplexCondition.initOperations(_CardinalityCondition__ComplexCondition);
			Fragments._CardinalityCondition__Condition.initOperations(_CardinalityCondition__Condition);
			Fragments._CardinalityCondition__NamedElement.initOperations(_CardinalityCondition__NamedElement);
			Fragments._CardinalityCondition__OclAny.initOperations(_CardinalityCondition__OclAny);
			Fragments._CardinalityCondition__OclElement.initOperations(_CardinalityCondition__OclElement);

			Fragments._ComparatorEnum__ComparatorEnum.initOperations(_ComparatorEnum__ComparatorEnum);
			Fragments._ComparatorEnum__OclAny.initOperations(_ComparatorEnum__OclAny);
			Fragments._ComparatorEnum__OclElement.initOperations(_ComparatorEnum__OclElement);
			Fragments._ComparatorEnum__OclEnumeration.initOperations(_ComparatorEnum__OclEnumeration);
			Fragments._ComparatorEnum__OclType.initOperations(_ComparatorEnum__OclType);

			Fragments._ComplexCondition__ComplexCondition.initOperations(_ComplexCondition__ComplexCondition);
			Fragments._ComplexCondition__NamedElement.initOperations(_ComplexCondition__NamedElement);
			Fragments._ComplexCondition__OclAny.initOperations(_ComplexCondition__OclAny);
			Fragments._ComplexCondition__OclElement.initOperations(_ComplexCondition__OclElement);

			Fragments._Condition__ComplexCondition.initOperations(_Condition__ComplexCondition);
			Fragments._Condition__Condition.initOperations(_Condition__Condition);
			Fragments._Condition__NamedElement.initOperations(_Condition__NamedElement);
			Fragments._Condition__OclAny.initOperations(_Condition__OclAny);
			Fragments._Condition__OclElement.initOperations(_Condition__OclElement);

			Fragments._Not__ComplexCondition.initOperations(_Not__ComplexCondition);
			Fragments._Not__NamedElement.initOperations(_Not__NamedElement);
			Fragments._Not__Not.initOperations(_Not__Not);
			Fragments._Not__OclAny.initOperations(_Not__OclAny);
			Fragments._Not__OclElement.initOperations(_Not__OclElement);
			Fragments._Not__UnaryCondition.initOperations(_Not__UnaryCondition);

			Fragments._Or__ComplexCondition.initOperations(_Or__ComplexCondition);
			Fragments._Or__NamedElement.initOperations(_Or__NamedElement);
			Fragments._Or__OclAny.initOperations(_Or__OclAny);
			Fragments._Or__OclElement.initOperations(_Or__OclElement);
			Fragments._Or__Or.initOperations(_Or__Or);
			Fragments._Or__VariadicCondition.initOperations(_Or__VariadicCondition);

			Fragments._UnaryCondition__ComplexCondition.initOperations(_UnaryCondition__ComplexCondition);
			Fragments._UnaryCondition__NamedElement.initOperations(_UnaryCondition__NamedElement);
			Fragments._UnaryCondition__OclAny.initOperations(_UnaryCondition__OclAny);
			Fragments._UnaryCondition__OclElement.initOperations(_UnaryCondition__OclElement);
			Fragments._UnaryCondition__UnaryCondition.initOperations(_UnaryCondition__UnaryCondition);

			Fragments._VariadicCondition__ComplexCondition.initOperations(_VariadicCondition__ComplexCondition);
			Fragments._VariadicCondition__NamedElement.initOperations(_VariadicCondition__NamedElement);
			Fragments._VariadicCondition__OclAny.initOperations(_VariadicCondition__OclAny);
			Fragments._VariadicCondition__OclElement.initOperations(_VariadicCondition__OclElement);
			Fragments._VariadicCondition__VariadicCondition.initOperations(_VariadicCondition__VariadicCondition);

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

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _And = {
			ConditionTables.Properties._VariadicCondition__localCondParts,
			ConditionTables.Properties._VariadicCondition__sharedCondParts,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ApplicationDependency = {
			ConditionTables.Properties._Condition__additionalConditionSpecification,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._ApplicationDependency__conditionalElement,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeCondition = {
			ConditionTables.Properties._Condition__additionalConditionSpecification,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._AttributeCondition__conditionAttributeRef,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._AttributeCondition__valueConstraint,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _CardinalityCondition = {
			ConditionTables.Properties._Condition__additionalConditionSpecification,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._CardinalityCondition__conditionSectionRef,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ComparatorEnum = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ComplexCondition = {
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Condition = {
			ConditionTables.Properties._Condition__additionalConditionSpecification,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Not = {
			ConditionTables.Properties._UnaryCondition__localCondPart,
			ConditionTables.Properties._UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Or = {
			ConditionTables.Properties._VariadicCondition__localCondParts,
			ConditionTables.Properties._VariadicCondition__sharedCondParts,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _UnaryCondition = {
			ConditionTables.Properties._UnaryCondition__localCondPart,
			ConditionTables.Properties._UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _VariadicCondition = {
			ConditionTables.Properties._VariadicCondition__localCondParts,
			ConditionTables.Properties._VariadicCondition__sharedCondParts,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__localCondPart,
			ConditionTables.Properties._ComplexCondition__UnaryCondition__sharedCondPart,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__localCondParts,
			ConditionTables.Properties._ComplexCondition__VariadicCondition__sharedCondParts
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._And__And.initProperties(_And);
			Fragments._ApplicationDependency__ApplicationDependency.initProperties(_ApplicationDependency);
			Fragments._AttributeCondition__AttributeCondition.initProperties(_AttributeCondition);
			Fragments._CardinalityCondition__CardinalityCondition.initProperties(_CardinalityCondition);
			Fragments._ComparatorEnum__ComparatorEnum.initProperties(_ComparatorEnum);
			Fragments._ComplexCondition__ComplexCondition.initProperties(_ComplexCondition);
			Fragments._Condition__Condition.initProperties(_Condition);
			Fragments._Not__Not.initProperties(_Not);
			Fragments._Or__Or.initProperties(_Or);
			Fragments._UnaryCondition__UnaryCondition.initProperties(_UnaryCondition);
			Fragments._VariadicCondition__VariadicCondition.initProperties(_VariadicCondition);

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
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _ComparatorEnum = {
			_ComparatorEnum__EQ,
			_ComparatorEnum__GT,
			_ComparatorEnum__LT,
			_ComparatorEnum__GE,
			_ComparatorEnum__LE
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._ComparatorEnum.initLiterals(_ComparatorEnum);

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
