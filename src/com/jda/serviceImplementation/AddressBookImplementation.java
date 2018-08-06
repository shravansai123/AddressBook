/**
 * 
 */
package com.jda.serviceImplementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.jda.Utility.Utility;
import com.jda.model.AddressBook;
import com.jda.model.Person;
import com.jda.service.Functions;

/**
 * @author bridgelabz
 *
 */
public class AddressBookImplementation implements Functions {

	Utility util = new Utility();

	@Override
	public ArrayList<Person> add(ArrayList<Person> people) throws IOException {
		Person person = new Person();
		System.out.println("Enter the firstName");
		String firstName = util.getInputStringline();
		System.out.println("Enter the lastName");
		String lastName = util.getInputStringline();
		System.out.println("Enter the phone");
		String phone = util.getInputStringline();
		System.out.println("Enter the city");
		String city = util.getInputStringline();
		System.out.println("Enter the zip");
		String zip = util.getInputStringline();
		System.out.println("Enter the address");
		String address = util.getInputStringline();
		System.out.println("Enter the state");
		String state = util.getInputStringline();
		person.setAddress(address);
		person.setCity(city);
		person.setPhone(phone);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setState(state);
		person.setZip(zip);
		people.add(person);
		return people;
	}

	@Override
	public ArrayList<Person> delete(ArrayList<Person> people) throws IOException {
		Utility util = new Utility();
		System.out.println("Enter the firstName");
		String firstName = util.getInputStringline();
		for (Person p : people) {
			if (p.getFirstName().equals(firstName)) {
				people.remove(p);
				break;
			}
		}
		return people;
	}

	@Override
	public ArrayList<Person> edit(ArrayList<Person> people) throws IOException {
		Person person = new Person();
		int choice;
		Utility util = new Utility();
		System.out.println("Enter the firstName");
		String firstName = util.getInputStringline();
		for (Person p : people) {
			if (p.getFirstName().equals(firstName)) {
				do {
					System.out.println("1. edit phone 2. edit city 3. edit state 4. edit address 5 edit zipcode 0. exit ");
					choice = Integer.parseInt(util.getInputStringline());
					switch (choice) {
					case 1:
						System.out.println("Enter the phone");
						String phone = util.getInputStringline();
						p.setPhone(phone);break;
					case 2:
						System.out.println("Enter the city");
						String city = util.getInputStringline();
						p.setCity(city);break;
					case 5:
						System.out.println("Enter the zip");
						String zip = util.getInputStringline();
						p.setZip(zip);break;
					case 4:
						System.out.println("Enter the address");
						String address = util.getInputStringline();
						p.setAddress(address);break;
					case 3:
						System.out.println("Enter the state");
						String state = util.getInputStringline();
						p.setState(state);break;
					}
				} while (choice != 0);
			}
		}
		return people;
	}

	@Override
	public ArrayList<Person> sortByLastName(ArrayList<Person> people) {
		Collections.sort(people, new Sortbyname());
		return people;
	}

	@Override
	public ArrayList<Person> sortByZip(ArrayList<Person> people) {
		Collections.sort(people, new Sortbyzip());
		return people;
	}

	public class Sortbyname implements Comparator<Person> {
		public int compare(Person a, Person b) {
			return a.getLastName().compareTo(b.getLastName());
		}
	}

	public class Sortbyzip implements Comparator<Person> {
		public int compare(Person a, Person b) {
			return a.getZip().compareTo(b.getZip());
		}
	}

	@Override
	public void printAll(ArrayList<Person> people) {
		for (Person p : people) {
			System.out.println(p.toString());
		}
	}
}
