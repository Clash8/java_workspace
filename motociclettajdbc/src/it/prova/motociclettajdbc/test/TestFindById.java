package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.text.ParseException;

public class TestFindById {
    public static void main(String[] args) throws ParseException {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        // #####################################################################
        System.out.println("####################### test per verifica findById:          ##################################");

        Long idDaTrovare = 2L; // id da eliminare

        // inserisco un nuovo record
        Motocicletta motoTrovata = motociclettaDaoInstance.findById(idDaTrovare);
        System.out.println("Moto trovata : " + motoTrovata);

        System.out.println("####################### test per verifica delete: FINE     ##################################");
        System.out.println("##################################################################################################");
    }
}
