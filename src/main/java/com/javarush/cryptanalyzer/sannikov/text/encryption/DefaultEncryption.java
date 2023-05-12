package com.javarush.cryptanalyzer.sannikov.text.encryption;

import com.javarush.cryptanalyzer.sannikov.exception.FileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DefaultEncryption {
    public static void textDefault(){
        String text = "";

        try (BufferedReader bufferedWriter = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\sannikov\\file\\input.txt"))) {
            while (bufferedWriter.ready()) {
                text = bufferedWriter.readLine();
            }
        } catch (FileException | IOException e) {
            System.out.println("пустой файл" + e.getMessage());
        }

        System.out.println("Текст выбран по умолчанию");
        System.out.println("Введите ключ ");
        Scanner console = new Scanner(System.in);
        int key1 = console.nextInt();
        console.close();
        String letter1 = "";
        int modifiedLetter1 = 0;
        int letterFormula1 = 0;

        for (int j = 0; j < text.length(); j++) {
            int a = text.charAt(j);

            if (a <= 1071 && a >= 1040) {
                modifiedLetter1 = (text.charAt(j) + key1);
                letterFormula1 = (modifiedLetter1 - 1040) % 32 + 1040; // 1040 - это код буквы А, 32 - это кол-во букв
                letter1 += (char) letterFormula1; // получаем букву по коду

            } else if (a > 1071) {
                modifiedLetter1 = (text.charAt(j) + key1);
                letterFormula1 = (modifiedLetter1 - 1072) % 32 + 1072; // 1072 - это код буквы а, 32 - это кол-во букв
                letter1 += (char) letterFormula1; // получаем букву по коду

            } else if (a >= 32 && a <= 47) {
                modifiedLetter1 = (text.charAt(j) + key1);
                letterFormula1 = (modifiedLetter1 - 32) % 16 + 32;
                letter1 += (char) letterFormula1;

            } else if (a > 47 && a <= 57) {
                modifiedLetter1 = (text.charAt(j) + key1);
                letterFormula1 = (modifiedLetter1 - 47) % 10 + 47;
                letter1 += (char) letterFormula1;

            } else if (a > 57 && a <= 64) {
                modifiedLetter1 = (text.charAt(j) + key1);
                letterFormula1 = (modifiedLetter1 - 57) % 7 + 57;
                letter1 += (char) letterFormula1;
            }
        }
        System.out.println(letter1);

    }


}
