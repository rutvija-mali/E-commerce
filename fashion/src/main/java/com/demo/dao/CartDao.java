package com.demo.dao;
import com.demo.product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.demo.ConnectionClass;
import com.demo.utility.Cart;
import com.demo.utility.Wishlist;

public class CartDao {

	public static int saveCart(Cart cart) {
		int status = -1;
		try(Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("INSERT INTO addtocart(userid,product_id) VALUES(?,?) ")
			){
			  ps.setInt(1, cart.getUserId());
			  ps.setInt(2,cart.getProduct_id());;
			  status = ps.executeUpdate();
			  
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("problem in saving product : "+e.getMessage());;
		}
		
		return status;
	}
	
	public static List<Cart> getAllCartIteams(int userid){
		List<Cart> list = new ArrayList<Cart>();
		
		try( Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM addtocart WHERE userid=?");
			 ){
			 ps.setInt(1, userid);
			 
			 try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Cart cart = new Cart();
					cart.setUserId(rs.getInt("userid"));
					cart.setQty(rs.getInt("qty"));
					cart.setProduct_id(rs.getInt("product_id"));
					list.add(cart);
				}
			 }
				
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());;
			}
		return list;
	}
	
	public static int deleteItem(int userid , int product_id) {
		int status = -1;
		try(Connection con = ConnectionClass.getConnctionMethod();
				 PreparedStatement ps = con.prepareStatement("DELETE FROM addtocart WHERE userid=? AND product_id=?")
			){
			ps.setInt(1, userid);
			ps.setInt(2, product_id);
			status = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static boolean isProductExist(int product_id, int userid) {
      boolean exist = false;
		ResultSet rs =null;
		try( Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM addtocart WHERE userid=? AND product_id=? LIMIT 1");
			){
			 ps.setInt(1,userid);
			 ps.setInt(2, product_id);
			 rs = ps.executeQuery();
			
				 exist = rs.next();
			
			
				
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("problem in getting product id :"+e.getMessage());;
			}finally {
				
					try {
						if(rs !=null) rs.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
		
		
		   return exist;
	}
	
	public static List<Product>getAllProducts(int userid) {
		List<Product> list = new ArrayList<Product>();
		try(Connection con =  ConnectionClass.getConnctionMethod();
		    PreparedStatement ps = con.prepareStatement("SELECT p.*,c.qty FROM product p JOIN addtocart c ON p.product_id = c.product_id WHERE c.userid=?")
		  ){
			ps.setInt(1, userid);
		   
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Product product = new Product();
					product.setId(rs.getInt("product_id"));
					product.setProduct_name(rs.getString("product_name"));
					product.setImage(rs.getString("image_url"));
					product.setProduct_desc(rs.getString("description"));
					product.setProduct_price(rs.getInt("price"));
					product.setGender(rs.getString("gender"));
					product.setProduct_color(rs.getString("color"));
					product.setProduct_size(rs.getInt("size"));
					product.setProduct_qty(rs.getInt("qty"));
					product.setProduct_category(rs.getString("category_name"));
					product.setOriginal_price(rs.getInt("original_price"));
					product.setDiscount(rs.getInt("discount"));
					list.add(product);
				}
			}
		   
					
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("something went wrong" + e.getMessage());
		}
		
		
		return list;
	}
	
	public static int getQty(int userid, int product_id) {
		int qty = -1;
		try(Connection con =  ConnectionClass.getConnctionMethod();
		    PreparedStatement ps = con.prepareStatement("SELECT qty  WHERE userid=? AND product_id=?");
			
		  ){
			
			ps.setInt(1, userid);
		    ps.setInt(2, product_id);
		
		    try(ResultSet rs = ps.executeQuery()){
		    	while (rs.next()) {
					qty = rs.getInt(qty);
					
				}
		    }
					
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("something went wrong" + e.getMessage());
		}
		
		System.out.println("status of qty : "+qty);
		return qty;
	}
	
	public static int updateQty(int userid, int product_id , int qty) {
		int status = -1;
		try(Connection con =  ConnectionClass.getConnctionMethod();
		    PreparedStatement ps = con.prepareStatement("UPDATE addtocart SET qty = ? WHERE userid = ? AND product_id = ?");
			
		  ){
			ps.setInt(1, qty);
			ps.setInt(2, userid);
		    ps.setInt(3, product_id);
		    
		    status = ps.executeUpdate();
		  		
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("something went wrong" + e.getMessage());
		}
		
		System.out.println("status of updateQTY : "+ status);
		return status;
	}
	
	public static int deleteAll(int userid) {
		int status = -1;
		try(Connection con = ConnectionClass.getConnctionMethod();
				 PreparedStatement ps = con.prepareStatement("DELETE FROM addtocart WHERE userid=?")
			){
			ps.setInt(1, userid);
			
			status = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	public static int getTotalCartProducts(int userid) {
		int total = 0;
		try(Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS total FROM addtocart WHERE userid = ? ")
			){
			    ps.setInt(1, userid);
				try(ResultSet rs = ps.executeQuery()){
				    if(rs.next()) {
				    	total = rs.getInt("total");
				    }
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}
}
