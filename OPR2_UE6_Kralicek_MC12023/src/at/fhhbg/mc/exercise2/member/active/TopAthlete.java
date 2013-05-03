/**
 * 
 */
package at.fhhbg.mc.exercise2.member.active;

import at.fhhbg.mc.exercise1.ValueException;
import at.fhhbg.mc.exercise2.member.ActiveMember;

/**
 * @author ralfkralicek
 * 
 */
public class TopAthlete extends ActiveMember {

	/**
	 * Constructor for the member with the name.
	 * 
	 * @param name
	 *            the name of the member
	 */
	public TopAthlete(String name) {
		super(name);

	}

	/**
	 * Constructor of the member with the activity. Activity have to be smaller
	 * than 10 and bigger than 0.
	 * 
	 * @param activity
	 *            the grade of activity have to be smaller than 10 and bigger
	 *            than 0.
	 */
	public TopAthlete(int activity) {

		super(activity);
	}

	/**
	 * Default constructor
	 */
	public TopAthlete() {
		super(0);
	}

	/**
	 * Constructor for the member with name and activity. Activity have to be
	 * smaller than 10 and bigger than 0.
	 * 
	 * @param name
	 *            the name of the member
	 * @param activity
	 *            the activity grade of the member have to be bigger than 0 and
	 *            smaller to 10.
	 * @throws ValueException
	 *             if the given activity is not between 0 and 10.
	 */
	public TopAthlete(String name, int activity) throws ValueException {
		super(name, activity);

	}

	@Override
	public double getIncome() {

		return 10 * 12;
	}

	@Override
	public double getCosts() {

		return this.getActivity() * 5 * 12;
	}

}