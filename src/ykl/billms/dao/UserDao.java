package ykl.billms.dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import ykl.billms.DBtool.ConnTool;
import ykl.billms.model.User;

public class UserDao {

	public static boolean SelectByname(String username) {
		Connection con = ConnTool.getCon();
		try {
			Statement statement = con.createStatement();
			String sql = "select * from t_user where username='" + username + "'";
			if (statement.executeQuery(sql).next() == true) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	public static void addUesr(User user) {
		Connection con = ConnTool.getCon();
		String sql = "insert into t_user(username,password) value(?,?)";
		try {
			PreparedStatement prepareSt = con.prepareStatement(sql);
			prepareSt.setString(1, user.getUsername());
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte[] digest = md5.digest(user.getPassword().getBytes("utf-8"));
			String encode = Base64.getEncoder().encodeToString(digest);
			prepareSt.setString(2, encode);
			prepareSt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static User checkPassword(String username) throws SQLException {
		Connection con = ConnTool.getCon();
		Statement statement = con.createStatement();
		String sql = "select * from t_user where username='" + username + "'";
		ResultSet executeQuery = statement.executeQuery(sql);
		executeQuery.next();
		User user = new User();
		user.setId(executeQuery.getInt("id"));
		user.setPassword(executeQuery.getString("password"));
		user.setUsername(executeQuery.getString("username"));
		return user;

	}

}
