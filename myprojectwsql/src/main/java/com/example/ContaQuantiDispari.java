package com.example;

import org.jetbrains.annotations.Contract;

import java.util.Arrays;

public class ContaQuantiDispari {

    public static int quantiDispari(int[] arr) {
        int c = 0;
        for (int num : arr)
            if (num % 2 != 0)
                c++;
        return c;
    }

    public static int quantiDispari2(int[] arr) {
        return (int) Arrays
                .stream(arr)
                .filter(num -> num % 2 != 0)
                .count();
    }

    public static int sommaElementiDispari(int[] arr) {
        int sum = 0;
        for (int num : arr)
            if (num % 2 != 0)
                sum += num;
        return sum;
    }

    public static int sommaElementiDispari2(int[] arr) {
        return Arrays.stream(arr)
                .filter(num -> num % 2 != 0)
                .sum();
    }

    public static int sommaElementiPosizionePari(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i += 2)
            sum += arr[i];
        return sum;
    }

    public static boolean esisteAlmenoUnNegativo(int[] arr) {
        for (int num : arr)
            if (num < 0)
                return true;
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,8};

        System.out.printf("Ci sono %d numeri dispari", quantiDispari(arr));
    }
}
