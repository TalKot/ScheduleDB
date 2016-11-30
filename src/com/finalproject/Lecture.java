package com.finalproject;

public class Lecture {
	private int ID;
	private String FirstName;
	private String LastName;
	private int BirthdayDay;
	private int BirthdayMonth;
	private int BirthdayYear;
	private String AdressCity;
	private int AdressStreetNumber;
	private String AdressName;

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
	public int getBirthdayDay() {
		return BirthdayDay;
	}
	public void setBirthdayDay(int birthdayDay) {
		BirthdayDay = birthdayDay;
	}
	public int getBirthdayMonth() {
		return BirthdayMonth;
	}
	public void setBirthdayMonth(int birthdayMonth) {
		BirthdayMonth = birthdayMonth;
	}
	public int getBirthdayYear() {
		return BirthdayYear;
	}
	public void setBirthdayYear(int birthdayYear) {
		BirthdayYear = birthdayYear;
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
		return  FirstName + " " + LastName +",ID=" + ID + "," +  ", Birthday="
				+ BirthdayDay + "." + BirthdayMonth + "." + BirthdayYear + ", Adress="
				 +AdressName+" "+ AdressStreetNumber +"," + AdressCity;
	}

}
