package ec.com.technoloqie.galactic.currency.commons.exception;

public class GalacticCurrencyException extends RuntimeException{

	public GalacticCurrencyException() {
        super();
    }
    
	public GalacticCurrencyException(String msg, Throwable nested) {
        super(msg, nested);
    }
    
	public GalacticCurrencyException(String message) {
        super(message);
    }
    
	public GalacticCurrencyException(Throwable nested) {
        super(nested);
	}
	
	private static final long serialVersionUID = 1L;
}
