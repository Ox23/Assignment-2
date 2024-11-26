package amazonproducts;

public class AmazonProductException extends Exception {

	private static final long serialVersionUID = 1L;

	public AmazonProductException (String errorText)
	{
	String result = "AmazonProductException: ";
		System.err.println(result + errorText);
	}
}

