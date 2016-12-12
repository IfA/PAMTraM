package de.mfreund.pamtram.model.generator;

import pamtram.PAMTraM;
import pamtram.structure.Section;

/**
 * An enum describing the types of {@link Section Sections} that can be created by an instance of
 * {@link GeneratorWizard} for a selected {@link PAMTraM} model.
 *
 * @author mfreund
 */
enum SectionType {
	NONE, SOURCE, TARGET, BOTH
}
