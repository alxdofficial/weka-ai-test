package ui;

import model.Event;
import model.EventLog;
import persistence.JsonReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Main implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton addEntryM;
    JButton addEntryC;
    JButton load;
    JButton loadFromCsv;

    private static final String JSON_STORE = "./data/loce.json";

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public Main() {

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {

                System.out.println("\n\n\n Log:");
                Iterator<Event> events = EventLog.getInstance().iterator();
                for (Iterator<Event> it = events; it.hasNext(); ) {
                    Event e = it.next();
                    System.out.println(e.toString());
                }
            }
        }));

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

        BufferedImage mainPic = null;
        try {
            mainPic = ImageIO.read(new File("0__VH001TPrUWwoFPh.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert mainPic != null;
        JLabel picLabel = new JLabel(new ImageIcon(mainPic));
        picLabel.setVisible(true);
        picLabel.setBounds(0, 500, 800, 600);
        frame.add(picLabel);


        panel.setVisible(true);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(textarea1);
        frame.setVisible(true);//making the frame visible


    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) {
        Main main = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadFromCsv) {
            System.out.println("load from csv button pressed");
            LoadFromCsvPage lp = new LoadFromCsvPage();
        } else if (e.getSource() == addEntryM) {
            System.out.println("entrym button pressed");
            EntryMPage emp = new EntryMPage();
        } else if (e.getSource() == addEntryC) {
            System.out.println("entryc button pressed");
            EntryCPage ecp = new EntryCPage();
        } else if (e.getSource() == load) {
            JsonReader jr = new JsonReader(JSON_STORE);
            try {
                ChooseArffForClassification cr = new ChooseArffForClassification(jr.read());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

