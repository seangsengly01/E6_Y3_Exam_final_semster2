package org.e6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        // Create components
        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField(10);

        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField(10);

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(firstNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(secondNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(secondNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(resultLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(resultField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(subButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        add(mulButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(divButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(modButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        add(clearButton, gbc);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = firstNumber + secondNumber;
            } else if (e.getSource() == subButton) {
                result = firstNumber - secondNumber;
            } else if (e.getSource() == mulButton) {
                result = firstNumber * secondNumber;
            } else if (e.getSource() == divButton) {
                result = firstNumber / secondNumber;
            } else if (e.getSource() == modButton) {
                result = firstNumber % secondNumber;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
