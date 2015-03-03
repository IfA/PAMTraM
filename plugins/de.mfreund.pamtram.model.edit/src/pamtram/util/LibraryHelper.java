package pamtram.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.impl.MetamodelFactoryImpl;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.util.impl.FileParserImpl;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;


/**
 * This class provides convenience functions to work with library items.
 * 
 * @author mfreund
 */
public class LibraryHelper {

	/**
	 * This method converts a LibraryEntry represented by a given path to the library file and a 
	 * relative path inside the library file to a pamtram LibraryEntry. Therefore, it generates {@link LibraryParameter}s 
	 * for every {@link AbstractAttributeParameter}, {@link AbstractContainerParameter} and 
	 * {@link AbstractExternalReferenceParameter} that it encounters. 
	 * 
	 * @param libraryFile The path to a library file (Zip or Jar).
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @param targetEPackage The target ePackage of the pamtram model into that the generated library
	 * element shall be inserted later on.
	 * @param uri The URI where the resource created for the library element shall be stored.
	 * @return The generated LibraryEntry.
	 * @throws IOException If something goes wrong during loading the libraryFile or the XMI file inside
	 * the library file representing the LibraryEntry. 
	 */
	public static LibraryEntry convertToLibraryElement(String libraryFile, String path,
			EPackage targetEPackage, URI uri) throws IOException {
		
		//TODO maybe use a factory pattern for this?
		LibraryElementConverter converter =
				(new LibraryHelper()).new LibraryElementConverter(libraryFile, path, targetEPackage, uri);
		
		return converter.convert();
	}
	

	/**
	 * This determines the LibraryFileEntry identified by a given combination of a library file and a path
	 * inside the library file.
	 * 
	 * @param libraryFile The path to a library file (Zip or Jar).
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @return The LibraryFileEntry identified by the given combination of libraryFile and path; null
	 * if the LibraryFileEntry could not be determined.
	 * @throws IOException If something goes wrong during loading the libraryFile. 
	 */
	public static LibraryFileEntry getLibraryFileEntry(String libraryFile, String path) throws IOException {
		
		// get the library elements in the specified library file
		List<LibraryFileEntry> entries = (new FileParserImpl()).parseFile((new File(libraryFile)).toPath());
		
		// iterate over the entries to find the one that matches the given path
		for (LibraryFileEntry libraryFileEntry : entries) {
			if(libraryFileEntry.getKey().equals(path)) {
				return libraryFileEntry;
			}
		}
		return null;
	}

	/**
	 * This determines the LibraryEntry identified by a given combination of a library file and a path
	 * inside the library file.
	 * 
	 * @param libraryFile The path to a library file (Zip or Jar).
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @return The LibraryEntry identified by the given combination of libraryFile and path; null
	 * if the LibraryEntry could not be determined.
	 * @throws IOException If something goes wrong during loading the libraryFile or the XMI file inside
	 * the library file representing the LibraryEntry. 
	 */
	public static de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry 
			getLibraryEntry(LibraryFileEntry entry) throws IOException {
		
		if(entry == null) {
			return null;
		}
		
		// try to load the resource
		InputStream inputStream = entry.getXMIFileAsInputStream();
		Resource resource = new XMIResourceImpl();
		resource.load(inputStream, null);
		inputStream.close();
		// get the library entry from the resource contents and return it
		if(!(resource.getContents() == null) && !resource.getContents().isEmpty() &&
				resource.getContents().get(0) instanceof de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) {
			return (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) resource.getContents().get(0);
		}
		
		return null;
	}
	
	/**
	 * This is an internal class that is used by the 'convertToLibraryElement()' functions to 
	 * generate a LibraryElement.
	 * 
	 * @author mfreund
	 *
	 */
	private class LibraryElementConverter {
		
		/**
		 * This is the path to the library file that the converter works on.
		 */
		final private String libraryFile;
		
		/**
		 * This is the path inside a library file pointing to a library file element
		 * that shall be converted.
		 */
		final private String path;
		
		/**
		 * This is the set of target ePackages of the pamtram model into that the generated library
		 * element shall be inserted later on. This list contains the main ePackage and all of its children
		 * ePackages.
		 */
		final private HashSet<EPackage> targetEPackages;
		
		/**
		 * This is the LibraryFileEntry that this converter shall convert.
		 */
		private LibraryFileEntry libFileEntry;
		
		/**
		 * This is the LibraryEntry that the LibraryFileEntry is associated with.
		 */
		private de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libEntry;
		
		/**
		 * This is the generated LibraryEntry.
		 */
		private LibraryEntry pamtramLibEntry;

		/**
		 * The URI where the resource created for the library element shall be stored.
		 */
		private URI uri;
		
