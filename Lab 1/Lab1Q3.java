import java.lang.*;

class Lab1Q3 {
	public static void main(String[] args) {
		int a = 68;
		int b = 139;
	 	final long startTime = System.currentTimeMillis(); 
		System.out.println(russianMultiply(a, b));
		final long elapsedTime = System.currentTimeMillis() - startTime;  
		System.out.println("The time taken " + elapsedTime);  
		
	}
	
	public static long russianMultiply(int number1, int number2){
		int accumulator = 0;
		
		while (number1 > 1){
			if (number1 % 2 == 0){
				number1 = number1 / 2;
				number2 = number2 * 2;
			}
			else {
				number1 = (number1 - 1) / 2;
				accumulator = accumulator + number2;
				number2 = number2 * 2;
			}
		}
		return accumulator + number2;
	}
}