import java.lang.*;

class RussianPeasantMultiplication {
	public static void main(String[] args) {
//		int a = 1;
//		int b = 1;
//		int a = 10;
//		int b = 15;
//		int a = 265;
//		int b = 349;
//		int a = 1552;
//		int b = 1655;
		int a = 4464;
		int b = 9389;
	 	final long startTime = System.currentTimeMillis();
		System.out.println(a + " * " + b + " = " + russianMultiply(a, b));
		final long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("The time taken " + elapsedTime);
	}
	
	public static long russianMultiply(int number1, int number2){
		int accumulator = 0;				
		
		while (number1 > 1){
			if (number1 % 2 == 0){			//if first number is even
				number1 = number1 / 2;		
				number2 = number2 * 2;
			}
			else {							//if first number is odd
				number1 = (number1 - 1) / 2;
				accumulator = accumulator + number2;
				number2 = number2 * 2;
			}
		}
		return accumulator + number2;
	}
}