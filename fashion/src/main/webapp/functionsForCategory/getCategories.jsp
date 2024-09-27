<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.User" %>
 <%@ page import="com.demo.category.Category" %>
 <%@ page import="com.demo.category.CategoryDao" %>
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
    }else if(user.getRole().equals("customer")){
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
   List <Category> list =  CategoryDao.getCategories();
   request.setAttribute("list", list);
   
 %>
 <div class="container-fluid pt-2 " id="CategoriesDisplay">
  <div class="d-flex flex-column align-items-center ">
    <div class="">
      <h3>Categories List</h3>
      
  </div>
  <div class="container-fluid table-responsive mt-3 " id="CategoriesTableDiv">
    <table class="table table-hover ">
      <thead>
        <tr class="table-light">
          
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Update</th> 
                <th scope="col">Delete</th> 
                
        </tr>
      </thead>
		  <tbody>
			   <c:forEach items="${list}" var="category">
					<tr scope="row">
						<td scope="col">${category.getCategory_id()}</td>
						<td scope="col">${category.getCategory_name() }</td>
					   
						<td scope="col">
						  <span class="nav-link active">
						       <a href="${pageContext.request.contextPath }/admin/editCategory.jsp?id=${category.getCategory_id()}" class="active">
							      <i class="fa-solid fa-pen-to-square"></i>
							   </a>
						  </span>
						</td>
						<td scope="col">
						    <a href="${pageContext.request.contextPath }/functionsForCategory/delete.jsp?category_id=${category.getCategory_id()}">
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