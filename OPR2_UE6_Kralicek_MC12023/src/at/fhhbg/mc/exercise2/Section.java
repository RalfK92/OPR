package at.fhhbg.mc.exercise2;

import at.fhhbg.mc.exercise1.ValueException;

/**
 * @author ralfkralicek
 * 
 */
/**
 * @author ralfkralicek
 * 
 */
public class Section extends AbstractMember {

	private BinarySearchTree<AbstractMember> bst = null;

	/**
	 * Constructor for section
	 */
	public Section() {
		super();
		bst = new BinarySearchTree<AbstractMember>();
	}

	/**
	 * Constructor with the String name
	 * 
	 * @param name
	 *            name of the section.
	 */
	public Section(String name) {
		super(name);
		bst = new BinarySearchTree<AbstractMember>();
	}

	/**
	 * Method to add a member to a section.
	 * 
	 * @param m
	 *            the member to add
	 * @return true if the member is added and false if the member already
	 *         exists.
	 * @throws ValueException
	 *             if the member is not comparable to the root node
	 */
	public boolean addMember(AbstractMember m) throws ValueException {
		if (this.bst.root != null) {
			if (this.findMember(m.getName()) == null) {

				this.bst.insert(m);
				return true;
			} else {
				return false;
			}

		} else {
			this.bst.insert(m);
			return true;
		}

	}

	/**
	 * This method removes the member you enter with a String.
	 * 
	 * @param name
	 *            member to remove
	 * @return true if the member is removed false if the member does not
	 *         exists.
	 */
	public boolean removeMember(String name) {
		try {
			return this.bst.remove(this.findMember(name));
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Method to search after a Member
	 * 
	 * @param name
	 *            member you are looking for
	 * @return true if the member is in this section otherwise false
	 */
	public boolean isMember(String name) {
		AbstractMember am = this.findMember(name);
		if (am == null) {
			return false;
		}
		return true;
	}

	/**
	 * This private method finds the string name and returns the member if the
	 * member is not found it returns null
	 * 
	 * @param name
	 *            the person you are looking for
	 * @return null if the member not exists otherwise the member.
	 */
	private AbstractMember findMember(String name) {
		if (name != null) {
			AbstractMember[] ama = this.bst.toArray(AbstractMember.class, true);
			for (int i = 0; i < ama.length; i++) {
				if (name.equals(ama[i].getName())) {
					return ama[i];
				}
			}
		}
		return null;
	}

	@Override
	public double getIncome() {
		double income = 0.0;
		try {
			AbstractMember[] ama = this.bst.toArray(AbstractMember.class, true);
			for (int i = 0; i < ama.length; i++) {
				income += ama[i].getIncome();
			}
		} catch (NullPointerException npe) {
		}
		return income;
	}

	@Override
	public double getCosts() {
		double cost = 0.0;
		try {
			AbstractMember[] ama = this.bst.toArray(AbstractMember.class, true);
			for (int i = 0; i < ama.length; i++) {
				cost += ama[i].getCosts();
			}
		} catch (NullPointerException npe) {
		}
		return cost;
	}

	@Override
	public String toString() {
		return this.toString(true);
	}

	public String toString(boolean ascending, int tab) {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString(tab));
		try {
			AbstractMember[] ama = (AbstractMember[]) this.bst.toArray(
					AbstractMember.class, ascending);
			for (int i = 0; i < ama.length; i++) {
				if (Section.class.equals(ama[i].getClass())) {
					sb.append(((Section) ama[i]).toString(ascending, tab + 1));
				} else {
					sb.append(ama[i].toString(tab + 1));
				}
			}
		} catch (NullPointerException npe) {
		}
		return sb.toString();
	}

	/**
	 * This toString sorts the members if ascending if you enter true if you
	 * enter false it is descending.
	 * 
	 * @param ascending
	 *            for true its ascending and false descending
	 * @return toString
	 */
	public String toString(boolean ascending) {
		return toString(ascending, 0);
	}

}
