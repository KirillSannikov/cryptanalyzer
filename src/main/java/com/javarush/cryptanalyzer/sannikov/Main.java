package com.javarush.cryptanalyzer.sannikov;

import com.javarush.cryptanalyzer.sannikov.exception.FileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static int modulo(int n, int modulus) {
        if(n < 0) return n%modulus + modulus;
        return n%modulus;
    }
    public static void main(String[] args) {
         String text = "";
        try (BufferedReader bufferedWriter = new BufferedReader (new FileReader("C:\\Users\\user\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\sannikov\\file\\input.txt"))) {
            while (bufferedWriter.ready()){
                 text = bufferedWriter.readLine();




            }
        } catch (FileException | IOException e){
            System.out.println("пустой файл" + e.getMessage());
        }
        System.out.println(text);

        Scanner console = new Scanner(System.in);
        System.out.println("Для шифрования введите 1, расшифрования – 2, метод brute force (поиск грубой силой) - 3 ");
        int number = console.nextInt();


        switch (number) {

            case 1:
                System.out.println("Введите ключ ");
                int encryption_key = console.nextInt();
//                System.out.println("Введите текст для шифрования ");
//                String line = console.next();
                console.close();

                char[] symbol = new char[text.length()];

                for (int i = 0; i < text.length(); i++) {
                    if (Character.isLetter(text.charAt(i)) && Character.isUpperCase(text.charAt(i))){
                    symbol[i] = (char) ((modulo((((int) (text.charAt(i))) - 'А' + encryption_key), 33)) + 'А');
                    }

                    else if (Character.isLetter(text.charAt(i)) && Character.isLowerCase(text.charAt(i))) {
                        symbol[i] = (char) ((modulo((((int) (text.charAt(i))) - 'а' + encryption_key), 33)) + 'а');
                    }
                    else {
                        symbol[i] = text.charAt(i);
                    }
                }
                String line2 = String.copyValueOf(symbol);

                System.out.println("Зашифрованный текст: " + line2);
                break;

            case 2:
                System.out.println("Введите ключ ");
                int encryption_key1 = console.nextInt();
                System.out.println("Введите текст для шифрования ");
                String line1 = console.next();
                console.close();

                char[] symbol1 = new char[line1.length()];

                for (int i = 0; i < line1.length(); i++) {
                    if (Character.isLetter(line1.charAt(i)) && Character.isUpperCase(line1.charAt(i))) {
                        symbol1[i] = (char) (((((int) (line1.charAt(i))) - 'А' - encryption_key1) % 33) + 'А');
                    }
                    else if (Character.isLetter(line1.charAt(i)) && Character.isLowerCase(line1.charAt(i))) {
                        symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 'а' - encryption_key1), 33)) + 'а');
                    }
                    else {
                        symbol1[i] = line1.charAt(i);
                    }
                }
                String line21 = String.copyValueOf(symbol1);

                System.out.println("Зашифрованный текст: " + line21);
                break;

            case 3:
                System.out.print ("Введите зашифрованный текст, для взлома методом brute force ");
                String line3 = console.next();
                console.close();
                char[] symbol3 = new char[line3.length()];

                int encryption_key3 = 1;
                while (encryption_key3!=34){

                    for (int i = 0; i < line3.length(); i++) {
                        if (Character.isLetter(line3.charAt(i)) && Character.isUpperCase(line3.charAt(i))){
                            symbol3[i] = (char) (((((int) (line3.charAt(i))) - 'А' - encryption_key3 + 33) % 33) + 'А');
                        }
                        if (Character.isLetter(line3.charAt(i)) && Character.isLowerCase(line3.charAt(i))){
                            symbol3[i] = (char) (((((int) (line3.charAt(i))) - 'а' - encryption_key3 + 33) % 33) + 'а');
                        }
                        else {
                            symbol3[i] = line3.charAt(i);
                        }

                    }

                    System.out.print ("Расшифровка текста " + line3 + " c ключом " + encryption_key3 + ": " );
                    System.out.println (symbol3);
                    encryption_key3 ++;

                }


        }

    }
}




















































