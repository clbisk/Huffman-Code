package homework5;

import java.util.ArrayList;

public class HauffmanCode {
	public static HauffmanTree hauffmanEncode(String s) {
		if (s.length() == 0)
			return new HauffmanTree();
		MinHeap<Letters> letters = HauffmanCode.makeHeap(s);
		HauffmanTree cipher = HauffmanCode.heapToTree(letters);
		return cipher;
	}
	
	public static MinHeap<Letters> makeHeap(String s) {
		ArrayList<Letters> letters = new ArrayList<Letters>();
		while (s.length() > 0) {
			char letter = s.charAt(0);
			s = s.substring(1, s.length());
			int frequency = 1;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == letter) {
					frequency++;
					s = s.substring(0, j) + s.substring(j+1, s.length());
					j--;
				}
			}
			letters.add(new Letters(Character.toString(letter), frequency));
		}
		Letters[] a = new Letters[letters.size()];
		letters.toArray(a);
		return new MinHeap<Letters>(a, letters.size(), letters.size());
	}
	
	public static HauffmanTree heapToTree(MinHeap<Letters> m) {
		//create a list with all the nodes including combined letters in order of smallest to largest
		ArrayList<Letters> leftovers = new ArrayList<Letters>();
		//BST<Letters> codeTree = new BST<Letters>();
		while (m.heapsize() > 1) {
			Letters let1 = m.removemin();
			leftovers.add(let1);
			Letters let2 = m.removemin();
			leftovers.add(let2);
			Letters combo = new Letters(let1, let2);
			m.insert(combo);
		}
	    leftovers.add(m.removemin());
	    
	    //use this list to create a Hauffman Tree
	    HauffmanTree tree = new HauffmanTree();
	    while(leftovers.size() != 0) {
	    	tree.insert_el(leftovers.remove(leftovers.size()-1));
	    }
	    
	    return tree;
	}
	
	public static String encode(String message, HauffmanTree cipher) {
		if (cipher == null)
			return null;
		
		String code = "";
		
		for (int i = 0; i < message.length(); i++) {
			code += cipher.find_el(message.charAt(i));
		}
		
		return code;
	}
	
	public static String decode(String codedMessage, HauffmanTree cipher) {
		if (cipher.size() == 0)
			return null;
		
		return cipher.decodeCode(codedMessage);
	}
}
