import java.util.Scanner; 

public class RunLengthEncoding {

	public static void encodeAndPrint(String str){
		int length = str.length();
		for (int i = 0; i < length; i++) {
			int count = 1;
			while(i < length-1 && str.charAt(i) == str.charAt(i+1)){
				count++;
				i++;
			}
			System.out.print(str.charAt(i));
			System.out.print(count);
		}
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = "";
		System.out.println("Enter string for encoding: ");
		if(scanner.hasNext()){
			str = scanner.nextLine();
			System.out.println("Encoded string: ");
			encodeAndPrint(str);
		}
		scanner.close();	
	}

}