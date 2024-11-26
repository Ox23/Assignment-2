package amazonproducts;

public class AmazonProductCategory {
    private String categoryName;

    // constructor
    public AmazonProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    // getter for categoryName
    public String getCategory() {
        return categoryName;
    }

    // setter for categoryName
    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}

