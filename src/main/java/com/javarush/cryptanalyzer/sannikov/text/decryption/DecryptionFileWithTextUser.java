package com.javarush.cryptanalyzer.sannikov.text.decryption;

import com.javarush.cryptanalyzer.sannikov.constants.constForDecryption.ConstDecryptionDefault;
import com.javarush.cryptanalyzer.sannikov.constants.constForDecryption.ConstDecryptionEntered;
import com.javarush.cryptanalyzer.sannikov.constants.constForDecryption.ConstDecryptionFileUser;
import com.javarush.cryptanalyzer.sannikov.exception.FileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DecryptionFileWithTextUser {
    private static int modulo(int n, int modulus) {
        if (n < 0) return n % modulus + modulus;
        return n % modulus;
    }

    public static void decodingFileUser(){

        ConstDecryptionFileUser constDecryptionFileUser = new ConstDecryptionFileUser();

        String text = "";

        try (BufferedReader bufferedWriter = new BufferedReader(new FileReader("cipherTextEntered.txt"))) {
            while (bufferedWriter.ready()) {
                text = bufferedWriter.readLine();
            }
        } catch (FileException | IOException e) {
            System.out.println(constDecryptionFileUser.exceptionFile + e.getMessage());
        }

        Scanner console = new Scanner(System.in);
        String letter1 = "";
        System.out.println(constDecryptionFileUser.enterKey);
        int key = console.nextInt();
        console.close();

        char[] symbol1 = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            int a = text.charAt(i);

            if (a <= 1071 && a >= 1040) {
                symbol1[i] = (char) (((((int) (text.charAt(i))) - 1040 - key) % 32) + 1040);
                letter1 += (char) symbol1[i];

            } else if (a > 1071) {
                symbol1[i] = (char) ((modulo((((int) (text.charAt(i))) - 1072 - key), 32)) + 1072);
                letter1 += (char) symbol1[i];

            } else if (a >= 32 && a <= 47) {
                symbol1[i] = (char) ((modulo((((int) (text.charAt(i))) - 32 - key), 16)) + 32);
                letter1 += (char) symbol1[i];

            } else if (a > 47 && a <= 57) {
                symbol1[i] = (char) ((modulo((((int) (text.charAt(i))) - 47 - key), 10)) + 47);
                letter1 += (char) symbol1[i];

            } else if (a > 57 && a <= 64) {
                symbol1[i] = (char) ((modulo((((int) (text.charAt(i))) - 57 - key), 7)) + 57);
                letter1 += (char) symbol1[i];
            }

        }
        try{
            FileWriter fileWriter =new FileWriter("output.txt");
            fileWriter.write(letter1);
            fileWriter.close();
            System.out.println(constDecryptionFileUser.ready);
            System.out.println(constDecryptionFileUser.decipheredText);
            System.out.println(constDecryptionFileUser.fileLocation);
        } catch(Exception e){
            System.out.println(constDecryptionFileUser.ciphertextGenerationError);
        }
    }
}
