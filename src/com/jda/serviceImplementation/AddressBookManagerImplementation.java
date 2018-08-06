package com.jda.serviceImplementation;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jda.Utility.Utility;
import com.jda.model.AddressBook;
import com.jda.model.Person;
import com.jda.service.AddressBookManager;

public class AddressBookManagerImplementation implements AddressBookManager {

	@Override
	public void createNewAddressBook() throws IOException {
		Utility util=new Utility();
		System.out.println("Enter new Address Book Name");
		String addressBookName=util.getInputStringline();
		AddressBook first=new AddressBook();
		
		AddressBookImplementation addressBookImplementation= new AddressBookImplementation();
		ArrayList<Person> people = new ArrayList<Person> ();
		people=addressBookImplementation.add(people);
		saveAddressBook(people,addressBookName) ;
	}

	@Override
	public void openExistingAddressBook() throws IOException, ParseException {
		Utility util=new Utility();
		System.out.println("Enter Address Book Name");
		String addressBookName=util.getInputStringline();
		ArrayList<Person> people=new ArrayList<Person>();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(addressBookName+".json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray addressBook = (JSONArray) jsonObject.get("AddressBook");
		Person person;
		for(Object pers:addressBook){
			person=new Person();
			person.setFirstName((String) ((JSONObject) pers).get("First Name"));
			person.setAddress((String) ((JSONObject) pers).get("Address"));
			person.setCity((String) ((JSONObject) pers).get("City"));
			person.setLastName((String) ((JSONObject) pers).get("Last Name"));
			person.setPhone((String) ((JSONObject) pers).get("Phone Number"));
			person.setState((String) ((JSONObject) pers).get("State"));
			person.setZip((String) ((JSONObject) pers).get("Zip"));
			people.add(person);
		}
		int choice;
		do{
			AddressBookImplementation addressBookImplementation= new AddressBookImplementation();
		System.out.println("enter what you want to do with file 1. add 2. edit 3. delete 4.sortByLastName 5. sortByZip 6. print all 7. save 8.save as 0. close");
		choice=Integer.parseInt(util.getInputStringline());
		switch(choice){
		case 1: people=addressBookImplementation.add(people);break;
		case 2:people=addressBookImplementation.edit(people);break;
		case 3:people=addressBookImplementation.delete(people);break;
		case 4: people=addressBookImplementation.sortByLastName(people);break;
		case 5 : people=addressBookImplementation.sortByZip(people);break;
		case 6: addressBookImplementation.printAll(people);break;
		case 7: saveAddressBook(people,addressBookName) ;break;
		case 8: saveAsAddressBook(people);break;
		}}while(choice!=0);
	
	}

	@Override
	public void saveAddressBook(ArrayList<Person> people,String addressBookName) throws IOException {
		JSONObject obj2 = new JSONObject();
		JSONArray jarray = new JSONArray();
		for (Person person1 : people)

		jarray.add(person1);
		obj2.put("AddressBook", jarray);
		FileWriter file = new FileWriter(addressBookName+".json");
		obj2.writeJSONString(file);
		file.flush();

	}

	@Override
	public void saveAsAddressBook(ArrayList<Person> people) throws IOException {
		Utility util=new Utility();
		System.out.println("Enter new Address Book Name");
		String addressBookName=util.getInputStringline();
		saveAddressBook(people,addressBookName);
	}



}
