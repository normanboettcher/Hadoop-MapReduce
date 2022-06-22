package basic.example3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;

import de.basic.example3.UserIDMapper;
import de.basic.example3.UserIDReducer;

public abstract class Example3TestBase {
	MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;
	MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;
	ReduceDriver<Text, IntWritable, Text,IntWritable> reduceDriver;

	@Before
	public void setUp() {
		UserIDMapper uMapper = new UserIDMapper();
		UserIDReducer uReducer = new UserIDReducer();
		
		mapDriver = new MapDriver<LongWritable, Text, Text, IntWritable>();
		mapDriver.setMapper(uMapper);
		reduceDriver = new ReduceDriver<Text, IntWritable, Text,IntWritable>();
		reduceDriver.setReducer(uReducer);
		
		mapReduceDriver = new MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable>();
		mapReduceDriver.setMapper(uMapper);
		mapReduceDriver.setReducer(uReducer);
	}
}
