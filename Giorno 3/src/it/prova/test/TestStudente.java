package it.prova.test;

import it.prova.model.Studente;


public class TestStudente {
    public static void main(String[] args) {
        Studente io = new Studente("Mario", "Rossi", 20, 7.0);

        Studente[] corso = {
            new Studente("Luca", "Bianchi", 18, 5.5),
            new Studente("Mario", "Monti", 19, 6.5),
            new Studente("Mario", "Draghi", 17, 7.0),
            new Studente("Mario", "Balotelli", 16, 8.0),
            new Studente("Paolo", "Neri", 15, 4.0)
        };

        // Test: sonoTuttiPiuGiovaniDiMe
        System.out.println("TEST sonoTuttiPiuGiovaniDiMe.............START");
        System.out.println("Tutti più giovani di me? " + io.sonoTuttiPiuGiovaniDiMe(corso));
        System.out.println("TEST sonoTuttiPiuGiovaniDiMe.............END\n");

        // Test: almenoUnoHaLaMediaMiglioreDellaMia
        System.out.println("TEST almenoUnoHaLaMediaMiglioreDellaMia.............START");
        System.out.println("Qualcuno ha media migliore? " + io.almenoUnoHaLaMediaMiglioreDellaMia(corso));
        System.out.println("TEST almenoUnoHaLaMediaMiglioreDellaMia.............END\n");


        // Test: contaOmonimiMinorenni
        System.out.println("TEST contaOmonimiMinorenni.............START");
        System.out.println("Omonimi minorenni: " + io.contaOmonimiMinorenni(corso));
        System.out.println("TEST contaOmonimiMinorenni.............END\n");


        // Test: contaStudentiConMediaSufficiente
        System.out.println("TEST contaStudentiConMediaSufficiente.............START");
        System.out.println("Studenti con media ≥ 6: " + Studente.contaStudentiConMediaSufficiente(corso));
        System.out.println("TEST contaStudentiConMediaSufficiente.............END\n");

    }
}
