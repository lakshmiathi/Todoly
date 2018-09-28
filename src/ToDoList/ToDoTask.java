package ToDoList;
import java.io.Serializable;
import java.util.Scanner;

/*Todo task detail: taskitems, date, project and status.
 * 
 * @author Seetha .A.
 * @version 28.09.2018
 */
public class ToDoTask implements Comparable<ToDoTask>, Serializable{
	private String taskitem;
	private String date;
	private String project;
	private String status;
	Scanner sc = new Scanner(System.in);
/*
 * Set up the Task details.
 * @param taskitem
 * @param date
 * @param project
 * @param status
 */
	public ToDoTask(String taskitem, String date, String project, String status) {
		
		if(taskitem == null) {
			taskitem = "";	
		}
		if(date == null) {
			date = "";
		}
		if(project == null) {
			project = "";
		}
		if(status == null) {
			status = "";
		}
	this.taskitem = taskitem.trim();
	this.date = date.trim();
	this.project = project.trim();
	this.status = status.trim();
	}
	
	public ToDoTask() {
		
	}
	
	/*Return the task item, date project and status.
	 *
	 */
	public String getTaskItem() {
		return taskitem;
	}
	public String getDate() {
		return date;
	}
	public String getProject() {
		return project;
	}
	public String getStatus() {
		return status;
	}
	
	public void setTaskItem() {
	    System.out.print("\n\tEnter Task : ");
        taskitem = sc.nextLine();
	}
	
	public void setDate() {
		System.out.print("\n\tEnter Date : ");
        date = sc.nextLine();
	}
	public void setProject() {
		System.out.print("\n\tEnter Project : ");
        project = sc.nextLine();
	}
	public void setStatus() {
        System.out.print("\n\tEnter Status : ");
        status = sc.nextLine();
	}	
	
	// Defining GetData()
	public void addTask()           
    {
        
        System.out.print("\n\tEnter Task : ");
        taskitem = sc.nextLine();

        System.out.print("\n\tEnter Date : ");
        date = sc.nextLine();
        
        System.out.print("\n\tEnter Project : ");
        project = sc.nextLine();
        
        System.out.print("\n\tEnter Status : ");
        status = sc.nextLine();
    }
	
	/*Test for content equality between two objects.
	 *@param othertask the object to compare to this one.
	 *@return true if the argument object is a set 
	               of contact details with matching attributes.
	 */
	public boolean equals(Object other) {
		if(other instanceof ToDoTask) {
			ToDoTask otherTask = (ToDoTask)other;
			return taskitem.equals(otherTask.getTaskItem()) && 
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
	
	/* Return a multi-line string containing the taskitem, date, project and status.
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return taskitem +"\n" + date + "\n"+ project + "\n" + status;
		}
	

	
}


