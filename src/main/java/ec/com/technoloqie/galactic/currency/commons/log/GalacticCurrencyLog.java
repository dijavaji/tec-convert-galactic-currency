package ec.com.technoloqie.galactic.currency.commons.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class GalacticCurrencyLog {
	static final Logger logger = Logger.getLogger(GalacticCurrencyLog.class);
	private static final GalacticCurrencyLog INSTANCIA = new GalacticCurrencyLog();
	
	private GalacticCurrencyLog(){
		BasicConfigurator.configure();
	}
	
	public static void info(String parameter){
		logger.info(parameter);
	}
	
	public void debug(String parameter){
		logger.debug("This is debug : " + parameter);
	}
		
	public void warn(String parameter){
		logger.warn("This is warn : " + parameter);
	}
	
	public static void error(String parameter){
		logger.error(parameter);
	}
	
	public void fatal(String parameter){
		logger.fatal("This is fatal : " + parameter);
	}
	
	public static GalacticCurrencyLog getLog(){
		return INSTANCIA;
	}
	public static void error(String string, Exception e) {
		error(string + e.getMessage());
	}

}
