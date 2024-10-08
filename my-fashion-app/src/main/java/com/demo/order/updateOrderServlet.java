package com.demo.order;
import com.demo.User;
import com.demo.dao.*;

import com.demo.product.ProductDao;
import com.demo.utility.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
@WebServlet("/updateOrderServlet")
public class updateOrderServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("current-user");
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		
		JSONObject data = new JSONObject(sb.toString());
		
		String payment_id = data.getString("paymentId");
		String order_id = data.getString("orderId");
		String status = data.getString("status");
		int userid = user.getUserId();
		
		int checkUpdate = OrderDao.update(payment_id, order_id, status);
		if(checkUpdate > 0) {
		
			List<Cart> list = CartDao.getAllCartIteams(userid);
			
			for(Cart cart : list ) {
				int isUpdate = -1;
				
			 	ProductDao.updateQty(cart.getProduct_id(),cart.getQty());
			 	
			}
			CartDao.deleteAll(userid);
			
			
		}else {
			System.out.println("something went wrong in updating order");
		}
		
		
		
	}

}
