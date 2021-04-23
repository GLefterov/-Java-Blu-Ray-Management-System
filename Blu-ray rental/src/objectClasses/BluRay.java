package objectClasses;

import java.time.LocalDate;

/**
 * BluRay objects with assigned Customer.
 *
 * @author codeThatCompiles
 *
 */
public class BluRay {

	private int copyID;
	private int titleID;
	private int yearPublished;
	private boolean isRented = false;
	private int movieRating;
	private String title;
	private String director;
	private Customer customer;
	private LocalDate dateDue;

	/**
	 * Creates a BluRay object with its essential bibliographical data and IDs
	 * necessary for identification within the system.
	 *
	 * @param copyID        ID of the BluRay object
	 * @param titleID       ID of the title
	 * @param title         title of the film
	 * @param director      director of the film
	 * @param yearPublished year of film release
	 * @param movieRating   age rating of the film
	 */
	public BluRay(int copyID, int titleID, String title, String director, int yearPublished, int movieRating) {

		super();
		this.copyID = copyID;
		this.titleID = titleID;
		this.title = title;
		this.director = director;
		this.yearPublished = yearPublished;
		this.movieRating = movieRating;
	}

	/**
	 * Age rating of the film.
	 *
	 * @return movieRating
	 */
	public int getMovieRating() {
		return movieRating;
	}

	/**
	 * Returns true if the copy if currently rented by a Customer.
	 *
	 * @return isRented
	 */
	public boolean isRented() {
		return isRented;
	}

	/**
	 * Customer who rented the copy.
	 *
	 * @return Customer object
	 */
	public Customer getCustomer() {

		return customer;
	}

	/**
	 * Date that the copy is due back.
	 *
	 * @return dateDue
	 */
	public LocalDate getDateDue() {

		if (isRented) {
			return dateDue;

		} else {
			return null;
		}
	}

	/**
	 * ID of the copy of the film.
	 *
	 * @return copyID
	 */
	public int getCopyID() {
		return copyID;
	}

	/**
	 * ID of the title.
	 *
	 * @return titleID
	 */
	public int getTitleID() {
		return titleID;
	}

	/**
	 * Title of the film.
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Director of the film.
	 *
	 * @return director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Year of the film release.
	 *
	 * @return yearPublished
	 */
	public int getYearPublished() {
		return yearPublished;
	}

	/**
	 * Sets the isRented property to the boolean taken as a parameter.
	 *
	 * @param isRented true if the film is currently rented
	 */
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	/**
	 * Sets the customer to the Customer object taken as a parameter.
	 *
	 * @param customer Customer object who rents the copy
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Sets the date that the copy is due back.
	 *
	 * @param dateDue date that the film is due back
	 */
	public void setDateDue(LocalDate dateDue) {
		this.dateDue = dateDue;
	}

	@Override
	public String toString() {
		return "BluRay [copyID=" + copyID + ", titleID=" + titleID + ", title=" + title + ", director=" + director
				+ ", yearPublished=" + yearPublished + ", isRented=" + isRented + ", movieRating=" + movieRating
				+ ", customer=" + customer + ", dateDue=" + dateDue + "]";
	}

}
