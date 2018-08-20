package br.edu.infnet.edc.calebesantos.tp1.api;

import java.util.Enumeration;
import java.util.Vector;
import java.util.stream.Stream;

import br.edu.infnet.edc.calebesantos.tp1.models.Rental;

public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = getTotalAmount();
		int frequentRenterPoints = getFrequentRenterPoints();
		Enumeration<Rental> rentals = _rentals.elements();

		String result = generateHeader();

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			// add frequent renter points
			frequentRenterPoints += each.calculateFrequentRenterPoints();

			// show figures for this rental
			result = generateFigureForRental(each);
		}

		// add footer lines
		result = generateFooter(totalAmount, frequentRenterPoints);

		return result;
	}

	private int getFrequentRenterPoints() {
		return getRentalsStream().mapToInt(r -> r.calculateFrequentRenterPoints()).sum();
	}

	private double getTotalAmount() {
		return getRentalsStream().mapToDouble(r -> r.calculateAmount()).sum();
	}

	private Stream<Rental> getRentalsStream() {
		return _rentals.stream();
	}

	private String generateHeader() {
		String result = "Rental Record for " + getName() + "\n";
		return result;
	}

	private String generateFigureForRental(Rental each) {
		return "\t" + each.getMovie().getTitle() + "\t" + each.calculateAmount() + "\n";
	}

	private String generateFooter(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned "
				+ String.valueOf(frequentRenterPoints) + " frequent renter points";
	}
}
