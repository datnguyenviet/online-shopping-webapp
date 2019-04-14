package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.Category;
public class CategoryDAO {

	public ArrayList<Category> getListCategory () throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "SELECT * FROM Category";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Category> list = new ArrayList<>();
		while(rs.next()) {
			Category category = new Category();
			category.setCategoryID(rs.getLong("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			list.add(category);
		}
		return list;
	}
	
	//Adding new data
	public boolean insertCategory(Category c) {
		Connection connection = DBConnect.getConnection();
		String sql = "INSERT INTO Category VALUES (?,?)";
		try {
			PreparedStatement ps = connection.prepareCall(sql);
			ps.setLong(1, c.getCategoryID());
			ps.setString(2, c.getCategoryName());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return false;
		
	}
	
	//Update data
	public boolean updateCategory(Category c) {
		Connection connection = DBConnect.getConnection();
		String sql =  "UPDATE Category SET category_name = ? WHERE category_id = ?";
		try {
			PreparedStatement ps = connection.prepareCall(sql);
			ps.setString(1, c.getCategoryName());
			ps.setLong(2, c.getCategoryID());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);

		}
		return false;
	}
	
	
	//Delete data
	public boolean deleteCategory(long category_id) {
		Connection connection = DBConnect.getConnection();
		String sql = "DELETE FROM Category WHERE category_id = ?";
		try {
			PreparedStatement ps = connection.prepareCall(sql);
			ps.setLong(1, category_id);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);

		}
		return false;
	}
	
	public static void main (String[] args) throws SQLException {
		CategoryDAO dao = new CategoryDAO(); 
		//for(int i=1; i < 10;i++) {
			//dao.insertCategory(new Category(i, "Category " + i));
		//}
		//System.out.println(dao.insertCategory(new Category(new Date().getTime(), "nhanvnguyen")));

	}
}
