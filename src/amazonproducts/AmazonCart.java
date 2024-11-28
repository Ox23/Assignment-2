package amazonproducts;

import java.util.*;

public class AmazonCart {
    private AmazonCustomer customer; // The customer who owns the cart
 
    public AmazonCart(AmazonCustomer customer) {
        this.customer = customer;
    }
}