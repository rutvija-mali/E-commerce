<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.demo.product.Product" %>
 <%@ page import="com.demo.product.ProductDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <jsp:useBean id="product" class="com.demo.product.Product"></jsp:useBean>
    
    <jsp:setProperty property="*" name="product"/>

      <% 
     
	     try {
	         int status = ProductDao.deleteProduct(product.getId());
	         if (status > 0) {
	        	 
	           
	             session.setAttribute("message","Product deleted successfully!");
	             response.sendRedirect("./getAllProducts.jsp");
	         } 
	     } catch (Exception e) {
	         out.println("<p>Database error: " + e.getMessage() + "</p>");
	         e.printStackTrace(); // Print stack trace for debugging
	     }
  %>

</body>
</html>