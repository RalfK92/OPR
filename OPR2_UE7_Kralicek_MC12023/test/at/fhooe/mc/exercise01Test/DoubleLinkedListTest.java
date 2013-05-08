package at.fhooe.mc.exercise01Test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhooe.mc.exercise01.DoubleLinkedList;
import at.fhooe.mc.exercise01.InvalidAccessException;

/**
 * @author ralfkralicek
 * 
 */
public class DoubleLinkedListTest {
	@Test
	public void pushFrontDLLTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();
		l.pushBack(4);
		l.pushBack(5);
		l.pushBack(6);
		other.pushBack(1);
		other.pushBack(2);
		other.pushBack(3);
		try {
			l.pushFront(other);
			assertEquals(1, l.popFront());
			assertEquals(2, l.popFront());
			assertEquals(3, l.popFront());
			assertEquals(4, l.popFront());
			assertEquals(5, l.popFront());
			assertEquals(6, l.popFront());
		} catch (InvalidAccessException e) {
			fail("Unexpected Exception");
		}

	}

	@Test
	public void pushBackDLLTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();
		other.pushBack(4);
		other.pushBack(5);
		other.pushBack(6);
		l.pushBack(1);
		l.pushBack(2);
		l.pushBack(3);
		try {
			l.pushBack(other);

			assertEquals(1, l.popFront());
			assertEquals(2, l.popFront());
			assertEquals(3, l.popFront());
			assertEquals(4, l.popFront());
			assertEquals(5, l.popFront());
			assertEquals(6, l.popFront());
		} catch (Exception e) {
			fail("Unexpected Exception");
		}

	}

	@Test
	public void cloneTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList clone = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();
		DoubleLinkedList cloneOther = new DoubleLinkedList();
		try {
			l.pushBack(1);
			l.pushBack(2);
			l.pushBack(3);

			clone = l.clone();

			assertEquals(1, clone.popFront());
			assertEquals(2, clone.popFront());
			assertEquals(3, clone.popFront());
			other.pushBack(l);
			other.pushBack(4);
			other.pushBack(5);
			cloneOther = other.clone();

			assertEquals(1, cloneOther.popFront());
			assertEquals(2, cloneOther.popFront());
			assertEquals(3, cloneOther.popFront());
			assertEquals(4, cloneOther.popFront());
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void equalsTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();
		DoubleLinkedList other1 = new DoubleLinkedList();

		l.pushBack(1);
		l.pushBack(2);
		l.pushBack(3);

		other.pushBack(1);
		other.pushBack(2);
		other.pushBack(3);

		assertEquals(true, l.equals(other));

		l1.pushBack(4);
		l1.pushBack(5);

		other1.pushBack(4);
		other1.pushBack(5);

		assertEquals(true, l1.equals(other1));
		try {
			other1.popBack();
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		assertEquals(false, l1.equals(other1));

	}

	@Test
	public void search() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();

		l.pushBack(1);
		l.pushBack(3);
		l.pushBack(4);
		l.pushBack(2);
		try {
			other.pushFront(l);
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		other.pushBack(6);
		other.pushBack(5);

		assertEquals(true, l.search(2));
		assertEquals(false, l.search(5));
		assertEquals(true, other.search(2));
		assertEquals(true, other.search(5));

		assertEquals(false, l1.search(2));

	}

	@Test
	public void clearTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();
		l.pushFront(1);
		l.pushFront(2);
		l.pushBack(3);
		l.clear();

		assertEquals(0, l.elements());

		assertEquals(false, l1.clear());
	}

	@Test
	public void pushFrontTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		l.pushFront(1);
		l.pushFront(2);
		try {
			assertEquals(2, l.peekFront());
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void pushBackTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		l.pushFront(2);
		l.pushBack(3);
		try {
			assertEquals(3, l.peekBack());
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void popFrontTest() {

		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();

		l.pushFront(1);
		l.pushBack(2);
		l.pushBack(3);

		other = l.clone();
		try {
			l.pushFront(other);
			assertEquals(1, l.popFront());
			assertEquals(2, l.popFront());
			assertEquals(3, l.popFront());
			assertEquals(1, l.popFront());
			assertEquals(2, l.popFront());
			assertEquals(3, l.popFront());
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			l.popFront();
		} catch (InvalidAccessException e) {
			// expected

		} catch (Exception e) {
			fail("Unexpected Exception");

		}

		try {
			l1.popFront();

		} catch (InvalidAccessException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}

	}

	@Test
	public void peekFrontTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();
		l.pushFront(1);
		l.pushBack(2);
		l.pushBack(3);

		other.pushBack(2);
		try {
			assertEquals(1, l.peekFront());
			assertEquals(1, l.peekFront());

			l.popFront();
			assertEquals(2, l.peekFront());
			assertEquals(2, l.peekFront());
		} catch (Exception e) {
			fail("Unexpected Exception");
		}

		try {
			l1.peekFront();
		} catch (InvalidAccessException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");

		}
	}

	@Test
	public void popBackTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();

		l.pushFront(1);
		l.pushFront(2);
		l.pushBack(3);

		try {
			assertEquals(3, l.popBack());
			assertEquals(1, l.popBack());
			assertEquals(2, l.popBack());
		} catch (InvalidAccessException e) {
			fail("Unexpected Exception");
		}
		try {
			l.popBack();
		} catch (InvalidAccessException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			l1.popBack();
		} catch (InvalidAccessException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void peekBackTest() {
		DoubleLinkedList l = new DoubleLinkedList();
		DoubleLinkedList l1 = new DoubleLinkedList();
		DoubleLinkedList other = new DoubleLinkedList();

		l.pushFront(1);
		l.pushBack(2);
		l.pushBack(3);
		try {
			assertEquals(3, l.peekBack());
			assertEquals(3, l.peekBack());
			l.popBack();
			assertEquals(2, l.peekBack());
			assertEquals(2, l.peekBack());

			other.pushBack(l);
			assertEquals(2, other.peekBack());
			assertEquals(2, other.peekBack());
		} catch (InvalidAccessException e) {
			fail("Unexpected Exception");
		}

		try {
			l1.peekBack();
		} catch (InvalidAccessException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void elementsTest() {
		DoubleLinkedList l = new DoubleLinkedList();

		l.pushFront(1);
		l.pushFront(2);
		l.pushBack(3);
		try {
			assertEquals(3, l.elements());
			l.popFront();
			assertEquals(2, l.elements());
			l.popBack();
			assertEquals(1, l.elements());
		} catch (InvalidAccessException e) {
			fail("Unexpected Exception");
		}
		l.pushFront(1);
		l.pushBack(3);

	}

	@Test
	public void reverseTest() {
		DoubleLinkedList l = new DoubleLinkedList();

		l.pushBack(1);
		l.pushBack(2);
		l.pushBack(3);
		l.pushBack(4);
		l.pushBack(5);
		l.reverse();
		try {
			assertEquals(5, l.popFront());
			assertEquals(4, l.popFront());
			assertEquals(3, l.popFront());
			assertEquals(2, l.popFront());
			assertEquals(1, l.popFront());
		} catch (InvalidAccessException e) {
			fail("Unexpected Exception");
		}
	}

}
