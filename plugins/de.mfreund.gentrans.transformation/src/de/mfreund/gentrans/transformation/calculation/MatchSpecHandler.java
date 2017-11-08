/**
 *
 */
package de.mfreund.gentrans.transformation.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.MatchSpecElement;
import pamtram.impl.MatchSpecElementImpl;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Reference;

/**
 * A simple util class to evaluate {@link MatchSpecElement MatchSpecElements}.
 *
 * @author mfreund
 */
public class MatchSpecHandler {

	/**
	 * This can be used to check whether the given <em>matchedElement</em> fulfills the
	 * {@link MatchSpecElementImpl#getReferenceMatchSpec() referenceMatchSpec} of the given <em>matchSpecElement</em>
	 * starting the evaluation from the given <em>root</em> element.
	 *
	 * @param root
	 *            The {@link EObject} from which to start the evaluation.
	 * @param matchedElement
	 *            The {@link EObject} to check.
	 * @param matchSpecElement
	 *            The {@link MatchSpecElement} to evaluate.
	 * @param logger
	 *            A {@link Logger} that shall be used to report errors.
	 * @return '<em>true</em>' if the match spec if fulfilled; '<em>false</em>' otherwise.
	 */
	public static boolean conformsMatchedObject(EObject root, EObject matchedElement,
			MatchSpecElement<?, ?, ?, ?> matchSpecElement, Logger logger) {

		return MatchSpecHandler.conformsMatchedObject(root, matchedElement,
				new ArrayList<>(matchSpecElement.getReferenceMatchSpec()), logger);
	}

	protected static boolean conformsMatchedObject(EObject root, EObject matchedElement,
			List<Reference<?, ?, ?, ?>> referenceMatchSpec, Logger logger) {

		// Create a local copy first
		//
		List<Reference<?, ?, ?, ?>> localReferenceSegments = new ArrayList<>(referenceMatchSpec);

		Reference<?, ?, ?, ?> firstSegment = localReferenceSegments.remove(0);

		if (firstSegment instanceof ActualReference<?, ?, ?, ?>) {

			if (!root.eClass().getEAllReferences()
					.contains(((ActualReference<?, ?, ?, ?>) firstSegment).getEReference())) {
				logger.severe("Faulty Reference Match Spec encountered!");
				return false;
			}

			List<Object> values = AgteleEcoreUtil.getStructuralFeatureValueAsList(root,
					((ActualReference<?, ?, ?, ?>) firstSegment).getEReference());
			if (localReferenceSegments.isEmpty()) {
				return values.contains(matchedElement);
			} else {
				return !localReferenceSegments.isEmpty()
						&& values.stream().filter(v -> v instanceof EObject).anyMatch(v -> MatchSpecHandler
								.conformsMatchedObject((EObject) v, matchedElement, localReferenceSegments, logger));
			}

		} else {
			logger.severe("Reference Match Specs based on VirtualReferences are not yet supported!");
			return false;
		}
	}
}
