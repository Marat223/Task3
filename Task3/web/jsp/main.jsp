<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : main
    Created on : 08.07.2018, 15:22:22
    Author     : me
-->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">

    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
    <jsp:include page="/WEB-INF/jspf/header.jspf"/>
    ${user}, hello!
    <br/>
    <form action="controller" method="POST">
	<input type="hidden" name="command" value="logout"/>
	<input type="submit" value="Logout" />
    </form><br/>
    ${requestScope.uploadState}
    <form name="UploadForm" action="upload" enctype="multipart/form-data" method="POST">
        Select file to upload: <input type="file" name="file" size="60" /><br/>
        <br/> <input type="submit" value="Upload"/>
    </form>
    <jsp:include page="/WEB-INF/jspf/footer.jspf"/>
</jsp:root>
