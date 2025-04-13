package it.esercizipercasa.test;
import it.esercizipercasa.model.*;

public class TestBiblioteca {
    public static void main(String[] args) {

        MaterialeBiblioteca libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", "1234567890", 1000, "Fantasy");
        MaterialeBiblioteca libro2 = new Libro("Il Codice Da Vinci", "Dan Brown", "0987654321", 500, "Thriller");
        MaterialeBiblioteca dvd1 = new DVD("Inception", "Christopher Nolan", "1122334455", 148);
        MaterialeBiblioteca rivista1 = new Rivista("National Geographic", "National Geographic Society", "2233445566", 1, 2023);
        MaterialeBiblioteca rivista2 = new Rivista("Time", "Time Inc.", "3344556677", 2, 2023);
        MaterialeBiblioteca[] materiali = {libro1, libro2, dvd1, rivista1, rivista2};

        Biblioteca biblioteca = new Biblioteca(materiali);

        System.out.println(biblioteca);
        MaterialeBiblioteca libro3 = new Libro("Harry Potter e la Pietra Filosofale", "J.K. Rowling", "4455667788", 300, "Fantasy");
        biblioteca.aggiungiMateriale(libro3);
        System.out.println(biblioteca);

        Biblioteca bibliotecaPerCerca = biblioteca.cercaMaterialePerTitolo("time");
        System.out.println("Cerco \"time\":");
        System.out.println(bibliotecaPerCerca);


        biblioteca.getMateriali()[0].prestito();
        biblioteca.getMateriali()[3].prestito();
        biblioteca.getMateriali()[4].prestito();

        Biblioteca materialiDisponibili = biblioteca.elencaMaterialiDisponibili();
        System.out.println("Materiali disponibili:");
        System.out.println(materialiDisponibili);


        Biblioteca materialiInPrestito = biblioteca.elencaMaterialiInPrestito();
        System.out.println("Materiali in prestito:");
        System.out.println(materialiInPrestito);
        

    }
}
