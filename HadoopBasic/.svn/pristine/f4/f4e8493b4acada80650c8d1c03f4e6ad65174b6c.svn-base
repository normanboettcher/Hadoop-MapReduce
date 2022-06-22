package basic.example1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class WordCountMapperTest extends WordCountTestBase{
	
	@Test
	public void testWithOneLineOfWords() {
		Text input = new Text("These are words");
		
		try {
			mapDriver
			.withInput(new LongWritable(1L), input)
			.withOutput(new Text("These"), new IntWritable(1))
			.withOutput(new Text("are"), new IntWritable(1))
			.withOutput(new Text("words"), new IntWritable(1))
			.runTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testWithTextIsNull() {
		Text input = new Text("One words");
		Text input2 = new Text("");
		Text input3 = new Text("Two words");
		
		try {
			mapDriver
			.withInput(new LongWritable(1), input)
			.withInput(new LongWritable(2), input2)
			.withInput(new LongWritable(3), input3)
			.withOutput(new Text("One"), new IntWritable(1))
			.withOutput(new Text("words"), new IntWritable(1))
			.withOutput(new Text("Two"), new IntWritable(1))
			.withOutput(new Text("words"), new IntWritable(1))
			.runTest();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
