package ToDoList;

import java.util.stream.Collectors;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import FileHandler.FileManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;


/* A class to maintain an arbitrary number of contact details.
 * @author Seetha .A.
 * @version 28.09.2018.
 */

public class ToDoList implements Serializable{
		
	
	private ArrayList<ToDoTask>taskList;
	private FileManager toDoFileMgr;
	
	
    

/*Initialization for the todo list.
 * 
 */

	public ToDoList() {	
		
		toDoFileMgr= new FileManager();
		taskList = new ArrayList<ToDoTask>();
		}

	public  ArrayList<ToDoTask> getTaskList() {
		return taskList;
	}
	
	

	//to create and add new task.
	public String addTask(String project, String title, LocalDate date) {
		if (this.taskExists(project, title)) {
			return "";
		}

		ToDoTask task = new ToDoTask(title, date,  project);
		this.taskList.add(task);
		System.out.println(taskList.size());
		StringBuilder sb = new StringBuilder();
		Formatter fmt = new Formatter(sb);
		fmt.format("date = %s toDo = %s project = %s status = %s", date , title, project, "open");
		return sb.toString();
		
	}
	
	//save the task added in the taskList.
	public void saveTask() throws IOException {
		
		try {
			
			toDoFileMgr.writeOutput(taskList);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	//to display the task.
	
	
	  public void displayTask(int choice) {
		  
	 if (choice == 1) {
		  System.out.println("******************************  GROUP BY DATE  ********************************");	
		  String format = "%-7s %-12s %-35s %-15s %-10s \n"; 
		  System.out.print("-------------------------------------------------------------------------------\n");
		  System.out.print(String.format(format,"S.No.","DATE","TASK","PROJECT", "STATUS"));
		  System.out.print("-------------------------------------------------------------------------------\n");        	  
		 
		  Collections.sort(this.taskList);
		for(int i=0;i<this.taskList.size();i++){
			String format1 = "%-7s %-12s %-35s %-15s %-10s \n";
			int j = i+1;
			
	  System.out.print(String.format(format1,j,this.taskList.get(i).getDate(), this.taskList.get(i).getTitle(),this.taskList.get(i).getProject(),this.taskList.get(i).getStatus()));
	
	  }
		System.out.print("-------------------------------------------------------------------------------\n");
	}
	 
	 if(choice==2) {
		  System.out.println("******************************  GROUP BY PROJECT  *****************************");
		  String format = "%-7s %-12s %-35s %-15s %-10s \n"; 
		  System.out.print("-------------------------------------------------------------------------------\n");
		  System.out.print(String.format(format,"S.No.","DATE","TASK","PROJECT", "STATUS"));
		  System.out.print("-------------------------------------------------------------------------------\n");        	  
		 
		  taskList.sort((ToDoTask t1, ToDoTask t2) -> t1.getProject().compareTo(t2.getProject()));
		  
		  for(int i=0;i<this.taskList.size();i++){
			String format1 = "%-7s %-12s %-35s %-15s %-10s \n";
			int j = i+1;
	  System.out.print(String.format(format1,j,this.taskList.get(i).getDate(), this.taskList.get(i).getTitle(),this.taskList.get(i).getProject(),this.taskList.get(i).getStatus()));
	
	  }
		System.out.print("-------------------------------------------------------------------------------\n");
	}	 
	  }
	
	  
	 // remove task
	public void removeTask(int tasknum){
		
		
		int index = tasknum - 1;
		if((tasknum>=0 && tasknum <= taskList.size())&&(taskList!=null)){
		
			taskList.remove(index);
		 
			}else {
				System.out.println("Task not available. Enter valid task number:");
						}}
		
		public void loading() {
			this.taskList= toDoFileMgr.reading();
		}
	
	
	public void editTask(int index, int c, String editItem) 
	
	{
		if((index>=0 && index < taskList.size())&&(taskList!=null)){
		if(c == 1) {
			LocalDate dateInput= LocalDate.parse(editItem);
			taskList.get(index).setDate(dateInput);
		}
		if(c==2) {
			
			taskList.get(index).setTitle(editItem);
			
		}
		if(c==3) {
			taskList.get(index).setProject(editItem);
		}
			if(c==4) {
				taskList.get(index).setStatus(editItem);
			}
	
	} else {
		System.out.println("Task not available. Enter valid task number:");
	}
	}
	
		 

public void sortTaskList() {
	List<ToDoTask>list = new ArrayList<ToDoTask>();
	ArrayList<ToDoTask> taskList = (ArrayList<ToDoTask>)list.stream().sorted().collect(Collectors.toList());
	System.out.println("---Sorting using Comparator by project---");
	taskList = (ArrayList<ToDoTask>)list.stream().sorted(Comparator.comparing(ToDoTask::getProject).reversed()).collect(Collectors.toList());
taskList.forEach(e -> System.out.println("TaskItem:"+ e.getTitle()+", Date: "
						+e.getDate()+", Project:"+e.getProject()+", "+ "Status:"+e.getStatus()));
	
    }
	
	public int unDoneItem() {
		String status = "OPEN";
		int undone=0;
		for(ToDoTask t : taskList) {
			status.equals(t.getStatus().toUpperCase());
			undone++;			
		}
		return undone;
	}
	
	public int doneItem() {
		int x = this.taskList.size();
		int y = this.unDoneItem();
		int done = x-y;
		return(done);
	}
	
	public void overDueTask() {
		int overDue = 0;
		LocalDate date=null;
		for(ToDoTask t: taskList) {
			date=(t.getDate());
		if(date.isBefore(LocalDate.now())) {	
			overDue++;
		}
		}
		if(overDue>0) {
			System.err.println(">> You have " +overDue+ " overdue tasks");
		} 
	}
	
	
	public boolean taskExists(String project, String title) {
		for (ToDoTask task : this.taskList) {
			if (task.getTitle().equals(title) && task.getProject().equals(project)) {
				return true;
				}
			}
		return false;
		
	}
}//end class
		
	
		       
	

   
  
		
