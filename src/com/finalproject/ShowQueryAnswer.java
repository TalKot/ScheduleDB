package com.finalproject;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ShowQueryAnswer {

	protected Shell shell;
	private Text StartGroupDayText;
	private Text StartGroupHourText;
	private Text StartGroupMinuteText;
	private Text EndGroupDayText;
	private Text EndGroupHourText;
	private Text EndGroupMinuteText;
	private ArrayList<Lecture> lec;
	private List list;

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

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(710, 456);
		shell.setText("SWT Application");
		
		list = new List(shell, SWT.BORDER);
		list.setBounds(10, 148, 674, 259);
		
		Group StartGroup = new Group(shell, SWT.NONE);
		StartGroup.setText("Start");
		StartGroup.setBounds(10, 7, 674, 47);
		
		CLabel StartGroupDayLable = new CLabel(StartGroup, SWT.NONE);
		StartGroupDayLable.setBounds(10, 16, 37, 21);
		StartGroupDayLable.setText("Day");
		
		CLabel StartGroupTimeLable = new CLabel(StartGroup, SWT.NONE);
		StartGroupTimeLable.setText("Time");
		StartGroupTimeLable.setBounds(120, 16, 37, 21);
		
		StartGroupDayText = new Text(StartGroup, SWT.BORDER);
		StartGroupDayText.setBounds(53, 16, 37, 21);
		
		StartGroupHourText = new Text(StartGroup, SWT.BORDER);
		StartGroupHourText.setBounds(170, 16, 30, 21);
		
		StartGroupMinuteText = new Text(StartGroup, SWT.BORDER);
		StartGroupMinuteText.setBounds(217, 16, 37, 21);
		
		CLabel label_2 = new CLabel(StartGroup, SWT.NONE);
		label_2.setText(":");
		label_2.setBounds(206, 16, 5, 21);
		
		Group EndGroup = new Group(shell, SWT.NONE);
		EndGroup.setText("End");
		EndGroup.setBounds(10, 64, 674, 47);
		
		CLabel EndGroupDayLable = new CLabel(EndGroup, SWT.NONE);
		EndGroupDayLable.setText("Day");
		EndGroupDayLable.setBounds(10, 16, 37, 21);
		
		EndGroupDayText = new Text(EndGroup, SWT.BORDER);
		EndGroupDayText.setBounds(53, 16, 37, 21);
		
		CLabel EndGroupTimeLable = new CLabel(EndGroup, SWT.NONE);
		EndGroupTimeLable.setText("Time");
		EndGroupTimeLable.setBounds(120, 16, 37, 21);
		
		EndGroupHourText = new Text(EndGroup, SWT.BORDER);
		EndGroupHourText.setBounds(170, 16, 30, 21);
		
		CLabel label_1 = new CLabel(EndGroup, SWT.NONE);
		label_1.setText(":");
		label_1.setBounds(206, 16, 5, 21);
		
		EndGroupMinuteText = new Text(EndGroup, SWT.BORDER);
		EndGroupMinuteText.setBounds(217, 16, 37, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				//String sqlQuery = "SELECT * FROM lecture left JOIN teaching ON ID=teaching.Lecture_ID left JOIN course ON Course_CourseNumber=course.CourseNumber where Day>="+StartGroupDayText.getText()+" AND Day<="+EndGroupDayText.getText()+";";//+" AND Time_Hour>="+StartGroupHourText.getText()+" AND Time_Hour<="+EndGroupHourText.getText()+" AND Time_Minute>= "+StartGroupMinuteText.getText()+" AND Time_Minute<="+EndGroupMinuteText.getText()+";";
//"+StartGroupMinuteText.getText()+" AND Time_Minute<="+EndGroupMinuteText.getText()+";";

				//
				String sqlQuery = "SELECT teaching.Lecture_ID, course.* FROM teaching RIGHT JOIN course ON teaching.Course_CourseNumber=course.CourseNumber	WHERE (course.Day >"+StartGroupDayText.getText()+" AND course.Time_Hour>="+StartGroupHourText.getText()+") AND (course.Day<"+EndGroupDayText.getText()+" AND course.Time_Hour<"+EndGroupHourText.getText()+") ORDER BY teaching.Lecture_ID;";				System.out.println(sqlQuery);
				System.out.println(sqlQuery);
				try {
					list.removeAll();
					lec = Connection2DB.Instance().getLecture(sqlQuery);
					for (Lecture lectures : lec) 
					{
						list.add(lectures.toString());
					}
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 117, 75, 25);
		btnNewButton.setText("Execute");

	}
}
