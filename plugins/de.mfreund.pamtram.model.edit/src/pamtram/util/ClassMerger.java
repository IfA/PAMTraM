/**
 *
 */
package pamtram.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;

import de.mfreund.pamtram.util.NullComparator;
import pamtram.structure.SourceSectionAttribute;
import pamtram.structure.TargetSectionAttribute;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * A utility class that is able to merge a set of {@link Class Classes}.
 *
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 *
 * @author mfreund
 */
public class ClassMerger<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> {

	/**
	 * After a call to {@link #merge()} this contains all the {@link EObject elements} that have been merged into other
	 * elements and that can now be deleted from the model.
	 * <p />
	 * The key of this map represents the element into which the associated set of values has been merged.
	 */
	protected Map<EObject, Set<EObject>> mergedElements;

	/**
	 * After a call to {@link #merge()} this contains all the {@link EObject elements} that have been deleted during the
	 * merging process because they could not be merged with other elements.
	 */
	protected Set<EObject> deletedElements;

	/**
	 * The set of {@link Class elements} to be merged.
	 */
	protected Set<C> elementsToMerge;

	/**
	 * The list of contained {@link ClassMerger ClassMergers} that are used to merge elements further down in the
	 * containment hierarchy.
	 */
	private List<ClassMerger<S, C, R, A>> subMergers;

	/**
	 * This creates an instance.
	 *
	 * @param elementsToMerge
	 *            The set of {@link Class elements} to be merged.
	 */
	public ClassMerger(Set<C> elementsToMerge) {
		this.elementsToMerge = elementsToMerge;
		this.mergedElements = new HashMap<>();
		this.deletedElements = new HashSet<>();
		this.subMergers = new ArrayList<>();

	}

	/**
	 * Merge the {@link #elementsToMerge}.
	 * <p />
	 * Note: Clients should call {@link #canMerge()} before actually merging the elements so that an unsuccessful merge
	 * process won't affect the {@link #elementsToMerge}.
	 *
	 * @return <em>true</em> if the elements were merged successfully; <em>false</em> otherwise.
	 */
	public boolean merge() {

		return this.mergeClasses(this.elementsToMerge);

	}

	/**
	 * Check if the {@link #elementsToMerge} can be merged successfully.
	 * <p />
	 * Note: This won't affect the {@link #elementsToMerge} so that it is safe to call this even if a merge would not be
	 * successful.
	 *
	 * @return <em>true</em> if the elements can be merged successfully; <em>false</em> otherwise.
	 */
	public boolean canMerge() {

		// Create a self-contained copy of all elements that we can safely try to merge without having to think
		// about
		// any consequences if the merge fails
		//
		Set<C> copiedElements = new HashSet<>(EcoreUtil.copyAll(this.elementsToMerge));

		ClassMerger<S, C, R, A> tempMerger = new ClassMerger<>(copiedElements);

		return tempMerger.merge();

	}

