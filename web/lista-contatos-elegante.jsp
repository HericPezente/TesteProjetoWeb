<%-- 
    Document   : lista-contatos-elegante
    Created on : 30/09/2014, 22:58:45
    Author     : MEUS DOCUMENTOS
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <!-- cria o DAO -->
        <jsp:useBean id="dao" class="jdbc.dao.ContatoDao"/>
        <c:import url="cabecalho.jsp"/>
        
        
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Endereço</th>
                <th>Data</th>
            </tr>
        <!--percorre contatos montando as linhas da tabela -->    
        <c:forEach var="contato" items="${dao.lista}">
        
            <tr>
                <td>${contato.nome}</td>
                <td>
                   <%-- <c:if test="${not empty contato.email}">
                        <a href="mailto:${contato.email}">${contato.email}</a>
                    </c:if>
                    <c:if test="${empty contato.email}">
                        E-mail não encontrado
                    </c:if>
                    --%>
                    <c:choose>
                        <c:when test="${not empty contato.email}">
                            <a href="mailto:${contato.email}">${contato.email} </a>
                        </c:when>
                            <c:otherwise>
                            Email não encontrado
                            </c:otherwise>    
                            
                    </c:choose>
                </td>
                <td>${contato.endereco}</td>
                <%-- <td> <fmt:formatDate type="date" value="${contato.dtNascimento.time}" /></td> --%>
                <td> <fmt:formatDate value="${contato.dtNascimento.time}" pattern="dd/MM/yyyy" /> </td>
                
                
                
            </tr>
        </c:forEach>
            
        </table>
        <c:import url="rodape.jsp"/>    
    </body>
    
</html>
