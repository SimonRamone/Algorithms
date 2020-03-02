

import java.util.Arrays;
import java.util.Random;

	/**
	 * Implementation of various sorting algorithms 
	 * that includes a framework for testing with various input array sizes and over
	 * multiple runs
	 * 
	 */

public class Sorts {

private static Random r = new Random(System.currentTimeMillis());
public static void main(String args[]) { 

System.out.println("running main");
//use an integer variable to decide which sorting algorithm to use below
int type = 0; 

			
///adjust input size to vary size of arrays
for (int inputSize = 1; inputSize < 10; inputSize++) {
//vary total Runs to give you many empirical tests
	System.out.print("inputSize " + inputSize);
	
	int totalRuns = 1000;
	System.out.println("total runs " + totalRuns); 
    

	long totalruntime = 0;

	for (int run = 0; run < totalRuns; run++) {

	int[] nums = new int[inputSize];

    for (int i = 0; i < nums.length; i++) {
	 nums[i] = r.nextInt(5 * inputSize);
	  }
    
  
    long time = System.nanoTime();

					switch (type) {
						case 0:
						//selectionsort algorithm
					     selectionSort(nums);
						break;
						
						case 1:
						//insertsort algorithm
						insertionSort(nums);
						break;
						
						case 2:
						//some silly algorithm
						break;
						
						default:
							System.err.printf("\nBad sort ID '%d'", type);
							System.exit(-2);
					}


					totalruntime += System.nanoTime() - time;

				}
				//printout runtime.
				System.out.println("totaal run time " + totalruntime);
			}

		}
		
		//********print helper class*****
		// Prints the input array 
	    private static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        	System.out.println(); 
	    } 
	 



		// ***************************** Insertion Sorts *****************************


		//insert your MergeSort implementation here


		public static int[] quickSort(int[] array, int low, int high){
				if(low < high){
					int pi = partition(array, low, high);
					
					quickSort(array, low, pi-1);
					quickSort(array, pi+1, high);
				}
				return array;
			}
			
		public static int partition(int[] array, int low, int high){
			int pivot = array[high];
			int i = low - 1;
			int temp;
			
			for(int j = low; j <= high-1; j++){
				if(array[j] < pivot){
					i++;
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		
			temp = array[i+1];
			array[i+1] = array[high];
			array[high] = temp;
			
			return i+1;	
		}
		
	public static int[] enhancedQuickSort(int[] array, int low, int high){
		if (high <= low + CUTOFF) { 
			insertionSort(array);
			return array;
		}
		
		if(low < high){
			int pi = partition(array, low, high);
			
			quickSort(array, low, pi-1);
			quickSort(array, pi+1, high);
		}
		return array;
	}

	
	public static void insertionSort(int[] arr) {
		System.out.println("Insertion Sort"); 
	  for (int i = 1; i < arr.length; i++) {
		  int valueToSort = arr[i]; 
		  int j = i;
		  
		  while (j > 0 && arr[j-1] > valueToSort) {
			  arr[j] = arr[j-1]; 
			  j--; 
		  }
		  arr[j] = valueToSort; 
	  }
            
    printArray(arr);
    
	}

	

		// ***************************** Selection Sort ****************************

		public static void selectionSort(int[] nums) {
			int minindex;
			for (int i = 0; i < nums.length - 1; i++) {
				minindex = i;
				for (int j = i; j < nums.length; j++) {
					if (nums[j] < nums[minindex]) {
						minindex = j;
					}
				}
				if (minindex != i) {
					int tmp = nums[i];
					nums[i] = nums[minindex];
					nums[minindex] = tmp;
				}
			}
		}

		// ***************************** Silly Sorts *****************************
		//*** the silliest sorts of them all
		public static void bogoSort(int[] nums) {
			while (!isSorted(nums)) {
				shuffle(nums);
			}
		}
		
       //******shuffle helpfer for bogoSort
		// Knuth Shuffle
		private static void shuffle(int[] nums) { 
			int n, tmp;
			for (int i = nums.length - 1; i > 0; i--) {
				n = r.nextInt(i + 1);
				tmp = nums[i];
				nums[i] = nums[n];
				nums[n] = tmp;
			}
		}
		
		//**helper function to check if your array is sorted or not
		public static boolean isSorted(int[] nums) {
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					return false;
				}
			}
			return true;
		}
	

	}
