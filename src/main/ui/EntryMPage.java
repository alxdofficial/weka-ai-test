package ui;

import model.Entry;
import model.EntryM;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EntryMPage {
    private List<EntryM> loe;
    private JFrame frame;

    public EntryMPage() {
        loe = new ArrayList<>();
        frame = new JFrame();
        frame.setSize(1000,1000);

        JTextArea ta1 = new JTextArea("this is where you will enter new model entries. "
                + "model entries are items that you already know which style it belongs to.");
        ta1.setSize(ta1.getPreferredSize());
        ta1.setVisible(true);
        frame.add(ta1);

        frame.setVisible(true);
    }

    public void setupinputfields() {

    }
}