	/**
	 * @return the {@link #mergedElements}
	 */
	public Map<EObject, Set<EObject>> getMergedElements() {

		Map<EObject, Set<EObject>> ret = new HashMap<>();
		ret.putAll(this.mergedElements);

		ret.putAll(this.subMergers.stream().flatMap(s -> s.getMergedElements().entrySet().stream())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
		return ret;
	}

	/**
	 * @return the {@link #deletedElements}
	 */
	public Set<EObject> getDeletedElements() {

		Set<EObject> ret = new HashSet<>(this.deletedElements);
		ret.addAll(this.subMergers.stream().flatMap(s -> s.getDeletedElements().stream()).collect(Collectors.toSet()));
		return ret;
	}

	private boolean mergeClasses(Set<C> classesToMerge) {

		Iterator<C> it = classesToMerge.iterator();

		C class1 = it.next();

		Set<EObject> merged = new HashSet<>();
		while (it.hasNext()) {
			C class2 = it.next();
			if (!this.mergeClass(class1, class2)) {
				return false;
			}

			merged.add(class2);
		}
		this.mergedElements.put(class1, merged);

		return true;
	}

	private boolean mergeClass(C left, C right) {

		// Merge the names of the class
		//
		left.setName(ClassMerger.longestCommonSubstring(left.getName(), right.getName()));

		// Merge the attributes first
		//
		if (!this.mergeAttributes(left, right)) {
			return false;
		}

		// Now, merge the references
		//
		return this.mergeReferences(left, right);

	}

	private boolean mergeAttributes(C left, C right) {

		return new ArrayList<>(right.getAttributes()).stream()
				.allMatch(rightAttribute -> this.mergeAttribute(left, rightAttribute));
	}

	private boolean mergeReferences(C left, C right) {

		return new ArrayList<>(right.getReferences()).stream()
				.allMatch(rightReference -> this.mergeReference(left, rightReference));
	}

	/**
	 *
	 *
	 * @param left
	 * @param rightAttribute
	 * @return
	 */
	private boolean mergeAttribute(C left, A rightAttribute) {

		Optional<A> leftAttribute;

		if (rightAttribute instanceof ActualAttribute<?, ?, ?, ?>) {
			leftAttribute = left.getAttributes().parallelStream()
					.filter(a -> a instanceof ActualAttribute<?, ?, ?, ?> && ((ActualAttribute<?, ?, ?, ?>) a)
							.getAttribute().equals(((ActualAttribute<?, ?, ?, ?>) rightAttribute).getAttribute()))
					.findAny();
		} else {
			leftAttribute = left.getAttributes().parallelStream()
					.filter(a -> a.getName().equals(rightAttribute.getName())).findAny();
		}

		// Simply add the attribute
		//
		if (!leftAttribute.isPresent()) {
			left.getAttributes().add(rightAttribute);
			return true;
		}

		EqualityHelper equalityHelper = new EqualityHelper();

		// Merge the attributes
		//
		String mergedName;
		if (leftAttribute.get().getName().isEmpty()) {
			mergedName = rightAttribute.getName();
		} else if (rightAttribute.getName().isEmpty()) {
			mergedName = leftAttribute.get().getName();
		} else {
			mergedName = ClassMerger.longestCommonSubstring(leftAttribute.get().getName(), rightAttribute.getName());
		}
		leftAttribute.get().setName(mergedName);

		if (leftAttribute.get() instanceof SourceSectionAttribute) {

			// TODO find a better algorithm to merge constraints?
			List<ValueConstraint> leftConstraints = ((SourceSectionAttribute) leftAttribute.get()).getValueConstraint();
			List<ValueConstraint> rightConstraints = ((SourceSectionAttribute) rightAttribute).getValueConstraint();

			if (leftConstraints.isEmpty() && rightConstraints.isEmpty()) {
				// nothing to be done
			} else if (leftConstraints.size() != rightConstraints.size()) {
				// delete all constraints
				this.deletedElements.addAll(leftConstraints);
				leftConstraints.clear();
			} else {
				// delete those constraints that are not equal
				Set<ValueConstraint> constraintsToDelete = IntStream.range(0, leftConstraints.size())
						.filter(i -> !equalityHelper.equals(leftConstraints.get(i), rightConstraints.get(i)))
						.mapToObj(leftConstraints::get).collect(Collectors.toSet());

				this.deletedElements.addAll(constraintsToDelete);
				leftConstraints.removeAll(constraintsToDelete);
			}
		} else if (leftAttribute.get() instanceof TargetSectionAttribute) {

			String leftValue = ((TargetSectionAttribute) leftAttribute.get()).getValue();
			String rightValue = ((TargetSectionAttribute) rightAttribute).getValue();

			if (!NullComparator.compare(leftValue, rightValue)) {
				((TargetSectionAttribute) leftAttribute.get()).setValue(null);
			}

		} else {
			return false;
		}

		Set<EObject> merged = new HashSet<>();
		if (this.mergedElements.containsKey(leftAttribute.get())) {
			merged.addAll(this.mergedElements.get(leftAttribute.get()));
		}
		merged.add(rightAttribute);
		this.mergedElements.put(leftAttribute.get(), merged);

		return true;
	}

	/**
	 *
	 *
	 * @param left
	 * @param rightReference
	 */
	private boolean mergeReference(C left, R rightReference) {

		Optional<R> leftReference = left.getReferences().parallelStream()
				.filter(l -> l.getClass() == rightReference.getClass()
						&& l.getEReference().equals(rightReference.getEReference()))
				.findAny();

		// Simply add the reference
		//
		if (!leftReference.isPresent()) {
			left.getReferences().add(rightReference);
			return true;
		}

		// Nothing to be done
		//
		if (rightReference.getValuesGeneric().isEmpty()) {
			return true;
		}

		// For a single-valued reference, we cannot simply add the values (unless the 'size == 1'-constraint is
		// already
		// violated). Consequently, we try to merge the values...
		//
		if (!leftReference.get().getEReference().isMany() && leftReference.get().getValuesGeneric().size() == 1) {

			Set<C> valuesToMerge = Stream
					.concat(leftReference.get().getValuesGeneric().stream(), rightReference.getValuesGeneric().stream())
					.collect(Collectors.toSet());

			ClassMerger<S, C, R, A> subMerger = new ClassMerger<>(valuesToMerge);
			this.subMergers.add(subMerger);

			if (subMerger.canMerge()) {

				Set<EObject> merged = new HashSet<>();
				if (this.mergedElements.containsKey(leftReference.get())) {
					merged.addAll(this.mergedElements.get(leftReference.get()));
				}
				merged.add(rightReference);
				this.mergedElements.put(leftReference.get(), merged);

				subMerger.mergeClasses(valuesToMerge);
				return true;

			} else {

				return false;
			}
		}

		// In any other case, we simply add the values
		//
		leftReference.get().addValuesGeneric(rightReference.getValuesGeneric());

		Set<EObject> merged = new HashSet<>();
		if (this.mergedElements.containsKey(leftReference.get())) {
			merged.addAll(this.mergedElements.get(leftReference.get()));
		}
		merged.add(rightReference);
		this.mergedElements.put(leftReference.get(), merged);

		return true;
	}

	/**
	 * Find the longest common substring of two Strings. Copied from <a href=
	 * "https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Longest_common_substring#Java">Wikipedia</a>.
	 *
	 * @param S1
	 * @param S2
	 * @return
	 */
	private static String longestCommonSubstring(String S1, String S2) {

		int Start = 0;
		int Max = 0;
		for (int i = 0; i < S1.length(); i++) {
			for (int j = 0; j < S2.length(); j++) {
				int x = 0;
				while (S1.charAt(i + x) == S2.charAt(j + x)) {
					x++;
					if (i + x >= S1.length() || j + x >= S2.length()) {
						break;
					}
				}
				if (x > Max) {
					Max = x;
					Start = i;
				}
			}
		}
		return S1.substring(Start, Start + Max);
	}
}