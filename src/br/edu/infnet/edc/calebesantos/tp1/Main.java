package br.edu.infnet.edc.calebesantos.tp1;

import br.edu.infnet.edc.calebesantos.tp1.api.Customer;
import br.edu.infnet.edc.calebesantos.tp1.models.Movie;
import br.edu.infnet.edc.calebesantos.tp1.models.Rental;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer("Calebe Santos");
		Movie movie1 = new Movie("Os incríveis", 2);
		Movie movie2 = new Movie("Os incríveis 2", 1);

		customer.addRental(new Rental(movie1, 3));
		customer.addRental(new Rental(movie2, 3));

		System.out.println(customer.statement());

		Customer customer2 = new Customer("Vicente");

		System.out.println(customer2.statement());
	}

}
