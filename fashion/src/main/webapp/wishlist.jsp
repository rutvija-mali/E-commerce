<%@page import="java.util.ArrayList"%>
<%@page import="com.demo.utility.Wishlist"%>
<%@page import="com.demo.dao.wishlistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/other/wishlist.css">
<%@ include file="../components/imports.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title>Wishlist</title>
</head>
<body>
    <%  
    User user = (User)session.getAttribute("current-user");
    
   
    int product_id = 0;
    
    
    if(user == null){
 	   response.sendRedirect("./login.jsp");
    }else{
           
	     
		   int userid = user.getUserId();
		   List<Wishlist> list= wishlistDao.getAllWishlistIteams(userid);
		   List<Integer> ids = new ArrayList<Integer>() ;
			 for(Wishlist  item : list){
				 ids.add(item.getProduct_id());
			 }
		   List <Product> productList = new ArrayList<Product>();
		   
		   for(Integer id : ids){
			   productList.add(ProductDao.getProduct(id));
		   }
		   
		   request.setAttribute("list", productList);
		   
		   
	}
		
    %>
      <div class="mb-5 pb-4">
         <%@ include file="./components/header.jsp" %>
 
      </div>  
     
     <div class="container-fluid " id="container">
     <jsp:include page="/components/message.jsp"></jsp:include>
        <div class="mt-2 ms-2 d-flex align-items-center "  >
          <h3>My Wishlist</h3>
          <span class="ps-2 count" id="totalProductCount">(123)</span>
       </div>
        <div class="row row-cols-lg-5 row-cols-md-4 row-cols-sm-3 row-cols-2 g-2 g-lg-3 g-4 mt-2 ">
           <c:forEach items="${list}" var="product">
             <div class="col product-card " data-colors="${product.getProduct_color()}" data-price="${product.getProduct_price() }">
                     <div class="card" >
				        <div class="card-body">
				            <div class="text-start position-relative mb-2">
				                <a href="#"><img src="img/product/${product.getImage()}" alt="product-image" class="img-fluid image-container" >
				                </a>
				                <div class="product-action d-flex justify-content-center mt-5 gap-1 position-absolute  " tabindex="-1" id="little-navigation">
				                    <a href="#" class="px-2 btn " data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Quick View" data-bs-original-title="Quick View"><i class="fa-regular fa-eye" aria-hidden="true"></i></a>
				                    
				                    <a href="#" class="px-2 btn " data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Compare" data-bs-original-title="Compare"><i class="fa-solid fa-arrow-right-arrow-left" aria-hidden="true"></i></a>
				                 </div>
				                 <div class="position-absolute top-0 end-0 left-100 bottom-0 bg-light rounded-circle p-2 d-flex justify-content-center align-items-center" tabindex="-1"  style="width: 30px; height: 30px;">
				                    <span class="fs-6" ><a href="./function/removeWishlist.jsp?product_id=${product.getId() }"><i class="fa-solid fa-xmark" style="color:#6c757d;"></i></a></span>
				                 </div>
				               
				              </div>
				            <h6 class=" lh-sm "><a href="#" class="fs-6 text-decoration-none :hover-up text-truncate pb-0 mb-0" style="max-width: 200px;">${Reduce.reduceDesc(product.getProduct_name())}</a><h6>
				                <div class="mt-0 pt-0 text-start lh-sm ">
				                    <div class="small">
				                      <small>
				                          <i class=" fa-solid fa-star text-warning" style="font-size: 12px;" aria-hidden="true"></i>
				                          <i class=" fa-solid fa-star text-warning" style="font-size: 12px;" aria-hidden="true"></i>
				                          <i class=" fa-solid fa-star text-warning" style="font-size: 12px;" aria-hidden="true"></i>
				                          <i class=" fa-solid fa-star text-warning" style="font-size: 12px;" aria-hidden="true"></i>
				                          <i class=" fa-solid fa-star-half-stroke text-warning" style="font-size: 12px;" aria-hidden="true"></i>
				                          <span  style="font-size: 12px;" id="total-star">4.5</span>
				                      </small>
				                      
				                    </div>
				                </div>
				                <div class="d-flex justify-content-between align-items-center ">
				                    <div>
				                        <span class=" me-1" id="price">&#8377;${product.getProduct_price()}</span>
				                        <span class="text-decoration-line-through " id="original-price">&#8377;${product.getOriginal_price()}</span>
				        
				                    </div>
				                    <div class="d-grid mt-2">
				                        <a href="${pageContext.request.contextPath}/addToCart/saveCart.jsp?action=save&product_id=${product.getId()}" class="btn btn-dark text-light d-flex align-items-center gap-1">
				                           <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus">
				                              <line x1="12" y1="5" x2="12" y2="19"></line>
				                              <line x1="5" y1="12" x2="19" y2="12"></line>
				                           </svg>
				                           Add 
				                        </a>
				                     </div>
				                </div>
				        </div>
			      </div>
             </div>
           </c:forEach>

         </div>
       </div>
     
      <%@ include file="./components/footer.jsp" %>

</body>
</html>