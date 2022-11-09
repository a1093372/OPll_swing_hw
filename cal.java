import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cal extends JFrame implements ActionListener {
    JButton[] numberButtons = new JButton[10];
    /*
     * numberButtons[0] = 0
     * numberButtons[1] = 1
     * numberButtons[2] = 2
     * numberButtons[3] = 3
     * numberButtons[4] = 4
     * numberButtons[5] = 5
     * numberButtons[6] = 6
     * numberButtons[7] = 7
     * numberButtons[8] = 8
     * numberButtons[9] = 9
     */
    JButton[] operatorButtons = new JButton[5];
    /*
     * operatorButtons[0] = +
     * operatorButtons[1] = -
     * operatorButtons[2] = *
     * operatorButtons[3] = =
     * operatorButtons[4] = /
     */
    JButton initButton = new JButton("init");
    JPanel panel = new JPanel();
    JPanel numberPanel = new JPanel();
    JTextField textField = new JTextField();
    char operator;
    double num1 = 0, num2 = 0, result = 0;

    public cal() {
        setTitle("Calculator");
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 350, 550);
        textField.setEditable(false);
        textField.setBounds(10, 10, 500, 40);
        textField.setFont(new Font(textField.getFont().getName(), textField.getFont().getStyle(), 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        numberPanel.setLayout(new GridLayout(5, 3, 10, 20));
        numberPanel.setBounds(10, 70, 310, 350);
        initButton.setBounds(10, 440, 310, 40);
        initButton.addActionListener(this);
        add(textField);
        add(numberPanel);
        add(initButton);

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(Integer.toString(i));
            numberButtons[i].addActionListener(this);
            if (i == 0)
                continue;
            numberPanel.add(numberButtons[i]);
        }
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("=");
        operatorButtons[4] = new JButton("/");
        for (int i = 0; i < operatorButtons.length; i++) {
            operatorButtons[i].addActionListener(this);
            if (i == 0) {
                numberPanel.add(operatorButtons[0]);
                numberPanel.add(numberButtons[0]);
                continue;
            }
            numberPanel.add(operatorButtons[i]);
        }

    }

    public static void main(String[] args) {
        new cal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == operatorButtons[0]) {
            num1 = getText();
            operator = '+';
        }
        if (e.getSource() == operatorButtons[1]) {
            num1 = getText();
            operator = '-';
        }
        if (e.getSource() == operatorButtons[2]) {
            num1 = getText();
            operator = '*';
        }
        if (e.getSource() == operatorButtons[4]) {
            num1 = getText();
            operator = '/';
        }
        if (e.getSource() == operatorButtons[3]) {
            num2 = Double.parseDouble(textField.getText());
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
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == initButton) {
            num1 = 0;
            num2 = 0;
            textField.setText("");
        }
    }

    public double getText() {
        double text = 0.0;
        if (textField.getText() == "")
            text = 0.0;
        text = Double.parseDouble(textField.getText());
        textField.setText("");

        return text;
    }
}