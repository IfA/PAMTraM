/**
 *
 * $Id$
 */
package pamtram.metamodel.validation;

import org.eclipse.emf.common.util.EList;

import pamtram.metamodel.TargetSectionClass;

/**
 * A sample validator interface for {@link pamtram.metamodel.TargetSectionContainmentReference}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TargetSectionContainmentReferenceValidator {
	boolean validate();

	boolean validateValue(EList<TargetSectionClass> value);
}