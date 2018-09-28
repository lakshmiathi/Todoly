package ToDoList;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


/* A class to maintain an arbitrary number of contact details.
 * @author Seetha .A.
 * @version 28.09.2018.
 */

public class ToDoList implements Serializable{
	
	private ArrayList<ToDoTask>taskList;
	private int taskCount;
	

/*Initialization for the todo list.
 * 
 */

	public ToDoList() {
		taskList = new ArrayList<>();
		taskCount = taskList.size()+1;
	}

	public  ArrayList<ToDoTask> getTaskList() {
		return taskList;
	}
	
	public int getTaskCount() {
		return taskCount;
	}

	public void addToTaskList(ToDoTask task) {
		
		if(task != null) {
			taskList.add(task);
			taskCount++;
			}
	}
	
	
	
	/*public void sortByproject(TodoTask task) {
		int comparison = project.compareTo(task.getProject());
		
	}*/
	
	public void editTask(int count) {
		 
			Scanner sc = new Scanner(System.in);
			int choice = 1;
			while (choice != 0) {
		
		  System.out.println();
	      System.out.println("You can now edit the task"); 
		  System.out.println("Pick an option:");
	      System.out.println("(1) To edit the taskitem");
	      System.out.println("(2) To edit the date");
	      System.out.println("(3) To edit the project");
	      System.out.println("(4) To edit the status");
	      System.out.println("(0) - Quit");
	      try {
	          choice = sc.nextInt();
	          sc.nextLine();  //clear input stream
	          switch (choice) {
	            case 1:  //edit taskitem
	            	taskList.get(count--).setTaskItem();
	              	break;
	          	case 2:  //edit date
	          		taskList.get(count--).setDate();
	                break;
	          	case 3:  //edit project
	          		taskList.get(count--).setProject(); 
	                break;
	          	case 4:  //edit project
	          		taskList.get(count--).setStatus(); 
	                break;
	          	case 0:
	                System.out.println("Goodbye! no more modification.");
	                break;
	          	default:
	                 System.out.println("Sorry, but " + choice + " is not one of " +
	                     "the menu choices. Please try again.");
	                 break;
	      			}    		  
	      		}	catch (java.util.InputMismatchException ime) {
	      			System.out.println("Sorry, but you must enter a number.");
	      			sc.nextLine();  //clear bad input from stream
	      			}
			}
	}

     
		
	/*public void removeTask(int count) {
		/*taskCount = count;
		if(count >=1 && count <= taskCount) {
			taskList.remove(count--);
		
		//no such element
		if (count < 1 || count > taskCount) {
		      return null;  
		    }else {
		    
		    	//convert to 0-based indexing used by array	
		    	taskList.remove(Count--)
		      //delete by shifting everything down into removed item's space
		      for (int i = count; i < taskCount - 1; i++) {
		        this.todo[i] = this.todo[i + 1];
		      }
		      this.count--;  //removed an element
		      return deleted;
		    }
		
		}*/
		
public static void main(String[] args) {
	// TODO Auto-generated method stub
	java.util.Scanner sc = new java.util.Scanner(System.in);
	ToDoTask task = new ToDoTask();
	ArrayList<ToDoTask>taskList = new ArrayList<ToDoTask>();
	int choice = 1;
    while (choice != 0) {
      //print list
    	
      System.out.println();
      System.out.println("Welcome to Todoly");
      System.out.println(taskList);  

      
      //print option choices
      System.out.println("Option:");
      System.out.println("(1) - Show task List by date or project");
      System.out.println("(2) - Add new task");
      System.out.println("(3) - Edit specific item");
      System.out.println("(4) - Save and Exit");
      System.out.print("Pick an option : ");

      //process user's menu choice
      try {
        choice = sc.nextInt();
        sc.nextLine();  //clear input stream
        switch (choice) {
          case 1:  //Display task list by date or project
                   
            break;

          case 2:  //Add task.
        	  System.out.print("Eter the task you need to do: ");
              taskList.add(task);
            break;

          /*case 3:  //Edit specific task.
            System.out.print("Enter the count of the item to remove: ");
            int count = keybd.nextInt();
            if(count >=1 && count <= taskList.size()) {
            taskList.get(count--).editTask();
            }
             break;*/

          case 4:
            System.out.println("Goodbye!");
            break;

          default:
            System.out.println("Sorry, but " + choice + " is not one of " +
                "the menu choices. Please try again.");
            break;
        }
      }catch (java.util.InputMismatchException ime) {
        System.out.println("Sorry, but you must enter a number.");
        sc.nextLine();  //clear bad input from stream
      }
    }//end while
  }//end main
}



