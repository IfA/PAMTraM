package pamtram.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.util.impl.FileParserImpl;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.VirtualAttribute;
import pamtram.metamodel.impl.MetamodelFactoryImpl;


/**
 * This class provides convenience functions to work with library items.
 * 
 * @author mfreund
 */
public class LibraryHelper {

	/**
	 * This creates a target section (represented by its root {@link TargetSectionClass} from a given {@link LibraryEntry}. 
	 * @param libEntry The {@link LibraryEntry} to be converted.
	 * @return The created targetsection.
	 */
	public static TargetSectionClass convertToTargetSection(LibraryEntry libEntry) {

		if(libEntry.getOriginalLibraryEntry().getParameterDescription().getContainerParameters().size() != 1) {
			return null;
		}
		return (new LibraryHelper()).new MetamodelSectionConverter().convert(libEntry);

	}

	private class MetamodelSectionConverter {

		public TargetSectionClass convert(LibraryEntry libEntry) {

			LibraryItem libItem = libEntry.getOriginalLibraryEntry().getLibraryItem();

			EObject root = libEntry.getOriginalLibraryEntry().getParameterDescription().getContainerParameters().get(0).getSource();

			// now, iterate over the contents of the LibraryEntry
			TargetSectionClass section = populateSection(null, root);

			// finally, try to set the non-containment references
			findNonContainmentReferenceTargets();

			return section;
		}

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
		 * This function is recursively called to iterate through the LibraryEntry and generate the
		 * corresponding LibraryElement. Targets of non-containment references thereby have to be set
		 * manually afterwards by calling 'findNonContainmentReferenceTargets()'.
		 * @param parentObject The object that shall serve as the container for newly created elements.
		 * At the beginning, this will be the LibraryElement itself, later on this will be a 
		 * TargetSectionContainmentReference.
		 * @param currentObject A pointer to the part of the LibraryElement that we are currently
		 * browsing through.
		 * @return 
		 */
		private TargetSectionClass populateSection(EObject parentObject, EObject currentObject) {

			// first generate a target section class for the element itself and
			// attach it to the parentObject
			TargetSectionClass tClass = 
					MetamodelFactoryImpl.eINSTANCE.createTargetSectionClass();
			tClass.setEClass(currentObject.eClass());
			tClass.setName(currentObject.eClass().getName());
			tClass.setCardinality(CardinalityType.ONE);
			libEntries2metaModelElementsMap.put(currentObject, tClass);
			if(parentObject instanceof TargetSectionContainmentReference) {
				((TargetSectionContainmentReference) parentObject).getValue().add(tClass);
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
						populateSection(tReference, (EObject) currentObject.eGet(ref));
					} else {
						for (Object child : (EList<?>) currentObject.eGet(ref)) {
							populateSection(tReference, (EObject) child);
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

			return tClass;

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


	/**
	 * This method converts a LibraryEntry represented by a given path to the library file and a 
	 * relative path inside the library file to a pamtram LibraryEntry. Therefore, it generates {@link LibraryParameter}s 
	 * for every {@link AbstractAttributeParameter}, {@link AbstractContainerParameter} and 
	 * {@link AbstractExternalReferenceParameter} that it encounters. 
	 * 
	 * @param libraryContextDescriptor The descriptor for the library context to be used during the conversion.
	 * @param path The path of the library entry inside the library (e.g. 'my.path').
	 * @param targetEPackage The target ePackage of the pamtram model into that the generated library
	 * element shall be inserted later on.
	 * @param uri The URI where the resource created for the library element shall be stored.
	 * @param resourceSet The resource set to be used to.
	 * @return The generated LibraryEntry.
	 * @throws IOException If something goes wrong during loading the libraryFile or the XMI file inside
	 * the library file representing the LibraryEntry. 
	 */
	public static LibraryEntry convertToLibraryElement(LibraryContextDescriptor libraryContextDescriptor, String path,
			EPackage targetEPackage, URI uri, ResourceSet resourceSet) throws IOException {

		//TODO maybe use a factory pattern for this?
		LibraryElementConverter converter;
		try {
			converter = (new LibraryHelper()).new LibraryElementConverter(libraryContextDescriptor, path, targetEPackage, uri, resourceSet);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}

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

		de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libEntry = null;

		// try to load the resource
		InputStream inputStream = entry.getXMIFileAsInputStream();
		Resource resource = new XMIResourceImpl();
		resource.load(inputStream, null);
		inputStream.close();
		// get the library entry from the resource contents and return it
		if(!(resource.getContents() == null) && !resource.getContents().isEmpty() &&
				resource.getContents().get(0) instanceof de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) {
			libEntry =  (de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry) resource.getContents().get(0);
		}

		return libEntry;
	}

	public static void storeLibraryEntry(de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry libEntry, URI uri, ResourceSet resourceSet) throws IOException {

		if(libEntry == null) {
			return;
		}

		// create a resource and add the library entry
		//			Resource resource = new XMIResourceImpl(uri);
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(libEntry);

		// try to save the resource
		resource.save(null);
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
		 * This is the library context descriptor used for the conversion.
		 */
		private LibraryContextDescriptor libraryContextDescriptor;

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
		 * The resource set to be used to create the new resource.
		 */
		private ResourceSet resourceSet;

		/**
		 * This is the GenLibraryManager that proxies calls to the 'genlibrary' plug-in.
		 */
		private GenLibraryManager manager;

		/**
		 * This constructs an instance of the LibraryElementConverter.
		 * 
		 * @param libraryContextDescriptor The descriptor for the library context to be used during the conversion.
		 * @param path The path of the library entry inside the library (e.g. 'my.path').
		 * @param targetEPackage The target ePackage of the pamtram model into that the generated library
		 * element shall be inserted later on.
		 * @param uri The URI where the resource created for the library element shall be stored.
		 * @param resourceSet The resource set to be used.
		 * @throws IllegalAccessException 
		 * @throws InstantiationException 
		 */
		public LibraryElementConverter(LibraryContextDescriptor libraryContextDescriptor, String path,
				EPackage targetEPackage, URI uri, ResourceSet resourceSet) throws InstantiationException, IllegalAccessException {
			this.libraryContextDescriptor = libraryContextDescriptor;
			this.path = path;
			this.targetEPackages = EPackageHelper.collectEPackages(targetEPackage);
			this.uri = uri;
			this.resourceSet = resourceSet;

			this.manager = new GenLibraryManager(libraryContextDescriptor);
		}

		/**
		 * This performs the actual conversion from the {@link LibraryFileEntry} to a {@link LibraryEntry}. 
		 * @return The generated LibraryElement.
		 * @throws IOException 
		 */
		public LibraryEntry convert() throws IOException {

			// first, determine the LibraryFileEntry and LibraryEntry to be converted
			//			libFileEntry = getLibraryFileEntry(libraryFile, path);
			//			libEntry = getLibraryEntry(libFileEntry);
			libEntry = manager.getLibraryEntry(path, false);

			//			storeLibraryEntry(libEntry, uri.appendSegment(path).appendSegment("data.xmi"), resourceSet);

			// create the LibraryElement to be returned
			pamtramLibEntry = MetamodelFactoryImpl.eINSTANCE.createLibraryEntry();

			// set the path, id, etc.
			//			pamtramLibEntry.setPath(libFileEntry.getKey());
			VirtualAttribute pathAttribute = MetamodelFactoryImpl.eINSTANCE.createVirtualAttribute();
			pathAttribute.setName("Classpath");
			pathAttribute.setValue(path);
			pamtramLibEntry.setPath(pathAttribute);
			VirtualAttribute idAttribute = MetamodelFactoryImpl.eINSTANCE.createVirtualAttribute();
			idAttribute.setName("ID");
			idAttribute.setValue(libEntry.getParameterDescription().getID());
			pamtramLibEntry.setId(idAttribute);
			//						pamtramLibEntry.setLibraryFile(libraryFile);
			pamtramLibEntry.setOriginalLibraryEntry(libEntry);

			if(libEntry.getParameterDescription() == null) {
				return pamtramLibEntry;
			}

			/*
			 * Create and populate a Pamtram AttributeParameter for every Genlib AttributeParameter
			 */
			for (AbstractAttributeParameter<EObject> attParameter : libEntry.getParameterDescription().getAttributeParameters()) {

				AttributeParameter param = MetamodelFactoryImpl.eINSTANCE.createAttributeParameter();
				param.setOriginalParameter(attParameter);
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
				param.setOriginalParameter(contParameter);
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
					param.setOriginalParameter(extRefParameter);
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
	}

}