package model;
/**
* <h1>Representation of a booking entry!</h1>
* Simple representation of a booking entry as a project
* name and the number of hours booked.
*<p>
*/
public class BookingEntry {
	public String project;
	public int hours;	
	public BookingEntry(String p, int h) {
		project = p;
		hours = h;
	}
	
	public void BookingEntryPrint () {
		System.out.print(project + ": ");
		System.out.println(hours);
	}

}
