package ui;

import model.Entry;
import model.EntryM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntryMPage implements ActionListener {
    private List<EntryM> loe;
    private JFrame frame;
    private Map<Integer,EntryM> listOfInputs;

    private final String[] levelChoices = {"low", "mid", "high"};
    private final String[] booleanChoices = {"yes", "no"};
    private final JButton addButton = new JButton("add");
    private final JTextField colorField = new JTextField();
    private final JComboBox lengthField = new JComboBox(new String[]{"long", "mid", "short"});



    public EntryMPage() {
        loe = new ArrayList<>();
        frame = new JFrame();
        listOfInputs = new HashMap<>();

        frame.setSize(1920,1000);
        frame.setLayout(null);
        addButton.addActionListener(this);
        addButton.setVisible(true);

        JTextArea ta1 = new JTextArea("this is where you will enter new model entries. "
                + "model entries are items that you already know which style it belongs to.");
        ta1.setSize(ta1.getPreferredSize());
        ta1.setVisible(true);
        frame.add(ta1);

        setupinputfields();

        frame.add(addButton);
        frame.setVisible(true);
    }

    public void setupinputfields() {
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBounds(0, 100, 1000, 1000);

        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
        colorField.setVisible(true);
        JLabel colorLable = new JLabel("color");
        colorLable.setVisible(true);
        colorPanel.add(colorLable);
        colorPanel.add(colorField);

        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(new BoxLayout(lengthPanel, BoxLayout.Y_AXIS));
        lengthField.setVisible(true);
        JLabel lengthLabel = new JLabel("length");
        lengthLabel.setVisible(true);
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthField);

        inputPanel.add(colorPanel);
        inputPanel.add(lengthPanel);

        inputPanel.setVisible(true);
        frame.add(inputPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String colorText = colorField.getText();
            String lengthText = (String) lengthField.getSelectedItem();

            System.out.println(colorText);
            System.out.println(lengthText);
        }
    }
}
