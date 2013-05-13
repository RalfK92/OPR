package at.fhooe.mc.exercise01;

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
	 * @throws ValueException
	 *             if the value of the head of the other list is not comparable
	 *             to the head node of this list.
	 */
	public boolean pushFront(DoubleLinkedList other)
			throws InvalidAccessException, ValueException {

		if (other == null) {
			throw new InvalidAccessException("Empty List");
		}
		if (this.head != null) {
			if (!isComparable(this.head.getVal(), other.head.getVal())) {
				throw new ValueException(
						"The head value of the head node of the other list is not comparable to the head node of the list you want to insert it.");
			}
		}
		DoubleLinkedList clonedList = other.clone();

		while (clonedList.elements() > 0) {
			this.pushFront(clonedList.popBack());

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
	 * @throws ValueException
	 *             if the value of the head of the other list is not comparable
	 *             to the head node of this list.
	 */
	public boolean pushBack(DoubleLinkedList other)
			throws InvalidAccessException, ValueException {
		int counter = -1;
		if (other == null) {
			throw new InvalidAccessException("Empty list.");
		}
		if (this.head != null) {
			if (!isComparable(this.head.getVal(), other.head.getVal())) {
				throw new ValueException(
						"The head value of the head node of the other list is not comparable to the head node of the list you want to insert it.");
			}
		}
		while (counter <= other.elements()) {
			try {
				this.pushBack(other.popFront());
			} catch (ValueException e) {

			}
			counter++;
		}
		return true;
	}

	/**
	 * Clones this DoubleLinkedList instance and returns an exact COPY.
	 */
	public DoubleLinkedList clone() {
		DoubleLinkedList clonedList = new DoubleLinkedList();
		DLNode current = new DLNode();

		current = head;
		do {
			try {
				clonedList.pushBack(current.getVal());
			} catch (ValueException e) {
			}
			current = current.getNext();
		} while (current != null);

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
		} else if (!isComparable(clone1.head.getVal(), clone2.head.getVal())) {

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
		int counter = 0;
		current = head;
		while (current != null) {
			printOut.append("[ value no." + counter + ": ");
			printOut.append(String.format("%5d", current.getVal()));
			printOut.append("] \n");

			current = current.getNext();
			counter++;
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
	public boolean search(Comparable val) {
		DLNode current = head;

		if (this.head == null) {
			return false;
		}

		while (current != null) {

			if (val == current.getVal()) {
				return true;

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
	 * @throws ValueException
	 *             if the val is not comparable to the head element
	 */
	public void pushFront(Comparable val) throws ValueException {
		DLNode node = new DLNode(val);
		node.setVal(val);

		if (head == null) {
			head = node;
			tail = node;

		} else {
			if (!isComparable(head.getVal(), val)) {
				throw new ValueException(
						"The value you want to insert is not comparable to the head value.");
			}
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
	 * @throws ValueException
	 *             if the val is not comparable to the head value
	 */
	public void pushBack(Comparable val) throws ValueException {
		DLNode node = new DLNode(val);
		if (head == null && tail == null) {
			pushFront(val);
		} else {
			if (!isComparable(head.getVal(), val)) {
				throw new ValueException(
						"The value is not comparable to the head value");
			}
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
	 * 
	 * @throws InvalidAccessException
	 *             if the list is null
	 */
	public Comparable popFront() throws InvalidAccessException {
		Comparable val = null;
		DLNode delete = null;
		if (this.head != null) {
			if (head.getNext() != null) {
				val = head.getVal();
				delete = head;
				head = head.getNext();
				delete.setNext(null);
				head.setPrev(null);
			} else {
				val = head.getVal();
				head = null;
				tail = null;
			}
			return val;
		}
		throw new InvalidAccessException("Empty List");

	}

	/**
	 * Method to get the first element of the list without removing it.
	 * 
	 * @return the first element of the list.
	 */
	public Comparable peekFront() throws InvalidAccessException {

		if (this.head != null) {

			return head.getVal();
		}
		throw new InvalidAccessException("Empty List!");

	}

	/**
	 * Method to get the last element of the list and removes it.
	 * 
	 * @return the last element of the list.
	 * 
	 * @throws InvalidAccessException
	 *             if the list is null
	 */
	public Comparable popBack() throws InvalidAccessException {
		Comparable val = null;
		DLNode delete = null;
		if (this.head != null) {

			if (tail.getPrev() != null) {
				val = tail.getVal();
				delete = tail;
				tail = tail.getPrev();
				delete.setPrev(null);
				tail.setNext(null);
			} else {
				val = tail.getVal();
				head = null;
				tail = null;
			}
			return val;
		} else {
			throw new InvalidAccessException("Empty List!");
		}

	}

	/**
	 * Method to get the last element of the list without removing it.
	 * 
	 * @return the last element of the list.
	 */
	public Comparable peekBack() throws InvalidAccessException {
		if (this.head != null) {

			return this.tail.getVal();
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
	 * This method returns true if two comparable are comparable false otherwise
	 * 
	 * @param _c1
	 *            the one comparable
	 * @param _c2
	 *            the other comparable
	 * @return true if the two comparable are comparable otherwise false
	 */
	public static boolean isComparable(Comparable _c1, Comparable _c2) {
		try {
			_c1.compareTo(_c2);
			return true;
		} catch (ClassCastException _e) {
			return false;
		}
	}

	public static void main(String[] args) {
		/*
		 * DoubleLinkedList l = new DoubleLinkedList(); DoubleLinkedList l1 =
		 * new DoubleLinkedList(); l1.pushBack(1); l1.pushBack(2);
		 * l1.pushBack(3);
		 * 
		 * l.pushBack(1); l.pushBack(2); l.pushBack(3); l.pushBack(4);
		 * l.pushBack(5);
		 * 
		 * System.out.println(l.toString()); // l.reverse();
		 * 
		 * // System.out.print(l.toString());
		 */
	}

}
