/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.core.TransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import pamtram.mapping.InstantiableMappingHintGroup;

/**
 * An abstract base class for a ConnectionProvider that is able to return a list of {@link Connection
 * AbstractConnections} based on some kind of requirement.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public abstract class AbstractConnectionProvider extends TransformationAsset {

	protected Map<InstantiableMappingHintGroup, EClassConnectionPath> standardConnectionsForHintGroups;

	protected EClassConnectionPathProvider eClassConnectionPathProvider;

	protected IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	protected Logger logger;

	protected TargetSectionRegistry targetSectionRegistry;

	protected InstanceSelectorHandler instanceSelectorHandler;

	protected MappingInstanceDescriptor currentMappingInstanceDescriptor;

	protected InstantiableMappingHintGroup currentHintGroup;

	protected List<EObjectWrapper> currentInstancesToConnect;

	public AbstractConnectionProvider(TransformationAssetManager assetManager,
			Map<InstantiableMappingHintGroup, EClassConnectionPath> standardPaths,
			EClassConnectionPathProvider eClassConnectionPathProvider) {

		super(assetManager);

		standardConnectionsForHintGroups = standardPaths;
		this.eClassConnectionPathProvider = eClassConnectionPathProvider;
		ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		logger = assetManager.getLogger();
		targetSectionRegistry = assetManager.getTargetSectionRegistry();
		instanceSelectorHandler = assetManager.getInstanceSelectorHandler();
	}

}