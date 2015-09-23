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
		}
%>
</p>
<p>
	question:
	<%
	out.print(q.getName());
%>
</p>

<ul class="choices">
	<%
		out.print(q.getDescription());
			ArrayList<Choice> choices = exam.getChoices().get(i);
			for (int j = 0; j < choices.size(); j++) {
	%>
	<li><label> <input data-key="a" type="radio">
			<%
				out.print(choices.get(j).getDescription());
			%>
	</label></li>
	<%
		}
	%>
</ul>
<%
	}
%>
