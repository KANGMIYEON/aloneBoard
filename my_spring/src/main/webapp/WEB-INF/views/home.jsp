<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
	
		body{
			margin: 0;
			background-size: cover;
		}
	
		h1{
			text-align: center;
			height: 10px;
			padding: 50px 0px;
			color: #FFB0C4DE;
			font-size: 60px;
		}	
		
		img{
			margin: 100px 0px;
			width: 1000px;
			height : 500px;
			border-radius: 20px;
		}
		
		div{
			display: flex;
			justify-content: center;
		}
		
	</style>
</head>
<body>
<h1>
	Hello world!
</h1>

<div>
	<a href="/main"><img alt="" src="../resources/img/tree.jpg"></a>
</div>
</body>
</html>
