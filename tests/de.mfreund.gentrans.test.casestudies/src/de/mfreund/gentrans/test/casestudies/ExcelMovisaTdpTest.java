/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Collections;
import java.util.Set;

/**
 *
 * @author mfreund
 */
public class ExcelMovisaTdpTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "excel-movisa-tdp";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.excel-movisa-tdp/Source/Variablen.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections
				.singleton("/de.mfreund.pamtram.casestudies.excel-movisa-tdp/Pamtram/excel-movisa-tdp.pamtram");
	}

}
