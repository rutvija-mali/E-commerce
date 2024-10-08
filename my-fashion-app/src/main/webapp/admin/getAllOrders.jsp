<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.order.MyOrder" %>
<%@ page import="com.demo.order.OrderDao" %>
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
   List <MyOrder> list = OrderDao.getAllOrders();
   request.setAttribute("list", list);
  
 %>
 <div class="container-fluid pt-2 " id="allProductDisplay">
  <div class="d-flex flex-column align-items-center ">
    <div class="">
      <h3>Order List</h3>
      
  </div>
  <div class="container-fluid table-responsive mt-3 " id="allProductsTableDiv">
    <table class="table table-hover ">
      <thead>
        <tr class="table-light">
          
                <th scope="col">Id</th>
                <th scope="col">User Id</th>
                <th scope="col">Order id</th>
                <th scope="col">Amount (INR)</th>
                <th scope="col">payment Id</th>
                <th scope="col">Status</th>
                <th scope="col">Receipt</th>
                
        </tr>
      </thead>
		  <tbody>
			   <c:forEach items="${list}" var="order">
					<tr scope="row">
						<td scope="col">${order.getMyOrderId()}</td>
						<td scope="col">${order.getUserid()}</td>
					    <td scope="col">${order.getOrderid()}</td>
					    <td scope="col">${order.getAmount()/100}</td>
						<td scope="col">${order.getPaymentid()}</td>
						<td scope="col">${order.getStatus()}</td>
						<td scope="col">${order.getReceipt()}</td>
						
						
					</tr>

			 </c:forEach>
		 </tbody>
     </table>
   </div>
  </div>
</div>

</body>
</html>