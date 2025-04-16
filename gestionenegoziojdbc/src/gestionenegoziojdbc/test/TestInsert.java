package gestionenegoziojdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.text.ParseException;

public class TestInsert {
    public static void main(String[] args) throws ParseException {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        // #####################################################################
        System.out.println("####################### test per verifica inserimento:          ##################################");

        Motocicletta motociclettaDaInserire = new Motocicletta("Yamaha",  1000, new java.text.SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010"));

        // inserisco un nuovo record
        int r = motociclettaDaoInstance.insert(motociclettaDaInserire);
        System.out.println("Rows affected: " + r);

        System.out.println("####################### test per verifica inserimento: FINE     ##################################");
        System.out.println("##################################################################################################");
    }
}
