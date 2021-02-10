package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;
import java.util.Scanner;

public class Tekstgrensesnitt {
	
	public Film lesFilm(Scanner reader) {
		System.out.println("Skriv inn filmnr: ");
	    int filmnr = Integer.parseInt(reader.nextLine());
	    
		System.out.println("Skriv inn filmprodusent: ");
	    String producer = reader.nextLine();
	    
	    System.out.println("Skriv inn tittel: ");
	    String title = reader.nextLine();
	    
	    System.out.println("Skriv inn år: ");
	    int year = Integer.parseInt(reader.nextLine());
	    
	    System.out.println("Skriv inn sjanger (ACTION, DRAMA, HISTORY, SCIFI): ");
	    Sjanger genre = Sjanger.finnSjanger(reader.nextLine());
	    
	    System.out.println("Skriv inn filmselskap: ");
	    String company = reader.nextLine();
	    
	    Film tempFilm = new Film(filmnr, producer, title, year, genre, company);
	    
		return tempFilm;
	}
	
	public void visFilm(Film film) {
		if(film != null) {
			System.out.println("===============================");
			System.out.println(String.format("%-10s:%20s", "Number", film.getFilmnr()));
			System.out.println(String.format("%-10s:%20s", "Producer", film.getProducer()));
			System.out.println(String.format("%-10s:%20s", "Title", film.getTitle()));
			System.out.println(String.format("%-10s:%20s", "Year", film.getYear()));
			System.out.println(String.format("%-10s:%20s", "Genre", film.getGenre()));
			System.out.println(String.format("%-10s:%20s", "Company", film.getCompany()));
		}
	}
	
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		for(Film film : filma.soekTittel(delstreng)) {
			visFilm(film);
		}
	}
	 
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) { 
		for(Film film : filma.soekProdusent(delstreng)) {
			visFilm(film);
		}
	} 
	 
	public void skrivUtStatistikk(FilmarkivADT filma){
		System.out.println("Totalt antall filmer i arkivet: " + filma.antall());
		for(Sjanger genre : Sjanger.values()) {
			System.out.println(genre.toString() + ": " + filma.antall(genre));
		}
	}
}
