package ec.com.technoloqie.galactic.currency.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ec.com.technoloqie.galactic.currency.commons.exception.GalacticCurrencyException;
import ec.com.technoloqie.galactic.currency.commons.log.GalacticCurrencyLog;
import ec.com.technoloqie.galactic.currency.commons.utils.ConvertCurrencyUtil;

public class ConvertGalacticCurrencyTest {
	
	@Before
	public void setUp() throws GalacticCurrencyException{
		
	}
	
	@Test
	public void testParseUnitRoman(){
		try {
			GalacticCurrencyLog.getLog().info("testparseUnitRoman.");
			assertEquals( "XLII" , ConvertCurrencyUtil.getInstance().parseUnitRoman("pish tegj glob glob"));
			assertEquals( "IV" , ConvertCurrencyUtil.getInstance().parseUnitRoman("glob prok"));
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertUnitRoman.");
			fail("Error in testParseUnitRoman.");
		}
	}
	
	@Test
	public void testParseUnitRomanEmpty(){
		try {
			GalacticCurrencyLog.getLog().info("testparseUnitRoman.");
			assertEquals( "" , ConvertCurrencyUtil.getInstance().parseUnitRoman(""));
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertUnitRoman.");
			fail("Error in testParseUnitRoman.");
		}
	}
	
	@Test
	public void testParseUnitRomanNull(){
		try {
			GalacticCurrencyLog.getLog().info("testparseUnitRoman.");
			assertEquals( null , ConvertCurrencyUtil.getInstance().parseUnitRoman(null));
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertUnitRoman.");
			fail("Error in testParseUnitRoman.");
		}
	}
	
	@Test
	public void testConvertGalaxyMoneytoUnit(){
		try {
			GalacticCurrencyLog.getLog().info("testConvertGalaxyMoneytoUnit.");
			assertEquals( 42.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit("pish tegj glob glob"),0.0);		
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertGalaxyMoneytoUnit.");
			fail("Error in testConvertGalaxyMoneytoUnit.");
		}
	}
	
}
