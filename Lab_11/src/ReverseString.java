import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;



public class ReverseString {

	public static void main(String[] args) {

		final int MAXLENGTH = 2000;
		System.out.println("Time is in microseconds.");
		for (int i = 1; i <= MAXLENGTH; i++) {
			long iterTemp = getDurationIter(i);
			long recurTemp = getDurationRecurs(i);
			System.out.println("Len " + i + ", Iterative : " + iterTemp +
											", Recursive : " + recurTemp +
											", Difference: " + (recurTemp - iterTemp) 
											);
		}
		

		System.out.println("To reverse a text, the time it takes for iterative"
				+ " rises slower than the time it takes for recursive as the length of the text grows longer.");
		
		System.out.println("Iterative : O(n");
		System.out.println("Recursive : Log(n)");
	}
	
	public static long getDurationIter(int textLength) {
		String text = "";
		for (int i = 0; i < textLength; i++) {
			text += "x";
		}
		long startIter = System.nanoTime()/1000;
		iterativeReverse(text);
		long endIter = System.nanoTime()/1000;
		return endIter - startIter ;
	}
	
	public static long getDurationRecurs(int textLength) {
		String text = "";
		for (int i = 0; i < textLength; i++) {
			text += "x";
		}
		long startRecursive = System.nanoTime()/1000;
		recursiveReverse(text);
		long endRecursive = System.nanoTime()/1000;
		return endRecursive - startRecursive ;
	}
	
	public static String recursiveReverse(String text){
		return text.length() == 1 ? text : 
			recursiveReverse(text.substring(1)) + text.substring(0,1);
	}

	
	public static String iterativeReverse(String text) {
		String temp = "";
		for (int i = text.length(); i > 0; i--) {
			temp += text.charAt(i-1);
		}
		return temp;
	}
}
