// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginController.java

package Control;

import Entity.Account;
import Entity.Cart;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import service.UserService;

public class LoginController extends HttpServlet
{

    public LoginController()
    {
    }

    protected void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        try
        {
            UserService service = new UserService();
            Account account = service.findAccount(username, password);
            if(account == null)
            {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else
            {
                HttpSession session = request.getSession();
                session.setAttribute("account", account);
                session.setAttribute("cart", new Cart());
                response.sendRedirect("index.jsp");
            }
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
