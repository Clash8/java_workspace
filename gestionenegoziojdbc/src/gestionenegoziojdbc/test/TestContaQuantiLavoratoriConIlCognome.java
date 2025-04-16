package gestionenegoziojdbc.test;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;

public class TestContaQuantiLavoratoriConIlCognome {
    public static void main(String[] args) {
        String cognome = "del piero";
        LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();

        System.out.println("############### test conta quanti lavoratori con il cognome ###########################");
        int quantiConCognome = lavoratoreDaoInstance.contaQuantiLavoratoriConIlCognome(cognome);
        System.out.println("Sono stati trovati " + quantiConCognome + " elementi con cognome \"" + cognome + "\"");
        System.out.println("############### test conta quanti lavoratori con il cognome END ###########################");
        System.out.println("#######################################################################");

    }
}
