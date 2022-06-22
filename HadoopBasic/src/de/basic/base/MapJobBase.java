package de.basic.base;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public abstract class MapJobBase extends Configured {
	protected Configuration conf;
	protected Job job;
	protected boolean result; 
	protected Logger log;
	
	/**
	 * 
	 */
	protected void initJob() {
		//Wenn configured erweitert wird, kann die bestehende Konfiguration
		//per getConf erweitert werden.
		this.conf = this.getConf();

		this.job = null;

		try {
			this.job = Job.getInstance(getConfig());
		} catch(IOException e1) {
			getLogger().log(Level.SEVERE, "Fehler bei Instanziierung des Jobs");
			e1.printStackTrace();
		}
	}
	/**
	 * 
	 * @param args
	 */
	protected void initStandardPaths(String[] args) {
		//Pfad, von wo aus die Eingabedaten eingelesen werden solllen, werden 
		//beim aufruf der jar als erstes uebergeben
		try {
			FileInputFormat.addInputPath(getJob(), new Path(args[0]));

		} catch(IllegalArgumentException e2) {
			getLogger().log(Level.SEVERE, "Fehler (Argument) beim setzen des Eingabepfades");
			e2.printStackTrace();
		} catch(IOException e3) {
			getLogger().log(Level.SEVERE, "Fehler (IO) beim setzen des Eingabepfades");
			e3.printStackTrace();
		}

		//Der Ausgabeordner wird als zweites Argument uebergeben
		FileOutputFormat.setOutputPath(getJob(), new Path(args[1]));
		this.result = false;

		try {
			//Führe den Job aus und warte, bis er beendet wurde
			this.result = getJob().waitForCompletion(true);

		} catch(ClassNotFoundException e) {
			getLogger().log(Level.SEVERE, "Fehler (ClassNotFound) beim Ausführen des Jobs");
			e.printStackTrace();
		} catch(IOException e) {
			getLogger().log(Level.SEVERE, "Fehler (IO) beim Ausführen des Jobs");
			e.printStackTrace();
		} catch(InterruptedException e) {
			getLogger().log(Level.SEVERE, "Fehler (Interrupted) beim Ausführen des Jobs");
			e.printStackTrace();
		}	
	}
	
	protected boolean getResult() {
		return this.result;
	}
	
	
	protected void setLogger(final Logger log) {
		this.log = log;
	}
	
	private Logger getLogger() {
		return this.log;
	}
	
	protected Job getJob() {
		return this.job;
	}
	
	protected Configuration getConfig() {
		return this.conf;
	}
	
}
