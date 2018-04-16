/*******************************************************************************
 * Copyright (C) 2018-2018  and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package amlToXmi;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import CAEX.util.CAEXResourceFactoryImpl;
import CAEX.util.CaexPreprocessor;
import CAEX.util.CaexSerializer;

/**
 * This class makes use of the {@link CaexSerializer} to convert an XML-based
 * AML document to an Ecore/XMI-based version.
 *
 * @author mfreund
 */
public class AML2XMIConverter {

	/**
	 * This converts an an XML-based AML document to an Ecore/XMI-based version
	 * using {@link CaexSerializer#writeXMI(File, ResourceSet, String)}.
	 * <p />
	 * This method expects one or two arguments:
	 * <ol>
	 * <li>The path (relative to the project root) of the source file to be
	 * converted (e.g. 'Source/aml-model.aml'). The source file needs to be an
	 * XML-based AML document.</li>
	 * <li>Optional: The path (relative to the project root) of the (XMI-based)
	 * target file to be created (e.g. 'Source/aml-model.xmi'). If no second
	 * argument is given, the created file will be stored in the path resulting from
	 * replacing the file ending of the given source path by '.xmi'.</li>
	 * </ol>
	 *
	 */
	public static void main(String[] args) {

		if (args.length == 0 || args.length > 2) {
			System.err.println(
					"This method expects either one or two arguments: The project-relative path to the source "
					+ "file to be converted (e.g. 'Source/aml-model.aml') and - optional - the project-relative "
					+ "path to the target file to be created (e.g. 'Source/aml-model.xmi').");
			return;
		}
		
		String sourcePath = args[0];
		
		File sourceFile = new File(sourcePath);
		
		if(!sourceFile.exists()) {
			System.err.println("Source file '" + sourcePath + "' not found!");
			return;
		}
		
		URI sourceURI = URI.createURI(sourcePath);
		
		String sourceFileExtension = sourceURI.fileExtension();
		
		String targetPath = "";
		
		if(args.length == 2) {
			targetPath = args[1];
		} else {
			targetPath = args[0];
			targetPath = targetPath.split("\\." + sourceFileExtension)[0] + ".xmi";
		}
		
		String targetFileExtension = URI.createURI(targetPath).fileExtension();

		ResourceSet resourceSet = new ResourceSetImpl();

		ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap().put(sourceFileExtension, new CAEXResourceFactoryImpl());

		ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap().put(targetFileExtension, new XMIResourceFactoryImpl());

		try {
			CaexPreprocessor.removeAdditionalInformation(sourcePath);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		CaexSerializer serializer = new CaexSerializer();
		try {
			serializer.writeXMI(sourceFile, resourceSet, targetPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
