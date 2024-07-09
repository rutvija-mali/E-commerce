package com.demo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class UserDao {

	public static int save(User user) {
		int status = -1;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionClass.getConnctionMethod();
			String query = "INSERT INTO user(username,email,password,address) VALUES(?,?,?,?)";
			
              ps = con.prepareStatement(query);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAddress());
			
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
	
	public static User getUser(String email) {
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			
			 con = ConnectionClass.getConnctionMethod();
			String query = "SELECT * FROM user WHERE email =?";
			
			 ps = con.prepareStatement(query);
			ps.setString(1, email);
			
		    rs = ps.executeQuery();
			
			if(rs.next())
			{
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(3));
				user.setAddress(rs.getString(5));
				user.setRole(rs.getString(6));
			}
			
		    
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(rs != null)
				try {
					if(rs != null)rs.close();
					if(ps != null) ps.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return user;
		
	}


	public static String getPassword(String email)
	{
		String password = null;
		 Connection con = null;
		 PreparedStatement ps = null;
	     ResultSet rs = null;
		
		try {
			 con = ConnectionClass.getConnctionMethod();
			 ps = con.prepareStatement("SELECT password FROM user WHERE email =?");
			ps.setString(1,email);
			
			 rs = ps.executeQuery();
			if(rs.next())
			{
				 password = rs.getString("password"); 
				 
			}else
			{
				 System.out.println("No user found with the given email.");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(rs != null)
				try {
					if(rs != null)rs.close();
					if(ps != null) ps.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return password;
	}
	
	public static List<User> getAllUsers()
	{
		 Connection con = null;
		 PreparedStatement ps = null;
	     ResultSet rs = null;
	    List<User> list = new ArrayList();
	     try {
			con = ConnectionClass.getConnctionMethod();
			ps = con.prepareStatement("SELECT * FROM user");
			rs = ps.executeQuery();
		
			while (rs.next()) {
				User user =new User();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
				
				list.add(user);
				
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
	
    public static boolean emailExist(String email)
    {

		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 boolean exist = false;
		 try {
			con = ConnectionClass.getConnctionMethod();
			 ps = con.prepareStatement("SELECT * FROM user WHERE email =?");
			 ps.setString(1, email);
			 
			 rs = ps.executeQuery();
			 exist = rs.next();
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
		
		 
    	
    	return exist;
    }
    
    public static int updateUser(User user) {
    	System.out.println("user object for user upadte : "+user);
    	int status = -1;
    	try( Connection con = ConnectionClass.getConnctionMethod();
    		 PreparedStatement ps = con.prepareStatement("UPDATE user SET username=?,email=?,address=? WHERE userid=?");
    		){
    		System.out.println(user.getUsername()+" "+ user.getEmail()+" "+ user.getAddress()+" "+user.getUserId());
    		ps.setString(1,user.getUsername());
    		ps.setString(2, user.getEmail());
    		ps.setString(3, user.getAddress());
    		ps.setInt(4, user.getUserId());
    		
    	   status = ps.executeUpdate();
    		
    	}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR MSG : "+e.getMessage());
		}
    	System.out.println("status for user upadte : "+status);
    	return status;
    }
    
    public static int deleteUser(int userid) {
    	int status = -1;
    	try( Connection con = ConnectionClass.getConnctionMethod();
       		 PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE userid=?");
       		){
    		ps.setInt(1, userid);
    		status = ps.executeUpdate();
    		
    	}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR MSG : "+e.getMessage());
		}
    	System.out.println("status for user upadte : "+status);
		return status;
    	
    	
    }
}
