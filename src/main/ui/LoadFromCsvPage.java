package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadFromCsvPage {
    String filePath;

    public LoadFromCsvPage() {
        filePath = "";
        JFrame f = new JFrame();
        f.setSize(1000,800);
        f.setBackground(Color.GRAY);

        JFileChooser chooser = new JFileChooser();
        chooser.setBounds(0, 0, 800, 800);
        chooser.setVisible(true);

        f.add(chooser);
        f.setVisible(true);//making the frame visible

    }

    private void handleFilechooser() {

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//    }
}




