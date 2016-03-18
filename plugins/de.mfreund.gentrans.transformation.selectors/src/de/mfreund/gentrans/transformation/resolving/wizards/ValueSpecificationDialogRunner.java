package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author mfreund
 * @version 1.0 Runner for the {@link ValueSpecificationDialog}.
 *
 */
public class ValueSpecificationDialogRunner implements Runnable {
	private final String message;
	
	private String specifiedValue;

	private boolean transformationStopRequested;
	

	/**
	 * @param message
	 */
	public ValueSpecificationDialogRunner(final String message) {
		transformationStopRequested = false;
		this.message = message;
	}

	/**
	 * Get value after dialog has finished, returns standardSelection if
	 * dialog not run
	 * <p />
	 * Note: If multiple elements are selected by the user, this will return one (random!) element.
	 *
	 * @return selected <AnyType>
	 */
	public String getSingleValue() {
		return specifiedValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		
		final ValueSpecificationDialog d = new ValueSpecificationDialog(shell, message);
		d.open();
		specifiedValue = d.getValue();
		transformationStopRequested = d.isTransformationStopRequested();
	}

	/**
	 * @return true if Button "Abort Transformation" was clicked during run()
	 */
	public boolean wasTransformationStopRequested() {
		return transformationStopRequested;
	}

}
