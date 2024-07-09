package com.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String errorMessage = null;
		RequestDispatcher dispatch = null;
	    boolean exist = UserDao.emailExist(email);
	    User user = null;
		
		if(email == null || email.trim().isEmpty()) {
			errorMessage = "Email cannot be empty.";
		}else if(!exist)
		{
			 errorMessage = "Email does not exist.";
		}
		if( errorMessage != null) {
			forwardWithError(request, response, errorMessage);
			return;
		}else {
			 user = UserDao.getUser(email);
		}
		
		
	    String pass = UserDao.getPassword(email.trim());
		if(pass.equals(passwordHashing.doHashing(password)))
		{
			
			session.setAttribute("isLoggedIn", true);
			 if(user != null) {
				 session.setAttribute("current-user",user);
			 }
			if(user.getRole()!= null && user.getRole().equals("customer")) {
				dispatch = request.getRequestDispatcher("/index.jsp");
				dispatch.forward(request, response);
			}else
			{
			   dispatch = request.getRequestDispatcher("/admin/dashboard.jsp");
			   dispatch.forward(request, response);
			}
			
		}else
		{
			errorMessage = "Wrong password";
			forwardWithError(request, response, errorMessage);
			return;
			
		}
		
		
		
		
	}
	
	private void forwardWithError(HttpServletRequest request,HttpServletResponse response,String errorMessage) {
		request.setAttribute("errorMessage", errorMessage);
		RequestDispatcher dispatch = request.getRequestDispatcher("/login.jsp");
		try {
			dispatch.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

}
