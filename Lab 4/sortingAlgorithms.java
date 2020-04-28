import java.util.Random;
import java.lang.*;

class sortingAlgorithms {
	public static void main(String[] args) {
		int[] array1000 = generateArray(1000);
				int[] array10000 = generateArray(10000);
				int[] array100000 = generateArray(100000);
				
				int[] array1000copy = new int[1000];
				int[] array10000copy = new int[10000];;
				int[] array100000copy = new int[100000];;
				
				int[] array5 = generateArray(5);
				int[] array10 = generateArray(10);
				
				System.arraycopy(array1000, 0, array1000copy, 0, 1000);
				System.arraycopy(array10000, 0, array10000copy, 0, 10000);
				System.arraycopy(array100000, 0, array100000copy, 0, 100000);
				
				final long startTime1 = System.currentTimeMillis(); 
				selectionSort(array1000);
				final long elapsedTime1 = System.currentTimeMillis() - startTime1;
				System.out.println();
				System.out.println("The time taken for selection 1k int " + elapsedTime1);
				
				final long startTime2 = System.currentTimeMillis(); 
				selectionSort(array10000);
				final long elapsedTime2 = System.currentTimeMillis() - startTime2;
				System.out.println();
				System.out.println("The time taken for selection 10k int " + elapsedTime2);
				
				final long startTime3 = System.currentTimeMillis(); 
				selectionSort(array100000);
				final long elapsedTime3 = System.currentTimeMillis() - startTime3;
				System.out.println();
				System.out.println("The time taken for selection 100k int " + elapsedTime3);
				
				final long startTime4 = System.currentTimeMillis(); 
				insertionSort(array1000copy);
				final long elapsedTime4 = System.currentTimeMillis() - startTime4;
				System.out.println();
				System.out.println("The time taken for insertion 1k int " + elapsedTime4);
				
				final long startTime5 = System.currentTimeMillis(); 
				insertionSort(array10000copy);
				final long elapsedTime5 = System.currentTimeMillis() - startTime5;
				System.out.println();
				System.out.println("The time taken for insertion 10k int " + elapsedTime5);
				
				final long startTime6 = System.currentTimeMillis(); 
				insertionSort(array100000copy);
				final long elapsedTime6 = System.currentTimeMillis() - startTime6;
				System.out.println();
				System.out.println("The time taken for insertion 100k int " + elapsedTime6);
				
				final long startTime7 = System.currentTimeMillis(); 
				bogoSort(array5);
				final long elapsedTime7 = System.currentTimeMillis() - startTime7;
				System.out.println();
				System.out.println("The time taken for bogo 5 int " + elapsedTime7);
				
				final long startTime8 = System.currentTimeMillis(); 
				bogoSort(array10);
				final long elapsedTime8 = System.currentTimeMillis() - startTime8;
				System.out.println();
				System.out.println("The time taken for bogo 10 int " + elapsedTime8);
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
	
}