package com.pd;

import java.util.List;
import java.util.Scanner;

public class Address {
	
	public Address() {		
	}
	private String street;
	private String state;
	private String city;
	private String zipCode;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void updateAddress(Scanner scanner, List<Person>direcotory) {
		System.out.println("Street: ");
		System.out.println("State: ");
		System.out.println("City: ");
		System.out.println("Zipcode: ");
	}
}
