package Cart;

import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity){
        CartItem cartItem = new CartItem(product, quantity);
        items.add(cartItem);
    }

    public List<CartItem> getItems(){
        return this.items;
    }
}
