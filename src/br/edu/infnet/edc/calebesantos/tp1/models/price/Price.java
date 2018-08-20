package br.edu.infnet.edc.calebesantos.tp1.models.price;

public abstract class Price {
	public abstract int getPriceCode();

	public abstract double calculateAmount(int daysRented);
}
