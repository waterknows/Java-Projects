import javax.swing.Timer;


public class ReverseString {

	public static void main(String[] args) {
		final int DELAY = 1;
		String text = "Hello!";
		String reversed = recursiveReverse(text);
		System.out.println("Original string: " + text);
		System.out.println("Reversed string: " + reversed);
//		Timer t = new Timer(DELAY,);
	}
	
	public static String recursiveReverse(String text){
		if(text.length() == 1)
			return text;
		else
			return recursiveReverse(text.substring(1)) + text.substring(0,1);
	}
}
