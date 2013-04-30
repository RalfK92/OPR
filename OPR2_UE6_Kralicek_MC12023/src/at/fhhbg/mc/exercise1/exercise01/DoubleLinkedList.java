package at.fhhbg.mc.exercise1.exercise01;

public class DoubleLinkedList {
	protected DLNode head, tail;

	/**
	 * Constructor initializes list with a standard size.
	 */
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * 
	 * Copy constructor initializes list with another list. This constructor
	 * must COPY all elements of the other list. The elements of the other list
	 * must NOT be changed!
	 * 
	 * 
	 * @param other
	 *            the other list.
	 */
	public DoubleLinkedList(DoubleLinkedList other) {
		DoubleLinkedList cloned = new DoubleLinkedList();

		cloned = other.clone();

		this.head = cloned.head;
		this.tail = cloned.tail;
	}

	/**
	 * Deinitializes the object and resets the list.
	 */
	protected void finalize() {
		this.clear();
	}

	/**
	 * Adds all elements from another list at the front of this linked list.
	 * 
	 * @param other
	 *            the other list
	 * @throws InvalidAccessException
	 *             if the list other is null
	 */
	public boolean pushFront(DoubleLinkedList other)
			throws InvalidAccessException {
		int counter = -1;
		if (other == null) {
			throw new InvalidAccessException("Empty List");
		}
		while (counter <= other.elements()) {
			this.pushFront(other.popBack());
			counter++;
		}
		return true;
	}

	/**
	 * Adds all elements from another list at the back of this linked list.
	 * 
	 * @param other
	 *            the other list
	 * @throws InvalidAccessException
	 *             if the other list is null
	 */
	public boolean pushBack(DoubleLinkedList other)
			throws InvalidAccessException {
		int counter = -1;
		if (other == null) {
			throw new InvalidAccessException("Empty list.");
		}
		while (counter <= other.elements()) {
			this.pushBack(other.popFront());
			counter++;
		}
		return true;
	}

	/**
	 * Clones this DoubleLinkedList instance and returns an exact COPY.
	 */
	public DoubleLinkedList clone() {
		DoubleLinkedList clonedList = new DoubleLinkedList();
		DLNode current = head;

		while (current != null) {
			if (current.getVal() == Integer.MIN_VALUE
					&& current.getList() != null) {

				clonedList.pushBackRecursive(current.getList().clone());
			} else {
				clonedList.pushBack(current.getVal());
			}
			current = current.getNext();

		}

		return clonedList;
	}

	/**
	 * Returns true if the other list is equal to this one, false otherwise. The
	 * contents of the two lists must not be changed!
	 * 
	 * @param other
	 *            the other list to compare
	 * @return true if the lists are equal in length and the value they are
	 *         containing
	 */
	public boolean equals(DoubleLinkedList other) {

		DoubleLinkedList clone1 = this.clone();
		DoubleLinkedList clone2 = other.clone();

		if (clone1.elements() != clone2.elements()) {
			return false;
		} else {
			while (clone1.head != null) {

				try {
					if (clone1.popFront() != clone2.popFront()) {
						return false;
					}
				} catch (InvalidAccessException e) {

					return false;
				}

			}
			return true;

		}

	}

	/**
	 * Returns a string representation of the list. See the exercise
	 * specification below for the exact string format!
	 */
	public String toString() {
		StringBuilder printOut = new StringBuilder();
		DLNode current = new DLNode();

		current = head;
		while (current != null) {
			if (current.getVal() == Integer.MIN_VALUE) {
				printOut.append("( ");
				printOut.append(current.getList().toString().trim());
				printOut.append(" ) ");
			} else {
				printOut.append(current.getVal());
				printOut.append(" | ");

			}
			current = current.getNext();
		}

		return printOut.toString();
	}

	/**
	 * Returns true if the element val exists in the list, false otherwise.
	 * 
	 * @param val
	 *            the element your looking for
	 * @return true if the element is in the list.
	 */
	public boolean search(int val) {
		DLNode current = head;

		if (this.head == null) {
			return false;
		}

		while (current != null) {

			if (val == current.getVal()) {
				return true;
			} else if (current.getVal() == Integer.MIN_VALUE) {
				if (current.getList().search(val) == true) {
					return true;
				}

			}
			current = current.getNext();
		}
		return false;

	}

	/**
	 * The method clear reset all pointer in the list and so the Garbage
	 * Collector will delete it
	 */
	public boolean clear() {
		if (head == null) {
			return false;
		}
		DLNode current = new DLNode();
		DLNode currentNext = new DLNode();

		current = head;

		while (currentNext.getNext() != null) {
			currentNext = current.getNext();

			current.setNext(null);
			current.setPrev(null);

			current = currentNext;

		}

		head = null;
		tail = null;

		return true;

	}

