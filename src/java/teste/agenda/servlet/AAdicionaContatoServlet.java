/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.agenda.servlet;

import java.io.IOException;
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
@WebServlet("/add-contato")
public class AAdicionaContatoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        RequestDispatcher rd=req.getRequestDispatcher("adiciona-contato.jsp");
        rd.forward(req, resp);
    }

   /* @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service");
    }*/

    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        String nome=req.getParameter("nome");
        String endereco=req.getParameter("endereco");
        String email=req.getParameter("email");
        
        Contato contato= new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        try{
        if(req.getParameter("dataNascimento")!= null && !req.getParameter("dataNascimento").isEmpty()){
            Calendar dataNascimento= Calendar.getInstance();
            dataNascimento.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dataNascimento")));
            contato.setDtNascimento(dataNascimento);
        }
        }catch(ParseException e){
            throw new ServletException(e);
        }
        
        
            ContatoDao dao= new ContatoDao();
            dao.adiciona(contato);
        
        
        RequestDispatcher rd=req.getRequestDispatcher("contato-adicionado.jsp");
        rd.forward(req, resp);
        
        
        
    }
    
    
    
    
    
}
