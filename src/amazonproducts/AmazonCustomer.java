package amazonproducts;
import java.util.ArrayList;
import java.util.List;

public class AmazonCustomer {
    private int id;
    private String name;
    private String address;
    private List<AmazonProduct> wishList = new ArrayList<>(); // Wishlist of products
    private AmazonCart cart = new AmazonCart(this); // Cart for the customer
    private List<AmazonComment> comments = new ArrayList<>(); // Comments for products

    public AmazonCustomer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void addProductToWishList(AmazonProduct product) {
        // Add a product to the wishlist.
        if (!wishList.contains(product)) {
            wishList.add(product);
            System.out.println("Product added to wishlist successfully.");
        } else {
            System.out.println("Product is already in wishlist.");
        }
    }

    public void removeProductFromWishList(AmazonProduct product) {
        // Remove a product from the wishlist.
        if (wishList.contains(product)) {
            wishList.remove(product);
            System.out.println("Product removed from wishlist successfully.");
        } else {
            System.out.println("Product not found in wishlist.");
        }
    }

    public void showWishList() {
        // Display all products in the wishlist.
        if (wishList.isEmpty()) {
            System.out.println("Wishlist is empty.");
        } else {
            for (AmazonProduct product : wishList) {
                System.out.println(product.toString());
            }
        }
    }

    public void addItemToCart(AmazonCartItem item) {
        // Add an item to the cart.
        cart.addItem(item);
    }

    public void removeProductFromCart(AmazonProduct product) {
        // Remove a product from the cart.
        cart.removeItem(product);
    }

    public void showCart() {
        // Display all items in the customer's cart.
        cart.showCartItems();
    }

    public void addComment(AmazonProduct product, String comment, float rating) {
        // Add a comment for a purchased product.
        AmazonComment productComment = new AmazonComment(product, comment, rating);
        comments.add(productComment);
    }

    public void showComments() {
        // Display all comments for purchased products.
        if (comments.isEmpty()) {
            System.out.println("No comments available.");
        } else {
            for (AmazonComment comment : comments) {
                System.out.println(comment.getCommentDetails());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d, Name: %s, Address: %s", id, name, address);
    }
}