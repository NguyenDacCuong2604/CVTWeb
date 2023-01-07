// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EditAccountController.java

package Control;

import Dao.AccountDao;
import Entity.Account;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class EditAccountController extends HttpServlet
{

    public EditAccountController()
    {
    }

    protected void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String fullName = request.getParameter("fullname");
        System.out.println(fullName);
        String phone = request.getParameter("telephone");
        System.out.println(phone);
        System.out.println(request.getParameter("sex"));
        int sex = Integer.parseInt(request.getParameter("sex"));
        Account account = (Account)request.getSession().getAttribute("account");
        account.setFullName(fullName);
        account.setPhoneNumber(phone);
        account.setSex(sex);
        try
        {
            AccountDao.updateAccount(account);
            request.getSession().setAttribute("account", account);
            response.sendRedirect("MyAccount.jsp");
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
