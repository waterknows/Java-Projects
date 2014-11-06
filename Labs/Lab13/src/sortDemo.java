import java.util.Random;
import java.util.Scanner;


public class sortDemo {

	static final int MAX_TEST = 5;

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
        
//        print(array, 0, 9);
//        threWPartition(array, 0, 9);
//        print(array, 0, 9);
        
        int[] array2 = { 5, 7, 5, 9, 3, 4};
        threWPartition(array2, 0, MAX_TEST);
    }

    public static void threWPartition(int[] a, int from, int to) {
    	
    	if(to <= from)
    		return;
    		
    	int lo = a[from];
    	int i = from + 1, j = to;
    	int p = from + 1, q = to;
    	
    	
    	// Part A : Before crossing over
    	while(i < j) {
    		System.out.println("i : " + i + ", j : " + j);
    		print(a, i, j);
    		while(a[i] < lo)
    			i++;
    		while(a[j] > lo)
    			j--;
    		if(i < j)	{
    			swap(a, i, j);
    			if(a[i] == lo) {
    				swap(a, i, p++);
    				if(i == p - 1)
    					i++;
    			}
    			if(a[j] == lo) {
    				swap(a, j, q--);
    				if(j == q + 1)
    					j--;
    			}
    		}
    	}
    	
    	print(a, i, j);
    	System.out.println("Phase 1 Complete");
//    	Scanner in = new Scanner(System.in);
//    	in.next();
    	// Phase 2 : After crossing
    	//scan left part
    	while(p >= from) {
    		print(a, p, j);
    		System.out.println(" P : " + p);
    		if(a[p] == lo)
    			swap(a, p, j--);
    		p--;
    	}
    	System.out.println("After moving p, j");
    	while(q <= to) {
    		print(a, q, i);
    		if(a[q] == lo)
    			swap(a, q, i++);
    		q++;
    	}
    	System.out.println("Complete all phase before recurs");
    		
    	// Phase infinity
    	System.out.println("RecursLeft(a," + from + "," + j);
    	threWPartition(a, from, j);
    	System.out.println("RecursRight(a," + i + "," + to);
    	threWPartition(a, i, to);    	
    }
    
    
    public static void swap(int[] array, int i, int j){
    	int temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
    
    public static void print(int[] array, int i, int j){
//    	for(int e : array)
//    		System.out.print(e + " ");
    	for(int k = 0; k < MAX_TEST + 1; k++){
    		if(k == i)
    			System.out.print("{" + array[k] + "}");
    		else if(k == j)
    			System.out.print("[" + array[k] + "]");
    		else
    			System.out.print( " " + array[k] + " ");
    	}
    	System.out.println();
    }
    
}
