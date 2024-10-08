package com.demo.dao;
import com.demo.utility.Wishlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.ConnectionClass;
import com.demo.utility.Wishlist;

public class wishlistDao {
    
	public static int saveWhishlist(Wishlist wish) {
		int status = -1;
		try(Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("INSERT INTO wishlist(userid,product_id) VALUES(?,?) ")
			){
			  ps.setInt(1, wish.getUserId());
			  ps.setInt(2,wish.getProduct_id());;
			  status = ps.executeUpdate();
			  
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("problem in saving product : "+e.getMessage());;
		}
		
		return status;
	}
	
	public static List<Wishlist> getAllWishlistIteams(int userid){
		List<Wishlist> list = new ArrayList<Wishlist>();
		
		try( Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM wishlist WHERE userid=?");
			 ){
			 ps.setInt(1, userid);
			 
			 try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Wishlist wish = new Wishlist();
					wish.setUserId(rs.getInt("userid"));
					wish.setProduct_id(rs.getInt("product_id"));
					list.add(wish);
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
				 PreparedStatement ps = con.prepareStatement("DELETE FROM wishlist WHERE userid=? AND product_id=?")
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
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM wishlist WHERE userid=? AND product_id=? LIMIT 1");
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
		
		 System.out.println("EXIST PRODUCT IN WISHLIST : "+exist);
		   return exist;
	}
	
	public static int getTotalWhistlistProducts(int userid) {
		int total = 0;
		try(Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS total FROM wishlist WHERE userid = ? ")
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
