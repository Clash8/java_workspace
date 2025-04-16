package gestionenegoziojdbc.test;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;

public class TestDeleteByCognome {
    public static void main(String[] args) {
        String cognome = "buffon";
        LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();


        System.out.println("############### test delete by cognome ###########################");
        int quantiEliminati = lavoratoreDaoInstance.deleteByCognome(cognome);
        System.out.println("Sono stati eliminati " + quantiEliminati + " elementi");
        System.out.println("############### test delete by cognome END ###########################");
        System.out.println("#######################################################################");


    }
}
