package at.fhhbg.mc.exercise2Test.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import at.fhhbg.mc.exercise2.member.HonoraryMember;

public class HonoraryMemberTest {

	@Test
	public void getIncome() {
		HonoraryMember test = new HonoraryMember("Franz");
		HonoraryMember test1 = new HonoraryMember("Karl");
		HonoraryMember test3 = new HonoraryMember("Sepp");

		assertEquals(0, test.getIncome(), 0);
		assertEquals(0, test1.getIncome(), 0);
		assertEquals(0, test3.getIncome(), 0);

	}

	@Test
	public void getCostsTest() {
		HonoraryMember test = new HonoraryMember("Franz");
		HonoraryMember test1 = new HonoraryMember("Karl");
		HonoraryMember test3 = new HonoraryMember("Sepp");

		assertEquals(20, test.getCosts(), 0);
		assertEquals(20, test1.getCosts(), 0);
		assertEquals(20, test3.getCosts(), 0);

	}

	@Test
	public void getSurplus() {
		HonoraryMember test = new HonoraryMember("Franz");
		HonoraryMember test1 = new HonoraryMember("Karl");
		HonoraryMember test3 = new HonoraryMember("Sepp");

		assertEquals(-20, test.getSurplus(), 0);
		assertEquals(-20, test1.getSurplus(), 0);
		assertEquals(-20, test3.getSurplus(), 0);

	}

}
