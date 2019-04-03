package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static void main (String[] args) throws SQLException {
		CategoryDAO dao = new CategoryDAO(); 
		for(Category ds: dao.getListCategory()) {
			System.out.println(ds.getCategoryID() + " -- " + ds.getCategoryName());
		}
	}
}
