<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/other/product.css">
<%@ include file="../components/imports.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title>Products</title>
</head>
<body>
   <%
            User user = (User)session.getAttribute("current-user");
            List <Product> list =null;
            
             String category = request.getParameter("category");
             System.out.println("category : "+category);
             String searchedQuery = request.getParameter("searchItem");
             System.out.println("searched query  request : "+searchedQuery);
          	if (category == null ) {
		   		if(searchedQuery != null){
		   			System.out.println("In searched query ");
			   		list = ProductDao.getSearchedProduct(searchedQuery);
			   		System.out.println("In searched query 2nd ");
		   		}
		   	} else         	
			   if (category != null && category.equals("all")) {
			   		
			   		list = ProductDao.getAllProducts();
			
			   	} else if(category != null) {
			   		list = ProductDao.getPerticulerProducts(category);
			   	}
			   	
		
			   	request.setAttribute("list", list);
				   System.out.println("list : "+list);
			   	List<Category> catList = CategoryDao.getCategories();
			   	request.setAttribute("catList", catList);
			
			   	HashSet<String> colors = ProductDao.getColors();
			   	request.setAttribute("colors", colors);
			   	
			   	
			   	
			   	/* 
			   	  
			   	
			   	*/
   %>
   
    
   <div class="mb-5 pb-4">
     <%@ include file="./components/header.jsp" %>
 
   </div>    
    
  
   <!--aside section  -->
    <aside class="sidebar  " id="product-sidebar">
        <div class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false" id="bd-sidebar" tabindex="-1"    aria-labelledby="offcanvasScrollingLabel">
          <div class="offcanvas-header d-sm-none">
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>
          <div class="offcanvas-body">
            <div class="list-group ">
              <a href="#" class="list-group-item main d-flex justify-content-between " data-bs-toggle="collapse" data-bs-target="#collapseExample"role="button" aria-expanded="false" aria-controls="collapseExample">
                Categories
                <span><i class="fa-solid fa-chevron-down"></i></span>
              </a>
              
              <div class="collapse" id="collapseExample">
                <div class="card card-body">
                  <ul class="list-group">
                    <c:forEach items="${catList}" var="cat">
                       <li class="list-group-item"><a href="${pageContext.request.contextPath }/product.jsp?category=${cat.getCategory_name()}">${cat.getCategory_name()}</a></li>
                    </c:forEach>
                    
                  </ul>
                </div>
              </div>
            </div>
            <div class="list-group color">
              <a href="#" class="list-group-item main d-flex justify-content-between " data-bs-toggle="collapse" data-bs-target="#color-list"role="button" aria-expanded="false" aria-controls="color-list">
                Color
                <span><i class="fa-solid fa-chevron-down"></i></span>
              </a>
              <div>
                <div class="collapse" id="color-list">
                 <div class="card card-body">
                   <ul class="list-group">
                       <c:forEach items="${colors}" var="color">
                          <li class="list-group-item">
						       <div class="checkbox">
						            <label>
						               <input type="checkbox" name="${color}" value="${color}" class="color-filter">
						               <span>${color}</span>
						            </label>
						         </div>
		                      
		                    </li> 
                      </c:forEach>
                   
                   </ul>
                 </div>
                </div>
              </div>
            </div>
            <div class="list-group price">
              <a href="#" class="list-group-item  main d-flex justify-content-between" data-bs-toggle="collapse" data-bs-target="#price-list"role="button" aria-expanded="false" aria-controls="price-list">
                Price
                <span><i class="fa-solid fa-chevron-down"></i></span>
              </a>
              <div class="">
                <div class="collapse" id="price-list">
                  <div class="card card-body">
                    <ul class="list-group">
                     <li class="list-group-item">
                       <div class="checkbox">
                         <label>
                           <input type="checkbox" name="" value="500-1000" class="price-filter">
                           <span>500-1000</span>
                         </label>
                       </div>
                       
                     </li>
                     <li class="list-group-item">
                       <div class="checkbox">
                         <label>
                           <input type="checkbox" name="" value="1000-2500" class="price-filter">
                           <span>1000-2500</span>
                         </label>
                       </div>
                       
                     </li>
                     <li class="list-group-item">
                       <div class="checkbox">
                         <label>
                           <input type="checkbox" name="" value="2500-4000" class="price-filter">
                           <span>2500-4000</span>
                         </label>
                       </div>
                       
                     </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            
           
          </div>
        </div>
    </aside>
    
    <!--product section  -->
     <section>
      <div class="container-fluid " id="product-container">
        <div class="mt-2 ms-2 d-flex align-items-center" id="product-count">
          <% if(category == null && searchedQuery != null){ %>
          <h6><%= "Top Search Results For "+ searchedQuery %></h6>
          <% }else {%>
          <h3><%=category.equals("all")?"All Products": category %></h3>
          <%} %>
          <span class="ps-2" id="totalProductCount">(<%=list.size() %>)</span>
        </div>
        <div class="row row-cols-lg-5 row-cols-md-4 row-cols-sm-3 row-cols-2 g-2 g-lg-3 g-4 mt-2">
           <c:forEach items="${list}" var="product">
             <div class="col product-card" data-colors="${product.getProduct_color()}" data-price="${product.getProduct_price() }">
                     <div class="card" >
				        <div class="card-body">
				            <div class="text-start position-relative mb-2">
				                <a href="#"><img src="img/product/${product.getImage()}" alt="product-image" class="img-fluid image-container" >
				                </a>
				                <div class="product-action d-flex justify-content-center mt-5 gap-1 position-absolute  " tabindex="-1" id="little-navigation">
				                    <a href="#" class="px-2 btn " data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Quick View" data-bs-original-title="Quick View"><i class="fa-regular fa-eye" aria-hidden="true"></i></a>
				                    <a href="${pageContext.request.contextPath}/function/saveWishlist.jsp?action=save&product_id=${product.getId()}" class="px-2 btn " data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Whishlist" data-bs-original-title="Whishlist"><i class="fa-regular fa-heart" aria-hidden="true"></i></a>
				                    <a href="#" class="px-2 btn " data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Compare" data-bs-original-title="Compare"><i class="fa-solid fa-arrow-right-arrow-left" aria-hidden="true"></i></a>
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
				                        <span class="text-decoration-line-through" id="original-price">&#8377;${product.getOriginal_price()}</span>
				        
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
    </section>
    <!-- sticky filters -->
    <div class="container-fluid position-fixed bottom-0 d-sm-none  d-flex">
      <div class="col-6">
          <button class="btn btn-success w-100" type="button" data-bs-toggle="offcanvas" data-bs-target="#bd-sidebar" aria-controls="offcanvasScrolling">
             <span class="fs-5"><i class="fa-solid fa-arrow-down-wide-short"></i></span>
          </button>
      </div>
      <div class="col-6">
          <button class="btn btn-success w-100" type="button" data-bs-toggle="offcanvas" data-bs-target="#bd-sidebar" aria-controls="offcanvasScrolling">
              <span class="fs-5"><i class="fa-solid fa-sliders"></i></span>
          </button>
      </div>
  </div>
  <%@ include file="./components/footer.jsp" %>
