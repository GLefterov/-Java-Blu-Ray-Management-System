package objectClasses;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * Customer objects with their rented films.
 *
 * @author codeThatCompiles
 *
 */
public class Customer {

	private String name;
	private LocalDate dateOfBirth;
	private String address;
	private ArrayList<BluRay> rentals;
	private int memberNumber;

	/**
	 * Creates a new Customer object with their name, member number, date of birth,
	 * address, and list of rentals taken as parameters.
	 *
	 * @param name         full name of the customer
	 * @param dateOfBirth  customer's date of birth
	 * @param address      customer's address
	 * @param memberNumber cusotmer's membership number
	 * @param rentals      list of the customer's rentals
	 */
	public Customer(String name, LocalDate dateOfBirth, String address, int memberNumber, ArrayList<BluRay> rentals) {

		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.rentals = rentals;
		this.address = address;
		this.memberNumber = memberNumber;
	}

	/**
	 * Returns the passed customer's age.
	 *
	 * @param customer chosen Customer object
	 * @return age of the customer
	 */
	public int findAge() {

		Period difference = Period.between(this.getDateOfBirth(), LocalDate.now());
		int years = difference.getYears();
		return years;
	}

	/**
	 * Sets the list of rentals to the list of films passed as a parameter.
	 *
	 * @param rentals ArrayList of BluRays rented
	 */
	public void setRented(ArrayList<BluRay> rentals) {
		this.rentals = rentals;
	}

	/**
	 * The name of the customer.
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Customer's date of birth.
	 *
	 * @return dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * The customer's address.
	 *
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Customer's membership number.
	 *
	 * @return memberNumber
	 */
	public int getMemberNumber() {
		return memberNumber;
	}

	/**
	 * List of films rented by the customer.
	 *
	 * @return rentals
	 */
	public ArrayList<BluRay> getRented() {
		return rentals;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", memberNumber="
				+ memberNumber + ", rented=" + rentals.size() + "]";
	}

}
