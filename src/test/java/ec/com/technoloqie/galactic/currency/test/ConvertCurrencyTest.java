package ec.com.technoloqie.galactic.currency.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import ec.com.technoloqie.galactic.currency.commons.exception.GalacticCurrencyException;
import ec.com.technoloqie.galactic.currency.commons.log.GalacticCurrencyLog;
import ec.com.technoloqie.galactic.currency.commons.utils.ConvertCurrencyUtil;

/**
 * Utilizada para realizar test unitarios sobre la conversi&#243;n entre unidades intergal&#225;cticas y n&#250;meros romanos.
 * @author dvasquez
 *
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class ConvertCurrencyTest {
	
	@Before
	public void setUp() throws GalacticCurrencyException{
		
	}
	
	@Test
	public void testNumberEmpty(){
		try {
			GalacticCurrencyLog.getLog().info("testNumberEmpty.");
			ConvertCurrencyUtil.getInstance().convertRomantoUnit("");
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
			assertEquals( 1.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("I"),0);
			assertEquals(5.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("V"),0);
			assertEquals(10.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("X"),0);
			assertEquals(50.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("L"),0);
			assertEquals(100.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("C"),0);
			assertEquals(500.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("D"),0);
			assertEquals(1000.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("M"),0);

			
		} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("Error in testConvertRomanNumbers.");
			fail("Error in testConvertRomanNumbers.");
		}
	}
	
	@Test
	public void testNumberNull(){
		try {
			GalacticCurrencyLog.getLog().info("testNumberNull.");
			assertEquals(null , ConvertCurrencyUtil.getInstance().convertRomantoUnit(null));
		} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testNumberNull.");
			assertTrue("number is null.",Boolean.TRUE);
		}
	}
	
	@Test
	public void testConvert(){
		try {
			GalacticCurrencyLog.getLog().info("testConvert.");
			assertEquals( 39.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("XXXIX"),0.0);		
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testConvertRomanNumbers.");
			fail("Error in testConvertRomanNumbers.");
		}
	}
	
	@Test
	public void testValidSucession() throws Exception {
		
		try {
			GalacticCurrencyLog.getLog().info("testValidSucession.");
			assertEquals( 39.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("XXXXI"),0.0);		
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testValidSucession.",e);
			assertTrue("Error in testValidSucession.",Boolean.TRUE);
		}
	}
	
	@Test
	public void testValidSucession_D() throws Exception {
		
		try {
			GalacticCurrencyLog.getLog().info("testValidSucession.");
			ConvertCurrencyUtil.getInstance().convertRomantoUnit("DDI");		
			} catch (Exception e) {
			GalacticCurrencyLog.getLog().error("testValidSucession.",e);
			assertTrue("Error in testValidSucession.",Boolean.TRUE);
		}
	}
	
	@Test
	public void testSmallerValuesSubtracted_I() throws Exception {

		// Subtract
		assertEquals(4.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("IV"), 0.0);
		assertEquals(9.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("IX"),0.0);

		// ADD
		assertEquals(6.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("VI"),0.0);
		assertEquals(11.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("XI"),0.0);

	}
	
	@Test
	public void testSmallerValuesSubtracted_X() throws Exception {

		assertEquals(40.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("XL"),0.0);
		assertEquals(90.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("XC"),0.0);

		assertEquals(60.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("LX"),0.0);
		assertEquals(110.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("CX"),0.0);

	}
	
	@Test
	public void testSmallerValuesSubtracted_C() throws Exception {

		assertEquals(400.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("CD"),0.0);
		assertEquals(900.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("CM"),0.0);

		assertEquals(600.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("DC"),0.0);
		assertEquals(1100.0, ConvertCurrencyUtil.getInstance().convertRomantoUnit("MC"),0.0);

	}

}
