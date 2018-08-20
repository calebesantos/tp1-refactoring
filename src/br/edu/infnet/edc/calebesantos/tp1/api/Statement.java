package br.edu.infnet.edc.calebesantos.tp1.api;

import java.util.Enumeration;

import br.edu.infnet.edc.calebesantos.tp1.models.Rental;

public class Statement {

	public String generate(Customer customer) {
		double totalAmount = customer.getTotalAmount();
		int frequentRenterPoints = customer.getFrequentRenterPoints();
		Enumeration<Rental> rentals = customer.getEnumerationRentals();

		String result = generateHeader(customer);

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			frequentRenterPoints += each.calculateFrequentRenterPoints();

			result += generateFigureForRental(each);
		}

		result += generateFooter(totalAmount, frequentRenterPoints);

		return result;
	}

	private String generateHeader(Customer customer) {
		return "Rental Record for " + customer.getName() + "\n";
	}

	private String generateFigureForRental(Rental each) {
		return "\t" + each.getMovie().getTitle() + "\t" + each.calculateAmount() + "\n";
	}

	private String generateFooter(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned "
				+ String.valueOf(frequentRenterPoints) + " frequent renter points";
	}
}
