package at.fhooe.mc.exercise01;

public interface Sortable {
	//insert one element into the Sortable and do so either in ascending //or descending fashion
	public void insertSorted(Comparable _value, boolean _ascending);
	// create a new Sortable which is guaranteed to be sorted ascending
	public Sortable sortAscending();
	// create a new Sortable which is guaranteed to be sorted descending
	public Sortable sortDescending();
}
