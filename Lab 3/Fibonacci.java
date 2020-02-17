import java.lang.*;

class Fibonacci {
	public static void main(String[] args) {
		//Fibonacci Iterative
		final long startTime1 = System.currentTimeMillis(); 
		for(int i = 0; i <= 45; i++)
			System.out.print(FibonacciIterative(i) + " ");
		final long elapsedTime1 = System.currentTimeMillis() - startTime1;
		System.out.println();
		System.out.println("The time taken " + elapsedTime1);
		
		System.out.println();
		
		//Fibonacci Recursive
		final long startTime2 = System.currentTimeMillis(); 
		for(int i = 0; i <= 45; i++)
			System.out.print(FibonacciRecursive(i) + " ");
		final long elapsedTime2 = System.currentTimeMillis() - startTime2; 
		System.out.println();
		System.out.println("The time taken " + elapsedTime2);
	}
	
	public static int FibonacciRecursive(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return FibonacciRecursive(n-1) + FibonacciRecursive(n-2);
	}
	
	public static int FibonacciIterative(int n){
		int fib = 1;
		int prevFib = 1;
		
		if(n == 0) fib = 0;
			else if(n == 1 || n == 2) fib = 1;
				else {
					for(int i = 2; i < n; i++){
						int temp = fib;
						fib = fib + prevFib;
						prevFib = temp;
					}
				}
				
		return fib;
	}
}