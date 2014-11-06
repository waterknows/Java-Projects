import java.util.Random;


public class sortDemo {

    public static void main (String[] args) {
    	final int MAX = 10;
    	final int VAL = 10;
    	int[] array = new int[MAX];
        Random Rand = new Random();
        for(int i = 0; i < MAX; i++)
        	array[i] = Rand.nextInt(VAL);
        for(int i = 0; i < MAX/2; i++){
        	array[2*i] = 4;
        }
        
        
    }

    public static void threWPartition(int[] a, int from, int to) {
    	
    	if(from < to)
    		return;
    		
    	int lo = a[from];
    	int i = from + 1, j = to;
    	int p = from + 1, q = to;
    	
    	
    	// Part A : Before crossing over
    	while(i <= j) {
    		while(a[i] < lo)
    			i++;
    		while(a[j] > lo)
    			j--;
    		swap(a, i, j);
    		if(a[i] == lo)
    			swap(a, i, p++);
    		if(a[j] == q)
    			swap(a, j, q--);
    	}
    	
    	// Phase 2 : After crossing
    	//scan left part
    	while(p >= from) {
    		if(a[p] == lo)
    			swap(a, p, j--);
    		p--;
    	}
    	while(q >= to) {
    		if(a[q] == lo)
    			swap(a, q, i++);
    		q++;
    	}
    		
    	// Phase infinity
    	threWPartition(a, from, j);
    	threWPartition(a, i, to);    	
    }
    
    public static void sortOriginal(int[] array, int from, int to){
    	if(from >= to)
    		return;
    	int p = partition(array,from,to);
    	sortOriginal(array,from,p);
    	sortOriginal(array,p+1,to);
    }
    
    public static int partition(int[] array, int from, int to){
    	int pivot = array[from];
    	int i = from - 1, j = to + 1;
    	while(i < j){
    		i++; j--;
    		while(array[i] < pivot) 
    			i++;
    		while(array[j] > pivot) 
    			j--;
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
    
    public static void print(int[] array, int i, int j){
//    	for(int e : array)
//    		System.out.print(e + " ");
    	for(int k = 0; k < 10; k++){
    		if(k == i)
    			System.out.print("{" + array[k] + "} ");
    		else if(k == j)
    			System.out.print("[" + array[k] + "] ");
    		else
    			System.out.print(array[k] + " ");
    	}
    	System.out.println();
    }
    
}
