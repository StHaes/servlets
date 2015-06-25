package be.vdab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jeansmits on 24/06/15.
 */
@WebServlet(urlPatterns = "/filmrepository")
public class FilmServlet extends HttpServlet {
    private FilmRepository filmRepository = new FilmRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Film> l = filmRepository.findFilms();
        req.setAttribute("Films", l);
        req.getRequestDispatcher("/WEB-INF/Film.jsp").forward(req,resp);
    }

}
