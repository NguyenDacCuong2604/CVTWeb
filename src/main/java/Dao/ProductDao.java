package Dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import Connect.DataDB;
import Entity.Product;

public class ProductDao
{
    public Product getProduct(final String id) throws SQLException, ClassNotFoundException {
        DataDB db = new DataDB();
        DataDB db2 = new DataDB();
        PreparedStatement sta = db.getStatement("select * from product where id_product=?");
        sta.setString(1, id);
        ResultSet rs = sta.executeQuery();
        Product product = null;
        while (rs.next()) {
            List<String> images = new ArrayList<String>();
            String id_product = rs.getString("id_product");
            PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add("Image/"+rsImg.getString("link"));
            }
            product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), images);
        }
        return product;
    }
    
    public List<Product> getProductsBestSeller() throws SQLException, ClassNotFoundException {
        List<Product> list = new ArrayList<Product>();
        DataDB db = new DataDB();
        DataDB db2 = new DataDB();
        PreparedStatement sta = db.getStatement("select * from product ORDER BY products_sold DESC limit 0, 3");
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            List<String> images = new ArrayList<String>();
            String id_product = rs.getString("id_product");
            PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add("Image/"+rsImg.getString("link"));
            }
            Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), images);
            list.add(product);
        }
        return list;
    }
    
    public List<Product> getProductsRelation(final int category) throws SQLException, ClassNotFoundException {
        List<Product> list = new ArrayList<Product>();
        DataDB db = new DataDB();
        DataDB db2 = new DataDB();
        PreparedStatement sta = db.getStatement("select * from product  where category = ? limit 0, 10");
        sta.setInt(1, category);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            List<String> images = new ArrayList<String>();
            String id_product = rs.getString("id_product");
            PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add("Image/"+rsImg.getString("link"));
            }
            Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), (List)images);
            list.add(product);
        }
        return list;
    }
    
    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
        List<Product> list = new ArrayList<Product>();
        DataDB db = new DataDB();
        DataDB db2 = new DataDB();
        PreparedStatement sta = db.getStatement("select * from product");
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            List<String> images = new ArrayList<String>();
            String id_product = rs.getString("id_product");
            PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add("Image/"+rsImg.getString("link"));
            }
            Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), images);
            list.add(product);
        }
        return list;
    }
    
    public List<Product> getAllProducts(final int category) throws SQLException, ClassNotFoundException {
        List<Product> list = new ArrayList<Product>();
        DataDB db = new DataDB();
        DataDB db2 = new DataDB();
        PreparedStatement sta = db.getStatement("select * from product where category=?");
        sta.setInt(1, category);
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            List<String> images = new ArrayList<String>();
            String id_product = rs.getString("id_product");
            PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add("Image/"+rsImg.getString("link"));
            }
            Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), images);
            list.add(product);
        }
        return list;
    }
    
    public static void main(final String[] args) throws SQLException, ClassNotFoundException {
        ProductDao dao = new ProductDao();
        List<Product> list = dao.getAllProducts(3);
        for (Product p : list) {
            System.out.println(p.toString());
        }
    }
}