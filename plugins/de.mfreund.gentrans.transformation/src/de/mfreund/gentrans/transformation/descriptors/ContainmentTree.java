package de.mfreund.gentrans.transformation.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * This represents the containment tree of a given {@link EObject source model} and keeps track of unmatched and matched
 * elements in the tree.
 * <p />
 * Note: Instances are created via the static factory method {@link #build(List)}.
 *
 * @author mfreund
 *
 */
public class ContainmentTree {

	/**
	 * The {@link EObject root elements} of the source models that this represents.
	 */
	private final List<EObject> sourceModels;

	/**
	 * This list of {@link EObject EObjects} represents the containment tree of the source model. It therefore stores
	 * the elements of the source model in hierarchical order.
	 */
	private final List<EObject> elements;

	/**
	 * This list keeps track of those of the {@link #elements} that are still available for matching.
	 */
	private final List<EObject> availableElements;

	/**
	 * This list keeps track of those of the {@link #elements} that have already been matched.
	 */
	private final Set<EObject> matchedElements;

	/**
	 * This list keeps track of those of the {@link #elements} that could not be matched.
	 */
	private final List<EObject> unmatchedElements;

	/**
	 * This keeps track of the element that is currently evaluated for matching.
	 */
	private EObject currentElement;

	/**
	 * This constructs an instance.
	 */
	private ContainmentTree() {

		this.sourceModels = new ArrayList<>();
		this.elements = new ArrayList<>();
		this.availableElements = new ArrayList<>();
		this.matchedElements = new HashSet<>();
		this.unmatchedElements = new ArrayList<>();
		this.currentElement = null;
	}

	/**
	 * This creates a new instance based on a given {@link EObject sourceModels} and returns it.
	 *
	 * @param sourceModels
	 *            The list of {@link EObject EObjects} representing the source models for which the containment tree
	 *            shall be built.
	 * @return The created {@link ContainmentTree}.
	 */
	public static ContainmentTree build(List<EObject> sourceModels) {

		ContainmentTree tree = new ContainmentTree();

		tree.sourceModels.addAll(sourceModels);

		for (EObject sourceModel : sourceModels) {
			tree.buildContainmentTree(sourceModel);
		}

		// at the beginning of the matching process, all elements from the
		// containment tree are still 'unmatched'
		tree.availableElements.addAll(tree.elements);

		return tree;
	}

	/**
	 * This method recursively builds the containment tree by iterating over all child elements of the given
	 * <em>modelElement</em>.
	 *
	 * @param modelElement
	 *            The model element for that the containment tree shall be built.
	 */
	private void buildContainmentTree(final EObject modelElement) {

		this.elements.add(modelElement);

		for (EObject childElement : modelElement.eContents()) {
			this.buildContainmentTree(childElement);
		}

	}

	/**
	 * Reset this tree, i.e. clear the {@link #availableElements}, the {@link #matchedElements}, and the
	 * {@link #unmatchedElements} and {@link #restartIteration() restart} the iteration process. process}.
	 * <p />
	 * Note: This will neither change the available {@link #sourceModels} nor {@link #buildContainmentTree(EObject)
	 * rebuild} the list of {@link #availableElements}.
	 *
	 * @see #restartIteration()
	 */
	public void reset() {

		this.availableElements.clear();
		this.availableElements.addAll(this.elements);
		this.matchedElements.clear();
		this.unmatchedElements.clear();

		this.restartIteration();
	}

	/**
	 * Reset the current iteration status, i.e. clear the {@link #currentElement} so that the next call to
	 * {@link #getNextElementForMatching()} will return the first element {@link #availableElements available} for
	 * matching.
	 * <p />
	 * Note: This should be called before restarting/repeating the {@link #getNextElementForMatching() iteration
	 * process}.
	 * <p />
	 * Note: This will not reset the {@link #matchedElements matched} and {@link #unmatchedElements unmatched} elements.
	 *
	 * @see #reset()
	 */
	public void restartIteration() {

		this.currentElement = null;
	}

	/**
	 * This is the getter for the {@link #elements}.
	 *
	 * @return the {@link #elements}.
	 */
	public List<EObject> getElements() {

		return this.elements;
	}

	/**
	 * This returns the number of elements in the containment tree.
	 *
	 * @return The number of elements in the containment tree.
	 */
	public int getNumberOfElements() {

		return this.elements.size();
	}

	/**
	 * This returns the number of elements in the containment tree that are still available for matching.
	 *
	 * @return The number of elements that are still available for matching.
	 */
	public int getNumberOfAvailableElements() {

		return this.availableElements.size();
	}

	/**
	 * This returns the number of elements in the containment tree that have already been matched.
	 *
	 * @return The number of elements that have already been matched.
	 */
	public int getNumberOfMatchedElements() {

		return this.matchedElements.size();
	}

	/**
	 * This returns the number of elements in the containment tree that could not be matched.
	 *
	 * @return The number of elements that could not be matched.
	 */
	public int getNumberOfUnmatchedElements() {

		return this.unmatchedElements.size();
	}

	/**
	 * This returns the next element that is still available for matching.
	 * <p />
	 * Note: Every element will be returned only once. Consequently, calling this twice will return different elements.
	 *
	 * @see #reset()
	 * @see #restartIteration()
	 *
	 * @return The next element that is still available for matching (the returned optional will be empty if there is no
	 *         next element).
	 */
	public Optional<EObject> getNextElementForMatching() {

		if (this.getNumberOfAvailableElements() == 0) {
			return Optional.empty();
		}

		/*
		 * if the element that was evaluated for matching has not been marked as matched (and is thus still be marked as
		 * 'currentElement'), we assume that it could not be matched
		 */
		if (this.currentElement != null) {
			this.unmatchedElements.add(this.currentElement);
		}

		this.currentElement = this.availableElements.remove(0);
		return Optional.of(this.currentElement);
	}

	/**
	 * This marks the given element as '<em>matched</em>' and thus adds it to the list of {@link #matchedElements}.
	 *
	 * @param element
	 *            The element to be marked as '<em>matched</em>'.
	 */
	public void markAsMatched(EObject element) {

		this.markAsMatched(new HashSet<>(Arrays.asList(element)));
	}

	/**
	 * This marks the given set of elements as '<em>matched</em>' and thus adds them to the list of
	 * {@link #matchedElements}.
	 *
	 * @param elements
	 *            The list of elements to be marked as '<em>matched</em>'.
	 */
	public void markAsMatched(Set<EObject> elements) {

		this.matchedElements.addAll(elements);
		this.availableElements.removeAll(elements);
		if (elements.contains(this.currentElement)) {
			this.currentElement = null;
		}
	}

	/**
	 * @return the {@link #matchedElements}
	 */
	public Set<EObject> getMatchedElements() {

		return this.matchedElements;
	}

	/**
	 * @return the {@link #unmatchedElements}
	 */
	public List<EObject> getUnmatchedElements() {

		return this.unmatchedElements;
	}

}
