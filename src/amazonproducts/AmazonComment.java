package amazonproducts;

public class AmazonComment {
    private AmazonProduct product; // Product that the comment refers to
    private String comment; // Comment text
    private float rating; // Rating given by the customer

    public AmazonComment(AmazonProduct product, String comment, float rating) {
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }

    public String getCommentDetails() {
        // Return the comment details as a formatted string.
        return String.format("Product: %s | Comment: %s | Rating: %.2f", product.getName(), comment, rating);
    }
}
