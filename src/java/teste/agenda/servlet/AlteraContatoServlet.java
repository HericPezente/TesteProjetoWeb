/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.agenda.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
@WebServlet("/altera-contato")
public class AlteraContatoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String id=req.getParameter("id");
            ContatoDao dao= new ContatoDao();
             Contato contato=dao.buscaPorId(Long.valueOf(id));
             req.setAttribute("contato",contato);
             RequestDispatcher rd=req.getRequestDispatcher("altera-contato.jsp");
             rd.forward(req, resp);
        }catch(SQLException e){
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("passo 1");
      String id=req.getParameter("id");
      String nome=req.getParameter("nome");
      String email=req.getParameter("email");
      String endereco=req.getParameter("endereco");
      
      System.out.println("passo 2");
      
      Contato contato=new Contato();
      contato.setId(Long.valueOf(id));
      contato.setNome(nome);
      contato.setEmail(email);
      contato.setEndereco(endereco);
            System.out.println("passo 3");
      try{
        if(req.getParameter("dataNascimento")!= null){
            System.out.println("passo 4");
            Calendar dtNascimento= Calendar.getInstance();
            dtNascimento.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dataNascimento")));
            contato.setDtNascimento(dtNascimento);
            System.out.println("passo 5");
         }
      }catch(ParseException e){
          throw new ServletException(e);
      }
      
                System.out.println("passo 6");
          ContatoDao dao= new ContatoDao();
          dao.altera(contato);
                System.out.println("passo 7");
          RequestDispatcher rd= req.getRequestDispatcher("contato-alterado.jsp");
          rd.forward(req, resp);
                System.out.println("passo 8");
    }
    
    
    
    
}
