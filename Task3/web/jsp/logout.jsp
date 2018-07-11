<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : logout
    Created on : 08.07.2018, 19:06:07
    Author     : me
-->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">

    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
    <jsp:include page="/WEB-INF/jspf/header.jspf"/>
    <form action="controller" method="POST">
	<input type="hidden" name="command" value="logout"/>
	<input type="submit" value="Logout"/>
    </form>
    <br/>
    ${wrongActionMessage}
    <jsp:include page="/WEB-INF/jspf/footer.jspf"/>

</jsp:root>
