package model;


import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* <h1>Model for a Simple Time Recording System!</h1>
* The TimeRecoding program implements a number of 
* classes to support the entry and management of 
* a time bookings against projects.
*<p>
* @author  Patrick McParland
* @version 1.0
* @since   01-August-2014
*/

public class TimeRecording {
	   /**
	   * This data structure contains a set of the people against which bookings can be made.
	   */
	LinkedHashMap<String, Person> people = new LinkedHashMap<String, Person>();
	
	   /**
	   * This data structure contains a mapping of all of the time entries entered, stored by date.
	   */
	LinkedHashMap<String, Booking> timeRecorded = new LinkedHashMap<String, Booking>();
	
	
	   /**
	   * This method is used to enter time against a project.
	   * @param name This is the name of the person working on the project.
	   * @param d  This is the date on which the work was carried out.
	   * @param project  This is the project name for this booking.
	   * @param hours  This is the number of hours worked on the project.
	   * @return res This is the result of entering the time recording.

	   */
	public Result enterTimeRecording(String name, LocalDate d, String project, int hours){
		//Check if person called name exists
		if (!people.containsKey(name)) {
			// Person name does not exist
			return new Result(false, "Person " + name + " does not exist");
		}
		else if (hours<0 || hours>24) {
			// Hours out of range
			return new Result(false, "Hours " + hours + " is out of range");
		}
		else if (people.containsKey(name) && timeRecorded.containsKey(name)){
			timeRecorded.put(name, new Booking(d, project, hours));
			return new Result(true, "");
		}
		else if (!timeRecorded.containsKey(name)){
			//First entry for person name
			timeRecorded.put(name, new Booking(d, project, hours));
		    return new Result(true, "");
		} 
	    return new Result(false, "unexpected error with adding person " + name);
	}
	   /**
	   * This method is used to search for a booking made by a person for a specific date.
	   * @param name This is the name of the person to search against
	   * @param d  This is the date for which entries are required.
	   * @return Booking This all the of the bookings which match person and date
	   */
	public Booking findBookings (String name, LocalDate d){
		// Return the bookings made for a person, name, on a date, d.
		if (!people.containsKey(name) || !timeRecorded.containsKey(name)) {
			return null;
		}
		else {
			return timeRecorded.get(name);
		}
		
	}
	   /**
	   * This method is used to enter a person into the system.
	   * @param name This is the name of the person.
	   * @param project  This is the name of a project on which this person is working.
	   * @return res This is the result of entering the person.
	   */
	public Result enterPerson(String name, Boolean b, String project ){
		// Person must be unique
		if (people.containsKey(name)) {
			return new Result(false, "Person "+ name+ " already exists");
		}
		else {
			Person p = new Person(name, b, project);
			people.put(name, p);
			return new Result(true, "");
		}
		//return new Result(false, "unexpected error with adding person " + name);
	}
	   /**
	   * This method is used to print out all current time recordings.
	   */
	public void displayTimeRecorded (){
		for (Map.Entry<String, Booking> entry :timeRecorded.entrySet()){
			String name = (String) entry.getKey();
			Booking b = (Booking) entry.getValue();
			System.out.println("Entries for person:" + name);
			b.printBookings();
		}
	}
	   /**
	   * This method is used to print out all current people in the system.
	   */
	public void displayPeople(){
		for(Map.Entry<String, Person> entry: people.entrySet()){
			entry.getValue().PrintPerson();
		}
	}
	public TimeRecording() {
		// TODO Auto-generated constructor stub
	}

}
