<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : login
    Created on : 06.07.2018, 12:57:57
    Author     : me
-->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">

    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
    <jsp:include page="/WEB-INF/jspf/header.jspf"/>
    <form name="LoginForm" action="controller" method="POST">
	<input type="hidden" name="command" value="login"/>
	Login<input type="text" maxlength="11" name="login" required=""/><br/>
	Password<input type="password" maxlength="11" name="password" required=""/><br/>
	<input type="submit" value="Send"/>
    </form>
    <br/>
    ${errorAuthMessage}
    <br/>
    ${wrongActionMessage}
    <jsp:include page="/WEB-INF/jspf/footer.jspf"/>
</jsp:root>
