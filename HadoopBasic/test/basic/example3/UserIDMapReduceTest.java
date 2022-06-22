package basic.example3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class UserIDMapReduceTest extends Example3TestBase {
	
	@Test
	public void testMapReduceWithTwoLines() throws IOException {
		Text text1 = new Text("\"UserId\"");
		Text text2 = new Text("\"12345\"");
		Text text3 = new Text("\"12345\"");
		Text text4 = new Text("\"12346\"");
		
		mapReduceDriver.withInput(new LongWritable(1L), new Text(text1));
		mapReduceDriver.withInput(new LongWritable(2L), new Text(text2));
		mapReduceDriver.withInput(new LongWritable(3L), new Text(text3));
		mapReduceDriver.withInput(new LongWritable(4L), new Text(text4));
		mapReduceDriver.addOutput(new Text("12345"), new IntWritable(2));
		mapReduceDriver.addOutput(new Text("12346"), new IntWritable(1));
		mapReduceDriver.runTest();
	}

}
