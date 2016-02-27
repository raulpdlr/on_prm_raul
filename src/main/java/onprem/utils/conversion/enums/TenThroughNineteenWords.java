package onprem.utils.conversion.enums;

/**
 * Enum to represent the words including 10 to 19.
 * @author Raul
 *
 */
public enum TenThroughNineteenWords {
    TEN(" ten"),
    ELEVEN(" eleven"),
    TWELVE(" twelve"),
    THIRTEEN(" thirteen"),
    FOURTEEN(" fourteen"),
    FIFTEEN(" fifteen"),
    SIXTEEN(" sixteen"),
    SEVENTEEN(" seventeen"),
    EIGHTEEN(" eighteen"),
    NINETEEN(" nineteen");
	
    private String wordNumber;
	
    TenThroughNineteenWords(String s) {
		this.wordNumber = s;
	}

	public String getWordNumber() {
		return wordNumber;
	}     
}

