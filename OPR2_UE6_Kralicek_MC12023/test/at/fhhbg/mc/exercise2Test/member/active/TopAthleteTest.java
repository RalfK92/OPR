package at.fhhbg.mc.exercise2Test.member.active;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.member.active.TopAthlete;

;

public class TopAthleteTest {

	@Test
	public void getIncome() {
		TopAthlete test = null;
		TopAthlete test1 = null;
		try {
			test = new TopAthlete("Franz", 3);
			test1 = new TopAthlete("Karl", 5);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			TopAthlete test3 = new TopAthlete("Sepp", 12);
		} catch (ValueException e) {
			// excpected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			TopAthlete test4 = new TopAthlete("Tony", -5);
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
		TopAthlete test = null;
		TopAthlete test1 = null;
		try {
			test = new TopAthlete("Franz", 3);
			test1 = new TopAthlete("Karl", 5);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			TopAthlete test3 = new TopAthlete("Sepp", 12);
		} catch (ValueException e) {
			// excpected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			TopAthlete test4 = new TopAthlete("Tony", -5);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(180, test.getCosts(), 0);
		assertEquals(300, test1.getCosts(), 0);

	}

	@Test
	public void getSurplus() {
		TopAthlete test = null;
		TopAthlete test1 = null;
		try {
			test = new TopAthlete("Franz", 3);
			test1 = new TopAthlete("Karl", 5);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			TopAthlete test3 = new TopAthlete("Sepp", 12);
		} catch (ValueException e) {
			// excpected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			TopAthlete test4 = new TopAthlete("Tony", -5);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(-60, test.getSurplus(), 0);
		assertEquals(-180, test1.getSurplus(), 0);

	}
}
