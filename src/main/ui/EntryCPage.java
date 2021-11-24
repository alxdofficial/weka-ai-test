package ui;

import model.EntryC;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntryCPage implements ActionListener {
    private List<EntryC> loe;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel existingInputs;
    private static final String JSON_STORE = "./data/loce.json";

    private Map<JButton, EntryC> mapOfInputs;

    private final String[] levelChoices = {"low", "mid", "high"};
    private final String[] booleanChoices = {"yes", "no"};
    private final JButton addButton;
    private final JButton finishButton;
    private final JButton quitButton;


    private final JTextField idField = new JTextField();
    private final JTextField itemNameField = new JTextField();
    private final JTextField colorField = new JTextField();
    private final JComboBox lengthField = new JComboBox(new String[]{"long", "mid", "short"});
    private final JComboBox thickField = new JComboBox(new String[]{"thick", "mid", "thin"});
    private final JComboBox warmthField = new JComboBox(levelChoices);
    private final JComboBox densityField = new JComboBox(levelChoices);
    private final JComboBox shinyField = new JComboBox(booleanChoices);
    private final JFormattedTextField numcolorsField = new JFormattedTextField(new DecimalFormat());
    private final JTextField bodylineField = new JTextField();
    private final JComboBox stiffField = new JComboBox(new String[]{"stiff", "stretch"});
    private final JComboBox waterField = new JComboBox(booleanChoices);
    private final JTextField materialField = new JTextField();
    private final JComboBox fitField = new JComboBox(new String[]{"tight", "loose"});
    private final JTextField patternField = new JTextField();
    private final JComboBox contrastField = new JComboBox(new String[]{"low", "high"});


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public EntryCPage() {
        loe = new ArrayList<EntryC>();
        mapOfInputs = new LinkedHashMap<>();

        frame = new JFrame();
        frame.setSize(1920,1000);
        addButton = new JButton("add");
        addButton.addActionListener(this);
        mainPanel = new JPanel();
        existingInputs = new JPanel();

        setupPanels();
        mainPanel.add(existingInputs);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 3)));
        setupinputfields();
        mainPanel.add(addButton);

        finishButton = new JButton("done");
        finishButton.addActionListener(this);
        mainPanel.add(finishButton);

        quitButton = new JButton("quit and save json");
        quitButton.addActionListener(this);
        mainPanel.add(quitButton);

        mainPanel.setVisible(true);
        frame.add(mainPanel);
        frame.setVisible(true);

    }

    public void setupPanels() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentY(JPanel.TOP_ALIGNMENT);
        addButton.setBounds(1660, 230, 90, 30);
        addButton.setVisible(true);
        colorField.setPreferredSize(new Dimension(100, 20));
        itemNameField.setPreferredSize(new Dimension(100, 20));
        idField.setPreferredSize(new Dimension(50, 20));


        JTextArea ta1 = new JTextArea("this is where you will enter new items that you dont know which style . "
                + "it belongs to. the style of each item can later be predicted using a set of model entries.");
        ta1.setSize(ta1.getPreferredSize());
        ta1.setVisible(true);
        mainPanel.add(ta1);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void setupinputfields() {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,40,20));
        inputPanel.setBounds(0, 100, 1920, 100);

        JPanel idPanel = new JPanel();
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.Y_AXIS));
        idField.setVisible(true);
        JLabel idLable = new JLabel("id");
        idLable.setVisible(true);
        idPanel.add(idLable);
        idPanel.add(idField);

        JPanel itemNamePanel = new JPanel();
        itemNamePanel.setLayout(new BoxLayout(itemNamePanel, BoxLayout.Y_AXIS));
        itemNameField.setVisible(true);
        JLabel itemNameLable = new JLabel("itemname");
        itemNameLable.setVisible(true);
        itemNamePanel.add(itemNameLable);
        itemNamePanel.add(itemNameField);

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

        JPanel thickPanel = new JPanel();
        thickPanel.setLayout(new BoxLayout(thickPanel, BoxLayout.Y_AXIS));
        thickField.setVisible(true);
        JLabel thickLabel = new JLabel("thick");
        thickLabel.setVisible(true);
        thickPanel.add(thickLabel);
        thickPanel.add(thickField);

        JPanel warmthPanel = new JPanel();
        warmthPanel.setLayout(new BoxLayout(warmthPanel, BoxLayout.Y_AXIS));
        warmthField.setVisible(true);
        JLabel warmthLabel = new JLabel("warmth");
        warmthLabel.setVisible(true);
        warmthPanel.add(warmthLabel);
        warmthPanel.add(warmthField);

        JPanel densityPanel = new JPanel();
        densityPanel.setLayout(new BoxLayout(densityPanel, BoxLayout.Y_AXIS));
        densityField.setVisible(true);
        JLabel densityLabel = new JLabel("density");
        densityLabel.setVisible(true);
        densityPanel.add(densityLabel);
        densityPanel.add(densityField);

        JPanel shinyPanel = new JPanel();
        shinyPanel.setLayout(new BoxLayout(shinyPanel, BoxLayout.Y_AXIS));
        shinyField.setVisible(true);
        JLabel shinyLabel = new JLabel("shiny?");
        shinyLabel.setVisible(true);
        shinyPanel.add(shinyLabel);
        shinyPanel.add(shinyField);

        JPanel numcolorsPanel = new JPanel();
        numcolorsPanel.setLayout(new BoxLayout(numcolorsPanel, BoxLayout.Y_AXIS));
        numcolorsField.setVisible(true);
        JLabel numcolorsLabel = new JLabel("num colors");
        numcolorsLabel.setVisible(true);
        numcolorsPanel.add(numcolorsLabel);
        numcolorsPanel.add(numcolorsField);

        JPanel bodylinePanel = new JPanel();
        bodylinePanel.setLayout(new BoxLayout(bodylinePanel, BoxLayout.Y_AXIS));
        bodylineField.setVisible(true);
        JLabel bodylineLabel = new JLabel("body contour line");
        bodylineLabel.setVisible(true);
        bodylinePanel.add(bodylineLabel);
        bodylinePanel.add(bodylineField);

        JPanel stiffPanel = new JPanel();
        stiffPanel.setLayout(new BoxLayout(stiffPanel, BoxLayout.Y_AXIS));
        stiffField.setVisible(true);
        JLabel stiffLabel = new JLabel("stiffness");
        stiffLabel.setVisible(true);
        stiffPanel.add(stiffLabel);
        stiffPanel.add(stiffField);

        JPanel waterPanel = new JPanel();
        waterPanel.setLayout(new BoxLayout(waterPanel, BoxLayout.Y_AXIS));
        waterField.setVisible(true);
        JLabel waterLabel = new JLabel("wet weather ready?");
        waterLabel.setVisible(true);
        waterPanel.add(waterLabel);
        waterPanel.add(waterField);

        JPanel materialPanel = new JPanel();
        materialPanel.setLayout(new BoxLayout(materialPanel, BoxLayout.Y_AXIS));
        materialField.setVisible(true);
        JLabel materialLabel = new JLabel("material");
        materialLabel.setVisible(true);
        materialPanel.add(materialLabel);
        materialPanel.add(materialField);

        JPanel fitPanel = new JPanel();
        fitPanel.setLayout(new BoxLayout(fitPanel, BoxLayout.Y_AXIS));
        fitField.setVisible(true);
        JLabel fitLabel = new JLabel("fit");
        fitLabel.setVisible(true);
        fitPanel.add(fitLabel);
        fitPanel.add(fitField);

        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.Y_AXIS));
        patternField.setVisible(true);
        JLabel patternLabel = new JLabel("pattern");
        patternLabel.setVisible(true);
        patternPanel.add(patternLabel);
        patternPanel.add(patternField);

        JPanel contrastPanel = new JPanel();
        contrastPanel.setLayout(new BoxLayout(contrastPanel, BoxLayout.Y_AXIS));
        contrastField.setVisible(true);
        JLabel contrastLabel = new JLabel("contrast");
        contrastLabel.setVisible(true);
        contrastPanel.add(contrastLabel);
        contrastPanel.add(contrastField);

        inputPanel.add(idPanel);
        inputPanel.add(itemNamePanel);
        inputPanel.add(colorPanel);
        inputPanel.add(lengthPanel);
        inputPanel.add(thickPanel);
        inputPanel.add(warmthPanel);
        inputPanel.add(densityPanel);
        inputPanel.add(shinyPanel);
        inputPanel.add(numcolorsPanel);
        inputPanel.add(bodylinePanel);
        inputPanel.add(stiffPanel);
        inputPanel.add(waterPanel);
        inputPanel.add(materialPanel);
        inputPanel.add(fitPanel);
        inputPanel.add(patternPanel);
        inputPanel.add(contrastPanel);

        inputPanel.setVisible(true);
        mainPanel.add(inputPanel);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void displayInputs() {
        existingInputs.setLayout(new BoxLayout(existingInputs,BoxLayout.Y_AXIS));
        existingInputs.removeAll();

        for (Map.Entry<JButton, EntryC> e : mapOfInputs.entrySet()) {
            JLabel idtext = new JLabel(e.getValue().id);
            JLabel itemNametext = new JLabel(e.getValue().itemName);
            JLabel colortext = new JLabel(e.getValue().color);
            JLabel lengthtext = new JLabel(e.getValue().length);
            JLabel thicknesstext = new JLabel(e.getValue().thickness);
            JLabel warmtext = new JLabel(e.getValue().warmth);
            JLabel densitytext = new JLabel(e.getValue().fabricStitchDensity);
            JLabel shinytext = new JLabel(e.getValue().shiny);
            JLabel numcolorstext = new JLabel(String.valueOf(e.getValue().numColors));
            JLabel bodytext = new JLabel(e.getValue().bodyLine);
            JLabel stifftext = new JLabel(e.getValue().stiffness);
            JLabel watertext = new JLabel(e.getValue().waterResistance);
            JLabel materialtext = new JLabel(e.getValue().material);
            JLabel fittext = new JLabel(e.getValue().fit);
            JLabel patterntext = new JLabel(e.getValue().pattern);
            JLabel contrasttext = new JLabel(e.getValue().contrastVibrancy);
            JLabel classtext = new JLabel(e.getValue().classifcication);

            idtext.setVisible(true);
            itemNametext.setVisible(true);
            colortext.setVisible(true);
            lengthtext.setVisible(true);
            thicknesstext.setVisible(true);
            warmtext.setVisible(true);
            densitytext.setVisible(true);
            shinytext.setVisible(true);
            numcolorstext.setVisible(true);
            bodytext.setVisible(true);
            stifftext.setVisible(true);
            watertext.setVisible(true);
            materialtext.setVisible(true);
            fittext.setVisible(true);
            patterntext.setVisible(true);
            contrasttext.setVisible(true);
            classtext.setVisible(true);


            JPanel entryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,40,10));
            entryPanel.add(colortext);
            entryPanel.add(lengthtext);
            entryPanel.add(thicknesstext);
            entryPanel.add(warmtext);
            entryPanel.add(densitytext);
            entryPanel.add(shinytext);
            entryPanel.add(numcolorstext);
            entryPanel.add(bodytext);
            entryPanel.add(stifftext);
            entryPanel.add(watertext);
            entryPanel.add(materialtext);
            entryPanel.add(fittext);
            entryPanel.add(patterntext);
            entryPanel.add(contrasttext);
            entryPanel.add(classtext);
            entryPanel.add(e.getKey());

            existingInputs.add(entryPanel);
            entryPanel.setVisible(true);
        }

        existingInputs.setBounds(0, 500, 1900, 600);
        existingInputs.setVisible(true);
        existingInputs.revalidate();
        existingInputs.repaint();
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == addButton) {
            EntryC newEntryC = new EntryC(idField.getText(), itemNameField.getText(),
                    colorField.getText(), lengthField.getSelectedItem().toString(),
                    thickField.getSelectedItem().toString(), warmthField.getSelectedItem().toString(),
                    densityField.getSelectedItem().toString(), shinyField.getSelectedItem().toString(),
                    Integer.valueOf(numcolorsField.getText()), bodylineField.getText().toString(),
                    stiffField.getSelectedItem().toString(), waterField.getSelectedItem().toString(),
                    materialField.getText().toString(), fitField.getSelectedItem().toString(),
                    patternField.getText().toString(),contrastField.getSelectedItem().toString());

            loe.add(newEntryC);
            JButton b = new JButton("delete");
            b.setVisible(true);
            b.addActionListener(this);
            mapOfInputs.put(b, newEntryC);
            displayInputs();
        } else if (button.getText() ==  "delete") {
            mapOfInputs.remove(e.getSource());
            displayInputs();
            loe.remove(mapOfInputs.get(button));
        } else if (button == finishButton) {
            ChooseArffForClassification ca = new ChooseArffForClassification(loe);
        } else if (button == quitButton) {
            JsonWriter jw = new JsonWriter(JSON_STORE);
            try {
                jw.open();
                jw.write(loe);
                jw.close();

                JDialog savedPopup = new JDialog();
                savedPopup.add(new TextArea("successfully saved as a json in the project root directory"));
                savedPopup.setSize(new Dimension(400,300));
                savedPopup.setVisible(true);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }


    }
}
