
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/championship.css" var="championshipCSS" />
<spring:url value="/resources/js/jquery-3.1.1.min.js" var="championshipJS" />
<link href="${championshipCSS}" rel="stylesheet" />

<title>Rock, Paper, Scissors Game</title>

<script type="text/javascript">
	var message = '<c:out value='${winnerData.winner}'/>';
	if(message != ''){
		//alert("Datos del ganador: "+ message);
		var resultsOfTheGame = '';
		var count = 0;
		<c:forEach var="data" items="${winnerData.winner}">
			if(count == 0){
				resultsOfTheGame = 'Winner\'s name: ' + '${data}';
			}
			else{
				resultsOfTheGame = resultsOfTheGame + ', Strategy: ' + '${data}';
			}
			count++;
		</c:forEach>
		alert('RESULT OF THE GAME: \n\n' + resultsOfTheGame);
	}
	
	function cleanDB(){
		
		if (confirm("Do you really want to delete the database content?"))
		{
			$.ajax({
		        type: "DELETE",
		        url: "deleteAllBDDataUI",
		        success: function (result) {
		        	alert("NOTICE: Database contents were deleted successfully!");
		            // do something.
		        },
		        error: function (result) {
		        	alert("ERROR: Database contents could'n not be deleted!");
		        }
		    });
		}
		
	}
	
	function watchTop10(){
		window.location.href = 'listTopPlayers';
	}
	
	function showFilesToDownload(){
		window.location.href = 'downloadExamples';
	}
	
	function readDocumentation(){
		window.location.href = 'readDocumentation';
	}
	
</script>
<script src="${championshipJS}"></script>
</head>

<body class="container">
	<form method="POST" action="uploadFile" enctype="multipart/form-data">
		<h2>Rock, Paper, Scissors Game</h2>
		<fieldset>
		<legend>Please select a file to upload</legend>
			<div class="rowForm">
				File to upload: <input type="file" name="file" class="fileButton"/>
			</div>
			<div class="rowForm">
				<input type="submit" value="Upload File"/>
			</div>
		</fieldset>
		<fieldset>
		<legend>Other actions</legend>
			<div class="rowForm">
				<input type="button" class="button" value="Clean up database" onclick = "cleanDB();"/>
				<input type="button" class="button" value="Watch top 10" onclick = "watchTop10();"/>
				<input type="button" class="button" value="Download examples" onclick = "showFilesToDownload();"/>
				<input type="button" class="button" value="Read Manual" onclick = "readDocumentation();"/>
			</div>
		</fieldset>
	</form>
</body>
</html>