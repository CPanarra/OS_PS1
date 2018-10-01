package cs131.pa1.filter.sequential;
import java.util.LinkedList;
import java.util.Scanner;

public class wc extends SequentialFilter {
	
	public wc{
		
	this.input = new LinkedList<String>();
	this.output = new LinkedList<String>();
	}

	charCount = 0;
	wordCount = 0;
	lineCount = 0;
	
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
		while (s != null) {
			count(s);
			s = input.poll();
		}
		return lineCount + "" + wordCount + "" + charCount + "\n";
	}
	
	public void count(String s){
		String w = s;
		lineCount = lineCount + 1;
		while(w.hasNext()){
		      wordCount++;
		      w.next();
	}
		while(s.hasNextByte()) {
			charCount ++;
			s.nextByte():
		}
	}
}