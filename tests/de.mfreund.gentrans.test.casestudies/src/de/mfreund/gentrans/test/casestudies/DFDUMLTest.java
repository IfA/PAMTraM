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
public class DFDUMLTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "dfd-uml";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.dfd-uml/Source/Temperaturmessung.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.dfd-uml/Pamtram/dfd-uml.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		return super.getTransformationConfig().withMaxPathLength(0);
	}

}
