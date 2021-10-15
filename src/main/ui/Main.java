package ui;

import model.ArffWriter;
import model.Entry;
import model.EntryM;
import model.MLAlgorithm;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) throws Exception {
        System.out.println("welcome to the clothing-design-style machine-learning classifier");


        System.out.println("you can create a new set of data entries to train your model by entering 'e', "
                + "or classify new unlabled items by pressing 'c'.");
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
            } else {
                if (decision1.equals("c")) {
                    List<Entry> loce = new ArrayList<>();
                    inputClassifyData(loce);
                    classify(loce);

                    System.out.println(" create a new set of data entries to train your model by entering 'e',"
                            + "or classify new unlabled items by pressing 'c'.");
                    decision1 = sc.nextLine();
                }
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

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void inputClassifyData(List<Entry> loce) {
        System.out.println("you will now need to enter new items that havent been labled yet."
                + "fill each parameter in order and seperated by ','."
                + "enter #done when you are finished."
                + " the attributes you need to fill are as follows:");
        while (true) {
            System.out.println("id  name  color  length  thickness   warmth   fabric-stich-density   shiny?"
                    + "num-of-colors   body-contour-line   stiffness   water-resistance    material"
                    + "fit     pattern   contrast");
            String entryInput = sc.nextLine();
            if (entryInput.equals("#done")) {
                break;
            } else {
                List<String> inputSplit = Arrays.asList(entryInput.split(","));
                for (String s:inputSplit) {
                    s = s.trim();
                }
                Entry newEntry = new Entry(inputSplit.get(0),inputSplit.get(1),inputSplit.get(2),
                        inputSplit.get(3),inputSplit.get(4),inputSplit.get(5),inputSplit.get(6),
                        inputSplit.get(7),Integer.parseInt(inputSplit.get(8)),inputSplit.get(9),
                        inputSplit.get(10),
                        inputSplit.get(11),inputSplit.get(12),inputSplit.get(13),inputSplit.get(14),
                        inputSplit.get(15));
                loce.add(newEntry);
            }
        }
    }



    public static void classify(List<Entry> loce) throws Exception {
        System.out.println("now enter the filename indicating the model you want to use "
                    + "to classify your newly added items. after the program"
                    + " runs the model, you will see a evaluation sumary, and then your results");
        String input3 = sc.nextLine();
        MLAlgorithm mla = new MLAlgorithm();
        List<Entry> results = mla.naiveBayesClassification(input3, loce);
        for (Entry e : results) {
            System.out.print(e.id + "   ");
            System.out.print(e.itemName + "   ");
            System.out.print(e.classifcication);
            System.out.println("");
        }
    }


}

