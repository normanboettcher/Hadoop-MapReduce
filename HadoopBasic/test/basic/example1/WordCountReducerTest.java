package basic.example1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class WordCountReducerTest extends WordCountTestBase {

	@Test
	public void testReducerWithOneInput() {
		List<IntWritable> input1 = new ArrayList<IntWritable>();
		input1.add(new IntWritable(1));
		input1.add(new IntWritable(1));
		
		Text text1 = new Text("word");
		
		try {
			reduceDriver
			.withInput(text1, input1)
			.withOutput(new Text("word"), new IntWritable(2))
			.runTest();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReducerWithTwoInputs() {
		List<IntWritable> val1 = new ArrayList<IntWritable>();
		val1.add(new IntWritable(1));
		val1.add(new IntWritable(1));
		
		List<IntWritable> val2	= new ArrayList<IntWritable>();
		val2.add(new IntWritable(1));
		
		Text text1 = new Text("word");
		Text text2 = new Text("new");
		
		try {
			reduceDriver
			.withInput(text1, val1)
			.withInput(text2, val2)
			.withOutput(new Text("word"), new IntWritable(2))
			.withOutput(new Text("new"), new IntWritable(1))
			.runTest();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
