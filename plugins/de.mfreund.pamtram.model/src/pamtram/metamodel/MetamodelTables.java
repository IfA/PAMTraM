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

import org.eclipse.ocl.pivot.ParameterTypes;
import org.eclipse.ocl.pivot.TemplateParameters;
import org.eclipse.ocl.pivot.ids.IdManager;
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
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSpecializedType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorTypeParameter;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.TypeUtil;
import pamtram.PamtramTables;
import pamtram.mapping.MappingTables;
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
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_TMPLid_ = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(2));
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_TMPLid__0 = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(3));
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.RootPackageId PACKid_$metamodel$ = org.eclipse.ocl.pivot.ids.IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, pamtram.PamtramPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/condition", null, pamtram.condition.ConditionPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/mapping", null, pamtram.mapping.MappingPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/metamodel", null, pamtram.metamodel.MetamodelPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/ocl/2015/Orphanage", "orphanage", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_www_et_tu_m_dresden_de_s_ifa_s_agtele_s_genlib = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.et.tu-dresden.de/ifa/agtele/genlib", null, de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ActualAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ActualAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ActualSourceSectionAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ActualSourceSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ActualTargetSectionAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ActualTargetSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeCondition = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("AttributeCondition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMapping = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMapping", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMatcher = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMatcher", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeParameter = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("AttributeParameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_CardinalityCondition = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("CardinalityCondition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_CardinalityMapping = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("CardinalityMapping", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Class = pamtram.metamodel.MetamodelTables.PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ClassMatcher = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ClassMatcher", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Class_0 = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ComplexCondition = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("ComplexCondition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Condition = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_condition.getClassId("Condition", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ContainerParameter = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ContainerParameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ContainmentReference = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage.getClassId("ContainmentReference", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EClass = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EClass", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EObject = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EReference = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EReference", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ExternalReferenceParameter = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ExternalReferenceParameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_FileAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("FileAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_GlobalAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("GlobalAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_GlobalModifiedAttributeElementType = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("GlobalModifiedAttributeElementType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_InstancePointer = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("InstancePointer", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_InstancePointerSourceInterface = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("InstancePointerSourceInterface", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_LibraryEntry = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("LibraryEntry", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_LibraryEntry_0 = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_et_tu_m_dresden_de_s_ifa_s_agtele_s_genlib.getClassId("LibraryEntry", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_LibraryParameter = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage.getClassId("LibraryParameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingHintGroupImporter = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintGroupImporter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingHintGroupType = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintGroupType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingType = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MetaModelSectionReference = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("MetaModelSectionReference", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModifiedAttributeElementType = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModifiedAttributeElementType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_OclElement = pamtram.metamodel.MetamodelTables.PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_PAMTraM = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("PAMTraM", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_RangeBound = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("RangeBound", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_RangeConstraint = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("RangeConstraint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ReferenceTargetSelector = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ReferenceTargetSelector", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ResourceParameter = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_et_tu_m_dresden_de_s_ifa_s_agtele_s_genlib.getClassId("ResourceParameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ResourceParameter_0 = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ResourceParameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SectionModel = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_www_eclipse_org_s_ocl_s_2015_s_Orphanage.getClassId("SectionModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SingleReferenceValueConstraint = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SingleReferenceValueConstraint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSectionAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSectionClass = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionClass", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSection = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSection", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSectionClass = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSectionClass", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSectionModel = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("TargetSectionModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSectionNonContainmentReference = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSectionNonContainmentReference", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ValueConstraint = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ValueConstraint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ValueConstraintSourceInterface = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ValueConstraintSourceInterface", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_VirtualTargetSectionAttribute = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("VirtualTargetSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.EnumerationId ENUMid_CardinalityType = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getEnumerationId("CardinalityType");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.EnumerationId ENUMid_FileTypeEnum = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getEnumerationId("FileTypeEnum");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.EnumerationId ENUMid_ValueConstraintType = pamtram.metamodel.MetamodelTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getEnumerationId("ValueConstraintType");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_0 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("0");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_4 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("4");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_TMPLid__1 = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(0));
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_TMPLid__2 = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(1));
    public static final /*@NonInvalid*/ java.lang.String STR_ActualAttribute_c_c_attributeMatchesParentEClass = "ActualAttribute::attributeMatchesParentEClass";
    public static final /*@NonInvalid*/ java.lang.String STR_InstancePointer_c_c_noModifiedAttributeElementTypesInConditionModel = "InstancePointer::noModifiedAttributeElementTypesInConditionModelConditions";
    public static final /*@NonInvalid*/ java.lang.String STR_MetaModelSectionReference_c_c_valuesMatchReferenceType = "MetaModelSectionReference::valuesMatchReferenceType";
    public static final /*@NonInvalid*/ java.lang.String STR_ModifiedAttributeElementTypes_32_are_32_not_32_allowed_32_as_32_part_32_of_32_Conditi = "ModifiedAttributeElementTypes are not allowed as part of ConditionModelConditions!";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_eAttribute_32_39 = "The eAttribute \'";
    public static final /*@NonInvalid*/ java.lang.String STR__32_of_32_the_32_selected_32_target_32_Classes_32_o_Value_e_32_are_32_not_32_allowed_32_by_32_the_32_s = " of the selected target Classes (Value) are not allowed by the selected eReference \'";
    public static final /*@NonInvalid*/ java.lang.String STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_Class_33 = "\' is not allowed by the containing Class!";
    public static final /*@NonInvalid*/ java.lang.String STR__39_33 = "\'!";
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_AttributeCondition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_AttributeCondition);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_AttributeMapping = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_AttributeMapping);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_AttributeMatcher = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_AttributeMatcher);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_CardinalityCondition = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_CardinalityCondition);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_CardinalityMapping = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_CardinalityMapping);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_ClassMatcher = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_ClassMatcher);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_GlobalAttribute = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_GlobalAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_InstancePointer = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_InstancePointer);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_MappingHintGroupImporter = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_MappingHintGroupImporter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_MappingHintGroupType = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_MappingHintGroupType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_MappingType = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_MappingType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_MetaModelSectionReference = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_MetaModelSectionReference);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_PAMTraM = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_PAMTraM);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_ReferenceTargetSelector = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_ReferenceTargetSelector);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_TargetSection = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_TargetSection);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_EAttribute = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_EAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_InstancePointer = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_InstancePointer);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_InstancePointerSourceInterface = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_InstancePointerSourceInterface);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_LibraryParameter = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_LibraryParameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_MappingHintGroupType = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_MappingHintGroupType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_MappingType = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_MappingType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ResourceParameter = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_ResourceParameter_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_SourceSectionClass = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_SourceSectionClass);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_TargetSectionClass = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_TargetSectionClass);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ValueConstraint = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_ValueConstraint);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ValueConstraintSourceInterface = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.metamodel.MetamodelTables.CLSSid_ValueConstraintSourceInterface);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			MetamodelTables.init();
		}

		public static final /*@NonNull*/ ExecutorTypeParameter _ActualAttribute_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _ActualAttribute_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _ActualAttribute_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _ActualAttribute_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _Attribute_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _Attribute_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _Attribute_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _Attribute_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _Class_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _Class_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _Class_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _Class_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _ContainmentReference_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _ContainmentReference_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _ContainmentReference_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _ContainmentReference_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _LibraryParameter_ParameterType = new ExecutorTypeParameter(TypeId.T_1, "ParameterType");

		public static final /*@NonNull*/ ExecutorTypeParameter _MetaModelElement_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _MetaModelElement_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _MetaModelElement_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _MetaModelElement_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _NonContainmentReference_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _NonContainmentReference_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _NonContainmentReference_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _NonContainmentReference_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _Reference_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _Reference_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _Reference_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _Reference_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _Section_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _Section_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _Section_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _Section_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _VirtualAttribute_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _VirtualAttribute_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _VirtualAttribute_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _VirtualAttribute_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

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

		public static final /*@NonNull*/ EcoreExecutorType _ActualAttribute = new EcoreExecutorType(MetamodelPackage.Literals.ACTUAL_ATTRIBUTE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._ActualAttribute_S, TypeParameters._ActualAttribute_C, TypeParameters._ActualAttribute_R, TypeParameters._ActualAttribute_A);
		public static final /*@NonNull*/ EcoreExecutorType _ActualSourceSectionAttribute = new EcoreExecutorType(MetamodelPackage.Literals.ACTUAL_SOURCE_SECTION_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ActualTargetSectionAttribute = new EcoreExecutorType(MetamodelPackage.Literals.ACTUAL_TARGET_SECTION_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Attribute = new EcoreExecutorType(MetamodelPackage.Literals.ATTRIBUTE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._Attribute_S, TypeParameters._Attribute_C, TypeParameters._Attribute_R, TypeParameters._Attribute_A);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeParameter = new EcoreExecutorType(MetamodelPackage.Literals.ATTRIBUTE_PARAMETER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _BeginningMatcher = new EcoreExecutorType(MetamodelPackage.Literals.BEGINNING_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _CardinalityType = new EcoreExecutorEnumeration(MetamodelPackage.Literals.CARDINALITY_TYPE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _CaseSensitiveConstraint = new EcoreExecutorType(MetamodelPackage.Literals.CASE_SENSITIVE_CONSTRAINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _Class = new EcoreExecutorType(MetamodelPackage.Literals.CLASS, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._Class_S, TypeParameters._Class_C, TypeParameters._Class_R, TypeParameters._Class_A);
		public static final /*@NonNull*/ EcoreExecutorType _ContainerParameter = new EcoreExecutorType(MetamodelPackage.Literals.CONTAINER_PARAMETER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.CONTAINMENT_REFERENCE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._ContainmentReference_S, TypeParameters._ContainmentReference_C, TypeParameters._ContainmentReference_R, TypeParameters._ContainmentReference_A);
		public static final /*@NonNull*/ EcoreExecutorType _EndingMatcher = new EcoreExecutorType(MetamodelPackage.Literals.ENDING_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _EqualityMatcher = new EcoreExecutorType(MetamodelPackage.Literals.EQUALITY_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ExternalReferenceParameter = new EcoreExecutorType(MetamodelPackage.Literals.EXTERNAL_REFERENCE_PARAMETER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _FileAttribute = new EcoreExecutorType(MetamodelPackage.Literals.FILE_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _FileTypeEnum = new EcoreExecutorEnumeration(MetamodelPackage.Literals.FILE_TYPE_ENUM, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _InstancePointer = new EcoreExecutorType(MetamodelPackage.Literals.INSTANCE_POINTER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _InstancePointerExternalSourceElement = new EcoreExecutorType(MetamodelPackage.Literals.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _InstancePointerSourceElement = new EcoreExecutorType(MetamodelPackage.Literals.INSTANCE_POINTER_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _InstancePointerSourceInterface = new EcoreExecutorType(MetamodelPackage.Literals.INSTANCE_POINTER_SOURCE_INTERFACE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _LibraryEntry = new EcoreExecutorType(MetamodelPackage.Literals.LIBRARY_ENTRY, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _LibraryParameter = new EcoreExecutorType(MetamodelPackage.Literals.LIBRARY_PARAMETER, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._LibraryParameter_ParameterType);
		public static final /*@NonNull*/ EcoreExecutorType _MetaModelElement = new EcoreExecutorType(MetamodelPackage.Literals.META_MODEL_ELEMENT, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._MetaModelElement_S, TypeParameters._MetaModelElement_C, TypeParameters._MetaModelElement_R, TypeParameters._MetaModelElement_A);
		public static final /*@NonNull*/ EcoreExecutorType _MetaModelSectionReference = new EcoreExecutorType(MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MultipleReferencesValueConstraint = new EcoreExecutorType(MetamodelPackage.Literals.MULTIPLE_REFERENCES_VALUE_CONSTRAINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _NonContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._NonContainmentReference_S, TypeParameters._NonContainmentReference_C, TypeParameters._NonContainmentReference_R, TypeParameters._NonContainmentReference_A);
		public static final /*@NonNull*/ EcoreExecutorType _RangeBound = new EcoreExecutorType(MetamodelPackage.Literals.RANGE_BOUND, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _RangeConstraint = new EcoreExecutorType(MetamodelPackage.Literals.RANGE_CONSTRAINT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Reference = new EcoreExecutorType(MetamodelPackage.Literals.REFERENCE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._Reference_S, TypeParameters._Reference_C, TypeParameters._Reference_R, TypeParameters._Reference_A);
		public static final /*@NonNull*/ EcoreExecutorType _RegExMatcher = new EcoreExecutorType(MetamodelPackage.Literals.REG_EX_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ResourceParameter = new EcoreExecutorType(MetamodelPackage.Literals.RESOURCE_PARAMETER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Section = new EcoreExecutorType(MetamodelPackage.Literals.SECTION, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._Section_S, TypeParameters._Section_C, TypeParameters._Section_R, TypeParameters._Section_A);
		public static final /*@NonNull*/ EcoreExecutorType _SingleReferenceValueConstraint = new EcoreExecutorType(MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSection = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionAttribute = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionClass = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_CLASS, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_CONTAINMENT_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SourceSectionReference = new EcoreExecutorType(MetamodelPackage.Literals.SOURCE_SECTION_REFERENCE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _SubstringMatcher = new EcoreExecutorType(MetamodelPackage.Literals.SUBSTRING_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSection = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionAttribute = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_ATTRIBUTE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionClass = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_CLASS, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_CONTAINMENT_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionNonContainmentReference = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_NON_CONTAINMENT_REFERENCE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _TargetSectionReference = new EcoreExecutorType(MetamodelPackage.Literals.TARGET_SECTION_REFERENCE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ValueConstraint = new EcoreExecutorType(MetamodelPackage.Literals.VALUE_CONSTRAINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ValueConstraintExternalSourceElement = new EcoreExecutorType(MetamodelPackage.Literals.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ValueConstraintSourceElement = new EcoreExecutorType(MetamodelPackage.Literals.VALUE_CONSTRAINT_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ValueConstraintSourceInterface = new EcoreExecutorType(MetamodelPackage.Literals.VALUE_CONSTRAINT_SOURCE_INTERFACE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorEnumeration _ValueConstraintType = new EcoreExecutorEnumeration(MetamodelPackage.Literals.VALUE_CONSTRAINT_TYPE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _VirtualAttribute = new EcoreExecutorType(MetamodelPackage.Literals.VIRTUAL_ATTRIBUTE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._VirtualAttribute_S, TypeParameters._VirtualAttribute_C, TypeParameters._VirtualAttribute_R, TypeParameters._VirtualAttribute_A);
		public static final /*@NonNull*/ EcoreExecutorType _VirtualTargetSectionAttribute = new EcoreExecutorType(MetamodelPackage.Literals.VIRTUAL_TARGET_SECTION_ATTRIBUTE, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType /*@NonNull*/ [] types = {
			_ActualAttribute,
			_ActualSourceSectionAttribute,
			_ActualTargetSectionAttribute,
			_Attribute,
			_AttributeParameter,
			_BeginningMatcher,
			_CardinalityType,
			_CaseSensitiveConstraint,
			_Class,
			_ContainerParameter,
			_ContainmentReference,
			_EndingMatcher,
			_EqualityMatcher,
			_ExternalReferenceParameter,
			_FileAttribute,
			_FileTypeEnum,
			_InstancePointer,
			_InstancePointerExternalSourceElement,
			_InstancePointerSourceElement,
			_InstancePointerSourceInterface,
			_LibraryEntry,
			_LibraryParameter,
			_MetaModelElement,
			_MetaModelSectionReference,
			_MultipleReferencesValueConstraint,
			_NonContainmentReference,
			_RangeBound,
			_RangeConstraint,
			_Reference,
			_RegExMatcher,
			_ResourceParameter,
			_Section,
			_SingleReferenceValueConstraint,
			_SourceSection,
			_SourceSectionAttribute,
			_SourceSectionClass,
			_SourceSectionContainmentReference,
			_SourceSectionReference,
			_SubstringMatcher,
			_TargetSection,
			_TargetSectionAttribute,
			_TargetSectionClass,
			_TargetSectionContainmentReference,
			_TargetSectionNonContainmentReference,
			_TargetSectionReference,
			_ValueConstraint,
			_ValueConstraintExternalSourceElement,
			_ValueConstraintSourceElement,
			_ValueConstraintSourceInterface,
			_ValueConstraintType,
			_VirtualAttribute,
			_VirtualTargetSectionAttribute
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

		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__ActualAttribute = new ExecutorFragment(Types._ActualSourceSectionAttribute, MetamodelTables.Types._ActualAttribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__ActualSourceSectionAttribute = new ExecutorFragment(Types._ActualSourceSectionAttribute, MetamodelTables.Types._ActualSourceSectionAttribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__Attribute = new ExecutorFragment(Types._ActualSourceSectionAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__MetaModelElement = new ExecutorFragment(Types._ActualSourceSectionAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__NamedElement = new ExecutorFragment(Types._ActualSourceSectionAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__OclAny = new ExecutorFragment(Types._ActualSourceSectionAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__OclElement = new ExecutorFragment(Types._ActualSourceSectionAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualSourceSectionAttribute__SourceSectionAttribute = new ExecutorFragment(Types._ActualSourceSectionAttribute, MetamodelTables.Types._SourceSectionAttribute);

		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__ActualAttribute = new ExecutorFragment(Types._ActualTargetSectionAttribute, MetamodelTables.Types._ActualAttribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__ActualTargetSectionAttribute = new ExecutorFragment(Types._ActualTargetSectionAttribute, MetamodelTables.Types._ActualTargetSectionAttribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__Attribute = new ExecutorFragment(Types._ActualTargetSectionAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__MetaModelElement = new ExecutorFragment(Types._ActualTargetSectionAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__NamedElement = new ExecutorFragment(Types._ActualTargetSectionAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__OclAny = new ExecutorFragment(Types._ActualTargetSectionAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__OclElement = new ExecutorFragment(Types._ActualTargetSectionAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ActualTargetSectionAttribute__TargetSectionAttribute = new ExecutorFragment(Types._ActualTargetSectionAttribute, MetamodelTables.Types._TargetSectionAttribute);

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

		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__BeginningMatcher = new ExecutorFragment(Types._BeginningMatcher, MetamodelTables.Types._BeginningMatcher);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._BeginningMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__ExpressionHint = new ExecutorFragment(Types._BeginningMatcher, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__ModifiableHint = new ExecutorFragment(Types._BeginningMatcher, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__NamedElement = new ExecutorFragment(Types._BeginningMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__OclAny = new ExecutorFragment(Types._BeginningMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__OclElement = new ExecutorFragment(Types._BeginningMatcher, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__SingleReferenceValueConstraint = new ExecutorFragment(Types._BeginningMatcher, MetamodelTables.Types._SingleReferenceValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _BeginningMatcher__ValueConstraint = new ExecutorFragment(Types._BeginningMatcher, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__CardinalityType = new ExecutorFragment(Types._CardinalityType, MetamodelTables.Types._CardinalityType);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__OclAny = new ExecutorFragment(Types._CardinalityType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__OclElement = new ExecutorFragment(Types._CardinalityType, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__OclEnumeration = new ExecutorFragment(Types._CardinalityType, OCLstdlibTables.Types._OclEnumeration);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityType__OclType = new ExecutorFragment(Types._CardinalityType, OCLstdlibTables.Types._OclType);

		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__CaseSensitiveConstraint = new ExecutorFragment(Types._CaseSensitiveConstraint, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__ExpressionHint = new ExecutorFragment(Types._CaseSensitiveConstraint, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__ModifiableHint = new ExecutorFragment(Types._CaseSensitiveConstraint, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__NamedElement = new ExecutorFragment(Types._CaseSensitiveConstraint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__OclAny = new ExecutorFragment(Types._CaseSensitiveConstraint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__OclElement = new ExecutorFragment(Types._CaseSensitiveConstraint, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__SingleReferenceValueConstraint = new ExecutorFragment(Types._CaseSensitiveConstraint, MetamodelTables.Types._SingleReferenceValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _CaseSensitiveConstraint__ValueConstraint = new ExecutorFragment(Types._CaseSensitiveConstraint, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _Class__Class = new ExecutorFragment(Types._Class, MetamodelTables.Types._Class);
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

		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._EndingMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__EndingMatcher = new ExecutorFragment(Types._EndingMatcher, MetamodelTables.Types._EndingMatcher);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__ExpressionHint = new ExecutorFragment(Types._EndingMatcher, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__ModifiableHint = new ExecutorFragment(Types._EndingMatcher, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__NamedElement = new ExecutorFragment(Types._EndingMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__OclAny = new ExecutorFragment(Types._EndingMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__OclElement = new ExecutorFragment(Types._EndingMatcher, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__SingleReferenceValueConstraint = new ExecutorFragment(Types._EndingMatcher, MetamodelTables.Types._SingleReferenceValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EndingMatcher__ValueConstraint = new ExecutorFragment(Types._EndingMatcher, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._EqualityMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__EqualityMatcher = new ExecutorFragment(Types._EqualityMatcher, MetamodelTables.Types._EqualityMatcher);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__ExpressionHint = new ExecutorFragment(Types._EqualityMatcher, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__ModifiableHint = new ExecutorFragment(Types._EqualityMatcher, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__NamedElement = new ExecutorFragment(Types._EqualityMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__OclAny = new ExecutorFragment(Types._EqualityMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__OclElement = new ExecutorFragment(Types._EqualityMatcher, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__SingleReferenceValueConstraint = new ExecutorFragment(Types._EqualityMatcher, MetamodelTables.Types._SingleReferenceValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _EqualityMatcher__ValueConstraint = new ExecutorFragment(Types._EqualityMatcher, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__ExternalReferenceParameter = new ExecutorFragment(Types._ExternalReferenceParameter, MetamodelTables.Types._ExternalReferenceParameter);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__LibraryParameter = new ExecutorFragment(Types._ExternalReferenceParameter, MetamodelTables.Types._LibraryParameter);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__NamedElement = new ExecutorFragment(Types._ExternalReferenceParameter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__OclAny = new ExecutorFragment(Types._ExternalReferenceParameter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExternalReferenceParameter__OclElement = new ExecutorFragment(Types._ExternalReferenceParameter, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__Attribute = new ExecutorFragment(Types._FileAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__FileAttribute = new ExecutorFragment(Types._FileAttribute, MetamodelTables.Types._FileAttribute);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__MetaModelElement = new ExecutorFragment(Types._FileAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__NamedElement = new ExecutorFragment(Types._FileAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__OclAny = new ExecutorFragment(Types._FileAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__OclElement = new ExecutorFragment(Types._FileAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__TargetSectionAttribute = new ExecutorFragment(Types._FileAttribute, MetamodelTables.Types._TargetSectionAttribute);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__VirtualAttribute = new ExecutorFragment(Types._FileAttribute, MetamodelTables.Types._VirtualAttribute);
		private static final /*@NonNull*/ ExecutorFragment _FileAttribute__VirtualTargetSectionAttribute = new ExecutorFragment(Types._FileAttribute, MetamodelTables.Types._VirtualTargetSectionAttribute);

		private static final /*@NonNull*/ ExecutorFragment _FileTypeEnum__FileTypeEnum = new ExecutorFragment(Types._FileTypeEnum, MetamodelTables.Types._FileTypeEnum);
		private static final /*@NonNull*/ ExecutorFragment _FileTypeEnum__OclAny = new ExecutorFragment(Types._FileTypeEnum, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _FileTypeEnum__OclElement = new ExecutorFragment(Types._FileTypeEnum, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _FileTypeEnum__OclEnumeration = new ExecutorFragment(Types._FileTypeEnum, OCLstdlibTables.Types._OclEnumeration);
		private static final /*@NonNull*/ ExecutorFragment _FileTypeEnum__OclType = new ExecutorFragment(Types._FileTypeEnum, OCLstdlibTables.Types._OclType);

		private static final /*@NonNull*/ ExecutorFragment _InstancePointer__ExpressionHint = new ExecutorFragment(Types._InstancePointer, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointer__InstancePointer = new ExecutorFragment(Types._InstancePointer, MetamodelTables.Types._InstancePointer);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointer__ModifiableHint = new ExecutorFragment(Types._InstancePointer, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointer__OclAny = new ExecutorFragment(Types._InstancePointer, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointer__OclElement = new ExecutorFragment(Types._InstancePointer, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._InstancePointerExternalSourceElement, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__InstancePointerExternalSourceElement = new ExecutorFragment(Types._InstancePointerExternalSourceElement, MetamodelTables.Types._InstancePointerExternalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__InstancePointerSourceInterface = new ExecutorFragment(Types._InstancePointerExternalSourceElement, MetamodelTables.Types._InstancePointerSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._InstancePointerExternalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._InstancePointerExternalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__NamedElement = new ExecutorFragment(Types._InstancePointerExternalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__OclAny = new ExecutorFragment(Types._InstancePointerExternalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerExternalSourceElement__OclElement = new ExecutorFragment(Types._InstancePointerExternalSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__InstancePointerSourceElement = new ExecutorFragment(Types._InstancePointerSourceElement, MetamodelTables.Types._InstancePointerSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__InstancePointerSourceInterface = new ExecutorFragment(Types._InstancePointerSourceElement, MetamodelTables.Types._InstancePointerSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__LocalModifiedAttributeElementType = new ExecutorFragment(Types._InstancePointerSourceElement, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._InstancePointerSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._InstancePointerSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__NamedElement = new ExecutorFragment(Types._InstancePointerSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__OclAny = new ExecutorFragment(Types._InstancePointerSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceElement__OclElement = new ExecutorFragment(Types._InstancePointerSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceInterface__InstancePointerSourceInterface = new ExecutorFragment(Types._InstancePointerSourceInterface, MetamodelTables.Types._InstancePointerSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceInterface__MappingHintSourceInterface = new ExecutorFragment(Types._InstancePointerSourceInterface, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceInterface__NamedElement = new ExecutorFragment(Types._InstancePointerSourceInterface, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceInterface__OclAny = new ExecutorFragment(Types._InstancePointerSourceInterface, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _InstancePointerSourceInterface__OclElement = new ExecutorFragment(Types._InstancePointerSourceInterface, OCLstdlibTables.Types._OclElement);

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

		private static final /*@NonNull*/ ExecutorFragment _MultipleReferencesValueConstraint__MultipleReferencesValueConstraint = new ExecutorFragment(Types._MultipleReferencesValueConstraint, MetamodelTables.Types._MultipleReferencesValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _MultipleReferencesValueConstraint__NamedElement = new ExecutorFragment(Types._MultipleReferencesValueConstraint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MultipleReferencesValueConstraint__OclAny = new ExecutorFragment(Types._MultipleReferencesValueConstraint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MultipleReferencesValueConstraint__OclElement = new ExecutorFragment(Types._MultipleReferencesValueConstraint, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _MultipleReferencesValueConstraint__ValueConstraint = new ExecutorFragment(Types._MultipleReferencesValueConstraint, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__MetaModelElement = new ExecutorFragment(Types._NonContainmentReference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__NamedElement = new ExecutorFragment(Types._NonContainmentReference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__NonContainmentReference = new ExecutorFragment(Types._NonContainmentReference, MetamodelTables.Types._NonContainmentReference);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__OclAny = new ExecutorFragment(Types._NonContainmentReference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__OclElement = new ExecutorFragment(Types._NonContainmentReference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _NonContainmentReference__Reference = new ExecutorFragment(Types._NonContainmentReference, MetamodelTables.Types._Reference);

		private static final /*@NonNull*/ ExecutorFragment _RangeBound__ExpressionHint = new ExecutorFragment(Types._RangeBound, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _RangeBound__ModifiableHint = new ExecutorFragment(Types._RangeBound, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _RangeBound__OclAny = new ExecutorFragment(Types._RangeBound, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _RangeBound__OclElement = new ExecutorFragment(Types._RangeBound, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _RangeBound__RangeBound = new ExecutorFragment(Types._RangeBound, MetamodelTables.Types._RangeBound);

		private static final /*@NonNull*/ ExecutorFragment _RangeConstraint__MultipleReferencesValueConstraint = new ExecutorFragment(Types._RangeConstraint, MetamodelTables.Types._MultipleReferencesValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _RangeConstraint__NamedElement = new ExecutorFragment(Types._RangeConstraint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _RangeConstraint__OclAny = new ExecutorFragment(Types._RangeConstraint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _RangeConstraint__OclElement = new ExecutorFragment(Types._RangeConstraint, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _RangeConstraint__RangeConstraint = new ExecutorFragment(Types._RangeConstraint, MetamodelTables.Types._RangeConstraint);
		private static final /*@NonNull*/ ExecutorFragment _RangeConstraint__ValueConstraint = new ExecutorFragment(Types._RangeConstraint, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _Reference__MetaModelElement = new ExecutorFragment(Types._Reference, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _Reference__NamedElement = new ExecutorFragment(Types._Reference, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Reference__OclAny = new ExecutorFragment(Types._Reference, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Reference__OclElement = new ExecutorFragment(Types._Reference, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Reference__Reference = new ExecutorFragment(Types._Reference, MetamodelTables.Types._Reference);

		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__ExpressionHint = new ExecutorFragment(Types._RegExMatcher, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__ModifiableHint = new ExecutorFragment(Types._RegExMatcher, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__NamedElement = new ExecutorFragment(Types._RegExMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__OclAny = new ExecutorFragment(Types._RegExMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__OclElement = new ExecutorFragment(Types._RegExMatcher, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__RegExMatcher = new ExecutorFragment(Types._RegExMatcher, MetamodelTables.Types._RegExMatcher);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__SingleReferenceValueConstraint = new ExecutorFragment(Types._RegExMatcher, MetamodelTables.Types._SingleReferenceValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _RegExMatcher__ValueConstraint = new ExecutorFragment(Types._RegExMatcher, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _ResourceParameter__NamedElement = new ExecutorFragment(Types._ResourceParameter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ResourceParameter__OclAny = new ExecutorFragment(Types._ResourceParameter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ResourceParameter__OclElement = new ExecutorFragment(Types._ResourceParameter, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ResourceParameter__ResourceParameter = new ExecutorFragment(Types._ResourceParameter, MetamodelTables.Types._ResourceParameter);

		private static final /*@NonNull*/ ExecutorFragment _Section__Class = new ExecutorFragment(Types._Section, MetamodelTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _Section__MetaModelElement = new ExecutorFragment(Types._Section, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _Section__NamedElement = new ExecutorFragment(Types._Section, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Section__OclAny = new ExecutorFragment(Types._Section, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Section__OclElement = new ExecutorFragment(Types._Section, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _Section__Section = new ExecutorFragment(Types._Section, MetamodelTables.Types._Section);

		private static final /*@NonNull*/ ExecutorFragment _SingleReferenceValueConstraint__ExpressionHint = new ExecutorFragment(Types._SingleReferenceValueConstraint, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _SingleReferenceValueConstraint__ModifiableHint = new ExecutorFragment(Types._SingleReferenceValueConstraint, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _SingleReferenceValueConstraint__NamedElement = new ExecutorFragment(Types._SingleReferenceValueConstraint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SingleReferenceValueConstraint__OclAny = new ExecutorFragment(Types._SingleReferenceValueConstraint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SingleReferenceValueConstraint__OclElement = new ExecutorFragment(Types._SingleReferenceValueConstraint, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SingleReferenceValueConstraint__SingleReferenceValueConstraint = new ExecutorFragment(Types._SingleReferenceValueConstraint, MetamodelTables.Types._SingleReferenceValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _SingleReferenceValueConstraint__ValueConstraint = new ExecutorFragment(Types._SingleReferenceValueConstraint, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _SourceSection__Class = new ExecutorFragment(Types._SourceSection, MetamodelTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _SourceSection__MetaModelElement = new ExecutorFragment(Types._SourceSection, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSection__NamedElement = new ExecutorFragment(Types._SourceSection, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSection__OclAny = new ExecutorFragment(Types._SourceSection, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SourceSection__OclElement = new ExecutorFragment(Types._SourceSection, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSection__Section = new ExecutorFragment(Types._SourceSection, MetamodelTables.Types._Section);
		private static final /*@NonNull*/ ExecutorFragment _SourceSection__SourceSection = new ExecutorFragment(Types._SourceSection, MetamodelTables.Types._SourceSection);
		private static final /*@NonNull*/ ExecutorFragment _SourceSection__SourceSectionClass = new ExecutorFragment(Types._SourceSection, MetamodelTables.Types._SourceSectionClass);

		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__Attribute = new ExecutorFragment(Types._SourceSectionAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__MetaModelElement = new ExecutorFragment(Types._SourceSectionAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__NamedElement = new ExecutorFragment(Types._SourceSectionAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__OclAny = new ExecutorFragment(Types._SourceSectionAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__OclElement = new ExecutorFragment(Types._SourceSectionAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SourceSectionAttribute__SourceSectionAttribute = new ExecutorFragment(Types._SourceSectionAttribute, MetamodelTables.Types._SourceSectionAttribute);

		private static final /*@NonNull*/ ExecutorFragment _SourceSectionClass__Class = new ExecutorFragment(Types._SourceSectionClass, MetamodelTables.Types._Class);
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

		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__CaseSensitiveConstraint = new ExecutorFragment(Types._SubstringMatcher, MetamodelTables.Types._CaseSensitiveConstraint);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__ExpressionHint = new ExecutorFragment(Types._SubstringMatcher, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__ModifiableHint = new ExecutorFragment(Types._SubstringMatcher, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__NamedElement = new ExecutorFragment(Types._SubstringMatcher, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__OclAny = new ExecutorFragment(Types._SubstringMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__OclElement = new ExecutorFragment(Types._SubstringMatcher, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__SingleReferenceValueConstraint = new ExecutorFragment(Types._SubstringMatcher, MetamodelTables.Types._SingleReferenceValueConstraint);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__SubstringMatcher = new ExecutorFragment(Types._SubstringMatcher, MetamodelTables.Types._SubstringMatcher);
		private static final /*@NonNull*/ ExecutorFragment _SubstringMatcher__ValueConstraint = new ExecutorFragment(Types._SubstringMatcher, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _TargetSection__Class = new ExecutorFragment(Types._TargetSection, MetamodelTables.Types._Class);
		private static final /*@NonNull*/ ExecutorFragment _TargetSection__MetaModelElement = new ExecutorFragment(Types._TargetSection, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSection__NamedElement = new ExecutorFragment(Types._TargetSection, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSection__OclAny = new ExecutorFragment(Types._TargetSection, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSection__OclElement = new ExecutorFragment(Types._TargetSection, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSection__Section = new ExecutorFragment(Types._TargetSection, MetamodelTables.Types._Section);
		private static final /*@NonNull*/ ExecutorFragment _TargetSection__TargetSection = new ExecutorFragment(Types._TargetSection, MetamodelTables.Types._TargetSection);
		private static final /*@NonNull*/ ExecutorFragment _TargetSection__TargetSectionClass = new ExecutorFragment(Types._TargetSection, MetamodelTables.Types._TargetSectionClass);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__Attribute = new ExecutorFragment(Types._TargetSectionAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__MetaModelElement = new ExecutorFragment(Types._TargetSectionAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__NamedElement = new ExecutorFragment(Types._TargetSectionAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__OclAny = new ExecutorFragment(Types._TargetSectionAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__OclElement = new ExecutorFragment(Types._TargetSectionAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _TargetSectionAttribute__TargetSectionAttribute = new ExecutorFragment(Types._TargetSectionAttribute, MetamodelTables.Types._TargetSectionAttribute);

		private static final /*@NonNull*/ ExecutorFragment _TargetSectionClass__Class = new ExecutorFragment(Types._TargetSectionClass, MetamodelTables.Types._Class);
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

		private static final /*@NonNull*/ ExecutorFragment _ValueConstraint__NamedElement = new ExecutorFragment(Types._ValueConstraint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraint__OclAny = new ExecutorFragment(Types._ValueConstraint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraint__OclElement = new ExecutorFragment(Types._ValueConstraint, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraint__ValueConstraint = new ExecutorFragment(Types._ValueConstraint, MetamodelTables.Types._ValueConstraint);

		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__NamedElement = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__OclAny = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__OclElement = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__ValueConstraintExternalSourceElement = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, MetamodelTables.Types._ValueConstraintExternalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintExternalSourceElement__ValueConstraintSourceInterface = new ExecutorFragment(Types._ValueConstraintExternalSourceElement, MetamodelTables.Types._ValueConstraintSourceInterface);

		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__LocalModifiedAttributeElementType = new ExecutorFragment(Types._ValueConstraintSourceElement, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._ValueConstraintSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._ValueConstraintSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__NamedElement = new ExecutorFragment(Types._ValueConstraintSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__OclAny = new ExecutorFragment(Types._ValueConstraintSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__OclElement = new ExecutorFragment(Types._ValueConstraintSourceElement, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__ValueConstraintSourceElement = new ExecutorFragment(Types._ValueConstraintSourceElement, MetamodelTables.Types._ValueConstraintSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceElement__ValueConstraintSourceInterface = new ExecutorFragment(Types._ValueConstraintSourceElement, MetamodelTables.Types._ValueConstraintSourceInterface);

		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceInterface__MappingHintSourceInterface = new ExecutorFragment(Types._ValueConstraintSourceInterface, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceInterface__NamedElement = new ExecutorFragment(Types._ValueConstraintSourceInterface, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceInterface__OclAny = new ExecutorFragment(Types._ValueConstraintSourceInterface, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceInterface__OclElement = new ExecutorFragment(Types._ValueConstraintSourceInterface, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintSourceInterface__ValueConstraintSourceInterface = new ExecutorFragment(Types._ValueConstraintSourceInterface, MetamodelTables.Types._ValueConstraintSourceInterface);

		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintType__OclAny = new ExecutorFragment(Types._ValueConstraintType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintType__OclElement = new ExecutorFragment(Types._ValueConstraintType, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintType__OclEnumeration = new ExecutorFragment(Types._ValueConstraintType, OCLstdlibTables.Types._OclEnumeration);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintType__OclType = new ExecutorFragment(Types._ValueConstraintType, OCLstdlibTables.Types._OclType);
		private static final /*@NonNull*/ ExecutorFragment _ValueConstraintType__ValueConstraintType = new ExecutorFragment(Types._ValueConstraintType, MetamodelTables.Types._ValueConstraintType);

		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__Attribute = new ExecutorFragment(Types._VirtualAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__MetaModelElement = new ExecutorFragment(Types._VirtualAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__NamedElement = new ExecutorFragment(Types._VirtualAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__OclAny = new ExecutorFragment(Types._VirtualAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__OclElement = new ExecutorFragment(Types._VirtualAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualAttribute__VirtualAttribute = new ExecutorFragment(Types._VirtualAttribute, MetamodelTables.Types._VirtualAttribute);

		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__Attribute = new ExecutorFragment(Types._VirtualTargetSectionAttribute, MetamodelTables.Types._Attribute);
		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__MetaModelElement = new ExecutorFragment(Types._VirtualTargetSectionAttribute, MetamodelTables.Types._MetaModelElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__NamedElement = new ExecutorFragment(Types._VirtualTargetSectionAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__OclAny = new ExecutorFragment(Types._VirtualTargetSectionAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__OclElement = new ExecutorFragment(Types._VirtualTargetSectionAttribute, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__TargetSectionAttribute = new ExecutorFragment(Types._VirtualTargetSectionAttribute, MetamodelTables.Types._TargetSectionAttribute);
		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__VirtualAttribute = new ExecutorFragment(Types._VirtualTargetSectionAttribute, MetamodelTables.Types._VirtualAttribute);
		private static final /*@NonNull*/ ExecutorFragment _VirtualTargetSectionAttribute__VirtualTargetSectionAttribute = new ExecutorFragment(Types._VirtualTargetSectionAttribute, MetamodelTables.Types._VirtualTargetSectionAttribute);

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

		public static final /*@NonNull*/ ParameterTypes _Class_C = TypeUtil.createParameterTypes(MetamodelTables.TypeParameters._Class_C);
		public static final /*@NonNull*/ ParameterTypes _Class_C___OrderedSet__Class_C__ = TypeUtil.createParameterTypes(MetamodelTables.TypeParameters._Class_C, new ExecutorSpecializedType("OrderedSet", MetamodelTables.TypeParameters._Class_C));
		public static final /*@NonNull*/ ParameterTypes _String___OrderedSet__String__ = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String, new ExecutorSpecializedType("OrderedSet", OCLstdlibTables.Types._String));
		public static final /*@NonNull*/ ParameterTypes _String___String = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String, OCLstdlibTables.Types._String);

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

		public static final /*@NonNull*/ ExecutorOperation _Class__getOwningContainmentReference = new ExecutorOperation("getOwningContainmentReference", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Class,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Class__isContainedIn = new ExecutorOperation("isContainedIn", Parameters._Class_C, Types._Class,
			1, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Class__isContainerFor = new ExecutorOperation("isContainerFor", Parameters._Class_C, Types._Class,
			2, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Class__isReferencedBy = new ExecutorOperation("isReferencedBy", Parameters._Class_C___OrderedSet__Class_C__, Types._Class,
			3, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _MetaModelElement__getContainingSection = new ExecutorOperation("getContainingSection", TypeUtil.EMPTY_PARAMETER_TYPES, Types._MetaModelElement,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _MetaModelElement__getContainingSectionModel = new ExecutorOperation("getContainingSectionModel", TypeUtil.EMPTY_PARAMETER_TYPES, Types._MetaModelElement,
			1, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _MetaModelElement__isLibraryEntry = new ExecutorOperation("isLibraryEntry", TypeUtil.EMPTY_PARAMETER_TYPES, Types._MetaModelElement,
			2, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _MultipleReferencesValueConstraint__checkConstraint = new ExecutorOperation("checkConstraint", Parameters._String___OrderedSet__String__, Types._MultipleReferencesValueConstraint,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _RangeBound__isLocalConstraint = new ExecutorOperation("isLocalConstraint", TypeUtil.EMPTY_PARAMETER_TYPES, Types._RangeBound,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _SingleReferenceValueConstraint__checkConstraint = new ExecutorOperation("checkConstraint", Parameters._String___String, Types._SingleReferenceValueConstraint,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _SingleReferenceValueConstraint__isLocalConstraint = new ExecutorOperation("isLocalConstraint", TypeUtil.EMPTY_PARAMETER_TYPES, Types._SingleReferenceValueConstraint,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _SourceSectionReference__getValuesGeneric = new ExecutorOperation("getValuesGeneric", TypeUtil.EMPTY_PARAMETER_TYPES, Types._SourceSectionReference,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _TargetSectionReference__getValuesGeneric = new ExecutorOperation("getValuesGeneric", TypeUtil.EMPTY_PARAMETER_TYPES, Types._TargetSectionReference,
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

		public static final /*@NonNull*/ ExecutorProperty _ActualSourceSectionAttribute__InstancePointer__target = new ExecutorPropertyWithImplementation("InstancePointer", Types._ActualSourceSectionAttribute, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.INSTANCE_POINTER__TARGET));

		public static final /*@NonNull*/ ExecutorProperty _ActualTargetSectionAttribute__AttributeParameter__attribute = new ExecutorPropertyWithImplementation("AttributeParameter", Types._ActualTargetSectionAttribute, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.ATTRIBUTE_PARAMETER__ATTRIBUTE));

		public static final /*@NonNull*/ ExecutorProperty _Attribute__owningClass = new EcoreExecutorProperty(MetamodelPackage.Literals.ATTRIBUTE__OWNING_CLASS, Types._Attribute, 0);

		public static final /*@NonNull*/ ExecutorProperty _AttributeParameter__attribute = new EcoreExecutorProperty(MetamodelPackage.Literals.ATTRIBUTE_PARAMETER__ATTRIBUTE, Types._AttributeParameter, 0);

		public static final /*@NonNull*/ ExecutorProperty _CaseSensitiveConstraint__caseSensitive = new EcoreExecutorProperty(MetamodelPackage.Literals.CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE, Types._CaseSensitiveConstraint, 0);

		public static final /*@NonNull*/ ExecutorProperty _Class__attributes = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__ATTRIBUTES, Types._Class, 0);
		public static final /*@NonNull*/ ExecutorProperty _Class__cardinality = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__CARDINALITY, Types._Class, 1);
		public static final /*@NonNull*/ ExecutorProperty _Class__container = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__CONTAINER, Types._Class, 2);
		public static final /*@NonNull*/ ExecutorProperty _Class__eClass = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__ECLASS, Types._Class, 3);
		public static final /*@NonNull*/ ExecutorProperty _Class__references = new EcoreExecutorProperty(MetamodelPackage.Literals.CLASS__REFERENCES, Types._Class, 4);

		public static final /*@NonNull*/ ExecutorProperty _ContainerParameter__class = new EcoreExecutorProperty(MetamodelPackage.Literals.CONTAINER_PARAMETER__CLASS, Types._ContainerParameter, 0);

		public static final /*@NonNull*/ ExecutorProperty _ContainmentReference__value = new EcoreExecutorProperty(MetamodelPackage.Literals.CONTAINMENT_REFERENCE__VALUE, Types._ContainmentReference, 0);

		public static final /*@NonNull*/ ExecutorProperty _ExternalReferenceParameter__reference = new EcoreExecutorProperty(MetamodelPackage.Literals.EXTERNAL_REFERENCE_PARAMETER__REFERENCE, Types._ExternalReferenceParameter, 0);

		public static final /*@NonNull*/ ExecutorProperty _FileAttribute__fileType = new EcoreExecutorProperty(MetamodelPackage.Literals.FILE_ATTRIBUTE__FILE_TYPE, Types._FileAttribute, 0);
		public static final /*@NonNull*/ ExecutorProperty _FileAttribute__TargetSection__file = new ExecutorPropertyWithImplementation("TargetSection", Types._FileAttribute, 1, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.TARGET_SECTION__FILE));

		public static final /*@NonNull*/ ExecutorProperty _InstancePointer__sourceElements = new EcoreExecutorProperty(MetamodelPackage.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS, Types._InstancePointer, 0);
		public static final /*@NonNull*/ ExecutorProperty _InstancePointer__target = new EcoreExecutorProperty(MetamodelPackage.Literals.INSTANCE_POINTER__TARGET, Types._InstancePointer, 1);
		public static final /*@NonNull*/ ExecutorProperty _InstancePointer__RangeBound__boundReferenceValueAdditionalSpecification = new ExecutorPropertyWithImplementation("RangeBound", Types._InstancePointer, 2, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION));
		public static final /*@NonNull*/ ExecutorProperty _InstancePointer__SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification = new ExecutorPropertyWithImplementation("SingleReferenceValueConstraint", Types._InstancePointer, 3, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION));

		public static final /*@NonNull*/ ExecutorProperty _InstancePointerSourceInterface__InstancePointer__sourceElements = new ExecutorPropertyWithImplementation("InstancePointer", Types._InstancePointerSourceInterface, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS));

		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__id = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__ID, Types._LibraryEntry, 0);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__libraryFile = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__LIBRARY_FILE, Types._LibraryEntry, 1);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__originalLibraryEntry = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY, Types._LibraryEntry, 2);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__parameters = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__PARAMETERS, Types._LibraryEntry, 3);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__path = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__PATH, Types._LibraryEntry, 4);
		public static final /*@NonNull*/ ExecutorProperty _LibraryEntry__resourceParameters = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__RESOURCE_PARAMETERS, Types._LibraryEntry, 5);

		public static final /*@NonNull*/ ExecutorProperty _LibraryParameter__originalParameter = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_PARAMETER__ORIGINAL_PARAMETER, Types._LibraryParameter, 0);
		public static final /*@NonNull*/ ExecutorProperty _LibraryParameter__source = new EcoreExecutorProperty(MetamodelPackage.Literals.LIBRARY_PARAMETER__SOURCE, Types._LibraryParameter, 1);

		public static final /*@NonNull*/ ExecutorProperty _MetaModelSectionReference__value = new EcoreExecutorProperty(MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE, Types._MetaModelSectionReference, 0);

		public static final /*@NonNull*/ ExecutorProperty _NonContainmentReference__value = new EcoreExecutorProperty(MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE__VALUE, Types._NonContainmentReference, 0);

		public static final /*@NonNull*/ ExecutorProperty _RangeBound__boundReferenceValueAdditionalSpecification = new EcoreExecutorProperty(MetamodelPackage.Literals.RANGE_BOUND__BOUND_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION, Types._RangeBound, 0);
		public static final /*@NonNull*/ ExecutorProperty _RangeBound__boundType = new EcoreExecutorProperty(MetamodelPackage.Literals.RANGE_BOUND__BOUND_TYPE, Types._RangeBound, 1);
		public static final /*@NonNull*/ ExecutorProperty _RangeBound__sourceElements = new EcoreExecutorProperty(MetamodelPackage.Literals.RANGE_BOUND__SOURCE_ELEMENTS, Types._RangeBound, 2);
		public static final /*@NonNull*/ ExecutorProperty _RangeBound__RangeConstraint__lowerBound = new ExecutorPropertyWithImplementation("RangeConstraint", Types._RangeBound, 3, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.RANGE_CONSTRAINT__LOWER_BOUND));
		public static final /*@NonNull*/ ExecutorProperty _RangeBound__RangeConstraint__upperBound = new ExecutorPropertyWithImplementation("RangeConstraint", Types._RangeBound, 4, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.RANGE_CONSTRAINT__UPPER_BOUND));

		public static final /*@NonNull*/ ExecutorProperty _RangeConstraint__lowerBound = new EcoreExecutorProperty(MetamodelPackage.Literals.RANGE_CONSTRAINT__LOWER_BOUND, Types._RangeConstraint, 0);
		public static final /*@NonNull*/ ExecutorProperty _RangeConstraint__upperBound = new EcoreExecutorProperty(MetamodelPackage.Literals.RANGE_CONSTRAINT__UPPER_BOUND, Types._RangeConstraint, 1);

		public static final /*@NonNull*/ ExecutorProperty _Reference__eReference = new EcoreExecutorProperty(MetamodelPackage.Literals.REFERENCE__EREFERENCE, Types._Reference, 0);
		public static final /*@NonNull*/ ExecutorProperty _Reference__owningClass = new EcoreExecutorProperty(MetamodelPackage.Literals.REFERENCE__OWNING_CLASS, Types._Reference, 1);

		public static final /*@NonNull*/ ExecutorProperty _ResourceParameter__attribute = new EcoreExecutorProperty(MetamodelPackage.Literals.RESOURCE_PARAMETER__ATTRIBUTE, Types._ResourceParameter, 0);
		public static final /*@NonNull*/ ExecutorProperty _ResourceParameter__originalParameter = new EcoreExecutorProperty(MetamodelPackage.Literals.RESOURCE_PARAMETER__ORIGINAL_PARAMETER, Types._ResourceParameter, 1);
		public static final /*@NonNull*/ ExecutorProperty _ResourceParameter__LibraryEntry__resourceParameters = new ExecutorPropertyWithImplementation("LibraryEntry", Types._ResourceParameter, 2, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__RESOURCE_PARAMETERS));

		public static final /*@NonNull*/ ExecutorProperty _Section__abstract = new EcoreExecutorProperty(MetamodelPackage.Literals.SECTION__ABSTRACT, Types._Section, 0);
		public static final /*@NonNull*/ ExecutorProperty _Section__extend = new EcoreExecutorProperty(MetamodelPackage.Literals.SECTION__EXTEND, Types._Section, 1);

		public static final /*@NonNull*/ ExecutorProperty _SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification = new EcoreExecutorProperty(MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION, Types._SingleReferenceValueConstraint, 0);
		public static final /*@NonNull*/ ExecutorProperty _SingleReferenceValueConstraint__sourceElements = new EcoreExecutorProperty(MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS, Types._SingleReferenceValueConstraint, 1);

		public static final /*@NonNull*/ ExecutorProperty _SourceSection__referencingMappings = new EcoreExecutorProperty(MetamodelPackage.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS, Types._SourceSection, 0);

		public static final /*@NonNull*/ ExecutorProperty _SourceSectionAttribute__valueConstraint = new EcoreExecutorProperty(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT, Types._SourceSectionAttribute, 0);

		public static final /*@NonNull*/ ExecutorProperty _SourceSectionClass__MetaModelSectionReference__value = new ExecutorPropertyWithImplementation("MetaModelSectionReference", Types._SourceSectionClass, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE));

		public static final /*@NonNull*/ ExecutorProperty _TargetSection__file = new EcoreExecutorProperty(MetamodelPackage.Literals.TARGET_SECTION__FILE, Types._TargetSection, 0);
		public static final /*@NonNull*/ ExecutorProperty _TargetSection__referencingMappingHintGroups = new EcoreExecutorProperty(MetamodelPackage.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS, Types._TargetSection, 1);
		public static final /*@NonNull*/ ExecutorProperty _TargetSection__ContainerParameter__class = new ExecutorPropertyWithImplementation("ContainerParameter", Types._TargetSection, 2, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.CONTAINER_PARAMETER__CLASS));

		public static final /*@NonNull*/ ExecutorProperty _TargetSectionAttribute__unique = new EcoreExecutorProperty(MetamodelPackage.Literals.TARGET_SECTION_ATTRIBUTE__UNIQUE, Types._TargetSectionAttribute, 0);
		public static final /*@NonNull*/ ExecutorProperty _TargetSectionAttribute__value = new EcoreExecutorProperty(MetamodelPackage.Literals.TARGET_SECTION_ATTRIBUTE__VALUE, Types._TargetSectionAttribute, 1);

		public static final /*@NonNull*/ ExecutorProperty _TargetSectionNonContainmentReference__ExternalReferenceParameter__reference = new ExecutorPropertyWithImplementation("ExternalReferenceParameter", Types._TargetSectionNonContainmentReference, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.EXTERNAL_REFERENCE_PARAMETER__REFERENCE));

		public static final /*@NonNull*/ ExecutorProperty _ValueConstraint__type = new EcoreExecutorProperty(MetamodelPackage.Literals.VALUE_CONSTRAINT__TYPE, Types._ValueConstraint, 0);
		public static final /*@NonNull*/ ExecutorProperty _ValueConstraint__SourceSectionAttribute__valueConstraint = new ExecutorPropertyWithImplementation("SourceSectionAttribute", Types._ValueConstraint, 1, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT));

		public static final /*@NonNull*/ ExecutorProperty _ValueConstraintSourceInterface__RangeBound__sourceElements = new ExecutorPropertyWithImplementation("RangeBound", Types._ValueConstraintSourceInterface, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.RANGE_BOUND__SOURCE_ELEMENTS));
		public static final /*@NonNull*/ ExecutorProperty _ValueConstraintSourceInterface__SingleReferenceValueConstraint__sourceElements = new ExecutorPropertyWithImplementation("SingleReferenceValueConstraint", Types._ValueConstraintSourceInterface, 1, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS));

		public static final /*@NonNull*/ ExecutorProperty _VirtualTargetSectionAttribute__LibraryEntry__id = new ExecutorPropertyWithImplementation("LibraryEntry", Types._VirtualTargetSectionAttribute, 0, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__ID));
		public static final /*@NonNull*/ ExecutorProperty _VirtualTargetSectionAttribute__LibraryEntry__path = new ExecutorPropertyWithImplementation("LibraryEntry", Types._VirtualTargetSectionAttribute, 1, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.LIBRARY_ENTRY__PATH));
		public static final /*@NonNull*/ ExecutorProperty _VirtualTargetSectionAttribute__ResourceParameter__attribute = new ExecutorPropertyWithImplementation("ResourceParameter", Types._VirtualTargetSectionAttribute, 2, new EcoreLibraryOppositeProperty(MetamodelPackage.Literals.RESOURCE_PARAMETER__ATTRIBUTE));
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

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ActualAttribute =
		{
			Fragments._ActualAttribute__OclAny /* 0 */,
			Fragments._ActualAttribute__OclElement /* 1 */,
			Fragments._ActualAttribute__NamedElement /* 2 */,
			Fragments._ActualAttribute__MetaModelElement /* 3 */,
			Fragments._ActualAttribute__Attribute /* 4 */,
			Fragments._ActualAttribute__ActualAttribute /* 5 */
		};
		private static final int /*@NonNull*/ [] __ActualAttribute = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ActualSourceSectionAttribute =
		{
			Fragments._ActualSourceSectionAttribute__OclAny /* 0 */,
			Fragments._ActualSourceSectionAttribute__OclElement /* 1 */,
			Fragments._ActualSourceSectionAttribute__NamedElement /* 2 */,
			Fragments._ActualSourceSectionAttribute__MetaModelElement /* 3 */,
			Fragments._ActualSourceSectionAttribute__Attribute /* 4 */,
			Fragments._ActualSourceSectionAttribute__ActualAttribute /* 5 */,
			Fragments._ActualSourceSectionAttribute__SourceSectionAttribute /* 5 */,
			Fragments._ActualSourceSectionAttribute__ActualSourceSectionAttribute /* 6 */
		};
		private static final int /*@NonNull*/ [] __ActualSourceSectionAttribute = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ActualTargetSectionAttribute =
		{
			Fragments._ActualTargetSectionAttribute__OclAny /* 0 */,
			Fragments._ActualTargetSectionAttribute__OclElement /* 1 */,
			Fragments._ActualTargetSectionAttribute__NamedElement /* 2 */,
			Fragments._ActualTargetSectionAttribute__MetaModelElement /* 3 */,
			Fragments._ActualTargetSectionAttribute__Attribute /* 4 */,
			Fragments._ActualTargetSectionAttribute__ActualAttribute /* 5 */,
			Fragments._ActualTargetSectionAttribute__TargetSectionAttribute /* 5 */,
			Fragments._ActualTargetSectionAttribute__ActualTargetSectionAttribute /* 6 */
		};
		private static final int /*@NonNull*/ [] __ActualTargetSectionAttribute = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Attribute =
		{
			Fragments._Attribute__OclAny /* 0 */,
			Fragments._Attribute__OclElement /* 1 */,
			Fragments._Attribute__NamedElement /* 2 */,
			Fragments._Attribute__MetaModelElement /* 3 */,
			Fragments._Attribute__Attribute /* 4 */
		};
		private static final int /*@NonNull*/ [] __Attribute = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeParameter =
		{
			Fragments._AttributeParameter__OclAny /* 0 */,
			Fragments._AttributeParameter__OclElement /* 1 */,
			Fragments._AttributeParameter__NamedElement /* 2 */,
			Fragments._AttributeParameter__LibraryParameter /* 3 */,
			Fragments._AttributeParameter__AttributeParameter /* 4 */
		};
		private static final int /*@NonNull*/ [] __AttributeParameter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _BeginningMatcher =
		{
			Fragments._BeginningMatcher__OclAny /* 0 */,
			Fragments._BeginningMatcher__OclElement /* 1 */,
			Fragments._BeginningMatcher__ExpressionHint /* 2 */,
			Fragments._BeginningMatcher__ModifiableHint /* 2 */,
			Fragments._BeginningMatcher__NamedElement /* 2 */,
			Fragments._BeginningMatcher__ValueConstraint /* 3 */,
			Fragments._BeginningMatcher__SingleReferenceValueConstraint /* 4 */,
			Fragments._BeginningMatcher__CaseSensitiveConstraint /* 5 */,
			Fragments._BeginningMatcher__BeginningMatcher /* 6 */
		};
		private static final int /*@NonNull*/ [] __BeginningMatcher = { 1,1,3,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _CardinalityType =
		{
			Fragments._CardinalityType__OclAny /* 0 */,
			Fragments._CardinalityType__OclElement /* 1 */,
			Fragments._CardinalityType__OclType /* 2 */,
			Fragments._CardinalityType__OclEnumeration /* 3 */,
			Fragments._CardinalityType__CardinalityType /* 4 */
		};
		private static final int /*@NonNull*/ [] __CardinalityType = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _CaseSensitiveConstraint =
		{
			Fragments._CaseSensitiveConstraint__OclAny /* 0 */,
			Fragments._CaseSensitiveConstraint__OclElement /* 1 */,
			Fragments._CaseSensitiveConstraint__ExpressionHint /* 2 */,
			Fragments._CaseSensitiveConstraint__ModifiableHint /* 2 */,
			Fragments._CaseSensitiveConstraint__NamedElement /* 2 */,
			Fragments._CaseSensitiveConstraint__ValueConstraint /* 3 */,
			Fragments._CaseSensitiveConstraint__SingleReferenceValueConstraint /* 4 */,
			Fragments._CaseSensitiveConstraint__CaseSensitiveConstraint /* 5 */
		};
		private static final int /*@NonNull*/ [] __CaseSensitiveConstraint = { 1,1,3,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Class =
		{
			Fragments._Class__OclAny /* 0 */,
			Fragments._Class__OclElement /* 1 */,
			Fragments._Class__NamedElement /* 2 */,
			Fragments._Class__MetaModelElement /* 3 */,
			Fragments._Class__Class /* 4 */
		};
		private static final int /*@NonNull*/ [] __Class = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ContainerParameter =
		{
			Fragments._ContainerParameter__OclAny /* 0 */,
			Fragments._ContainerParameter__OclElement /* 1 */,
			Fragments._ContainerParameter__NamedElement /* 2 */,
			Fragments._ContainerParameter__LibraryParameter /* 3 */,
			Fragments._ContainerParameter__ContainerParameter /* 4 */
		};
		private static final int /*@NonNull*/ [] __ContainerParameter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ContainmentReference =
		{
			Fragments._ContainmentReference__OclAny /* 0 */,
			Fragments._ContainmentReference__OclElement /* 1 */,
			Fragments._ContainmentReference__NamedElement /* 2 */,
			Fragments._ContainmentReference__MetaModelElement /* 3 */,
			Fragments._ContainmentReference__Reference /* 4 */,
			Fragments._ContainmentReference__ContainmentReference /* 5 */
		};
		private static final int /*@NonNull*/ [] __ContainmentReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _EndingMatcher =
		{
			Fragments._EndingMatcher__OclAny /* 0 */,
			Fragments._EndingMatcher__OclElement /* 1 */,
			Fragments._EndingMatcher__ExpressionHint /* 2 */,
			Fragments._EndingMatcher__ModifiableHint /* 2 */,
			Fragments._EndingMatcher__NamedElement /* 2 */,
			Fragments._EndingMatcher__ValueConstraint /* 3 */,
			Fragments._EndingMatcher__SingleReferenceValueConstraint /* 4 */,
			Fragments._EndingMatcher__CaseSensitiveConstraint /* 5 */,
			Fragments._EndingMatcher__EndingMatcher /* 6 */
		};
		private static final int /*@NonNull*/ [] __EndingMatcher = { 1,1,3,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _EqualityMatcher =
		{
			Fragments._EqualityMatcher__OclAny /* 0 */,
			Fragments._EqualityMatcher__OclElement /* 1 */,
			Fragments._EqualityMatcher__ExpressionHint /* 2 */,
			Fragments._EqualityMatcher__ModifiableHint /* 2 */,
			Fragments._EqualityMatcher__NamedElement /* 2 */,
			Fragments._EqualityMatcher__ValueConstraint /* 3 */,
			Fragments._EqualityMatcher__SingleReferenceValueConstraint /* 4 */,
			Fragments._EqualityMatcher__CaseSensitiveConstraint /* 5 */,
			Fragments._EqualityMatcher__EqualityMatcher /* 6 */
		};
		private static final int /*@NonNull*/ [] __EqualityMatcher = { 1,1,3,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExternalReferenceParameter =
		{
			Fragments._ExternalReferenceParameter__OclAny /* 0 */,
			Fragments._ExternalReferenceParameter__OclElement /* 1 */,
			Fragments._ExternalReferenceParameter__NamedElement /* 2 */,
			Fragments._ExternalReferenceParameter__LibraryParameter /* 3 */,
			Fragments._ExternalReferenceParameter__ExternalReferenceParameter /* 4 */
		};
		private static final int /*@NonNull*/ [] __ExternalReferenceParameter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _FileAttribute =
		{
			Fragments._FileAttribute__OclAny /* 0 */,
			Fragments._FileAttribute__OclElement /* 1 */,
			Fragments._FileAttribute__NamedElement /* 2 */,
			Fragments._FileAttribute__MetaModelElement /* 3 */,
			Fragments._FileAttribute__Attribute /* 4 */,
			Fragments._FileAttribute__TargetSectionAttribute /* 5 */,
			Fragments._FileAttribute__VirtualAttribute /* 5 */,
			Fragments._FileAttribute__VirtualTargetSectionAttribute /* 6 */,
			Fragments._FileAttribute__FileAttribute /* 7 */
		};
		private static final int /*@NonNull*/ [] __FileAttribute = { 1,1,1,1,1,2,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _FileTypeEnum =
		{
			Fragments._FileTypeEnum__OclAny /* 0 */,
			Fragments._FileTypeEnum__OclElement /* 1 */,
			Fragments._FileTypeEnum__OclType /* 2 */,
			Fragments._FileTypeEnum__OclEnumeration /* 3 */,
			Fragments._FileTypeEnum__FileTypeEnum /* 4 */
		};
		private static final int /*@NonNull*/ [] __FileTypeEnum = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _InstancePointer =
		{
			Fragments._InstancePointer__OclAny /* 0 */,
			Fragments._InstancePointer__OclElement /* 1 */,
			Fragments._InstancePointer__ExpressionHint /* 2 */,
			Fragments._InstancePointer__ModifiableHint /* 2 */,
			Fragments._InstancePointer__InstancePointer /* 3 */
		};
		private static final int /*@NonNull*/ [] __InstancePointer = { 1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _InstancePointerExternalSourceElement =
		{
			Fragments._InstancePointerExternalSourceElement__OclAny /* 0 */,
			Fragments._InstancePointerExternalSourceElement__OclElement /* 1 */,
			Fragments._InstancePointerExternalSourceElement__NamedElement /* 2 */,
			Fragments._InstancePointerExternalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._InstancePointerExternalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._InstancePointerExternalSourceElement__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._InstancePointerExternalSourceElement__InstancePointerSourceInterface /* 4 */,
			Fragments._InstancePointerExternalSourceElement__InstancePointerExternalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __InstancePointerExternalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _InstancePointerSourceElement =
		{
			Fragments._InstancePointerSourceElement__OclAny /* 0 */,
			Fragments._InstancePointerSourceElement__OclElement /* 1 */,
			Fragments._InstancePointerSourceElement__NamedElement /* 2 */,
			Fragments._InstancePointerSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._InstancePointerSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._InstancePointerSourceElement__InstancePointerSourceInterface /* 4 */,
			Fragments._InstancePointerSourceElement__LocalModifiedAttributeElementType /* 4 */,
			Fragments._InstancePointerSourceElement__InstancePointerSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __InstancePointerSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _InstancePointerSourceInterface =
		{
			Fragments._InstancePointerSourceInterface__OclAny /* 0 */,
			Fragments._InstancePointerSourceInterface__OclElement /* 1 */,
			Fragments._InstancePointerSourceInterface__NamedElement /* 2 */,
			Fragments._InstancePointerSourceInterface__MappingHintSourceInterface /* 3 */,
			Fragments._InstancePointerSourceInterface__InstancePointerSourceInterface /* 4 */
		};
		private static final int /*@NonNull*/ [] __InstancePointerSourceInterface = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _LibraryEntry =
		{
			Fragments._LibraryEntry__OclAny /* 0 */,
			Fragments._LibraryEntry__OclElement /* 1 */,
			Fragments._LibraryEntry__LibraryEntry /* 2 */
		};
		private static final int /*@NonNull*/ [] __LibraryEntry = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _LibraryParameter =
		{
			Fragments._LibraryParameter__OclAny /* 0 */,
			Fragments._LibraryParameter__OclElement /* 1 */,
			Fragments._LibraryParameter__NamedElement /* 2 */,
			Fragments._LibraryParameter__LibraryParameter /* 3 */
		};
		private static final int /*@NonNull*/ [] __LibraryParameter = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MetaModelElement =
		{
			Fragments._MetaModelElement__OclAny /* 0 */,
			Fragments._MetaModelElement__OclElement /* 1 */,
			Fragments._MetaModelElement__NamedElement /* 2 */,
			Fragments._MetaModelElement__MetaModelElement /* 3 */
		};
		private static final int /*@NonNull*/ [] __MetaModelElement = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MetaModelSectionReference =
		{
			Fragments._MetaModelSectionReference__OclAny /* 0 */,
			Fragments._MetaModelSectionReference__OclElement /* 1 */,
			Fragments._MetaModelSectionReference__NamedElement /* 2 */,
			Fragments._MetaModelSectionReference__MetaModelElement /* 3 */,
			Fragments._MetaModelSectionReference__Reference /* 4 */,
			Fragments._MetaModelSectionReference__SourceSectionReference /* 5 */,
			Fragments._MetaModelSectionReference__MetaModelSectionReference /* 6 */
		};
		private static final int /*@NonNull*/ [] __MetaModelSectionReference = { 1,1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MultipleReferencesValueConstraint =
		{
			Fragments._MultipleReferencesValueConstraint__OclAny /* 0 */,
			Fragments._MultipleReferencesValueConstraint__OclElement /* 1 */,
			Fragments._MultipleReferencesValueConstraint__NamedElement /* 2 */,
			Fragments._MultipleReferencesValueConstraint__ValueConstraint /* 3 */,
			Fragments._MultipleReferencesValueConstraint__MultipleReferencesValueConstraint /* 4 */
		};
		private static final int /*@NonNull*/ [] __MultipleReferencesValueConstraint = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _NonContainmentReference =
		{
			Fragments._NonContainmentReference__OclAny /* 0 */,
			Fragments._NonContainmentReference__OclElement /* 1 */,
			Fragments._NonContainmentReference__NamedElement /* 2 */,
			Fragments._NonContainmentReference__MetaModelElement /* 3 */,
			Fragments._NonContainmentReference__Reference /* 4 */,
			Fragments._NonContainmentReference__NonContainmentReference /* 5 */
		};
		private static final int /*@NonNull*/ [] __NonContainmentReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _RangeBound =
		{
			Fragments._RangeBound__OclAny /* 0 */,
			Fragments._RangeBound__OclElement /* 1 */,
			Fragments._RangeBound__ExpressionHint /* 2 */,
			Fragments._RangeBound__ModifiableHint /* 2 */,
			Fragments._RangeBound__RangeBound /* 3 */
		};
		private static final int /*@NonNull*/ [] __RangeBound = { 1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _RangeConstraint =
		{
			Fragments._RangeConstraint__OclAny /* 0 */,
			Fragments._RangeConstraint__OclElement /* 1 */,
			Fragments._RangeConstraint__NamedElement /* 2 */,
			Fragments._RangeConstraint__ValueConstraint /* 3 */,
			Fragments._RangeConstraint__MultipleReferencesValueConstraint /* 4 */,
			Fragments._RangeConstraint__RangeConstraint /* 5 */
		};
		private static final int /*@NonNull*/ [] __RangeConstraint = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Reference =
		{
			Fragments._Reference__OclAny /* 0 */,
			Fragments._Reference__OclElement /* 1 */,
			Fragments._Reference__NamedElement /* 2 */,
			Fragments._Reference__MetaModelElement /* 3 */,
			Fragments._Reference__Reference /* 4 */
		};
		private static final int /*@NonNull*/ [] __Reference = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _RegExMatcher =
		{
			Fragments._RegExMatcher__OclAny /* 0 */,
			Fragments._RegExMatcher__OclElement /* 1 */,
			Fragments._RegExMatcher__ExpressionHint /* 2 */,
			Fragments._RegExMatcher__ModifiableHint /* 2 */,
			Fragments._RegExMatcher__NamedElement /* 2 */,
			Fragments._RegExMatcher__ValueConstraint /* 3 */,
			Fragments._RegExMatcher__SingleReferenceValueConstraint /* 4 */,
			Fragments._RegExMatcher__RegExMatcher /* 5 */
		};
		private static final int /*@NonNull*/ [] __RegExMatcher = { 1,1,3,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ResourceParameter =
		{
			Fragments._ResourceParameter__OclAny /* 0 */,
			Fragments._ResourceParameter__OclElement /* 1 */,
			Fragments._ResourceParameter__NamedElement /* 2 */,
			Fragments._ResourceParameter__ResourceParameter /* 3 */
		};
		private static final int /*@NonNull*/ [] __ResourceParameter = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Section =
		{
			Fragments._Section__OclAny /* 0 */,
			Fragments._Section__OclElement /* 1 */,
			Fragments._Section__NamedElement /* 2 */,
			Fragments._Section__MetaModelElement /* 3 */,
			Fragments._Section__Class /* 4 */,
			Fragments._Section__Section /* 5 */
		};
		private static final int /*@NonNull*/ [] __Section = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SingleReferenceValueConstraint =
		{
			Fragments._SingleReferenceValueConstraint__OclAny /* 0 */,
			Fragments._SingleReferenceValueConstraint__OclElement /* 1 */,
			Fragments._SingleReferenceValueConstraint__ExpressionHint /* 2 */,
			Fragments._SingleReferenceValueConstraint__ModifiableHint /* 2 */,
			Fragments._SingleReferenceValueConstraint__NamedElement /* 2 */,
			Fragments._SingleReferenceValueConstraint__ValueConstraint /* 3 */,
			Fragments._SingleReferenceValueConstraint__SingleReferenceValueConstraint /* 4 */
		};
		private static final int /*@NonNull*/ [] __SingleReferenceValueConstraint = { 1,1,3,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SourceSection =
		{
			Fragments._SourceSection__OclAny /* 0 */,
			Fragments._SourceSection__OclElement /* 1 */,
			Fragments._SourceSection__NamedElement /* 2 */,
			Fragments._SourceSection__MetaModelElement /* 3 */,
			Fragments._SourceSection__Class /* 4 */,
			Fragments._SourceSection__Section /* 5 */,
			Fragments._SourceSection__SourceSectionClass /* 5 */,
			Fragments._SourceSection__SourceSection /* 6 */
		};
		private static final int /*@NonNull*/ [] __SourceSection = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SourceSectionAttribute =
		{
			Fragments._SourceSectionAttribute__OclAny /* 0 */,
			Fragments._SourceSectionAttribute__OclElement /* 1 */,
			Fragments._SourceSectionAttribute__NamedElement /* 2 */,
			Fragments._SourceSectionAttribute__MetaModelElement /* 3 */,
			Fragments._SourceSectionAttribute__Attribute /* 4 */,
			Fragments._SourceSectionAttribute__SourceSectionAttribute /* 5 */
		};
		private static final int /*@NonNull*/ [] __SourceSectionAttribute = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SourceSectionClass =
		{
			Fragments._SourceSectionClass__OclAny /* 0 */,
			Fragments._SourceSectionClass__OclElement /* 1 */,
			Fragments._SourceSectionClass__NamedElement /* 2 */,
			Fragments._SourceSectionClass__MetaModelElement /* 3 */,
			Fragments._SourceSectionClass__Class /* 4 */,
			Fragments._SourceSectionClass__SourceSectionClass /* 5 */
		};
		private static final int /*@NonNull*/ [] __SourceSectionClass = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SourceSectionContainmentReference =
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
		private static final int /*@NonNull*/ [] __SourceSectionContainmentReference = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SourceSectionReference =
		{
			Fragments._SourceSectionReference__OclAny /* 0 */,
			Fragments._SourceSectionReference__OclElement /* 1 */,
			Fragments._SourceSectionReference__NamedElement /* 2 */,
			Fragments._SourceSectionReference__MetaModelElement /* 3 */,
			Fragments._SourceSectionReference__Reference /* 4 */,
			Fragments._SourceSectionReference__SourceSectionReference /* 5 */
		};
		private static final int /*@NonNull*/ [] __SourceSectionReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SubstringMatcher =
		{
			Fragments._SubstringMatcher__OclAny /* 0 */,
			Fragments._SubstringMatcher__OclElement /* 1 */,
			Fragments._SubstringMatcher__ExpressionHint /* 2 */,
			Fragments._SubstringMatcher__ModifiableHint /* 2 */,
			Fragments._SubstringMatcher__NamedElement /* 2 */,
			Fragments._SubstringMatcher__ValueConstraint /* 3 */,
			Fragments._SubstringMatcher__SingleReferenceValueConstraint /* 4 */,
			Fragments._SubstringMatcher__CaseSensitiveConstraint /* 5 */,
			Fragments._SubstringMatcher__SubstringMatcher /* 6 */
		};
		private static final int /*@NonNull*/ [] __SubstringMatcher = { 1,1,3,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _TargetSection =
		{
			Fragments._TargetSection__OclAny /* 0 */,
			Fragments._TargetSection__OclElement /* 1 */,
			Fragments._TargetSection__NamedElement /* 2 */,
			Fragments._TargetSection__MetaModelElement /* 3 */,
			Fragments._TargetSection__Class /* 4 */,
			Fragments._TargetSection__Section /* 5 */,
			Fragments._TargetSection__TargetSectionClass /* 5 */,
			Fragments._TargetSection__TargetSection /* 6 */
		};
		private static final int /*@NonNull*/ [] __TargetSection = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _TargetSectionAttribute =
		{
			Fragments._TargetSectionAttribute__OclAny /* 0 */,
			Fragments._TargetSectionAttribute__OclElement /* 1 */,
			Fragments._TargetSectionAttribute__NamedElement /* 2 */,
			Fragments._TargetSectionAttribute__MetaModelElement /* 3 */,
			Fragments._TargetSectionAttribute__Attribute /* 4 */,
			Fragments._TargetSectionAttribute__TargetSectionAttribute /* 5 */
		};
		private static final int /*@NonNull*/ [] __TargetSectionAttribute = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _TargetSectionClass =
		{
			Fragments._TargetSectionClass__OclAny /* 0 */,
			Fragments._TargetSectionClass__OclElement /* 1 */,
			Fragments._TargetSectionClass__NamedElement /* 2 */,
			Fragments._TargetSectionClass__MetaModelElement /* 3 */,
			Fragments._TargetSectionClass__Class /* 4 */,
			Fragments._TargetSectionClass__TargetSectionClass /* 5 */
		};
		private static final int /*@NonNull*/ [] __TargetSectionClass = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _TargetSectionContainmentReference =
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
		private static final int /*@NonNull*/ [] __TargetSectionContainmentReference = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _TargetSectionNonContainmentReference =
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
		private static final int /*@NonNull*/ [] __TargetSectionNonContainmentReference = { 1,1,1,1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _TargetSectionReference =
		{
			Fragments._TargetSectionReference__OclAny /* 0 */,
			Fragments._TargetSectionReference__OclElement /* 1 */,
			Fragments._TargetSectionReference__NamedElement /* 2 */,
			Fragments._TargetSectionReference__MetaModelElement /* 3 */,
			Fragments._TargetSectionReference__Reference /* 4 */,
			Fragments._TargetSectionReference__TargetSectionReference /* 5 */
		};
		private static final int /*@NonNull*/ [] __TargetSectionReference = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ValueConstraint =
		{
			Fragments._ValueConstraint__OclAny /* 0 */,
			Fragments._ValueConstraint__OclElement /* 1 */,
			Fragments._ValueConstraint__NamedElement /* 2 */,
			Fragments._ValueConstraint__ValueConstraint /* 3 */
		};
		private static final int /*@NonNull*/ [] __ValueConstraint = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ValueConstraintExternalSourceElement =
		{
			Fragments._ValueConstraintExternalSourceElement__OclAny /* 0 */,
			Fragments._ValueConstraintExternalSourceElement__OclElement /* 1 */,
			Fragments._ValueConstraintExternalSourceElement__NamedElement /* 2 */,
			Fragments._ValueConstraintExternalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._ValueConstraintExternalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._ValueConstraintExternalSourceElement__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._ValueConstraintExternalSourceElement__ValueConstraintSourceInterface /* 4 */,
			Fragments._ValueConstraintExternalSourceElement__ValueConstraintExternalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __ValueConstraintExternalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ValueConstraintSourceElement =
		{
			Fragments._ValueConstraintSourceElement__OclAny /* 0 */,
			Fragments._ValueConstraintSourceElement__OclElement /* 1 */,
			Fragments._ValueConstraintSourceElement__NamedElement /* 2 */,
			Fragments._ValueConstraintSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._ValueConstraintSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._ValueConstraintSourceElement__LocalModifiedAttributeElementType /* 4 */,
			Fragments._ValueConstraintSourceElement__ValueConstraintSourceInterface /* 4 */,
			Fragments._ValueConstraintSourceElement__ValueConstraintSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __ValueConstraintSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ValueConstraintSourceInterface =
		{
			Fragments._ValueConstraintSourceInterface__OclAny /* 0 */,
			Fragments._ValueConstraintSourceInterface__OclElement /* 1 */,
			Fragments._ValueConstraintSourceInterface__NamedElement /* 2 */,
			Fragments._ValueConstraintSourceInterface__MappingHintSourceInterface /* 3 */,
			Fragments._ValueConstraintSourceInterface__ValueConstraintSourceInterface /* 4 */
		};
		private static final int /*@NonNull*/ [] __ValueConstraintSourceInterface = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ValueConstraintType =
		{
			Fragments._ValueConstraintType__OclAny /* 0 */,
			Fragments._ValueConstraintType__OclElement /* 1 */,
			Fragments._ValueConstraintType__OclType /* 2 */,
			Fragments._ValueConstraintType__OclEnumeration /* 3 */,
			Fragments._ValueConstraintType__ValueConstraintType /* 4 */
		};
		private static final int /*@NonNull*/ [] __ValueConstraintType = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _VirtualAttribute =
		{
			Fragments._VirtualAttribute__OclAny /* 0 */,
			Fragments._VirtualAttribute__OclElement /* 1 */,
			Fragments._VirtualAttribute__NamedElement /* 2 */,
			Fragments._VirtualAttribute__MetaModelElement /* 3 */,
			Fragments._VirtualAttribute__Attribute /* 4 */,
			Fragments._VirtualAttribute__VirtualAttribute /* 5 */
		};
		private static final int /*@NonNull*/ [] __VirtualAttribute = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _VirtualTargetSectionAttribute =
		{
			Fragments._VirtualTargetSectionAttribute__OclAny /* 0 */,
			Fragments._VirtualTargetSectionAttribute__OclElement /* 1 */,
			Fragments._VirtualTargetSectionAttribute__NamedElement /* 2 */,
			Fragments._VirtualTargetSectionAttribute__MetaModelElement /* 3 */,
			Fragments._VirtualTargetSectionAttribute__Attribute /* 4 */,
			Fragments._VirtualTargetSectionAttribute__TargetSectionAttribute /* 5 */,
			Fragments._VirtualTargetSectionAttribute__VirtualAttribute /* 5 */,
			Fragments._VirtualTargetSectionAttribute__VirtualTargetSectionAttribute /* 6 */
		};
		private static final int /*@NonNull*/ [] __VirtualTargetSectionAttribute = { 1,1,1,1,1,2,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._ActualAttribute.initFragments(_ActualAttribute, __ActualAttribute);
			Types._ActualSourceSectionAttribute.initFragments(_ActualSourceSectionAttribute, __ActualSourceSectionAttribute);
			Types._ActualTargetSectionAttribute.initFragments(_ActualTargetSectionAttribute, __ActualTargetSectionAttribute);
			Types._Attribute.initFragments(_Attribute, __Attribute);
			Types._AttributeParameter.initFragments(_AttributeParameter, __AttributeParameter);
			Types._BeginningMatcher.initFragments(_BeginningMatcher, __BeginningMatcher);
			Types._CardinalityType.initFragments(_CardinalityType, __CardinalityType);
			Types._CaseSensitiveConstraint.initFragments(_CaseSensitiveConstraint, __CaseSensitiveConstraint);
			Types._Class.initFragments(_Class, __Class);
			Types._ContainerParameter.initFragments(_ContainerParameter, __ContainerParameter);
			Types._ContainmentReference.initFragments(_ContainmentReference, __ContainmentReference);
			Types._EndingMatcher.initFragments(_EndingMatcher, __EndingMatcher);
			Types._EqualityMatcher.initFragments(_EqualityMatcher, __EqualityMatcher);
			Types._ExternalReferenceParameter.initFragments(_ExternalReferenceParameter, __ExternalReferenceParameter);
			Types._FileAttribute.initFragments(_FileAttribute, __FileAttribute);
			Types._FileTypeEnum.initFragments(_FileTypeEnum, __FileTypeEnum);
			Types._InstancePointer.initFragments(_InstancePointer, __InstancePointer);
			Types._InstancePointerExternalSourceElement.initFragments(_InstancePointerExternalSourceElement, __InstancePointerExternalSourceElement);
			Types._InstancePointerSourceElement.initFragments(_InstancePointerSourceElement, __InstancePointerSourceElement);
			Types._InstancePointerSourceInterface.initFragments(_InstancePointerSourceInterface, __InstancePointerSourceInterface);
			Types._LibraryEntry.initFragments(_LibraryEntry, __LibraryEntry);
			Types._LibraryParameter.initFragments(_LibraryParameter, __LibraryParameter);
			Types._MetaModelElement.initFragments(_MetaModelElement, __MetaModelElement);
			Types._MetaModelSectionReference.initFragments(_MetaModelSectionReference, __MetaModelSectionReference);
			Types._MultipleReferencesValueConstraint.initFragments(_MultipleReferencesValueConstraint, __MultipleReferencesValueConstraint);
			Types._NonContainmentReference.initFragments(_NonContainmentReference, __NonContainmentReference);
			Types._RangeBound.initFragments(_RangeBound, __RangeBound);
			Types._RangeConstraint.initFragments(_RangeConstraint, __RangeConstraint);
			Types._Reference.initFragments(_Reference, __Reference);
			Types._RegExMatcher.initFragments(_RegExMatcher, __RegExMatcher);
			Types._ResourceParameter.initFragments(_ResourceParameter, __ResourceParameter);
			Types._Section.initFragments(_Section, __Section);
			Types._SingleReferenceValueConstraint.initFragments(_SingleReferenceValueConstraint, __SingleReferenceValueConstraint);
			Types._SourceSection.initFragments(_SourceSection, __SourceSection);
			Types._SourceSectionAttribute.initFragments(_SourceSectionAttribute, __SourceSectionAttribute);
			Types._SourceSectionClass.initFragments(_SourceSectionClass, __SourceSectionClass);
			Types._SourceSectionContainmentReference.initFragments(_SourceSectionContainmentReference, __SourceSectionContainmentReference);
			Types._SourceSectionReference.initFragments(_SourceSectionReference, __SourceSectionReference);
			Types._SubstringMatcher.initFragments(_SubstringMatcher, __SubstringMatcher);
			Types._TargetSection.initFragments(_TargetSection, __TargetSection);
			Types._TargetSectionAttribute.initFragments(_TargetSectionAttribute, __TargetSectionAttribute);
			Types._TargetSectionClass.initFragments(_TargetSectionClass, __TargetSectionClass);
			Types._TargetSectionContainmentReference.initFragments(_TargetSectionContainmentReference, __TargetSectionContainmentReference);
			Types._TargetSectionNonContainmentReference.initFragments(_TargetSectionNonContainmentReference, __TargetSectionNonContainmentReference);
			Types._TargetSectionReference.initFragments(_TargetSectionReference, __TargetSectionReference);
			Types._ValueConstraint.initFragments(_ValueConstraint, __ValueConstraint);
			Types._ValueConstraintExternalSourceElement.initFragments(_ValueConstraintExternalSourceElement, __ValueConstraintExternalSourceElement);
			Types._ValueConstraintSourceElement.initFragments(_ValueConstraintSourceElement, __ValueConstraintSourceElement);
			Types._ValueConstraintSourceInterface.initFragments(_ValueConstraintSourceInterface, __ValueConstraintSourceInterface);
			Types._ValueConstraintType.initFragments(_ValueConstraintType, __ValueConstraintType);
			Types._VirtualAttribute.initFragments(_VirtualAttribute, __VirtualAttribute);
			Types._VirtualTargetSectionAttribute.initFragments(_VirtualTargetSectionAttribute, __VirtualTargetSectionAttribute);

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

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualAttribute__ActualAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__ActualSourceSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__ActualAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualSourceSectionAttribute__SourceSectionAttribute = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__ActualTargetSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__ActualAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ActualTargetSectionAttribute__TargetSectionAttribute = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Attribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Attribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Attribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Attribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Attribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeParameter__AttributeParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__BeginningMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__SingleReferenceValueConstraint = {
			MetamodelTables.Operations._SingleReferenceValueConstraint__checkConstraint /* checkConstraint(String[1],String[1]) */,
			MetamodelTables.Operations._SingleReferenceValueConstraint__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _BeginningMatcher__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityType__CardinalityType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__SingleReferenceValueConstraint = {
			MetamodelTables.Operations._SingleReferenceValueConstraint__checkConstraint /* checkConstraint(String[1],String[1]) */,
			MetamodelTables.Operations._SingleReferenceValueConstraint__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CaseSensitiveConstraint__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Class__Class = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isReferencedBy /* isReferencedBy(C[1],OrderedSet(C)[*|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Class__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Class__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Class__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Class__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainerParameter__ContainerParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainerParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainerParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainerParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainerParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainmentReference__ContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ContainmentReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__EndingMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__SingleReferenceValueConstraint = {
			MetamodelTables.Operations._SingleReferenceValueConstraint__checkConstraint /* checkConstraint(String[1],String[1]) */,
			MetamodelTables.Operations._SingleReferenceValueConstraint__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EndingMatcher__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__EqualityMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__SingleReferenceValueConstraint = {
			MetamodelTables.Operations._SingleReferenceValueConstraint__checkConstraint /* checkConstraint(String[1],String[1]) */,
			MetamodelTables.Operations._SingleReferenceValueConstraint__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _EqualityMatcher__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalReferenceParameter__ExternalReferenceParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalReferenceParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalReferenceParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalReferenceParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalReferenceParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__FileAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__TargetSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__VirtualAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileAttribute__VirtualTargetSectionAttribute = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileTypeEnum__FileTypeEnum = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileTypeEnum__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileTypeEnum__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileTypeEnum__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FileTypeEnum__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointer__InstancePointer = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointer__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointer__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointer__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointer__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__InstancePointerExternalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__InstancePointerSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerExternalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__InstancePointerSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__InstancePointerSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceInterface__InstancePointerSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceInterface__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceInterface__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceInterface__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstancePointerSourceInterface__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LibraryEntry__LibraryEntry = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LibraryEntry__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LibraryEntry__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LibraryParameter__LibraryParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LibraryParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LibraryParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LibraryParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelElement__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelSectionReference__MetaModelSectionReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelSectionReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelSectionReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelSectionReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelSectionReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelSectionReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MetaModelSectionReference__SourceSectionReference = {
			MetamodelTables.Operations._SourceSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MultipleReferencesValueConstraint__MultipleReferencesValueConstraint = {
			MetamodelTables.Operations._MultipleReferencesValueConstraint__checkConstraint /* checkConstraint(String[1],OrderedSet(String)[+|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MultipleReferencesValueConstraint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MultipleReferencesValueConstraint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MultipleReferencesValueConstraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MultipleReferencesValueConstraint__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NonContainmentReference__NonContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NonContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NonContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NonContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NonContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _NonContainmentReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeBound__RangeBound = {
			MetamodelTables.Operations._RangeBound__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeBound__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeBound__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeBound__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeBound__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeConstraint__RangeConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeConstraint__MultipleReferencesValueConstraint = {
			MetamodelTables.Operations._MultipleReferencesValueConstraint__checkConstraint /* checkConstraint(String[1],OrderedSet(String)[+|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeConstraint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeConstraint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeConstraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RangeConstraint__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Reference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Reference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Reference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Reference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Reference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__RegExMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__SingleReferenceValueConstraint = {
			MetamodelTables.Operations._SingleReferenceValueConstraint__checkConstraint /* checkConstraint(String[1],String[1]) */,
			MetamodelTables.Operations._SingleReferenceValueConstraint__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _RegExMatcher__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ResourceParameter__ResourceParameter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ResourceParameter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ResourceParameter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ResourceParameter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Section__Section = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Section__Class = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isReferencedBy /* isReferencedBy(C[1],OrderedSet(C)[*|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Section__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Section__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Section__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Section__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SingleReferenceValueConstraint__SingleReferenceValueConstraint = {
			MetamodelTables.Operations._SingleReferenceValueConstraint__checkConstraint /* checkConstraint(String[1],String[1]) */,
			MetamodelTables.Operations._SingleReferenceValueConstraint__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SingleReferenceValueConstraint__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SingleReferenceValueConstraint__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SingleReferenceValueConstraint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SingleReferenceValueConstraint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SingleReferenceValueConstraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SingleReferenceValueConstraint__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__SourceSection = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__Class = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isReferencedBy /* isReferencedBy(C[1],OrderedSet(C)[*|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__Section = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSection__SourceSectionClass = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionAttribute__SourceSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionClass__SourceSectionClass = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionClass__Class = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isReferencedBy /* isReferencedBy(C[1],OrderedSet(C)[*|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionClass__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionClass__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionClass__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionClass__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__SourceSectionContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__ContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionContainmentReference__SourceSectionReference = {
			MetamodelTables.Operations._SourceSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionReference__SourceSectionReference = {
			MetamodelTables.Operations._SourceSectionReference__getValuesGeneric /* getValuesGeneric() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SourceSectionReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__SubstringMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__CaseSensitiveConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__SingleReferenceValueConstraint = {
			MetamodelTables.Operations._SingleReferenceValueConstraint__checkConstraint /* checkConstraint(String[1],String[1]) */,
			MetamodelTables.Operations._SingleReferenceValueConstraint__isLocalConstraint /* isLocalConstraint() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringMatcher__ValueConstraint = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__TargetSection = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__Class = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isReferencedBy /* isReferencedBy(C[1],OrderedSet(C)[*|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__Section = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSection__TargetSectionClass = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionAttribute__TargetSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionClass__TargetSectionClass = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionClass__Class = {
			MetamodelTables.Operations._Class__getOwningContainmentReference /* getOwningContainmentReference() */,
			MetamodelTables.Operations._Class__isContainedIn /* isContainedIn(C[1]) */,
			MetamodelTables.Operations._Class__isContainerFor /* isContainerFor(C[1]) */,
			MetamodelTables.Operations._Class__isReferencedBy /* isReferencedBy(C[1],OrderedSet(C)[*|1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionClass__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionClass__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionClass__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionClass__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__TargetSectionContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__ContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionContainmentReference__TargetSectionReference = {
			MetamodelTables.Operations._TargetSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__TargetSectionNonContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__NonContainmentReference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__Reference = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionNonContainmentReference__TargetSectionReference = {
			MetamodelTables.Operations._TargetSectionReference__getValuesGeneric /* getValuesGeneric() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionReference__TargetSectionReference = {
			MetamodelTables.Operations._TargetSectionReference__getValuesGeneric /* getValuesGeneric() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionReference__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionReference__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionReference__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionReference__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _TargetSectionReference__Reference = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraint__ValueConstraint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__ValueConstraintExternalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintExternalSourceElement__ValueConstraintSourceInterface = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__ValueConstraintSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceElement__ValueConstraintSourceInterface = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceInterface__ValueConstraintSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceInterface__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceInterface__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceInterface__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintSourceInterface__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintType__ValueConstraintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintType__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintType__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueConstraintType__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualAttribute__VirtualAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__VirtualTargetSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__Attribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__MetaModelElement = {
			MetamodelTables.Operations._MetaModelElement__getContainingSection /* getContainingSection() */,
			MetamodelTables.Operations._MetaModelElement__getContainingSectionModel /* getContainingSectionModel() */,
			MetamodelTables.Operations._MetaModelElement__isLibraryEntry /* isLibraryEntry() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__TargetSectionAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _VirtualTargetSectionAttribute__VirtualAttribute = {};

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

			Fragments._ActualSourceSectionAttribute__ActualAttribute.initOperations(_ActualSourceSectionAttribute__ActualAttribute);
			Fragments._ActualSourceSectionAttribute__ActualSourceSectionAttribute.initOperations(_ActualSourceSectionAttribute__ActualSourceSectionAttribute);
			Fragments._ActualSourceSectionAttribute__Attribute.initOperations(_ActualSourceSectionAttribute__Attribute);
			Fragments._ActualSourceSectionAttribute__MetaModelElement.initOperations(_ActualSourceSectionAttribute__MetaModelElement);
			Fragments._ActualSourceSectionAttribute__NamedElement.initOperations(_ActualSourceSectionAttribute__NamedElement);
			Fragments._ActualSourceSectionAttribute__OclAny.initOperations(_ActualSourceSectionAttribute__OclAny);
			Fragments._ActualSourceSectionAttribute__OclElement.initOperations(_ActualSourceSectionAttribute__OclElement);
			Fragments._ActualSourceSectionAttribute__SourceSectionAttribute.initOperations(_ActualSourceSectionAttribute__SourceSectionAttribute);

			Fragments._ActualTargetSectionAttribute__ActualAttribute.initOperations(_ActualTargetSectionAttribute__ActualAttribute);
			Fragments._ActualTargetSectionAttribute__ActualTargetSectionAttribute.initOperations(_ActualTargetSectionAttribute__ActualTargetSectionAttribute);
			Fragments._ActualTargetSectionAttribute__Attribute.initOperations(_ActualTargetSectionAttribute__Attribute);
			Fragments._ActualTargetSectionAttribute__MetaModelElement.initOperations(_ActualTargetSectionAttribute__MetaModelElement);
			Fragments._ActualTargetSectionAttribute__NamedElement.initOperations(_ActualTargetSectionAttribute__NamedElement);
			Fragments._ActualTargetSectionAttribute__OclAny.initOperations(_ActualTargetSectionAttribute__OclAny);
			Fragments._ActualTargetSectionAttribute__OclElement.initOperations(_ActualTargetSectionAttribute__OclElement);
			Fragments._ActualTargetSectionAttribute__TargetSectionAttribute.initOperations(_ActualTargetSectionAttribute__TargetSectionAttribute);

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

			Fragments._BeginningMatcher__BeginningMatcher.initOperations(_BeginningMatcher__BeginningMatcher);
			Fragments._BeginningMatcher__CaseSensitiveConstraint.initOperations(_BeginningMatcher__CaseSensitiveConstraint);
			Fragments._BeginningMatcher__ExpressionHint.initOperations(_BeginningMatcher__ExpressionHint);
			Fragments._BeginningMatcher__ModifiableHint.initOperations(_BeginningMatcher__ModifiableHint);
			Fragments._BeginningMatcher__NamedElement.initOperations(_BeginningMatcher__NamedElement);
			Fragments._BeginningMatcher__OclAny.initOperations(_BeginningMatcher__OclAny);
			Fragments._BeginningMatcher__OclElement.initOperations(_BeginningMatcher__OclElement);
			Fragments._BeginningMatcher__SingleReferenceValueConstraint.initOperations(_BeginningMatcher__SingleReferenceValueConstraint);
			Fragments._BeginningMatcher__ValueConstraint.initOperations(_BeginningMatcher__ValueConstraint);

			Fragments._CardinalityType__CardinalityType.initOperations(_CardinalityType__CardinalityType);
			Fragments._CardinalityType__OclAny.initOperations(_CardinalityType__OclAny);
			Fragments._CardinalityType__OclElement.initOperations(_CardinalityType__OclElement);
			Fragments._CardinalityType__OclEnumeration.initOperations(_CardinalityType__OclEnumeration);
			Fragments._CardinalityType__OclType.initOperations(_CardinalityType__OclType);

			Fragments._CaseSensitiveConstraint__CaseSensitiveConstraint.initOperations(_CaseSensitiveConstraint__CaseSensitiveConstraint);
			Fragments._CaseSensitiveConstraint__ExpressionHint.initOperations(_CaseSensitiveConstraint__ExpressionHint);
			Fragments._CaseSensitiveConstraint__ModifiableHint.initOperations(_CaseSensitiveConstraint__ModifiableHint);
			Fragments._CaseSensitiveConstraint__NamedElement.initOperations(_CaseSensitiveConstraint__NamedElement);
			Fragments._CaseSensitiveConstraint__OclAny.initOperations(_CaseSensitiveConstraint__OclAny);
			Fragments._CaseSensitiveConstraint__OclElement.initOperations(_CaseSensitiveConstraint__OclElement);
			Fragments._CaseSensitiveConstraint__SingleReferenceValueConstraint.initOperations(_CaseSensitiveConstraint__SingleReferenceValueConstraint);
			Fragments._CaseSensitiveConstraint__ValueConstraint.initOperations(_CaseSensitiveConstraint__ValueConstraint);

			Fragments._Class__Class.initOperations(_Class__Class);
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

			Fragments._EndingMatcher__CaseSensitiveConstraint.initOperations(_EndingMatcher__CaseSensitiveConstraint);
			Fragments._EndingMatcher__EndingMatcher.initOperations(_EndingMatcher__EndingMatcher);
			Fragments._EndingMatcher__ExpressionHint.initOperations(_EndingMatcher__ExpressionHint);
			Fragments._EndingMatcher__ModifiableHint.initOperations(_EndingMatcher__ModifiableHint);
			Fragments._EndingMatcher__NamedElement.initOperations(_EndingMatcher__NamedElement);
			Fragments._EndingMatcher__OclAny.initOperations(_EndingMatcher__OclAny);
			Fragments._EndingMatcher__OclElement.initOperations(_EndingMatcher__OclElement);
			Fragments._EndingMatcher__SingleReferenceValueConstraint.initOperations(_EndingMatcher__SingleReferenceValueConstraint);
			Fragments._EndingMatcher__ValueConstraint.initOperations(_EndingMatcher__ValueConstraint);

			Fragments._EqualityMatcher__CaseSensitiveConstraint.initOperations(_EqualityMatcher__CaseSensitiveConstraint);
			Fragments._EqualityMatcher__EqualityMatcher.initOperations(_EqualityMatcher__EqualityMatcher);
			Fragments._EqualityMatcher__ExpressionHint.initOperations(_EqualityMatcher__ExpressionHint);
			Fragments._EqualityMatcher__ModifiableHint.initOperations(_EqualityMatcher__ModifiableHint);
			Fragments._EqualityMatcher__NamedElement.initOperations(_EqualityMatcher__NamedElement);
			Fragments._EqualityMatcher__OclAny.initOperations(_EqualityMatcher__OclAny);
			Fragments._EqualityMatcher__OclElement.initOperations(_EqualityMatcher__OclElement);
			Fragments._EqualityMatcher__SingleReferenceValueConstraint.initOperations(_EqualityMatcher__SingleReferenceValueConstraint);
			Fragments._EqualityMatcher__ValueConstraint.initOperations(_EqualityMatcher__ValueConstraint);

			Fragments._ExternalReferenceParameter__ExternalReferenceParameter.initOperations(_ExternalReferenceParameter__ExternalReferenceParameter);
			Fragments._ExternalReferenceParameter__LibraryParameter.initOperations(_ExternalReferenceParameter__LibraryParameter);
			Fragments._ExternalReferenceParameter__NamedElement.initOperations(_ExternalReferenceParameter__NamedElement);
			Fragments._ExternalReferenceParameter__OclAny.initOperations(_ExternalReferenceParameter__OclAny);
			Fragments._ExternalReferenceParameter__OclElement.initOperations(_ExternalReferenceParameter__OclElement);

			Fragments._FileAttribute__Attribute.initOperations(_FileAttribute__Attribute);
			Fragments._FileAttribute__FileAttribute.initOperations(_FileAttribute__FileAttribute);
			Fragments._FileAttribute__MetaModelElement.initOperations(_FileAttribute__MetaModelElement);
			Fragments._FileAttribute__NamedElement.initOperations(_FileAttribute__NamedElement);
			Fragments._FileAttribute__OclAny.initOperations(_FileAttribute__OclAny);
			Fragments._FileAttribute__OclElement.initOperations(_FileAttribute__OclElement);
			Fragments._FileAttribute__TargetSectionAttribute.initOperations(_FileAttribute__TargetSectionAttribute);
			Fragments._FileAttribute__VirtualAttribute.initOperations(_FileAttribute__VirtualAttribute);
			Fragments._FileAttribute__VirtualTargetSectionAttribute.initOperations(_FileAttribute__VirtualTargetSectionAttribute);

			Fragments._FileTypeEnum__FileTypeEnum.initOperations(_FileTypeEnum__FileTypeEnum);
			Fragments._FileTypeEnum__OclAny.initOperations(_FileTypeEnum__OclAny);
			Fragments._FileTypeEnum__OclElement.initOperations(_FileTypeEnum__OclElement);
			Fragments._FileTypeEnum__OclEnumeration.initOperations(_FileTypeEnum__OclEnumeration);
			Fragments._FileTypeEnum__OclType.initOperations(_FileTypeEnum__OclType);

			Fragments._InstancePointer__ExpressionHint.initOperations(_InstancePointer__ExpressionHint);
			Fragments._InstancePointer__InstancePointer.initOperations(_InstancePointer__InstancePointer);
			Fragments._InstancePointer__ModifiableHint.initOperations(_InstancePointer__ModifiableHint);
			Fragments._InstancePointer__OclAny.initOperations(_InstancePointer__OclAny);
			Fragments._InstancePointer__OclElement.initOperations(_InstancePointer__OclElement);

			Fragments._InstancePointerExternalSourceElement__ExternalModifiedAttributeElementType.initOperations(_InstancePointerExternalSourceElement__ExternalModifiedAttributeElementType);
			Fragments._InstancePointerExternalSourceElement__InstancePointerExternalSourceElement.initOperations(_InstancePointerExternalSourceElement__InstancePointerExternalSourceElement);
			Fragments._InstancePointerExternalSourceElement__InstancePointerSourceInterface.initOperations(_InstancePointerExternalSourceElement__InstancePointerSourceInterface);
			Fragments._InstancePointerExternalSourceElement__MappingHintSourceInterface.initOperations(_InstancePointerExternalSourceElement__MappingHintSourceInterface);
			Fragments._InstancePointerExternalSourceElement__ModifiedAttributeElementType.initOperations(_InstancePointerExternalSourceElement__ModifiedAttributeElementType);
			Fragments._InstancePointerExternalSourceElement__NamedElement.initOperations(_InstancePointerExternalSourceElement__NamedElement);
			Fragments._InstancePointerExternalSourceElement__OclAny.initOperations(_InstancePointerExternalSourceElement__OclAny);
			Fragments._InstancePointerExternalSourceElement__OclElement.initOperations(_InstancePointerExternalSourceElement__OclElement);

			Fragments._InstancePointerSourceElement__InstancePointerSourceElement.initOperations(_InstancePointerSourceElement__InstancePointerSourceElement);
			Fragments._InstancePointerSourceElement__InstancePointerSourceInterface.initOperations(_InstancePointerSourceElement__InstancePointerSourceInterface);
			Fragments._InstancePointerSourceElement__LocalModifiedAttributeElementType.initOperations(_InstancePointerSourceElement__LocalModifiedAttributeElementType);
			Fragments._InstancePointerSourceElement__MappingHintSourceInterface.initOperations(_InstancePointerSourceElement__MappingHintSourceInterface);
			Fragments._InstancePointerSourceElement__ModifiedAttributeElementType.initOperations(_InstancePointerSourceElement__ModifiedAttributeElementType);
			Fragments._InstancePointerSourceElement__NamedElement.initOperations(_InstancePointerSourceElement__NamedElement);
			Fragments._InstancePointerSourceElement__OclAny.initOperations(_InstancePointerSourceElement__OclAny);
			Fragments._InstancePointerSourceElement__OclElement.initOperations(_InstancePointerSourceElement__OclElement);

			Fragments._InstancePointerSourceInterface__InstancePointerSourceInterface.initOperations(_InstancePointerSourceInterface__InstancePointerSourceInterface);
			Fragments._InstancePointerSourceInterface__MappingHintSourceInterface.initOperations(_InstancePointerSourceInterface__MappingHintSourceInterface);
			Fragments._InstancePointerSourceInterface__NamedElement.initOperations(_InstancePointerSourceInterface__NamedElement);
			Fragments._InstancePointerSourceInterface__OclAny.initOperations(_InstancePointerSourceInterface__OclAny);
			Fragments._InstancePointerSourceInterface__OclElement.initOperations(_InstancePointerSourceInterface__OclElement);

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

			Fragments._MultipleReferencesValueConstraint__MultipleReferencesValueConstraint.initOperations(_MultipleReferencesValueConstraint__MultipleReferencesValueConstraint);
			Fragments._MultipleReferencesValueConstraint__NamedElement.initOperations(_MultipleReferencesValueConstraint__NamedElement);
			Fragments._MultipleReferencesValueConstraint__OclAny.initOperations(_MultipleReferencesValueConstraint__OclAny);
			Fragments._MultipleReferencesValueConstraint__OclElement.initOperations(_MultipleReferencesValueConstraint__OclElement);
			Fragments._MultipleReferencesValueConstraint__ValueConstraint.initOperations(_MultipleReferencesValueConstraint__ValueConstraint);

			Fragments._NonContainmentReference__MetaModelElement.initOperations(_NonContainmentReference__MetaModelElement);
			Fragments._NonContainmentReference__NamedElement.initOperations(_NonContainmentReference__NamedElement);
			Fragments._NonContainmentReference__NonContainmentReference.initOperations(_NonContainmentReference__NonContainmentReference);
			Fragments._NonContainmentReference__OclAny.initOperations(_NonContainmentReference__OclAny);
			Fragments._NonContainmentReference__OclElement.initOperations(_NonContainmentReference__OclElement);
			Fragments._NonContainmentReference__Reference.initOperations(_NonContainmentReference__Reference);

			Fragments._RangeBound__ExpressionHint.initOperations(_RangeBound__ExpressionHint);
			Fragments._RangeBound__ModifiableHint.initOperations(_RangeBound__ModifiableHint);
			Fragments._RangeBound__OclAny.initOperations(_RangeBound__OclAny);
			Fragments._RangeBound__OclElement.initOperations(_RangeBound__OclElement);
			Fragments._RangeBound__RangeBound.initOperations(_RangeBound__RangeBound);

			Fragments._RangeConstraint__MultipleReferencesValueConstraint.initOperations(_RangeConstraint__MultipleReferencesValueConstraint);
			Fragments._RangeConstraint__NamedElement.initOperations(_RangeConstraint__NamedElement);
			Fragments._RangeConstraint__OclAny.initOperations(_RangeConstraint__OclAny);
			Fragments._RangeConstraint__OclElement.initOperations(_RangeConstraint__OclElement);
			Fragments._RangeConstraint__RangeConstraint.initOperations(_RangeConstraint__RangeConstraint);
			Fragments._RangeConstraint__ValueConstraint.initOperations(_RangeConstraint__ValueConstraint);

			Fragments._Reference__MetaModelElement.initOperations(_Reference__MetaModelElement);
			Fragments._Reference__NamedElement.initOperations(_Reference__NamedElement);
			Fragments._Reference__OclAny.initOperations(_Reference__OclAny);
			Fragments._Reference__OclElement.initOperations(_Reference__OclElement);
			Fragments._Reference__Reference.initOperations(_Reference__Reference);

			Fragments._RegExMatcher__ExpressionHint.initOperations(_RegExMatcher__ExpressionHint);
			Fragments._RegExMatcher__ModifiableHint.initOperations(_RegExMatcher__ModifiableHint);
			Fragments._RegExMatcher__NamedElement.initOperations(_RegExMatcher__NamedElement);
			Fragments._RegExMatcher__OclAny.initOperations(_RegExMatcher__OclAny);
			Fragments._RegExMatcher__OclElement.initOperations(_RegExMatcher__OclElement);
			Fragments._RegExMatcher__RegExMatcher.initOperations(_RegExMatcher__RegExMatcher);
			Fragments._RegExMatcher__SingleReferenceValueConstraint.initOperations(_RegExMatcher__SingleReferenceValueConstraint);
			Fragments._RegExMatcher__ValueConstraint.initOperations(_RegExMatcher__ValueConstraint);

			Fragments._ResourceParameter__NamedElement.initOperations(_ResourceParameter__NamedElement);
			Fragments._ResourceParameter__OclAny.initOperations(_ResourceParameter__OclAny);
			Fragments._ResourceParameter__OclElement.initOperations(_ResourceParameter__OclElement);
			Fragments._ResourceParameter__ResourceParameter.initOperations(_ResourceParameter__ResourceParameter);

			Fragments._Section__Class.initOperations(_Section__Class);
			Fragments._Section__MetaModelElement.initOperations(_Section__MetaModelElement);
			Fragments._Section__NamedElement.initOperations(_Section__NamedElement);
			Fragments._Section__OclAny.initOperations(_Section__OclAny);
			Fragments._Section__OclElement.initOperations(_Section__OclElement);
			Fragments._Section__Section.initOperations(_Section__Section);

			Fragments._SingleReferenceValueConstraint__ExpressionHint.initOperations(_SingleReferenceValueConstraint__ExpressionHint);
			Fragments._SingleReferenceValueConstraint__ModifiableHint.initOperations(_SingleReferenceValueConstraint__ModifiableHint);
			Fragments._SingleReferenceValueConstraint__NamedElement.initOperations(_SingleReferenceValueConstraint__NamedElement);
			Fragments._SingleReferenceValueConstraint__OclAny.initOperations(_SingleReferenceValueConstraint__OclAny);
			Fragments._SingleReferenceValueConstraint__OclElement.initOperations(_SingleReferenceValueConstraint__OclElement);
			Fragments._SingleReferenceValueConstraint__SingleReferenceValueConstraint.initOperations(_SingleReferenceValueConstraint__SingleReferenceValueConstraint);
			Fragments._SingleReferenceValueConstraint__ValueConstraint.initOperations(_SingleReferenceValueConstraint__ValueConstraint);

			Fragments._SourceSection__Class.initOperations(_SourceSection__Class);
			Fragments._SourceSection__MetaModelElement.initOperations(_SourceSection__MetaModelElement);
			Fragments._SourceSection__NamedElement.initOperations(_SourceSection__NamedElement);
			Fragments._SourceSection__OclAny.initOperations(_SourceSection__OclAny);
			Fragments._SourceSection__OclElement.initOperations(_SourceSection__OclElement);
			Fragments._SourceSection__Section.initOperations(_SourceSection__Section);
			Fragments._SourceSection__SourceSection.initOperations(_SourceSection__SourceSection);
			Fragments._SourceSection__SourceSectionClass.initOperations(_SourceSection__SourceSectionClass);

			Fragments._SourceSectionAttribute__Attribute.initOperations(_SourceSectionAttribute__Attribute);
			Fragments._SourceSectionAttribute__MetaModelElement.initOperations(_SourceSectionAttribute__MetaModelElement);
			Fragments._SourceSectionAttribute__NamedElement.initOperations(_SourceSectionAttribute__NamedElement);
			Fragments._SourceSectionAttribute__OclAny.initOperations(_SourceSectionAttribute__OclAny);
			Fragments._SourceSectionAttribute__OclElement.initOperations(_SourceSectionAttribute__OclElement);
			Fragments._SourceSectionAttribute__SourceSectionAttribute.initOperations(_SourceSectionAttribute__SourceSectionAttribute);

			Fragments._SourceSectionClass__Class.initOperations(_SourceSectionClass__Class);
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

			Fragments._SubstringMatcher__CaseSensitiveConstraint.initOperations(_SubstringMatcher__CaseSensitiveConstraint);
			Fragments._SubstringMatcher__ExpressionHint.initOperations(_SubstringMatcher__ExpressionHint);
			Fragments._SubstringMatcher__ModifiableHint.initOperations(_SubstringMatcher__ModifiableHint);
			Fragments._SubstringMatcher__NamedElement.initOperations(_SubstringMatcher__NamedElement);
			Fragments._SubstringMatcher__OclAny.initOperations(_SubstringMatcher__OclAny);
			Fragments._SubstringMatcher__OclElement.initOperations(_SubstringMatcher__OclElement);
			Fragments._SubstringMatcher__SingleReferenceValueConstraint.initOperations(_SubstringMatcher__SingleReferenceValueConstraint);
			Fragments._SubstringMatcher__SubstringMatcher.initOperations(_SubstringMatcher__SubstringMatcher);
			Fragments._SubstringMatcher__ValueConstraint.initOperations(_SubstringMatcher__ValueConstraint);

			Fragments._TargetSection__Class.initOperations(_TargetSection__Class);
			Fragments._TargetSection__MetaModelElement.initOperations(_TargetSection__MetaModelElement);
			Fragments._TargetSection__NamedElement.initOperations(_TargetSection__NamedElement);
			Fragments._TargetSection__OclAny.initOperations(_TargetSection__OclAny);
			Fragments._TargetSection__OclElement.initOperations(_TargetSection__OclElement);
			Fragments._TargetSection__Section.initOperations(_TargetSection__Section);
			Fragments._TargetSection__TargetSection.initOperations(_TargetSection__TargetSection);
			Fragments._TargetSection__TargetSectionClass.initOperations(_TargetSection__TargetSectionClass);

			Fragments._TargetSectionAttribute__Attribute.initOperations(_TargetSectionAttribute__Attribute);
			Fragments._TargetSectionAttribute__MetaModelElement.initOperations(_TargetSectionAttribute__MetaModelElement);
			Fragments._TargetSectionAttribute__NamedElement.initOperations(_TargetSectionAttribute__NamedElement);
			Fragments._TargetSectionAttribute__OclAny.initOperations(_TargetSectionAttribute__OclAny);
			Fragments._TargetSectionAttribute__OclElement.initOperations(_TargetSectionAttribute__OclElement);
			Fragments._TargetSectionAttribute__TargetSectionAttribute.initOperations(_TargetSectionAttribute__TargetSectionAttribute);

			Fragments._TargetSectionClass__Class.initOperations(_TargetSectionClass__Class);
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

			Fragments._ValueConstraint__NamedElement.initOperations(_ValueConstraint__NamedElement);
			Fragments._ValueConstraint__OclAny.initOperations(_ValueConstraint__OclAny);
			Fragments._ValueConstraint__OclElement.initOperations(_ValueConstraint__OclElement);
			Fragments._ValueConstraint__ValueConstraint.initOperations(_ValueConstraint__ValueConstraint);

			Fragments._ValueConstraintExternalSourceElement__ExternalModifiedAttributeElementType.initOperations(_ValueConstraintExternalSourceElement__ExternalModifiedAttributeElementType);
			Fragments._ValueConstraintExternalSourceElement__MappingHintSourceInterface.initOperations(_ValueConstraintExternalSourceElement__MappingHintSourceInterface);
			Fragments._ValueConstraintExternalSourceElement__ModifiedAttributeElementType.initOperations(_ValueConstraintExternalSourceElement__ModifiedAttributeElementType);
			Fragments._ValueConstraintExternalSourceElement__NamedElement.initOperations(_ValueConstraintExternalSourceElement__NamedElement);
			Fragments._ValueConstraintExternalSourceElement__OclAny.initOperations(_ValueConstraintExternalSourceElement__OclAny);
			Fragments._ValueConstraintExternalSourceElement__OclElement.initOperations(_ValueConstraintExternalSourceElement__OclElement);
			Fragments._ValueConstraintExternalSourceElement__ValueConstraintExternalSourceElement.initOperations(_ValueConstraintExternalSourceElement__ValueConstraintExternalSourceElement);
			Fragments._ValueConstraintExternalSourceElement__ValueConstraintSourceInterface.initOperations(_ValueConstraintExternalSourceElement__ValueConstraintSourceInterface);

			Fragments._ValueConstraintSourceElement__LocalModifiedAttributeElementType.initOperations(_ValueConstraintSourceElement__LocalModifiedAttributeElementType);
			Fragments._ValueConstraintSourceElement__MappingHintSourceInterface.initOperations(_ValueConstraintSourceElement__MappingHintSourceInterface);
			Fragments._ValueConstraintSourceElement__ModifiedAttributeElementType.initOperations(_ValueConstraintSourceElement__ModifiedAttributeElementType);
			Fragments._ValueConstraintSourceElement__NamedElement.initOperations(_ValueConstraintSourceElement__NamedElement);
			Fragments._ValueConstraintSourceElement__OclAny.initOperations(_ValueConstraintSourceElement__OclAny);
			Fragments._ValueConstraintSourceElement__OclElement.initOperations(_ValueConstraintSourceElement__OclElement);
			Fragments._ValueConstraintSourceElement__ValueConstraintSourceElement.initOperations(_ValueConstraintSourceElement__ValueConstraintSourceElement);
			Fragments._ValueConstraintSourceElement__ValueConstraintSourceInterface.initOperations(_ValueConstraintSourceElement__ValueConstraintSourceInterface);

			Fragments._ValueConstraintSourceInterface__MappingHintSourceInterface.initOperations(_ValueConstraintSourceInterface__MappingHintSourceInterface);
			Fragments._ValueConstraintSourceInterface__NamedElement.initOperations(_ValueConstraintSourceInterface__NamedElement);
			Fragments._ValueConstraintSourceInterface__OclAny.initOperations(_ValueConstraintSourceInterface__OclAny);
			Fragments._ValueConstraintSourceInterface__OclElement.initOperations(_ValueConstraintSourceInterface__OclElement);
			Fragments._ValueConstraintSourceInterface__ValueConstraintSourceInterface.initOperations(_ValueConstraintSourceInterface__ValueConstraintSourceInterface);

			Fragments._ValueConstraintType__OclAny.initOperations(_ValueConstraintType__OclAny);
			Fragments._ValueConstraintType__OclElement.initOperations(_ValueConstraintType__OclElement);
			Fragments._ValueConstraintType__OclEnumeration.initOperations(_ValueConstraintType__OclEnumeration);
			Fragments._ValueConstraintType__OclType.initOperations(_ValueConstraintType__OclType);
			Fragments._ValueConstraintType__ValueConstraintType.initOperations(_ValueConstraintType__ValueConstraintType);

			Fragments._VirtualAttribute__Attribute.initOperations(_VirtualAttribute__Attribute);
			Fragments._VirtualAttribute__MetaModelElement.initOperations(_VirtualAttribute__MetaModelElement);
			Fragments._VirtualAttribute__NamedElement.initOperations(_VirtualAttribute__NamedElement);
			Fragments._VirtualAttribute__OclAny.initOperations(_VirtualAttribute__OclAny);
			Fragments._VirtualAttribute__OclElement.initOperations(_VirtualAttribute__OclElement);
			Fragments._VirtualAttribute__VirtualAttribute.initOperations(_VirtualAttribute__VirtualAttribute);

			Fragments._VirtualTargetSectionAttribute__Attribute.initOperations(_VirtualTargetSectionAttribute__Attribute);
			Fragments._VirtualTargetSectionAttribute__MetaModelElement.initOperations(_VirtualTargetSectionAttribute__MetaModelElement);
			Fragments._VirtualTargetSectionAttribute__NamedElement.initOperations(_VirtualTargetSectionAttribute__NamedElement);
			Fragments._VirtualTargetSectionAttribute__OclAny.initOperations(_VirtualTargetSectionAttribute__OclAny);
			Fragments._VirtualTargetSectionAttribute__OclElement.initOperations(_VirtualTargetSectionAttribute__OclElement);
			Fragments._VirtualTargetSectionAttribute__TargetSectionAttribute.initOperations(_VirtualTargetSectionAttribute__TargetSectionAttribute);
			Fragments._VirtualTargetSectionAttribute__VirtualAttribute.initOperations(_VirtualTargetSectionAttribute__VirtualAttribute);
			Fragments._VirtualTargetSectionAttribute__VirtualTargetSectionAttribute.initOperations(_VirtualTargetSectionAttribute__VirtualTargetSectionAttribute);

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

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ActualAttribute = {
			MetamodelTables.Properties._ActualAttribute__attribute,
			MetamodelTables.Properties._Attribute__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ActualSourceSectionAttribute = {
			MetamodelTables.Properties._ActualAttribute__attribute,
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._SourceSectionAttribute__valueConstraint,
			MetamodelTables.Properties._ActualSourceSectionAttribute__InstancePointer__target
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ActualTargetSectionAttribute = {
			MetamodelTables.Properties._ActualAttribute__attribute,
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._TargetSectionAttribute__unique,
			MetamodelTables.Properties._TargetSectionAttribute__value,
			MetamodelTables.Properties._ActualTargetSectionAttribute__AttributeParameter__attribute
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Attribute = {
			MetamodelTables.Properties._Attribute__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeParameter = {
			MetamodelTables.Properties._AttributeParameter__attribute,
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _BeginningMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._SingleReferenceValueConstraint__sourceElements,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _CardinalityType = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _CaseSensitiveConstraint = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._SingleReferenceValueConstraint__sourceElements,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Class = {
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Class__references
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ContainerParameter = {
			MetamodelTables.Properties._ContainerParameter__class,
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._ContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _EndingMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._SingleReferenceValueConstraint__sourceElements,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _EqualityMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._SingleReferenceValueConstraint__sourceElements,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExternalReferenceParameter = {
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._ExternalReferenceParameter__reference,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _FileAttribute = {
			MetamodelTables.Properties._FileAttribute__fileType,
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._TargetSectionAttribute__unique,
			MetamodelTables.Properties._TargetSectionAttribute__value,
			MetamodelTables.Properties._VirtualTargetSectionAttribute__LibraryEntry__id,
			MetamodelTables.Properties._VirtualTargetSectionAttribute__LibraryEntry__path,
			MetamodelTables.Properties._VirtualTargetSectionAttribute__ResourceParameter__attribute,
			MetamodelTables.Properties._FileAttribute__TargetSection__file
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _FileTypeEnum = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _InstancePointer = {
			MetamodelTables.Properties._InstancePointer__sourceElements,
			MetamodelTables.Properties._InstancePointer__target,
			MetamodelTables.Properties._InstancePointer__RangeBound__boundReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._InstancePointer__SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _InstancePointerExternalSourceElement = {
			MetamodelTables.Properties._InstancePointerSourceInterface__InstancePointer__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _InstancePointerSourceElement = {
			MetamodelTables.Properties._InstancePointerSourceInterface__InstancePointer__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _InstancePointerSourceInterface = {
			MetamodelTables.Properties._InstancePointerSourceInterface__InstancePointer__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _LibraryEntry = {
			MetamodelTables.Properties._LibraryEntry__id,
			MetamodelTables.Properties._LibraryEntry__libraryFile,
			MetamodelTables.Properties._LibraryEntry__originalLibraryEntry,
			MetamodelTables.Properties._LibraryEntry__parameters,
			MetamodelTables.Properties._LibraryEntry__path,
			MetamodelTables.Properties._LibraryEntry__resourceParameters
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _LibraryParameter = {
			MetamodelTables.Properties._LibraryParameter__originalParameter,
			MetamodelTables.Properties._LibraryParameter__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MetaModelElement = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MetaModelSectionReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._MetaModelSectionReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MultipleReferencesValueConstraint = {
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _NonContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._NonContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _RangeBound = {
			MetamodelTables.Properties._RangeBound__boundReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._RangeBound__boundType,
			MetamodelTables.Properties._RangeBound__sourceElements,
			MetamodelTables.Properties._RangeBound__RangeConstraint__lowerBound,
			MetamodelTables.Properties._RangeBound__RangeConstraint__upperBound
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _RangeConstraint = {
			MetamodelTables.Properties._RangeConstraint__lowerBound,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._RangeConstraint__upperBound,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Reference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _RegExMatcher = {
			MetamodelTables.Properties._SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._SingleReferenceValueConstraint__sourceElements,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ResourceParameter = {
			MetamodelTables.Properties._ResourceParameter__attribute,
			MetamodelTables.Properties._ResourceParameter__originalParameter,
			MetamodelTables.Properties._ResourceParameter__LibraryEntry__resourceParameters
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Section = {
			MetamodelTables.Properties._Section__abstract,
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Section__extend,
			MetamodelTables.Properties._Class__references
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SingleReferenceValueConstraint = {
			MetamodelTables.Properties._SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._SingleReferenceValueConstraint__sourceElements,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SourceSection = {
			MetamodelTables.Properties._Section__abstract,
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Section__extend,
			MetamodelTables.Properties._Class__references,
			MetamodelTables.Properties._SourceSection__referencingMappings,
			MetamodelTables.Properties._SourceSectionClass__MetaModelSectionReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SourceSectionAttribute = {
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SourceSectionClass = {
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Class__references,
			MetamodelTables.Properties._SourceSectionClass__MetaModelSectionReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SourceSectionContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._ContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SourceSectionReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SubstringMatcher = {
			MetamodelTables.Properties._CaseSensitiveConstraint__caseSensitive,
			MetamodelTables.Properties._SingleReferenceValueConstraint__constraintReferenceValueAdditionalSpecification,
			MetamodelTables.Properties._SingleReferenceValueConstraint__sourceElements,
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _TargetSection = {
			MetamodelTables.Properties._Section__abstract,
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Section__extend,
			MetamodelTables.Properties._TargetSection__file,
			MetamodelTables.Properties._Class__references,
			MetamodelTables.Properties._TargetSection__referencingMappingHintGroups,
			MetamodelTables.Properties._TargetSection__ContainerParameter__class
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _TargetSectionAttribute = {
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._TargetSectionAttribute__unique,
			MetamodelTables.Properties._TargetSectionAttribute__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _TargetSectionClass = {
			MetamodelTables.Properties._Class__attributes,
			MetamodelTables.Properties._Class__cardinality,
			MetamodelTables.Properties._Class__container,
			MetamodelTables.Properties._Class__eClass,
			MetamodelTables.Properties._Class__references
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _TargetSectionContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._ContainmentReference__value
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _TargetSectionNonContainmentReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass,
			MetamodelTables.Properties._NonContainmentReference__value,
			MetamodelTables.Properties._TargetSectionNonContainmentReference__ExternalReferenceParameter__reference
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _TargetSectionReference = {
			MetamodelTables.Properties._Reference__eReference,
			MetamodelTables.Properties._Reference__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ValueConstraint = {
			MetamodelTables.Properties._ValueConstraint__type,
			MetamodelTables.Properties._ValueConstraint__SourceSectionAttribute__valueConstraint
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ValueConstraintExternalSourceElement = {
			MetamodelTables.Properties._ValueConstraintSourceInterface__RangeBound__sourceElements,
			MetamodelTables.Properties._ValueConstraintSourceInterface__SingleReferenceValueConstraint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ValueConstraintSourceElement = {
			MetamodelTables.Properties._ValueConstraintSourceInterface__RangeBound__sourceElements,
			MetamodelTables.Properties._ValueConstraintSourceInterface__SingleReferenceValueConstraint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ValueConstraintSourceInterface = {
			MetamodelTables.Properties._ValueConstraintSourceInterface__RangeBound__sourceElements,
			MetamodelTables.Properties._ValueConstraintSourceInterface__SingleReferenceValueConstraint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ValueConstraintType = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _VirtualAttribute = {
			MetamodelTables.Properties._Attribute__owningClass
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _VirtualTargetSectionAttribute = {
			MetamodelTables.Properties._Attribute__owningClass,
			MetamodelTables.Properties._TargetSectionAttribute__unique,
			MetamodelTables.Properties._TargetSectionAttribute__value,
			MetamodelTables.Properties._VirtualTargetSectionAttribute__LibraryEntry__id,
			MetamodelTables.Properties._VirtualTargetSectionAttribute__LibraryEntry__path,
			MetamodelTables.Properties._VirtualTargetSectionAttribute__ResourceParameter__attribute
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._ActualAttribute__ActualAttribute.initProperties(_ActualAttribute);
			Fragments._ActualSourceSectionAttribute__ActualSourceSectionAttribute.initProperties(_ActualSourceSectionAttribute);
			Fragments._ActualTargetSectionAttribute__ActualTargetSectionAttribute.initProperties(_ActualTargetSectionAttribute);
			Fragments._Attribute__Attribute.initProperties(_Attribute);
			Fragments._AttributeParameter__AttributeParameter.initProperties(_AttributeParameter);
			Fragments._BeginningMatcher__BeginningMatcher.initProperties(_BeginningMatcher);
			Fragments._CardinalityType__CardinalityType.initProperties(_CardinalityType);
			Fragments._CaseSensitiveConstraint__CaseSensitiveConstraint.initProperties(_CaseSensitiveConstraint);
			Fragments._Class__Class.initProperties(_Class);
			Fragments._ContainerParameter__ContainerParameter.initProperties(_ContainerParameter);
			Fragments._ContainmentReference__ContainmentReference.initProperties(_ContainmentReference);
			Fragments._EndingMatcher__EndingMatcher.initProperties(_EndingMatcher);
			Fragments._EqualityMatcher__EqualityMatcher.initProperties(_EqualityMatcher);
			Fragments._ExternalReferenceParameter__ExternalReferenceParameter.initProperties(_ExternalReferenceParameter);
			Fragments._FileAttribute__FileAttribute.initProperties(_FileAttribute);
			Fragments._FileTypeEnum__FileTypeEnum.initProperties(_FileTypeEnum);
			Fragments._InstancePointer__InstancePointer.initProperties(_InstancePointer);
			Fragments._InstancePointerExternalSourceElement__InstancePointerExternalSourceElement.initProperties(_InstancePointerExternalSourceElement);
			Fragments._InstancePointerSourceElement__InstancePointerSourceElement.initProperties(_InstancePointerSourceElement);
			Fragments._InstancePointerSourceInterface__InstancePointerSourceInterface.initProperties(_InstancePointerSourceInterface);
			Fragments._LibraryEntry__LibraryEntry.initProperties(_LibraryEntry);
			Fragments._LibraryParameter__LibraryParameter.initProperties(_LibraryParameter);
			Fragments._MetaModelElement__MetaModelElement.initProperties(_MetaModelElement);
			Fragments._MetaModelSectionReference__MetaModelSectionReference.initProperties(_MetaModelSectionReference);
			Fragments._MultipleReferencesValueConstraint__MultipleReferencesValueConstraint.initProperties(_MultipleReferencesValueConstraint);
			Fragments._NonContainmentReference__NonContainmentReference.initProperties(_NonContainmentReference);
			Fragments._RangeBound__RangeBound.initProperties(_RangeBound);
			Fragments._RangeConstraint__RangeConstraint.initProperties(_RangeConstraint);
			Fragments._Reference__Reference.initProperties(_Reference);
			Fragments._RegExMatcher__RegExMatcher.initProperties(_RegExMatcher);
			Fragments._ResourceParameter__ResourceParameter.initProperties(_ResourceParameter);
			Fragments._Section__Section.initProperties(_Section);
			Fragments._SingleReferenceValueConstraint__SingleReferenceValueConstraint.initProperties(_SingleReferenceValueConstraint);
			Fragments._SourceSection__SourceSection.initProperties(_SourceSection);
			Fragments._SourceSectionAttribute__SourceSectionAttribute.initProperties(_SourceSectionAttribute);
			Fragments._SourceSectionClass__SourceSectionClass.initProperties(_SourceSectionClass);
			Fragments._SourceSectionContainmentReference__SourceSectionContainmentReference.initProperties(_SourceSectionContainmentReference);
			Fragments._SourceSectionReference__SourceSectionReference.initProperties(_SourceSectionReference);
			Fragments._SubstringMatcher__SubstringMatcher.initProperties(_SubstringMatcher);
			Fragments._TargetSection__TargetSection.initProperties(_TargetSection);
			Fragments._TargetSectionAttribute__TargetSectionAttribute.initProperties(_TargetSectionAttribute);
			Fragments._TargetSectionClass__TargetSectionClass.initProperties(_TargetSectionClass);
			Fragments._TargetSectionContainmentReference__TargetSectionContainmentReference.initProperties(_TargetSectionContainmentReference);
			Fragments._TargetSectionNonContainmentReference__TargetSectionNonContainmentReference.initProperties(_TargetSectionNonContainmentReference);
			Fragments._TargetSectionReference__TargetSectionReference.initProperties(_TargetSectionReference);
			Fragments._ValueConstraint__ValueConstraint.initProperties(_ValueConstraint);
			Fragments._ValueConstraintExternalSourceElement__ValueConstraintExternalSourceElement.initProperties(_ValueConstraintExternalSourceElement);
			Fragments._ValueConstraintSourceElement__ValueConstraintSourceElement.initProperties(_ValueConstraintSourceElement);
			Fragments._ValueConstraintSourceInterface__ValueConstraintSourceInterface.initProperties(_ValueConstraintSourceInterface);
			Fragments._ValueConstraintType__ValueConstraintType.initProperties(_ValueConstraintType);
			Fragments._VirtualAttribute__VirtualAttribute.initProperties(_VirtualAttribute);
			Fragments._VirtualTargetSectionAttribute__VirtualTargetSectionAttribute.initProperties(_VirtualTargetSectionAttribute);

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

		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CardinalityType__ONE = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.CARDINALITY_TYPE.getEEnumLiteral("ONE"), Types._CardinalityType, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CardinalityType__ONE__INFINITY = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.CARDINALITY_TYPE.getEEnumLiteral("ONE__INFINITY"), Types._CardinalityType, 1);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _CardinalityType__ZERO__INFINITY = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.CARDINALITY_TYPE.getEEnumLiteral("ZERO__INFINITY"), Types._CardinalityType, 2);
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _CardinalityType = {
			_CardinalityType__ONE,
			_CardinalityType__ONE__INFINITY,
			_CardinalityType__ZERO__INFINITY
		};

		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _FileTypeEnum__XMI = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.FILE_TYPE_ENUM.getEEnumLiteral("XMI"), Types._FileTypeEnum, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _FileTypeEnum__XML = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.FILE_TYPE_ENUM.getEEnumLiteral("XML"), Types._FileTypeEnum, 1);
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _FileTypeEnum = {
			_FileTypeEnum__XMI,
			_FileTypeEnum__XML
		};

		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _ValueConstraintType__INCLUSION = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.VALUE_CONSTRAINT_TYPE.getEEnumLiteral("INCLUSION"), Types._ValueConstraintType, 0);
		public static final /*@NonNull*/ EcoreExecutorEnumerationLiteral _ValueConstraintType__EXCLUSION = new EcoreExecutorEnumerationLiteral(MetamodelPackage.Literals.VALUE_CONSTRAINT_TYPE.getEEnumLiteral("EXCLUSION"), Types._ValueConstraintType, 1);
		private static final /*@NonNull*/ EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _ValueConstraintType = {
			_ValueConstraintType__INCLUSION,
			_ValueConstraintType__EXCLUSION
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._CardinalityType.initLiterals(_CardinalityType);
			Types._FileTypeEnum.initLiterals(_FileTypeEnum);
			Types._ValueConstraintType.initLiterals(_ValueConstraintType);

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
