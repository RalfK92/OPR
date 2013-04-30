/**
 * 
 */
package at.fhhbg.mc.exercise1Test.exercise01;

import static org.junit.Assert.*;

import java.rmi.UnexpectedException;

import org.junit.Test;

import at.fhhbg.mc.exercise1.exercise01.InvalidAccessException;
import at.fhhbg.mc.exercise1.exercise01.RandomAccessDoubleLinkedList;
import at.fhhbg.mc.exercise1.exercise01.ValueException;

/**
 * @author ralfkralicek
 * 
 */
public class RandomAcessDoubleLinkedListTest {

	@Test
	public void useCopyConstructor() {
		RandomAccessDoubleLinkedList test1 = new RandomAccessDoubleLinkedList();
		try {
			test1.insertAt(5, 5);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		RandomAccessDoubleLinkedList test = new RandomAccessDoubleLinkedList(
				test1);

		try {
			assertEquals(5, test.elementAt(5));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}

		assertEquals(5, test.elements());

	}

	@Test
	public void insertTest() {
		RandomAccessDoubleLinkedList test = new RandomAccessDoubleLinkedList();
		try {
			test.insertAt(2, 3);
			assertEquals(3, test.elementAt(2));
			test.insertAt(7, 2);
			assertEquals(2, test.elementAt(7));
			test.insertAt(5, 3);
			assertEquals(3, test.elementAt(5));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}

	}

	@Test
	public void containsTest() {
		RandomAccessDoubleLinkedList test = new RandomAccessDoubleLinkedList();

		try {
			test.insertAt(10, 2);
			test.insertAt(3, 22);
			test.insertAt(5, 17);
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		assertEquals(true, test.contains(2));
		assertEquals(true, test.contains(22));
		assertEquals(true, test.contains(17));
		assertEquals(false, test.contains(23));

	}

	@Test
	public void removeAt() {
		RandomAccessDoubleLinkedList test = new RandomAccessDoubleLinkedList();
		try {
			test.removeAt(2); // empty list
			fail("ValueException");

		} catch (InvalidAccessException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			test.insertAt(2, 3);
			test.insertAt(7, 2);
			test.insertAt(5, 3);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			assertEquals(false, test.removeAt(-2)); // index smaller than 1 is
													// not
			fail("InvalidAccessException");
		} catch (InvalidAccessException e) {
			// possible
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			assertEquals(false, test.removeAt(8));
			fail("InvaidAccessExeption"); // index bigger than list is not
		} catch (InvalidAccessException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try { // possible
			assertEquals(true, test.removeAt(7));
			assertEquals(true, test.removeAt(2));
			assertEquals(true, test.removeAt(5));
			assertEquals(true, test.removeAt(4));

		} catch (Exception E) {
			fail("Unexpected Exception");

		}

	}

	@Test
	public void removeAll() {
		RandomAccessDoubleLinkedList test = new RandomAccessDoubleLinkedList();
		try {
			test.insertAt(2, 5);
			test.insertAt(7, 2);
			test.insertAt(5, 4);
			test.insertAt(9, 3);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(true, test.removeAll(3));
		assertEquals(false, test.contains(3));

		assertEquals(false, test.removeAll(7));
	}

	@Test
	public void elementAtTest() {
		RandomAccessDoubleLinkedList test = new RandomAccessDoubleLinkedList();
		try {
			test.insertAt(2, 5);
			test.insertAt(7, 2);
			test.insertAt(5, 4);
			test.insertAt(9, 3);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			assertEquals(5, test.elementAt(2));
			assertEquals(2, test.elementAt(7));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}

		try {
			test.elementAt(10);
			fail("ValueException");
		} catch (ValueException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");

		}

	}
}
