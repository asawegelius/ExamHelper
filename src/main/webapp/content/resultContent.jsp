<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Question" import="model.Exam"
	import="model.Answer" import="model.Choice"
	import="java.util.ArrayList"%>


<%
	Exam exam = (Exam) request.getSession().getAttribute("exam");
	int correct = 0;
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
<%
	}
%>
<p>
	question:
	<%
	out.print(q.getName());
%>
</p>
<div class="radio">
	<%
		out.print(q.getDescription());
	%>
	<ul class="radio">
		<%
			Answer answer = exam.getAnswers().get(i);
				ArrayList<Choice> choices = exam.getChoices().get(i);
				for (int j = 0; j < choices.size(); j++) {
		%>
		<li><label> <%
 			String buttonName = "id" + q.getQuestionId();
 			String value = "id" + choices.get(j).getChoiceId();
 			if (request.getParameter(buttonName) != null &&request.getParameter(buttonName).equals(value)) {
 				correct ++;
 %> <input
				name="<%out.print(q.getQuestionId());%>"
				value="<%out.print("id" + choices.get(j).getChoiceId());%>"
				type="radio" checked="checked"> <%
 	} else {
 %> <input
				name="<%out.print(q.getQuestionId());%>"
				value="<%out.print("id" + choices.get(j).getChoiceId());%>"
				type="radio"> <%
 	}
 %> <%
 	if (answer.getChoiceId() == choices.get(j).getChoiceId())
 				out.print("<u>");
 			out.print(choices.get(j).getDescription());
 			if (answer.getChoiceId() == choices.get(j).getChoiceId())
 				out.print("</u>");
 %>
		</label></li>
		<%
			}
		%>
	</ul>
</div>
<%
	}
%>

<p>
	You had
	<%
	out.print( correct);
%>
	answers correct out of
	<%
	out.print(exam.getQuestions().size());
%>
	questions.
</p>
