package ui;

import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import persistence.JsonReader;
import persistence.JsonWriter;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static final String JSON_STORE = "./data/loce.json";
    private static JsonWriter jsonWriter;


    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) throws Exception {
        System.out.println("welcome to the clothing-design-style machine-learning classifier");


        System.out.println("you can create a new set of data entries to train your model by entering 'e', "
                + "enter 'l' to load an csv file to generate arff file,"
                + ", classify new unlabled items by pressing 'c', or load json to classify by entering 'lc'.");
        String decision1 = sc.nextLine();

        while (true) {
            if (decision1.equals("e")) {
                System.out.println("enter a filename for your arff file to be stored in the project directory,"
                        + " or provide a absolute file-path");
                String filename = sc.nextLine();
                List<EntryM> loe = new ArrayList<>();
                addModelEntry(loe,filename);
                filename = writeEntryToArff(loe,filename);

                System.out.println("arff file created, restart the program to take effect");
                decision1 = sc.nextLine();
            } else if (decision1.equals("c")) {
                List<EntryC> loce = new ArrayList<>();
                inputClassifyData(loce);
                classify(loce);

                System.out.println("you can create a new set of data entries to train your model by entering 'e', "
                        + "enter 'l' to load an csv file to generate arff file,"
                        + ", classify new unlabled items by pressing 'c', or load json to classify by entering 'lc'.");
                decision1 = sc.nextLine();
            } else if (decision1.equals("l")) {
                loadFile();
                System.out.println("you can create a new set of data entries to train your model by entering 'e', "
                        + "enter 'l' to load an csv file to generate arff file,"
                        + ", classify new unlabled items by pressing 'c', or load json to classify by entering 'lc'.");
                decision1 = sc.nextLine();

            } else if (decision1.equals("lc")) {
                List<EntryC> loce = new ArrayList<>();
                loadListOfClassifyingEntries(loce);
                classify(loce);
                System.out.println("you can create a new set of data entries to train your model by entering 'e', "
                        + "enter 'l' to load an csv file to generate arff file,"
                        + ", classify new unlabled items by pressing 'c', or load json to classify by entering 'lc'.");
                decision1 = sc.nextLine();
            }

        }

    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void addModelEntry(List<EntryM> loe, String filename) throws IOException {
        System.out.println("each garment is described by the following attributes. "
                + "fill out each attribute in order " + "seperated by ','. when you are done one item "
                + ", just press enter to enter the next item. once you are done all items, "
                + "enter '#done' to continue");
        while (true) {
            System.out.println("color  length   thickness   warmth   fabric-stich-density   shiny?  "
                    + "num-of-colors   body-contour-line   stiffness   water-resistance    material     "
                    + "fit     pattern   contrast   classification");
            String entryInput = sc.nextLine();
            if (entryInput.contains("#done")) {
                break;
            } else {
                List<String> inputSplit = Arrays.asList(entryInput.split(","));
                for (String s : inputSplit) {
                    s = s.trim();
                }
                EntryM newModelEntry = new EntryM(inputSplit.get(0),inputSplit.get(1),inputSplit.get(2),
                        inputSplit.get(3),inputSplit.get(4),inputSplit.get(5),Integer.parseInt(inputSplit.get(6)),
                        inputSplit.get(7), inputSplit.get(8),inputSplit.get(9),inputSplit.get(10),
                        inputSplit.get(11),
                        inputSplit.get(12), inputSplit.get(13),inputSplit.get(14));
                loe.add(newModelEntry);
            }
        }
    }

    public static String writeEntryToArff(List<EntryM> loe, String filename) throws IOException {
        ArffWriter af = new ArffWriter();
        filename = af.createArffFromModelEntries(loe, filename);
        System.out.println("cool, your arff file has been created, remember your file name below because "
                + "thats how you select it as your classfification model");
        System.out.println(filename);
        System.out.println("...");
        return filename;
    }

    public static void loadFile() {
        System.out.println("enter the absolute file path of your csv file:");
        String filepath = sc.nextLine();
        CsvLoader csvLoader = new CsvLoader();
        csvLoader.loadFile(filepath);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void inputClassifyData(List<EntryC> loce) {
        System.out.println("you will now need to enter new items that havent been labled yet."
                + "fill each parameter in order and seperated by ','."
                + "enter #done when you are finished. if you need to quit, save by entering '#quit'."
                + " the attributes you need to fill are as follows:");
        while (true) {
            System.out.println("id  name  color  length  thickness   warmth   fabric-stich-density   shiny?"
                    + "num-of-colors   body-contour-line   stiffness   water-resistance    material"
                    + "fit     pattern   contrast");
            String entryInput = sc.nextLine();
            if (entryInput.equals("#done")) {
                break;
            } else if (entryInput.equals("#quit")) {
                save(loce);
                break;
            } else {
                List<String> inputSplit = Arrays.asList(entryInput.split(","));
                for (String s:inputSplit) {
                    s = s.trim();
                }
                EntryC newEntryC = new EntryC(inputSplit.get(0),inputSplit.get(1),inputSplit.get(2),
                        inputSplit.get(3),inputSplit.get(4),inputSplit.get(5),inputSplit.get(6),
                        inputSplit.get(7),Integer.parseInt(inputSplit.get(8)),inputSplit.get(9),
                        inputSplit.get(10),
                        inputSplit.get(11),inputSplit.get(12),inputSplit.get(13),inputSplit.get(14),
                        inputSplit.get(15));
                loce.add(newEntryC);
            }
        }
    }



    public static void classify(List<EntryC> loce) throws Exception {
        System.out.println("now enter the filename indicating the model you want to use "
                    + "to classify your newly added items. after the program"
                    + " runs the model, you will see a evaluation sumary, and then your results");
        String input3 = sc.nextLine();
        MLAlgorithm mla = new MLAlgorithm();
        mla.naiveBayesClassification(input3, loce);
        List<EntryC> results = mla.getCatEntries();
        for (EntryC e : results) {
            System.out.print(e.id + "   ");
            System.out.print(e.itemName + "   ");
            System.out.print(e.classifcication);
            System.out.println("");
        }
    }

    private static void save(List<EntryC> loce) {
        try {
            jsonWriter = new JsonWriter(JSON_STORE);
            jsonWriter.open();
            jsonWriter.write(loce);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
        System.exit(0);
    }

    private static void loadListOfClassifyingEntries(List<EntryC> loce) {
        try {
            JsonReader jsonReader = new JsonReader(JSON_STORE);
            loce.addAll(jsonReader.read());
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}

