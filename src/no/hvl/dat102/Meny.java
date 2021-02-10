package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.FilmarkivADT;
import no.hvl.dat102.klient.Tekstgrensesnitt;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filma;
	
	public Meny(FilmarkivADT filma){
		tekstgr = new Tekstgrensesnitt();
		this.filma = filma;
	}

	public void start(){
		Boolean b = true;
		Scanner reader = new Scanner(System.in);
		
		options();
		
		while(b) {
			System.out.println("Skriv inn alternativet: ");
		    int input = Integer.parseInt(reader.nextLine());
		    
		    String case_input;
		    
		    switch(input) {
		    	case 1:
		    		System.out.println("Skriv inn navnet på filen: ");
		    		case_input = reader.nextLine();
		    		filma = Fil.lesFraFil(case_input);
		    		break;
		    	case 2:
		    		System.out.println("Skriv inn navnet på filen: ");
		    		case_input = reader.nextLine();
		    		Fil.skrivTilFil(filma, case_input);
		    		break;
		    	case 3:
		    		System.out.println("Skriv inn tittel: ");
		    		case_input = reader.nextLine();
		    		tekstgr.skrivUtFilmDelstrengITittel(filma, case_input);
		    		break;
		    	case 4:
		    		System.out.println("Skriv inn produsent: ");
		    		case_input = reader.nextLine();
		    		tekstgr.skrivUtFilmProdusent(filma, case_input);
		    		break;
		    	case 5:
		    		tekstgr.skrivUtStatistikk(filma);
		    		break;
		    	case 6:
		    		filma.leggTilFilm(tekstgr.lesFilm(reader));
		    		break;
		    	case 7:
		    		System.out.println("Skriv inn filmnr for film du vil slette: ");
		    		case_input = reader.nextLine();
		    		filma.slettFilm(Integer.parseInt(case_input));
		    		break;
		    	case 8:
		    		b = false;
		    		break;
		    	case 9:
		    		options();
		    		break;
		    }
		}
		reader.close();
	}
	
	public void options() {
		System.out.println("1 for å laste inn et filmarkiv fra en fil.");
		System.out.println("2 for å lagre inn et filmarkiv til en fil.");
		System.out.println("3 for å søke etter tittel et filmarkiv.");
		System.out.println("4 for å søke etter produsent et filmarkiv.");
		System.out.println("5 for å skrive ut antall filmer i hver sjanger.");
		System.out.println("6 for å lese inn en film i arkivet.");
		System.out.println("7 for å avslutte programmet.");
		System.out.println("8 for å vise kommandoene igjen.");
	}
}

