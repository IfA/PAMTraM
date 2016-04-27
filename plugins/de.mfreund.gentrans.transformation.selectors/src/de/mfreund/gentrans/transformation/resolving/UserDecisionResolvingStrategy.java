package de.mfreund.gentrans.transformation.resolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;

import de.mfreund.gentrans.transformation.EObjectWrapper;
import de.mfreund.gentrans.transformation.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.wizards.GenericSelectionDialogRunner;
import de.mfreund.gentrans.transformation.resolving.wizards.NamedElementItemSelectorDialogRunner;
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
	public List<Mapping> matchingSelectMapping(List<Mapping> choices, EObject element) throws Exception {

		final NamedElementItemSelectorDialogRunner<Mapping> dialog = new NamedElementItemSelectorDialogRunner<>(
				"Please select a Mapping for the source element\n'" + EObjectWrapper.asString(element)+ "'", 
				choices, 
				0);
		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}
		printMessage(dialog.getSelection().getName(), userDecisionPrefix);
		return new ArrayList<>(Arrays.asList(dialog.getSelection()));
	}
	
	@Override
	public List<String> expandingSelectAttributeValue(List<String> choices, TargetSectionAttribute attribute,
			EObject element) throws Exception {
		
		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else if(choices.size() > 1 || choices.get(0) != null || skipExpandingAmbiguities) {
			return choices;
		}
		
		String dialogMessage = "Please specify a value for the attribute '" + attribute.getName() + "' of the element '" 
				+ element.eClass().getName() + "'...";

		final ValueSpecificationDialogRunner dialog = new ValueSpecificationDialogRunner(dialogMessage);

		Display.getDefault().syncExec(
				dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}
		
		printMessage(dialog.getSingleValue(), userDecisionPrefix);
		return Arrays.asList(dialog.getSingleValue());
	}
	
	@Override
	public List<Integer> expandingSelectCardinality(List<Integer> choices, TargetSectionClass targetSectionClass,
			InstantiableMappingHintGroup mappingHintGroup) throws Exception {
		
		if(choices == null || choices.size() == 0) {
			return new ArrayList<>();
		} else if(choices.size() > 1 || choices.get(0) != null || skipExpandingAmbiguities) {
			return choices;
		}
		
		String dialogMessage = "Please specify a cardinality for the target section class '" + targetSectionClass.getName() 
				+ "' that is instantiated by the mapping hint group '" + mappingHintGroup.getName() + "'...";

		final ValueSpecificationDialogRunner dialog = new ValueSpecificationDialogRunner(dialogMessage);

		Display.getDefault().syncExec(
				dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}
		
		int cardinality = -1;
		if(!(dialog.getSingleValue() == null) && !dialog.getSingleValue().isEmpty()) {
			try {
				cardinality = Integer.parseInt(dialog.getSingleValue());
				
			} catch (NumberFormatException e) {
				throw new RuntimeException("Could not parse a valid cardinality (positive integer) from the string '" 
						+ dialog.getSingleValue() + "'!");
			}			
		}
		if(cardinality == -1) {
			return choices;
		}
		printMessage("Cardinality: " + cardinality, userDecisionPrefix);
		return Arrays.asList(cardinality);
		
	}

	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) throws Exception {

		ArrayList<String> classNames = new ArrayList<>();

		for (EClass eClass : choices) {
			classNames.add(eClass.getName());
		}

		final GenericSelectionDialogRunner<String> dialog = new GenericSelectionDialogRunner<String>(
				"There was more than one target model element that could not be connected to a root element. Therefore "
						+ "a model root element needs to be created. Please select a fitting class:",
						0, false, classNames);
		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}
		printMessage(dialog.getSingleSelection(), userDecisionPrefix);
		return new ArrayList<>(Arrays.asList(choices.get(classNames.indexOf(dialog.getSingleSelection()))));
	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws Exception {

		// get shortest path
		ModelConnectionPath chosenPath = choices.get(0);
		int chosenPathSize = chosenPath.size();
		for (final ModelConnectionPath p : choices) {// get
			/*
			 * one of the shortest paths
			 */
			final int pSize = p.size();
			if (pSize < chosenPathSize) {
				chosenPath = p;
				chosenPathSize = pSize;
			}
		}

		final GenericSelectionDialogRunner<ModelConnectionPath> dialog = new GenericSelectionDialogRunner<ModelConnectionPath>(
				"Please choose one of the possible connections for connecting the "
						+ "instances of the target section '" + section.getName() + "' (EClass: '"
						+ section.getEClass().getName() + "') to the model root element of the type '" + choices.get(0).getPathRootClass().getName() + "'.",
						choices.indexOf(chosenPath), false, choices);
		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}
		printMessage(dialog.getSelection().toString(), userDecisionPrefix);
		return new ArrayList<>(Arrays.asList(dialog.getSingleSelection()));
	}

	@Override
	public HashMap<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			HashMap<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section, List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws Exception {

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
						+ section.getName() + "', created by the mapping '" + ((Mapping) (hintGroup.eContainer())).getName() + " (Group: " + hintGroup.getName()
						+ ")', " + (sectionInstances.size() > 1 ? "have" : "has a") + " root element" + (sectionInstances.size() > 1 ? "s" : "")
						+ " of the type '" + section.getEClass().getName() + "'. "
						+ (sectionInstances.size() > 1 ? "Theese need" : "It needs") + " to be put at a sensible position in the target model. "
						+ "Please choose one of the possible connections to other existing target model elements"
						+ " below.", namesAsList, instanceNames);

		Display.getDefault().syncExec(dialog); // TODO Maybe add option to not do anything
		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}

		ModelConnectionPath retPath = null;
		for (ModelConnectionPath path : choices.keySet()) {
			if(dialog.getPath().equals(path.toString())) {
				retPath = path;
				break;
			}
		}
		if(retPath == null) {
			throw new RuntimeException("Internal Error! Could not determine chosen connection path...");
		}
		EObjectWrapper retWrapper = null;
		for (EObjectWrapper wrapper : choices.get(retPath)) {
			if(dialog.getSingleInstance().equals(wrapper.toString())) {
				retWrapper = wrapper;
				break;
			}
		}
		if(retWrapper == null) {
			throw new RuntimeException("Internal Error! Could not determine chosen connection instance...");
		}
		HashMap<ModelConnectionPath, List<EObjectWrapper>> ret = new HashMap<>();
		ret.put(retPath, Arrays.asList(retWrapper));
		printMessage(retPath + "-->" + retWrapper.toString(), userDecisionPrefix);
		return ret;

	}

	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(
			List<EObjectWrapper> choices, 
			List<EObjectWrapper> sectionInstances,
			MappingHintGroupType hintGroup,
			ModelConnectionHint modelConnectionHint, 
			String hintValue) throws Exception {

		final GenericSelectionDialogRunner<EObjectWrapper> dialog = new GenericSelectionDialogRunner<EObjectWrapper>(
				"The ModelConnectionHint '" + modelConnectionHint.getName() + " (Mapping :" + ((Mapping) (hintGroup.eContainer())).getName() + ", Group: " + hintGroup.getName()
				+ ")' points to a non-unique Attribute. Please choose under which elements " + 
				(sectionInstances.size() > 1 ? 
						"theese " + sectionInstances.size()+ "elements" : 
							"this " + sectionInstances.size() + "element")
				+ " should be inserted.\n\n" + "Attribute value: " + hintValue,
				0, false, choices);
		Display.getDefault().syncExec(dialog);
		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}

		printMessage(dialog.getSelection().toString(), userDecisionPrefix);
		return Arrays.asList(dialog.getSingleSelection());
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionNonContainmentReference reference, MappingHintGroupType hintGroup,
			MappingInstanceSelector mappingInstanceSelector, EObjectWrapper sourceElement) throws Exception {

		String dialogMessage = "";
		if(mappingInstanceSelector != null) {
			dialogMessage = "The MappingInstanceSelector '" + mappingInstanceSelector.getName() + " of Mapping" + ((Mapping) (hintGroup.eContainer())).getName() + "(Group: "
					+ hintGroup.getName() + ")' has a Matcher that points to a target element with more than one instance. "
					+ "Please choose to which element the Reference '" + reference.getName()
					+ "' of the " + (sourceElement != null ? ("following element should point to:\n\n" + sourceElement.toString()) : "affected elements should point to.");
		} else {
			dialogMessage = "There was more than one target element found for the NonContainmmentReference '" + reference.getName() + "' of TargetMMSection "
					+ hintGroup.getTargetMMSection().getName()
					+ "(Section: " + hintGroup.getTargetMMSection().getEClass().getName()
					+ ") in Mapping " + ((Mapping) (hintGroup.eContainer())).getName()
					+ "(Group: " + hintGroup.getName()
					+ ") . Please select a target element for the following source:\n" + sourceElement.toString();
		}

		final GenericSelectionDialogRunner<EObjectWrapper> dialog = new GenericSelectionDialogRunner<EObjectWrapper>(
				dialogMessage, 0, reference.getEReference().isMany(), choices);

		Display.getDefault().syncExec(
				dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}
		
		printMessage(Arrays.toString(dialog.getSelection().toArray()), userDecisionPrefix);
		if(reference.getEReference().isMany()) {
			return new ArrayList<>(dialog.getSelection());
		} else {			
			return Arrays.asList(dialog.getSingleSelection());
		}
	}

	@Override
	public HashMap<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			HashMap<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionNonContainmentReference reference,
			MappingHintGroupType hintGroup) throws Exception {

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
						+ hintGroup.getTargetMMSection().getName()
						+ "(Section: "
						+ hintGroup.getTargetMMSection().getEClass().getName()
						+ ") in Mapping "
						+ ((Mapping) (hintGroup.eContainer())).getName()
						+ "(Group: "
						+ hintGroup.getName()
						+ ") ."
						+ "Please select a target Class and element.",
						namesAsList, instanceNames, reference.getEReference().isMany());
		Display.getDefault().syncExec(dialog);

		if (dialog.wasTransformationStopRequested()) {
			throw new UserAbortException();
		}

		TargetSectionClass retSection = null;
		for (TargetSectionClass section : choices.keySet()) {
			if(dialog.getPath().equals(section.getName() + " (Section: " + section.getContainingSection().getName() + ")")) {
				retSection = section;
				break;
			}
		}
		if(retSection == null) {
			throw new RuntimeException("Internal Error! Could not determine chosen target section...");
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
				throw new RuntimeException("Internal Error! Could not determine chosen target instance...");
			}
			ret.put(retSection, retWrappers);	
		}
		printMessage(retSection.getName() + "-->" + Arrays.toString(ret.get(retSection).toArray()), userDecisionPrefix);
		return ret;
	}
}