		/**
		 * This constructs an instance of the LibraryElementConverter.
		 * 
		 * @param libraryFile The path to a library file (Zip or Jar).
		 * @param path The path of the library entry inside the library (e.g. 'my.path').
		 * @param targetEPackage The target ePackage of the pamtram model into that the generated library
		 * element shall be inserted later on.
		 * @param uri The URI where the resource created for the library element shall be stored.
		 */
		public LibraryElementConverter(String libraryFile, String path,
			EPackage targetEPackage, URI uri) {
			this.libraryFile = libraryFile;
			this.path = path;
			this.targetEPackages = EPackageHelper.collectEPackages(targetEPackage);
			this.uri = uri;
		}
		
		/**
		 * This performs the actual conversion from the {@link LibraryFileEntry} to a {@link LibraryEntry}. 
		 * @return The generated LibraryElement.
		 * @throws IOException 
		 */
		public LibraryEntry convert() throws IOException {
			
			// first, determine the LibraryFileEntry and LibraryEntry to be converted
			libFileEntry = getLibraryFileEntry(libraryFile, path);
			libEntry = getLibraryEntry(libFileEntry);
			
			storeLibraryEntry(libEntry, uri.appendSegment(path).appendSegment("data.xmi"));
			
			// create the LibraryElement to be returned
			pamtramLibEntry = MetamodelFactoryImpl.eINSTANCE.createLibraryEntry();
			
			// set the path, version, etc.
			pamtramLibEntry.setVersion(libEntry.getVersion() != null ? libEntry.getVersion() : "");
			pamtramLibEntry.setPath(libFileEntry.getKey());
			pamtramLibEntry.setLibraryFile(libraryFile);
			
			pamtramLibEntry.setOriginalLibraryEntry(libEntry);
			
			if(libEntry.getParameterDescription() == null) {
				return pamtramLibEntry;
			}
			
			/*
			 * Create and populate a Pamtram AttributeParameter for every Genlib AttributeParameter
			 */
			for (AbstractAttributeParameter<EObject> attParameter : libEntry.getParameterDescription().getAttributeParameters()) {
				
				AttributeParameter param = MetamodelFactoryImpl.eINSTANCE.createAttributeParameter();
				param.setName(attParameter.eClass().getName());
				param.setSource(attParameter.getSource());
				
				ActualAttribute attribute = MetamodelFactoryImpl.eINSTANCE.createActualAttribute();
				attribute.setAttribute(attParameter.getAttribute());
				attribute.setName(attParameter.getAttribute().getName());
				
				param.setAttribute(attribute);
				
				pamtramLibEntry.getParameters().add(param);
				
			}

			/*
			 * Create and populate a Pamtram ContainerParameter for every Genlib ContainerParameter
			 */
			for (AbstractContainerParameter<EObject, EObject> contParameter : libEntry.getParameterDescription().getContainerParameters()) {
				
				ContainerParameter param = MetamodelFactoryImpl.eINSTANCE.createContainerParameter();
				param.setName(contParameter.eClass().getName());
				param.setSource(contParameter.getSource());
				
				TargetSectionClass clazz = MetamodelFactoryImpl.eINSTANCE.createTargetSectionClass();
				clazz.setEClass(contParameter.getSource().eClass());
				clazz.setName(contParameter.getSource().eClass().getName());
				
				param.setClass(clazz);
				
				pamtramLibEntry.getParameters().add(param);
				
			}
			
			/*
			 * Create and populate a Pamtram ExternalReferenceParameter for every Genlib ExternalReferenceParameter
			 */
			for (AbstractExternalReferenceParameter<EObject, EObject> extRefParameter : libEntry.getParameterDescription().getExternalReferenceParameters()) {
				
				EObject source = extRefParameter.getSource();

				// search for cross references to the old source object from
				// the library item
				Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(source, libEntry);

				// create a paramter for every setting
				for (Setting setting : crossReferences) {
					ExternalReferenceParameter param = MetamodelFactoryImpl.eINSTANCE.createExternalReferenceParameter();
					param.setName(extRefParameter.eClass().getName());
					param.setSource(setting.getEObject());
					
					TargetSectionNonContainmentReference ref = MetamodelFactoryImpl.eINSTANCE.createTargetSectionNonContainmentReference();
					ref.setEReference((EReference) setting.getEStructuralFeature());
					ref.setName(setting.getEStructuralFeature().getName());
					
					param.setReference(ref);
					
					pamtramLibEntry.getParameters().add(param);
				}
			}
			
			return pamtramLibEntry;
		}
		
		private void storeLibraryEntry(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libEntry, URI uri) throws IOException {
			
			if(libEntry == null) {
				return;
			}
		
			// create a resource and add the library entry
			Resource resource = new XMIResourceImpl(uri);
			resource.getContents().add(libEntry);
			
			// try to save the resource
			resource.save(null);
		}
	}
	
}
