import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;


public class Convertwindowcomponant {
    private JPanel rootpanel;
    private JTextField textDez;
    private JTextField textBin;
    private JTextField textHexa;
    private JButton umrechnenButton;
    private JButton quizButton;
    private JButton binearButton;
    private JButton dezimalButton;
    private JButton hexaButton;
    private JTextArea textArearechwegBin;
    private JTextArea textArearechwegHex;
    private JTextArea textArearechwegDez;

    public Convertwindowcomponant() {
        binearButton.addActionListener((e -> binear()));
        hexaButton.addActionListener((e -> hexa()));
        dezimalButton.addActionListener((e -> dezimal()));
        quizButton.addActionListener((e -> componentswitch()));
        umrechnenButton.addActionListener((e -> umrechnen()));
    }

    private void umrechnen() {
        if (textBin.isEnabled()) {
            // Umrechnung von Binär
            String binary = textBin.getText();
            int decimal = BinearUmrechenen.binaryToDecimal(binary);
            String rechenwegBin = generateBinaryToDecimalCalculation(binary);
            String hex = DezimalUmrechnen.decimalToHex(decimal);
            String rechenwegHex = generateBinaryToHexCalculation(binary);
            textArearechwegDez.setText("Binär zu Dezimal:\n");
            textArearechwegHex.setText("Binär zu Hexadezimal:\n");
            textArearechwegDez.append(rechenwegBin + " = " + decimal + "\n");
            textArearechwegHex.append(rechenwegHex + " = " + hex + "\n");
        } else if (textDez.isEnabled()) {
            // Umrechnung von Dezimal
            String decimalString = textDez.getText();
            int decimal = Integer.parseInt(decimalString);
            String binary = DezimalUmrechnen.decimalToBinary(decimal);
            String hex = DezimalUmrechnen.decimalToHex(decimal);
            String rechenwegBin = generateDecimalToBinaryCalculation(decimal);
            String rechenwegHex = generateDecimalToHexCalculation(decimal);
            textArearechwegHex.setText("Dezimal zu Hexadezimal:\n");
            textArearechwegBin.setText("Dezimal zu Binär:\n");
            textArearechwegHex.append(rechenwegHex + " = " + hex + "\n");
            textArearechwegBin.append(rechenwegBin + " = " + binary + "\n");
        } else if (textHexa.isEnabled()) {
            // Umrechnung von Hexadezimal
            String hex = textHexa.getText();
            int decimal = HexaUmrechnen.hexToDecimal(hex);
            String binary = HexaUmrechnen.hexToBinary(hex);
            String rechenwegDez = generateHexToDecimalCalculation(hex);
            String rechenwegBin = generateHexToBinaryCalculation(hex);
            textArearechwegDez.setText("Hexadezimal zu Dezimal:\n");
            textArearechwegBin.setText("Hexadezimal zu Binär:\n");
            textArearechwegDez.append(rechenwegDez + " = " + decimal + "\n");
            textArearechwegBin.append(rechenwegBin + " = " + binary + "\n");
        }
    }

    private String generateBinaryToDecimalCalculation(String binary) {
        StringBuilder calculation = new StringBuilder();
        int length = binary.length();
        for (int i = length - 1; i >= 0; i--) {
            int digit = binary.charAt(i) - '0';
            calculation.append("(" + digit + "*" + (int) Math.pow(2, length - i - 1) + ")");
            if (i != 0) {
                calculation.append(" + ");
            }
        }
        return calculation.toString();
    }

    private String generateDecimalToBinaryCalculation(int decimal) {
        StringBuilder calculation = new StringBuilder();
        int quotient = decimal;
        int remainder;
        String binary = "";
        while (quotient != 0) {
            remainder = quotient % 2;
            binary = remainder + binary;
            calculation.append(quotient + " / 2 = " + quotient / 2 + " Rest: " + remainder);
            if (quotient / 2 != 0) {
                calculation.append("\n");
            }
            quotient = quotient / 2;
        }
        calculation.append("= Bin " + binary);
        return calculation.toString();
    }



