import javax.swing.*;
import java.awt.*;

public class window extends JFrame{
    public window()  {
        // sichtbar machen
        setVisible(true);

        // Größe setzen
        setPreferredSize(new Dimension(800, 600));

        // Titel setzen
        setTitle("Umrechner");

        // Close on Exit, d.h. Programm beenden wenn oben rechts X gedrückt wird
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // jetzt kommt: Inhalt!
        // Objekt vom Typ FensterComponent erstellen
        Convertwindowcomponant inhaltComponent=new Convertwindowcomponant();

        // Zugriff auf das RootPanel in der inhaltComponent
        // und setzen als ContentPane (als Inhalt)
        setContentPane(inhaltComponent.getRootPanel());

        // Pack immer ganz unten
        pack();



    }
}
