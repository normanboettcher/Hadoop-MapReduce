package basic.example2;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;

import de.basic.example2.GradesMapper;
import de.basic.example2.GradesReducer;

public abstract class Example2TestBase {
	
	MapReduceDriver<LongWritable, Text, IntWritable, IntWritable, IntWritable, FloatWritable> mapReduceDriver;
	MapDriver<LongWritable, Text, IntWritable, IntWritable> mapDriver;
	ReduceDriver<IntWritable, IntWritable, IntWritable,FloatWritable> reduceDriver;

	@Before
	public void setUp() {
		GradesMapper gMapper = new GradesMapper();
		GradesReducer gReducer = new GradesReducer();
		
		mapDriver = new MapDriver<LongWritable, Text, IntWritable, IntWritable>();
		mapDriver.setMapper(gMapper);
		reduceDriver = new ReduceDriver<IntWritable, IntWritable, IntWritable,FloatWritable>();
		reduceDriver.setReducer(gReducer);
		
		mapReduceDriver = new MapReduceDriver<LongWritable, Text, IntWritable, IntWritable, IntWritable, FloatWritable>();
		mapReduceDriver.setMapper(gMapper);
		mapReduceDriver.setReducer(gReducer);
		
	}
	
}
