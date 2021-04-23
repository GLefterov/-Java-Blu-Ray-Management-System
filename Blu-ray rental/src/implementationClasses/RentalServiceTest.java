package implementationClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objectClasses.BluRay;
import objectClasses.Customer;

public class RentalServiceTest {

	static ArrayList<BluRay> bluRays;
	static ArrayList<Customer> customers;
	static ArrayList<BluRay> rentals;
	static ArrayList<BluRay> rentals1;
	static ArrayList<BluRay> rentals5;
	static ArrayList<BluRay> rentals6;
	static Customer kevin;
	static Customer emily;
	static Customer angus;
	static Customer georgi;
	static Customer simon;
	static Customer julia;
	static BluRay saw;
	static BluRay jaws;
	static BluRay madMax;
	static BluRay potato;

	@Before
	public void beforeClass() {

		bluRays = new ArrayList<BluRay>();
		customers = new ArrayList<Customer>();
		rentals = new ArrayList<BluRay>();
		rentals1 = new ArrayList<BluRay>();
		rentals6 = new ArrayList<BluRay>();
		julia = new Customer("Julia Sw.", LocalDate.of(2000, 10, 03), "Poland", 4, rentals);
		angus = new Customer("Angus", LocalDate.of(1999, 11, 04), "his mums house", 8, rentals6);
		emily = new Customer("Georgi.", LocalDate.of(1997, 10, 03), "Scotland", 5, rentals1);
		potato = new BluRay(6, 800, "Potato", "George Miller", 2007, 12);
		madMax = new BluRay(1, 100, "Mad Max", "George Miller", 2007, 12);
		saw = new BluRay(7, 900, "Saw", "Saw director", 2018, 18);
		jaws = new BluRay(3, 200, "Jaws", "jaws director", 2003, 15);

		bluRays.add(potato);
		bluRays.add(saw);
		bluRays.add(jaws);
		bluRays.add(madMax);

	}

	@Test
	public void testGetQuantity() {

		assertEquals(1, RentalService.getQuantity(bluRays, jaws));
	}

	@Test
	public void testGetQuantityNeg() {

		assertFalse(2 == RentalService.getQuantity(bluRays, jaws));
	}

	@Test
	public void testGetOverdue() {

		RentalService.rentIt(julia, jaws);
		RentalService.rentIt(angus, madMax);
		assertSame(RentalService.getOverdue(bluRays).size(), 0);
	}

	@Test
	public void testGetOverdueNeg() {

		RentalService.rentIt(angus, madMax);
		RentalService.rentIt(julia, jaws);

		assertFalse(RentalService.getOverdue(bluRays).size() == 1);
	}

	@Test
	public void testRentIt() {

		RentalService.rentIt(emily, madMax);

		assertTrue(madMax.isRented());
	}

	@Test
	public void testRentItNeg() {

		RentalService.rentIt(angus, saw);

		assertFalse(potato.isRented());
	}

	@Test
	public void testReturnIt() {

		RentalService.rentIt(emily, madMax);
		RentalService.returnIt(emily, madMax);

		assertTrue(!madMax.isRented());
	}

	@Test
	public void testReturnItNeg() {

		RentalService.rentIt(emily, madMax);

		assertTrue(RentalService.returnIt(emily, potato).equals("We cannot currently return that movie"));

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
		emily = null;
		angus = null;
		georgi = null;
		simon = null;
		julia = null;
		saw = null;
		jaws = null;
		madMax = null;
		potato = null;
	}
}
