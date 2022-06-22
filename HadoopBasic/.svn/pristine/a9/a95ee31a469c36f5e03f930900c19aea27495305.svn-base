package de.basic.example2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GradesMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
	
	private IntWritable year_int = null;
	private IntWritable grade_int = null;
	
	public void map(LongWritable key, Text value, Context context) throws IOException,
		InterruptedException {
	
		//Auslesen des Jahres und der Note aus einem String
		String year_str = value.toString().substring(10, 14);
		String grade_str = value.toString().substring(14,15);
		
		year_int = new IntWritable(Integer.parseInt(year_str));
		grade_int = new IntWritable(Integer.parseInt(grade_str));
		
		//sammlen der Ergebnisse
		context.write(year_int, grade_int);
	}
	
	
}
