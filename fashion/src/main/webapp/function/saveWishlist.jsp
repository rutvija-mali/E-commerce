<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/other/product.css">
<%@ include file="../components/imports.jsp" %>
<%@page import="com.demo.utility.Wishlist"%>
<%@page import="com.demo.dao.wishlistDao"%>
   <% 
       User user = (User)session.getAttribute("current-user");
       String action = request.getParameter("action");
      
       int product_id = 0;
       
       if(user == null){
    	   response.sendRedirect("../login.jsp");
       }else{
         
	     
		   product_id = Integer.parseInt(request.getParameter("product_id"));
		   int userid = user.getUserId();
		   Wishlist wish =  new Wishlist();
		   wish.setProduct_id(product_id);
		   wish.setUserId(userid);
		   boolean exist = wishlistDao.isProductExist(product_id,userid );
		   if(action.equals("save")&&  !exist ){
			  
			   int status = wishlistDao.saveWhishlist(wish);
			  
			   if(status > 0){
				   
				   response.sendRedirect("../product.jsp?category=all");
				  
			   }
			 }else{
				   response.sendRedirect("../product.jsp?category=all");
				  
			   }
		  }
		
		
		
     
   %>