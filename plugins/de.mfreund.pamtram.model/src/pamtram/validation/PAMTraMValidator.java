/**
 *
 * $Id$
 */
package pamtram.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;

import pamtram.MappingModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * A sample validator interface for {@link pamtram.PAMTraM}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface PAMTraMValidator {
	boolean validate();

	boolean validateContextMetaModelPackage(EList<EPackage> value);
	boolean validateSourceSectionModel(SourceSectionModel value);
	boolean validateTargetSectionModel(TargetSectionModel value);
	boolean validateMappingModel(MappingModel value);
}
