package com.javarush.cryptanalyzer.sannikov;
import com.javarush.cryptanalyzer.sannikov.cipherCaesar.ImplementationCipher;
import com.javarush.cryptanalyzer.sannikov.swimg.Swing;

import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {

        //ImplementationCipher.cipher();
        try{
            FileOutputStream fout=new FileOutputStream("testout.txt");
            fout.write(65);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}

    }
}




