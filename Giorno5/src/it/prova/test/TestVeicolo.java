package it.prova.test;
import it.prova.model.prova.*;

public class TestVeicolo {
    public static void main(String[] args) {
        Veicolo bici = new Bicicletta("Bianchi");
        Veicolo auto = new Auto("Fiat");

        Veicolo veicoloGenerico = new Veicolo();

        System.out.println("Marca della bicicletta: " + bici.getMarca());
        bici.suono();
        System.out.println("Marca dell'auto: " + auto.getMarca());
        auto.suono();

        System.out.println("Marca del veicolo generico: " + veicoloGenerico.getMarca());
        veicoloGenerico.suono();

        System.out.println("Bici è un " + bici.getClass().getSimpleName());
        System.out.println("Auto è un " + auto.getClass().getSimpleName());
        System.out.println("Veicolo generico è un " + veicoloGenerico.getClass().getSimpleName());

    }
}
