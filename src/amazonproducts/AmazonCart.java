package amazonproducts;

import java.util.*;

public class AmazonCart {
    private AmazonCustomer customer; // The customer who owns the cart
 
    public AmazonCart(AmazonCustomer customer) {
        this.customer = customer;
    }
}
/*
    public void addItem(AmazonCartItem item) {
        // Add an item to the cart.
        items.add(item);
        System.out.println("Item added to cart successfully.");
    }

    public void removeItem(AmazonProduct product) {
        // Remove an item from the cart by product.
        items.removeIf(item -> item.getProduct().equals(product));
        System.out.println("Item removed from cart successfully.");
    }

   
         
        }
*/