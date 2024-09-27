<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.User" %>
<%@ page import="com.demo.product.Product" %>
<%@ page import="com.demo.product.ProductDao" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/other/table.css" >
<%
   User user = (User)session.getAttribute("current-user");
    if(user == null)
    {
    	// send msg
    	response.sendRedirect("login.jsp");
    	return;
    }else if(user.getRole() == "customer"){
    	// send msg
    	response.sendRedirect("login.jsp");
    	return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
 <jsp:include page="../admin/admin.jsp"></jsp:include>
 <jsp:include page="/components/message.jsp"></jsp:include>
 
 <% 
   List <Product> list =  ProductDao.getAllProducts();
   request.setAttribute("list", list);
   
 %>
 <div class="container-fluid " id="allProductDisplay">
  <div class="d-flex flex-column align-items-center ">
    <div class="">
      <h3>Products List</h3>
      
  </div>
  <div class="container-fluid table-responsive  " id="allProductsTableDiv">
    <table class="table table-hover ">
      <thead>
        <tr class="table-light">
          
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Image</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Gender</th>
                <th scope="col">Color</th>
                <th scope="col">Size</th>
                <th scope="col">Quantity</th>
                <th scope="col">Category Name</th> 
                <th scope="col">Update</th> 
                <th scope="col">Delete</th> 
        </tr>
      </thead>
		  <tbody>
			   <c:forEach items="${list}" var="product">
					<tr scope="row">
						<td scope="col">${product.getId() }</td>
						<td scope="col">${product.getProduct_name() }</td>
					    <td scope="col">${product.getImage() }</td>
						<td scope="col">${product.getProduct_desc()}</td>
						<td scope="col">${product.getProduct_price() }</td>
						<td scope="col">${product.getGender() }</td>
					    <td scope="col">${product.getProduct_color() }</td>
					    <td scope="col">${product.getProduct_size() }</td>
						<td scope="col">${product.getProduct_qty()}</td>
						<td scope="col">${product.getProduct_category()}</td>
						<td scope="col">
						  <span class="nav-link active">
						       <a href="${pageContext.request.contextPath }/admin/editProduct.jsp?id=${product.getId()}" class="active">
							      <i class="fa-solid fa-pen-to-square"></i>
							   </a>
						  </span>
						</td>
						<td scope="col">
						    <a href="./delete.jsp?id=${product.getId()}">
						      <i class="fa-solid fa-trash"></i>
						   </a>
						</td>
						



					</tr>

			 </c:forEach>
		 </tbody>
     </table>
   </div>
  </div>
</div>

</body>
</html>