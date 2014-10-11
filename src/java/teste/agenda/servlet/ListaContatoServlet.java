/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.agenda.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.dao.ContatoDao;

/**
 *
 * @author MEUS DOCUMENTOS
 */
@WebServlet("/lista-contatos")
public class ListaContatoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
        
            ContatoDao dao= new ContatoDao();
            req.setAttribute("contatos",dao.getLista());
            
            RequestDispatcher rd=req.getRequestDispatcher("lista-contatos.jsp");
            rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
            ContatoDao dao= new ContatoDao();
            
            String parametro=req.getParameter("pesquisa");
            if(parametro != null){
                try{
                req.setAttribute("contatos",dao.buscaPorNome(parametro));
                }catch(SQLException e){
                    throw  new ServletException(e);
                }
            }
            
            
             RequestDispatcher rd=req.getRequestDispatcher("lista-contatos.jsp");
             rd.forward(req, resp);
    }
    
    
}
