package at.fhhbg.mc.exercise2Test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhbg.mc.exercise2.Section;
import at.fhhbg.mc.exercise2.member.ChairMember;
import at.fhhbg.mc.exercise2.member.HonoraryMember;
import at.fhhbg.mc.exercise2.member.SupportingMember;
import at.fhhbg.mc.exercise2.member.active.AmateurAthlete;

public class SectionTest {

	@Test
	public void addMember() {
		Section union = new Section("UnionAdd");
		try {
			assertEquals(true, union.addMember(new HonoraryMember("Franz")));
			assertEquals(false, union.addMember(new ChairMember("Franz")));

			Section fb = new Section("FB");
			assertEquals(true, fb.addMember(new SupportingMember("Sepp")));
			Section fb1 = new Section("FBB");
			assertEquals(true, fb1.addMember(new SupportingMember("Fritz")));
			fb1.addMember(new AmateurAthlete("Karl", 2));

			assertEquals(true, fb.addMember(fb1));
			assertEquals(true, union.addMember(fb));
			assertEquals(false, fb.addMember(new Section("FBB")));

		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			union.addMember(null);
		} catch (NullPointerException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void removeMemberTest() {
		Section union = new Section("UnionRemove");

		try {
			union.addMember(new HonoraryMember("Franz"));
			Section fb = new Section("FB");
			fb.addMember(new SupportingMember("Sepp"));
			Section fb1 = new Section("FBB");
			fb1.addMember(new SupportingMember("Fritz"));
			fb1.addMember(new AmateurAthlete("Karl", 2));
			fb.addMember(fb1);
			union.addMember(fb);

			assertEquals(true, union.removeMember("Franz"));
			assertEquals(true, fb1.removeMember("Karl"));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}
		try {
			union.removeMember(null);
		} catch (NullPointerException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

	@Test
	public void isMemberTest() {
		Section union = new Section("UnionIsMember");

		try {
			union.addMember(new HonoraryMember("Franz"));
			Section fb = new Section("FB");
			fb.addMember(new SupportingMember("Sepp"));
			Section fb1 = new Section("FBB");
			fb1.addMember(new SupportingMember("Fritz"));
			fb1.addMember(new AmateurAthlete("Karl", 2));
			fb.addMember(fb1);
			union.addMember(fb);

			assertEquals(true, union.isMember("Franz"));
			assertEquals(false, union.isMember("Karl"));
		} catch (Exception e) {
			fail("Unexpected Exception");

		}

		try {
			union.isMember(null);
		} catch (NullPointerException e) {

		} catch (Exception e) {
			fail("Unexpected Exception");
		}
	}

}
