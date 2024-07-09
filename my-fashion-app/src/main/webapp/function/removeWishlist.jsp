<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/other/product.css">
<%@ include file="../components/imports.jsp" %>
<%@page import="com.demo.utility.Wishlist"%>
<%@page import="com.demo.dao.wishlistDao"%>
 <% 
       User user = (User)session.getAttribute("current-user");
       
       int product_id = 0;
       
       if(user == null){
    	   response.sendRedirect("../login.jsp");
       }else{
         
	     
		   product_id = Integer.parseInt(request.getParameter("product_id"));
		   int userid = user.getUserId();
		  
		   boolean exist = wishlistDao.isProductExist(product_id,userid );
		   if(exist){
			   int status = wishlistDao.deleteItem(userid, product_id);
			   System.out.println("Status : "+status);
			   if(status > 0){
				   
				   response.sendRedirect("../wishlist.jsp");
				  
			   }
			 }else{
				   response.sendRedirect("../wishlist.jsp");
				  
			   }
		  }
	%>	