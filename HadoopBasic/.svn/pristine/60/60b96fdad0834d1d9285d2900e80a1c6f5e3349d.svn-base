package de.basic.example3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UserIDMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] values = value.toString().split(",");
		Text id = null;
		final IntWritable count = new IntWritable(1);
		if(values[0].compareTo("\"UserId\"") != 0) {
			id = new Text(values[0]);
			context.write(id, count);
		}
	}

}
