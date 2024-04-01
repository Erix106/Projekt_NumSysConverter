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
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;


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
            textDez.setText(String.valueOf(BinearUmrechenen.binaryToDecimal(binary)));
            textHexa.setText(BinearUmrechenen.binaryToHex(binary));
        } else if (textDez.isEnabled()) {
            // Umrechnung von Dezimal
            int decimal = Integer.parseInt(textDez.getText());
            textBin.setText(DezimalUmrechnen.decimalToBinary(decimal));
            textHexa.setText(DezimalUmrechnen.decimalToHex(decimal));
        } else if (textHexa.isEnabled()) {
            // Umrechnung von Hexadezimal
            String hex = textHexa.getText();
            textBin.setText(HexaUmrechnen.hexToBinary(hex));
            textDez.setText(String.valueOf(HexaUmrechnen.hexToDecimal(hex)));
        }
    }

    public void textfield(){
        textBin.setText(null);
        textHexa.setText(null);
        textDez.setText(null);
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
        windowtwo w2= new windowtwo();
        w2.setVisible(true);
       }

    public JPanel getRootPanel() {
        return rootpanel;
    }

}
