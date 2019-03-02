package com.rhiodamuthie.spring.springcoreadvanced.autowiring.annotations;

public class Address {
	
	private String street;
	private String number;
	
	
	public Address() {
		super();
	}
	public Address(String street, String number) {
		super();
		this.street = street;
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
