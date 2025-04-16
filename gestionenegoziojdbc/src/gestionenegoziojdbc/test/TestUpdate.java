package gestionenegoziojdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.text.ParseException;

public class TestUpdate {
    public static void main(String[] args) throws ParseException {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        // #####################################################################
        System.out.println("####################### test per verifica Update:          ##################################");

        Motocicletta motociclettaDaModificare = new Motocicletta("Yamaha",  1000, new java.text.SimpleDateFormat("dd/MM/yyyy").parse("01/01/2010"));
        motociclettaDaModificare.setId(2L);
        // inserisco un nuovo record
        int r = motociclettaDaoInstance.update(motociclettaDaModificare);
        System.out.println("Rows affected: " + r);

        System.out.println("####################### test per verifica update: FINE     ##################################");
        System.out.println("##################################################################################################");
    }
}
