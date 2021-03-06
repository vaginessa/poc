package com.hawk.framework.codegen.database.meta;

/**
 * 映射单个字段
 * @author pzhang1
 *
 */
public class Field {
	
	public String getColumnCode() {
		return columnCode;
	}
	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}
	public int getIsPk() {
		return isPk;
	}
	public void setIsPk(int isPk) {
		this.isPk = isPk;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	
	public int getNullable() {
		return nullable;
	}
	public void setNullable(int nullable) {
		this.nullable = nullable;
	}
	public int getCharMaxLength() {
		return charMaxLength;
	}
	public void setCharMaxLength(int charMaxLength) {
		this.charMaxLength = charMaxLength;
	}
	public int getNumericPrecision() {
		return numericPrecision;
	}
	public void setNumericPrecision(int numericPrecision) {
		this.numericPrecision = numericPrecision;
	}
	public int getNumericScale() {
		return numericScale;
	}
	public void setNumericScale(int numericScale) {
		this.numericScale = numericScale;
	}
	public int getDatetimePrecision() {
		return datetimePrecision;
	}
	public void setDatetimePrecision(int datetimePrecision) {
		this.datetimePrecision = datetimePrecision;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getFieldJdbcType() {
		return fieldJdbcType;
	}
	public void setFieldJdbcType(String fieldJdbcType) {
		this.fieldJdbcType = fieldJdbcType;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
	public String getFieldDesc() {
		return fieldDesc;
	}
	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}
	
	
	/**
	 * java
	 */
	private String fieldName;	
	private String fieldType;
	private String fieldDesc;
	private String fieldJdbcType;
	
	/**
	 * db
	 */
	private String columnCode;
	private String dbType;
	private int isPk;
	private int nullable = 1;
	private int charMaxLength;
	private int numericPrecision;
	private int numericScale;
	private int datetimePrecision;
	private String columnType ;

}
