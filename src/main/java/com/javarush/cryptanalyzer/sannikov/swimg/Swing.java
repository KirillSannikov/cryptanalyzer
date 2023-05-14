package com.javarush.cryptanalyzer.sannikov.swimg;

import com.javarush.cryptanalyzer.sannikov.constants.ConstImplementationCipher;

import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame {

    public static void swingStart() {
        JFrame frame = new JFrame("Секретный текст");
        JButton button = new JButton("Enter");
        JButton button1 = new JButton("Расшифровать");
        JButton button2 = new JButton("Засшифровать");
        JButton button3 = new JButton("BruteForce");
        JLabel mainText = new JLabel("Добро пожаловать дорогой пользователь!");
        JLabel mainText2 = new JLabel("С помощью приложения вы сможете расшифровать и зашифровать текст");
        JLabel mainText3 = new JLabel("Для запуска программы нажмите - Enter");


        mainText.setBounds(115, 90, 350, 30);
        mainText2.setBounds(25, 130, 500, 30);
        mainText3.setBounds(120, 170, 350, 30);

        button.setBounds(200, 250, 85, 25);
        button1.setBounds(100, 250, 85, 25);
        button2.setBounds(200, 250, 100, 25);
        button3.setBounds(300, 250, 100, 25);
        button.setBackground(Color.ORANGE);
        button1.setBackground(Color.GREEN);
        button2.setBackground(Color.GREEN);
        button3.setBackground(Color.GREEN);

        frame.add(button);

        frame.add(mainText);
        frame.add(mainText2);
        frame.add(mainText3);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);


        ConstImplementationCipher constImplementationCipher = new ConstImplementationCipher();
        button.addActionListener(e -> mainText.setText("Выберите режим данной программы"));
        button.addActionListener(e -> mainText2.setText(""));
        button.addActionListener(e -> mainText3.setText(""));
        button.addActionListener(e -> frame.remove(button));
        button.addActionListener(e -> frame.add(button1));
        button.addActionListener(e -> frame.add(button2));
        button.addActionListener(e -> frame.add(button3));


    }
}

