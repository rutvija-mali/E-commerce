<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.User" %>
 <%@ include file="../components/common.jsp" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/other/admin.css" >
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


 <nav class="navbar navbar-expand-lg bg-dark text-lightborder-bottom border-light-subtle position-fixed z-3 top-0 w-100">
    <div class="container-fluid  ">
      <!-- btn-toggler offcanvas -->
      <div class="me-4 me-lg-0">
        <button class="navbar-toggler" data-bs-toggle="offcanvas" data-bs-target="#bd-sidebar" aria-controls="bd-sidebar" >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
        <a class="navbar-brand text-light fw-bold text-uppercase ms-0" href="#">
           Admin Panel
        </a>
       
        <div class="dropdown admin-navbar-dropdown mt-2 mt-lg-0 ">
          <svg xmlns="http://www.w3.org/2000/svg" width="30" height="32" fill="currentColor" class="bi bi-person dropdown-toggle me-3"
          style="color: whitesmoke;" data-bs-toggle="dropdown" aria-expanded="false" viewBox="0 0 16 16">
            <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
          </svg>
          <ul class="dropdown-menu" id="admin-dropdown-menu">
		   <% 
			    Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
			    System.out.print(isLoggedIn);
			    if (isLoggedIn != null && isLoggedIn) {
			%>
				<li>
					<form action="${pageContext.request.contextPath }/logoutServlet" method="post">
					  <button class="dropdown-item" type="submit">Logout</button>
					</form>
			    </li>				          
			<%
			    } else {
			%>  
				<li><a class="dropdown-item" href="login.jsp">Login</a></li>				       
			<%
			    }
			%>	
      
          </ul>
        </div>
      </div>
      
    
  </nav>

<!-- sidebar offcanvas -->

<aside>
    <div class="offcanvas offcanvas-start text-bg-dark sidebar " tabindex="-1" id="bd-sidebar" aria-labelledby="bd-sidebarLabel">
      <div class="offcanvas-header">
        <button type="button " class="btn-close d-lg-none d-block  text-bg-danger text-danger" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body p-0">
        <nav class="navbar-dark ">
          <ul class="navbar-nav">
            <li class="mt-2">
              <a href="${pageContext.request.contextPath }/admin/dashboard.jsp" class="nav-link px-3 active">
                <span class="me-2"><i class="fa-solid fa-chart-line"></i></span> 
                <span>Dashboard</span>
              </a>
            </li>
            <li class="mt-2">
              <a href="${pageContext.request.contextPath }/function/getAllProducts.jsp" class="nav-link px-3 active">
                <span class="me-2 text-light"><i class="fa-solid fa-boxes-stacked"></i></span> 
                <span>Products</span>
              </a>
            </li>
            <li class="mt-2">
              <a href="${pageContext.request.contextPath }/functionsForCategory/getCategories.jsp"  class="nav-link px-3 active">
                <span class="me-2 text-light"><i class="fa-solid fa-tag"></i></span> 
                <span>Categories</span>
              </a>
            </li>
            <li class="mt-2">
              <a href="${pageContext.request.contextPath }/admin/getAllOrders.jsp" class="nav-link px-3 active">
                <span class="me-2 text-light"><i class="fa-solid fa-clipboard"></i></span> 
                <span>View Orders</span>
              </a>
            </li>
            
            <li class="mt-2">
              <a href="${pageContext.request.contextPath }/admin/getAllUsers.jsp"  class="nav-link px-3 active">
                <span class="me-2 text-light"><i class="fa-solid fa-users"></i></i></span> 
                <span>Users</span>
              </a>
            </li>
           
            
          </ul>
        </nav>
      </div>
    </div>
</aside>
  <!-- card -->



				            
					            
					        
