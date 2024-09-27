<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.User" %>
<%@ page import="com.demo.UserDao" %>
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
   List <User> list =  UserDao.getAllUsers();
   request.setAttribute("list", list);
   
 %>
 <div class="container-fluid pt-2 " id="allProductDisplay">
  <div class="d-flex flex-column align-items-center ">
    <div class="">
      <h3>Users List</h3>
      
  </div>
  <div class="container-fluid table-responsive mt-3 " id="allProductsTableDiv">
    <table class="table table-hover ">
      <thead>
        <tr class="table-light">
          
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Address</th>
                
        </tr>
      </thead>
		  <tbody>
			   <c:forEach items="${list}" var="user">
					<tr scope="row">
						<td scope="col">${user.getUserId()}</td>
						<td scope="col">${user.getUsername()}</td>
					    <td scope="col">${user.getEmail()}</td>
						<td scope="col">${user.getAddress()}</td>
						
					</tr>

			 </c:forEach>
		 </tbody>
     </table>
   </div>
  </div>
</div>

</body>
</html>