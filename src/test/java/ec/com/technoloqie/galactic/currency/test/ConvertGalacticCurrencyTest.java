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
			assertEquals( "I" , ConvertCurrencyUtil.getInstance().parseUnitRoman("glob"));
			assertEquals( "V" , ConvertCurrencyUtil.getInstance().parseUnitRoman("prok"));
			assertEquals( "X" , ConvertCurrencyUtil.getInstance().parseUnitRoman("pish"));
			assertEquals( "L" , ConvertCurrencyUtil.getInstance().parseUnitRoman("tegj"));
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
			assertEquals( 1.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit("glob"),0.0);
			assertEquals( 5.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit("prok"),0.0);
			assertEquals( 10.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit("pish"),0.0);
			assertEquals( 50.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit("tegj"),0.0);
			assertEquals( 42.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit("pish tegj glob glob"),0.0);		
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertGalaxyMoneytoUnit.");
			fail("Error in testConvertGalaxyMoneytoUnit.");
		}
	}
	
	@Test
	public void testConvertGalaxyMoneytoUnitEmpty(){
		try {
			GalacticCurrencyLog.getLog().info("testConvertGalaxyMoneytoUnitEmpty.");
			assertEquals( 0.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit(""),0);
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertGalaxyMoneytoUnitEmpty.");
			fail("Error in testConvertGalaxyMoneytoUnitEmpty.");
		}
	}
	
	@Test
	public void testConvertGalaxyMoneytoUnitNull(){
		try {
			GalacticCurrencyLog.getLog().info("testConvertGalaxyMoneytoUnitNull.");
			assertEquals( null , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit(null));
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertGalaxyMoneytoUnitNull." + e);
			assertTrue("testConvertGalaxyMoneytoUnitNull number is null.",Boolean.TRUE);
		}
	}
	
	
	@Test
	public void testConvertGalaxyMoneytoCredits(){
		try {
			GalacticCurrencyLog.getLog().info("testConvertGalaxyMoneytoCredits.");
			assertEquals( 68.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("glob prok silver"),0.0);
			assertEquals( 57800.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("glob prok gold"),0.0);
			assertEquals( 782.0 , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("glob prok iron"),0.0);
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertGalaxyMoneytoCredits.");
			fail("Error in testConvertGalaxyMoneytoCredits.");
		}
	}
	
}
