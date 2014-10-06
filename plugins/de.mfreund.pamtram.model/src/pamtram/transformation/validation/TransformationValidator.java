/**
 *
 * $Id$
 */
package pamtram.transformation.validation;

import org.eclipse.emf.common.util.EList;

import pamtram.transformation.TransformationMapping;

/**
 * A sample validator interface for {@link pamtram.transformation.Transformation}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface TransformationValidator {
	boolean validate();

	boolean validateTransformationMapping(EList<TransformationMapping> value);
	boolean validateName(String value);
	boolean validateId(String value);
}
