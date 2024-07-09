<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="../components/imports.jsp" %>
 

    
    

      <% 
       int userid = Integer.parseInt(request.getParameter("userId"));
	     try {
	         int status = UserDao.deleteUser(userid);
	         if (status > 0) {
	        	 
	           
	             session.setAttribute("message","User data deleted successfully!");
	             response.sendRedirect("../index.jsp");
	         } 
	     } catch (Exception e) {
	         out.println("<p>Database error: " + e.getMessage() + "</p>");
	         e.printStackTrace(); // Print stack trace for debugging
	     }
  %>