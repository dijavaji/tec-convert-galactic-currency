package ec.com.technoloqie.galactic.currency.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ec.com.technoloqie.galactic.currency.commons.exception.GalacticCurrencyException;
import ec.com.technoloqie.galactic.currency.commons.log.GalacticCurrencyLog;
import ec.com.technoloqie.galactic.currency.commons.utils.ConvertCurrencyUtil;

/**
 * Utilizada para realizar test unitarios sobre la conversi&#243;n entre unidades intergal&#225;cticas y n&#250;meros romanos.
 * @author dvasquez
 *
 */
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
			assertEquals( 1.0, ConvertCurrencyUtil.getInstance().convertCredit("I"),1);
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
			GalacticCurrencyLog.getLog().error("testConvert.");
			assertEquals( 39.0, ConvertCurrencyUtil.getInstance().convertCredit("XXXIX"),39);		
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertRomanNumbers.");
			fail("Error in testConvertRomanNumbers.");
		}
	}
	
	public void testSmallerValuesSubtracted_I() throws Exception {

		// Subtract
		assertEquals(4.0, ConvertCurrencyUtil.getInstance().convertCredit("IV"));
		assertEquals(9.0, ConvertCurrencyUtil.getInstance().convertCredit("IX"));

		// ADD
		assertEquals(6.0, ConvertCurrencyUtil.getInstance().convertCredit("VI"));
		assertEquals(11.0, ConvertCurrencyUtil.getInstance().convertCredit("XI"));

	}

	public void testSmallerValuesSubtracted_X() throws Exception {

		assertEquals(40.0, ConvertCurrencyUtil.getInstance().convertCredit("XL"));
		assertEquals(90.0, ConvertCurrencyUtil.getInstance().convertCredit("XC"));

		assertEquals(60.0, ConvertCurrencyUtil.getInstance().convertCredit("LX"));
		assertEquals(110.0, ConvertCurrencyUtil.getInstance().convertCredit("CX"));

	}

	public void testSmallerValuesSubtracted_C() throws Exception {

		assertEquals(400.0, ConvertCurrencyUtil.getInstance().convertCredit("CD"));
		assertEquals(900.0, ConvertCurrencyUtil.getInstance().convertCredit("CM"));

		assertEquals(600.0, ConvertCurrencyUtil.getInstance().convertCredit("DC"));
		assertEquals(1100.0, ConvertCurrencyUtil.getInstance().convertCredit("MC"));

	}

}
