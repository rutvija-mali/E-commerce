/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.20
 * Generated at: 2024-06-21 08:18:18 UTC
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
import java.util.List;

public final class editProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/rutvi/OneDrive/Desktop/fashion-app/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/my-fashion-app/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0%20(1).jar!/META-INF/c.tld", Long.valueOf(1602854172000L));
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0 (1).jar", Long.valueOf(1717239385690L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(6);
    _jspx_imports_classes.add("com.demo.User");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.demo.product.ProductDao");
    _jspx_imports_classes.add("com.demo.category.CategoryDao");
    _jspx_imports_classes.add("com.demo.product.Product");
    _jspx_imports_classes.add("com.demo.category.Category");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write(" <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/other/addProduct.css\" >\r\n");

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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 
    int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
   
    Product product = ProductDao.getProduct(id);
    session.setAttribute("product", product);
    

   

      out.write('\r');
      out.write('\n');
      out.write(' ');
 
   List <Category> list =  CategoryDao.getCategories();
   request.setAttribute("list", list);
   session.setAttribute("catList", list);
   
 
      out.write('\r');
      out.write('\n');
      out.write(' ');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./admin.jsp", out, false);
      out.write('\r');
      out.write('\n');
      out.write(' ');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/components/message.jsp", out, false);
      out.write("\r\n");
      out.write("   <div class=\"container-fluid mt-5\" id=\"addProduct\">\r\n");
      out.write("    <div class=\"d-flex flex-column align-items-center\">\r\n");
      out.write("      <div class=\"d-flex align-items-center mt-3 ms-2\">\r\n");
      out.write("        <h3>Products</h3>\r\n");
      out.write("        <span class=\"text-secondary ms-3\">Add New Product</span>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"pt-3 p-4 \" id=\"addProductFormDiv\">\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/ProductSaveServlet?action=update&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${product.getId()}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("          <div class=\"mb-3 invisible d-none\" >\r\n");
      out.write("              <label for=\"exampleInputProductId\" class=\"form-label\">Product Id</label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control \" name=\"product_id\" id=\"exampleInputProductId\" aria-describedby=\"productId\" value=\"");
      out.print(product.getId());
      out.write("\" >\r\n");
      out.write("                     \r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"row mb-3\">\r\n");
      out.write("            <div class=\"mb-3 col-12 col-md-6\">\r\n");
      out.write("              <label for=\"exampleInputProductName\" class=\"form-label\">Product Name</label>\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" name=\"product_name\" id=\"exampleInputProductName\" value=\"");
      out.print(product.getProduct_name());
      out.write("\"  required>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"mb-3 col-12 col-md-3\">\r\n");
      out.write("              <label for=\"originalPrice\" class=\"form-label\">Original Price</label>\r\n");
      out.write("              <input type=\"text\" id=\"originalPrice\" name=\"original_price\" class=\"form-control double-input\" value=\"");
      out.print(product.getOriginal_price());
      out.write("\" required>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-12 col-md-3\">\r\n");
      out.write("              <label for=\"productPrice\" class=\"form-label\">Price</label>\r\n");
      out.write("              <input type=\"text\" id=\"productPrice\" name=\"product_price\" class=\"form-control double-input\" value=\"");
      out.print(product.getProduct_price() );
      out.write("\" required>\r\n");
      out.write("             \r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"mb-3 row\">\r\n");
      out.write("            <div class=\"col-12 col-md-3\">\r\n");
      out.write("              <label for=\"productCategory\" class=\"form-label\">Category</label>\r\n");
      out.write("              <select class=\"form-select form-control double-input\" id=\"productCategory\" name=\"product_category\" required>\r\n");
      out.write("                <option selected>");
      out.print(product.getProduct_category());
      out.write("</option>\r\n");
      out.write("                 ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                \r\n");
      out.write("              </select>\r\n");
      out.write("             \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-12 col-md-3\">\r\n");
      out.write("              <label for=\"productForGender\" class=\"form-label\">Gender</label>\r\n");
      out.write("              <select class=\"form-select form-control double-input\" id=\"productForGender\" name=\"gender\" required>\r\n");
      out.write("                <option selected>");
      out.print(product.getGender() );
      out.write("</option>\r\n");
      out.write("                <option value=\"Male\">Male</option>\r\n");
      out.write("                <option value=\"Female\">Female</option>\r\n");
      out.write("                <option value=\"Other\">Other</option>\r\n");
      out.write("              </select>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-12 col-md-3\">\r\n");
      out.write("              <label for=\"productColor\" class=\"form-label\">Color</label>\r\n");
      out.write("              <input type=\"text\" id=\"productColor\" class=\"form-control double-input\" name=\"product_color\"  value=\"");
      out.print(product.getProduct_color());
      out.write("\" required>\r\n");
      out.write("             \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-12 col-md-3\">\r\n");
      out.write("              <label for=\"productSize\" class=\"form-label\">Size</label>\r\n");
      out.write("              <input type=\"text\" id=\"productSize\" class=\"form-control double-input\" name=\"product_size\" placeholder=\"Enter the size\" value=\"");
      out.print(product.getProduct_size() );
      out.write("\" required>\r\n");
      out.write("             \r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"mb-3 row\">\r\n");
      out.write("            <div class=\"col-12 col-md-6\">\r\n");
      out.write("              <label for=\"productQty\" class=\"form-label\">Quantity</label>\r\n");
      out.write("              <input type=\"text\" id=\"productQty\" class=\"form-control double-input\" name=\"product_qty\" value=\"");
      out.print(product.getProduct_qty() );
      out.write("\">  required>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-12 col-md-6\">\r\n");
      out.write("              <label for=\"productImage\" class=\"form-label\">Upload Image</label>\r\n");
      out.write("              <input type=\"file\" id=\"productImage\" name=\"file\" accept=\"image/*\" class=\"form-control mt-1\" value=\"");
      out.print(product.getImage() );
      out.write("\" required>\r\n");
      out.write("              \r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"mb-3\">\r\n");
      out.write("            <label for=\"productDescription\" class=\"form-label\">Description</label>\r\n");
      out.write("            <textarea id=\"productDescription\" class=\"form-control mt-1\" rows=\"3\" name=\"product_desc\" placeholder=\"Enter product description\">");
      out.print(product.getProduct_desc());
      out.write("</textarea>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"mb-3  \">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-dark w-50 align-self-center mt-1\" id=\"addProduct\">Save</button>\r\n");
      out.write("          </div>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write(" ");
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

  private boolean _jspx_meth_c_005fforEach_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /admin/editProduct.jsp(84,17) name = items type = jakarta.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/admin/editProduct.jsp(84,17) '${list}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /admin/editProduct.jsp(84,17) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("cat");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                  <option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cat.getCategory_name()}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cat.getCategory_name()}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
