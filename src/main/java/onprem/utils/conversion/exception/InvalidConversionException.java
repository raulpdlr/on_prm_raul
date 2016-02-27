package onprem.utils.conversion.exception;

/**
 * Represents an error for invalid conversion requests.
 * @author Raul
 *
 */
public class InvalidConversionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5808705849833082716L;

	/**
	 * An error indicating there is an exception for the requested conversion.
	 * @param message Message to pass the constructor of the Exception class
	 */
	public InvalidConversionException(final String message) {
		super(message);
	}
	
}
