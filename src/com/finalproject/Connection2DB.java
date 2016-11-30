package com.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;


public class Connection2DB { 
	
	
	private final String driver = "com.mysql.jdbc.Driver";  	
	private final String protocol = "jdbc:mysql://localhost:3306/aabb"; 	
	private final String USER = "root"; 	
	private final String PASS = "admin"; 
	private Connection connection = null; 
	private Statement statement = null; 
	private static Connection2DB DBConnectors ;

	 public static Connection2DB Instance() throws SQLException
	{
		if (DBConnectors == null) return new Connection2DB();
		return DBConnectors;
	}
		
	 private Connection2DB() throws SQLException
	 {
		 try
			{ 
				Class.forName(driver);//loading the driver to memory 
				connection=DriverManager.getConnection(protocol,USER,PASS);
				connection.setAutoCommit(false);
				tableCreation();//method for creating the tables in DB
				enterData();//method for entering data to DB
				System.out.println("Creation complete");
			} 
			catch(Exception e)
			{
				//e.printStackTrace(); 
				connection.rollback();
			}
			finally 	
			{ 
				if(statement!=null) try{statement.close();}catch(Exception e){/*e.printStackTrace();*/} 
				if(connection!=null) try{connection.close();}catch(Exception e){/*e.printStackTrace();*/} 	
			} 
		
	 }
 
	public void tableCreation() throws SQLException
	{
		statement = connection.createStatement();
		/*creation of the tables*/
		statement.execute("create table Class(ClassNumber int,BuildingNumber int,Floor int,PRIMARY KEY (ClassNumber))"); 		
		statement.execute("create table Course(CourseNumber int,Name varchar(255), Semester CHAR,HourseAmount int,Year int,Day int,Time_Hour int,Time_Minute int,PRIMARY KEY (CourseNumber))"); 
		statement.execute("create table Lecture(ID int,Name_FirstName varchar(255),Name_LastName varchar(255),Birthdate_Day int,Birthdate_Month int,Birthdate_Year int, Address_City varchar(255),Address_street_Number int,Address_Name varchar(255),PRIMARY KEY (ID))"); 		
		statement.execute("create table Takeplace(Course_CourseNumber int, Class_ClassNumber int,PRIMARY KEY (Course_CourseNumber,Class_ClassNumber))"); 		
		statement.execute("create table Teaching(Course_CourseNumber int, Lecture_ID int,PRIMARY KEY (Course_CourseNumber,Lecture_ID))"); 
		statement.execute("create table LecturePhone(LectureID int,PhoneNumber int,PRIMARY KEY (LectureID,PhoneNumber))"); 
	}
	
