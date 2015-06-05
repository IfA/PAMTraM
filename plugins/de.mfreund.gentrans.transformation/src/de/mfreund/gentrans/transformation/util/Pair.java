package de.mfreund.gentrans.transformation.util;

/**
 * Class to hold references to two objects. Can be used by a method two return
 * two objects.
 *
 * @author copied from
 *         https://stackoverflow.com/questions/521171/a-java-collection
 *         -of-value-pairs-tuples
 * @version 1.0
 * @param <L>
 *            left type
 * @param <R>
 *            right type
 */
public class Pair<L, R> {

	private final L left;
	private final R right;

	/**
	 * @param left
	 *            element
	 * @param right
	 *            element
	 */
	public Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Pair))
			return false;
		@SuppressWarnings("rawtypes")
		final Pair pairo = (Pair) o;
		return this.left.equals(pairo.getLeft())
				&& this.right.equals(pairo.getRight());
	}

	/**
	 * @return left element
	 */
	public L getLeft() {
		return left;
	}

	/**
	 * @return right element
	 */
	public R getRight() {
		return right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return left.hashCode() ^ right.hashCode();
	}

}