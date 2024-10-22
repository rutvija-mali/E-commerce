<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../components/common.jsp" %>
<%@ page import="com.demo.product.Product" %>
<%@ page import="com.demo.product.ProductDao" %>
<%@ page import="com.demo.helper.Reduce" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.File" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/img.png" />
<title> Online Shopping Destination </title>
</head>
<body>
 <% 
   List <Product> list =  ProductDao.getAllProducts();
   request.setAttribute("list", list);
   String path = application.getRealPath("img") + File.separator + "product";
   
 %>
 <div class="mb-5 pb-4">
    <%@ include file="./components/header.jsp" %>
 
 </div>
  
   <!--carousel  -->
	<div class="container" id="container" >
		<div id="carouselExampleRide" class="carousel slide carousel-dark"
			data-bs-ride="true">

			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="${pageContext.request.contextPath }/product.jsp?category=all"><img src="images/home/pink.png" class="d-block w-100"
						alt="..."></a>
				</div>
				<div class="carousel-item">
					<a href="${pageContext.request.contextPath }/product.jsp?category=all"><img
						src="images/home/Screenshot 2024-06-19 130831.png"
						class="d-block w-100" alt="..."></a>
				</div>
				<div class="carousel-item">
					<a href="${pageContext.request.contextPath }/product.jsp?category=all"><img src="images/home/fun.png" class="d-block w-100"
						alt="..."></a>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleRide" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleRide" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>

    <!-- popular product  -->
	<div class="container text-center mt-3 pt-lg-5">
		<h3 class="text-dark ">Popular Products</h3>
	</div>
	<div class="container pt-lg-2 pt-1   position-relative"
		id="owl-carousel">
		<!-- Owl Carousel HTML -->
		<div class="owl-carousel owl-theme">
		    <c:forEach items="${list}" var="product" begin="0" end="9">
			   <div class="item product-card" >
				   <div class="card">
				        <div class="card-body">
				            <div class="text-start position-relative mb-2">
				                <a href="#"><img src="img/product/${product.getImage()}" alt="product-image" class="img-fluid image-container" >
				                </a>
				                <div class="product-action d-flex justify-content-center mt-5 gap-1 position-absolute  " tabindex="-1" id="little-navigation">
				                    <a href="#" class="px-2 btn "data-bs-toggle="tooltip" data-bs-title="Another tooltip"><i class="fa-regular fa-eye" aria-hidden="true"></i></a>
				                    <a  href="${pageContext.request.contextPath}/function/saveWishlist.jsp?action=save&product_id=${product.getId()}" class="px-2 btn " data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Whishlist" data-bs-original-title="Whishlist"><i class="fa-regular fa-heart" aria-hidden="true"></i></a>
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
				                          <span id="total-star" style="font-size: 12px;">4.5</span>
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


		<div class="owl-nav">
			<button type="button" role="presentation" class="owl-prev">
				<i class="fas fa-chevron-left f"></i>
			</button>
			<button type="button" role="presentation" class="owl-next">
				<i class="fas fa-chevron-right"></i>
			</button>
		</div>


	</div>
   <!-- shop by category -->
	<div class="container text-center mt-3 pt-lg-4">
		<h3 class="text-dark ">Shop By Categories</h3>
	</div>

	<!-- Categories -->
	<div class="container" id="category-container">
		<div class="container">
			<div
				class="row  row-cols-1 row-cols-sm-2 row-cols-md-3 g-2 g-lg-3 g-4">
				<div class="col" id="image-container">
					<a href="${pageContext.request.contextPath }/product.jsp?category=Co-ords"> <img src="./images/categories/co-ords.png"
						alt="co-ords" class="img-fluid category-image">
					</a>
				</div>
				<div class="col ">
					<a href="${pageContext.request.contextPath }/product.jsp?category=Denim "> <img src="./images/categories/denime_Cat.png"
						alt="denim" class="img-fluid category-image">
					</a>
				</div>
				<div class="col ">
					<a href="${pageContext.request.contextPath }/product.jsp?category=Dresses"> <img src="./images/categories/dresses.png"
						alt="dresses" class="img-fluid category-image">
					</a>
				</div>
				<div class="col">
					<a href="${pageContext.request.contextPath }/product.jsp?category=Skirts and Shorts "> <img src="./images/categories/skirt_shorts.png"
						alt="skirts and shorts" class="img-fluid category-image ">
					</a>
				</div>
				<div class="col">
					<a href="${pageContext.request.contextPath }/product.jsp?category=Tees"> <img src="./images/categories/tees.png" alt="tees"
						class="img-fluid category-image">
					</a>
				</div>
				<div class="col ">
					<a href="${pageContext.request.contextPath }/product.jsp?category=Tops"> <img src="./images/categories/tops.png" alt="tops"
						class="img-fluid category-image">
					</a>
				</div>
			</div>
		</div>
	</div>
	<!--second last section   -->
	<section>
		  <div class="container pt-lg-5 pt-4">
		    <div class="row">
		      <div class="col-md-6 col-lg-3 mb-3 gap-1">
		        <div class="py-4 fs-2">
		          <i class="fa-solid fa-scissors"></i>
		        </div>
		        <h5 class="mb-3">Free Alterations</h5>
		        <p class="text-muted">Enjoy complimentary alterations on all purchases, ensuring your clothing fits perfectly.</p>
		      </div>
		      <div class="col-md-6 col-lg-3 mb-3">
		        <div class="py-4">
		          <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40"  class="bi bi-bag" viewBox="0 0 16 16">
		            <path d="M6 2a2 2 0 0 0-2 2h12a2 2 0 0 0-2-2H6zm1 1a1 1 0 0 1 2 0h6a1 1 0 0 1 1 1v7a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h6z"/>
		          </svg>
		        </div>
		        <h5 class="mb-3">Best Prices & Offers</h5>
		        <p class="text-muted">Enjoy exclusive discounts and promotions on a wide range of clothing items.</p>
		      </div>
		      <div class="col-md-6 col-lg-3 mb-3">
		        <div class="py-4">
		          <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40"  class="bi bi-tags" viewBox="0 0 16 16">
		            <path d="M3 2a2 2 0 0 0 0 4h.293L7.5 6.207l-.708.707L2.585 6.5A1 1 0 0 1 3 3.5a1 1 0 0 1 1.707-.707L6.5 4.793l.707-.707L3.293 2H3zm4 4L9 5.293l-.707-.707L6.293 4H4v1h2.293l.707-.707z"/>
		            <path d="M1 4.586l7.5 7.5A1.5 1.5 0 0 0 9.414 12L16 5.414a1.5 1.5 0 0 0 0-2.121L10.707.586a1.5 1.5 0 0 0-2.121 0L1 8.172v4.414a1.5 1.5 0 0 0 1.5 1.5h4.414a1.5 1.5 0 0 0 1.5-1.5V9.414l-1 1v2.414a.5.5 0 0 1-.5.5H2v-2.414l-1-1v2.414A1.5 1.5 0 0 0 2.414 13h4.414A1.5 1.5 0 0 0 8.5 11.414v-2.828L1 3.586z"/>
		          </svg>
		        </div>
		        <h5 class="mb-3">Wide Assortment</h5>
		        <p class="text-muted">Choose from a vast collection of clothing items for women.</p>
		      </div>
		      <div class="col-md-6 col-lg-3 mb-3">
		        <div class="py-4">
		          <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40"  class="bi bi-box-arrow-in-left" viewBox="0 0 16 16">
		            <path d="M10.5 3a.5.5 0 0 1 .5.5V5h4.5a.5.5 0 0 1 .354.854l-7 7a.5.5 0 1 1-.708-.708l7-7A.5.5 0 0 1 15.5 5H11v1.5a.5.5 0 0 1-1 0V3.5a.5.5 0 0 1 .5-.5z"/>
		            <path d="M3.5 2A1.5 1.5 0 0 0 2 3.5v9A1.5 1.5 0 0 0 3.5 14H7a.5.5 0 0 0 0-1H3.5a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5H7a.5.5 0 0 0 0-1H3.5z"/>
		          </svg>
		        </div>
		        <h5 class="mb-3">Easy Returns</h5>
		        <p class="text-muted">Not satisfied with your purchase? Return it easily within 30 days for a full refund.</p>
		      </div>
		    </div>
		  </div>
   </section>
	
	<%@ include file="./components/footer.jsp" %>
	
	
  <!-- script for tooltip -->
 
	
  <!-- Custom Script -->
  <script>
  
   
	 
    $(document).ready(function(){
      $('.owl-carousel').owlCarousel({
        loop:true,
        margin:10,
        nav:false,
        autoplay: true,
        autoplayTimeout: 3000,
        responsive:{
            0:{
                items:1
            },
            480:{
               items:2
            },
            600:{
                items:3
            },
            1000:{
                items:5
            }
        }
      });
      $('.owl-prev').click(function() {
        $('.owl-carousel').trigger('prev.owl.carousel');
      });

      $('.owl-next').click(function() {
        $('.owl-carousel').trigger('next.owl.carousel');
      });
    });
      

  </script>
  <script>
		  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
		 var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
		  return new bootstrap.Tooltip(tooltipTriggerEl)
		 })

  </script>
    
</body>
</html>

