/**
 *
 */
package pamtram.commands;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.util.ClassMerger;

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
		extends AbstractOverrideableCommand {

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
	 * {@link #redirectCrossReferences(EObject, EObject) redirecting cross-references} after merging elements.
	 */
	protected Set<EObject> elementsOfInterest;

	/**
	 * The {@link ClassMerger} that is used to merge the {@link #elementsToMerge}.
	 */
	protected ClassMerger<S, C, R, A> merger;

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
		super(domain, ClassMergeCommand.LABEL, ClassMergeCommand.DESCRIPTION);

		this.elementsToMerge = elementsToMerge;
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
	 *            {@link #redirectCrossReferences(EObject, EObject) redirecting cross-references} after merging
	 *            elements.
	 *
	 * @see ClassMergeCommand#ClassMergeCommand(EditingDomain, Set)
	 */
	public ClassMergeCommand(EditingDomain domain, Set<C> elementsToMerge, Set<EObject> elementsOfInterest) {
		super(domain, ClassMergeCommand.LABEL, ClassMergeCommand.DESCRIPTION);

		this.elementsToMerge = elementsToMerge;
		this.elementsOfInterest = elementsOfInterest;
	}

	@Override
	public void doExecute() {

		// Merge the elements using the special merger class
		//
		this.merger.merge();

		// Redirect all references to 'mergedElements' to the elements they have been merged into
		//
		this.merger.getMergedElements().entrySet().stream().forEach(merged -> merged.getValue().stream()
				.forEach(mergedElement -> this.redirectCrossReferences(mergedElement, merged.getKey())));

		// Finally, we delete the merged elements and update/refresh the viewers
		//
		Set<EObject> elementsToDelete = this.merger.getMergedElements().values().stream().flatMap(Set::stream)
				.collect(Collectors.toSet());
		elementsToDelete.addAll(this.merger.getDeletedElements());

		elementsToDelete.stream().forEach(EcoreUtil::delete);

	}

	/**
	 * After merging elements, this can be used to redirect all cross references to the given <em>mergedElement</em> to
	 * the element they have been merged into.
	 *
	 * @param mergedElement
	 *            The {@link EObject element} that has been merged into the <em>newElement</em>.
	 * @param newElement
	 *            The {@link EObject element} into which the <em>mergedElement</em> has been merged into.
	 */
	@SuppressWarnings("unchecked")
	protected void redirectCrossReferences(EObject mergedElement, EObject newElement) {

		// Determine all cross references...
		//
		Collection<Setting> usages;

		if (this.elementsOfInterest != null) {
			usages = EcoreUtil.UsageCrossReferencer.find(mergedElement, this.elementsOfInterest);
		} else {
			usages = EcoreUtil.UsageCrossReferencer.find(mergedElement, this.domain.getResourceSet());
		}

		// ... and redirect them
		//
		usages.stream().filter(usage -> !usage.getEStructuralFeature().isDerived()
				&& !usage.getEStructuralFeature().isTransient() && usage.getEStructuralFeature() instanceof EReference)
				.filter(usage -> !EcoreUtil.isAncestor(this.elementsToMerge, usage.getEObject())).forEach(usage -> {

					if (usage.getEStructuralFeature().isMany()) {
						((Collection<EObject>) usage.get(true)).add(newElement);
					} else {
						usage.set(newElement);
					}
				});
	}

	@Override
	protected boolean prepare() {

		// Initialize the 'merger' and check if it can merge the 'elementsToMerge'
		//
		this.merger = new ClassMerger<>(this.elementsToMerge);
		return this.merger.canMerge();
	}

	@Override
	public void doUndo() {

		// TODO Auto-generated method stub

	}

	@Override
	public void doRedo() {

		// TODO Auto-generated method stub

	}

}
