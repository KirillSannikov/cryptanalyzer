package com.javarush.cryptanalyzer.sannikov.text.encryption;

import com.javarush.cryptanalyzer.sannikov.constants.constForEncryption.ConstEnteredText;

import java.util.Scanner;

public class EnteredTextEncryption {
    public static void enteredText(){

        ConstEnteredText constEnteredText = new ConstEnteredText();
        System.out.println(constEnteredText.enterText);
        Scanner scanner = new Scanner(System.in);
        String consoleText = scanner.nextLine();

        System.out.println(constEnteredText.enterKey);
        int key = scanner.nextInt();
        scanner.close();

        String letter = "";
        int modifiedLetter;
        int letterFormula;

        for (int j = 0; j < consoleText.length(); j++) {
            int a = consoleText.charAt(j);

            if (a <= 1071 && a >= 1040) {
                modifiedLetter = (consoleText.charAt(j) + key);
                letterFormula = (modifiedLetter - 1040) % 32 + 1040; // 1040 - это код буквы А, 32 - это кол-во букв
                letter += (char) letterFormula; // получаем букву по коду

            } else if (a > 1071) {
                modifiedLetter = (consoleText.charAt(j) + key);
                letterFormula = (modifiedLetter - 1072) % 32 + 1072; // 1072 - это код буквы а, 32 - это кол-во букв
                letter += (char) letterFormula; // получаем букву по коду

            } else if (a >= 32 && a <= 47) {
                modifiedLetter = (consoleText.charAt(j) + key);
                letterFormula = (modifiedLetter - 32) % 16 + 32;
                letter += (char) letterFormula;

            } else if (a > 47 && a <= 57) {
                modifiedLetter = (consoleText.charAt(j) + key);
                letterFormula = (modifiedLetter - 47) % 10 + 47;
                letter += (char) letterFormula;

            } else if (a > 57 && a <= 64) {
                modifiedLetter = (consoleText.charAt(j) + key);
                letterFormula = (modifiedLetter - 57) % 7 + 57;
                letter += (char) letterFormula;
            }
        }
        System.out.println(letter);

    }
}