	/**
	 * To push an new Node in front of the list.
	 * 
	 * @param val
	 *            the value in the list.
	 */
	public void pushFront(int val) {
		DLNode node = new DLNode(val);
		node.setVal(val);

		if (head == null) {
			head = node;
			tail = node;

		} else {
			node.setNext(head);
			head.setPrev(node);
			head = node;

		}

	}

	/**
	 * This method push a new Node to the end of the list.
	 * 
	 * @param val
	 *            the value of the new Node.
	 */
	public void pushBack(int val) {
		DLNode node = new DLNode(val);
		if (head == null && tail == null) {
			pushFront(val);
		} else {

			node.setVal(val);
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;

		}
	}

	/**
	 * Method to get the first element of the list
	 * 
	 * @return the value of the first element.
	 */
	public int popFront() throws InvalidAccessException {
		if (this.head != null) {

			if (head.getVal() == Integer.MIN_VALUE) {
				int value = head.getList().popFront();
				if (head.getList().peekFront() == Integer.MIN_VALUE) {
					DLNode temp = head;
					head = head.getNext();
					temp.setNext(null);
					if (head != null) {
						head.setPrev(null);
					}
				}
				return value;
			} else {
				int val = head.getVal();

				DLNode temp = head;
				head = head.getNext();
				temp.setNext(null);
				if (head != null) {
					head.setPrev(null);
				}
				return val;
			}
		}
		throw new InvalidAccessException("Empty List");

	}

	/**
	 * Method to get the first element of the list without removing it.
	 * 
	 * @return the first element of the list.
	 */
	public int peekFront() throws InvalidAccessException {

		if (this.head != null) {

			DLNode current = head;

			while (current != null) {
				if (current.getVal() == Integer.MIN_VALUE) {
					current = current.getList().head;
				} else {

					return current.getVal();
				}
			}
		}
		throw new InvalidAccessException("Empty List!");

	}

	/**
	 * Method to get the last element of the list and removes it.
	 * 
	 * @return the last element of the list.
	 */
	public int popBack() throws InvalidAccessException {

		if (this.head != null) {

			DLNode current = tail;

			while (current != null) {
				if (current.getVal() == Integer.MIN_VALUE) {
					current = current.getList().tail;
				} else {
					int val = current.getVal();

					current = tail.getPrev();
					if (current != null) {
						current.setNext(null);

					}
					tail = current;

					return val;

				}
			}
		}
		throw new InvalidAccessException("Empty List!");

	}

	/**
	 * Method to get the last element of the list without removing it.
	 * 
	 * @return the last element of the list.
	 */
	public int peekBack() throws InvalidAccessException {
		if (this.head != null) {

			DLNode current = tail;

			while (current != null) {
				if (current.getVal() == Integer.MIN_VALUE) {
					current = current.getList().tail;
				} else {

					return current.getVal();
				}
			}
		}
		throw new InvalidAccessException("Empty List!");
	}

	/**
	 * Method to count the elements in the list.
	 * 
	 * @return the amount of elements in the list.
	 */
	public int elements() {
		int counter = 0;
		DLNode current = head;

		while (current != null) {

			if (current.getVal() == Integer.MIN_VALUE
					&& current.getList() != null) {
				counter -= 1;// The Node which contains the list is not to
								// count.
				counter += current.getList().elements();

			}
			counter++;
			current = current.getNext();
		}

		return counter;
	}

	/**
	 * Method to reverse the list.
	 */
	public void reverse() {
		DLNode current = head;
		DLNode currentPrev = null;
		DLNode currentNext = null;

		while (current != null) {
			currentPrev = current.getPrev();
			currentNext = current.getNext();

			current.setNext(currentPrev);
			current.setPrev(currentNext);
			current = currentNext;
		}
		current = tail;
		tail = head;
		head = current;

	}

	/**
	 * Method to push a sublist in an new Node to the front of the list.
	 * 
	 * @param list
	 *            the method to push into the first node.
	 */
	public void pushFrontRecursive(DoubleLinkedList list) {

		if (list != null) {
			DLNode nodeList = new DLNode(list);
			if (head == null) {
				head = nodeList;
				tail = nodeList;
			} else

				nodeList.setNext(this.head);

			this.head.setPrev(nodeList);
			this.head = nodeList;
		}
	}

	/**
	 * Method to push a sublist in a new Node to the end of the list.
	 * 
	 * @param list
	 *            the list to push in the node
	 */
	public void pushBackRecursive(DoubleLinkedList list) {
		if (list != null) {
			DLNode nodeList = new DLNode(list);
			if (head == null && tail == null) {
				pushFrontRecursive(list);
			} else {
				nodeList.setPrev(tail);

				tail.setNext(nodeList);
				tail = nodeList;
			}
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();
		l1.pushBack(1);
		l1.pushBack(2);
		l1.pushBack(3);

		l.pushBack(1);
		l.pushBack(2);
		l.pushBack(3);
		l.pushBack(4);
		l.pushBack(5);
		l.pushBackRecursive(l1);

		System.out.println(l.toString());
		// l.reverse();

		// System.out.print(l.toString());

	}

}
