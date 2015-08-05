<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<jsp:include page = "links.jsp"/>
</head>
<body>
<jsp:include page ="header.jsp"/>
<section id="error" class="container text-center">
        <h1>404, Page not found</h1>
        <p>The Page you are looking for doesn't exist or an other error occurred.</p>
        <a class="btn btn-primary" href="/home">GO BACK TO THE HOMEPAGE</a>
    </section><!--/#error-->
 <jsp:include page ="script.jsp"/>
 
</body>
</html>