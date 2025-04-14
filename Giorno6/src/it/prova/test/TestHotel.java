package it.prova.test;

import it.prova.model.hotel.*;

import java.util.Arrays;
import java.util.List;

public class TestHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hilton", 5);
        Stanza stanza101 = new Stanza(101, 25f, hotel);
        Stanza stanza102 = new Stanza(102, 25f, hotel);
        Stanza stanza103 = new Stanza(103, 25f, hotel);
        Stanza stanza104 = new Stanza(104, 50f, hotel);

        Cliente turista1 = new Turista("Leonardo", "da Vinci", stanza101);
        Cliente turista2 = new Turista("Michelangelo", "Buonarroti", stanza103);
        Cliente turista3 = new Turista("Raffaello", "Sanzio", stanza104);

        Cliente premio1 = new Premio("Donatello", "di Niccolò", stanza102);
        Cliente premio2 = new Premio("Caravaggio", "Merisi", stanza103);
        Cliente premio3 = new Premio("Giorgio", "Vasari", stanza101);

        Cliente rappresentante1 = new Rappresentante("Tiziano", "Vecellio", stanza103);
        Cliente rappresentante2 = new Rappresentante("Gian Lorenzo", "Bernini", stanza102);
        Cliente rappresentante3 = new Rappresentante("Amedeo", "Modigliani", stanza101);

        List<Cliente> clienti101 = Arrays.asList(turista1, premio3, rappresentante3);
        List<Cliente> clienti102 = Arrays.asList(premio1, rappresentante2);
        List<Cliente> clienti103 = Arrays.asList(turista2, premio2, rappresentante1);
        List<Cliente> clienti104 = Arrays.asList(turista3);

        List<Stanza> stanze = Arrays.asList(stanza101, stanza102, stanza103, stanza104);

        hotel.setStanze(stanze);

        stanza101.setClienti(clienti101);
        stanza102.setClienti(clienti102);
        stanza103.setClienti(clienti103);
        stanza104.setClienti(clienti104);


        System.out.println("\n\nstampo conto stanza 101");
        System.out.println(hotel.calcolaContoAndPrint(stanza101));

        System.out.println("\n\nstampo conto stanza 102");
        System.out.println(hotel.calcolaContoAndPrint(stanza102));

        System.out.println("\n\nstampo conto stanza 103");
        System.out.println(hotel.calcolaContoAndPrint(stanza103));

        System.out.println("\n\nstampo conto stanza 104");
        System.out.println(hotel.calcolaContoAndPrint(stanza104));


        System.out.println(hotel.calcolaConto(stanza101));
        System.out.println(hotel.calcolaConto(stanza102));
        System.out.println(hotel.calcolaConto(stanza103));
        System.out.println(hotel.calcolaConto(stanza104));




    }
}
