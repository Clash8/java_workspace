package it.prova.test;

import it.prova.utility.NumberUtility;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarOutputStream;

public class TestNumberUtility {
    public static void main(String[] args) {
        String value;
        int c = 0;
        List<String> messages = new ArrayList<>(Arrays.asList("Inserisci un valore del numero","Ho detto inserisci un numero", "O ma mi ascolti inserisci un numero!", "senti mi stai stancando inserisci un numero!", "ora basta non ti sopporto piu inserisci un numero o mi autodistruggo!"));
        do {
            value = JOptionPane.showInputDialog(messages.get(c++));
            Integer parsedValue = NumberUtility.parseFromStringToInt(value);
            if (value != null && parsedValue != null) {
                JOptionPane.showMessageDialog(null, parsedValue);
                break;
            }
        } while (value != null && c < messages.size());

    }
}
