package com.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		PrintWriter out = response.getWriter();
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordHashing.doHashing(password));
		user.setAddress(address);
				
		int status = UserDao.save(user);
			
		if(status>0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("isLoggedIn", true);
			session.setAttribute("current-user",user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			
			dispatcher.forward(request, response);
			
		}else
		{
			
			out.write("somethimg is wrong");
		}
	}

}
