package com.demo.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.ConnectionClass;
import com.demo.product.Product;


public class CategoryDao {

	 /**
     * Saves a new category to the database.
     * 
     * @param category The Category object to be saved.
     * @return The status of the operation: 1 if successful, -1 if failed.
     */

	public static int save(Category category) {
		int status = -1;
	
		try (Connection con = ConnectionClass.getConnctionMethod();
		     PreparedStatement ps = con.prepareStatement("INSERT INTO categories(category_name) VALUES(?)")) {
			
			 ps.setString(1, category.getCategory_name());
			 
			 status = ps.executeUpdate();
			 
			} catch (Exception e) {
			   e.printStackTrace();
			}
		
		
		
		
		return status;
	}
	
     public static Category getCategory( int category_id) 
     {
    	 Category category = null;
    	 try(Connection con = ConnectionClass.getConnctionMethod();
    		 PreparedStatement ps = con.prepareStatement("SELECT * FROM categories WHERE category_id  =?"); 
    		 ){
    		   ps.setInt(1, category_id);
    		 
    		 ResultSet rs = ps.executeQuery() ;
    		 if(rs.next()) {
    			category = new Category();
				category.setCategory_id(rs.getInt(1));
				category.setCategory_name(rs.getString(2));
			}
    	 
    	 }catch (Exception e) {
			e.printStackTrace();
		}
    	 return category;
	 }
 
    public static List<Category> getCategories()
    {
    	 
    	 List<Category> list = new ArrayList<>();
    	 try(Connection con = ConnectionClass.getConnctionMethod();
    		 PreparedStatement ps = con.prepareStatement("SELECT * FROM categories"); 
    		 ResultSet rs = ps.executeQuery()	 ){
    		 
    		 while (rs.next()) {
    			Category category = new Category();
				category.setCategory_id(rs.getInt(1));
				category.setCategory_name(rs.getString(2));
				list.add(category);
			}
    	 
    	 }catch (Exception e) {
			e.printStackTrace();
		}
		return list;
    	
    }

    public static int deleteCategory(int category_id)
    {
    	 System.out.println("category id in dao class"+category_id);
    	int status = -1;
    	 try(Connection con = ConnectionClass.getConnctionMethod();
    		 PreparedStatement ps = con.prepareStatement("DELETE FROM categories WHERE category_id =?");){
    		 ps.setInt(1,category_id);
    		 status = ps.executeUpdate();
    		
    	 
    	 }catch (Exception e) {
			e.printStackTrace();
		}
		return status;
    	
    }

	public static int update(Category category) {
		int status = -1;
		String query = "UPDATE categories SET category_name = ? where category_id = ?";
		
		try( Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement(query);){
			   
			
			ps.setString(1,category.getCategory_name());
			ps.setInt(2,category.getCategory_id());
			
			
	          status = ps.executeUpdate();
			
		} catch (SQLException e) {
			 System.err.println("SQL Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return status;
	}






}
