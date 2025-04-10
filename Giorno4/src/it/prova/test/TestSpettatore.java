package it.prova.test;

import it.prova.model.*;

public class TestSpettatore {
    public static void main(String[] args) {

        Spettatore me = new Spettatore("Matteo", "Rossi", "1234567890123456", new Biglietto("Il grande spettacolo", 'A', 5, 50.0f));

        Spettatore[] elencoSpettatori = {
                new Spettatore("Marco", "Travaglio", "1234567890123456", new Biglietto("Il grande spettacolo", 'A', 1, 51.0f)),
                new Spettatore("Giovanni", "Verdi", "1234567890123456", new Biglietto("Il grande spettacolo", 'A', 2, 52.0f)),
                new Spettatore("Luca", "Bianchi", "1234567890123456", new Biglietto("Il grande spettacolo", 'A', 3, 53.0f)),
                new Spettatore("Alessandro", "Neri", "1234567890123456", new Biglietto("Il grande spettacolo", 'A', 4, 54.0f)),
                new Spettatore("Francesco", "Gialli", "1234567890123456", new Biglietto("Il grande spettacolo", 'A', 5, 55.0f)),
        };

        System.out.println("TEST incassoDeiPagantiNellaMiaFila.........................START");
        System.out.println("questo e' l'incasso dei paganti nella mia fila: " + me.incassoDeiPagantiNellaMiaFila(elencoSpettatori) + " euro");
        System.out.println("TEST incassoDeiPagantiNellaMiaFila.........................END\n");

        System.out.println("TEST numeroSpettatoriDelMioStessoSpettacolo.........................START");
        System.out.println("questo e' il numero di spettatori del mio stesso spettacolo: " + me.numeroSpettatoriDelMioStessoSpettacolo(elencoSpettatori));
        System.out.println("TEST numeroSpettatoriDelMioStessoSpettacolo.........................END\n");

        System.out.println("TEST numeroSpettatoriMioSpettacoloSuperaAspettativa.........................START");
        System.out.println("Il numero di spettatori del mio stesso spettacolo super l'aspettativa di 6? : " + me.numeroSpettatoriMioSpettacoloSuperaAspettativa(elencoSpettatori, 6));
        System.out.println("TEST numeroSpettatoriMioSpettacoloSuperaAspettativa.........................END\n");

        Biglietto mioBiglietto = me.getBiglietto();
        Biglietto[] biglietti = {
                new Biglietto("Il grande spettacolo", 'A', 1, 51.0f),
                new Biglietto("Il grande spettacolo", 'A', 2, 5.0f),
                new Biglietto("Il grande spettacolo", 'A', 3, 468.0f),
                new Biglietto("Il grande spettacolo", 'A', 4, 127.0f),
        };

        System.out.println("TEST trovaIlPiuEconomico........................START");
        System.out.println("Il biglietto piu' economico e': " + Biglietto.trovaIlPiuEconomico(biglietti));
        System.out.println("TEST trovaIlPiuEconomico.........................END\n");


        System.out.println("TEST bigliettoAncoraInvenduto........................START");
        System.out.println("Il biglietto e' ancora invenduto? " + mioBiglietto.bigliettoAncoraInvenduto(biglietti));
        System.out.println("TEST bigliettoAncoraInvenduto.........................END\n");


    }
}
