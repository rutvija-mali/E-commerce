/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.20
 * Generated at: 2024-07-08 08:48:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.demo.User;
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

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Users/rutvi/OneDrive/Desktop/fashion-app/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/my-fashion-app/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0%20(1).jar!/META-INF/c.tld", Long.valueOf(1602854172000L));
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0 (1).jar", Long.valueOf(1717239385690L));
    _jspx_dependants.put("/admin/../components/imports.jsp", Long.valueOf(1720165404251L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(15);
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
      out.write(" <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/other/admin.css\" >\r\n");

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
    

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/img.png\" />\r\n");
      out.write("<title>Dashboard</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./admin.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <main class=\"\" id=\"main-section\">\r\n");
      out.write("  <div class=\"container-fluid \" >\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"row my-2 gy-5 \">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center \"  >\r\n");
      out.write("        <div class=\"card align-self-center py-3  dash-card \" style=\"width: 18rem; \"> \r\n");
      out.write("          <div class=\"card-body d-flex flex-column align-items-center  \">\r\n");
      out.write("            <span class=\"\"><i class=\"fa-solid fa-users fa-3x\"></i></span>\r\n");
      out.write("             <p class=\"fs-5   mt-3 mb-0\">");
      out.print(totalUsers );
      out.write("</p>\r\n");
      out.write("            <h5 class=\"card-title  fw-bold\">Users</h5>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center\">\r\n");
      out.write("        <div class=\"card  align-self-center py-3 dash-card \" style=\"width: 18rem;\">\r\n");
      out.write("          <div class=\"card-body d-flex flex-column align-items-center  \">\r\n");
      out.write("            <span class=\"\"><i class=\"fa-solid fa-boxes-stacked fa-3x\"></i></span>\r\n");
      out.write("             <p class=\"fs-5  mt-3 mb-0\">");
      out.print(totalProducts );
      out.write("</p>\r\n");
      out.write("            <h5 class=\"card-title  fw-bold\">Products</h5>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center\">\r\n");
      out.write("        <div class=\"card  align-self-center py-3 dash-card \" style=\"width: 18rem;\">\r\n");
      out.write("          <div class=\"card-body d-flex flex-column align-items-center  \">\r\n");
      out.write("            <span class=\"\"><i class=\"fa-solid fa-tag fa-3x\"></i></span>\r\n");
      out.write("             <p class=\"fs-5   mt-3 mb-0\">");
      out.print(totalCategories);
      out.write("</p>\r\n");
      out.write("            <h5 class=\"card-title  fw-bold\">Categories</h5>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"row my-2 gy-5 \">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center \" >\r\n");
      out.write("        <div class=\"card align-self-center py-3 dash-card\" style=\"width: 18rem;\"> \r\n");
      out.write("          <div class=\"card-body d-flex flex-column align-items-center  \">\r\n");
      out.write("            <span class=\"\"><i class=\"fa-solid fa-receipt fa-3x \"></i></span>\r\n");
      out.write("             <p class=\"fs-5   mt-3 mb-0\">");
      out.print(totalOrders);
      out.write("</p>\r\n");
      out.write("            <h5 class=\"card-title  fw-bold \">Orders</h5>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center\">\r\n");
      out.write("        <div class=\"card  align-self-center py-3 dash-card  \" style=\"width: 18rem;\">\r\n");
      out.write("          <div class=\"card-body d-flex flex-column align-items-center  \">\r\n");
      out.write("            <span class=\"\" ><i class=\"fa-solid fa-box fa-3x\"></i></span>\r\n");
      out.write("             <p class=\"fs-5   mt-3 mb-0 \"><i class=\"fa-solid fa-plus\"></i></p>\r\n");
      out.write("             <h5 class=\"card-title fw-bold \"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/addProduct.jsp\" class=\"nav-link active\">Product</a></h5>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"col-sm-12 col-md-4 col-lg-4  d-flex justify-content-center\">\r\n");
      out.write("        <div class=\"card  align-self-center py-3 dash-card\" style=\"width: 18rem;\">\r\n");
      out.write("          <div class=\"card-body d-flex flex-column align-items-center  \">\r\n");
      out.write("            <span class=\"\"><i class=\"fa-solid fa-list fa-3x\"></i></span>\r\n");
      out.write("             <p class=\"fs-5 mt-3 mb-0\"><i class=\"fa-solid fa-plus\"></i></p>\r\n");
      out.write("             <h5 class=\"card-title  fw-bold \"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/addCategory.jsp\" class=\"nav-link active\">Category</a></h5>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("   \r\n");
      out.write("   </div>\r\n");
      out.write("</main>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
