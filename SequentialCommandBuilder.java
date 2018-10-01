package cs131.pa1.filter.sequential;

import java.util.List;

import cs131.pa1.filter.Filter;

public  class SequentialCommandBuilder{
	public static String[] commands; 
	public static List<SequentialFilter> filterList;
	
	
	public SequentialCommandBuilder(String[] commands) {
		this.commands=commands;
	}
	
	
	
	
	public static List<SequentialFilter> createFiltersFromCommand(String command){
		
		int length = commands.length; 
		for (int x=0;x<length;x++) {
		String[] singleCommand = commands[x].trim().split("\\s+");
		SequentialFilter filter = (singleCommand[0]); 
		filterList.add(filter);

		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	private static SequentialFilter determineFinalFilter(String command){
		return null;
	}
	
	private static String adjustCommandToRemoveFinalFilter(String command){
		return null;
	}
	
	private static SequentialFilter constructFilterFromSubCommand(String subCommand){
		return null;
	}

	private static boolean linkFilters(List<SequentialFilter> filters){
		return false;
	}
}
