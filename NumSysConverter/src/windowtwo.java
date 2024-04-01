import javax.swing.*;
import java.awt.*;

public class windowtwo extends JFrame{
    public windowtwo()  {
        // sichtbar machen
        setVisible(false);
        // Größe setzen
        setPreferredSize(new Dimension(800, 600));

        // Titel setzen
        setTitle("Umrechnen Pruefung");

        // Close on Exit, d.h. Programm beenden wenn oben rechts X gedrückt wird
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // jetzt kommt: Inhalt!

        // Objekt vom Typ FensterComponent erstellen
        Quizwindowcomponant inhaltComponenttwo=new Quizwindowcomponant();

        // Zugriff auf das RootPanel in der inhaltComponent
        // und setzen als ContentPane (als Inhalt)
        setContentPane(inhaltComponenttwo.getQuizPanle());

        // Pack immer ganz unten
        pack();



    }
}
