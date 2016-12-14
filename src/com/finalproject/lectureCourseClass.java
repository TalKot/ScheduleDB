package com.finalproject;

public class lectureCourseClass {
	private int ID,CourseNumber,HourseAmount,Year,Day,TimeHour,TimeMinute,ClassNumber;
	private String CourseName;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCourseNumber() {
		return CourseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		CourseNumber = courseNumber;
	}
	public int getHourseAmount() {
		return HourseAmount;
	}
	public void setHourseAmount(int hourseAmount) {
		HourseAmount = hourseAmount;
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
	public int getTimeHour() {
		return TimeHour;
	}
	public void setTimeHour(int timeHour) {
		TimeHour = timeHour;
	}
	public int getTimeMinute() {
		return TimeMinute;
	}
	public void setTimeMinute(int timeMinute) {
		TimeMinute = timeMinute;
	}
	public int getClassNumber() {
		return ClassNumber;
	}
	public void setClassNumber(int classNumber) {
		ClassNumber = classNumber;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	@Override
	public String toString() {
		return "Lecture ID=" + ID + ", Teaches Course=" + CourseName+ "," + CourseNumber + ", HourseAmount=" + HourseAmount
				+ ", Year=" + Year + ", Day=" + Day + ", at time=" + TimeHour + ":" + TimeMinute+ ", ClassNumber=" + ClassNumber ;
	}
}
