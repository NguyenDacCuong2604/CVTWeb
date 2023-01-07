package Control;

import java.sql.SQLException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import Dao.AccountDao;
import Entity.Account;
import service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "RegisterController", value = { "/RegisterController" })
public class RegisterController extends HttpServlet
{
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final String firstname = request.getParameter("firstname");
        final String lastname = request.getParameter("lastname");
        final String email = request.getParameter("email");
        final String phone = request.getParameter("telephone");
        final String password = request.getParameter("password");
        final String verifyPassword = request.getParameter("confirm");
        final int newsletter = Integer.parseInt(request.getParameter("newsletter"));
        final int sex = Integer.parseInt(request.getParameter("male"));
        final String fullname =  firstname+" "+ lastname;
        try {
            final UserService service = new UserService();
            final Account account = service.findAccount(email);
            if (account == null) {
                final Account acountNew = new Account(email, password, fullname, phone, sex, newsletter);
                AccountDao.addAccount(acountNew);
                System.out.println(acountNew.toString());
                response.sendRedirect("Login.jsp");
            }
            else {
                request.getRequestDispatcher("Register.jsp").forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }
}