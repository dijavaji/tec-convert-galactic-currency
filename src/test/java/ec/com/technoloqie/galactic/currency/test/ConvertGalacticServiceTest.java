package ec.com.technoloqie.galactic.currency.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ec.com.technoloqie.galactic.currency.commons.CurrencyConstants;
import ec.com.technoloqie.galactic.currency.commons.log.GalacticCurrencyLog;
import ec.com.technoloqie.galactic.currency.model.Currency;
import ec.com.technoloqie.galactic.currency.service.impl.CurrencyServiceImpl;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={CurrencyServiceImpl.class})
//@TestPropertySource("/appTest.properties")
public class ConvertGalacticServiceTest {
	
	@Autowired
	private CurrencyServiceImpl currencyService;
	
	@Test
	public void testServiceConvertMoneytoCredits(){
		try{
			GalacticCurrencyLog.getLog().info("testServiceConvertMoneytoCredits.");
			Currency currency = currencyService.convertGalaxyMoneytoCredits("glob prok Silver");
			assertEquals( 68.0 ,currency.getCoin(),0);
			assertEquals( CurrencyConstants.GALACTIC_CURRENCY ,currency.getCurrency());
		}catch(Exception e){
			GalacticCurrencyLog.getLog().error("testServiceConvertMoneytoCredits.");
			fail("Error in testServiceConvertMoneytoCredits.");
		}
	}
	
	
}
