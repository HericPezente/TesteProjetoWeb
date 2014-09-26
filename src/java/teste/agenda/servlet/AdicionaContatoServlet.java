/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contato contato= new Contato();
        contato.setNome(req.getParameter("nome"));
        contato.setEmail(req.getParameter("email"));
        contato.setEndereco(req.getParameter("endereco"));
        
        try{
            Calendar dataNascimento= Calendar.getInstance();
            dataNascimento.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dataNascimento")));
            contato.setDtNascimento(dataNascimento);
        }catch(ParseException e){
            e.printStackTrace();
        }
        
        //try{
            ContatoDao dao=new ContatoDao();
            dao.adiciona(contato);
            
        //}catch(Exception e){
        //    throw new ServletException(e);
        //}
        
        StringBuilder sb=new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(String.format("O contato %s foi adicionado com sucesso.",contato.getNome()));
        sb.append("<a href=\"adiciona-contato.html\">Voltar</a>");
        sb.append("</body>");
        sb.append("</html>");
        
        PrintWriter pw= resp.getWriter();
        pw.println(sb);
    }
    
    
    
}
