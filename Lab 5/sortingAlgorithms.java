import java.util.Random;
import java.lang.*;

class sortingAlgorithms {
		private static final int CUTOFF = 10;
	
	public static void main(String[] args) {
		int[] array1000 = generateArray(1000);
		int[] array10000 = generateArray(10000);
		int[] array100000 = generateArray(100000);
		
		int[] array1000copy1 = new int[1000];
		int[] array10000copy1 = new int[10000];
		int[] array100000copy1 = new int[100000];
		
		int[] array1000copy2 = new int[1000];
		int[] array10000copy2 = new int[10000];
		int[] array100000copy2 = new int[100000];
		
		System.arraycopy(array1000, 0, array1000copy1, 0, 1000);
		System.arraycopy(array10000, 0, array10000copy1, 0, 10000);
		System.arraycopy(array100000, 0, array100000copy1, 0, 100000);
		System.arraycopy(array1000, 0, array1000copy2, 0, 1000);
		System.arraycopy(array10000, 0, array10000copy2, 0, 10000);
		System.arraycopy(array100000, 0, array100000copy2, 0, 100000);
		
		final long startTime1 = System.currentTimeMillis(); 
		insertionSort(array1000);
		final long elapsedTime1 = System.currentTimeMillis() - startTime1;
		System.out.println();
		System.out.println("The time taken for insertion 1k int " + elapsedTime1);
		
		final long startTime2 = System.currentTimeMillis(); 
		insertionSort(array10000);
		final long elapsedTime2 = System.currentTimeMillis() - startTime2;
		System.out.println();
		System.out.println("The time taken for insertion 10k int " + elapsedTime2);
		
		final long startTime3 = System.currentTimeMillis(); 
		insertionSort(array100000);
		final long elapsedTime3 = System.currentTimeMillis() - startTime3;
		System.out.println();
		System.out.println("The time taken for insertion 100k int " + elapsedTime3);
		
		final long startTime4 = System.currentTimeMillis(); 
		mergeSort(array1000copy1);
		final long elapsedTime4 = System.currentTimeMillis() - startTime4;
		System.out.println();
		System.out.println("The time taken for mergeSort 1k int " + elapsedTime4);
		
		final long startTime5 = System.currentTimeMillis(); 
		mergeSort(array10000copy1);
		final long elapsedTime5 = System.currentTimeMillis() - startTime5;
		System.out.println();
		System.out.println("The time taken for mergeSort 10k int " + elapsedTime5);
		
		final long startTime6 = System.currentTimeMillis(); 
		mergeSort(array100000copy1);
		final long elapsedTime6 = System.currentTimeMillis() - startTime6;
		System.out.println();
		System.out.println("The time taken for mergeSort 100k int " + elapsedTime6);
		
		final long startTime7 = System.currentTimeMillis(); 
		mergeSortEnhanced(array1000copy2);
		final long elapsedTime7 = System.currentTimeMillis() - startTime7;
		System.out.println();
		System.out.println("The time taken for mergeSortEnhanced 1k int " + elapsedTime7);
		
		final long startTime8 = System.currentTimeMillis(); 
		mergeSortEnhanced(array10000copy2);
		final long elapsedTime8 = System.currentTimeMillis() - startTime8;
		System.out.println();
		System.out.println("The time taken for mergeSortEnhanced 10k int " + elapsedTime8);
		
		final long startTime9 = System.currentTimeMillis(); 
		mergeSortEnhanced(array100000copy2);
		final long elapsedTime9 = System.currentTimeMillis() - startTime9;
		System.out.println();
		System.out.println("The time taken for mergeSortEnhanced 100k int " + elapsedTime9);		
	}

