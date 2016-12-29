package com.finalproject;

public class LecturesPhonesQuery {

		private int PhoneNumber;
		private String FirstName, LastName;
		
		public LecturesPhonesQuery(int phoneNumber, String firstName, String lastName) {
			this.setPhoneNumber(phoneNumber);
			this.setFirstName(firstName);
			this.setLastName(lastName);
		}
		
		public int PhoneNumber() {
			return PhoneNumber;
		}
		public void setPhoneNumber(int phoneNumber) {
			PhoneNumber = phoneNumber;
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
		
		
		public String toString() {
			return FirstName +""+ LastName + " , PhoneNumber - " + PhoneNumber ;
		}

	}