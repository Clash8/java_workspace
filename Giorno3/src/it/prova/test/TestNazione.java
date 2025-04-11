package it.prova.test;

import it.prova.model.Nazione;

public class TestNazione {
    public static void main(String[] args) {
        Nazione italia = new Nazione("Italia", 301340, 59000000);
        Nazione francia = new Nazione("Francia", 551695, 68000000);
        Nazione germania = new Nazione("Germania", 357022, 83000000);
        Nazione vaticano = new Nazione("Vaticano", 0.44, 800);
        Nazione spagna = new Nazione("Spagna", 505990, 47000000);

        Nazione[] nazioni = {francia, germania, vaticano, spagna};

        System.out.printf("TEST piuEstesaDi.........................Start%n");
        boolean testEstensione = italia.piuEstesaDi(vaticano);
        System.out.printf("Italia è più estesa del Vaticano? %b%n", testEstensione);
        System.out.printf("TEST piuEstesaDi.........................End%n%n");

        System.out.printf("TEST piuPopolosaDi.......................Start%n");
        boolean testPopolazione = italia.piuPopolosaDi(spagna);
        System.out.printf("Italia è più popolosa della Spagna? %b%n", testPopolazione);
        System.out.printf("TEST piuPopolosaDi.......................End%n%n");

        System.out.printf("TEST esisteAlmenoUnaPiuEstesa...........Start%n");
        boolean testAlmenoUnaPiuEstesa = italia.esisteAlmenoUnaPiuEstesa(nazioni);
        System.out.printf("Esiste almeno una nazione più estesa dell'Italia? %b%n", testAlmenoUnaPiuEstesa);
        System.out.printf("TEST esisteAlmenoUnaPiuEstesa...........End%n%n");

        System.out.printf("TEST dimmiQuanteSonoPiuPopolose.........Start%n");
        int quantePiuPopolose = italia.dimmiQuanteSonoPiuPopolose(nazioni);
        System.out.printf("Quante nazioni sono più popolose dell'italia? %d%n", quantePiuPopolose);
        System.out.printf("TEST dimmiQuanteSonoPiuPopolose.........End%n%n");

        System.out.printf("TEST haPiuAbitantiDiTutteLeAltre........Start%n");
        boolean haPiuAbitanti = germania.haPiuAbitantiDiTutteLeAltre(nazioni);
        System.out.printf("La Germania ha più abitanti di tutte le altre? %b%n", haPiuAbitanti);
        System.out.printf("TEST haPiuAbitantiDiTutteLeAltre........End%n%n");

        System.out.printf("TEST hannoTutteLaMiaStessaIniziale......Start%n");
        Nazione a1 = new Nazione("Austria", 83879, 8900000);
        Nazione a2 = new Nazione("Albania", 28748, 2800000);
        Nazione a3 = new Nazione("Andorra", 468, 77000);
        Nazione[] inizialiA = {a1, a2, a3};
        boolean stesseIniziali = a1.hannoTutteLaMiaStessaIniziale(inizialiA);
        System.out.printf("Tutte le nazioni iniziano con la stessa lettera di Austria? %b%n", stesseIniziali);
        System.out.printf("TEST hannoTutteLaMiaStessaIniziale......End%n%n");

        System.out.printf("TEST eAlDiSopraDellaMediaComeSuperficie.Start%n");
        boolean sopraMedia = francia.eAlDiSopraDellaMediaComeSuperficie(nazioni);
        System.out.printf("La Francia ha una superficie sopra la media del gruppo? %b%n", sopraMedia);
        System.out.printf("TEST eAlDiSopraDellaMediaComeSuperficie.End%n%n");
    }
}
