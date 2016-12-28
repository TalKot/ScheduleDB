package com.finalproject;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import java.sql.PreparedStatement;



public class ProgramGUI {
	
		protected Shell shell;
		private Group LectureGroupView,ClassGroupView,CourseGroupView,ClassGroup,CourseGroup,LectureGroup;
		private Button ShowFullSchedule,ClassGroupChooseInsert,ClassGroupChooseUpdate,ClassGroupChooseDelete,ClassGroupExecuteButton,
		FindLectures,PairClassCourse,PairCourseLecture,CourseGroupChooseDelete,CourseGroupChooseUpdate,
		CourseGroupChooseInsert,CourseGroupExecuteButton,LectureGroupChooseDelete,LectureGroupExecuteButton,LectureGroupChooseUpdate,LectureGroupChooseInsert;
		private Text ClassGroupResultText,ClassGroupClassNumberText,ClassGroupBuildingNumberText,
		ClassGroupFloorText,CourseGroupResultText,CourseGroupCourseNumberText,CourseGroupCourseNameText,CourseGroupCourseSemesterText,
		CourseGroupYearText,CourseGroupHoursAmountText,CourseGroupDayText,LectureGroupResultText,LectureGroupIDText,
		LectureGroupFirstNameText,LectureGroupBirthdayDayText,LectureGroupBirthdayMonthText,LectureGroupBirthdayYearText,
		CourseGroupTimeHourText,CourseGroupTimeMinuteText,LectureGroupLastNameText,LectureGroupAdressCityText,LectureGroupAdressNumberText,LectureGroupAdressNameText;
		private CLabel ClassGroupResultLable, ClassGroupClassNumberLable, ClassGroupBuildingNumberLable,ClassGroupFloorLable,LectureGroupBirhtdayLable,
		CourseGroupResultLable,CourseGroupCourseNumberLable,CourseGroupCourseNameLable,CourseGroupCourseSemesterLable,CourseGroupYearLable,CourseGroupDayLable,CourseGroupHoursAmountLable,CourseGroupTimeLable,label_2,
		LectureGroupResultLable,LectureGroupIDLable,LectureGroupFirstNameLable,LectureGroupLastNameLable,LectureGroupAdressCityLable,LectureGroupAdressNumberLable,LectureGroupAdressNameLable;
		private List listLecture,listClass,listCourse;
		private ArrayList<Classes> cls;
		private ArrayList<Lecture> lec;
		private ArrayList<Course> crs;
		private Button ClassInformaiton;
		private Button LectureClassCourseList;
		private static Text PairResultText;
		
		public static void main(String[] args) throws SQLException
		{
			try{
				new ProgramGUI().open();
			}
			catch (Exception e) {
					PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
					PairResultText.setText(e.getMessage());
				}
		}


		public void open() {
			Display display = Display.getDefault();
			creation();
			createContents();
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		}

