package de.mfreund.gentrans.transformation.resolving.wizards;

import org.eclipse.swt.widgets.Dialog;

import de.mfreund.gentrans.transformation.resolving.enhancing.MappingModelEnhancer;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * An {@link AbstractDialogRunner} that spawns a {@link ValueSpecificationDialog}.
 *
 * @author mfreund
 */
public class ValueSpecificationDialogRunner extends AbstractDialogRunner {

	private String specifiedValue;

	/**
	 * This creates an instance.
	 *
	 * @see #ValueSpecificationDialogRunner(String, MappingModelEnhancer)
	 *
	 * @param message
	 *            The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 */
	public ValueSpecificationDialogRunner(final String message) {

		super(message);
	}

	/**
	 * This creates an instance.
	 * <p />
	 * If <em>enhanceMappingModelListener</em> is <em>null</em>, the {@link AbstractDialog#enhanceMappingModelButton}
	 * will be grayed out.
	 *
	 * @see #ValueSpecificationDialogRunner(String)
	 *
	 * @param message
	 *            The message that shall be displayed in the {@link Dialog} that this runner will instantiate.
	 * @param enhanceMappingModelListener
	 *            A {@link SelectionListener2} that will be called when the
	 *            {@link AbstractDialog#enhanceMappingModelButton} is clicked.
	 */
	public ValueSpecificationDialogRunner(final String message,
			final MappingModelEnhancer<? extends ValueSpecificationDialogRunner> enhanceMappingModelListener) {
		super(message, enhanceMappingModelListener);
	}

	/**
	 * Get the value after the dialog has finished.
	 *
	 * @return The value specified by the user.
	 */
	public String getSingleValue() {

		return this.specifiedValue;
	}

	@Override
	protected void initializeDialog() {

		this.dialog = new ValueSpecificationDialog(this.message, this.enhanceMappingModelListener);
	}

	@Override
	protected void evaluateResults() {

		this.specifiedValue = ((ValueSpecificationDialog) this.dialog).getValue();
	}

}
