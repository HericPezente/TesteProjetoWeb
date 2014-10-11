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
import jdbc.modelo.Contato;

/**
 *
 * @author MEUS DOCUMENTOS
 */
@WebServlet("/remove-contato")
public class RemoveContatoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        ContatoDao dao=new ContatoDao();
        
        try{
            
         Contato contato=dao.buscaPorId(Long.valueOf(id));
         dao.remove(contato);
         
         req.setAttribute("contato",contato);
            RequestDispatcher rd=req.getRequestDispatcher("contato-removido.jsp");
            rd.forward(req, resp);
         
        }catch(SQLException e){
            throw new ServletException(e);
        } 
        
        
    }
    
}
