package no.hvl.dat102;

public class Film {
	private int filmnr;
	private String producer;
	private String title;
	private int year;
	private Sjanger genre;
	private String company;
	
	public Film() {
		
	}
	
	public Film(int filmnr, String producer, String title, int year, Sjanger genre, String company) {
		this.setFilmnr(filmnr);
		this.setProducer(producer);
		this.setTitle(title);
		this.setYear(year);
		this.setGenre(genre);
		this.setCompany(company);
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Sjanger getGenre() {
		return genre;
	}

	public void setGenre(Sjanger genre) {
		this.genre = genre;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
