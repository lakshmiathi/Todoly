package ToDoList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

/*Todo task detail: tasktitle, date, project and status.
 * 
 * @author Seetha .A.
 * @version 28.09.2018
 */
public class ToDoTask implements Comparable<ToDoTask>, Serializable{
	private String title;
	private LocalDate date;
	private String project;
	private String status;	
	
/*
 * Set up the Task details.
 * @param taskitem
 * @param date
 * @param project
 * @param status
 */
	public ToDoTask(String title, LocalDate date, String project, String status) {
		
		if(title== null) {
			title = "";	
		}
		if(date == null) {
			date = null;
		}
		if(project == null) {
			project = "";
		}
		if(status == null) {
			status = "";
		}
	this.title = title.trim();
	this.date = date;
	this.project = project.trim();
	this.status = status.trim();
	}
	
	public ToDoTask(String title, LocalDate date, String project) {
		this(title, date, project, "OPEN");
	}
	
	public ToDoTask() {
		
	}
	
	/*Return the task item, date project and status.
	 *
	 */
	public String getTitle() {
		return title;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getProject() {
		return project;
	}
	public String getStatus() {
		return status;
	}
	
	
	
	
	
	public void setTitle(String title) {
	    
		this.title = title;
	}
	
	public void setDate(LocalDate date )
	{
		
	   this.date = date;
	}
	public void setProject(String project) {
		
		this.project = project;
	}
	public void setStatus(String status) {
      
		this.status = status;
	
	}
	
		

	/*Test for content equality between two objects.
	 *@param othertask the object to compare to this one.
	 *@return true if the argument object is a set 
	               of contact details with matching attributes.
	 */
	public boolean equals(Object other) {
		if(other instanceof ToDoTask) {
			ToDoTask otherTask = (ToDoTask)other;
			return title.equals(otherTask.getTitle()) && 
					date.equals(otherTask.getDate()) && 
					project.equals(otherTask.getProject()) && 
					status.equals(otherTask.getStatus());
		}
		else {
			return false;
		}
	}
	
	/* Compare these details against another set, for the purpose of sorting.
	 * by date; project and status.
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ToDoTask otherTask) {
		// TODO Auto-generated method stub
		int comparison = date.compareTo(otherTask.getDate());
		if(comparison !=0) {
			return comparison;
		}
		
		comparison = project.compareTo(otherTask.getProject());
		if(comparison !=0) {
		    return comparison;
		}
		
		    return status.compareTo(otherTask.getStatus());
	}
	
	/** Return a multi-line string containing the taskitem, date, project and status.
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	public String toString() {
		return this.date +"|" + this.title + "|"+ this.project + "|" + this.status + "\n";
		// return this.date +" \n" + this.taskitem + " \n"+ this.project + " \n" + this.status;
	}
		
	}//end class


	



