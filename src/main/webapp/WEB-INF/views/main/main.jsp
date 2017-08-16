<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="main.js"></script>
	<title>Main</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<form id="rsturtInfoFrm" name="rsturtInfoFrm" >
	<input type="hidden" id="telNo" name="telNo" value="0319743439"/>
	<input type="hidden" id="addrSeq" name="addrSeq" value=""/>
	<input type="button" id="btnSave" name="btnSave" value=""/>
</form>
</body>
</html>
