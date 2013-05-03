/**
 * 
 */
package at.fhhbg.mc.exercise2;

import java.lang.reflect.Array;

import at.fhhbg.mc.exercise1.ValueException;

/**
 * @author ralfkralicek
 * 
 */

public class BinarySearchTree<E extends Comparable<E>> {
	int counter = 0; // to count how many elements are in the tree.

	/** Inner class for the binary tree node. **/
	protected class BinaryTreeNode<T extends Comparable<T>> {
		// the left sub node (smaller as the parent)
		private BinaryTreeNode<T> left;
		// the right sub node (bigger than the parent)
		private BinaryTreeNode<T> right;
		// the date saved in the node
		private T data;

		/**
		 * Constructor for the node.
		 * 
		 * @param elem
		 *            the element to put in the node
		 */
		public BinaryTreeNode(T elem) {
			data = elem;
			left = null;
			right = null;
		}

		/**
		 * Setting method to set the left sub node.
		 * 
		 * @param l
		 *            the node to set left.
		 */
		public void setLeft(BinaryTreeNode<T> l) {
			left = l;
		}

		/**
		 * Getting method to get the left sub node.
		 * 
		 * @return the left sub node.
		 */
		public BinaryTreeNode<T> getLeft() {
			return left;
		}

		/**
		 * Setting method to set the right node.
		 * 
		 * @param r
		 *            the right node.
		 */
		public void setRight(BinaryTreeNode<T> r) {
			right = r;
		}

		/**
		 * Pointer to the right sub node.
		 * 
		 * @return the pointer to the right.
		 */
		public BinaryTreeNode<T> getRight() {
			return right;
		}

		/**
		 * Setting method for the data.
		 * 
		 * @param d
		 *            the value to put in the node.
		 */
		public void setData(T d) {
			this.data = d;
		}

		/**
		 * Getting method for the data.
		 * 
		 * @return the value out of the node.
		 */
		public T getData() {
			return data;
		}
	}

	/** Root node of the tree. **/
	protected BinaryTreeNode<E> root;
	/** Number of elements stored in the tree. */
	protected int size;

	/**
	 * Inserts the given element in the tree. Duplicate elements are not
	 * allowed.
	 * 
	 * @param elem
	 *            the given element
	 * @return true if insertion was successful, false otherwise.
	 * @throws ValueException
	 *             if the element is not comparable to the root node
	 */

	public boolean insert(E elem) throws ValueException, NullPointerException {

		BinaryTreeNode<E> current = root; // starting node is root

		return insertElem(current, elem);

	}

	/**
	 * Private insert method.
	 * 
	 * @param current
	 *            the actual node. At the begin it is ever root.
	 * @param elem
	 *            element to insert
	 * @return true if everything goes right and false when the element exists.
	 * @throws ValueException
	 *             if the element is not comparable to the root node
	 */
	private boolean insertElem(BinaryTreeNode<E> current, E elem)
			throws ValueException {
		if (elem == null) {
			throw new NullPointerException("Given element is null.");
		}

		if (current == null) {
			BinaryTreeNode<E> newNode = new BinaryTreeNode<E>(elem);
			root = newNode;
			counter++; // counter for the elements
			return true;
		} else if (!isComparable(current.data, elem)) {
			throw new ValueException("Element not compareable to root");

		} else if (current.getData().compareTo(elem) >= 0) { // left side and
																// equal
																// getIncome
			if (current.getLeft() == null) {
				BinaryTreeNode<E> newNode = new BinaryTreeNode<E>(elem);
				current.setLeft(newNode);
				counter++;
				return true;
			} else {
				return insertElem(current.getLeft(), elem);
			}
		} else if (current.getData().compareTo(elem) < 0) { // right side
			if (current.getRight() == null) {
				BinaryTreeNode<E> newNode = new BinaryTreeNode<E>(elem);
				current.setRight(newNode);
				counter++;
				return true;

			} else {
				return insertElem(current.getRight(), elem);
			}
		} else {
			return false;
		}
	}

