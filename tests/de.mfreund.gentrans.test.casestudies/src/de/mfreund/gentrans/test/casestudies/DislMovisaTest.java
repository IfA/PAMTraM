/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Collections;
import java.util.Set;

import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 *
 * @author mfreund
 */
public class DislMovisaTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "disl-movisa";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.disl-movisa/Source/usecase_simple.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.disl-movisa/Pamtram/Disl2Movisa.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		return super.getTransformationConfig().withDefaultTargetModel("out.movisa.xmi").withMaxPathLength(0);
	}

}
