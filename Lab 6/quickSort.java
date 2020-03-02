class quickSort {
	private static final int CUTOFF = 10;
	
	public static void main(String[] args) {
		int[] array = {6, 1, 3, 10, 2, 9, 16, 12, 10, 1, 10, 18, 13};
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		
		shuffleQuickSort(array);
		System.out.println();
		
		
		for(int j = 0; j < array.length; j++){
			System.out.print(array[j] + " ");
		}	
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
			
			if(low < high){
				int pi = enhancedPartition(array, low, high);
				
				enhancedQuickSort(array, low, pi-1);
				enhancedQuickSort(array, pi+1, high);
			}
			return array;
		}
		
		 public static final void swap(int[] a, int index1, int index2){
				int temp = a[index1];
				a[index1] = a[index2];
				a[index2] = temp;
			}
		
		public static int enhancedPartition(int[] array, int low, int high){
			int middle = array[low + (high - low)/2];
			
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