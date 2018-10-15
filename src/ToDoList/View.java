package ToDoList;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import FileHandler.FileManager;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




/* A class to maintain an arbitrary number of contact details.
 * @author Seetha .A.
 * @version 28.09.2018.
 */

public class View {
	
	private Scanner sc; // VIEW MENU
	private ToDoList tm;


	/*
	 * The view is the application User Interface  
	 */
	public View(ToDoList todoList) {
		
		sc = new Scanner(System.in); // VIEW MENU

		this.tm = todoList; // TaskManager
	}

	
	
	// to add task (in turn calls the addTask method to add to taskList). 
	public void menuOptAddTask() {
		
		
		String project, task;
		LocalDate date;
		int max = 100;
		int min = 3;
	
					
		
		System.out.print("\n\tEnter the task description (min 3 character and max 100 character): \n\t");
		task = sc.nextLine();
		if (task.length() > max) {
			perror("Task description", "over", max);
			return;
		}
		if (task.length() < min) {
			perror("Task description", "less", min);
			return;
		}
		
		
        System.out.print("\n\tEnter the project (min 3 character and max 100 character): \n\t");
        project = sc.nextLine();
		if (project.length() > max) {
			perror("Project name ", "over", max);
			return;
		}
		
		if (task.length() < min) {
			perror("Project name", "less", min);
			return;
		}
		
		
		// check if it exists
		if (tm.taskExists(project, task)) {
			System.out.printf("The task '%s' already exists within '%s' ", task, project);
			return;
		};
		
		
		String dateInput = "";
		try {

			System.out.print("\n\tEnter Date as yyyy-mm-dd: \n\t");
			dateInput = sc.nextLine();
			
			date = LocalDate.parse(dateInput);
			if(date.isBefore(LocalDate.now())) {
			System.err.println("date is not valid");
			return;
		}
			
		} catch(DateTimeParseException e) {
			System.out.printf("[ERROR] The date '%s' is invalid format\n", dateInput);
			return;
		}
        
        
		String result = tm.addTask(project, task, date);
		System.out.printf("\nSuccessfully added: %s\n", result);
		
		
		}
	//error msg.
	private void perror (String description, String lessOver, int limit) {
		System.err.printf("[%s] %s is %s the character limit (%d\n", "ERROR",description, lessOver, limit);
	}
	
	//editTask
	public void editTaskList(int tasknum, int choice_edit) {
		
		int index = tasknum - 1;
		String date, status, project, title;
		Scanner edit = this.sc; 
		edit.nextLine(); 		
			  
		switch (choice_edit) {
			    
				case 1:
					System.out.println("Enter the new date "); 	
					tm.editTask(index, 1, sc.nextLine());
					break;
				case 2:

					System.out.println("Enter the new task item");
					title = edit.nextLine();
					tm.editTask(index,2,title);
					break;
				case 3:

					System.out.println("Enter the project");
					project = sc.nextLine();
					tm.editTask(index, 3, project);
					break;
				case 4:
					System.out.println(" Note the status as done");
					
					//status = sc.nextLine();
					tm.editTask(index, 4, sc.nextLine());
					break;
					
				case 5:
					System.out.println("Task no. " + tasknum + "is removed");
					tm.removeTask(tasknum);
					break;
				
				default:
			        System.out.println("Sorry, but " + choice_edit + " is not one of " +
			            "the menu choices. Please try again.");
			        break;
					
  }
			  } 

	
		
	
	
	public int Run() {
		System.out.println("START >> ");
		tm.loading();
		
		int choice = 1;
	    while (choice != 0) {
		  try {
			  System.out.println("\n");
			  System.out.println(">> Welcome to ToDoly");
			  System.out.println(">> You have " +tm.unDoneItem()+ " tasks todo and " + tm.doneItem()+" tasks are done!");
			 // System.out.println(">> you have " +tm.overDueTask()+  " overdue tasks");
			  tm.overDueTask();
			  //print option choices
				
			  System.out.println(">> Pick an option");
		      System.out.println(">> (1) Show task List by date or project");
		      System.out.println(">> (2) Add new task");
		      System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		      System.out.println(">> (4) Save and Exit");
		      System.out.println(">> Option: \t");
			  
		        choice = sc.nextInt();
		        sc.nextLine();  //clear input stream
		        switch (choice) {
		        
		        	case 1:
		        		System.out.println(">> Pick an option");
		      	      	System.out.println(">> (1) Show task List by date");
		      	      	System.out.println(">> (2) Show task List by project");
		      	      	System.out.println(">> Option: \t");
		      	      	System.out.print("\n");
		        			tm.displayTask(sc.nextInt());
		        		  break;
			    	case 2:  
			    		System.out.println(">> (2) Add New Task");
			        	  this.menuOptAddTask();
			        	  break;
			        
			    	case 3:
			    		System.out.println(">> (3) To update, mark as done, remove task:");
			    		System.out.print("\n");
			    		tm.displayTask(2);
			   
			    		System.out.println("\n Enter the task number to be updated/removed: ");
			    		int tasknum =sc.nextInt();
			    		System.out.println(">> Pick an option");
		      	      	System.out.println(">> (1) Edit task's date");
		      	      	System.out.println(">> (2) Edit taskitem ");
		      	      	System.out.println(">> (3) Edit task's project");
		      	      	System.out.println(">> (4) Edit task's status");
		      	      	System.out.println(">> (5) Remove task ");
		      	      	System.out.println(">> Option: \t");
		      	      	System.out.print("\n");
		      	      	
		      	      	int editmenu=sc.nextInt();
		      	      	sc.nextLine();//clear input stream
		      	      	
			    		this.editTaskList(tasknum, editmenu);
			    		break;
			    		
			    	
			    	case 4:
			    		System.out.println(">> (4) Save and Quit");
			    		System.out.println("Goodbye!");
			    		try {
			    			
			    			tm.saveTask();
			    			
			    		} catch (IOException e) {
			    			// TODO Auto-generated catch block
			    			e.printStackTrace();
			    		}
			    		System.exit(0);           
			    		break;
			   
			        
			        default:
			            System.out.println("Sorry, but " + choice + " is not one of " +
			                "the menu choices. Please try again.");
			            break;
		        }
		      }catch (java.util.InputMismatchException ime) {
		        System.out.println("Sorry, but you must enter a number.");
		        sc.nextLine();  //clear bad input from stream
		        return 0;
		      //} catch (IOException e1) 
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			}
		}//end while
	    return 1;
	}
}
