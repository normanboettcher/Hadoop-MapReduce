package basic.example2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import de.basic.example2.JobExecuter;

public class Example2OnTestDataTest {

	@Test
	public void test() {
		JobExecuter mapjob = new JobExecuter();
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "file:///");
		conf.set("mapreduce.framework.name", "local");
		conf.setInt("mapreduce.task.io.mb", 1);
		
		Path input = new Path("testdata/mr_student_data_test.txt");
		Path output = new Path("testdata_output/output");
		
		try {
			FileSystem fs = FileSystem.getLocal(conf);
			fs.delete(output, true);
			mapjob.setConf(conf);
			
			int exitCode = mapjob.run(new String[] {
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
