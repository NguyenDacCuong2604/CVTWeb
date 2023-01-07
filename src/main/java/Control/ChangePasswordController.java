// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 1/7/2023 10:48:59 AM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ChangePasswordController.java

package Control;

import Dao.AccountDao;
import Entity.Account;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ChangePasswordController extends HttpServlet
{

    public ChangePasswordController()
    {
    }

    protected void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        Account account = (Account)request.getSession().getAttribute("account");
        if(account == null)
        {
            response.sendRedirect("Login.jsp");
            return;
        }
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String confirm = request.getParameter("confirm");
        if(account.getPassword().equals(password))
        {
            if(newpassword.equals(confirm))
            {
                account.setPassword(newpassword);
                try
                {
                    AccountDao.updatePassword(account);
                    request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
                }
                catch(SQLException e)
                {
                    throw new RuntimeException(e);
                }
                catch(ClassNotFoundException e)
                {
                    throw new RuntimeException(e);
                }
            } else
            {
                request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
            }
        } else
        {
            request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
        }
    }
}
