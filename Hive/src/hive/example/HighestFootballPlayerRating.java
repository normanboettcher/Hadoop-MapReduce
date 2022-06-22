package hive.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HighestFootballPlayerRating {

	private static final String DRIVERNAME = "org.apache.hive.jdbc.HiveDriver";

	private static Connection getConn() {
		try {
			Class.forName(DRIVERNAME);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hive2://localhost:10000/football", "", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	private static void printQuery(String s, Connection con) {
		try {
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(s);
			
			while(res.next()) {
				System.out.println(res.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Connection con = getConn();
		printQuery("select team_long_name from team", con);
	}

}
