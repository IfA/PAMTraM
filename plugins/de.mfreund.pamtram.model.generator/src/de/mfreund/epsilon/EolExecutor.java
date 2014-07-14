package de.mfreund.epsilon;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.dt.userinput.JFaceUserInput;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository;

public class EolExecutor {
	
	private HashMap<String, IModel> models;

	public EolExecutor() {
		models = new HashMap<String, IModel>();
	}

	public HashMap<String, IModel> getModels() {
		return models;
	}
	
	// load a model and add it to the model repository
	public void loadModel(String modelName, String metamodelUri,
			String modelPath, boolean readOnLoad, boolean storeOnDisposal) throws EolModelLoadingException {
		
		System.out.println("Loading " + modelName + " model for EOL transformation.");
		
		// load EMF model
		EmfModel model = new EmfModel();
		model.setName(modelName);
		if(metamodelUri != null){
			model.setMetamodelUri(metamodelUri);
		}
		model.setModelFileUri(URI.createFileURI(modelPath));
		model.setReadOnLoad(readOnLoad);
		model.setStoredOnDisposal(storeOnDisposal);
		model.load();
		
		// add to list of loaded models
		models.put(modelPath, model);
	}
	
	// disposes all models that have been loaded
	public void disposeModels() {
		Iterator <String> it = models.keySet().iterator(); 
		while(it.hasNext()) {
			String next = it.next(); 
			models.get(next).dispose();
			models.remove(next);
		}	
	}
	
	// disposes a model
	public void disposeModel(String modelPath) {
		
		IModel model = models.get(modelPath);
		if(model == null) {
			return;
		}
		model.dispose();
		models.remove(modelPath);
	}
	
	// loads and executes an eol file
	public Object executeEol(URL eolFile, HashMap<String, Object> params) {
	
		// get the file
		File file;
		try {
			file = new File(FileLocator.resolve(eolFile).toURI());
		}
		catch (Exception e1) {
			disposeModels();
			throw new RuntimeException(e1);
		}
		
		return executeEol(file, params);
	}
	
	// loads and executes an eol file
	public Object executeEol(File eolFile, HashMap<String, Object> params) {
		try {
						
			// create and load etlModule from path
			EolModule eolModule = new EolModule();
			//eolModule.parse(new File(path));
			eolModule.parse(eolFile);
			
			// test for parsing errors of the path
			if (eolModule.getParseProblems().size() > 0) {
				System.err.println("Parse errors occured...");
				for (ParseProblem problem : eolModule.getParseProblems()) {
					System.err.println(problem.toString());
				}
				System.exit(-1);
			}
			
			// Set new UserInput for System.user.choose to work
			eolModule.getContext().setUserInput(new JFaceUserInput(new PrettyPrinterManager()));
			
			// Fix for new Native...
			eolModule.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
			
			// Make the source and destination models available to the transformation
			final ModelRepository eolModelRepo = eolModule.getContext().getModelRepository();
			
			// Iterate over loaded Models
			Iterator <IModel> it = models.values().iterator(); 
			while(it.hasNext()) {
				eolModelRepo.addModel(it.next());
			}
			
			// load variables into ETL
			for (String paramName : params.keySet()) {
				eolModule.getContext().getFrameStack().put(Variable.createReadOnlyVariable(paramName, params.get(paramName)));
			}
			
			// start the transformation
			Object ret =  eolModule.execute();
			System.out.println("EolModule " + eolFile.getAbsolutePath() + " successfully executed.");
			return ret;
		}
		catch (Exception e) {
			disposeModels();
			throw new RuntimeException(e);
		}
	}
}
