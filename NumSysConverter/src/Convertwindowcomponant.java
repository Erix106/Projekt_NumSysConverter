import javax.swing.*;
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

    public Convertwindowcomponant(){
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
            if (!binary.matches("[01]+")) {
                JOptionPane.showMessageDialog(null, "Ungültige Eingabe für Binär.");
                return;
            }
            int decimal = BinearUmrechenen.binaryToDecimal(binary);
            textDez.setText(Integer.toString(decimal));
            textHexa.setText(DezimalUmrechnen.decimalToHex(decimal));
            textHexa.setEnabled(false);
            textDez.setEnabled(false);
            textBin.setEnabled(false);
        } else if (textDez.isEnabled()) {
            // Umrechnung von Dezimal
            String decimalString = textDez.getText();
            if (!decimalString.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Ungültige Eingabe für Dezimal.");
                return;
            }
            int decimal = Integer.parseInt(decimalString);
            textBin.setText(DezimalUmrechnen.decimalToBinary(decimal));
            textHexa.setText(DezimalUmrechnen.decimalToHex(decimal));
            textHexa.setEnabled(false);
            textDez.setEnabled(false);
            textBin.setEnabled(false);
        } else if (textHexa.isEnabled()) {
            // Umrechnung von Hexadezimal
            String hex = textHexa.getText();
            if (!hex.matches("[0-9A-Fa-f]+")) {
                JOptionPane.showMessageDialog(null, "Ungültige Eingabe für Hexadezimal.");
                return;
            }
            int decimal = HexaUmrechnen.hexToDecimal(hex);
            textBin.setText(HexaUmrechnen.hexToBinary(hex));
            textDez.setText(Integer.toString(decimal));
            textHexa.setEnabled(false);
            textDez.setEnabled(false);
            textBin.setEnabled(false);
        }
    }


    public void textfield(){
        textBin.setText(null);
        textHexa.setText(null);
        textDez.setText(null);
        textArearechwegBin.setText(null);
        textArearechwegHex.setText(null);
        textArearechwegDez.setText(null);
    }

    public void hexa(){
        textfield();
        textHexa.setEnabled(true);
        textDez.setEnabled(false);
        textBin.setEnabled(false);
    }

    public void binear(){
        textfield();
        textBin.setEnabled(true);
        textDez.setEnabled(false);
        textHexa.setEnabled(false);
    }

    public void dezimal(){
        textfield();
        textDez.setEnabled(true);
        textHexa.setEnabled(false);
        textBin.setEnabled(false);
    }

    public void componentswitch() {
        windowtwo w2 = new windowtwo();
        w2.setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootpanel;
    }
}
