
package amazonproducts;
import java.io.*;
import java.util.*;

public class AmazonProduct {

    private int id;
    private String name;
    private String category;
    private String subCategory;
    private String imageURL;
    private String link;
    private float rating;
    private int nRatings;
    private float discountPrice;
    private float actualPrice;
    private static final int NUMCOLS = 10;
    private static List<AmazonProduct> bestsellers = new ArrayList<>(); // List to store all products


    // Constructor to initialize all fields
    public AmazonProduct(int id, String name, String category, String subCategory, String imageURL, String link, float rating, int nRatings, float discountPrice, float actualPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.imageURL = imageURL;
        this.link = link;
        this.rating = rating;
        this.nRatings = nRatings;
        this.discountPrice = discountPrice;
        this.actualPrice = actualPrice;
    }
/*
    // Constructor with just the product name
    public AmazonProduct(String name) {
        this.name = name;
    }
*/
    @Override
    public String toString() {
        return String.format(
            "ID: %d | Name: %s | Category: %s | SubCategory: %s | Rating: %.2f | No. of Ratings: %d | Discount Price: %.2f | Actual Price: %.2f\nImage: %s\nLink: %s\n",
            id, name, category, subCategory, rating, nRatings, discountPrice, actualPrice, imageURL, link);
    }
    
    // Constructor with just the product name
    public AmazonProduct() {

    }
    
    public void setTitle(String title) { 
        this.name = title;
    }

	public int getId() {
		return id;
	}
	
	public String getName() {
        return name;
    }
	
    // Getter for the bestsellers list
    public static List<AmazonProduct> getBestsellers() {
        return bestsellers;
    }
	
	
	public void createList(String csvFile) {
		
		AmazonUtil productUtil = new AmazonUtil();
		
	    System.out.println("Loading product list from: " + csvFile);
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        String line; //current line
	        boolean firstLine = true;

	        while ((line = br.readLine()) != null) { // while line is not null
	            if (firstLine) { // skips the first line
	                firstLine = false;
	                continue;
	            }

	            //String[] details = line.split(","); // splits the line where ever there's a comma
	            String[] details = productUtil.lineReader(line, NUMCOLS); //returns an array of strings representing the fields of the CSV row. 
	            
	            // Clean numeric strings to remove commas
	            int id = Integer.parseInt(details[0].replace(",", ""));
	            String name = details[1];
	            String category = details[2];
	            String subCategory = details[3];
	            String imageURL = details[4];
	            String link = details[5];
	            float rating = productUtil.convertStrToFloat(details[6].replace(",", ""));
	            int nRatings = Integer.parseInt(details[7].replace(",", ""));
	            float discountPrice = productUtil.convertStrToFloat(details[8].replace(",", ""));
	            float actualPrice = productUtil.convertStrToFloat(details[9].replace(",", ""));

	            AmazonProduct product = new AmazonProduct(
	                id,
	                name,
	                category,
	                subCategory,
	                imageURL,
	                link,
	                rating,
	                nRatings,
	                discountPrice,
	                actualPrice
	            );
	            bestsellers.add(product); // adds product to bestsellers
	        }

	        System.out.println("Product list loaded successfully.");
	    } catch (IOException e) {
	        System.out.println("Error loading product list: " + e.getMessage());
	    } catch (NumberFormatException e) {
	        System.out.println("Error parsing product details: " + e.getMessage());
	    }
	}


    // Method to display the list of all products.
    public void printList() {
        // Display the list of all products.
        if (bestsellers.isEmpty()) {
            System.out.println("The product list is empty. Load the product list first.");
        } else {
            for (AmazonProduct product : bestsellers) {
                System.out.println(product.toString());
            }
        }
    }
    
    
    public void search(String inquiry) {
        System.out.println("Searching for: " + inquiry);
        List<AmazonProduct> matchingProducts = new ArrayList<>();

        for (AmazonProduct product : bestsellers) {
            // Convert all fields to strings for comparison
            if (String.valueOf(product.id).contains(inquiry) ||
                product.name.toLowerCase().contains(inquiry.toLowerCase()) ||
                product.category.toLowerCase().contains(inquiry.toLowerCase()) ||
                product.subCategory.toLowerCase().contains(inquiry.toLowerCase()) ||
                product.imageURL.toLowerCase().contains(inquiry.toLowerCase()) ||
                product.link.toLowerCase().contains(inquiry.toLowerCase()) ||
                String.valueOf(product.rating).contains(inquiry) ||
                String.valueOf(product.nRatings).contains(inquiry) ||
                String.valueOf(product.discountPrice).contains(inquiry) ||
                String.valueOf(product.actualPrice).contains(inquiry)) {
                
                // Add product to the list of matching products
                matchingProducts.add(product);
            }
        }
        // Display the matching products
        if (matchingProducts.isEmpty()) {
            System.out.println("No matching products found.");
        } else {
            System.out.println("Matching products:");
            for (AmazonProduct matchingProduct : matchingProducts) {
                System.out.println(matchingProduct.toString());
            }
        }
    }

	
    public void saveList(String csvFile) {
        System.out.println("Saving product list to: " + csvFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) { // Use BufferedWriter to write to the specified file.
            for (AmazonProduct product : bestsellers) { // Iterate over the bestsellers list and convert each product to a CSV line.
                String line = String.format("%d,%s,%s,%s,%s,%s,%.2f,%d,%.2f,%.2f",
                    product.id,
                    product.name,
                    product.category,
                    product.subCategory,
                    product.imageURL,
                    product.link,
                    product.rating,
                    product.nRatings,
                    product.discountPrice,
                    product.actualPrice
                );
                bw.write(line); // Write each line to the file.
                bw.newLine();
            }
            System.out.println("Product list saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving product list: " + e.getMessage());
        }
    }
    

    // Method to add a product (empty placeholder for future implementation).
    public static void addProduct() {
        // TODO: Implement adding a new product to the list.
        // Step-by-step logic:
        // 1. Prompt the user for product details.
        // 2. Create a new AmazonProduct object with the provided details.
        // 3. Add the new product to the bestsellers list.
    }

    // Method to edit a product (empty placeholder for future implementation).
    public static void editProduct(int productId) {
        // TODO: Implement editing an existing product's details.
        // Step-by-step logic:
        // 1. Find the product by productId in the bestsellers list.
        // 2. Prompt the user for updated details.
        // 3. Update the product's attributes accordingly.
    }

    // Method to delete a product (empty placeholder for future implementation).
    public static void deleteProduct(int productId) {
        // TODO: Implement deleting a product from the list.
        // Step-by-step logic:
        // 1. Find the product by productId in the bestsellers list.
        // 2. Remove the product from the list if found.
    }
	public int getActualPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	


}