	/**
	 * Searches for the (first) element with the given key. Returns true if it
	 * could be found, false otherwise.
	 * 
	 * @param key
	 *            element we are looking for
	 * @return true if the element was found
	 * 
	 * @throws NullPointerException
	 *             if the key is null
	 * @throws ValueException
	 *             if the key is not comparable to the root node
	 */
	public E find(E key) throws NullPointerException, ValueException {
		BinaryTreeNode<E> current = root;
		if (key == null) {
			throw new NullPointerException();
		}

		return findKey(current, key);
	}

	/**
	 * Private searching method where current is the actual node we proof.
	 * 
	 * @param current
	 *            the actual node we are proofing
	 * @param key
	 *            the value we are looking for
	 * @return true if the element was found and false if the element was not
	 *         found.
	 * @throws ValueException
	 *             if the key is not comparable to the node
	 */
	private E findKey(BinaryTreeNode<E> current, E key) throws ValueException {
		if (root == null) {// empty tree

			return null;
		}
		if (!isComparable(current.data, key)) {
			System.out.print(current.toString());
			System.out.print(key.toString());

			throw new ValueException("Key is not comparable!");
		}

		if (current.getData().compareTo(key) == 0) {// element is found
			return current.data;

		} else if (current.getData().compareTo(key) > 0) { // left side
			if (current.getLeft() == null) {
				return null;

			} else {
				return findKey(current.getLeft(), key);
			}

		} else if (current.getData().compareTo(key) < 0) { // right side
			if (current.getRight() == null) {

				return null;

			} else {
				return findKey(current.getRight(), key);
			}
		}
		return null;

	}

	/**
	 * Removes the (first) element with the given key. Returns true if the key
	 * could be found, false otherwise.
	 * 
	 * @param key
	 *            element to remove
	 * @return true if the element is deleted
	 * @throws ValueException
	 *             if the key is not comparable to the root node
	 */
	public boolean remove(E key) throws ValueException, NullPointerException {
		BinaryTreeNode<E> current = root;
		if (current == null) { // empty tree
			return false;
		}
		if (key == null) {
			throw new NullPointerException("Key == Null!");
		}

		return removeKey(current, key);
	}

	/**
	 * The private remove method.
	 * 
	 * @param current
	 *            actual node.
	 * @param key
	 *            node to delete
	 * @return true if everything goes right false if something went wrong.
	 * @throws ValueException
	 *             if the key is not comparable to the root node
	 */
	private boolean removeKey(BinaryTreeNode<E> current, E key)
			throws ValueException {
		BinaryTreeNode<E> nextRight = null; // the next node at the right side
		BinaryTreeNode<E> nextLeft = null;// the next node at the left side
		BinaryTreeNode<E> bringBack = null;// helping node to delete the node

		// correctly
		if (!isComparable(root.data, key)) {
			throw new ValueException("key is not comparable");
		}
		if (root.getData().compareTo(key) == 0) {
			current = root;
			if (current.getLeft() != null) {
				bringBack = current.getRight();

				root = current.getLeft();
				if (root.getRight() == null) {
					root.setRight(bringBack);

				} else {
					current = root;
					while (current.getRight() != null) {
						current = current.getRight();
					}
					current.setRight(bringBack);
				}
			} else {
				if (current.getRight() != null) {
					root = current.getRight();
				} else {
					root = null;
				}
			}

			return true;
		}
		if (!isComparable(current.data, key)) {
			throw new ValueException("key is not comparable");
		}

		if (current.getData().compareTo(key) > 0) { // left side
			if (current.getLeft() == null) {
				return false;
			}
			if (current.getLeft().getData() == key) {
				if (current.getLeft().getRight() == null
						&& current.getLeft().getLeft() == null) {
					current.setLeft(null);
					counter--;
					return true;

				} else {

					bringBack = current.getLeft().getRight();
					current.setLeft(current.getLeft().getLeft());
					nextRight = current.getLeft();
					if (nextRight == null) {
						current.setRight(bringBack);
					} else {
						while (nextRight.getRight() != null) {
							nextRight = nextRight.getRight();
						}

						nextRight.setRight(bringBack);
					}
					counter--; // counter for the elements
					return true;
				}
			}
		} else if (current.getData().compareTo(key) < 0) { // right side
			if (current.getRight() == null) {
				return false;
			}
			if (current.getRight().getData() == key) {
				if (current.getRight().getLeft() == null
						&& current.getRight().getRight() == null) {
					current.setRight(null);
					counter--;
					return true;
				} else {

					bringBack = current.getRight().getLeft();
					current.setRight(current.getRight().getRight());
					nextLeft = current.getRight();
					if (nextLeft == null) {
						current.setRight(bringBack);
					} else {
						while (nextLeft.getLeft() != null) {
							nextLeft = nextLeft.getLeft();
						}
						nextLeft.setLeft(bringBack);
					}
					counter--;
					return true;
				}
			}

		}

		return false;
	}

