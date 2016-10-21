/**
 *
 * $Id$
 */
package pamtram.mapping.validation;

import pamtram.mapping.Matcher;

import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * A sample validator interface for {@link pamtram.mapping.ReferenceTargetSelector}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MappingInstanceSelectorValidator {
	boolean validate();

	boolean validateAffectedReference(TargetSectionNonContainmentReference value);
	boolean validateMatcher(Matcher value);
}
