package homework5;

public class HauffmanTree {
	  private BSTNode<Letters> root; // Root of the BT
	  private int nodecount; // Number of nodes in the BT

	  // constructor
	  HauffmanTree() { root = null; nodecount = 0; }

	  // Reinitialize tree
	  public void clear() { root = null; nodecount = 0; }

	  // Find key and return its code
	  public String find_el(char key) {
		  // Write the iterative algorithm of finding the element key in BST.
		  BSTNode<Letters> rt = root;
		  String str = "";
		  while (rt != null)
		  {
			  if (rt.value().getLetter().equals("" + key))
				  return str;
			  else if (rt.left() != null && rt.left().value().getLetter().contains("" + key)) {
				  rt = rt.left();
				  str += "0";
			  }
			  else if (rt.right().value().getLetter().contains("" + key)) {
				  rt = rt.right();
				  str += "1";
			  }
			  else
				  return null;
		  }
		  return null;
	  }
	  
	  //Find all keys using a code; edits down the string once it has used it
	  public String decodeCode(String codedMessage) {
		  String message = "";
		  
		  //special case with only one character
		  if (nodecount == 1) {
			  BSTNode<Letters> onlyLetter = root;
			  //frequency times
			  for (int i = 0; i < onlyLetter.value().getFreq(); i++) {
				  //add the only letter
				  message += onlyLetter.value().getLetter();
			  }
			  return message;
		  }
		  
		  //go through the binary tree until you can't go anymore; that is the key at the code used so far
		  BSTNode<Letters> tracker = root;
		  while (codedMessage.length() > 0) {
			  char thischar = codedMessage.charAt(0);
			  
			  //go left
			  if (thischar == '0') {
				  //if you can't, you're done
				  if (tracker.left() == null) {
					  //add this letter to the final string and start back at the root
					  message += tracker.value().getLetter();
					  tracker = root;
				  }
				  //if you can, go there and use up that number
				  else {
					  tracker = tracker.left();
					  codedMessage = codedMessage.substring(1, codedMessage.length());
				  }
			  }
			  //go right
			  if (thischar == '1') {
				  //if you can't, you're done
				  if (tracker.left() == null) {
					  //add this letter to the final string and start back at the root
					  message += tracker.value().getLetter();
					  tracker = root;
				  }
				  //if you can, go there and use up that number
				  else {
					  tracker = tracker.right();
					  codedMessage = codedMessage.substring(1, codedMessage.length());
				  }
			  }
		  }
		  message += tracker.value().getLetter();
		  return message;
	  }
	  
	  // Insert a record into the tree.
	  // Records can be anything, but they must be Comparable
	  // key: The record to insert.
	  public void insert_el(Letters key) {
		  BSTNode<Letters> rt = root;
		  BSTNode<Letters> temp = new BSTNode<Letters>(key);
		  if (nodecount == 0)
			  root = temp;
		  else {
			  while (rt != temp){
				  // Left contains key
				  if (rt.left() != null && rt.left().value().compareLetters(key))
					  rt = rt.left();
				  // Right contains key
				  else if (rt.right() != null && rt.right().value().compareLetters(key))
					  rt = rt.right();
				  // Empty left
				  else if (rt.left() == null)
					  rt.setLeft(temp);
				  // This will only happen when we put in the very last element of a branch
				  else
					  rt.setRight(temp);

			  }
		  }
		  nodecount++;
	  }
	  
	  // Return the number of records in the dictionary
	  public int size() { return nodecount; }
	  
	  public void print() {
		  if (root == null)
			  return;
		  printHelper(root);
	  }
	  public void printHelper(BSTNode<Letters> node) {
		  if (node.isLeaf()) {
			  char letter = node.value().getLetter().charAt(0);
			  System.out.print(letter + " ");
			  System.out.print(this.find_el(letter) + "\n");
		  }
		  if (node.left() != null)
			  printHelper(node.left());
		  if (node.right() != null)
			  printHelper(node.right());
	  }
}
