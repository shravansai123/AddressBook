/**
 * 
 */
package com.jda.service;

import java.io.IOException;
import java.util.ArrayList;

import com.jda.model.Person;

/**
 * @author Shravan
 *
 */
public interface Functions {
public ArrayList<Person> add(ArrayList<Person> people) throws IOException;
public ArrayList<Person> delete(ArrayList<Person> people) throws IOException;
public ArrayList<Person> edit(ArrayList<Person> people) throws IOException;
public ArrayList<Person> sortByLastName(ArrayList<Person> people);
public ArrayList<Person> sortByZip(ArrayList<Person> people);
public void printAll(ArrayList<Person> people);
}
