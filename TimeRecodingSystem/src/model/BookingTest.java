package model;


import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class BookingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEnterBooking() {
		Booking b = new Booking (LocalDate.now(), "Test", 7);
		b.printBookings();
	}

}
