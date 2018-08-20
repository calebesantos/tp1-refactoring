package br.edu.infnet.edc.calebesantos.tp1.models.price;

import br.edu.infnet.edc.calebesantos.tp1.models.Movie;

public class RegularPrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	public double calculateAmount(int daysRented) {
		double result = 2;

		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;

		return result;
	}

}
