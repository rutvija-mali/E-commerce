<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/other/resistor.css" >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

    <title>Document</title>
<title>Insert title here</title>

</head>
<body>
   
   <div class="mb-5 pb-4">
     <%@ include file="./components/header.jsp" %>
 
   </div>  
   <div class="container-fluid " id="register-container">
    <div class="login-box pb-5" id="form-container">
        <div class="register-title">
            <div class="text-center">
                <p>Signup with</p>
            </div>
        </div>
       <div class="login-form">
            <form action="${pageContext.request.contextPath}/register" method="post" class="needs-validation" novalidate>
               
                <div class="mb-3 group ">
                  <input type="text" class="form-control register-input "  name="username" placeholder="Enter Your Name*" id="username" cc>
                   <i class="icon fa-regular fa-user "></i>
                   <div class="error-message " id="usernameError">*Please enter your name.</div> 
                </div>
                <div class="mb-3 group">
                    <input type="email" class="form-control register-input"  name="email"  placeholder="Your Email Address*" required >
                    <i class="icon fa-regular fa-envelope "></i>
                    <div class="error-message" id="emailError">*Please enter a valid email address.</div>
                </div>
                <div class="mb-3 group">
                    <input type="password" class="form-control register-input" name="password" id="password" placeholder="Choose Your Password*" required minlength="8" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}" title="Password must contain at least one number, one uppercase letter, one lowercase letter, and one special character">
                    <i class="icon fa-solid fa-lock"></i>
                    <div class="error-message" id="passwordError">Password must be 8+ chars, include a number, an uppercase letter, a lowercase letter, and a special character.</div>
                
                </div>
                <div class="mb-3 group">
                    <input type="password" class="form-control register-input" name="confirmPassword" id="confirm_password" placeholder="Confirm Your Password*" required oninput="checkPasswordMatch(this)">
                    <i class="icon fa-solid fa-lock"></i>
                     <div class="error-message" id="confirmPasswordError">*Passwords must match.</div>
                </div>
                <div class="mb-3 group">
                    <input type="text" class="form-control register-input" name="address"  placeholder="Enter Your Address*" required >
                    <i class="icon  fa-solid fa-house "></i>
                     <div class="error-message" id="addressError">*Please enter your address.</div>
                </div>
                <button type="submit" class="btn btn-success w-100">REGISTER</button>
            </form>
           
       </div>
       <div class="login-bottom">
        <div class="text-center">
            <span>Already Register ? 
                <a href="login.jsp"> LOG IN</a>
                <!-- redirect link needs to add -->
            </span>
        </div>
    </div>
    </div>
   </div>



















    <script>
      (() => {
    	  'use strict'

    	 
    	  const forms = document.querySelectorAll('.needs-validation')
        
    	  
    	  Array.from(forms).forEach(form => {
    	    form.addEventListener('submit', event => {
    	      if (!form.checkValidity()) {
    	        event.preventDefault()
    	        event.stopPropagation()
    	      }

    	      form.classList.add('was-validated');
    	      displayErrorMessages();
    	    }, false)
    	  })
    	})();
      
        function displayErrorMessages(form){
    	  let inputs = document.querySelectorAll('.register-input');
    	  
    	   inputs.forEach((input)=>{
    		   let errorElement = document.getElementById(input.name+"Error");
    		   
    		   if(errorElement && !input.validity.valid){
              let icon = input.nextElementSibling;
            
    			   errorElement.style.display = 'block';
                   display(errorElement.display,icon);
            
    		   }else{
    			   errorElement.style.display = 'none';
    		   }
    			   
    		
    		   
    	   })
      }
	   function display(display,icon)
     {
      let formContainer = document.getElementById('form-container')
      
           console.log(formContainer);
           formContainer.style.height = "81vh"
           icon.style.position = 'absolute';
           icon.style.top = '19%'
     }
      
    
      </script>
<%@ include file="./components/footer.jsp" %>
      
</body>
</html>


