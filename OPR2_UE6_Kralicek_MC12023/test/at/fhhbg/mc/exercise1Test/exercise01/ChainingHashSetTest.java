package at.fhhbg.mc.exercise1Test.exercise01;

import static org.junit.Assert.*;

import org.junit.Test;
import at.fhhbg.mc.exercise1.exercise01.ChainingHashSet;
import at.fhhbg.mc.exercise1.exercise01.ValueException;

public class ChainingHashSetTest {
	@Test
	public void insertTest() {
		ChainingHashSet test = new ChainingHashSet(10);

		try {
			assertEquals(true, test.insert(50));
			assertEquals(true, test.insert(32));
		} catch (Exception e) {
			fail("Unexpected Execption");

		}

		try {
			test.insert(50);
			fail("ValueException");
		} catch (ValueException e) {
			// expected Exception
		} catch (Exception e) {
			fail("Unexpected Exception");
		}

		assertEquals(2, test.elements());
		assertEquals(true, test.contains(50));
		assertEquals(true, test.contains(32));

		ChainingHashSet test1 = new ChainingHashSet(3);
		try {
			assertEquals(true, test1.insert(50));
			assertEquals(true, test1.insert(32));
		} catch (Exception e) {
			fail("Unexpected Execption");

		}
		try {
			test.insert(50);
			fail("ValueException");
		} catch (ValueException e) {
			// expected Exception
		} catch (Exception e) {
			fail("Unexpected Exception");
		}

		assertEquals(2, test1.elements());
		assertEquals(true, test1.contains(50));
		assertEquals(true, test1.contains(32));

	}

	@Test
	public void containsTest() {
		ChainingHashSet test = new ChainingHashSet(10);
		assertEquals(false, test.contains(12));

		try {
			test.insert(23);
			test.insert(55);
			test.insert(10);

		} catch (Exception e) {
			fail("Unexpected Execption");

		}
		try {
			test.insert(10);
			fail("ValueException");
		} catch (ValueException e) {

			// expected Exception
		} catch (Exception e) {
			fail("Unexpected Exception");

		}

		assertEquals(true, test.contains(23));
		assertEquals(false, test.contains(33));

		ChainingHashSet test1 = new ChainingHashSet(3);
		try {
			test1.insert(23);
			test1.insert(55);
			test1.insert(10);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(true, test1.contains(23));
		assertEquals(false, test1.contains(33));

	}

	@Test
	public void removeTest() {
		ChainingHashSet test = new ChainingHashSet(10);
		assertEquals(false, test.remove(12));
		try {
			test.insert(23);
			test.insert(55);
			test.insert(10);
			test.insert(65);
			test.insert(75);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(true, test.remove(23));
		assertEquals(false, test.contains(23));
		assertEquals(4, test.elements());

		assertEquals(true, test.remove(65));
		assertEquals(false, test.contains(65));
		assertEquals(3, test.elements());

		assertEquals(true, test.remove(75));
		assertEquals(false, test.contains(75));
		assertEquals(2, test.elements());

		ChainingHashSet test1 = new ChainingHashSet(10);
		try {
			test1.insert(23);
			test1.insert(55);
			test1.insert(10);
			test1.insert(65);
			test1.insert(75);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(true, test1.remove(23));
		assertEquals(false, test1.contains(23));
		assertEquals(4, test1.elements());

		assertEquals(true, test1.remove(65));
		assertEquals(false, test1.contains(65));
		assertEquals(3, test1.elements());

		assertEquals(true, test1.remove(75));
		assertEquals(false, test1.contains(75));
		assertEquals(2, test1.elements());

	}

	@Test
	public void getOverflowCount() {
		ChainingHashSet test = new ChainingHashSet(10);
		try {
			test.getOverflowCount(0);

		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			test.insert(23);
			test.insert(55);
			test.insert(10);
			test.insert(33);
			test.insert(65);
			test.insert(20);
			test.insert(43);
			test.insert(75);
			test.insert(30);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			assertEquals(3, test.getOverflowCount(3));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		ChainingHashSet test1 = new ChainingHashSet(3);
		try {
			test1.insert(23);
			test1.insert(55);
			test1.insert(10);
			test1.insert(33);
			test1.insert(65);
			test1.insert(20);
			test1.insert(43);
			test1.insert(75);
			test1.insert(30);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			assertEquals(3, test1.getOverflowCount(2));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
	}

	@Test
	public void elementsTest() {
		ChainingHashSet test = new ChainingHashSet(10);

		assertEquals(0, test.elements());
		try {
			test.insert(23);
			test.insert(55);
			test.insert(10);
			test.insert(33);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(4, test.elements());
		try {
			test.insert(65);
			test.insert(20);
			test.insert(43);
			test.insert(75);
			test.insert(30);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(9, test.elements());

	}

}
