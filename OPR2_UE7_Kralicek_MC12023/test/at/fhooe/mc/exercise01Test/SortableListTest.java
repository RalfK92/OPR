package at.fhooe.mc.exercise01Test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhooe.mc.exercise01.Sortable;
import at.fhooe.mc.exercise01.SortableList;

public class SortableListTest {

	@Test
	public void insertSortedTest() {
		SortableList test = new SortableList();

		test.pushFront(3);
		test.pushFront(66);
		test.insertSorted(5, true);
		test.insertSorted(25, false);
		test.insertSorted(2, true);

		try {
			assertEquals(2, test.elementAt(1));
			assertEquals(25, test.elementAt(2));
			assertEquals(5, test.elementAt(3));
			assertEquals(66, test.elementAt(4));
			assertEquals(3, test.elementAt(5));
		} catch (Exception e) {
			fail("Unexpected Exception");
		}

	}

	@Test
	public void sortAcending() {
		SortableList test = new SortableList();
		SortableList test1 = new SortableList();

		test.pushFront(3);
		test.pushFront(66);
		test.insertSorted(5, true);
		test.insertSorted(25, false);
		test.insertSorted(2, true);

		test1 = (SortableList) test.sortAscending();

		try {
			assertEquals(2, test1.elementAt(1));
			assertEquals(3, test1.elementAt(2));
			assertEquals(5, test1.elementAt(3));
			assertEquals(25, test1.elementAt(4));
			assertEquals(66, test1.elementAt(5));
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void sortDescending() {
		SortableList test = new SortableList();
		SortableList test1 = new SortableList();

		test.pushFront(3);
		test.pushFront(66);
		test.insertSorted(5, true);
		test.insertSorted(25, false);
		test.insertSorted(2, true);

		test1 = (SortableList) test.sortDescending();

		try {
			assertEquals(66, test1.elementAt(1));
			assertEquals(25, test1.elementAt(2));
			assertEquals(5, test1.elementAt(3));
			assertEquals(3, test1.elementAt(4));
			assertEquals(2, test1.elementAt(5));
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

}
