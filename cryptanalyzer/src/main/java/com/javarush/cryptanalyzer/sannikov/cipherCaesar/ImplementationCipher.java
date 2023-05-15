package com.javarush.cryptanalyzer.sannikov.cipherCaesar;

import com.javarush.cryptanalyzer.sannikov.constants.ConstImplementationCipher;
import com.javarush.cryptanalyzer.sannikov.text.bruteForce.BruteForce;
import com.javarush.cryptanalyzer.sannikov.text.decryption.TextTranscription;
import com.javarush.cryptanalyzer.sannikov.text.encryption.DefaultEncryption;
import com.javarush.cryptanalyzer.sannikov.text.encryption.EnteredTextEncryption;

import java.util.Scanner;

public class ImplementationCipher {

    static Scanner console = new Scanner(System.in);

    public static void cipher() {

        ConstImplementationCipher constImplementationCipher = new ConstImplementationCipher();

        System.out.println(constImplementationCipher.selectionExecutionProgram);
        int number = console.nextInt();

        switch (number) {
            case 1:
                System.out.println(constImplementationCipher.selectionText);
                int textSelection = console.nextInt();

                switch (textSelection) {
                    case 1 -> EnteredTextEncryption.enteredText();
                    case 2 -> DefaultEncryption.textDefault();
                    default -> System.out.print(constImplementationCipher.incorrectEnterText);
                }

            break;

            case 2:
                TextTranscription.decoding();
                break;
            case 3:
                BruteForce.textBruteForce();
                break;
            default: System.out.print(constImplementationCipher.incorrectEnterText);

        }
    }
}
