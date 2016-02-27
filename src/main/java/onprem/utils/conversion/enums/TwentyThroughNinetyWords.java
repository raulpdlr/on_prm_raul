package onprem.utils.conversion.enums;

/**
 * Enum to represent the words 20, 30,40,...,90.
 * @author Raul
 *
 */
public enum TwentyThroughNinetyWords {
	
	BLANKA(""),
	BLANKB(""),
	TWENTY(" twenty"),
	THIRTY(" thirty"),
	FORTY(" forty"),
	FIFTY(" fifty"),
	SIXTY(" sixty"),
	SEVENTY(" seventy"),
	EIGHTY(" eighty"),
	NINETY(" ninety");

    private String wordNumber;
	
	TwentyThroughNinetyWords(String s) {
		this.wordNumber = s;
	}

	public String getWordNumber() {
		return wordNumber;
	}
}