	public static int[] generateArray(int size){
		Random rand = new Random(); // creating Random object
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(); // storing random integers in an array
		}
		return array;
	}
	
	
	public static int[] selectionSort(int[] array){
		int temp;
		int min_index;
		
		for(int i = 0; i < array.length - 1; i++){
			min_index = i;
			for(int j = i+1; j < array.length; j++){
				if(array[min_index] > array[j]){
					min_index = j;
				}	
			}
			temp = array[i];
		array[i] = array[min_index];
		array[min_index] = temp;
		}	
		return array;
	}
	
	public static int[] insertionSort(int[] array){
		for(int i = 1; i < array.length; ++i){
			int key = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > key){
				array[j+1] = array[j];
				j = j-1;
				array[j+1] = key;
			}
		}	
		return array;
	}
	

	
	public static int[] bogoSort(int[] array){
		while(!isSorted(array))	shuffleArray(array);
		return array;
	}
		
	public static int[] shuffleArray(int[] array){
		Random rand = new Random();
				
		for (int i = 0; i < array.length; i++) {
			int random_index = rand.nextInt(array.length);
			int temp = array[random_index];
			array[random_index] = array[i];
			array[i] = temp;
		}
		return array;
	}
		
	public static Boolean isSorted(int[] array){
		for (int i = 0; i < array.length-1; i++) {
			if(array[i] > array[i+1]) return false;
		}
		return true;
	}	

	public static int[] mergeSort(int[] array){
		int n = array.length;
		
		if(n == 1){
			return array;
		}
		
		int[] mergedArray = new int[n];
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++){
			left[i] = array[i];
		} 

		for (int i = mid; i < n; i++){
			right[i - mid] = array[i];
		}
		left = mergeSort(left);
		right = mergeSort(right);
		
		
		mergedArray = merge(left, right);
		
		return mergedArray;
	}
	
	public static int[] mergeSortEnhanced(int[] array){
		int n = array.length;
		
		if(n == 1){
			return array;
		}
		
		if(n <= 10){
			return insertionSort(array);
		}
		
		int[] mergedArray = new int[n];
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];

		for (int i = 0; i < mid; i++){
			left[i] = array[i];
		} 

		for (int i = mid; i < n; i++){
			right[i - mid] = array[i];
		}
		left = mergeSort(left);
		right = mergeSort(right);
		
		
		mergedArray = merge(left, right);
		
		return mergedArray;
	}

	public static int[] merge(int[] left, int[] right){
		int i = 0, j = 0, k = 0;
		int[] mergedArray = new int[left.length + right.length];
		
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) mergedArray[k++] = left[i++];
			else mergedArray[k++] = right[j++];
		}

		while (i < left.length){
			mergedArray[k++] = left[i++];
		}	

		while (j < right.length){
			mergedArray[k++] = right[j++];
		} 

		return mergedArray;
	}

	public static int[] mergeEnhanced(int[] left, int[] right){
		int i = 0, j = 0, k = 0;
		int[] mergedArray = new int[left.length + right.length];
		
		if(left[left.length-1] <= right[0]){
			for(int l = 0; l < left.length; l++){
				mergedArray[l] = left[l];
			}
			for(int m = left.length; m < right.length; m++){
				mergedArray[m] = right[m];
			}
		}
		
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) mergedArray[k++] = left[i++];
			else mergedArray[k++] = right[j++];
		}

		while (i < left.length){
			mergedArray[k++] = left[i++];
		}	

		while (j < right.length){
			mergedArray[k++] = right[j++];
		} 

		return mergedArray;
	}

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
				swap(array, i, j);
			}
		}
		
		swap(array, i+1, high);
		
		return i+1;	
	}



	public static void shuffle(int[] a) {
			int n = a.length;
			for (int i = 0; i < n; i++) {
				// choose index uniformly in [0, i]
				int r = (int) (Math.random() * (i + 1));
				swap(a, r, i);
			}
	}
		
	public static void shuffleQuickSort(int[] array){
		shuffle(array);
		enhancedQuickSort(array, 0, array.length-1);
	}

	public static int[] enhancedQuickSort(int[] array, int low, int high){
		if (high <= low + CUTOFF) { 
			insertionSort(array);
			return array;
		}
		else{
			if(low < high){
			int pi = enhancedPartition(array, low, high);
			
			enhancedQuickSort(array, low, pi-1);
			enhancedQuickSort(array, pi+1, high);
		}
		return array;
		}
		
	}
	
	 public static final void swap(int[] a, int index1, int index2){
			int temp = a[index1];
			a[index1] = a[index2];
			a[index2] = temp;
		}
	
	public static int enhancedPartition(int[] array, int low, int high){
		int middle = low + (high - low)/2;
		
		if(array[high] < array[low]){
			swap(array, low, high);
		}
		if(array[middle] < array[low]){
			swap(array, low, middle);
		}			 
		if(array[high] < array[middle]){
			swap(array, high, middle);
		}
		
		int pivot = array[middle];
		int i = low - 1;
		
		for(int j = low; j <= high-1; j++){
			if(array[j] < pivot){
				i++;
				swap(array, i, j);
			}
		}
		
		swap(array, i+1, high);
		
		return i+1;	
	}
}