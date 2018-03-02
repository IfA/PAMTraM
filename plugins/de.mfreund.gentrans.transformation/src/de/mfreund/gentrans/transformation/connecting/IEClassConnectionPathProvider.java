/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.List;

import de.mfreund.gentrans.transformation.connecting.impl.ComplexEClassConnectionPath;

/**
 *
 * @author mfreund
 */
public interface IEClassConnectionPathProvider {

	List<ComplexEClassConnectionPath> getConnections(EClassConnectionPathRequirement connectionRequirement);

}
