import java.util.Random;


public class sortDemo {

    public static void main (String[] args) {
    	final int MAX = 50;
    	final int VAL = 100;
    	int[] array = new int[MAX];
        Random Rand = new Random();
        for(int i = 0; i < MAX; i++)
        	array[i] = Rand.nextInt(100);
        print(array);
        sort(array,0,MAX-1);
        print(array);
    }
    public static void sort(int[] array, int from, int to){
    	if(from >= to)
    		return;
    	int p = partition(array,from,to);
    	sort(array,from,p);
    	sort(array,p+1,to);
    }
    public static int partition(int[] array, int from, int to){
    	int pivot = array[from];
    	int i = from - 1;
    	int j = to + 1;
    	while(i < j){
    		i++; while(array[i] < pivot) {i++;}
    		j--; while(array[j] > pivot) {j--;}
    		if(i < j)
    			swap(array,i,j);
    	}
    	return j;
    }
    public static void swap(int[] array, int i, int j){
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
    public static void print(int[] array){
    	for(int e : array)
    		System.out.print(e + " ");
    	System.out.println();
    }
}
