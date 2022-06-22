package de.basic.example2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JobExecuter extends Configured implements Tool{
	
	private static final Logger log = Logger.getLogger(JobExecuter.class.getName());
	
	public static void main(String[] args) {
		int res = 1; //Wenn 1 nicht verändert wird, endet der Job nicht korrekt
		
		try {
			res = ToolRunner.run(new Configuration(), new JobExecuter(), args);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, "Fehler beim Ausführen des MRJobs");
			e.printStackTrace();
		}
		System.exit(res);

	}

	public int run(String[] args) throws Exception {
		log.log(Level.INFO, "Starte Map-Reduce Job 'JobExecutor'....");
		//Wenn configured erweitert wird, kann die bestehende Konfiguration
		//per getConf erweitert werden.
		Configuration conf = this.getConf();
		
		Job job = null;
		
		try {
			job = Job.getInstance(conf);
			
		} catch(IOException e1) {
			log.log(Level.SEVERE, "Fehler bei Instanzieerung des Jobs");
			e1.printStackTrace();
		}
		
		//Hadoop soll ein verfügbares JAR verwenden, das die Klasse JobExecutor enthaelt.
		job.setJarByClass(JobExecuter.class);
		
		//Mapper und Reducer Klassen festlegen
		job.setMapperClass(GradesMapper.class);
		job.setReducerClass(GradesReducer.class);
		
		//Ausgabetypen festlegen
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(FloatWritable.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		//Pfad, von wo aus die Eingabedaten eingelesen werden solllen, werden 
		//beim aufruf der jar als erstes uebergeben
		try {
			FileInputFormat.addInputPath(job, new Path(args[0]));
			
		} catch(IllegalArgumentException e2) {
			log.log(Level.SEVERE, "Fehler (Argument) beim setzen des Eingabepfades");
			e2.printStackTrace();
		} catch(IOException e3) {
			log.log(Level.SEVERE, "Fehler (IO) beim setzen des Eingabepfades");
			e3.printStackTrace();
		}
		
		//Der Ausgabeordner wird als zweites Argument uebergeben
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		boolean result = false;
		
		try {
			//Führe den Job aus und warte, bis er beendet wurde
			result = job.waitForCompletion(true);
			
		} catch(ClassNotFoundException e) {
			log.log(Level.SEVERE, "Fehler (ClassNotFound) beim Ausführen des Jobs");
			e.printStackTrace();
		} catch(IOException e) {
			log.log(Level.SEVERE, "Fehler (IO) beim Ausführen des Jobs");
			e.printStackTrace();
		} catch(InterruptedException e) {
			log.log(Level.SEVERE, "Fehler (Interrupted) beim Ausführen des Jobs");
			e.printStackTrace();
		}
		
		log.log(Level.INFO, "Fertig");
		return result ? 0: 1;
	}

}
