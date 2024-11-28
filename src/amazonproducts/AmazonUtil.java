package amazonproducts;

public class AmazonUtil {

	public float convertStrToFloat(String str) {
		
		//System.out.println("Original String: " + str);  // log original string
		
		// needs to be done for every currency  
	    str = str.replace(",", "").replace("₹", ""); // remove commas and currency symbols

	    //System.out.println("Cleaned String: " + str);  // Log the cleaned string
	    
	    
	    try {
	        return Float.parseFloat(str);  // convert cleaned string to float
	    } catch (NumberFormatException e) {
	        System.err.println("Error converting string to float: " + str);  // print error if conversion fails
	        return 0.0f;
	    }
	}


	public String[] lineReader(String line, int num) {
		
	    String[] str = new String[num]; // an array of Strings with size "num" to store the parsed fields
	    
	    int index = 0; // index variable to keep track of the current position in the array
	    
	    boolean inQuotes = false; // boolean to track if we are inside a quoted section 
	    
	    StringBuilder field = new StringBuilder();

	    for (int i = 0; i < line.length(); i++) { // loop over each character in the input string
	    	
	        char currentChar = line.charAt(i); // get character in current position

	        if (currentChar == '"') { // If character is a double-quote toggle the inQuotes boolean
	        	
	            inQuotes = !inQuotes;  // toggle inQuotes boolean
	            
	        } else if (currentChar == ',' && !inQuotes) { // if character is comma and we aren't inside quotes it's a field separator
	            
	            str[index++] = field.toString().trim(); // convert the StringBuilder field into a regular string and store it in the str array
	            
	            field.setLength(0);  // clear field and start building next field
	            
	        } else {
	            // Append the current character to the current field 
	            field.append(currentChar);
	        }
	    }	
	    // add final field to array
	    if (field.length() > 0) {
	        str[index] = field.toString().trim();
	    }

	    return str; // return the array of parsed fields
	}

}
