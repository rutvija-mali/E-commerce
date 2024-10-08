package com.demo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	   User user = (User)session.getAttribute("current-user");
	   String username = user.getUsername();
	   String email = user.getEmail();
	   
	   JSONObject userObj = new JSONObject();
	   userObj.put("email", email);
	   userObj.put("name", username);
	   
	   response.getWriter().write(userObj.toString());
	
	   
	   
	   
	   
	 
	
	}

}
