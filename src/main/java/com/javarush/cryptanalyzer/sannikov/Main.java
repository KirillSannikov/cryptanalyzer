package com.javarush.cryptanalyzer.sannikov;
import com.javarush.cryptanalyzer.sannikov.exception.FileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int modulo(int n, int modulus) {
        if (n < 0) return n % modulus + modulus;
        return n % modulus;
    }

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        String text = "";
        try (BufferedReader bufferedWriter = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\cryptanalyzer\\src\\main\\java\\com\\javarush\\cryptanalyzer\\sannikov\\file\\input.txt"))) {
            while (bufferedWriter.ready()) {
                text = bufferedWriter.readLine();
            }
        } catch (FileException | IOException e) {
            System.out.println("пустой файл" + e.getMessage());
        }

        System.out.println("Для шифрования введите - 1, расшифрования – 2, метод brute force (поиск грубой силой) - 3 ");
        int number = console.nextInt();

        switch (number) {
            case 1:

                System.out.println("Для шифрования своего текста введите - 1 , для выбора текста по умолчанию - 2");
                int textSelection = console.nextInt();

                switch (textSelection) {

                    case 1:

                        System.out.println("Введите текст: ");
                        Scanner scanner = new Scanner(System.in);
                        String consoleText = scanner.nextLine();

                        System.out.println("Введите ключ ");
                        int key = console.nextInt();
                        console.close();
                        scanner.close();

                        String letter = "";
                        int modifiedLetter = 0;
                        int letterFormula = 0;

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
                        System.out.println(letter); // выводимый текст
                        break;

                    case 2:
                        System.out.println("Текст выбран по умолчанию");
                        System.out.println("Введите ключ ");

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
                                letterFormula = (modifiedLetter1 - 57) % 7 + 57;
                                letter1 += (char) letterFormula1;
                            }
                        }
                        System.out.println(letter1);
                        break;
                    default:
                        System.out.print("Неверный ввод");
                }
                break;

            case 2:
                String letter1 = "";
                System.out.println("Введите текст для расшифрования ");
                String line1 = console.next();
                System.out.println("Введите ключ ");
                int key = console.nextInt();
                console.close();

                char[] symbol1 = new char[line1.length()];

                for (int i = 0; i < line1.length(); i++) {
                    int a = line1.charAt(i);

                    if (a <= 1071 && a >= 1040) {
                        symbol1[i] = (char) (((((int) (line1.charAt(i))) - 1040 - key) % 32) + 1040);
                        letter1 += (char) symbol1[i];

                    } else if (a > 1071) {
                        symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 1072 - key), 32)) + 1072);
                        letter1 += (char) symbol1[i];

                    } else if (a >= 32 && a <= 47) {
                        symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 32 - key), 16)) + 32);
                        letter1 += (char) symbol1[i];

                    } else if (a > 47 && a <= 57) {
                        symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 47 - key), 10)) + 47);
                        letter1 += (char) symbol1[i];

                    } else if (a > 57 && a <= 64) {
                        symbol1[i] = (char) ((modulo((((int) (line1.charAt(i))) - 57 - key), 7)) + 57);
                        letter1 += (char) symbol1[i];
                    }

                }

                System.out.println("Расшифрованный текст: " + letter1);
                break;

            case 3:
                System.out.print("Введите зашифрованный текст, для взлома методом brute force ");
                String line3 = console.next();
                console.close();
                String letter3 = "";
                char[] symbol3 = new char[line3.length()];

                int key3 = 1;
                while (key3 != 98) {

                    for (int i = 0; i < line3.length(); i++) {
                        int a = line3.charAt(i);

                        if (a <= 1071 && a >= 1040) {
                            symbol3[i] = (char) (((((int) (line3.charAt(i))) - 1040 - key3) % 32) + 1040);
                            letter3 += (char) symbol3[i];

                        } else if (a > 1071) {
                            symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 1072 - key3), 32)) + 1072);
                            letter3 += (char) symbol3[i];

                        } else if (a >= 32 && a <= 47) {
                            symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 32 - key3), 16)) + 32);
                            letter3 += (char) symbol3[i];

                        } else if (a > 47 && a <= 57) {
                            symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 47 - key3), 10)) + 47);
                            letter3 += (char) symbol3[i];

                        } else if (a > 57 && a <= 64) {
                            symbol3[i] = (char) ((modulo((((int) (line3.charAt(i))) - 57 - key3), 7)) + 57);
                            letter3 += (char) symbol3[i];
                        }

                    }

                    System.out.print("Расшифровка текста " + line3 + " c ключом " + key3 + ": ");
                    System.out.println(symbol3);
                    key3++;
                }
                break;
            default:
                System.out.print("Неверный ввод");



        }
    }
}




