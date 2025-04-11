package it.prova.test;
import it.prova.model.onetomany.*;

public class TestRaccoglitore {
    public static void main(String[] args) {

        Foglio foglio1 = new Foglio("Alta", "A4");
        Foglio foglio2 = new Foglio("Media", "quadretti");
        Foglio foglio3 = new Foglio("Bassa", "A5");


        Foglio[] fogli = {
                new Foglio("Alta", "A4"),
                new Foglio("Media", "quadretti"),
                new Foglio("Bassa", "A5")
        };

        Raccoglitore raccoglitore = new Raccoglitore("Blu", 5, fogli);

        System.out.println(raccoglitore);

        Foglio nuovoFoglio = new Foglio("Nuovo", "A4");

        raccoglitore.addToFogli(nuovoFoglio);

        System.out.println(raccoglitore);

        raccoglitore.removeFromFogli(1);

        System.out.println(raccoglitore);

        fogli = new Foglio[] {
                new Foglio("Alta", "A4"),
                new Foglio("Media", "quadretti"),
                new Foglio("Bassa", "A5")
        };
        raccoglitore.setFogli(fogli);

        Raccoglitore raccoglitore1 = new Raccoglitore("Blu", 5,
                new Foglio[] {
                        new Foglio("Alta", "A4"),
                        new Foglio("Media", "quadretti"),
                        new Foglio("Bassa", "A5")
                });
        System.out.println("TEST esisteAlmenoUnFoglioAQuadretti....................START");
        System.out.println("Esiste almeno un foglio a quadretti? " + raccoglitore.esisteAlmenoUnFoglioAQuadretti());
        System.out.println("TEST esisteAlmenoUnFoglioAQuadretti....................END\n");

        System.out.println("TEST esisteAlmenoUnFoglioAQuadretti....................START");
        System.out.println("Esiste almeno un foglio di qualita' alta? " + raccoglitore.quantiFogliDiAltaQualita());
        System.out.println("TEST esisteAlmenoUnFoglioAQuadretti....................END\n");

        System.out.println("TEST stessoColoreENumeroFogliDi....................START");
        System.out.println("il raccoglitore ha lo stesso numero di fogli e colore uguale a raccoglitore1? " + raccoglitore.stessoColoreENumeroFogliDi(raccoglitore1));
        System.out.println("TEST stessoColoreENumeroFogliDi....................END\n");


    }
}
