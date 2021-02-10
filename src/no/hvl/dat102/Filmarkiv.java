package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmTabell;
	private int antall;
	
	public Filmarkiv() {
		filmTabell = new Film[10];
	}
	
	public Filmarkiv(int i) {
		filmTabell = new Film[i];
	}

	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall() == filmTabell.length) {
			utvidKapasitet();
		}
		filmTabell[antall++] = nyFilm;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		int temp_antall = antall;
		boolean b = false;
		
		for(int i = 0; i < temp_antall; i++) {
			if(filmTabell[i].getFilmnr() == filmnr) {
				filmTabell[i] = filmTabell[antall - 1];
				antall = antall - 1;
				b = true;
			}
		}
		
		filmTabell = trimTab(filmTabell, antall);
		return b;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tempTable = new Film[filmTabell.length];
		
		delstreng = delstreng.toUpperCase();
		int i = 0;
		
		for(Film film : filmTabell) {
			if(film != null) {
				String title = film.getTitle().toUpperCase();
				if(title.contains(delstreng)) {
					tempTable[i++] = film;
				}
			}
		}
		return tempTable;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tempTable = new Film[filmTabell.length];
		
		delstreng = delstreng.toUpperCase();
		int i = 0;
		
		for(Film film : filmTabell) {
			if(film != null) {
				String producer = film.getProducer().toUpperCase();
				if(producer.contains(delstreng)) {
					tempTable[i++] = film;
				}
			}
		}
		return tempTable;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int i = 0;
		for(Film film : filmTabell) {
			if(film != null && film.getGenre() == sjanger) {
				i++;
			}
		}
		return i;
	}

	@Override
	public int antall() {
		return this.antall;
	}
	
	private void utvidKapasitet() {
		Film[] hjelpetabell = new Film[(int)Math.ceil(1.1 * filmTabell.length)];
		for (int i = 0; i < filmTabell.length; i++){
			hjelpetabell[i] = filmTabell[i];
		}
		filmTabell = hjelpetabell;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;
		}
		
		return filmtab2;
	}
}
