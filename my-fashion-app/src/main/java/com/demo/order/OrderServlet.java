package com.demo.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONObject;

import com.demo.User;
import com.razorpay.Order;
import com.razorpay.OrderClient;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("current-user");
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		
		JSONObject object = new JSONObject(sb.toString());
		String amountString = object.getString("price");
		int amount = Integer.parseInt(amountString);

		
		
		JSONObject ob = new JSONObject();

		  ob.put("amount",amount*100); 
		  ob.put("currency","INR");
		  ob.put("receipt","tnx_123456");
		  
		  
		
		 
		  
		  try {
			RazorpayClient client = new RazorpayClient("rzp_test_yVDgRhYuDx3lXm","jq8wpYMxqhbZbgvy3K6nyigh");
			
			Order order = client.Orders.create(ob);

			 
			MyOrder ordersave = new MyOrder();
			ordersave.setAmount(order.get("amount"));
			ordersave.setOrderid(order.get("id"));
			ordersave.setPaymentid(null);
			ordersave.setReceipt(order.get("receipt"));
			ordersave.setStatus(order.get("status"));
			ordersave.setUserid(user.getUserId());
			
			int status = OrderDao.save(ordersave);
			if(status > 0) {
				System.out.println("Data order save successfuly");
			}else {
				System.out.println("something went wrong in saving iorder");
			}
			  
			if(order !=null) {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(order.toString());

					
				}
			
		} catch (RazorpayException e) {
			
			e.printStackTrace();
		}
        
		  
		

	}

}
