package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall; 
	private LinearNode<Film> start;

	@Override
	public Film[] hentFilmTabell() {
		Film[] temp_table = new Film[antall];
		LinearNode<Film> temp_node = start;
		
		for(int i = 0; i < antall; i++) {
			temp_table[i] = temp_node.getElement();
			temp_node = temp_node.getNeste();
		}
		
		return temp_table;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> temp_node = start;
		
		while(temp_node.getNeste() != null) {
			temp_node = temp_node.getNeste();
		}
		
		LinearNode<Film> next = new LinearNode<Film>(nyFilm);
		temp_node.setNeste(next);
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> temp_node = start;
		
		while(temp_node.getNeste() != null) {
			if(temp_node.getElement().getFilmnr() == filmnr) {
				temp_node.setNeste(temp_node.getNeste().getNeste());
				antall = antall - 1;
			}
			temp_node = temp_node.getNeste();
		}
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] temp_table = new Film[antall];
		LinearNode<Film> temp_node = start;
		
		for(int i = 0; i < antall; i++) {
			String temp_title = temp_node.getElement().getTitle().toUpperCase();
			if(temp_title.contains(delstreng.toUpperCase())) {
				temp_table[i] = temp_node.getElement();
			}
			temp_node = temp_node.getNeste();
		}
		
		return temp_table;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] temp_table = new Film[antall];
		LinearNode<Film> temp_node = start;
		
		for(int i = 0; i < antall; i++) {
			String temp_title = temp_node.getElement().getProducer().toUpperCase();
			if(temp_title.contains(delstreng.toUpperCase())) {
				temp_table[i] = temp_node.getElement();
			}
			temp_node = temp_node.getNeste();
		}
		
		return temp_table;
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> temp_node = start;
		int antall = 0;
		
		while(temp_node != null) {
			if(temp_node.getElement() != null && temp_node.getElement().getGenre() == sjanger) {
				antall++;
			}
			temp_node = temp_node.getNeste();
		}
		
		return antall;
	}

	@Override
	public int antall() {
		LinearNode<Film> temp_node = start;
		int antall = 0;
		
		while(temp_node != null) {
			antall++;
		}
		
		return antall;
	}

}
