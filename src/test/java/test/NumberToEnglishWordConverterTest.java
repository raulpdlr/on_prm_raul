package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import onprem.utils.conversion.NumberToEnglishWordConverter;
import onprem.utils.conversion.NumberToEnglishWordConverterImpl;

/**
 * Set of tests to exercise the high level {@link NumberToEnglishWordConverterImpl} class.
 * @author Raul
 *
 */
public class NumberToEnglishWordConverterTest {

	/**
	 * Test method for {@link onprem.utils.conversion.NumberToEnglishWordConverterImpl#convertToNumberWord(string)} for valid input.
	 */
	@Test
	public final void testConvertToNumberStringValid() {
		String conversionResult = "";
		NumberToEnglishWordConverter numberToStringConverterImpl = new NumberToEnglishWordConverterImpl();
		
		conversionResult = numberToStringConverterImpl.convertToNumberWord("0");
		assertEquals(conversionResult, "String = zero");
		
		conversionResult = numberToStringConverterImpl.convertToNumberWord("-1000");
		assertEquals(conversionResult, "String = negative one thousand");
		
		conversionResult = numberToStringConverterImpl.convertToNumberWord("123");
		assertEquals(conversionResult, "String = one hundred twenty three");
		
		conversionResult = numberToStringConverterImpl.convertToNumberWord("2147483647");
		assertEquals(conversionResult, "String = two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven");
		
		conversionResult = numberToStringConverterImpl.convertToNumberWord("-2147483647");
		assertEquals(conversionResult, "String = negative two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven");
	}

	/**
	 * Test method for {@link onprem.utils.conversion.NumberToEnglishWordConverterImpl#convertToNumberWord(string)} for valid input.
	 */
	@Test
	public final void testConvertToNumberStringInvalid() {
		String conversionResult = "";
		NumberToEnglishWordConverterImpl numberToStringConverterImpl = new NumberToEnglishWordConverterImpl();
		
		conversionResult = numberToStringConverterImpl.convertToNumberWord("1.0");
		assertEquals(conversionResult, "Conversion of this input not yet supported");

		conversionResult = numberToStringConverterImpl.convertToNumberWord("1.");
		assertEquals(conversionResult, "Conversion of this input not yet supported");
		
		conversionResult = numberToStringConverterImpl.convertToNumberWord("1.2.3");
		assertEquals(conversionResult, "Conversion of this input not yet supported");
		
	}	
	
}
