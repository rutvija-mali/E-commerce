<%@page import="com.demo.dao.wishlistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../components/imports.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
      User currentUser = (User)session.getAttribute("current-user");

      int totalWishlist = 0;
      int totalCartItems = 0;
      
      if(currentUser != null){
    	  int userid = currentUser.getUserId();
    	  totalWishlist = wishlistDao.getTotalWhistlistProducts(userid);
    	  totalCartItems = CartDao.getTotalCartProducts(userid);
      }
%>


<header>
    <!-- first navbar  -->
  <div class="position-fixed z-3 mt-0 w-100 top-0" id="header-container">
        <div class="container-fluid bg-black text-white text-center p-1 mb-0">
           <span id="first-nav">Spring-Summer'24 SALE! Flat40%  OFF*</span>
		 </div> 
		     <!--second navbar  -->
		     <nav class="navbar navbar-expand-lg  border-bottom border-light-subtle " id="second-navbar">
		        <div class="container-fluid d-flex justify-content-between row  ">
		          <div class="col-lg-4 col-sm-4 col-xs-4 align-self-start align align-self-center">
		             <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#thirdNavbar" aria-controls="thirdNavbarLabel" aria-expanded="false" aria-label="Toggle navigation">
			            <span class="navbar-toggler-icon"></span>
			         </button>
		          </div>
		           <div class="col-lg-4 col-sm-4 col-xs-4 align-self-center" >
		            <a class="navbar-brand " href="#">
		                <!-- add image -->
		                <%-- <img src="${pageContext.request.contextPath}/images/img.png"  alt="fashion logo" height="48rem" width="150rem"  > --%>
		                <span id="brand-name">FASHION</span>
		            </a>
		           </div>
		           <div class="d-flex justify-content-center align-items-center col-lg-4 col-sm-4 col-4 align-self-center  " style="height:3.4rem" >
		              <div class="col-lg-8 d-none d-lg-block  " style="height:100%"  >
				        <div class=" w-100 " style="height:100%">
				           <form class="d-flex w-100 align-items-center" style="height:100%" role="search" id="nav-2-form" action="${pageContext.request.contextPath}/product.jsp">
							   <div class="input-group ">
								    <input class="form-control" name="searchItem" type="search" placeholder="Search" aria-label="Search">
								    <button class="btn btn-outline-secondary border " type="submit" aria-label="Search" id="searched-btn">
								      <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
								        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
								      </svg>
								    </button>
								  </div>
						  </form>	
				        </div> 
		              </div>
		              <div class="col-lg-4 col-sm-12 justify-content-evenly d-flex align-items-center " id="header-section">
		                 <div class="row row-col-4">
		                     <div class="col d-flex align-items-center">
		                        <div class="dropdown" id="header-dropdown">
		                              <span class="fs-3" data-bs-toggle="dropdown" aria-expanded="false" ><i class="bi bi-person "></i></span>
					                  
					                   <ul class="dropdown-menu" id="header-dropdown-menu">
					                        <% 
									            Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
					                            System.out.print(isLoggedIn);
									            if (isLoggedIn != null && isLoggedIn) {
									        %>
									            <li><a class="dropdown-item" href="profile.jsp">My Account</a></li>
									            
									            <li>
										            <form action="logoutServlet" method="post">
										             <button class="dropdown-item" type="submit">Logout</button>
										            </form>
									            </li>
									        <% 
									            } else {
									        %>
									            <li><a class="dropdown-item" href="registor.jsp">Register</a></li>
									            <li><a class="dropdown-item" href="login.jsp">Login</a></li>
									        <% 
									            } 
									        %>
									   </ul>
				                 </div>
				                     
		                     </div>
		                     <div class="col d-flex align-items-center">
				                          <!-- add option -->
				                <a href="${pageContext.request.contextPath}/wishlist.jsp" class="position-relative">
				                 <span class=" fs-4">
				                     <i class="bi bi-heart"></i>
				                     <span class="position-absolute top-0 start-100 translate-middle px-2 text-light badge  rounded-circle">
									    <span style="font-size:0.88rem"><%= totalWishlist%></span>
									 </span>
				                 </span>
				                   
				                </a>
		                     </div>
		                     <div class="col d-flex align-items-center">
				                        <!-- add heart -->
				                <a href="${pageContext.request.contextPath}/addtocart.jsp" class="position-relative"> 
				                   <span class=" fs-4">
				                     <i class="bi bi-bag custom-icon"></i>
				                      <span class="position-absolute top-0 start-100 translate-middle px-2 text-light badge rounded-circle">
									    <span style="font-size:0.85rem"><%=totalCartItems %></span>
									 </span>
				                   </span>
				                </a>
				               <!-- add bag -->
		                     
		                     </div>
		                 </div>
		               
		               
		              </div>
		              
		           </div>
		        </div>
        
		      </nav>
		   <!--third navbar  -->
		   <nav class="navbar  navbar-expand-lg border-bottom border-light-subtle  " id="third-navbar-container">
		        <div class="container-fluid">
		         
		          <div class="offcanvas offcanvas-start" tabindex="-1" id="thirdNavbar" aria-labelledby="thirdNavbarLabel">
		                <div class="offcanvas-header">
		                
		                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		                </div>
		              <div class="offcanvas-body">
		               <div class="container d-lg-block d-none">
		                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3 ">
		                 <div class="d-flex justify-content-evenly  w-100">
		                    <div class="p-2">
		                      <nav class="nav-item"><a href="${pageContext.request.contextPath}/index.jsp" class="nav-link">Home</a></nav>
		                    </div>
		                    <div class="p-2">
		                      <nav class="nav-item"><a href="${pageContext.request.contextPath }/product.jsp?category=all" class="nav-link">All products</a></nav>
		                    </div>
		                    <div class="p-2">
		                     <div class=" nav-item dropdown">
		                        <a class="nav-link " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		                          Tops <span class="ps-2 small"><i class="fa-solid fa-chevron-down"></i></span>
		                        </a>
		                        <ul class="dropdown-menu">
		                          <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Tops">Floweral Tops</a></li>
		                          <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Tops">Cropped Tops</a></li>
		                          <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Tops">Tops</a></li>
		                        </ul>
		                     </div>
		                     
		                    </div>
		                  
		                    <div class="p-2">
		                      <li class="nav-item">
		                      <a class="nav-link link " href="${pageContext.request.contextPath }/product.jsp?category=Co-ords" role="button"  >
		                        Co-ords
		                      </a></li>
		                      
		                    </div>
		                    <div class="p-2">
		                      <div class="nav-item dropdown">
		
		                      <a class="nav-link " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		                        Exclusive  <span class="ps-2 small"><i class="fa-solid fa-chevron-down"></i></span>
		                      </a>
		                      <ul class="dropdown-menu">
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Tops">Tops</a></li>
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Skirts and Shorts">Shorts</a></li>
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Dresses">Dresses</a></li>
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Denim">Denim</a></li>
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Co-ords">Jumpsuit</a></li>
		                      </ul>
		                      </div>
		                    </div>
		                    <div class="p-2">
		                      <div class="nav-item dropdown">
		                      <a class="nav-link " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		                        New In <span class="ps-2 small"><i class="fa-solid fa-chevron-down"></i></span>
		                      </a>
		                      <ul class="dropdown-menu">
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Tops">Tops</a></li>
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Skirts and Shorts">Shorts</a></li>
		                        <li><a class="dropdown-item" href="${pageContext.request.contextPath }/product.jsp?category=Denim">Denim</a></li>
		                      </ul>
		                      </div>
		                    </div>
		                 </div>
		                    
		                </ul>
		               </div>
            

              <!-- navbar for small screen -->
              <div class="container d-block d-lg-none mb-5  ">
                <div class="">
                  <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <div class="p-2">
                      <nav class="nav-item"><a href="#" class="nav-link">Home</a></nav>
                    </div>
                    <div class="p-2">
                      <nav class="nav-item"><a href="#" class="nav-link">All products</a></nav>
                    </div>
                    
                    <div class="p-2">
                      <div class=" ">
                        <a class="nav-link" data-bs-toggle="collapse" href="#collapseHome3" role="button" aria-expanded="false" aria-controls="collapseHome">
                        Tops <span class="ps-2 small"><i class="fa-solid fa-chevron-down"></i></span>
                        </a>
                        <div class="collapse" id="collapseHome3">
                          <div class="card card-body">
                            <ul class="list-unstyled">
                              <li><a class="dropdown-item" href="#">Floweral Tops</a></li>
                              <li><a class="dropdown-item" href="#">Cropped Tops</a></li>
                              <li><a class="dropdown-item" href="#">Tops</a></li>
                             </ul>
                           </div>
                         </div>
                       </div>
                     </div>
                   
                    <div class="p-2">
                      <li class="nav-item">
                      <a class="nav-link " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Co-ords
                      </a>
                      </li>
                    </div>
                   
                    <div class="p-2">
                      <div class="">
                        <a class="nav-link" data-bs-toggle="collapse" href="#collapseHome2" role="button" aria-expanded="false" aria-controls="collapseHome">
                        Exclusive <span class="ps-2 small"><i class="fa-solid fa-chevron-down"></i></span>
                        </a>
                        <div class="collapse" id="collapseHome2">
                          <div class="card card-body">
                            <ul class="list-unstyled">
                              <li><a class="dropdown-item" href="#">Tops</a></li>
                              <li><a class="dropdown-item" href="#">Shorts</a></li>
                              <li><a class="dropdown-item" href="#">Dresses</a></li>
                              <li><a class="dropdown-item" href="#">Denimes</a></li>
                              <li><a class="dropdown-item" href="#">Jumpsuit</a></li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </div>  
                    <div class="p-2">
                      <div class="">
                       
                        <a class="nav-link" data-bs-toggle="collapse" href="#collapseHome1" role="button" aria-expanded="false" aria-controls="collapseHome">
                          New In <span class="ps-2 small"><i class="fa-solid fa-chevron-down"></i></span>
                        </a>
                        <div class="collapse" id="collapseHome1">
                          <div class="card card-body">
                            <ul class="list-unstyled">
                              <li><a class="dropdown-item" href="#">Tops</a></li>
                              <li><a class="dropdown-item" href="#">Shorts</a></li>
                              <li><a class="dropdown-item" href="#">Denimes</a></li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </div>  
                      
                  </ul>
                </div>
              </div>
             
            </div>
          </div>
        </div>
      </nav>
		   
		   
		  
  </div>
 </header>

 
 
 
 
