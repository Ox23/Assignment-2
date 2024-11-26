package amazonproducts;

public class AmazonCartItem {
    private AmazonProduct product; // The product being added to the cart
    private int quantity; // Quantity of the product

    public AmazonCartItem(AmazonProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public AmazonProduct getProduct() {
        return product;
    }

    public String getDetails() {
        // Return details of the cart item.
        return String.format("Product: %s, Quantity: %d", product.getName(), quantity);
    }
}