package com.pd;

import java.util.List;

public class Person implements Comparable<Person> {
		
		private String firstName;
		private String lastName;
		private String telephone;
		private Address address;
		
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		
		@Override
		public String toString() {
			return firstName + " " + lastName + ", " + telephone + ", " + address;
		}
		public static void displayAll(List<Person> directory) {
		System.out.println();
			if(directory.isEmpty()) {
				System.out.println("You have no contacts in your directory");
				return;
			}
			int i = 1;
			for(Person person : directory) {
				System.out.println(i + " " + person.firstName + " " + person.lastName + ", "+ person.telephone + ", "+ person.address);
				i++;
			}
		}
		
		@Override
		public int compareTo(Person o) {
			return this.firstName.compareTo(o.firstName);
		}
}