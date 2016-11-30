package com.finalproject;

import org.eclipse.swt.widgets.Display;
import java.util.Properties;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.awt.Image;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;


public class ProgramGUI {
	
		protected Shell shell;
		private Group LecturerGroupView,ClassGroupView,CourseGroupView,ClassGroup,CourseGroup;
		private Button ClassGroupChooseInsert,ClassGroupChooseUpdate,ClassGroupChooseDelete,ClassGroupExecuteButton;
		private Text ClassGroupResultText,ClassGroupClassNumberText,ClassGroupBuildingNumberText,ClassGroupFloorText,CourseGroupResultText,CourseGroupCourseNumberText,CourseGroupCourseNameText,CourseGroupCourseSemesterText,CourseGroupYearText,CourseGroupHoursAmountText,CourseGroupDayText,CourseGroupTimeHourText,CourseGroupTimeMinuteText;
		private CLabel ClassGroupResultLable, ClassGroupClassNumberLable, ClassGroupBuildingNumberLable,ClassGroupFloorLable;
		private Button CourseGroupChooseDelete,CourseGroupChooseUpdate,CourseGroupChooseInsert, CourseGroupExecuteButton;
		private CLabel CourseGroupResultLable,CourseGroupCourseNumberLable,CourseGroupCourseNameLable,CourseGroupCourseSemesterLable,CourseGroupYearLable,CourseGroupDayLable,CourseGroupHoursAmountLable,CourseGroupTimeLable,label_2;
		private Group LectureGroup;
		private Button LectureGroupChooseDelete;
		private Button LectureGroupChooseUpdate;
		private Button LectureGroupChooseInsert;
		private Button LectureGroupExecuteButton;
		private Text LectureGroupResultText;
		private CLabel LectureGroupResultLable;
		private CLabel LectureGroupIDLable;
		private Text LectureGroupIDText;
		private CLabel LectureGroupFirstNameLable;
		private Text LectureGroupFirstNameText;
		private CLabel LectureGroupLastNameLable;
		private Text LectureGroupLastNameText;
		private Text LectureGroupBirthdayDayText;
		private CLabel LectureGroupBirhtdayLable;
		private Text LectureGroupBirthdayMonthText;
		private Text LectureGroupBirthdayYearText;
		private CLabel LectureGroupAdressCityLable;
		private Text LectureGroupAdressCityText;
		private CLabel LectureGroupAdressNumberLable;
		private Text LectureGroupAdressNumberText;
		private CLabel LectureGroupAdressNameLable;
		private Text LectureGroupAdressNameText;

		
		public static void main(String[] args)
		{
			ProgramGUI GUI = new ProgramGUI();
			
		}
		public ProgramGUI()
		{
			try{
			this.open();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


		public void open() {
			Display display = Display.getDefault();
			createContents();
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		}


		protected void createContents() {
			shell = new Shell(); 
			shell.setImage(null);	       
			shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			shell.setSize(877, 1003);
			shell.setText("DB Final Project");
			/***********************************For the main display**************************************/
			LecturerGroupView = new Group(shell, SWT.NONE);
			LecturerGroupView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			LecturerGroupView.setText("Lecturer");
			LecturerGroupView.setBounds(23, 36, 262, 314);
			
			ClassGroupView = new Group(shell, SWT.SHADOW_ETCHED_IN);
			ClassGroupView.setText("Class");
			ClassGroupView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			ClassGroupView.setBounds(301, 36, 262, 314);
			
			CourseGroupView = new Group(shell, SWT.NONE);
			CourseGroupView.setText("Course");
			CourseGroupView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			CourseGroupView.setBounds(569, 36, 262, 314);
			/************************************************************************************************/
			ClassGroup = new Group(shell, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
			ClassGroup.setText("Class Group");
			ClassGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			ClassGroup.setBounds(23, 370, 808, 153);
			
			ClassGroupChooseDelete = new Button(ClassGroup, SWT.RADIO);
			ClassGroupChooseDelete.setBounds(199, 94, 90, 16);
			ClassGroupChooseDelete.setText("Delete");
			
			ClassGroupChooseUpdate = new Button(ClassGroup, SWT.RADIO);
			ClassGroupChooseUpdate.setBounds(341, 94, 90, 16);
			ClassGroupChooseUpdate.setText("Update");
			
			ClassGroupChooseInsert = new Button(ClassGroup, SWT.RADIO);
			ClassGroupChooseInsert.setBounds(495, 94, 90, 16);
			ClassGroupChooseInsert.setText("Insert");
			
			ClassGroupExecuteButton = new Button(ClassGroup, SWT.NONE);
			
			/***********************************Execute Button  of Class group******************************************/
			ClassGroupExecuteButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					/*checking all information added*/
					if (ClassGroupBuildingNumberText.getText().equals("") || ClassGroupClassNumberText.getText().equals("") ||ClassGroupFloorText.getText().equals(""))
					{
						ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						ClassGroupResultText.setText("All Information Must Be Added.");
						return;
					}
					/*splitting the options*/
					if (ClassGroupChooseDelete.getSelection())//Class delete option
					{

						String query1 = "DELETE FROM class WHERE ClassNumber="+ClassGroupClassNumberText.getText() ;
						String query2 = "DELETE FROM takeplace WHERE Class_ClassNumber="+ClassGroupClassNumberText.getText() ;
						try {
							Connection2DB.Instance().Exectueuery(query1);
							Connection2DB.Instance().Exectueuery(query2);
						} 
						catch (SQLException e1) {
							ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							ClassGroupResultText.setText(e1.getMessage());
							return;
						}
						
					}
					else if (ClassGroupChooseInsert.getSelection())//Class Insert option
					{
						String query = "INSERT INTO class VALUES ("+ClassGroupClassNumberText.getText()+","+ClassGroupBuildingNumberText.getText()+","+ClassGroupFloorText.getText()+")";
						try {
							Connection2DB.Instance().Exectueuery(query);
						} 
						catch (SQLException e1) {
							ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							ClassGroupResultText.setText(e1.getMessage());
							return;
						}
					}
					else if(ClassGroupChooseUpdate.getSelection())//Class Update option
					{
						String query = "UPDATE class SET BuildingNumber="+ClassGroupBuildingNumberText.getText()+",Floor="+ClassGroupFloorText.getText()+" WHERE ClassNumber="+ClassGroupClassNumberText.getText()+";";
						System.out.println(query);
						try {
							Connection2DB.Instance().Exectueuery(query);
						} 
						catch (SQLException e1) {
							ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							ClassGroupResultText.setText(e1.getMessage());
							return;
						}

					}
					ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					ClassGroupResultText.setText("Action Complete.");
				}
			});
			/************************************************************************************************************/
			ClassGroupExecuteButton.setBounds(27, 90, 143, 25);
			ClassGroupExecuteButton.setText("Execute");
			
			ClassGroupResultText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
			ClassGroupResultText.setEditable(false);
			ClassGroupResultText.setEnabled(false);
			ClassGroupResultText.setBounds(175, 116, 623, 26);
			
			ClassGroupResultLable = new CLabel(ClassGroup, SWT.CENTER);
			ClassGroupResultLable.setBounds(27, 121, 143, 22);
			ClassGroupResultLable.setText("Query Result");
			
			ClassGroupClassNumberLable = new CLabel(ClassGroup, SWT.NONE);
			ClassGroupClassNumberLable.setAlignment(SWT.CENTER);
			ClassGroupClassNumberLable.setBounds(10, 34, 93, 21);
			ClassGroupClassNumberLable.setText("Class Number");
			
			ClassGroupClassNumberText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupClassNumberText.setBounds(109, 34, 121, 21);
			
			ClassGroupBuildingNumberLable = new CLabel(ClassGroup, SWT.NONE);
			ClassGroupBuildingNumberLable.setAlignment(SWT.CENTER);
			ClassGroupBuildingNumberLable.setText("Building Number");
			ClassGroupBuildingNumberLable.setBounds(236, 34, 97, 21);
			
			ClassGroupBuildingNumberText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupBuildingNumberText.setBounds(339, 34, 121, 21);
			
			ClassGroupFloorLable = new CLabel(ClassGroup, SWT.NONE);
			ClassGroupFloorLable.setAlignment(SWT.CENTER);
			ClassGroupFloorLable.setText("Floor");
			ClassGroupFloorLable.setBounds(488, 34, 76, 21);
			
			ClassGroupFloorText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupFloorText.setBounds(570, 34, 121, 21);
			
			CourseGroup = new Group(shell, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
			CourseGroup.setText("Course Group");
			CourseGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			CourseGroup.setBounds(23, 538, 808, 188);
			
			CourseGroupChooseDelete = new Button(CourseGroup, SWT.RADIO);
			CourseGroupChooseDelete.setText("Delete");
			CourseGroupChooseDelete.setBounds(182, 129, 90, 16);
			
			CourseGroupChooseUpdate = new Button(CourseGroup, SWT.RADIO);
			CourseGroupChooseUpdate.setText("Update");
			CourseGroupChooseUpdate.setBounds(324, 129, 90, 16);
			
			CourseGroupChooseInsert = new Button(CourseGroup, SWT.RADIO);
			CourseGroupChooseInsert.setText("Insert");
			CourseGroupChooseInsert.setBounds(478, 129, 90, 16);
			
			CourseGroupExecuteButton = new Button(CourseGroup, SWT.NONE);
			
			/***********************************Execute Button  of Class group******************************************/
			CourseGroupExecuteButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					if (CourseGroupCourseNumberText.getText().equals("")||CourseGroupCourseNameText.getText().equals("")||CourseGroupCourseSemesterText.getText().equals("")||CourseGroupHoursAmountText.getText().equals("")||CourseGroupDayText.getText().equals("")|| 
					CourseGroupYearText.getText().equals("")||CourseGroupTimeHourText.getText().equals("")||CourseGroupTimeMinuteText.getText().equals(""))
					{
							CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							CourseGroupResultText.setText("All Information Must Be Added.");
							return;
					}
					/*splitting the options*/
					if (CourseGroupChooseDelete.getSelection())//Course delete option
					{
						String query1 = "DELETE FROM Course WHERE CourseNumber="+CourseGroupCourseNumberText.getText() ;
						String query2 = "DELETE FROM takeplace WHERE Course_CourseNumber="+CourseGroupCourseNumberText.getText() ;
						String query3 = "DELETE FROM teaching WHERE Course_CourseNumber="+CourseGroupCourseNumberText.getText() ;
						try {
							Connection2DB.Instance().Exectueuery(query1);
							Connection2DB.Instance().Exectueuery(query2);
							Connection2DB.Instance().Exectueuery(query3);

						} 
						catch (SQLException e1) {
							CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							CourseGroupResultText.setText(e1.getMessage());
							return;
						}
					}
					else if (CourseGroupChooseInsert.getSelection())//Course Insert option
					{
						String query = "INSERT INTO Course VALUES ("+CourseGroupCourseNumberText.getText()+","+CourseGroupCourseNameText.getText()+","+CourseGroupCourseSemesterText.getText()+","+
								CourseGroupHoursAmountText.getText()+","+CourseGroupDayText.getText()+","+CourseGroupYearText.getText()+","+
								CourseGroupTimeHourText.getText()+","+CourseGroupTimeMinuteText.getText()+")";
						try {
							Connection2DB.Instance().Exectueuery(query);
						} 
						catch (SQLException e1) {
							CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							CourseGroupResultText.setText(e1.getMessage());
							return;
						}
					}
					else if(CourseGroupChooseUpdate.getSelection())//Course Update option
					{
						 String query = "UPDATE course SET Name='"+CourseGroupCourseNameText.getText()+"',"+"Semester='"+ CourseGroupCourseSemesterText.getText()+"',"+
						 "HourseAmount="+ CourseGroupHoursAmountText.getText()+","+
						 "Year="+CourseGroupYearText.getText() +","+
						 "Day="+ CourseGroupDayText.getText()+","+
						 "Time_Hour="+ CourseGroupTimeHourText.getText()+","+
						 "Time_Minute="+CourseGroupTimeMinuteText.getText()+
						 " WHERE CourseNumber="+CourseGroupCourseNumberText.getText()+";";
						 System.out.println(query);
						
						try {
							Connection2DB.Instance().Exectueuery(query);
						} 
						catch (SQLException e1) {
							CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							CourseGroupResultText.setText(e1.getMessage());
							return;
						}
					}
					
					CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					CourseGroupResultText.setText("Action Complete.");
				}
			});
			/************************************************************************************************************/
			CourseGroupExecuteButton.setText("Execute");
			CourseGroupExecuteButton.setBounds(10, 125, 143, 25);
			
			CourseGroupResultText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupResultText.setEnabled(false);
			CourseGroupResultText.setEditable(false);
			CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
			CourseGroupResultText.setBounds(158, 151, 623, 26);
			
			CourseGroupResultLable = new CLabel(CourseGroup, SWT.CENTER);
			CourseGroupResultLable.setText("Query Result");
			CourseGroupResultLable.setBounds(10, 156, 143, 22);
			
			CourseGroupCourseNumberLable = new CLabel(CourseGroup, SWT.NONE);
			CourseGroupCourseNumberLable.setText("Course Number");
			CourseGroupCourseNumberLable.setAlignment(SWT.CENTER);
			CourseGroupCourseNumberLable.setBounds(10, 34, 93, 21);
			
			CourseGroupCourseNumberText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupCourseNumberText.setBounds(109, 34, 121, 21);
			
			CourseGroupCourseNameLable = new CLabel(CourseGroup, SWT.NONE);
			CourseGroupCourseNameLable.setText("Course Name");
			CourseGroupCourseNameLable.setAlignment(SWT.CENTER);
			CourseGroupCourseNameLable.setBounds(236, 34, 97, 21);
			
			CourseGroupCourseNameText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupCourseNameText.setBounds(339, 34, 121, 21);
			
			CourseGroupCourseSemesterLable = new CLabel(CourseGroup, SWT.NONE);
			CourseGroupCourseSemesterLable.setText("Semester");
			CourseGroupCourseSemesterLable.setAlignment(SWT.CENTER);
			CourseGroupCourseSemesterLable.setBounds(488, 34, 76, 21);
			
			CourseGroupCourseSemesterText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupCourseSemesterText.setBounds(570, 34, 121, 21);
			
			CourseGroupYearText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupYearText.setBounds(570, 61, 121, 21);
			
			CourseGroupYearLable = new CLabel(CourseGroup, SWT.NONE);
			CourseGroupYearLable.setText("Year");
			CourseGroupYearLable.setAlignment(SWT.CENTER);
			CourseGroupYearLable.setBounds(488, 61, 76, 21);
			
			CourseGroupDayText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupDayText.setBounds(339, 61, 121, 21);
			
			CourseGroupDayLable = new CLabel(CourseGroup, SWT.NONE);
			CourseGroupDayLable.setText("Day");
			CourseGroupDayLable.setAlignment(SWT.CENTER);
			CourseGroupDayLable.setBounds(236, 61, 97, 21);
			
			CourseGroupHoursAmountText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupHoursAmountText.setBounds(109, 61, 121, 21);
			
			CourseGroupHoursAmountLable = new CLabel(CourseGroup, SWT.NONE);
			CourseGroupHoursAmountLable.setText("Hours Amount");
			CourseGroupHoursAmountLable.setAlignment(SWT.CENTER);
			CourseGroupHoursAmountLable.setBounds(10, 61, 93, 21);
			
			CourseGroupTimeLable = new CLabel(CourseGroup, SWT.NONE);
			CourseGroupTimeLable.setText("Time");
			CourseGroupTimeLable.setAlignment(SWT.CENTER);
			CourseGroupTimeLable.setBounds(10, 88, 93, 21);
			
			CourseGroupTimeHourText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupTimeHourText.setBounds(109, 88, 44, 21);
			
			CourseGroupTimeMinuteText = new Text(CourseGroup, SWT.BORDER);
			CourseGroupTimeMinuteText.setBounds(163, 88, 44, 21);
			
			label_2 = new CLabel(CourseGroup, SWT.NONE);
			label_2.setText(":");
			label_2.setAlignment(SWT.CENTER);
			label_2.setBounds(153, 84, 9, 25);
			
			LectureGroup = new Group(shell, SWT.BORDER | SWT.SHADOW_IN);
			LectureGroup.setText("Lecture Group");
			LectureGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			LectureGroup.setBounds(23, 741, 808, 188);
			
			LectureGroupChooseDelete = new Button(LectureGroup, SWT.RADIO);
			LectureGroupChooseDelete.setText("Delete");
			LectureGroupChooseDelete.setBounds(182, 129, 90, 16);
			
			LectureGroupChooseUpdate = new Button(LectureGroup, SWT.RADIO);
			LectureGroupChooseUpdate.setText("Update");
			LectureGroupChooseUpdate.setBounds(324, 129, 90, 16);
			
			LectureGroupChooseInsert = new Button(LectureGroup, SWT.RADIO);
			LectureGroupChooseInsert.setText("Insert");
			LectureGroupChooseInsert.setBounds(478, 129, 90, 16);
			
			LectureGroupExecuteButton = new Button(LectureGroup, SWT.NONE);
			
			/***********************************Execute Button  of Lecture group******************************************/
			LectureGroupExecuteButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					if (LectureGroupIDText.getText().equals("")||LectureGroupFirstNameText.getText().equals("")||LectureGroupLastNameText.getText().equals("")||LectureGroupBirthdayDayText.getText().equals("")||LectureGroupBirthdayMonthText.getText().equals("")|| LectureGroupBirthdayYearText.getText().equals("")||LectureGroupAdressCityText.getText().equals("")||LectureGroupAdressNameText.getText().equals("")||LectureGroupAdressNumberText.getText().equals(""))
					{
						LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						LectureGroupResultText.setText("All Information Must Be Added.");
						return;
					}
					if (LectureGroupChooseDelete.getSelection())//Lecture delete option
					{
						String query1 = "DELETE FROM lecture WHERE ID="+LectureGroupIDText.getText() ;
						String query2 = "DELETE FROM teaching WHERE Lecture_ID="+LectureGroupIDText.getText() ;
						String query3 = "DELETE FROM LECTUREPHONE WHERE LectureID="+LectureGroupIDText.getText() ;
						try {
							Connection2DB.Instance().Exectueuery(query1);
							Connection2DB.Instance().Exectueuery(query2);
							Connection2DB.Instance().Exectueuery(query3);
						} 
						catch (SQLException e1) {
							LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							LectureGroupResultText.setText(e1.getMessage());
							return;
						}
					}
					else if (LectureGroupChooseInsert.getSelection())//Lecture Insert option
					{
						String query = "INSERT INTO lecture VALUES ("+LectureGroupIDText.getText()+","+"'"+LectureGroupFirstNameText.getText()+"',"+"'"+LectureGroupLastNameText.getText()+"',"+LectureGroupBirthdayDayText.getText()+","+LectureGroupBirthdayMonthText.getText()+","+LectureGroupBirthdayYearText.getText()+","+"'"+LectureGroupAdressCityText.getText()+"',"+LectureGroupAdressNumberText.getText()+","+"'"+LectureGroupAdressNameText.getText()+"')";
						try {
							Connection2DB.Instance().Exectueuery(query);
						} 
						catch (SQLException e1) {
							LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							LectureGroupResultText.setText(e1.getMessage());
							return;
						}
					}
					else if(LectureGroupChooseUpdate.getSelection())//Lecture Update option
					{
						 String query = "UPDATE lecture SET "+ 
						 "Name_FirstName='"+LectureGroupFirstNameText.getText()+"',"+"Name_LastName='"+ LectureGroupLastNameText.getText()+"',"+"Birthdate_Day="+ LectureGroupBirthdayDayText.getText()+","+ "Birthdate_Month="+LectureGroupBirthdayMonthText.getText() +","+"Birthdate_Year="+ LectureGroupBirthdayYearText.getText()+","+
						 "Address_City='"+ LectureGroupAdressCityText.getText()+"',"+"Address_street_Number="+LectureGroupAdressNumberText.getText()+","+ "Address_Name='"+LectureGroupAdressNameText.getText()+"'"+
						 " WHERE ID="+LectureGroupIDText.getText()+";";					
						try {
							Connection2DB.Instance().Exectueuery(query);
						} 
						catch (SQLException e1) {
							LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							LectureGroupResultText.setText(e1.getMessage());
							return;
						}
					}
					LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					LectureGroupResultText.setText("Action Complete.");
				}
			});
			/************************************************************************************************************/

			LectureGroupExecuteButton.setText("Execute");
			LectureGroupExecuteButton.setBounds(10, 125, 143, 25);
			
			LectureGroupResultText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupResultText.setEnabled(false);
			LectureGroupResultText.setEditable(false);
			LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
			LectureGroupResultText.setBounds(158, 151, 623, 26);
			
			LectureGroupResultLable = new CLabel(LectureGroup, SWT.CENTER);
			LectureGroupResultLable.setText("Query Result");
			LectureGroupResultLable.setBounds(10, 156, 143, 22);
			
			LectureGroupIDLable = new CLabel(LectureGroup, SWT.NONE);
			LectureGroupIDLable.setText("ID");
			LectureGroupIDLable.setAlignment(SWT.CENTER);
			LectureGroupIDLable.setBounds(10, 34, 93, 21);
			
			LectureGroupIDText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupIDText.setBounds(109, 34, 121, 21);
			
			LectureGroupFirstNameLable = new CLabel(LectureGroup, SWT.NONE);
			LectureGroupFirstNameLable.setText("First Name");
			LectureGroupFirstNameLable.setAlignment(SWT.CENTER);
			LectureGroupFirstNameLable.setBounds(236, 34, 97, 21);
			
			LectureGroupFirstNameText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupFirstNameText.setBounds(339, 34, 121, 21);
			
			LectureGroupLastNameLable = new CLabel(LectureGroup, SWT.NONE);
			LectureGroupLastNameLable.setText("Last Name");
			LectureGroupLastNameLable.setAlignment(SWT.CENTER);
			LectureGroupLastNameLable.setBounds(488, 34, 76, 21);
			
			LectureGroupLastNameText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupLastNameText.setBounds(570, 34, 121, 21);
			
			LectureGroupBirhtdayLable = new CLabel(LectureGroup, SWT.NONE);
			LectureGroupBirhtdayLable.setText("Date of birth");
			LectureGroupBirhtdayLable.setAlignment(SWT.CENTER);
			LectureGroupBirhtdayLable.setBounds(10, 61, 93, 21);
			
			LectureGroupBirthdayDayText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupBirthdayDayText.setBounds(109, 61, 31, 21);
			LectureGroupBirthdayDayText.setText("DD");
			LectureGroupBirthdayMonthText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupBirthdayMonthText.setBounds(149, 61, 31, 21);
			LectureGroupBirthdayMonthText.setText("MM");
			LectureGroupBirthdayYearText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupBirthdayYearText.setBounds(188, 61, 31, 21);
			LectureGroupBirthdayYearText.setText("YY");
			
			LectureGroupAdressCityLable = new CLabel(LectureGroup, SWT.NONE);
			LectureGroupAdressCityLable.setText("Adress City");
			LectureGroupAdressCityLable.setAlignment(SWT.CENTER);
			LectureGroupAdressCityLable.setBounds(10, 88, 93, 21);
			
			LectureGroupAdressCityText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupAdressCityText.setBounds(109, 88, 121, 21);
			
			LectureGroupAdressNumberLable = new CLabel(LectureGroup, SWT.NONE);
			LectureGroupAdressNumberLable.setText("Adress Number");
			LectureGroupAdressNumberLable.setAlignment(SWT.CENTER);
			LectureGroupAdressNumberLable.setBounds(467, 88, 97, 21);
			
			LectureGroupAdressNameText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupAdressNameText.setBounds(339, 88, 121, 21);
			
			LectureGroupAdressNumberText = new Text(LectureGroup, SWT.BORDER);
			LectureGroupAdressNumberText.setBounds(570, 88, 121, 21);
			
			LectureGroupAdressNameLable = new CLabel(LectureGroup, SWT.NONE);
			LectureGroupAdressNameLable.setText("Adress Name");
			LectureGroupAdressNameLable.setAlignment(SWT.CENTER);
			LectureGroupAdressNameLable.setBounds(236, 88, 97, 21);
			
		}
}

