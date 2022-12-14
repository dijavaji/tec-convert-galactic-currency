package ec.com.technoloqie.galactic.currency.service.impl;

import org.springframework.stereotype.Service;

import ec.com.technoloqie.galactic.currency.commons.CurrencyConstants;
import ec.com.technoloqie.galactic.currency.commons.utils.ConvertCurrencyUtil;
import ec.com.technoloqie.galactic.currency.model.Currency;
import ec.com.technoloqie.galactic.currency.service.CurrencyService;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService{

	@Override
	public Currency convertGalaxyMoneytoCredits(String coins) {
		Currency currency = new Currency();
		currency.setCoin(ConvertCurrencyUtil.getInstance().convertGalaxyMoneytoCredits(coins));
		currency.setCurrency(CurrencyConstants.GALACTIC_CURRENCY);
		return currency;
	}
}
