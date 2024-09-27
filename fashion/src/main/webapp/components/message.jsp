<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  String message = (String)session.getAttribute("message");
  if(message != null){
%>
   <div class="alert alert-success alert-dismissible fade show" role="alert" id="alert-message">
	  <strong>${message}</strong> 
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div>

<% 	  
	  session.removeAttribute("message");
  }
%>
