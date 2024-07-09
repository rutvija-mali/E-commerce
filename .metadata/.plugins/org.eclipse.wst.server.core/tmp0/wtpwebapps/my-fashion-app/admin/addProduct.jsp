
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.demo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.category.Category" %>
 <%@ page import="com.demo.category.CategoryDao" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/other/addProduct.css" >
<%
   User user = (User)session.getAttribute("current-user");
    if(user == null)
    {
    	// send msg
    	response.sendRedirect("login.jsp");
    	return;
    }else if(user.getRole().equals("customer")){
    	// send msg
    	response.sendRedirect("login.jsp");
    	return;
    }
%>
 <% 
   List <Category> list =  CategoryDao.getCategories();
   request.setAttribute("list", list);
   session.setAttribute("catList", list);
   
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
 
  <div class="container-fluid mt-5" id="addProduct">
    <div class="d-flex flex-column align-items-center">
      <div class="d-flex align-items-center mt-3 ms-2">
        <h3>Products</h3>
        <span class="text-secondary ms-3">Add New Product</span>
      </div>
      <div class="pt-3 p-4" id="addProductFormDiv">
        <form action="${pageContext.request.contextPath}/ProductSaveServlet?action=save" enctype="multipart/form-data" method="post">
          <div class="row mb-3">
            <div class="mb-3 col-12 col-md-6">
              <label for="exampleInputProductName" class="form-label">Product Name</label>
              <input type="text" class="form-control" name="product_name" id="exampleInputProductName" placeholder="Enter product name" required>
              <div id="error-message" class="form-text d-none">Please enter the name of product</div>
            </div>
            <div class="mb-3 col-12 col-md-3">
              <label for="originalPrice" class="form-label">Original Price</label>
              <input type="text" id="originalPrice" name="original_price" class="form-control double-input" placeholder="Enter the original price" required>
              <div id="error-message" class="form-text d-none">Please enter the original price of product</div>
            </div>
            <div class="col-sm-12 col-md-3">
              <label for="productPrice" class="form-label">Price</label>
              <input type="text" id="productPrice" name="product_price" class="form-control double-input" placeholder="Enter the price" required>
              <div id="error-message" class="form-text d-none">Please enter the price of product</div>
            </div>
          </div>
          <div class="mb-3 row">
            <div class="col-12 col-md-3">
              <label for="productCategory" class="form-label">Category</label>
              <select class="form-select form-control double-input" id="productCategory" name="product_category" required>
                <c:forEach items="${list}" var="cat">
                  <option value="${cat.getCategory_name()}">${cat.getCategory_name()}</option>
                </c:forEach>
              </select>
              <div id="error-message" class="form-text d-none">Please enter the Category id of product</div>
            </div>
            <div class="col-12 col-md-3">
              <label for="productForGender" class="form-label">Gender</label>
              <select class="form-select form-control double-input" id="productForGender" name="gender" required>
                <option selected>Select gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </select>
              <div id="error-message" class="form-text d-none">Please select the gender</div>
            </div>
            <div class="col-12 col-md-3">
              <label for="productColor" class="form-label">Color</label>
              <input type="text" id="productColor" class="form-control double-input" name="product_color" placeholder="Enter the color" required>
              <div id="error-message" class="form-text d-none">Please enter the color of product</div>
            </div>
            <div class="col-12 col-md-3">
              <label for="productSize" class="form-label">Size</label>
              <input type="text" id="productSize" class="form-control double-input" name="product_size" placeholder="Enter the size" required>
              <div id="error-message" class="form-text d-none">Please enter the size of product</div>
            </div>
          </div>
          <div class="mb-3 row">
            <div class="col-12 col-md-6">
              <label for="productQty" class="form-label">Quantity</label>
              <input type="text" id="productQty" class="form-control double-input" name="product_qty" placeholder="Enter the quantity" required>
              <div id="error-message" class="form-text d-none">Please enter the quantity of product</div>
            </div>
            <div class="col-12 col-md-6">
              <label for="productImage" class="form-label">Upload Image</label>
              <input type="file" id="productImage" name="file" accept="image/*" class="form-control mt-1" required>
              <div id="error-message" class="form-text d-none">Please choose product image</div>
            </div>
          </div>
          <div class="mb-3">
            <label for="productDescription" class="form-label">Description</label>
            <textarea id="productDescription" class="form-control mt-1" rows="4" name="product_desc" placeholder="Enter product description"></textarea>
          </div>
          <div class="mb-3  ">
            <button type="submit" class="btn btn-dark w-50 align-self-center mt-1" id="addProduct">Submit</button>
          </div>
        </form>
      </div>
    </div>
  </div>

</body>
</html>

