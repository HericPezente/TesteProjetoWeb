<%-- 
    Document   : primeira-pagina
    Created on : 29/09/2014, 20:31:24
    Author     : MEUS DOCUMENTOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <%--comentário em JSP aqui: nossa primeira página JSP--%>
        
        <%
            String mensagem="Bem vindo";
        %>
        
        <% out.println(mensagem); %> <br/>
        
        <%
            String desenvolvido="Desenvolvido por Heric Walnier Pezente";
        %>
        
       <%=desenvolvido%> <br/>
       
       <%
        System.out.println("Este print sairá no console do tomcat");
       %>
    </body>
</html>
