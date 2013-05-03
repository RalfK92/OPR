package at.fhhbg.mc.exercise1;

public class DLNode {
	/**
	 * Holds the actual data. Must equal Integer.MIN_VALUE if node contains a
	 * list
	 */
	private int val;
	/** Reference to the next element in the list, or null if it is the last */
	private DLNode next;
	/**
	 * Reference to the previous element in the list, or null if it is the first
	 */
	private DLNode prev;
	/** Holds another list. Must be null if val != Integer.MIN_VALUE */
	private DoubleLinkedList list;

	/**
	 * Cunstructor for an empty list.
	 */
	public DLNode() {
		val = Integer.MIN_VALUE;
		list = null;
		next = null;
		prev = null;
	}

	/**
	 * Constructor with value.
	 * 
	 * @param val
	 *            the value which should be set.
	 */
	public DLNode(int val) {

		this(val, null, null, null);
	}

	/**
	 * Constructor with a list.
	 * 
	 * @param list
	 *            creates a sublist.
	 */
	public DLNode(DoubleLinkedList list) {
		this(Integer.MIN_VALUE, null, null, list);

	}

	/**
	 * Constructor
	 * 
	 * @param val
	 *            the val to set
	 * @param next
	 *            the next pointer
	 * @param prev
	 *            the preview pointer
	 * @param list
	 *            the sublist
	 */
	public DLNode(int val, DLNode next, DLNode prev, DoubleLinkedList list) {

		this.val = val;
		this.next = next;
		this.prev = prev;
		this.list = list;
	}

	/**
	 * Method to return the value
	 * 
	 * @return the value
	 */
	public int getVal() {
		return val;
	}

	/**
	 * Method to set the value
	 * 
	 * @param val
	 *            the value
	 */
	public void setVal(int val) {
		this.val = val;
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

	/**
	 * Method to get the list.
	 * 
	 * @return the sublist.
	 */
	public DoubleLinkedList getList() {
		return list;
	}

	/**
	 * Method to set the list.
	 * 
	 * @param list
	 *            the list
	 */
	public void setList(DoubleLinkedList list) {
		this.list = list;
	}

	public boolean isInitialized() {
		return list != null || val != Integer.MIN_VALUE;
	}

}
