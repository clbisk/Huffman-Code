package homework5;

/**Cecilia Bisk
 *February 28, 2017
 *Homework 3 for CSCI 204
 ***/

//Linked list implementation with two additional methods
class FreeList<E> implements List<E> {
  private Link<E> head;      // Pointer to list header
  private Link<E> tail;      // Pointer to last element
  private Link<E> curr;      // Access to current element
  private int listSize;      // Size of list

  // Constructors
  FreeList(int size) { this(); }     // Constructor -- Ignore size
  FreeList() { clear(); }

  // Remove all elements
  public void clear() {
    curr = tail = new Link<E>(null); // Create trailer
    head = new Link<E>(tail);        // Create header
    listSize = 0;
  }
  
  // Insert "it" at current position
  public boolean insert(E it) {
    curr.setNext(new Link<E>(curr.element(), curr.next()));
    curr.setElement(it);
    if (tail == curr) tail = curr.next();  // New tail
    listSize++;
    return true;
  }
  
  // Append "it" to list
  public boolean append(E it) {
    tail.setNext(new Link<E>(null));
    tail.setElement(it);
    tail = tail.next();
    listSize++;
    return true;
  }

  // Remove and return current element
  public E remove () {
    if (curr == tail) return null;          // Nothing to remove
    E it = curr.element();                  // Remember value
    curr.setElement(curr.next().element()); // Pull forward the next element
    if (curr.next() == tail) tail = curr;   // Removed last, move tail
    curr.setNext(curr.next().next());       // Point around unneeded link
    listSize--;                             // Decrement element count
    return it;                              // Return value
  }

  public void moveToStart() { curr = head.next(); } // Set curr at list start
  public void moveToEnd() { curr = tail; }     // Set curr at list end

  // Move curr one step left; no change if now at front
  public void prev() {
    if (head.next() == curr) return; // No previous element
    Link<E> temp = head;
    // March down list until we find the previous element
    while (temp.next() != curr) temp = temp.next();
    curr = temp;
  }

  // Move curr one step right; no change if now at end
  public void next() { if (curr != tail) curr = curr.next(); }

  public int length() { return listSize; } // Return list length


  // Return the position of the current element
  public int currPos() {
    Link<E> temp = head.next();
    int i;
    for (i=0; curr != temp; i++)
      temp = temp.next();
    return i;
  }
  
  // Move down list to "pos" position
  public boolean moveToPos(int pos) {
    if ((pos < 0) || (pos > listSize)) return false;
    curr = head.next();
    for(int i=0; i<pos; i++) curr = curr.next();
    return true;
  }

  // Return true if current position is at end of the list
  public boolean isAtEnd() { return curr == tail; }

  // Return current element value. Note that null gets returned if curr is at the tail
  public E getValue() {
    return curr.element();
  }
  
  //find an element in the list
  public Object find(E it) {
	  Link<E> temp = head.next();
	  if (listSize == 0) {
		  return ("the list is empty");
	  }
	  for (Integer i = 0; i < listSize; i++) {
		  if (temp.element() == it) {
			  return (it + " was found at position [" + i + "]");
		  }
		  temp = temp.next();
	  }
	  return (it + " was not found");
  }
  
  //find element recursively
  public Object find_rec(E it) {
	  //if the list is empty, return this information
	  if (listSize == 0)
		  return ("the list is empty");
	  //otherwise, search the list starting with the first node with a value
	  return find_rec(it, head.next(), 0);
  }
  private Object find_rec(E it, Link<E> temp, int pos) {
	  //if you've found the element, return its position
	  if (temp.element() == it)
		  return (it + " was found at position [" + pos + "]");
	  //if this is the end, the element could not be found
	  if (temp.next() == null)
		  return (it + " was not found");
	  //otherwise, recurse
	  return find_rec(it, temp.next(), pos + 1);
  }
  
  public void reverse() {
	  //if there is nothing to be switched
	  if (listSize == 0 || listSize == 1) {
		  //don't do anything
		  return;
	  }
	  
	  //reference links keeping track of elements being switched
	  Link<E> front = head.next();
	  Link<E> back = front.next();
	  //point the first element to the head
	  front.setNext(head);
	  //reference link keeping the rest of the list
	  Link<E> list;
	  
	  //while we can keep switching
	  while (back.next() != null) {
		  //set list position
		  list = back.next();
		  
		  //point the second element to the first
		  back.setNext(front);
		  
		  //shift the pointers
		  front = back;
		  back = list;
	  }
	  //after, put the head and tail in order by switching them
	  head.setNext(null);
	  tail = head;
	  back.setNext(front);
	  head = back;
	  
  }
}