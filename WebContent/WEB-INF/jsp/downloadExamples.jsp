
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/championship.css" var="championshipCSS" />
<spring:url value="/resources/files/download" var="championshipFiles" />
<link href="${championshipCSS}" rel="stylesheet" />


<title>Download Example Files</title>

<script>
	function goBack(){
		window.location.href = 'rockPaperScissors';
	}
</script>
</head>
<body class="container">
<h1>Download Example Files</h1>
	<table cellspacing=0>
		<tr>
			<th scope="col">FileName</tr>
		<tr>
		<tr>
			<td><a href="${championshipFiles}/Tournament1.txt">Tournament1.txt</a></td>
		</tr>
		<tr>
			<td><a href="${championshipFiles}/Tournament2.txt">Tournament2.txt</a></td>
		</tr>
		<tr>
			<td><a href="${championshipFiles}/Tournament3.txt">Tournament3.txt</a></td>
		</tr>
		<tr>
			<td><a href="${championshipFiles}/Tournament4.txt">Tournament4.txt</a></td>
		</tr>
		</tbody>
	</table>
	<div class="rowForm">
		<input type="button" class="button" value="Go Back" onclick = "goBack();"/>
	</div>
</body>
</html>