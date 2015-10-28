package de.mfreund.gentrans.transformation;

/**
 * This exception can be used to indicate a request by the user for an early termination
 * of the transformation. 
 * 
 * @author mfreund
 */
public class UserAbortException extends Exception {

	private static final long serialVersionUID = -5137744892390040105L;

	@Override
	public String getMessage() {
		return "User abort...";
	}

}
