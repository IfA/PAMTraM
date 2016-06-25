package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * This represents the containment tree of a given {@link EObject source model}
 * and keeps track of unmatched and matched elements in the tree.
 * <p />
 * Note: Instances are created via the static factory method
 * {@link #build(List)}.
 * 
 * @author mfreund
 *
 */
public class ContainmentTree {

	/**
	 * The {@link EObject root elements} of the source models that this
	 * represents.
	 */
	private final List<EObject> sourceModels;

	/**
	 * This list of {@link EObject EObjects} represents the containment tree of the source model. It therefore stores the elements of
	 * the source model in hierarchical order.
	 */
	final private LinkedList<EObject> containmentTree;

	/**
	 * This list keeps track of those elements of the {@link #containmentTree} that are still available for matching.
	 */
	final private LinkedList<EObject> availableElements;

	/**
	 * This list keeps track of those elements of the {@link #containmentTree} that have already been matched.
	 */
	final private LinkedList<EObject> matchedElements;

	/**
	 * This list keeps track of those elements of the {@link #containmentTree} that could not be matched.
	 */
	final private LinkedList<EObject> unmatchedElements;

	/**
	 * This keeps track of the element that is currently evaluated for matching.
	 */
	private EObject currentElement;

	/**
	 * This constructs an instance.
	 */
	private ContainmentTree() {
		sourceModels = new ArrayList<>();
		containmentTree = new LinkedList<>();
		availableElements = new LinkedList<>();
		matchedElements = new LinkedList<>();
		unmatchedElements = new LinkedList<>();
		currentElement = null;
	}

	/**
	 * This creates a new instance based on a given {@link EObject sourceModels} and returns it.
	 * 
	 * @param sourceModels The list of {@link EObject EObjects} representing the source models for which the containment tree shall be built.
	 * @return The created {@link ContainmentTree}.
	 */
	public static ContainmentTree build(List<EObject> sourceModels) {

		ContainmentTree tree = new ContainmentTree();

		tree.sourceModels.addAll(sourceModels);

		for (EObject sourceModel : sourceModels) {
			tree.buildContainmentTree(sourceModel);
		}

		// at the beginning of the matching process, all elements from the containment tree are still 'unmatched'
		tree.availableElements.addAll(tree.containmentTree);

		return tree;
	}

	/**
	 * This method recursively builds the containment tree by iterating over all child elements of the given <em>modelElement</em>.
	 * 
	 * @param modelElement The model element for that the containment tree shall be built.
	 */
	private void buildContainmentTree(final EObject modelElement) {

		containmentTree.add(modelElement);

		for (EObject childElement : modelElement.eContents()) {
			buildContainmentTree(childElement);
		}

	}

	/**
	 * This returns the number of elements in the containment tree.
	 * 
	 * @return The number of elements in the containment tree.
	 */
	public int getNumberOfElements() {
		return containmentTree.size();
	}

	/**
	 * This returns the number of elements in the containment tree that are still available for matching.
	 * 
	 * @return The number of elements that are still available for matching.
	 */
	public int getNumberOfAvailableElements() {
		if(availableElements.isEmpty() && currentElement != null) {
			/*
			 *  If this function is called and there are no available elements left, we assume that
			 *  we have arrived at the end of the matching process. Consequently, the 'current element'
			 *  should be marked as unmatched if necessary.
			 */
			unmatchedElements.add(currentElement);
			currentElement = null;
		}
		return availableElements.size();
	}

	/**
	 * This returns the number of elements in the containment tree that have already been matched.
	 * 
	 * @return The number of elements that have already been matched.
	 */
	public int getNumberOfMatchedElements() {
		return matchedElements.size();
	}

	/**
	 * This returns the number of elements in the containment tree that could not be matched.
	 * 
	 * @return The number of elements that could not be matched.
	 */
	public int getNumberOfUnmatchedElements() {

		return unmatchedElements.size();
	}

	/**
	 * This returns the next element that is still available for matching.
	 * <p />
	 * Note: Every element will be returned only once. Consequently, calling this twice will return 
	 * different elements.
	 * 
	 * @return The next element that is still available for mathcing or '<em>null</em>'
	 * if there is no next element.
	 */
	public EObject getNextElementForMatching() {
		if(getNumberOfAvailableElements() == 0) {
			return null;
		}

		/*
		 * if the element that was evaluated for matching has not been marked as matched (and is thus still be marked as 
		 * 'currentElement'), we assume that it could not be matched
		 */
		if(currentElement != null) {
			unmatchedElements.add(currentElement);
		}

		currentElement = availableElements.removeFirst();
		return currentElement; 
	}

	/**
	 * This marks the given element as '<em>matched</em>' and thus adds it to the list of {@link #matchedElements}.
	 * 
	 * @param element The element to be marked as '<em>matched</em>'.
	 */
	public void markAsMatched(EObject element) {
		matchedElements.add(element);
		availableElements.remove(element);
		if(element.equals(currentElement)) {
			currentElement = null;
		}
	}

	/**
	 * This marks the given set of elements as '<em>matched</em>' and thus adds them to the list of {@link #matchedElements}.
	 * 
	 * @param elements The list of elements to be marked as '<em>matched</em>'.
	 */
	public void markAsMatched(Set<EObject> elements) {
		matchedElements.addAll(elements);
		availableElements.removeAll(elements);
		if(elements.contains(currentElement)) {
			currentElement = null;
		}
	}

}
