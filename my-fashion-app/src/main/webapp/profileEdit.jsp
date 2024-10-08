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
<title>Edit profile</title>
<style >
#edit-form{
  
  width:100%;
  marign-left:20px;
  
}
#edit-form input{
 
  width:100%;
  
}
#edit-form form{
   
    padding: 30px 15px 20px 15px;
    padding-bottom: 25px;
}
</style>
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
    <div class="container-lg   d-flex justify-content-center  " id="container" >
		 <div id="main-profile-container" >
		    <div class="border-bottom border-secondary border-opacity-25">
		      <h5 class="fw-bold lh-sm mb-0">Account</h5>
		      <div class="mb-2"><small class="text-muted lh-sm mt-0 ">Rutvija Mali</small></div>
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
		          <div id="edit-form" class="d-flex justify-content-center align-items-center "> 
		             <div class="d-flex flex-column justify-content-center align-items-center m-md-3 w-100">
		                 <div class="border-bottom border-secondary border-opacity-25 mb-2 py-3 px-3  w-100">
					            <h5 class="fw-bold lh-sm mb-0 text-center">Profile Details</h5>
					          </div>
				              <form action="${pageContext.request.contextPath}/userFunctions/updateUser.jsp?id=${user.getUserId()}" method="post" class="needs-validation w-100 d-flex flex-column justify-content-center align-items-center" novalidate >
		                        <div class="mb-3 group w-75 d-none">
				                  <input type="text" class="form-control register-input "  name="userId" value=<%=user.getUserId()%> id="username" >
				                   <i class="icon fa-regular fa-user "></i>
				                    
				                </div>
				                <div class="mb-3 group w-75">
				                  <input type="text" class="form-control register-input "  name="username" value=<%=user.getUsername()%> id="username" >
				                   <i class="icon fa-regular fa-user "></i>
				                    
				                </div>
				                <div class="mb-3 group w-75">
				                    <input type="email" class="form-control register-input"  name="email" value=<%=user.getEmail()%> >
				                    <i class="icon fa-regular fa-envelope "></i>
				                    
				                </div>
				               
				                <div class="mb-3 group w-75">
				                    <input type="text" class="form-control register-input" name="address"  value=<%=user.getAddress()%>  >
				                    <i class="icon  fa-solid fa-house "></i>
				                     
				                </div>
				                <button type="submit" class="btn btn-dark text-light w-25">save</button>
				            </form>
		          
		               </div>
		          </div>
		          
		        </div>
		      </div>
		
		    </div>
		 </div>
		</div>
	
	<%@ include file="./components/footer.jsp" %>
<% } %>
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
</body>
</html>