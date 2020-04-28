import java.util.*;

class NumberListAddition{
	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		a.add(2);a.add(9);a.add(0);a.add(3);
		b.add(9);b.add(9);
		LinkedList<Integer> res = addition(a, b);
		int sizeOfList = res.size();
		for(int i = 0; i < sizeOfList; i++)
			System.out.print(res.get(i));
	}
	
	public static LinkedList<Integer> addition (LinkedList<Integer> a, LinkedList<Integer> b){
		LinkedList<Integer> result = new LinkedList<Integer>();
		int maxSize = a.size()>b.size()?a.size():b.size();
		int sizeA = a.size();
		int sizeB = b.size();
		int sum;
		int rem;
		int carry = 0;
		while(a.size() != maxSize){
			a.add(0, 0);
			sizeA++;
		}
		while(b.size() != maxSize){
			b.add(0, 0);
			sizeB++;
		}
		for(int i = maxSize-1; i >= 0; i--){
			sum = a.get(sizeA-1) + b.get(sizeB-1) + carry;
			rem = sum%10;
			carry = sum/10;
			result.add(0, rem);
			sizeA--;
			sizeB--;
		}
		if(carry > 0) result.add(0, carry);
		return result;
	}
}