package basic.example2;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class Example2MapReduceTest extends Example2TestBase{

	@Test
	public void testMapReduceWithTwoLines() {
		Text text1 = new Text("2006052509201042");
		Text text2 = new Text("2006052509200762");
		
		mapReduceDriver.withInput(new LongWritable(1L), new Text(text1));
		mapReduceDriver.withInput(new LongWritable(2L), new Text(text2));
		mapReduceDriver.addOutput(new IntWritable(2007), new FloatWritable(6.0f));
		mapReduceDriver.addOutput(new IntWritable(2010), new FloatWritable(4.0f));
		
		try {
			mapReduceDriver.runTest();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
