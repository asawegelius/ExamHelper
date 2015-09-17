<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/login.css">
<title>Exam Helper</title>
</head>
<body>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/
ajax/libs/jquery/1.5/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$(".tab").click(function() {
				var X = $(this).attr('id');

				if (X == 'signup') {
					$("#login").removeClass('select');
					$("#signup").addClass('select');
					$("#loginbox").slideUp();
					$("#signupbox").slideDown();
				} else {
					$("#signup").removeClass('select');
					$("#login").addClass('select');
					$("#signupbox").slideUp();
					$("#loginbox").slideDown();
				}

			});

		});
	</script>
	<%@ include file="header.jsp"%>
	<%@ include file="navbar.jsp"%>
	<%@ include file="content/loginContent.jsp"%>
	<jsp:include page="footer.jsp" />
</body>
</html>