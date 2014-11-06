

public class Sorter {

    public static void swap(int[] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void moveLeft() {

    }


//    public static void sortModified(int[] array, int from, int to){
//    	if(from > to)
//    		return;
//
//    	int pivot = array[from];
//    	int i = from + 1, j = to;
//    	int p = from + 1, q = to;
//    	while(i <= j){
//            print(array,i,j);   	
//    		while(array[i] < pivot){
//    			print(array,i,j);  
//    			i++;
//    		}
//    		while(array[j] > pivot) {
//    			print(array,i,j);  
//    			j--;
//    		}
//    		if(i < j){
//    			swap(array,i,j);
//    			print(array,i,j);  
//    		}
//    		
//			if(array[i] == pivot){
//				swap(array,i,p);
//				print(array,i,j);  
//				p++;
//			}
//			if(array[j] == pivot){
//				swap(array,j,q);
//				print(array,i,j);  
//				q--;
//			}
//			if(i == j){
//				j--;
//				if(array[j] == pivot){
//					j++;
//					i--;
//				}
//				break;
//			}
//			i++; j--;
//			print(array,i,j); 
//    	}
//    	print(array,i,j);
//    	System.out.println();
//    	p--; q++;
//    	while(p >= 0 && j >= 0){
//    		swap(array,j,p);
//    		print(array,i,j);
//    		p--;
//    		j--;
//    	}
//    	while(q <= to && i <= to){
//    		swap(array,i,q);
//    		print(array,i,j);
//    		i++;
//    		q++;
//    	}
//    	System.out.println("End ");
//    	sortModified(array,from,j);
//    	sortModified(array,i,to);
//    }
//    public static int partitionModified(int[] array, int from, int to){
//
//    }
}
