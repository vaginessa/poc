package com.hawk.framework.dic.design.data;

public enum EnumDataType {
	
	Integer("integer"),
	Long("long"),
	Numeric("numeric"),
	String("string"),
	Date("date")
	;
	
	private String value;
	
	public String getValue() {
		return value;
	}
	
	private EnumDataType(String value){
		this.value = value;
	}
	
	@Override
	public java.lang.String toString() {

		return value;
	}
	
	
	public static EnumDataType parse(String type){
		EnumDataType[] types =  EnumDataType.values();
		if (type.equalsIgnoreCase("bigdecimal"))
			type = "numeric";
		for (EnumDataType t : types){
			if (t.getValue().equalsIgnoreCase(type))
				return t;
		}
		throw new RuntimeException("Unsupported data type");
	}

}
