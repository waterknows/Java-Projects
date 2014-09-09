/*

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
    public static ArrayList<Integer> createFillArrayList(int min, int max, int length){
        Random Rand = new Random();
        int random1 = Rand.nextInt(max - 1 - min) + min;
        int random2 = Rand.nextInt(max - 1 - min) + min;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int index = 0; index < length; index++){
//            arrayList.add(Rand.nextInt(max - 1 - min) + min);
            arrayList.add(index * random1 + random2) ;
        }
        Rand = null;
        return arrayList;
    }
    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> listOne, ArrayList<Integer> listTwo){
        ArrayList<Integer> mergedList = new ArrayList<>();
        int sizeOne = listOne.size();
        int sizeTwo = listTwo.size();
        int indexOne = 0, indexTwo = 0;
        int atOne, atTwo;
        while(indexOne < sizeOne && indexTwo < sizeTwo){
            atOne = listOne.get(indexOne);
            atTwo = listTwo.get(indexTwo);
            if(atOne < atTwo){
                mergedList.add(atOne);
                indexOne++;
            }
            else if(atOne > atTwo){
                mergedList.add(atTwo);
                indexTwo++;
            }
            else{
                mergedList.add(atOne);
                mergedList.add(atTwo);
                indexOne++;
                indexTwo++;
            } 
        }
        if(indexOne == sizeOne && indexTwo != sizeTwo){
            for(int index = indexTwo; index < sizeTwo; index++){
                mergedList.add(listTwo.get(index));
            }
        }
        else if(indexOne != sizeOne && indexTwo == sizeTwo){
            for(int index = indexOne; index < sizeOne; index++){
                mergedList.add(listOne.get(index));
            }
        }
        return mergedList;
    }
}
