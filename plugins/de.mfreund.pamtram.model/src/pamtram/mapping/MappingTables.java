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
package pamtram.mapping;

import org.eclipse.ocl.pivot.ParameterTypes;
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
import pamtram.mapping.MappingTables;
import pamtram.metamodel.MetamodelTables;

/**
 * MappingTables provides the dispatch tables for the mapping for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
@SuppressWarnings("nls")
public class MappingTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final /*@NonNull*/ EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(MappingPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final /*@NonNull*/ ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.RootPackageId PACKid_$metamodel$ = org.eclipse.ocl.pivot.ids.IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram", null, pamtram.PamtramPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/mapping", null, pamtram.mapping.MappingPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://mfreund.de/pamtram/metamodel", null, pamtram.metamodel.MetamodelPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = org.eclipse.ocl.pivot.ids.IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ActualSourceSectionAttribute = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("ActualSourceSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Attribute = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("Attribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMapping = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMapping", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMappingExternalSourceElement = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMappingExternalSourceElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMappingSourceElement = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMappingSourceElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMappingSourceInterface = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMappingSourceInterface", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMatcher = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMatcher", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMatcherExternalSourceElement = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMatcherExternalSourceElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMatcherSourceElement = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMatcherSourceElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_AttributeMatcherSourceInterface = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("AttributeMatcherSourceInterface", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_CardinalityMapping = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("CardinalityMapping", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Class = pamtram.mapping.MappingTables.PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Class_0 = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EAttribute = pamtram.mapping.MappingTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EClass = pamtram.mapping.MappingTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EClass", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_EReference = pamtram.mapping.MappingTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EReference", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ExpandableHint = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ExpandableHint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ExportedMappingHintGroup = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ExportedMappingHintGroup", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ExternalModifiedAttributeElementType = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ExternalModifiedAttributeElementType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_GlobalAttribute = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("GlobalAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_GlobalAttributeImporter = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("GlobalAttributeImporter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_InstancePointer = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("InstancePointer", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappedAttributeValueExpander = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappedAttributeValueExpander", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Mapping = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("Mapping", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingHint = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingHintGroup = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintGroup", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingHintGroupImporter = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintGroupImporter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingHintGroupType = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintGroupType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingHintType = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("MappingHintType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_MappingModel = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("MappingModel", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Matcher = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("Matcher", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModelConnectionHint = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModelConnectionHint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModelConnectionHintExternalSourceElement = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModelConnectionHintExternalSourceElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModelConnectionHintSourceElement = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModelConnectionHintSourceElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModelConnectionHintSourceInterface = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModelConnectionHintSourceInterface", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModelConnectionHintTargetAttribute = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModelConnectionHintTargetAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModifiableHint = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModifiableHint", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ModifiedAttributeElementType = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ModifiedAttributeElementType", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_NamedElement = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("NamedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_OclElement = pamtram.mapping.MappingTables.PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_PAMTraM = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram.getClassId("PAMTraM", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ReferenceTargetSelector = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ReferenceTargetSelector", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_Section = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("Section", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSection = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSection", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSectionAttribute = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_SourceSectionClass = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("SourceSectionClass", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSection = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSection", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSectionAttribute = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSectionAttribute", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSectionClass = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSectionClass", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_TargetSectionNonContainmentReference = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getClassId("TargetSectionNonContainmentReference", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ValueModifier = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ValueModifier", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.ClassId CLSSid_ValueModifierSet = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_mapping.getClassId("ValueModifierSet", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.DataTypeId DATAid_EInt = pamtram.mapping.MappingTables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EInt", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.EnumerationId ENUMid_CardinalityType = pamtram.mapping.MappingTables.PACKid_http_c_s_s_mfreund_de_s_pamtram_s_metamodel.getEnumerationId("CardinalityType");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_0 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("0");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_1 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("1");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_2 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("2");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.IntegerValue INT_4 = org.eclipse.ocl.pivot.utilities.ValueUtil.integerValueOf("4");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_TMPLid_ = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(org.eclipse.ocl.pivot.ids.IdManager.getTemplateParameterId(0));
    public static final /*@NonInvalid*/ java.lang.String STR_AttributeMapping_c_c_targetAttributeMatchesSection = "AttributeMapping::targetAttributeMatchesSection";
    public static final /*@NonInvalid*/ java.lang.String STR_AttributeMatcher_c_c_targetMatchesAffectedReferenceType = "AttributeMatcher::targetMatchesAffectedReferenceType";
    public static final /*@NonInvalid*/ java.lang.String STR_CardinalityMapping_c_c_noCardinalityMappingForSourceSectionRoot = "CardinalityMapping::noCardinalityMappingForSourceSectionRoot";
    public static final /*@NonInvalid*/ java.lang.String STR_CardinalityMapping_c_c_sourceClassIsVariableCardinality = "CardinalityMapping::sourceClassIsVariableCardinality";
    public static final /*@NonInvalid*/ java.lang.String STR_CardinalityMapping_c_c_sourceClassMatchesSection = "CardinalityMapping::sourceClassMatchesSection";
    public static final /*@NonInvalid*/ java.lang.String STR_CardinalityMapping_c_c_targetClassIsVariableCardinality = "CardinalityMapping::targetClassIsVariableCardinality";
    public static final /*@NonInvalid*/ java.lang.String STR_CardinalityMapping_c_c_targetClassMatchesSection = "CardinalityMapping::targetClassMatchesSection";
    public static final /*@NonInvalid*/ java.lang.String STR_Cardinality_32_mappings_32_may_32_only_32_be_32_defined_32_for_32_source_32_classes_32_with = "Cardinality mappings may only be defined for source classes with a specified cardinality distinct from \'CardinalityType::ONE\'!";
    public static final /*@NonInvalid*/ java.lang.String STR_Cardinality_32_mappings_32_may_32_only_32_be_32_defined_32_for_32_target_32_classes_32_with = "Cardinality mappings may only be defined for target classes with a specified cardinality distinct from \'CardinalityType::ONE\'!";
    public static final /*@NonInvalid*/ java.lang.String STR_Cardinality_32_mappings_32_must_32_not_32_be_32_defined_32_for_32_SourceSection_32_root_32 = "Cardinality mappings must not be defined for SourceSection root classes!";
    public static final /*@NonInvalid*/ java.lang.String STR_ExternalModifiedAttributeElementType_c_c_sourceAttributeMatchesCont = "ExternalModifiedAttributeElementType::sourceAttributeMatchesContainerSection";
    public static final /*@NonInvalid*/ java.lang.String STR_GlobalAttribute_c_c_sourceAttributeHasUpperBoundOne = "GlobalAttribute::sourceAttributeHasUpperBoundOne";
    public static final /*@NonInvalid*/ java.lang.String STR_Global_32_attributes_32_may_32_only_32_be_32_defined_32_for_32_attributes_32_that_32_have_32_a = "Global attributes may only be defined for attributes that have an upper bound of 1!";
    public static final /*@NonInvalid*/ java.lang.String STR_Mapping_c_c_containsDeactivatedHintGroups = "Mapping::containsDeactivatedHintGroups";
    public static final /*@NonInvalid*/ java.lang.String STR_Mapping_c_c_containsHintGroups = "Mapping::containsHintGroups";
    public static final /*@NonInvalid*/ java.lang.String STR_ModelConnectionHintTargetAttribute_c_c_sourceMatchesPossibleContain = "ModelConnectionHintTargetAttribute::sourceMatchesPossibleContainerType";
    public static final /*@NonInvalid*/ java.lang.String STR_ReferenceTargetSelector_c_c_affectedReferenceIsNonContainment = "ReferenceTargetSelector::affectedReferenceIsNonContainment";
    public static final /*@NonInvalid*/ java.lang.String STR_ReferenceTargetSelector_c_c_affectedReferenceMatchesSection = "ReferenceTargetSelector::affectedReferenceMatchesSection";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_affected_32_reference_32_39 = "The affected reference \'";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_affected_32_reference_32_39_32_p_32_self_affectedReference_name_32_p_32_39_32_is_32_no = "The affected reference \' + self.affectedReference.name + \' is no non-containment reference!";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_mapping_32_contains_32_deactivated_32_hint_32_groups_32_that_32_will_32_not_32_be_32_us = "The mapping contains deactivated hint groups that will not be used in a transformation!";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_mapping_32_does_32_not_32_contain_32_any_32_hint_32_groups_33 = "The mapping does not contain any hint groups!";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_source_32_attribute_32_39 = "The source attribute \'";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_source_32_class_32_39 = "The source class \'";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_target_32_attribute_32_39 = "The target attribute \'";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_target_32_class_32_39 = "The target class \'";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_type_32_of_32_the_32_class_32_containing_32_the_32_target_32_attribute_32_o_39 = "The type of the class containing the target attribute (\'";
    public static final /*@NonInvalid*/ java.lang.String STR_The_32_type_32_of_32_the_32_parent_32_hint_32_group_39_s_32_target_32_section_32_o_39 = "The type of the parent hint group\'s target section (\'";
    public static final /*@NonInvalid*/ java.lang.String STR__33 = "!";
    public static final /*@NonInvalid*/ java.lang.String STR__39_32_is_32_not_32_part_32_of_32_a_32_container_32_section_32_of_32_the_32_source_32_section_32_of_32_th = "\' is not part of a container section of the source section of the parent mapping \'";
    public static final /*@NonInvalid*/ java.lang.String STR__39_32_is_32_not_32_part_32_of_32_the_32_source_32_section_32_referenced_32_by_32_parent_32_mapping = "\' is not part of the source section referenced by parent mapping \'";
    public static final /*@NonInvalid*/ java.lang.String STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr = "\' is not part of the target section referenced by parent hint group ";
    public static final /*@NonInvalid*/ java.lang.String STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr_0 = "\' is not part of the target section referenced by parent hint group \'";
    public static final /*@NonInvalid*/ java.lang.String STR__39_33 = "\'!";
    public static final /*@NonInvalid*/ java.lang.String STR__39_e_32_cannot_32_be_32_connected_32_to_32_o_contained_32_in_e_32_the_32_type_32_of_32_the_32_class_32_c = "\') cannot be connected to (contained in) the type of the class containing the target attribute (\'";
    public static final /*@NonInvalid*/ java.lang.String STR__39_e_32_is_32_not_32_allowed_32_by_32_the_32_affected_32_reference_32_of_32_the_32_parent_32_Refere = "\') is not allowed by the affected reference of the parent ReferenceTargetSelector that ";
    public static final /*@NonInvalid*/ java.lang.String STR__39_e_33 = "\')!";
    public static final /*@NonInvalid*/ java.lang.String STR_requires_32_a_32_o_sub_m_e_type_32_of_32_39 = "requires a (sub-)type of \'";
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_GlobalAttribute = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_GlobalAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_GlobalAttributeImporter = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_GlobalAttributeImporter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_MappedAttributeValueExpander = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_MappedAttributeValueExpander);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_MappingHintGroupImporter = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_MappingHintGroupImporter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_MappingHintGroupType = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_MappingHintGroupType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_ModifiableHint = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ModifiableHint);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_ModifiedAttributeElementType = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ModifiedAttributeElementType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_PAMTraM = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_PAMTraM);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_SourceSection = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_SourceSection);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId BAG_CLSSid_TargetSection = org.eclipse.ocl.pivot.ids.TypeId.BAG.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_TargetSection);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.EnumerationLiteralId ELITid_ONE = pamtram.mapping.MappingTables.ENUMid_CardinalityType.getEnumerationLiteralId("ONE");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_AttributeMappingSourceInterface = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_AttributeMappingSourceInterface);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_AttributeMatcherSourceInterface = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_AttributeMatcherSourceInterface);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_EReference = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_EReference);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ExpandableHint = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ExpandableHint);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_GlobalAttribute = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_GlobalAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_InstancePointer = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_InstancePointer);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_MappingHint = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_MappingHint);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_MappingHintGroupImporter = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_MappingHintGroupImporter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_MappingHintGroupType = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_MappingHintGroupType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_MappingHintType = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_MappingHintType);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ModelConnectionHintSourceInterface = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ModelConnectionHintSourceInterface);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ModelConnectionHintTargetAttribute = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ModelConnectionHintTargetAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ValueModifier = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ValueModifier);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId ORD_CLSSid_ValueModifierSet = org.eclipse.ocl.pivot.ids.TypeId.ORDERED_SET.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ValueModifierSet);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_ActualSourceSectionAttribute = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ActualSourceSectionAttribute);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_AttributeMappingExternalSourceElement = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_AttributeMappingExternalSourceElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_AttributeMappingSourceElement = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_AttributeMappingSourceElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_AttributeMatcherExternalSourceElement = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_AttributeMatcherExternalSourceElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_AttributeMatcherSourceElement = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_AttributeMatcherSourceElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_ModelConnectionHintExternalSourceElement = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ModelConnectionHintExternalSourceElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.CollectionTypeId SEQ_CLSSid_ModelConnectionHintSourceElement = org.eclipse.ocl.pivot.ids.TypeId.SEQUENCE.getSpecializedId(pamtram.mapping.MappingTables.CLSSid_ModelConnectionHintSourceElement);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			MappingTables.init();
		}

		public static final /*@NonNull*/ ExecutorTypeParameter _ExternalModifiedAttributeElementType_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _ExternalModifiedAttributeElementType_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _ExternalModifiedAttributeElementType_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _ExternalModifiedAttributeElementType_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _GlobalModifiedAttributeElementType_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _GlobalModifiedAttributeElementType_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _GlobalModifiedAttributeElementType_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _GlobalModifiedAttributeElementType_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _LocalModifiedAttributeElementType_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _LocalModifiedAttributeElementType_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _LocalModifiedAttributeElementType_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _LocalModifiedAttributeElementType_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		public static final /*@NonNull*/ ExecutorTypeParameter _ModifiedAttributeElementType_S = new ExecutorTypeParameter(TypeId.T_1, "S");
		public static final /*@NonNull*/ ExecutorTypeParameter _ModifiedAttributeElementType_C = new ExecutorTypeParameter(TypeId.T_2, "C");
		public static final /*@NonNull*/ ExecutorTypeParameter _ModifiedAttributeElementType_R = new ExecutorTypeParameter(TypeId.T_3, "R");
		public static final /*@NonNull*/ ExecutorTypeParameter _ModifiedAttributeElementType_A = new ExecutorTypeParameter(IdManager.getTemplateParameterId(3), "A");

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::TypeParameters and all preceding sub-packages.
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

		public static final /*@NonNull*/ EcoreExecutorType _AttributeMapping = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MAPPING, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMappingExternalSourceElement = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMappingGlobalSourceElement = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMappingSourceElement = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMappingSourceInterface = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_INTERFACE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMatcher = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMatcherExternalSourceElement = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMatcherGlobalSourceElement = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMatcherSourceElement = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MATCHER_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _AttributeMatcherSourceInterface = new EcoreExecutorType(MappingPackage.Literals.ATTRIBUTE_MATCHER_SOURCE_INTERFACE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _CardinalityMapping = new EcoreExecutorType(MappingPackage.Literals.CARDINALITY_MAPPING, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ClassMatcher = new EcoreExecutorType(MappingPackage.Literals.CLASS_MATCHER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ExpandableHint = new EcoreExecutorType(MappingPackage.Literals.EXPANDABLE_HINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ExportedMappingHintGroup = new EcoreExecutorType(MappingPackage.Literals.EXPORTED_MAPPING_HINT_GROUP, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ExpressionHint = new EcoreExecutorType(MappingPackage.Literals.EXPRESSION_HINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ExternalMappedAttributeValueAppender = new EcoreExecutorType(MappingPackage.Literals.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ExternalMappedAttributeValueExpander = new EcoreExecutorType(MappingPackage.Literals.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ExternalMappedAttributeValuePrepender = new EcoreExecutorType(MappingPackage.Literals.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ExternalModifiedAttributeElementType = new EcoreExecutorType(MappingPackage.Literals.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._ExternalModifiedAttributeElementType_S, TypeParameters._ExternalModifiedAttributeElementType_C, TypeParameters._ExternalModifiedAttributeElementType_R, TypeParameters._ExternalModifiedAttributeElementType_A);
		public static final /*@NonNull*/ EcoreExecutorType _FixedValue = new EcoreExecutorType(MappingPackage.Literals.FIXED_VALUE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _GlobalAttribute = new EcoreExecutorType(MappingPackage.Literals.GLOBAL_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _GlobalAttributeImporter = new EcoreExecutorType(MappingPackage.Literals.GLOBAL_ATTRIBUTE_IMPORTER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _GlobalModifiedAttributeElementType = new EcoreExecutorType(MappingPackage.Literals.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._GlobalModifiedAttributeElementType_S, TypeParameters._GlobalModifiedAttributeElementType_C, TypeParameters._GlobalModifiedAttributeElementType_R, TypeParameters._GlobalModifiedAttributeElementType_A);
		public static final /*@NonNull*/ EcoreExecutorType _HintImporterMappingHint = new EcoreExecutorType(MappingPackage.Literals.HINT_IMPORTER_MAPPING_HINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _InstantiableMappingHintGroup = new EcoreExecutorType(MappingPackage.Literals.INSTANTIABLE_MAPPING_HINT_GROUP, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _LocalMappedAttributeValueExpander = new EcoreExecutorType(MappingPackage.Literals.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _LocalModifiedAttributeElementType = new EcoreExecutorType(MappingPackage.Literals.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._LocalModifiedAttributeElementType_S, TypeParameters._LocalModifiedAttributeElementType_C, TypeParameters._LocalModifiedAttributeElementType_R, TypeParameters._LocalModifiedAttributeElementType_A);
		public static final /*@NonNull*/ EcoreExecutorType _MappedAttributeValueAppender = new EcoreExecutorType(MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_APPENDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MappedAttributeValueExpander = new EcoreExecutorType(MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MappedAttributeValuePrepender = new EcoreExecutorType(MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_PREPENDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Mapping = new EcoreExecutorType(MappingPackage.Literals.MAPPING, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MappingHint = new EcoreExecutorType(MappingPackage.Literals.MAPPING_HINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MappingHintBaseType = new EcoreExecutorType(MappingPackage.Literals.MAPPING_HINT_BASE_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MappingHintGroup = new EcoreExecutorType(MappingPackage.Literals.MAPPING_HINT_GROUP, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MappingHintGroupImporter = new EcoreExecutorType(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MappingHintGroupType = new EcoreExecutorType(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MappingHintSourceInterface = new EcoreExecutorType(MappingPackage.Literals.MAPPING_HINT_SOURCE_INTERFACE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MappingHintType = new EcoreExecutorType(MappingPackage.Literals.MAPPING_HINT_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MappingType = new EcoreExecutorType(MappingPackage.Literals.MAPPING_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _MatchToLowerCaseConverter = new EcoreExecutorType(MappingPackage.Literals.MATCH_TO_LOWER_CASE_CONVERTER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _MatchToUpperCaseConverter = new EcoreExecutorType(MappingPackage.Literals.MATCH_TO_UPPER_CASE_CONVERTER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _Matcher = new EcoreExecutorType(MappingPackage.Literals.MATCHER, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ModelConnectionHint = new EcoreExecutorType(MappingPackage.Literals.CONTAINER_SELECTOR, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ModelConnectionHintExternalSourceElement = new EcoreExecutorType(MappingPackage.Literals.CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ModelConnectionHintGlobalSourceElement = new EcoreExecutorType(MappingPackage.Literals.CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ModelConnectionHintSourceElement = new EcoreExecutorType(MappingPackage.Literals.CONTAINER_SELECTOR_SOURCE_ELEMENT, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ModelConnectionHintSourceInterface = new EcoreExecutorType(MappingPackage.Literals.CONTAINER_SELECTOR_SOURCE_INTERFACE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ModelConnectionHintTargetAttribute = new EcoreExecutorType(MappingPackage.Literals.CONTAINER_SELECTOR_TARGET_ATTRIBUTE, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ModifiableHint = new EcoreExecutorType(MappingPackage.Literals.MODIFIABLE_HINT, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ModifiedAttributeElementType = new EcoreExecutorType(MappingPackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE, PACKAGE, 0 | ExecutorType.ABSTRACT, TypeParameters._ModifiedAttributeElementType_S, TypeParameters._ModifiedAttributeElementType_C, TypeParameters._ModifiedAttributeElementType_R, TypeParameters._ModifiedAttributeElementType_A);
		public static final /*@NonNull*/ EcoreExecutorType _ReferenceTargetSelector = new EcoreExecutorType(MappingPackage.Literals.REFERENCE_TARGET_SELECTOR, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _StringAppender = new EcoreExecutorType(MappingPackage.Literals.STRING_APPENDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _StringPrepender = new EcoreExecutorType(MappingPackage.Literals.STRING_PREPENDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _SubstringReplacer = new EcoreExecutorType(MappingPackage.Literals.SUBSTRING_REPLACER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _UniqueNumberAppender = new EcoreExecutorType(MappingPackage.Literals.UNIQUE_NUMBER_APPENDER, PACKAGE, 0);
		public static final /*@NonNull*/ EcoreExecutorType _ValueModifier = new EcoreExecutorType(MappingPackage.Literals.VALUE_MODIFIER, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final /*@NonNull*/ EcoreExecutorType _ValueModifierSet = new EcoreExecutorType(MappingPackage.Literals.VALUE_MODIFIER_SET, PACKAGE, 0);

		private static final /*@NonNull*/ EcoreExecutorType /*@NonNull*/ [] types = {
			_AttributeMapping,
			_AttributeMappingExternalSourceElement,
			_AttributeMappingGlobalSourceElement,
			_AttributeMappingSourceElement,
			_AttributeMappingSourceInterface,
			_AttributeMatcher,
			_AttributeMatcherExternalSourceElement,
			_AttributeMatcherGlobalSourceElement,
			_AttributeMatcherSourceElement,
			_AttributeMatcherSourceInterface,
			_CardinalityMapping,
			_ClassMatcher,
			_ExpandableHint,
			_ExportedMappingHintGroup,
			_ExpressionHint,
			_ExternalMappedAttributeValueAppender,
			_ExternalMappedAttributeValueExpander,
			_ExternalMappedAttributeValuePrepender,
			_ExternalModifiedAttributeElementType,
			_FixedValue,
			_GlobalAttribute,
			_GlobalAttributeImporter,
			_GlobalModifiedAttributeElementType,
			_HintImporterMappingHint,
			_InstantiableMappingHintGroup,
			_LocalMappedAttributeValueExpander,
			_LocalModifiedAttributeElementType,
			_MappedAttributeValueAppender,
			_MappedAttributeValueExpander,
			_MappedAttributeValuePrepender,
			_Mapping,
			_MappingHint,
			_MappingHintBaseType,
			_MappingHintGroup,
			_MappingHintGroupImporter,
			_MappingHintGroupType,
			_MappingHintSourceInterface,
			_MappingHintType,
			_MappingType,
			_MatchToLowerCaseConverter,
			_MatchToUpperCaseConverter,
			_Matcher,
			_ModelConnectionHint,
			_ModelConnectionHintExternalSourceElement,
			_ModelConnectionHintGlobalSourceElement,
			_ModelConnectionHintSourceElement,
			_ModelConnectionHintSourceInterface,
			_ModelConnectionHintTargetAttribute,
			_ModifiableHint,
			_ModifiedAttributeElementType,
			_ReferenceTargetSelector,
			_StringAppender,
			_StringPrepender,
			_SubstringReplacer,
			_UniqueNumberAppender,
			_ValueModifier,
			_ValueModifierSet
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::Types and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__AttributeMapping = new ExecutorFragment(Types._AttributeMapping, MappingTables.Types._AttributeMapping);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__ConditionalElement = new ExecutorFragment(Types._AttributeMapping, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__ExpandableHint = new ExecutorFragment(Types._AttributeMapping, MappingTables.Types._ExpandableHint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__ExpressionHint = new ExecutorFragment(Types._AttributeMapping, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__MappingHint = new ExecutorFragment(Types._AttributeMapping, MappingTables.Types._MappingHint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__MappingHintBaseType = new ExecutorFragment(Types._AttributeMapping, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__MappingHintType = new ExecutorFragment(Types._AttributeMapping, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__ModifiableHint = new ExecutorFragment(Types._AttributeMapping, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__NamedElement = new ExecutorFragment(Types._AttributeMapping, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__OclAny = new ExecutorFragment(Types._AttributeMapping, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMapping__OclElement = new ExecutorFragment(Types._AttributeMapping, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__AttributeMappingExternalSourceElement = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, MappingTables.Types._AttributeMappingExternalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__AttributeMappingSourceInterface = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, MappingTables.Types._AttributeMappingSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__NamedElement = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__OclAny = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingExternalSourceElement__OclElement = new ExecutorFragment(Types._AttributeMappingExternalSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__AttributeMappingGlobalSourceElement = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, MappingTables.Types._AttributeMappingGlobalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__AttributeMappingSourceInterface = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, MappingTables.Types._AttributeMappingSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__GlobalModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, MappingTables.Types._GlobalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__NamedElement = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__OclAny = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingGlobalSourceElement__OclElement = new ExecutorFragment(Types._AttributeMappingGlobalSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__AttributeMappingSourceElement = new ExecutorFragment(Types._AttributeMappingSourceElement, MappingTables.Types._AttributeMappingSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__AttributeMappingSourceInterface = new ExecutorFragment(Types._AttributeMappingSourceElement, MappingTables.Types._AttributeMappingSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__LocalModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMappingSourceElement, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMappingSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMappingSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__NamedElement = new ExecutorFragment(Types._AttributeMappingSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__OclAny = new ExecutorFragment(Types._AttributeMappingSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceElement__OclElement = new ExecutorFragment(Types._AttributeMappingSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceInterface__AttributeMappingSourceInterface = new ExecutorFragment(Types._AttributeMappingSourceInterface, MappingTables.Types._AttributeMappingSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceInterface__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMappingSourceInterface, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceInterface__NamedElement = new ExecutorFragment(Types._AttributeMappingSourceInterface, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceInterface__OclAny = new ExecutorFragment(Types._AttributeMappingSourceInterface, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMappingSourceInterface__OclElement = new ExecutorFragment(Types._AttributeMappingSourceInterface, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcher__AttributeMatcher = new ExecutorFragment(Types._AttributeMatcher, MappingTables.Types._AttributeMatcher);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcher__ExpandableHint = new ExecutorFragment(Types._AttributeMatcher, MappingTables.Types._ExpandableHint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcher__ExpressionHint = new ExecutorFragment(Types._AttributeMatcher, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcher__Matcher = new ExecutorFragment(Types._AttributeMatcher, MappingTables.Types._Matcher);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcher__ModifiableHint = new ExecutorFragment(Types._AttributeMatcher, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcher__OclAny = new ExecutorFragment(Types._AttributeMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcher__OclElement = new ExecutorFragment(Types._AttributeMatcher, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__AttributeMatcherExternalSourceElement = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, MappingTables.Types._AttributeMatcherExternalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__AttributeMatcherSourceInterface = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, MappingTables.Types._AttributeMatcherSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__NamedElement = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__OclAny = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherExternalSourceElement__OclElement = new ExecutorFragment(Types._AttributeMatcherExternalSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__AttributeMatcherGlobalSourceElement = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, MappingTables.Types._AttributeMatcherGlobalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__AttributeMatcherSourceInterface = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, MappingTables.Types._AttributeMatcherSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__GlobalModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, MappingTables.Types._GlobalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__NamedElement = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__OclAny = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherGlobalSourceElement__OclElement = new ExecutorFragment(Types._AttributeMatcherGlobalSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__AttributeMatcherSourceElement = new ExecutorFragment(Types._AttributeMatcherSourceElement, MappingTables.Types._AttributeMatcherSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__AttributeMatcherSourceInterface = new ExecutorFragment(Types._AttributeMatcherSourceElement, MappingTables.Types._AttributeMatcherSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__LocalModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMatcherSourceElement, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMatcherSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._AttributeMatcherSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__NamedElement = new ExecutorFragment(Types._AttributeMatcherSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__OclAny = new ExecutorFragment(Types._AttributeMatcherSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceElement__OclElement = new ExecutorFragment(Types._AttributeMatcherSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceInterface__AttributeMatcherSourceInterface = new ExecutorFragment(Types._AttributeMatcherSourceInterface, MappingTables.Types._AttributeMatcherSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceInterface__MappingHintSourceInterface = new ExecutorFragment(Types._AttributeMatcherSourceInterface, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceInterface__NamedElement = new ExecutorFragment(Types._AttributeMatcherSourceInterface, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceInterface__OclAny = new ExecutorFragment(Types._AttributeMatcherSourceInterface, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _AttributeMatcherSourceInterface__OclElement = new ExecutorFragment(Types._AttributeMatcherSourceInterface, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__CardinalityMapping = new ExecutorFragment(Types._CardinalityMapping, MappingTables.Types._CardinalityMapping);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__ConditionalElement = new ExecutorFragment(Types._CardinalityMapping, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__MappingHint = new ExecutorFragment(Types._CardinalityMapping, MappingTables.Types._MappingHint);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__MappingHintBaseType = new ExecutorFragment(Types._CardinalityMapping, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__MappingHintType = new ExecutorFragment(Types._CardinalityMapping, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__NamedElement = new ExecutorFragment(Types._CardinalityMapping, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__OclAny = new ExecutorFragment(Types._CardinalityMapping, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _CardinalityMapping__OclElement = new ExecutorFragment(Types._CardinalityMapping, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ClassMatcher__ClassMatcher = new ExecutorFragment(Types._ClassMatcher, MappingTables.Types._ClassMatcher);
		private static final /*@NonNull*/ ExecutorFragment _ClassMatcher__Matcher = new ExecutorFragment(Types._ClassMatcher, MappingTables.Types._Matcher);
		private static final /*@NonNull*/ ExecutorFragment _ClassMatcher__OclAny = new ExecutorFragment(Types._ClassMatcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ClassMatcher__OclElement = new ExecutorFragment(Types._ClassMatcher, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExpandableHint__ExpandableHint = new ExecutorFragment(Types._ExpandableHint, MappingTables.Types._ExpandableHint);
		private static final /*@NonNull*/ ExecutorFragment _ExpandableHint__OclAny = new ExecutorFragment(Types._ExpandableHint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExpandableHint__OclElement = new ExecutorFragment(Types._ExpandableHint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExportedMappingHintGroup__ExportedMappingHintGroup = new ExecutorFragment(Types._ExportedMappingHintGroup, MappingTables.Types._ExportedMappingHintGroup);
		private static final /*@NonNull*/ ExecutorFragment _ExportedMappingHintGroup__MappingHintGroupType = new ExecutorFragment(Types._ExportedMappingHintGroup, MappingTables.Types._MappingHintGroupType);
		private static final /*@NonNull*/ ExecutorFragment _ExportedMappingHintGroup__NamedElement = new ExecutorFragment(Types._ExportedMappingHintGroup, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ExportedMappingHintGroup__OclAny = new ExecutorFragment(Types._ExportedMappingHintGroup, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExportedMappingHintGroup__OclElement = new ExecutorFragment(Types._ExportedMappingHintGroup, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExpressionHint__ExpressionHint = new ExecutorFragment(Types._ExpressionHint, MappingTables.Types._ExpressionHint);
		private static final /*@NonNull*/ ExecutorFragment _ExpressionHint__OclAny = new ExecutorFragment(Types._ExpressionHint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExpressionHint__OclElement = new ExecutorFragment(Types._ExpressionHint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueAppender = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._ExternalMappedAttributeValueAppender);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueExpander = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._ExternalMappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__HintImporterMappingHint = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__MappedAttributeValueExpander = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._MappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__MappingHintBaseType = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__MappingHintType = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__ModifiedAttributeElementType = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__NamedElement = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__OclAny = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueAppender__OclElement = new ExecutorFragment(Types._ExternalMappedAttributeValueAppender, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__ExternalMappedAttributeValueExpander = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, MappingTables.Types._ExternalMappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__HintImporterMappingHint = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__MappedAttributeValueExpander = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, MappingTables.Types._MappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__MappingHintBaseType = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__MappingHintType = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__ModifiedAttributeElementType = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__NamedElement = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__OclAny = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValueExpander__OclElement = new ExecutorFragment(Types._ExternalMappedAttributeValueExpander, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValueExpander = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._ExternalMappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValuePrepender = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._ExternalMappedAttributeValuePrepender);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__HintImporterMappingHint = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__MappedAttributeValueExpander = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._MappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__MappingHintBaseType = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__MappingHintType = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__ModifiedAttributeElementType = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__NamedElement = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__OclAny = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExternalMappedAttributeValuePrepender__OclElement = new ExecutorFragment(Types._ExternalMappedAttributeValuePrepender, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ExternalModifiedAttributeElementType__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._ExternalModifiedAttributeElementType, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalModifiedAttributeElementType__ModifiedAttributeElementType = new ExecutorFragment(Types._ExternalModifiedAttributeElementType, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ExternalModifiedAttributeElementType__NamedElement = new ExecutorFragment(Types._ExternalModifiedAttributeElementType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ExternalModifiedAttributeElementType__OclAny = new ExecutorFragment(Types._ExternalModifiedAttributeElementType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ExternalModifiedAttributeElementType__OclElement = new ExecutorFragment(Types._ExternalModifiedAttributeElementType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _FixedValue__AttributeMappingSourceInterface = new ExecutorFragment(Types._FixedValue, MappingTables.Types._AttributeMappingSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__AttributeMatcherSourceInterface = new ExecutorFragment(Types._FixedValue, MappingTables.Types._AttributeMatcherSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__FixedValue = new ExecutorFragment(Types._FixedValue, MappingTables.Types._FixedValue);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__InstancePointerSourceInterface = new ExecutorFragment(Types._FixedValue, MetamodelTables.Types._InstancePointerSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__MappingHintSourceInterface = new ExecutorFragment(Types._FixedValue, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__ModelConnectionHintSourceInterface = new ExecutorFragment(Types._FixedValue, MappingTables.Types._ModelConnectionHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__NamedElement = new ExecutorFragment(Types._FixedValue, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__OclAny = new ExecutorFragment(Types._FixedValue, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__OclElement = new ExecutorFragment(Types._FixedValue, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _FixedValue__ValueConstraintSourceInterface = new ExecutorFragment(Types._FixedValue, MetamodelTables.Types._ValueConstraintSourceInterface);

		private static final /*@NonNull*/ ExecutorFragment _GlobalAttribute__GlobalAttribute = new ExecutorFragment(Types._GlobalAttribute, MappingTables.Types._GlobalAttribute);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttribute__NamedElement = new ExecutorFragment(Types._GlobalAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttribute__OclAny = new ExecutorFragment(Types._GlobalAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttribute__OclElement = new ExecutorFragment(Types._GlobalAttribute, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__AttributeMappingSourceInterface = new ExecutorFragment(Types._GlobalAttributeImporter, MappingTables.Types._AttributeMappingSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__AttributeMatcherSourceInterface = new ExecutorFragment(Types._GlobalAttributeImporter, MappingTables.Types._AttributeMatcherSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__GlobalAttributeImporter = new ExecutorFragment(Types._GlobalAttributeImporter, MappingTables.Types._GlobalAttributeImporter);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__InstancePointerSourceInterface = new ExecutorFragment(Types._GlobalAttributeImporter, MetamodelTables.Types._InstancePointerSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__MappingHintSourceInterface = new ExecutorFragment(Types._GlobalAttributeImporter, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__ModelConnectionHintSourceInterface = new ExecutorFragment(Types._GlobalAttributeImporter, MappingTables.Types._ModelConnectionHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__NamedElement = new ExecutorFragment(Types._GlobalAttributeImporter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__OclAny = new ExecutorFragment(Types._GlobalAttributeImporter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__OclElement = new ExecutorFragment(Types._GlobalAttributeImporter, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _GlobalAttributeImporter__ValueConstraintSourceInterface = new ExecutorFragment(Types._GlobalAttributeImporter, MetamodelTables.Types._ValueConstraintSourceInterface);

		private static final /*@NonNull*/ ExecutorFragment _GlobalModifiedAttributeElementType__GlobalModifiedAttributeElementType = new ExecutorFragment(Types._GlobalModifiedAttributeElementType, MappingTables.Types._GlobalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _GlobalModifiedAttributeElementType__ModifiedAttributeElementType = new ExecutorFragment(Types._GlobalModifiedAttributeElementType, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _GlobalModifiedAttributeElementType__NamedElement = new ExecutorFragment(Types._GlobalModifiedAttributeElementType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _GlobalModifiedAttributeElementType__OclAny = new ExecutorFragment(Types._GlobalModifiedAttributeElementType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _GlobalModifiedAttributeElementType__OclElement = new ExecutorFragment(Types._GlobalModifiedAttributeElementType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _HintImporterMappingHint__HintImporterMappingHint = new ExecutorFragment(Types._HintImporterMappingHint, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _HintImporterMappingHint__MappingHintBaseType = new ExecutorFragment(Types._HintImporterMappingHint, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _HintImporterMappingHint__MappingHintType = new ExecutorFragment(Types._HintImporterMappingHint, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _HintImporterMappingHint__NamedElement = new ExecutorFragment(Types._HintImporterMappingHint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _HintImporterMappingHint__OclAny = new ExecutorFragment(Types._HintImporterMappingHint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _HintImporterMappingHint__OclElement = new ExecutorFragment(Types._HintImporterMappingHint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _InstantiableMappingHintGroup__ConditionalElement = new ExecutorFragment(Types._InstantiableMappingHintGroup, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _InstantiableMappingHintGroup__DeactivatableElement = new ExecutorFragment(Types._InstantiableMappingHintGroup, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _InstantiableMappingHintGroup__InstantiableMappingHintGroup = new ExecutorFragment(Types._InstantiableMappingHintGroup, MappingTables.Types._InstantiableMappingHintGroup);
		private static final /*@NonNull*/ ExecutorFragment _InstantiableMappingHintGroup__NamedElement = new ExecutorFragment(Types._InstantiableMappingHintGroup, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _InstantiableMappingHintGroup__OclAny = new ExecutorFragment(Types._InstantiableMappingHintGroup, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _InstantiableMappingHintGroup__OclElement = new ExecutorFragment(Types._InstantiableMappingHintGroup, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__HintImporterMappingHint = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__LocalMappedAttributeValueExpander = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, MappingTables.Types._LocalMappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__LocalModifiedAttributeElementType = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__MappedAttributeValueExpander = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, MappingTables.Types._MappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__MappingHintBaseType = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__MappingHintType = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__ModifiedAttributeElementType = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__NamedElement = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__OclAny = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _LocalMappedAttributeValueExpander__OclElement = new ExecutorFragment(Types._LocalMappedAttributeValueExpander, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _LocalModifiedAttributeElementType__LocalModifiedAttributeElementType = new ExecutorFragment(Types._LocalModifiedAttributeElementType, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _LocalModifiedAttributeElementType__ModifiedAttributeElementType = new ExecutorFragment(Types._LocalModifiedAttributeElementType, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _LocalModifiedAttributeElementType__NamedElement = new ExecutorFragment(Types._LocalModifiedAttributeElementType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _LocalModifiedAttributeElementType__OclAny = new ExecutorFragment(Types._LocalModifiedAttributeElementType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _LocalModifiedAttributeElementType__OclElement = new ExecutorFragment(Types._LocalModifiedAttributeElementType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__HintImporterMappingHint = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__LocalMappedAttributeValueExpander = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._LocalMappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__LocalModifiedAttributeElementType = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__MappedAttributeValueAppender = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._MappedAttributeValueAppender);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__MappedAttributeValueExpander = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._MappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__MappingHintBaseType = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__MappingHintType = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__ModifiedAttributeElementType = new ExecutorFragment(Types._MappedAttributeValueAppender, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__NamedElement = new ExecutorFragment(Types._MappedAttributeValueAppender, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__OclAny = new ExecutorFragment(Types._MappedAttributeValueAppender, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueAppender__OclElement = new ExecutorFragment(Types._MappedAttributeValueAppender, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueExpander__HintImporterMappingHint = new ExecutorFragment(Types._MappedAttributeValueExpander, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueExpander__MappedAttributeValueExpander = new ExecutorFragment(Types._MappedAttributeValueExpander, MappingTables.Types._MappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueExpander__MappingHintBaseType = new ExecutorFragment(Types._MappedAttributeValueExpander, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueExpander__MappingHintType = new ExecutorFragment(Types._MappedAttributeValueExpander, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueExpander__NamedElement = new ExecutorFragment(Types._MappedAttributeValueExpander, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueExpander__OclAny = new ExecutorFragment(Types._MappedAttributeValueExpander, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValueExpander__OclElement = new ExecutorFragment(Types._MappedAttributeValueExpander, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__HintImporterMappingHint = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._HintImporterMappingHint);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__LocalMappedAttributeValueExpander = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._LocalMappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__LocalModifiedAttributeElementType = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__MappedAttributeValueExpander = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._MappedAttributeValueExpander);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__MappedAttributeValuePrepender = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._MappedAttributeValuePrepender);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__MappingHintBaseType = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__MappingHintType = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__ModifiedAttributeElementType = new ExecutorFragment(Types._MappedAttributeValuePrepender, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__NamedElement = new ExecutorFragment(Types._MappedAttributeValuePrepender, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__OclAny = new ExecutorFragment(Types._MappedAttributeValuePrepender, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappedAttributeValuePrepender__OclElement = new ExecutorFragment(Types._MappedAttributeValuePrepender, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _Mapping__ConditionalElement = new ExecutorFragment(Types._Mapping, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _Mapping__DeactivatableElement = new ExecutorFragment(Types._Mapping, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _Mapping__Mapping = new ExecutorFragment(Types._Mapping, MappingTables.Types._Mapping);
		private static final /*@NonNull*/ ExecutorFragment _Mapping__MappingType = new ExecutorFragment(Types._Mapping, MappingTables.Types._MappingType);
		private static final /*@NonNull*/ ExecutorFragment _Mapping__NamedElement = new ExecutorFragment(Types._Mapping, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _Mapping__OclAny = new ExecutorFragment(Types._Mapping, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Mapping__OclElement = new ExecutorFragment(Types._Mapping, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingHint__ConditionalElement = new ExecutorFragment(Types._MappingHint, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHint__MappingHint = new ExecutorFragment(Types._MappingHint, MappingTables.Types._MappingHint);
		private static final /*@NonNull*/ ExecutorFragment _MappingHint__MappingHintBaseType = new ExecutorFragment(Types._MappingHint, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _MappingHint__MappingHintType = new ExecutorFragment(Types._MappingHint, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _MappingHint__NamedElement = new ExecutorFragment(Types._MappingHint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHint__OclAny = new ExecutorFragment(Types._MappingHint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingHint__OclElement = new ExecutorFragment(Types._MappingHint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingHintBaseType__MappingHintBaseType = new ExecutorFragment(Types._MappingHintBaseType, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintBaseType__NamedElement = new ExecutorFragment(Types._MappingHintBaseType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintBaseType__OclAny = new ExecutorFragment(Types._MappingHintBaseType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintBaseType__OclElement = new ExecutorFragment(Types._MappingHintBaseType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__ConditionalElement = new ExecutorFragment(Types._MappingHintGroup, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__DeactivatableElement = new ExecutorFragment(Types._MappingHintGroup, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__InstantiableMappingHintGroup = new ExecutorFragment(Types._MappingHintGroup, MappingTables.Types._InstantiableMappingHintGroup);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__MappingHintGroup = new ExecutorFragment(Types._MappingHintGroup, MappingTables.Types._MappingHintGroup);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__MappingHintGroupType = new ExecutorFragment(Types._MappingHintGroup, MappingTables.Types._MappingHintGroupType);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__NamedElement = new ExecutorFragment(Types._MappingHintGroup, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__OclAny = new ExecutorFragment(Types._MappingHintGroup, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroup__OclElement = new ExecutorFragment(Types._MappingHintGroup, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupImporter__ConditionalElement = new ExecutorFragment(Types._MappingHintGroupImporter, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupImporter__DeactivatableElement = new ExecutorFragment(Types._MappingHintGroupImporter, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupImporter__InstantiableMappingHintGroup = new ExecutorFragment(Types._MappingHintGroupImporter, MappingTables.Types._InstantiableMappingHintGroup);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupImporter__MappingHintGroupImporter = new ExecutorFragment(Types._MappingHintGroupImporter, MappingTables.Types._MappingHintGroupImporter);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupImporter__NamedElement = new ExecutorFragment(Types._MappingHintGroupImporter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupImporter__OclAny = new ExecutorFragment(Types._MappingHintGroupImporter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupImporter__OclElement = new ExecutorFragment(Types._MappingHintGroupImporter, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupType__MappingHintGroupType = new ExecutorFragment(Types._MappingHintGroupType, MappingTables.Types._MappingHintGroupType);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupType__NamedElement = new ExecutorFragment(Types._MappingHintGroupType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupType__OclAny = new ExecutorFragment(Types._MappingHintGroupType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintGroupType__OclElement = new ExecutorFragment(Types._MappingHintGroupType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingHintSourceInterface__MappingHintSourceInterface = new ExecutorFragment(Types._MappingHintSourceInterface, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintSourceInterface__NamedElement = new ExecutorFragment(Types._MappingHintSourceInterface, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintSourceInterface__OclAny = new ExecutorFragment(Types._MappingHintSourceInterface, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintSourceInterface__OclElement = new ExecutorFragment(Types._MappingHintSourceInterface, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingHintType__MappingHintBaseType = new ExecutorFragment(Types._MappingHintType, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintType__MappingHintType = new ExecutorFragment(Types._MappingHintType, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintType__NamedElement = new ExecutorFragment(Types._MappingHintType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintType__OclAny = new ExecutorFragment(Types._MappingHintType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingHintType__OclElement = new ExecutorFragment(Types._MappingHintType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MappingType__DeactivatableElement = new ExecutorFragment(Types._MappingType, PamtramTables.Types._DeactivatableElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingType__MappingType = new ExecutorFragment(Types._MappingType, MappingTables.Types._MappingType);
		private static final /*@NonNull*/ ExecutorFragment _MappingType__NamedElement = new ExecutorFragment(Types._MappingType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MappingType__OclAny = new ExecutorFragment(Types._MappingType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MappingType__OclElement = new ExecutorFragment(Types._MappingType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _MatchToLowerCaseConverter__MatchToLowerCaseConverter = new ExecutorFragment(Types._MatchToLowerCaseConverter, MappingTables.Types._MatchToLowerCaseConverter);
		private static final /*@NonNull*/ ExecutorFragment _MatchToLowerCaseConverter__NamedElement = new ExecutorFragment(Types._MatchToLowerCaseConverter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MatchToLowerCaseConverter__OclAny = new ExecutorFragment(Types._MatchToLowerCaseConverter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MatchToLowerCaseConverter__OclElement = new ExecutorFragment(Types._MatchToLowerCaseConverter, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _MatchToLowerCaseConverter__ValueModifier = new ExecutorFragment(Types._MatchToLowerCaseConverter, MappingTables.Types._ValueModifier);

		private static final /*@NonNull*/ ExecutorFragment _MatchToUpperCaseConverter__MatchToUpperCaseConverter = new ExecutorFragment(Types._MatchToUpperCaseConverter, MappingTables.Types._MatchToUpperCaseConverter);
		private static final /*@NonNull*/ ExecutorFragment _MatchToUpperCaseConverter__NamedElement = new ExecutorFragment(Types._MatchToUpperCaseConverter, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _MatchToUpperCaseConverter__OclAny = new ExecutorFragment(Types._MatchToUpperCaseConverter, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _MatchToUpperCaseConverter__OclElement = new ExecutorFragment(Types._MatchToUpperCaseConverter, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _MatchToUpperCaseConverter__ValueModifier = new ExecutorFragment(Types._MatchToUpperCaseConverter, MappingTables.Types._ValueModifier);

		private static final /*@NonNull*/ ExecutorFragment _Matcher__Matcher = new ExecutorFragment(Types._Matcher, MappingTables.Types._Matcher);
		private static final /*@NonNull*/ ExecutorFragment _Matcher__OclAny = new ExecutorFragment(Types._Matcher, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _Matcher__OclElement = new ExecutorFragment(Types._Matcher, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHint__MappingHintBaseType = new ExecutorFragment(Types._ModelConnectionHint, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHint__ModelConnectionHint = new ExecutorFragment(Types._ModelConnectionHint, MappingTables.Types._ModelConnectionHint);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHint__NamedElement = new ExecutorFragment(Types._ModelConnectionHint, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHint__OclAny = new ExecutorFragment(Types._ModelConnectionHint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHint__OclElement = new ExecutorFragment(Types._ModelConnectionHint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__ExternalModifiedAttributeElementType = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, MappingTables.Types._ExternalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__ModelConnectionHintExternalSourceElement = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, MappingTables.Types._ModelConnectionHintExternalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__ModelConnectionHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, MappingTables.Types._ModelConnectionHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__NamedElement = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__OclAny = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintExternalSourceElement__OclElement = new ExecutorFragment(Types._ModelConnectionHintExternalSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__GlobalModifiedAttributeElementType = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, MappingTables.Types._GlobalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__ModelConnectionHintGlobalSourceElement = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, MappingTables.Types._ModelConnectionHintGlobalSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__ModelConnectionHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, MappingTables.Types._ModelConnectionHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__NamedElement = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__OclAny = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintGlobalSourceElement__OclElement = new ExecutorFragment(Types._ModelConnectionHintGlobalSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__LocalModifiedAttributeElementType = new ExecutorFragment(Types._ModelConnectionHintSourceElement, MappingTables.Types._LocalModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__MappingHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintSourceElement, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__ModelConnectionHintSourceElement = new ExecutorFragment(Types._ModelConnectionHintSourceElement, MappingTables.Types._ModelConnectionHintSourceElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__ModelConnectionHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintSourceElement, MappingTables.Types._ModelConnectionHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__ModifiedAttributeElementType = new ExecutorFragment(Types._ModelConnectionHintSourceElement, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__NamedElement = new ExecutorFragment(Types._ModelConnectionHintSourceElement, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__OclAny = new ExecutorFragment(Types._ModelConnectionHintSourceElement, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceElement__OclElement = new ExecutorFragment(Types._ModelConnectionHintSourceElement, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceInterface__MappingHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintSourceInterface, MappingTables.Types._MappingHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceInterface__ModelConnectionHintSourceInterface = new ExecutorFragment(Types._ModelConnectionHintSourceInterface, MappingTables.Types._ModelConnectionHintSourceInterface);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceInterface__NamedElement = new ExecutorFragment(Types._ModelConnectionHintSourceInterface, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceInterface__OclAny = new ExecutorFragment(Types._ModelConnectionHintSourceInterface, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintSourceInterface__OclElement = new ExecutorFragment(Types._ModelConnectionHintSourceInterface, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintTargetAttribute__ModelConnectionHintTargetAttribute = new ExecutorFragment(Types._ModelConnectionHintTargetAttribute, MappingTables.Types._ModelConnectionHintTargetAttribute);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintTargetAttribute__ModifiedAttributeElementType = new ExecutorFragment(Types._ModelConnectionHintTargetAttribute, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintTargetAttribute__NamedElement = new ExecutorFragment(Types._ModelConnectionHintTargetAttribute, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintTargetAttribute__OclAny = new ExecutorFragment(Types._ModelConnectionHintTargetAttribute, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModelConnectionHintTargetAttribute__OclElement = new ExecutorFragment(Types._ModelConnectionHintTargetAttribute, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModifiableHint__ModifiableHint = new ExecutorFragment(Types._ModifiableHint, MappingTables.Types._ModifiableHint);
		private static final /*@NonNull*/ ExecutorFragment _ModifiableHint__OclAny = new ExecutorFragment(Types._ModifiableHint, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModifiableHint__OclElement = new ExecutorFragment(Types._ModifiableHint, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ModifiedAttributeElementType__ModifiedAttributeElementType = new ExecutorFragment(Types._ModifiedAttributeElementType, MappingTables.Types._ModifiedAttributeElementType);
		private static final /*@NonNull*/ ExecutorFragment _ModifiedAttributeElementType__NamedElement = new ExecutorFragment(Types._ModifiedAttributeElementType, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ModifiedAttributeElementType__OclAny = new ExecutorFragment(Types._ModifiedAttributeElementType, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ModifiedAttributeElementType__OclElement = new ExecutorFragment(Types._ModifiedAttributeElementType, OCLstdlibTables.Types._OclElement);

		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__ConditionalElement = new ExecutorFragment(Types._ReferenceTargetSelector, PamtramTables.Types._ConditionalElement);
		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__MappingHint = new ExecutorFragment(Types._ReferenceTargetSelector, MappingTables.Types._MappingHint);
		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__MappingHintBaseType = new ExecutorFragment(Types._ReferenceTargetSelector, MappingTables.Types._MappingHintBaseType);
		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__MappingHintType = new ExecutorFragment(Types._ReferenceTargetSelector, MappingTables.Types._MappingHintType);
		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__NamedElement = new ExecutorFragment(Types._ReferenceTargetSelector, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__OclAny = new ExecutorFragment(Types._ReferenceTargetSelector, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__OclElement = new ExecutorFragment(Types._ReferenceTargetSelector, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ReferenceTargetSelector__ReferenceTargetSelector = new ExecutorFragment(Types._ReferenceTargetSelector, MappingTables.Types._ReferenceTargetSelector);

		private static final /*@NonNull*/ ExecutorFragment _StringAppender__NamedElement = new ExecutorFragment(Types._StringAppender, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _StringAppender__OclAny = new ExecutorFragment(Types._StringAppender, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _StringAppender__OclElement = new ExecutorFragment(Types._StringAppender, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _StringAppender__StringAppender = new ExecutorFragment(Types._StringAppender, MappingTables.Types._StringAppender);
		private static final /*@NonNull*/ ExecutorFragment _StringAppender__ValueModifier = new ExecutorFragment(Types._StringAppender, MappingTables.Types._ValueModifier);

		private static final /*@NonNull*/ ExecutorFragment _StringPrepender__NamedElement = new ExecutorFragment(Types._StringPrepender, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _StringPrepender__OclAny = new ExecutorFragment(Types._StringPrepender, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _StringPrepender__OclElement = new ExecutorFragment(Types._StringPrepender, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _StringPrepender__StringPrepender = new ExecutorFragment(Types._StringPrepender, MappingTables.Types._StringPrepender);
		private static final /*@NonNull*/ ExecutorFragment _StringPrepender__ValueModifier = new ExecutorFragment(Types._StringPrepender, MappingTables.Types._ValueModifier);

		private static final /*@NonNull*/ ExecutorFragment _SubstringReplacer__NamedElement = new ExecutorFragment(Types._SubstringReplacer, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _SubstringReplacer__OclAny = new ExecutorFragment(Types._SubstringReplacer, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _SubstringReplacer__OclElement = new ExecutorFragment(Types._SubstringReplacer, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _SubstringReplacer__SubstringReplacer = new ExecutorFragment(Types._SubstringReplacer, MappingTables.Types._SubstringReplacer);
		private static final /*@NonNull*/ ExecutorFragment _SubstringReplacer__ValueModifier = new ExecutorFragment(Types._SubstringReplacer, MappingTables.Types._ValueModifier);

		private static final /*@NonNull*/ ExecutorFragment _UniqueNumberAppender__NamedElement = new ExecutorFragment(Types._UniqueNumberAppender, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _UniqueNumberAppender__OclAny = new ExecutorFragment(Types._UniqueNumberAppender, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _UniqueNumberAppender__OclElement = new ExecutorFragment(Types._UniqueNumberAppender, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _UniqueNumberAppender__UniqueNumberAppender = new ExecutorFragment(Types._UniqueNumberAppender, MappingTables.Types._UniqueNumberAppender);
		private static final /*@NonNull*/ ExecutorFragment _UniqueNumberAppender__ValueModifier = new ExecutorFragment(Types._UniqueNumberAppender, MappingTables.Types._ValueModifier);

		private static final /*@NonNull*/ ExecutorFragment _ValueModifier__NamedElement = new ExecutorFragment(Types._ValueModifier, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueModifier__OclAny = new ExecutorFragment(Types._ValueModifier, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ValueModifier__OclElement = new ExecutorFragment(Types._ValueModifier, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueModifier__ValueModifier = new ExecutorFragment(Types._ValueModifier, MappingTables.Types._ValueModifier);

		private static final /*@NonNull*/ ExecutorFragment _ValueModifierSet__NamedElement = new ExecutorFragment(Types._ValueModifierSet, PamtramTables.Types._NamedElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueModifierSet__OclAny = new ExecutorFragment(Types._ValueModifierSet, OCLstdlibTables.Types._OclAny);
		private static final /*@NonNull*/ ExecutorFragment _ValueModifierSet__OclElement = new ExecutorFragment(Types._ValueModifierSet, OCLstdlibTables.Types._OclElement);
		private static final /*@NonNull*/ ExecutorFragment _ValueModifierSet__ValueModifierSet = new ExecutorFragment(Types._ValueModifierSet, MappingTables.Types._ValueModifierSet);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::Fragments and all preceding sub-packages.
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

		public static final /*@NonNull*/ ParameterTypes _String = TypeUtil.createParameterTypes(OCLstdlibTables.Types._String);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::Parameters and all preceding sub-packages.
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

		public static final /*@NonNull*/ ExecutorOperation _AttributeMapping__getExternalSourceElements = new ExecutorOperation("getExternalSourceElements", TypeUtil.EMPTY_PARAMETER_TYPES, Types._AttributeMapping,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _AttributeMapping__getLocalSourceElements = new ExecutorOperation("getLocalSourceElements", TypeUtil.EMPTY_PARAMETER_TYPES, Types._AttributeMapping,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _AttributeMatcher__getExternalSourceElements = new ExecutorOperation("getExternalSourceElements", TypeUtil.EMPTY_PARAMETER_TYPES, Types._AttributeMatcher,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _AttributeMatcher__getLocalSourceElements = new ExecutorOperation("getLocalSourceElements", TypeUtil.EMPTY_PARAMETER_TYPES, Types._AttributeMatcher,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _MappedAttributeValueExpander__getModifiers = new ExecutorOperation("getModifiers", TypeUtil.EMPTY_PARAMETER_TYPES, Types._MappedAttributeValueExpander,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _MappedAttributeValueExpander__getSourceAttribute = new ExecutorOperation("getSourceAttribute", TypeUtil.EMPTY_PARAMETER_TYPES, Types._MappedAttributeValueExpander,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _Mapping__getActiveImportedMappingHintGroups = new ExecutorOperation("getActiveImportedMappingHintGroups", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Mapping,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _Mapping__getActiveMappingHintGroups = new ExecutorOperation("getActiveMappingHintGroups", TypeUtil.EMPTY_PARAMETER_TYPES, Types._Mapping,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _MappingHintSourceInterface__getSourceAttribute = new ExecutorOperation("getSourceAttribute", TypeUtil.EMPTY_PARAMETER_TYPES, Types._MappingHintSourceInterface,
			0, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _ModelConnectionHint__getExternalSourceElements = new ExecutorOperation("getExternalSourceElements", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ModelConnectionHint,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _ModelConnectionHint__getLocalSourceElements = new ExecutorOperation("getLocalSourceElements", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ModelConnectionHint,
			1, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _ModelConnectionHint__getSourceAttributes = new ExecutorOperation("getSourceAttributes", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ModelConnectionHint,
			2, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _ModifiedAttributeElementType__getMapping = new ExecutorOperation("getMapping", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ModifiedAttributeElementType,
			0, TemplateParameters.EMPTY_LIST, null);
		public static final /*@NonNull*/ ExecutorOperation _ModifiedAttributeElementType__getMappingHintGroup = new ExecutorOperation("getMappingHintGroup", TypeUtil.EMPTY_PARAMETER_TYPES, Types._ModifiedAttributeElementType,
			1, TemplateParameters.EMPTY_LIST, null);

		public static final /*@NonNull*/ ExecutorOperation _ValueModifier__modifyValue = new ExecutorOperation("modifyValue", Parameters._String, Types._ValueModifier,
			0, TemplateParameters.EMPTY_LIST, null);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::Operations and all preceding sub-packages.
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

		public static final /*@NonNull*/ ExecutorProperty _AttributeMapping__sourceElements = new EcoreExecutorProperty(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS, Types._AttributeMapping, 0);
		public static final /*@NonNull*/ ExecutorProperty _AttributeMapping__target = new EcoreExecutorProperty(MappingPackage.Literals.ATTRIBUTE_MAPPING__TARGET, Types._AttributeMapping, 1);

		public static final /*@NonNull*/ ExecutorProperty _AttributeMappingSourceInterface__AttributeMapping__sourceElements = new ExecutorPropertyWithImplementation("AttributeMapping", Types._AttributeMappingSourceInterface, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS));

		public static final /*@NonNull*/ ExecutorProperty _AttributeMatcher__sourceElements = new EcoreExecutorProperty(MappingPackage.Literals.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS, Types._AttributeMatcher, 0);
		public static final /*@NonNull*/ ExecutorProperty _AttributeMatcher__target = new EcoreExecutorProperty(MappingPackage.Literals.ATTRIBUTE_MATCHER__TARGET, Types._AttributeMatcher, 1);

		public static final /*@NonNull*/ ExecutorProperty _AttributeMatcherSourceInterface__AttributeMatcher__sourceElements = new ExecutorPropertyWithImplementation("AttributeMatcher", Types._AttributeMatcherSourceInterface, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.ATTRIBUTE_MATCHER__SOURCE_ELEMENTS));

		public static final /*@NonNull*/ ExecutorProperty _CardinalityMapping__source = new EcoreExecutorProperty(MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE, Types._CardinalityMapping, 0);
		public static final /*@NonNull*/ ExecutorProperty _CardinalityMapping__target = new EcoreExecutorProperty(MappingPackage.Literals.CARDINALITY_MAPPING__TARGET, Types._CardinalityMapping, 1);

		public static final /*@NonNull*/ ExecutorProperty _ClassMatcher__targetClass = new EcoreExecutorProperty(MappingPackage.Literals.CLASS_MATCHER__TARGET_CLASS, Types._ClassMatcher, 0);

		public static final /*@NonNull*/ ExecutorProperty _ExpandableHint__MappedAttributeValueExpander__hintsToExpand = new ExecutorPropertyWithImplementation("MappedAttributeValueExpander", Types._ExpandableHint, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND));

		public static final /*@NonNull*/ ExecutorProperty _ExportedMappingHintGroup__MappingHintGroupImporter__hintGroup = new ExecutorPropertyWithImplementation("MappingHintGroupImporter", Types._ExportedMappingHintGroup, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP));

		public static final /*@NonNull*/ ExecutorProperty _ExpressionHint__expression = new EcoreExecutorProperty(MappingPackage.Literals.EXPRESSION_HINT__EXPRESSION, Types._ExpressionHint, 0);

		public static final /*@NonNull*/ ExecutorProperty _FixedValue__value = new EcoreExecutorProperty(MappingPackage.Literals.FIXED_VALUE__VALUE, Types._FixedValue, 0);

		public static final /*@NonNull*/ ExecutorProperty _GlobalAttribute__modifier = new EcoreExecutorProperty(MappingPackage.Literals.GLOBAL_ATTRIBUTE__MODIFIER, Types._GlobalAttribute, 0);
		public static final /*@NonNull*/ ExecutorProperty _GlobalAttribute__source = new EcoreExecutorProperty(MappingPackage.Literals.GLOBAL_ATTRIBUTE__SOURCE, Types._GlobalAttribute, 1);
		public static final /*@NonNull*/ ExecutorProperty _GlobalAttribute__GlobalAttributeImporter__globalAttribute = new ExecutorPropertyWithImplementation("GlobalAttributeImporter", Types._GlobalAttribute, 2, new EcoreLibraryOppositeProperty(MappingPackage.Literals.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE));
		public static final /*@NonNull*/ ExecutorProperty _GlobalAttribute__Mapping__globalVariables = new ExecutorPropertyWithImplementation("Mapping", Types._GlobalAttribute, 3, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING__GLOBAL_VARIABLES));

		public static final /*@NonNull*/ ExecutorProperty _GlobalAttributeImporter__globalAttribute = new EcoreExecutorProperty(MappingPackage.Literals.GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE, Types._GlobalAttributeImporter, 0);

		public static final /*@NonNull*/ ExecutorProperty _GlobalModifiedAttributeElementType__instanceSelector = new EcoreExecutorProperty(MappingPackage.Literals.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTOR, Types._GlobalModifiedAttributeElementType, 0);

		public static final /*@NonNull*/ ExecutorProperty _MappedAttributeValueExpander__hintsToExpand = new EcoreExecutorProperty(MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND, Types._MappedAttributeValueExpander, 0);

		public static final /*@NonNull*/ ExecutorProperty _Mapping__abstract = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING__ABSTRACT, Types._Mapping, 0);
		public static final /*@NonNull*/ ExecutorProperty _Mapping__globalVariables = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING__GLOBAL_VARIABLES, Types._Mapping, 1);
		public static final /*@NonNull*/ ExecutorProperty _Mapping__importedMappingHintGroups = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING__IMPORTED_MAPPING_HINT_GROUPS, Types._Mapping, 2);
		public static final /*@NonNull*/ ExecutorProperty _Mapping__mappingHintGroups = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS, Types._Mapping, 3);

		public static final /*@NonNull*/ ExecutorProperty _MappingHint__MappingHintGroupType__mappingHints = new ExecutorPropertyWithImplementation("MappingHintGroupType", Types._MappingHint, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS));

		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroup__modelConnectionMatcher = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER, Types._MappingHintGroup, 0);

		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupImporter__container = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, Types._MappingHintGroupImporter, 0);
		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupImporter__hintGroup = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP, Types._MappingHintGroupImporter, 1);
		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupImporter__mappingHints = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS, Types._MappingHintGroupImporter, 2);
		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupImporter__Mapping__importedMappingHintGroups = new ExecutorPropertyWithImplementation("Mapping", Types._MappingHintGroupImporter, 3, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING__IMPORTED_MAPPING_HINT_GROUPS));

		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupType__extend = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND, Types._MappingHintGroupType, 0);
		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupType__mappingHints = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS, Types._MappingHintGroupType, 1);
		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupType__targetSection = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION, Types._MappingHintGroupType, 2);
		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupType__Mapping__mappingHintGroups = new ExecutorPropertyWithImplementation("Mapping", Types._MappingHintGroupType, 3, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS));
		public static final /*@NonNull*/ ExecutorProperty _MappingHintGroupType__MappingHintGroupType__extend = new ExecutorPropertyWithImplementation("MappingHintGroupType", Types._MappingHintGroupType, 4, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND));

		public static final /*@NonNull*/ ExecutorProperty _MappingHintType__MappingHintGroupImporter__mappingHints = new ExecutorPropertyWithImplementation("MappingHintGroupImporter", Types._MappingHintType, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS));

		public static final /*@NonNull*/ ExecutorProperty _MappingType__sourceSection = new EcoreExecutorProperty(MappingPackage.Literals.MAPPING_TYPE__SOURCE_SECTION, Types._MappingType, 0);

		public static final /*@NonNull*/ ExecutorProperty _MatchToLowerCaseConverter__regex = new EcoreExecutorProperty(MappingPackage.Literals.MATCH_TO_LOWER_CASE_CONVERTER__REGEX, Types._MatchToLowerCaseConverter, 0);

		public static final /*@NonNull*/ ExecutorProperty _MatchToUpperCaseConverter__regex = new EcoreExecutorProperty(MappingPackage.Literals.MATCH_TO_UPPER_CASE_CONVERTER__REGEX, Types._MatchToUpperCaseConverter, 0);

		public static final /*@NonNull*/ ExecutorProperty _Matcher__ReferenceTargetSelector__matcher = new ExecutorPropertyWithImplementation("ReferenceTargetSelector", Types._Matcher, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__MATCHER));

		public static final /*@NonNull*/ ExecutorProperty _ModelConnectionHint__sourceElements = new EcoreExecutorProperty(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS, Types._ModelConnectionHint, 0);
		public static final /*@NonNull*/ ExecutorProperty _ModelConnectionHint__targetAttributes = new EcoreExecutorProperty(MappingPackage.Literals.CONTAINER_SELECTOR__TARGET_ATTRIBUTES, Types._ModelConnectionHint, 1);
		public static final /*@NonNull*/ ExecutorProperty _ModelConnectionHint__MappingHintGroup__modelConnectionMatcher = new ExecutorPropertyWithImplementation("MappingHintGroup", Types._ModelConnectionHint, 2, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER));

		public static final /*@NonNull*/ ExecutorProperty _ModelConnectionHintSourceInterface__ModelConnectionHint__sourceElements = new ExecutorPropertyWithImplementation("ModelConnectionHint", Types._ModelConnectionHintSourceInterface, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS));

		public static final /*@NonNull*/ ExecutorProperty _ModelConnectionHintTargetAttribute__ModelConnectionHint__targetAttributes = new ExecutorPropertyWithImplementation("ModelConnectionHint", Types._ModelConnectionHintTargetAttribute, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.CONTAINER_SELECTOR__TARGET_ATTRIBUTES));

		public static final /*@NonNull*/ ExecutorProperty _ModifiableHint__resultModifier = new EcoreExecutorProperty(MappingPackage.Literals.MODIFIABLE_HINT__RESULT_MODIFIER, Types._ModifiableHint, 0);

		public static final /*@NonNull*/ ExecutorProperty _ModifiedAttributeElementType__modifier = new EcoreExecutorProperty(MappingPackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER, Types._ModifiedAttributeElementType, 0);
		public static final /*@NonNull*/ ExecutorProperty _ModifiedAttributeElementType__source = new EcoreExecutorProperty(MappingPackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE, Types._ModifiedAttributeElementType, 1);

		public static final /*@NonNull*/ ExecutorProperty _ReferenceTargetSelector__affectedReference = new EcoreExecutorProperty(MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE, Types._ReferenceTargetSelector, 0);
		public static final /*@NonNull*/ ExecutorProperty _ReferenceTargetSelector__matcher = new EcoreExecutorProperty(MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__MATCHER, Types._ReferenceTargetSelector, 1);

		public static final /*@NonNull*/ ExecutorProperty _StringAppender__string = new EcoreExecutorProperty(MappingPackage.Literals.STRING_APPENDER__STRING, Types._StringAppender, 0);

		public static final /*@NonNull*/ ExecutorProperty _StringPrepender__string = new EcoreExecutorProperty(MappingPackage.Literals.STRING_PREPENDER__STRING, Types._StringPrepender, 0);

		public static final /*@NonNull*/ ExecutorProperty _SubstringReplacer__regex = new EcoreExecutorProperty(MappingPackage.Literals.SUBSTRING_REPLACER__REGEX, Types._SubstringReplacer, 0);
		public static final /*@NonNull*/ ExecutorProperty _SubstringReplacer__replacement = new EcoreExecutorProperty(MappingPackage.Literals.SUBSTRING_REPLACER__REPLACEMENT, Types._SubstringReplacer, 1);

		public static final /*@NonNull*/ ExecutorProperty _ValueModifier__ValueModifierSet__modifier = new ExecutorPropertyWithImplementation("ValueModifierSet", Types._ValueModifier, 0, new EcoreLibraryOppositeProperty(MappingPackage.Literals.VALUE_MODIFIER_SET__MODIFIER));

		public static final /*@NonNull*/ ExecutorProperty _ValueModifierSet__modifier = new EcoreExecutorProperty(MappingPackage.Literals.VALUE_MODIFIER_SET__MODIFIER, Types._ValueModifierSet, 0);
		public static final /*@NonNull*/ ExecutorProperty _ValueModifierSet__GlobalAttribute__modifier = new ExecutorPropertyWithImplementation("GlobalAttribute", Types._ValueModifierSet, 1, new EcoreLibraryOppositeProperty(MappingPackage.Literals.GLOBAL_ATTRIBUTE__MODIFIER));
		public static final /*@NonNull*/ ExecutorProperty _ValueModifierSet__ModifiableHint__resultModifier = new ExecutorPropertyWithImplementation("ModifiableHint", Types._ValueModifierSet, 2, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MODIFIABLE_HINT__RESULT_MODIFIER));
		public static final /*@NonNull*/ ExecutorProperty _ValueModifierSet__ModifiedAttributeElementType__modifier = new ExecutorPropertyWithImplementation("ModifiedAttributeElementType", Types._ValueModifierSet, 3, new EcoreLibraryOppositeProperty(MappingPackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::Properties and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMapping =
		{
			Fragments._AttributeMapping__OclAny /* 0 */,
			Fragments._AttributeMapping__OclElement /* 1 */,
			Fragments._AttributeMapping__ConditionalElement /* 2 */,
			Fragments._AttributeMapping__ExpandableHint /* 2 */,
			Fragments._AttributeMapping__ExpressionHint /* 2 */,
			Fragments._AttributeMapping__ModifiableHint /* 2 */,
			Fragments._AttributeMapping__NamedElement /* 2 */,
			Fragments._AttributeMapping__MappingHintBaseType /* 3 */,
			Fragments._AttributeMapping__MappingHintType /* 4 */,
			Fragments._AttributeMapping__MappingHint /* 5 */,
			Fragments._AttributeMapping__AttributeMapping /* 6 */
		};
		private static final int /*@NonNull*/ [] __AttributeMapping = { 1,1,5,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMappingExternalSourceElement =
		{
			Fragments._AttributeMappingExternalSourceElement__OclAny /* 0 */,
			Fragments._AttributeMappingExternalSourceElement__OclElement /* 1 */,
			Fragments._AttributeMappingExternalSourceElement__NamedElement /* 2 */,
			Fragments._AttributeMappingExternalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMappingExternalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._AttributeMappingExternalSourceElement__AttributeMappingSourceInterface /* 4 */,
			Fragments._AttributeMappingExternalSourceElement__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._AttributeMappingExternalSourceElement__AttributeMappingExternalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __AttributeMappingExternalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMappingGlobalSourceElement =
		{
			Fragments._AttributeMappingGlobalSourceElement__OclAny /* 0 */,
			Fragments._AttributeMappingGlobalSourceElement__OclElement /* 1 */,
			Fragments._AttributeMappingGlobalSourceElement__NamedElement /* 2 */,
			Fragments._AttributeMappingGlobalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMappingGlobalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._AttributeMappingGlobalSourceElement__AttributeMappingSourceInterface /* 4 */,
			Fragments._AttributeMappingGlobalSourceElement__GlobalModifiedAttributeElementType /* 4 */,
			Fragments._AttributeMappingGlobalSourceElement__AttributeMappingGlobalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __AttributeMappingGlobalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMappingSourceElement =
		{
			Fragments._AttributeMappingSourceElement__OclAny /* 0 */,
			Fragments._AttributeMappingSourceElement__OclElement /* 1 */,
			Fragments._AttributeMappingSourceElement__NamedElement /* 2 */,
			Fragments._AttributeMappingSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMappingSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._AttributeMappingSourceElement__AttributeMappingSourceInterface /* 4 */,
			Fragments._AttributeMappingSourceElement__LocalModifiedAttributeElementType /* 4 */,
			Fragments._AttributeMappingSourceElement__AttributeMappingSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __AttributeMappingSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMappingSourceInterface =
		{
			Fragments._AttributeMappingSourceInterface__OclAny /* 0 */,
			Fragments._AttributeMappingSourceInterface__OclElement /* 1 */,
			Fragments._AttributeMappingSourceInterface__NamedElement /* 2 */,
			Fragments._AttributeMappingSourceInterface__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMappingSourceInterface__AttributeMappingSourceInterface /* 4 */
		};
		private static final int /*@NonNull*/ [] __AttributeMappingSourceInterface = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMatcher =
		{
			Fragments._AttributeMatcher__OclAny /* 0 */,
			Fragments._AttributeMatcher__OclElement /* 1 */,
			Fragments._AttributeMatcher__ExpandableHint /* 2 */,
			Fragments._AttributeMatcher__ExpressionHint /* 2 */,
			Fragments._AttributeMatcher__Matcher /* 2 */,
			Fragments._AttributeMatcher__ModifiableHint /* 2 */,
			Fragments._AttributeMatcher__AttributeMatcher /* 3 */
		};
		private static final int /*@NonNull*/ [] __AttributeMatcher = { 1,1,4,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMatcherExternalSourceElement =
		{
			Fragments._AttributeMatcherExternalSourceElement__OclAny /* 0 */,
			Fragments._AttributeMatcherExternalSourceElement__OclElement /* 1 */,
			Fragments._AttributeMatcherExternalSourceElement__NamedElement /* 2 */,
			Fragments._AttributeMatcherExternalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMatcherExternalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._AttributeMatcherExternalSourceElement__AttributeMatcherSourceInterface /* 4 */,
			Fragments._AttributeMatcherExternalSourceElement__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._AttributeMatcherExternalSourceElement__AttributeMatcherExternalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __AttributeMatcherExternalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement =
		{
			Fragments._AttributeMatcherGlobalSourceElement__OclAny /* 0 */,
			Fragments._AttributeMatcherGlobalSourceElement__OclElement /* 1 */,
			Fragments._AttributeMatcherGlobalSourceElement__NamedElement /* 2 */,
			Fragments._AttributeMatcherGlobalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMatcherGlobalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._AttributeMatcherGlobalSourceElement__AttributeMatcherSourceInterface /* 4 */,
			Fragments._AttributeMatcherGlobalSourceElement__GlobalModifiedAttributeElementType /* 4 */,
			Fragments._AttributeMatcherGlobalSourceElement__AttributeMatcherGlobalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __AttributeMatcherGlobalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMatcherSourceElement =
		{
			Fragments._AttributeMatcherSourceElement__OclAny /* 0 */,
			Fragments._AttributeMatcherSourceElement__OclElement /* 1 */,
			Fragments._AttributeMatcherSourceElement__NamedElement /* 2 */,
			Fragments._AttributeMatcherSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMatcherSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._AttributeMatcherSourceElement__AttributeMatcherSourceInterface /* 4 */,
			Fragments._AttributeMatcherSourceElement__LocalModifiedAttributeElementType /* 4 */,
			Fragments._AttributeMatcherSourceElement__AttributeMatcherSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __AttributeMatcherSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _AttributeMatcherSourceInterface =
		{
			Fragments._AttributeMatcherSourceInterface__OclAny /* 0 */,
			Fragments._AttributeMatcherSourceInterface__OclElement /* 1 */,
			Fragments._AttributeMatcherSourceInterface__NamedElement /* 2 */,
			Fragments._AttributeMatcherSourceInterface__MappingHintSourceInterface /* 3 */,
			Fragments._AttributeMatcherSourceInterface__AttributeMatcherSourceInterface /* 4 */
		};
		private static final int /*@NonNull*/ [] __AttributeMatcherSourceInterface = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _CardinalityMapping =
		{
			Fragments._CardinalityMapping__OclAny /* 0 */,
			Fragments._CardinalityMapping__OclElement /* 1 */,
			Fragments._CardinalityMapping__ConditionalElement /* 2 */,
			Fragments._CardinalityMapping__NamedElement /* 2 */,
			Fragments._CardinalityMapping__MappingHintBaseType /* 3 */,
			Fragments._CardinalityMapping__MappingHintType /* 4 */,
			Fragments._CardinalityMapping__MappingHint /* 5 */,
			Fragments._CardinalityMapping__CardinalityMapping /* 6 */
		};
		private static final int /*@NonNull*/ [] __CardinalityMapping = { 1,1,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ClassMatcher =
		{
			Fragments._ClassMatcher__OclAny /* 0 */,
			Fragments._ClassMatcher__OclElement /* 1 */,
			Fragments._ClassMatcher__Matcher /* 2 */,
			Fragments._ClassMatcher__ClassMatcher /* 3 */
		};
		private static final int /*@NonNull*/ [] __ClassMatcher = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExpandableHint =
		{
			Fragments._ExpandableHint__OclAny /* 0 */,
			Fragments._ExpandableHint__OclElement /* 1 */,
			Fragments._ExpandableHint__ExpandableHint /* 2 */
		};
		private static final int /*@NonNull*/ [] __ExpandableHint = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExportedMappingHintGroup =
		{
			Fragments._ExportedMappingHintGroup__OclAny /* 0 */,
			Fragments._ExportedMappingHintGroup__OclElement /* 1 */,
			Fragments._ExportedMappingHintGroup__NamedElement /* 2 */,
			Fragments._ExportedMappingHintGroup__MappingHintGroupType /* 3 */,
			Fragments._ExportedMappingHintGroup__ExportedMappingHintGroup /* 4 */
		};
		private static final int /*@NonNull*/ [] __ExportedMappingHintGroup = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExpressionHint =
		{
			Fragments._ExpressionHint__OclAny /* 0 */,
			Fragments._ExpressionHint__OclElement /* 1 */,
			Fragments._ExpressionHint__ExpressionHint /* 2 */
		};
		private static final int /*@NonNull*/ [] __ExpressionHint = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExternalMappedAttributeValueAppender =
		{
			Fragments._ExternalMappedAttributeValueAppender__OclAny /* 0 */,
			Fragments._ExternalMappedAttributeValueAppender__OclElement /* 1 */,
			Fragments._ExternalMappedAttributeValueAppender__NamedElement /* 2 */,
			Fragments._ExternalMappedAttributeValueAppender__MappingHintBaseType /* 3 */,
			Fragments._ExternalMappedAttributeValueAppender__ModifiedAttributeElementType /* 3 */,
			Fragments._ExternalMappedAttributeValueAppender__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._ExternalMappedAttributeValueAppender__MappingHintType /* 4 */,
			Fragments._ExternalMappedAttributeValueAppender__HintImporterMappingHint /* 5 */,
			Fragments._ExternalMappedAttributeValueAppender__MappedAttributeValueExpander /* 6 */,
			Fragments._ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueExpander /* 7 */,
			Fragments._ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueAppender /* 8 */
		};
		private static final int /*@NonNull*/ [] __ExternalMappedAttributeValueAppender = { 1,1,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExternalMappedAttributeValueExpander =
		{
			Fragments._ExternalMappedAttributeValueExpander__OclAny /* 0 */,
			Fragments._ExternalMappedAttributeValueExpander__OclElement /* 1 */,
			Fragments._ExternalMappedAttributeValueExpander__NamedElement /* 2 */,
			Fragments._ExternalMappedAttributeValueExpander__MappingHintBaseType /* 3 */,
			Fragments._ExternalMappedAttributeValueExpander__ModifiedAttributeElementType /* 3 */,
			Fragments._ExternalMappedAttributeValueExpander__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._ExternalMappedAttributeValueExpander__MappingHintType /* 4 */,
			Fragments._ExternalMappedAttributeValueExpander__HintImporterMappingHint /* 5 */,
			Fragments._ExternalMappedAttributeValueExpander__MappedAttributeValueExpander /* 6 */,
			Fragments._ExternalMappedAttributeValueExpander__ExternalMappedAttributeValueExpander /* 7 */
		};
		private static final int /*@NonNull*/ [] __ExternalMappedAttributeValueExpander = { 1,1,1,2,2,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender =
		{
			Fragments._ExternalMappedAttributeValuePrepender__OclAny /* 0 */,
			Fragments._ExternalMappedAttributeValuePrepender__OclElement /* 1 */,
			Fragments._ExternalMappedAttributeValuePrepender__NamedElement /* 2 */,
			Fragments._ExternalMappedAttributeValuePrepender__MappingHintBaseType /* 3 */,
			Fragments._ExternalMappedAttributeValuePrepender__ModifiedAttributeElementType /* 3 */,
			Fragments._ExternalMappedAttributeValuePrepender__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._ExternalMappedAttributeValuePrepender__MappingHintType /* 4 */,
			Fragments._ExternalMappedAttributeValuePrepender__HintImporterMappingHint /* 5 */,
			Fragments._ExternalMappedAttributeValuePrepender__MappedAttributeValueExpander /* 6 */,
			Fragments._ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValueExpander /* 7 */,
			Fragments._ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValuePrepender /* 8 */
		};
		private static final int /*@NonNull*/ [] __ExternalMappedAttributeValuePrepender = { 1,1,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ExternalModifiedAttributeElementType =
		{
			Fragments._ExternalModifiedAttributeElementType__OclAny /* 0 */,
			Fragments._ExternalModifiedAttributeElementType__OclElement /* 1 */,
			Fragments._ExternalModifiedAttributeElementType__NamedElement /* 2 */,
			Fragments._ExternalModifiedAttributeElementType__ModifiedAttributeElementType /* 3 */,
			Fragments._ExternalModifiedAttributeElementType__ExternalModifiedAttributeElementType /* 4 */
		};
		private static final int /*@NonNull*/ [] __ExternalModifiedAttributeElementType = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _FixedValue =
		{
			Fragments._FixedValue__OclAny /* 0 */,
			Fragments._FixedValue__OclElement /* 1 */,
			Fragments._FixedValue__NamedElement /* 2 */,
			Fragments._FixedValue__MappingHintSourceInterface /* 3 */,
			Fragments._FixedValue__AttributeMappingSourceInterface /* 4 */,
			Fragments._FixedValue__AttributeMatcherSourceInterface /* 4 */,
			Fragments._FixedValue__InstancePointerSourceInterface /* 4 */,
			Fragments._FixedValue__ModelConnectionHintSourceInterface /* 4 */,
			Fragments._FixedValue__ValueConstraintSourceInterface /* 4 */,
			Fragments._FixedValue__FixedValue /* 5 */
		};
		private static final int /*@NonNull*/ [] __FixedValue = { 1,1,1,1,5,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _GlobalAttribute =
		{
			Fragments._GlobalAttribute__OclAny /* 0 */,
			Fragments._GlobalAttribute__OclElement /* 1 */,
			Fragments._GlobalAttribute__NamedElement /* 2 */,
			Fragments._GlobalAttribute__GlobalAttribute /* 3 */
		};
		private static final int /*@NonNull*/ [] __GlobalAttribute = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _GlobalAttributeImporter =
		{
			Fragments._GlobalAttributeImporter__OclAny /* 0 */,
			Fragments._GlobalAttributeImporter__OclElement /* 1 */,
			Fragments._GlobalAttributeImporter__NamedElement /* 2 */,
			Fragments._GlobalAttributeImporter__MappingHintSourceInterface /* 3 */,
			Fragments._GlobalAttributeImporter__AttributeMappingSourceInterface /* 4 */,
			Fragments._GlobalAttributeImporter__AttributeMatcherSourceInterface /* 4 */,
			Fragments._GlobalAttributeImporter__InstancePointerSourceInterface /* 4 */,
			Fragments._GlobalAttributeImporter__ModelConnectionHintSourceInterface /* 4 */,
			Fragments._GlobalAttributeImporter__ValueConstraintSourceInterface /* 4 */,
			Fragments._GlobalAttributeImporter__GlobalAttributeImporter /* 5 */
		};
		private static final int /*@NonNull*/ [] __GlobalAttributeImporter = { 1,1,1,1,5,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _GlobalModifiedAttributeElementType =
		{
			Fragments._GlobalModifiedAttributeElementType__OclAny /* 0 */,
			Fragments._GlobalModifiedAttributeElementType__OclElement /* 1 */,
			Fragments._GlobalModifiedAttributeElementType__NamedElement /* 2 */,
			Fragments._GlobalModifiedAttributeElementType__ModifiedAttributeElementType /* 3 */,
			Fragments._GlobalModifiedAttributeElementType__GlobalModifiedAttributeElementType /* 4 */
		};
		private static final int /*@NonNull*/ [] __GlobalModifiedAttributeElementType = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _HintImporterMappingHint =
		{
			Fragments._HintImporterMappingHint__OclAny /* 0 */,
			Fragments._HintImporterMappingHint__OclElement /* 1 */,
			Fragments._HintImporterMappingHint__NamedElement /* 2 */,
			Fragments._HintImporterMappingHint__MappingHintBaseType /* 3 */,
			Fragments._HintImporterMappingHint__MappingHintType /* 4 */,
			Fragments._HintImporterMappingHint__HintImporterMappingHint /* 5 */
		};
		private static final int /*@NonNull*/ [] __HintImporterMappingHint = { 1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _InstantiableMappingHintGroup =
		{
			Fragments._InstantiableMappingHintGroup__OclAny /* 0 */,
			Fragments._InstantiableMappingHintGroup__OclElement /* 1 */,
			Fragments._InstantiableMappingHintGroup__ConditionalElement /* 2 */,
			Fragments._InstantiableMappingHintGroup__DeactivatableElement /* 2 */,
			Fragments._InstantiableMappingHintGroup__NamedElement /* 2 */,
			Fragments._InstantiableMappingHintGroup__InstantiableMappingHintGroup /* 3 */
		};
		private static final int /*@NonNull*/ [] __InstantiableMappingHintGroup = { 1,1,3,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _LocalMappedAttributeValueExpander =
		{
			Fragments._LocalMappedAttributeValueExpander__OclAny /* 0 */,
			Fragments._LocalMappedAttributeValueExpander__OclElement /* 1 */,
			Fragments._LocalMappedAttributeValueExpander__NamedElement /* 2 */,
			Fragments._LocalMappedAttributeValueExpander__MappingHintBaseType /* 3 */,
			Fragments._LocalMappedAttributeValueExpander__ModifiedAttributeElementType /* 3 */,
			Fragments._LocalMappedAttributeValueExpander__LocalModifiedAttributeElementType /* 4 */,
			Fragments._LocalMappedAttributeValueExpander__MappingHintType /* 4 */,
			Fragments._LocalMappedAttributeValueExpander__HintImporterMappingHint /* 5 */,
			Fragments._LocalMappedAttributeValueExpander__MappedAttributeValueExpander /* 6 */,
			Fragments._LocalMappedAttributeValueExpander__LocalMappedAttributeValueExpander /* 7 */
		};
		private static final int /*@NonNull*/ [] __LocalMappedAttributeValueExpander = { 1,1,1,2,2,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _LocalModifiedAttributeElementType =
		{
			Fragments._LocalModifiedAttributeElementType__OclAny /* 0 */,
			Fragments._LocalModifiedAttributeElementType__OclElement /* 1 */,
			Fragments._LocalModifiedAttributeElementType__NamedElement /* 2 */,
			Fragments._LocalModifiedAttributeElementType__ModifiedAttributeElementType /* 3 */,
			Fragments._LocalModifiedAttributeElementType__LocalModifiedAttributeElementType /* 4 */
		};
		private static final int /*@NonNull*/ [] __LocalModifiedAttributeElementType = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappedAttributeValueAppender =
		{
			Fragments._MappedAttributeValueAppender__OclAny /* 0 */,
			Fragments._MappedAttributeValueAppender__OclElement /* 1 */,
			Fragments._MappedAttributeValueAppender__NamedElement /* 2 */,
			Fragments._MappedAttributeValueAppender__MappingHintBaseType /* 3 */,
			Fragments._MappedAttributeValueAppender__ModifiedAttributeElementType /* 3 */,
			Fragments._MappedAttributeValueAppender__LocalModifiedAttributeElementType /* 4 */,
			Fragments._MappedAttributeValueAppender__MappingHintType /* 4 */,
			Fragments._MappedAttributeValueAppender__HintImporterMappingHint /* 5 */,
			Fragments._MappedAttributeValueAppender__MappedAttributeValueExpander /* 6 */,
			Fragments._MappedAttributeValueAppender__LocalMappedAttributeValueExpander /* 7 */,
			Fragments._MappedAttributeValueAppender__MappedAttributeValueAppender /* 8 */
		};
		private static final int /*@NonNull*/ [] __MappedAttributeValueAppender = { 1,1,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappedAttributeValueExpander =
		{
			Fragments._MappedAttributeValueExpander__OclAny /* 0 */,
			Fragments._MappedAttributeValueExpander__OclElement /* 1 */,
			Fragments._MappedAttributeValueExpander__NamedElement /* 2 */,
			Fragments._MappedAttributeValueExpander__MappingHintBaseType /* 3 */,
			Fragments._MappedAttributeValueExpander__MappingHintType /* 4 */,
			Fragments._MappedAttributeValueExpander__HintImporterMappingHint /* 5 */,
			Fragments._MappedAttributeValueExpander__MappedAttributeValueExpander /* 6 */
		};
		private static final int /*@NonNull*/ [] __MappedAttributeValueExpander = { 1,1,1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappedAttributeValuePrepender =
		{
			Fragments._MappedAttributeValuePrepender__OclAny /* 0 */,
			Fragments._MappedAttributeValuePrepender__OclElement /* 1 */,
			Fragments._MappedAttributeValuePrepender__NamedElement /* 2 */,
			Fragments._MappedAttributeValuePrepender__MappingHintBaseType /* 3 */,
			Fragments._MappedAttributeValuePrepender__ModifiedAttributeElementType /* 3 */,
			Fragments._MappedAttributeValuePrepender__LocalModifiedAttributeElementType /* 4 */,
			Fragments._MappedAttributeValuePrepender__MappingHintType /* 4 */,
			Fragments._MappedAttributeValuePrepender__HintImporterMappingHint /* 5 */,
			Fragments._MappedAttributeValuePrepender__MappedAttributeValueExpander /* 6 */,
			Fragments._MappedAttributeValuePrepender__LocalMappedAttributeValueExpander /* 7 */,
			Fragments._MappedAttributeValuePrepender__MappedAttributeValuePrepender /* 8 */
		};
		private static final int /*@NonNull*/ [] __MappedAttributeValuePrepender = { 1,1,1,2,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Mapping =
		{
			Fragments._Mapping__OclAny /* 0 */,
			Fragments._Mapping__OclElement /* 1 */,
			Fragments._Mapping__ConditionalElement /* 2 */,
			Fragments._Mapping__DeactivatableElement /* 2 */,
			Fragments._Mapping__NamedElement /* 2 */,
			Fragments._Mapping__MappingType /* 3 */,
			Fragments._Mapping__Mapping /* 4 */
		};
		private static final int /*@NonNull*/ [] __Mapping = { 1,1,3,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingHint =
		{
			Fragments._MappingHint__OclAny /* 0 */,
			Fragments._MappingHint__OclElement /* 1 */,
			Fragments._MappingHint__ConditionalElement /* 2 */,
			Fragments._MappingHint__NamedElement /* 2 */,
			Fragments._MappingHint__MappingHintBaseType /* 3 */,
			Fragments._MappingHint__MappingHintType /* 4 */,
			Fragments._MappingHint__MappingHint /* 5 */
		};
		private static final int /*@NonNull*/ [] __MappingHint = { 1,1,2,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingHintBaseType =
		{
			Fragments._MappingHintBaseType__OclAny /* 0 */,
			Fragments._MappingHintBaseType__OclElement /* 1 */,
			Fragments._MappingHintBaseType__NamedElement /* 2 */,
			Fragments._MappingHintBaseType__MappingHintBaseType /* 3 */
		};
		private static final int /*@NonNull*/ [] __MappingHintBaseType = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingHintGroup =
		{
			Fragments._MappingHintGroup__OclAny /* 0 */,
			Fragments._MappingHintGroup__OclElement /* 1 */,
			Fragments._MappingHintGroup__ConditionalElement /* 2 */,
			Fragments._MappingHintGroup__DeactivatableElement /* 2 */,
			Fragments._MappingHintGroup__NamedElement /* 2 */,
			Fragments._MappingHintGroup__InstantiableMappingHintGroup /* 3 */,
			Fragments._MappingHintGroup__MappingHintGroupType /* 3 */,
			Fragments._MappingHintGroup__MappingHintGroup /* 4 */
		};
		private static final int /*@NonNull*/ [] __MappingHintGroup = { 1,1,3,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingHintGroupImporter =
		{
			Fragments._MappingHintGroupImporter__OclAny /* 0 */,
			Fragments._MappingHintGroupImporter__OclElement /* 1 */,
			Fragments._MappingHintGroupImporter__ConditionalElement /* 2 */,
			Fragments._MappingHintGroupImporter__DeactivatableElement /* 2 */,
			Fragments._MappingHintGroupImporter__NamedElement /* 2 */,
			Fragments._MappingHintGroupImporter__InstantiableMappingHintGroup /* 3 */,
			Fragments._MappingHintGroupImporter__MappingHintGroupImporter /* 4 */
		};
		private static final int /*@NonNull*/ [] __MappingHintGroupImporter = { 1,1,3,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingHintGroupType =
		{
			Fragments._MappingHintGroupType__OclAny /* 0 */,
			Fragments._MappingHintGroupType__OclElement /* 1 */,
			Fragments._MappingHintGroupType__NamedElement /* 2 */,
			Fragments._MappingHintGroupType__MappingHintGroupType /* 3 */
		};
		private static final int /*@NonNull*/ [] __MappingHintGroupType = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingHintSourceInterface =
		{
			Fragments._MappingHintSourceInterface__OclAny /* 0 */,
			Fragments._MappingHintSourceInterface__OclElement /* 1 */,
			Fragments._MappingHintSourceInterface__NamedElement /* 2 */,
			Fragments._MappingHintSourceInterface__MappingHintSourceInterface /* 3 */
		};
		private static final int /*@NonNull*/ [] __MappingHintSourceInterface = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingHintType =
		{
			Fragments._MappingHintType__OclAny /* 0 */,
			Fragments._MappingHintType__OclElement /* 1 */,
			Fragments._MappingHintType__NamedElement /* 2 */,
			Fragments._MappingHintType__MappingHintBaseType /* 3 */,
			Fragments._MappingHintType__MappingHintType /* 4 */
		};
		private static final int /*@NonNull*/ [] __MappingHintType = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MappingType =
		{
			Fragments._MappingType__OclAny /* 0 */,
			Fragments._MappingType__OclElement /* 1 */,
			Fragments._MappingType__DeactivatableElement /* 2 */,
			Fragments._MappingType__NamedElement /* 2 */,
			Fragments._MappingType__MappingType /* 3 */
		};
		private static final int /*@NonNull*/ [] __MappingType = { 1,1,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MatchToLowerCaseConverter =
		{
			Fragments._MatchToLowerCaseConverter__OclAny /* 0 */,
			Fragments._MatchToLowerCaseConverter__OclElement /* 1 */,
			Fragments._MatchToLowerCaseConverter__NamedElement /* 2 */,
			Fragments._MatchToLowerCaseConverter__ValueModifier /* 3 */,
			Fragments._MatchToLowerCaseConverter__MatchToLowerCaseConverter /* 4 */
		};
		private static final int /*@NonNull*/ [] __MatchToLowerCaseConverter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _MatchToUpperCaseConverter =
		{
			Fragments._MatchToUpperCaseConverter__OclAny /* 0 */,
			Fragments._MatchToUpperCaseConverter__OclElement /* 1 */,
			Fragments._MatchToUpperCaseConverter__NamedElement /* 2 */,
			Fragments._MatchToUpperCaseConverter__ValueModifier /* 3 */,
			Fragments._MatchToUpperCaseConverter__MatchToUpperCaseConverter /* 4 */
		};
		private static final int /*@NonNull*/ [] __MatchToUpperCaseConverter = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _Matcher =
		{
			Fragments._Matcher__OclAny /* 0 */,
			Fragments._Matcher__OclElement /* 1 */,
			Fragments._Matcher__Matcher /* 2 */
		};
		private static final int /*@NonNull*/ [] __Matcher = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModelConnectionHint =
		{
			Fragments._ModelConnectionHint__OclAny /* 0 */,
			Fragments._ModelConnectionHint__OclElement /* 1 */,
			Fragments._ModelConnectionHint__NamedElement /* 2 */,
			Fragments._ModelConnectionHint__MappingHintBaseType /* 3 */,
			Fragments._ModelConnectionHint__ModelConnectionHint /* 4 */
		};
		private static final int /*@NonNull*/ [] __ModelConnectionHint = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement =
		{
			Fragments._ModelConnectionHintExternalSourceElement__OclAny /* 0 */,
			Fragments._ModelConnectionHintExternalSourceElement__OclElement /* 1 */,
			Fragments._ModelConnectionHintExternalSourceElement__NamedElement /* 2 */,
			Fragments._ModelConnectionHintExternalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._ModelConnectionHintExternalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._ModelConnectionHintExternalSourceElement__ExternalModifiedAttributeElementType /* 4 */,
			Fragments._ModelConnectionHintExternalSourceElement__ModelConnectionHintSourceInterface /* 4 */,
			Fragments._ModelConnectionHintExternalSourceElement__ModelConnectionHintExternalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __ModelConnectionHintExternalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement =
		{
			Fragments._ModelConnectionHintGlobalSourceElement__OclAny /* 0 */,
			Fragments._ModelConnectionHintGlobalSourceElement__OclElement /* 1 */,
			Fragments._ModelConnectionHintGlobalSourceElement__NamedElement /* 2 */,
			Fragments._ModelConnectionHintGlobalSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._ModelConnectionHintGlobalSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._ModelConnectionHintGlobalSourceElement__GlobalModifiedAttributeElementType /* 4 */,
			Fragments._ModelConnectionHintGlobalSourceElement__ModelConnectionHintSourceInterface /* 4 */,
			Fragments._ModelConnectionHintGlobalSourceElement__ModelConnectionHintGlobalSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __ModelConnectionHintGlobalSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModelConnectionHintSourceElement =
		{
			Fragments._ModelConnectionHintSourceElement__OclAny /* 0 */,
			Fragments._ModelConnectionHintSourceElement__OclElement /* 1 */,
			Fragments._ModelConnectionHintSourceElement__NamedElement /* 2 */,
			Fragments._ModelConnectionHintSourceElement__MappingHintSourceInterface /* 3 */,
			Fragments._ModelConnectionHintSourceElement__ModifiedAttributeElementType /* 3 */,
			Fragments._ModelConnectionHintSourceElement__LocalModifiedAttributeElementType /* 4 */,
			Fragments._ModelConnectionHintSourceElement__ModelConnectionHintSourceInterface /* 4 */,
			Fragments._ModelConnectionHintSourceElement__ModelConnectionHintSourceElement /* 5 */
		};
		private static final int /*@NonNull*/ [] __ModelConnectionHintSourceElement = { 1,1,1,2,2,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModelConnectionHintSourceInterface =
		{
			Fragments._ModelConnectionHintSourceInterface__OclAny /* 0 */,
			Fragments._ModelConnectionHintSourceInterface__OclElement /* 1 */,
			Fragments._ModelConnectionHintSourceInterface__NamedElement /* 2 */,
			Fragments._ModelConnectionHintSourceInterface__MappingHintSourceInterface /* 3 */,
			Fragments._ModelConnectionHintSourceInterface__ModelConnectionHintSourceInterface /* 4 */
		};
		private static final int /*@NonNull*/ [] __ModelConnectionHintSourceInterface = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModelConnectionHintTargetAttribute =
		{
			Fragments._ModelConnectionHintTargetAttribute__OclAny /* 0 */,
			Fragments._ModelConnectionHintTargetAttribute__OclElement /* 1 */,
			Fragments._ModelConnectionHintTargetAttribute__NamedElement /* 2 */,
			Fragments._ModelConnectionHintTargetAttribute__ModifiedAttributeElementType /* 3 */,
			Fragments._ModelConnectionHintTargetAttribute__ModelConnectionHintTargetAttribute /* 4 */
		};
		private static final int /*@NonNull*/ [] __ModelConnectionHintTargetAttribute = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModifiableHint =
		{
			Fragments._ModifiableHint__OclAny /* 0 */,
			Fragments._ModifiableHint__OclElement /* 1 */,
			Fragments._ModifiableHint__ModifiableHint /* 2 */
		};
		private static final int /*@NonNull*/ [] __ModifiableHint = { 1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ModifiedAttributeElementType =
		{
			Fragments._ModifiedAttributeElementType__OclAny /* 0 */,
			Fragments._ModifiedAttributeElementType__OclElement /* 1 */,
			Fragments._ModifiedAttributeElementType__NamedElement /* 2 */,
			Fragments._ModifiedAttributeElementType__ModifiedAttributeElementType /* 3 */
		};
		private static final int /*@NonNull*/ [] __ModifiedAttributeElementType = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ReferenceTargetSelector =
		{
			Fragments._ReferenceTargetSelector__OclAny /* 0 */,
			Fragments._ReferenceTargetSelector__OclElement /* 1 */,
			Fragments._ReferenceTargetSelector__ConditionalElement /* 2 */,
			Fragments._ReferenceTargetSelector__NamedElement /* 2 */,
			Fragments._ReferenceTargetSelector__MappingHintBaseType /* 3 */,
			Fragments._ReferenceTargetSelector__MappingHintType /* 4 */,
			Fragments._ReferenceTargetSelector__MappingHint /* 5 */,
			Fragments._ReferenceTargetSelector__ReferenceTargetSelector /* 6 */
		};
		private static final int /*@NonNull*/ [] __ReferenceTargetSelector = { 1,1,2,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _StringAppender =
		{
			Fragments._StringAppender__OclAny /* 0 */,
			Fragments._StringAppender__OclElement /* 1 */,
			Fragments._StringAppender__NamedElement /* 2 */,
			Fragments._StringAppender__ValueModifier /* 3 */,
			Fragments._StringAppender__StringAppender /* 4 */
		};
		private static final int /*@NonNull*/ [] __StringAppender = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _StringPrepender =
		{
			Fragments._StringPrepender__OclAny /* 0 */,
			Fragments._StringPrepender__OclElement /* 1 */,
			Fragments._StringPrepender__NamedElement /* 2 */,
			Fragments._StringPrepender__ValueModifier /* 3 */,
			Fragments._StringPrepender__StringPrepender /* 4 */
		};
		private static final int /*@NonNull*/ [] __StringPrepender = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _SubstringReplacer =
		{
			Fragments._SubstringReplacer__OclAny /* 0 */,
			Fragments._SubstringReplacer__OclElement /* 1 */,
			Fragments._SubstringReplacer__NamedElement /* 2 */,
			Fragments._SubstringReplacer__ValueModifier /* 3 */,
			Fragments._SubstringReplacer__SubstringReplacer /* 4 */
		};
		private static final int /*@NonNull*/ [] __SubstringReplacer = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _UniqueNumberAppender =
		{
			Fragments._UniqueNumberAppender__OclAny /* 0 */,
			Fragments._UniqueNumberAppender__OclElement /* 1 */,
			Fragments._UniqueNumberAppender__NamedElement /* 2 */,
			Fragments._UniqueNumberAppender__ValueModifier /* 3 */,
			Fragments._UniqueNumberAppender__UniqueNumberAppender /* 4 */
		};
		private static final int /*@NonNull*/ [] __UniqueNumberAppender = { 1,1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ValueModifier =
		{
			Fragments._ValueModifier__OclAny /* 0 */,
			Fragments._ValueModifier__OclElement /* 1 */,
			Fragments._ValueModifier__NamedElement /* 2 */,
			Fragments._ValueModifier__ValueModifier /* 3 */
		};
		private static final int /*@NonNull*/ [] __ValueModifier = { 1,1,1,1 };

		private static final /*@NonNull*/ ExecutorFragment /*@NonNull*/ [] _ValueModifierSet =
		{
			Fragments._ValueModifierSet__OclAny /* 0 */,
			Fragments._ValueModifierSet__OclElement /* 1 */,
			Fragments._ValueModifierSet__NamedElement /* 2 */,
			Fragments._ValueModifierSet__ValueModifierSet /* 3 */
		};
		private static final int /*@NonNull*/ [] __ValueModifierSet = { 1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._AttributeMapping.initFragments(_AttributeMapping, __AttributeMapping);
			Types._AttributeMappingExternalSourceElement.initFragments(_AttributeMappingExternalSourceElement, __AttributeMappingExternalSourceElement);
			Types._AttributeMappingGlobalSourceElement.initFragments(_AttributeMappingGlobalSourceElement, __AttributeMappingGlobalSourceElement);
			Types._AttributeMappingSourceElement.initFragments(_AttributeMappingSourceElement, __AttributeMappingSourceElement);
			Types._AttributeMappingSourceInterface.initFragments(_AttributeMappingSourceInterface, __AttributeMappingSourceInterface);
			Types._AttributeMatcher.initFragments(_AttributeMatcher, __AttributeMatcher);
			Types._AttributeMatcherExternalSourceElement.initFragments(_AttributeMatcherExternalSourceElement, __AttributeMatcherExternalSourceElement);
			Types._AttributeMatcherGlobalSourceElement.initFragments(_AttributeMatcherGlobalSourceElement, __AttributeMatcherGlobalSourceElement);
			Types._AttributeMatcherSourceElement.initFragments(_AttributeMatcherSourceElement, __AttributeMatcherSourceElement);
			Types._AttributeMatcherSourceInterface.initFragments(_AttributeMatcherSourceInterface, __AttributeMatcherSourceInterface);
			Types._CardinalityMapping.initFragments(_CardinalityMapping, __CardinalityMapping);
			Types._ClassMatcher.initFragments(_ClassMatcher, __ClassMatcher);
			Types._ExpandableHint.initFragments(_ExpandableHint, __ExpandableHint);
			Types._ExportedMappingHintGroup.initFragments(_ExportedMappingHintGroup, __ExportedMappingHintGroup);
			Types._ExpressionHint.initFragments(_ExpressionHint, __ExpressionHint);
			Types._ExternalMappedAttributeValueAppender.initFragments(_ExternalMappedAttributeValueAppender, __ExternalMappedAttributeValueAppender);
			Types._ExternalMappedAttributeValueExpander.initFragments(_ExternalMappedAttributeValueExpander, __ExternalMappedAttributeValueExpander);
			Types._ExternalMappedAttributeValuePrepender.initFragments(_ExternalMappedAttributeValuePrepender, __ExternalMappedAttributeValuePrepender);
			Types._ExternalModifiedAttributeElementType.initFragments(_ExternalModifiedAttributeElementType, __ExternalModifiedAttributeElementType);
			Types._FixedValue.initFragments(_FixedValue, __FixedValue);
			Types._GlobalAttribute.initFragments(_GlobalAttribute, __GlobalAttribute);
			Types._GlobalAttributeImporter.initFragments(_GlobalAttributeImporter, __GlobalAttributeImporter);
			Types._GlobalModifiedAttributeElementType.initFragments(_GlobalModifiedAttributeElementType, __GlobalModifiedAttributeElementType);
			Types._HintImporterMappingHint.initFragments(_HintImporterMappingHint, __HintImporterMappingHint);
			Types._InstantiableMappingHintGroup.initFragments(_InstantiableMappingHintGroup, __InstantiableMappingHintGroup);
			Types._LocalMappedAttributeValueExpander.initFragments(_LocalMappedAttributeValueExpander, __LocalMappedAttributeValueExpander);
			Types._LocalModifiedAttributeElementType.initFragments(_LocalModifiedAttributeElementType, __LocalModifiedAttributeElementType);
			Types._MappedAttributeValueAppender.initFragments(_MappedAttributeValueAppender, __MappedAttributeValueAppender);
			Types._MappedAttributeValueExpander.initFragments(_MappedAttributeValueExpander, __MappedAttributeValueExpander);
			Types._MappedAttributeValuePrepender.initFragments(_MappedAttributeValuePrepender, __MappedAttributeValuePrepender);
			Types._Mapping.initFragments(_Mapping, __Mapping);
			Types._MappingHint.initFragments(_MappingHint, __MappingHint);
			Types._MappingHintBaseType.initFragments(_MappingHintBaseType, __MappingHintBaseType);
			Types._MappingHintGroup.initFragments(_MappingHintGroup, __MappingHintGroup);
			Types._MappingHintGroupImporter.initFragments(_MappingHintGroupImporter, __MappingHintGroupImporter);
			Types._MappingHintGroupType.initFragments(_MappingHintGroupType, __MappingHintGroupType);
			Types._MappingHintSourceInterface.initFragments(_MappingHintSourceInterface, __MappingHintSourceInterface);
			Types._MappingHintType.initFragments(_MappingHintType, __MappingHintType);
			Types._MappingType.initFragments(_MappingType, __MappingType);
			Types._MatchToLowerCaseConverter.initFragments(_MatchToLowerCaseConverter, __MatchToLowerCaseConverter);
			Types._MatchToUpperCaseConverter.initFragments(_MatchToUpperCaseConverter, __MatchToUpperCaseConverter);
			Types._Matcher.initFragments(_Matcher, __Matcher);
			Types._ModelConnectionHint.initFragments(_ModelConnectionHint, __ModelConnectionHint);
			Types._ModelConnectionHintExternalSourceElement.initFragments(_ModelConnectionHintExternalSourceElement, __ModelConnectionHintExternalSourceElement);
			Types._ModelConnectionHintGlobalSourceElement.initFragments(_ModelConnectionHintGlobalSourceElement, __ModelConnectionHintGlobalSourceElement);
			Types._ModelConnectionHintSourceElement.initFragments(_ModelConnectionHintSourceElement, __ModelConnectionHintSourceElement);
			Types._ModelConnectionHintSourceInterface.initFragments(_ModelConnectionHintSourceInterface, __ModelConnectionHintSourceInterface);
			Types._ModelConnectionHintTargetAttribute.initFragments(_ModelConnectionHintTargetAttribute, __ModelConnectionHintTargetAttribute);
			Types._ModifiableHint.initFragments(_ModifiableHint, __ModifiableHint);
			Types._ModifiedAttributeElementType.initFragments(_ModifiedAttributeElementType, __ModifiedAttributeElementType);
			Types._ReferenceTargetSelector.initFragments(_ReferenceTargetSelector, __ReferenceTargetSelector);
			Types._StringAppender.initFragments(_StringAppender, __StringAppender);
			Types._StringPrepender.initFragments(_StringPrepender, __StringPrepender);
			Types._SubstringReplacer.initFragments(_SubstringReplacer, __SubstringReplacer);
			Types._UniqueNumberAppender.initFragments(_UniqueNumberAppender, __UniqueNumberAppender);
			Types._ValueModifier.initFragments(_ValueModifier, __ValueModifier);
			Types._ValueModifierSet.initFragments(_ValueModifierSet, __ValueModifierSet);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::TypeFragments and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__AttributeMapping = {
			MappingTables.Operations._AttributeMapping__getExternalSourceElements /* getExternalSourceElements() */,
			MappingTables.Operations._AttributeMapping__getLocalSourceElements /* getLocalSourceElements() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__ExpandableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__MappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMapping__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__AttributeMappingExternalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__AttributeMappingSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingExternalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__AttributeMappingGlobalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__AttributeMappingSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__GlobalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingGlobalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__AttributeMappingSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__AttributeMappingSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceInterface__AttributeMappingSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceInterface__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceInterface__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceInterface__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMappingSourceInterface__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcher__AttributeMatcher = {
			MappingTables.Operations._AttributeMatcher__getExternalSourceElements /* getExternalSourceElements() */,
			MappingTables.Operations._AttributeMatcher__getLocalSourceElements /* getLocalSourceElements() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcher__ExpandableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcher__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcher__Matcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcher__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__AttributeMatcherExternalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__AttributeMatcherSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherExternalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__AttributeMatcherGlobalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__AttributeMatcherSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__GlobalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__AttributeMatcherSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__AttributeMatcherSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceInterface__AttributeMatcherSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceInterface__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceInterface__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceInterface__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _AttributeMatcherSourceInterface__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__CardinalityMapping = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__MappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _CardinalityMapping__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ClassMatcher__ClassMatcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ClassMatcher__Matcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ClassMatcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ClassMatcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExpandableHint__ExpandableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExpandableHint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExpandableHint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExportedMappingHintGroup__ExportedMappingHintGroup = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExportedMappingHintGroup__MappingHintGroupType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExportedMappingHintGroup__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExportedMappingHintGroup__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExportedMappingHintGroup__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExpressionHint__ExpressionHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExpressionHint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExpressionHint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueAppender = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueExpander = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__MappedAttributeValueExpander = {
			MappingTables.Operations._MappedAttributeValueExpander__getModifiers /* getModifiers() */,
			MappingTables.Operations._MappedAttributeValueExpander__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueAppender__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__ExternalMappedAttributeValueExpander = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__MappedAttributeValueExpander = {
			MappingTables.Operations._MappedAttributeValueExpander__getModifiers /* getModifiers() */,
			MappingTables.Operations._MappedAttributeValueExpander__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValueExpander__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValuePrepender = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValueExpander = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__MappedAttributeValueExpander = {
			MappingTables.Operations._MappedAttributeValueExpander__getModifiers /* getModifiers() */,
			MappingTables.Operations._MappedAttributeValueExpander__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalModifiedAttributeElementType__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalModifiedAttributeElementType__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalModifiedAttributeElementType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalModifiedAttributeElementType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ExternalModifiedAttributeElementType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__FixedValue = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__AttributeMappingSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__AttributeMatcherSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__InstancePointerSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__ModelConnectionHintSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _FixedValue__ValueConstraintSourceInterface = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttribute__GlobalAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__GlobalAttributeImporter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__AttributeMappingSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__AttributeMatcherSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__InstancePointerSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__ModelConnectionHintSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalAttributeImporter__ValueConstraintSourceInterface = {};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalModifiedAttributeElementType__GlobalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalModifiedAttributeElementType__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalModifiedAttributeElementType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalModifiedAttributeElementType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _GlobalModifiedAttributeElementType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _HintImporterMappingHint__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _HintImporterMappingHint__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _HintImporterMappingHint__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _HintImporterMappingHint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _HintImporterMappingHint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _HintImporterMappingHint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstantiableMappingHintGroup__InstantiableMappingHintGroup = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstantiableMappingHintGroup__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstantiableMappingHintGroup__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstantiableMappingHintGroup__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstantiableMappingHintGroup__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _InstantiableMappingHintGroup__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__LocalMappedAttributeValueExpander = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__MappedAttributeValueExpander = {
			MappingTables.Operations._MappedAttributeValueExpander__getModifiers /* getModifiers() */,
			MappingTables.Operations._MappedAttributeValueExpander__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalMappedAttributeValueExpander__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalModifiedAttributeElementType__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalModifiedAttributeElementType__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalModifiedAttributeElementType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalModifiedAttributeElementType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _LocalModifiedAttributeElementType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__MappedAttributeValueAppender = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__LocalMappedAttributeValueExpander = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__MappedAttributeValueExpander = {
			MappingTables.Operations._MappedAttributeValueExpander__getModifiers /* getModifiers() */,
			MappingTables.Operations._MappedAttributeValueExpander__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueAppender__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueExpander__MappedAttributeValueExpander = {
			MappingTables.Operations._MappedAttributeValueExpander__getModifiers /* getModifiers() */,
			MappingTables.Operations._MappedAttributeValueExpander__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueExpander__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueExpander__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueExpander__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueExpander__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueExpander__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValueExpander__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__MappedAttributeValuePrepender = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__HintImporterMappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__LocalMappedAttributeValueExpander = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__MappedAttributeValueExpander = {
			MappingTables.Operations._MappedAttributeValueExpander__getModifiers /* getModifiers() */,
			MappingTables.Operations._MappedAttributeValueExpander__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappedAttributeValuePrepender__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Mapping__Mapping = {
			MappingTables.Operations._Mapping__getActiveImportedMappingHintGroups /* getActiveImportedMappingHintGroups() */,
			MappingTables.Operations._Mapping__getActiveMappingHintGroups /* getActiveMappingHintGroups() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Mapping__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Mapping__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Mapping__MappingType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Mapping__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Mapping__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Mapping__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHint__MappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHint__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHint__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHint__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintBaseType__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintBaseType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintBaseType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintBaseType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__MappingHintGroup = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__InstantiableMappingHintGroup = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__MappingHintGroupType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroup__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupImporter__MappingHintGroupImporter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupImporter__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupImporter__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupImporter__InstantiableMappingHintGroup = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupImporter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupImporter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupImporter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupType__MappingHintGroupType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintGroupType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintSourceInterface__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintSourceInterface__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintSourceInterface__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintSourceInterface__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintType__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintType__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingHintType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingType__MappingType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingType__DeactivatableElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MappingType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToLowerCaseConverter__MatchToLowerCaseConverter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToLowerCaseConverter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToLowerCaseConverter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToLowerCaseConverter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToLowerCaseConverter__ValueModifier = {
			MappingTables.Operations._ValueModifier__modifyValue /* modifyValue(String[1]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToUpperCaseConverter__MatchToUpperCaseConverter = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToUpperCaseConverter__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToUpperCaseConverter__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToUpperCaseConverter__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _MatchToUpperCaseConverter__ValueModifier = {
			MappingTables.Operations._ValueModifier__modifyValue /* modifyValue(String[1]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Matcher__Matcher = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Matcher__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _Matcher__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHint__ModelConnectionHint = {
			MappingTables.Operations._ModelConnectionHint__getExternalSourceElements /* getExternalSourceElements() */,
			MappingTables.Operations._ModelConnectionHint__getLocalSourceElements /* getLocalSourceElements() */,
			MappingTables.Operations._ModelConnectionHint__getSourceAttributes /* getSourceAttributes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHint__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHint__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__ModelConnectionHintExternalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__ExternalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__ModelConnectionHintSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__ModelConnectionHintGlobalSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__GlobalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__ModelConnectionHintSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__ModelConnectionHintSourceElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__LocalModifiedAttributeElementType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__ModelConnectionHintSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceElement__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceInterface__ModelConnectionHintSourceInterface = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceInterface__MappingHintSourceInterface = {
			MappingTables.Operations._MappingHintSourceInterface__getSourceAttribute /* getSourceAttribute() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceInterface__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceInterface__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintSourceInterface__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintTargetAttribute__ModelConnectionHintTargetAttribute = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintTargetAttribute__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintTargetAttribute__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintTargetAttribute__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModelConnectionHintTargetAttribute__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModifiableHint__ModifiableHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModifiableHint__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModifiableHint__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModifiedAttributeElementType__ModifiedAttributeElementType = {
			MappingTables.Operations._ModifiedAttributeElementType__getMapping /* getMapping() */,
			MappingTables.Operations._ModifiedAttributeElementType__getMappingHintGroup /* getMappingHintGroup() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModifiedAttributeElementType__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModifiedAttributeElementType__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ModifiedAttributeElementType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__ReferenceTargetSelector = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__ConditionalElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__MappingHint = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__MappingHintBaseType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__MappingHintType = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ReferenceTargetSelector__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringAppender__StringAppender = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringAppender__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringAppender__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringAppender__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringAppender__ValueModifier = {
			MappingTables.Operations._ValueModifier__modifyValue /* modifyValue(String[1]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringPrepender__StringPrepender = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringPrepender__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringPrepender__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringPrepender__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _StringPrepender__ValueModifier = {
			MappingTables.Operations._ValueModifier__modifyValue /* modifyValue(String[1]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringReplacer__SubstringReplacer = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringReplacer__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringReplacer__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringReplacer__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _SubstringReplacer__ValueModifier = {
			MappingTables.Operations._ValueModifier__modifyValue /* modifyValue(String[1]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UniqueNumberAppender__UniqueNumberAppender = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UniqueNumberAppender__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UniqueNumberAppender__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UniqueNumberAppender__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _UniqueNumberAppender__ValueModifier = {
			MappingTables.Operations._ValueModifier__modifyValue /* modifyValue(String[1]) */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifier__ValueModifier = {
			MappingTables.Operations._ValueModifier__modifyValue /* modifyValue(String[1]) */
		};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifier__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifier__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifier__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances() */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[?]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[?]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifierSet__ValueModifierSet = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifierSet__NamedElement = {};
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifierSet__OclAny = {
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
		private static final /*@NonNull*/ ExecutorOperation /*@NonNull*/ [] _ValueModifierSet__OclElement = {
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
			Fragments._AttributeMapping__AttributeMapping.initOperations(_AttributeMapping__AttributeMapping);
			Fragments._AttributeMapping__ConditionalElement.initOperations(_AttributeMapping__ConditionalElement);
			Fragments._AttributeMapping__ExpandableHint.initOperations(_AttributeMapping__ExpandableHint);
			Fragments._AttributeMapping__ExpressionHint.initOperations(_AttributeMapping__ExpressionHint);
			Fragments._AttributeMapping__MappingHint.initOperations(_AttributeMapping__MappingHint);
			Fragments._AttributeMapping__MappingHintBaseType.initOperations(_AttributeMapping__MappingHintBaseType);
			Fragments._AttributeMapping__MappingHintType.initOperations(_AttributeMapping__MappingHintType);
			Fragments._AttributeMapping__ModifiableHint.initOperations(_AttributeMapping__ModifiableHint);
			Fragments._AttributeMapping__NamedElement.initOperations(_AttributeMapping__NamedElement);
			Fragments._AttributeMapping__OclAny.initOperations(_AttributeMapping__OclAny);
			Fragments._AttributeMapping__OclElement.initOperations(_AttributeMapping__OclElement);

			Fragments._AttributeMappingExternalSourceElement__AttributeMappingExternalSourceElement.initOperations(_AttributeMappingExternalSourceElement__AttributeMappingExternalSourceElement);
			Fragments._AttributeMappingExternalSourceElement__AttributeMappingSourceInterface.initOperations(_AttributeMappingExternalSourceElement__AttributeMappingSourceInterface);
			Fragments._AttributeMappingExternalSourceElement__ExternalModifiedAttributeElementType.initOperations(_AttributeMappingExternalSourceElement__ExternalModifiedAttributeElementType);
			Fragments._AttributeMappingExternalSourceElement__MappingHintSourceInterface.initOperations(_AttributeMappingExternalSourceElement__MappingHintSourceInterface);
			Fragments._AttributeMappingExternalSourceElement__ModifiedAttributeElementType.initOperations(_AttributeMappingExternalSourceElement__ModifiedAttributeElementType);
			Fragments._AttributeMappingExternalSourceElement__NamedElement.initOperations(_AttributeMappingExternalSourceElement__NamedElement);
			Fragments._AttributeMappingExternalSourceElement__OclAny.initOperations(_AttributeMappingExternalSourceElement__OclAny);
			Fragments._AttributeMappingExternalSourceElement__OclElement.initOperations(_AttributeMappingExternalSourceElement__OclElement);

			Fragments._AttributeMappingGlobalSourceElement__AttributeMappingGlobalSourceElement.initOperations(_AttributeMappingGlobalSourceElement__AttributeMappingGlobalSourceElement);
			Fragments._AttributeMappingGlobalSourceElement__AttributeMappingSourceInterface.initOperations(_AttributeMappingGlobalSourceElement__AttributeMappingSourceInterface);
			Fragments._AttributeMappingGlobalSourceElement__GlobalModifiedAttributeElementType.initOperations(_AttributeMappingGlobalSourceElement__GlobalModifiedAttributeElementType);
			Fragments._AttributeMappingGlobalSourceElement__MappingHintSourceInterface.initOperations(_AttributeMappingGlobalSourceElement__MappingHintSourceInterface);
			Fragments._AttributeMappingGlobalSourceElement__ModifiedAttributeElementType.initOperations(_AttributeMappingGlobalSourceElement__ModifiedAttributeElementType);
			Fragments._AttributeMappingGlobalSourceElement__NamedElement.initOperations(_AttributeMappingGlobalSourceElement__NamedElement);
			Fragments._AttributeMappingGlobalSourceElement__OclAny.initOperations(_AttributeMappingGlobalSourceElement__OclAny);
			Fragments._AttributeMappingGlobalSourceElement__OclElement.initOperations(_AttributeMappingGlobalSourceElement__OclElement);

			Fragments._AttributeMappingSourceElement__AttributeMappingSourceElement.initOperations(_AttributeMappingSourceElement__AttributeMappingSourceElement);
			Fragments._AttributeMappingSourceElement__AttributeMappingSourceInterface.initOperations(_AttributeMappingSourceElement__AttributeMappingSourceInterface);
			Fragments._AttributeMappingSourceElement__LocalModifiedAttributeElementType.initOperations(_AttributeMappingSourceElement__LocalModifiedAttributeElementType);
			Fragments._AttributeMappingSourceElement__MappingHintSourceInterface.initOperations(_AttributeMappingSourceElement__MappingHintSourceInterface);
			Fragments._AttributeMappingSourceElement__ModifiedAttributeElementType.initOperations(_AttributeMappingSourceElement__ModifiedAttributeElementType);
			Fragments._AttributeMappingSourceElement__NamedElement.initOperations(_AttributeMappingSourceElement__NamedElement);
			Fragments._AttributeMappingSourceElement__OclAny.initOperations(_AttributeMappingSourceElement__OclAny);
			Fragments._AttributeMappingSourceElement__OclElement.initOperations(_AttributeMappingSourceElement__OclElement);

			Fragments._AttributeMappingSourceInterface__AttributeMappingSourceInterface.initOperations(_AttributeMappingSourceInterface__AttributeMappingSourceInterface);
			Fragments._AttributeMappingSourceInterface__MappingHintSourceInterface.initOperations(_AttributeMappingSourceInterface__MappingHintSourceInterface);
			Fragments._AttributeMappingSourceInterface__NamedElement.initOperations(_AttributeMappingSourceInterface__NamedElement);
			Fragments._AttributeMappingSourceInterface__OclAny.initOperations(_AttributeMappingSourceInterface__OclAny);
			Fragments._AttributeMappingSourceInterface__OclElement.initOperations(_AttributeMappingSourceInterface__OclElement);

			Fragments._AttributeMatcher__AttributeMatcher.initOperations(_AttributeMatcher__AttributeMatcher);
			Fragments._AttributeMatcher__ExpandableHint.initOperations(_AttributeMatcher__ExpandableHint);
			Fragments._AttributeMatcher__ExpressionHint.initOperations(_AttributeMatcher__ExpressionHint);
			Fragments._AttributeMatcher__Matcher.initOperations(_AttributeMatcher__Matcher);
			Fragments._AttributeMatcher__ModifiableHint.initOperations(_AttributeMatcher__ModifiableHint);
			Fragments._AttributeMatcher__OclAny.initOperations(_AttributeMatcher__OclAny);
			Fragments._AttributeMatcher__OclElement.initOperations(_AttributeMatcher__OclElement);

			Fragments._AttributeMatcherExternalSourceElement__AttributeMatcherExternalSourceElement.initOperations(_AttributeMatcherExternalSourceElement__AttributeMatcherExternalSourceElement);
			Fragments._AttributeMatcherExternalSourceElement__AttributeMatcherSourceInterface.initOperations(_AttributeMatcherExternalSourceElement__AttributeMatcherSourceInterface);
			Fragments._AttributeMatcherExternalSourceElement__ExternalModifiedAttributeElementType.initOperations(_AttributeMatcherExternalSourceElement__ExternalModifiedAttributeElementType);
			Fragments._AttributeMatcherExternalSourceElement__MappingHintSourceInterface.initOperations(_AttributeMatcherExternalSourceElement__MappingHintSourceInterface);
			Fragments._AttributeMatcherExternalSourceElement__ModifiedAttributeElementType.initOperations(_AttributeMatcherExternalSourceElement__ModifiedAttributeElementType);
			Fragments._AttributeMatcherExternalSourceElement__NamedElement.initOperations(_AttributeMatcherExternalSourceElement__NamedElement);
			Fragments._AttributeMatcherExternalSourceElement__OclAny.initOperations(_AttributeMatcherExternalSourceElement__OclAny);
			Fragments._AttributeMatcherExternalSourceElement__OclElement.initOperations(_AttributeMatcherExternalSourceElement__OclElement);

			Fragments._AttributeMatcherGlobalSourceElement__AttributeMatcherGlobalSourceElement.initOperations(_AttributeMatcherGlobalSourceElement__AttributeMatcherGlobalSourceElement);
			Fragments._AttributeMatcherGlobalSourceElement__AttributeMatcherSourceInterface.initOperations(_AttributeMatcherGlobalSourceElement__AttributeMatcherSourceInterface);
			Fragments._AttributeMatcherGlobalSourceElement__GlobalModifiedAttributeElementType.initOperations(_AttributeMatcherGlobalSourceElement__GlobalModifiedAttributeElementType);
			Fragments._AttributeMatcherGlobalSourceElement__MappingHintSourceInterface.initOperations(_AttributeMatcherGlobalSourceElement__MappingHintSourceInterface);
			Fragments._AttributeMatcherGlobalSourceElement__ModifiedAttributeElementType.initOperations(_AttributeMatcherGlobalSourceElement__ModifiedAttributeElementType);
			Fragments._AttributeMatcherGlobalSourceElement__NamedElement.initOperations(_AttributeMatcherGlobalSourceElement__NamedElement);
			Fragments._AttributeMatcherGlobalSourceElement__OclAny.initOperations(_AttributeMatcherGlobalSourceElement__OclAny);
			Fragments._AttributeMatcherGlobalSourceElement__OclElement.initOperations(_AttributeMatcherGlobalSourceElement__OclElement);

			Fragments._AttributeMatcherSourceElement__AttributeMatcherSourceElement.initOperations(_AttributeMatcherSourceElement__AttributeMatcherSourceElement);
			Fragments._AttributeMatcherSourceElement__AttributeMatcherSourceInterface.initOperations(_AttributeMatcherSourceElement__AttributeMatcherSourceInterface);
			Fragments._AttributeMatcherSourceElement__LocalModifiedAttributeElementType.initOperations(_AttributeMatcherSourceElement__LocalModifiedAttributeElementType);
			Fragments._AttributeMatcherSourceElement__MappingHintSourceInterface.initOperations(_AttributeMatcherSourceElement__MappingHintSourceInterface);
			Fragments._AttributeMatcherSourceElement__ModifiedAttributeElementType.initOperations(_AttributeMatcherSourceElement__ModifiedAttributeElementType);
			Fragments._AttributeMatcherSourceElement__NamedElement.initOperations(_AttributeMatcherSourceElement__NamedElement);
			Fragments._AttributeMatcherSourceElement__OclAny.initOperations(_AttributeMatcherSourceElement__OclAny);
			Fragments._AttributeMatcherSourceElement__OclElement.initOperations(_AttributeMatcherSourceElement__OclElement);

			Fragments._AttributeMatcherSourceInterface__AttributeMatcherSourceInterface.initOperations(_AttributeMatcherSourceInterface__AttributeMatcherSourceInterface);
			Fragments._AttributeMatcherSourceInterface__MappingHintSourceInterface.initOperations(_AttributeMatcherSourceInterface__MappingHintSourceInterface);
			Fragments._AttributeMatcherSourceInterface__NamedElement.initOperations(_AttributeMatcherSourceInterface__NamedElement);
			Fragments._AttributeMatcherSourceInterface__OclAny.initOperations(_AttributeMatcherSourceInterface__OclAny);
			Fragments._AttributeMatcherSourceInterface__OclElement.initOperations(_AttributeMatcherSourceInterface__OclElement);

			Fragments._CardinalityMapping__CardinalityMapping.initOperations(_CardinalityMapping__CardinalityMapping);
			Fragments._CardinalityMapping__ConditionalElement.initOperations(_CardinalityMapping__ConditionalElement);
			Fragments._CardinalityMapping__MappingHint.initOperations(_CardinalityMapping__MappingHint);
			Fragments._CardinalityMapping__MappingHintBaseType.initOperations(_CardinalityMapping__MappingHintBaseType);
			Fragments._CardinalityMapping__MappingHintType.initOperations(_CardinalityMapping__MappingHintType);
			Fragments._CardinalityMapping__NamedElement.initOperations(_CardinalityMapping__NamedElement);
			Fragments._CardinalityMapping__OclAny.initOperations(_CardinalityMapping__OclAny);
			Fragments._CardinalityMapping__OclElement.initOperations(_CardinalityMapping__OclElement);

			Fragments._ClassMatcher__ClassMatcher.initOperations(_ClassMatcher__ClassMatcher);
			Fragments._ClassMatcher__Matcher.initOperations(_ClassMatcher__Matcher);
			Fragments._ClassMatcher__OclAny.initOperations(_ClassMatcher__OclAny);
			Fragments._ClassMatcher__OclElement.initOperations(_ClassMatcher__OclElement);

			Fragments._ExpandableHint__ExpandableHint.initOperations(_ExpandableHint__ExpandableHint);
			Fragments._ExpandableHint__OclAny.initOperations(_ExpandableHint__OclAny);
			Fragments._ExpandableHint__OclElement.initOperations(_ExpandableHint__OclElement);

			Fragments._ExportedMappingHintGroup__ExportedMappingHintGroup.initOperations(_ExportedMappingHintGroup__ExportedMappingHintGroup);
			Fragments._ExportedMappingHintGroup__MappingHintGroupType.initOperations(_ExportedMappingHintGroup__MappingHintGroupType);
			Fragments._ExportedMappingHintGroup__NamedElement.initOperations(_ExportedMappingHintGroup__NamedElement);
			Fragments._ExportedMappingHintGroup__OclAny.initOperations(_ExportedMappingHintGroup__OclAny);
			Fragments._ExportedMappingHintGroup__OclElement.initOperations(_ExportedMappingHintGroup__OclElement);

			Fragments._ExpressionHint__ExpressionHint.initOperations(_ExpressionHint__ExpressionHint);
			Fragments._ExpressionHint__OclAny.initOperations(_ExpressionHint__OclAny);
			Fragments._ExpressionHint__OclElement.initOperations(_ExpressionHint__OclElement);

			Fragments._ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueAppender.initOperations(_ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueAppender);
			Fragments._ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueExpander.initOperations(_ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueExpander);
			Fragments._ExternalMappedAttributeValueAppender__ExternalModifiedAttributeElementType.initOperations(_ExternalMappedAttributeValueAppender__ExternalModifiedAttributeElementType);
			Fragments._ExternalMappedAttributeValueAppender__HintImporterMappingHint.initOperations(_ExternalMappedAttributeValueAppender__HintImporterMappingHint);
			Fragments._ExternalMappedAttributeValueAppender__MappedAttributeValueExpander.initOperations(_ExternalMappedAttributeValueAppender__MappedAttributeValueExpander);
			Fragments._ExternalMappedAttributeValueAppender__MappingHintBaseType.initOperations(_ExternalMappedAttributeValueAppender__MappingHintBaseType);
			Fragments._ExternalMappedAttributeValueAppender__MappingHintType.initOperations(_ExternalMappedAttributeValueAppender__MappingHintType);
			Fragments._ExternalMappedAttributeValueAppender__ModifiedAttributeElementType.initOperations(_ExternalMappedAttributeValueAppender__ModifiedAttributeElementType);
			Fragments._ExternalMappedAttributeValueAppender__NamedElement.initOperations(_ExternalMappedAttributeValueAppender__NamedElement);
			Fragments._ExternalMappedAttributeValueAppender__OclAny.initOperations(_ExternalMappedAttributeValueAppender__OclAny);
			Fragments._ExternalMappedAttributeValueAppender__OclElement.initOperations(_ExternalMappedAttributeValueAppender__OclElement);

			Fragments._ExternalMappedAttributeValueExpander__ExternalMappedAttributeValueExpander.initOperations(_ExternalMappedAttributeValueExpander__ExternalMappedAttributeValueExpander);
			Fragments._ExternalMappedAttributeValueExpander__ExternalModifiedAttributeElementType.initOperations(_ExternalMappedAttributeValueExpander__ExternalModifiedAttributeElementType);
			Fragments._ExternalMappedAttributeValueExpander__HintImporterMappingHint.initOperations(_ExternalMappedAttributeValueExpander__HintImporterMappingHint);
			Fragments._ExternalMappedAttributeValueExpander__MappedAttributeValueExpander.initOperations(_ExternalMappedAttributeValueExpander__MappedAttributeValueExpander);
			Fragments._ExternalMappedAttributeValueExpander__MappingHintBaseType.initOperations(_ExternalMappedAttributeValueExpander__MappingHintBaseType);
			Fragments._ExternalMappedAttributeValueExpander__MappingHintType.initOperations(_ExternalMappedAttributeValueExpander__MappingHintType);
			Fragments._ExternalMappedAttributeValueExpander__ModifiedAttributeElementType.initOperations(_ExternalMappedAttributeValueExpander__ModifiedAttributeElementType);
			Fragments._ExternalMappedAttributeValueExpander__NamedElement.initOperations(_ExternalMappedAttributeValueExpander__NamedElement);
			Fragments._ExternalMappedAttributeValueExpander__OclAny.initOperations(_ExternalMappedAttributeValueExpander__OclAny);
			Fragments._ExternalMappedAttributeValueExpander__OclElement.initOperations(_ExternalMappedAttributeValueExpander__OclElement);

			Fragments._ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValueExpander.initOperations(_ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValueExpander);
			Fragments._ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValuePrepender.initOperations(_ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValuePrepender);
			Fragments._ExternalMappedAttributeValuePrepender__ExternalModifiedAttributeElementType.initOperations(_ExternalMappedAttributeValuePrepender__ExternalModifiedAttributeElementType);
			Fragments._ExternalMappedAttributeValuePrepender__HintImporterMappingHint.initOperations(_ExternalMappedAttributeValuePrepender__HintImporterMappingHint);
			Fragments._ExternalMappedAttributeValuePrepender__MappedAttributeValueExpander.initOperations(_ExternalMappedAttributeValuePrepender__MappedAttributeValueExpander);
			Fragments._ExternalMappedAttributeValuePrepender__MappingHintBaseType.initOperations(_ExternalMappedAttributeValuePrepender__MappingHintBaseType);
			Fragments._ExternalMappedAttributeValuePrepender__MappingHintType.initOperations(_ExternalMappedAttributeValuePrepender__MappingHintType);
			Fragments._ExternalMappedAttributeValuePrepender__ModifiedAttributeElementType.initOperations(_ExternalMappedAttributeValuePrepender__ModifiedAttributeElementType);
			Fragments._ExternalMappedAttributeValuePrepender__NamedElement.initOperations(_ExternalMappedAttributeValuePrepender__NamedElement);
			Fragments._ExternalMappedAttributeValuePrepender__OclAny.initOperations(_ExternalMappedAttributeValuePrepender__OclAny);
			Fragments._ExternalMappedAttributeValuePrepender__OclElement.initOperations(_ExternalMappedAttributeValuePrepender__OclElement);

			Fragments._ExternalModifiedAttributeElementType__ExternalModifiedAttributeElementType.initOperations(_ExternalModifiedAttributeElementType__ExternalModifiedAttributeElementType);
			Fragments._ExternalModifiedAttributeElementType__ModifiedAttributeElementType.initOperations(_ExternalModifiedAttributeElementType__ModifiedAttributeElementType);
			Fragments._ExternalModifiedAttributeElementType__NamedElement.initOperations(_ExternalModifiedAttributeElementType__NamedElement);
			Fragments._ExternalModifiedAttributeElementType__OclAny.initOperations(_ExternalModifiedAttributeElementType__OclAny);
			Fragments._ExternalModifiedAttributeElementType__OclElement.initOperations(_ExternalModifiedAttributeElementType__OclElement);

			Fragments._FixedValue__AttributeMappingSourceInterface.initOperations(_FixedValue__AttributeMappingSourceInterface);
			Fragments._FixedValue__AttributeMatcherSourceInterface.initOperations(_FixedValue__AttributeMatcherSourceInterface);
			Fragments._FixedValue__FixedValue.initOperations(_FixedValue__FixedValue);
			Fragments._FixedValue__InstancePointerSourceInterface.initOperations(_FixedValue__InstancePointerSourceInterface);
			Fragments._FixedValue__MappingHintSourceInterface.initOperations(_FixedValue__MappingHintSourceInterface);
			Fragments._FixedValue__ModelConnectionHintSourceInterface.initOperations(_FixedValue__ModelConnectionHintSourceInterface);
			Fragments._FixedValue__NamedElement.initOperations(_FixedValue__NamedElement);
			Fragments._FixedValue__OclAny.initOperations(_FixedValue__OclAny);
			Fragments._FixedValue__OclElement.initOperations(_FixedValue__OclElement);
			Fragments._FixedValue__ValueConstraintSourceInterface.initOperations(_FixedValue__ValueConstraintSourceInterface);

			Fragments._GlobalAttribute__GlobalAttribute.initOperations(_GlobalAttribute__GlobalAttribute);
			Fragments._GlobalAttribute__NamedElement.initOperations(_GlobalAttribute__NamedElement);
			Fragments._GlobalAttribute__OclAny.initOperations(_GlobalAttribute__OclAny);
			Fragments._GlobalAttribute__OclElement.initOperations(_GlobalAttribute__OclElement);

			Fragments._GlobalAttributeImporter__AttributeMappingSourceInterface.initOperations(_GlobalAttributeImporter__AttributeMappingSourceInterface);
			Fragments._GlobalAttributeImporter__AttributeMatcherSourceInterface.initOperations(_GlobalAttributeImporter__AttributeMatcherSourceInterface);
			Fragments._GlobalAttributeImporter__GlobalAttributeImporter.initOperations(_GlobalAttributeImporter__GlobalAttributeImporter);
			Fragments._GlobalAttributeImporter__InstancePointerSourceInterface.initOperations(_GlobalAttributeImporter__InstancePointerSourceInterface);
			Fragments._GlobalAttributeImporter__MappingHintSourceInterface.initOperations(_GlobalAttributeImporter__MappingHintSourceInterface);
			Fragments._GlobalAttributeImporter__ModelConnectionHintSourceInterface.initOperations(_GlobalAttributeImporter__ModelConnectionHintSourceInterface);
			Fragments._GlobalAttributeImporter__NamedElement.initOperations(_GlobalAttributeImporter__NamedElement);
			Fragments._GlobalAttributeImporter__OclAny.initOperations(_GlobalAttributeImporter__OclAny);
			Fragments._GlobalAttributeImporter__OclElement.initOperations(_GlobalAttributeImporter__OclElement);
			Fragments._GlobalAttributeImporter__ValueConstraintSourceInterface.initOperations(_GlobalAttributeImporter__ValueConstraintSourceInterface);

			Fragments._GlobalModifiedAttributeElementType__GlobalModifiedAttributeElementType.initOperations(_GlobalModifiedAttributeElementType__GlobalModifiedAttributeElementType);
			Fragments._GlobalModifiedAttributeElementType__ModifiedAttributeElementType.initOperations(_GlobalModifiedAttributeElementType__ModifiedAttributeElementType);
			Fragments._GlobalModifiedAttributeElementType__NamedElement.initOperations(_GlobalModifiedAttributeElementType__NamedElement);
			Fragments._GlobalModifiedAttributeElementType__OclAny.initOperations(_GlobalModifiedAttributeElementType__OclAny);
			Fragments._GlobalModifiedAttributeElementType__OclElement.initOperations(_GlobalModifiedAttributeElementType__OclElement);

			Fragments._HintImporterMappingHint__HintImporterMappingHint.initOperations(_HintImporterMappingHint__HintImporterMappingHint);
			Fragments._HintImporterMappingHint__MappingHintBaseType.initOperations(_HintImporterMappingHint__MappingHintBaseType);
			Fragments._HintImporterMappingHint__MappingHintType.initOperations(_HintImporterMappingHint__MappingHintType);
			Fragments._HintImporterMappingHint__NamedElement.initOperations(_HintImporterMappingHint__NamedElement);
			Fragments._HintImporterMappingHint__OclAny.initOperations(_HintImporterMappingHint__OclAny);
			Fragments._HintImporterMappingHint__OclElement.initOperations(_HintImporterMappingHint__OclElement);

			Fragments._InstantiableMappingHintGroup__ConditionalElement.initOperations(_InstantiableMappingHintGroup__ConditionalElement);
			Fragments._InstantiableMappingHintGroup__DeactivatableElement.initOperations(_InstantiableMappingHintGroup__DeactivatableElement);
			Fragments._InstantiableMappingHintGroup__InstantiableMappingHintGroup.initOperations(_InstantiableMappingHintGroup__InstantiableMappingHintGroup);
			Fragments._InstantiableMappingHintGroup__NamedElement.initOperations(_InstantiableMappingHintGroup__NamedElement);
			Fragments._InstantiableMappingHintGroup__OclAny.initOperations(_InstantiableMappingHintGroup__OclAny);
			Fragments._InstantiableMappingHintGroup__OclElement.initOperations(_InstantiableMappingHintGroup__OclElement);

			Fragments._LocalMappedAttributeValueExpander__HintImporterMappingHint.initOperations(_LocalMappedAttributeValueExpander__HintImporterMappingHint);
			Fragments._LocalMappedAttributeValueExpander__LocalMappedAttributeValueExpander.initOperations(_LocalMappedAttributeValueExpander__LocalMappedAttributeValueExpander);
			Fragments._LocalMappedAttributeValueExpander__LocalModifiedAttributeElementType.initOperations(_LocalMappedAttributeValueExpander__LocalModifiedAttributeElementType);
			Fragments._LocalMappedAttributeValueExpander__MappedAttributeValueExpander.initOperations(_LocalMappedAttributeValueExpander__MappedAttributeValueExpander);
			Fragments._LocalMappedAttributeValueExpander__MappingHintBaseType.initOperations(_LocalMappedAttributeValueExpander__MappingHintBaseType);
			Fragments._LocalMappedAttributeValueExpander__MappingHintType.initOperations(_LocalMappedAttributeValueExpander__MappingHintType);
			Fragments._LocalMappedAttributeValueExpander__ModifiedAttributeElementType.initOperations(_LocalMappedAttributeValueExpander__ModifiedAttributeElementType);
			Fragments._LocalMappedAttributeValueExpander__NamedElement.initOperations(_LocalMappedAttributeValueExpander__NamedElement);
			Fragments._LocalMappedAttributeValueExpander__OclAny.initOperations(_LocalMappedAttributeValueExpander__OclAny);
			Fragments._LocalMappedAttributeValueExpander__OclElement.initOperations(_LocalMappedAttributeValueExpander__OclElement);

			Fragments._LocalModifiedAttributeElementType__LocalModifiedAttributeElementType.initOperations(_LocalModifiedAttributeElementType__LocalModifiedAttributeElementType);
			Fragments._LocalModifiedAttributeElementType__ModifiedAttributeElementType.initOperations(_LocalModifiedAttributeElementType__ModifiedAttributeElementType);
			Fragments._LocalModifiedAttributeElementType__NamedElement.initOperations(_LocalModifiedAttributeElementType__NamedElement);
			Fragments._LocalModifiedAttributeElementType__OclAny.initOperations(_LocalModifiedAttributeElementType__OclAny);
			Fragments._LocalModifiedAttributeElementType__OclElement.initOperations(_LocalModifiedAttributeElementType__OclElement);

			Fragments._MappedAttributeValueAppender__HintImporterMappingHint.initOperations(_MappedAttributeValueAppender__HintImporterMappingHint);
			Fragments._MappedAttributeValueAppender__LocalMappedAttributeValueExpander.initOperations(_MappedAttributeValueAppender__LocalMappedAttributeValueExpander);
			Fragments._MappedAttributeValueAppender__LocalModifiedAttributeElementType.initOperations(_MappedAttributeValueAppender__LocalModifiedAttributeElementType);
			Fragments._MappedAttributeValueAppender__MappedAttributeValueAppender.initOperations(_MappedAttributeValueAppender__MappedAttributeValueAppender);
			Fragments._MappedAttributeValueAppender__MappedAttributeValueExpander.initOperations(_MappedAttributeValueAppender__MappedAttributeValueExpander);
			Fragments._MappedAttributeValueAppender__MappingHintBaseType.initOperations(_MappedAttributeValueAppender__MappingHintBaseType);
			Fragments._MappedAttributeValueAppender__MappingHintType.initOperations(_MappedAttributeValueAppender__MappingHintType);
			Fragments._MappedAttributeValueAppender__ModifiedAttributeElementType.initOperations(_MappedAttributeValueAppender__ModifiedAttributeElementType);
			Fragments._MappedAttributeValueAppender__NamedElement.initOperations(_MappedAttributeValueAppender__NamedElement);
			Fragments._MappedAttributeValueAppender__OclAny.initOperations(_MappedAttributeValueAppender__OclAny);
			Fragments._MappedAttributeValueAppender__OclElement.initOperations(_MappedAttributeValueAppender__OclElement);

			Fragments._MappedAttributeValueExpander__HintImporterMappingHint.initOperations(_MappedAttributeValueExpander__HintImporterMappingHint);
			Fragments._MappedAttributeValueExpander__MappedAttributeValueExpander.initOperations(_MappedAttributeValueExpander__MappedAttributeValueExpander);
			Fragments._MappedAttributeValueExpander__MappingHintBaseType.initOperations(_MappedAttributeValueExpander__MappingHintBaseType);
			Fragments._MappedAttributeValueExpander__MappingHintType.initOperations(_MappedAttributeValueExpander__MappingHintType);
			Fragments._MappedAttributeValueExpander__NamedElement.initOperations(_MappedAttributeValueExpander__NamedElement);
			Fragments._MappedAttributeValueExpander__OclAny.initOperations(_MappedAttributeValueExpander__OclAny);
			Fragments._MappedAttributeValueExpander__OclElement.initOperations(_MappedAttributeValueExpander__OclElement);

			Fragments._MappedAttributeValuePrepender__HintImporterMappingHint.initOperations(_MappedAttributeValuePrepender__HintImporterMappingHint);
			Fragments._MappedAttributeValuePrepender__LocalMappedAttributeValueExpander.initOperations(_MappedAttributeValuePrepender__LocalMappedAttributeValueExpander);
			Fragments._MappedAttributeValuePrepender__LocalModifiedAttributeElementType.initOperations(_MappedAttributeValuePrepender__LocalModifiedAttributeElementType);
			Fragments._MappedAttributeValuePrepender__MappedAttributeValueExpander.initOperations(_MappedAttributeValuePrepender__MappedAttributeValueExpander);
			Fragments._MappedAttributeValuePrepender__MappedAttributeValuePrepender.initOperations(_MappedAttributeValuePrepender__MappedAttributeValuePrepender);
			Fragments._MappedAttributeValuePrepender__MappingHintBaseType.initOperations(_MappedAttributeValuePrepender__MappingHintBaseType);
			Fragments._MappedAttributeValuePrepender__MappingHintType.initOperations(_MappedAttributeValuePrepender__MappingHintType);
			Fragments._MappedAttributeValuePrepender__ModifiedAttributeElementType.initOperations(_MappedAttributeValuePrepender__ModifiedAttributeElementType);
			Fragments._MappedAttributeValuePrepender__NamedElement.initOperations(_MappedAttributeValuePrepender__NamedElement);
			Fragments._MappedAttributeValuePrepender__OclAny.initOperations(_MappedAttributeValuePrepender__OclAny);
			Fragments._MappedAttributeValuePrepender__OclElement.initOperations(_MappedAttributeValuePrepender__OclElement);

			Fragments._Mapping__ConditionalElement.initOperations(_Mapping__ConditionalElement);
			Fragments._Mapping__DeactivatableElement.initOperations(_Mapping__DeactivatableElement);
			Fragments._Mapping__Mapping.initOperations(_Mapping__Mapping);
			Fragments._Mapping__MappingType.initOperations(_Mapping__MappingType);
			Fragments._Mapping__NamedElement.initOperations(_Mapping__NamedElement);
			Fragments._Mapping__OclAny.initOperations(_Mapping__OclAny);
			Fragments._Mapping__OclElement.initOperations(_Mapping__OclElement);

			Fragments._MappingHint__ConditionalElement.initOperations(_MappingHint__ConditionalElement);
			Fragments._MappingHint__MappingHint.initOperations(_MappingHint__MappingHint);
			Fragments._MappingHint__MappingHintBaseType.initOperations(_MappingHint__MappingHintBaseType);
			Fragments._MappingHint__MappingHintType.initOperations(_MappingHint__MappingHintType);
			Fragments._MappingHint__NamedElement.initOperations(_MappingHint__NamedElement);
			Fragments._MappingHint__OclAny.initOperations(_MappingHint__OclAny);
			Fragments._MappingHint__OclElement.initOperations(_MappingHint__OclElement);

			Fragments._MappingHintBaseType__MappingHintBaseType.initOperations(_MappingHintBaseType__MappingHintBaseType);
			Fragments._MappingHintBaseType__NamedElement.initOperations(_MappingHintBaseType__NamedElement);
			Fragments._MappingHintBaseType__OclAny.initOperations(_MappingHintBaseType__OclAny);
			Fragments._MappingHintBaseType__OclElement.initOperations(_MappingHintBaseType__OclElement);

			Fragments._MappingHintGroup__ConditionalElement.initOperations(_MappingHintGroup__ConditionalElement);
			Fragments._MappingHintGroup__DeactivatableElement.initOperations(_MappingHintGroup__DeactivatableElement);
			Fragments._MappingHintGroup__InstantiableMappingHintGroup.initOperations(_MappingHintGroup__InstantiableMappingHintGroup);
			Fragments._MappingHintGroup__MappingHintGroup.initOperations(_MappingHintGroup__MappingHintGroup);
			Fragments._MappingHintGroup__MappingHintGroupType.initOperations(_MappingHintGroup__MappingHintGroupType);
			Fragments._MappingHintGroup__NamedElement.initOperations(_MappingHintGroup__NamedElement);
			Fragments._MappingHintGroup__OclAny.initOperations(_MappingHintGroup__OclAny);
			Fragments._MappingHintGroup__OclElement.initOperations(_MappingHintGroup__OclElement);

			Fragments._MappingHintGroupImporter__ConditionalElement.initOperations(_MappingHintGroupImporter__ConditionalElement);
			Fragments._MappingHintGroupImporter__DeactivatableElement.initOperations(_MappingHintGroupImporter__DeactivatableElement);
			Fragments._MappingHintGroupImporter__InstantiableMappingHintGroup.initOperations(_MappingHintGroupImporter__InstantiableMappingHintGroup);
			Fragments._MappingHintGroupImporter__MappingHintGroupImporter.initOperations(_MappingHintGroupImporter__MappingHintGroupImporter);
			Fragments._MappingHintGroupImporter__NamedElement.initOperations(_MappingHintGroupImporter__NamedElement);
			Fragments._MappingHintGroupImporter__OclAny.initOperations(_MappingHintGroupImporter__OclAny);
			Fragments._MappingHintGroupImporter__OclElement.initOperations(_MappingHintGroupImporter__OclElement);

			Fragments._MappingHintGroupType__MappingHintGroupType.initOperations(_MappingHintGroupType__MappingHintGroupType);
			Fragments._MappingHintGroupType__NamedElement.initOperations(_MappingHintGroupType__NamedElement);
			Fragments._MappingHintGroupType__OclAny.initOperations(_MappingHintGroupType__OclAny);
			Fragments._MappingHintGroupType__OclElement.initOperations(_MappingHintGroupType__OclElement);

			Fragments._MappingHintSourceInterface__MappingHintSourceInterface.initOperations(_MappingHintSourceInterface__MappingHintSourceInterface);
			Fragments._MappingHintSourceInterface__NamedElement.initOperations(_MappingHintSourceInterface__NamedElement);
			Fragments._MappingHintSourceInterface__OclAny.initOperations(_MappingHintSourceInterface__OclAny);
			Fragments._MappingHintSourceInterface__OclElement.initOperations(_MappingHintSourceInterface__OclElement);

			Fragments._MappingHintType__MappingHintBaseType.initOperations(_MappingHintType__MappingHintBaseType);
			Fragments._MappingHintType__MappingHintType.initOperations(_MappingHintType__MappingHintType);
			Fragments._MappingHintType__NamedElement.initOperations(_MappingHintType__NamedElement);
			Fragments._MappingHintType__OclAny.initOperations(_MappingHintType__OclAny);
			Fragments._MappingHintType__OclElement.initOperations(_MappingHintType__OclElement);

			Fragments._MappingType__DeactivatableElement.initOperations(_MappingType__DeactivatableElement);
			Fragments._MappingType__MappingType.initOperations(_MappingType__MappingType);
			Fragments._MappingType__NamedElement.initOperations(_MappingType__NamedElement);
			Fragments._MappingType__OclAny.initOperations(_MappingType__OclAny);
			Fragments._MappingType__OclElement.initOperations(_MappingType__OclElement);

			Fragments._MatchToLowerCaseConverter__MatchToLowerCaseConverter.initOperations(_MatchToLowerCaseConverter__MatchToLowerCaseConverter);
			Fragments._MatchToLowerCaseConverter__NamedElement.initOperations(_MatchToLowerCaseConverter__NamedElement);
			Fragments._MatchToLowerCaseConverter__OclAny.initOperations(_MatchToLowerCaseConverter__OclAny);
			Fragments._MatchToLowerCaseConverter__OclElement.initOperations(_MatchToLowerCaseConverter__OclElement);
			Fragments._MatchToLowerCaseConverter__ValueModifier.initOperations(_MatchToLowerCaseConverter__ValueModifier);

			Fragments._MatchToUpperCaseConverter__MatchToUpperCaseConverter.initOperations(_MatchToUpperCaseConverter__MatchToUpperCaseConverter);
			Fragments._MatchToUpperCaseConverter__NamedElement.initOperations(_MatchToUpperCaseConverter__NamedElement);
			Fragments._MatchToUpperCaseConverter__OclAny.initOperations(_MatchToUpperCaseConverter__OclAny);
			Fragments._MatchToUpperCaseConverter__OclElement.initOperations(_MatchToUpperCaseConverter__OclElement);
			Fragments._MatchToUpperCaseConverter__ValueModifier.initOperations(_MatchToUpperCaseConverter__ValueModifier);

			Fragments._Matcher__Matcher.initOperations(_Matcher__Matcher);
			Fragments._Matcher__OclAny.initOperations(_Matcher__OclAny);
			Fragments._Matcher__OclElement.initOperations(_Matcher__OclElement);

			Fragments._ModelConnectionHint__MappingHintBaseType.initOperations(_ModelConnectionHint__MappingHintBaseType);
			Fragments._ModelConnectionHint__ModelConnectionHint.initOperations(_ModelConnectionHint__ModelConnectionHint);
			Fragments._ModelConnectionHint__NamedElement.initOperations(_ModelConnectionHint__NamedElement);
			Fragments._ModelConnectionHint__OclAny.initOperations(_ModelConnectionHint__OclAny);
			Fragments._ModelConnectionHint__OclElement.initOperations(_ModelConnectionHint__OclElement);

			Fragments._ModelConnectionHintExternalSourceElement__ExternalModifiedAttributeElementType.initOperations(_ModelConnectionHintExternalSourceElement__ExternalModifiedAttributeElementType);
			Fragments._ModelConnectionHintExternalSourceElement__MappingHintSourceInterface.initOperations(_ModelConnectionHintExternalSourceElement__MappingHintSourceInterface);
			Fragments._ModelConnectionHintExternalSourceElement__ModelConnectionHintExternalSourceElement.initOperations(_ModelConnectionHintExternalSourceElement__ModelConnectionHintExternalSourceElement);
			Fragments._ModelConnectionHintExternalSourceElement__ModelConnectionHintSourceInterface.initOperations(_ModelConnectionHintExternalSourceElement__ModelConnectionHintSourceInterface);
			Fragments._ModelConnectionHintExternalSourceElement__ModifiedAttributeElementType.initOperations(_ModelConnectionHintExternalSourceElement__ModifiedAttributeElementType);
			Fragments._ModelConnectionHintExternalSourceElement__NamedElement.initOperations(_ModelConnectionHintExternalSourceElement__NamedElement);
			Fragments._ModelConnectionHintExternalSourceElement__OclAny.initOperations(_ModelConnectionHintExternalSourceElement__OclAny);
			Fragments._ModelConnectionHintExternalSourceElement__OclElement.initOperations(_ModelConnectionHintExternalSourceElement__OclElement);

			Fragments._ModelConnectionHintGlobalSourceElement__GlobalModifiedAttributeElementType.initOperations(_ModelConnectionHintGlobalSourceElement__GlobalModifiedAttributeElementType);
			Fragments._ModelConnectionHintGlobalSourceElement__MappingHintSourceInterface.initOperations(_ModelConnectionHintGlobalSourceElement__MappingHintSourceInterface);
			Fragments._ModelConnectionHintGlobalSourceElement__ModelConnectionHintGlobalSourceElement.initOperations(_ModelConnectionHintGlobalSourceElement__ModelConnectionHintGlobalSourceElement);
			Fragments._ModelConnectionHintGlobalSourceElement__ModelConnectionHintSourceInterface.initOperations(_ModelConnectionHintGlobalSourceElement__ModelConnectionHintSourceInterface);
			Fragments._ModelConnectionHintGlobalSourceElement__ModifiedAttributeElementType.initOperations(_ModelConnectionHintGlobalSourceElement__ModifiedAttributeElementType);
			Fragments._ModelConnectionHintGlobalSourceElement__NamedElement.initOperations(_ModelConnectionHintGlobalSourceElement__NamedElement);
			Fragments._ModelConnectionHintGlobalSourceElement__OclAny.initOperations(_ModelConnectionHintGlobalSourceElement__OclAny);
			Fragments._ModelConnectionHintGlobalSourceElement__OclElement.initOperations(_ModelConnectionHintGlobalSourceElement__OclElement);

			Fragments._ModelConnectionHintSourceElement__LocalModifiedAttributeElementType.initOperations(_ModelConnectionHintSourceElement__LocalModifiedAttributeElementType);
			Fragments._ModelConnectionHintSourceElement__MappingHintSourceInterface.initOperations(_ModelConnectionHintSourceElement__MappingHintSourceInterface);
			Fragments._ModelConnectionHintSourceElement__ModelConnectionHintSourceElement.initOperations(_ModelConnectionHintSourceElement__ModelConnectionHintSourceElement);
			Fragments._ModelConnectionHintSourceElement__ModelConnectionHintSourceInterface.initOperations(_ModelConnectionHintSourceElement__ModelConnectionHintSourceInterface);
			Fragments._ModelConnectionHintSourceElement__ModifiedAttributeElementType.initOperations(_ModelConnectionHintSourceElement__ModifiedAttributeElementType);
			Fragments._ModelConnectionHintSourceElement__NamedElement.initOperations(_ModelConnectionHintSourceElement__NamedElement);
			Fragments._ModelConnectionHintSourceElement__OclAny.initOperations(_ModelConnectionHintSourceElement__OclAny);
			Fragments._ModelConnectionHintSourceElement__OclElement.initOperations(_ModelConnectionHintSourceElement__OclElement);

			Fragments._ModelConnectionHintSourceInterface__MappingHintSourceInterface.initOperations(_ModelConnectionHintSourceInterface__MappingHintSourceInterface);
			Fragments._ModelConnectionHintSourceInterface__ModelConnectionHintSourceInterface.initOperations(_ModelConnectionHintSourceInterface__ModelConnectionHintSourceInterface);
			Fragments._ModelConnectionHintSourceInterface__NamedElement.initOperations(_ModelConnectionHintSourceInterface__NamedElement);
			Fragments._ModelConnectionHintSourceInterface__OclAny.initOperations(_ModelConnectionHintSourceInterface__OclAny);
			Fragments._ModelConnectionHintSourceInterface__OclElement.initOperations(_ModelConnectionHintSourceInterface__OclElement);

			Fragments._ModelConnectionHintTargetAttribute__ModelConnectionHintTargetAttribute.initOperations(_ModelConnectionHintTargetAttribute__ModelConnectionHintTargetAttribute);
			Fragments._ModelConnectionHintTargetAttribute__ModifiedAttributeElementType.initOperations(_ModelConnectionHintTargetAttribute__ModifiedAttributeElementType);
			Fragments._ModelConnectionHintTargetAttribute__NamedElement.initOperations(_ModelConnectionHintTargetAttribute__NamedElement);
			Fragments._ModelConnectionHintTargetAttribute__OclAny.initOperations(_ModelConnectionHintTargetAttribute__OclAny);
			Fragments._ModelConnectionHintTargetAttribute__OclElement.initOperations(_ModelConnectionHintTargetAttribute__OclElement);

			Fragments._ModifiableHint__ModifiableHint.initOperations(_ModifiableHint__ModifiableHint);
			Fragments._ModifiableHint__OclAny.initOperations(_ModifiableHint__OclAny);
			Fragments._ModifiableHint__OclElement.initOperations(_ModifiableHint__OclElement);

			Fragments._ModifiedAttributeElementType__ModifiedAttributeElementType.initOperations(_ModifiedAttributeElementType__ModifiedAttributeElementType);
			Fragments._ModifiedAttributeElementType__NamedElement.initOperations(_ModifiedAttributeElementType__NamedElement);
			Fragments._ModifiedAttributeElementType__OclAny.initOperations(_ModifiedAttributeElementType__OclAny);
			Fragments._ModifiedAttributeElementType__OclElement.initOperations(_ModifiedAttributeElementType__OclElement);

			Fragments._ReferenceTargetSelector__ConditionalElement.initOperations(_ReferenceTargetSelector__ConditionalElement);
			Fragments._ReferenceTargetSelector__MappingHint.initOperations(_ReferenceTargetSelector__MappingHint);
			Fragments._ReferenceTargetSelector__MappingHintBaseType.initOperations(_ReferenceTargetSelector__MappingHintBaseType);
			Fragments._ReferenceTargetSelector__MappingHintType.initOperations(_ReferenceTargetSelector__MappingHintType);
			Fragments._ReferenceTargetSelector__NamedElement.initOperations(_ReferenceTargetSelector__NamedElement);
			Fragments._ReferenceTargetSelector__OclAny.initOperations(_ReferenceTargetSelector__OclAny);
			Fragments._ReferenceTargetSelector__OclElement.initOperations(_ReferenceTargetSelector__OclElement);
			Fragments._ReferenceTargetSelector__ReferenceTargetSelector.initOperations(_ReferenceTargetSelector__ReferenceTargetSelector);

			Fragments._StringAppender__NamedElement.initOperations(_StringAppender__NamedElement);
			Fragments._StringAppender__OclAny.initOperations(_StringAppender__OclAny);
			Fragments._StringAppender__OclElement.initOperations(_StringAppender__OclElement);
			Fragments._StringAppender__StringAppender.initOperations(_StringAppender__StringAppender);
			Fragments._StringAppender__ValueModifier.initOperations(_StringAppender__ValueModifier);

			Fragments._StringPrepender__NamedElement.initOperations(_StringPrepender__NamedElement);
			Fragments._StringPrepender__OclAny.initOperations(_StringPrepender__OclAny);
			Fragments._StringPrepender__OclElement.initOperations(_StringPrepender__OclElement);
			Fragments._StringPrepender__StringPrepender.initOperations(_StringPrepender__StringPrepender);
			Fragments._StringPrepender__ValueModifier.initOperations(_StringPrepender__ValueModifier);

			Fragments._SubstringReplacer__NamedElement.initOperations(_SubstringReplacer__NamedElement);
			Fragments._SubstringReplacer__OclAny.initOperations(_SubstringReplacer__OclAny);
			Fragments._SubstringReplacer__OclElement.initOperations(_SubstringReplacer__OclElement);
			Fragments._SubstringReplacer__SubstringReplacer.initOperations(_SubstringReplacer__SubstringReplacer);
			Fragments._SubstringReplacer__ValueModifier.initOperations(_SubstringReplacer__ValueModifier);

			Fragments._UniqueNumberAppender__NamedElement.initOperations(_UniqueNumberAppender__NamedElement);
			Fragments._UniqueNumberAppender__OclAny.initOperations(_UniqueNumberAppender__OclAny);
			Fragments._UniqueNumberAppender__OclElement.initOperations(_UniqueNumberAppender__OclElement);
			Fragments._UniqueNumberAppender__UniqueNumberAppender.initOperations(_UniqueNumberAppender__UniqueNumberAppender);
			Fragments._UniqueNumberAppender__ValueModifier.initOperations(_UniqueNumberAppender__ValueModifier);

			Fragments._ValueModifier__NamedElement.initOperations(_ValueModifier__NamedElement);
			Fragments._ValueModifier__OclAny.initOperations(_ValueModifier__OclAny);
			Fragments._ValueModifier__OclElement.initOperations(_ValueModifier__OclElement);
			Fragments._ValueModifier__ValueModifier.initOperations(_ValueModifier__ValueModifier);

			Fragments._ValueModifierSet__NamedElement.initOperations(_ValueModifierSet__NamedElement);
			Fragments._ValueModifierSet__OclAny.initOperations(_ValueModifierSet__OclAny);
			Fragments._ValueModifierSet__OclElement.initOperations(_ValueModifierSet__OclElement);
			Fragments._ValueModifierSet__ValueModifierSet.initOperations(_ValueModifierSet__ValueModifierSet);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::FragmentOperations and all preceding sub-packages.
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

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMapping = {
			MappingTables.Properties._ExpressionHint__expression,
			MappingTables.Properties._ModifiableHint__resultModifier,
			MappingTables.Properties._AttributeMapping__sourceElements,
			MappingTables.Properties._AttributeMapping__target,
			MappingTables.Properties._ExpandableHint__MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints,
			MappingTables.Properties._MappingHint__MappingHintGroupType__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMappingExternalSourceElement = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._AttributeMappingSourceInterface__AttributeMapping__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMappingGlobalSourceElement = {
			MappingTables.Properties._GlobalModifiedAttributeElementType__instanceSelector,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._AttributeMappingSourceInterface__AttributeMapping__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMappingSourceElement = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._AttributeMappingSourceInterface__AttributeMapping__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMappingSourceInterface = {
			MappingTables.Properties._AttributeMappingSourceInterface__AttributeMapping__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMatcher = {
			MappingTables.Properties._ExpressionHint__expression,
			MappingTables.Properties._ModifiableHint__resultModifier,
			MappingTables.Properties._AttributeMatcher__sourceElements,
			MappingTables.Properties._AttributeMatcher__target,
			MappingTables.Properties._ExpandableHint__MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._Matcher__ReferenceTargetSelector__matcher
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMatcherExternalSourceElement = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._AttributeMatcherSourceInterface__AttributeMatcher__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMatcherGlobalSourceElement = {
			MappingTables.Properties._GlobalModifiedAttributeElementType__instanceSelector,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._AttributeMatcherSourceInterface__AttributeMatcher__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMatcherSourceElement = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._AttributeMatcherSourceInterface__AttributeMatcher__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _AttributeMatcherSourceInterface = {
			MappingTables.Properties._AttributeMatcherSourceInterface__AttributeMatcher__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _CardinalityMapping = {
			MappingTables.Properties._CardinalityMapping__source,
			MappingTables.Properties._CardinalityMapping__target,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints,
			MappingTables.Properties._MappingHint__MappingHintGroupType__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ClassMatcher = {
			MappingTables.Properties._ClassMatcher__targetClass,
			MappingTables.Properties._Matcher__ReferenceTargetSelector__matcher
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExpandableHint = {
			MappingTables.Properties._ExpandableHint__MappedAttributeValueExpander__hintsToExpand
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExportedMappingHintGroup = {
			MappingTables.Properties._MappingHintGroupType__extend,
			MappingTables.Properties._MappingHintGroupType__mappingHints,
			MappingTables.Properties._MappingHintGroupType__targetSection,
			MappingTables.Properties._MappingHintGroupType__Mapping__mappingHintGroups,
			MappingTables.Properties._ExportedMappingHintGroup__MappingHintGroupImporter__hintGroup,
			MappingTables.Properties._MappingHintGroupType__MappingHintGroupType__extend
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExpressionHint = {
			MappingTables.Properties._ExpressionHint__expression
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExternalMappedAttributeValueAppender = {
			MappingTables.Properties._MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExternalMappedAttributeValueExpander = {
			MappingTables.Properties._MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExternalMappedAttributeValuePrepender = {
			MappingTables.Properties._MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ExternalModifiedAttributeElementType = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _FixedValue = {
			MappingTables.Properties._FixedValue__value,
			MappingTables.Properties._AttributeMappingSourceInterface__AttributeMapping__sourceElements,
			MappingTables.Properties._AttributeMatcherSourceInterface__AttributeMatcher__sourceElements,
			MappingTables.Properties._ModelConnectionHintSourceInterface__ModelConnectionHint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _GlobalAttribute = {
			MappingTables.Properties._GlobalAttribute__modifier,
			MappingTables.Properties._GlobalAttribute__source,
			MappingTables.Properties._GlobalAttribute__GlobalAttributeImporter__globalAttribute,
			MappingTables.Properties._GlobalAttribute__Mapping__globalVariables
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _GlobalAttributeImporter = {
			MappingTables.Properties._GlobalAttributeImporter__globalAttribute,
			MappingTables.Properties._AttributeMappingSourceInterface__AttributeMapping__sourceElements,
			MappingTables.Properties._AttributeMatcherSourceInterface__AttributeMatcher__sourceElements,
			MappingTables.Properties._ModelConnectionHintSourceInterface__ModelConnectionHint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _GlobalModifiedAttributeElementType = {
			MappingTables.Properties._GlobalModifiedAttributeElementType__instanceSelector,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _HintImporterMappingHint = {
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _InstantiableMappingHintGroup = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _LocalMappedAttributeValueExpander = {
			MappingTables.Properties._MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _LocalModifiedAttributeElementType = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappedAttributeValueAppender = {
			MappingTables.Properties._MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappedAttributeValueExpander = {
			MappingTables.Properties._MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappedAttributeValuePrepender = {
			MappingTables.Properties._MappedAttributeValueExpander__hintsToExpand,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Mapping = {
			MappingTables.Properties._Mapping__abstract,
			MappingTables.Properties._Mapping__globalVariables,
			MappingTables.Properties._Mapping__importedMappingHintGroups,
			MappingTables.Properties._Mapping__mappingHintGroups,
			MappingTables.Properties._MappingType__sourceSection
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingHint = {
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints,
			MappingTables.Properties._MappingHint__MappingHintGroupType__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingHintBaseType = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingHintGroup = {
			MappingTables.Properties._MappingHintGroupType__extend,
			MappingTables.Properties._MappingHintGroupType__mappingHints,
			MappingTables.Properties._MappingHintGroup__modelConnectionMatcher,
			MappingTables.Properties._MappingHintGroupType__targetSection,
			MappingTables.Properties._MappingHintGroupType__Mapping__mappingHintGroups,
			MappingTables.Properties._MappingHintGroupType__MappingHintGroupType__extend
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingHintGroupImporter = {
			MappingTables.Properties._MappingHintGroupImporter__container,
			MappingTables.Properties._MappingHintGroupImporter__hintGroup,
			MappingTables.Properties._MappingHintGroupImporter__mappingHints,
			MappingTables.Properties._MappingHintGroupImporter__Mapping__importedMappingHintGroups
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingHintGroupType = {
			MappingTables.Properties._MappingHintGroupType__extend,
			MappingTables.Properties._MappingHintGroupType__mappingHints,
			MappingTables.Properties._MappingHintGroupType__targetSection,
			MappingTables.Properties._MappingHintGroupType__Mapping__mappingHintGroups,
			MappingTables.Properties._MappingHintGroupType__MappingHintGroupType__extend
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingHintSourceInterface = {};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingHintType = {
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MappingType = {
			MappingTables.Properties._MappingType__sourceSection
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MatchToLowerCaseConverter = {
			MappingTables.Properties._MatchToLowerCaseConverter__regex,
			MappingTables.Properties._ValueModifier__ValueModifierSet__modifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _MatchToUpperCaseConverter = {
			MappingTables.Properties._MatchToUpperCaseConverter__regex,
			MappingTables.Properties._ValueModifier__ValueModifierSet__modifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _Matcher = {
			MappingTables.Properties._Matcher__ReferenceTargetSelector__matcher
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModelConnectionHint = {
			MappingTables.Properties._ModelConnectionHint__sourceElements,
			MappingTables.Properties._ModelConnectionHint__targetAttributes,
			MappingTables.Properties._ModelConnectionHint__MappingHintGroup__modelConnectionMatcher
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModelConnectionHintExternalSourceElement = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._ModelConnectionHintSourceInterface__ModelConnectionHint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModelConnectionHintGlobalSourceElement = {
			MappingTables.Properties._GlobalModifiedAttributeElementType__instanceSelector,
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._ModelConnectionHintSourceInterface__ModelConnectionHint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModelConnectionHintSourceElement = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._ModelConnectionHintSourceInterface__ModelConnectionHint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModelConnectionHintSourceInterface = {
			MappingTables.Properties._ModelConnectionHintSourceInterface__ModelConnectionHint__sourceElements
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModelConnectionHintTargetAttribute = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source,
			MappingTables.Properties._ModelConnectionHintTargetAttribute__ModelConnectionHint__targetAttributes
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModifiableHint = {
			MappingTables.Properties._ModifiableHint__resultModifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ModifiedAttributeElementType = {
			MappingTables.Properties._ModifiedAttributeElementType__modifier,
			MappingTables.Properties._ModifiedAttributeElementType__source
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ReferenceTargetSelector = {
			MappingTables.Properties._ReferenceTargetSelector__affectedReference,
			MappingTables.Properties._ReferenceTargetSelector__matcher,
			MappingTables.Properties._MappingHintType__MappingHintGroupImporter__mappingHints,
			MappingTables.Properties._MappingHint__MappingHintGroupType__mappingHints
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _StringAppender = {
			MappingTables.Properties._StringAppender__string,
			MappingTables.Properties._ValueModifier__ValueModifierSet__modifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _StringPrepender = {
			MappingTables.Properties._StringPrepender__string,
			MappingTables.Properties._ValueModifier__ValueModifierSet__modifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _SubstringReplacer = {
			MappingTables.Properties._SubstringReplacer__regex,
			MappingTables.Properties._SubstringReplacer__replacement,
			MappingTables.Properties._ValueModifier__ValueModifierSet__modifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _UniqueNumberAppender = {
			MappingTables.Properties._ValueModifier__ValueModifierSet__modifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ValueModifier = {
			MappingTables.Properties._ValueModifier__ValueModifierSet__modifier
		};

		private static final /*@NonNull*/ ExecutorProperty /*@NonNull*/ [] _ValueModifierSet = {
			MappingTables.Properties._ValueModifierSet__modifier,
			MappingTables.Properties._ValueModifierSet__GlobalAttribute__modifier,
			MappingTables.Properties._ValueModifierSet__ModifiableHint__resultModifier,
			MappingTables.Properties._ValueModifierSet__ModifiedAttributeElementType__modifier
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AttributeMapping__AttributeMapping.initProperties(_AttributeMapping);
			Fragments._AttributeMappingExternalSourceElement__AttributeMappingExternalSourceElement.initProperties(_AttributeMappingExternalSourceElement);
			Fragments._AttributeMappingGlobalSourceElement__AttributeMappingGlobalSourceElement.initProperties(_AttributeMappingGlobalSourceElement);
			Fragments._AttributeMappingSourceElement__AttributeMappingSourceElement.initProperties(_AttributeMappingSourceElement);
			Fragments._AttributeMappingSourceInterface__AttributeMappingSourceInterface.initProperties(_AttributeMappingSourceInterface);
			Fragments._AttributeMatcher__AttributeMatcher.initProperties(_AttributeMatcher);
			Fragments._AttributeMatcherExternalSourceElement__AttributeMatcherExternalSourceElement.initProperties(_AttributeMatcherExternalSourceElement);
			Fragments._AttributeMatcherGlobalSourceElement__AttributeMatcherGlobalSourceElement.initProperties(_AttributeMatcherGlobalSourceElement);
			Fragments._AttributeMatcherSourceElement__AttributeMatcherSourceElement.initProperties(_AttributeMatcherSourceElement);
			Fragments._AttributeMatcherSourceInterface__AttributeMatcherSourceInterface.initProperties(_AttributeMatcherSourceInterface);
			Fragments._CardinalityMapping__CardinalityMapping.initProperties(_CardinalityMapping);
			Fragments._ClassMatcher__ClassMatcher.initProperties(_ClassMatcher);
			Fragments._ExpandableHint__ExpandableHint.initProperties(_ExpandableHint);
			Fragments._ExportedMappingHintGroup__ExportedMappingHintGroup.initProperties(_ExportedMappingHintGroup);
			Fragments._ExpressionHint__ExpressionHint.initProperties(_ExpressionHint);
			Fragments._ExternalMappedAttributeValueAppender__ExternalMappedAttributeValueAppender.initProperties(_ExternalMappedAttributeValueAppender);
			Fragments._ExternalMappedAttributeValueExpander__ExternalMappedAttributeValueExpander.initProperties(_ExternalMappedAttributeValueExpander);
			Fragments._ExternalMappedAttributeValuePrepender__ExternalMappedAttributeValuePrepender.initProperties(_ExternalMappedAttributeValuePrepender);
			Fragments._ExternalModifiedAttributeElementType__ExternalModifiedAttributeElementType.initProperties(_ExternalModifiedAttributeElementType);
			Fragments._FixedValue__FixedValue.initProperties(_FixedValue);
			Fragments._GlobalAttribute__GlobalAttribute.initProperties(_GlobalAttribute);
			Fragments._GlobalAttributeImporter__GlobalAttributeImporter.initProperties(_GlobalAttributeImporter);
			Fragments._GlobalModifiedAttributeElementType__GlobalModifiedAttributeElementType.initProperties(_GlobalModifiedAttributeElementType);
			Fragments._HintImporterMappingHint__HintImporterMappingHint.initProperties(_HintImporterMappingHint);
			Fragments._InstantiableMappingHintGroup__InstantiableMappingHintGroup.initProperties(_InstantiableMappingHintGroup);
			Fragments._LocalMappedAttributeValueExpander__LocalMappedAttributeValueExpander.initProperties(_LocalMappedAttributeValueExpander);
			Fragments._LocalModifiedAttributeElementType__LocalModifiedAttributeElementType.initProperties(_LocalModifiedAttributeElementType);
			Fragments._MappedAttributeValueAppender__MappedAttributeValueAppender.initProperties(_MappedAttributeValueAppender);
			Fragments._MappedAttributeValueExpander__MappedAttributeValueExpander.initProperties(_MappedAttributeValueExpander);
			Fragments._MappedAttributeValuePrepender__MappedAttributeValuePrepender.initProperties(_MappedAttributeValuePrepender);
			Fragments._Mapping__Mapping.initProperties(_Mapping);
			Fragments._MappingHint__MappingHint.initProperties(_MappingHint);
			Fragments._MappingHintBaseType__MappingHintBaseType.initProperties(_MappingHintBaseType);
			Fragments._MappingHintGroup__MappingHintGroup.initProperties(_MappingHintGroup);
			Fragments._MappingHintGroupImporter__MappingHintGroupImporter.initProperties(_MappingHintGroupImporter);
			Fragments._MappingHintGroupType__MappingHintGroupType.initProperties(_MappingHintGroupType);
			Fragments._MappingHintSourceInterface__MappingHintSourceInterface.initProperties(_MappingHintSourceInterface);
			Fragments._MappingHintType__MappingHintType.initProperties(_MappingHintType);
			Fragments._MappingType__MappingType.initProperties(_MappingType);
			Fragments._MatchToLowerCaseConverter__MatchToLowerCaseConverter.initProperties(_MatchToLowerCaseConverter);
			Fragments._MatchToUpperCaseConverter__MatchToUpperCaseConverter.initProperties(_MatchToUpperCaseConverter);
			Fragments._Matcher__Matcher.initProperties(_Matcher);
			Fragments._ModelConnectionHint__ModelConnectionHint.initProperties(_ModelConnectionHint);
			Fragments._ModelConnectionHintExternalSourceElement__ModelConnectionHintExternalSourceElement.initProperties(_ModelConnectionHintExternalSourceElement);
			Fragments._ModelConnectionHintGlobalSourceElement__ModelConnectionHintGlobalSourceElement.initProperties(_ModelConnectionHintGlobalSourceElement);
			Fragments._ModelConnectionHintSourceElement__ModelConnectionHintSourceElement.initProperties(_ModelConnectionHintSourceElement);
			Fragments._ModelConnectionHintSourceInterface__ModelConnectionHintSourceInterface.initProperties(_ModelConnectionHintSourceInterface);
			Fragments._ModelConnectionHintTargetAttribute__ModelConnectionHintTargetAttribute.initProperties(_ModelConnectionHintTargetAttribute);
			Fragments._ModifiableHint__ModifiableHint.initProperties(_ModifiableHint);
			Fragments._ModifiedAttributeElementType__ModifiedAttributeElementType.initProperties(_ModifiedAttributeElementType);
			Fragments._ReferenceTargetSelector__ReferenceTargetSelector.initProperties(_ReferenceTargetSelector);
			Fragments._StringAppender__StringAppender.initProperties(_StringAppender);
			Fragments._StringPrepender__StringPrepender.initProperties(_StringPrepender);
			Fragments._SubstringReplacer__SubstringReplacer.initProperties(_SubstringReplacer);
			Fragments._UniqueNumberAppender__UniqueNumberAppender.initProperties(_UniqueNumberAppender);
			Fragments._ValueModifier__ValueModifier.initProperties(_ValueModifier);
			Fragments._ValueModifierSet__ValueModifierSet.initProperties(_ValueModifierSet);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of MappingTables::FragmentProperties and all preceding sub-packages.
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
		 * Force initialization of the fields of MappingTables::EnumerationLiterals and all preceding sub-packages.
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
