import java.lang.*;

class Hanoi {
	public static void main(String[] args) {
		int disks = 3;
		towersOfHanoi(disks, 'A', 'C', 'B');
	}
	
	public static void towersOfHanoi(int disks, char src, char dest, char aux){
		if(disks == 0)
			System.out.println("Move disk from " + src + " to " + dest);
			else {
				towersOfHanoi(disks-1, src, aux, dest);
				towersOfHanoi(disks-1, aux, dest, src);
			}
	}
}