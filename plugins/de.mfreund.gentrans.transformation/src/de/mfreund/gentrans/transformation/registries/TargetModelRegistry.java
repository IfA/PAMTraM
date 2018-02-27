package de.mfreund.gentrans.transformation.registries;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.FileType;

/**
 * This class represents a registry for the various target models to be created during a transformation.
 * <p />
 * Therefore, it keeps track of the {@link Resource resources} to be created and the {@link EObjectWrapper contents} to
 * be added to those resources via the {@link #targetModels} field. New content can be added to a target model via the
 * various '<em>addToTargetModel(...)</em>' methods. In order to persist the target models (after all contents have been
 * added, the method {@link #saveTargetModels()} needs to be called once.
 *
 * @author mfreund
 */
public class TargetModelRegistry {

	/**
	 * A map representing the target models to be created. The <em>key</em> thereby represents the '<em>path</em>' of a
	 * target model, the '<em>value</em>' represents the list of {@link EObject elements} that shall be added to this
	 * target model (the content).
	 * <p />
	 * <b>Note:</b> All paths are interpreted as relative to a base path (specified during
	 * {@link #createTargetModels(ResourceSet, String)}. For example, a target model represented by the path
	 * ('path/to/the/target.model') will be created at the location '${basePath}/path/to/the/target.model').
	 */
	private final Map<String, List<EObject>> targetModels;

	/**
	 * The {@link #basePath} relative to that all the resources for the {@link #targetModels} will be created.
	 * <p />
	 * Note: The path must either be absolute or relative to the workspace root (of the form
	 * '<em>/project-name/path</em>').
	 */
	private String basePath;

	/**
	 * This represents the path for the <em>default</em> target model (relative to the {@link #basePath}). The default
	 * target model is that target model to which all contents will be added that are not associated with a special
	 * model via the {@link FileAttribute}.
	 */
	private String defaultTargetModel;

	/**
	 * The {@link ResourceSet} that shall be used to create the resources.
	 */
	private ResourceSet resourceSet;

	/**
	 * The {@link Logger} that is used to print messages.
	 */
	private final Logger logger;

	/**
	 * Create a new instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 * @param resourceSet
	 *            The {@link ResourceSet} that shall be used to create the resources.
	 */
	public TargetModelRegistry(TransformationAssetManager assetManager, Optional<ResourceSet> resourceSet) {

		this.targetModels = new LinkedHashMap<>();
		this.basePath = assetManager.getTransformationConfig().getTargetBasePath();
		this.defaultTargetModel = assetManager.getTransformationConfig().getDefaultTargetModel();
		this.resourceSet = resourceSet.isPresent() ? resourceSet.get() : new ResourceSetImpl();
		this.logger = assetManager.getLogger();
	}

	/**
	 * This is the getter for the {@link #targetModels}.
	 *
	 * @return The map representing the target models to be created.
	 */
	public Map<String, List<EObject>> getTargetModels() {

		return this.targetModels;
	}

	/**
	 * Whether the target model represented by the given <em>path</em> is already handled by this
	 * {@link TargetModelRegistry}.
	 *
	 * @param path
	 *            The target model path to check.
	 * @return <em><b>true</b></em> if the target model represented by the given <em>path</em> is already handled by
	 *         this {@link TargetModelRegistry}; <em><b>false</b></em> otherwise.
	 */
	public boolean contains(String path) {

		return this.targetModels.containsKey(path);
	}

	/**
	 * Whether the given {@link EObject} is already handled by this {@link TargetModelRegistry}.
	 *
	 * @param element
	 *            The target model element to check.
	 * @return <em><b>true</b></em> if the given {@link EObject} is already handled by this {@link TargetModelRegistry};
	 *         <em><b>false</b></em> otherwise.
	 */
	public boolean contains(EObject element) {

		return this.targetModels.values().parallelStream().flatMap(List::parallelStream).collect(Collectors.toList())
				.contains(element);
	}

