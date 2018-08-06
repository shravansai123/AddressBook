/**
 * 
 */
package com.jda.model;

/**
 * @author shravan
 *
 */
public class Person {
	public String firstName;
	public String lastName;
	public String phone;
	public String city;
	public String zip;
	public String address;
	public String state;
public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "\n {\n" +"\"First Name\" : \"" + firstName + "\"\n" +"\"Last Name\"  : \"" + lastName + "\"\n" +"\"Address\"  :\"" + address +"\"\n" +"\"State\"   :\"" + state +"\"\n" +"\"City\"   :\"" + city +"\"\n" +"\"Zip\"   :\"" + zip + "\"\n" +"\"Phone Number\"  : \""
				+ phone + "\"\n}\n";
	}

}
