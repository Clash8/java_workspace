package it.prova.test;

import it.prova.model.Televisore;

public class TestModel {
    public static void main(String[] args) {
        Televisore tv1 = new Televisore("Samsung", "QLED-Q80", 1200, 55);
        Televisore tv2 = new Televisore("LG", "OLED-C2", 1400, 65);
        Televisore tv3 = new Televisore("Sony", "Bravia-X90", 1000, 50);
        Televisore tv4 = new Televisore("Philips", "Ambilight-7600", 900, 58);
        Televisore tv5 = new Televisore("Panasonic", "TX-HX800", 850, 49);
        Televisore tv6 = new Televisore("Hisense", "U8HQ", 700, 55);
        Televisore tv7 = new Televisore("TCL", "C735", 650, 65);
        Televisore tv8 = new Televisore("Sharp", "AQUOS-LED", 500, 40);

        Televisore[] catalogo1 = {tv1, tv2, tv3, tv4};
        Televisore[] catalogo2 = {tv5, tv6, tv7, tv8};


        boolean costaMenoDelSecondo = tv1.costaMenoDelBudgetDisponibile(500);
        boolean marcheCoincidenti = tv1.stessaMarcaDi(tv2);
        boolean piuGrandeDi = tv1.piuGrandeDi(tv2);
        boolean miglioreQualitaPrezzo = tv1.miglioreQualitaPrezzoDi(tv2);

        System.out.println("Test costaMenoDelBudgetDisponibile");
        System.out.println("Start.....");
        System.out.println("Il televisore " + tv1.getMarca() + " costa meno del budget previsto? " + costaMenoDelSecondo);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test stessaMarcaDi");
        System.out.println("Start.....");
        System.out.println("Il televisore " + tv1.getMarca() + " è della stessa marca del " + tv2.getMarca() + " ? " + marcheCoincidenti);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test piuGrandeDi");
        System.out.println("Start.....");
        System.out.println("Il televisore " + tv1.getPollici() + " è più grande di " + tv2.getPollici() + " ? " + piuGrandeDi);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test miglioreQualitaPrezzoDi");
        System.out.println("Start.....");
        System.out.println("Il televisore " + tv1.getMarca() + " è migliore per qualita-prezzo di " + tv2.getMarca() + " ? " + miglioreQualitaPrezzo);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test esisteAlmenoUnoPiùEconomico");
        System.out.println("Start.....");
        boolean esisteEconomico = tv1.esisteAlmenoUnoPiuEconomico(catalogo2);
        System.out.println("Nel catalogo2 esiste almeno un televisore più economico di " + tv1.getMarca() + "? " + esisteEconomico);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test quantiSonoPiuGrandi");
        System.out.println("Start.....");
        int piuGrandi = tv1.quantiSonoPiuGrandi(catalogo2);
        System.out.println("Nel catalogo2, quanti televisori sono più grandi di " + tv1.getPollici() + " pollici? " + piuGrandi);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test quantiSonoPiuCariAvendoStessaMarca");
        System.out.println("Start.....");
        int piuCariStessaMarca = tv1.quantiSonoPiuCariAvendoStessaMarca(catalogo1);
        System.out.println("Nel catalogo1, quanti televisori della stessa marca (" + tv1.getMarca() + ") costano di più? " + piuCariStessaMarca);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test ePiuCaroDellaMedia");
        System.out.println("Start.....");
        boolean piuCaroDellaMedia = tv1.ePiuCaroDellaMedia(catalogo1);
        System.out.println("Il televisore " + tv1.getMarca() + " è più caro della media del catalogo1? " + piuCaroDellaMedia);
        System.out.println("End.......");
        System.out.println(".......... \n");

        System.out.println("Test getMostExpensive");
        System.out.println("Start.....");
        Televisore ilPiuCaro = Televisore.getMostExpensive(catalogo1);
        System.out.println("Il televisore più caro del catalogo è " + ilPiuCaro);
        System.out.println("End.......");
        System.out.println(".......... \n");

    }
}
