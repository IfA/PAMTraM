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
public class AMLOPCUASimpleTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "aml-opcua-simple";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.aml-opc-ua/Source/Topology.xmi");
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
