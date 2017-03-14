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
