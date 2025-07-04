package Product;

import java.time.LocalDate;

public class Product implements ShippingProduct {
    private final String name;
    private float price;
    private int quantity;

    public final boolean canShippable;
    private final Double weight;

    private final boolean canExpire;
    private final LocalDate expireDate;

    public Product(
            String name,
            float price,
            int quantity,
            boolean canShippable,
            Double weight,
            boolean canExpire,
            LocalDate expireDate
    ){
        this.name = name;
        this.price = price;
        this.quantity = quantity;

        this.canExpire = canExpire;
        if(canExpire){
            this.expireDate = expireDate;
        }else{
            this.expireDate = null;
        }
        this.canShippable = canShippable;
        if(canShippable){
            if(weight <= 0){
                throw new IllegalArgumentException("The Shippable products must have a weight");
            }
            this.weight = weight;
        }else{
            this.weight = 0.0;
        }
    }

    // Getters
    @Override
    public String getName(){
        return this.name;
    }

    public float getPrice(){
        return this.price;
    }

    public Double getWeight(){
        return this.weight;
    }

    public int getQuantity(){
        return this.quantity;
    }

    // Setters
    public void setPrice(float price){
        if(price <= 0){
            throw new IllegalArgumentException("Price should be greater than 0");
        }
        this.price = price;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    public boolean isExpired(){
        if(canExpire && LocalDate.now().isAfter(this.expireDate)){
            return true;
        }
        return false;
    }

    public void checkAvailability(int quantity){
        if(isExpired()){
            throw new IllegalArgumentException("This product is expired");
        }
        if(quantity > this.quantity){
            throw new IllegalArgumentException("There are only "+ this.quantity + " pieces of " + this.name);
        }
    }
    public void decreaseQuantity(int quantity){
        this.quantity -= quantity;
    }
}