		public void creation()
		{
			shell = new Shell(); 
			shell.setImage(null);	       
			shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			shell.setSize(1097, 1015);
			shell.setLocation(200, 0);
			shell.setText("DB Final Project");
			LectureGroupView = new Group(shell, SWT.NONE);
			LectureGroupView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			LectureGroupView.setText("Lecturer");
			LectureGroupView.setBounds(23, 36, 439, 314);
			listLecture = new List(LectureGroupView, SWT.BORDER);
			listLecture.setBounds(10, 27, 419, 277);
			ClassGroupView = new Group(shell, SWT.SHADOW_ETCHED_IN);
			ClassGroupView.setText("Class");
			ClassGroupView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			ClassGroupView.setBounds(462, 36, 201, 314);
			listClass = new List(ClassGroupView, SWT.BORDER);
			listClass.setBounds(10, 27, 188, 277);		
			CourseGroupView = new Group(shell, SWT.NONE);
			CourseGroupView.setText("Course");
			CourseGroupView.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			CourseGroupView.setBounds(669, 36, 402, 314);
			listCourse = new List(CourseGroupView, SWT.BORDER);
			listCourse.setBounds(10, 27, 389, 277);
			ClassGroup = new Group(shell, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
			ClassGroup.setText("Class Group");
			ClassGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			ClassGroup.setBounds(23, 400, 1048, 123);		
			ClassGroupChooseDelete = new Button(ClassGroup, SWT.RADIO);
			ClassGroupChooseDelete.setBounds(199, 56, 90, 16);
			ClassGroupChooseDelete.setText("Delete");			
			ClassGroupChooseUpdate = new Button(ClassGroup, SWT.RADIO);
			ClassGroupChooseUpdate.setBounds(341, 56, 90, 16);
			ClassGroupChooseUpdate.setText("Update");			
			ClassGroupChooseInsert = new Button(ClassGroup, SWT.RADIO);
			ClassGroupChooseInsert.setBounds(495, 56, 90, 16);
			ClassGroupChooseInsert.setText("Insert");			
			ClassGroupExecuteButton = new Button(ClassGroup, SWT.NONE);
			ClassGroupExecuteButton.setBounds(27, 52, 143, 25);
			ClassGroupExecuteButton.setText("Execute");			
			ClassGroupResultText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
			ClassGroupResultText.setEditable(false);
			ClassGroupResultText.setEnabled(false);
			ClassGroupResultText.setBounds(175, 78, 623, 26);			
			ClassGroupResultLable = new CLabel(ClassGroup, SWT.CENTER);
			ClassGroupResultLable.setBounds(27, 83, 143, 22);
			ClassGroupResultLable.setText("Query Result");			
			ClassGroupClassNumberLable = new CLabel(ClassGroup, SWT.NONE);
			ClassGroupClassNumberLable.setAlignment(SWT.CENTER);
			ClassGroupClassNumberLable.setBounds(10, 25, 93, 21);
			ClassGroupClassNumberLable.setText("Class Number");			
			ClassGroupClassNumberText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupClassNumberText.setBounds(110, 25, 121, 21);			
			ClassGroupBuildingNumberLable = new CLabel(ClassGroup, SWT.NONE);
			ClassGroupBuildingNumberLable.setAlignment(SWT.CENTER);
			ClassGroupBuildingNumberLable.setText("Building Number");
			ClassGroupBuildingNumberLable.setBounds(237, 25, 97, 21);		
			ClassGroupBuildingNumberText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupBuildingNumberText.setBounds(344, 25, 121, 21);			
			ClassGroupFloorLable = new CLabel(ClassGroup, SWT.NONE);
			ClassGroupFloorLable.setAlignment(SWT.CENTER);
			ClassGroupFloorLable.setText("Floor");
			ClassGroupFloorLable.setBounds(489, 25, 76, 21);
			ClassGroupFloorText = new Text(ClassGroup, SWT.BORDER);
			ClassGroupFloorText.setBounds(573, 25, 121, 21);
			CourseGroup = new Group(shell, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
			CourseGroup.setText("Course Group");
			CourseGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
			CourseGroup.setBounds(23, 538, 1048, 188);
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
			LectureGroup.setBounds(23, 741, 1048, 188);
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
			LectureGroupBirthdayYearText.setBounds(188, 61, 54, 21);
			LectureGroupBirthdayYearText.setText("YYYY");			
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
			PairClassCourse = new Button(shell, SWT.NONE);
			PairCourseLecture = new Button(shell, SWT.NONE);
			PairCourseLecture.setText("Pair Course Lecture");
			PairClassCourse.setText("Pair Class Course");
			PairClassCourse.setBounds(220, 356, 158, 25);			
			ShowFullSchedule = new Button(shell, SWT.NONE);
			FindLectures = new Button(shell, SWT.NONE);
			FindLectures.setText("Find Lectures");
			FindLectures.setBounds(342, 942, 182, 25);
			PairCourseLecture.setBounds(44, 356, 158, 25);
			ShowFullSchedule.setBounds(75, 942, 182, 25);
			ShowFullSchedule.setText("Show Full Schedule");	
			ClassInformaiton = new Button(shell, SWT.NONE);
			ClassInformaiton.setBounds(617, 942, 182, 25);
			ClassInformaiton.setText("Class Informaiton");		
			LectureClassCourseList = new Button(shell, SWT.NONE);
			LectureClassCourseList.setText("Lecture Class&Course List");
			LectureClassCourseList.setBounds(875, 942, 182, 25);
			PairResultText = new Text(shell, SWT.BORDER);
			PairResultText.setEnabled(false);
			PairResultText.setEditable(false);
			PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
			PairResultText.setBounds(395, 355, 676, 26);
		}

		protected void createContents() 
		{
			try //first enter of the list to the GUI first lists
			{
				cls = Connection2DB.Instance().getClasses("");
				for (Classes classes : cls) 
				{
					listClass.add(classes.toString());
				}
				lec = Connection2DB.Instance().getLecture("");
				for (Lecture lecture : lec) 
				{
					listLecture.add(lecture.toString());
				}
				crs= Connection2DB.Instance().getCourse("");
				for (Course course : crs) 
				{
					listCourse.add(course.toString());
				}
			} 
			catch (SQLException e) 
			{
				PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
				PairResultText.setText(e.getMessage());
			}
/***********************************Execute Button of Class group******************************************/
			ClassGroupExecuteButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					/*checking all information added*/
					if (ClassGroupClassNumberText.getText().equals("") || ClassGroupBuildingNumberText.equals("") || ClassGroupFloorText.equals(""))
					{
						if (ClassGroupClassNumberText.getText().equals(""))ClassGroupResultText.setText("Class Number text filed must be added - Primary key!");
						else ClassGroupResultText.setText("other fileds must be set as well.");
						ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						return;
					}
					try
					{
						if (ClassGroupChooseDelete.getSelection())//Class delete option
						{
							String query1 = "DELETE FROM class WHERE ClassNumber="+ClassGroupClassNumberText.getText() ;
							String query2 = "DELETE FROM takeplace WHERE Class_ClassNumber="+ClassGroupClassNumberText.getText() ;
							Connection2DB.Instance().Exectuequery(query1);
							Connection2DB.Instance().Exectuequery(query2);	
						}
						else if (ClassGroupChooseInsert.getSelection())//Class Insert option
						{
							PreparedStatement pStmt = Connection2DB.Instance().getConnection().prepareStatement("INSERT INTO class(ClassNumber,BuildingNumber,Floor) VALUES (?,?,?);");				
							pStmt.setInt(1,Integer.parseInt(ClassGroupClassNumberText.getText()));
							pStmt.setInt(2,Integer.parseInt(ClassGroupBuildingNumberText.getText()));
							pStmt.setInt(3,Integer.parseInt(ClassGroupFloorText.getText()));
							pStmt.executeUpdate();
							pStmt.close();
						}
						else if(ClassGroupChooseUpdate.getSelection())//Class Update option
						{
							PreparedStatement pStmt = Connection2DB.Instance().getConnection().prepareStatement("UPDATE class SET BuildingNumber=?,Floor=? WHERE ClassNumber = ?;");
							pStmt.setInt(1,Integer.parseInt(ClassGroupBuildingNumberText.getText()));	
							pStmt.setInt(2,Integer.parseInt(ClassGroupFloorText.getText()));
							pStmt.setInt(3,Integer.parseInt(ClassGroupClassNumberText.getText()));
							pStmt.executeUpdate();
							pStmt.close();
						}
						else
						{
							ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							ClassGroupResultText.setText("Please choose an action");
							return;
						}
						listClass.removeAll();
						cls = Connection2DB.Instance().getClasses("");
						for (Classes classes : cls) 
						{
							listClass.add(classes.toString());
						}
						ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
						ClassGroupResultText.setText("Action Complete.");
					}
					catch(NumberFormatException e1)
					{
						ClassGroupResultText.setText(e1.getMessage());
						ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						return;
					}
					catch (SQLException e1) 
					{
						ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						ClassGroupResultText.setText(e1.getMessage());
						return;
					}
					catch (Exception e1) {
						ClassGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						ClassGroupResultText.setText(e1.getMessage());
						return;
					}
				}
			});
			
/***********************************Execute Button of Course group******************************************/
			CourseGroupExecuteButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					if (CourseGroupCourseNumberText.getText().equals("")|| CourseGroupCourseNameText.getText().equals("")|| CourseGroupCourseSemesterText.getText().equals("")||CourseGroupHoursAmountText.getText().equals("") ||CourseGroupDayText.getText().equals("") || CourseGroupYearText.getText().equals("")|| CourseGroupTimeHourText.getText().equals("")||CourseGroupTimeMinuteText.getText().equals(""))
					{
							if (CourseGroupCourseNumberText.getText().equals(""))CourseGroupResultText.setText("Course Number text filed must be added - Primary key!");
							else CourseGroupResultText.setText("All course text filed must be added!");
							CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							return;
					}
					try
					{
						if (CourseGroupChooseDelete.getSelection())//Course delete option
						{
							String query1 = "DELETE FROM Course WHERE CourseNumber="+CourseGroupCourseNumberText.getText()+";" ;
							String query3 = "DELETE FROM teaching WHERE Course_CourseNumber="+CourseGroupCourseNumberText.getText() ;
							//takeplace will delete tupple by using trigger
							Connection2DB.Instance().Exectuequery(query1);
							Connection2DB.Instance().Exectuequery(query3);
						}	
						else if (CourseGroupChooseInsert.getSelection())//Course Insert option
						{
							PreparedStatement pStmt = Connection2DB.Instance().getConnection().prepareStatement("INSERT INTO Course(CourseNumber,Name, Semester ,HourseAmount ,Year ,Day ,Time_Hour,Time_Minute) VALUES (?,?,?,?,?,?,?,?);");				
							pStmt.setInt(1,Integer.parseInt(CourseGroupCourseNumberText.getText()));
							pStmt.setString(2,CourseGroupCourseNameText.getText());
							pStmt.setInt(3,Integer.parseInt(CourseGroupCourseSemesterText.getText()));
							pStmt.setInt(4,Integer.parseInt(CourseGroupHoursAmountText.getText()));
							pStmt.setInt(5,Integer.parseInt(CourseGroupDayText.getText()));
							pStmt.setInt(6,Integer.parseInt(CourseGroupYearText.getText()));
							pStmt.setInt(7,Integer.parseInt(CourseGroupTimeHourText.getText()));
							pStmt.setInt(8,Integer.parseInt(CourseGroupTimeMinuteText.getText()));
							pStmt.executeUpdate();
							pStmt.close();

						}
						else if(CourseGroupChooseUpdate.getSelection())//Course Update option
						{
							PreparedStatement pStmt = Connection2DB.Instance().getConnection().prepareStatement("UPDATE course SET Name=?,Semester=?,HourseAmount=?,Year=?,Day=?,Time_Hour=?,Time_Minute=? WHERE CourseNumber=?;");				
							pStmt.setString(1,CourseGroupCourseNameText.getText());							
							pStmt.setString(2,CourseGroupCourseSemesterText.getText());
							pStmt.setInt(3,Integer.parseInt(CourseGroupHoursAmountText.getText()));
							pStmt.setInt(4,Integer.parseInt(CourseGroupYearText.getText()));
							pStmt.setInt(5,Integer.parseInt(CourseGroupDayText.getText()));
							pStmt.setInt(7,Integer.parseInt(CourseGroupTimeMinuteText.getText()));
							pStmt.setInt(6,Integer.parseInt(CourseGroupTimeHourText.getText()));
							pStmt.setInt(8,Integer.parseInt(CourseGroupCourseNumberText.getText()));
							pStmt.executeUpdate();
							pStmt.close();
						}
						else /*when no operation chosen*/
						{
							CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							CourseGroupResultText.setText("Please choose an action");
							return;
						}
						listCourse.removeAll();
						crs= Connection2DB.Instance().getCourse("");
						for (Course course : crs) 
						{
							listCourse.add(course.toString());
						}
						CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
						CourseGroupResultText.setText("Action Complete.");

					}
					catch (NumberFormatException e1) {
						CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						CourseGroupResultText.setText(e1.getMessage());
						return;
					}
					catch (SQLException e1) {
						CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						CourseGroupResultText.setText(e1.getMessage());
						return;
					}
					catch (Exception e1) {
						CourseGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						CourseGroupResultText.setText(e1.getMessage());
						return;
					}
				}
			});
			
