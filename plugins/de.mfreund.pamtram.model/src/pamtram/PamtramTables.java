/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /de.mfreund.pamtram.model/model/pamtram.ecore
 * using:
 *   /de.mfreund.pamtram.model/model/pamtram.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package pamtram;

import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import pamtram.PamtramTables;

/**
 * PamtramTables provides the dispatch tables for the pamtram for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class PamtramTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final /*@NonNull*/ EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(PamtramPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final /*@NonNull*/ ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_TMPLid_ = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(0));
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.RootPackageId PACKid_$metamodel$ = org.eclipse.ocl.pivot.ids.IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, pamtram.PamtramPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/condition", null, pamtram.condition.ConditionPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/mapping", null, pamtram.mapping.MappingPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/metamodel", null, pamtram.metamodel.MetamodelPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Class = pamtram.PamtramTables.PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ComplexCondition = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("ComplexCondition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ConditionModel = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("ConditionModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ConditionalElement = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("ConditionalElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EPackage = pamtram.PamtramTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EPackage", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_FixedValue = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("FixedValue", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_LibraryEntry = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("LibraryEntry", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Mapping = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("Mapping", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingModel = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("MappingModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_OclElement = pamtram.PamtramTables.PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_PAMTraM = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("PAMTraM", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSection = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSection", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSectionModel = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("SourceSectionModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSection = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSection", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSectionModel = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("TargetSectionModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ValueModifierSet = pamtram.PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ValueModifierSet", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_0 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("0");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_1 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("1");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_4 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("4");
    public static final /*@NonInvalid*/ java.lang.String STR_As_32_this_32_Instance_32_is_32_a_32_ConditionElement_32_and_32_you_32_want_32_to_32_add_32_a_32_con = "As this Instance is a ConditionElement and you want to add a condition, you either have to model a condition or reference an already existing one!";
    public static final /*@NonInvalid*/ java.lang.String STR_ConditionalElement_c_c_eitherModelOrReferCondition = "ConditionalElement::eitherModelOrReferCondition";
    public static final /*@NonInvalid*/ java.lang.String STR_ConditionalElement_c_c_referenceOnlyConditionsFromConditionModel = "ConditionalElement::referenceOnlyConditionsFromConditionModel";
    public static final /*@NonInvalid*/ java.lang.String STR_It_32_only_32_allowed_32_to_32_reference_32_Condition_m_Instances_32_that_32_are_32_model_32 = "It only allowed to reference Condition-Instances that are model inside the ConditionModel!";
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ComplexCondition = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_ComplexCondition);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ConditionModel = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_ConditionModel);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_EPackage = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_EPackage);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_FixedValue = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_FixedValue);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_LibraryEntry = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_LibraryEntry);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_Mapping = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_Mapping);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_MappingModel = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_MappingModel);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_SourceSection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_SourceSection);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_SourceSectionModel = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_SourceSectionModel);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_TargetSection = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_TargetSection);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_TargetSectionModel = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_TargetSectionModel);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ValueModifierSet = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.PamtramTables.CLSSid_ValueModifierSet);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_FixedValue = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.PamtramTables.CLSSid_FixedValue);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_Mapping = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.PamtramTables.CLSSid_Mapping);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_ValueModifierSet = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.PamtramTables.CLSSid_ValueModifierSet);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SET_CLSSid_ComplexCondition = org.eclipse.ocl.pivot.ids.TypeId.SET.getSpecializedId(pamtram.PamtramTables.CLSSid_ComplexCondition);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			PamtramTables.init();
		}

		public static final /*@NonNull*/ ExecutorTypeParameter _SectionModel_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _SectionModel_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _SectionModel_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _SectionModel_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::TypeParameters and all preceding sub-packages.
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

		public static final /*@NonNull*/ EcoreExecutorType _ConditionModel = new EcoreExecutorType(PamtramPackage.Literals.CONDITION_MODEL, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ConditionalElement = new EcoreExecutorType(PamtramPackage.Literals.CONDITIONAL_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _DeactivatableElement = new EcoreExecutorType(PamtramPackage.Literals.DEACTIVATABLE_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MappingModel = new EcoreExecutorType(PamtramPackage.Literals.MAPPING_MODEL, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _NamedElement = new EcoreExecutorType(PamtramPackage.Literals.NAMED_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _PAMTraM = new EcoreExecutorType(PamtramPackage.Literals.PAM_TRA_M, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SectionModel = new EcoreExecutorType(PamtramPackage.Literals.SECTION_MODEL, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._SectionModel_S, TypeParameters._SectionModel_C, TypeParameters._SectionModel_R, TypeParameters._SectionModel_A);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionModel = new EcoreExecutorType(PamtramPackage.Literals.SOURCE_SECTION_MODEL, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionModel = new EcoreExecutorType(PamtramPackage.Literals.TARGET_SECTION_MODEL, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType /*@NonNull*/ [] types = {
			_ConditionModel,
			_ConditionalElement,
			_DeactivatableElement,
			_MappingModel,
			_NamedElement,
			_PAMTraM,
			_SectionModel,
			_SourceSectionModel,
			_TargetSectionModel
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::Types and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorFragment _ConditionModel__ConditionModel = new ExecutorFragment(Types._ConditionModel, PamtramTables.Types._ConditionModel);
		private static final /*@NonNull*/ ExecutorFragment _ConditionModel__NamedElement = new ExecutorFragment(Types._ConditionModel, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ConditionModel__OclAny = new ExecutorFragment(Types._ConditionModel, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ConditionModel__OclElement = new ExecutorFragment(Types._ConditionModel, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ConditionalElement__ConditionalElement = new ExecutorFragment(Types._ConditionalElement, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _ConditionalElement__OclAny = new ExecutorFragment(Types._ConditionalElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ConditionalElement__OclElement = new ExecutorFragment(Types._ConditionalElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _DeactivatableElement__DeactivatableElement = new ExecutorFragment(Types._DeactivatableElement, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _DeactivatableElement__OclAny = new ExecutorFragment(Types._DeactivatableElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _DeactivatableElement__OclElement = new ExecutorFragment(Types._DeactivatableElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingModel__DeactivatableElement = new ExecutorFragment(Types._MappingModel, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingModel__MappingModel = new ExecutorFragment(Types._MappingModel, PamtramTables.Types._MappingModel);
		private static final /*@NonNull*/ ExecutorFragment _MappingModel__NamedElement = new ExecutorFragment(Types._MappingModel, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingModel__OclAny = new ExecutorFragment(Types._MappingModel, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingModel__OclElement = new ExecutorFragment(Types._MappingModel, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _NamedElement__NamedElement = new ExecutorFragment(Types._NamedElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _NamedElement__OclAny = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _NamedElement__OclElement = new ExecutorFragment(Types._NamedElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _PAMTraM__OclAny = new ExecutorFragment(Types._PAMTraM, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _PAMTraM__OclElement = new ExecutorFragment(Types._PAMTraM, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _PAMTraM__PAMTraM = new ExecutorFragment(Types._PAMTraM, PamtramTables.Types._PAMTraM);

		private static final /*@NonNull*/ ExecutorFragment _SectionModel__NamedElement = new ExecutorFragment(Types._SectionModel, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SectionModel__OclAny = new ExecutorFragment(Types._SectionModel, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SectionModel__OclElement = new ExecutorFragment(Types._SectionModel, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SectionModel__SectionModel = new ExecutorFragment(Types._SectionModel, PamtramTables.Types._SectionModel);

		private static final /*@NonNull*/ ExecutorFragment _SourceSectionModel__NamedElement = new ExecutorFragment(Types._SourceSectionModel, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionModel__OclAny = new ExecutorFragment(Types._SourceSectionModel, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionModel__OclElement = new ExecutorFragment(Types._SourceSectionModel, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionModel__SectionModel = new ExecutorFragment(Types._SourceSectionModel, PamtramTables.Types._SectionModel);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionModel__SourceSectionModel = new ExecutorFragment(Types._SourceSectionModel, PamtramTables.Types._SourceSectionModel);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionModel__NamedElement = new ExecutorFragment(Types._TargetSectionModel, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionModel__OclAny = new ExecutorFragment(Types._TargetSectionModel, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionModel__OclElement = new ExecutorFragment(Types._TargetSectionModel, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionModel__SectionModel = new ExecutorFragment(Types._TargetSectionModel, PamtramTables.Types._SectionModel);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionModel__TargetSectionModel = new ExecutorFragment(Types._TargetSectionModel, PamtramTables.Types._TargetSectionModel);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of PamtramTables::Parameters and all preceding sub-packages.
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

		public static final /*@NonNull*/ ExecutorOperation _MappingModel__getActiveMappings = new ExecutorOperation("getActiveMappings", TypeUtil.EMPTY_PARAMETER_TYPES, Types._MappingModel,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _PAMTraM__mergeExtends = new ExecutorOperation("mergeExtends", TypeUtil.EMPTY_PARAMETER_TYPES, Types._PAMTraM,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::Operations and all preceding sub-packages.
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

		public static final /*@NonNull*/ ExecutorProperty _ConditionModel__condition = new EcoreExecutorProperty(PamtramPackage.Literals.CONDITION_MODEL__CONDITION, Types._ConditionModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _ConditionModel__PAMTraM__conditionModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._ConditionModel, 1, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL));

		public static final /*@NonNull*/ ExecutorProperty _ConditionalElement__condition = new EcoreExecutorProperty(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION, Types._ConditionalElement, 0);
		public static final /*@NonNull*/ ExecutorProperty _ConditionalElement__conditionRef = new EcoreExecutorProperty(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION_REF, Types._ConditionalElement, 1);

		public static final /*@NonNull*/ ExecutorProperty _DeactivatableElement__deactivated = new EcoreExecutorProperty(PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED, Types._DeactivatableElement, 0);

		public static final /*@NonNull*/ ExecutorProperty _MappingModel__globalValues = new EcoreExecutorProperty(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES, Types._MappingModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _MappingModel__mapping = new EcoreExecutorProperty(PamtramPackage.Literals.MAPPING_MODEL__MAPPING, Types._MappingModel, 1);
		public static final /*@NonNull*/ ExecutorProperty _MappingModel__modifierSets = new EcoreExecutorProperty(PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS, Types._MappingModel, 2);
		public static final /*@NonNull*/ ExecutorProperty _MappingModel__PAMTraM__mappingModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._MappingModel, 3, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL));

		public static final /*@NonNull*/ ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(PamtramPackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__activeMappings = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__ACTIVE_MAPPINGS, Types._PAMTraM, 0);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__conditionModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL, Types._PAMTraM, 1);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__contextMetaModelPackage = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE, Types._PAMTraM, 2);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__globalValues = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__GLOBAL_VALUES, Types._PAMTraM, 3);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__mappingModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL, Types._PAMTraM, 4);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__mappings = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__MAPPINGS, Types._PAMTraM, 5);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__modifierSets = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__MODIFIER_SETS, Types._PAMTraM, 6);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__sourceSectionModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL, Types._PAMTraM, 7);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__sourceSections = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS, Types._PAMTraM, 8);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__targetSectionModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL, Types._PAMTraM, 9);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__targetSections = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS, Types._PAMTraM, 10);

		public static final /*@NonNull*/ ExecutorProperty _SectionModel__metaModelPackage = new EcoreExecutorProperty(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_PACKAGE, Types._SectionModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _SectionModel__metaModelSections = new EcoreExecutorProperty(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, Types._SectionModel, 1);

		public static final /*@NonNull*/ ExecutorProperty _SourceSectionModel__PAMTraM__sourceSectionModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._SourceSectionModel, 0, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL));

		public static final /*@NonNull*/ ExecutorProperty _TargetSectionModel__libraryElements = new EcoreExecutorProperty(PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS, Types._TargetSectionModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _TargetSectionModel__PAMTraM__targetSectionModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._TargetSectionModel, 1, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::Properties and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ConditionModel =
		{
			Fragments._ConditionModel__OclAny /* 0 */,
			Fragments._ConditionModel__OclElement /* 1 */,
			Fragments._ConditionModel__NamedElement /* 2 */,
			Fragments._ConditionModel__ConditionModel /* 3 */
		};
		private static final int /*@NonNull*/ [] __ConditionModel = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ConditionalElement =
		{
			Fragments._ConditionalElement__OclAny /* 0 */,
			Fragments._ConditionalElement__OclElement /* 1 */,
			Fragments._ConditionalElement__ConditionalElement /* 2 */
		};
		private static final int /*@NonNull*/ [] __ConditionalElement = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _DeactivatableElement =
		{
			Fragments._DeactivatableElement__OclAny /* 0 */,
			Fragments._DeactivatableElement__OclElement /* 1 */,
			Fragments._DeactivatableElement__DeactivatableElement /* 2 */
		};
		private static final int /*@NonNull*/ [] __DeactivatableElement = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingModel =
		{
			Fragments._MappingModel__OclAny /* 0 */,
			Fragments._MappingModel__OclElement /* 1 */,
			Fragments._MappingModel__DeactivatableElement /* 2 */,
			Fragments._MappingModel__NamedElement /* 2 */,
			Fragments._MappingModel__MappingModel /* 3 */
		};
		private static final int /*@NonNull*/ [] __MappingModel = { 1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _NamedElement =
		{
			Fragments._NamedElement__OclAny /* 0 */,
			Fragments._NamedElement__OclElement /* 1 */,
			Fragments._NamedElement__NamedElement /* 2 */
		};
		private static final int /*@NonNull*/ [] __NamedElement = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _PAMTraM =
		{
			Fragments._PAMTraM__OclAny /* 0 */,
			Fragments._PAMTraM__OclElement /* 1 */,
			Fragments._PAMTraM__PAMTraM /* 2 */
		};
		private static final int /*@NonNull*/ [] __PAMTraM = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SectionModel =
		{
			Fragments._SectionModel__OclAny /* 0 */,
			Fragments._SectionModel__OclElement /* 1 */,
			Fragments._SectionModel__NamedElement /* 2 */,
			Fragments._SectionModel__SectionModel /* 3 */
		};
		private static final int /*@NonNull*/ [] __SectionModel = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SourceSectionModel =
		{
			Fragments._SourceSectionModel__OclAny /* 0 */,
			Fragments._SourceSectionModel__OclElement /* 1 */,
			Fragments._SourceSectionModel__NamedElement /* 2 */,
			Fragments._SourceSectionModel__SectionModel /* 3 */,
			Fragments._SourceSectionModel__SourceSectionModel /* 4 */
		};
		private static final int /*@NonNull*/ [] __SourceSectionModel = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _TargetSectionModel =
		{
			Fragments._TargetSectionModel__OclAny /* 0 */,
			Fragments._TargetSectionModel__OclElement /* 1 */,
			Fragments._TargetSectionModel__NamedElement /* 2 */,
			Fragments._TargetSectionModel__SectionModel /* 3 */,
			Fragments._TargetSectionModel__TargetSectionModel /* 4 */
		};
		private static final int /*@NonNull*/ [] __TargetSectionModel = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._ConditionModel.initFragments(_ConditionModel, __ConditionModel);
			Types._ConditionalElement.initFragments(_ConditionalElement, __ConditionalElement);
			Types._DeactivatableElement.initFragments(_DeactivatableElement, __DeactivatableElement);
			Types._MappingModel.initFragments(_MappingModel, __MappingModel);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._PAMTraM.initFragments(_PAMTraM, __PAMTraM);
			Types._SectionModel.initFragments(_SectionModel, __SectionModel);
			Types._SourceSectionModel.initFragments(_SourceSectionModel, __SourceSectionModel);
			Types._TargetSectionModel.initFragments(_TargetSectionModel, __TargetSectionModel);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::TypeFragments and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ConditionModel__ConditionModel = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ConditionModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ConditionModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ConditionModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ConditionalElement__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ConditionalElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ConditionalElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _DeactivatableElement__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _DeactivatableElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _DeactivatableElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingModel__MappingModel = {
			PamtramTables.Operations._MappingModel__getActiveMappings /* getActiveMappings() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingModel__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NamedElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NamedElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _PAMTraM__PAMTraM = {
			PamtramTables.Operations._PAMTraM__mergeExtends /* mergeExtends() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _PAMTraM__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _PAMTraM__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SectionModel__SectionModel = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SectionModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SectionModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SectionModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionModel__SourceSectionModel = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionModel__SectionModel = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionModel__TargetSectionModel = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionModel__SectionModel = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._ConditionModel__ConditionModel.initOperations(_ConditionModel__ConditionModel);
			Fragments._ConditionModel__NamedElement.initOperations(_ConditionModel__NamedElement);
			Fragments._ConditionModel__OclAny.initOperations(_ConditionModel__OclAny);
			Fragments._ConditionModel__OclElement.initOperations(_ConditionModel__OclElement);

			Fragments._ConditionalElement__ConditionalElement.initOperations(_ConditionalElement__ConditionalElement);
			Fragments._ConditionalElement__OclAny.initOperations(_ConditionalElement__OclAny);
			Fragments._ConditionalElement__OclElement.initOperations(_ConditionalElement__OclElement);

			Fragments._DeactivatableElement__DeactivatableElement.initOperations(_DeactivatableElement__DeactivatableElement);
			Fragments._DeactivatableElement__OclAny.initOperations(_DeactivatableElement__OclAny);
			Fragments._DeactivatableElement__OclElement.initOperations(_DeactivatableElement__OclElement);

			Fragments._MappingModel__DeactivatableElement.initOperations(_MappingModel__DeactivatableElement);
			Fragments._MappingModel__MappingModel.initOperations(_MappingModel__MappingModel);
			Fragments._MappingModel__NamedElement.initOperations(_MappingModel__NamedElement);
			Fragments._MappingModel__OclAny.initOperations(_MappingModel__OclAny);
			Fragments._MappingModel__OclElement.initOperations(_MappingModel__OclElement);

			Fragments._NamedElement__NamedElement.initOperations(_NamedElement__NamedElement);
			Fragments._NamedElement__OclAny.initOperations(_NamedElement__OclAny);
			Fragments._NamedElement__OclElement.initOperations(_NamedElement__OclElement);

			Fragments._PAMTraM__OclAny.initOperations(_PAMTraM__OclAny);
			Fragments._PAMTraM__OclElement.initOperations(_PAMTraM__OclElement);
			Fragments._PAMTraM__PAMTraM.initOperations(_PAMTraM__PAMTraM);

			Fragments._SectionModel__NamedElement.initOperations(_SectionModel__NamedElement);
			Fragments._SectionModel__OclAny.initOperations(_SectionModel__OclAny);
			Fragments._SectionModel__OclElement.initOperations(_SectionModel__OclElement);
			Fragments._SectionModel__SectionModel.initOperations(_SectionModel__SectionModel);

			Fragments._SourceSectionModel__NamedElement.initOperations(_SourceSectionModel__NamedElement);
			Fragments._SourceSectionModel__OclAny.initOperations(_SourceSectionModel__OclAny);
			Fragments._SourceSectionModel__OclElement.initOperations(_SourceSectionModel__OclElement);
			Fragments._SourceSectionModel__SectionModel.initOperations(_SourceSectionModel__SectionModel);
			Fragments._SourceSectionModel__SourceSectionModel.initOperations(_SourceSectionModel__SourceSectionModel);

			Fragments._TargetSectionModel__NamedElement.initOperations(_TargetSectionModel__NamedElement);
			Fragments._TargetSectionModel__OclAny.initOperations(_TargetSectionModel__OclAny);
			Fragments._TargetSectionModel__OclElement.initOperations(_TargetSectionModel__OclElement);
			Fragments._TargetSectionModel__SectionModel.initOperations(_TargetSectionModel__SectionModel);
			Fragments._TargetSectionModel__TargetSectionModel.initOperations(_TargetSectionModel__TargetSectionModel);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::FragmentOperations and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ConditionModel = {
			PamtramTables.Properties._ConditionModel__condition,
			PamtramTables.Properties._NamedElement__name,
			PamtramTables.Properties._ConditionModel__PAMTraM__conditionModel
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ConditionalElement = {
			PamtramTables.Properties._ConditionalElement__condition,
			PamtramTables.Properties._ConditionalElement__conditionRef
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _DeactivatableElement = {
			PamtramTables.Properties._DeactivatableElement__deactivated
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingModel = {
			PamtramTables.Properties._DeactivatableElement__deactivated,
			PamtramTables.Properties._MappingModel__globalValues,
			PamtramTables.Properties._MappingModel__mapping,
			PamtramTables.Properties._MappingModel__modifierSets,
			PamtramTables.Properties._NamedElement__name,
			PamtramTables.Properties._MappingModel__PAMTraM__mappingModel
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _NamedElement = {
			PamtramTables.Properties._NamedElement__name
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _PAMTraM = {
			PamtramTables.Properties._PAMTraM__activeMappings,
			PamtramTables.Properties._PAMTraM__conditionModel,
			PamtramTables.Properties._PAMTraM__contextMetaModelPackage,
			PamtramTables.Properties._PAMTraM__globalValues,
			PamtramTables.Properties._PAMTraM__mappingModel,
			PamtramTables.Properties._PAMTraM__mappings,
			PamtramTables.Properties._PAMTraM__modifierSets,
			PamtramTables.Properties._PAMTraM__sourceSectionModel,
			PamtramTables.Properties._PAMTraM__sourceSections,
			PamtramTables.Properties._PAMTraM__targetSectionModel,
			PamtramTables.Properties._PAMTraM__targetSections
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SectionModel = {
			PamtramTables.Properties._SectionModel__metaModelPackage,
			PamtramTables.Properties._SectionModel__metaModelSections,
			PamtramTables.Properties._NamedElement__name
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SourceSectionModel = {
			PamtramTables.Properties._SectionModel__metaModelPackage,
			PamtramTables.Properties._SectionModel__metaModelSections,
			PamtramTables.Properties._NamedElement__name,
			PamtramTables.Properties._SourceSectionModel__PAMTraM__sourceSectionModel
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _TargetSectionModel = {
			PamtramTables.Properties._TargetSectionModel__libraryElements,
			PamtramTables.Properties._SectionModel__metaModelPackage,
			PamtramTables.Properties._SectionModel__metaModelSections,
			PamtramTables.Properties._NamedElement__name,
			PamtramTables.Properties._TargetSectionModel__PAMTraM__targetSectionModel
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._ConditionModel__ConditionModel.initProperties(_ConditionModel);
			Fragments._ConditionalElement__ConditionalElement.initProperties(_ConditionalElement);
			Fragments._DeactivatableElement__DeactivatableElement.initProperties(_DeactivatableElement);
			Fragments._MappingModel__MappingModel.initProperties(_MappingModel);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._PAMTraM__PAMTraM.initProperties(_PAMTraM);
			Fragments._SectionModel__SectionModel.initProperties(_SectionModel);
			Fragments._SourceSectionModel__SourceSectionModel.initProperties(_SourceSectionModel);
			Fragments._TargetSectionModel__TargetSectionModel.initProperties(_TargetSectionModel);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::FragmentProperties and all preceding sub-packages.
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

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of PamtramTables::EnumerationLiterals and all preceding sub-packages.
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
