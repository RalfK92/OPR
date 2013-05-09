package at.fhooe.mc.exercise01;

public class SortableList extends RandomAccessDoubleLinkedList implements
		Sortable {

	@Override
	public void insertSorted(Comparable _value, boolean _ascending) {
		DLNode current = this.head;

		if (head == null) {
			DLNode insertNode = new DLNode(_value);
			head = insertNode;
			tail = head;
		} else {
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
			sortedList.insertSorted(current.getVal(), true);
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
			sortedList.insertSorted(current.getVal(), false);
			current = current.getNext();
		}

		return sortedList;
	}

}
