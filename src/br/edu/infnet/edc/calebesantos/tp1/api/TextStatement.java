package br.edu.infnet.edc.calebesantos.tp1.api;

import br.edu.infnet.edc.calebesantos.tp1.models.Rental;

public class TextStatement extends Statement {
	protected String generateHeader(Customer customer) {
		return "Rental Record for " + customer.getName() + "\n";
	}

	protected String generateFigureForRental(Rental each) {
		return "\t" + each.getMovie().getTitle() + "\t" + each.calculateAmount() + "\n";
	}

	protected String generateFooter(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned "
				+ String.valueOf(frequentRenterPoints) + " frequent renter points";
	}
}
