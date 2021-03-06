package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.Users;

public class UsersDAO {

	//Check whether email exists or not
	public boolean checkEmail(String email){
		Connection connection = DBConnect.getConnection();
		String sql = "SELECT * FROM users WHERE user_email = '"+email+"'";
		PreparedStatement ps;
		try {
			ps = connection.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				connection.close();
				return true;
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
		
		
	}
	
	//Adding account method
	public boolean insertUser(Users u) {
		Connection connection = DBConnect.getConnection();
		String sql = "INSERT INTO users VALUE(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareCall(sql);
			ps.setLong(1, u.getUserID());
			ps.setString(2, u.getUserEmail());
			ps.setString(3, u.getUserPass());
			ps.setBoolean(4, u.isUserRole());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	//Checking login 
	public Users login(String email, String password) {
		Connection con = DBConnect.getConnection();
		String sql = "SELECT * FROM users WHERE user_email='" + email + "' and user_pass='" + password + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Users u = new Users();
				u.setUserID(rs.getLong("user_id"));
				u.setUserEmail(rs.getString("user_email"));
				u.setUserPass(rs.getString("user_role"));
				u.setUserRole(rs.getBoolean("user_role"));
				con.close();
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Users getUser(Long userID) {
		try {
		Connection connection = DBConnect.getConnection();
		String sql = "SELECT * FROM users WHERE user_id = ?";
		PreparedStatement ps = connection.prepareCall(sql);
		ps.setLong(1, userID);
		ResultSet rs = ps.executeQuery();
		Users u = new Users();
		while(rs.next()) {
			u.setUserEmail(rs.getString("user_email"));
		}
	} catch (SQLException ex) {
		Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
		return null;
	}
}
