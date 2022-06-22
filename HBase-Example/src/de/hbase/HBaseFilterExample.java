package de.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.util.Bytes;
/**
 * 
 * @author norman
 *
 */
public class HBaseFilterExample {
	
	public static void main(String[] args) {
		
			Configuration conf = HBaseConfiguration.create();
			HTable table;
			try {
				table = new HTable(conf, "retailstore");

				Scan scan = new Scan();

				//scanning based on row id
				Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, 
						new BinaryComparator(Bytes.toBytes("1200")));
				scan.setFilter(filter);

				ResultScanner resultScanner =  table.getScanner(scan);
				
				for(Result r: resultScanner) {
					for(Cell c : r.listCells()) {
						String row = new String(CellUtil.cloneRow(c));
						String family = new String(CellUtil.cloneFamily(c));
						String column = new String(CellUtil.cloneQualifier(c));
						String value = new String(CellUtil.cloneValue(c));
						long timestamp = c.getTimestamp();
						System.out.printf("%-20s column=%s:%s, timestamp = %s, "
								+ "value = %s", row, family, column, timestamp, value + "\n");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	

}
