<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.demo.category.CategoryDao" %>
  <%@page import="com.demo.category.Category" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="category" class="com.demo.category.Category"></jsp:useBean>

 <jsp:setProperty property="*" name="category"/>
   <% 
     
	     try {
	         int status = CategoryDao.update(category);
	         if (status > 0) {
	        	 
	           
	             session.setAttribute("message","Category updated successfully!");
	             response.sendRedirect("./getCategories.jsp");
	         } 
	     } catch (Exception e) {
	         out.println("<p>Database error: " + e.getMessage() + "</p>");
	         e.printStackTrace(); // Print stack trace for debugging
	     }
  %>

</body>
</html>