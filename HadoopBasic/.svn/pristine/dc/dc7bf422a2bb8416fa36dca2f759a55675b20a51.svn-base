package basic.example1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import de.basic.example1.WordCountDriver;

public class WordCountOnTestData {

	@Test
	public void test() {
		WordCountDriver driver = new WordCountDriver();
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "file:///");
		conf.set("mapreduce.framework.name", "local");
		conf.setInt("mapreduce.task.io.mb", 1);
		
		Path input = new Path("testdata/ba_thesis_test_data.txt");
		Path output = new Path("testdata_output/output/words");
		
		try {
			FileSystem fs = FileSystem.getLocal(conf);
			fs.delete(output, true);
			driver.setConf(conf);
			
			int exitCode = driver.run(new String[] {
					input.toString(), output.toString()
			});
			
			assertThat(exitCode, is(0));
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
