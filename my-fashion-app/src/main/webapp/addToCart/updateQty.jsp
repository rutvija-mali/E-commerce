<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/other/product.css">
<%@ include file="../components/imports.jsp" %>
<%@page import="com.demo.utility.Wishlist"%>
<%@page import="com.demo.dao.wishlistDao"%>
   <% 
       User user = (User)session.getAttribute("current-user");
       
       System.out.println("user in updateCart : "+user);
      
       
       if(user == null){
    	   response.sendRedirect("../login.jsp");
       }else{
         
	     int qty = Integer.parseInt(request.getParameter("product_qty"));  
		 int  product_id = Integer.parseInt(request.getParameter("product_id"));
		   int userid = user.getUserId();
		   boolean exist = CartDao.isProductExist(product_id,userid);
				   
		   if(exist){
			  
			   int status = CartDao.updateQty(userid, product_id,qty);
			  
			   if(status > 0){
				   
				   response.sendRedirect("../addtocart.jsp?category=all");
				  
			   }
			 }else{
				   response.sendRedirect("../addtocart.jsp?category=all");
				   System.out.println("something went wrong");
			   }
		  }
		
		
		
     
   %>