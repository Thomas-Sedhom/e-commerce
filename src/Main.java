import Cart.Cart;
import Checkout.CheckoutService;
import Customer.Customer;
import Product.Product;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product(
                "Cheese",
                100,
                200,
                true,
                750.0,
                true,
                LocalDate.of(2026, 8, 22)
        );
        Product tv = new Product(
                "TV",
                5000,
                300,
                true,
                5000.0,
                false,
                null
        );

        Product scratchCard = new Product(
                "scratch card",
                1,
                50,
                false,
                0.0,
                false,
                null
        );
        Customer customer = new Customer("Thomas", 10000.0);
        Cart cart = new Cart();

        // try if the customer balance insufficient
        //  cart.addItem(cheese, 2);
        //  cart.addItem(tv, 3);
        //  cart.addItem(scratchCard, 1);

        // try if the customer make an order with a quantity greater than the remaining one
        // cart.addItem(cheese, 2);
        // cart.addItem(tv, 1);
        // cart.addItem(scratchCard, 1000);

        // The happy case
         cart.addItem(cheese, 2);
         cart.addItem(tv, 0);
         cart.addItem(scratchCard, 50);

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer, cart);
    }
}