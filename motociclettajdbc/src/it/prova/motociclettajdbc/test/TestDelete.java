package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.text.ParseException;

public class TestDelete {
    public static void main(String[] args) throws ParseException {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        // #####################################################################
        System.out.println("####################### test per verifica delete:          ##################################");

        Long idDaEliminare = 1L; // id da eliminare

        // inserisco un nuovo record
        int r = motociclettaDaoInstance.delete(idDaEliminare);
        System.out.println("Rows affected: " + r);

        System.out.println("####################### test per verifica delete: FINE     ##################################");
        System.out.println("##################################################################################################");
    }
}
