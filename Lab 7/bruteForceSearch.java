// Java program for Naive Pattern Searching 

import java.io.File; 
import java.util.Scanner; 
import java.lang.*;

public class bruteForceSearch {
	
	public static void BFSearch(String pat, String txt)	{ 
		int n = txt.length();	
		int m = pat.length();
		for(int pos = 0; pos <= n-m; pos++){
			int i;
			for(i = 0; i < m; i++){
				if(txt.charAt(pos + i) != pat.charAt(i)){
					break;
				}
				
			}
			if(i == m) System.out.println(pos);
		}

	}

	public static void main(String[] args) throws Exception{ 
		File file = new File("test1.txt"); 
		Scanner sc = new Scanner(file); 
		
		String txtMid1K = sc.nextLine();
		String txtEnd1K = sc.nextLine();
		String txtMid5K = sc.nextLine();
		String txtEnd5K = sc.nextLine();
		String txtMid10K = sc.nextLine();
		String txtEnd10K = sc.nextLine();
		String pat = sc.nextLine(); 
		
		final long startTime6 = System.nanoTime(); 
		BFSearch(pat, txtMid1K);
		final long elapsedTime6 = System.nanoTime() - startTime6;  
		System.out.println("the time taken " + (float)elapsedTime6/1000000);
		
		final long startTime7 = System.nanoTime(); 
		BFSearch(pat, txtEnd1K);
		final long elapsedTime7 = System.nanoTime() - startTime7;  
		System.out.println("the time taken " + (float)elapsedTime7/1000000);
		
		final long startTime8 = System.nanoTime(); 
		BFSearch(pat, txtMid5K);
		final long elapsedTime8 = System.nanoTime() - startTime8;  
		System.out.println("the time taken " + (float)elapsedTime8/1000000);
		
		final long startTime9 = System.nanoTime(); 
		BFSearch(pat, txtEnd5K);
		final long elapsedTime9 = System.nanoTime() - startTime9;  
		System.out.println("the time taken " + (float)elapsedTime9/1000000);
		
		final long startTime10 = System.nanoTime(); 
		BFSearch(pat, txtMid10K);
		final long elapsedTime10 = System.nanoTime() - startTime10;  
		System.out.println("the time taken " + (float)elapsedTime10/1000000);
		
		final long startTime11 = System.nanoTime(); 
		BFSearch(pat, txtEnd10K);
		final long elapsedTime11 = System.nanoTime() - startTime11;  
		System.out.println("the time taken " + (float)elapsedTime11/1000000); 
	} 
} 