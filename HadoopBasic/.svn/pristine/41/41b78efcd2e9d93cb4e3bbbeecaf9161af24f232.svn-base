package de.basic.example3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UserIDReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context) 
			throws IOException, InterruptedException {
		int sum = 0;
		
		for(IntWritable val: values) {
			sum += val.get();
		}
		//Removing "" from key
		Text key_final = new Text(key.toString().substring(1, key.toString().length() - 1));
		context.write(key_final, new IntWritable(sum));
	}
}
