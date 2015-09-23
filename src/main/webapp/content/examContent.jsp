<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Question"
	import="java.util.ArrayList"%>
<% ArrayList<Question> myList = (ArrayList<Question>) request.getAttribute("questions"); 
	for(Question q : myList) {%>
	<p>chapter:  <%out.print(q.getChapter());%></p>
	<p>question name: <%out.print(q.getName());%></p>
	<p>question :<%out.print(q.getDescription());}%></p>