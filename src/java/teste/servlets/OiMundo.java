/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MEUS DOCUMENTOS
 */
@WebServlet(name="MinhaServelt",  urlPatterns = {"/oi","/ola"})
public class OiMundo extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        
        //escrete o texto
        
        out.println("<html>");
        out.println("<body>");
        out.println("Oi mundo!");
        out.println("</body>");
        out.println("</html>");
    }
    
}
