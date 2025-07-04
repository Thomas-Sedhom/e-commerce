package Checkout;
import Customer.Customer;
import Cart.Cart;
import Cart.CartItem;
import Product.Product;
import Shipping.ShippingService;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    ShippingService shippingService;
    public void checkout(Customer customer, Cart cart){

        // Check if cart is empty
        if(cart.getItems().isEmpty()){
            throw new IllegalArgumentException("The cart is empty");
        }

        Double totalFees;
        Double subTotal = 0.0;
        String checkoutReceipt = "** Checkout receipt **\n";
        List<CartItem> items = cart.getItems();
        List<CartItem> shippingItems = new ArrayList<CartItem>() ;

        // get total cost and
        for(CartItem cartItem: items){
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            if(product.canShippable){
                shippingItems.add(cartItem);
            }
            subTotal += product.getPrice() * quantity;
            checkoutReceipt +=  quantity + "x " + product.getName() + " " + product.getPrice() + "\n";
        }

        // add the shipping items to shipping service
        shippingService = new ShippingService(shippingItems);

        // total cost
        totalFees = shippingService.getTotalShippingFees();
        Double totalCost = subTotal + totalFees;

        // check customer balance
        if(customer.getBalance() < totalCost){
            throw new IllegalArgumentException("Insufficient balance. Total required: " + totalCost);
        }

        // update customer balance
        customer.decreaseBalance(totalCost);

        // update products quantity
        for(CartItem cartItem: items){
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            product.decreaseQuantity(quantity);
        }

        checkoutReceipt +=
            "--------------- \n" +
            "subTotal " + subTotal +
            "\nShipping " + totalFees +
            "\nAmount " + totalCost +
            "\nRemaining customer balance is: " + customer.getBalance();

        shippingService.printInfo();
        System.out.println(checkoutReceipt);
    }
}
