package com.finalproject;

public class Course 
{
	private int CourseNumber;
	private String Name;
	private String Semester;
	private int HourseAmount;
	private int Year;
	private int Day;
	private int Time_Hour;
	private int Time_Minute;
	
	public int getCourseNumber() {
		return CourseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		CourseNumber = courseNumber;
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
	@Override
	public String toString() {
		return 	Name+ ", Number=" + CourseNumber + ", Sem.=" + Semester + ", Hours="
				+ HourseAmount + ", Year=" + Year + ", Day=" + Day + ", Time=" + Time_Hour + ":"
				+ Time_Minute;
	}
	
	
}
