<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <script src="https://kit.fontawesome.com/c13edee66d.js" crossorigin="anonymous"></script>
 <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title>Login</title>
<style>

</style>
</head>
<body>
   <div class="mb-5 pb-4">
     <%@ include file="./components/header.jsp" %>
 
   </div>  
   <div class="container-fluid mt-5 pt-5" >
      <div class="login-box pb-5" >
         <div class="login-title">
            <div class="text-center">
                <p>LOG IN</p>
            </div>
         </div>
         <div class="login-form">
            <form action="${pageContext.request.contextPath}/loginServlet" method="post" class="needs-validation" novalidate id="emailForm">
                <div class="mb-3 group ">
                   <input type="email" class="form-control login-inputs "  name="email" placeholder="Email Address" id="email" required>
                   <i class="icon fa-solid fa-envelope"></i>
                
                </div>
                <div class="mb-3  group">
                    <input type="password" class="form-control  login-inputs"  name="password"  placeholder="Password" required>
                    <i class="icon fa-solid fa-key"></i>
                </div>
               
                <button type="submit" class="btn btn-success w-100">Login</button>
            </form>
            
            <div class="error-message " style="font-size:.7rem ;color:red; padding-top:2px; margin-top: 5px; margin-left: 10px;">
                  <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
            </div>
            
         </div>
         <div class="login-form-footer d-flex justify-content-center">
            
            <div class="footer-items "><span>Not Registered User ? <a href="${pageContext.request.contextPath }/registor.jsp"> SIGN UP</a></span></div>
         </div>
     </div>
   </div>
  <%@ include file="./components/footer.jsp" %>
</body>
</html>


 