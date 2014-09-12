/*
Name: Joseph Park
Date: September 12, 2014
Assignment: 6, Problem 6.7
Input: None
Process: Reverses an array
Output: Prints reversed array
*/
public class A6P67 {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5};
        reverse(array);
        for(int i : array)
            System.out.print(i + " ");
    }
    /**
     * reverses an integer array
     * @param intArray array of integers
     */
    public static void reverse(int[] intArray){
        int length = length(intArray); //Get the length of the array
        int endIndex = length - 1; //Set the end index to the last index
        for(int index = 0; index < length; index++, endIndex--){ //Go through each element starting at 0, then move up index and move down end index
            if(index < endIndex){ //If the index is less than the end index (means that as long as the index hasnt passed the end index)
                int temp = intArray[index]; //The Swap Algorithm
                intArray[index] = intArray[endIndex];
                intArray[endIndex] = temp;
            }
            else //Else just end; no need to go through the rest
                break;
        }
    }
    /**
     * gets the length of an integer array
     * @param intArray array of integers
     * @return the length of the integer array
     */
    public static int length(int[] intArray){
        int length = 0; //Length counter
        for(int element : intArray) //Go through each element; element unused
            length++; //Increment length for each element
        return length;
    }
}
