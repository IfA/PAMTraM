/**
 *
 */
package pamtram.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import pamtram.ConditionModel;
import pamtram.MappingModel;
import pamtram.PamtramPackage;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.provider.PamtramEditPlugin;

/**
 * This provides some convenience methods to work with shared models
 * ({@link SourceSectionModel}, {@link TargetSectionModel},
 * {@link MappingModel}, or {@link ConditionModel}).
 *
 * @author mfreund
 */
public interface SharedModelUtil {

	/**
	 * Return the file ending that shall be used to store a shared model
	 * referenced by the given {@link EStructuralFeature}.
	 *
	 * @param feature
	 *            The feature that will hold the shared model.
	 * @return The file ending to be used (including a leading '.').
	 */
	public static String getFileEndingBySubModelFeature(EStructuralFeature feature) {

		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS)) {
			return PamtramEditPlugin.INSTANCE.getString("SOURCE_SECTION_MODEL_FILE_ENDING");
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS)) {
			return PamtramEditPlugin.INSTANCE.getString("TARGET_SECTION_MODEL_FILE_ENDING");
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS)) {
			return PamtramEditPlugin.INSTANCE.getString("MAPPING_MODEL_FILE_ENDING");
		} else if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS)) {
			return PamtramEditPlugin.INSTANCE.getString("CONDITION_MODEL_FILE_ENDING");
		} else {
			throw new RuntimeException(
					"Internal Error! Unknown sub-model feature named '" + feature.getName() + "' encountered!");
		}
	}

	/**
	 * Return the file ending that shall be used to store a shared model of the
	 * given {@link SharedModelType}.
	 *
	 * @param type
	 *            The type of the shared model to create.
	 * @return The file ending to be used (including a leading '.').
	 */
	public static String getFileEndingBySharedModelType(SharedModelType type) {

		if (type.equals(SharedModelType.SOURCE)) {
			return PamtramEditPlugin.INSTANCE.getString("SOURCE_SECTION_MODEL_FILE_ENDING");
		} else if (type.equals(SharedModelType.TARGET)) {
			return PamtramEditPlugin.INSTANCE.getString("TARGET_SECTION_MODEL_FILE_ENDING");
		} else if (type.equals(SharedModelType.MAPPING)) {
			return PamtramEditPlugin.INSTANCE.getString("MAPPING_MODEL_FILE_ENDING");
		} else if (type.equals(SharedModelType.CONDITION)) {
			return PamtramEditPlugin.INSTANCE.getString("CONDITION_MODEL_FILE_ENDING");
		} else {
			throw new RuntimeException("Internal Error! Unknown SharedModelType '" + type.name() + "' encountered!");
		}
	}

	/**
	 * Return the file ending that shall be used to store the given shared model
	 * root.
	 *
	 * @param root
	 *            The root element of the shared model to create.
	 * @return The file ending to be used (including a leading '.').
	 */
	public static String getFileEndingBySharedModelRoot(EObject root) {

		if (root instanceof SourceSectionModel) {
			return PamtramEditPlugin.INSTANCE.getString("SOURCE_SECTION_MODEL_FILE_ENDING");
		} else if (root instanceof TargetSectionModel) {
			return PamtramEditPlugin.INSTANCE.getString("TARGET_SECTION_MODEL_FILE_ENDING");
		} else if (root instanceof MappingModel) {
			return PamtramEditPlugin.INSTANCE.getString("MAPPING_MODEL_FILE_ENDING");
		} else if (root instanceof ConditionModel) {
			return PamtramEditPlugin.INSTANCE.getString("CONDITION_MODEL_FILE_ENDING");
		} else {
			throw new RuntimeException("Internal Error! Unsupported root element for a shared model encountered!");
		}
	}

	/**
	 * Validates if the given feature can be used to reference a shared model.
	 *
	 * @param feature
	 *            The feature to validate.
	 * @return '<em>true</em>' if the feature can be used to reference a shared
	 *         model; '<em>false</em>' otherwise.
	 */
	public static boolean isValidSubModelFeature(EStructuralFeature feature) {

		return feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS);
	}

	/**
	 * Validates if the given element can be used as root element for a shared
	 * model of the given <em>type</em>.
	 *
	 * @param type
	 *            The {@link SharedModelType} to validate the given
	 *            <em>element</em> against.
	 * @param element
	 *            The element to validate.
	 * @return '<em>true</em>' if the given element can be used as root element
	 *         for a shared model of the given <em>type</em>; '<em>false</em>'
	 *         otherwise.
	 */
	public static boolean isValidSubModelContent(SharedModelType type, EObject element) {

		return type.equals(SharedModelType.SOURCE) && element instanceof SourceSectionModel
				|| type.equals(SharedModelType.TARGET) && element instanceof TargetSectionModel
				|| type.equals(SharedModelType.MAPPING) && element instanceof MappingModel
				|| type.equals(SharedModelType.CONDITION) && element instanceof ConditionModel;
	}

	/**
	 * An enum representing the types of shared models that can be imported.
	 *
	 * @author mfreund
	 */
	public enum SharedModelType {

		/**
		 * A shared {@link SourceSectionModel}.
		 */
		SOURCE,

		/**
		 * A shared {@link TargetSectionModel}.
		 */
		TARGET,

		/**
		 * A shared {@link MappingModel}.
		 */
		MAPPING,

		/**
		 * A shared {@link ConditionModel}.
		 */
		CONDITION;
	}
}
