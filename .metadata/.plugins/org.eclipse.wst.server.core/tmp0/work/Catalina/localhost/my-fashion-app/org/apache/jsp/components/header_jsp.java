/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.20
 * Generated at: 2024-07-06 14:06:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.components;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.demo.dao.wishlistDao;
import com.demo.product.Product;
import com.demo.product.ProductDao;
import com.demo.category.Category;
import com.demo.category.CategoryDao;
import com.demo.helper.Reduce;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import com.demo.User;
import com.demo.UserDao;
import com.demo.utility.Cart;
import com.demo.dao.CartDao;
import com.demo.order.MyOrder;
import com.demo.order.OrderDao;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Users/rutvi/OneDrive/Desktop/fashion-app/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/my-fashion-app/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0%20(1).jar!/META-INF/c.tld", Long.valueOf(1602854172000L));
    _jspx_dependants.put("/components/../components/imports.jsp", Long.valueOf(1720165404251L));
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0 (1).jar", Long.valueOf(1717239385690L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(16);
    _jspx_imports_classes.add("com.demo.product.Product");
    _jspx_imports_classes.add("com.demo.dao.CartDao");
    _jspx_imports_classes.add("com.demo.order.OrderDao");
    _jspx_imports_classes.add("java.util.Set");
    _jspx_imports_classes.add("com.demo.category.Category");
    _jspx_imports_classes.add("java.io.File");
    _jspx_imports_classes.add("com.demo.helper.Reduce");
    _jspx_imports_classes.add("java.util.HashSet");
    _jspx_imports_classes.add("com.demo.User");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.demo.product.ProductDao");
    _jspx_imports_classes.add("com.demo.category.CategoryDao");
    _jspx_imports_classes.add("com.demo.UserDao");
    _jspx_imports_classes.add("com.demo.order.MyOrder");
    _jspx_imports_classes.add("com.demo.utility.Cart");
    _jspx_imports_classes.add("com.demo.dao.wishlistDao");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

      User currentUser = (User)session.getAttribute("current-user");
      System.out.println(currentUser + " in header");
      int totalWishlist = 0;
      int totalCartItems = 0;
      
      if(currentUser != null){
    	  int userid = currentUser.getUserId();
    	  totalWishlist = wishlistDao.getTotalWhistlistProducts(userid);
    	  totalCartItems = CartDao.getTotalCartProducts(userid);
      }

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <!-- first navbar  -->\r\n");
      out.write("  <div class=\"position-fixed z-3 mt-0 w-100 top-0\">\r\n");
      out.write("        <div class=\"container-fluid bg-black text-white text-center p-1 mb-0\">\r\n");
      out.write("           <span id=\"first-nav\">Spring-Summer'24 SALE! Flat40%  OFF*</span>\r\n");
      out.write("		 </div> \r\n");
      out.write("		     <!--second navbar  -->\r\n");
      out.write("		     <nav class=\"navbar navbar-expand-lg  border-bottom border-light-subtle \" id=\"second-navbar\">\r\n");
      out.write("		        <div class=\"container-fluid d-flex justify-content-between row  \">\r\n");
      out.write("		          <div class=\"col-lg-4 col-sm-4 col-xs-4 align-self-start align align-self-center\">\r\n");
      out.write("		            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("		              <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("		            </button>\r\n");
      out.write("		          </div>\r\n");
      out.write("		           <div class=\"col-lg-4 col-sm-4 col-xs-4 align-self-center\" >\r\n");
      out.write("		            <a class=\"navbar-brand \" href=\"#\">\r\n");
      out.write("		                <!-- add image -->\r\n");
      out.write("		                ");
      out.write("\r\n");
      out.write("		                <span id=\"brand-name\">FASHION</span>\r\n");
      out.write("		            </a>\r\n");
      out.write("		           </div>\r\n");
      out.write("		           <div class=\"d-flex justify-content-center align-items-center col-lg-4 col-sm-4 col-4 align-self-center  \" style=\"height:3.4rem\" >\r\n");
      out.write("		              <div class=\"col-lg-8 d-none d-lg-block  \" style=\"height:100%\"  >\r\n");
      out.write("				        <div class=\" w-100 \" style=\"height:100%\">\r\n");
      out.write("				           <form class=\"d-flex w-100 align-items-center\" style=\"height:100%\" role=\"search\" id=\"nav-2-form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/product.jsp\">\r\n");
      out.write("							   <div class=\"input-group \">\r\n");
      out.write("								    <input class=\"form-control\" name=\"searchItem\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n");
      out.write("								    <button class=\"btn btn-outline-secondary border \" type=\"submit\" aria-label=\"Search\" id=\"searched-btn\">\r\n");
      out.write("								      <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"18\" height=\"18\" fill=\"currentColor\" class=\"bi bi-search\" viewBox=\"0 0 16 16\">\r\n");
      out.write("								        <path d=\"M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0\"/>\r\n");
      out.write("								      </svg>\r\n");
      out.write("								    </button>\r\n");
      out.write("								  </div>\r\n");
      out.write("						  </form>	\r\n");
      out.write("				        </div> \r\n");
      out.write("		              </div>\r\n");
      out.write("		              <div class=\"col-lg-4 col-sm-12 justify-content-evenly d-flex align-items-center \" id=\"header-section\">\r\n");
      out.write("		                 <div class=\"row row-col-4\">\r\n");
      out.write("		                     <div class=\"col d-flex align-items-center\">\r\n");
      out.write("		                        <div class=\"dropdown\" id=\"header-dropdown\">\r\n");
      out.write("		                              <span class=\"fs-3\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\" ><i class=\"bi bi-person \"></i></span>\r\n");
      out.write("					                  \r\n");
      out.write("					                   <ul class=\"dropdown-menu\" id=\"header-dropdown-menu\">\r\n");
      out.write("					                        ");
 
									            Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
					                            System.out.print(isLoggedIn);
									            if (isLoggedIn != null && isLoggedIn) {
									        
      out.write("\r\n");
      out.write("									            <li><a class=\"dropdown-item\" href=\"profile.jsp\">My Account</a></li>\r\n");
      out.write("									            \r\n");
      out.write("									            <li>\r\n");
      out.write("										            <form action=\"logoutServlet\" method=\"post\">\r\n");
      out.write("										             <button class=\"dropdown-item\" type=\"submit\">Logout</button>\r\n");
      out.write("										            </form>\r\n");
      out.write("									            </li>\r\n");
      out.write("									        ");
 
									            } else {
									        
      out.write("\r\n");
      out.write("									            <li><a class=\"dropdown-item\" href=\"registor.jsp\">Register</a></li>\r\n");
      out.write("									            <li><a class=\"dropdown-item\" href=\"login.jsp\">Login</a></li>\r\n");
      out.write("									        ");
 
									            } 
									        
      out.write("\r\n");
      out.write("									   </ul>\r\n");
      out.write("				                 </div>\r\n");
      out.write("				                     \r\n");
      out.write("		                     </div>\r\n");
      out.write("		                     <div class=\"col d-flex align-items-center\">\r\n");
      out.write("				                          <!-- add option -->\r\n");
      out.write("				                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/wishlist.jsp\" class=\"position-relative\">\r\n");
      out.write("				                 <span class=\" fs-4\">\r\n");
      out.write("				                     <i class=\"bi bi-heart\"></i>\r\n");
      out.write("				                     <span class=\"position-absolute top-0 start-100 translate-middle px-2 text-light badge  rounded-circle\">\r\n");
      out.write("									    <span style=\"font-size:0.88rem\">");
      out.print( totalWishlist);
      out.write("</span>\r\n");
      out.write("									 </span>\r\n");
      out.write("				                 </span>\r\n");
      out.write("				                   \r\n");
      out.write("				                </a>\r\n");
      out.write("		                     </div>\r\n");
      out.write("		                     <div class=\"col d-flex align-items-center\">\r\n");
      out.write("				                        <!-- add heart -->\r\n");
      out.write("				                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/addtocart.jsp\" class=\"position-relative\"> \r\n");
      out.write("				                   <span class=\" fs-4\">\r\n");
      out.write("				                     <i class=\"bi bi-bag custom-icon\"></i>\r\n");
      out.write("				                      <span class=\"position-absolute top-0 start-100 translate-middle px-2 text-light badge rounded-circle\">\r\n");
      out.write("									    <span style=\"font-size:0.85rem\">");
      out.print(totalCartItems );
      out.write("</span>\r\n");
      out.write("									 </span>\r\n");
      out.write("				                   </span>\r\n");
      out.write("				                </a>\r\n");
      out.write("				               <!-- add bag -->\r\n");
      out.write("		                     \r\n");
      out.write("		                     </div>\r\n");
      out.write("		                 </div>\r\n");
      out.write("		               \r\n");
      out.write("		               \r\n");
      out.write("		              </div>\r\n");
      out.write("		              \r\n");
      out.write("		           </div>\r\n");
      out.write("		        </div>\r\n");
      out.write("        \r\n");
      out.write("		      </nav>\r\n");
      out.write("		   \r\n");
      out.write("		   \r\n");
      out.write("		   \r\n");
      out.write("		  \r\n");
      out.write("  </div>\r\n");
      out.write(" </header>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
