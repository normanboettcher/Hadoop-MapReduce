package basic.example3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.junit.Test;

public class UserIDReducerTest extends Example3TestBase {

	@Test
	public void reduceTest() throws IOException {
		List<IntWritable> values = new ArrayList<IntWritable>();
		
		values.add(new IntWritable(1));
		values.add(new IntWritable(1));
		
		reduceDriver
		.withInput(new Text("\"12345\""), values)
		.withOutput(new Text("12345"), new IntWritable(2))
		.runTest();
	}
}
