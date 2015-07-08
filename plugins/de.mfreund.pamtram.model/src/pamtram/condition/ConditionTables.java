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

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
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
import pamtram.condition.ConditionPackage;
import pamtram.condition.ConditionTables;
import pamtram.mapping.MappingPackage;

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
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/condition", null, ConditionPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/mapping", null, MappingPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_And = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("And", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ComplexCondition = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("ComplexCondition", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = ConditionTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Mapping = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("Mapping", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Not = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("Not", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Or = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("Or", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ EnumerationId ENUMid_ComparatorEnum = ConditionTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getEnumerationId("ComparatorEnum");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ComplexCondition = TypeId.ORDERED_SET.getSpecializedId(ConditionTables.CLSSid_ComplexCondition);

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
		public static final /*@NonNull*/ EcoreExecutorEnumeration _ComparatorEnum = new EcoreExecutorEnumeration(ConditionPackage.Literals.COMPARATOR_ENUM, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ComplexCondition = new EcoreExecutorType(ConditionPackage.Literals.COMPLEX_CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Condition = new EcoreExecutorType(ConditionPackage.Literals.CONDITION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Not = new EcoreExecutorType(ConditionPackage.Literals.NOT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Or = new EcoreExecutorType(ConditionPackage.Literals.OR, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType[] types = {
			_And,
			_ComparatorEnum,
			_ComplexCondition,
			_Condition,
			_Not,
			_Or
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
		private static final /*@NonNull*/ ExecutorFragment _And__OclAny = new ExecutorFragment(Types._And, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _And__OclElement = new ExecutorFragment(Types._And, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Class = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__ComparatorEnum = new ExecutorFragment(Types._ComparatorEnum, ConditionTables.Types._ComparatorEnum);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__DataType = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._DataType);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Element = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Element);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Enumeration = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Enumeration);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Nameable = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Nameable);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__NamedElement = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Namespace = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Namespace);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclAny = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclElement = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__OclType = new ExecutorFragment(Types._ComparatorEnum, OCLstdlibTables.Types._OclType);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__TemplateableElement = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._TemplateableElement);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Type = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Type);
		private static final /*@NonNull*/ ExecutorFragment _ComparatorEnum__Visitable = new ExecutorFragment(Types._ComparatorEnum, PivotTables.Types._Visitable);

		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__ComplexCondition = new ExecutorFragment(Types._ComplexCondition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__OclAny = new ExecutorFragment(Types._ComplexCondition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ComplexCondition__OclElement = new ExecutorFragment(Types._ComplexCondition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Condition__ComplexCondition = new ExecutorFragment(Types._Condition, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Condition__Condition = new ExecutorFragment(Types._Condition, ConditionTables.Types._Condition);
		private static final /*@NonNull*/ ExecutorFragment _Condition__OclAny = new ExecutorFragment(Types._Condition, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Condition__OclElement = new ExecutorFragment(Types._Condition, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Not__ComplexCondition = new ExecutorFragment(Types._Not, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Not__Not = new ExecutorFragment(Types._Not, ConditionTables.Types._Not);
		private static final /*@NonNull*/ ExecutorFragment _Not__OclAny = new ExecutorFragment(Types._Not, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Not__OclElement = new ExecutorFragment(Types._Not, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Or__ComplexCondition = new ExecutorFragment(Types._Or, ConditionTables.Types._ComplexCondition);
		private static final /*@NonNull*/ ExecutorFragment _Or__OclAny = new ExecutorFragment(Types._Or, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Or__OclElement = new ExecutorFragment(Types._Or, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Or__Or = new ExecutorFragment(Types._Or, ConditionTables.Types._Or);

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

		public static final /*@NonNull*/ ExecutorProperty _And__condition = new EcoreExecutorProperty(ConditionPackage.Literals.AND__CONDITION, Types._And, 0);

		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__And__condition = new ExecutorPropertyWithImplementation("And", Types._ComplexCondition, 0, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.AND__CONDITION));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__Not__condition = new ExecutorPropertyWithImplementation("Not", Types._ComplexCondition, 1, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.NOT__CONDITION));
		public static final /*@NonNull*/ ExecutorProperty _ComplexCondition__Or__condition = new ExecutorPropertyWithImplementation("Or", Types._ComplexCondition, 2, new EcoreLibraryOppositeProperty(ConditionPackage.Literals.OR__CONDITION));

		public static final /*@NonNull*/ ExecutorProperty _Condition__attribute = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__ATTRIBUTE, Types._Condition, 0);
		public static final /*@NonNull*/ ExecutorProperty _Condition__comparator = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__COMPARATOR, Types._Condition, 1);
		public static final /*@NonNull*/ ExecutorProperty _Condition__value = new EcoreExecutorProperty(ConditionPackage.Literals.CONDITION__VALUE, Types._Condition, 2);

		public static final /*@NonNull*/ ExecutorProperty _Not__condition = new EcoreExecutorProperty(ConditionPackage.Literals.NOT__CONDITION, Types._Not, 0);

		public static final /*@NonNull*/ ExecutorProperty _Or__condition = new EcoreExecutorProperty(ConditionPackage.Literals.OR__CONDITION, Types._Or, 0);
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
			Fragments._And__ComplexCondition /* 2 */,
			Fragments._And__And /* 3 */
		};
		private static final /*@NonNull*/ int[] __And = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _ComparatorEnum =
		{
			Fragments._ComparatorEnum__OclAny /* 0 */,
			Fragments._ComparatorEnum__OclElement /* 1 */,
			Fragments._ComparatorEnum__Nameable /* 2 */,
			Fragments._ComparatorEnum__OclType /* 2 */,
			Fragments._ComparatorEnum__Visitable /* 2 */,
			Fragments._ComparatorEnum__Element /* 3 */,
			Fragments._ComparatorEnum__NamedElement /* 4 */,
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
			Fragments._ComplexCondition__ComplexCondition /* 2 */
		};
		private static final /*@NonNull*/ int[] __ComplexCondition = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Condition =
		{
			Fragments._Condition__OclAny /* 0 */,
			Fragments._Condition__OclElement /* 1 */,
			Fragments._Condition__ComplexCondition /* 2 */,
			Fragments._Condition__Condition /* 3 */
		};
		private static final /*@NonNull*/ int[] __Condition = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Not =
		{
			Fragments._Not__OclAny /* 0 */,
			Fragments._Not__OclElement /* 1 */,
			Fragments._Not__ComplexCondition /* 2 */,
			Fragments._Not__Not /* 3 */
		};
		private static final /*@NonNull*/ int[] __Not = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Or =
		{
			Fragments._Or__OclAny /* 0 */,
			Fragments._Or__OclElement /* 1 */,
			Fragments._Or__ComplexCondition /* 2 */,
			Fragments._Or__Or /* 3 */
		};
		private static final /*@NonNull*/ int[] __Or = { 1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._And.initFragments(_And, __And);
			Types._ComparatorEnum.initFragments(_ComparatorEnum, __ComparatorEnum);
			Types._ComplexCondition.initFragments(_ComplexCondition, __ComplexCondition);
			Types._Condition.initFragments(_Condition, __Condition);
			Types._Not.initFragments(_Not, __Not);
			Types._Or.initFragments(_Or, __Or);

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
		private static final /*@NonNull*/ ExecutorOperation[] _ComparatorEnum__NamedElement = {};
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

		private static final /*@NonNull*/ ExecutorOperation[] _Condition__Condition = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Condition__ComplexCondition = {};
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

		private static final /*@NonNull*/ ExecutorOperation[] _Not__Not = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Not__ComplexCondition = {};
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

		private static final /*@NonNull*/ ExecutorOperation[] _Or__Or = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Or__ComplexCondition = {};
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

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._And__And.initOperations(_And__And);
			Fragments._And__ComplexCondition.initOperations(_And__ComplexCondition);
			Fragments._And__OclAny.initOperations(_And__OclAny);
			Fragments._And__OclElement.initOperations(_And__OclElement);

			Fragments._ComparatorEnum__Class.initOperations(_ComparatorEnum__Class);
			Fragments._ComparatorEnum__ComparatorEnum.initOperations(_ComparatorEnum__ComparatorEnum);
			Fragments._ComparatorEnum__DataType.initOperations(_ComparatorEnum__DataType);
			Fragments._ComparatorEnum__Element.initOperations(_ComparatorEnum__Element);
			Fragments._ComparatorEnum__Enumeration.initOperations(_ComparatorEnum__Enumeration);
			Fragments._ComparatorEnum__Nameable.initOperations(_ComparatorEnum__Nameable);
			Fragments._ComparatorEnum__NamedElement.initOperations(_ComparatorEnum__NamedElement);
			Fragments._ComparatorEnum__Namespace.initOperations(_ComparatorEnum__Namespace);
			Fragments._ComparatorEnum__OclAny.initOperations(_ComparatorEnum__OclAny);
			Fragments._ComparatorEnum__OclElement.initOperations(_ComparatorEnum__OclElement);
			Fragments._ComparatorEnum__OclType.initOperations(_ComparatorEnum__OclType);
			Fragments._ComparatorEnum__TemplateableElement.initOperations(_ComparatorEnum__TemplateableElement);
			Fragments._ComparatorEnum__Type.initOperations(_ComparatorEnum__Type);
			Fragments._ComparatorEnum__Visitable.initOperations(_ComparatorEnum__Visitable);

			Fragments._ComplexCondition__ComplexCondition.initOperations(_ComplexCondition__ComplexCondition);
			Fragments._ComplexCondition__OclAny.initOperations(_ComplexCondition__OclAny);
			Fragments._ComplexCondition__OclElement.initOperations(_ComplexCondition__OclElement);

			Fragments._Condition__ComplexCondition.initOperations(_Condition__ComplexCondition);
			Fragments._Condition__Condition.initOperations(_Condition__Condition);
			Fragments._Condition__OclAny.initOperations(_Condition__OclAny);
			Fragments._Condition__OclElement.initOperations(_Condition__OclElement);

			Fragments._Not__ComplexCondition.initOperations(_Not__ComplexCondition);
			Fragments._Not__Not.initOperations(_Not__Not);
			Fragments._Not__OclAny.initOperations(_Not__OclAny);
			Fragments._Not__OclElement.initOperations(_Not__OclElement);

			Fragments._Or__ComplexCondition.initOperations(_Or__ComplexCondition);
			Fragments._Or__OclAny.initOperations(_Or__OclAny);
			Fragments._Or__OclElement.initOperations(_Or__OclElement);
			Fragments._Or__Or.initOperations(_Or__Or);

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
			ConditionTables.Properties._And__condition,
			ConditionTables.Properties._ComplexCondition__And__condition,
			ConditionTables.Properties._ComplexCondition__Not__condition,
			ConditionTables.Properties._ComplexCondition__Or__condition
		};

		private static final /*@NonNull*/ ExecutorProperty[] _ComparatorEnum = {};

		private static final /*@NonNull*/ ExecutorProperty[] _ComplexCondition = {
			ConditionTables.Properties._ComplexCondition__And__condition,
			ConditionTables.Properties._ComplexCondition__Not__condition,
			ConditionTables.Properties._ComplexCondition__Or__condition
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Condition = {
			ConditionTables.Properties._Condition__attribute,
			ConditionTables.Properties._Condition__comparator,
			ConditionTables.Properties._Condition__value,
			ConditionTables.Properties._ComplexCondition__And__condition,
			ConditionTables.Properties._ComplexCondition__Not__condition,
			ConditionTables.Properties._ComplexCondition__Or__condition
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Not = {
			ConditionTables.Properties._Not__condition,
			ConditionTables.Properties._ComplexCondition__And__condition,
			ConditionTables.Properties._ComplexCondition__Not__condition,
			ConditionTables.Properties._ComplexCondition__Or__condition
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Or = {
			ConditionTables.Properties._Or__condition,
			ConditionTables.Properties._ComplexCondition__And__condition,
			ConditionTables.Properties._ComplexCondition__Not__condition,
			ConditionTables.Properties._ComplexCondition__Or__condition
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._And__And.initProperties(_And);
			Fragments._ComparatorEnum__ComparatorEnum.initProperties(_ComparatorEnum);
			Fragments._ComplexCondition__ComplexCondition.initProperties(_ComplexCondition);
			Fragments._Condition__Condition.initProperties(_Condition);
			Fragments._Not__Not.initProperties(_Not);
			Fragments._Or__Or.initProperties(_Or);

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
