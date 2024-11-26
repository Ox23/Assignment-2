package amazonproducts;
import java.util.List;
import java.util.ArrayList;

public class AmazonCustomer {
    // Attributes
    private int id;
    private String name;
    private String address;
    //private List<AmazonComment> comments = new ArrayList<>(); // List of comments made by the customer
    private List<AmazonProduct> wishList = new ArrayList<>(); // Wishlist for the customer
    //private List<AmazonCredit> credits = new ArrayList<>(); // List of credits the customer holds
	private List<AmazonCustomer> customers = new ArrayList<>(); // List to store all customers
	//AmazonCustomer AC = new AmazonCustomer();


    public AmazonCustomer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public AmazonCustomer() {
		// TODO Auto-generated constructor stub
	}

	// Static method to create an AmazonCustomer from a String array
    public static AmazonCustomer createAmazonCustomer(String[] details) {
        return null;
    }

    public void addCustomer(int id, String name, String address) {
        // Check if a customer with the same ID already exists
        AmazonCustomer existingCustomer = findCustomerById(id);
        if (existingCustomer != null) {
            System.out.println("Customer with ID " + id + " already exists. Cannot add duplicate customer.");
            return;
        }

        // Create a new customer and add it to the list
        AmazonCustomer newCustomer = new AmazonCustomer(id, name, address);
        customers.add(newCustomer);
        System.out.println("Customer '" + newCustomer.getId() + "' has been added successfully.");
    }
    	
    
    
	// Displays the customers
	public void showCustomers() {
	    if (customers.isEmpty()) {
	        System.out.println("No customers available.");
	    } else {
	        for (AmazonCustomer customer : customers) {
	            System.out.println("Customer ID: " + customer.getId()); // need to add so it displays name and address as well
	        }
	    }
	}
    
    
    
    
    
    
    
    // Wishlist Methods:

    // Adds a product to the wishlist by its ID.
    public void addProductInWishList(int productId) {
        AmazonProduct product = findProductById(productId);
        if (product == null) {
            System.out.println("Product number:  " + productId + " not found in the bestsellers list. Cannot add to wishlist.");
            return;
        }

        wishList.add(product);
        System.out.println("Product '" + product.getName() + "' has been added to the wishlist.");
    }

    // Removes a product from the wishlist by its ID.
    public void removeProductFromWishList(int productId) {
        if (wishList.isEmpty()) {
            System.out.println("Wishlist is empty. No products to remove.");
            return;
        }

        AmazonProduct productToRemove = findProductInWishListById(productId);
        if (productToRemove != null) {
            wishList.remove(productToRemove);
            System.out.println("Product '" + productToRemove.getName() + "' has been removed from the wishlist.");
        } else {
            System.out.println("Product with ID " + productId + " is not in the wishlist.");
        }
    }

    // Checks if a product is in the wishlist by its ID.
    public boolean isProductInWishList(int productId) {
        return findProductInWishListById(productId) != null;
    }

    // Displays the wishlist.
    public void showWishList() {
        if (wishList.isEmpty()) {
            System.out.println("Your wishlist is empty.");
        } else {
            System.out.println("Your wishlist contains the following products:");
            for (AmazonProduct product : wishList) {
                System.out.println("- " + product.toString());
            }
        }
    }

    // Helper method to find a product by its ID from the bestsellers list.
    private AmazonProduct findProductById(int productId) {
        // Static method to get the bestsellers list from AmazonProduct
        for (AmazonProduct product : AmazonProduct.getBestsellers()) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }
    
    private AmazonCustomer findCustomerById(int id) {
        for (AmazonCustomer customer : getCustomers()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    // Helper method to find a product by its ID from the wishlist.
    private AmazonProduct findProductInWishListById(int productId) {
        for (AmazonProduct product : wishList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Product not found in wishlist
    }
    
    private AmazonCustomer findCustomertById(int id) {
        // Static method to get the bestsellers list from AmazonProduct
        for (AmazonCustomer customer : getCustomers()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null; // Product not found
    }
    
    // Getter for the bestsellers list
    public List<AmazonCustomer> getCustomers() {
        return customers; // Cannot make a static reference to the non-static field customers ERROR
    }
 
    
    public int getId() {
		return id;
	}
    
    
    
    
    
    
    /*
    
    
    // Cart Methods:

    // Adds an item to the cart.
    public void addItemInCart(AmazonCartItem item) {
    }

    // Removes a product from the cart.
    public void removeProductFromCart(AmazonProduct product) {
    }

    // Displays the cart.
    public void showCart() {
    }

    // Moves all items from the cart to the wishlist.
    public void moveFromCartToComments() {
    }

    
    
    
    
    
    
    // Credit Methods:

    // Adds a credit to the customer account.
    public void addCredit(AmazonCredit credit) {
    }

    // Shows the available credits for the customer.
    public void showCredits() {
    }

    // Pays using the available credit.
    public void pay(AmazonCredit credit) {
        // Placeholder for implementation
    }

    
    
    
    
    
    
    // Comment Methods:

    // Checks if the customer has purchased a product to comment on.
    public boolean hasProductToComment(AmazonProduct product) {
        return false;
    }

    // Adds a comment to a purchased product.
    public void addComment(AmazonComment comment) {
    }

    // Sets a comment for a product, rating, and review.
    public void setComment(AmazonProduct product, String comment, float rating) {
    }

    // Displays all comments.
    public void showComments() {
    }
*/
    @Override
    public String toString() {
        return null;
    }
}