	public void enterData() throws SQLException
	{
		statement = connection.createStatement();
		/*insert into class table*/
		statement.executeUpdate("INSERT INTO class VALUES (200,3,2)");
		statement.executeUpdate("INSERT INTO class VALUES (201,3,2)");
		statement.executeUpdate("INSERT INTO class VALUES (202,2,2)");
		statement.executeUpdate("INSERT INTO class VALUES (203,3,2)");
		statement.executeUpdate("INSERT INTO class VALUES (204,3,2)");
		statement.executeUpdate("INSERT INTO class VALUES (300,2,3)");
		statement.executeUpdate("INSERT INTO class VALUES (301,2,3)");
		statement.executeUpdate("INSERT INTO class VALUES (302,2,3)");
		statement.executeUpdate("INSERT INTO class VALUES (303,2,3)");
		statement.executeUpdate("INSERT INTO class VALUES (304,2,3)");
		/*insert into Course table*/
		statement.executeUpdate("INSERT INTO course VALUES(5000,'courseA','A',5,2,1,18,00)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5001,'courseB','A',2,3,1,12,00)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5002,'courseB','A',3,1,1,18,30)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5003,'courseC','B',4,1,2,10,30)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5004,'courseD','B',5,1,2,21,00)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5006,'courseE','B',6,2,3,13,45)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5007,'courseF','B',2,3,3,12,30)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5008,'courseG','S',2,4,3,10,00)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5009,'courseH','S',2,4,4,15,30)"); 		
		statement.executeUpdate("INSERT INTO course VALUES(5010,'courseI','S',3,2,5,12,00)"); 
		/*insert into Lecture table*/
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444440,'Shalom','Shloshe',23,2,1972,'Tel-Aviv',34,'Mozkin')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444441,'Amit','Lapidot',3,12,1990,'Beit-Shean',18,'Arlozerov')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444442,'Naor','Yoni',5,4,1982,'Bear-Sheva',1,'Bavli')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444443,'Shalomi','Sheldon',15,4,1978,'Tel-Aviv',23,'Lamed')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444444,'Uri','Dudi',24,3,1970,'Tel-Aviv',50,'Ramat Aviv')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444445,'Uri','Hamoiv',3,9,1975,'Tel-Aviv',5,'Ramat Aviv G')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444446,'Cris','Nedved',1,9,1980,'Ashdod',30,'New Ramat Aviv')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444447,'David','Del-Piero',26,7,1983,'Ashdod',20,'Shalom')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444448,'Aviv','Davids',6,5,1982,'Ofakim',18,'Arlozrov')"); 
		statement.executeUpdate("INSERT INTO Lecture VALUES(305444449,'Dekel','Cafu',30,6,1981,'Ofakim',80,'Ana Frank')"); 
		/*insert into TakePlace table*/
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5000,200)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5001,201)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5002,202)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5003,203)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5004,204)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5005,300)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5006,301)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5007,302)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5008,303)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5009,304)"); 
		statement.executeUpdate("INSERT INTO Takeplace VALUES(5010,200)"); 
		/*insert into Teaching table*/
		statement.executeUpdate("INSERT INTO Teaching VALUES(5000,305444440)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5001,305444441)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5002,305444442)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5003,305444443)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5004,305444444)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5005,305444445)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5006,305444446)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5007,305444447)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5008,305444448)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5009,305444449)"); 
		statement.executeUpdate("INSERT INTO Teaching VALUES(5010,305444449)"); 
		/*insert into LecturePhone table*/
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444440,305468050)"); 
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444440,0526336132)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444441,0543334557)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444441,675849387)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444442,584339485)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444443,575774839)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444443,347544326)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444444,234775829)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444445,247839562)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444445,238998743)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444446,429182736)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444447,547889234)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444448,723885958)");
		statement.executeUpdate("INSERT INTO LecturePhone VALUES(305444449,345776543)");	
		connection.commit();	
	}	
	
	public void Exectueuery(String Query) throws SQLException
	{
		try{
			connection=DriverManager.getConnection(protocol,USER,PASS);
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			statement.executeUpdate(Query);
			connection.commit();
		}
		finally 	
		{ 
			if(statement!=null) try{statement.close();}catch(Exception e){e.printStackTrace();} 
			if(connection!=null) try{connection.close();}catch(Exception e){e.printStackTrace();} 	
		} 
	}
	public Classes[] getClasses() throws SQLException
	{
		System.out.println("i'm here2");
		connection=DriverManager.getConnection(protocol,USER,PASS);
		connection.setAutoCommit(false);
	    statement = connection.createStatement();

	      String sql = "SELECT * from class";
	      ResultSet rs = statement.executeQuery(sql);
	      while(rs.next()){
	    	  Classes classtemp = new Classes();
		      int first = rs.getInt("ClassNumber");
		      //int last = rs.getString("Floor");
		      int last = rs.getInt("Floor");
	         //Retrieve by column name
	        // int id  = rs.getInt("id");
	        // int age = rs.getInt("age");


	         //Display values
		      System.out.println("*************************************");
	         System.out.print("ClassNumber: " + first);
	         System.out.print("Floor: " + last);

	      }
/*
		//List Classes  
		ResultSet rs= statement.execute("select * from class");


		System.out.println("There are " + users.size() + " users(s)");
		
		Iterator i = users.iterator();
		while(i.hasNext()) 
		{
			System.out.println(i.next());
		}
		
		session.getTransaction().commit();
		*/
		
		return null;
	}

}