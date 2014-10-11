<%-- 
    Document   : contato-removido
    Created on : 09/10/2014, 22:00:59
    Author     : MEUS DOCUMENTOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contato Removido</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        
        Contato ${contato.nome} removido com sucesso!
        
        <c:import url="rodape.jsp"/>
    </body>
</html>
