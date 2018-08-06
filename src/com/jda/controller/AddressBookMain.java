package com.jda.controller;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.jda.Utility.Utility;
import com.jda.serviceImplementation.AddressBookImplementation;
import com.jda.serviceImplementation.AddressBookManagerImplementation;

public class AddressBookMain {
public static void main(String[] args) throws NumberFormatException, IOException, ParseException{
	Utility util=new Utility();
	AddressBookManagerImplementation addressBookManagerImpementation=new AddressBookManagerImplementation();
	
	
	int choice;
	do{
		AddressBookImplementation addressBookImplementation= new AddressBookImplementation();
		System.out.println("enter the choice 1. create new address book 2.open existing 0. close program ");
		choice=Integer.parseInt(util.getInputStringline());
		switch(choice){
		case 1:addressBookManagerImpementation.createNewAddressBook();break;
		case 2:addressBookManagerImpementation.openExistingAddressBook();break;
		}
	}while (choice!=0);
	
	
}
}
