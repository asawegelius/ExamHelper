<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="randExam" class="model.Exam" scope="request" />

<c:forEach items="${questions}" var="randExam.getQuestions()">
	<p>
		chapter:
		${questions.getChapter()}
	</p>
	<p>
		question name:
		${questions.getName()}
	</p>
	<p>
		question :${questions.getDescription()}
	</p>
</c:forEach>