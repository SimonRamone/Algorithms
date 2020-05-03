/******************************************************************************
 *  Compilation:  javac Huffman.java
 *  Execution:    java Huffman compress < input.txt > output.txt     (compress)
 *  Execution:    java Huffman decompress < input.txt > output.txt   (decompress)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *
 *  Compress or expand text input from standard input using Huffman coding.
 ******************************************************************************/


/**
 *  The {@code Huffman} class provides static methods for compressing
 *  and decompressing text input using Huffman coding.
 *
 *  @author Simonas Ramonas 18763829
 *  @author Shijie Liu 18439314
 */

public class Huffman {

    // alphabet size of extended ASCII
    private static final int R = 256;

    // Do not instantiate.
    private Huffman() { }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
    	int[] freq = new int[R];				//Frequencies of each ASCII character in input String
    	String[] codeTable = new String[R];		//Array of encoded characters
    
        // read the input
    	String input = BinaryStdIn.readString();	//Input string from file
    	
        // tabulate frequency counts
    	for(int i = 0; i  < input.length(); i++) {
    		freq[input.charAt(i)]++;
    	}

        // build Huffman trie
    	Node trie = buildTrie(freq);

        // build code table
    	buildCode(codeTable, trie, "");

        // print trie to output file for decoder
    	writeTrie(trie);

        // print number of bytes in original uncompressed message
    	BinaryStdOut.write(input.length());

        // use Huffman code to encode input
    	StringBuilder encodedInput = new StringBuilder();
    	
    	for(int i = 0; i < input.length(); i++) {
    		encodedInput.append(codeTable[input.charAt(i)]);	//Encode input string
    	}
    	
    	// convert encoded string to booleans and print to output file
    	for(int i = 0; i < encodedInput.length(); i++) {
    		if(encodedInput.charAt(i) == '1') {				
    			BinaryStdOut.write(true);				//If bit is 1
    		} 
    		else {
    			BinaryStdOut.write(false);				//If bit is 0
    		}
    	}
    	
    	BinaryStdOut.close();			//Flush and close standard output
    }
    

    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {
    	// read in Huffman trie from input stream
    	Node root = readTrie();
    	
    	// number of bytes to write
    	int length = BinaryStdIn.readInt();
    	
        // decode using the Huffman trie
    	for(int i = 0; i < length; i++) {				//Read bits until you reach length of uncompressed message
    		Node child = root;							//Start at root
    		while(!child.isLeaf()) {					//While not leaf node
    			if(!BinaryStdIn.readBoolean()) {
    				child = child.left;					//Go to left node if bit is 0
    			}
    			else {
    				child = child.right;				//Go to right node if bit is 1
    			}
    		}
    		BinaryStdOut.write(child.ch, 8);			//Print char at leaf node to output file
    	}
    	
    	BinaryStdOut.close();			//Flush and close standard output
    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else                 pq.insert(new Node('\1', 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);

    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }



    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	if (args[0].equals("compress")) {   	
    		compress();
    	}
		else if (args[0].equals("decompress")) {     
			decompress();
		}
		else throw new IllegalArgumentException("Illegal command line argument");
    	
//    	if (args[0].equals("compress")) {
//    		final long startTime = System.nanoTime();
//    		compress();
//    		final long elapsedTime = System.nanoTime() - startTime;
//    		System.out.println("The time taken: " + (float)elapsedTime/1000000);
//    		BinaryStdOut.write("The time taken: " + (float)elapsedTime/1000000);
//    		BinaryStdOut.close();
//    	}
//    		else if (args[0].equals("decompress")) { 
//    			final long startTime = System.nanoTime();
//    			decompress();
//    			final long elapsedTime = System.nanoTime() - startTime;
//    			BinaryStdOut.write("The time taken: " + (float)elapsedTime/1000000);
//        		BinaryStdOut.close();
//    		
//    		}
//    			else throw new IllegalArgumentException("Illegal command line argument");	
    }

}

