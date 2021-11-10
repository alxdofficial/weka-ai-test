package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton addEntryM;
    JButton addEntryC;
    JButton load;
    JButton loadFromCsv;

    public GUI() {
        frame = new JFrame();//creating instance of JFrame
        frame.setSize(1000,900);

        panel = new JPanel(new GridLayout(2,2,20,20));
        panel.setBounds(30,30, 600, 400);
        addEntryM = new JButton("add model entries");//creating instance of JButton
        addEntryM.setMinimumSize(new Dimension(200,80));
        addEntryM.addActionListener(this);
        panel.add(addEntryM); //adding button in JFrame
        addEntryC = new JButton("add classifying entries");//creating instance of JButton
        addEntryC.setMinimumSize(new Dimension(200,80));
        addEntryC.addActionListener(this);
        panel.add(addEntryC); //adding button in JFrame
        load = new JButton("load classifying entries");//creating instance of JButton
        load.setMinimumSize(new Dimension(200,80));
        load.addActionListener(this);
        panel.add(load); //adding button in JFrame
        loadFromCsv = new JButton("load model entries from CSV");//creating instance of JButton
        loadFromCsv.setMinimumSize(new Dimension(200,80));
        loadFromCsv.addActionListener(this);
        panel.add(loadFromCsv); //adding button in JFrame

        JTextArea textarea1 = new JTextArea("Welcome to the clothing design style machine learning algorithm");
        textarea1.setSize(380, 20);
        textarea1.setVisible(true);

        panel.setVisible(true);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(textarea1);
        frame.setVisible(true);//making the frame visible


    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) {
        GUI gui = new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadFromCsv) {
            LoadFromCsvPage lp = new LoadFromCsvPage();
            System.out.println("load from csv button pressed");
        }
    }
}

