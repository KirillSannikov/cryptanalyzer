package com.javarush.cryptanalyzer.sannikov.cipherCaesar;

import com.javarush.cryptanalyzer.sannikov.text.bruteForce.BruteForce;
import com.javarush.cryptanalyzer.sannikov.text.decryption.TextTranscription;
import com.javarush.cryptanalyzer.sannikov.text.encryption.DefaultEncryption;
import com.javarush.cryptanalyzer.sannikov.text.encryption.EnteredTextEncryption;

import java.util.Scanner;

public class ImplementationCipher {

    static Scanner console = new Scanner(System.in);

    public static void cipher() {



        System.out.println("Для шифрования введите - 1, расшифрования – 2, метод brute force (поиск грубой силой) - 3 ");
        int number = console.nextInt();

        switch (number) {
            case 1:
                System.out.println("Для шифрования своего текста введите - 1 , для выбора текста по умолчанию - 2");
                int textSelection = console.nextInt();

                switch (textSelection) {
                    case 1 -> EnteredTextEncryption.enteredText();
                    case 2 -> DefaultEncryption.textDefault();
                    default -> System.out.print("Неверный ввод");
                }

            break;

            case 2:
                TextTranscription.Transcription();
                break;
            case 3:
                BruteForce.textBruteForce();
                break;
            default: System.out.print("Неверный ввод");

        }
    }
}
