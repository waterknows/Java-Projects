/*
Name: Joseph Park
Date: September 9, 2014
Assignment: 5, Problem 6.14
Input: None
Process: Randomly generates 20 integers and sorts it
Output: Prints the array
*/
import java.util.Arrays;
import java.util.Random;
public class A5P614 {
    private static final int MIN = 0; //the minimum value the array can hold
    private static final int MAX = 99; //the maximum value the array can hold
    private static final int LENGTH = 20; //the length of the array
    public static void main(String[] args) {
        int[] array = createFillArray(MIN,MAX,LENGTH); //create an array filled with random ints
        System.out.println("The unsorted array: ");
        printArray(array); //print the array as is
        Arrays.sort(array); //Sort the array
        System.out.println("Now sorted: ");
        printArray(array); //print the now sorted array
    }
    /**
     * Creates and fills an int array with randomly generated ints from min to max
     * @param min the min value an int can be
     * @param max the max value
     * @param length the length of the array
     * @return the filled array
     */
    public static int[] createFillArray(int min, int max, int length){
        int[] intArray = new int[length];
        Random Rand = new Random(); //Create random object to get random ints
        for(int index = 0; index < length; index++){ //Fills each index with a randomly generated int
            intArray[index] = Rand.nextInt(max + 1 - min) + min; //Goes up to max + 1 - min exclusive, then adds min to it
        }
        Rand = null; //Set the refernece to null to be garbage collected
        return intArray;
    }
    /**
     * Prints each index of the array with a separator. Prints an endline at the end
     * @param intArray the array to be printed
     */
    public static void printArray(int[] intArray){
        for(int index : intArray){ //Prints each index in the array
            System.out.print(index + "|");
        }
        System.out.println();
    }
}

/*
The unsorted array: 
69|98|23|34|30|13|92|17|87|65|56|30|92|17|79|66|87|32|94|5|
Now sorted: 
5|13|17|17|23|30|30|32|34|56|65|66|69|79|87|87|92|92|94|98|
*/