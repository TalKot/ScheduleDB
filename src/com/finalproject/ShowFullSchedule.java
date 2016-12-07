package com.finalproject;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.util.ArrayList;

import org.eclipse.swt.SWT;

public class ShowFullSchedule {

	protected Shell shell;
	private List list;
	private ArrayList<Schedule> sch;

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
		shell.setSize(1800, 499);
		shell.setText("Show Full Schedule");
		
		list = new List(shell, SWT.BORDER);
		list.setBounds(10, 10, 1780, 440);
		
		
		
		try {
				sch = Connection2DB.Instance().getSchedule();
				for (Schedule schedule : sch) 
				{
					list.add(schedule.toString());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
	}

}
