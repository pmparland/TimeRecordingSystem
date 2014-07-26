package model;


import org.junit.Test;

public class PersonTest {



	@Test
	public void testPrintAssignments() {
		Person P = new Person ("Joe",true, "Initial");
		P.assignProject("Important");
		P.assignProject("Very Important");
		P.PrintPerson();
	}

}
