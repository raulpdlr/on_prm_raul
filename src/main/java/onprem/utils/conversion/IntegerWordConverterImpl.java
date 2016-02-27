package onprem.utils.conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import onprem.utils.conversion.enums.OneThousandAndLargerWords;
import onprem.utils.conversion.enums.OneThroughNineWords;
import onprem.utils.conversion.enums.TenThroughNineteenWords;
import onprem.utils.conversion.enums.TwentyThroughNinetyWords;
import onprem.utils.conversion.exception.InvalidConversionException;

/**
 * Class to allow the conversion of integer numbers to their English word representations.
 * Extraneous comments are provided to help readability.
 * @author Raul
 *
 */
public class IntegerWordConverterImpl implements InputConverter {

	/** 
	 * Converts integer numbers that are less than one thousand to their word equivalent.
	 * Is used as a helper function.
	 * @param numberInput Input integer number
	 * @return String representation of integer number
	 */
	private String convertLessThanOneThousandString(final int numberInput) {
        int number = numberInput;
		String numberWordResult = "";
        String hundredWord = "";
        
        String twentyThroughNinetyWord = "";
        String tenThroughNineteenWord = "";
        String oneThroughNineWord = "";
        
        String lastTwoDigitWord = "";
        
        // If there is a number in the hundreds place, we need the word equivalent for it that includes the word 'hundred'
        if (number >= 100) {
        	int singleHundredWordIndex = number / 100;

        	hundredWord = OneThroughNineWords.values()[singleHundredWordIndex].getWordNumber() + " hundred";

        	number = number % 100;
        }
        
        // If there is a number between 20 and 99, we need the word equivalent plus any 
        // single digit number associated with it such as 'twenty one' 
        if (number >= 20 && number <= 99) {
        	// First get the "n"ty part of the number
        	int twentyThroughNinetyIndex = number / 10;
        	twentyThroughNinetyWord = TwentyThroughNinetyWords.values()[twentyThroughNinetyIndex].getWordNumber();
        	
        	// Now get the remaining single number
        	number = number % 10;
        	oneThroughNineWord = OneThroughNineWords.values()[number].getWordNumber();
        	
        	lastTwoDigitWord = twentyThroughNinetyWord + oneThroughNineWord;
        	number = 0;
        } else if (number >= 10 && number <= 19) {
        	// If the number is between 10 and 19, we need the word equivalent including any possible 'teen' values.
        	number = number % 10;
        	tenThroughNineteenWord = TenThroughNineteenWords.values()[number].getWordNumber();
        	
        	lastTwoDigitWord = tenThroughNineteenWord;
        	number = 0;
        } else if (number >= 1 && number <= 9) {
            // If the number is a single digit, just get the single digit word equivalent.
        	lastTwoDigitWord = OneThroughNineWords.values()[number].getWordNumber();
        } 
          
        // Final result will be the word in the hundreds place plus the last two digits which can be a single or double digit number.
        numberWordResult = hundredWord + lastTwoDigitWord;
        
        return numberWordResult;
    }
    
    /*
     * (non-Javadoc)
     * @see onprem.utils.conversion.AbstractNumberToWordConverter#convertToString(java.lang.Number)
     */
	@Override
    public final String convertToString(final Number inputNumber) throws InvalidConversionException {
    	Integer number;
    	String numberWordResult = "";
    	
    	if (inputNumber == null) {
    		throw new InvalidConversionException("Illegal argument given, null");
    	} else if (!(inputNumber instanceof Integer)) {
    		throw new InvalidConversionException("Unsupported conversion for number: " + inputNumber.toString());
    	}
    	
    	number = (Integer) inputNumber;   	
    	
        if (number == 0) { 
        	return "zero"; 
    	}

        String prefix = "";

        if (number < 0) {
            number = Math.abs(number);
            prefix = "negative";
        }

        List<Integer> numberParts = new ArrayList<Integer>(); 
        
        // Break the number down into the parts that would be separated by commas and put into a list.
        // 1,234,567 goes into the list as [567, 234, 1]
        while (number > 0) {
        	int modOneThousandResult = number % 1000;
        	number = number / 1000;
        	numberParts.add(modOneThousandResult);
        }
        
        ListIterator<Integer> listIterator = numberParts.listIterator(numberParts.size());
        
        int placesCounter = numberParts.size() - 1;
        
        // Since the comma separated number blocks were put in an order in the list that is reverse of the 
        // actual number, we will reverse iterate this list to get the word conversions done in proper order.
        while (listIterator.hasPrevious()) {
        	int currentNumber = (int) listIterator.previous();
        	
        	if (currentNumber != 0) {
            	String underOneThousandWord = convertLessThanOneThousandString(currentNumber);
            	numberWordResult = numberWordResult + underOneThousandWord + OneThousandAndLargerWords.values()[placesCounter].getWordNumber();       		
        	}
        	
        	placesCounter--;
        }

        return (prefix + numberWordResult).trim();
    }
}
