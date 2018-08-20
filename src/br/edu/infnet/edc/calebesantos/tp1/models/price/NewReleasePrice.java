package br.edu.infnet.edc.calebesantos.tp1.models.price;

import br.edu.infnet.edc.calebesantos.tp1.models.Movie;

public class NewReleasePrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override
	public double calculateAmount(int daysRented) {
		return daysRented * 3;
	}

}
