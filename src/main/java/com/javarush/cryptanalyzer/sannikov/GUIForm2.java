package com.javarush.cryptanalyzer.sannikov;

import com.javarush.cryptanalyzer.sannikov.constants.ConstImplementationCipher;

import javax.swing.*;

public class GUIForm2 extends JFrame{
    private JPanel NextMainPanel;
    private JButton encryptionButton;
    private JButton bruteForceButton;
    private JButton decryptionButton;
    private JTextArea textPanel2;

    public GUIForm2() {
        initComponents1();
        addActionListenerClickHere1();
        displayThisWindow1();
    }

    public void initComponents1(){


        this.add(NextMainPanel);

    }

    private void displayThisWindow1(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setVisible(true);
    }

    private void addActionListenerClickHere1(){
        ConstImplementationCipher constImplementationCipher = new ConstImplementationCipher();
        //enterButton.addActionListener(e -> mainText.setText(constImplementationCipher.selectionExecutionProgram));
       // enterButton.addActionListener(e -> mainPanel.setUI());
        //enterButton.addActionListener(e -> mainPanel.set);
    }

}
