/**
 *
 * $Id$
 */
package pamtram.metamodel.validation;

import pamtram.metamodel.SourceSectionClass;

/**
 * A sample validator interface for {@link pamtram.metamodel.SourceSectionReference}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SourceSectionReferenceValidator {
	boolean validate();

	boolean validateOwningClass(SourceSectionClass value);
}
