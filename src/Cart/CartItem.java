package Cart;

import Product.Product;

public class CartItem {
    private Product product;
    private int quantity;

    CartItem(Product product, int quantity){
        this.product = product;
        product.checkAvailability(quantity);
        this.quantity = quantity;
    }

    public Product getProduct(){
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }
}
