package de.basic.example3;

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


public class BankTransactionJob extends MapJobBase implements Tool {
	
	private static final Logger log = Logger.getLogger(BankTransactionJob.class.getName());
	
	public static void main(String[] args) {
		int res = 1; //Wenn 1 nicht verändert wird, endet der Job nicht korrekt
		
		try {
			res = ToolRunner.run(new Configuration(), new BankTransactionJob(), args);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, "Fehler beim Ausführen des MRJobs");
			e.printStackTrace();
		}
		System.exit(res);
	}
	
	@Override
	public int run(String[] args) throws Exception {
		setLogger(log);
		
		log.log(Level.INFO, "Starte Map-Reduce Job 'BankTransactionJob'....");
		
		//
		initJob();
		
		//Hadoop soll ein verfügbares JAR verwenden, das die Klasse JobExecutor enthaelt.
		getJob().setJarByClass(BankTransactionJob.class);
		
		//Mapper und Reducer Klassen festlegen
		getJob().setMapperClass(UserIDMapper.class);
		getJob().setCombinerClass(UserIDReducer.class);
		getJob().setReducerClass(UserIDReducer.class);
		
		//Ausgabetypen festlegen
		getJob().setMapOutputKeyClass(Text.class);
		getJob().setMapOutputValueClass(IntWritable.class);
		getJob().setOutputKeyClass(Text.class);
		getJob().setOutputValueClass(IntWritable.class);
		getJob().setInputFormatClass(TextInputFormat.class);
		getJob().setOutputFormatClass(TextOutputFormat.class);
		
		//
		initStandardPaths(args);
		
		log.log(Level.INFO, "Fertig");
		return getResult() ? 0: 1;
	}

}
