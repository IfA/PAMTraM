/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.List;

/**
 *
 * @author mfreund
 */
public interface IEClassConnectionPathProvider {

	List<ComplexEClassConnectionPath> getConnections(EClassConnectionPathRequirement connectionRequirement);

}
