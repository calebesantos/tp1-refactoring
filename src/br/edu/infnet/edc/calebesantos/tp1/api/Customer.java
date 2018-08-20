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
		return new TextStatement().generate(this);
	}
	
	public String htmlStatement() {
		return new HtmlStatement().generate(this);
	}

	public int getFrequentRenterPoints() {
		return getRentalsStream().mapToInt(r -> r.calculateFrequentRenterPoints()).sum();
	}

	public double getTotalAmount() {
		return getRentalsStream().mapToDouble(r -> r.calculateAmount()).sum();
	}
	
	public Enumeration<Rental> getEnumerationRentals() {
		return _rentals.elements();
	}

	private Stream<Rental> getRentalsStream() {
		return _rentals.stream();
	}
}
