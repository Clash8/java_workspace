package it.prova.test;

import it.prova.model.Destinatario;
import it.prova.model.PostaDiPaese;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static final List<PostaDiPaese> POSTA_DI_PAESE = new ArrayList<>();

    static {

        PostaDiPaese postaDiPaese1 = new PostaDiPaese("Posta Centrale", "Via Roma 1", LocalDate.of(1999, 1, 1), 51);
        Destinatario destinatario1 = new Destinatario("Mario", "Rossi", 30, "Via Roma 1", true, postaDiPaese1);
        Destinatario destinatario2 = new Destinatario("Luigi", "Verdi", 25, "Via Milano 2", false, postaDiPaese1);
        Destinatario destinatario3 = new Destinatario("Giovanni", "Bianchi", 40, "Via Napoli 3", true, postaDiPaese1);
        Destinatario destinatario4 = new Destinatario("Anna", "Neri", 35, "Via Torino 4", false, postaDiPaese1);

        postaDiPaese1.getDestinatari().add(destinatario1);
        postaDiPaese1.getDestinatari().add(destinatario2);
        postaDiPaese1.getDestinatari().add(destinatario3);
        postaDiPaese1.getDestinatari().add(destinatario4);

        PostaDiPaese postaDiPaese2 = new PostaDiPaese("Posta Secondaria", "Via Firenze 5", LocalDate.of(2005, 1, 1), 20);
        Destinatario destinatario5 = new Destinatario("Marco", "Gialli", 28, "Via Bologna 6", true, postaDiPaese2);
        Destinatario destinatario6 = new Destinatario("Sara", "Blu", 22, "Via Venezia 7", false, postaDiPaese2);
        Destinatario destinatario7 = new Destinatario("Francesco", "Verdi", 45, "Via Palermo 8", true, postaDiPaese2);
        Destinatario destinatario8 = new Destinatario("Laura", "Rosa", 32, "Via Genova 9", false, postaDiPaese2);

        postaDiPaese2.getDestinatari().add(destinatario5);
        postaDiPaese2.getDestinatari().add(destinatario6);
        postaDiPaese2.getDestinatari().add(destinatario7);
        postaDiPaese2.getDestinatari().add(destinatario8);

        PostaDiPaese postaDiPaese3 = new PostaDiPaese("Posta Tertiaria", "Via Roma 10 (MI)", LocalDate.of(2020, 1, 1), 8);
        Destinatario destinatario9 = new Destinatario("Alessandro", "Neri", 29, "Via Roma 11", false, postaDiPaese3);
        Destinatario destinatario10 = new Destinatario("Chiara", "Gialli", 62, "Via Roma 12", false, postaDiPaese3);
        Destinatario destinatario11 = new Destinatario("Simone", "Blu", 41, "Via Roma 13", false, postaDiPaese3);

        postaDiPaese3.getDestinatari().add(destinatario9);
        postaDiPaese3.getDestinatari().add(destinatario10);
        postaDiPaese3.getDestinatari().add(destinatario11);

        POSTA_DI_PAESE.add(postaDiPaese1);
        POSTA_DI_PAESE.add(postaDiPaese2);
        POSTA_DI_PAESE.add(postaDiPaese3);
    }

}