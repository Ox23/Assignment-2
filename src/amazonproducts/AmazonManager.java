package amazonproducts;
import java.util.*;

//AmazonManager Class - The main controller class managing both admin and customer actions, and delegating work to other classes.
public class AmazonManager {
	 private List<AmazonCustomer> customers = new ArrayList<>(); // List to store all customers
	 private AmazonProduct AP = new AmazonProduct(); // Product list managed by AmazonProductList class
	 private Scanner input = new Scanner(System.in);
	
	 public static void main(String[] args) {
	     AmazonManager manager = new AmazonManager();
	     manager.showMenu(); // Show the main menu to begin interaction
	 }
	
	 public void showMenu() {
	     String choice;
	     while (true) {
	    	 //System.out.println("Current working directory: " + System.getProperty("user.dir"));
	         System.out.println("==========================================================================");
	         System.out.println("||    ****   ****             ****   ****  *****      ALGONQUIN COLLEGE   ||");
	         System.out.println("||   **  ** **         **    **  ** **  ** ** **      COURSE: OOP/CST8132 ||");
	         System.out.println("||   ****** **         **    **  ** **  ** *****      PROF: PAULO         ||");
	         System.out.println("||   **  **  ****             ****   ****  **         TERM: FALL / 2024   ||");
	         System.out.println("==========================================================================");
	         System.out.println("||                         [Menu A2 - Amazon Manager]                     ||");
	         System.out.println("==========================================================================");
	         System.out.println("|| ADMIN OPTIONS                     || CUSTOMER OPTIONS                  ||");
	         System.out.println("|| [A] Load product list              || [H] Add product to wishlist      ||");
	         System.out.println("|| [B] Show product list              || [I] Remove product from wishlist ||");
	         System.out.println("|| [C] Search products                || [J] Show products from wishlist  ||");
	         System.out.println("|| [D] Add customer                   || [K] Add product to cart          ||");
	         System.out.println("|| [E] Show customers                 || [L] Remove product from cart     ||");
	         System.out.println("||                                    || [M] Show products from cart      ||");
	         System.out.println("||                                    || [O] Comment on purchased products||");
	         System.out.println("||              [Q] Exit              || [P] List comments from products  ||");
	         System.out.println("==========================================================================");
	         System.out.print("Choose an option (A-Q): ");
	         choice = input.nextLine().trim().toUpperCase();
	
	         switch (choice) {
	             case "Q":
	                 exit(); // Exit the program
	                 return;
	             case "A":
	                 loadProductList(); // Load the product list
	                 break;
	             case "B":
	                 showProductList(); // Show the product list
	                 break;
	             case "C":
	                 searchProducts(); // Search for a product in the list
	                 break;
	                 /*
	             case "D":
	                 addCustomer(); // Add a new customer
	                 break;
	             case "E":
	                 showCustomers(); // Show customers
	                 break;
	             case "H":
	                 addProductToWishList(); // Add a product to wishlist
	                 break;
	             case "I":
	                 removeProductFromWishList(); // Remove a product from wishlist
	                 break;
	             case "J":
	                 showWishList(); // Show wishlist
	                 break;
	             case "K":
	                 addProductToCart(); // Add product to cart
	                 break;
	             case "L":
	                 removeProductFromCart(); // Remove product from cart
	                 break;
	             case "M":
	                 showProductsInCart(); // Show products in cart
	                 break;
	             case "O":
	                 addCommentToProduct(); // Add comment to purchased products
	                 break;
	             case "P":
	                 listCommentsFromProducts(); // List comments for purchased products
	                 break;
	                 */
	             default:
	                 System.out.println("Invalid input! Please enter a letter between A-Q.");
	         }
	     }
	 }
	
	 public void loadProductList() {
	     // Use AmazonProductList to handle loading the products from a CSV file.
	     System.out.print("Enter the name of the CSV file to load products: ");
	     String fileName = input.nextLine();
	     AP.createList(fileName);
	 }
	
	 public void showProductList() {
	     // Delegate product listing to AmazonProductList class.
	     AP.printList();
	 }
	
