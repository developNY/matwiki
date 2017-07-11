<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
<script type="text/javascript">
	
	function testAjax(){
		
	}
	
</script>	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>
<p>param1 : <input type="text" id="param1"></p>
<p>param2 : <input type="text" id="param2"></p>
</div>
<a href="/matwiki/login"> 파라미터 테스트 </a>
</body>
</html>
