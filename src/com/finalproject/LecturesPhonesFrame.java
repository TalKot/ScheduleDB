package com.finalproject;


import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class LecturesPhonesFrame {


	protected Shell shell;
	private List list;
	private ArrayList<LecturesPhonesQuery> sch;
	private int LectureID;
	
	public LecturesPhonesFrame(int ID)
	{
		LectureID=ID;
	}

	/**
	 * Open the window.
	 */
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
		shell.setSize(720, 499);
		shell.setText("Lecture Phones");
		
		list = new List(shell, SWT.BORDER);
		list.setBounds(10, 10, 680, 440);
		
		
		
		try {
				sch = Connection2DB.Instance().getLecturesPhoneslist(LectureID);
				for (LecturesPhonesQuery lecturesphones : sch) 
				{
				list.add(lecturesphones.toString());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
	}


}
