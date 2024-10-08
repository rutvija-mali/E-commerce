package com.demo.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.ConnectionClass;

public class OrderDao {
	
	public static int save(MyOrder order) {
		int status = -1;
		
		try( Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("INSERT INTO orders(amount,payment_id,receipt,status,userid,orderId) VALUES(?,?,?,?,?,?)")
			){
			
			  ps.setInt(1,order.getAmount());
			  ps.setString(2,order.getPaymentid());
			  ps.setString(3,order.getReceipt());
			  ps.setString(4,order.getStatus());
			  ps.setInt(5,order.getUserid());
			  ps.setString(6,order.getOrderid());
			  
			  status = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	public static int update(String payment_id,String  order_id,String status) {
		int done = -1;
		
		try( Connection con = ConnectionClass.getConnctionMethod();
			 PreparedStatement ps = con.prepareStatement("UPDATE orders SET payment_id=?,status=? WHERE orderId = ? ")
			){
			
			  ps.setString(1,payment_id);
			  ps.setString(2,status);
			  ps.setString(3,order_id);
			  
			 done = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return done;
		
	}

	public static List<MyOrder> getAllOrders(){
		
		List<MyOrder> list = new ArrayList<MyOrder>();
		
		try( Connection con = ConnectionClass.getConnctionMethod();
				 PreparedStatement ps = con.prepareStatement("SELECT * FROM orders")
				){
				
			   try(ResultSet rs = ps.executeQuery()){
				   while(rs.next()) {
					   MyOrder order = new MyOrder();
					   order.setAmount(rs.getInt(1));
					   order.setPaymentid(rs.getString(2));
					   order.setReceipt(rs.getString(3));
					   order.setStatus(rs.getString(4));
					   order.setUserid(rs.getInt(5));
					   order.setOrderid(rs.getString(6));
					   order.setMyOrderId(rs.getInt(7));
					   
					   list.add(order);
				   }
				   
			   }
			   
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		
		
		
		return list;
	}
}
