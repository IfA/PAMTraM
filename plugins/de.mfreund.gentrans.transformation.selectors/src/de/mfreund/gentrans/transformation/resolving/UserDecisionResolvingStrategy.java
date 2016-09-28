package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectConnectionPathMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.enhancing.JoiningSelectRootElementMappingModelEnhancer;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialogRunner;
import de.mfreund.gentrans.transformation.resolving.wizards.PathAndInstanceSelectorRunner;
import de.mfreund.gentrans.transformation.resolving.wizards.ValueSpecificationDialogRunner;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * This class implements a concrete {@link IAmbiguityResolvingStrategy} that allows a user to resolve
 * ambiguities by presenting selection dialogues to him.
 *
 * @author mfreund
 */
public class UserDecisionResolvingStrategy extends AbstractAmbiguityResolvingStrategy {



	/**
	 * This prefix will be added to {@link #printMessage(String, String) messages} printed after user selections.
	 */
	private static final String userDecisionPrefix = "User";

	/**
	 * If this is set to '<em>false</em>' this strategy will also try to resolve ambiguities during the <em>expanding<em>
	 * step as this might lead to a ton of questions.
	 * <p />
	 * The default value is '<em>true</em>'.
	 */
	private boolean skipExpandingAmbiguities = true;

	/**
	 * This allows to change the {@link #skipExpandingAmbiguities} behavior.
	 *
	 * @param skipExpandingAmbiguities If this is set to '<em>false</em>' this strategy will also try to resolve ambiguities
	 * during the <em>expanding<em> step
	 */
	public void setSkipExpandingAmbiguities(boolean skipExpandingAmbiguities) {
		this.skipExpandingAmbiguities = skipExpandingAmbiguities;
	}

