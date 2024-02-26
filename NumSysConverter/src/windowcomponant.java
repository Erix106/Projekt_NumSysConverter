import javax.swing.*;

public class windowcomponant{
    private JPanel rootpanel;
    private JTextField textDez;
    private JTextField textBin;
    private JTextField textHexa;
    private JButton umrechnenButton;
    private JRadioButton dezimalRadioButton;
    private JRadioButton hexaRadioButton;
    private JRadioButton binearRadioButton;
    private JButton quizButton;


    public void radiobuttonwahl(){
        if (binearRadioButton.isSelected()){
            textBin.setText(null);
            textDez.setText(null);
            textHexa.setText(null);
        } else if (dezimalRadioButton.isSelected()){
            textBin.setText(null);
            textDez.setText(null);
            textHexa.setText(null);
        } else if (hexaRadioButton.isSelected()){
            textBin.setText(null);
            textDez.setText(null);
            textHexa.setText(null);
        }
    }


    public JPanel getRootPanel() {
        return rootpanel;
    }

    public JRadioButton getBinearRadioButton() {
        return binearRadioButton;
    }

    public JRadioButton getDezimalRadioButton() {
        return dezimalRadioButton;
    }
}
