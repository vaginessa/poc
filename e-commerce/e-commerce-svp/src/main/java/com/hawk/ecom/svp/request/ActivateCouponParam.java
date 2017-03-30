package com.hawk.ecom.svp.request;

public class ActivateCouponParam {
	
	public Integer getPhoneModelId() {
		return phoneModelId;
	}

	public void setPhoneModelId(Integer phoneModelId) {
		this.phoneModelId = phoneModelId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	

	
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 代金券的使用者的手机号
	 */
	private String ticket;
	
	/**
	 * 代金券编号
	 */
	private String couponCode;
	
	/**
	 * 投保者手机号
	 */
	private String mobileNumber;
	
	/**
	 * 投保者证件类型
	 */
	private Integer idType;
	
	/**
	 * 投保者证件号码
	 */
	private String idNumber;
	
	
	/**
	 * 投保者姓名
	 */
	private String name;
	
	/**
	 * 投保者性别	
	 */
	private String sex;
	
	/**
	 * 投保手机串号
	 */
	private String imei;
	
	/**
	 * 投保者身份证号
	 */
	private String birthday;
	
	/**
	 * 手机型号ID
	 */
	private Integer phoneModelId;
	
	/**
	 * 产品ID
	 */
	private Integer productId;

}
