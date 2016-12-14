package com.finalproject;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class ClassInformationFrame{

	protected Shell shell;
	private List list;
	private ArrayList<ClassInformationQuery> sch;

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
		shell.setSize(620, 499);	
		shell.setText("Class infomation Lecture Courses");
		list = new List(shell, SWT.BORDER);
		list.setBounds(10, 10, 580, 440);
		
		try {
				sch = Connection2DB.Instance().getClassInformation();
				for (ClassInformationQuery classdata : sch) 
				{
					list.add(classdata.toString());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
	}

}
