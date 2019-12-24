package com.rest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.rest.utils.model.UserObject;

public class UserDAO {
	private static SQLconnection factory = new SQLconnection();

	public static UserObject login(String username, String password) throws ClassNotFoundException {
		ResultSet res = null;
		UserObject user = null;
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT * FROM user WHERE username=? AND password=?";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			preStmt.setString(1, username);
			preStmt.setString(2, password);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				user = new UserObject();
				user.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				user.setUsername(res.getObject("username") != null ? res.getObject("username").toString() : "");
				user.setPassword(res.getObject("password").toString() != null ? res.getObject("password").toString() : "");
				user.setEmail(res.getObject("email").toString() != null ? res.getObject("email").toString() : "");
				user.setAddress(res.getObject("address").toString() != null ? res.getObject("address").toString() : "");
				user.setRole(res.getObject("role").toString() != null ? Integer.valueOf(res.getObject("role").toString()) : 0);
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return user;
	}

	public static String deleteUser(String id) throws ClassNotFoundException {
		String result = "KO";
		PreparedStatement preStmt = null;
		String sqlQuery = "DELETE FROM user WHERE id='" + id + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			preStmt.executeUpdate();
			preStmt.close();
			result = "OK";
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return result;
	}

	public static int getNumberUserByName(String name) throws ClassNotFoundException {
		int result = 0;
		ResultSet res = null;
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT COUNT(*) AS 'TOTAL' From user where username = '" + name + "'";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			if (res != null && res.next()) {
				result = res.getInt("TOTAL");
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return result;
	}

	public static int insertUser(UserObject user) throws ClassNotFoundException {
		int id = 0;
		ResultSet res = null;
		PreparedStatement preStmt = null;
		String sqlQuery = "Insert Into user(username, password, email, address) values('" + user.getUsername() + "','" + user.getPassword() + "','"
				+ user.getEmail() + "','" + user.getAddress() + "')";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			preStmt.executeUpdate();
			res = preStmt.getGeneratedKeys();
			id = res.getInt(1);
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return id;
	}

	public static String updateUser(UserObject user) throws ClassNotFoundException {
		String result = "KO";
		PreparedStatement preStmt = null;
		String sqlQuery = "UPDATE user SET password=?, email =?, address=?, role=? WHERE username=?";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			preStmt.setString(1, user.getPassword());
			preStmt.setString(2, user.getEmail());
			preStmt.setString(3, user.getAddress());
			preStmt.setInt(4, user.getRole());
			preStmt.setString(5, user.getUsername());
			preStmt.executeUpdate();
			preStmt.close();
			result = "OK";
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return result;
	}

	public static List<UserObject> getListAllUser() throws ClassNotFoundException {
		ResultSet res = null;
		List<UserObject> users = new ArrayList<UserObject>();
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT * FROM user";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				UserObject tmpUser = new UserObject();
				tmpUser.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				tmpUser.setUsername(res.getObject("username").toString() != null ? res.getObject("username").toString() : "");
				tmpUser.setPassword(res.getObject("password").toString() != null ? res.getObject("password").toString() : "");
				tmpUser.setEmail(res.getObject("email").toString() != null ? res.getObject("email").toString() : "");
				tmpUser.setAddress(res.getObject("address").toString() != null ? res.getObject("address").toString() : "");
				tmpUser.setRole(res.getObject("role").toString() != null ? Integer.valueOf(res.getObject("role").toString()) : null);

				users.add(tmpUser);
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return users;
	}

	public static List<UserObject> getAllPage(int start, int display) throws ClassNotFoundException {
		ResultSet res = null;
		List<UserObject> users = new ArrayList<UserObject>();
		PreparedStatement preStmt = null;
		String sqlQuery = "SELECT * FROM user ORDER BY id LIMIT " + start + "," + display + "";
		try {
			preStmt = factory.getConnectionDB().prepareStatement(sqlQuery);
			res = preStmt.executeQuery();
			while (res != null && res.next()) {
				UserObject tmpUser = new UserObject();
				tmpUser.setId(res.getObject("id").toString() != null ? Integer.valueOf(res.getObject("id").toString()) : null);
				tmpUser.setUsername(res.getObject("username").toString() != null ? res.getObject("username").toString() : "");
				tmpUser.setPassword(res.getObject("password").toString() != null ? res.getObject("password").toString() : "");
				tmpUser.setEmail(res.getObject("email").toString() != null ? res.getObject("email").toString() : "");
				tmpUser.setAddress(res.getObject("address").toString() != null ? res.getObject("address").toString() : "");
				tmpUser.setRole(res.getObject("role").toString() != null ? Integer.valueOf(res.getObject("role").toString()) : null);

				users.add(tmpUser);
			}
			preStmt.close();
		} catch (SQLException e) {
			System.out.print(e.toString());
		}
		return users;
	}

}
