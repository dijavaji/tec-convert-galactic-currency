package ec.com.technoloqie.galactic.currency.commons;

public interface CurrencyConstants {
	
	// Roman numerals
	public static final char ROMAN_I = 'I';
	public static final char ROMAN_V = 'V';
	public static final char ROMAN_X = 'X';
	public static final char ROMAN_L = 'L';
	public static final char ROMAN_C = 'C';
	public static final char ROMAN_D = 'D';
	public static final char ROMAN_M = 'M';
	
	// Metal Types
	static final String NONE = "";
	static final String METAL_IRON = "iron";
	static final String METAL_SILVER = "silver";
	static final String METAL_GOLD = "gold";
	static final String GALACTIC_CURRENCY = "credits";
	
	// Exchnage rate
	static final double IRON_PER_UNIT = 195.5;
	static final double SILVER_PER_UNIT = 17;
	static final double GOLD_PER_UNIT = 14450;
	
	// Rules for valid roman inputs
	static final String REGEX_MORE_THAN_3_OCCURANCE = "([I,X,C,M])\\1{3,}";
	static final String REGEX_MORE_THAN_ONE_OCCURANCE = "([D,L,V])\\1{1,}";
	static final String REGEX_MORE_THAN_1_OCCURANCE_OF_I_AS_PREFIX = "(I)\\1+([V,X,L,C,D,M])";
	static final String REGEX_MORE_THAN_1_OCCURANCE_OF_X_AS_PREFIX = "(X)\\1+([L,C,D,M])";
	static final String REGEX_MORE_THAN_1_OCCURANCE_OF_C_AS_PREFIX = "(C)\\1+([D,M])";
	
	// Error Messages for invalid inputs
	static final String ERROR_MESSAGE_2_OCCURANCE = "Invalid Input D,L,V cannot occure twise";
	static final String ERROR_MESSAGE_4_OCCURANCE = "Invalid Input I,X,C,M cannot occure 4 times";
	static final String ERROR_MESSAGE_2_OCCURANCE_I_PREFIX = "Invalid Input I cannot occure more than once as prefix";
	static final String ERROR_MESSAGE_2_OCCURANCE_X_PREFIX = "Invalid Input X cannot occure more than once as prefix";
	static final String ERROR_MESSAGE_2_OCCURANCE_C_PREFIX = "Invalid Input C cannot occure more than once as prefix";
	
	public static int currentMetalType = -1;
}
