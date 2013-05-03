/**
 * 
 */
package at.fhhbg.mc.exercise2.member;

import at.fhhbg.mc.exercise2.AbstractMember;

/**
 * @author ralfkralicek
 * 
 */
public class SupportingMember extends AbstractMember {

	/**
	 * Default constructor for the member.
	 */
	public SupportingMember() {
		super();
	}

	/**
	 * Constructor for the member with the name.
	 * 
	 * @param name
	 */
	public SupportingMember(String name) {
		super(name);
	}

	@Override
	public double getIncome() {
		return 100;

	}

	@Override
	public double getCosts() {
		return 15;
	}

}