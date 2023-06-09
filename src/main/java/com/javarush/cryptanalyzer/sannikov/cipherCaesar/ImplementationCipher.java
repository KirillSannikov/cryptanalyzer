package com.javarush.cryptanalyzer.sannikov.cipherCaesar;

import com.javarush.cryptanalyzer.sannikov.constants.ConstImplementationCipher;

import com.javarush.cryptanalyzer.sannikov.text.bruteForce.BruteForceForDefaultText;
import com.javarush.cryptanalyzer.sannikov.text.bruteForce.BruteForceForFileEnteredWithConsole;
import com.javarush.cryptanalyzer.sannikov.text.bruteForce.BruteForceForFileWithTextUser;
import com.javarush.cryptanalyzer.sannikov.text.decryption.DecryptionFileWithTextDefault;
import com.javarush.cryptanalyzer.sannikov.text.decryption.DecryptionFileWithTextUser;
import com.javarush.cryptanalyzer.sannikov.text.decryption.DecryptionTextEnteredWithConsole;
import com.javarush.cryptanalyzer.sannikov.text.encryption.DefaultEncryption;
import com.javarush.cryptanalyzer.sannikov.text.encryption.EnteredCipherText;

import java.util.Scanner;

public class ImplementationCipher {

    static Scanner console = new Scanner(System.in);

    public static void cipher() {

        ConstImplementationCipher constImplementationCipher = new ConstImplementationCipher();

        System.out.println(constImplementationCipher.selectionExecutionProgram);
        int number = console.nextInt();

        switch (number) {
            case 1:
                System.out.println(constImplementationCipher.selectionTextForEncryption);
                int textSelection = console.nextInt();

                switch (textSelection) {
                    case 1 -> EnteredCipherText.enteredText();
                    case 2 -> DefaultEncryption.textDefault();
                    default -> System.out.print(constImplementationCipher.incorrectEnterText);
                }
            break;

            case 2:
                System.out.println(constImplementationCipher.selectionTextForDecryption);
                int textSelection1 = console.nextInt();
                switch (textSelection1){

                    case 1: DecryptionTextEnteredWithConsole.decoding();
                    break;
                    case 2:
                        System.out.println(constImplementationCipher.selectionAlreadyCreateFileForDecryption);
                        int fileSelection = console.nextInt();
                        switch (fileSelection){

                            case 1:
                                DecryptionFileWithTextUser.decodingFileUser();
                                break;
                            case 2:
                                DecryptionFileWithTextDefault.decodingDefault();
                                break;
                            default:
                                System.out.println(constImplementationCipher.incorrectEnterText);
                                break;
                        }
                        break;

                    default: System.out.print(constImplementationCipher.incorrectEnterText);
                }
            break;
            case 3:
                System.out.println(constImplementationCipher.selectionBruteForce);
                int selectionBruteForce = console.nextInt();
                switch (selectionBruteForce){
                    case 1:
                        BruteForceForFileEnteredWithConsole.enteredTextBruteForce();
                        break;
                    case 2:
                        System.out.println(constImplementationCipher.selectionAlreadyCreateFileForBruteForce);
                        int selectionFileForBruteForce = console.nextInt();
                        switch (selectionFileForBruteForce){
                            case 1:
                                BruteForceForFileWithTextUser.enteredTextBruteForce();
                                break;
                            case 2:
                                BruteForceForDefaultText.defaultTextBruteForce();
                                break;
                            default: System.out.println(constImplementationCipher.incorrectEnterText);
                        }
                        break;
                    default:
                        System.out.println(constImplementationCipher.incorrectEnterText);

                }
            break;

        default: System.out.print(constImplementationCipher.incorrectEnterText);
        }
    }
}
