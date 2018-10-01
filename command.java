import java.util.LinkedList;

// >
public class command(fileName) {

	public command{
		this.fileName = fileName;
		this.input = new LinkedList<String>();
		this.output = new LinkedList<String>();
		
	}
	
	@Override
	public void process{
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName)));
		while (!input.isEmpty()) {
			String s = input.poll();
			String f = processLine(s);
			if (f != null) {
				BufferedWriter.write(f);
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
