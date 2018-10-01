package cs131.pa1.filter.sequential;
import java.util.LinkedList;

public class grep extends SequentialFilter {
	String key;
	
	public grep(String s) {
		this.input = new LinkedList<String>();
		this.output = new LinkedList<String>();
		this.key = key;
		
		if (key == null) {
			System.out.print(Message.REQUIRES_PARAMETER.with_parameter("grep"));
		}
	}
	
	@Override
	public void process{
		while (!input.isEmpty()) {
			String s = input.poll();
			String f = processLine(s);
			if (f != null) {
				output.add(f);
			}
		}
	}
	
	public String processLine(String s) {
		if (s.contains(key)) {
			return s;
		} else {
			return "";
		} 
	}
}
