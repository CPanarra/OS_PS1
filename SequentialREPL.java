package cs131.pa1.filter.sequential;

import java.io.File;
import java.util.*;

import cs131.pa1.filter.Filter;
import cs131.pa1.filter.Message;

public class SequentialREPL {

	static String currentWorkingDirectory = "C:"+ Filter.FILE_SEPARATOR +
			"Users"+ Filter.FILE_SEPARATOR + "colin"+ Filter.FILE_SEPARATOR 
			+ "Desktop"+ Filter.FILE_SEPARATOR 
			+ "OS_PS1-master"+ Filter.FILE_SEPARATOR
			+ "cs131a_PA1_Part1_StarterKit"+ Filter.FILE_SEPARATOR
			+ "cs131a_PA1_Part1_StarterKit"+ Filter.FILE_SEPARATOR
			+ "src"+ Filter.FILE_SEPARATOR 
			+ "cs131"+ Filter.FILE_SEPARATOR 
			+ "pa1"+ Filter.FILE_SEPARATOR
			+ "filter"+ Filter.FILE_SEPARATOR 
			+ "sequential";
	
	/*
	Todo:
	1. print >
	2. Take input with scanner
		-parse for pipes
		-string.split
		-put into array
	3. Identify and report errors
		- undefined
		-invalid
		- invalid piping
		-file not found

	 */
	public static void main(String[] args){
		//Takes in users command(s) as a string 
		boolean exit = false; 
		System.out.print(Message.WELCOME);
		while(!exit) {
		System.out.print(Message.NEWCOMMAND);
		Scanner console = new Scanner (System.in);
		String userInput = console.nextLine();
	
		
		//Splits the users input by searching for pipes and storing them into an array
		//We have to escape the pipe character because it has a different meaning alone
		String[] commands = userInput.split("\\|"); 
		System.out.print(Arrays.toString(commands));
		boolean noError=true; 
		
		int numCommands = commands.length; 
		//Loop checks each command for both a valid command AND a file 
		for( int x = 0; x < numCommands; x++) { 
			if (undefinedCommand(commands[x])) {
				x = numCommands; 
				noError= false;
			}
			if(x!=numCommands && userExit(commands[x])) {
				exit = true; 
				x=numCommands; 
			}
			if (x!= numCommands && invalidArgument(commands[x]) ) {
				x = numCommands; 
				noError= false;
			}
			if (x!=numCommands &&nonexistentFile(commands[x]) ) {
				x = numCommands; 
				noError= false;
			}
			
		}
		//feed our array of commands into the sequential command builder
		if(noError) {
			SequentialCommandBuilder command = new SequentialCommandBuilder(commands); 
			
			
			
			
			
		}
		
		}
	}
	
	
	
	
	
	
	/*
	*	UNDEFINED
	*	COMMAND
	*/ 
	public static boolean undefinedCommand(String s) {
		
			
			//splits each piping command into both the command and the potential file
			//we use \\s+ to split by spaces and trim to ignore the first space if there is one
			String [] singleCommand = s.trim().split("\\s+"); 
			
			//tests for an undefined command by ensuring the first set is actually a command
			if (!singleCommand[0].matches("pwd|ls|cd|cat|grep|wc|uniq|exit|>|")){
				System.out.print(Message.FILE_NOT_FOUND.with_parameter(singleCommand[0]) );
				return true; 
				  
			}
			return false; 
		}
	public static boolean invalidArgument(String s) {

		
		
		/*
		*	INVALID
		*	ARGUMENTS 
		*
		*	AND INVALID PIPING ORDER
		*/ 
		String [] singleCommand = s.trim().split("\\s+"); 
		if(singleCommand[0].matches("cat|grep|wc|uniq") ) {
			//if there is no second phrase in a command block it is an invalid piping order
			//this also avoids an out of bounds error
			if( singleCommand.length<=1) {
				System.out.print(Message.REQUIRES_INPUT.with_parameter(singleCommand[0]) );
				return true; 
				
				}
			
			//makes sure there is a file to look for by checking for .txt
			int length = singleCommand[1].length(); 
			if (length<=4 || !singleCommand[1].substring(length-4).equals(".txt")) {
				System.out.print(Message.REQUIRES_PARAMETER.with_parameter(singleCommand[0]) );
				return true; 
				
			}
		
		
		}
		return false; 
	}
	
	public static boolean nonexistentFile(String s) {
		/*
		*	FILE \ DIRECTORY 
		*	NOT FOUND 
		*/ 
		String [] singleCommand = s.trim().split("\\s+"); 
		
		//checks the directory for any files from commands that aren't dealing with directories 
		if(!singleCommand[0].matches("cd|ls|pwd")) {
			File file = new File (singleCommand[1]); 
			if(!file.exists()) {
				System.out.print(Message.FILE_NOT_FOUND.with_parameter(s)); 
				
				return true; 
			}
		}
		if(singleCommand[0].matches("cd|ls|pwd") && singleCommand.length>1) {
			System.out.print(Message.CANNOT_HAVE_INPUT.with_parameter(singleCommand[0]));
		}
		//checks to see if current directory or new directory exists. 
		if(singleCommand[0].matches("cd")) {
			if(singleCommand.length!=1) {
			currentWorkingDirectory = singleCommand[1]; }
			else { 	System.out.print(Message.REQUIRES_PARAMETER.with_parameter(singleCommand[0]));}
		}
		if(currentWorkingDirectory!=null) {
		File directory = new File (currentWorkingDirectory); 
		if(!directory.isDirectory()) {
			System.out.print(Message.DIRECTORY_NOT_FOUND.with_parameter(s));
			return true;
		}
		}

		
		
		return false;
	}
	
	//checks if user wants to exit. 
	public static boolean userExit(String s) {
		String [] singleCommand = s.trim().split("\\s+"); 
		
		if(singleCommand[0].equals("exit")){
			System.out.print(Message.GOODBYE);
			return true;
		}
		return false; 
		
	}

}
