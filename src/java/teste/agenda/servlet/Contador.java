/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MEUS DOCUMENTOS
 */
public class Contador extends HttpServlet{
    int contador;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        log("Iniciando servlet Contador");
    }

    
    
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        contador++;
        
        PrintWriter out= resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Contador agora e:"+contador);
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        log("Destruindo servlet Contador");
    }
    
    
    
}
