package basic.example2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.junit.Test;

public class Example2ReducerTest extends Example2TestBase {

	@Test
	public void testReducerWithOneInput() {
		List<IntWritable> values = new ArrayList<IntWritable>();
		
		values.add(new IntWritable(1));
		try {
			reduceDriver
			.withInput(new IntWritable(2), values)
			.withOutput(new IntWritable(2), new FloatWritable(1.0f))
			.runTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReducerWithMultipleInputs() {
		List<IntWritable> values = new ArrayList<IntWritable>();
		
		//test with 10 Inputs 1...,10. sum = 45.
		for(int i = 0; i < 10; i++) {
			values.add(new IntWritable(i));
		}
			
		try {
			reduceDriver
			.withInput(new IntWritable(2010), values)
			.withOutput(new IntWritable(2010), new FloatWritable(4.5f))
			.runTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReducerWithDifferentInputKeys() {
		List<IntWritable> values_2010 = new ArrayList<IntWritable>();
		List<IntWritable> values_2009 = new ArrayList<IntWritable>();
		
		//test with 10 Inputs 1...,10. sum = 55.
		for(int i = 1; i < 11; i++) {
			values_2010.add(new IntWritable(i));
		}
		//test with 3 Inputs. sum = 6
		for(int i = 1; i < 4; i++) {
			values_2009.add(new IntWritable(i));
		}
			
		try {
			reduceDriver
			.withInput(new IntWritable(2010), values_2010)
			.withInput(new IntWritable(2009), values_2009)
			.withOutput(new IntWritable(2010), new FloatWritable(5.5f))
			.withOutput(new IntWritable(2009), new FloatWritable(2.0f))
			.runTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
