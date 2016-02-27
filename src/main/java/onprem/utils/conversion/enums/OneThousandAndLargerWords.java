package onprem.utils.conversion.enums;

/**
 * Enum to represent the words including and exceeding the thousandths place.
 * @author Raul
 *
 */
public enum OneThousandAndLargerWords {
    BLANK(" "),
    THOUSAND(" thousand"),
    MILLION(" million"),
    BILLION(" billion"),
    TRILLION(" trillion"),
    QUADRILLION(" quadrillion"),
    QUINTILLION(" quintillion"),
    SEXTILLION(" sextillion"),
    SEPTILLION(" septillion"),
    OCTILLION(" octillion"),
    NONILLION(" nonillion"),
    DECILLION(" decillion");
	
    private String wordNumber;
	
	OneThousandAndLargerWords(String s) {
		this.wordNumber = s;
	}

	public String getWordNumber() {
		return wordNumber;
	}
}