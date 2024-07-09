<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.demo.category.Category" %>
 <%@ page import="com.demo.category.CategoryDao" %>
  
    <jsp:useBean id="category" class="com.demo.category.Category"></jsp:useBean>
    
    <jsp:setProperty property="*" name="category"/>

    <% 
    System.out.println("category id in delete class"+category.getCategory_id());
	     try {
	         int status = CategoryDao.deleteCategory(category.getCategory_id());;
	         if (status > 0) {
	        	 
	           
	             session.setAttribute("message","Category deleted successfully!");
	             response.sendRedirect("./getCategories.jsp");
	         } 
	     } catch (Exception e) {
	         out.println("<p>Database error: " + e.getMessage() + "</p>");
	         e.printStackTrace(); // Print stack trace for debugging
	     }
  %>

