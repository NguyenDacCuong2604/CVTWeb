package Control;

import Entity.Product;
import java.util.Iterator;
import java.util.Set;
import java.sql.SQLException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import service.Ulti;
import Dao.ProductDao;
import Dao.OrderDao;
import Entity.Cart;
import Entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "CheckOrderController", value = { "/CheckOrder" })
public class CheckOrderController extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final Account account = (Account)request.getSession().getAttribute("account");
        final Cart cart = (Cart)request.getSession().getAttribute("cart");
        if (account == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
        if (cart.getCart().isEmpty()) {
            response.sendRedirect("Cart");
        }
        final String username = account.getUsername();
        final String paymentText = request.getParameter("payment_method");
        final String payment = paymentText.equals("Cod") ? "Thanh to\u00e1n khi nh\u1eadn h\u00e0ng" : null;
        final String shipText = request.getParameter("shipping_method");
        final String ship = shipText.equals("1") ? "Giao h\u00e0ng ti\u1ebft ki\u1ec7m" : "Viettel Post";
        final int totalship = 30000;
        final String fullname = request.getParameter("fullname");
        final String numberphone = request.getParameter("phone");
        final String address = request.getParameter("address_detail")+", "+request.getParameter("phuongxa")+", "+request.getParameter("quanhuyen")+", "+request.getParameter("tinhthanh");
        final String comment = request.getParameter("comment");
        final OrderDao dao = new OrderDao();
        final ProductDao daoProduct = new ProductDao();
        try {
            final int total = cart.getTotalSum() + totalship;
            String id_order;
            for (id_order = Ulti.randomText(); !dao.checkIdOrder(id_order); id_order = Ulti.randomText()) {}
            dao.addOrder(id_order, username, payment, ship, totalship, total, fullname, numberphone, address, comment, cart.getCart().size());
            final Set<String> list = cart.getCart().keySet();
            for (final String s : list) {
                final Product p = daoProduct.getProduct(s);
                dao.addProductOrder(id_order, s, (int)cart.getCart().get(s), p.getPrice_buy() * cart.getCart().get(s));
            }
            cart.getCart().clear();
            request.getRequestDispatcher("Success.jsp").forward((ServletRequest)request, (ServletResponse)response);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }
}