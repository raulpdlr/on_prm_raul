package onprem.utils.conversion;

import onprem.utils.conversion.exception.InvalidConversionException;

/**
 * High level class that will act to convert a String number to its English String equivalent. The function:
 * String convertToNumberWord(final String stringInput)
 * will determine the appropriate number to word converter to use.
 * @author Raul
 *
 *
 */
public class NumberToEnglishWordConverterImpl implements NumberToEnglishWordConverter {

	/**
	 * Helper function determines whether or not a passed in string is a double with a '.' in it.  For example
	 * "123.456"
	 * @param str Input test string
	 * @return boolean True if input is a string of a double containing a dot, false otherwise.
	 */
	private static boolean isDoubleWithDot(final String str) {
		if (!str.contains(".")) {
			return false;
		}
		try {
			Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

	/**
	 * Helper function determines whether or not a passed in string is an integer.  For example "123"
	 * @param str Input test string
	 * @return boolean True if input is a string of an integer, false otherwise.
	 */
	private static boolean isInteger(final String str) {
		try {
			Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	/*
	 * (non-Javadoc)
	 * @see onprem.utils.conversion.NumberToStringConverter#convertToNumberWord(java.lang.String)
	 */
	public final String convertToNumberWord(final String stringInput) {
		String numberWordResult = "";
		InputConverter numberToWordConverter = null;
		Number numberInput = null;
		
		try {
			if (isDoubleWithDot(stringInput)) {
				numberInput = Double.parseDouble(stringInput);
				numberToWordConverter = new DoubleWordConverterImpl();			
			} else if (isInteger(stringInput)) {
				numberInput = Integer.parseInt(stringInput);
				numberToWordConverter = new IntegerWordConverterImpl();
			} else {
				numberWordResult = "Conversion of this input not yet supported";
			}
			
			if (numberWordResult == "") {
				numberWordResult = "String = " + numberToWordConverter.convertToString(numberInput);
				
		    	// Uncomment this block if you simply want to observe the output of the code for various sample inputs
				/*
				System.out.println(numberToWordConverter.convertToString(0));
		    	System.out.println(numberToWordConverter.convertToString(1));
		    	System.out.println(numberToWordConverter.convertToString(5));
		    	System.out.println(numberToWordConverter.convertToString(999999999));
		    	System.out.println(numberToWordConverter.convertToString(2147483647));   	
		    	System.out.println(numberToWordConverter.convertToString(-2147483647));
		    	*/
			}
    	} catch (InvalidConversionException e) {
			String message = e.getMessage();
			numberWordResult = message;
		}				
		
		return numberWordResult;
	}
	
    /**
     * Support for command line input.
     * @param args Command line input arguments.
     */
	public static void main(final String[] args) {
    	String convertedResult = "";
    	NumberToEnglishWordConverter numberToStringConverter = new NumberToEnglishWordConverterImpl();
    	
    	if (args == null || args.length == 0) {
    		convertedResult = "No input given";
		} else {
    		String commandLineInput = args[0];
    		convertedResult = numberToStringConverter.convertToNumberWord(commandLineInput);
		}

		System.out.println(convertedResult);
	}
}
