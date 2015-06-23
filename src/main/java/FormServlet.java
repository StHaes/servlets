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
@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        headerSetup(out);
        bodySetup(out);
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        headerSetup(out);
        out.println("<body>");
        out.println("<h1> Welkom " + req.getParameter("firstname") + " " + req.getParameter("lastname") + "</h1>");
        out.println("<p>Have a look around and tell us what you think!</p>");
        if (Integer.parseInt(req.getParameter("age"))< 30) {
            out.println("<p> You're "+ (30 - Integer.parseInt(req.getParameter("age")) + " years below 30 years old.</p>"));
        }
        out.println("</body>");
        out.println("</html>");

    }

    private void headerSetup(PrintWriter out) {
        out.println("<head><title>Fill in this form</title><link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'><link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"></head>");
    }

    private void bodySetup(PrintWriter out) {
        out.println("<body>");
        out.println("<h1>Please fill in this form</h1>");
        out.println("<div><form action = 'form' method ='post'> First Name<input type='text' name='firstname'/></div>");
        out.println("<div>Last Name<input type='text' name='lastname'/></div>");
        out.println("<div>Age<input type='number' name='age'/></div>");
        out.println("<div><input type='submit' value='Submit'/></div>");
        out.println("</form>");
        out.println("</body>");
    }
}
