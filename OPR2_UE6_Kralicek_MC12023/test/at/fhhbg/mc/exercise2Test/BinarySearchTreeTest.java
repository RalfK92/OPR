package at.fhhbg.mc.exercise2Test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.BinarySearchTree;

public class BinarySearchTreeTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void insertTest() {
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test1 = new BinarySearchTree();
		try {
			assertEquals(true, test.insert(50));
			assertEquals(true, test.insert(20));
			assertEquals(true, test.insert(60));

			test1.insert(50);
			test1.insert(20);
			test1.insert(60);
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			test1.insert(20);

		} catch (ValueException e) {
			// expected Exception
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void findTest() {
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test1 = new BinarySearchTree();
		try {
			test.insert(70);
			test.insert(90);
			test.insert(50);
			test.insert(22);
			test.insert(99);
			test.insert(33);
			test.insert(44);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			assertEquals(22, test.find(22));
			assertEquals(null, test.find(100));
			assertEquals(99, test.find(99));
			assertEquals(44, test.find(44));

			assertEquals(null, test1.find(20));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Unexpected Exception");

		}
		try {
			test.find(null);

		} catch (NullPointerException e) {
			// Excpexted
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void removeTest() {
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test1 = new BinarySearchTree();
		try {
			test.insert(70);
			test.insert(90);
			test.insert(50);
			test.insert(22);
			test.insert(99);
			test.insert(33);
			test.insert(44);
			test.insert(52);
			test.insert(51);
			test.insert(53);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			assertEquals(true, test.remove(50));

			assertEquals(9, test.size());

			assertEquals(52, test.find(52));

			assertEquals(true, test.remove(90));
			assertEquals(8, test.size());

			assertEquals(99, test.find(99));

			assertEquals(true, test.remove(99));
			assertEquals(7, test.size());

			assertEquals(true, test.remove(22));

			assertEquals(false, test1.remove(20));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}

		try {
			test1.remove(null);
		} catch (NullPointerException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void sizeTest() {
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test1 = new BinarySearchTree();
		try {
			test.insert(70);
			test.insert(90);
			test.insert(50);
			test.insert(22);
			test.insert(99);

			assertEquals(5, test.size());
			test.insert(33);
			test.insert(44);
			assertEquals(7, test.size());

			assertEquals(Integer.MIN_VALUE, test1.size());
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void maxTest() {
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test1 = new BinarySearchTree();
		try {
			test.insert(70);
			test.insert(90);
			test.insert(50);
			test.insert(22);
			test.insert(99);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(99, test.max());
		try {
			test.insert(110);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(110, test.max());
		try {
			test1.max();
		} catch (NullPointerException e) {
			// excpected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void minTest() {
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test1 = new BinarySearchTree();
		try {
			test.insert(70);
			test.insert(90);
			test.insert(50);
			test.insert(22);
			test.insert(99);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(22, test.min());

		try {
			test1.min();
		} catch (NullPointerException e) {
			// expected Exception
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void toArrayTest() {
		BinarySearchTree test = new BinarySearchTree();
		BinarySearchTree test1 = new BinarySearchTree();
		try {
			test.insert(70);
			test.insert(90);
			test.insert(50);
			test.insert(22);
			test.insert(99);

		} catch (Exception e) {
			fail("Unexpected Exception");

		}

		Integer[] testArray = { 22, 50, 70, 90, 99 };
		assertArrayEquals(testArray, test.toArray(Integer.class, true));

		Integer[] testArrayFalse = { 99, 90, 70, 50, 22 };
		assertArrayEquals(testArrayFalse, test.toArray(Integer.class, false));

		try {
			test1.toArray(Integer.class, true);
		} catch (NullPointerException e) {
			// expected Exception
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}
}
