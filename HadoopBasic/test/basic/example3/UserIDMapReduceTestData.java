package basic.example3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import de.basic.example3.BankTransactionJob;

public class UserIDMapReduceTestData {

	@Test
	public void test() throws Exception {
		BankTransactionJob mapjob = new BankTransactionJob();
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "file:///");
		conf.set("mapreduce.framework.name", "local");
		conf.setInt("mapreduce.task.io.mb", 1);
		
		Path input = new Path("testdata/bank_transactions_test.csv");
		Path output = new Path("testdata_output/output/bank");
		
		FileSystem fs = FileSystem.getLocal(conf);
		fs.delete(output, true);
		mapjob.setConf(conf);

		int exitCode = mapjob.run(new String[] {
				input.toString(), output.toString()
		});

		assertThat(exitCode, is(0));
	}
	
}
