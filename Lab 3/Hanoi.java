import java.lang.*;

class Hanoi {
	public static int moves = 0;
	public static void main(String[] args) {
		int disks = 15;
		final long startTime1 = System.currentTimeMillis(); 
		towersOfHanoi(disks, 'A', 'C', 'B');
		final long elapsedTime1 = System.currentTimeMillis() - startTime1;
		System.out.println();
		System.out.println("The time taken " + elapsedTime1);
		System.out.println("Min moves: " + moves);
	}
	
	public static void towersOfHanoi(int disks, char src, char dest, char aux){
		if(disks == 0)
			System.out.println("Move disk from " + src + " to " + dest);
			else {
				moves++;
				towersOfHanoi(disks-1, src, aux, dest);
				towersOfHanoi(disks-1, aux, dest, src);
			}
	}
}