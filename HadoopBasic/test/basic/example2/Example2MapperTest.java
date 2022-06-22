package basic.example2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class Example2MapperTest extends Example2TestBase {

	@Test
	public void testMapperWithExampleLine() throws IOException, InterruptedException {
		Text value = new Text("2006052509201042");
		
		//set the MapDRiver from MRUNIT
		mapDriver
		.withInput(new LongWritable(1L), value)
		.withOutput(new IntWritable(2010), new IntWritable(4))
		.runTest();
	}
	
	

}
