<%-- 
    Document   : lista-contatos
    Created on : 07/10/2014, 20:43:35
    Author     : MEUS DOCUMENTOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Contatos</title>
        <meta charset="UTF-8">
        
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
  
        <form action="lista-contatos" method="post">  
            Pesquisa:<input type="text" name="pesquisa"/>
            <input type="submit" value="Pesquisar"   >
        </form>
        <%--
        <input type="button" name="btPesquisa"   onclick="location.href='lista-contatos' " value="Pesquisar" >
        --%>
        
        <br/>
        <br/>
        <br/>
        <br/>
        
        <table border="0">
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Email</td>
                <td>Endereco</td>
                <td>Data de Nascimento</td>
            </tr>
            
            <c:forEach var="contato" items="${contatos}" varStatus="status">
            <tr>
                <td>${contato.id}</td>
                <%--<td>${status.index}</td>
                <td>${status.count}</td>--%>
                <td><a href="altera-contato?id=${contato.id}">${contato.nome}</a></td>
                
                <td><c:choose> 
                        <c:when test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email}</a>
                        </c:when>
                        <c:otherwise>
                            Sem email definido
                        </c:otherwise>    
                    </c:choose>
                </td>
                <td>${contato.endereco}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${contato.dtNascimento.time}"/></td>
                <td><a href="remove-contato?id=${contato.id}">Excluir</a></td>
            </tr>    
            </c:forEach>
            
        </table>
        <c:import url="rodape.jsp"/>
    </body>
</html>
