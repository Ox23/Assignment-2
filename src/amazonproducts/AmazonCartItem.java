package amazonproducts;

public class AmazonCartItem {
    // Attributes
    private AmazonProduct product;
    private int quantity;

    // Constructor
    public AmazonCartItem(AmazonProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Calculates the subtotal for the cart item
    public float calcSubTotal() {
        if (product == null) {
            return 0;
        }
        return product.getActualPrice() * quantity;
    }

    // Overrides toString to provide cart item details
    @Override
    public String toString() {
        if (product == null) {
            return "No product details available";
        }
        return "Product: " + product.getName() + ", Quantity: " + quantity + ", Subtotal: $" + calcSubTotal();
    }

    // Getters and Setters
    public AmazonProduct getProduct() {
        return product;
    }

    public void setProduct(AmazonProduct product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
