package it.prova.utility;


public class NumberUtility {
    public static Integer parseFromStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }
}
