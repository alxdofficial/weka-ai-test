package ui;

import model.EntryC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChooseArffForClassification implements ActionListener {
    List<EntryC> loe;
    JTextField tf;
    JButton choose;

    @SuppressWarnings({"checkstyle:LocalVariableName", "checkstyle:SuppressWarnings"})
    public ChooseArffForClassification(List<EntryC> loe) {
        tf = new JTextField();
        choose = new JButton("choose");
        this.loe = loe;


        JDialog ChooseArffPopup = new JDialog();
        ChooseArffPopup.setSize(new Dimension(1500,500));
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
        JTextArea ta2 = new JTextArea("now enter the filename of the arff file you want to use to classify your new "
                + "Entries.");
        ta2.setSize(ta2.getPreferredSize());
        ta2.setVisible(true);
        mainpanel.add(ta2);
        tf.setMinimumSize(new Dimension(200,30));
        tf.setMaximumSize(new Dimension(300,30));
        tf.setVisible(true);
        choose.setMinimumSize(new Dimension(60,30));
        choose.setVisible(true);
        choose.addActionListener(this);

        mainpanel.add(tf);
        mainpanel.add(choose);
        ChooseArffPopup.add(mainpanel);
        ChooseArffPopup.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filename = tf.getText();
        ClassificationPage classificationPage = new ClassificationPage(loe,filename);
    }
}
