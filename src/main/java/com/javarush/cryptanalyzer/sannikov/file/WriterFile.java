package com.javarush.cryptanalyzer.sannikov.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;

public class WriterFile  {
        String src = "c:\\projects\\log.txt";
        try( FileReader fileReader= new FileReader(src);
    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileReader)){


        }

}
