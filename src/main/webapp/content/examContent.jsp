<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Question" import="model.Exam"
	import="model.Choice" import="java.util.ArrayList"%>
	
<%
	Exam exam = (Exam) request.getAttribute("exam");
	Question q;
	for (int i = 0; i < exam.getQuestions().size(); i++) {
		q = exam.getQuestions().get(i);
		if (i % 2 == 0) {
%>
<p>
	chapter:
	<%
	out.print(q.getChapter());
		
%>
</p>
<% }%>
<p>
	question:
	<%
	out.print(q.getName());
%>
</p>
<div class="radio">
<% 
		out.print(q.getDescription());%>
<ul class="radio">
	<%
			ArrayList<Choice> choices = exam.getChoices().get(i);
			for (int j = 0; j < choices.size(); j++) {
	%>
	<li ><label> <input name="<% out.print(q.getQuestionId()); %>" id="<% out.print("id" + choices.get(j).getChoiceId()); %>" type="radio">
			<%
				out.print(choices.get(j).getDescription());
			%>
	</label></li>
	<%
		}
	%>
</ul>
</div>
<%}%>
