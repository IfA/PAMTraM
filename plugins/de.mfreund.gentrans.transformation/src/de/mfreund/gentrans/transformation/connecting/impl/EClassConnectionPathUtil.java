/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;

/**
 * This provides some static utility functions that simplify working with {@link EClassConnectionPath
 * EClassConnectionPaths}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class EClassConnectionPathUtil {

	private EClassConnectionPathUtil() {

	}

	public static EClassConnectionPath join(EClassConnectionPath path1, EClassConnectionPath path2) {

		List<DirectEClassConnectionPath> segments = new ArrayList<>();

		segments.addAll(getPathSegments(path1));
		segments.addAll(getPathSegments(path2));

		if (segments.isEmpty()) {
			return new EmptyEClassConnectionPath();
		} else if (segments.size() == 1) {
			return segments.get(0);
		} else {
			return new ComplexEClassConnectionPath(segments);
		}
	}

	public static List<DirectEClassConnectionPath> getPathSegments(EClassConnectionPath path) {

		if (path == null) {
			return Collections.emptyList();
		} else if (path instanceof DirectEClassConnectionPath) {
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

	public static List<EClassConnectionPath> sortConnectionPathsFromShortestToLongest(
			List<EClassConnectionPath> pathsToSort) {

		return pathsToSort.stream().sorted((p1, p2) -> p1.getLength().compareTo(p2.getLength()))
				.collect(Collectors.toList());
	}

}
