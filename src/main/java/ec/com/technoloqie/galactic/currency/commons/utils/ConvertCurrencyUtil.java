package ec.com.technoloqie.galactic.currency.commons.utils;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;

import ec.com.technoloqie.galactic.currency.commons.CurrencyConstants;

public final class ConvertCurrencyUtil {
	
	//objeto que sera instanciado
	private static ConvertCurrencyUtil instance = new ConvertCurrencyUtil();
	
	private HashMap<Character, Integer> currencyMap = new HashMap<Character, Integer>();
	
	private ConvertCurrencyUtil(){
		currencyMap.put(CurrencyConstants.ROMAN_M, 1000);
		currencyMap.put(CurrencyConstants.ROMAN_D, 500);
		currencyMap.put(CurrencyConstants.ROMAN_C, 100);
		currencyMap.put(CurrencyConstants.ROMAN_L, 50);
		currencyMap.put(CurrencyConstants.ROMAN_X, 10);
		currencyMap.put(CurrencyConstants.ROMAN_V, 5);
		currencyMap.put(CurrencyConstants.ROMAN_I, 1);
	}
	
	public static ConvertCurrencyUtil getInstance() {
		if (null == instance) {
			instance = new ConvertCurrencyUtil();

		}
		return instance;
	}
	
	
	public double convertCredit(String input) {
		int totalUnits = 0;
		Stack<Character> symbolStack = new Stack<Character>();
		
		for (Character character : input.toCharArray()) {
			symbolStack.add(character);
		}
		
		Character nextSymbol = null, currentSymbol;
		
		// Input is empty
		if (symbolStack.size() == 0) {
			return 00;
		}else if (symbolStack.size() == 1) {	// input have only one symbol
			return convertUnitsToCredits(currencyMap.get(symbolStack.pop()));
		}else{
		
		// input have more than one symbol
		while (!symbolStack.isEmpty()) {
		
			// pop end element
			currentSymbol = symbolStack.pop();
		
			// peek next symbol.
			// Important Note 'H' is invalid
		
			if (!symbolStack.isEmpty()) {
				nextSymbol = symbolStack.peek();
			} else {
				nextSymbol = 'H';
			}
		
			// "I" can be subtracted from "V" and "X" only.
			// "X" can be subtracted from "L" and "C" only.
			// "C" can be subtracted from "D" and "M" only.
			// "V","L", and "D" can never be subtracted.
			//
			// Only one small-value symbol may be subtracted from any
			// large-value symbol.
		
			if (nextSymbol != 'H'
						&& (nextSymbol == CurrencyConstants.ROMAN_I && (currentSymbol == CurrencyConstants.ROMAN_V || currentSymbol == CurrencyConstants.ROMAN_X))
						|| (nextSymbol == CurrencyConstants.ROMAN_X && (currentSymbol == CurrencyConstants.ROMAN_L || currentSymbol == CurrencyConstants.ROMAN_C))
						|| (nextSymbol == CurrencyConstants.ROMAN_C && (currentSymbol == CurrencyConstants.ROMAN_D || currentSymbol == CurrencyConstants.ROMAN_M))) {
		
					totalUnits += currencyMap.get(currentSymbol) - currencyMap.get(symbolStack.pop());
		
				} else {
					totalUnits += currencyMap.get(currentSymbol);
				}
			}
		}
		
		return convertUnitsToCredits(totalUnits);
	}
	
	/**
	 * Convierte unidades a creditos dependiendo del tipo de metal.
	 * @param numberOfUnits
	 * @return
	 */
	private double convertUnitsToCredits(int numberOfUnits) {

		// Credit for iron
		if (CurrencyConstants.currentMetalType == CurrencyConstants.METAL_IRON) {
			return numberOfUnits * CurrencyConstants.IRON_PER_UNIT;
		}
		// Credit for Silver
		else if (CurrencyConstants.currentMetalType == CurrencyConstants.METAL_SILVER) {
			return numberOfUnits * CurrencyConstants.SILVER_PER_UNIT;
		}
		// Credit for Gold
		else if (CurrencyConstants.currentMetalType == CurrencyConstants.METAL_GOLD) {
			return numberOfUnits * CurrencyConstants.GOLD_PER_UNIT;
		}
		// just checking credits
		else {
			return numberOfUnits;
		}
	}
	
	/**
	 * Validacion de sucesion de simbolos romanos 
	 * @param string
	 * @return
	 */
	public final String checkRepeatedSuccession(String string) {

		String errorMessage = null;

		// "I", "X", "C", and "M" can be repeated three times
		if (Pattern.compile(CurrencyConstants.REGEX_MORE_THAN_3_OCCURANCE).matcher(string).find()) {
			errorMessage = CurrencyConstants.ERROR_MESSAGE_4_OCCURANCE;
		}

		// "D", "L", and "V" can never be repeated
		if (Pattern.compile(CurrencyConstants.REGEX_MORE_THAN_ONE_OCCURANCE).matcher(string).find()) {
			errorMessage = CurrencyConstants.ERROR_MESSAGE_2_OCCURANCE;
		}

		// "I" cannot occure more than once in from of C,X,L,C,D,M
		if (Pattern.compile(CurrencyConstants.REGEX_MORE_THAN_1_OCCURANCE_OF_I_AS_PREFIX).matcher(string).find()) {
			errorMessage = CurrencyConstants.ERROR_MESSAGE_2_OCCURANCE_I_PREFIX;
		}

		// "X" cannot occure more than once in from of L,C,D,M
		if (Pattern.compile(CurrencyConstants.REGEX_MORE_THAN_1_OCCURANCE_OF_X_AS_PREFIX).matcher(string).find()) {
			errorMessage = CurrencyConstants.ERROR_MESSAGE_2_OCCURANCE_X_PREFIX;
		}

		// "C" cannot occure more than once in from of D,M
		if (Pattern.compile(CurrencyConstants.REGEX_MORE_THAN_1_OCCURANCE_OF_C_AS_PREFIX).matcher(string).find()) {
			errorMessage = CurrencyConstants.ERROR_MESSAGE_2_OCCURANCE_C_PREFIX;
		}

		return errorMessage;
	}
}
