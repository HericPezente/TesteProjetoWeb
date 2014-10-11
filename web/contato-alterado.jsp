<%-- 
    Document   : contato-alterado
    Created on : 08/10/2014, 23:40:59
    Author     : MEUS DOCUMENTOS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contato Alterado</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        Contato ${param.nome} alterado com sucesso!
        <c:import url="rodape.jsp"/>
    </body>
</html>
