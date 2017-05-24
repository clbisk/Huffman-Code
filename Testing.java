package homework5;

import java.util.ArrayList;

public class Testing {
	
	public static void print(ArrayList<Letters> l) {
		System.out.print("{ ");
		for (int i = 0; i < l.size(); i++) {
			Letters letter = l.get(i);
			System.out.print("(" + letter.getLetter() + ", " + letter.getFreq() + ") ");
		}
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		 /** Integer[] a = {3, 5, 7, 8, 9, 3, 5, 0};
		  MaxHeap<Integer> max = new MaxHeap<Integer>(a, 7, 8);
		  max.printheap();
		  System.out.println("\n");
		  MinHeap<Integer> min = new MinHeap<Integer>(a, 7, 8);
		  min.printheap();**/
		  
		String message = "AAAAAAAaaaaBBBBbbC";
		HauffmanTree cipher = HauffmanCode.hauffmanEncode(message);
		
		cipher.print();
		
		String code = HauffmanCode.encode(message, cipher);
		System.out.print("'" + code + "' = ");
		
		String reMessage = HauffmanCode.decode(code, cipher);
		System.out.print(reMessage);
		
		System.out.println("\n");
		
		String message2 = "Hello, I'm John.";
		HauffmanTree cipher2 = HauffmanCode.hauffmanEncode(message2);
		
		cipher2.print();
		
		String code2 = HauffmanCode.encode(message2, cipher2);
		System.out.print ("'" + code2 + "' = ");
		
		String reMessage2 = HauffmanCode.decode(code2, cipher2);
		System.out.print(reMessage2);
		
		System.out.println("\n");
		
		String message3 = "";
		HauffmanTree cipher3 = HauffmanCode.hauffmanEncode(message3);
		
		cipher3.print();
		
		String code3 = HauffmanCode.encode(message3, cipher3);
		System.out.print(code3 + " = ");
		
		String reMessage3 = HauffmanCode.decode(code3, cipher3);
		System.out.print(reMessage3);
	}

}
