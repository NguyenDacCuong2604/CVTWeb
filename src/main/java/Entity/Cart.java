package Entity;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import Dao.ProductDao;
import java.util.HashMap;
import java.util.Map;

public class Cart
{
    private Map<String, Integer> cart;
    
    public Cart(final Map<String, Integer> cart) {
        this.cart = cart;
    }
    
    public Cart() {
        this.cart = new HashMap<String, Integer>();
    }
    
    public Map<String, Integer> getCart() {
        return this.cart;
    }
    
    public void setCart(final Map<String, Integer> cart) {
        this.cart = cart;
    }
    
    public void addProductUpdate(final String id, final int quantity) {
        if (this.cart.containsKey(id)) {
            this.cart.put(id, this.cart.get(id) + quantity);
        }
        else {
            this.cart.put(id, quantity);
        }
    }
    
    public void addProduct(final String id, final int quantity) {
        this.cart.put(id, quantity);
    }
    
    public int getTotalSum() throws SQLException, ClassNotFoundException {
        final ProductDao dao = new ProductDao();
        int sum = 0;
        final Set<String> list = this.cart.keySet();
        for (final String id : list) {
            final Product product = dao.getProduct(id);
            sum += product.getPrice_buy() * this.cart.get(id);
        }
        return sum;
    }
}