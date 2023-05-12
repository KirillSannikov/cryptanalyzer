package com.javarush.cryptanalyzer.sannikov;
import com.javarush.cryptanalyzer.sannikov.cipherCaesar.ImplementationCipher;
import com.javarush.cryptanalyzer.sannikov.exception.FileException;
import com.javarush.cryptanalyzer.sannikov.text.encryption.DefaultEncryption;
import com.javarush.cryptanalyzer.sannikov.text.encryption.EnteredTextEncryption;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ImplementationCipher.cipher();

    }
}




