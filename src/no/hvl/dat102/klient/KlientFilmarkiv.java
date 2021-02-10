package no.hvl.dat102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Filmarkiv2;
import no.hvl.dat102.Meny;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmarkiv {
	public static void main(String[] args) {
		FilmarkivADT filmarkiv = new Filmarkiv2();
		Meny meny = new Meny(filmarkiv);
		
		meny.start();
	}
}
