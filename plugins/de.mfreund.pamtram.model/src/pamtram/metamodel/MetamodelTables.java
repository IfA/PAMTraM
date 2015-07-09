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
package pamtram.metamodel;

import java.lang.String;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import pamtram.PamtramPackage;
import pamtram.PamtramTables;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;

/**
 * MetamodelTables provides the dispatch tables for the metamodel for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class MetamodelTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final /*@NonNull*/ EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(MetamodelPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final /*@NonNull*/ ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_TMPLid_ = TypeId.ORDERED_SET.getSpecializedId(IdManager.getTemplateParameterId(1));
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_TMPLid__0 = TypeId.ORDERED_SET.getSpecializedId(IdManager.getTemplateParameterId(2));
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, PamtramPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/mapping", null, MappingPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel = IdManager.getNsURIPackageId("http://mfreund.de/pamtram/metamodel", null, MetamodelPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage = IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/Orphanage", "orphanage", null);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_et_tu_m_dresden_de_s_ifa_s_agtele_s_genlib = IdManager.getNsURIPackageId("http://www.et.tu-dresden.de/ifa/agtele/genlib", null, null);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ActualAttribute = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ActualAttribute", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AttributeMapping = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMapping", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AttributeMatcher = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMatcher", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AttributeParameter = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("AttributeParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AttributeValueConstraint = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("AttributeValueConstraint", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_CardinalityMapping = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("CardinalityMapping", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ClassMatcher = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ClassMatcher", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class_0 = MetamodelTables.PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ContainerParameter = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ContainerParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ContainmentReference = MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage.getClassId("ContainmentReference", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ContainmentReference_0 = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ContainmentReference", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EAttribute = MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EAttribute", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EClass = MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EClass", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EObject = MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_EReference = MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EReference", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_ExternalReferenceParameter = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ExternalReferenceParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_GlobalAttribute = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("GlobalAttribute", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_LibraryEntry = MetamodelTables.PACKid_http_c_s_s_www_et_tu_m_dresden_de_s_ifa_s_agtele_s_genlib.getClassId("LibraryEntry", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_LibraryParameter = MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage.getClassId("LibraryParameter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingHintGroupImporter = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintGroupImporter", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingHintGroupType = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintGroupType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingInstanceSelector = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingInstanceSelector", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MappingType = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingType", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_MetaModelSectionReference = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("MetaModelSectionReference", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NonContainmentReference = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("NonContainmentReference", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = MetamodelTables.PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Reference = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("Reference", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SectionModel = MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage.getClassId("SectionModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SourceSectionAttribute = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionAttribute", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_SourceSectionClass = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionClass", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TargetSectionClass = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSectionClass", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TargetSectionModel = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("TargetSectionModel", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_TargetSectionNonContainmentReference = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSectionNonContainmentReference", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ EnumerationId ENUMid_AttributeValueConstraintType = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getEnumerationId("AttributeValueConstraintType");
    public static final /*@NonNull*/ /*@NonInvalid*/ EnumerationId ENUMid_CardinalityType = MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getEnumerationId("CardinalityType");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_2 = ValueUtil.integerValueOf("2");
    public static final /*@NonNull*/ /*@NonInvalid*/ IntegerValue INT_4 = ValueUtil.integerValueOf("4");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_TMPLid__1 = TypeId.ORDERED_SET.getSpecializedId(IdManager.getTemplateParameterId(0));
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_ActualAttribute_c_c_attributeMatchesParentEClass = "ActualAttribute::attributeMatchesParentEClass";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Class_c_c_cardinalityIsValid = "Class::cardinalityIsValid";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Class_c_c_containerIsValid = "Class::containerIsValid";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Class_c_c_eClassMatchesParentEReference = "Class::eClassMatchesParentEReference";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_ContainmentReference_c_c_eReferenceIsContainment = "ContainmentReference::eReferenceIsContainment";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_MetaModelSectionReference_c_c_valuesMatchReferenceType = "MetaModelSectionReference::valuesMatchReferenceType";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_NonContainmentReference_c_c_eReferenceIsNonContainment = "NonContainmentReference::eReferenceIsNonContainment";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_Reference_c_c_eReferenceMatchesParentEClass = "Reference::eReferenceMatchesParentEClass";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_SourceSectionAttribute_c_c_attributeMatchesParentEClass = "SourceSectionAttribute::attributeMatchesParentEClass";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_SourceSectionClass_c_c_isReferencedByMapping = "SourceSectionClass::isReferencedByMapping";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_TargetSectionClass_c_c_isReferencedByMappingHintGroup = "TargetSectionClass::isReferencedByMappingHintGroup";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_39_container_39_32_refrence_32_must_32_point_32_to_32_the_32_containing_32_Class_33 = "The \'container\' refrence must point to the containing Class!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_cardinality_32_of_32_a_32_Class_32_must_32_be_32_specified_32_as_32_39_CardinalityType = "The cardinality of a Class must be specified as \'CardinalityType::ONE\' when the upper bound of the containing Reference is \'1\'!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_eAttribute_32_39 = "The eAttribute \'";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_eClass_32_39 = "The eClass \'";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_eReference_32_39 = "The eReference \'";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_section_32_is_32_not_32_referenced_32_by_32_any_32_hint_32_group_32_and_32_will_32_not_32_be_32 = "The section is not referenced by any hint group and will not be instantiated!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR_The_32_section_32_is_32_not_32_referenced_32_by_32_any_32_mapping_33 = "The section is not referenced by any mapping!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR__32_of_32_the_32_selected_32_target_32_Classes_32_o_Value_e_32_are_32_not_32_allowed_32_by_32_the_32_s = " of the selected target Classes (Value) are not allowed by the selected eReference \'";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR__39_32_is_32_no_32_containment_32_reference_33 = "\' is no containment reference!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR__39_32_is_32_no_32_non_m_containment_32_reference_33 = "\' is no non-containment reference!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_Class_33 = "\' is not allowed by the containing Class!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_reference_33 = "\' is not allowed by the containing reference!";
    public static final /*@NonNull*/ /*@NonInvalid*/ String STR__39_33 = "\'!";
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_AttributeMapping = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_AttributeMapping);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_AttributeMatcher = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_AttributeMatcher);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_CardinalityMapping = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_CardinalityMapping);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_ClassMatcher = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_ClassMatcher);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_GlobalAttribute = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_GlobalAttribute);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_MappingHintGroupImporter = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_MappingHintGroupImporter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_MappingHintGroupType = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_MappingHintGroupType);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_MappingInstanceSelector = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_MappingInstanceSelector);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_MappingType = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_MappingType);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId BAG_CLSSid_MetaModelSectionReference = TypeId.BAG.getSpecializedId(MetamodelTables.CLSSid_MetaModelSectionReference);
    public static final /*@NonNull*/ /*@NonInvalid*/ EnumerationLiteralId ELITid_ONE = MetamodelTables.ENUMid_CardinalityType.getEnumerationLiteralId("ONE");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_AttributeValueConstraint = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_AttributeValueConstraint);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EAttribute = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_EAttribute);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_EReference = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_EReference);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_LibraryParameter = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_LibraryParameter);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_MappingHintGroupType = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_MappingHintGroupType);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_MappingType = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_MappingType);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_SourceSectionClass = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_SourceSectionClass);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_TargetSectionClass = TypeId.ORDERED_SET.getSpecializedId(MetamodelTables.CLSSid_TargetSectionClass);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_MappingHintGroupType = TypeId.SET.getSpecializedId(MetamodelTables.CLSSid_MappingHintGroupType);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SET_CLSSid_MappingType = TypeId.SET.getSpecializedId(MetamodelTables.CLSSid_MappingType);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			MetamodelTables.init();
		}

		public static final /*@NonNull*/ ExecutorTypeParameter _Attribute_C = new ExecutorTypeParameter(TypeId.T_1, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _Attribute_R = new ExecutorTypeParameter(TypeId.T_2, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _Attribute_A = new ExecutorTypeParameter(TypeId.T_3, "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _Class_C = new ExecutorTypeParameter(TypeId.T_1, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _Class_R = new ExecutorTypeParameter(TypeId.T_2, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _Class_A = new ExecutorTypeParameter(TypeId.T_3, "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _ContainmentReference_C = new ExecutorTypeParameter(TypeId.T_1, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _ContainmentReference_R = new ExecutorTypeParameter(TypeId.T_2, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _ContainmentReference_A = new ExecutorTypeParameter(TypeId.T_3, "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _LibraryParameter_ParameterType = new ExecutorTypeParameter(TypeId.T_1, "ParameterType");

		public static final /*@NonNull*/ ExecutorTypeParameter _MetaModelElement_C = new ExecutorTypeParameter(TypeId.T_1, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _MetaModelElement_R = new ExecutorTypeParameter(TypeId.T_2, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _MetaModelElement_A = new ExecutorTypeParameter(TypeId.T_3, "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _NonContainmentReference_C = new ExecutorTypeParameter(TypeId.T_1, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _NonContainmentReference_R = new ExecutorTypeParameter(TypeId.T_2, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _NonContainmentReference_A = new ExecutorTypeParameter(TypeId.T_3, "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _Reference_C = new ExecutorTypeParameter(TypeId.T_1, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _Reference_R = new ExecutorTypeParameter(TypeId.T_2, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _Reference_A = new ExecutorTypeParameter(TypeId.T_3, "A");

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::TypeParameters and all preceding sub-packages.
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

		public static final /*@NonNull*/ EcoreExecutorType _ActualAttribute = new EcoreExecutorType(MetamodelPackage.Literals.ACTUAL_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Attribute = new EcoreExecutorType(MetamodelPackage.Literals.ATTRIBUTE, PACKAGE, 0, TypeParameters._Attribute_C, TypeParameters._Attribute_R, TypeParameters._Attribute_A);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeParameter = new EcoreExecutorType(MetamodelPackage.Literals.ATTRIBUTE_PARAMETER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeValueConstraint = new EcoreExecutorType(MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _AttributeValueConstraintType = new EcoreExecutorEnumeration(MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT_TYPE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _BeginningMatcher = new EcoreExecutorType(MetamodelPackage.Literals.BEGINNING_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _CardinalityType = new EcoreExecutorEnumeration(MetamodelPackage.Literals.CARDINALITY_TYPE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _CaseSensitiveConstraint = new EcoreExecutorType(MetamodelPackage.Literals.CASE_SENSITIVE_CONSTRAINT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Class = new EcoreExecutorType(MetamodelPackage.Literals.CLASS, PACKAGE, 0, TypeParameters._Class_C, TypeParameters._Class_R, TypeParameters._Class_A);
		public static final /*@NonNull*/ EcoreExecutorType _ContainerParameter = new EcoreExecutorType(MetamodelPackage.Literals.CONTAINER_PARAMETER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.CONTAINMENT_REFERENCE, PACKAGE, 0, TypeParameters._ContainmentReference_C, TypeParameters._ContainmentReference_R, TypeParameters._ContainmentReference_A);
		public static final /*@NonNull*/ EcoreExecutorType _EndingMatcher = new EcoreExecutorType(MetamodelPackage.Literals.ENDING_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _EqualityMatcher = new EcoreExecutorType(MetamodelPackage.Literals.EQUALITY_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ExternalReferenceParameter = new EcoreExecutorType(MetamodelPackage.Literals.EXTERNAL_REFERENCE_PARAMETER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _LibraryEntry = new EcoreExecutorType(MetamodelPackage.Literals.LIBRARY_ENTRY, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _LibraryParameter = new EcoreExecutorType(MetamodelPackage.Literals.LIBRARY_PARAMETER, PACKAGE, 0, TypeParameters._LibraryParameter_ParameterType);
		public static final /*@NonNull*/ EcoreExecutorType _MetaModelElement = new EcoreExecutorType(MetamodelPackage.Literals.META_MODEL_ELEMENT, PACKAGE, 0, TypeParameters._MetaModelElement_C, TypeParameters._MetaModelElement_R, TypeParameters._MetaModelElement_A);
		public static final /*@NonNull*/ EcoreExecutorType _MetaModelSectionReference = new EcoreExecutorType(MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _NonContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE, PACKAGE, 0, TypeParameters._NonContainmentReference_C, TypeParameters._NonContainmentReference_R, TypeParameters._NonContainmentReference_A);
		public static final /*@NonNull*/ EcoreExecutorType _Reference = new EcoreExecutorType(MetamodelPackage.Literals.REFERENCE, PACKAGE, 0, TypeParameters._Reference_C, TypeParameters._Reference_R, TypeParameters._Reference_A);
		public static final /*@NonNull*/ EcoreExecutorType _RegExMatcher = new EcoreExecutorType(MetamodelPackage.Literals.REG_EX_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionAttribute = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionClass = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_CLASS, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_CONTAINMENT_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionReference = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SubstringMatcher = new EcoreExecutorType(MetamodelPackage.Literals.SUBSTRING_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionAttribute = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionClass = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_CLASS, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_CONTAINMENT_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionNonContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_NON_CONTAINMENT_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionReference = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _VirtualAttribute = new EcoreExecutorType(MetamodelPackage.Literals.VIRTUAL_ATTRIBUTE, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType[] types = {
			_ActualAttribute,
			_Attribute,
			_AttributeParameter,
			_AttributeValueConstraint,
			_AttributeValueConstraintType,
			_BeginningMatcher,
			_CardinalityType,
			_CaseSensitiveConstraint,
			_Class,
			_ContainerParameter,
			_ContainmentReference,
			_EndingMatcher,
			_EqualityMatcher,
			_ExternalReferenceParameter,
			_LibraryEntry,
			_LibraryParameter,
			_MetaModelElement,
			_MetaModelSectionReference,
			_NonContainmentReference,
			_Reference,
			_RegExMatcher,
			_SourceSectionAttribute,
			_SourceSectionClass,
			_SourceSectionContainmentReference,
			_SourceSectionReference,
			_SubstringMatcher,
			_TargetSectionAttribute,
			_TargetSectionClass,
			_TargetSectionContainmentReference,
			_TargetSectionNonContainmentReference,
			_TargetSectionReference,
			_VirtualAttribute
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::Types and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorFragment _ActualAttribute__ActualAttribute = new ExecutorFragment(Types._ActualAttribute, MetamodelTables.Types._ActualAttribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualAttribute__Attribute = new ExecutorFragment(Types._ActualAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualAttribute__MetaModelElement = new ExecutorFragment(Types._ActualAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualAttribute__NamedElement = new ExecutorFragment(Types._ActualAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualAttribute__OclAny = new ExecutorFragment(Types._ActualAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ActualAttribute__OclElement = new ExecutorFragment(Types._ActualAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualAttribute__TargetSectionAttribute = new ExecutorFragment(Types._ActualAttribute, MetamodelTables.Types._TargetSectionAttribute);

		private static final /*@NonNull*/ ExecutorFragment _Attribute__Attribute = new ExecutorFragment(Types._Attribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _Attribute__MetaModelElement = new ExecutorFragment(Types._Attribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _Attribute__NamedElement = new ExecutorFragment(Types._Attribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Attribute__OclAny = new ExecutorFragment(Types._Attribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Attribute__OclElement = new ExecutorFragment(Types._Attribute, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeParameter__AttributeParameter = new ExecutorFragment(Types._AttributeParameter, MetamodelTables.Types._AttributeParameter);
		private static final /*@NonNull*/ ExecutorFragment _AttributeParameter__LibraryParameter = new ExecutorFragment(Types._AttributeParameter, MetamodelTables.Types._LibraryParameter);
		private static final /*@NonNull*/ ExecutorFragment _AttributeParameter__NamedElement = new ExecutorFragment(Types._AttributeParameter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeParameter__OclAny = new ExecutorFragment(Types._AttributeParameter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeParameter__OclElement = new ExecutorFragment(Types._AttributeParameter, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraint__AttributeValueConstraint = new ExecutorFragment(Types._AttributeValueConstraint, MetamodelTables.Types._AttributeValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraint__NamedElement = new ExecutorFragment(Types._AttributeValueConstraint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraint__OclAny = new ExecutorFragment(Types._AttributeValueConstraint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraint__OclElement = new ExecutorFragment(Types._AttributeValueConstraint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__AttributeValueConstraintType = new ExecutorFragment(Types._AttributeValueConstraintType, MetamodelTables.Types._AttributeValueConstraintType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__Class = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__DataType = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._DataType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__Element = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._Element);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__Enumeration = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._Enumeration);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__Nameable = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._Nameable);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__NamedElement_1 = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__Namespace = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._Namespace);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__OclAny = new ExecutorFragment(Types._AttributeValueConstraintType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__OclElement = new ExecutorFragment(Types._AttributeValueConstraintType, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__OclType = new ExecutorFragment(Types._AttributeValueConstraintType, OCLstdlibTables.Types._OclType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__TemplateableElement = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._TemplateableElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__Type = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._Type);
		private static final /*@NonNull*/ ExecutorFragment _AttributeValueConstraintType__Visitable = new ExecutorFragment(Types._AttributeValueConstraintType, PivotTables.Types._Visitable);

		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__AttributeValueConstraint = new ExecutorFragment(Types._BeginningMatcher, MetamodelTables.Types._AttributeValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__BeginningMatcher = new ExecutorFragment(Types._BeginningMatcher, MetamodelTables.Types._BeginningMatcher);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._BeginningMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__NamedElement = new ExecutorFragment(Types._BeginningMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__OclAny = new ExecutorFragment(Types._BeginningMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__OclElement = new ExecutorFragment(Types._BeginningMatcher, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__CardinalityType = new ExecutorFragment(Types._CardinalityType, MetamodelTables.Types._CardinalityType);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__Class = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__DataType = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._DataType);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__Element = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._Element);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__Enumeration = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._Enumeration);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__Nameable = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._Nameable);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__NamedElement_1 = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__Namespace = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._Namespace);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__OclAny = new ExecutorFragment(Types._CardinalityType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__OclElement = new ExecutorFragment(Types._CardinalityType, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__OclType = new ExecutorFragment(Types._CardinalityType, OCLstdlibTables.Types._OclType);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__TemplateableElement = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._TemplateableElement);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__Type = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._Type);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__Visitable = new ExecutorFragment(Types._CardinalityType, PivotTables.Types._Visitable);

		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__AttributeValueConstraint = new ExecutorFragment(Types._CaseSensitiveConstraint, MetamodelTables.Types._AttributeValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__CaseSensitiveConstraint = new ExecutorFragment(Types._CaseSensitiveConstraint, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__NamedElement = new ExecutorFragment(Types._CaseSensitiveConstraint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__OclAny = new ExecutorFragment(Types._CaseSensitiveConstraint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__OclElement = new ExecutorFragment(Types._CaseSensitiveConstraint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Class__Class_1 = new ExecutorFragment(Types._Class, MetamodelTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _Class__MetaModelElement = new ExecutorFragment(Types._Class, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _Class__NamedElement = new ExecutorFragment(Types._Class, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Class__OclAny = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Class__OclElement = new ExecutorFragment(Types._Class, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ContainerParameter__ContainerParameter = new ExecutorFragment(Types._ContainerParameter, MetamodelTables.Types._ContainerParameter);
		private static final /*@NonNull*/ ExecutorFragment _ContainerParameter__LibraryParameter = new ExecutorFragment(Types._ContainerParameter, MetamodelTables.Types._LibraryParameter);
		private static final /*@NonNull*/ ExecutorFragment _ContainerParameter__NamedElement = new ExecutorFragment(Types._ContainerParameter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ContainerParameter__OclAny = new ExecutorFragment(Types._ContainerParameter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ContainerParameter__OclElement = new ExecutorFragment(Types._ContainerParameter, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ContainmentReference__ContainmentReference = new ExecutorFragment(Types._ContainmentReference, MetamodelTables.Types._ContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _ContainmentReference__MetaModelElement = new ExecutorFragment(Types._ContainmentReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _ContainmentReference__NamedElement = new ExecutorFragment(Types._ContainmentReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ContainmentReference__OclAny = new ExecutorFragment(Types._ContainmentReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ContainmentReference__OclElement = new ExecutorFragment(Types._ContainmentReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ContainmentReference__Reference = new ExecutorFragment(Types._ContainmentReference, MetamodelTables.Types._Reference);

		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__AttributeValueConstraint = new ExecutorFragment(Types._EndingMatcher, MetamodelTables.Types._AttributeValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._EndingMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__EndingMatcher = new ExecutorFragment(Types._EndingMatcher, MetamodelTables.Types._EndingMatcher);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__NamedElement = new ExecutorFragment(Types._EndingMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__OclAny = new ExecutorFragment(Types._EndingMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__OclElement = new ExecutorFragment(Types._EndingMatcher, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__AttributeValueConstraint = new ExecutorFragment(Types._EqualityMatcher, MetamodelTables.Types._AttributeValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._EqualityMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__EqualityMatcher = new ExecutorFragment(Types._EqualityMatcher, MetamodelTables.Types._EqualityMatcher);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__NamedElement = new ExecutorFragment(Types._EqualityMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__OclAny = new ExecutorFragment(Types._EqualityMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__OclElement = new ExecutorFragment(Types._EqualityMatcher, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__ExternalReferenceParameter = new ExecutorFragment(Types._ExternalReferenceParameter, MetamodelTables.Types._ExternalReferenceParameter);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__LibraryParameter = new ExecutorFragment(Types._ExternalReferenceParameter, MetamodelTables.Types._LibraryParameter);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__NamedElement = new ExecutorFragment(Types._ExternalReferenceParameter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__OclAny = new ExecutorFragment(Types._ExternalReferenceParameter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__OclElement = new ExecutorFragment(Types._ExternalReferenceParameter, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _LibraryEntry__LibraryEntry = new ExecutorFragment(Types._LibraryEntry, MetamodelTables.Types._LibraryEntry);
		private static final /*@NonNull*/ ExecutorFragment _LibraryEntry__OclAny = new ExecutorFragment(Types._LibraryEntry, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _LibraryEntry__OclElement = new ExecutorFragment(Types._LibraryEntry, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _LibraryParameter__LibraryParameter = new ExecutorFragment(Types._LibraryParameter, MetamodelTables.Types._LibraryParameter);
		private static final /*@NonNull*/ ExecutorFragment _LibraryParameter__NamedElement = new ExecutorFragment(Types._LibraryParameter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _LibraryParameter__OclAny = new ExecutorFragment(Types._LibraryParameter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _LibraryParameter__OclElement = new ExecutorFragment(Types._LibraryParameter, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MetaModelElement__MetaModelElement = new ExecutorFragment(Types._MetaModelElement, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelElement__NamedElement = new ExecutorFragment(Types._MetaModelElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelElement__OclAny = new ExecutorFragment(Types._MetaModelElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelElement__OclElement = new ExecutorFragment(Types._MetaModelElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MetaModelSectionReference__MetaModelElement = new ExecutorFragment(Types._MetaModelSectionReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelSectionReference__MetaModelSectionReference = new ExecutorFragment(Types._MetaModelSectionReference, MetamodelTables.Types._MetaModelSectionReference);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelSectionReference__NamedElement = new ExecutorFragment(Types._MetaModelSectionReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelSectionReference__OclAny = new ExecutorFragment(Types._MetaModelSectionReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelSectionReference__OclElement = new ExecutorFragment(Types._MetaModelSectionReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelSectionReference__Reference = new ExecutorFragment(Types._MetaModelSectionReference, MetamodelTables.Types._Reference);
		private static final /*@NonNull*/ ExecutorFragment _MetaModelSectionReference__SourceSectionReference = new ExecutorFragment(Types._MetaModelSectionReference, MetamodelTables.Types._SourceSectionReference);

		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__MetaModelElement = new ExecutorFragment(Types._NonContainmentReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__NamedElement = new ExecutorFragment(Types._NonContainmentReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__NonContainmentReference = new ExecutorFragment(Types._NonContainmentReference, MetamodelTables.Types._NonContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__OclAny = new ExecutorFragment(Types._NonContainmentReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__OclElement = new ExecutorFragment(Types._NonContainmentReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__Reference = new ExecutorFragment(Types._NonContainmentReference, MetamodelTables.Types._Reference);

		private static final /*@NonNull*/ ExecutorFragment _Reference__MetaModelElement = new ExecutorFragment(Types._Reference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _Reference__NamedElement = new ExecutorFragment(Types._Reference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Reference__OclAny = new ExecutorFragment(Types._Reference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Reference__OclElement = new ExecutorFragment(Types._Reference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Reference__Reference = new ExecutorFragment(Types._Reference, MetamodelTables.Types._Reference);

		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__AttributeValueConstraint = new ExecutorFragment(Types._RegExMatcher, MetamodelTables.Types._AttributeValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__NamedElement = new ExecutorFragment(Types._RegExMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__OclAny = new ExecutorFragment(Types._RegExMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__OclElement = new ExecutorFragment(Types._RegExMatcher, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__RegExMatcher = new ExecutorFragment(Types._RegExMatcher, MetamodelTables.Types._RegExMatcher);

		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__Attribute = new ExecutorFragment(Types._SourceSectionAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__MetaModelElement = new ExecutorFragment(Types._SourceSectionAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__NamedElement = new ExecutorFragment(Types._SourceSectionAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__OclAny = new ExecutorFragment(Types._SourceSectionAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__OclElement = new ExecutorFragment(Types._SourceSectionAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__SourceSectionAttribute = new ExecutorFragment(Types._SourceSectionAttribute, MetamodelTables.Types._SourceSectionAttribute);

		private static final /*@NonNull*/ ExecutorFragment _SourceSectionClass__Class_1 = new ExecutorFragment(Types._SourceSectionClass, MetamodelTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionClass__MetaModelElement = new ExecutorFragment(Types._SourceSectionClass, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionClass__NamedElement = new ExecutorFragment(Types._SourceSectionClass, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionClass__OclAny = new ExecutorFragment(Types._SourceSectionClass, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionClass__OclElement = new ExecutorFragment(Types._SourceSectionClass, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionClass__SourceSectionClass = new ExecutorFragment(Types._SourceSectionClass, MetamodelTables.Types._SourceSectionClass);

		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__ContainmentReference = new ExecutorFragment(Types._SourceSectionContainmentReference, MetamodelTables.Types._ContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__MetaModelElement = new ExecutorFragment(Types._SourceSectionContainmentReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__NamedElement = new ExecutorFragment(Types._SourceSectionContainmentReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__OclAny = new ExecutorFragment(Types._SourceSectionContainmentReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__OclElement = new ExecutorFragment(Types._SourceSectionContainmentReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__Reference = new ExecutorFragment(Types._SourceSectionContainmentReference, MetamodelTables.Types._Reference);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__SourceSectionContainmentReference = new ExecutorFragment(Types._SourceSectionContainmentReference, MetamodelTables.Types._SourceSectionContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionContainmentReference__SourceSectionReference = new ExecutorFragment(Types._SourceSectionContainmentReference, MetamodelTables.Types._SourceSectionReference);

		private static final /*@NonNull*/ ExecutorFragment _SourceSectionReference__MetaModelElement = new ExecutorFragment(Types._SourceSectionReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionReference__NamedElement = new ExecutorFragment(Types._SourceSectionReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionReference__OclAny = new ExecutorFragment(Types._SourceSectionReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionReference__OclElement = new ExecutorFragment(Types._SourceSectionReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionReference__Reference = new ExecutorFragment(Types._SourceSectionReference, MetamodelTables.Types._Reference);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionReference__SourceSectionReference = new ExecutorFragment(Types._SourceSectionReference, MetamodelTables.Types._SourceSectionReference);

		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__AttributeValueConstraint = new ExecutorFragment(Types._SubstringMatcher, MetamodelTables.Types._AttributeValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._SubstringMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__NamedElement = new ExecutorFragment(Types._SubstringMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__OclAny = new ExecutorFragment(Types._SubstringMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__OclElement = new ExecutorFragment(Types._SubstringMatcher, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__SubstringMatcher = new ExecutorFragment(Types._SubstringMatcher, MetamodelTables.Types._SubstringMatcher);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__Attribute = new ExecutorFragment(Types._TargetSectionAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__MetaModelElement = new ExecutorFragment(Types._TargetSectionAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__NamedElement = new ExecutorFragment(Types._TargetSectionAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__OclAny = new ExecutorFragment(Types._TargetSectionAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__OclElement = new ExecutorFragment(Types._TargetSectionAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__TargetSectionAttribute = new ExecutorFragment(Types._TargetSectionAttribute, MetamodelTables.Types._TargetSectionAttribute);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionClass__Class_1 = new ExecutorFragment(Types._TargetSectionClass, MetamodelTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionClass__MetaModelElement = new ExecutorFragment(Types._TargetSectionClass, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionClass__NamedElement = new ExecutorFragment(Types._TargetSectionClass, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionClass__OclAny = new ExecutorFragment(Types._TargetSectionClass, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionClass__OclElement = new ExecutorFragment(Types._TargetSectionClass, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionClass__TargetSectionClass = new ExecutorFragment(Types._TargetSectionClass, MetamodelTables.Types._TargetSectionClass);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__ContainmentReference = new ExecutorFragment(Types._TargetSectionContainmentReference, MetamodelTables.Types._ContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__MetaModelElement = new ExecutorFragment(Types._TargetSectionContainmentReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__NamedElement = new ExecutorFragment(Types._TargetSectionContainmentReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__OclAny = new ExecutorFragment(Types._TargetSectionContainmentReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__OclElement = new ExecutorFragment(Types._TargetSectionContainmentReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__Reference = new ExecutorFragment(Types._TargetSectionContainmentReference, MetamodelTables.Types._Reference);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__TargetSectionContainmentReference = new ExecutorFragment(Types._TargetSectionContainmentReference, MetamodelTables.Types._TargetSectionContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionContainmentReference__TargetSectionReference = new ExecutorFragment(Types._TargetSectionContainmentReference, MetamodelTables.Types._TargetSectionReference);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__MetaModelElement = new ExecutorFragment(Types._TargetSectionNonContainmentReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__NamedElement = new ExecutorFragment(Types._TargetSectionNonContainmentReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__NonContainmentReference = new ExecutorFragment(Types._TargetSectionNonContainmentReference, MetamodelTables.Types._NonContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__OclAny = new ExecutorFragment(Types._TargetSectionNonContainmentReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__OclElement = new ExecutorFragment(Types._TargetSectionNonContainmentReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__Reference = new ExecutorFragment(Types._TargetSectionNonContainmentReference, MetamodelTables.Types._Reference);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__TargetSectionNonContainmentReference = new ExecutorFragment(Types._TargetSectionNonContainmentReference, MetamodelTables.Types._TargetSectionNonContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionNonContainmentReference__TargetSectionReference = new ExecutorFragment(Types._TargetSectionNonContainmentReference, MetamodelTables.Types._TargetSectionReference);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionReference__MetaModelElement = new ExecutorFragment(Types._TargetSectionReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionReference__NamedElement = new ExecutorFragment(Types._TargetSectionReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionReference__OclAny = new ExecutorFragment(Types._TargetSectionReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionReference__OclElement = new ExecutorFragment(Types._TargetSectionReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionReference__Reference = new ExecutorFragment(Types._TargetSectionReference, MetamodelTables.Types._Reference);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionReference__TargetSectionReference = new ExecutorFragment(Types._TargetSectionReference, MetamodelTables.Types._TargetSectionReference);

		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__Attribute = new ExecutorFragment(Types._VirtualAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__MetaModelElement = new ExecutorFragment(Types._VirtualAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__NamedElement = new ExecutorFragment(Types._VirtualAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__OclAny = new ExecutorFragment(Types._VirtualAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__OclElement = new ExecutorFragment(Types._VirtualAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__TargetSectionAttribute = new ExecutorFragment(Types._VirtualAttribute, MetamodelTables.Types._TargetSectionAttribute);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__VirtualAttribute = new ExecutorFragment(Types._VirtualAttribute, MetamodelTables.Types._VirtualAttribute);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::Fragments and all preceding sub-packages.
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
		public static final /*@NonNull*/ ParameterTypes _Class_C = TypeUtil.createParameterTypes(MetamodelTables.TypeParameters._Class_C);
		public static final /*@NonNull*/ ParameterTypes _String = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::Parameters and all preceding sub-packages.
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

		public static final /*@NonNull*/ ExecutorOperation _AttributeValueConstraint__checkConstraint = new ExecutorOperation("checkConstraint", Parameters._String, Types._AttributeValueConstraint,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _Class__getOwningContainmentReference = new ExecutorOperation("getOwningContainmentReference", Parameters._, Types._Class,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Class__isContainedIn = new ExecutorOperation("isContainedIn", Parameters._Class_C, Types._Class,
			1, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Class__isContainerFor = new ExecutorOperation("isContainerFor", Parameters._Class_C, Types._Class,
			2, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Class__isSection = new ExecutorOperation("isSection", Parameters._, Types._Class,
			3, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _MetaModelElement__getContainingSection = new ExecutorOperation("getContainingSection", Parameters._, Types._MetaModelElement,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _MetaModelElement__getContainingSectionModel = new ExecutorOperation("getContainingSectionModel", Parameters._, Types._MetaModelElement,
			1, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _MetaModelElement__isLibraryEntry = new ExecutorOperation("isLibraryEntry", Parameters._, Types._MetaModelElement,
			2, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _SourceSectionReference__getValuesGeneric = new ExecutorOperation("getValuesGeneric", Parameters._, Types._SourceSectionReference,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _TargetSectionReference__getValuesGeneric = new ExecutorOperation("getValuesGeneric", Parameters._, Types._TargetSectionReference,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::Operations and all preceding sub-packages.
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

		public static final /*@NonNull*/ ExecutorProperty _ActualAttribute__attribute = new EcoreExecutorProperty(MetamodelPackage.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE, Types._ActualAttribute, 0);
		public static final /*@NonNull*/ ExecutorProperty _ActualAttribute__AttributeParameter__attribute = new ExecutorPropertyWithImplementation("AttributeParameter", Types._ActualAttribute, 1, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.ATTRIBUTE_PARAMETER__ATTRIBUTE));

		public static final /*@NonNull*/ ExecutorProperty _Attribute__owningClass = new EcoreExecutorProperty(MetamodelPackage.Literals.ATTRIBUTE__OWNING_CLASS, Types._Attribute, 0);

		public static final /*@NonNull*/ ExecutorProperty _AttributeParameter__attribute = new EcoreExecutorProperty(MetamodelPackage.Literals.ATTRIBUTE_PARAMETER__ATTRIBUTE, Types._AttributeParameter, 0);

		public static final /*@NonNull*/ ExecutorProperty _AttributeValueConstraint__type = new EcoreExecutorProperty(MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__TYPE, Types._AttributeValueConstraint, 0);
		public static final /*@NonNull*/ ExecutorProperty _AttributeValueConstraint__value = new EcoreExecutorProperty(MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__VALUE, Types._AttributeValueConstraint, 1);
		public static final /*@NonNull*/ ExecutorProperty _AttributeValueConstraint__SourceSectionAttribute__valueConstraint = new ExecutorPropertyWithImplementation("SourceSectionAttribute", Types._AttributeValueConstraint, 2, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT));

		public static final /*@NonNull*/ ExecutorProperty _CaseSensitiveConstraint__caseSensitive = new EcoreExecutorProperty(MetamodelPackage.Literals.CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE, Types._CaseSensitiveConstraint, 0);

		public static final /*@NonNull*/ ExecutorProperty _Class__attributes = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__ATTRIBUTES, Types._Class, 0);
		public static final /*@NonNull*/ ExecutorProperty _Class__cardinality = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__CARDINALITY, Types._Class, 1);
		public static final /*@NonNull*/ ExecutorProperty _Class__container = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__CONTAINER, Types._Class, 2);
		public static final /*@NonNull*/ ExecutorProperty _Class__eClass = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__ECLASS, Types._Class, 3);
		public static final /*@NonNull*/ ExecutorProperty _Class__references = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__REFERENCES, Types._Class, 4);

		public static final /*@NonNull*/ ExecutorProperty _ContainerParameter__class = new EcoreExecutorProperty(MetamodelPackage.Literals.CONTAINER_PARAMETER__CLASS, Types._ContainerParameter, 0);

		public static final /*@NonNull*/ ExecutorProperty _ContainmentReference__value = new EcoreExecutorProperty(MetamodelPackage.Literals.CONTAINMENT_REFERENCE__VALUE, Types._ContainmentReference, 0);

		public static final /*@NonNull*/ ExecutorProperty _ExternalReferenceParameter__reference = new EcoreExecutorProperty(MetamodelPackage.Literals.EXTERNAL_REFERENCE_PARAMETER__REFERENCE, Types._ExternalReferenceParameter, 0);

		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__libraryFile = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__LIBRARY_FILE, Types._LibraryEntry, 0);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__originalLibraryEntry = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY, Types._LibraryEntry, 1);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__parameters = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__PARAMETERS, Types._LibraryEntry, 2);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__path = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__PATH, Types._LibraryEntry, 3);

		public static final /*@NonNull*/ ExecutorProperty _LibraryParameter__originalParameter = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_PARAMETER__ORIGINAL_PARAMETER, Types._LibraryParameter, 0);
		public static final /*@NonNull*/ ExecutorProperty _LibraryParameter__source = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_PARAMETER__SOURCE, Types._LibraryParameter, 1);

		public static final /*@NonNull*/ ExecutorProperty _MetaModelSectionReference__value = new EcoreExecutorProperty(MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE, Types._MetaModelSectionReference, 0);

		public static final /*@NonNull*/ ExecutorProperty _NonContainmentReference__value = new EcoreExecutorProperty(MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE__VALUE, Types._NonContainmentReference, 0);

		public static final /*@NonNull*/ ExecutorProperty _Reference__eReference = new EcoreExecutorProperty(MetamodelPackage.Literals.REFERENCE__EREFERENCE, Types._Reference, 0);
		public static final /*@NonNull*/ ExecutorProperty _Reference__owningClass = new EcoreExecutorProperty(MetamodelPackage.Literals.REFERENCE__OWNING_CLASS, Types._Reference, 1);

		public static final /*@NonNull*/ ExecutorProperty _SourceSectionAttribute__attribute = new EcoreExecutorProperty(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE, Types._SourceSectionAttribute, 0);
		public static final /*@NonNull*/ ExecutorProperty _SourceSectionAttribute__valueConstraint = new EcoreExecutorProperty(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT, Types._SourceSectionAttribute, 1);

		public static final /*@NonNull*/ ExecutorProperty _SourceSectionClass__referencingMappings = new EcoreExecutorProperty(MetamodelPackage.Literals.SOURCE_SECTION_CLASS__REFERENCING_MAPPINGS, Types._SourceSectionClass, 0);
		public static final /*@NonNull*/ ExecutorProperty _SourceSectionClass__MetaModelSectionReference__value = new ExecutorPropertyWithImplementation("MetaModelSectionReference", Types._SourceSectionClass, 1, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE));

		public static final /*@NonNull*/ ExecutorProperty _TargetSectionAttribute__unique = new EcoreExecutorProperty(MetamodelPackage.Literals.TARGET_SECTION_ATTRIBUTE__UNIQUE, Types._TargetSectionAttribute, 0);
		public static final /*@NonNull*/ ExecutorProperty _TargetSectionAttribute__value = new EcoreExecutorProperty(MetamodelPackage.Literals.TARGET_SECTION_ATTRIBUTE__VALUE, Types._TargetSectionAttribute, 1);

		public static final /*@NonNull*/ ExecutorProperty _TargetSectionClass__referencingMappingHintGroups = new EcoreExecutorProperty(MetamodelPackage.Literals.TARGET_SECTION_CLASS__REFERENCING_MAPPING_HINT_GROUPS, Types._TargetSectionClass, 0);
		public static final /*@NonNull*/ ExecutorProperty _TargetSectionClass__ContainerParameter__class = new ExecutorPropertyWithImplementation("ContainerParameter", Types._TargetSectionClass, 1, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.CONTAINER_PARAMETER__CLASS));

		public static final /*@NonNull*/ ExecutorProperty _TargetSectionNonContainmentReference__ExternalReferenceParameter__reference = new ExecutorPropertyWithImplementation("ExternalReferenceParameter", Types._TargetSectionNonContainmentReference, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.EXTERNAL_REFERENCE_PARAMETER__REFERENCE));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::Properties and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorFragment[] _ActualAttribute =
		{
			Fragments._ActualAttribute__OclAny /* 0 */,
			Fragments._ActualAttribute__OclElement /* 1 */,
			Fragments._ActualAttribute__NamedElement /* 2 */,
			Fragments._ActualAttribute__MetaModelElement /* 3 */,
			Fragments._ActualAttribute__Attribute /* 4 */,
			Fragments._ActualAttribute__TargetSectionAttribute /* 5 */,
			Fragments._ActualAttribute__ActualAttribute /* 6 */
		};
		private static final /*@NonNull*/ int[] __ActualAttribute = { 1,1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Attribute =
		{
			Fragments._Attribute__OclAny /* 0 */,
			Fragments._Attribute__OclElement /* 1 */,
			Fragments._Attribute__NamedElement /* 2 */,
			Fragments._Attribute__MetaModelElement /* 3 */,
			Fragments._Attribute__Attribute /* 4 */
		};
		private static final /*@NonNull*/ int[] __Attribute = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _AttributeParameter =
		{
			Fragments._AttributeParameter__OclAny /* 0 */,
			Fragments._AttributeParameter__OclElement /* 1 */,
			Fragments._AttributeParameter__NamedElement /* 2 */,
			Fragments._AttributeParameter__LibraryParameter /* 3 */,
			Fragments._AttributeParameter__AttributeParameter /* 4 */
		};
		private static final /*@NonNull*/ int[] __AttributeParameter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _AttributeValueConstraint =
		{
			Fragments._AttributeValueConstraint__OclAny /* 0 */,
			Fragments._AttributeValueConstraint__OclElement /* 1 */,
			Fragments._AttributeValueConstraint__NamedElement /* 2 */,
			Fragments._AttributeValueConstraint__AttributeValueConstraint /* 3 */
		};
		private static final /*@NonNull*/ int[] __AttributeValueConstraint = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _AttributeValueConstraintType =
		{
			Fragments._AttributeValueConstraintType__OclAny /* 0 */,
			Fragments._AttributeValueConstraintType__OclElement /* 1 */,
			Fragments._AttributeValueConstraintType__Nameable /* 2 */,
			Fragments._AttributeValueConstraintType__OclType /* 2 */,
			Fragments._AttributeValueConstraintType__Visitable /* 2 */,
			Fragments._AttributeValueConstraintType__Element /* 3 */,
			Fragments._AttributeValueConstraintType__NamedElement_1 /* 4 */,
			Fragments._AttributeValueConstraintType__TemplateableElement /* 4 */,
			Fragments._AttributeValueConstraintType__Namespace /* 5 */,
			Fragments._AttributeValueConstraintType__Type /* 5 */,
			Fragments._AttributeValueConstraintType__Class /* 6 */,
			Fragments._AttributeValueConstraintType__DataType /* 7 */,
			Fragments._AttributeValueConstraintType__Enumeration /* 8 */,
			Fragments._AttributeValueConstraintType__AttributeValueConstraintType /* 9 */
		};
		private static final /*@NonNull*/ int[] __AttributeValueConstraintType = { 1,1,3,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _BeginningMatcher =
		{
			Fragments._BeginningMatcher__OclAny /* 0 */,
			Fragments._BeginningMatcher__OclElement /* 1 */,
			Fragments._BeginningMatcher__NamedElement /* 2 */,
			Fragments._BeginningMatcher__AttributeValueConstraint /* 3 */,
			Fragments._BeginningMatcher__CaseSensitiveConstraint /* 4 */,
			Fragments._BeginningMatcher__BeginningMatcher /* 5 */
		};
		private static final /*@NonNull*/ int[] __BeginningMatcher = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _CardinalityType =
		{
			Fragments._CardinalityType__OclAny /* 0 */,
			Fragments._CardinalityType__OclElement /* 1 */,
			Fragments._CardinalityType__Nameable /* 2 */,
			Fragments._CardinalityType__OclType /* 2 */,
			Fragments._CardinalityType__Visitable /* 2 */,
			Fragments._CardinalityType__Element /* 3 */,
			Fragments._CardinalityType__NamedElement_1 /* 4 */,
			Fragments._CardinalityType__TemplateableElement /* 4 */,
			Fragments._CardinalityType__Namespace /* 5 */,
			Fragments._CardinalityType__Type /* 5 */,
			Fragments._CardinalityType__Class /* 6 */,
			Fragments._CardinalityType__DataType /* 7 */,
			Fragments._CardinalityType__Enumeration /* 8 */,
			Fragments._CardinalityType__CardinalityType /* 9 */
		};
		private static final /*@NonNull*/ int[] __CardinalityType = { 1,1,3,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _CaseSensitiveConstraint =
		{
			Fragments._CaseSensitiveConstraint__OclAny /* 0 */,
			Fragments._CaseSensitiveConstraint__OclElement /* 1 */,
			Fragments._CaseSensitiveConstraint__NamedElement /* 2 */,
			Fragments._CaseSensitiveConstraint__AttributeValueConstraint /* 3 */,
			Fragments._CaseSensitiveConstraint__CaseSensitiveConstraint /* 4 */
		};
		private static final /*@NonNull*/ int[] __CaseSensitiveConstraint = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Class =
		{
			Fragments._Class__OclAny /* 0 */,
			Fragments._Class__OclElement /* 1 */,
			Fragments._Class__NamedElement /* 2 */,
			Fragments._Class__MetaModelElement /* 3 */,
			Fragments._Class__Class_1 /* 4 */
		};
		private static final /*@NonNull*/ int[] __Class = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _ContainerParameter =
		{
			Fragments._ContainerParameter__OclAny /* 0 */,
			Fragments._ContainerParameter__OclElement /* 1 */,
			Fragments._ContainerParameter__NamedElement /* 2 */,
			Fragments._ContainerParameter__LibraryParameter /* 3 */,
			Fragments._ContainerParameter__ContainerParameter /* 4 */
		};
		private static final /*@NonNull*/ int[] __ContainerParameter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _ContainmentReference =
		{
			Fragments._ContainmentReference__OclAny /* 0 */,
			Fragments._ContainmentReference__OclElement /* 1 */,
			Fragments._ContainmentReference__NamedElement /* 2 */,
			Fragments._ContainmentReference__MetaModelElement /* 3 */,
			Fragments._ContainmentReference__Reference /* 4 */,
			Fragments._ContainmentReference__ContainmentReference /* 5 */
		};
		private static final /*@NonNull*/ int[] __ContainmentReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _EndingMatcher =
		{
			Fragments._EndingMatcher__OclAny /* 0 */,
			Fragments._EndingMatcher__OclElement /* 1 */,
			Fragments._EndingMatcher__NamedElement /* 2 */,
			Fragments._EndingMatcher__AttributeValueConstraint /* 3 */,
			Fragments._EndingMatcher__CaseSensitiveConstraint /* 4 */,
			Fragments._EndingMatcher__EndingMatcher /* 5 */
		};
		private static final /*@NonNull*/ int[] __EndingMatcher = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _EqualityMatcher =
		{
			Fragments._EqualityMatcher__OclAny /* 0 */,
			Fragments._EqualityMatcher__OclElement /* 1 */,
			Fragments._EqualityMatcher__NamedElement /* 2 */,
			Fragments._EqualityMatcher__AttributeValueConstraint /* 3 */,
			Fragments._EqualityMatcher__CaseSensitiveConstraint /* 4 */,
			Fragments._EqualityMatcher__EqualityMatcher /* 5 */
		};
		private static final /*@NonNull*/ int[] __EqualityMatcher = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _ExternalReferenceParameter =
		{
			Fragments._ExternalReferenceParameter__OclAny /* 0 */,
			Fragments._ExternalReferenceParameter__OclElement /* 1 */,
			Fragments._ExternalReferenceParameter__NamedElement /* 2 */,
			Fragments._ExternalReferenceParameter__LibraryParameter /* 3 */,
			Fragments._ExternalReferenceParameter__ExternalReferenceParameter /* 4 */
		};
		private static final /*@NonNull*/ int[] __ExternalReferenceParameter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _LibraryEntry =
		{
			Fragments._LibraryEntry__OclAny /* 0 */,
			Fragments._LibraryEntry__OclElement /* 1 */,
			Fragments._LibraryEntry__LibraryEntry /* 2 */
		};
		private static final /*@NonNull*/ int[] __LibraryEntry = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _LibraryParameter =
		{
			Fragments._LibraryParameter__OclAny /* 0 */,
			Fragments._LibraryParameter__OclElement /* 1 */,
			Fragments._LibraryParameter__NamedElement /* 2 */,
			Fragments._LibraryParameter__LibraryParameter /* 3 */
		};
		private static final /*@NonNull*/ int[] __LibraryParameter = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _MetaModelElement =
		{
			Fragments._MetaModelElement__OclAny /* 0 */,
			Fragments._MetaModelElement__OclElement /* 1 */,
			Fragments._MetaModelElement__NamedElement /* 2 */,
			Fragments._MetaModelElement__MetaModelElement /* 3 */
		};
		private static final /*@NonNull*/ int[] __MetaModelElement = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _MetaModelSectionReference =
		{
			Fragments._MetaModelSectionReference__OclAny /* 0 */,
			Fragments._MetaModelSectionReference__OclElement /* 1 */,
			Fragments._MetaModelSectionReference__NamedElement /* 2 */,
			Fragments._MetaModelSectionReference__MetaModelElement /* 3 */,
			Fragments._MetaModelSectionReference__Reference /* 4 */,
			Fragments._MetaModelSectionReference__SourceSectionReference /* 5 */,
			Fragments._MetaModelSectionReference__MetaModelSectionReference /* 6 */
		};
		private static final /*@NonNull*/ int[] __MetaModelSectionReference = { 1,1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _NonContainmentReference =
		{
			Fragments._NonContainmentReference__OclAny /* 0 */,
			Fragments._NonContainmentReference__OclElement /* 1 */,
			Fragments._NonContainmentReference__NamedElement /* 2 */,
			Fragments._NonContainmentReference__MetaModelElement /* 3 */,
			Fragments._NonContainmentReference__Reference /* 4 */,
			Fragments._NonContainmentReference__NonContainmentReference /* 5 */
		};
		private static final /*@NonNull*/ int[] __NonContainmentReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _Reference =
		{
			Fragments._Reference__OclAny /* 0 */,
			Fragments._Reference__OclElement /* 1 */,
			Fragments._Reference__NamedElement /* 2 */,
			Fragments._Reference__MetaModelElement /* 3 */,
			Fragments._Reference__Reference /* 4 */
		};
		private static final /*@NonNull*/ int[] __Reference = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _RegExMatcher =
		{
			Fragments._RegExMatcher__OclAny /* 0 */,
			Fragments._RegExMatcher__OclElement /* 1 */,
			Fragments._RegExMatcher__NamedElement /* 2 */,
			Fragments._RegExMatcher__AttributeValueConstraint /* 3 */,
			Fragments._RegExMatcher__RegExMatcher /* 4 */
		};
		private static final /*@NonNull*/ int[] __RegExMatcher = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SourceSectionAttribute =
		{
			Fragments._SourceSectionAttribute__OclAny /* 0 */,
			Fragments._SourceSectionAttribute__OclElement /* 1 */,
			Fragments._SourceSectionAttribute__NamedElement /* 2 */,
			Fragments._SourceSectionAttribute__MetaModelElement /* 3 */,
			Fragments._SourceSectionAttribute__Attribute /* 4 */,
			Fragments._SourceSectionAttribute__SourceSectionAttribute /* 5 */
		};
		private static final /*@NonNull*/ int[] __SourceSectionAttribute = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SourceSectionClass =
		{
			Fragments._SourceSectionClass__OclAny /* 0 */,
			Fragments._SourceSectionClass__OclElement /* 1 */,
			Fragments._SourceSectionClass__NamedElement /* 2 */,
			Fragments._SourceSectionClass__MetaModelElement /* 3 */,
			Fragments._SourceSectionClass__Class_1 /* 4 */,
			Fragments._SourceSectionClass__SourceSectionClass /* 5 */
		};
		private static final /*@NonNull*/ int[] __SourceSectionClass = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SourceSectionContainmentReference =
		{
			Fragments._SourceSectionContainmentReference__OclAny /* 0 */,
			Fragments._SourceSectionContainmentReference__OclElement /* 1 */,
			Fragments._SourceSectionContainmentReference__NamedElement /* 2 */,
			Fragments._SourceSectionContainmentReference__MetaModelElement /* 3 */,
			Fragments._SourceSectionContainmentReference__Reference /* 4 */,
			Fragments._SourceSectionContainmentReference__ContainmentReference /* 5 */,
			Fragments._SourceSectionContainmentReference__SourceSectionReference /* 5 */,
			Fragments._SourceSectionContainmentReference__SourceSectionContainmentReference /* 6 */
		};
		private static final /*@NonNull*/ int[] __SourceSectionContainmentReference = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SourceSectionReference =
		{
			Fragments._SourceSectionReference__OclAny /* 0 */,
			Fragments._SourceSectionReference__OclElement /* 1 */,
			Fragments._SourceSectionReference__NamedElement /* 2 */,
			Fragments._SourceSectionReference__MetaModelElement /* 3 */,
			Fragments._SourceSectionReference__Reference /* 4 */,
			Fragments._SourceSectionReference__SourceSectionReference /* 5 */
		};
		private static final /*@NonNull*/ int[] __SourceSectionReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _SubstringMatcher =
		{
			Fragments._SubstringMatcher__OclAny /* 0 */,
			Fragments._SubstringMatcher__OclElement /* 1 */,
			Fragments._SubstringMatcher__NamedElement /* 2 */,
			Fragments._SubstringMatcher__AttributeValueConstraint /* 3 */,
			Fragments._SubstringMatcher__CaseSensitiveConstraint /* 4 */,
			Fragments._SubstringMatcher__SubstringMatcher /* 5 */
		};
		private static final /*@NonNull*/ int[] __SubstringMatcher = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TargetSectionAttribute =
		{
			Fragments._TargetSectionAttribute__OclAny /* 0 */,
			Fragments._TargetSectionAttribute__OclElement /* 1 */,
			Fragments._TargetSectionAttribute__NamedElement /* 2 */,
			Fragments._TargetSectionAttribute__MetaModelElement /* 3 */,
			Fragments._TargetSectionAttribute__Attribute /* 4 */,
			Fragments._TargetSectionAttribute__TargetSectionAttribute /* 5 */
		};
		private static final /*@NonNull*/ int[] __TargetSectionAttribute = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TargetSectionClass =
		{
			Fragments._TargetSectionClass__OclAny /* 0 */,
			Fragments._TargetSectionClass__OclElement /* 1 */,
			Fragments._TargetSectionClass__NamedElement /* 2 */,
			Fragments._TargetSectionClass__MetaModelElement /* 3 */,
			Fragments._TargetSectionClass__Class_1 /* 4 */,
			Fragments._TargetSectionClass__TargetSectionClass /* 5 */
		};
		private static final /*@NonNull*/ int[] __TargetSectionClass = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TargetSectionContainmentReference =
		{
			Fragments._TargetSectionContainmentReference__OclAny /* 0 */,
			Fragments._TargetSectionContainmentReference__OclElement /* 1 */,
			Fragments._TargetSectionContainmentReference__NamedElement /* 2 */,
			Fragments._TargetSectionContainmentReference__MetaModelElement /* 3 */,
			Fragments._TargetSectionContainmentReference__Reference /* 4 */,
			Fragments._TargetSectionContainmentReference__ContainmentReference /* 5 */,
			Fragments._TargetSectionContainmentReference__TargetSectionReference /* 5 */,
			Fragments._TargetSectionContainmentReference__TargetSectionContainmentReference /* 6 */
		};
		private static final /*@NonNull*/ int[] __TargetSectionContainmentReference = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TargetSectionNonContainmentReference =
		{
			Fragments._TargetSectionNonContainmentReference__OclAny /* 0 */,
			Fragments._TargetSectionNonContainmentReference__OclElement /* 1 */,
			Fragments._TargetSectionNonContainmentReference__NamedElement /* 2 */,
			Fragments._TargetSectionNonContainmentReference__MetaModelElement /* 3 */,
			Fragments._TargetSectionNonContainmentReference__Reference /* 4 */,
			Fragments._TargetSectionNonContainmentReference__NonContainmentReference /* 5 */,
			Fragments._TargetSectionNonContainmentReference__TargetSectionReference /* 5 */,
			Fragments._TargetSectionNonContainmentReference__TargetSectionNonContainmentReference /* 6 */
		};
		private static final /*@NonNull*/ int[] __TargetSectionNonContainmentReference = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _TargetSectionReference =
		{
			Fragments._TargetSectionReference__OclAny /* 0 */,
			Fragments._TargetSectionReference__OclElement /* 1 */,
			Fragments._TargetSectionReference__NamedElement /* 2 */,
			Fragments._TargetSectionReference__MetaModelElement /* 3 */,
			Fragments._TargetSectionReference__Reference /* 4 */,
			Fragments._TargetSectionReference__TargetSectionReference /* 5 */
		};
		private static final /*@NonNull*/ int[] __TargetSectionReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment[] _VirtualAttribute =
		{
			Fragments._VirtualAttribute__OclAny /* 0 */,
			Fragments._VirtualAttribute__OclElement /* 1 */,
			Fragments._VirtualAttribute__NamedElement /* 2 */,
			Fragments._VirtualAttribute__MetaModelElement /* 3 */,
			Fragments._VirtualAttribute__Attribute /* 4 */,
			Fragments._VirtualAttribute__TargetSectionAttribute /* 5 */,
			Fragments._VirtualAttribute__VirtualAttribute /* 6 */
		};
		private static final /*@NonNull*/ int[] __VirtualAttribute = { 1,1,1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._ActualAttribute.initFragments(_ActualAttribute, __ActualAttribute);
			Types._Attribute.initFragments(_Attribute, __Attribute);
			Types._AttributeParameter.initFragments(_AttributeParameter, __AttributeParameter);
			Types._AttributeValueConstraint.initFragments(_AttributeValueConstraint, __AttributeValueConstraint);
			Types._AttributeValueConstraintType.initFragments(_AttributeValueConstraintType, __AttributeValueConstraintType);
			Types._BeginningMatcher.initFragments(_BeginningMatcher, __BeginningMatcher);
			Types._CardinalityType.initFragments(_CardinalityType, __CardinalityType);
			Types._CaseSensitiveConstraint.initFragments(_CaseSensitiveConstraint, __CaseSensitiveConstraint);
			Types._Class.initFragments(_Class, __Class);
			Types._ContainerParameter.initFragments(_ContainerParameter, __ContainerParameter);
			Types._ContainmentReference.initFragments(_ContainmentReference, __ContainmentReference);
			Types._EndingMatcher.initFragments(_EndingMatcher, __EndingMatcher);
			Types._EqualityMatcher.initFragments(_EqualityMatcher, __EqualityMatcher);
			Types._ExternalReferenceParameter.initFragments(_ExternalReferenceParameter, __ExternalReferenceParameter);
			Types._LibraryEntry.initFragments(_LibraryEntry, __LibraryEntry);
			Types._LibraryParameter.initFragments(_LibraryParameter, __LibraryParameter);
			Types._MetaModelElement.initFragments(_MetaModelElement, __MetaModelElement);
			Types._MetaModelSectionReference.initFragments(_MetaModelSectionReference, __MetaModelSectionReference);
			Types._NonContainmentReference.initFragments(_NonContainmentReference, __NonContainmentReference);
			Types._Reference.initFragments(_Reference, __Reference);
			Types._RegExMatcher.initFragments(_RegExMatcher, __RegExMatcher);
			Types._SourceSectionAttribute.initFragments(_SourceSectionAttribute, __SourceSectionAttribute);
			Types._SourceSectionClass.initFragments(_SourceSectionClass, __SourceSectionClass);
			Types._SourceSectionContainmentReference.initFragments(_SourceSectionContainmentReference, __SourceSectionContainmentReference);
			Types._SourceSectionReference.initFragments(_SourceSectionReference, __SourceSectionReference);
			Types._SubstringMatcher.initFragments(_SubstringMatcher, __SubstringMatcher);
			Types._TargetSectionAttribute.initFragments(_TargetSectionAttribute, __TargetSectionAttribute);
			Types._TargetSectionClass.initFragments(_TargetSectionClass, __TargetSectionClass);
			Types._TargetSectionContainmentReference.initFragments(_TargetSectionContainmentReference, __TargetSectionContainmentReference);
			Types._TargetSectionNonContainmentReference.initFragments(_TargetSectionNonContainmentReference, __TargetSectionNonContainmentReference);
			Types._TargetSectionReference.initFragments(_TargetSectionReference, __TargetSectionReference);
			Types._VirtualAttribute.initFragments(_VirtualAttribute, __VirtualAttribute);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::TypeFragments and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorOperation[] _ActualAttribute__ActualAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ActualAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ActualAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ActualAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ActualAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _ActualAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ActualAttribute__TargetSectionAttribute = {};

		private static final /*@NonNull*/ ExecutorOperation[] _Attribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Attribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Attribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Attribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _Attribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _AttributeParameter__AttributeParameter = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraint__AttributeValueConstraint = {
			MetamodelTables.Operations._AttributeValueConstraint__checkConstraint /* checkConstraint(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__AttributeValueConstraintType = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__Class = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__DataType = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__Nameable = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__NamedElement_1 = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__Namespace = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__TemplateableElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _AttributeValueConstraintType__Visitable = {};

		private static final /*@NonNull*/ ExecutorOperation[] _BeginningMatcher__BeginningMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation[] _BeginningMatcher__AttributeValueConstraint = {
			MetamodelTables.Operations._AttributeValueConstraint__checkConstraint /* checkConstraint(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _BeginningMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation[] _BeginningMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _BeginningMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _BeginningMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__CardinalityType = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__Class = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__DataType = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__Element = {
			PivotTables.Operations._Element__allOwnedElements /* allOwnedElements() */,
			PivotTables.Operations._Element__getValue /* getValue(Type[1],String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__Enumeration = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__Nameable = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__NamedElement_1 = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__Namespace = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__OclElement = {
			PivotTables.Operations._Enumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__TemplateableElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__Type = {
			PivotTables.Operations._Type__conformsTo /* conformsTo(Type[?]) */,
			PivotTables.Operations._Type__flattenedType /* flattenedType() */,
			PivotTables.Operations._Type__isClass /* isClass() */,
			PivotTables.Operations._Type__isTemplateParameter /* isTemplateParameter() */,
			PivotTables.Operations._Type__specializeIn /* specializeIn(CallExp[1],Type[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CardinalityType__Visitable = {};

		private static final /*@NonNull*/ ExecutorOperation[] _CaseSensitiveConstraint__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CaseSensitiveConstraint__AttributeValueConstraint = {
			MetamodelTables.Operations._AttributeValueConstraint__checkConstraint /* checkConstraint(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _CaseSensitiveConstraint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _CaseSensitiveConstraint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _CaseSensitiveConstraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _Class__Class_1 = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isSection /* isSection() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Class__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Class__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Class__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _Class__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _ContainerParameter__ContainerParameter = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ContainerParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ContainerParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ContainerParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _ContainerParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _ContainmentReference__ContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _ContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _ContainmentReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation[] _EndingMatcher__EndingMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation[] _EndingMatcher__AttributeValueConstraint = {
			MetamodelTables.Operations._AttributeValueConstraint__checkConstraint /* checkConstraint(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _EndingMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation[] _EndingMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _EndingMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _EndingMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _EqualityMatcher__EqualityMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation[] _EqualityMatcher__AttributeValueConstraint = {
			MetamodelTables.Operations._AttributeValueConstraint__checkConstraint /* checkConstraint(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _EqualityMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation[] _EqualityMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _EqualityMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _EqualityMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _ExternalReferenceParameter__ExternalReferenceParameter = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ExternalReferenceParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ExternalReferenceParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _ExternalReferenceParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _ExternalReferenceParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _LibraryEntry__LibraryEntry = {};
		private static final /*@NonNull*/ ExecutorOperation[] _LibraryEntry__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _LibraryEntry__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _LibraryParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation[] _LibraryParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _LibraryParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _LibraryParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelElement__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelSectionReference__MetaModelSectionReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelSectionReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelSectionReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelSectionReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelSectionReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelSectionReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _MetaModelSectionReference__SourceSectionReference = {
			MetamodelTables.Operations._SourceSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _NonContainmentReference__NonContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _NonContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _NonContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _NonContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _NonContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _NonContainmentReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation[] _Reference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Reference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _Reference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _Reference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _Reference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _RegExMatcher__RegExMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation[] _RegExMatcher__AttributeValueConstraint = {
			MetamodelTables.Operations._AttributeValueConstraint__checkConstraint /* checkConstraint(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _RegExMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _RegExMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _RegExMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionAttribute__SourceSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionClass__SourceSectionClass = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionClass__Class_1 = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isSection /* isSection() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionClass__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionClass__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionClass__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionClass__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__SourceSectionContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__ContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionContainmentReference__SourceSectionReference = {
			MetamodelTables.Operations._SourceSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionReference__SourceSectionReference = {
			MetamodelTables.Operations._SourceSectionReference__getValuesGeneric /* getValuesGeneric() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SourceSectionReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation[] _SubstringMatcher__SubstringMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SubstringMatcher__AttributeValueConstraint = {
			MetamodelTables.Operations._AttributeValueConstraint__checkConstraint /* checkConstraint(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _SubstringMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SubstringMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _SubstringMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _SubstringMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionAttribute__TargetSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionClass__TargetSectionClass = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionClass__Class_1 = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isSection /* isSection() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionClass__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionClass__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionClass__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionClass__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__TargetSectionContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__ContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionContainmentReference__TargetSectionReference = {
			MetamodelTables.Operations._TargetSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__TargetSectionNonContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__NonContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionNonContainmentReference__TargetSectionReference = {
			MetamodelTables.Operations._TargetSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionReference__TargetSectionReference = {
			MetamodelTables.Operations._TargetSectionReference__getValuesGeneric /* getValuesGeneric() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _TargetSectionReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation[] _VirtualAttribute__VirtualAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _VirtualAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation[] _VirtualAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _VirtualAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation[] _VirtualAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation[] _VirtualAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */
		};
		private static final /*@NonNull*/ ExecutorOperation[] _VirtualAttribute__TargetSectionAttribute = {};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._ActualAttribute__ActualAttribute.initOperations(_ActualAttribute__ActualAttribute);
			Fragments._ActualAttribute__Attribute.initOperations(_ActualAttribute__Attribute);
			Fragments._ActualAttribute__MetaModelElement.initOperations(_ActualAttribute__MetaModelElement);
			Fragments._ActualAttribute__NamedElement.initOperations(_ActualAttribute__NamedElement);
			Fragments._ActualAttribute__OclAny.initOperations(_ActualAttribute__OclAny);
			Fragments._ActualAttribute__OclElement.initOperations(_ActualAttribute__OclElement);
			Fragments._ActualAttribute__TargetSectionAttribute.initOperations(_ActualAttribute__TargetSectionAttribute);

			Fragments._Attribute__Attribute.initOperations(_Attribute__Attribute);
			Fragments._Attribute__MetaModelElement.initOperations(_Attribute__MetaModelElement);
			Fragments._Attribute__NamedElement.initOperations(_Attribute__NamedElement);
			Fragments._Attribute__OclAny.initOperations(_Attribute__OclAny);
			Fragments._Attribute__OclElement.initOperations(_Attribute__OclElement);

			Fragments._AttributeParameter__AttributeParameter.initOperations(_AttributeParameter__AttributeParameter);
			Fragments._AttributeParameter__LibraryParameter.initOperations(_AttributeParameter__LibraryParameter);
			Fragments._AttributeParameter__NamedElement.initOperations(_AttributeParameter__NamedElement);
			Fragments._AttributeParameter__OclAny.initOperations(_AttributeParameter__OclAny);
			Fragments._AttributeParameter__OclElement.initOperations(_AttributeParameter__OclElement);

			Fragments._AttributeValueConstraint__AttributeValueConstraint.initOperations(_AttributeValueConstraint__AttributeValueConstraint);
			Fragments._AttributeValueConstraint__NamedElement.initOperations(_AttributeValueConstraint__NamedElement);
			Fragments._AttributeValueConstraint__OclAny.initOperations(_AttributeValueConstraint__OclAny);
			Fragments._AttributeValueConstraint__OclElement.initOperations(_AttributeValueConstraint__OclElement);

			Fragments._AttributeValueConstraintType__AttributeValueConstraintType.initOperations(_AttributeValueConstraintType__AttributeValueConstraintType);
			Fragments._AttributeValueConstraintType__Class.initOperations(_AttributeValueConstraintType__Class);
			Fragments._AttributeValueConstraintType__DataType.initOperations(_AttributeValueConstraintType__DataType);
			Fragments._AttributeValueConstraintType__Element.initOperations(_AttributeValueConstraintType__Element);
			Fragments._AttributeValueConstraintType__Enumeration.initOperations(_AttributeValueConstraintType__Enumeration);
			Fragments._AttributeValueConstraintType__Nameable.initOperations(_AttributeValueConstraintType__Nameable);
			Fragments._AttributeValueConstraintType__NamedElement_1.initOperations(_AttributeValueConstraintType__NamedElement_1);
			Fragments._AttributeValueConstraintType__Namespace.initOperations(_AttributeValueConstraintType__Namespace);
			Fragments._AttributeValueConstraintType__OclAny.initOperations(_AttributeValueConstraintType__OclAny);
			Fragments._AttributeValueConstraintType__OclElement.initOperations(_AttributeValueConstraintType__OclElement);
			Fragments._AttributeValueConstraintType__OclType.initOperations(_AttributeValueConstraintType__OclType);
			Fragments._AttributeValueConstraintType__TemplateableElement.initOperations(_AttributeValueConstraintType__TemplateableElement);
			Fragments._AttributeValueConstraintType__Type.initOperations(_AttributeValueConstraintType__Type);
			Fragments._AttributeValueConstraintType__Visitable.initOperations(_AttributeValueConstraintType__Visitable);

			Fragments._BeginningMatcher__AttributeValueConstraint.initOperations(_BeginningMatcher__AttributeValueConstraint);
			Fragments._BeginningMatcher__BeginningMatcher.initOperations(_BeginningMatcher__BeginningMatcher);
			Fragments._BeginningMatcher__CaseSensitiveConstraint.initOperations(_BeginningMatcher__CaseSensitiveConstraint);
			Fragments._BeginningMatcher__NamedElement.initOperations(_BeginningMatcher__NamedElement);
			Fragments._BeginningMatcher__OclAny.initOperations(_BeginningMatcher__OclAny);
			Fragments._BeginningMatcher__OclElement.initOperations(_BeginningMatcher__OclElement);

			Fragments._CardinalityType__CardinalityType.initOperations(_CardinalityType__CardinalityType);
			Fragments._CardinalityType__Class.initOperations(_CardinalityType__Class);
			Fragments._CardinalityType__DataType.initOperations(_CardinalityType__DataType);
			Fragments._CardinalityType__Element.initOperations(_CardinalityType__Element);
			Fragments._CardinalityType__Enumeration.initOperations(_CardinalityType__Enumeration);
			Fragments._CardinalityType__Nameable.initOperations(_CardinalityType__Nameable);
			Fragments._CardinalityType__NamedElement_1.initOperations(_CardinalityType__NamedElement_1);
			Fragments._CardinalityType__Namespace.initOperations(_CardinalityType__Namespace);
			Fragments._CardinalityType__OclAny.initOperations(_CardinalityType__OclAny);
			Fragments._CardinalityType__OclElement.initOperations(_CardinalityType__OclElement);
			Fragments._CardinalityType__OclType.initOperations(_CardinalityType__OclType);
			Fragments._CardinalityType__TemplateableElement.initOperations(_CardinalityType__TemplateableElement);
			Fragments._CardinalityType__Type.initOperations(_CardinalityType__Type);
			Fragments._CardinalityType__Visitable.initOperations(_CardinalityType__Visitable);

			Fragments._CaseSensitiveConstraint__AttributeValueConstraint.initOperations(_CaseSensitiveConstraint__AttributeValueConstraint);
			Fragments._CaseSensitiveConstraint__CaseSensitiveConstraint.initOperations(_CaseSensitiveConstraint__CaseSensitiveConstraint);
			Fragments._CaseSensitiveConstraint__NamedElement.initOperations(_CaseSensitiveConstraint__NamedElement);
			Fragments._CaseSensitiveConstraint__OclAny.initOperations(_CaseSensitiveConstraint__OclAny);
			Fragments._CaseSensitiveConstraint__OclElement.initOperations(_CaseSensitiveConstraint__OclElement);

			Fragments._Class__Class_1.initOperations(_Class__Class_1);
			Fragments._Class__MetaModelElement.initOperations(_Class__MetaModelElement);
			Fragments._Class__NamedElement.initOperations(_Class__NamedElement);
			Fragments._Class__OclAny.initOperations(_Class__OclAny);
			Fragments._Class__OclElement.initOperations(_Class__OclElement);

			Fragments._ContainerParameter__ContainerParameter.initOperations(_ContainerParameter__ContainerParameter);
			Fragments._ContainerParameter__LibraryParameter.initOperations(_ContainerParameter__LibraryParameter);
			Fragments._ContainerParameter__NamedElement.initOperations(_ContainerParameter__NamedElement);
			Fragments._ContainerParameter__OclAny.initOperations(_ContainerParameter__OclAny);
			Fragments._ContainerParameter__OclElement.initOperations(_ContainerParameter__OclElement);

			Fragments._ContainmentReference__ContainmentReference.initOperations(_ContainmentReference__ContainmentReference);
			Fragments._ContainmentReference__MetaModelElement.initOperations(_ContainmentReference__MetaModelElement);
			Fragments._ContainmentReference__NamedElement.initOperations(_ContainmentReference__NamedElement);
			Fragments._ContainmentReference__OclAny.initOperations(_ContainmentReference__OclAny);
			Fragments._ContainmentReference__OclElement.initOperations(_ContainmentReference__OclElement);
			Fragments._ContainmentReference__Reference.initOperations(_ContainmentReference__Reference);

			Fragments._EndingMatcher__AttributeValueConstraint.initOperations(_EndingMatcher__AttributeValueConstraint);
			Fragments._EndingMatcher__CaseSensitiveConstraint.initOperations(_EndingMatcher__CaseSensitiveConstraint);
			Fragments._EndingMatcher__EndingMatcher.initOperations(_EndingMatcher__EndingMatcher);
			Fragments._EndingMatcher__NamedElement.initOperations(_EndingMatcher__NamedElement);
			Fragments._EndingMatcher__OclAny.initOperations(_EndingMatcher__OclAny);
			Fragments._EndingMatcher__OclElement.initOperations(_EndingMatcher__OclElement);

			Fragments._EqualityMatcher__AttributeValueConstraint.initOperations(_EqualityMatcher__AttributeValueConstraint);
			Fragments._EqualityMatcher__CaseSensitiveConstraint.initOperations(_EqualityMatcher__CaseSensitiveConstraint);
			Fragments._EqualityMatcher__EqualityMatcher.initOperations(_EqualityMatcher__EqualityMatcher);
			Fragments._EqualityMatcher__NamedElement.initOperations(_EqualityMatcher__NamedElement);
			Fragments._EqualityMatcher__OclAny.initOperations(_EqualityMatcher__OclAny);
			Fragments._EqualityMatcher__OclElement.initOperations(_EqualityMatcher__OclElement);

			Fragments._ExternalReferenceParameter__ExternalReferenceParameter.initOperations(_ExternalReferenceParameter__ExternalReferenceParameter);
			Fragments._ExternalReferenceParameter__LibraryParameter.initOperations(_ExternalReferenceParameter__LibraryParameter);
			Fragments._ExternalReferenceParameter__NamedElement.initOperations(_ExternalReferenceParameter__NamedElement);
			Fragments._ExternalReferenceParameter__OclAny.initOperations(_ExternalReferenceParameter__OclAny);
			Fragments._ExternalReferenceParameter__OclElement.initOperations(_ExternalReferenceParameter__OclElement);

			Fragments._LibraryEntry__LibraryEntry.initOperations(_LibraryEntry__LibraryEntry);
			Fragments._LibraryEntry__OclAny.initOperations(_LibraryEntry__OclAny);
			Fragments._LibraryEntry__OclElement.initOperations(_LibraryEntry__OclElement);

			Fragments._LibraryParameter__LibraryParameter.initOperations(_LibraryParameter__LibraryParameter);
			Fragments._LibraryParameter__NamedElement.initOperations(_LibraryParameter__NamedElement);
			Fragments._LibraryParameter__OclAny.initOperations(_LibraryParameter__OclAny);
			Fragments._LibraryParameter__OclElement.initOperations(_LibraryParameter__OclElement);

			Fragments._MetaModelElement__MetaModelElement.initOperations(_MetaModelElement__MetaModelElement);
			Fragments._MetaModelElement__NamedElement.initOperations(_MetaModelElement__NamedElement);
			Fragments._MetaModelElement__OclAny.initOperations(_MetaModelElement__OclAny);
			Fragments._MetaModelElement__OclElement.initOperations(_MetaModelElement__OclElement);

			Fragments._MetaModelSectionReference__MetaModelElement.initOperations(_MetaModelSectionReference__MetaModelElement);
			Fragments._MetaModelSectionReference__MetaModelSectionReference.initOperations(_MetaModelSectionReference__MetaModelSectionReference);
			Fragments._MetaModelSectionReference__NamedElement.initOperations(_MetaModelSectionReference__NamedElement);
			Fragments._MetaModelSectionReference__OclAny.initOperations(_MetaModelSectionReference__OclAny);
			Fragments._MetaModelSectionReference__OclElement.initOperations(_MetaModelSectionReference__OclElement);
			Fragments._MetaModelSectionReference__Reference.initOperations(_MetaModelSectionReference__Reference);
			Fragments._MetaModelSectionReference__SourceSectionReference.initOperations(_MetaModelSectionReference__SourceSectionReference);

			Fragments._NonContainmentReference__MetaModelElement.initOperations(_NonContainmentReference__MetaModelElement);
			Fragments._NonContainmentReference__NamedElement.initOperations(_NonContainmentReference__NamedElement);
			Fragments._NonContainmentReference__NonContainmentReference.initOperations(_NonContainmentReference__NonContainmentReference);
			Fragments._NonContainmentReference__OclAny.initOperations(_NonContainmentReference__OclAny);
			Fragments._NonContainmentReference__OclElement.initOperations(_NonContainmentReference__OclElement);
			Fragments._NonContainmentReference__Reference.initOperations(_NonContainmentReference__Reference);

			Fragments._Reference__MetaModelElement.initOperations(_Reference__MetaModelElement);
			Fragments._Reference__NamedElement.initOperations(_Reference__NamedElement);
			Fragments._Reference__OclAny.initOperations(_Reference__OclAny);
			Fragments._Reference__OclElement.initOperations(_Reference__OclElement);
			Fragments._Reference__Reference.initOperations(_Reference__Reference);

			Fragments._RegExMatcher__AttributeValueConstraint.initOperations(_RegExMatcher__AttributeValueConstraint);
			Fragments._RegExMatcher__NamedElement.initOperations(_RegExMatcher__NamedElement);
			Fragments._RegExMatcher__OclAny.initOperations(_RegExMatcher__OclAny);
			Fragments._RegExMatcher__OclElement.initOperations(_RegExMatcher__OclElement);
			Fragments._RegExMatcher__RegExMatcher.initOperations(_RegExMatcher__RegExMatcher);

			Fragments._SourceSectionAttribute__Attribute.initOperations(_SourceSectionAttribute__Attribute);
			Fragments._SourceSectionAttribute__MetaModelElement.initOperations(_SourceSectionAttribute__MetaModelElement);
			Fragments._SourceSectionAttribute__NamedElement.initOperations(_SourceSectionAttribute__NamedElement);
			Fragments._SourceSectionAttribute__OclAny.initOperations(_SourceSectionAttribute__OclAny);
			Fragments._SourceSectionAttribute__OclElement.initOperations(_SourceSectionAttribute__OclElement);
			Fragments._SourceSectionAttribute__SourceSectionAttribute.initOperations(_SourceSectionAttribute__SourceSectionAttribute);

			Fragments._SourceSectionClass__Class_1.initOperations(_SourceSectionClass__Class_1);
			Fragments._SourceSectionClass__MetaModelElement.initOperations(_SourceSectionClass__MetaModelElement);
			Fragments._SourceSectionClass__NamedElement.initOperations(_SourceSectionClass__NamedElement);
			Fragments._SourceSectionClass__OclAny.initOperations(_SourceSectionClass__OclAny);
			Fragments._SourceSectionClass__OclElement.initOperations(_SourceSectionClass__OclElement);
			Fragments._SourceSectionClass__SourceSectionClass.initOperations(_SourceSectionClass__SourceSectionClass);

			Fragments._SourceSectionContainmentReference__ContainmentReference.initOperations(_SourceSectionContainmentReference__ContainmentReference);
			Fragments._SourceSectionContainmentReference__MetaModelElement.initOperations(_SourceSectionContainmentReference__MetaModelElement);
			Fragments._SourceSectionContainmentReference__NamedElement.initOperations(_SourceSectionContainmentReference__NamedElement);
			Fragments._SourceSectionContainmentReference__OclAny.initOperations(_SourceSectionContainmentReference__OclAny);
			Fragments._SourceSectionContainmentReference__OclElement.initOperations(_SourceSectionContainmentReference__OclElement);
			Fragments._SourceSectionContainmentReference__Reference.initOperations(_SourceSectionContainmentReference__Reference);
			Fragments._SourceSectionContainmentReference__SourceSectionContainmentReference.initOperations(_SourceSectionContainmentReference__SourceSectionContainmentReference);
			Fragments._SourceSectionContainmentReference__SourceSectionReference.initOperations(_SourceSectionContainmentReference__SourceSectionReference);

			Fragments._SourceSectionReference__MetaModelElement.initOperations(_SourceSectionReference__MetaModelElement);
			Fragments._SourceSectionReference__NamedElement.initOperations(_SourceSectionReference__NamedElement);
			Fragments._SourceSectionReference__OclAny.initOperations(_SourceSectionReference__OclAny);
			Fragments._SourceSectionReference__OclElement.initOperations(_SourceSectionReference__OclElement);
			Fragments._SourceSectionReference__Reference.initOperations(_SourceSectionReference__Reference);
			Fragments._SourceSectionReference__SourceSectionReference.initOperations(_SourceSectionReference__SourceSectionReference);

			Fragments._SubstringMatcher__AttributeValueConstraint.initOperations(_SubstringMatcher__AttributeValueConstraint);
			Fragments._SubstringMatcher__CaseSensitiveConstraint.initOperations(_SubstringMatcher__CaseSensitiveConstraint);
			Fragments._SubstringMatcher__NamedElement.initOperations(_SubstringMatcher__NamedElement);
			Fragments._SubstringMatcher__OclAny.initOperations(_SubstringMatcher__OclAny);
			Fragments._SubstringMatcher__OclElement.initOperations(_SubstringMatcher__OclElement);
			Fragments._SubstringMatcher__SubstringMatcher.initOperations(_SubstringMatcher__SubstringMatcher);

			Fragments._TargetSectionAttribute__Attribute.initOperations(_TargetSectionAttribute__Attribute);
			Fragments._TargetSectionAttribute__MetaModelElement.initOperations(_TargetSectionAttribute__MetaModelElement);
			Fragments._TargetSectionAttribute__NamedElement.initOperations(_TargetSectionAttribute__NamedElement);
			Fragments._TargetSectionAttribute__OclAny.initOperations(_TargetSectionAttribute__OclAny);
			Fragments._TargetSectionAttribute__OclElement.initOperations(_TargetSectionAttribute__OclElement);
			Fragments._TargetSectionAttribute__TargetSectionAttribute.initOperations(_TargetSectionAttribute__TargetSectionAttribute);

			Fragments._TargetSectionClass__Class_1.initOperations(_TargetSectionClass__Class_1);
			Fragments._TargetSectionClass__MetaModelElement.initOperations(_TargetSectionClass__MetaModelElement);
			Fragments._TargetSectionClass__NamedElement.initOperations(_TargetSectionClass__NamedElement);
			Fragments._TargetSectionClass__OclAny.initOperations(_TargetSectionClass__OclAny);
			Fragments._TargetSectionClass__OclElement.initOperations(_TargetSectionClass__OclElement);
			Fragments._TargetSectionClass__TargetSectionClass.initOperations(_TargetSectionClass__TargetSectionClass);

			Fragments._TargetSectionContainmentReference__ContainmentReference.initOperations(_TargetSectionContainmentReference__ContainmentReference);
			Fragments._TargetSectionContainmentReference__MetaModelElement.initOperations(_TargetSectionContainmentReference__MetaModelElement);
			Fragments._TargetSectionContainmentReference__NamedElement.initOperations(_TargetSectionContainmentReference__NamedElement);
			Fragments._TargetSectionContainmentReference__OclAny.initOperations(_TargetSectionContainmentReference__OclAny);
			Fragments._TargetSectionContainmentReference__OclElement.initOperations(_TargetSectionContainmentReference__OclElement);
			Fragments._TargetSectionContainmentReference__Reference.initOperations(_TargetSectionContainmentReference__Reference);
			Fragments._TargetSectionContainmentReference__TargetSectionContainmentReference.initOperations(_TargetSectionContainmentReference__TargetSectionContainmentReference);
			Fragments._TargetSectionContainmentReference__TargetSectionReference.initOperations(_TargetSectionContainmentReference__TargetSectionReference);

			Fragments._TargetSectionNonContainmentReference__MetaModelElement.initOperations(_TargetSectionNonContainmentReference__MetaModelElement);
			Fragments._TargetSectionNonContainmentReference__NamedElement.initOperations(_TargetSectionNonContainmentReference__NamedElement);
			Fragments._TargetSectionNonContainmentReference__NonContainmentReference.initOperations(_TargetSectionNonContainmentReference__NonContainmentReference);
			Fragments._TargetSectionNonContainmentReference__OclAny.initOperations(_TargetSectionNonContainmentReference__OclAny);
			Fragments._TargetSectionNonContainmentReference__OclElement.initOperations(_TargetSectionNonContainmentReference__OclElement);
			Fragments._TargetSectionNonContainmentReference__Reference.initOperations(_TargetSectionNonContainmentReference__Reference);
			Fragments._TargetSectionNonContainmentReference__TargetSectionNonContainmentReference.initOperations(_TargetSectionNonContainmentReference__TargetSectionNonContainmentReference);
			Fragments._TargetSectionNonContainmentReference__TargetSectionReference.initOperations(_TargetSectionNonContainmentReference__TargetSectionReference);

			Fragments._TargetSectionReference__MetaModelElement.initOperations(_TargetSectionReference__MetaModelElement);
			Fragments._TargetSectionReference__NamedElement.initOperations(_TargetSectionReference__NamedElement);
			Fragments._TargetSectionReference__OclAny.initOperations(_TargetSectionReference__OclAny);
			Fragments._TargetSectionReference__OclElement.initOperations(_TargetSectionReference__OclElement);
			Fragments._TargetSectionReference__Reference.initOperations(_TargetSectionReference__Reference);
			Fragments._TargetSectionReference__TargetSectionReference.initOperations(_TargetSectionReference__TargetSectionReference);

			Fragments._VirtualAttribute__Attribute.initOperations(_VirtualAttribute__Attribute);
			Fragments._VirtualAttribute__MetaModelElement.initOperations(_VirtualAttribute__MetaModelElement);
			Fragments._VirtualAttribute__NamedElement.initOperations(_VirtualAttribute__NamedElement);
			Fragments._VirtualAttribute__OclAny.initOperations(_VirtualAttribute__OclAny);
			Fragments._VirtualAttribute__OclElement.initOperations(_VirtualAttribute__OclElement);
			Fragments._VirtualAttribute__TargetSectionAttribute.initOperations(_VirtualAttribute__TargetSectionAttribute);
			Fragments._VirtualAttribute__VirtualAttribute.initOperations(_VirtualAttribute__VirtualAttribute);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::FragmentOperations and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorProperty[] _ActualAttribute = {
			MetamodelTables.Properties._ActualAttribute__attribute,
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._TargetSectionAttribute__unique,
			MetamodelTables.Properties._TargetSectionAttribute__value,
			MetamodelTables.Properties._ActualAttribute__AttributeParameter__attribute
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Attribute = {
			MetamodelTables.Properties._Attribute__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty[] _AttributeParameter = {
			MetamodelTables.Properties._AttributeParameter__attribute,
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty[] _AttributeValueConstraint = {
			MetamodelTables.Properties._AttributeValueConstraint__type,
			MetamodelTables.Properties._AttributeValueConstraint__value,
			MetamodelTables.Properties._AttributeValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _AttributeValueConstraintType = {};

		private static final /*@NonNull*/ ExecutorProperty[] _BeginningMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._AttributeValueConstraint__type,
			MetamodelTables.Properties._AttributeValueConstraint__value,
			MetamodelTables.Properties._AttributeValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _CardinalityType = {};

		private static final /*@NonNull*/ ExecutorProperty[] _CaseSensitiveConstraint = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._AttributeValueConstraint__type,
			MetamodelTables.Properties._AttributeValueConstraint__value,
			MetamodelTables.Properties._AttributeValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Class = {
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Class__references
		};

		private static final /*@NonNull*/ ExecutorProperty[] _ContainerParameter = {
			MetamodelTables.Properties._ContainerParameter__class,
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty[] _ContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._ContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty[] _EndingMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._AttributeValueConstraint__type,
			MetamodelTables.Properties._AttributeValueConstraint__value,
			MetamodelTables.Properties._AttributeValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _EqualityMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._AttributeValueConstraint__type,
			MetamodelTables.Properties._AttributeValueConstraint__value,
			MetamodelTables.Properties._AttributeValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _ExternalReferenceParameter = {
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._ExternalReferenceParameter__reference,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty[] _LibraryEntry = {
			MetamodelTables.Properties._LibraryEntry__libraryFile,
			MetamodelTables.Properties._LibraryEntry__originalLibraryEntry,
			MetamodelTables.Properties._LibraryEntry__parameters,
			MetamodelTables.Properties._LibraryEntry__path
		};

		private static final /*@NonNull*/ ExecutorProperty[] _LibraryParameter = {
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty[] _MetaModelElement = {};

		private static final /*@NonNull*/ ExecutorProperty[] _MetaModelSectionReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._MetaModelSectionReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty[] _NonContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._NonContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty[] _Reference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty[] _RegExMatcher = {
			MetamodelTables.Properties._AttributeValueConstraint__type,
			MetamodelTables.Properties._AttributeValueConstraint__value,
			MetamodelTables.Properties._AttributeValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SourceSectionAttribute = {
			MetamodelTables.Properties._SourceSectionAttribute__attribute,
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SourceSectionClass = {
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Class__references,
			MetamodelTables.Properties._SourceSectionClass__referencingMappings,
			MetamodelTables.Properties._SourceSectionClass__MetaModelSectionReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SourceSectionContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._ContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SourceSectionReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty[] _SubstringMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._AttributeValueConstraint__type,
			MetamodelTables.Properties._AttributeValueConstraint__value,
			MetamodelTables.Properties._AttributeValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TargetSectionAttribute = {
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._TargetSectionAttribute__unique,
			MetamodelTables.Properties._TargetSectionAttribute__value
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TargetSectionClass = {
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Class__references,
			MetamodelTables.Properties._TargetSectionClass__referencingMappingHintGroups,
			MetamodelTables.Properties._TargetSectionClass__ContainerParameter__class
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TargetSectionContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._ContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TargetSectionNonContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._NonContainmentReference__value,
			MetamodelTables.Properties._TargetSectionNonContainmentReference__ExternalReferenceParameter__reference
		};

		private static final /*@NonNull*/ ExecutorProperty[] _TargetSectionReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty[] _VirtualAttribute = {
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._TargetSectionAttribute__unique,
			MetamodelTables.Properties._TargetSectionAttribute__value
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._ActualAttribute__ActualAttribute.initProperties(_ActualAttribute);
			Fragments._Attribute__Attribute.initProperties(_Attribute);
			Fragments._AttributeParameter__AttributeParameter.initProperties(_AttributeParameter);
			Fragments._AttributeValueConstraint__AttributeValueConstraint.initProperties(_AttributeValueConstraint);
			Fragments._AttributeValueConstraintType__AttributeValueConstraintType.initProperties(_AttributeValueConstraintType);
			Fragments._BeginningMatcher__BeginningMatcher.initProperties(_BeginningMatcher);
			Fragments._CardinalityType__CardinalityType.initProperties(_CardinalityType);
			Fragments._CaseSensitiveConstraint__CaseSensitiveConstraint.initProperties(_CaseSensitiveConstraint);
			Fragments._Class__Class_1.initProperties(_Class);
			Fragments._ContainerParameter__ContainerParameter.initProperties(_ContainerParameter);
			Fragments._ContainmentReference__ContainmentReference.initProperties(_ContainmentReference);
			Fragments._EndingMatcher__EndingMatcher.initProperties(_EndingMatcher);
			Fragments._EqualityMatcher__EqualityMatcher.initProperties(_EqualityMatcher);
			Fragments._ExternalReferenceParameter__ExternalReferenceParameter.initProperties(_ExternalReferenceParameter);
			Fragments._LibraryEntry__LibraryEntry.initProperties(_LibraryEntry);
			Fragments._LibraryParameter__LibraryParameter.initProperties(_LibraryParameter);
			Fragments._MetaModelElement__MetaModelElement.initProperties(_MetaModelElement);
			Fragments._MetaModelSectionReference__MetaModelSectionReference.initProperties(_MetaModelSectionReference);
			Fragments._NonContainmentReference__NonContainmentReference.initProperties(_NonContainmentReference);
			Fragments._Reference__Reference.initProperties(_Reference);
			Fragments._RegExMatcher__RegExMatcher.initProperties(_RegExMatcher);
			Fragments._SourceSectionAttribute__SourceSectionAttribute.initProperties(_SourceSectionAttribute);
			Fragments._SourceSectionClass__SourceSectionClass.initProperties(_SourceSectionClass);
			Fragments._SourceSectionContainmentReference__SourceSectionContainmentReference.initProperties(_SourceSectionContainmentReference);
			Fragments._SourceSectionReference__SourceSectionReference.initProperties(_SourceSectionReference);
			Fragments._SubstringMatcher__SubstringMatcher.initProperties(_SubstringMatcher);
			Fragments._TargetSectionAttribute__TargetSectionAttribute.initProperties(_TargetSectionAttribute);
			Fragments._TargetSectionClass__TargetSectionClass.initProperties(_TargetSectionClass);
			Fragments._TargetSectionContainmentReference__TargetSectionContainmentReference.initProperties(_TargetSectionContainmentReference);
			Fragments._TargetSectionNonContainmentReference__TargetSectionNonContainmentReference.initProperties(_TargetSectionNonContainmentReference);
			Fragments._TargetSectionReference__TargetSectionReference.initProperties(_TargetSectionReference);
			Fragments._VirtualAttribute__VirtualAttribute.initProperties(_VirtualAttribute);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::FragmentProperties and all preceding sub-packages.
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

		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _AttributeValueConstraintType__INCLUSION = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT_TYPE.getEEnumLiteral("INCLUSION"), Types._AttributeValueConstraintType, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _AttributeValueConstraintType__EXCLUSION = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT_TYPE.getEEnumLiteral("EXCLUSION"), Types._AttributeValueConstraintType, 1);
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral[] _AttributeValueConstraintType = {
			_AttributeValueConstraintType__INCLUSION,
			_AttributeValueConstraintType__EXCLUSION
		};

		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CardinalityType__ONE = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.CARDINALITY_TYPE.getEEnumLiteral("ONE"), Types._CardinalityType, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CardinalityType__ONE__INFINITY = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.CARDINALITY_TYPE.getEEnumLiteral("ONE__INFINITY"), Types._CardinalityType, 1);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CardinalityType__ZERO__INFINITY = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.CARDINALITY_TYPE.getEEnumLiteral("ZERO__INFINITY"), Types._CardinalityType, 2);
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral[] _CardinalityType = {
			_CardinalityType__ONE,
			_CardinalityType__ONE__INFINITY,
			_CardinalityType__ZERO__INFINITY
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._AttributeValueConstraintType.initLiterals(_AttributeValueConstraintType);
			Types._CardinalityType.initLiterals(_CardinalityType);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MetamodelTables::EnumerationLiterals and all preceding sub-packages.
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
