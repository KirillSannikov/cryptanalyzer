package com.javarush.cryptanalyzer.sannikov.text.bruteForce;

import com.javarush.cryptanalyzer.sannikov.constants.ConstBruteForce;

import java.util.Scanner;

public class BruteForce {
    private static int modulo(int n, int modulus) {
        if (n < 0) return n % modulus + modulus;
        return n % modulus;
    }

    public static void textBruteForce() {
        ConstBruteForce constBruteForce = new ConstBruteForce();
        Scanner console = new Scanner(System.in);
        System.out.println(constBruteForce.enterText);
        String line3 = console.nextLine();
        console.close();
        String letter3 = "";
        char[] symbol3 = new char[line3.length()];
        System.out.println(constBruteForce.encryptionText + line3);

        int key3 = 1;
        while (key3 != 33) {

            for (int i = 0; i < line3.length(); i++) {
                int a = line3.charAt(i);

                if (a <= 1071 && a >= 1040) {
                    symbol3[i] = (char) (((((int) (line3.charAt(i))) - 1040 - key3) % 32) + 1040);
                    letter3 += (char) symbol3[i];

                } else if (a > 1071) {
                    symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 1072 - key3), 32)) + 1072);
                    letter3 += (char) symbol3[i];

                } else if (a >= 32 && a <= 47) {
                    symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 32 - key3), 16)) + 32);
                    letter3 += (char) symbol3[i];

                } else if (a > 47 && a <= 57) {
                    symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 47 - key3), 10)) + 47);
                    letter3 += (char) symbol3[i];

                } else if (a > 57 && a <= 64) {
                    symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 57 - key3), 7)) + 57);
                    letter3 += (char) symbol3[i];
                }

            }

            System.out.print(constBruteForce.decryptionText + key3 + ": ");
            System.out.println();
            System.out.println(symbol3);
            System.out.println();
            key3++;




            }
        }
    }