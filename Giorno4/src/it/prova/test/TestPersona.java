package it.prova.test;
import it.prova.model.*;

public class TestPersona {
    public static void main(String[] args) {
        Indirizzo indirizzo = new Indirizzo("Via Mosca", "52", "Roma");

        Persona me = new Persona("Matteo", "Castobaldo", 21, indirizzo);

        System.out.println(me);

        Persona[] elenco = {
                new Persona("Luca", "Bianchi", 25, new Indirizzo("Via Milano", "10", "Milano")),
                new Persona("Giulia", "Verdi", 40, new Indirizzo("Via Napoli", "15", "Napoli")),
                new Persona("Marco", "Neri", 35, new Indirizzo("Via Torino", "20", "Torino")),
                new Persona("Anna", "Rossi", 28, new Indirizzo("Via Firenze", "5", "Firenze")),
                new Persona("Paolo", "Gialli", 50, new Indirizzo("Via Venezia", "8", "Venezia")),
                new Persona("Sara", "Blu", 22, new Indirizzo("Via Genova", "12", "Genova")),
                new Persona("Elena", "Marrone", 45, new Indirizzo("Via Bologna", "18", "Bologna")),
                new Persona("Davide", "Viola", 33, new Indirizzo("Via Bari", "25", "Bari"))
        };


        System.out.println("TEST abitaA.........................START");
        System.out.println("io abito a roma? " + me.abitaA("roma"));
        System.out.println("TEST abitaA.........................END\n");

        System.out.println("TEST haAlmenoUnConcittadino.........START");
        System.out.println("io ho almeno un concittadino? " + me.haAlmenoUnConcittadino(elenco));
        System.out.println("TEST haAlmenoUnConcittadino.........START\n");

        System.out.println("TEST sonoTuttiPiuAnziani............START");
        System.out.println("sono tutti piu anziani di me? " + me.sonoTuttiPiuAnziani(elenco));
        System.out.println("TEST sonoTuttiPiuAnziani............END");


        System.out.println("TEST quantiCoabitanoNelMioStessoPalazzo............START");
        System.out.printf("Ci sono %d persone che abitano nel mio stesso palazzo%n", me.quantiCoabitanoNelMioStessoPalazzo(elenco));
        System.out.println("TEST quantiCoabitanoNelMioStessoPalazzo............END");


        System.out.println("TEST nuovoCoinquilino............START");
        Persona nuovoC = new Persona("Marco", "detto er caciotta", 23345);
        me.nuovoCoinquilino(nuovoC);
        System.out.printf("io abito a %s e adesso anche il mio coinquilino %s", me.getIndirizzo(), nuovoC);
        System.out.println("TEST nuovoCoinquilino............END");

    }
}
