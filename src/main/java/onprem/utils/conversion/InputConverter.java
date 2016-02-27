package onprem.utils.conversion;

import onprem.utils.conversion.exception.InvalidConversionException;

/**
 * Interface that implementing input to word converters must extend.
 * @author Raul
 *
 */
public interface InputConverter {
	
	/**
	 * Function that will convert a number to its English string equivalent.
	 * @param number Input number
	 * @return String that is the English representation of a number
	 * @throws InvalidConversionException thrown when invalid input is given
	 */
	String convertToString(Number number) throws InvalidConversionException;
}
