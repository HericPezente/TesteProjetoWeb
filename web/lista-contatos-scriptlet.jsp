<%-- 
    Document   : lista-contatos-scriptlet
    Created on : 29/09/2014, 20:50:53
    Author     : MEUS DOCUMENTOS
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="jdbc.dao.ContatoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <body>
        <%="Desenvolvido por Heric Walnier Pezente"%> <br/> <br/>
         <table border="1">
             <tr>
                 <th>NOME</th>
                 <th>EMAIL</th>
                 <th>ENDERECO</th>
                 <th>DATA</th>
             </tr>
             <%
                ContatoDao dao= new ContatoDao();
                List<Contato> contatos=dao.getLista();
                
                for(Contato contato:contatos){
             %>
             
             <tr>
                 <td><%=contato.getNome()%></td>
                 <td><%=contato.getEmail()%></td>
                 <td><%=contato.getEndereco()%></td>
                 <td><%=DateFormat.getInstance().format(contato.getDtNascimento().getTime())%></td>
             </tr>
             <%
                }
             %>
         </table>
    </body>
</html>
