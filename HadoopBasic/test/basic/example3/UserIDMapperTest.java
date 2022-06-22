package basic.example3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class UserIDMapperTest extends Example3TestBase {

	@Test
	public void mapperTest() throws IOException {
		Text value = new Text("\"UserId\",");
		Text value2 = new Text("\"12345\"");
		
		mapDriver
		.withInput(new LongWritable(1L), value)
		.withInput(new LongWritable(2L), value2)
		.withOutput(new Text("\"12345\""), new IntWritable(1))
		.runTest();
	}

}
