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
       System.out.println("user in saveCart : "+user);
       int product_id = 0;
       
       if(user == null){
    	   response.sendRedirect("../login.jsp");
       }else{
         
	     
		   product_id = Integer.parseInt(request.getParameter("product_id"));
		   int userid = user.getUserId();
		  
		   Cart cart = new Cart();
		   cart.setProduct_id(product_id);
		   cart.setUserId(userid);
		   boolean exist = CartDao.isProductExist(product_id, userid);
				   
		   if(action.equals("save")&&  !exist ){
			  
			   int status = CartDao.saveCart(cart);
			  
			   if(status > 0){
				   
				   response.sendRedirect("../product.jsp?category=all");
				  
			   }
			 }else{
				   response.sendRedirect("../product.jsp?category=all");
				  
			   }
		  }
		
		
		
     
   %>