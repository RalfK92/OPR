package at.fhhbg.mc.exercise2.member;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.AbstractMember;

public class ChairMember extends AbstractMember {
	private int competenz;

	/**
	 * Default constructor for the member
	 */
	public ChairMember() {
		super();

	}

	/**
	 * Constructor for the member with the name
	 * 
	 * @param name
	 *            the name of the member
	 */
	public ChairMember(String name) {
		super(name);

	}

	/**
	 * Constructor for the member with competenz grade.
	 * 
	 * @param competenz
	 *            the competenz grade of the member
	 * @throws ValueException
	 *             if the given competenz is not between 0 and 10
	 */
	public ChairMember(int competenz) throws ValueException {
		super();
		if (competenz < 0 || competenz > 10) {
			throw new ValueException("Competenz have to be between 0 and 10.");

		}

		this.competenz = competenz;
	}

	/**
	 * Constructor for the chairmember
	 * 
	 * @param name
	 *            name of the chairmember
	 * @param competenz
	 *            competenz of the cairmember
	 * @throws ValueException
	 *             if the given competenz is not between 0 and 10
	 */
	public ChairMember(String name, int competenz) throws ValueException {
		super(name);
		if (competenz < 0) {
			competenz = 0;
		} else if (competenz < 0 || competenz > 10) {
			throw new ValueException("Competenz have to be between 0 and 10.");

		}
		this.competenz = competenz;
	}

	/**
	 * This method returns you the competenz of a member.
	 * 
	 * @return returns the competenz of the member.
	 */
	public int getCompetenz() {
		return competenz;
	}

	/**
	 * This method set the competenz of an member with the given competenz.
	 * 
	 * @param competenz
	 *            the given competenz of an member
	 */
	public void setCompetenz(int competenz) {
		this.competenz = competenz;
	}

	@Override
	public double getIncome() {
		return this.getCompetenz() * 100;
	}

	@Override
	public double getCosts() {
		return this.getIncome() * 0.2;
	}

}
