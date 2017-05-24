package homework5;

//Binary Search Tree implementation
class BST<E extends Comparable<E>> {
	private BSTNode<E> root; // Root of the BST
	private int nodecount; // Number of nodes in the BST
	
	// constructor
	BST() { root = null; nodecount = 0; }
	
	// Reinitialize tree
	public void clear() { root = null; nodecount = 0; }
	
	// Insert a record into the tree.
	// Records can be anything, but they must be Comparable
	// e: The record to insert.
	public void insert(E e) {
	 root = inserthelp(root, e);
	 nodecount++;
	}
	
	// Insert iteratively
	public BSTNode<E> insert_el(E key) {
		nodecount++;
		if (root == null)
			return root = new BSTNode<E>(key);
		BSTNode<E> rootman = root;
		//BSTNode<E> parent = new BSTNode<E>();
		while (rootman != null) {
			//parent = rootman;
			if (rootman.value().compareTo(key) >= 0) {
				
			}
		}
		
		return root;
		//TODO: finish from slides
	}
	
	public BSTNode<E> remove_el(E key) {
		return root = new BSTNode<E>(key);
		//TODO: EC
	}

	// Remove a record from the tree
	// key: The key value of record to remove
	// Returns the record removed, null if there is none.
	public BSTNode<E> remove(E key) {
		BSTNode<E> temp = findhelp(root, key); // First find it
		 if (temp != null) {
		   root = removehelp(root, key); // Now remove it
		   nodecount--;
		 }
		 return temp;
	}

	// Return the record with key value k, null if none exists
	// key: The key value to find
	public BSTNode<E> find(E key) { return findhelp(root, key); }
	
	// Return the number of records in the dictionary
	public int size() { return nodecount; }
	
	private BSTNode<E> inserthelp(BSTNode<E> root2, E e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private BSTNode<E> removehelp(BSTNode<E> root2, E key) {
		// TODO Auto-generated method stub
		return null;
	}

	private BSTNode<E> findhelp(BSTNode<E> root2, E key) {
		// TODO Auto-generated method stub
		return null;
	}
}