package com.student.service.res;



public class AddressResponse {
	
	private long addressId;
	
	private String street;
	
	private String city;
	
	
	
	

	public AddressResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressResponse(long addressId, String street, String city) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	
	

}
