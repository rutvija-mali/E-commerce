 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="../components/imports.jsp" %>
 
 <jsp:useBean id="user" class="com.demo.User"></jsp:useBean>
    
    <jsp:setProperty property="*" name="user"/>

      <% 
     
	     try {
	         int status = UserDao.updateUser(user);
	         if (status > 0) {
	        	 
	           
	             session.setAttribute("message","User data updated successfully!");
	             response.sendRedirect("../profile.jsp");
	         } 
	     } catch (Exception e) {
	         out.println("<p>Database error: " + e.getMessage() + "</p>");
	         e.printStackTrace(); // Print stack trace for debugging
	     }
  %>