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
	@SuppressWarnings("static-access")
	public void testInteractiveSolution(){
		try{
			GalacticCurrencyLog.getLog().info("Test input:");
			GalacticCurrencyLog.getLog().info("glob is " + ConvertCurrencyUtil.getInstance().parseUnitRoman("glob"));
			GalacticCurrencyLog.getLog().info("prok is " + ConvertCurrencyUtil.getInstance().parseUnitRoman("prok"));
			GalacticCurrencyLog.getLog().info("pish is " + ConvertCurrencyUtil.getInstance().parseUnitRoman("pish"));
			GalacticCurrencyLog.getLog().info("tegj is " + ConvertCurrencyUtil.getInstance().parseUnitRoman("tegj"));
			GalacticCurrencyLog.getLog().info("glob glob Silver is " + ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("glob glob silver") +" Credits");
			GalacticCurrencyLog.getLog().info("glob prok Gold is " + ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("glob prok Gold") +" Credits");
			GalacticCurrencyLog.getLog().info("pish pish Iron is " + ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("pish pish Iron") +" Credits");
			GalacticCurrencyLog.getLog().info("how much is pish tegj glob glob ? is " + ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit("pish tegj glob glob") );
			GalacticCurrencyLog.getLog().info("how many Credits is glob prok Silver ? is " + ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("glob prok Silver") );
			GalacticCurrencyLog.getLog().info("how many Credits is glob prok Gold ? is " + ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("glob prok Gold") );
			GalacticCurrencyLog.getLog().info("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
			GalacticCurrencyLog.getLog().info("" + ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits("wood could a woodchuck chuck")); 
			
		}catch(Exception e){
			GalacticCurrencyLog.getLog().error("I have no idea what you are talking about.");
			assertTrue("Error in testInteractiveSolution.",Boolean.TRUE);
		}
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
			assertTrue("Error in testConvertGalaxyMoneytoUnitEmpty.",Boolean.TRUE);
		}
	}
	
	@Test
	public void testConvertGalaxyMoneytoUnitNull(){
		try {
			GalacticCurrencyLog.getLog().info("testConvertGalaxyMoneytoUnitNull.");
			assertEquals( null , ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoUnit(null));
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertGalaxyMoneytoUnitNull. ", e);
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
