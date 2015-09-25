<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Question" import="model.Exam"
	import="model.Answer" import="model.Choice" import="java.util.ArrayList"%>
	
		
<%
	Exam exam = (Exam) request.getAttribute("exam");
%>
	<p>
		You had <%out.print("blabla"); %> answers correct out of <%out.print(exam.getQuestions().size()); %> questions.
	</p>
