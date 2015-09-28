<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Question" import="model.Exam"
	import="model.Answer" import="model.Choice"
	import="java.util.ArrayList"%>


<%
	Exam exam = (Exam) request.getSession().getAttribute("exam");
	int answered = 0;
	int correct = 0;
	Question question;
	for (int i = 0; i < exam.getQuestions().size(); i++) {
		question = exam.getQuestions().get(i);
		//checks if even
		if (i % 2 == 0) {
%>
			<p>
			chapter: <% out.print(question.getChapter()); %>
			</p>
<%
		}
%>
		<p>
		question: <% out.print(question.getName()); %>
		</p>
		<div class="radio">
		<% out.print(question.getDescription());%>
		<ul class="radio">
		<%
		// answer for question i
		Answer answer = exam.getAnswers().get(i);
		// choices for question i
		ArrayList<Choice> choices = exam.getChoices().get(i);
		for (int j = 0; j < choices.size(); j++) {
			%>
			<li><label> 
			<%
 			String buttonName = "id" + question.getQuestionId();
 			String value = "id" + choices.get(j).getChoiceId();
 			//test if the radio button has been selected
 			if (request.getParameter(buttonName) != null
 					&& request.getParameter(buttonName).equals(value)) {
 				answered++;
 				if (answer.getChoiceId() == choices.get(j).getChoiceId()) {
 	 				//out.print("<u>");
 	 				correct++;
 	 			}
 			%> 
			 <input name="<%out.print(buttonName);%>"
				value="<%out.print(value);%>"
				type="radio" checked="checked"> 
			<%
 			} 
 			// not selected
 			else {
 			%> <input name="<%out.print(buttonName);%>"
				value="<%out.print(value);%>"
				type="radio"> 
			<%
 			}
 			if (answer.getChoiceId() == choices.get(j).getChoiceId()) {
 				out.print("<u>");
 			}
 			out.print(choices.get(j).getDescription());
 			if (answer.getChoiceId() == choices.get(j).getChoiceId()){
 				out.print("</u>");
 			}
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
	You have answered
	<%
	out.print(answered);
%>
	answers. Of those there were
	<%
	out.print(correct);
%>
	correct. There were
	<%
	out.print(exam.getQuestions().size());
%>
	questions.
</p>
