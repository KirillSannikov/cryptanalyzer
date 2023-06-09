package com.javarush.cryptanalyzer.sannikov.text.encryption;

import com.javarush.cryptanalyzer.sannikov.constants.constForEncryption.ConstDefaultText;
import com.javarush.cryptanalyzer.sannikov.exception.FileException;

import java.io.*;
import java.util.Scanner;

public class DefaultEncryption {
    public static void textDefault(){
        ConstDefaultText constDefaultText = new ConstDefaultText();
        String text = "";

        try (BufferedReader bufferedWriter = new BufferedReader(new FileReader("input.txt"))) {
            while (bufferedWriter.ready()) {
                text = bufferedWriter.readLine();
            }
        } catch (FileException | IOException e) {
            System.out.println(constDefaultText.exceptionFile + e.getMessage());
        }

        System.out.println(constDefaultText.text);
        System.out.println(constDefaultText.enterKey);
        Scanner console = new Scanner(System.in);
        int key1 = console.nextInt();
        console.close();
        String letter1 = "";
        int modifiedLetter1;
        int letterFormula1;

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
        System.out.println();

        try{
         FileWriter fileWriter =new FileWriter("cipherTextDefault.txt");
         fileWriter.write(letter1);
         fileWriter.close();
         System.out.println(constDefaultText.ready);
         System.out.println(constDefaultText.ciphertextOutput + key1);

         System.out.println(constDefaultText.fileLocation);
         } catch(Exception e){
            System.out.println(constDefaultText.ciphertextGenerationError);
        }

    }

}
