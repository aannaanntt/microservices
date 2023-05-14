package com.address.microservice.res;

import com.address.microservice.entity.Address;

public class AddressResponse {
	
	private long addressId;
	
	private String street;
	
	private String city;
	
	

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
	
	public static AddressResponse createResponse(Address address) {
		AddressResponse ar = new AddressResponse();
		ar.setAddressId(address.getId());
		ar.setCity(address.getCity());
		ar.setStreet(address.getStreet());
		return ar;
		
		
	}
	
	
	

}
