/**
 *
 */
package pamtram.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import de.mfreund.pamtram.util.NullComparator;
import pamtram.PamtramPackage;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.ValueConstraint;

/**
 * A {@link Command} that can be used to merge multiple {@link Class Classes}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class ClassMergeCommand<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends CompoundCommand {

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = "ClassMergeCommand";

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = "Merges a set of Classes.";

	/**
	 * The set of {@link Class elements} to merge.
	 */
	protected Set<C> elementsToMerge;

	/**
	 * The set of {@link EObject elements} that need to be consulted when
	 * {@link #prepareRedirectCrossReferencesCommand(EObject, EObject) redirecting cross-references} after merging
	 * elements.
	 */
	protected Set<EObject> elementsOfInterest;

	protected EditingDomain domain;

	/**
	 * This constructs an instance of the generic command to convert an instance of a source type to an instance of the
	 * target type.
	 * <p />
	 * The actual conversion is performed by an instance of 'IConverter' that is called when the command is invoked.
	 * <p />
	 * Note: When using this constructor, the {@link #elementsOfInterest} are determined from all resources in the
	 * <em>domain</em>'s resource set.
	 *
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param elementsToMerge
	 *            The set of {@link Class elements} to merge.
	 *
	 * @see ClassMergeCommand#ClassMergeCommand(EditingDomain, Set, Set)
	 */
	public ClassMergeCommand(EditingDomain domain, Set<C> elementsToMerge) {
		super();
		this.domain = domain;
		this.setLabel(ClassMergeCommand.LABEL);
		this.setDescription(ClassMergeCommand.DESCRIPTION);

		this.elementsToMerge = elementsToMerge;
		this.elementsOfInterest = null;
	}

	/**
	 * This constructs an instance of the generic command to convert an instance of a source type to an instance of the
	 * target type.
	 * <p />
	 * The actual conversion is performed by an instance of 'IConverter' that is called when the command is invoked.
	 * <p />
	 * Note: This constructor should be used when merging elements that are not contained in a resource, otherwise
	 * {@link ClassMergeCommand#ClassMergeCommand(EditingDomain, Set, Set) ClassMergeCommand(EditingDomain, Set, Set)}
	 * should be used as this determines the {@link #elementsOfInterest} from all resources in the <em>domain</em>'s
	 * resource set.
	 *
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param elementsToMerge
	 *            The set of {@link Class elements} to merge.
	 * @param elementsOfInterest
	 *            The set of {@link EObject elements} that need to be consulted when
	 *            {@link #prepareRedirectCrossReferencesCommand(EObject, EObject) redirecting cross-references} after
	 *            merging elements.
	 *
	 * @see ClassMergeCommand#ClassMergeCommand(EditingDomain, Set)
	 */
	public ClassMergeCommand(EditingDomain domain, Set<C> elementsToMerge, Set<EObject> elementsOfInterest) {
		this(domain, elementsToMerge);

		this.elementsToMerge = elementsToMerge;
		this.elementsOfInterest = elementsOfInterest;
	}

	@Override
	protected boolean prepare() {

		// Initialize the various sub-commands
		//
		Iterator<C> it = this.elementsToMerge.iterator();

		C class1 = it.next();

		while (it.hasNext()) {
			C class2 = it.next();
			this.append(new InternalMergeClassCommand(this.domain, class1, class2, null));
		}

		return super.prepare();
	}

	/**
	 * Find the longest common substring of two Strings. Copied from <a href=
	 * "https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Longest_common_substring#Java">Wikipedia</a>.
	 *
	 * @param S1
	 * @param S2
	 * @return
	 */
	protected static String longestCommonSubstring(String S1, String S2) {

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

	private abstract class InternalMergeCommand<T extends MetaModelElement<S, C, R, A>> extends CompoundCommand {

		/**
		 * The set of {@link EObject elements} that need to be consulted when
		 * {@link #prepareRedirectCrossReferencesCommand(EObject, EObject) redirecting cross-references} after merging
		 * elements.
		 */
		protected Set<EObject> elementsOfInterest;

		protected C left;

		protected T right;

		protected EditingDomain domain;

		/**
		 * This constructs an instance.
		 *
		 * @param domain
		 *            The editing domain that the command operated on.
		 * @param left
		 * @param right
		 * @param elementsOfInterest
		 *            The set of {@link EObject elements} that need to be consulted when
		 *            {@link #prepareRedirectCrossReferencesCommand(EObject, EObject) redirecting cross-references}
		 *            after merging elements or <em>null</em> when the elements shall be determined from the resource
		 *            set associated with the given <em>domain</em>.
		 */
		public InternalMergeCommand(EditingDomain domain, C left, T right, Set<EObject> elementsOfInterest) {

			super();
			this.domain = domain;
			this.left = left;
			this.right = right;
			this.elementsOfInterest = elementsOfInterest;
		}

		/**
		 * After merging elements, this can be used to redirect all cross references to the given <em>mergedElement</em>
		 * to the element they have been merged into.
		 *
		 * @param mergedElement
		 *            The element that has been merged into the <em>newElement</em>.
		 * @param newElement
		 *            The element into which the <em>mergedElement</em> has been merged into.
		 */
		protected void prepareRedirectCrossReferencesCommand(T mergedElement, T newElement) {

			// Determine all cross references...
			//
			Collection<Setting> usages;

			if (this.elementsOfInterest != null) {
				usages = EcoreUtil.UsageCrossReferencer.find(mergedElement, this.elementsOfInterest);
			} else {
				usages = EcoreUtil.UsageCrossReferencer.find(mergedElement, this.domain.getResourceSet());
			}

			// ... and redirect them by creating appropriate SetCommands
			//
			usages.stream()
					.filter(usage -> !usage.getEStructuralFeature().isDerived()
							&& !usage.getEStructuralFeature().isTransient()
							&& usage.getEStructuralFeature() instanceof EReference)
					.forEach(usage -> {

						if (usage.getEStructuralFeature().isMany()) {
							this.append(new AddCommand(this.domain, usage.getEObject(), usage.getEStructuralFeature(),
									newElement));
						} else {
							this.append(new SetCommand(this.domain, usage.getEObject(), usage.getEStructuralFeature(),
									newElement));
						}

					});

			// Finally, we can create a command that deletes the now unused merged element
			//
			this.append(DeleteCommand.create(this.domain, mergedElement));
		}
	}

	private class InternalMergeClassCommand extends InternalMergeCommand<C> {

		/**
		 *
		 *
		 * @param domain
		 * @param left
		 * @param right
		 * @param elementsOfInterest
		 */
		public InternalMergeClassCommand(EditingDomain domain, C left, C right, Set<EObject> elementsOfInterest) {

			super(domain, left, right, elementsOfInterest);
		}

		@Override
		protected boolean prepare() {

			// Merge the names of the class
			//
			this.append(new SetCommand(this.domain, this.left, PamtramPackage.Literals.NAMED_ELEMENT__NAME,
					ClassMergeCommand.longestCommonSubstring(this.left.getName(), this.right.getName())));

			// Merge the attributes first
			//
			new ArrayList<>(this.right.getAttributes()).stream()
					.forEach(rightAttribute -> this.append(new InternalMergeAttributeCommand(this.domain, this.left,
							rightAttribute, this.elementsOfInterest)));

			// Now, merge the references
			//
			new ArrayList<>(this.right.getReferences()).stream()
					.forEach(rightReference -> this.append(new InternalMergeReferenceCommand(this.domain, this.left,
							rightReference, this.elementsOfInterest)));

			this.prepareRedirectCrossReferencesCommand(this.right, this.left);

			return super.prepare();
		}

	}

	private class InternalMergeAttributeCommand extends InternalMergeCommand<A> {

		/**
		 *
		 *
		 * @param domain
		 * @param left
		 * @param right
		 * @param elementsOfInterest
		 */
		public InternalMergeAttributeCommand(EditingDomain domain, C left, A right, Set<EObject> elementsOfInterest) {
			super(domain, left, right, elementsOfInterest);
		}

		@Override
		protected boolean prepare() {

			Optional<A> leftAttribute;

			if (this.right instanceof ActualAttribute<?, ?, ?, ?>) {
				leftAttribute = this.left.getAttributes().parallelStream()
						.filter(a -> a instanceof ActualAttribute<?, ?, ?, ?> && ((ActualAttribute<?, ?, ?, ?>) a)
								.getAttribute().equals(((ActualAttribute<?, ?, ?, ?>) this.right).getAttribute()))
						.findAny();
			} else {
				leftAttribute = this.left.getAttributes().parallelStream()
						.filter(a -> a.getName().equals(this.right.getName())).findAny();
			}

			// Simply add the attribute
			//
			if (!leftAttribute.isPresent()) {
				this.append(new AddCommand(this.domain, this.left, MetamodelPackage.Literals.CLASS__ATTRIBUTES,
						this.right));
				return super.prepare();
			}

			EqualityHelper equalityHelper = new EqualityHelper();

			// Merge the attributes
			//
			String mergedName;
			if (leftAttribute.get().getName().isEmpty()) {
				mergedName = this.right.getName();
			} else if (this.right.getName().isEmpty()) {
				mergedName = leftAttribute.get().getName();
			} else {
				mergedName = ClassMergeCommand.longestCommonSubstring(leftAttribute.get().getName(),
						this.right.getName());
			}

			this.append(new SetCommand(this.domain, leftAttribute.get(), PamtramPackage.Literals.NAMED_ELEMENT__NAME,
					mergedName));

			if (leftAttribute.get() instanceof SourceSectionAttribute) {

				// TODO find a better algorithm to merge constraints?
				List<ValueConstraint> leftConstraints = ((SourceSectionAttribute) leftAttribute.get())
						.getValueConstraint();
				List<ValueConstraint> rightConstraints = ((SourceSectionAttribute) this.right).getValueConstraint();

				if (leftConstraints.isEmpty() && rightConstraints.isEmpty()) {
					// nothing to be done
				} else if (leftConstraints.size() != rightConstraints.size()) {
					// delete all constraints
					this.append(DeleteCommand.create(this.domain, leftConstraints));
				} else {
					// delete those constraints that are not equal
					Set<ValueConstraint> constraintsToDelete = IntStream.range(0, leftConstraints.size())
							.filter(i -> !equalityHelper.equals(leftConstraints.get(i), rightConstraints.get(i)))
							.mapToObj(leftConstraints::get).collect(Collectors.toSet());

					if (!constraintsToDelete.isEmpty()) {
						this.append(new DeleteCommand(this.domain, constraintsToDelete));
					}
				}
			} else if (leftAttribute.get() instanceof TargetSectionAttribute) {

				String leftValue = ((TargetSectionAttribute) leftAttribute.get()).getValue();
				String rightValue = ((TargetSectionAttribute) this.right).getValue();

				if (!NullComparator.compare(leftValue, rightValue)) {
					this.append(new SetCommand(this.domain, leftAttribute.get(),
							MetamodelPackage.Literals.TARGET_SECTION_ATTRIBUTE__VALUE, null));
				}

			} else {
				return false;
			}

			this.prepareRedirectCrossReferencesCommand(this.right, leftAttribute.get());

			return super.prepare();
		}

	}

	private class InternalMergeReferenceCommand extends InternalMergeCommand<R> {

		/**
		 *
		 *
		 * @param domain
		 * @param left
		 * @param right
		 * @param elementsOfInterest
		 */
		public InternalMergeReferenceCommand(EditingDomain domain, C left, R right, Set<EObject> elementsOfInterest) {
			super(domain, left, right, elementsOfInterest);
		}

		@Override
		protected boolean prepare() {

			Optional<R> leftReference = this.left.getReferences().parallelStream().filter(
					l -> l.getClass() == this.right.getClass() && l.getEReference().equals(this.right.getEReference()))
					.findAny();

			// Simply add the reference
			//
			if (!leftReference.isPresent()) {
				this.append(new AddCommand(this.domain, this.left, MetamodelPackage.Literals.CLASS__REFERENCES,
						this.right));

				return super.prepare();
			}

			// Nothing to be done
			//
			if (this.right.getValuesGeneric().isEmpty()) {
				return true;
			}

			// For a single-valued reference, we cannot simply add the values (unless the 'size == 1'-constraint is
			// already
			// violated). Consequently, we try to merge the values...
			//
			if (!leftReference.get().getEReference().isMany() && leftReference.get().getValuesGeneric().size() == 1) {

				Set<C> valuesToMerge = Stream
						.concat(leftReference.get().getValuesGeneric().stream(), this.right.getValuesGeneric().stream())
						.collect(Collectors.toSet());

				// Initialize the various sub-commands
				//
				Iterator<C> it = valuesToMerge.iterator();

				C class1 = it.next();

				while (it.hasNext()) {
					C class2 = it.next();
					this.append(new InternalMergeClassCommand(this.domain, class1, class2, this.elementsOfInterest));
				}

				this.prepareRedirectCrossReferencesCommand(this.right, leftReference.get());

				return super.prepare();
			}

			// In any other case, we simply add the values
			//
			if (leftReference.get() instanceof ContainmentReference<?, ?, ?, ?>) {

				this.append(new AddCommand(this.domain, leftReference.get(),
						MetamodelPackage.Literals.CONTAINMENT_REFERENCE__VALUE, this.right.getValuesGeneric()));
			} else if (leftReference.get() instanceof NonContainmentReference<?, ?, ?, ?>) {
				this.append(new AddCommand(this.domain, leftReference.get(),
						MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE__VALUE, this.right.getValuesGeneric()));

			} else {
				return false;
			}

			return super.prepare();
		}

	}
}
