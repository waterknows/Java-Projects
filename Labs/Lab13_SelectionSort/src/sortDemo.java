import java.util.Random;


public class sortDemo {

    public static void main (String[] args) {
    	final int MAX = 10;
    	final int VAL = 100;
    	int[] array = new int[MAX];
        Random Rand = new Random();
        for(int i = 0; i < MAX; i++)
        	array[i] = Rand.nextInt(VAL);
        for(int i = 0; i < MAX/2; i++)
        	array[2*i] = 34;
        print(array);
        sortModified(array,0,MAX-1);
        print(array);
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
    public static void print(int[] array){
    	for(int e : array)
    		System.out.print(e + " ");
    	System.out.println();
    }
    public static void sortModified(int[] array, int from, int to){
    	if(from >= to)
    		return;

    	int pivot = array[from];
    	int i = from + 1, j = to;
    	int p = from + 1, q = to;
    	while(i <= j){
            print(array);   	
    		while(array[i] < pivot) 
    			i++;
    		while(array[j] > pivot) 
    			j--;
    		if(i < j)
    			swap(array,i,j);
			if(array[i] == pivot){
				swap(array,i,p);
				p++;
			}
			if(array[j] == pivot){
				swap(array,j,q);
				q--;
			}
			i++; j--;
    	}
    	while(p >= 0 && j >= 0){
    		swap(array,j,p);
    		p--;
    		j--;
    	}
    	while(q <= to && i <= to){
    		swap(array,i,q);
    		i++;
    		q++;
    	}
    	
    	sortModified(array,from,j);
    	sortModified(array,i,to);
    }
//    public static int partitionModified(int[] array, int from, int to){
//
//    }
    
}
