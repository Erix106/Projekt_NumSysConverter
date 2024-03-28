import javax.swing.*;

public class Quizwindowcomponant {
    private JPanel QuizPanle;
    private JTextField textAntwort;
    private JTextField textzufalzahl;
    private JButton converterButton;
    private JButton neueZufallszahlButton;
    private JButton antwortAbgabeButton;


    public Quizwindowcomponant(){
        converterButton.addActionListener((e -> componentswitch()));
    }

    public void componentswitch() {
        windowtwo w2= new windowtwo();
        w2.setVisible(false);
        window w= new window();
        w.setVisible(true);
    }

    public JPanel getQuizPanle() {
        return QuizPanle;
    }
}
