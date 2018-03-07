/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;

/**
 *
 * @author mfreund
 */
public class EClassConnectionPathUtil {

	private EClassConnectionPathUtil() {

	}

	public static List<DirectEClassConnectionPath> getPathSegments(EClassConnectionPath path) {

		if (path instanceof DirectEClassConnectionPath) {
			return Arrays.asList((DirectEClassConnectionPath) path);
		} else if (path instanceof ComplexEClassConnectionPath) {
			return ((ComplexEClassConnectionPath) path).getPathSegments();
		} else if (path instanceof EmptyEClassConnectionPath) {
			return Collections.emptyList();
		} else {
			throw new RuntimeException(
					"Unknown type of ConnectionPath '" + path.getClass().getName() + "' encountered. Will be ignored.");
		}
	}
}
