package com.jda.serviceImplementation;

import java.io.IOException;
import java.sql.SQLException;

import com.jda.Utility.Utility;
import com.jda.model.Person;

public class Jdbc {
	public static void manager() throws Exception {
		Utility util = new Utility();

		int choice;
		do {
			System.out.println("enter what you want to do with file 1. add 2. edit 3. delete 4 print all  0. close");
			choice = Integer.parseInt(util.getInputStringline());
			switch (choice) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				delete();
				break;
			case 4:
				print();
				break;

			}
		} while (choice != 0);
	}

	private static void print() throws Exception {
		Add newData = new Add();
		newData.readDataBase();

	}

	private static void delete() throws IOException, ClassNotFoundException, SQLException {
		Add newData = new Add();
		Utility util = new Utility();
		Person person = new Person();
		System.out.println("Enter the firstName");
		String firstName = util.getInputStringline();
		newData.deleteDatabase(firstName);
	}

	public static void add() throws IOException, ClassNotFoundException, SQLException {

		Add newData = new Add();
		Utility util = new Utility();
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
		newData.addDatabase(person);
	}

	public static void edit() throws IOException, ClassNotFoundException, SQLException {
		Add newData = new Add();
		Utility util = new Utility();
		Person person = new Person();
		System.out.println("Enter the firstName");
		String firstName = util.getInputStringline();
		System.out.println("Enter the attribute");
		String attribute = util.getInputStringline();
		System.out.println("Enter the value");
		String value = util.getInputStringline();
		newData.updateDatabase(attribute, value, firstName);
	}
}
