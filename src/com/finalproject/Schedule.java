package com.finalproject;

public class Schedule {
	private int CourseNumber, HoursAmount,Year,Day,Time_Hour,Time_Minute,Lecture_ID,classNumber;
	private int BuildingNumber, floor, BirthdayDay,BirthdayMonth,BirthdayYear,AdressStreetNumber;
	private String firstName, lastName, AdressStreetName,AdressCity, Name, Semester;
	
	public int getCourseNumber() {
		return CourseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		CourseNumber = courseNumber;
	}
	public int getHoursAmount() {
		return HoursAmount;
	}
	public void setHoursAmount(int hoursAmount) {
		HoursAmount = hoursAmount;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getDay() {
		return Day;
	}
	public void setDay(int day) {
		Day = day;
	}
	public int getTime_Hour() {
		return Time_Hour;
	}
	public void setTime_Hour(int time_Hour) {
		Time_Hour = time_Hour;
	}
	public int getTime_Minute() {
		return Time_Minute;
	}
	public void setTime_Minute(int time_Minute) {
		Time_Minute = time_Minute;
	}
	public int getLecture_ID() {
		return Lecture_ID;
	}
	public void setLecture_ID(int lecture_ID) {
		Lecture_ID = lecture_ID;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public int getBuildingNumber() {
		return BuildingNumber;
	}
	public void setBuildingNumber(int buildingNumber) {
		BuildingNumber = buildingNumber;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
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
	public int getAdressStreetNumber() {
		return AdressStreetNumber;
	}
	public void setAdressStreetNumber(int adressStreetNumber) {
		AdressStreetNumber = adressStreetNumber;
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
	public String getAdressStreetName() {
		return AdressStreetName;
	}
	public void setAdressStreetName(String adressStreetName) {
		AdressStreetName = adressStreetName;
	}
	public String getAdressCity() {
		return AdressCity;
	}
	public void setAdressCity(String adressCity) {
		AdressCity = adressCity;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	
	@Override
	public String toString() {
		return "***Course information CourseNumber=" + CourseNumber +", Name=" + Name+ ", Semester=" + Semester +", HoursAmount=" + HoursAmount + ", Year=" + Year + ", Day="+ Day + ", Time=" + Time_Hour + ":" + Time_Minute + ", "
				+"***Lecture information*** Lecture_ID=" + Lecture_ID + ", Name=" + firstName+" " + lastName +", Birthday=" + BirthdayDay + "." + BirthdayMonth + "." + BirthdayYear +", Adress=" +AdressStreetName +" "+AdressStreetNumber+ ","+ AdressCity
				+"***Class information*** classNumber=" + classNumber + ", BuildingNumber=" + BuildingNumber + ", floor=" + floor;		
	}
}