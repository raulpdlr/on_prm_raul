package onprem.utils.conversion;

import onprem.utils.conversion.exception.InvalidConversionException;

/**
 * Sample class to show how we might begin the development of other number to word converters such as from 
 * double to word.
 * @author Raul
 *
 */
public class DoubleWordConverterImpl implements InputConverter {

    /**
     * Converts a double number with a '.' to its string equivalent.
     * @param inputNumber Double number to convert
     * @return String representation of double number
     * @throws InvalidConversionException thrown when invalid input is received such as null, blank, or non double
     * numbers such as an integer.
     */
	public final String convertToString(final Number inputNumber)  throws InvalidConversionException {
		throw new InvalidConversionException("Conversion of this input not yet supported");
	}
}
