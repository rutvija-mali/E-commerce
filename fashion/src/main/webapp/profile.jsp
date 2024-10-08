<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/other/profile.css">
<%@ include file="../components/imports.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title>Profile</title>
</head>
<body>
   <%  
    User user = (User)session.getAttribute("current-user");
   
    if(user == null){
 	   response.sendRedirect("./login.jsp");
    }else
    {
    	
    %>
   <%@ include file="./components/header.jsp" %>
    <jsp:include page="/components/message.jsp"></jsp:include>
    <div class="container-lg   d-flex justify-content-center  " id="container" >
		 <div id="main-profile-container" >
		    <div class="border-bottom border-secondary border-opacity-25">
		      <h5 class="fw-bold lh-sm mb-0"><%=user.getUsername() %></h5>
		      <div class="mb-2"><small class="text-muted lh-sm mt-0 "><%=user.getEmail() %></small></div>
		    </div>
		    <div class="d-flex">
		      <div class="sidebar mb-1 border-end border-secondary border-opacity-25 ">
		          <ul class="list-unstyled" id="sidebar-user">
		            <li class="px-3 mt-2 py-3  border-bottom border-secondary border-opacity-10"><a href="./index.jsp">Home</a></li>
		            <li class="px-3 mt-2 py-3  border-bottom border-secondary border-opacity-10"><a href="./wishlist.jsp">Wishlist</a></li>
		            <li class="px-3 mt-2 py-3  border-bottom border-secondary border-opacity-10"><a href="#">Orders</a></li>
		            <li class="px-3 mt-2 py-3  border-bottom border-secondary border-opacity-10"><a href="./logout.jsp">Logout</a></li>
		            <li class="px-3 mt-2 py-3  border-bottom border-secondary border-opacity-10"><a href="./userFunctions/deleteUser.jsp?userId=<%= user.getUserId()%>">Delete</a></li>
		          </ul>
		      </div>
		      <div  id="main" class="border border-secondary border-opacity-25 mt-3 ms-3">
		        <div class="d-flex flex-column justify-content-center align-items-center m-md-3">
		          <div class="border-bottom border-secondary border-opacity-25 mb-2 py-3 px-3  w-100">
		            <h5 class="fw-bold lh-sm mb-0 text-center">Profile Details</h5>
		          </div>
		          <div class="table-responsive w-100">
		            <table class="table table-borderless text-start">
		              <tbody>
		                <tr>
		                  <td class=" w-50">
		                    Full Name 
		                  </td>
		                  <td class=" w-50" id="username">
		                    <%=user.getUsername()%>
		                  </td>
		                </tr>
		                <tr>
		                  <td class=" w-50">
		                    E-mail 
		                  </td>
		                  <td class=" w-50" id="email">
		                    <%=user.getEmail()%>
		                  </td>
		                </tr>
		                <tr>
		                  <td class=" w-50">
		                    Address 
		                  </td>
		                  <td class=" w-50">
		                    <%=user.getAddress()%>
		                  </td>
		                </tr>
		              </tbody>
		            </table>
		          </div>
		          <a class="btn btn-dark text-light w-50 mt-2" href="./profileEdit.jsp" role="button">Edit</a>
		        </div>
		      </div>
		
		    </div>
		 </div>
		</div>
	
	<%@ include file="./components/footer.jsp" %>
<%} %>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/cart.js"></script>
</body>
</html>