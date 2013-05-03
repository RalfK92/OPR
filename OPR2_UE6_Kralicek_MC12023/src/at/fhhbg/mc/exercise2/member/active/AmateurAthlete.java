package at.fhhbg.mc.exercise2.member.active;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.member.ActiveMember;

public class AmateurAthlete extends ActiveMember {

	/**
	 * Constructor for the member with the name.
	 * 
	 * @param name
	 */
	public AmateurAthlete(String name) {
		super(name);

	}

	/**
	 * Constructor for the member with activity.
	 * 
	 * @param activity
	 *            the grade of activity must be smaller than 10 and bigger than
	 *            0
	 */
	public AmateurAthlete(int activity) throws ValueException {

		super(activity);
	}

	/**
	 * Constructor for the member.
	 */
	public AmateurAthlete() throws ValueException {
		this(0);
	}

	/**
	 * Constructor with the name and the activity grade.
	 * 
	 * @param name
	 * @param activity
	 * @throws ValueException
	 *             if the given activity is not between 0 and 10.
	 */
	public AmateurAthlete(String name, int activity) throws ValueException {
		super(name, activity);

	}

	@Override
	public double getIncome() {

		return 25 * 12;
	}

	@Override
	public double getCosts() {

		return this.getActivity() * 2.5 * 12;
	}

}
