package amazonproducts;
import java.util.*;

//AmazonManager Class - The main controller class managing both admin and customer actions, and delegating work to other classes.
public class AmazonManager {
	 private AmazonProduct AP = new AmazonProduct(); // Product list managed by AmazonProductList class
	 private AmazonCustomer AC = new AmazonCustomer();
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
	                 /*
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


	 public void addProductToWishList() {
		 System.out.print("Enter product ID to add it to your wish list: ");
		 int id = input.nextInt();
		 AC.addProductInWishList(id);

	 }
	
	 public void removeProductFromWishList() {
		 System.out.print("Enter product ID to remove it from your wish list:  ");
	     int id = input.nextInt();
	     AC.removeProductFromWishList(id);
		 
	 
	 }
	
	 public void showWishList() {
		 AC.showWishList();
	 }
	 
	 public void addCustomer() {
		 System.out.println("Enter a customer ID, Name and Address to add a new customer ");
		 
		 System.out.print("ID: ");
	     int id = input.nextInt();
	     input.nextLine(); // Consume the leftover newline character
	     
	     System.out.print("Name: ");
	     String name = input.nextLine();
	     
	     System.out.print("Address: ");
	     String address = input.nextLine();
	     
	     AC.addCustomer(id, name, address);
	 }
	 
	 public void showCustomers() {
		 AC.showCustomers();
	 }
	 
	 
	 
	 
	 

	 public void exit() {
	     // Exit the application gracefully.
	     System.out.println("Exiting program...");
	     System.exit(0);
	 }
}



