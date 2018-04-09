/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation;

import java.util.Optional;

import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;

/**
 * Classes implementing this interface are able to perform a generic transformation via the {@link #run()} method.
 *
 * @author mfreund
 */
public interface ITransformationRunner {

	/**
	 * This executes the runner (resp. the generic transformation that it represents).
	 *
	 * @return A {@link TransformationResult} indicating the result of the run.
	 */
	public TransformationResult run();

	/**
	 * Cancel a (potentially) running transformation.
	 *
	 */
	public void cancel();

	/**
	 * This class represents the result of an executed generic transformation.
	 *
	 * @author mfreund
	 */
	public static class TransformationResult {

		private boolean aborted = false;

		private MatchedSectionRegistry matchedSectionRegistry;

		private SelectedMappingRegistry selectedMappingRegistry;

		private TargetSectionRegistry targetSectionRegistry;

		private TargetModelRegistry targetModelRegistry;

		/**
		 * @return the {@link #aborted}}
		 */
		public boolean isAborted() {

			return aborted;
		}

		/**
		 * @param aborted
		 *            the isAborted to set
		 */
		public void setAborted(boolean aborted) {

			this.aborted = aborted;
		}

		/**
		 * @param aborted
		 *            the isAborted to set
		 * @return the {@link TransformationResult} after setting the {@link #aborted}
		 */
		public TransformationResult withAborted(boolean aborted) {

			this.aborted = aborted;
			return this;
		}

		/**
		 * @return the {@link #matchedSectionRegistry}
		 */
		public Optional<MatchedSectionRegistry> getMatchedSectionRegistry() {

			return Optional.ofNullable(matchedSectionRegistry);
		}

		/**
		 * @param matchedSectionRegistry
		 *            the {@link MatchedSectionRegistry} to set
		 */
		public void setMatchedSectionRegistry(MatchedSectionRegistry matchedSectionRegistry) {

			this.matchedSectionRegistry = matchedSectionRegistry;
		}

		/**
		 * @param matchedSectionRegistry
		 *            the matchedSectionRegistry to set
		 * @return the {@link TransformationResult} after setting the {@link #matchedSectionRegistry}
		 */
		public TransformationResult withMatchedSectionRegistry(MatchedSectionRegistry matchedSectionRegistry) {

			this.matchedSectionRegistry = matchedSectionRegistry;
			return this;
		}

		/**
		 * @return the {@link #selectedMappingRegistry}
		 */
		public Optional<SelectedMappingRegistry> getSelectedMappingRegistry() {

			return Optional.ofNullable(selectedMappingRegistry);
		}

		/**
		 * @param selectedMappingRegistry
		 *            the {@link SelectedMappingRegistry} to set
		 */
		public void setSelectedMappingRegistry(SelectedMappingRegistry selectedMappingRegistry) {

			this.selectedMappingRegistry = selectedMappingRegistry;
		}

		/**
		 * @param selectedMappingRegistry
		 *            the selectedMappingRegistry to set
		 * @return the {@link TransformationResult} after setting the {@link #selectedMappingRegistry}
		 */
		public TransformationResult withSelectedMappingRegistry(SelectedMappingRegistry selectedMappingRegistry) {

			this.selectedMappingRegistry = selectedMappingRegistry;
			return this;
		}

		/**
		 * @return the {@link #targetSectionRegistry}
		 */
		public Optional<TargetSectionRegistry> getTargetSectionRegistry() {

			return Optional.ofNullable(targetSectionRegistry);
		}

		/**
		 * @param targetSectionRegistry
		 *            the {@link TargetSectionRegistry} to set
		 */
		public void setTargetSectionRegistry(TargetSectionRegistry targetSectionRegistry) {

			this.targetSectionRegistry = targetSectionRegistry;
		}

		/**
		 * @param targetSectionRegistry
		 *            the targetSectionRegistry to set
		 * @return the {@link TransformationResult} after setting the {@link #targetSectionRegistry}
		 */
		public TransformationResult withTargetSectionRegistry(TargetSectionRegistry targetSectionRegistry) {

			this.targetSectionRegistry = targetSectionRegistry;
			return this;
		}

		/**
		 * @return the {@link #targetModelRegistry}
		 */
		public Optional<TargetModelRegistry> getTargetModelRegistry() {

			return Optional.ofNullable(targetModelRegistry);
		}

		/**
		 * @param targetModelRegistry
		 *            the {@link TargetModelRegistry} to set
		 */
		public void setTargetModelRegistry(TargetModelRegistry targetModelRegistry) {

			this.targetModelRegistry = targetModelRegistry;
		}

		/**
		 * @param targetModelRegistry
		 *            the targetModelRegistry to set
		 * @return the {@link TransformationResult} after setting the {@link #targetModelRegistry}
		 */
		public TransformationResult withTargetModelRegistry(TargetModelRegistry targetModelRegistry) {

			this.targetModelRegistry = targetModelRegistry;
			return this;
		}
	}
}
