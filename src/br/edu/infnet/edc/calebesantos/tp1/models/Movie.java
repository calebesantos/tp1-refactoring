package br.edu.infnet.edc.calebesantos.tp1.models;

import br.edu.infnet.edc.calebesantos.tp1.models.price.ChildrensPrice;
import br.edu.infnet.edc.calebesantos.tp1.models.price.NewReleasePrice;
import br.edu.infnet.edc.calebesantos.tp1.models.price.Price;
import br.edu.infnet.edc.calebesantos.tp1.models.price.RegularPrice;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case Movie.REGULAR:
			_price = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		case Movie.CHILDRENS:
			_price = new ChildrensPrice();
			break;
		}
	}

	public String getTitle() {
		return _title;
	}

	public int calculateFrequentRenterPoints(int daysRented) {
		return (getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1 ? 2 : 1;
	}

	public double calculateAmount(int daysRented) {
		return _price.calculateAmount(daysRented);
	}
}