</body>
</html>

<script>
   
   let checkboxes = document.querySelectorAll(".color-filter");
  
   checkboxes.forEach((checkbox)=>{
	    checkbox.addEventListener("change",filterProducts)
	});
   function filterProducts(){
	   let selectedColors = Array.from(checkboxes)
	                             .filter((checkbox)=>checkbox.checked)
	                             .map((checkbox)=> checkbox.value)
	                             

	  let productCards = document.querySelectorAll(".product-card");  
	   productCards.forEach((card)=>{
		   let productColors = card.dataset.colors ? card.dataset.colors.split(",") : [];
		   let isvisible = selectedColors.lenght === 0 || selectedColors.some((color)=> productColors.includes(color));
		   card.style.display = isvisible? "" : "none";
		 
	   });
	   
   }
   
   let priceCheckboxes = document.querySelectorAll(".price-filter");
   console.log(priceCheckboxes)
   priceCheckboxes.forEach((checkbox)=>{
	   checkbox.addEventListener("change",filterProducPrice)
   })
   
   function filterProducPrice(){
	   let selectedPriceRange = Array.from(priceCheckboxes)
	                                 .filter((checkbox)=>checkbox.checked)
	                                 .map((checkbox)=> checkbox.value)
	                                 .map((range)=>String(range).split("-"))
	                                 .flat();
	                                 
	                  
	                     
	   const maxPrice = Math.max(...selectedPriceRange)
	   const minPrice = Math.min(...selectedPriceRange);
	   let productCards = document.querySelectorAll(".product-card"); 
	   productCards.forEach((card)=>{
		   let productPrice = card.dataset.price;
		   let isvisible = selectedPriceRange.length === 0 || productPrice >= minPrice && maxPrice >= productPrice;
		   card.style.display = isvisible? "" : "none";
		   
	   })
   }
   

</script>