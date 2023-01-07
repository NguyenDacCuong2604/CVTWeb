package Entity;

import java.util.List;

public class Product
{
    private String id;
    private String name;
    private int price;
    private String brand;
    private int category;
    private String stock;
    private int price_buy;
    private int quantity;
    private int product_sold;
    private String detail;
    private List<String> images;
    
    public Product(final String id, final String name, final int price, final String brand, final int category, final String stock, final int price_buy, final int quantity, final int product_sold, final String detail, final List<String> images) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.stock = stock;
        this.price_buy = price_buy;
        this.quantity = quantity;
        this.product_sold = product_sold;
        this.detail = detail;
        this.images = images;
    }
    
    public int getCategory() {
        return this.category;
    }
    
    public void setCategory(final int category) {
        this.category = category;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(final int price) {
        this.price = price;
    }
    
    public List<String> getImages() {
        return this.images;
    }
    
    public void setImages(final List<String> images) {
        this.images = images;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(final String brand) {
        this.brand = brand;
    }
    
    public String getStock() {
        return this.stock;
    }
    
    public void setStock(final String stock) {
        this.stock = stock;
    }
    
    public int getPrice_buy() {
        return this.price_buy;
    }
    
    public void setPrice_buy(final int price_buy) {
        this.price_buy = price_buy;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
    
    public int getProduct_sold() {
        return this.product_sold;
    }
    
    public void setProduct_sold(final int product_sold) {
        this.product_sold = product_sold;
    }
    
    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(final String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                ", stock='" + stock + '\'' +
                ", price_buy=" + price_buy +
                ", quantity=" + quantity +
                ", product_sold=" + product_sold +
                ", detail='" + detail + '\'' +
                ", images=" + images +
                '}';
    }
}