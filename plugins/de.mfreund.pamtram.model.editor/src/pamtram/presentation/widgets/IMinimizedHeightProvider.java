package pamtram.presentation.widgets;

/**
 * This interface may be implemented by elements that specify a <em>minimized height</em>, i.e.
 * their preferred height in a <em>minimized<em>state.
 * 
 * @author mfreund
 */
public interface IMinimizedHeightProvider {

	/**
	 * Return the preferred height that the control should have in <em>minimized</em> state. 
	 * 
	 * @return The preferred height of the control in <em>minimized</em> state.
	 */
	public int getMinimizedHeight();
}
