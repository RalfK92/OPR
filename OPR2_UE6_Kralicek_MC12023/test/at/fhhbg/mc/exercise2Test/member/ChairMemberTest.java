package at.fhhbg.mc.exercise2Test.member;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.member.ChairMember;

public class ChairMemberTest {

	@Test
	public void getIncome() {
		ChairMember test = null;
		ChairMember test1 = null;

		try {
			test = new ChairMember("Franz", 5);
			test1 = new ChairMember("Karl", 3);
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		try {
			ChairMember test3 = new ChairMember("Sepp", 15);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {

		}
		assertEquals(500, test.getIncome(), 0);
		assertEquals(300, test1.getIncome(), 0);

	}

	@Test
	public void getCostsTest() {
		ChairMember test = null;
		ChairMember test1 = null;
		try {
			test = new ChairMember("Franz", 5);
			test1 = new ChairMember("Karl", 3);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			ChairMember test3 = new ChairMember("Sepp", 15);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		assertEquals(100, test.getCosts(), 0);
		assertEquals(60, test1.getCosts(), 0);

	}

	@Test
	public void getSurplus() {
		ChairMember test = null;
		ChairMember test1 = null;
		try {
			test = new ChairMember("Franz", 5);
			test1 = new ChairMember("Karl", 3);
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			ChairMember test3 = new ChairMember("Sepp", 15);
		} catch (ValueException e) {
			// expected
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		assertEquals(400, test.getSurplus(), 0);
		assertEquals(240, test1.getSurplus(), 0);

	}

}
