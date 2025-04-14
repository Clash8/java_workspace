package it.prova.test;


import it.prova.model.centrocommerciale.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCentroCommerciale {
    public static void main(String[] args) {

        Lavoratore commesso1 = new Commesso("Gennaro", "Banana");
        Lavoratore commesso2 = new Commesso("Ugo", "Frittella");
        Lavoratore commesso3 = new Commesso("Ciccio", "Panzerotto");
        Lavoratore boss = new Boss("Donato", "Spaccatutto");
        Lavoratore personaleAmministrativo = new PersonaleAmministrativo("Brunilde", "Cocomero");
        Lavoratore personaleAmministrativo2 = new PersonaleAmministrativo("Otello", "Pastasciutta");

        List<Lavoratore> lavoratori = new ArrayList<Lavoratore>(Arrays.asList(commesso1, commesso2, commesso3, boss, personaleAmministrativo, personaleAmministrativo2));

        Item item1 = new Item("Maglietta", "Cotone dei Pirenei", 19.99f);
        Item item2 = new Item("Cappello", "Pelo di Yak sintetico", 12.49f);
        Item item3 = new Item("Calzini", "Lana delle Ande", 5.99f);
        Item item4 = new Item("Mutande", "Seta d’astronauta", 14.50f);
        Item item5 = new Item("Sciarpa", "Filato di nuvola", 9.90f);
        Item item6 = new Item("Pantaloni", "Jeans antigravità", 49.99f);
        Item item7 = new Item("Guanti", "Pelliccia di draghetto", 24.75f);

//        List<Item> items = Arrays.asList(item1, item2, item3, item4, item5, item6, item7);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);

        Negozio negozio1 = new Negozio("H&M", "Abbigliamento", items, lavoratori);

        commesso1.setNegozio(negozio1);
        commesso2.setNegozio(negozio1);
        commesso3.setNegozio(negozio1);
        boss.setNegozio(negozio1);
        personaleAmministrativo.setNegozio(negozio1);
        personaleAmministrativo2.setNegozio(negozio1);


        CentroCommerciale centroCommerciale = new CentroCommerciale("Centro Commerciale Le Gru", "Via Roma 123", Arrays.asList(negozio1));

        Item nuovoItem = new Item("Cintura", "Pelle di drago", 29.99f);

        System.out.println(negozio1);

        System.out.println("\n\nun commesso prova ad aggiungere un item:");
        boolean added = negozio1.addToItems(commesso1, nuovoItem);
        System.out.println("Item aggiunto? " + added);

        System.out.println(negozio1);


        System.out.println("\n\nun commesso prova a rimuovere un item:");
        boolean removed = negozio1.removeFromItems(commesso1, item1);
        System.out.println("Item rimosso? " + removed);

        System.out.println(negozio1);

        System.out.println("\n\nun boss prova ad aggiungere un item:");
        added = negozio1.addToItems(boss, nuovoItem);
        System.out.println("Item aggiunto? " + added);

        System.out.println(negozio1);

        System.out.println("\n\nun boss prova a rimuovere un item:");
        removed = negozio1.removeFromItems(boss, item1);
        System.out.println("Item rimosso? " + removed);

        System.out.println(negozio1);

        System.out.println("\n\nun personale amministrativo prova a rimuovere un item:");
        removed = negozio1.removeFromItems(personaleAmministrativo, item1);
        System.out.println("Item rimosso? " + removed);

        System.out.println(negozio1);

        System.out.println("\n\nun personale amministrativo prova ad aggiungere un item:");
        added = negozio1.addToItems(personaleAmministrativo, nuovoItem);
        System.out.println("Item aggiunto? " + added);

        System.out.println(negozio1);
    }
}
