package FileHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ToDoList.ToDoTask;


public class FileManager {
	
		private static Scanner x;	
		private String fileName;
		
		public FileManager() 
		{
			fileName = "src/FileHandler/tasklist.txt";
		}
	
	public void writeOutput(ArrayList<ToDoTask> taskList) throws IOException

	{
		
	
	          try {
	        	  FileWriter fw = new FileWriter(fileName);
	        	  BufferedWriter writer = new BufferedWriter(fw);
	        	 
	          for (ToDoTask tasks : taskList) 

	            {
	        	  writer.write(tasks.toString());	
	        	  writer.write("\n");
		         
	            }
	        	
        		          	writer.close();

	      		}catch (IOException x) {
	    System.err.format("IOException: %s%n", x);

	}}

	

	
	public ArrayList<ToDoTask> reading() {
		String line;
		BufferedReader br = null;
		ToDoTask task = new ToDoTask();
		ArrayList<ToDoTask>taskList = new ArrayList<>();
		
		try {
			br= new BufferedReader(new FileReader(fileName));
			while((line = br.readLine())!=null){
					if(line.length() == 0)
					{
						continue;
					}
					
					String[]columns = line.split("[|\n]");
		    		String date = columns[0];
		    		    		
		        	task.setDate( LocalDate.parse(date.trim()));
					task.setTitle(columns[1].trim());
					task.setProject(columns[2].trim());
				    task.setStatus(columns[3].trim());
					//System.out.println(line);
					taskList.add(readLinefromFile(line,br));				
					//taskList.add((ToDoTask)line);
				}
				}catch (IOException x) {
					System.err.println(x);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return taskList;
			}
		
			
	public ToDoTask readLinefromFile(String line, BufferedReader br ) throws ParseException           
    {
		ToDoTask task = new ToDoTask();
				
        String[]columns = line.split("[|\n]");
		String date = columns[0];
		    		
		task.setDate( LocalDate.parse(date.trim()));
		task.setTitle(columns[1].trim());
		
		task.setProject(columns[2].trim());
		task.setStatus(columns[3].trim());  
   
		return task;
       
    }

	
	}//end class





	 

	

