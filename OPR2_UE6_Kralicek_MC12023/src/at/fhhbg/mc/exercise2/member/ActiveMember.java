package at.fhhbg.mc.exercise2.member;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.AbstractMember;

public abstract class ActiveMember extends AbstractMember {
	private int activity;

	/**
	 * Constructor for the name of the member
	 * 
	 * @param name
	 */
	public ActiveMember(String name) {
		super(name);

	}

	/**
	 * Standard constructor
	 */
	public ActiveMember() {
		this(0);

	}

	/**
	 * Constructor with the activity
	 * 
	 * @param activity
	 */
	public ActiveMember(int activity) {
		super();
		this.activity = activity;
	}

	/**
	 * Constructor for the name and activity
	 * 
	 * @param name
	 *            name of the member
	 * @param activity
	 *            activity grade of the member.
	 * @throws ValueException
	 *             if the activity is not between 0 and 10.
	 */
	public ActiveMember(String name, int activity) throws ValueException {
		super(name);
		if (activity < 0 || activity > 10) {
			throw new ValueException("Activity have to be between 0 and 10.");

		}
		this.activity = activity;
	}

	/**
	 * Getter for the activity
	 * 
	 * @return the activity
	 */
	public int getActivity() {
		return activity;
	}

	/**
	 * Setter for the activity. Activity have to be smaller than 10 and bigger
	 * than 0.
	 * 
	 * @param activity
	 * @throws ValueException
	 *             if the activity is not between 0 ant 10.
	 */
	public void setActivity(int activity) throws ValueException {
		if (activity < 0 || activity > 10) {
			throw new ValueException("Activity have to be between 0 and 10.");

		}
		this.activity = activity;
	}
}
