<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList"%>
 <%@ include file="../components/common.jsp" %>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/other/addtocart.css">
<%@ include file="../components/imports.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title>Checkout</title>
 
</head>
<body>
 <%  
   int subTotal = 0;
   int deliveryCharges = 99;
    User user = (User)session.getAttribute("current-user");
    
   
    int product_id = 0;
    
    
    if(user == null){
 	   response.sendRedirect("./login.jsp");
    }else{
           
	     
		   int userid = user.getUserId();
		  List<Product> list = CartDao.getAllProducts(userid);
		  
		  for(Product p : list){
			  subTotal += p.getProduct_price()*p.getProduct_qty();
		  }
		  
		  request.setAttribute("list", list);
		  
	}
		
%>

<div class="mb-5 pb-4">
    <%@ include file="./components/header.jsp" %>
 
 </div>

 <div class="container-fluid " id="addtocart">
<jsp:include page="/components/message.jsp"></jsp:include>
   <div class="row ">
      <div class="col-md-8 col-12 bg-light "  id="product-container">
         <div class="table-responsive">
          <table class="table  table-borderless w-100 " >
            <thead class="text-start ">
               <tr class="table-light">
                 <th scope="col">Product</th>
                 <th scope="col">Price</th>
                 <th scope="col">Quantity</th>
               </tr>
            </thead>
            <tbody>
             
             <c:forEach items="${list}" var="product">
                   <tr >
	                 <td colspan="1" class="">
	                   <div class="row ">
	                     <div class="col-4 col-sm-3 col-md-2 ">
	                       <a href="#"><img src="img/product/${product.getImage()}" width="80px"  height="93px"></a>
	                     </div>
	                      <div class="col-8 col-sm-9 col-md-10 ">
	                        <span class="lh-sm mb-2 fs-6 fw-medium ">${product.getProduct_name() }</span><br>
	                        <span style="font-size:0.9rem;" class="mb-2" ><small>Size: ${product.getProduct_size()}</small></span><br>
	                        <span style="font-size:0.95rem;" class="mb-1" id="wishlist-span">
	                          <a href="${pageContext.request.contextPath}/function/saveWishlist.jsp?action=save&product_id=${product.getId()}" class="text-decoration-none">
	                            <small>
	                              <i class="fa-solid fa-heart"></i>
	                              Add to Wishlist
	                            </small>
	                          </a>
	                        </span>
	
	                      </div>
	                   </div>
	                 </td>
	                 <td class="price-total text-start ">
	                   <span class="price-actual text-decoration-line-through">
	                    <small><i class="fa-solid fa-indian-rupee-sign"></i>${product.getOriginal_price()}</small>
	                   </span><br>
	                   <span class="price-new" id="productPrice_${product.getId()}">
	                       <small>
	                          <i class="fa-solid fa-indian-rupee-sign"></i>
	                          <span>${product.getProduct_price()}</span>
	                       </small>
	                   </span>
	                 </td>
	                 <td class=" text-start quantity ">
	                       <select name="product_qty" id="produt_qty_${product.getId()}" class="rounded-1 w-50" onchange="updateCart(${product.getId()},this.value,${product.getProduct_price()})" >
		                      <option selected value="1">1</option>
		                      <c:forEach var="num" begin="2" end="9">
		                        <option class="options" value="${num}"<c:if test="${num == product.getProduct_qty()}"></c:if> selected="selected" >${num}</option>
		                      </c:forEach>
		                    </select>
	                        <span class="ms-2  border rounded-circle px-1  text-center" id="removeProduct">
		                      <a href="${pageContext.request.contextPath}/addToCart/deleteCart.jsp?&product_id=${product.getId()}">
		                        <i class="fa-solid fa-xmark"></i>
		                      </a>
		                    </span>
	                 </td>
	                 
	              </tr>
             
             </c:forEach>
            </tbody>
          </table>
         </div>
      </div>
      <div class="col-md-4 col-xs-12 ">
       <div id="bill-container" >
        <div class="table-responsive  "> 
          <table class="table">
            <tbody> 
              <tr scope="row">
                <td scope="col"><strong><small>Sub Total:</small></strong></td>
                <td scope="col">
                  <span>
                    <i class="fa-solid fa-indian-rupee-sign"></i>
                   <span id="subTotal">0</span>
                  </span>
                </td>
                <tr class="border-end-0">
                  <td scope="col"><strong><small>Delivery Charges:</small></strong></td>
                  <td scope="col">
                    <span>
                      <i class="fa-solid fa-indian-rupee-sign"></i>
                      <span id="deliveryCharges">
                        99
                       </span>
                    </span>
                  </td>
                </tr>
                <tr scope="row" >
                  <td scope="col"><strong><small>Total:</small></strong></td>
                  <td scope="col">
                    <span >
                      <i class="fa-solid fa-indian-rupee-sign"></i>
                      <span id="total-price">
                         0
                      </span>
                    </span>
                  </td>
                  
                </tr>
            </tbody>
          </table>
        </div>
        <div>
          <a class="btn btn-success w-100" href="#" role="button" onclick="createOrder()">Checkout</a>
        </div>
       </div>
      </div>
    </div>
  </div>

<%@ include file="./components/footer.jsp" %>
 <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/cart.js"></script>
</body>
</html>