package at.fhhbg.mc.exercise2.member.active;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.member.ActiveMember;

public class Trainer extends ActiveMember {
	/**
	 * Constructor for the member with the activity. Activity have to be smaller
	 * than 10 and bigger than 0.
	 * 
	 * @param activity
	 *            the activity of the member.
	 */
	public Trainer(int activity) {
		super(activity);
	}

	/**
	 * Constructor for the member with the name.
	 * 
	 * @param name
	 *            the name of the member.
	 */
	public Trainer(String name) {
		super(name);
	}

	/**
	 * Default constructor for the member.
	 */
	public Trainer() {
		super(0);
	}

	/**
	 * Constructor for the member with the name and activity. Activity grade
	 * have to be smaller than 10 an bigger than 0.
	 * 
	 * @param name
	 *            the name of the member
	 * @param activity
	 *            the activity grade of the member have to be bigger than 0 and
	 *            smaller than 10.
	 * @throws ValueException
	 *             if the activity is not between 0 and 10.
	 */
	public Trainer(String name, int activity) throws ValueException {
		super(name, activity);

	}

	@Override
	public double getIncome() {

		return 12 * 10;
	}

	@Override
	public double getCosts() {

		return this.getActivity() * 40 * 12;
	}

}
