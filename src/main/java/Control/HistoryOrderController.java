// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HistoryOrderController.java

package Control;

import Dao.OrderDao;
import Entity.Account;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HistoryOrderController extends HttpServlet
{

    public HistoryOrderController()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        Account account = (Account)request.getSession().getAttribute("account");
        if(account == null)
        {
            response.sendRedirect("Login.jsp");
            return;
        }
        OrderDao dao = new OrderDao();
        try
        {
            java.util.List list = dao.getAllOrders(account.getUsername());
            request.setAttribute("listorder", list);
            request.getRequestDispatcher("HistoryOrder.jsp").forward(request, response);
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

    protected void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
    }
}
