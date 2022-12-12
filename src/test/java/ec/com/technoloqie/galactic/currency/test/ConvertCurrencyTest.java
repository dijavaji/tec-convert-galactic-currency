package ec.com.technoloqie.galactic.currency.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ec.com.technoloqie.galactic.currency.commons.exception.GalacticCurrencyException;
import ec.com.technoloqie.galactic.currency.commons.log.GalacticCurrencyLog;
import ec.com.technoloqie.galactic.currency.commons.utils.ConvertCurrencyUtil;

public class ConvertCurrencyTest {
	
	@Before
	public void setUp() throws GalacticCurrencyException{
		
	}
	
	@Test
	public void testNumberEmpty(){
		try {
			GalacticCurrencyLog.getLog().info("testNumberEmpty.");
			ConvertCurrencyUtil.getInstance().convertCredit("");
		} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("Number is empty.");
			assertTrue("Number is empty.",Boolean.TRUE);
		}
	}
	
	@Test
	public void testConvertRomanNumbers(){
		try {
			//ConvertCurrencyUtil.getInstance().convertCredit("");
			GalacticCurrencyLog.getLog().info("testConvertRomanNumbers.");
			assertEquals( 1.0, ConvertCurrencyUtil.getInstance().convertCredit("I"),5);
			assertEquals(5.0, ConvertCurrencyUtil.getInstance().convertCredit("V"),5);
			assertEquals(10.0, ConvertCurrencyUtil.getInstance().convertCredit("X"),10);
			assertEquals(50.0, ConvertCurrencyUtil.getInstance().convertCredit("L"),50);
			assertEquals(100.0, ConvertCurrencyUtil.getInstance().convertCredit("C"),100);
			assertEquals(500.0, ConvertCurrencyUtil.getInstance().convertCredit("D"),500);
			assertEquals(1000.0, ConvertCurrencyUtil.getInstance().convertCredit("M"),1000);

			
		} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("Error in testConvertRomanNumbers.");
			fail("Error in testConvertRomanNumbers.");
		}
	}
	
	@Test
	public void testNumberNull(){
		try {
			GalacticCurrencyLog.getLog().info("testNumberNull.");
			ConvertCurrencyUtil.getInstance().convertCredit(null);
		} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testNumberNull.");
			assertTrue("number is null.",Boolean.TRUE);
		}
	}
	
	@Test
	public void testConvert(){
		try {
			//ConvertCurrencyUtil.getInstance().convertCredit("");
			//GalacticCurrencyLog.getLog().error("testConvertRomanNumbers.");		
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertRomanNumbers.");
			fail("Error in testConvertRomanNumbers.");
		}
	}

}
