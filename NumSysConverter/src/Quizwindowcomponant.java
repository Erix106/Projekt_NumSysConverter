import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Quizwindowcomponant {
    private JPanel QuizPanle;
    private JTextField textAntwort;
    private JTextField textzufalzahl;
    private JButton converterButton;
    private JButton neueZufallszahlButton;
    private JButton antwortAbgabeButton;

    private String generatedBinary;

    public Quizwindowcomponant() {
        converterButton.addActionListener((e -> componentswitch()));
        neueZufallszahlButton.addActionListener((e -> generateRandomBinary()));
        antwortAbgabeButton.addActionListener((e -> checkAnswer()));
    }

    private void componentswitch() {
        window w = new window();
        w.setVisible(true);
        w.getDefaultCloseOperation();
    }




    private void generateRandomBinary() {
        Random random = new Random();
        int randomNumber = random.nextInt(256); // Generating random number between 0 to 255
        generatedBinary = DezimalUmrechnen.decimalToBinary(randomNumber);
        textzufalzahl.setText(generatedBinary);
        textAntwort.setText(""); // Clearing the answer field
    }

    private void checkAnswer() {
        String answer = textAntwort.getText();
        int answerDecimal = Integer.parseInt(answer);
        int generatedDecimal = BinearUmrechenen.binaryToDecimal(generatedBinary);
        if (answerDecimal == generatedDecimal) {
            JOptionPane.showMessageDialog(null, "Korrekt!");
        } else {
            JOptionPane.showMessageDialog(null, "Falsch. Die richtige Antwort ist: " + generatedDecimal);
        }
    }

    public JPanel getQuizPanle() {
        return QuizPanle;
    }
}
