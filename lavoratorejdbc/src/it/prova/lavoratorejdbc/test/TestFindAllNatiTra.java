package it.prova.lavoratorejdbc.test;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

import java.text.ParseException;
import java.util.List;
import java.util.Date;

public class TestFindAllNatiTra {
    public static void main(String[] args) throws ParseException {
        LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();

        System.out.println("############### test find all nati tra ###########################");

        Date data1 = new java.text.SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
        Date data2 = new java.text.SimpleDateFormat("dd/MM/yyyy").parse("01/01/2001");

        List<Lavoratore> result = lavoratoreDaoInstance.findAllNatiTra(data1, data2);
        System.out.println("Sono stati trovati " + result.size() + " elementi");

        for (Lavoratore lavoratoreItem : result) {
            System.out.println(lavoratoreItem);
        }
        System.out.println("############### test find all nati tra FINE ###########################");
        System.out.println("#######################################################################");

    }
}
