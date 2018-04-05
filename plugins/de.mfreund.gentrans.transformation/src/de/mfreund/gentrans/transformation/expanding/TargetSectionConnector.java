/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import de.tud.et.ifa.agtele.emf.connecting.Length;

/**
 * An abstract base implementation for workers that are able to perform some aspects of the <em>expanding</em> step of
 * the transformation that are related to connecting instantiated elements.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public abstract class TargetSectionConnector extends TargetSectionExpander {

	protected EClassConnectionPathProvider eClassConnectionPathProvider;

	protected Length maxPathLength;

	protected JoiningConnectionProvider connectionProvider;

	public TargetSectionConnector(TransformationAssetManager assetManager) {

		super(assetManager);

		eClassConnectionPathProvider = assetManager.getEClassConnectionPathProvider();

		// FIXME in the config, 0 means direct connection; in Length, 0 means no connection
		int rawMaxPathLength = assetManager.getTransformationConfig().getMaxPathLength();
		maxPathLength = Length.valueOf(rawMaxPathLength == -1 ? rawMaxPathLength : rawMaxPathLength + 1);
	}

	@Override
	protected void doExpandCurrentHintGroup() {

		if (hasCurrentMappinHintGroupBeenInstantiated()) {
			doConnectCurrentHintGroup();
		}

	}

	private boolean hasCurrentMappinHintGroupBeenInstantiated() {

		return !currentMappingInstanceDescriptor.getRootInstances(currentHintGroup).isEmpty();
	}

	protected abstract void doConnectCurrentHintGroup();
}
