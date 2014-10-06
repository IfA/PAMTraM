/**
 *
 * $Id$
 */
package pamtram.mapping.validation;

import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionClass;

/**
 * A sample validator interface for {@link pamtram.mapping.CardinalityMapping}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CardinalityMappingValidator {
	boolean validate();

	boolean validateSource(SourceSectionClass value);
	boolean validateTarget(TargetSectionClass value);
}
