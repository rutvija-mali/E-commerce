<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title>Logout</title>
</head>
<body>
  <%@ include file="./components/header.jsp" %>
   <div class="container-fluid ps-3 " id="container">
        <div class="logout-1">
          <ul class="d-flex list-unstyled">
	           <li class="p-1"><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa-solid fa-house"></i></a></li>
	           <li class="p-1"><span>> </span><a href="${pageContext.request.contextPath}/profile.jsp">ACCOUNT</a></li>
	           <li class="p-1"><span>> </span><a href="index.jsp">LOGOUT</a></li>
          </ul>
        </div>
        <div class="container-fluid">
          <h2 >Account Logout</h2>
        <div class=" logout-para"><p>You have been logged off your account. It is now safe to leave the computer.</p></div>
        <div class=" logout-para"><p>Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account.</p></div>
        
        </div>
        
        <a href="index.jsp" class="btn btn-success p-2 ps-3 pe-3 ms-4" role="button" >Continue</a>
    </div>
  <%@ include file="./components/footer.jsp" %>
  
</body>
</html>