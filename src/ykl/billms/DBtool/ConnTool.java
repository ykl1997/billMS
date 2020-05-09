package ykl.billms.DBtool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTool {
	private static String url = "jdbc:mysql://localhost:3306/billms";
	private static String usename = "root";
	private static String password = "123456";
	private static Connection con = null;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, usename, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
