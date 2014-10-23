

public class ReverseString {

	public static void main(String[] args) {
		final int DELAY = 1;
		String text = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		
		long startRecursive = System.currentTimeMillis();
		String reversedRecursive = recursiveReverse(text);
		long endRecursive = System.currentTimeMillis();
		long elapsedRecursive = endRecursive - startRecursive;
		
		long startIterative = System.currentTimeMillis();
		String reversedIterative = iterativeReverse(text);
		long endIterative = System.currentTimeMillis();
		long elapsedIterative = endIterative - startIterative;
		
		System.out.println("Original string: " + text);
		System.out.println("Reversed string: " + reversedRecursive);
		System.out.println("Elapsed Time for Recursive Reverse: " + elapsedRecursive);
		System.out.println("Elapsed Time for Iterative Reverse: " + elapsedIterative);
		
	}
	
	
	public static String recursiveReverse(String text){
		return text.length() == 1 ? text : 
			recursiveReverse(text.substring(1)) + text.substring(0,1);
	}

	
	public static String iterativeReverse(String text) {
		for (int i = 0; i < text.length(); i++)
			text = text.substring(1) + text.charAt(0);
		return text;
	}
}
