package ui;

import model.ArffWriter;
import model.Entry;
import model.EntryM;
import model.MLAlgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public static void main(String[] args) throws Exception {
        System.out.println("welcome to the clothing-design-style machine-learning classifier");
        System.out.println("you can create a new set of data entries to train your model by entering 'e', "
                + "or classify new unlabled items by pressing 'c'.");
        Scanner sc = new Scanner(System.in);
        String decision1 = sc.nextLine();

        if (decision1.equals("e")) {
            System.out.println("enter a filename for your arff file to be stored in the project directory,"
                    + " or provide a absolute file-path");
            String filename = sc.nextLine();

            List<EntryM> loe = new ArrayList<>();
            System.out.println("each garment is described by the following attributes. "
                        + "fill out each attribute in order " + "seperated by ','. when you are done one item "
                        + ", just press enter to enter the next item. once you are done all items, "
                        + "enter '#done' to continue");

            int keepEntering = 1;
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

            ArffWriter af = new ArffWriter();
            filename = af.createArffFromModelEntries(loe, filename);
            System.out.println("cool, your arff file has been created, remember your file name below because "
                    + "thats how you select it as your classfification model");
            System.out.println(filename);
            System.out.println("...");
            System.out.println("now enter c if you like to classify new items"
                    + " or enter any other character to quit.");
            String input2 = sc.nextLine();

            List<Entry> loce = new ArrayList<>();
            if (input2.equals("c")) {
                System.out.println("you will now need to enter new items that havent been labled yet."
                        + " like before, fill each parameter in order and seperated by ','."
                        + "enter #done when you are finished"
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
                        for (String s : inputSplit) {
                            s = s.trim();
                        }

                        Entry newEntry = new Entry(inputSplit.get(0), inputSplit.get(1), inputSplit.get(2),
                                inputSplit.get(3), inputSplit.get(4), inputSplit.get(5), inputSplit.get(6),
                                inputSplit.get(7), Integer.parseInt(inputSplit.get(8)), inputSplit.get(9),
                                inputSplit.get(10),
                                inputSplit.get(11), inputSplit.get(12), inputSplit.get(13), inputSplit.get(14),
                                inputSplit.get(15));

                        loce.add(newEntry);
                    }

                }

                System.out.println("now enter the filename indicating the model you want to use "
                        + "to classify your newly added items. after the program"
                        + " runs the model, you will see a evaluation sumary, and then your results");
            }
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

        if (decision1.equals("c")) {
            System.out.println("you will now need to enter new items that havent been labled yet."
                    + " fill each parameter in order and seperated by ','. then enter '#done'. "
                    + " the attributes you need to fill are as follows:");
            List<Entry> loce = new ArrayList<>();
            while (true) {
                System.out.println("id  name  color  length  thickness   warmth   fabric-stich-density   shiny?"
                        + "num-of-colors   body-contour-line   stiffness   water-resistance    material"
                        + "fit     pattern   contrast");

                String entryInput = sc.nextLine();
                if (entryInput.equals("#done")) {
                    break;
                } else {
                    List<String> inputSplit = Arrays.asList(entryInput.split(","));
                    for (String s : inputSplit) {
                        s = s.trim();
                    }

                    Entry newEntry = new Entry(inputSplit.get(0), inputSplit.get(1), inputSplit.get(2),
                            inputSplit.get(3), inputSplit.get(4), inputSplit.get(5), inputSplit.get(6),
                            inputSplit.get(7), Integer.parseInt(inputSplit.get(8)), inputSplit.get(9),
                            inputSplit.get(10),
                            inputSplit.get(11), inputSplit.get(12), inputSplit.get(13), inputSplit.get(14),
                            inputSplit.get(15));

                    loce.add(newEntry);
                }
            }

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
}

