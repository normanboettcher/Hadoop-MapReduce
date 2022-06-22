package de.basic.example1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString(); // converting input value to string
		
		if(value != null && !(line.equals(""))) {
			
			String[] splits = line.trim().split("\\W+"); // trimming and splitting the words in a line
					
			for(String outputKey:splits) {
				// writing the words to context class
				context.write(new Text(outputKey), new IntWritable(1));
			}
		}
		
	}
}
