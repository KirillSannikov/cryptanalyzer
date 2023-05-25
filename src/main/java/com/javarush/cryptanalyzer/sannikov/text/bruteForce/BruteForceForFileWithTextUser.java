package com.javarush.cryptanalyzer.sannikov.text.bruteForce;

import com.javarush.cryptanalyzer.sannikov.constants.constForBruteForce.ConstBruteForceDefault;
import com.javarush.cryptanalyzer.sannikov.constants.constForBruteForce.ConstBruteForceFileUser;
import com.javarush.cryptanalyzer.sannikov.exception.FileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BruteForceForFileWithTextUser {
    private static int modulo(int n, int modulus) {
        if (n < 0) return n % modulus + modulus;
        return n % modulus;
    }
    public static void enteredTextBruteForce() {

        ConstBruteForceFileUser constBruteForceFileUser = new ConstBruteForceFileUser();
        String text = "";
        String text1 = "";

        try (BufferedReader bufferedWriter = new BufferedReader(new FileReader("cipherTextEntered.txt"))) {
            while (bufferedWriter.ready()) {
                text = bufferedWriter.readLine();
            }
        } catch (FileException | IOException e) {
            System.out.println(constBruteForceFileUser.exceptionFile + e.getMessage());
        }

        try (BufferedReader bufferedWriter = new BufferedReader(new FileReader("enteredUserText.txt"))) {
            while (bufferedWriter.ready()) {
                text1 = bufferedWriter.readLine();
            }
        } catch (FileException | IOException e) {
            System.out.println(constBruteForceFileUser.exceptionFile + e.getMessage());
        }

        Scanner console = new Scanner(System.in);
        console.close();
        char[] symbol3 = new char[text.length()];
        char[] symbol4 = new char[text1.length()];

        for (int j = 0; j < text1.length(); j++) {
            symbol4[j] =  (text1.charAt(j));
        }

        int key = 0;
        while (key!=33){

            for (int i = 0; i < text.length(); i++) {
                int a = text.charAt(i);

                if (a <= 1071 && a >= 1040) {
                    symbol3[i] = (char) (((((int) (text.charAt(i))) - 1040 - key) % 32) + 1040);
                } else if (a > 1071) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 1072 - key), 32)) + 1072);
                } else if (a >= 32 && a <= 47) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 32 - key), 16)) + 32);
                } else if (a > 47 && a <= 57) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 47 - key), 10)) + 47);
                } else if (a > 57 && a <= 64) {
                    symbol3[i] = (char) ((modulo((((int) (text.charAt(i))) - 57 - key), 7)) + 57);
                }
            }

            int b = Arrays.mismatch(symbol3,symbol4);

            if (b != 0) {
                try{
                    FileWriter fileWriter =new FileWriter("output.txt");
                    fileWriter.write(symbol3);
                    fileWriter.close();
                    System.out.println(constBruteForceFileUser.ready);
                    System.out.println(constBruteForceFileUser.decryptionText + key);
                    System.out.println(constBruteForceFileUser.fileLocation);
                    break;
                } catch(Exception e){
                    System.out.println(constBruteForceFileUser.ciphertextGenerationError);
                }
            }
            key++;
        }
    }
}
