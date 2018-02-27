/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Collections;
import java.util.Set;

import pamtram.structure.target.FileType;

/**
 *
 * @author mfreund
 */
public class VisuPlusTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "visu-plus";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.visu-plus/Source/beispiel_ver_0_2_3.xml");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.visu-plus/Pamtram/visu-plus.pamtram");
	}

	@Override
	protected FileType getTargetModelType() {

		return FileType.XML;
	}

}
