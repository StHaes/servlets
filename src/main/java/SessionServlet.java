import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeansmits on 24/06/15.
 */
@WebServlet(urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Session order</title><link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'><link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"></head>");
        bodySetup(out);
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Session Validation</title><link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'><link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"></head>");
        out.println("<body>");
        List<Order> orderlist = addOrderItem(req);
        displayOrders(out,orderlist);
        out.println("</body>");
        out.println("</html>");

    }

    private void bodySetup(PrintWriter out) {
        out.println("<body>");
        out.println("<h1>Your order?</h1>");
        out.println("<div><form action = 'session' method ='post'> Product<input type='text' name='product'/></div>");
        out.println("<div>Price<input type='number' name='price'/></div>");
        out.println("<div>Quantity<input type='number' name='quantity'/></div>");
        out.println("<div><input type='submit' value='Submit'/></div>");
        out.println("</form>");
        out.println("</body>");
    }
    private List<Order> addOrderItem(HttpServletRequest req) {
        HttpSession session = req.getSession();
        List<Order> order = (List<Order>) session.getAttribute("order");
        if(order == null) {
            order = new ArrayList<>();
        }
        String product = req.getParameter("product");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        order.add(new Order(product, quantity, price));
        session.setAttribute("order", order);
        return order;
    }
    private void displayOrders(PrintWriter writer, List<Order> orderList) {
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Product</td>");
        writer.println("<td>Price</td>");
        writer.println("<td>Quantity</td>");
        writer.println("</tr>");

        for (Order orderItem : orderList) {
            writer.println("<tr>");
            writer.println("<td>" + orderItem.getProduct() + "</td>");
            writer.println("<td>" + orderItem.getPrice() + "</td>");
            writer.println("<td>" + orderItem.getQuantity() + "</td>");
            writer.println("</tr>");
        }
    }
}
