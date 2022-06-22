package basic.example1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class WordCountMapReduceTest extends WordCountTestBase {

	@Test
	public void testMapReduce() {
		Text input = new Text("dog cat cat elephant");
		
		try {
			mapReduceDriver
			.withInput(new LongWritable(1), input)
			.withOutput(new Text("cat"), new IntWritable(2))
			.withOutput(new Text("dog"), new IntWritable(1))
			.withOutput(new Text("elephant"), new IntWritable(1))
			.runTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
