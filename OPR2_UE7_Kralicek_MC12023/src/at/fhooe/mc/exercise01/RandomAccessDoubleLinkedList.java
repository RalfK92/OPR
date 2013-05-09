/**
 * 
 */
package at.fhooe.mc.exercise01;

/**
 * @author ralfkralicek
 * 
 */
public class RandomAccessDoubleLinkedList extends DoubleLinkedList {
	/** Initializes an empty list. */
	public RandomAccessDoubleLinkedList() {
		super();
	}

	/**
	 * Copy constructor which initializes the list with another list. This
	 * constructor must COPY all elements of the other list.
	 * 
	 * @param other
	 *            the RandomAccessDoubleLinkedList to construct
	 */
	public RandomAccessDoubleLinkedList(RandomAccessDoubleLinkedList other) {
		super(other);
	}

	/**
	 * Inserts a new element with value val at the given index. If the index is
	 * larger than the current size, the list is padded with uninitialized
	 * DLNodes.
	 * 
	 * @param index
	 *            at this point you want to insert.
	 * @param val
	 *            the number you want to insert.
	 * 
	 * @throws InvalidAccessException
	 *             if the index is smaller than 0
	 */
	public void insertAt(int index, Comparable val)
			throws InvalidAccessException {
		if (index - 1 < 0) {
			throw new InvalidAccessException("Index < 0");
		}
		if (this.head == null) {
			DLNode n = new DLNode();
			this.head = n;
			this.tail = n;

		}

		if (this.countElements() - 1 > index - 1) {
			if (isNodeInitialized(index - 1) == true) {
				DLNode newNode = new DLNode(val);
				DLNode current = runToIndex(index - 2);

				DLNode next = current.getNext();

				newNode.setPrev(current);
				newNode.setNext(next);
				current.setNext(newNode);
				next.setPrev(newNode);

			} else {
				DLNode current = runToIndex(index - 1);

				current.setVal(val);
			}
		} else { // countElement< index
			DLNode current = this.tail;

			for (int i = this.countElements() - 1; i < index - 1; i++) {
				DLNode newNode = new DLNode();
				newNode.setPrev(current);
				current.setNext(newNode);

				current = current.getNext();
			}
			current.setVal(val);
			tail = current;

		}

	}

	/**
	 * Counts the elements in the list.
	 * 
	 * @return the amount of elements in the list
	 */
	protected int countElements() {
		if (this.head == null) {
			return 0;
		}

		int counter = 0;
		DLNode current = this.head;
		while (current != null) {
			counter++;
			current = current.getNext();
		}

		return counter;
	}

	/**
	 * This method returns you the node at the given index
	 * 
	 * @param index
	 *            the index you want to have the node
	 * @return the node at the given index
	 */
	private DLNode runToIndex(int index) {
		DLNode current = this.head;

		for (int i = 1; i <= index; i++) {
			current = current.getNext();
		}
		return current;
	}

	/**
	 * This method returns true if the node at the given index is initialized
	 * false if not.
	 * 
	 * @param index
	 *            the given index for the node
	 * @return true if the node is initialized false if not.
	 */
	private boolean isNodeInitialized(int index) {
		DLNode current = runToIndex(index);

		return current.isInitialized();

	}

	/**
	 * Returns true if an element with the given value exists, false otherwise.
	 * However, true is returned upon the first occurrence of val.
	 * 
	 * @param val
	 *            the value you are looking for.
	 * @return true if the element exists false if not.
	 */
	public boolean contains(Comparable val) {
		DLNode current = head;
		if (this.head == null) {
			return false;
		}

		while (current != null) {
			if (current.getVal() == val) {
				return true;
			}

			current = current.getNext();
		}
		return false;
	}

	/**
	 * Removes the element at the given index. False is returned if index >
	 * list's size.
	 * 
	 * @param index
	 *            element at the index will be removed.
	 * @return true if the element was removed
	 * @throws InvalidAccessException
	 *             if the list is null or the index is smaller or bigger than
	 *             the list
	 */
	public boolean removeAt(int index) throws InvalidAccessException {

		DLNode current = new DLNode();
		DLNode next = current.getNext();
		DLNode prev = current.getPrev();

		if (this == null) {
			throw new InvalidAccessException("Empty List!");
		}

		if (index - 1 < 0) {
			throw new InvalidAccessException("Index < 0");
		}
		if (this.countElements() < index) {
			throw new InvalidAccessException("Index > List!");
		}
		try {
			if (this.elementAt(index) == null) {
				return false;
			}
		} catch (ValueException e) {
			return false;
		}
		if (head == tail) {
			head = null;
			tail = null;
			return true;
		}

		else if (index - 1 == 0) {
			current = head;
			next = current.getNext();
			prev = current.getPrev();
			head = next;

			current.setNext(null);
			next.setPrev(null);
			return true;

		} else if (index - 1 == this.countElements() - 1) {
			current = tail;

			next = current.getNext();

			prev = current.getPrev();
			
			while (prev.getVal() == null) {
				if (head == prev) {
					head = null;
					tail = head;
					return true;
				}
				prev = prev.getPrev();
			}
			
			prev.setNext(null);
			current.setPrev(null);
			tail = prev;
			return true;

		} else {

			current = runToIndex(index - 1);
			next = current.getNext();
			prev = current.getPrev();

			prev.setNext(next);
			next.setPrev(prev);
			return true;
		}

	}

	/**
	 * Removes all elements with the given value. False if returned if val was
	 * not found.
	 * 
	 * @param val
	 *            all elements which are containing val will be removed.
	 * @return true if all elements are removed and false if not.
	 * @throws InvalidAccessException
	 */
	public boolean removeAll(Comparable val) {
		if (!this.contains(val)) {
			return false;
		}

		DLNode current = this.head;
		int i = 1;
		while (current != null) {
			if (current.getVal() == val) {
				try {
					this.removeAt(i);
				} catch (InvalidAccessException e) {

				}
			}
			current = current.getNext();

			i++;
		}
		return true;
	}

	/**
	 * Returns the integer value at the given index. If index > list's size, a
	 * ValueException is thrown.
	 * 
	 * @param index
	 *            the position in the list you want to know the element
	 * @return the value saved in the element
	 * @throws ValueException
	 *             if the list is null or the node at the index is not
	 *             initialized
	 */
	public Comparable elementAt(int index) throws ValueException {

		if (index - 1 < 0 || index > this.countElements()) {
			throw new ValueException("Index is out of range of the list", index);

		}

		DLNode current = runToIndex(index - 1);
		if (this == null) {
			throw new ValueException("Node is not initialiced", index);

		}

		return current.getVal();
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
