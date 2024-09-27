package com.demo.product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductSaveServlet"})
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
	    maxFileSize = 1024 * 1024 * 10,      // 10 MB
	    maxRequestSize = 1024 * 1024 * 15    // 15 MB
	)
public class ProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
         PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		System.out.println(action);
		String productName = request.getParameter("product_name");
	    int productPrice = Integer.parseInt(request.getParameter("product_price"));
	    String productCategory = request.getParameter("product_category");
	    String gender = request.getParameter("gender");
	    String productColor = request.getParameter("product_color");
	    int productSize = Integer.parseInt(request.getParameter("product_size"));
	    int productQty = Integer.parseInt(request.getParameter("product_qty"));
	    String productDescription = request.getParameter("product_desc");
	    int originalPrice = Integer.parseInt(request.getParameter("original_price"));
	    int discount = (int)(((originalPrice - productPrice)/originalPrice)*100);
	    
	    System.out.println("in product servlet : "+productName+" "+productPrice+" "+productCategory+" "+gender+" "+productColor+" "+productSize+" "+productQty+" "+productDescription+" "+originalPrice+" "+discount);
	    
	    Product product = new Product();
	    product.setProduct_name(productName);
	    product.setProduct_price(productPrice);
	    product.setProduct_category(productCategory);
	    product.setGender(gender);
	    product.setProduct_color(productColor);
	    product.setProduct_size(productSize);
	    product.setProduct_qty(productQty);
	    product.setProduct_desc(productDescription);
	    product.setOriginal_price(originalPrice);
	    product.setDiscount(discount);
	    
	   
	    System.out.println(request.getContentType());
	    
	    if(request.getContentType() != null && request.getContentType().toLowerCase().startsWith("multipart/")){
	    	   Part part = request.getPart("file");
	    	  String fileName = part.getSubmittedFileName();
	    	   ServletContext context =  request.getServletContext();
	    	   String path = context.getRealPath("img")+ File.separator+"product"+File.separator+fileName;
	    	   product.setImage(fileName);
	    	   
	    	   
	    	   try( FileOutputStream fos = new FileOutputStream(path);
	    	        InputStream is = part.getInputStream();){
	    		   
	    		   byte data[] = new byte[is.available()];
	    		   
	    		   is.read(data);
	    		   fos.write(data);
	    		   
	    		   
	    	   }catch(Exception e) {
	    		   
	    		   e.printStackTrace();
	    		   System.out.println("Error uploading file "+e.getMessage());
	    	   }
	    	
	    }
	    
	    if(action.equals("save"))
	    {
	        save(product, session, request,response, out);	 
	    }else
	    if(action.equals("update")) {
	    	 int id = Integer.parseInt(request.getParameter("product_id"));
	    	 product.setId(id);
	    	 System.out.println("update product:"+product);
	    	 System.out.println("update");
	    	update(product, session, request, response,out);
	    }
		 
	}
	
	private void save(Product product,HttpSession session,HttpServletRequest request,HttpServletResponse response,PrintWriter out) {
		 try {
 	         int status = ProductDao.save(product);
 	         if (status > 0) {
 	        	 
 	          
 	            session.setAttribute("message","Product saved successfully!");
 	            RequestDispatcher dispatch = request.getRequestDispatcher("/admin/addProduct.jsp");
 	            
 				dispatch.forward(request, response);
 	       } 
 		     } catch (Exception e) {
 		         out.println("<p>Database error: " + e.getMessage() + "</p>");
 		         e.printStackTrace(); // Print stack trace for debugging
 		     }
	}
	
	private void update(Product product , HttpSession session , HttpServletRequest request,HttpServletResponse response, PrintWriter out) {
		try {
	         int status = ProductDao.update(product);
	         
	         System.out.println("status of update : "+status);
	         
	         if (status > 0) {
	        	 
	           
	             session.setAttribute("message","Product updated successfully!");
	             RequestDispatcher dispatch = request.getRequestDispatcher("/function/getAllProducts.jsp");
	             dispatch.forward(request, response);
	             
	         } 
	     } catch (Exception e) {
	         out.println("<p>Database error: " + e.getMessage() + "</p>");
	         e.printStackTrace(); // Print stack trace for debugging
	     }
	}

}