	 public void searchProducts() {
	     // Delegate search functionality to AmazonProductList class.
	     System.out.print("Enter product name to search: ");
	     String inquiry = input.nextLine();
	     AP.search(inquiry);
	 }
	/*
	 public void addCustomer() {
	     // Create a new customer and add it to the list.
	     System.out.print("Enter Customer ID: ");
	     int id = Integer.parseInt(input.nextLine());
	     System.out.print("Enter Customer Name: ");
	     String name = input.nextLine();
	     System.out.print("Enter Customer Address: ");
	     String address = input.nextLine();
	
	     AmazonCustomer customer = new AmazonCustomer(id, name, address);
	     customers.add(customer);
	     System.out.println("Customer added successfully.");
	 }
	
	 public void showCustomers() {
	     // Show customer details.
	     if (customers.isEmpty()) {
	         System.out.println("No customers available.");
	     } else {
	         for (AmazonCustomer customer : customers) {
	             System.out.println(customer.toString());
	         }
	     }
	 }
	
	 public void addProductToWishList() {
	     // Get customer and product details and delegate adding to wishlist to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	     System.out.print("Enter Product ID: ");
	     int productId = Integer.parseInt(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             AmazonProduct product = productList.findProductById(productId);
	             if (product != null) {
	                 customer.addProductToWishList(product);
	                 System.out.println("Product added to wishlist.");
	             } else {
	                 System.out.println("Product not found.");
	             }
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	
	 public void removeProductFromWishList() {
	     // Get customer and product details and delegate removing from wishlist to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	     System.out.print("Enter Product ID to remove: ");
	     int productId = Integer.parseInt(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             AmazonProduct product = productList.findProductById(productId);
	             if (product != null) {
	                 customer.removeProductFromWishList(product);
	                 System.out.println("Product removed from wishlist.");
	             } else {
	                 System.out.println("Product not found.");
	             }
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	
	 public void showWishList() {
	     // Get customer details and delegate showing wishlist to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             customer.showWishList();
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	
	 public void addProductToCart() {
	     // Get customer and product details and delegate adding to cart to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	     System.out.print("Enter Product ID: ");
	     int productId = Integer.parseInt(input.nextLine());
	     System.out.print("Enter quantity: ");
	     int quantity = Integer.parseInt(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             AmazonProduct product = productList.findProductById(productId);
	             if (product != null) {
	                 customer.addItemToCart(new AmazonCartItem(product, quantity));
	                 System.out.println("Product added to cart.");
	             } else {
	                 System.out.println("Product not found.");
	             }
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	
	 public void removeProductFromCart() {
	     // Get customer and product details and delegate removing from cart to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	     System.out.print("Enter Product ID to remove: ");
	     int productId = Integer.parseInt(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             AmazonProduct product = productList.findProductById(productId);
	             if (product != null) {
	                 customer.removeProductFromCart(product);
	                 System.out.println("Product removed from cart.");
	             } else {
	                 System.out.println("Product not found.");
	             }
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	
	 public void showProductsInCart() {
	     // Get customer details and delegate showing cart to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             customer.showCart();
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	
	 public void addCommentToProduct() {
	     // Get customer and product details and delegate adding comments to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	     System.out.print("Enter Product ID to comment on: ");
	     int productId = Integer.parseInt(input.nextLine());
	     System.out.print("Enter comment: ");
	     String comment = input.nextLine();
	     System.out.print("Enter rating (1.0 to 5.0): ");
	     float rating = Float.parseFloat(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             AmazonProduct product = productList.findProductById(productId);
	             if (product != null) {
	                 customer.addComment(product, comment, rating);
	                 System.out.println("Comment added successfully.");
	             } else {
	                 System.out.println("Product not found.");
	             }
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	
	 public void listCommentsFromProducts() {
	     // Get customer details and delegate listing comments to AmazonCustomer.
	     System.out.print("Enter Customer ID: ");
	     int customerId = Integer.parseInt(input.nextLine());
	
	     for (AmazonCustomer customer : customers) {
	         if (customer.getId() == customerId) {
	             customer.showComments();
	             return;
	         }
	     }
	     System.out.println("Customer not found.");
	 }
	*/
	 public void exit() {
	     // Exit the application gracefully.
	     System.out.println("Exiting program...");
	     System.exit(0);
	 }
}



