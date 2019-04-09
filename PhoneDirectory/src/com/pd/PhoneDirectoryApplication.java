package com.pd;


	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Scanner;

	public class PhoneDirectoryApplication {
		
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			List<Person> directory = new ArrayList<>();
			System.out.println("Welcome!");
			displayMenu(scanner, directory);
		}

	public static void displayMenu(Scanner scanner, List<Person> directory) {
			int choice = 0;
			do {
				System.out.println("\nWhat would you like to do?"
						+ "\n[1] Add New"
						+ "\n[2] Delete"
						+ "\n[3] Update"
						+ "\n[4] Search"
						+ "\n[5] Display All"
						+ "\n[6] Exit\n");
				System.out.print("Your Selection: ");
				try {
					choice = scanner.nextInt();
				}
				catch (Exception e) {
					String invalidChoice = scanner.next();
					System.out.printf("Error: \"%s\" is not a valid entry.\n", invalidChoice);
				}
				// calls other methods based on chosen action
				switch(choice) {
				case 1: addPerson(scanner, directory);
						displayMenu(scanner, directory);
						break;
				case 2: deletePerson(scanner, directory);
						displayMenu(scanner, directory);
						break;
				case 3: update(scanner, directory);
						displayMenu(scanner, directory);
						break;
				case 4: search(scanner, directory);
						displayMenu(scanner, directory);
						break;
				case 5: Person.displayAll(directory);
						displayMenu(scanner, directory);
						break;
				case 6: System.out.println("The program has been closed.");
						System.exit(0);
				default: System.out.println("Please choose 1, 2, 3, 4, 5, or 6.\n");
						break;
				}
			} while (choice < 1 || choice > 5);
		}
	
	private static void addPerson(Scanner scanner, List<Person> directory) {
		Person person = new Person();
		System.out.print("First Name: ");
		person.setFirstName(scanner.next());
			
		System.out.print("Last Name: ");
		person.setLastName(scanner.next());
			
		System.out.print("Telephone: ");
		person.setTelephone(scanner.next());
			
		Address address = new Address();
			
		System.out.print("Street: ");
		address.setStreet(scanner.next());
		
		System.out.print("City: ");
		address.setCity(scanner.next());
		
		System.out.print("State: ");
		address.setState(scanner.next());
		
		System.out.print("Zipcode: ");
		address.setZipCode(scanner.next());
		
		person.setAddress(address);
		directory.add(person);
		Collections.sort(directory);
		Person.displayAll(directory);
		}
		
	@SuppressWarnings("unused")
	private static void deletePerson(Scanner scanner, List<Person> directory) {
		Person.displayAll(directory);
		if (directory.isEmpty())
			return;
		System.out.println("Enter the first name of the contact you would like to delete: ");
		String deleteThis;
		
			do {
		System.out.print("Your Selection: ");
		deleteThis = scanner.next();
			} while(deleteThis.equals(null));
			List<Person> toRemove = new ArrayList<>();
			for (Person person : directory) {
				if(person.getFirstName().equalsIgnoreCase(deleteThis)) {
					toRemove.add(person);
				}
			}

		directory.removeAll(toRemove);
		Person.displayAll(directory);
		}
		
	private static void update(Scanner scanner, List<Person> directory) {
			if (directory.isEmpty()) {
				System.out.println("You have to have contacts before you can update them.");
				return;
			}
			System.out.println("Enter the telephone number to update the contact: ");
			System.out.print("Your Selection: ");
			
			String updateThis = scanner.next();
			boolean matches = false;
			
			for (Person person : directory) {
				if(updateThis.equalsIgnoreCase(person.getTelephone())) {
					matches = true;
					int choice = 0;
					
			System.out.println("What would you like to update?"
							+ "1. First Name"
							+ "2. Last Name"
							+ "3. Address"
							+ "4. Telephone");
			
			System.out.print("Your Selection: ");
					choice = scanner.nextInt();
					switch(choice) {
						case 1: prompt(); person.setFirstName(scanner.next());
						break;
						case 2: prompt(); person.setLastName(scanner.next());
						break;
						case 3: person.getAddress().updateAddress(scanner, directory);
						break;
						case 4: prompt();person.setTelephone(scanner.next());
						break;
						default: System.out.println("Invalid choice.");
						break;
					}					
				}
			}
			if (matches == false)
				System.out.println("No matches found!");
		}
		
	private static void prompt() {
			System.out.print("Enter new: ");
		}
		
	private static void search(Scanner scanner, List<Person> directory) {
			if (directory.isEmpty()) {
				System.out.println("You have to have contacts before you can search for them.");
				return;
			}
			System.out.println("Whose contact information would you like to find?"
					+ "(Enter the first name.)");

			System.out.print("Your Selection: ");
			String searchThis = scanner.next();
			System.out.println();
			for (Person person : directory) {
				if (person.getFirstName().equalsIgnoreCase(searchThis)) {
					System.out.println(person.toString());
				}
			}
		}
	
	} 