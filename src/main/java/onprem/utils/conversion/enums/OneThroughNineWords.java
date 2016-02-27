package onprem.utils.conversion.enums;

/**
 * Enum to represent the words from 1 to 9.
 * @author Raul
 *
 */
public enum OneThroughNineWords {
    BLANK(""),
	ONE(" one"),
    TWO(" two"),
    THREE(" three"),
    FOUR(" four"),
    FIVE(" five"),
    SIX(" six"),
    SEVEN(" seven"),
    EIGHT(" eight"),
    NINE(" nine");
    
    private String wordNumber;
	
	OneThroughNineWords(String s) {
		this.wordNumber = s;
	}

	public String getWordNumber() {
		return wordNumber;
	}        
}
