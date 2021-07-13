/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This code is written by Hoang Minh
 *
 * @author DELL
 */
public class calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addBt, subBt, mulBt, divBt;
    JButton decBt, equBt, delBt, clrBt, negBt;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setBackground(Color.GRAY);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addBt = new JButton("+");
        subBt = new JButton("-");
        mulBt = new JButton("*");
        divBt = new JButton("/");
        decBt = new JButton(".");
        equBt = new JButton("=");
        delBt = new JButton("Del");
        clrBt = new JButton("Clr");
        negBt = new JButton("(-)");

        funcButtons[0] = addBt;
        funcButtons[1] = subBt;
        funcButtons[2] = mulBt;
        funcButtons[3] = divBt;
        funcButtons[4] = decBt;
        funcButtons[5] = equBt;
        funcButtons[6] = delBt;
        funcButtons[7] = clrBt;
        funcButtons[8] = negBt;

        for (int i = 0; i < 9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }
        negBt.setBounds(50, 430, 100, 50);
        delBt.setBounds(150, 430, 100, 50);
        clrBt.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);
        panel.setVisible(true);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addBt);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subBt);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulBt);
        panel.add(decBt);
        panel.add(numButtons[0]);
        panel.add(numButtons[0]);
        panel.add(equBt);
        panel.add(divBt);

        frame.add(panel);
        frame.add(negBt);
        frame.add(delBt);
        frame.add(clrBt);
        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decBt) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addBt) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subBt) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulBt) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divBt) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if (e.getSource() == equBt) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrBt) {
            textfield.setText("");
        }
        if (e.getSource() == delBt) {
            String str = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                textfield.setText(textfield.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == negBt) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }

}
