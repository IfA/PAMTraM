/*******************************************************************************
 * Copyright (C) 2016-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.statistics;

import org.eclipse.ui.plugin.AbstractUIPlugin;



/**
 * This is the central singleton for the StatisticsResolvingStrategy plugin.
 *
 * @author mfreund
 */
public final class StatisticsResolvingStrategyPlugin extends AbstractUIPlugin {

	/**
	 * Keep track of the singleton.
	 */
	public static final StatisticsResolvingStrategyPlugin INSTANCE = new StatisticsResolvingStrategyPlugin();

	/**
	 * Returns the singleton instance of the plugin.
	 *
	 * @return the singleton instance.
	 */
	public static StatisticsResolvingStrategyPlugin getPlugin() {

		return StatisticsResolvingStrategyPlugin.INSTANCE;
	}

}
