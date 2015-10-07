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

import java.lang.String;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.MetamodelPackage;
import pamtram.transformation.TransformationPackage;

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
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_TMPLid_ = TypeId.ORDERED_SET.getSpecializedId(IdManager.getTemplateParameterId(0));
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, PamtramPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/mapping", null, MappingPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/metamodel", null, MetamodelPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_transformation = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/transformation", null, TransformationPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_TMPLid_ = TypeId.SEQUENCE.getSpecializedId(IdManager.getTemplateParameterId(0));
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AttributeValueModifierSet = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeValueModifierSet", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EPackage = PamtramTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EPackage", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_GlobalValue = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("GlobalValue", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_LibraryEntry = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("LibraryEntry", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Mapping = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("Mapping", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingModel = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("MappingModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_PAMTraM = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("PAMTraM", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SourceSection = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSection", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SourceSectionModel = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("SourceSectionModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TargetSection = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSection", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TargetSectionModel = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("TargetSectionModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Transformation = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_transformation.getClassId("Transformation", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TransformationModel = PamtramTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("TransformationModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_4 = ValueUtil.integerValueOf("4");
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Not_32_all_32_SourceSectionModels_32_specify_32_the_32_same_32_EPackage_32_This_32_is_32_c = "Not all SourceSectionModels specify the same EPackage. This is currently not supported!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Not_32_all_32_TargetSectionModels_32_specify_32_the_32_same_32_EPackage_32_This_32_is_32_c = "Not all TargetSectionModels specify the same EPackage. This is currently not supported!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_PAMTraM_c_c_sourceSectionModelsHaveSameEPackage = "PAMTraM::sourceSectionModelsHaveSameEPackage";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_PAMTraM_c_c_targetSectionModelsHaveSameEPackage = "PAMTraM::targetSectionModelsHaveSameEPackage";
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_AttributeValueModifierSet = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_AttributeValueModifierSet);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EPackage = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_EPackage);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_GlobalValue = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_GlobalValue);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_LibraryEntry = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_LibraryEntry);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Mapping = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_Mapping);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_MappingModel = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_MappingModel);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_SourceSection = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_SourceSection);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_SourceSectionModel = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_SourceSectionModel);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_TargetSection = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_TargetSection);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_TargetSectionModel = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_TargetSectionModel);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Transformation = TypeId.ORDERED_SET.getSpecializedId(PamtramTables.CLSSid_Transformation);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_AttributeValueModifierSet = TypeId.SEQUENCE.getSpecializedId(PamtramTables.CLSSid_AttributeValueModifierSet);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_EPackage = TypeId.SEQUENCE.getSpecializedId(PamtramTables.CLSSid_EPackage);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_GlobalValue = TypeId.SEQUENCE.getSpecializedId(PamtramTables.CLSSid_GlobalValue);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Mapping = TypeId.SEQUENCE.getSpecializedId(PamtramTables.CLSSid_Mapping);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_EPackage = TypeId.SET.getSpecializedId(PamtramTables.CLSSid_EPackage);

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

		public static final /*@NonNull*/ EcoreExecutorType _DeactivatableElement = new EcoreExecutorType(PamtramPackage.Literals.DEACTIVATABLE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MappingModel = new EcoreExecutorType(PamtramPackage.Literals.MAPPING_MODEL, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _NamedElement = new EcoreExecutorType(PamtramPackage.Literals.NAMED_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _PAMTraM = new EcoreExecutorType(PamtramPackage.Literals.PAM_TRA_M, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SectionModel = new EcoreExecutorType(PamtramPackage.Literals.SECTION_MODEL, PACKAGE, 0, TypeParameters._SectionModel_S, TypeParameters._SectionModel_C, TypeParameters._SectionModel_R, TypeParameters._SectionModel_A);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionModel = new EcoreExecutorType(PamtramPackage.Literals.SOURCE_SECTION_MODEL, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionModel = new EcoreExecutorType(PamtramPackage.Literals.TARGET_SECTION_MODEL, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TransformationModel = new EcoreExecutorType(PamtramPackage.Literals.TRANSFORMATION_MODEL, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType[] types = {
			_DeactivatableElement,
			_MappingModel,
			_NamedElement,
			_PAMTraM,
			_SectionModel,
			_SourceSectionModel,
			_TargetSectionModel,
			_TransformationModel
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

		private static final /*@NonNull*/ ExecutorFragment _DeactivatableElement__DeactivatableElement = new ExecutorFragment(Types._DeactivatableElement, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _DeactivatableElement__OclAny = new ExecutorFragment(Types._DeactivatableElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _DeactivatableElement__OclElement = new ExecutorFragment(Types._DeactivatableElement, OCLstdlibTables.Types._OclElement);

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

		private static final /*@NonNull*/ ExecutorFragment _TransformationModel__OclAny = new ExecutorFragment(Types._TransformationModel, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TransformationModel__OclElement = new ExecutorFragment(Types._TransformationModel, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TransformationModel__TransformationModel = new ExecutorFragment(Types._TransformationModel, PamtramTables.Types._TransformationModel);

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

		public static final /*@NonNull*/ ParameterTypes _ = TypeUtil.createParameterTypes();

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

		public static final /*@NonNull*/ ExecutorOperation _MappingModel__getActiveMappings = new ExecutorOperation("getActiveMappings", Parameters._, Types._MappingModel,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _PAMTraM__mergeExtends = new ExecutorOperation("mergeExtends", Parameters._, Types._PAMTraM,
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

		public static final /*@NonNull*/ ExecutorProperty _DeactivatableElement__deactivated = new EcoreExecutorProperty(PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED, Types._DeactivatableElement, 0);

		public static final /*@NonNull*/ ExecutorProperty _MappingModel__globalValues = new EcoreExecutorProperty(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES, Types._MappingModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _MappingModel__mapping = new EcoreExecutorProperty(PamtramPackage.Literals.MAPPING_MODEL__MAPPING, Types._MappingModel, 1);
		public static final /*@NonNull*/ ExecutorProperty _MappingModel__modifierSets = new EcoreExecutorProperty(PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS, Types._MappingModel, 2);
		public static final /*@NonNull*/ ExecutorProperty _MappingModel__PAMTraM__mappingModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._MappingModel, 3, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL));

		public static final /*@NonNull*/ ExecutorProperty _NamedElement__name = new EcoreExecutorProperty(PamtramPackage.Literals.NAMED_ELEMENT__NAME, Types._NamedElement, 0);

		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__activeMappings = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__ACTIVE_MAPPINGS, Types._PAMTraM, 0);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__contextMetaModelPackage = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE, Types._PAMTraM, 1);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__globalValues = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__GLOBAL_VALUES, Types._PAMTraM, 2);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__mappingModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL, Types._PAMTraM, 3);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__mappings = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__MAPPINGS, Types._PAMTraM, 4);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__modifierSets = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__MODIFIER_SETS, Types._PAMTraM, 5);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__sourceSectionModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL, Types._PAMTraM, 6);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__sourceSections = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS, Types._PAMTraM, 7);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__targetSectionModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL, Types._PAMTraM, 8);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__targetSections = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS, Types._PAMTraM, 9);
		public static final /*@NonNull*/ ExecutorProperty _PAMTraM__transformationModel = new EcoreExecutorProperty(PamtramPackage.Literals.PAM_TRA_M__TRANSFORMATION_MODEL, Types._PAMTraM, 10);

		public static final /*@NonNull*/ ExecutorProperty _SectionModel__metaModelPackage = new EcoreExecutorProperty(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_PACKAGE, Types._SectionModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _SectionModel__metaModelSections = new EcoreExecutorProperty(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS, Types._SectionModel, 1);

		public static final /*@NonNull*/ ExecutorProperty _SourceSectionModel__PAMTraM__sourceSectionModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._SourceSectionModel, 0, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL));

		public static final /*@NonNull*/ ExecutorProperty _TargetSectionModel__libraryElements = new EcoreExecutorProperty(PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS, Types._TargetSectionModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _TargetSectionModel__PAMTraM__targetSectionModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._TargetSectionModel, 1, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL));

		public static final /*@NonNull*/ ExecutorProperty _TransformationModel__transformation = new EcoreExecutorProperty(PamtramPackage.Literals.TRANSFORMATION_MODEL__TRANSFORMATION, Types._TransformationModel, 0);
		public static final /*@NonNull*/ ExecutorProperty _TransformationModel__PAMTraM__transformationModel = new ExecutorPropertyWithImplementation("PAMTraM", Types._TransformationModel, 1, new EcoreLibraryOppositeProperty(PamtramPackage.Literals.PAM_TRA_M__TRANSFORMATION_MODEL));
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

		private static final /*@NonNull*/ ExecutorFragment[] _DeactivatableElement =
		{
			Fragments._DeactivatableElement__OclAny /* 0 */,
			Fragments._DeactivatableElement__OclElement /* 1 */,
			Fragments._DeactivatableElement__DeactivatableElement /* 2 */
		};
		private static final /*@NonNull*/ int[] __DeactivatableElement = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _MappingModel =
		{
			Fragments._MappingModel__OclAny /* 0 */,
			Fragments._MappingModel__OclElement /* 1 */,
			Fragments._MappingModel__NamedElement /* 2 */,
			Fragments._MappingModel__MappingModel /* 3 */
		};
		private static final /*@NonNull*/ int[] __MappingModel = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _NamedElement =
		{
			Fragments._NamedElement__OclAny /* 0 */,
			Fragments._NamedElement__OclElement /* 1 */,
			Fragments._NamedElement__NamedElement /* 2 */
		};
		private static final /*@NonNull*/ int[] __NamedElement = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _PAMTraM =
		{
			Fragments._PAMTraM__OclAny /* 0 */,
			Fragments._PAMTraM__OclElement /* 1 */,
			Fragments._PAMTraM__PAMTraM /* 2 */
		};
		private static final /*@NonNull*/ int[] __PAMTraM = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SectionModel =
		{
			Fragments._SectionModel__OclAny /* 0 */,
			Fragments._SectionModel__OclElement /* 1 */,
			Fragments._SectionModel__NamedElement /* 2 */,
			Fragments._SectionModel__SectionModel /* 3 */
		};
		private static final /*@NonNull*/ int[] __SectionModel = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SourceSectionModel =
		{
			Fragments._SourceSectionModel__OclAny /* 0 */,
			Fragments._SourceSectionModel__OclElement /* 1 */,
			Fragments._SourceSectionModel__NamedElement /* 2 */,
			Fragments._SourceSectionModel__SectionModel /* 3 */,
			Fragments._SourceSectionModel__SourceSectionModel /* 4 */
		};
		private static final /*@NonNull*/ int[] __SourceSectionModel = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TargetSectionModel =
		{
			Fragments._TargetSectionModel__OclAny /* 0 */,
			Fragments._TargetSectionModel__OclElement /* 1 */,
			Fragments._TargetSectionModel__NamedElement /* 2 */,
			Fragments._TargetSectionModel__SectionModel /* 3 */,
			Fragments._TargetSectionModel__TargetSectionModel /* 4 */
		};
		private static final /*@NonNull*/ int[] __TargetSectionModel = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TransformationModel =
		{
			Fragments._TransformationModel__OclAny /* 0 */,
			Fragments._TransformationModel__OclElement /* 1 */,
			Fragments._TransformationModel__TransformationModel /* 2 */
		};
		private static final /*@NonNull*/ int[] __TransformationModel = { 1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._DeactivatableElement.initFragments(_DeactivatableElement, __DeactivatableElement);
			Types._MappingModel.initFragments(_MappingModel, __MappingModel);
			Types._NamedElement.initFragments(_NamedElement, __NamedElement);
			Types._PAMTraM.initFragments(_PAMTraM, __PAMTraM);
			Types._SectionModel.initFragments(_SectionModel, __SectionModel);
			Types._SourceSectionModel.initFragments(_SourceSectionModel, __SourceSectionModel);
			Types._TargetSectionModel.initFragments(_TargetSectionModel, __TargetSectionModel);
			Types._TransformationModel.initFragments(_TransformationModel, __TransformationModel);

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

		private static final /*@NonNull*/ ExecutorOperation[] _DeactivatableElement__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _DeactivatableElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _DeactivatableElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _MappingModel__MappingModel = {
			PamtramTables.Operations._MappingModel__getActiveMappings /* getActiveMappings() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _MappingModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _MappingModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _MappingModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _NamedElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _NamedElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _NamedElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _PAMTraM__PAMTraM = {
			PamtramTables.Operations._PAMTraM__mergeExtends /* mergeExtends() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _PAMTraM__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _PAMTraM__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SectionModel__SectionModel = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SectionModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SectionModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _SectionModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionModel__SourceSectionModel = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionModel__SectionModel = {};

		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionModel__TargetSectionModel = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionModel__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionModel__SectionModel = {};

		private static final /*@NonNull*/ ExecutorOperation[] _TransformationModel__TransformationModel = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TransformationModel__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _TransformationModel__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._DeactivatableElement__DeactivatableElement.initOperations(_DeactivatableElement__DeactivatableElement);
			Fragments._DeactivatableElement__OclAny.initOperations(_DeactivatableElement__OclAny);
			Fragments._DeactivatableElement__OclElement.initOperations(_DeactivatableElement__OclElement);

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

			Fragments._TransformationModel__OclAny.initOperations(_TransformationModel__OclAny);
			Fragments._TransformationModel__OclElement.initOperations(_TransformationModel__OclElement);
			Fragments._TransformationModel__TransformationModel.initOperations(_TransformationModel__TransformationModel);

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

		private static final /*@NonNull*/ ExecutorProperty[] _DeactivatableElement = {
			PamtramTables.Properties._DeactivatableElement__deactivated
		};

		private static final /*@NonNull*/ ExecutorProperty[] _MappingModel = {
			PamtramTables.Properties._MappingModel__globalValues,
			PamtramTables.Properties._MappingModel__mapping,
			PamtramTables.Properties._MappingModel__modifierSets,
			PamtramTables.Properties._NamedElement__name,
			PamtramTables.Properties._MappingModel__PAMTraM__mappingModel
		};

		private static final /*@NonNull*/ ExecutorProperty[] _NamedElement = {
			PamtramTables.Properties._NamedElement__name
		};

		private static final /*@NonNull*/ ExecutorProperty[] _PAMTraM = {
			PamtramTables.Properties._PAMTraM__activeMappings,
			PamtramTables.Properties._PAMTraM__contextMetaModelPackage,
			PamtramTables.Properties._PAMTraM__globalValues,
			PamtramTables.Properties._PAMTraM__mappingModel,
			PamtramTables.Properties._PAMTraM__mappings,
			PamtramTables.Properties._PAMTraM__modifierSets,
			PamtramTables.Properties._PAMTraM__sourceSectionModel,
			PamtramTables.Properties._PAMTraM__sourceSections,
			PamtramTables.Properties._PAMTraM__targetSectionModel,
			PamtramTables.Properties._PAMTraM__targetSections,
			PamtramTables.Properties._PAMTraM__transformationModel
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SectionModel = {
			PamtramTables.Properties._SectionModel__metaModelPackage,
			PamtramTables.Properties._SectionModel__metaModelSections,
			PamtramTables.Properties._NamedElement__name
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SourceSectionModel = {
			PamtramTables.Properties._SectionModel__metaModelPackage,
			PamtramTables.Properties._SectionModel__metaModelSections,
			PamtramTables.Properties._NamedElement__name,
			PamtramTables.Properties._SourceSectionModel__PAMTraM__sourceSectionModel
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TargetSectionModel = {
			PamtramTables.Properties._TargetSectionModel__libraryElements,
			PamtramTables.Properties._SectionModel__metaModelPackage,
			PamtramTables.Properties._SectionModel__metaModelSections,
			PamtramTables.Properties._NamedElement__name,
			PamtramTables.Properties._TargetSectionModel__PAMTraM__targetSectionModel
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TransformationModel = {
			PamtramTables.Properties._TransformationModel__transformation,
			PamtramTables.Properties._TransformationModel__PAMTraM__transformationModel
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._DeactivatableElement__DeactivatableElement.initProperties(_DeactivatableElement);
			Fragments._MappingModel__MappingModel.initProperties(_MappingModel);
			Fragments._NamedElement__NamedElement.initProperties(_NamedElement);
			Fragments._PAMTraM__PAMTraM.initProperties(_PAMTraM);
			Fragments._SectionModel__SectionModel.initProperties(_SectionModel);
			Fragments._SourceSectionModel__SourceSectionModel.initProperties(_SourceSectionModel);
			Fragments._TargetSectionModel__TargetSectionModel.initProperties(_TargetSectionModel);
			Fragments._TransformationModel__TransformationModel.initProperties(_TransformationModel);

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
