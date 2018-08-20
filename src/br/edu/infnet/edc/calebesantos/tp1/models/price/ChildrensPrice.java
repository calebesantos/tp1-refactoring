package br.edu.infnet.edc.calebesantos.tp1.models.price;

import br.edu.infnet.edc.calebesantos.tp1.models.Movie;

public class ChildrensPrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	public double calculateAmount(int daysRented) {
		double result = 1.5;

		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;

		return result;
	}

}
