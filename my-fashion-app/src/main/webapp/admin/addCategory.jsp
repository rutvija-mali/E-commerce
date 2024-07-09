<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.User" %>
 
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/other/addCategory.css" >
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

  <jsp:include page="./admin.jsp"></jsp:include>
  <jsp:include page="/components/message.jsp"></jsp:include>
   <div class="container-fluid" id="addCategory">
   
       <div class="d-flex flex-column align-items-center ">
            <div class="d-flex align-items-center mt-3 ms-2">
                <h3>Category</h3>
                <span class="text-secondary ms-3">Add New Category</span>
            </div>
            <div class=" pt-3 p-4 mt-4" id="addCategoryFormDiv">
               <form action="${pageContext.request.contextPath }/functionsForCategory/saveCategory.jsp" method="post">
                  <div class="mb-3" >
                    <label for="exampleInputCategoryName" class="form-label">Category</label>
                     <input type="text" class="form-control " name="category_name" id="exampleInputCategoryName" aria-describedby="categoryName" placeholder="Enter Category " required>
                     <div id="error-massage" class="form-text d-none">Please enter the  Category</div>
                  </div>
                   <div class="mb-3 d-flex justify-content-center align-items-center">
                     <button type="submit" class="btn btn-dark w-50 mt-3" id="addProduct">Submit</button>
                   </div>
               </form>
            </div>
        </div>
    </div>
  

</body>
</html>