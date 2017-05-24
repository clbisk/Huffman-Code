package homework5;

public class Letters implements Comparable<Letters> {
	private String letter;
	private int freq;
	
	//Constructors
	public Letters(String l, int f) {
		letter = l;
		freq = f;
	}
	
	public Letters(Letters l1, Letters l2) {
		letter = l1.getLetter() + l2.getLetter();
		freq = l1.getFreq() + l2.getFreq();
	}
	
	//other methods
	public void incFreq() {
		freq++;
	}
	
	public int getFreq() {
		return freq;
	}
	public String getLetter() {
		return letter;
	}
	
	//check if this is a substring of l
	public boolean compareLetters(Letters l) {
		return letter.contains(l.getLetter());
	}
	
	@Override
	public int compareTo(Letters l) {
		return (freq - l.getFreq());
	}
	
	@Override
	public String toString() {
		return "(" + letter + ", " + freq + ")";
	}
}
