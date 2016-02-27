package onprem.utils.conversion;

/**
 * Interface for high level class to convert input String ("9") to English number String ("nine").
 * @author Raul
 *
 */
public interface NumberToEnglishWordConverter {

	/**
	 * Function to allow the conversion of a command line string number input into its English word representation.
	 * @param stringInput String number input such as "123"
	 * @return English string representation of the number such as "one hundred twenty three"
	 */
	String convertToNumberWord(final String stringInput);
	
}
