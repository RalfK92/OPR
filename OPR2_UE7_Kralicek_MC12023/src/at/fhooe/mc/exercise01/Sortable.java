package at.fhooe.mc.exercise01;

/**
 * @author ralfkralicek
 * 
 */

// Die toString() Methode der DoubleLinkedList wird verwendet.
public interface Sortable {
	/**
	 * insert one element into the Sortable and do so either in ascending //or
	 * descending fashion
	 * 
	 * @param _value
	 *            the value you want to insert
	 * @param _ascending
	 *            if _ascending is true the value is inserted ascending. If
	 *            _ascending is false the value is decending inserted.
	 * @throws ValueException
	 *             if the value is not comparable to the head value
	 */
	public void insertSorted(Comparable _value, boolean _ascending)
			throws ValueException;

	// create a new Sortable which is guaranteed to be sorted ascending
	public Sortable sortAscending();

	// create a new Sortable which is guaranteed to be sorted descending
	public Sortable sortDescending();
}
