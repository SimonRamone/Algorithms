import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class WordSort {
		private static String inputFileName = "/Users/simonas/eclipse-workspace/Scrabble Bot/src/Collins_Scrabble_Words_2019.txt";
			private static final int[] TILE_VALUE = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
			ArrayList<WordNode> highestScoringWords = new ArrayList<WordNode>();

				public static class WordNode implements Comparable<WordNode>{
					String word;
					int score;
					
					public WordNode(String w, int s){
						word = w;
						score = s;
					}
					
					public void setScore(int s){score = s;}
					public void setWord(String w){word = w;}
					
					public int getScore(){return score;}
					public String getWord(){return word;}
					
					public int compareTo(WordNode node) {
						
						   return WordNode.compare(getScore(), node.getScore());
					}

					private static int compare(int score2, int score3) {
						if(score2 < score3) {
				            return 1;           
				        }
				        if(score2 == score3) {
				            return 0;           
				        }
				        return -1;
					}
				}
				
				private static int getWordScore(String word) {
					int wordScore = 0;
					for (int i = 0; i<word.length(); i++) {
						int letterValue = TILE_VALUE[word.charAt(i)-65];
						wordScore += letterValue;
					}
					return wordScore;
				}
				
				public void makeHighestScoringWordsList() throws FileNotFoundException {
					File inputFile = new File(inputFileName);
					Scanner in = new Scanner(inputFile);
					while (in.hasNextLine()) {
						String word = in.nextLine();
						WordNode node = new WordNode(word, getWordScore(word));
						highestScoringWords.add(node);
					}
					in.close();
				}
				
				public void sortHighestScoringWordsList() {
					Collections.sort(highestScoringWords);
				}
				
				
				
			public static void main(String[] args) throws FileNotFoundException{
				WordSort words = new WordSort();
				words.makeHighestScoringWordsList();
				words.sortHighestScoringWordsList();
				for(int i = 0; i < 1000; i++){
					System.out.println(words.highestScoringWords.get(i).getWord());
				}
			}

}