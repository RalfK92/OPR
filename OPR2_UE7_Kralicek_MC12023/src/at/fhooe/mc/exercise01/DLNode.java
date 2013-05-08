package at.fhooe.mc.exercise01;

public class DLNode {
	/**
	 * Holds the actual data. Must equal Integer.MIN_VALUE if node contains a
	 * list
	 */
	private Comparable value;
	/** Reference to the next element in the list, or null if it is the last */
	private DLNode next;
	/**
	 * Reference to the previous element in the list, or null if it is the first
	 */
	private DLNode prev;

	/**
	 * Constructor for an empty list.
	 * 
	 */
	public DLNode() {
		value = null;

		next = null;
		prev = null;
	}

	/**
	 * Constructor with value.
	 * 
	 * @param val
	 *            the value which should be set.
	 */
	public DLNode(Comparable value) {

		this(value, null, null);
	}

	/**
	 * Constructor
	 * 
	 * @param value
	 *            the value to set
	 * @param next
	 *            the next pointer
	 * @param prev
	 *            the preview pointer
	 * @param list
	 *            the sublist
	 */
	public DLNode(Comparable value, DLNode next, DLNode prev) {

		this.value = value;
		this.next = next;
		this.prev = prev;

	}

	/**
	 * Method to return the value
	 * 
	 * @return the value
	 */
	public Comparable getVal() {
		return value;
	}

	/**
	 * Method to set the value
	 * 
	 * @param val
	 *            the value
	 */
	public void setVal(Comparable value) {
		this.value = value;
	}

	/**
	 * Method to get the next list element
	 * 
	 * @return the next list element
	 */
	public DLNode getNext() {
		return next;
	}

	/**
	 * Method to set the next list element
	 * 
	 * @param next
	 *            the next element
	 */
	public void setNext(DLNode next) {
		this.next = next;
	}

	/**
	 * Method to get the preview list element
	 * 
	 * @return the preview list element
	 */
	public DLNode getPrev() {
		return prev;
	}

	/**
	 * Method to set the preview list element
	 * 
	 * @param prev
	 *            the preview list element
	 */
	public void setPrev(DLNode prev) {
		this.prev = prev;
	}

	public boolean isInitialized() {
		return value != null;
	}

}
