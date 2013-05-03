package at.fhhbg.mc.exercise2Test.member.active;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.member.active.Trainer;

public class TrainerTest {
	@Test
	public void getIncome() {
		Trainer test = null;
		Trainer test1 = null;
		try {
			test = new Trainer("Franz", 3);
			test1 = new Trainer("Karl", 5);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			Trainer test3 = new Trainer("Sepp", 12);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			Trainer test4 = new Trainer("Tony", -5);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(120, test.getIncome(), 0);
		assertEquals(120, test1.getIncome(), 0);

	}

	@Test
	public void getCostsTest() {
		Trainer test = null;
		Trainer test1 = null;
		try {
			test = new Trainer("Franz", 3);
			test1 = new Trainer("Karl", 5);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			Trainer test3 = new Trainer("Sepp", 12);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			Trainer test4 = new Trainer("Tony", -5);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(1440, test.getCosts(), 0);
		assertEquals(2400, test1.getCosts(), 0);

	}

	@Test
	public void getSurplus() {
		Trainer test = null;
		Trainer test1 = null;
		try {
			test = new Trainer("Franz", 3);
			test1 = new Trainer("Karl", 5);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			Trainer test3 = new Trainer("Sepp", 12);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			Trainer test4 = new Trainer("Tony", -5);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(-1320, test.getSurplus(), 0);
		assertEquals(-2280, test1.getSurplus(), 0);

	}
}
