/**
 *
 */
package de.mfreund.gentrans.transformation.maps;

import java.util.ArrayList;
import java.util.List;

import pamtram.mapping.extended.MappingHint;

/**
 *
 * @author mfreund
 */
public class EmptyHintValue extends HintValue {

	/**
	 * This creates an instance.
	 *
	 * @param hint
	 *            The {@link MappingHint} that this represents a value for.
	 */
	protected EmptyHintValue(MappingHint hint) {

		super(hint, null, null);
	}

	@Override
	public List<String> getResultingValues() {

		return new ArrayList<>();
	}

	@Override
	public void expandHintValue(String valueToAdd, boolean prepend) {

		// Nothing to be done
		//
	}

}