	/**
	 * This can be used to check if any content has been added to this TargetModelRegistry.
	 *
	 * @return '<em><b>true</b></em>' if the {@link #targetModels} does contain only empty lists of values,
	 *         '<em><b>false</b></em>' otherwise (if there is at least one target model for that at least one element
	 *         has been specified as content).
	 */
	public boolean isEmpty() {

		for (Entry<String, List<EObject>> targetModel : this.targetModels.entrySet()) {
			if (targetModel.getValue().isEmpty()) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * This adds the given list of {@link EObject elements} as root objects to the {@link #defaultTargetModel default
	 * target model}.
	 *
	 * @param elementsToAdd
	 *            The list of {@link EObject elements} to add.
	 */
	public void addToTargetModel(final Collection<EObject> elementsToAdd) {

		this.addToTargetModel(elementsToAdd, this.defaultTargetModel, null);
	}

	/**
	 * This adds the given list of {@link EObject elements} as root objects to the target model represented by the given
	 * '<em>path</em>'.
	 *
	 * @param elementsToAdd
	 *            The list of {@link EObject elements} to add.
	 * @param path
	 *            The path (relative to {@link #basePath} of the target model.
	 * @param fileType
	 *            The {@link FileType fileType} of the target model. If this is '<em>null</em>', the type will be
	 *            determined by the {@link #resourceSet}.
	 */
	public void addToTargetModel(final Collection<EObject> elementsToAdd, String path, FileType fileType) {

		if (!this.targetModels.containsKey(path)) {
			this.targetModels.put(path, new ArrayList<>());
		}

		/*
		 * the resource to contain the target model
		 */
		Resource resource = this.getTargetModelResource(path, fileType);

		if (resource != null) {

			/*
			 * add the contents
			 */
			resource.getContents().addAll(elementsToAdd);
		}

		/*
		 * add the elements to the 'targetModels' map
		 */
		this.targetModels.get(path).addAll(elementsToAdd);

	}

	/**
	 * This adds the given {@link EObject element} as root object to the {@link #defaultTargetModel default target
	 * model}.
	 *
	 * @param elementToAdd
	 *            The {@link EObject element} to add.
	 */
	public void addToTargetModel(final EObject elementToAdd) {

		this.addToTargetModel(elementToAdd, this.defaultTargetModel, null);
	}

	/**
	 * This adds the given {@link EObject element} as root object to the target model represented by the given
	 * '<em>path</em>'.
	 *
	 * @param elementToAdd
	 *            The {@link EObject element} to add.
	 * @param path
	 *            The path (relative to {@link #basePath} of the target model.
	 * @param fileType
	 *            The {@link FileType fileType} of the target model. If this is '<em>null</em>', the type will be
	 *            determined by the {@link #resourceSet}.
	 */
	public void addToTargetModel(final EObject elementToAdd, String path, FileType fileType) {

		this.addToTargetModel(Arrays.asList(elementToAdd), path, fileType);
	}

	/**
	 * This retrieves a resource for a target model as specified by the given '<em>path</em>'. If no resource yet
	 * exists, one is created.
	 *
	 * @param path
	 *            The path (relative to {@link #basePath}) of the target model.
	 * @return The resource representing the target model for the given '<em>path</em>', '<em><b>null</b></em>' if the
	 *         resource does not exist and could not be created.
	 * @param fileType
	 *            The {@link FileType fileType} of the target model. If this is '<em>null</em>', the type will be
	 *            determined by the {@link #resourceSet}.
	 */
	private Resource getTargetModelResource(String path, FileType fileType) {

		// the URI of the target resource
		final URI targetFileUri = this.getTargetModelURI(path);

		Resource resource;

		/*
		 * try to retrieve an existing resource
		 */
		resource = this.resourceSet.getResource(targetFileUri, false);

		if (resource != null) {
			// resource already exists
			return resource;
		}

		/*
		 * create the resource
		 */
		try {

			if (fileType == FileType.XMI) {
				this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(targetFileUri.fileExtension(), new XMIResourceFactoryImpl());
			} else if (fileType == FileType.XML) {
				this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put(targetFileUri.fileExtension(), new GenericXMLResourceFactoryImpl());
			}

			resource = this.resourceSet.createResource(targetFileUri);

			if (resource == null) {
				this.logger.severe(() -> "The resource for the target model '" + path + "' could not be created.");
			} else {
				if (resource instanceof XMLResource) {
					((XMLResource) resource).setEncoding("UTF-8");
				}
			}

		} catch (final Exception e) {
			this.logger.severe(() -> "The resource for the target model '" + path + "' could not be created.");
			e.printStackTrace();
		}

		return resource;
	}

	/**
	 * This returns a {@link URI} representing the target model specified by the given '<em>path</em>'.
	 *
	 * @param path
	 *            The path (relative to {@link #basePath}) of the target model.
	 * @return The {@link URI} representing the target model specified by the given '<em>path</em>'.
	 */
	private URI getTargetModelURI(String path) {

		return ResourceHelper.getURIForPathString(this.basePath + File.separator + path);

	}

	/**
	 * This saves all resources for the various target models as specified by the field {@link #targetModels}.
	 *
	 * @return '<em><b>true</b></em>' if all resources have successfully been saved, '<em><b>false</b></em>' otherwise.
	 */
	public boolean saveTargetModels() {

		boolean ret = true;

		for (Entry<String, List<EObject>> entry : this.targetModels.entrySet()) {

			// the URI of the target resource
			final URI targetFileUri = this.getTargetModelURI(entry.getKey());

			Resource resource = null;

			/*
			 * save the resource
			 */
			try {

				resource = this.resourceSet.getResource(targetFileUri, false);
				if (resource == null) {
					this.logger
							.severe(() -> "The resource for the target model '" + entry.getKey() + "' does not exist.");
					ret = false;
					continue;
				} else {

					/*
					 * For XML resources, we need to manually create a 'DocumentRoot' in order to get the right
					 * serialization.
					 */
					if (resource.getClass().equals(XMLResourceImpl.class)) {
						EObject root = resource.getContents().get(0);
						EClassifier docRootClass = root.eClass().getEPackage().getEClassifier("DocumentRoot");

						if (docRootClass == null || !(docRootClass instanceof EClass)) {
							this.logger.severe(() -> "Error creating a document root for file '" + targetFileUri
									+ "'! The XML content might not be serialized correctly.");
						}

						EObject docRoot = EcoreUtil.create((EClass) docRootClass);

						/*
						 * Find the correct reference for the document root and add the technical root element to the
						 * document root.
						 */
						Iterator<EStructuralFeature> it = docRoot.eClass().getEStructuralFeatures().iterator();
						EStructuralFeature feature = null;
						while (it.hasNext()) {
							EStructuralFeature next = it.next();
							if (next.getEType().equals(root.eClass())) {
								feature = next;
								break;
							}
						}

						if (feature == null) {
							this.logger.severe(() -> "Error creating a document root for file '" + targetFileUri
									+ "'! The XML content might not be serialized correctly.");
						} else {
							docRoot.eSet(feature, root);
							resource.getContents().clear();
							resource.getContents().add(docRoot);
						}

					}

					/*
					 * Save the resource.
					 */
					resource.save(Collections.emptyMap());
					this.logger.info(() -> "Target model resource '" + entry.getKey() + "' successfully saved.");
				}

			} catch (final Exception e) {
				this.logger.severe(() -> "Error saving the target model '" + entry.getKey() + "'.");
				e.printStackTrace();
				ret = false;
				continue;
			}

		}

		return ret;
	}

}
