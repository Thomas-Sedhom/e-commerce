package Shipping;

import Cart.CartItem;
import Product.Product;

import java.util.List;

public class ShippingService {
    private List<CartItem> shippingItems;
    private Double totalWeight = 0.0;
    private final double feesPercentage = 0.05;
    private String shipmentNotice = "** Shipment notice ** \n";
    public ShippingService(List<CartItem> shippingItems){
        this.shippingItems = shippingItems;

        // calculate total fees and total weight
        for(CartItem cartItem: shippingItems){
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            totalWeight += product.getWeight() * quantity;
            shipmentNotice +=  quantity + "x " + product.getName() + " " + product.getWeight() * quantity + "g \n";
        }
        shipmentNotice += "Total package weight "+ totalWeight + "g \n";
    }
    public Double getTotalWeight(){
        return totalWeight;
    }

    public Double getTotalShippingFees(){
        return totalWeight * feesPercentage;
    }

    public void printInfo(){
        System.out.println(shipmentNotice);
    }
}
