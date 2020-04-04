// JAVA program for implementation of KMP pattern 
// searching algorithm 

import java.io.File; 
import java.util.Scanner; 
import java.lang.*;

class KMPsearch { 
	void KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 

        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[M]; 
        int j = 0; // index for pat[] 
  
        // Preprocess the pattern (calculate lps[] 
        // array) 
        computeLPSArray(pat, M, lps); 
  
		int i = 0;
		while(i < N){
			if(pat.charAt(j) == txt.charAt(i)){
				i++;
				j++;
			}
			if(j == M){
				System.out.println(i - j); 
				j = lps[j - 1];
			}
			else if (i < N && pat.charAt(j) != txt.charAt(i)){
				if (j != 0) j = lps[j - 1]; 
				else i = i + 1;
			}
		}
    } 
  
    void computeLPSArray(String pat, int M, int lps[]) 
    { 
        // length of the previous longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0; // lps[0] is always 0 
  
        // the loop calculates lps[i] for i = 1 to M-1 
        while (i < M) { 
            if (pat.charAt(i) == pat.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else // (pat[i] != pat[len]) 
            { 
                // This is tricky. Consider the example. 
                // AAACAAAA and i = 7. The idea is similar 
                // to search step. 
                if (len != 0) { 
                    len = lps[len - 1]; 
  
                    // Also, note that we do not increment 
                    // i here 
                } 
                else // if (len == 0) 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 

    // Driver program to test above function 
    public static void main(String args[]) throws Exception
    { 	
		File file = new File("test1.txt"); 
		Scanner sc = new Scanner(file); 
		
		String txtMid1K = sc.nextLine();
		String txtEnd1K = sc.nextLine();
		String txtMid5K = sc.nextLine();
		String txtEnd5K = sc.nextLine();
		String txtMid10K = sc.nextLine();
		String txtEnd10K = sc.nextLine();
		String pat = sc.nextLine(); 
		
		final long startTime = System.nanoTime(); 
		new KMPsearch().KMPSearch(pat, txtMid1K);
		final long elapsedTime = System.nanoTime() - startTime;  
		System.out.println("the time taken " + (float)elapsedTime/1000000);
		
		final long startTime1 = System.nanoTime(); 
		new KMPsearch().KMPSearch(pat, txtEnd1K);
		final long elapsedTime1 = System.nanoTime() - startTime1;  
		System.out.println("the time taken " + (float)elapsedTime1/1000000);
		
		final long startTime2 = System.nanoTime(); 
		new KMPsearch().KMPSearch(pat, txtMid5K);
		final long elapsedTime2 = System.nanoTime() - startTime2;  
		System.out.println("the time taken " + (float)elapsedTime2/1000000);
		
		final long startTime3 = System.nanoTime(); 
		new KMPsearch().KMPSearch(pat, txtEnd5K);
		final long elapsedTime3 = System.nanoTime() - startTime3;  
		System.out.println("the time taken " + (float)elapsedTime3/1000000);
		
		final long startTime4 = System.nanoTime(); 
		new KMPsearch().KMPSearch(pat, txtMid10K);
		final long elapsedTime4 = System.nanoTime() - startTime4;  
		System.out.println("the time taken " + (float)elapsedTime4/1000000);
		
		final long startTime5 = System.nanoTime(); 
		new KMPsearch().KMPSearch(pat, txtEnd10K);
		final long elapsedTime5 = System.nanoTime() - startTime5;  
		System.out.println("the time taken " + (float)elapsedTime5/1000000);
		
	} 
} 