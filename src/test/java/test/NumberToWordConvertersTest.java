/**
 * 
 */

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import onprem.utils.conversion.IntegerWordConverterImpl;
import onprem.utils.conversion.exception.InvalidConversionException;

/**
 * 
 * Set of tests to exercise individual number to word converters.
 * 
 * @author Raul
 *
 */
public class NumberToWordConvertersTest {

	/**
	 * Test method for {@link onprem.utils.conversion.DoubleWordConverterImpl#convertToString(double)} for valid input.
	 */
	@Test
	public final void testDoubleToWordConversionValid() {
		
	}

	/**
	 * Test method for {@link onprem.utils.conversion.DoubleWordConverterImpl#convertToString(double)} for invalid input.
	 */
	@Test
	public final void testDoubleToWordConversionInvalid() {
		
	}
	
	/**
	 * Test method for {@link onprem.utils.conversion.IntegerWordConverterImpl#convertToString(int)} for invalid input.
	 */
	@Test
	public final void testIntegerToWordConversionInvalid() {

		IntegerWordConverterImpl integerToWord = new IntegerWordConverterImpl();
		
		String conversionResult = "";
		
		try {
			conversionResult = integerToWord.convertToString(1.0);
			fail("Not expecting to reach here");
		} catch (InvalidConversionException e) {
			
		}
		
		try {
			conversionResult = integerToWord.convertToString(null);
			fail("Not expecting to reach here");
		} catch (InvalidConversionException e) {
			
		}
	}
	
	/**
	 * Test method for {@link onprem.utils.conversion.IntegerWordConverterImpl#convertToString(int)} for valid input.
	 */
	@Test
	public final void testIntegerToWordConversionValid() {
		IntegerWordConverterImpl integerToWord = new IntegerWordConverterImpl();
		
		String conversionResult = "";
		
		try {
			conversionResult = integerToWord.convertToString(0);
			assertEquals(conversionResult, "zero");
	
			conversionResult = integerToWord.convertToString(1);
			assertEquals(conversionResult, "one");
			
			conversionResult = integerToWord.convertToString(5);
			assertEquals(conversionResult, "five");
	
			conversionResult = integerToWord.convertToString(10);
			assertEquals(conversionResult, "ten");
			
			conversionResult = integerToWord.convertToString(15);
			assertEquals(conversionResult, "fifteen");
			
			conversionResult = integerToWord.convertToString(19);
			assertEquals(conversionResult, "nineteen");
			
			conversionResult = integerToWord.convertToString(20);
			assertEquals(conversionResult, "twenty");
			
			conversionResult = integerToWord.convertToString(21);
			assertEquals(conversionResult, "twenty one");
			
			conversionResult = integerToWord.convertToString(59);
			assertEquals(conversionResult, "fifty nine");
			
			conversionResult = integerToWord.convertToString(99);
			assertEquals(conversionResult, "ninety nine");
			
			conversionResult = integerToWord.convertToString(100);
			assertEquals(conversionResult, "one hundred");
			
			conversionResult = integerToWord.convertToString(101);
			assertEquals(conversionResult, "one hundred one");
			
			conversionResult = integerToWord.convertToString(116);
			assertEquals(conversionResult, "one hundred sixteen");
			
			conversionResult = integerToWord.convertToString(999);
			assertEquals(conversionResult, "nine hundred ninety nine");
			
			conversionResult = integerToWord.convertToString(1000);
			assertEquals(conversionResult, "one thousand");
	
			conversionResult = integerToWord.convertToString(1000);
			assertEquals(conversionResult, "one thousand");
	
			conversionResult = integerToWord.convertToString(9999);
			assertEquals(conversionResult, "nine thousand nine hundred ninety nine");
	
			conversionResult = integerToWord.convertToString(10000);
			assertEquals(conversionResult, "ten thousand");
	
			conversionResult = integerToWord.convertToString(19000);
			assertEquals(conversionResult, "nineteen thousand");
	
			conversionResult = integerToWord.convertToString(50000);
			assertEquals(conversionResult, "fifty thousand");
	
			conversionResult = integerToWord.convertToString(100000);
			assertEquals(conversionResult, "one hundred thousand");
	
			conversionResult = integerToWord.convertToString(1000000);
			assertEquals(conversionResult, "one million");
	
			conversionResult = integerToWord.convertToString(1000000000);
			assertEquals(conversionResult, "one billion");
	
			conversionResult = integerToWord.convertToString(999999999);
			assertEquals(conversionResult, "nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");
	
			conversionResult = integerToWord.convertToString(123456789);
			assertEquals(conversionResult, "one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine");
	
			conversionResult = integerToWord.convertToString(2147483647);
			assertEquals(conversionResult, "two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven");
	
			conversionResult = integerToWord.convertToString(-2147483647);
			assertEquals(conversionResult, "negative two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven");
		} catch (InvalidConversionException e) {
			fail("Not expecting to reach here");
		}	
		
	}
}
