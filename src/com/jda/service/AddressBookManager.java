package com.jda.service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import com.jda.model.Person;

public interface AddressBookManager {
public void createNewAddressBook() throws IOException;
public void openExistingAddressBook() throws IOException, ParseException;
public void saveAddressBook(ArrayList<Person> people, String addressBookName) throws IOException;
public void saveAsAddressBook(ArrayList<Person> people) throws IOException;

}
