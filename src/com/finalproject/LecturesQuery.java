package com.finalproject;

import java.sql.Date;

public class LecturesQuery extends Lecture
{

	public LecturesQuery(int id, String FirstName, String LastName, Date birthdate, String AdressCity,
			int addressNumber, String AdressName) {
		super(id, FirstName, LastName, birthdate, AdressCity, addressNumber, AdressName);
	}
	
}
