package ToDoList;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDolyApp {

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
	              task.addTask();
	             
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

	
