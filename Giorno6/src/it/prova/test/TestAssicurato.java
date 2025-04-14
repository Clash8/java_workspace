package it.prova.test;

import it.prova.model.Assicurato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAssicurato {
    public static void main(String[] args) {
        Assicurato me = new Assicurato("Giuseppe", "Campitelli", "GPPCPT87839SBHZ", 134.50f);
        List<Assicurato> assicurati = new ArrayList<>(Arrays.asList(
                me,
                new Assicurato("Giorgia", "Meloni", "GRGMLN77A01H501Z", 300),
                new Assicurato("Matteo", "Salvini", "MTTSLV73A01H501Z", 280),
                new Assicurato("Elly", "Schlein", "LLYSCH85A01H501Z", 260),
                new Assicurato("Giuseppe", "Conte", "GSPCNT64A01H501Z", 290)
        )) {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder("Sono : " + this.size() + " assicurati\n");

                // Intestazione tabella
                sb.append(String.format("%-15s %-15s %-20s %-10s\n", "Nome", "Cognome", "Codice Fiscale", "Rata (€)"));
                sb.append("--------------------------------------------------------------\n");

                // Riga per ogni assicurato
                for (Assicurato assicurato : this) {
                    sb.append(assicurato);
                }

                return sb.toString();
            }
        };

        System.out.println("Assicurati:");
        System.out.println(assicurati);
        System.out.println("\n\nio sono presente in elenco? " + me.presenteInElenco(assicurati));
        System.out.println("\n\nQuanti hanno la stessa iniziale nel cognome? " + Assicurato.quantiConInizialeNelCognome(assicurati, 'R'));
        System.out.println("\n\nCognomi estratti: " + Assicurato.estraiSoloICognomi(assicurati));
        System.out.println("\n\nAssicurati con rata maggiore di 101: ");
        System.out.println(Assicurato.estraiQuelliConRataMaggioreDi(assicurati, 101));



    }
}
