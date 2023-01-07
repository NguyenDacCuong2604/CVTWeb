package Dao;

import java.util.Iterator;
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
        final DataDB db = new DataDB();
        final DataDB db2 = new DataDB();
        final PreparedStatement sta = db.getStatement("select * from product where id_product=?");
        sta.setString(1, id);
        final ResultSet rs = sta.executeQuery();
        Product product = null;
        while (rs.next()) {
            final List<String> images = new ArrayList<String>();
            final String id_product = rs.getString("id_product");
            final PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            final ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add(rsImg.getString("link"));
            }
            product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), (List)images);
        }
        return product;
    }
    
    public List<Product> getProductsBestSeller() throws SQLException, ClassNotFoundException {
        final List<Product> list = new ArrayList<Product>();
        final DataDB db = new DataDB();
        final DataDB db2 = new DataDB();
        final PreparedStatement sta = db.getStatement("select * from product ORDER BY products_sold DESC limit 0, 3");
        final ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            final List<String> images = new ArrayList<String>();
            final String id_product = rs.getString("id_product");
            final PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            final ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add(rsImg.getString("link"));
            }
            final Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), (List)images);
            list.add(product);
        }
        return list;
    }
    
    public List<Product> getProductsRelation(final int category) throws SQLException, ClassNotFoundException {
        final List<Product> list = new ArrayList<Product>();
        final DataDB db = new DataDB();
        final DataDB db2 = new DataDB();
        final PreparedStatement sta = db.getStatement("select * from product  where category = ? limit 0, 10");
        sta.setInt(1, category);
        final ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            final List<String> images = new ArrayList<String>();
            final String id_product = rs.getString("id_product");
            final PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            final ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add(rsImg.getString("link"));
            }
            final Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), (List)images);
            list.add(product);
        }
        return list;
    }
    
    public List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
        final List<Product> list = new ArrayList<Product>();
        final DataDB db = new DataDB();
        final DataDB db2 = new DataDB();
        final PreparedStatement sta = db.getStatement("select * from product");
        final ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            final List<String> images = new ArrayList<String>();
            final String id_product = rs.getString("id_product");
            final PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            final ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add(rsImg.getString("link"));
            }
            final Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), (List)images);
            list.add(product);
        }
        return list;
    }
    
    public List<Product> getAllProducts(final int category) throws SQLException, ClassNotFoundException {
        final List<Product> list = new ArrayList<Product>();
        final DataDB db = new DataDB();
        final DataDB db2 = new DataDB();
        final PreparedStatement sta = db.getStatement("select * from product where category=?");
        sta.setInt(1, category);
        final ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            final List<String> images = new ArrayList<String>();
            final String id_product = rs.getString("id_product");
            final PreparedStatement staImg = db2.getStatement("select * from imageproduct where id_product=?");
            staImg.setString(1, id_product);
            final ResultSet rsImg = staImg.executeQuery();
            while (rsImg.next()) {
                images.add(rsImg.getString("link"));
            }
            final Product product = new Product(rs.getString("id_product"), rs.getString("name"), rs.getInt("price"), rs.getString("brand"), rs.getInt("category"), rs.getString("stock"), rs.getInt("price_buy"), rs.getInt("quantity"), rs.getInt("products_sold"), rs.getString("detail"), (List)images);
            list.add(product);
        }
        return list;
    }
    
    public static void main(final String[] args) throws SQLException, ClassNotFoundException {
        final ProductDao dao = new ProductDao();
        final List<Product> list = dao.getAllProducts(3);
        for (final Product p : list) {
            System.out.println(p.toString());
        }
    }
}