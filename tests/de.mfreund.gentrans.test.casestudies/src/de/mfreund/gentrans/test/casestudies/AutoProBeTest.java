/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import de.mfreund.gentrans.transformation.ITransformationRunner;
import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.mfreund.gentrans.transformation.TransformationConfiguration.InitializationException;
import de.mfreund.gentrans.transformation.TransformationRunnerFactory;

/**
 *
 * @author mfreund
 */
public class AutoProBeTest {

	private static final String ABORTING = "Aborting...";

	@Test
	public void autoProBeCaseStudyShouldProduceCorrectResult() {

		String sourceModelPath = "/de.mfreund.pamtram.casestudies.autoprobe/Source/beispiel_ver_0_2_3.xml";
		String pamtramModelPath = "/de.mfreund.pamtram.casestudies.autoprobe/Pamtram/STGML2Movisa_enhanced.pamtram";
		String targetBasePath = "de.mfreund.gentrans.test/src/de/mfreund/gentrans/test/casestudies";
		String libPath = "D:\\git-repos\\de.tud.et.ifa.agtele.autoprobe\\de.tud.et.ifa.agtele.autoprobe.resources\\lib";

		// // Initialize the PAMTraM and GenLibrary packages (required as we run outside Eclipse)
		// //
		// PamtramPackageImpl.init();
		// GenLibraryPackageImpl.init();

		// Load the required models
		//
		// ResourceSet resourceSet = new ResourceSetImpl();
		//
		// EObject pamtram = this.loadModel(resourceSet, pamtramModelPath);
		//
		// if (pamtram == null || !(pamtram instanceof PAMTraM)) {
		// System.err.println("The specified PAMTraM File does not seem to contain a PAMTraM model!");
		// System.err.println(AutoProBeTest.ABORTING);
		// return;
		// }
		//
		// EObject sourceModel = this.loadModel(resourceSet, sourceModelPath);
		//
		// if (sourceModel == null) {
		// System.err.println("The specified Source Model File does not seem to contain an XMI/XML model!");
		// System.err.println(AutoProBeTest.ABORTING);
		// return;
		// }

		// Create the transformation runner
		//
		TransformationConfiguration config;
		try {
			config = TransformationConfiguration.createInstanceFromSourcePaths(Collections.singleton(sourceModelPath),
					Collections.singleton(pamtramModelPath), targetBasePath);
		} catch (InitializationException e) {
			System.err.println(e.getMessage());
			return;
		}
		// TransformationConfiguration config = TransformationConfiguration.createInstanceFromSourceModels(
		// Arrays.asList(sourceModel), Arrays.asList((PAMTraM) pamtram), targetBasePath);
		config.withLogLevel(Level.INFO).withDefaultTargetModel("target-model.xmi").withLibPaths(Arrays.asList(libPath))
				.withLogLevel(Level.WARNING).withMaxPathLength(0).withOpenTargetModelOnCompletion(false)
				.withOnlyAskOnceOnAmbiguousMappings(true).withUseParallelization(false);
		ITransformationRunner runner = TransformationRunnerFactory.INSTANCE.createGenericTransformationRunner(config);

		// Execute the transformation
		//
		runner.run();

	}

	protected EObject loadModel(ResourceSet resourceSet, String path) {

		// the URI of the source resource
		//
		URI uri = URI.createPlatformResourceURI(path, true);

		if (!Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().containsKey(uri.fileExtension())) {

			// Register the file extension. We assume XMI models unless the file extension is '.xml'
			//
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(uri.fileExtension(),
					uri.fileExtension().equalsIgnoreCase(".xml") ? new GenericXMLResourceFactoryImpl()
							: new XMIResourceFactoryImpl());
		}

		// Load source model
		//
		Resource sourceResource = resourceSet.getResource(uri, true);

		return sourceResource.getContents().isEmpty() ? null : sourceResource.getContents().get(0);
	}

}
