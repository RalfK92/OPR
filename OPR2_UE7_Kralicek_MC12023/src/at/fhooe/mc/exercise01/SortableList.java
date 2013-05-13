package at.fhooe.mc.exercise01;

public class SortableList extends RandomAccessDoubleLinkedList implements
		Sortable {

	@Override
	public void insertSorted(Comparable _value, boolean _ascending)
			throws ValueException {
		DLNode current = this.head;

		if (head == null) {
			DLNode insertNode = new DLNode(_value);
			head = insertNode;
			tail = head;
		} else {
			if (!isComparable(head.getVal(), _value)) {
				throw new ValueException(
						"The value you want to insert is not the same Type as the head value.");
			}
			if (_ascending) {

				while (current != null
						&& current.getVal().compareTo(_value) < 0) {
					current = current.getNext();

				}

			} else {
				while (current != null
						&& current.getVal().compareTo(_value) > 0) {
					current = current.getNext();

				}
			}
			if (current == null) {
				this.pushBack(_value);
			} else {
				DLNode prev = current.getPrev();
				DLNode insertNode = new DLNode(_value);

				if (prev == null) {
					this.pushFront(_value);
				} else {
					prev.setNext(insertNode);
					insertNode.setPrev(prev);
					insertNode.setNext(current);
					current.setPrev(insertNode);
				}
			}
		}
	}

	@Override
	public Sortable sortAscending() {
		DoubleLinkedList clone = this.clone();
		DLNode current = clone.head;
		SortableList sortedList = new SortableList();

		while (current != null) {
			try {
				sortedList.insertSorted(current.getVal(), true);
			} catch (ValueException e) {

			}
			current = current.getNext();
		}

		return sortedList;
	}

	@Override
	public Sortable sortDescending() {

		DoubleLinkedList clone = this.clone();
		DLNode current = clone.head;
		SortableList sortedList = new SortableList();
		while (current != null) {
			try {
				sortedList.insertSorted(current.getVal(), false);
			} catch (ValueException e) {

			}
			current = current.getNext();
		}

		return sortedList;
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
}
