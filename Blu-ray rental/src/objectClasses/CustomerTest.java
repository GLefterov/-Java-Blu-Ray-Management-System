package objectClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	static ArrayList<BluRay> bluRays;
	static ArrayList<Customer> customers;
	static ArrayList<BluRay> rentals;
	static ArrayList<BluRay> rentals1;
	static ArrayList<BluRay> rentals5;
	static ArrayList<BluRay> rentals6;
	static Customer kevin;
	static Customer angus;
	static Customer georgi;
	static Customer simon;
	static Customer julia;
	static BluRay saw;

	@Before
	public void beforeClass() {

		customers = new ArrayList<Customer>();
		bluRays = new ArrayList<BluRay>();
		rentals = new ArrayList<BluRay>();
		rentals1 = new ArrayList<BluRay>();
		rentals5 = new ArrayList<BluRay>();
		rentals6 = new ArrayList<BluRay>();

		georgi = new Customer("Georgi.", LocalDate.of(1999, 10, 03), "Bulgaria", 5, rentals1);
		julia = new Customer("Julia Sw.", LocalDate.of(2018, 10, 03), "Poland", 4, rentals);
		kevin = new Customer("Kevin.", LocalDate.of(1960, 10, 03), "Rosyth", 10, rentals6);
		simon = new Customer("Simon.", LocalDate.of(1980, 10, 03), "Haymarket", 9, rentals5);
		angus = new Customer("Angus", LocalDate.of(1999, 11, 04), "his mums house", 8, rentals6);

		saw = new BluRay(7, 900, "Saw", "Saw director", 2018, 18);

		bluRays.add(saw);

		customers.add(georgi);
		customers.add(kevin);
		customers.add(simon);
		customers.add(julia);
		customers.add(angus);

	}

	@Test
	public final void testCustomer() {

		assertEquals("Angus", angus.getName());
	}

	@Test
	public final void testCustomerNegative() {

		assertFalse(21 == kevin.getMemberNumber());
	}

	@Test
	public final void testFindAge() {

		assertEquals(21, georgi.findAge());
	}

	@Test
	public final void testFindAgeNegative() {

		assertFalse(21 == simon.findAge());
	}

	@After
	public void tearDown() {

		bluRays = null;
		customers = null;
		rentals = null;
		rentals1 = null;
		rentals5 = null;
		rentals6 = null;
		kevin = null;
		angus = null;
		georgi = null;
		simon = null;
		julia = null;
		saw = null;

	}

}
