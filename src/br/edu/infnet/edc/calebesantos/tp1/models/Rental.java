package br.edu.infnet.edc.calebesantos.tp1.models;

public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}
	
	public int calculateFrequentRenterPoints() {
		return _movie.calculateFrequentRenterPoints(_daysRented);
	}

	public double calculateAmount() {
		return _movie.calculateAmount(_daysRented);
	}
}
