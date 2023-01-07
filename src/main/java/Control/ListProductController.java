// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ListProductController.java

package Control;

import Dao.ProductDao;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ListProductController extends HttpServlet
{

    public ListProductController()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String cateId = request.getParameter("category");
        String category = null;
        ProductDao dao = new ProductDao();
        List list = null;
        try
        {
            if(cateId == null)
            {
                list = dao.getAllProducts();
                category = "Danh s\341ch s\u1EA3n ph\u1EA9m";
            } else
            if(cateId.equals("thatlung"))
            {
                list = dao.getAllProducts(3);
                category = "Th\u1EAFt l\u01B0ng nam";
            } else
            if(cateId.equals("matthatlung"))
            {
                list = dao.getAllProducts(2);
                category = "M\u1EB7t th\u1EAFt l\u01B0ng";
            } else
            if(cateId.equals("daythatlung"))
            {
                list = dao.getAllProducts(1);
                category = "D\342y th\u1EAFt l\u01B0ng";
            }
            request.setAttribute("list", list);
            request.setAttribute("category", category);
            request.setAttribute("id", cateId);
            System.out.println(cateId);
            request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
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
