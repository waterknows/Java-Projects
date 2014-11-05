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
//        print(array,-1,-1);
        sortModified(array,0,MAX-1);
//        print(array);
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
    public static void sortModified(int[] array, int from, int to){
    	if(from > to)
    		return;

    	int pivot = array[from];
    	int i = from + 1, j = to;
    	int p = from + 1, q = to;
    	while(i <= j){
            print(array,i,j);   	
    		while(array[i] < pivot){
    			print(array,i,j);  
    			i++;
    		}
    		while(array[j] > pivot) {
    			print(array,i,j);  
    			j--;
    		}
    		if(i < j){
    			swap(array,i,j);
    			print(array,i,j);  
    		}
    		
			if(array[i] == pivot){
				swap(array,i,p);
				print(array,i,j);  
				p++;
			}
			if(array[j] == pivot){
				swap(array,j,q);
				print(array,i,j);  
				q--;
			}
			if(i == j){
				j--;
				if(array[j] == pivot){
					j++;
					i--;
				}
				break;
			}
			i++; j--;
			print(array,i,j); 
    	}
    	print(array,i,j);
    	System.out.println();
    	p--; q++;
    	while(p >= 0 && j >= 0){
    		swap(array,j,p);
    		print(array,i,j);
    		p--;
    		j--;
    	}
    	while(q <= to && i <= to){
    		swap(array,i,q);
    		print(array,i,j);
    		i++;
    		q++;
    	}
    	System.out.println("End ");
    	sortModified(array,from,j);
    	sortModified(array,i,to);
    }
//    public static int partitionModified(int[] array, int from, int to){
//
//    }
    
}
