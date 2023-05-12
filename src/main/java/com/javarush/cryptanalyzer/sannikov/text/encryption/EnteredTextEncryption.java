package com.javarush.cryptanalyzer.sannikov.text.encryption;

import java.util.Scanner;

public class EnteredTextEncryption {
    public static void enteredText(){

        System.out.println("Введите текст: ");
        Scanner scanner = new Scanner(System.in);
        String consoleText = scanner.nextLine();

        System.out.println("Введите ключ ");
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
