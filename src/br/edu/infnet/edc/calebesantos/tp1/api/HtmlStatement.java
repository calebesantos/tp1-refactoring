package br.edu.infnet.edc.calebesantos.tp1.api;

import br.edu.infnet.edc.calebesantos.tp1.models.Rental;

public class HtmlStatement extends Statement {
	protected String generateHeader(Customer customer) {
		return "<h1>Rental Record for <em>" + customer.getName() + "</em></h1><p>\n";
	}

	protected String generateFigureForRental(Rental each) {
		return "\t" + each.getMovie().getTitle() + "\t" + each.calculateAmount() + "<br>\n";
	}

	protected String generateFooter(double totalAmount, int frequentRenterPoints) {
		return "<p>Amount owed is <em>" + String.valueOf(totalAmount) + "</em><p>\n"
				+ "You earned <em>" + String.valueOf(frequentRenterPoints) + "</em> frequent renter points<p>";
	}
}
