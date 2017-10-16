/**
 *
 */
package de.mfreund.gentrans.transformation.standalone;

import java.util.Arrays;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.mfreund.gentrans.transformation.ITransformationRunner;
import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.mfreund.gentrans.transformation.TransformationRunnerFactory;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl;
import pamtram.PAMTraM;
import pamtram.impl.PamtramPackageImpl;

/**
 *
 * @author mfreund
 */
public class StandaloneGenTransRunner {

	private static final String ABORTING = "Aborting...";

	/**
	 * Transforms a given input model by means of a given {@link PAMTraM} model.
	 * <p />
	 * This expects exactly three arguments:
	 * <ol>
	 * <li>the absolute path to a PAMTraM file</li>
	 * <li>the absolute file to a source model to be transformed</li>
	 * <li>the absolute path to a folder where the target model(s) shall be stored</li>
	 * </ol>
	 *
	 * @param args
	 *            The arguments specifying the transformation (see above).
	 */
	public static void main(String[] args) {

		if (args.length != 3) {
			System.err.println(
					"Please provide exactly three arguments:\n\t " + "1. the absolute path to a PAMTraM file\n\t "
							+ "2. the absolute file to a source model to be transformed\n\t "
							+ "3. the absolute path to a folder where the target model shall be stored");
			System.err.println(StandaloneGenTransRunner.ABORTING);
			return;
		}

		// Initialize the PAMTraM and GenLibrary packages (required as we run outside Eclipse)
		//
		PamtramPackageImpl.init();
		GenLibraryPackageImpl.init();

		// Load the required models
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		EObject pamtram = StandaloneGenTransRunner.loadModel(resourceSet, args[0]);

		if (pamtram == null || !(pamtram instanceof PAMTraM)) {
			System.err.println("The specified PAMTraM File does not seem to contain a PAMTraM model!");
			System.err.println(StandaloneGenTransRunner.ABORTING);
			return;
		}

		EObject sourceModel = StandaloneGenTransRunner.loadModel(resourceSet, args[1]);

		if (sourceModel == null) {
			System.err.println("The specified Source Model File does not seem to contain an XMI/XML model!");
			System.err.println(StandaloneGenTransRunner.ABORTING);
			return;
		}

		// Create the transformation runner
		//
		TransformationConfiguration config = TransformationConfiguration
				.createInstanceFromSourceModels(Arrays.asList(sourceModel), Arrays.asList((PAMTraM) pamtram), args[2]);
		config.withLogLevel(Level.INFO).withDefaultTargetModel("target-model.xmi");
		ITransformationRunner runner = TransformationRunnerFactory.INSTANCE.createGenericTransformationRunner(config);

		// Execute the transformation
		//
		runner.run();

	}

	private static EObject loadModel(ResourceSet resourceSet, String path) {

		// the URI of the source resource
		//
		URI uri = URI.createFileURI(path);

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
