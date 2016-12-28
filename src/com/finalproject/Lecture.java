package com.finalproject;

import java.sql.Date;

public class Lecture {
	private int ID;
	private String FirstName;
	private String LastName;
	private Date Birthday;
	private String AdressCity;
	private int AdressStreetNumber;
	private String AdressName;

	public Lecture(int id, String FirstName,String LastName, Date birthdate,String AdressCity, int addressNumber, String AdressName )
	{
		this.setID(id);
		this.setFirstName(FirstName);
		this.setLastName(LastName);
		this.setBirthday(birthdate);
		this.setAdressCity(AdressCity);
		this.setAdressStreetNumber(addressNumber);
		this.setAdressName(AdressName);
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String getAdressCity() {
		return AdressCity;
	}
	public void setAdressCity(String adressCity) {
		AdressCity = adressCity;
	}
	public int getAdressStreetNumber() {
		return AdressStreetNumber;
	}
	public void setAdressStreetNumber(int i) {
		AdressStreetNumber = i;
	}
	public String getAdressName() {
		return AdressName;
	}
	public void setAdressName(String adressName) {
		AdressName = adressName;
	}
	@Override
	public String toString() {
		return  FirstName + " " + LastName +"," + ID + ", Birthday="
				+ Birthday+ ","
				 +AdressName+" "+ AdressStreetNumber +"," + AdressCity;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

}
