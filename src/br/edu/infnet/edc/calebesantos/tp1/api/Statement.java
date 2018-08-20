package br.edu.infnet.edc.calebesantos.tp1.api;

import java.util.Enumeration;

import br.edu.infnet.edc.calebesantos.tp1.models.Rental;

public abstract class Statement {

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
	
	protected abstract String generateHeader(Customer customer);
	protected abstract String generateFigureForRental(Rental each);
	protected abstract String generateFooter(double totalAmount, int frequentRenterPoints);
}
