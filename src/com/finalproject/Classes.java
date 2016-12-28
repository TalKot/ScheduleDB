package com.finalproject;

public class Classes {
	private int classNumber;
	private int BuildingNumber;
	private int Floor;
	
	public Classes(int classNumber, int buildingNumber, int floor) {
		this.setClassNumber(classNumber);
		this.setBuildingNumber(buildingNumber);
		this.setFloor(floor);
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
		return Floor;
	}
	public void setFloor(int floor) {
		Floor = floor;
	}
	@Override
	public String toString() {
		return "Class=" + classNumber + ", Building=" + BuildingNumber + ", Floor=" + Floor;
	}
	

}
