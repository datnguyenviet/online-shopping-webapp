package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.DBConnect;
import model.Product;

public class ProductDAO {
	
	public ArrayList<Product> getListProductByCategory(long category_id) throws SQLException{
		Connection connection = DBConnect.getConnection();
		String sql = "SELECT * FROM product WHERE category_id = '"+category_id+"'";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Product> list = new ArrayList<>();
		while(rs.next()) {
			Product product = new Product();
			product.setProductID(rs.getLong("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductPrice(rs.getDouble("product_price"));
			product.setProductDescription(rs.getString("product_description"));
			list.add(product);
		}
		return list;
		
	}
	
	public Product getProduct(long productID) throws SQLException {
		Connection connection = DBConnect.getConnection();
		String sql = "SELECT * FROM product WHERE product_id = '"+productID+"'";
		PreparedStatement ps = connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		Product product = new Product();
		while(rs.next()) {
			product.setProductID(rs.getLong("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductPrice(rs.getDouble("product_price"));
			product.setProductDescription(rs.getString("product_description"));
		}
		return product;
		
	}
	
	public static void main(String []args) throws SQLException {
		ProductDAO dao = new ProductDAO();
		//for(Product p: dao.getListProductByCategory(2)) {
			//System.out.println(p.getProductID() + " - "+ p.getProductName());
		
		//}
		System.out.println(dao.getProduct(1).getProductImage());
	
		
	}
}
