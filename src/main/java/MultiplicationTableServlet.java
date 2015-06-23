import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jeansmits on 23/06/15.
 */
@WebServlet(urlPatterns = "/multiply")
public class MultiplicationTableServlet extends HttpServlet{
    private static final String CONTENT_TYPE= "text/html";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        String name = "Smeagol";
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Hello World</title><link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'><link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"></head>");
        out.println("<body>");
        out.println("<h1>This is " + name +" his table</h1>");
        printTable(out);
        out.println("</body></html>");
    }
    private void printTable(PrintWriter out){
        out.println("<table>");
        for (int x =1; x<=10;x++){
            out.println("<tr>");
            for(int y=1;y<=10;y++){
                out.println("<td>" + x*y + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
