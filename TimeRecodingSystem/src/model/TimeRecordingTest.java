package model;

import java.time.LocalDate;

import org.junit.Test;

public class TimeRecordingTest {

	@Test
	public void testPeople() {
		TimeRecording testSystem = new TimeRecording();
		Result res;
		//Enter some people
		res = testSystem.enterPerson("Joe", false, "Project One");
		res = testSystem.enterPerson("Jane", false, "Project One");
		res = testSystem.enterPerson("Jim", true, "Project One");
		res = testSystem.enterPerson("Paula", false, "Project One");
		res.displayResult();
		//Enter Paula twice - should fail
		res = testSystem.enterPerson("Paula", false, "Project One");
		res.displayResult();
		//show all people
		testSystem.displayPeople();
		// Enter some time records
		res=testSystem.enterTimeRecording("Joe", LocalDate.now(), "Project One", 7);
		res.displayResult();
		res=testSystem.enterTimeRecording("Joe", LocalDate.now(), "Project Three", 0);
		res.displayResult();
		res=testSystem.enterTimeRecording("Jane", LocalDate.now(), "Project Three", 5);
		res=testSystem.enterTimeRecording("Jane", LocalDate.now(), "Project Three", 6);
		res=testSystem.enterTimeRecording("Jane", LocalDate.now(), "Project Three", 6);
		testSystem.displayTimeRecorded();
		//Enter time for unknown person
		res=testSystem.enterTimeRecording("NOENTRY", LocalDate.now(), "Project Three", 6);
		res.displayResult();
		// Enter our of range hours
		res=testSystem.enterTimeRecording("Joe", LocalDate.now(), "Project Three", 66);
		res.displayResult();
		res=testSystem.enterTimeRecording("Joe", LocalDate.now(), "Project Three", -1);
		res.displayResult();
		//search for bookings
		Booking b0 = testSystem.findBookings("Jane", LocalDate.now());
		b0.printBookings();
		//search for a booking which does not exist
		Booking b1 = testSystem.findBookings("NOENTRY", LocalDate.now());
		b1.printBookings();
	}


}
