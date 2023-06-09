package com.javarush.cryptanalyzer.sannikov.text.decryption;

import com.javarush.cryptanalyzer.sannikov.constants.constForDecryption.ConstDecryptionEntered;

import java.io.FileWriter;
import java.util.Scanner;

public class DecryptionTextEnteredWithConsole {
    private static int modulo(int n, int modulus) {
        if (n < 0) return n % modulus + modulus;
        return n % modulus;
    }

    public static void decoding(){

        ConstDecryptionEntered constDecryptionEntered = new ConstDecryptionEntered();
        Scanner console = new Scanner(System.in);
        String letter1 = "";
        System.out.println(constDecryptionEntered.enterText);
        String line1 = console.next();
        System.out.println(constDecryptionEntered.enterKey1);
        int key = console.nextInt();
        console.close();

        char[] symbol1 = new char[line1.length()];

        for (int i = 0; i < line1.length(); i++) {
            int a = line1.charAt(i);

            if (a <= 1071 && a >= 1040) {
                symbol1[i] = (char) (((((int) (line1.charAt(i))) - 1040 - key) % 32) + 1040);
                letter1 += (char) symbol1[i];

            } else if (a > 1071) {
                symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 1072 - key), 32)) + 1072);
                letter1 += (char) symbol1[i];

            } else if (a >= 32 && a <= 47) {
                symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 32 - key), 16)) + 32);
                letter1 += (char) symbol1[i];

            } else if (a > 47 && a <= 57) {
                symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 47 - key), 10)) + 47);
                letter1 += (char) symbol1[i];

            } else if (a > 57 && a <= 64) {
                symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 57 - key), 7)) + 57);
                letter1 += (char) symbol1[i];
            }
        }

        try{
            FileWriter fileWriter =new FileWriter("output.txt");
            fileWriter.write(letter1);
            fileWriter.close();
            System.out.println(constDecryptionEntered.ready);
            System.out.println(constDecryptionEntered.decipheredText);
            System.out.println(constDecryptionEntered.fileLocation);
        } catch(Exception e){
            System.out.println(constDecryptionEntered.ciphertextGenerationError);
        }
    }
}
