import java.util.LinkedList;

public class cat {
	
	public cat{
		this.input = new LinkedList<String>();
		this.output = new LinkedList<String>();
	}
	
	@Override
	public void process{
		while (!input.isEmpty()) {
			String s = input.poll();
			String f = processLine(s);
			if (f != null) {
				System.out.println(f);
				output.add(f);
			}
		}
	} 
	
	public String processLine(String s) {
		if (s != null) {
			return s;
		} 
		}
	}

}
