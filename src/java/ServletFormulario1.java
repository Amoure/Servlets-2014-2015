

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletFormulario1 extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException
    {
        String nom =request.getParameter("nombre");
        String cod=request.getParameter("codigo");
        AccesoBaseDatos b= new AccesoBaseDatos();
        response.setContentType("text/html");
       
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Datos de la Localidad</title></head");
        out.println("<body>");
        out.println("<h1>DATOS DE LA LOCALIDAD</h1>");
        out.println("<table border)\"5\">");
        out.println("<tr><td><b><h4>Los datos de la localidad son: </h4></b></td><td><i>"+b.Base(nom)+"</i></td></tr>");
        out.println("</table><p>");
        out.println("</body>");
        out.println("</html>");
        
    }
}
