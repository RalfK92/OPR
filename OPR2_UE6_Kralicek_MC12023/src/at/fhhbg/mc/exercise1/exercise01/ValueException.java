package at.fhhbg.mc.exercise1.exercise01;

public class ValueException extends Exception {

	// think of how you could pass the information on the base class...
	public ValueException(String _msg, int _whichVal) {
		super(_msg + "\n" + _whichVal);
	}
}
