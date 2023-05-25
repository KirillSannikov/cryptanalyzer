package com.javarush.cryptanalyzer.sannikov.text.bruteForce;
import com.javarush.cryptanalyzer.sannikov.constants.constForBruteForce.ConstBruteForceEnteredWithConsole;
import java.util.Scanner;

public class BruteForceForFileEnteredWithConsole {
    private static int modulo(int n, int modulus) {
        if (n < 0) return n % modulus + modulus;
        return n % modulus;
    }

    public static void enteredTextBruteForce() {

        ConstBruteForceEnteredWithConsole constBruteForceEnteredWithConsole = new ConstBruteForceEnteredWithConsole();
        Scanner console = new Scanner(System.in);
        System.out.println(constBruteForceEnteredWithConsole.enterText);
        String text = console.nextLine();
        console.close();
        char[] symbol3 = new char[text.length()];

        int key3 = 1;
        while (key3 != 33) {

            for (int i = 0; i < text.length(); i++) {
                int a = text.charAt(i);

                if (a <= 1071 && a >= 1040) {
                    symbol3[i] = (char) (((((int) (text.charAt(i))) - 1040 - key3) % 32) + 1040);
                } else if (a > 1071) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 1072 - key3), 32)) + 1072);
                } else if (a >= 32 && a <= 47) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 32 - key3), 16)) + 32);
                } else if (a > 47 && a <= 57) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 47 - key3), 10)) + 47);
                } else if (a > 57 && a <= 64) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 57 - key3), 7)) + 57);
                }
            }
            System.out.print(constBruteForceEnteredWithConsole.decryptionText + key3 + ": ");
            System.out.println();
            System.out.println(symbol3);
            System.out.println();
            key3++;
        }
    }
}
