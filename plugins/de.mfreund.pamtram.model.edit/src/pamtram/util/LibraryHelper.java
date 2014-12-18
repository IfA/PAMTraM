package pamtram.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.LibraryElement;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.impl.MetamodelFactoryImpl;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;
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
	 * relative path inside the library file to a pamtram LibraryElement. Therefore, it iterates
	 * through the library entry and generates TargetSectionClasses, -References and -Attributes
	 * for every model element it encounters if its type is represented in the target metamodel.
	 * Consequently, no Classes, References or Attributes are created for the 'library' types like
	 * 'MetaData', 'Resource' and so on. In order to be able to determine, if an element is part of 
	 * the target metamodel, the target ePackage has to be passed as parameter.
	 * 
	 * @param libraryFile The path to a library file (Zip or Jar).
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @param targetEPackage The target ePackage of the pamtram model into that the generated library
	 * element shall be inserted later on.
	 * @return The generated LibraryElement.
	 * @throws IOException If something goes wrong during loading the libraryFile or the XMI file inside
	 * the library file representing the LibraryEntry. 
	 */
	public static LibraryElement convertToLibraryElement(String libraryFile, String path,
			EPackage targetEPackage) throws IOException {
		
		//TODO maybe use a factory pattern for this?
		LibraryElementConverter converter =
				(new LibraryHelper()).new LibraryElementConverter(libraryFile, path, targetEPackage);
		
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
	public static LibraryEntry getLibraryEntry(LibraryFileEntry entry) throws IOException {
		
		if(entry == null) {
			return null;
		}
		
		// try to load the resource
		InputStream inputStream = entry.getXMIFileAsInputStream();
		Resource resource = new XMIResourceImpl();
		resource.load(inputStream, null);
		
		// get the library entry from the resource contents and return it
		if(!(resource.getContents() == null) && !resource.getContents().isEmpty() &&
				resource.getContents().get(0) instanceof LibraryEntry) {
			return (LibraryEntry) resource.getContents().get(0);
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
		private LibraryEntry libEntry;
		
		/**
		 * This is the generated LibraryElement.
		 */
		private LibraryElement libElement;
		
		/**
		 * This map keeps track of the metamodel elements that have been created for the
		 * library entries.
		 */
		private HashMap<EObject, MetaModelElement> libEntries2metaModelElementsMap = new HashMap<>();

		/**
		 * This map keeps track of the non-containment references for that target values have to be found after
		 * iterating through the containment tree.
		 */
		private HashMap<TargetSectionNonContainmentReference, EObject> nonContainmentTargetMap = new HashMap<>();
		
		/**
		 * This constructs an instance of the LibraryElementConverter.
		 * 
		 * @param libraryFile The path to a library file (Zip or Jar).
		 * @param path The path of the library entry inside the library (e.g. 'my.path').
		 * @param targetEPackage The target ePackage of the pamtram model into that the generated library
		 * element shall be inserted later on.
		 */
		public LibraryElementConverter(String libraryFile, String path,
			EPackage targetEPackage) {
			this.libraryFile = libraryFile;
			this.path = path;
			this.targetEPackages = EPackageHelper.collectEPackages(targetEPackage);
		}
		
		/**
		 * This performs the actual conversion from the LibraryFileEntry to a LibraryElement. 
		 * @return The generated LibraryElement.
		 * @throws IOException 
		 */
		public LibraryElement convert() throws IOException {
			
			// first, determine the LibraryFileEntry and LibraryEntry to be converted
			libFileEntry = getLibraryFileEntry(libraryFile, path);
			libEntry = getLibraryEntry(libFileEntry);
			
			// create the LibraryElement to be returned
			libElement = MetamodelFactoryImpl.eINSTANCE.createLibraryElement();
			
			// set the path, version, etc.
			libElement.setVersion(libEntry.getVersion());
			libElement.setPath(libFileEntry.getKey());
			libElement.setLibraryFile(libraryFile);
			
			// now, iterate over the contents of the LibraryEntry
			populateLibraryElement(libElement, libEntry);
			
			// finally, try to set the non-containment references
			findNonContainmentReferenceTargets();
			
			return libElement;
		}
		
		/**
		 * This function is recursively called to iterate through the LibraryEntry and generate the
		 * corresponding LibraryElement. Targets of non-containment references thereby have to be set
		 * manually afterwards by calling 'findNonContainmentReferenceTargets()'.
		 * @param parentObject The object that shall serve as the container for newly created elements.
		 * At the beginning, this will be the LibraryElement itself, later on this will be a 
		 * TargetSectionContainmentReference.
		 * @param currentObject A pointer to the part of the LibraryElement that we are currently
		 * browsing through.
		 */
		private void populateLibraryElement(EObject parentObject, EObject currentObject) {
			
			// do not iterate through the metadata of a LibraryItem so that no elements are generated for it
			if(currentObject instanceof MetaData) {
				return;
			}
			
			// only generate metamodel elements for elements that do belong to the target namespace
			if(targetEPackages.contains(currentObject.eClass().getEPackage())) {
				
				// first generate a target section class for the element itself and
				// attach it to the parentObject
				TargetSectionClass tClass = 
						MetamodelFactoryImpl.eINSTANCE.createTargetSectionClass();
				tClass.setEClass(currentObject.eClass());
				tClass.setName(currentObject.eClass().getName());
				tClass.setCardinality(CardinalityType.ONE);
				libEntries2metaModelElementsMap.put(currentObject, tClass);
				if(parentObject instanceof LibraryElement) {
					((LibraryElement) parentObject).getTargetSectionClasses().add(tClass);
				} else if(parentObject instanceof TargetSectionContainmentReference) {
					((TargetSectionContainmentReference) parentObject).getValue().add(tClass);
				} else {
					throw new RuntimeException("Internal Error");
				}
				
				// second, generate a target section attribute for every attribute
				for (EAttribute att : currentObject.eClass().getEAllAttributes()) {
					if(currentObject.eGet(att) != null) {
						ActualAttribute tAttribute = 
								MetamodelFactoryImpl.eINSTANCE.createActualAttribute();
						tAttribute.setAttribute(att);
						tAttribute.setName(att.getName());
						// pimp the name of the surrounding Class
						if(att.getName().equalsIgnoreCase("name")) {
							tClass.setName(tClass.getName() + " " + currentObject.eGet(att)); 
						}
						tAttribute.setUnique(false);
						tAttribute.setValue(String.valueOf(currentObject.eGet(att)));
						tClass.getAttributes().add(tAttribute);
					}
				}
				
				// now, iterate through all containment references
				for (EReference ref : currentObject.eClass().getEAllContainments()) {
					if(currentObject.eGet(ref) != null) {
						TargetSectionContainmentReference tReference = 
								MetamodelFactoryImpl.eINSTANCE.createTargetSectionContainmentReference();
						tReference.setEReference(ref);
						tReference.setName(ref.getName());
						tClass.getReferences().add(tReference);
						
						// browse deeper in the containment hierarchy
						if(!ref.isMany()) {
							populateLibraryElement(tReference, (EObject) currentObject.eGet(ref));
						} else {
							for (Object child : (EList<?>) currentObject.eGet(ref)) {
								populateLibraryElement(tReference, (EObject) child);
							}
						}
					}
				}
				// at last, we can try to set the non-containment references because all objects should
				// already have been created (we iterated through the containment references first!)
				for (EReference ref : currentObject.eClass().getEAllReferences()) {
					if(ref.isContainment() || currentObject.eGet(ref) == null) {
						continue;
					}
					
					TargetSectionNonContainmentReference tReference = 
							MetamodelFactoryImpl.eINSTANCE.createTargetSectionNonContainmentReference();
					tReference.setEReference(ref);
					tReference.setName(ref.getName());
					tClass.getReferences().add(tReference);
					// try to set the target of the reference
					if(!ref.isMany()) {
						nonContainmentTargetMap.put(tReference, (EObject) currentObject.eGet(ref));
					} else {
						for (Object child : (EList<?>) currentObject.eGet(ref)) {
							nonContainmentTargetMap.put(tReference, (EObject) child);
						}
					}
				}
			} else {
				// browse deeper in the containment hierarchy
				for (EObject child : currentObject.eContents()) {
					populateLibraryElement(parentObject, child);
				}
			}
			
		}
		
		/**
		 * This iterates over the nonContainmentTargetMap and tries to set the
		 * target value for each non containment reference.
		 */
		private void findNonContainmentReferenceTargets() {
			
			for (TargetSectionNonContainmentReference ref : nonContainmentTargetMap.keySet()) {
				EObject target = 
						libEntries2metaModelElementsMap.get(nonContainmentTargetMap.get(ref));
				if(target != null && target instanceof TargetSectionClass) {
					ref.getValue().add((TargetSectionClass) target);
				} else {
					System.out.println("No target found for non-containment reference " + ref.getName());
				}
			}
		}
	}
	
}
