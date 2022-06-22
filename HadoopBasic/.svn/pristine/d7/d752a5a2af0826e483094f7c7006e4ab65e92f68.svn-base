package de.basic.example2;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class GradesReducer extends Reducer<IntWritable, IntWritable, IntWritable,
	FloatWritable> {
	
	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		//Summiere alle Noten eines Jahres auf
		float sum = 0;
		int count = 0;
		
		for(IntWritable val: values) {
			sum += val.get();
			count +=1;
		}
		
		//Und bilde den Durchschnitt
		float result = sum / count;
		
		//Schriebe den Durchschnitt fuer das Jahr in key
		context.write(key, new FloatWritable(result));
	}

}
