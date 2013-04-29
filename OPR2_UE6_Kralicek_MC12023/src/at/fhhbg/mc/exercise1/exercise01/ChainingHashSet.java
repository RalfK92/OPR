/**
 * 
 */
package at.fhhbg.mc.exercise1.exercise01;

/**
 * @author ralfkralicek
 * 
 */
/**
 * The class ChainingHashSet contains methods to work with it.
 * 
 */
public class ChainingHashSet {

	/**
	 * Array which stores overflow lists that are indexed by the hash code of
	 * their elements.
	 */
	private RandomAccessDoubleLinkedList[] array;

	/**
	 * Initializes an empty hashtable with the given number of overflow lists.
	 * If you enter 0 the array will be initialized with 10.
	 * 
	 * @param indexSize
	 *            how big you want your hashtable.
	 */
	public ChainingHashSet(int indexSize) {
		if (indexSize == 0) {
			indexSize = 10;
		}
		array = new RandomAccessDoubleLinkedList[indexSize];
	}

	/**
	 * Inserts a new element val into the hashtable (hashcode = val %
	 * array.length), if it did not exist in the table before. Returns true if a
	 * new element was inserted, false if it already existed.
	 * 
	 * @param val
	 *            the value you want to insert into the hashtable
	 * @return true if the element was inserted false if the element already
	 *         exists.
	 * @throws ValueException
	 */
	public boolean insert(int val) throws ValueException {
		int hashcode = val % array.length;
		if (this.array == null) {
			return false;
		}
		if (this.array[hashcode] == null) {
			RandomAccessDoubleLinkedList list = new RandomAccessDoubleLinkedList();
			array[hashcode] = list;
			array[hashcode].pushBack(val);
			return true;
		}

		if (array[hashcode].contains(val)) {
			throw new ValueException("Element already exists", val);
		} else {

			array[hashcode].pushBack(val);

			return true;
		}
	}

	/**
	 * Returns true if the given value is already stored in the hashtable, false
	 * otherwise.
	 * 
	 * @param val
	 *            the element you are looking for
	 * @return true if the element exists false if not
	 */
	public boolean contains(int val) {
		int hashcode = val % array.length;

		if (array[hashcode] == null) {
			return false;
		}
		if (array[hashcode].contains(val) == true) {
			return true;
		}
		return false;

	}

	/**
	 * Removes the given element from the hashtable if it exists. Returns true
	 * if the element was removed, false if no such element existed.
	 * 
	 * @param val
	 *            the element you want to remove
	 * @return true if the element was removed false if the element not exists.
	 */
	public boolean remove(int val) {
		if (this.array == null) {
			return false;
		}
		if (this.contains(val) == false) {
			return false;
		}
		int hashcode = val % array.length;

		array[hashcode].removeAll(val);

		return true;
	}

	/**
	 * Counts the amount of values, which are stored in the same overflow list
	 * 
	 * @param hashVal
	 *            the number of list you want to the amount of elements
	 * @return the amount of elements
	 * @throws ValueException
	 */
	public int getOverflowCount(int hashVal) throws ValueException {
		if (this.array == null) {
			return Integer.MIN_VALUE;
		}
		if (hashVal > array.length || hashVal < 0) { // hashVa bigger than
														// the hashtable or
														// smaller than zero
														// is not possible
			throw new ValueException("Invaid Index", hashVal);
		}
		if (array[hashVal] == null) {
			return Integer.MIN_VALUE;
		}
		return array[hashVal].countElements();

	}

	/**
	 * Counts the amount of elements in the hashtable by adding the amount of
	 * elements in each overflow list.
	 * 
	 * @return the amount of all elements
	 */
	public int elements() {
		if (this.array == null) {
			return Integer.MIN_VALUE;
		}
		int sum = 0;
		for (int i = 0; i <= array.length - 1; i++) {
			if (array[i] != null) {

				sum += array[i].countElements();
			}
		}
		return sum;

	}

}
