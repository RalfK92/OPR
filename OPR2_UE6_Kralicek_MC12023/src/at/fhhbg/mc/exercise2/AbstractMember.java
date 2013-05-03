/**
 * 
 */
package at.fhhbg.mc.exercise2;

/**
 * @author ralfkralicek
 * 
 */

public abstract class AbstractMember implements Comparable<AbstractMember> {
	private String name;

	/**
	 * Constructor with String
	 * 
	 * @param name
	 *            the of the abstract member
	 */
	public AbstractMember(String name) {
		super();
		this.name = name;
	}

	/**
	 * Constructor
	 */
	public AbstractMember() {

		this("");
	}

	/**
	 * Getter for the name.
	 * 
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the Name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public abstract double getIncome();

	public abstract double getCosts();

	/**
	 * This method returns the surplus of a person or section.
	 * 
	 * @return the surplus of a person or section.
	 */
	public double getSurplus() {
		return this.getIncome() - this.getCosts();
	}

	@Override
	public String toString() {
		StringBuilder nameLine = new StringBuilder();
		StringBuilder surplusLine = new StringBuilder();
		int biggest = 0;
		for (int i = 0; i <= getName().length(); i++) {
			nameLine.append("-");
		}
		nameLine.append("\n  ");

		if (new Double(getCosts()).toString().length() > new Double(getIncome())
				.toString().length()
				&& new Double(getCosts()).toString().length() > new Double(
						getSurplus()).toString().length()) {
			biggest = new Double(getCosts()).toString().length();
		} else if (new Double(getIncome()).toString().length() > new Double(
				getCosts()).toString().length()
				&& new Double(getIncome()).toString().length() > new Double(
						getSurplus()).toString().length()) {
			biggest = new Double(getIncome()).toString().length();
		} else {
			biggest = new Double(getSurplus()).toString().length();
		}

		for (int i = 0; i <= biggest; i++) {
			surplusLine.append("-");
		}

		return getName() + ":\n" + nameLine.toString() + getIncome() + "\n -"
				+ getCosts() + "\n " + surplusLine.toString() + "\n ="
				+ getSurplus() + "\n " + surplusLine.toString() + "\n";
	};

	public String toString(int tab) {
		StringBuilder tabLine = new StringBuilder();
		StringBuilder nameLine = new StringBuilder();
		StringBuilder surplusLine = new StringBuilder();
		int biggest = 0;
		for (int i = 0; i <= getName().length(); i++) {
			nameLine.append("-");
		}
		nameLine.append("\n");
		for (int i = 0; i < tab; i++) {
			tabLine.append("\t");
		}
		if (new Double(getCosts()).toString().length() > new Double(getIncome())
				.toString().length()
				&& new Double(getCosts()).toString().length() > new Double(
						getSurplus()).toString().length()) {
			biggest = new Double(getCosts()).toString().length();
		} else if (new Double(getIncome()).toString().length() > new Double(
				getCosts()).toString().length()
				&& new Double(getIncome()).toString().length() > new Double(
						getSurplus()).toString().length()) {
			biggest = new Double(getIncome()).toString().length();
		} else {
			biggest = new Double(getSurplus()).toString().length();
		}

		for (int i = 0; i <= biggest; i++) {
			surplusLine.append("-");
		}

		return tabLine.toString() + getName() + ":\n" + tabLine.toString()
				+ nameLine.toString() + tabLine.toString() + " " + getIncome()
				+ "\n" + tabLine.toString() + "-" + getCosts() + "\n"
				+ tabLine.toString() + "" + surplusLine.toString() + "\n"
				+ tabLine.toString() + "=" + getSurplus() + "\n"
				+ tabLine.toString() + "" + surplusLine.toString() + "\n";
	};

	@Override
	public int compareTo(AbstractMember other) {
		return new Double(this.getIncome()).compareTo(new Double(other
				.getIncome()));
	}

}
