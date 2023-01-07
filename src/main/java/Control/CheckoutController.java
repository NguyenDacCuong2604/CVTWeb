// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CheckoutController.java

package Control;

import Entity.Account;
import Entity.Cart;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CheckoutController extends HttpServlet
{

    public CheckoutController()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        Account account = (Account)request.getSession().getAttribute("account");
        if(account == null)
        {
            response.sendRedirect("Login.jsp");
            return;
        }
        if(cart.getCart().isEmpty())
        {
            response.sendRedirect("Cart");
            return;
        } else
        {
            request.getRequestDispatcher("Checkout.jsp").forward(request, response);
            return;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.getRequestDispatcher("Checkout.jsp").forward(request, response);
    }
}
