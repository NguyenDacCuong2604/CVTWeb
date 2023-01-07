// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProductController.java

package Control;

import Dao.ProductDao;
import Entity.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ProductController extends HttpServlet
{

    public ProductController()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String id = request.getParameter("id");
        String category = null;
        String categoryName = null;
        List list = null;
        ProductDao dao = new ProductDao();
        try
        {
            Product product = dao.getProduct(id);
            list = dao.getProductsRelation(product.getCategory());
            if(product.getCategory() == 1)
            {
                category = "daythatlung";
                categoryName = "D\342y th\u1EAFt l\u01B0ng";
            } else
            if(product.getCategory() == 2)
            {
                category = "matthatlung";
                categoryName = "M\u1EB7t th\u1EAFt l\u01B0ng";
            } else
            {
                category = "thatlung";
                categoryName = "Th\u1EAFt l\u01B0ng nam";
            }
            request.setAttribute("listproduct", list);
            request.setAttribute("category", category);
            request.setAttribute("product", product);
            request.setAttribute("namecategory", categoryName);
            request.getRequestDispatcher("Product.jsp").forward(request, response);
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
