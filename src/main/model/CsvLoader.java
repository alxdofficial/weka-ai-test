package model;

import weka.core.converters.ConverterUtils;
import weka.core.*;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvLoader {

    public CsvLoader(){
    }

    public void loadFile(String filename) {
        try {
            DataSource dataSource = new DataSource(filename);
            Instances instances = dataSource.getDataSet();
            List<EntryM> loe = new ArrayList<>();
            for (Instance i : instances) {
                EntryM e = new EntryM(i.stringValue(0), i.stringValue(1),
                        i.stringValue(2), i.stringValue(3), i.stringValue(4),
                        i.stringValue(5), (int) i.value(6), i.stringValue(7),
                        i.stringValue(8), i.stringValue(9), i.stringValue(10),
                        i.stringValue(11), i.stringValue(12), i.stringValue(13),
                        i.stringValue(14));

                loe.add(e);
            }
            ArffWriter arffWriter = new ArffWriter();
            String newFilename = arffWriter.createArffFromModelEntries(loe, "");
            System.out.println("remember this file name, you will need it later. your filename is:");
            System.out.println(newFilename);
            System.out.println("arff file created, restart the program to take effect");
                
        } catch (Exception e) {
            System.out.println("file does not exist or is of invalid type");

        }


    }
}