	/**
	 * Returns the number of elements stored in the tree.
	 * 
	 * @return the amount of elements.
	 */
	public int size() {
		if (root == null) {// empty tree
			return Integer.MIN_VALUE;
		}
		return counter;
	}

	/**
	 * Returns the elements of the tree in ascending (inorder traversal) or
	 * descending (reverse inorder traversal) order.
	 * 
	 * @param ascending
	 *            true the array is ascending sorted false is descending.
	 * @return the sorted array
	 */
	@SuppressWarnings("unchecked")
	public E[] toArray(Class<E> clasz, boolean ascending) {

		if (root == null) { // empty tree the method returns Integer.MIN_VALUE
			throw new NullPointerException("Root == null");
		}

		return toArray(root, (E[]) Array.newInstance(clasz, this.size()), 0,
				ascending);
	}

	/**
	 * Private toArray method.
	 * 
	 * @param current
	 *            actual node
	 * @param treeArray
	 *            the array the method writes in
	 * @param i
	 *            pointer to write in the array
	 * @param ascending
	 *            true for ascending false for descending
	 * @return the array
	 */
	private E[] toArray(BinaryTreeNode<E> current, E[] treeArray, int i,
			boolean ascending) {

		if (current != null) {
			toArray(current.getLeft(), treeArray, i, ascending);
			if (ascending == true) { // to sort ascending
				while (treeArray[i] != null) {

					i++;
				}
			}

			if (ascending == false) { // to sort decending
				i = treeArray.length - 1;
				while (treeArray[i] != null) {
					i--;
				}
			}

			treeArray[i] = current.getData(); // write in the array
			toArray(current.getRight(), treeArray, i, ascending);

		}

		return treeArray;
	}

	/**
	 * Returns largest number stored in the tree.
	 * 
	 * @return the largest stored number.
	 */
	public E max() {
		if (root == null) {
			throw new NullPointerException("Root == null");
		}
		BinaryTreeNode<E> current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current.getData();
	}

	/**
	 * Returns smallest number stored in the tree.
	 * 
	 * @return the smallest stored number
	 */
	public E min() {
		if (root == null) {
			throw new NullPointerException("Root == null");
		}
		BinaryTreeNode<E> current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current.getData();
	}

	/** Represents the tree in a human readable form. */
	public String toString() {

		StringBuffer printOut = new StringBuffer();
		if (root == null) { // if the tree is empty the method returns a String
							// "Empty Tree"

			printOut.append("Empty Tree");
			return printOut.toString();
		}

		appendString(printOut, root, 0);
		return printOut.toString();

	}

	/**
	 * Private toString method
	 * 
	 * @param printOut
	 *            StringBuffer to return
	 * @param current
	 *            actual node
	 * @param indent
	 *            is the offset
	 */
	private void appendString(StringBuffer printOut, BinaryTreeNode<E> current,
			int indent) {

		if (current == null)
			return;
		appendString(printOut, current.getRight(), indent + 2);
		for (int i = 0; i < indent; i++) {
			printOut.append(" ");
		}
		printOut.append(current.getData());
		printOut.append('\n');
		appendString(printOut, current.getLeft(), indent + 2);

	}

	public static boolean isComparable(Comparable _c1, Comparable _c2) {
		try {
			_c1.compareTo(_c2);
			return true;
		} catch (ClassCastException _e) {
			return false;
		}
	}

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { BinarySearchTree tree = new
	 * BinarySearchTree();
	 * 
	 * tree.insert(70); tree.insert(90); tree.insert(50); tree.insert(22);
	 * tree.insert(99); tree.insert(33); tree.insert(44); tree.insert(21);
	 * tree.insert(51); tree.insert(100); tree.insert(110);
	 * 
	 * tree.toArray(false);
	 * 
	 * System.out.print(tree.toString());
	 * 
	 * }
	 */

}
