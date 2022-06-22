package de.basic.example1;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import de.basic.base.MapJobBase;
import de.basic.example2.JobExecuter;

public class WordCountDriver extends MapJobBase implements Tool {
	
	private static final Logger log = Logger.getLogger(JobExecuter.class.getName());
	/**
	* @param args
	*/
	public static void main(String[] args) throws Exception {
		
		int res = 1; //Wenn 1 nicht verändert wird, endet der Job nicht korrekt

		try {
			res = ToolRunner.run(new Configuration(), new WordCountDriver(), args);

		} catch (Exception e) {
			log.log(Level.SEVERE, "Fehler beim Ausführen des MRJobs");
			e.printStackTrace();
		}
		System.exit(res);
	}

	public int run(String[] args) throws Exception {
		log.log(Level.INFO, "Starte Map-Reduce Job 'JobExecutor'....");
		setLogger(log);
		initJob();
		//Used for debug purpose
		getJob().setJobName("WordCount-Example1");
		getJob().setJarByClass(WordCountDriver.class);
		// configuration of all the file starts from here
		getJob().setMapperClass(WordCountMapper.class);
		getJob().setCombinerClass(WordCountReducer.class);
		getJob().setReducerClass(WordCountReducer.class);
		//Set the type of Output Key/Value
		getJob().setOutputKeyClass(Text.class);
		getJob().setOutputValueClass(IntWritable.class);
		getJob().setMapOutputKeyClass(Text.class);
		getJob().setMapOutputValueClass(IntWritable.class);
		getJob().setInputFormatClass(TextInputFormat.class);
		getJob().setOutputFormatClass(TextOutputFormat.class);

		initStandardPaths(args);
		
		log.log(Level.INFO, "Fertig");
		return getResult() ? 0: 1;
		}
}