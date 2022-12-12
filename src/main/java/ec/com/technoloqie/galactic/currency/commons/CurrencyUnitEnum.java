package ec.com.technoloqie.galactic.currency.commons;

public enum CurrencyUnitEnum {glob(1,"glob", String.valueOf(CurrencyConstants.ROMAN_I)),
	prok(5,"prok",String.valueOf(CurrencyConstants.ROMAN_V)),
	pish(10,"pish",String.valueOf(CurrencyConstants.ROMAN_X)),
	tegj(50,"tegj",String.valueOf(CurrencyConstants.ROMAN_L)),
	;
	
	private String label;
	private Integer value;
	private String romanProve;		//homologo romano
	
	private CurrencyUnitEnum(){
		
	}

	private CurrencyUnitEnum(Integer value, String romanProve){
    	this.label = romanProve;
    	this.value = value;
	}
	
	private CurrencyUnitEnum(Integer value, String label, String romanProve){
    	this.label = label;
    	this.value = value;
    	this.romanProve = romanProve;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getRomanProve() {
		return romanProve;
	}

	public void setRomanProve(String romanProve) {
		this.romanProve = romanProve;
	}


}
