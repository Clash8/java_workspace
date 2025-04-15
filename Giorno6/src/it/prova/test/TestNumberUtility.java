package it.prova.test;

import it.prova.utility.NumberUtility;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarOutputStream;

public class TestNumberUtility {
    public static void main(String[] args) {
//        String value;
//        int c = 0;
//        List<String> messages = new ArrayList<>(Arrays.asList("Inserisci un valore del numero","Ho detto inserisci un numero", "O ma mi ascolti inserisci un numero!", "senti mi stai stancando inserisci un numero!", "ora basta non ti sopporto più inserisci un numero o mi autodistruggo!"));
//        do {
//            value = JOptionPane.showInputDialog(messages.get(c++));
//            Integer parsedValue = NumberUtility.parseFromStringToInt(value);
//            if (value != null && parsedValue != null) {
//                JOptionPane.showMessageDialog(null, parsedValue);
//                break;
//            }
//        } while (value != null && c < messages.size());
        String[] options = {"Option 1", "Option 2", "Option 3"};

        JOptionPane.showInputDialog("ciao");
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Custom Option Dialog",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        JOptionPane.showInternalMessageDialog(null, "Internal message");
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        Object[] fields = {"Field 1:", field1, "Field 2:", field2};

        int result = JOptionPane.showConfirmDialog(null, fields, "Custom Input", JOptionPane.OK_CANCEL_OPTION);

    }
}
