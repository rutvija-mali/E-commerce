package com.demo.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.demo.ConnectionClass;
import com.demo.User;


public class ProductDao {
	

    /**
     * Saves a new product to the database.
     * 
     * @param product The Product object to be saved.
     * @return The status of the operation: 1 if successful, -1 if failed.
     */

	public static int save(Product product) {
		int status = -1;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionClass.getConnctionMethod();
			String query = "INSERT INTO product(product_name,image_url,description,price,gender,color,size,stock_qty,category_name,original_price,discount) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			
              ps = con.prepareStatement(query);
			
			ps.setString(1, product.getProduct_name());
			ps.setString(2,product.getImage());
			ps.setString(3,product.getProduct_desc());
			ps.setInt(4, product.getProduct_price());
			ps.setString(5,product.getGender() );
			ps.setString(6,product.getProduct_color() );
			ps.setInt(7, product.getProduct_size());
			ps.setInt(8,product.getProduct_qty());
			ps.setString(9,product.getProduct_category());
			ps.setInt(10,product.getOriginal_price());
			ps.setInt(11,product.getDiscount());
			
			status = ps.executeUpdate();
			
		} catch (SQLException e) {
			 System.err.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				
				
				if(con != null )con.close();
				if(ps != null)ps.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
	 /**
     * Retrieves a product from the database by its ID.
     * 
     * @param product_id The ID of the product to retrieve.
     * @return The Product object if found, or null if not found.
     */

	public static Product getProduct(int product_id) {
		Product product = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			
			 con = ConnectionClass.getConnctionMethod();
			String query = "SELECT * FROM product WHERE product_id =?";
			
			 ps = con.prepareStatement(query);
			ps.setInt(1, product_id);
			
		    rs = ps.executeQuery();
			
			if(rs.next())
			{
				product = new Product();
				product.setId(rs.getInt(1));
				product.setProduct_name(rs.getString(2));
				product.setImage(rs.getString(3));
				product.setProduct_desc(rs.getString(4));
				product.setProduct_price(rs.getInt(5));
				product.setGender(rs.getString(6));
				product.setProduct_color(rs.getString(7));
				product.setProduct_size(rs.getInt(8));
				product.setProduct_qty(rs.getInt(9));
				product.setProduct_category(rs.getString(10));
				product.setOriginal_price(rs.getInt(11));
				product.setDiscount(rs.getInt(12));
			}
			
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					if(rs != null)rs.close();
					if(ps != null) ps.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		System.out.print("product  :"+product);
		return product;
		
	}
	
	 /**
     * Retrieves all products from the database.
     * 
     * 
     * @return The list.
     */
	
	public static List<Product> getAllProducts()
	{    Product product = null;
		 Connection con = null;
		 PreparedStatement ps = null;
	     ResultSet rs = null;
	    
	      List<Product> list = new ArrayList();
	     try {
			con = ConnectionClass.getConnctionMethod();
			ps = con.prepareStatement("SELECT * FROM product");
			
			rs = ps.executeQuery();
		
			while (rs.next()) {
				
				product = new Product();
				product.setId(rs.getInt(1));
				product.setProduct_name(rs.getString(2));
				product.setImage(rs.getString(3));
				product.setProduct_desc(rs.getString(4));
				product.setProduct_price(rs.getInt(5));
				product.setGender(rs.getString(6));
				product.setProduct_color(rs.getString(7));
				product.setProduct_size(rs.getInt(8));
				product.setProduct_qty(rs.getInt(9));
				product.setProduct_category(rs.getString(10));
				product.setOriginal_price(rs.getInt(11));
				product.setDiscount(rs.getInt(12));
				
				list.add(product);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					if(rs != null)rs.close();
					if(ps != null) ps.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	     
	     return list;
		
	}
	

    /**
     * Deletes a product from the database by its ID.
     * 
     * @param product_id The ID of the product to delete.
     * @return The 1 if found, or null if not found -1.
     */
	public static int deleteProduct(int product_id) {
		Product product = null;
		Connection con = null;
		PreparedStatement ps = null;
		int status = -1;
		try {
			
			
			 con = ConnectionClass.getConnctionMethod();
			String query = "DELETE FROM product WHERE product_id =?";
			
			 ps = con.prepareStatement(query);
			 ps.setInt(1, product_id);
			
		    status = ps.executeUpdate();
			
			
			
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					
					if(ps != null) ps.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return status;
		
	}
	
	
	public static int update(Product product) {
		int status = -1;
		
		String query =  "UPDATE product SET product_name=?, image_url=?, description=?, price=?, gender=?, color=?, size=?, stock_qty=?, category_name=? ,original_price =?,discount=? WHERE product_id=?";
		
		try( Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement(query);){
	
			ps.setString(1, product.getProduct_name());
			ps.setString(2,product.getImage());
			ps.setString(3,product.getProduct_desc());
			ps.setInt(4, product.getProduct_price());
			ps.setString(5,product.getGender() );
			ps.setString(6,product.getProduct_color() );
			ps.setInt(7, product.getProduct_size());
			ps.setInt(8,product.getProduct_qty());
			ps.setString(9,product.getProduct_category());
			ps.setInt(10,product.getOriginal_price());
			ps.setInt(11,product.getDiscount());
			ps.setInt(12, product.getId());
			
	          status = ps.executeUpdate();
			
		} catch (SQLException e) {
			 System.err.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public static List<Product> getPerticulerProducts(String category)
	{    Product product = null;
		 Connection con = null;
		 PreparedStatement ps = null;
	     ResultSet rs = null;
	      List<Product> list = new ArrayList();
	     try {
			con = ConnectionClass.getConnctionMethod();
			ps = con.prepareStatement("SELECT * FROM product WHERE category_name =?");
			ps.setString(1, category);
			rs = ps.executeQuery();
			
		
			while (rs.next()) {
				
				product = new Product();
				product.setId(rs.getInt(1));
				product.setProduct_name(rs.getString(2));
				product.setImage(rs.getString(3));
				product.setProduct_desc(rs.getString(4));
				product.setProduct_price(rs.getInt(5));
				product.setGender(rs.getString(6));
				product.setProduct_color(rs.getString(7));
				product.setProduct_size(rs.getInt(8));
				product.setProduct_qty(rs.getInt(9));
				product.setProduct_category(rs.getString(10));
				product.setOriginal_price(rs.getInt(11));
				product.setDiscount(rs.getInt(12));
				
				list.add(product);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					if(rs != null)rs.close();
					if(ps != null) ps.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	     
	     return list;
		
	}
	
	public static HashSet<String> getColors()
	{
		 Product product = null;
		 HashSet<String> set = new HashSet<String>();
		try(Connection con = ConnectionClass.getConnctionMethod();
		    PreparedStatement ps = con.prepareStatement("SELECT color FROM product");
		    ResultSet rs  = ps.executeQuery();){
			
			while(rs.next())
			{
				set.add(rs.getString("color"));
			}
			
		}catch (SQLException e) {
	        // Handle the exception (e.g., log it or throw a custom exception)
	        e.printStackTrace();
	    }
		return set;
	}
	
	public static int updateQty( int product_id ,int qty) {
		
		
		int status = -1;
		try(Connection con =  ConnectionClass.getConnctionMethod(); 
		    PreparedStatement ps = con.prepareStatement("UPDATE product SET stock_qty = stock_qty - ? WHERE product_id = ? AND stock_qty > 0");
			
		  ){
			ps.setInt(1, qty);
		    ps.setInt(2, product_id);
		    
		    status = ps.executeUpdate();
		  		
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("something went wrong" + e.getMessage());
		}
		
		System.out.println("status of updateQTY : "+ status);
		return status;
	}
	
	public static List<Product> getSearchedProduct(String query)
	{    Product product = null;
		
	      List<Product> list = new ArrayList();
	     try (
	    	 Connection con = ConnectionClass.getConnctionMethod();
	    	 PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE MATCH(product_name,description,color,category_name) AGAINST(?)");
	    		
			){
	    	    System.out.println("searched query : "+query);
	    	       ps.setString(1, query);
	    	    try(ResultSet rs = ps.executeQuery()){
		
						while (rs.next()) {
							
							product = new Product();
							product.setId(rs.getInt(1));
							product.setProduct_name(rs.getString(2));
							product.setImage(rs.getString(3));
							product.setProduct_desc(rs.getString(4));
							product.setProduct_price(rs.getInt(5));
							product.setGender(rs.getString(6));
							product.setProduct_color(rs.getString(7));
							product.setProduct_size(rs.getInt(8));
							product.setProduct_qty(rs.getInt(9));
							product.setProduct_category(rs.getString(10));
							product.setOriginal_price(rs.getInt(11));
							product.setDiscount(rs.getInt(12));
							
							list.add(product);
							
						}
	    	    }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("error in sql "+e.getMessage());
		}
	     return list;
	 }
}