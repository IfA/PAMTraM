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
public class AMLOPCUATest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "aml-opcua";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections
				.singleton("/de.mfreund.pamtram.casestudies.aml-opc-ua/Source/Kleinversuchsanlage_PandIX_AML_Libs.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.aml-opc-ua/Pamtram/aml-opc-ua.pamtram");
	}

	@Override
	protected FileType getTargetModelType() {

		return FileType.XML;
	}
}
