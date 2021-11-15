package ui;

import model.CsvLoader;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LoadFromCsvPage extends Component {
    private String filePath;
    private JFrame frame;
    private JPanel panel1;

    public LoadFromCsvPage() {
        frame = new JFrame();
        frame.setSize(1000,800);
        frame.setBackground(Color.GRAY);

        panel1 = new JPanel();
        panel1.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));

        JTextArea ta1 = new JTextArea("your selected csv file:");
        ta1.setMaximumSize(ta1.getPreferredSize());
        ta1.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel1.add(ta1);
        ta1.setVisible(true);

        frame.add(panel1);
        JFileChooser chooser = new JFileChooser();
//        chooser.setSize(new Dimension(500,500));
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            String filename = selectedFile.getAbsolutePath();
            JTextArea ta2 = new JTextArea(filename);
            ta2.setMaximumSize(ta2.getPreferredSize());
            ta2.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel1.add(ta2);
            ta2.setVisible(true);

            handleFilechooser(filename);
        }


        frame.setVisible(true);//making the frame visible


    }

    private void handleFilechooser(String filename) {

        CsvLoader csvLoader = new CsvLoader();
        String newFilename = csvLoader.loadFile(filename);
        JTextArea ta3 = new JTextArea("\n\n your csv file will copied into a arff file,"
                + " which is what the program uses to train ML models. "
                + ".\n remember this file name because you will use it to identify which data set you want to use to"
                + "classify new items." + "\n\n the name of your arff file is:   " + newFilename);
        ta3.setAlignmentX(Component.LEFT_ALIGNMENT);
        ta3.setSize(ta3.getPreferredSize());
        ta3.setVisible(true);
        panel1.add(ta3);

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//    }
}




