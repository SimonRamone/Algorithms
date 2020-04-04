//import Trie.TrieNode;

public class Trie{

	// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26; 


	// class for Trie node 
	static class TrieNode { 
		TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
		// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord; 

		TrieNode(){ 
			isEndOfWord = false; 

			for (int i = 0; i < ALPHABET_SIZE; i++) 
				children[i] = null; 
		} 
	}

	static TrieNode root;
	// If not key present, inserts into trie 
	// If the key is prefix of Trie node,  
	//  marks leaf node
	static void insert(String key){ 
		TrieNode current = root;
		char currentLetter = key.charAt(0);
		
		for(int i = 0; i < key.length(); i++){
			currentLetter = key.charAt(i);
			if(current.children[currentLetter-97] == null){
				current.children[currentLetter-97] = new TrieNode();
			}
			current = current.children[currentLetter-97];
		}
		current.isEndOfWord = true;
	} 

	// Returns true if key presents in trie, else false 
	static boolean search(String key) { 
		TrieNode current = root;
		char currentLetter = key.charAt(0);
		
		for(int i = 0; i < key.length(); i++){
			currentLetter = key.charAt(i);
			if(current.children[currentLetter-97] == null){
				return false;
			}
			current = current.children[currentLetter-97];
		}
		return current.isEndOfWord;
	} 


	// Driver 
	public static void main(String args[]) { 

		// Input keys (use only 'a' through 'z' and lower case) 
		String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


		String output[] = {"Not present in trie", "Present in trie"}; 

		root = new TrieNode(); 

		// Construct trie 
		int i; 
		for (i = 0; i < keys.length ; i++) {
			insert(keys[i]); 
		}

		// Search for different keys 
		System.out.println(search("dog")?output[1]:output[0]);		//false
		System.out.println(search("bank")?output[1]:output[0]);		//true
		System.out.println(search("cat")?output[1]:output[0]);		//false
		System.out.println(search("film")?output[1]:output[0]);		//true
		System.out.println(search("movie")?output[1]:output[0]);	//false
		System.out.println(search("sim")?output[1]:output[0]);		//false
		System.out.println(search("simple")?output[1]:output[0]);	//true
		System.out.println(search("silver")?output[1]:output[0]);	//true

	} 

//end of class
} 