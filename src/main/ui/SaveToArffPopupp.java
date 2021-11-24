package ui;

import model.ArffWriter;
import model.EntryM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class SaveToArffPopupp implements ActionListener {
    List<EntryM> loe;
    JTextField tf;
    JButton save;

    public SaveToArffPopupp(List<EntryM> loe) {
        tf = new JTextField();
        save = new JButton("save");
        this.loe = loe;


        JDialog saveToArffPopup = new JDialog();
        saveToArffPopup.setSize(new Dimension(1500,500));
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
        JTextArea ta2 = new JTextArea("now enter a filename for your model entries to be written as a arff file in "
                + "the project root directory. then restart the program. ");
        ta2.setSize(ta2.getPreferredSize());
        ta2.setVisible(true);
        mainpanel.add(ta2);
        tf.setMinimumSize(new Dimension(200,30));
        tf.setMaximumSize(new Dimension(300,30));
        tf.setVisible(true);
        save.setMinimumSize(new Dimension(60,30));
        save.setVisible(true);
        save.addActionListener(this);

        mainpanel.add(tf);
        mainpanel.add(save);
        saveToArffPopup.add(mainpanel);
        saveToArffPopup.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filename = tf.getText();

        ArffWriter af = new ArffWriter();

        try {
            String newfn = af.createArffFromModelEntries(loe, filename);
            JDialog success = new JDialog();
            success.setLayout(new BorderLayout());
            success.setSize(new Dimension(600,300));

            JTextArea ta1 = new JTextArea("success." + "your file name is: " + newfn
                    + ".   now restart the program");



            success.add(ta1);
            success.setVisible(true);

        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }
}
