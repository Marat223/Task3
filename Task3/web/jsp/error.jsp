<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : error
    Created on : 08.07.2018, 15:37:03
    Author     : me
-->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
    <jsp:include page="/WEB-INF/jspf/header.jspf"/>
    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"/>

    Request from ${pageContext.errorData.requestURI} is failed
    <br/>
    Servlet name or type: ${pageContext.errorData.servletName}
    <br/>
    Status code: ${pageContext.errorData.statusCode}
    <br/>
    Exception: ${pageContext.errorData.throwable}
    <br/>
    Message: ${wrongAction}
    <br/>
    <!--TODO add link continue to work-->

    <jsp:include page="/WEB-INF/jspf/footer.jspf"/>
</jsp:root>
