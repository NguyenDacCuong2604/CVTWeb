package Entity;

public class ProductOrder
{
    private int id;
    private String id_order;
    private String id_product;
    private int quantity;
    private int total;
    
    public ProductOrder(final int id, final String id_order, final String id_product, final int quantity, final int total) {
        this.id = id;
        this.id_order = id_order;
        this.id_product = id_product;
        this.quantity = quantity;
        this.total = total;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getId_order() {
        return this.id_order;
    }
    
    public void setId_order(final String id_order) {
        this.id_order = id_order;
    }
    
    public String getId_product() {
        return this.id_product;
    }
    
    public void setId_product(final String id_product) {
        this.id_product = id_product;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}