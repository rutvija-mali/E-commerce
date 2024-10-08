package com.demo.helper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/imageServlet")
public class imageServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String localPath = "C:\\Users\\rutvi\\OneDrive\\Desktop\\fashion-app\\my-fashion-app\\src\\main\\webapp\\images\\img.png";
		
		String filename = new File(localPath).getName();
		
		ServletContext context = request.getServletContext();
		String imagePath = context.getRealPath("img")+File.separator+"product"+File.separator+filename;
		
		try(FileOutputStream out = new FileOutputStream(imagePath);
			FileInputStream in = new FileInputStream(localPath)){
			
			byte[] data = new byte[1024];
			int byteRead = 0;
			
			while((byteRead = in.read(data)) != -1) {
				
				out.write(data, 0, byteRead);
			}
			
			   System.out.println("File uploaded successfully!");
			   
		        String imageUrl = request.getContextPath() + "/img/product/" +filename;
		       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error uploading file: " + e.getMessage());
        }
   
			
		
	}

}
