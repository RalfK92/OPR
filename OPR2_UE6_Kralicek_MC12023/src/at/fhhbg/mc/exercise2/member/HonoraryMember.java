package at.fhhbg.mc.exercise2.member;

import at.fhhbg.mc.exercise2.AbstractMember;

public class HonoraryMember extends AbstractMember {

	/**
	 * Default constructor for the member
	 */
	public HonoraryMember() {
		super();
	}

	/**
	 * Constructor for the member with the name
	 * 
	 * @param name
	 */
	public HonoraryMember(String name) {
		super(name);
	}

	@Override
	public double getIncome() {
		return 0;
	}

	@Override
	public double getCosts() {
		return 20;
	}

}
