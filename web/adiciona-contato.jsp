<%-- 
    Document   : adiciona-contato
    Created on : 07/10/2014, 22:17:49
    Author     : MEUS DOCUMENTOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Adiciona Contatos</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        <form action="add-contato" method="post">
            Nome:<input type="text" name="nome"/> <br/>
            E-mail:<input type="text" name="email"/> <br/>
            Endereco:<input type="text" name="endereco"/> <br/>
            Data Nascimento:<input type="date" name="dataNascimento"/> <br/>
            <input type="submit" value="Gravar">
            
        </form>
        <c:import url="rodape.jsp"/>    
    </body>
</html>
