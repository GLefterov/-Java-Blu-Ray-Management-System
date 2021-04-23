package objectClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import implementationClasses.RentalService;

public class BluRayTest {

	static ArrayList<BluRay> bluRays;
	static ArrayList<Customer> customers;
	static ArrayList<BluRay> rentals1;
	static ArrayList<BluRay> rentals5;
	static Customer angus;
	static Customer emily;
	static Customer georgi;
	static BluRay saw;
	static BluRay jaws;

	@Before
	public void beforeClass() {

		bluRays = new ArrayList<BluRay>();
		customers = new ArrayList<Customer>();
		rentals1 = new ArrayList<BluRay>();
		rentals5 = new ArrayList<BluRay>();
		georgi = new Customer("Georgi.", LocalDate.of(1999, 10, 03), "Bulgaria", 5, rentals1);
		angus = new Customer("Angus", LocalDate.of(1999, 11, 04), "his mums house", 8, rentals5);
		saw = new BluRay(7, 900, "Saw", "Saw director", 2018, 18);
		jaws = new BluRay(3, 200, "Jaws", "jaws director", 2003, 15);
		bluRays.add(saw);
		bluRays.add(jaws);
		customers.add(georgi);
		customers.add(angus);

	}

	@Test
	public final void testBluRayConstructor() {

		assertEquals(15, jaws.getMovieRating());
	}

	@Test
	public void testBluRayNegativeConstructor() {

		assertFalse(saw.getTitleID() == 200);
	}

	@Test
	public final void testGetDateDue() {

		RentalService.rentIt(angus, saw);

		assertTrue(saw.getDateDue() != LocalDate.now().plusMonths(1));
	}

	@Test
	public final void testGetDateDueNeg() {

		RentalService.rentIt(georgi, jaws);

		assertFalse(jaws.getDateDue() == LocalDate.now());
	}

	@After
	public void tearDown() {

		bluRays = null;
		customers = null;
		rentals1 = null;
		rentals5 = null;
		angus = null;
		emily = null;
		georgi = null;
		saw = null;
		jaws = null;

	}
}
