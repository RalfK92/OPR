package at.fhhbg.mc.exercise2Test.member.active;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.member.active.AmateurAthlete;

;

public class AmateurAthelteTest {

	@Test
	public void getIncome() {
		AmateurAthlete test = null;
		AmateurAthlete test1 = null;
		try {
			test = new AmateurAthlete("Franz", 3);
			test1 = new AmateurAthlete("Karl", 5);
		} catch (Exception e) {
			// expected
		}
		try {
			AmateurAthlete test3 = new AmateurAthlete("Sepp", 12);
		} catch (ValueException e) {
			// excepted
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			AmateurAthlete test4 = new AmateurAthlete("Tony", -5);
		} catch (ValueException e) {
			// excepted
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		assertEquals(300, test.getIncome(), 0);
		assertEquals(300, test1.getIncome(), 0);

	}

	@Test
	public void getCostsTest() {
		AmateurAthlete test = null;
		AmateurAthlete test1 = null;
		try {
			test = new AmateurAthlete("Franz", 3);
			test1 = new AmateurAthlete("Karl", 5);
		} catch (Exception e) {
			// expected
		}
		try {
			AmateurAthlete test3 = new AmateurAthlete("Sepp", 12);
		} catch (ValueException e) {
			// excepted
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			AmateurAthlete test4 = new AmateurAthlete("Tony", -5);
		} catch (ValueException e) {
			// excepted
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		assertEquals(90, test.getCosts(), 0);
		assertEquals(150, test1.getCosts(), 0);

	}

	@Test
	public void getSurplus() {
		AmateurAthlete test = null;
		AmateurAthlete test1 = null;
		try {
			test = new AmateurAthlete("Franz", 3);
			test1 = new AmateurAthlete("Karl", 5);
		} catch (Exception e) {
			// expected
		}
		try {
			AmateurAthlete test3 = new AmateurAthlete("Sepp", 12);
		} catch (ValueException e) {
			// excepted
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			AmateurAthlete test4 = new AmateurAthlete("Tony", -5);
		} catch (ValueException e) {
			// excepted
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		assertEquals(210, test.getSurplus(), 0);
		assertEquals(150, test1.getSurplus(), 0);

	}
}
