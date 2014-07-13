<%-- 
    Document   : temperature
    Created on : 30-Jun-2014, 11:06:16
    Author     : Jonathan Perry
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Temperature</title>
        <!-- insert template ? -->
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/context.css" />
    </head>
    <body id="wrapper">
        <t:menu>
            <jsp:attribute name="menu" />
        </t:menu>

        <div id="content-wrapper">
            
            <t:page-header>
                <jsp:attribute name="header" />
            </t:page-header>
            
        </div>
        
    </body>
</html>