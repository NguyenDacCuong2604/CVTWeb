// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrderDetailController.java

package Control;

import Dao.OrderDao;
import Entity.Account;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class OrderDetailController extends HttpServlet
{

    public OrderDetailController()
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
        String id_order = request.getParameter("id");
        OrderDao dao = new OrderDao();
        try
        {
            Entity.Order order = dao.getOrder(id_order);
            java.util.List list = dao.getProductsOrder(id_order);
            request.setAttribute("order", order);
            request.setAttribute("orderdetail", list);
            request.getRequestDispatcher("Orderdetail.jsp").forward(request, response);
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
