/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathFactory;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathRequirement;
import de.mfreund.gentrans.transformation.connecting.IEClassConnectionPathProvider;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;

/**
 *
 *
 * @author mfreund
 */
public class CachedEClassConnectionPathProvider implements IEClassConnectionPathProvider {

	private final Map<EClassConnectionPathRequirement, Set<ComplexEClassConnectionPath>> cachedConnections;

	private final EClassConnectionPathFactory pathFactory;

	// FIXME this has to be removed
	private TargetSectionRegistry reg;

	/**
	 *
	 *
	 * ${tags}
	 */
	public CachedEClassConnectionPathProvider(Collection<EPackage> ePackages, Logger logger,
			TargetSectionRegistry reg) {

		this.cachedConnections = new HashMap<>();
		this.pathFactory = new EClassConnectionPathFactory(ePackages, logger);
		this.reg = reg;
	}

	@Override
	public List<ComplexEClassConnectionPath> getConnections(EClassConnectionPathRequirement connectionRequirement) {

		return new ArrayList<>(
				this.cachedConnections.computeIfAbsent(connectionRequirement, this::determineConnections));
	}

	private Set<ComplexEClassConnectionPath> determineConnections(
			EClassConnectionPathRequirement connectionRequirement) {

		EClass startingClass = connectionRequirement.getRequiredStartingClass();
		EClass targetClass = connectionRequirement.getRequiredTargetClass();
		int maxPathLength = connectionRequirement.getRequiredMaximumPathLength();

		if (startingClass == null) {
			return new LinkedHashSet<>(this.pathFactory.findPathsToInstances(this.reg, targetClass, maxPathLength));
		} else {
			return new LinkedHashSet<>(this.pathFactory.findPathsFromContainerToClassToConnect(this.reg, targetClass,
					startingClass, maxPathLength));
		}

	}
}
