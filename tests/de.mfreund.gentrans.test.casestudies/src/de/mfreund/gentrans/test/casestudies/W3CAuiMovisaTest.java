/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 *
 * @author mfreund
 */
public class W3CAuiMovisaTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "w3caui-movisa";
	}

	@Override
	protected Set<String> getSourceModels() {

		return new HashSet<>(
				Arrays.asList("/de.mfreund.pamtram.casestudies.w3caui-movisa/Source/Kleinversuchsanlage.xmi",
						"/de.mfreund.pamtram.casestudies.w3caui-movisa/Source/PMbase1.xmi"));
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.w3caui-movisa/Pamtram/w3caui-movisa.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		return super.getTransformationConfig().withMaxPathLength(0);
	}

}
