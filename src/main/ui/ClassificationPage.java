package ui;

import model.EntryC;
import model.MLAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClassificationPage {

    private List<EntryC> loe;
    private MLAlgorithm mla;
    private String arffName;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel resultsPanel;

    public ClassificationPage(List<EntryC> loe, String arffName) {
        this.loe = loe;
        mla = new MLAlgorithm();
        frame = new JFrame();
        mainPanel = new JPanel();
        this.arffName = arffName;
        resultsPanel = new JPanel();
        setupPage();

        try {
            String result = mla.naiveBayesClassification(arffName,loe);

            JTextArea ta5 = new JTextArea(result);
            ta5.setVisible(true);
            mainPanel.add(ta5);

            displayResults();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setupPage() {
        frame.setSize(new Dimension(1500,1000));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JTextArea ta1 = new JTextArea("here is the result of your Machine Learning analysis. the first chunk of text"
                + "below shows the quality and accuracy of the model you trained. then at the bottom you will get "
                + "the style prediction for each of your items.");
        ta1.setVisible(true);
        mainPanel.add(ta1);
        frame.add(mainPanel);
    }

    @SuppressWarnings({"checkstyle:LocalVariableName", "checkstyle:SuppressWarnings"})
    private void displayResults() {
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        List<EntryC> listOfResults = mla.getCatEntries();

        for (EntryC e : listOfResults) {
            JPanel resultPanel = new JPanel();
            resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));

            JTextArea ta2 = new JTextArea(e.id);
            JTextArea ta3 = new JTextArea(e.itemName);
            JTextArea ta4 = new JTextArea(e.classifcication);

            ta2.setVisible(true);
            ta3.setVisible(true);
            ta4.setVisible(true);

            resultPanel.add(ta2);
            resultPanel.add(ta3);
            resultPanel.add(ta4);

            resultPanel.setVisible(true);
            resultsPanel.add(resultPanel);
        }
        resultsPanel.setVisible(true);
        mainPanel.add(resultsPanel);
    }


}
