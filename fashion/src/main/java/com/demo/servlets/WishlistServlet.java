package com.demo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/whishlistServlet")
public class WishlistServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
         PrintWriter out = response.getWriter();
		
		 String action = request.getParameter("action");
		 System.out.println(action);
		 
		 int userid = Integer.parseInt(request.getParameter("userid"));
		 int product_id = Integer.parseInt(request.getParameter("product_is"));
		 
		 out.print(userid + product_id);
	}
	
	

}