/***********************************Execute Button of Lecture group******************************************/
			LectureGroupExecuteButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					if (LectureGroupIDText.getText().equals("")||LectureGroupFirstNameText.getText().equals("") ||LectureGroupLastNameText.getText().equals("") ||LectureGroupBirthdayMonthText.getText().equals("") ||LectureGroupBirthdayDayText.getText().equals("") ||LectureGroupBirthdayYearText.getText().equals("") ||LectureGroupAdressCityText.getText().equals("") ||LectureGroupAdressNumberText.getText().equals("") ||LectureGroupAdressNameText.getText().equals(""))
					{
						if (LectureGroupIDText.getText().equals(""))LectureGroupResultText.setText("Lecture ID text filed must be added - Primary key!");
						else LectureGroupResultText.setText("All lecture ID text filed must be added.");
						LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						return;
					}
					try
					{	
						if (LectureGroupChooseDelete.getSelection())//Lecture delete option
						{
							String query1 = "DELETE FROM lecture WHERE ID="+LectureGroupIDText.getText() ;
							String query2 = "DELETE FROM teaching WHERE Lecture_ID="+LectureGroupIDText.getText() ;
							Connection2DB.Instance().Exectuequery(query1);
							Connection2DB.Instance().Exectuequery(query2);
							//lecturephone will update because of the CASCADE
						}
						else if (LectureGroupChooseInsert.getSelection())//Lecture Insert option
						{
							PreparedStatement pStmt = Connection2DB.Instance().getConnection().prepareStatement("INSERT INTO Lecture(ID ,Name_FirstName,Name_LastName,Birthday, Address_City,Address_street_Number,Address_Name)VALUES (?,?,?,?,?,?,?);");				
							pStmt.setInt(1,Integer.parseInt(LectureGroupIDText.getText()));
							pStmt.setString(2,LectureGroupFirstNameText.getText());
							pStmt.setString(3,LectureGroupLastNameText.getText());
							SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  
							java.util.Date myDate;
							myDate = format.parse( LectureGroupBirthdayMonthText.getText()+"/"+LectureGroupBirthdayDayText.getText()+"/"+LectureGroupBirthdayYearText.getText());
							java.sql.Date sqlDate = new java.sql.Date( myDate.getTime()); 
							pStmt.setDate(4,sqlDate);
							pStmt.setString(5,LectureGroupAdressCityText.getText());
							pStmt.setInt(6,Integer.parseInt(LectureGroupAdressNumberText.getText()));
							pStmt.setString(7,LectureGroupAdressNameText.getText());
							pStmt.executeUpdate();
							pStmt.close();
						}
						else if(LectureGroupChooseUpdate.getSelection())//Lecture Update option
						{
							SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );  
							java.util.Date myDate = format.parse( LectureGroupBirthdayMonthText.getText()+"/"+LectureGroupBirthdayDayText.getText()+"/"+LectureGroupBirthdayYearText.getText()); 
							String query = "UPDATE lecture SET Name_FirstName=?,Name_LastName=?,Birthday=?, Address_City=?,Address_street_Number=?,Address_Name=? WHERE ID = ?;";
							PreparedStatement pstmt =  Connection2DB.Instance().getConnection().prepareStatement(query);
							pstmt.setString(1, LectureGroupFirstNameText.getText() );
							pstmt.setString(2, LectureGroupLastNameText.getText());  
							java.sql.Date sqlDate = new java.sql.Date( myDate.getTime() ); 
							pstmt.setDate( 3, sqlDate ); 
							pstmt.setString(4, LectureGroupAdressCityText.getText());
							pstmt.setInt(5, Integer.parseInt(LectureGroupAdressNumberText.getText()));
							pstmt.setString(6, LectureGroupAdressNameText.getText());
							pstmt.setInt(7, Integer.parseInt(LectureGroupIDText.getText()));
							pstmt.executeUpdate();
						}
						else
						{
							LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
							LectureGroupResultText.setText("Please choose an action");
							return;
						}
						listLecture.removeAll();
						lec = Connection2DB.Instance().getLecture("");
						for (Lecture lecture : lec) 
						{
							listLecture.add(lecture.toString());
						}
						LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
						LectureGroupResultText.setText("Action Complete.");
					}
					catch(NumberFormatException e1)
					{
						LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						LectureGroupResultText.setText(e1.getMessage());
						return;
					}
					catch (SQLException e1) {
						LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						LectureGroupResultText.setText(e1.getMessage());
						return;
					}
					catch (ParseException e1) {
						LectureGroupResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						LectureGroupResultText.setText(e1.getMessage());
						return;
					}
				}
			});

