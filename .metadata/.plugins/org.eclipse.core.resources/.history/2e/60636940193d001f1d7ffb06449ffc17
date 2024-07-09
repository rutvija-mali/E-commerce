<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.User" %>
<%@ include file="../components/imports.jsp" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/other/admin.css" >
<%
    User user = (User)session.getAttribute("current-user");
    List<MyOrder> orderlist = OrderDao.getAllOrders();
    List<Category> categoryList = CategoryDao.getCategories();
    List<Product> productList = ProductDao.getAllProducts();
    List<User> userList = UserDao.getAllUsers();
    
    int totalOrders = (orderlist != null)? orderlist.size() : 0;
    int totalCategories = (categoryList != null)? categoryList.size() : 0;
    int totalProducts = (productList != null)? productList.size() : 0;
    int totalUsers = (userList != null)? userList.size() : 0;
    
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
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title>Dashboard</title>
</head>
<body>

<jsp:include page="./admin.jsp"></jsp:include>

 <main class="" id="main-section">
  <div class="container-fluid " >
    
    <div class="row my-2 gy-5 ">

      <div class="col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center "  >
        <div class="card align-self-center py-3  dash-card " style="width: 18rem; "> 
          <div class="card-body d-flex flex-column align-items-center  ">
            <span class=""><i class="fa-solid fa-users fa-3x"></i></span>
             <p class="fs-5   mt-3 mb-0"><%=totalUsers %></p>
            <h5 class="card-title  fw-bold">Users</h5>
          </div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center">
        <div class="card  align-self-center py-3 dash-card " style="width: 18rem;">
          <div class="card-body d-flex flex-column align-items-center  ">
            <span class=""><i class="fa-solid fa-boxes-stacked fa-3x"></i></span>
             <p class="fs-5  mt-3 mb-0"><%=totalProducts %></p>
            <h5 class="card-title  fw-bold">Products</h5>
          </div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center">
        <div class="card  align-self-center py-3 dash-card " style="width: 18rem;">
          <div class="card-body d-flex flex-column align-items-center  ">
            <span class=""><i class="fa-solid fa-tag fa-3x"></i></span>
             <p class="fs-5   mt-3 mb-0"><%=totalCategories%></p>
            <h5 class="card-title  fw-bold">Categories</h5>
          </div>
        </div>
      </div>

    </div>
    <div class="row my-2 gy-5 ">

      <div class="col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center " >
        <div class="card align-self-center py-3 dash-card" style="width: 18rem;"> 
          <div class="card-body d-flex flex-column align-items-center  ">
            <span class=""><i class="fa-solid fa-receipt fa-3x "></i></span>
             <p class="fs-5   mt-3 mb-0"><%=totalOrders%></p>
            <h5 class="card-title  fw-bold ">Orders</h5>
          </div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center">
        <div class="card  align-self-center py-3 dash-card  " style="width: 18rem;">
          <div class="card-body d-flex flex-column align-items-center  ">
            <span class="" ><i class="fa-solid fa-box fa-3x"></i></span>
             <p class="fs-5   mt-3 mb-0 "><i class="fa-solid fa-plus"></i></p>
             <h5 class="card-title fw-bold "><a href="${pageContext.request.contextPath }/admin/addProduct.jsp" class="nav-link active">Product</a></h5>
          </div>
        </div>
      </div>

      <div class="col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center">
        <div class="card  align-self-center py-3 dash-card" style="width: 18rem;">
          <div class="card-body d-flex flex-column align-items-center  ">
            <span class=""><i class="fa-solid fa-list fa-3x"></i></span>
             <p class="fs-5 mt-3 mb-0"><i class="fa-solid fa-plus"></i></p>
             <h5 class="card-title  fw-bold "><a href="${pageContext.request.contextPath }/admin/addCategory.jsp" class="nav-link active">Category</a></h5>
          </div>
        </div>
      </div>

    </div>
   
   </div>
</main>
  
  

</body>
</html>