//
//    public static int modulo(int n, int modulus) {
//        if(n < 0) return n%modulus + modulus;
//        return n%modulus;
//    }
//    public static void main(String[] args) {
//        String text = "";
//        try (BufferedReader bufferedWriter = new BufferedReader (new FileReader("C:\\Users\\user\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\sannikov\\file\\input.txt"))) {
//            while (bufferedWriter.ready()){
//                text = bufferedWriter.readLine();
//            }
//        } catch (FileException | IOException e){
//            System.out.println("пустой файл" + e.getMessage());
//        }
//        System.out.println(text);
//
//        Scanner console = new Scanner(System.in);
//        System.out.println("Для шифрования введите 1, расшифрования – 2, метод brute force (поиск грубой силой) - 3 ");
////        int number = console.nextInt();
////
////
////        switch (number) {
////
////            case 1:
//        System.out.println("Введите ключ ");
//        int encryption_key = console.nextInt();
////                System.out.println("Введите текст для шифрования ");
////                String line = console.next();
//        console.close();
//
//        char[] symbol = new char[text.length()];
//
//        for (int i = 0; i < text.length(); i++) {
//            if (Character.isLetter(text.charAt(i)) && Character.isUpperCase(text.charAt(i))){
//                symbol[i] = (char) ((modulo((((int) (text.charAt(i))) - 'А' + encryption_key), 33)) + 'А');
//            }
//
//            else if (Character.isLetter(text.charAt(i)) && Character.isLowerCase(text.charAt(i))) {
//                symbol[i] = (char) ((modulo((((int) (text.charAt(i))) - 'а' + encryption_key), 33)) + 'а');
//            }
//            else {
//                symbol[i] = text.charAt(i);
//            }
//        }
//        String line2 = String.copyValueOf(symbol);
//
//        System.out.println("Зашифрованный текст: " + String.format(line2));
//                break;
//
//            case 2:
//                System.out.println("Введите ключ ");
//                int encryption_key1 = console.nextInt();
//                System.out.println("Введите текст для шифрования ");
//                String line1 = console.next();
//                console.close();
//
//                char[] symbol1 = new char[line1.length()];
//
//                for (int i = 0; i < line1.length(); i++) {
//                    if (Character.isLetter(line1.charAt(i)) && Character.isUpperCase(line1.charAt(i))) {
//                        symbol1[i] = (char) (((((int) (line1.charAt(i))) - 'А' - encryption_key1) % 33) + 'А');
//                    }
//                    else if (Character.isLetter(line1.charAt(i)) && Character.isLowerCase(line1.charAt(i))) {
//                        symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 'а' - encryption_key1), 33)) + 'а');
//                    }
//                    else {
//                        symbol1[i] = line1.charAt(i);
//                    }
//                }
//                String line21 = String.copyValueOf(symbol1);
//
//                System.out.println("Зашифрованный текст: " + line21);
//                break;
//
//            case 3:
//                System.out.print ("Введите зашифрованный текст, для взлома методом brute force ");
//                String line3 = console.next();
//                console.close();
//                char[] symbol3 = new char[line3.length()];
//
//                int encryption_key3 = 1;
//                while (encryption_key3!=34){
//
//                    for (int i = 0; i < line3.length(); i++) {
//                        if (Character.isLetter(line3.charAt(i)) && Character.isUpperCase(line3.charAt(i))){
//                            symbol3[i] = (char) (((((int) (line3.charAt(i))) - 'А' - encryption_key3 + 33) % 33) + 'А');
//                        }
//                        if (Character.isLetter(line3.charAt(i)) && Character.isLowerCase(line3.charAt(i))){
//                            symbol3[i] = (char) (((((int) (line3.charAt(i))) - 'а' - encryption_key3 + 33) % 33) + 'а');
//                        }
//                        else {
//                            symbol3[i] = line3.charAt(i);
//                        }
//
//                    }
//
//                    System.out.print ("Расшифровка текста " + line3 + " c ключом " + encryption_key3 + ": " );
//                    System.out.println (symbol3);
//                    encryption_key3 ++;
//
//                }
//
//
//        }

//    }









//
//
//       Scanner console = new Scanner(System.in);
//        String text = "Алексей поехал домой";
//        char letter;
//        int key = console.nextInt();
//        String changeText;
//        int letterInChangeText = 0;


//        Pattern pattern = Pattern.compile("$");
//        String[] strings = pattern.split(ConstAlphabet.ALPHABET);
//        for (String s : strings) {
//            System.out.println(s);
//
//            for (int i = 0; i <ConstAlphabet.ALPHABET.length(); i++) {
//                letter = s.charAt(i);
//                letterInChangeText = (letter + key);
//
//                System.out.print(Character.toString(letterInChangeText));
//
//            }
//
//        }


//        Scanner console = new Scanner(System.in);
//
//        String [] alphabet = new String[]{ConstAlphabet.ALPHABET};
//        String text = "Алексей поехал домой";
//        char letter;
//        int key = console.nextInt();
//       String changeText;
//       int letterInChangeText = 0;
//
//        System.out.println(text);
//
//        for (int i = 0; i < ConstAlphabet.ALPHABET.length(); i++) {
//            letter = ConstAlphabet.ALPHABET.charAt(i);
//            if ((letter >= 'А' && letter <= '?') && (letter == 32 )){
//               letterInChangeText = (letter + key);
//                System.out.print(Character.toString(letterInChangeText));
//            }
//
//            System.out.println(letterInChangeText);
//
//        }




