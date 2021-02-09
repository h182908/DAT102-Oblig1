package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.adt.FilmarkivADT;

public class Fil {
	final static String DELIMITER = "#";
	
	public static FilmarkivADT lesFraFil(String filnavn) {
		FilmarkivADT filmarkiv = null;
		
		FileReader reader = null;
		BufferedReader file = null;
		
		try{
	        // // 1 - FileReader
	       reader = new FileReader(filnavn);
	    } catch(FileNotFoundException unntak){
	        System.out.println("Finner ikke filen " + filnavn);
	        System.exit(1);
	    }
        try {          
            // 2 - BufferedReader
            file = new BufferedReader(reader);
            
            // 3 - Leser den første posten som er antall info-poster
            String linje = file.readLine();
            int n = Integer.parseInt(linje);
            filmarkiv = new Filmarkiv(n);
            
            // 4 - Les postene, en hel post om gangen
            String post = file.readLine();
            for (int i = 0; i < n; i++) {
                String[] felt = post.split(DELIMITER);
                // http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String, int)
                
                int filmnr 		= Integer.parseInt(felt[0]);
                String producer = felt[1];
                String title	= felt[2];
                int year		= Integer.parseInt(felt[3]);
                Sjanger genre	= Sjanger.finnSjanger(felt[4]);
                String company	= felt[5];
                
                Film film = new Film(filmnr, producer, title, year, genre, company);
                filmarkiv.leggTilFilm(film);
                
                post = file.readLine();
            }
            
            // 4 - Lukk filen
            file.close();
        } catch (IOException e) {
            System.out.println("Feil ved lesing av fil: " + e);
            System.exit(2);
        }
        
		return filmarkiv;
	}
	
	public static void skrivTilFil(FilmarkivADT filmarkiv, String filnavn){ 
		try {
			 // 1 - FileWriter
            FileWriter fwriter = new FileWriter(filnavn, false);
            
            // 2 - PrintWriter
            PrintWriter pwriter = new PrintWriter(fwriter);
            
            pwriter.print(filmarkiv.antall());
            pwriter.println();
            
            for(Film film : filmarkiv.hentFilmTabell()) {
            	if(film != null) {
	            	String output = film.getFilmnr()
	            			+ DELIMITER
	            			+ film.getProducer()
	            			+ DELIMITER
	            			+ film.getTitle()
	            			+ DELIMITER
	            			+ film.getYear()
	            			+ DELIMITER
	            			+ film.getGenre()
	            			+ DELIMITER
	            			+ film.getCompany();
	            	
	            	pwriter.print(output);
	            	pwriter.println();
            	}
            }
            
        	pwriter.close();
		} catch (IOException e) {
            System.out.println("Feil ved skriving til fil : " + e);
            System.exit(3);
        }
	}
}
