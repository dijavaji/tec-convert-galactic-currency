package ec.com.technoloqie.galactic.currency.commons.utils;

import java.util.HashMap;
import java.util.Stack;

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
	
	/*
	 * Coverts units to credit depend on current metal type
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
}
