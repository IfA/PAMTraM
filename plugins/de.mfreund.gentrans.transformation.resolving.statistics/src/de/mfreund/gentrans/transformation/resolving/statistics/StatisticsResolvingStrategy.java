/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.statistics;

import de.mfreund.gentrans.transformation.resolving.AbstractAmbiguityResolvingStrategy;

/**
 * This class implements a concrete {@link AbstractAmbiguityResolvingStrategy} that performs statistical evaluations of
 * previous choices for resolving ambiguities.
 * <p />
 * This strategy will not sort out any choices during the resolving of strategies but will merely sort them so that the
 * most probable choices will be first in the list of choices.
 *
 * @author mfreund
 */
public class StatisticsResolvingStrategy extends AbstractAmbiguityResolvingStrategy {

}