	@Override
	public List<MatchedSectionDescriptor> searchingSelectSection(List<MatchedSectionDescriptor> choices,
			EObject element) throws AmbiguityResolvingException {

		final GenericSelectionDialogRunner<MatchedSectionDescriptor> dialog = new GenericSelectionDialogRunner<MatchedSectionDescriptor>(
				"Please select a SourceSection for the source element\n'" + EObjectWrapper.asString(element) + "'", 0,
				false, choices, null) {

			@Override
			protected String getStringRepresentation(MatchedSectionDescriptor option) {

				return option.getAssociatedSourceSectionClass().getName();
			}
		};

		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}
		this.printMessage(dialog.getSingleSelection().getAssociatedSourceSectionClass().getName(),
				UserDecisionResolvingStrategy.userDecisionPrefix);
		return dialog.getSelection();
	}

	@Override
	public List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		final GenericSelectionDialogRunner<Mapping> dialog = new GenericSelectionDialogRunner<Mapping>(
				"Please select a Mapping for the source element\n'" + EObjectWrapper.asString(element)+ "'",
				0, false, choices, null) {

			@Override
			protected String getStringRepresentation(Mapping option) {
				return option.getName();
			}
		};

		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}
		this.printMessage(dialog.getSingleSelection().getName(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return dialog.getSelection();
	}

	@Override
	public List<String> instantiatingSelectAttributeValue(List<String> choices, TargetSectionAttribute attribute,
			EObject element) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else if(choices.size() > 1 || choices.get(0) != null || this.skipExpandingAmbiguities) {
			return choices;
		}

		String dialogMessage = "Please specify a value for the attribute '" + attribute.getName() + "' of the element '"
				+ element.eClass().getName() + "'...";

		final ValueSpecificationDialogRunner dialog = new ValueSpecificationDialogRunner(dialogMessage);

		Display.getDefault().syncExec(
				dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		this.printMessage(dialog.getSingleValue(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(dialog.getSingleValue());
	}

	@Override
	public List<Integer> instantiatingSelectCardinality(List<Integer> choices, TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup) throws AmbiguityResolvingException {

		if (choices == null || choices.isEmpty()) {
			return new ArrayList<>();
		} else if(choices.size() > 1 || choices.get(0) != null || this.skipExpandingAmbiguities) {
			return choices;
		}

		String dialogMessage = "Please specify a cardinality for the target section class '" + targetSectionClass.getName()
		+ "' that is instantiated by the mapping hint group '" + mappingHintGroup.getName() + "'...";

		final ValueSpecificationDialogRunner dialog = new ValueSpecificationDialogRunner(dialogMessage);

		Display.getDefault().syncExec(
				dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		int cardinality = -1;
		if (dialog.getSingleValue() != null && !dialog.getSingleValue().isEmpty()) {
			try {
				cardinality = Integer.parseInt(dialog.getSingleValue());

			} catch (NumberFormatException e) {
				throw new AmbiguityResolvingException(
						"Could not parse a valid cardinality (positive integer) from the string '"
								+ dialog.getSingleValue() + "'!");
			}
		}
		if(cardinality == -1) {
			return choices;
		}
		this.printMessage("Cardinality: " + cardinality, UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(cardinality);

	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) throws AmbiguityResolvingException {

		ArrayList<String> classNames = new ArrayList<>();

		for (EClass eClass : choices) {
			classNames.add(eClass.getName());
		}

		JoiningSelectRootElementMappingModelEnhancer enhancer = new JoiningSelectRootElementMappingModelEnhancer(this.pamtramModel);
		final GenericSelectionDialogRunner<EClass> dialog = new GenericSelectionDialogRunner<EClass>(
				"There was more than one target model element that could not be connected to a root element. Therefore "
						+ "a model root element needs to be created. Please select a fitting class:",
						0, false, choices, enhancer) {

			@Override
			protected String getStringRepresentation(EClass option) {

				return option.getName();
			}
		};

		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}
		this.printMessage(dialog.getSingleSelection().getName(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return new ArrayList<>(Arrays.asList(dialog.getSingleSelection()));
	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws AmbiguityResolvingException {

		JoiningSelectConnectionPathMappingModelEnhancer enhancer = new JoiningSelectConnectionPathMappingModelEnhancer(
				this.pamtramModel);
		final GenericSelectionDialogRunner<ModelConnectionPath> dialog = new GenericSelectionDialogRunner<>(
				"Please choose one of the possible connections for connecting the "
						+ "instances of the target section '" + section.getName() + "' (EClass: '"
						+ section.getEClass().getName() + "') to the model root element of the type '" + choices.get(0).getPathRootClass().getName() + "'.",
				0, false, choices, enhancer);
		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}
		this.printMessage(dialog.getSelection().toString(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return new ArrayList<>(Arrays.asList(dialog.getSingleSelection()));
	}

	@Override
	public Map<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			Map<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		List<String> namesAsList = new ArrayList<>();
		List<List<String>> instanceNames = new ArrayList<>();
		for (Entry<ModelConnectionPath, List<EObjectWrapper>> entry : choices.entrySet()) {
			namesAsList.add(entry.getKey().toString());
			ArrayList<String> instanceNameList = new ArrayList<>();
			for (EObjectWrapper wrapper : entry.getValue()) {
				instanceNameList.add(wrapper.toString());
			}
			instanceNames.add(instanceNameList);
		}

		final PathAndInstanceSelectorRunner dialog = new PathAndInstanceSelectorRunner(
				sectionInstances.size() + " Instance" + (sectionInstances.size() > 1 ? "s" : "") + " of the TargetSection '"
						+ section.getName() + "', created by the mapping '" + ((Mapping) hintGroup.eContainer()).getName() + " (Group: " + hintGroup.getName()
						+ ")', " + (sectionInstances.size() > 1 ? "have" : "has a") + " root element" + (sectionInstances.size() > 1 ? "s" : "")
						+ " of the type '" + section.getEClass().getName() + "'. "
						+ (sectionInstances.size() > 1 ? "Theese need" : "It needs") + " to be put at a sensible position in the target model. "
						+ "Please choose one of the possible connections to other existing target model elements"
						+ " below.",
						namesAsList, instanceNames, null);

		Display.getDefault().syncExec(dialog); // TODO Maybe add option to not do anything
		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		ModelConnectionPath retPath = null;
		for (ModelConnectionPath path : choices.keySet()) {
			if(dialog.getPath().equals(path.toString())) {
				retPath = path;
				break;
			}
		}
		if(retPath == null) {
			throw new AmbiguityResolvingException("Internal Error! Could not determine chosen connection path...");
		}
		EObjectWrapper retWrapper = null;
		for (EObjectWrapper wrapper : choices.get(retPath)) {
			if(dialog.getSingleInstance().equals(wrapper.toString())) {
				retWrapper = wrapper;
				break;
			}
		}
		if(retWrapper == null) {
			throw new AmbiguityResolvingException("Internal Error! Could not determine chosen connection instance...");
		}
		HashMap<ModelConnectionPath, List<EObjectWrapper>> ret = new HashMap<>();
		ret.put(retPath, Arrays.asList(retWrapper));
		this.printMessage(retPath + "-->" + retWrapper.toString(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return ret;

	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(
			List<EObjectWrapper> choices,
			List<EObjectWrapper> sectionInstances,
			MappingHintGroupType hintGroup,
			ModelConnectionHint modelConnectionHint,
			String hintValue) throws AmbiguityResolvingException {

		final GenericSelectionDialogRunner<EObjectWrapper> dialog = new GenericSelectionDialogRunner<>(
				"The ModelConnectionHint '" + modelConnectionHint.getName() + " (Mapping :" + ((Mapping) hintGroup.eContainer()).getName() + ", Group: " + hintGroup.getName()
				+ ")' points to a non-unique Attribute. Please choose under which elements " +
				(sectionInstances.size() > 1 ?
						"theese " + sectionInstances.size()+ "elements" :
							"this " + sectionInstances.size() + "element")
				+ " should be inserted.\n\n" + "Attribute value: " + hintValue,
				0, false, choices, null);
		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		this.printMessage(dialog.getSelection().toString(), UserDecisionResolvingStrategy.userDecisionPrefix);
		return Arrays.asList(dialog.getSingleSelection());
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionNonContainmentReference reference, MappingHintGroupType hintGroup,
			MappingInstanceSelector mappingInstanceSelector, EObjectWrapper sourceElement)
					throws AmbiguityResolvingException {

		String dialogMessage;
		if(mappingInstanceSelector != null) {
			dialogMessage = "The MappingInstanceSelector '" + mappingInstanceSelector.getName() + " of Mapping" + ((Mapping) hintGroup.eContainer()).getName() + "(Group: "
					+ hintGroup.getName() + ")' has a Matcher that points to a target element with more than one instance. "
					+ "Please choose to which element the Reference '" + reference.getName()
					+ "' of the " + (sourceElement != null ? "following element should point to:\n\n" + sourceElement.toString() : "affected elements should point to.");
		} else {
			dialogMessage = "There was more than one target element found for the NonContainmmentReference '" + reference.getName() + "' of TargetMMSection "
					+ hintGroup.getTargetSection().getName()
					+ "(Section: " + hintGroup.getTargetSection().getEClass().getName()
					+ ") in Mapping " + ((Mapping) hintGroup.eContainer()).getName()
					+ "(Group: " + hintGroup.getName()
					+ ") . Please select a target element for the following source:\n" + sourceElement.toString();
		}

		final GenericSelectionDialogRunner<EObjectWrapper> dialog = new GenericSelectionDialogRunner<>(
				dialogMessage, 0, reference.getEReference().isMany(), choices, null);

		Display.getDefault().syncExec(
				dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		this.printMessage(Arrays.toString(dialog.getSelection().toArray()), UserDecisionResolvingStrategy.userDecisionPrefix);
		if(reference.getEReference().isMany()) {
			return new ArrayList<>(dialog.getSelection());
		} else {
			return Arrays.asList(dialog.getSingleSelection());
		}
	}

	@Override
	public Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionNonContainmentReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		List<String> namesAsList = new ArrayList<>();
		List<List<String>> instanceNames = new ArrayList<>();
		for (Entry<TargetSectionClass, List<EObjectWrapper>> entry : choices.entrySet()) {
			namesAsList.add(entry.getKey().getName() + " (Section: " + entry.getKey().getContainingSection().getName() + ")");
			ArrayList<String> instanceNameList = new ArrayList<>();
			for (EObjectWrapper wrapper : entry.getValue()) {
				instanceNameList.add(wrapper.toString());
			}
			instanceNames.add(instanceNameList);
		}

		final PathAndInstanceSelectorRunner dialog = new PathAndInstanceSelectorRunner(
				"There was more than one target element found for the NonContainmmentReference '"
						+ reference.getName()
						+ "' of TargetMMSection "
						+ hintGroup.getTargetSection().getName()
						+ "(Section: "
						+ hintGroup.getTargetSection().getEClass().getName()
						+ ") in Mapping "
						+ ((Mapping) hintGroup.eContainer()).getName()
						+ "(Group: "
						+ hintGroup.getName()
						+ ") ."
						+ "Please select a target Class and element.",
						namesAsList, instanceNames, reference.getEReference().isMany(), null);
		Display.getDefault().syncExec(dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new AmbiguityResolvingException(new UserAbortException());
		}

		TargetSectionClass retSection = null;
		for (TargetSectionClass section : choices.keySet()) {
			if(dialog.getPath().equals(section.getName() + " (Section: " + section.getContainingSection().getName() + ")")) {
				retSection = section;
				break;
			}
		}
		if(retSection == null) {
			throw new AmbiguityResolvingException("Internal Error! Could not determine chosen target section...");
		}

		HashMap<TargetSectionClass, List<EObjectWrapper>> ret = new HashMap<>();
		if(dialog.getInstances().isEmpty()) {
			ret.put(retSection, new ArrayList<EObjectWrapper>());
		} else {
			List<EObjectWrapper> retWrappers = null;
			for (EObjectWrapper wrapper : choices.get(retSection)) {
				for (String instance : dialog.getInstances()) {
					if(instance.equals(wrapper.toString())) {
						if(retWrappers == null) {
							retWrappers = new ArrayList<>();
						}
						retWrappers.add(wrapper);
						if(!reference.getEReference().isMany()) {
							break;
						}
					}
					if(retWrappers != null && !reference.getEReference().isMany()) {
						break;
					}

				}
			}
			if(retWrappers == null) {
				throw new AmbiguityResolvingException("Internal Error! Could not determine chosen target instance...");
			}
			ret.put(retSection, retWrappers);
		}
		this.printMessage(retSection.getName() + "-->" + Arrays.toString(ret.get(retSection).toArray()), UserDecisionResolvingStrategy.userDecisionPrefix);
		return ret;
	}
}
