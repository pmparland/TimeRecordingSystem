package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
* <h1>Representation of a booking!</h1>
* Simple representation of a booking as a mapping 
* from a date to and entry.
*<p>
*/
public class Booking {

	public LinkedHashMap<LocalDate, BookingEntry> bookingsMade = new LinkedHashMap<LocalDate, BookingEntry>();
	
	public  Booking (LocalDate d, String project, int hours){
		bookingsMade.put(d, new BookingEntry(project, hours));
	}
	public BookingEntry getBookingEntry(LocalDate d){
		return this.bookingsMade.get(d);
	}
	public void printBookings (){
		for (Map.Entry<LocalDate, BookingEntry> entry :bookingsMade.entrySet()){
			LocalDate date = (LocalDate) entry.getKey();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			BookingEntry b = (BookingEntry) entry.getValue();
			System.out.print(formatter.format(date) + ": ");
			b.BookingEntryPrint();
		}
		System.out.println();
	}
	

}