    private String generateDecimalToHexCalculation(int decimal) {
        StringBuilder calculation = new StringBuilder();
        int quotient = decimal;
        String hex = "";
        boolean isFirstDigit = true;

        while (quotient != 0) {
            int remainder = quotient % 16;
            char hexDigit;
            if (remainder < 10) {
                hexDigit = (char) ('0' + remainder);
            } else {
                hexDigit = (char) ('A' + remainder - 10);
            }
            hex = hexDigit + hex;
            if (!isFirstDigit) {
                calculation.insert(0, " + ");
            } else {
                isFirstDigit = false;
            }
            calculation.insert(0, "(" + quotient + " / 16 = " + quotient / 16 + " Rest: " + hexDigit + ")");
            quotient /= 16;
        }
        calculation.append("= Hex " + hex);
        return calculation.toString();
    }





    private String generateHexToDecimalCalculation(String hex) {
        StringBuilder calculation = new StringBuilder();
        int decimal = 0;
        boolean isFirstDigit = true;
        hex = hex.toUpperCase(); // Konvertiert alle Buchstaben zu Großbuchstaben
        for (int i = hex.length() - 1; i >= 0; i--) {
            int digit;
            char hexChar = hex.charAt(i);
            if (hexChar >= '0' && hexChar <= '9') {
                digit = hexChar - '0';
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                digit = hexChar - 'A' + 10;
            } else {
                // Error: Invalid hex digit
                return "Invalid hex digit";
            }
            decimal += digit * Math.pow(16, hex.length() - i - 1);
            if (!isFirstDigit) {
                calculation.insert(0, " + ");
            } else {
                isFirstDigit = false;
            }
            calculation.insert(0, "(" + digit + "*" + (int)Math.pow(16, hex.length() - i - 1) + ")");
        }
        calculation.append(" = " + decimal);
        return calculation.toString();
    }

    private String generateHexToBinaryCalculation(String hex) {
        StringBuilder calculation = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            int digit = hex.charAt(i) <= '9' ? hex.charAt(i) - '0' : hex.charAt(i) - 'A' + 10;
            String binary = Integer.toBinaryString(digit);
            if (i != 0) {
                while (binary.length() < 4) {
                    binary = "0" + binary;
                }
            }
            calculation.append("(" + binary + ")");
        }
        return calculation.toString();
    }

    private String generateBinaryToHexCalculation(String binary) {
        StringBuilder calculation = new StringBuilder();
        StringBuilder hex = new StringBuilder();
        int groupLength = 4;
        boolean isFirstGroup = true;

        for (int i = binary.length() - 1; i >= 0; i -= groupLength) {
            int start = Math.max(0, i - groupLength + 1);
            String group = binary.substring(start, i + 1);
            int decimal = Integer.parseInt(group, 2);
            String hexDigit = Integer.toHexString(decimal).toUpperCase();
            hex.insert(0, hexDigit);
            if (!isFirstGroup) {
                calculation.insert(0, "\n");
            } else {
                isFirstGroup = false;
            }
            calculation.insert(0, "(Bin " + group + ") = (Hex " + hexDigit + ")");
        }
        calculation.append(" = Hex " + hex.toString());
        return calculation.toString();
    }

    private void binear() {
        textDez.setText(null);
        textHexa.setText(null);
        textArearechwegBin.setText(null);
        textArearechwegHex.setText(null);
        textArearechwegDez.setText(null);
        textBin.setEnabled(true);
        textDez.setEnabled(false);
        textHexa.setEnabled(false);
    }

    private void hexa() {
        textBin.setText(null);
        textDez.setText(null);
        textArearechwegBin.setText(null);
        textArearechwegHex.setText(null);
        textArearechwegDez.setText(null);
        textHexa.setEnabled(true);
        textDez.setEnabled(false);
        textBin.setEnabled(false);
    }

    private void dezimal() {
        textBin.setText(null);
        textHexa.setText(null);
        textArearechwegBin.setText(null);
        textArearechwegHex.setText(null);
        textArearechwegDez.setText(null);
        textDez.setEnabled(true);
        textHexa.setEnabled(false);
        textBin.setEnabled(false);
    }

    private void componentswitch() {
        windowtwo w2 = new windowtwo();
        w2.setVisible(true);
    }



    public JPanel getRootPanel() {
        return rootpanel;
    }
}