/******************************Paring section*****************************/
			//Pair Class Lecture
			PairCourseLecture.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					try {
						String query = "INSERT INTO teaching VALUES ("+crs.get(listCourse.getSelectionIndex()).getCourseNumber()+","+lec.get(listLecture.getSelectionIndex()).getID()+");";
						Connection2DB.Instance().Exectuequery(query);
						PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
						PairResultText.setText("Action Complete.");
					} 
					catch (SQLException e1) {
						PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						PairResultText.setText(e1.getMessage());
						return;
					}
					catch (Exception e1) {
						PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						PairResultText.setText(e1.getMessage());
						return;
					}
				}
			});
			//Pair Class Course
			PairClassCourse.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					try {
						String query = "INSERT INTO takeplace VALUES ("+crs.get(listCourse.getSelectionIndex()).getCourseNumber()+","+cls.get(listClass.getSelectionIndex()).getClassNumber()+")";
						Connection2DB.Instance().Exectuequery(query);
						PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
						PairResultText.setText("Action Complete.");
					} 
					catch (SQLException e1) {
						PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						PairResultText.setText(e1.getMessage());
						return;
					}
					catch (Exception e1) {
						PairResultText.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
						PairResultText.setText(e1.getMessage());
						return;
					}
					
				}
			});
/************************Add information to text fields after click****************************************/
			listLecture.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{	try{
					Lecture ClickedLecture  = lec.get(listLecture.getSelectionIndex());
					String birthday = ClickedLecture.getBirthday().toString();
					String[] dates=birthday.split("-");
					LectureGroupIDText.setText(String.valueOf(ClickedLecture.getID()));
					LectureGroupFirstNameText.setText(ClickedLecture.getFirstName());
					LectureGroupLastNameText.setText(ClickedLecture.getLastName());
					LectureGroupAdressCityText.setText(ClickedLecture.getAdressCity());
					LectureGroupAdressNameText.setText(ClickedLecture.getAdressName());
					LectureGroupBirthdayDayText.setText(dates[2]);
					LectureGroupBirthdayMonthText.setText(dates[1]);
					LectureGroupBirthdayYearText.setText(dates[0]);
					LectureGroupAdressNumberText.setText(String.valueOf(ClickedLecture.getAdressStreetNumber()));	
					}
					catch(Exception e1){/*e1.printStackTrace();*/}
				}	
			});
			
			listClass.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					try{
					Classes ClickedClass = cls.get(listClass.getSelectionIndex());
					ClassGroupBuildingNumberText.setText(String.valueOf(ClickedClass.getBuildingNumber()));
					ClassGroupClassNumberText.setText(String.valueOf(ClickedClass.getClassNumber()));
					ClassGroupFloorText.setText(String.valueOf(ClickedClass.getFloor()));
					}
					catch(Exception e1){/*e1.printStackTrace();*/}
				}	
			});
			
			listCourse.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					try{
					Course ClickedCourse = crs.get(listCourse.getSelectionIndex());
					CourseGroupCourseNumberText.setText(String.valueOf(ClickedCourse.getCourseNumber()));
					CourseGroupCourseNameText.setText(ClickedCourse.getName());
					CourseGroupCourseSemesterText.setText(ClickedCourse.getSemester());
					CourseGroupHoursAmountText.setText(String.valueOf(ClickedCourse.getHourseAmount()));
					CourseGroupDayText.setText(String.valueOf(ClickedCourse.getDay()));
					CourseGroupYearText.setText(String.valueOf(ClickedCourse.getYear()));
					CourseGroupTimeMinuteText.setText(String.valueOf(ClickedCourse.getTime_Minute()));
					CourseGroupTimeHourText.setText(String.valueOf(ClickedCourse.getTime_Hour()));
					}
					catch(Exception e1){/*e1.printStackTrace();*/}
				}	
			});
			
/********************Extra queries GUI creations**********************************/

			ShowFullSchedule.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					try{
						FullScheduleFrame qyeryAnswer = new FullScheduleFrame();
						qyeryAnswer.open();
					}
					catch(Exception e1){e1.printStackTrace();}
				}
			});

			FindLectures.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e)
				{
					try{
						LecturesFrame qyeryAnswer = new LecturesFrame();
						qyeryAnswer.open();
					}		
					catch(Exception e1){e1.printStackTrace();}
				}
			});
			
			ClassInformaiton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					try{
					ClassInformationFrame qyeryAnswer = new ClassInformationFrame();
					qyeryAnswer.open();
					}
					catch(Exception e1){e1.printStackTrace();}
				}
			});
			
			LectureClassCourseList.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					try{
					lectureCourseClassFrame qyeryAnswer = new lectureCourseClassFrame();
					qyeryAnswer.open();
					}
					catch(Exception e1){e1.printStackTrace();}
				}
			});
		}
}

