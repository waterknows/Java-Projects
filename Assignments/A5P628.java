/*
Name: Joseph Park
Date: September 9, 2014
Assignment: 5, Problem 6.28
Input: None
Process: Merges two sorted array lists
Output: Prints the merged sorted array
*/
import java.util.ArrayList;
import java.util.Random;
public class A5P628 {
    private final static int MIN = 0;
    private final static int MAX = 100;
    private final static int LENGTH = 20;
    public static void main(String[] args) {
        ArrayList<Integer> one = createFillArrayList(MIN,MAX,LENGTH);
        ArrayList<Integer> two = createFillArrayList(MIN,MAX,LENGTH/2);
        ArrayList<Integer> merged;
        
        merged = mergeSorted(one,two);
        for(int i : merged){
            System.out.print(i + "|");
        }
        System.out.println();
    }
    /**
     * Creates and fills an array list with random integers, sorted numerically
     * @param min min random value
     * @param max max random value
     * @param length
     * @return returns the array list
     */
    public static ArrayList<Integer> createFillArrayList(int min, int max, int length){
        Random Rand = new Random();
        int random1 = Rand.nextInt(max - 1 - min) + min; //Randomly generated modifiers
        int random2 = Rand.nextInt(max - 1 - min) + min;
        ArrayList<Integer> arrayList = new ArrayList<>(); //Create a new array list
        for(int index = 0; index < length; index++){ 
//            arrayList.add(Rand.nextInt(max - 1 - min) + min);
            arrayList.add(index * random1 + random2); //index times the random multiplier + the random modifier
        } //Ensures that it is pseudorandom and sorted numerically
        Rand = null; //Set to null
        return arrayList;
    }
    /**
     * merges two sorted array lists into one merged sorted array list
     * @param listOne
     * @param listTwo
     * @return merged sorted array list
     */
    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> listOne, ArrayList<Integer> listTwo){
        ArrayList<Integer> mergedList = new ArrayList<>();
        int sizeOne = listOne.size(); //Gets the size of each array list
        int sizeTwo = listTwo.size();
        int indexOne = 0, indexTwo = 0; //Iterators for each array list
        int atOne, atTwo; //The value at the index
        while(indexOne < sizeOne && indexTwo < sizeTwo){ //While the iterators are within the array list bounds
            atOne = listOne.get(indexOne);//Get the value at each index
            atTwo = listTwo.get(indexTwo);
            if(atOne < atTwo){ //If the first value is less than the second value
                mergedList.add(atOne); //Add the smaller one
                indexOne++; //Increment the first one up
            }
            else if(atOne > atTwo){ //If the first value is greater than the second value
                mergedList.add(atTwo); //Add the second value
                indexTwo++; //Increment the second one
            }
            else{ //If they are equal. NOTE: This else is not necessary as the first two can be modified to take care of equal
                mergedList.add(atOne); //But this ensures that it will not have to loop again just for equal
                mergedList.add(atTwo);
                indexOne++; //Takes care of both iterators
                indexTwo++;
            } 
        }//For the remaining values
        if(indexOne == sizeOne && indexTwo != sizeTwo){ // the first iterator hit the out of bounds, and the second did not
            for(int index = indexTwo; index < sizeTwo; index++){ //Add the remaining ones in the second list to the merged
                mergedList.add(listTwo.get(index));
            }
        }//If the first one did not hit of bounds and the second one did
        else if(indexOne != sizeOne && indexTwo == sizeTwo){
            for(int index = indexOne; index < sizeOne; index++){
                mergedList.add(listOne.get(index)); //Add the remaining ones 
            }
        }
        return mergedList;
    }
}

/*
run:
81|95|126|157|165|188|219|249|250|281|312|333|343|374|405|417|436|467|498|501|529|560|585|591|622|653|669|684|753|837|
BUILD SUCCESSFUL (total time: 0 seconds)
*/