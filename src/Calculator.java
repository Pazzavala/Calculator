import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    JTextField screen = new JTextField();

    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton,
    decButton, equButton, negButton, delButton, clrButton;

    JPanel buttonsPanel = new JPanel();

    Font font = new Font("Tahoma", Font.PLAIN, 30);

    Calculator() {
        this.setTitle("Calculator");
        this.setSize(420, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        screen.setFont(font);
        screen.setEditable(false);
        screen.setBackground(Color.DARK_GRAY);
        screen.setForeground(Color.GREEN);
        screen.setBounds(50, 25, 300, 60);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        negButton = new JButton("-/+");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = negButton;
        funcButtons[7] = delButton;
        funcButtons[8] = clrButton;

        for (int i = 0; i < funcButtons.length; i++) {
            funcButtons[i].setFont(font);
            funcButtons[i].setFocusable(false);
            funcButtons[i].addActionListener(this);
        }

        negButton.setBounds(50, 430, 95, 50);
        delButton.setBounds(152, 430, 95, 50);
        clrButton.setBounds(255, 430, 95, 50);

        buttonsPanel.setBounds(50, 100, 300, 300);
        buttonsPanel.setLayout(new GridLayout(4, 4, 6, 6));

        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(font);
            numButtons[i].setFocusable(false);
            numButtons[i].addActionListener(this);
        }

        for (int i = 0, j = 0; i < 16; i++) {
            if (i == 3)
                buttonsPanel.add(addButton);
            else if (i == 7)
                buttonsPanel.add(subButton);
            else if (i == 11)
                buttonsPanel.add(mulButton);
            else if (i == 12)
                buttonsPanel.add(decButton);
            else if (i == 14)
                buttonsPanel.add(equButton);
            else if (i == 15)
                buttonsPanel.add(divButton);
            else
                buttonsPanel.add(numButtons[j++]);
        }

        this.add(screen);
        this.add(buttonsPanel);
        this.add(negButton);
        this.add(delButton);
        this.add(clrButton);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton numButton : numButtons)
            if (e.getSource() == numButton)
                screen.setText(screen.getText().concat(numButton.getText()));

        if (e.getSource() == decButton)
            screen.setText(screen.getText().concat(decButton.getText()));
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(screen.getText());
            operator = addButton.getText().charAt(0);
            screen.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(screen.getText());
            operator = subButton.getText().charAt(0);
            screen.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(screen.getText());
            operator = mulButton.getText().charAt(0);
            screen.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(screen.getText());
            operator = divButton.getText().charAt(0);
            screen.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(screen.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }

            screen.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(screen.getText());
            temp *= -1;
            screen.setText(String.valueOf(temp));
        }
        if (e.getSource() == clrButton) {
            screen.setText("");
        }
        if (e.getSource() == delButton) {
            String eqn = screen.getText();
            screen.setText("");

            for (int i = 0; i < eqn.length() - 1; i++) {
                screen.setText(screen.getText() + eqn.charAt(i));
            }
        }
    }
}
