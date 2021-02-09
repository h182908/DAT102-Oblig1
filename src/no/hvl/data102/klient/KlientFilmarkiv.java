package no.hvl.data102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Meny;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv {
	public static void main(String[] args) {
		FilmarkivADT filmarkiv = new Filmarkiv();
		Meny meny = new Meny(filmarkiv);
		
		meny.start();
	}
}
