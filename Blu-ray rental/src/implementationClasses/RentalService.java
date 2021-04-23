package implementationClasses;

import java.time.LocalDate;
import java.util.ArrayList;

import objectClasses.BluRay;
import objectClasses.Customer;

public class RentalService {

	private static int quantity;

	/**
	 * Number of copies of the same title.
	 *
	 * @param dvds ArrayList of BluRays
	 * @param film a BluRay object used as the reference to find other copies of it
	 * @return quantity of copies of the film
	 */
	public static int getQuantity(ArrayList<BluRay> dvds, BluRay film) {

		quantity = 0;

		for (BluRay disk : dvds) {
			if (disk.getTitleID() == (film.getTitleID())) {
				quantity++;
			}
		}
		return quantity;
	}

	/**
	 * List of overdue BluRays.
	 *
	 * @param dvds ArrayList of all BluRay objects
	 * @return overdue
	 */
	public static ArrayList<BluRay> getOverdue(ArrayList<BluRay> dvds) {

		ArrayList<BluRay> overdue = new ArrayList<>();

		for (BluRay bluray : dvds) {

			if (bluray.getDateDue() == LocalDate.now().plusDays(1)) {
				overdue.add(bluray);
			}
		}
		return overdue;
	}

	/**
	 * Allows for the specified BluRay object to be rented by the chosen customer.
	 *
	 * @param customer Customer object that will store the BluRay object in its
	 *                 rentals
	 * @param film     BluRay object that will now become rented
	 * @return a message indicating the rent as successful or not
	 */
	public static String rentIt(Customer customer, BluRay film) {

		if (customer.findAge() > film.getMovieRating() && customer.getRented().size() < 3) {
			film.setRented(true);
			film.setDateDue(LocalDate.now().plusMonths(1));
			customer.getRented().add(film);
			return ("Thank you for renting this movie : " + film.getTitle() + " , it is due back on the : "
					+ film.getDateDue() + " !");

		} else {
			return "this movie cannot be rented";
		}
	}

	/**
	 * Return a BluRay.
	 *
	 * @param film BluRay to be returned
	 * @return a message stating if the return was successful or not
	 */
	public static String returnIt(Customer customer, BluRay film) {

		String message;
		String a = "We cannot currently return that movie";
		String b = "Thank you for returning " + film.getTitle() + " !";

		if (film.isRented()) {

			customer.getRented().remove(film);
			film.setRented(false);
			film.setDateDue(null);
			message = b;

		} else {
			message = a;
		}

		return message;
	}
}
