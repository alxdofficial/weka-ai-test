package model;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyModelTest {
    // delete or rename this class!
    @Test
    void test1() throws Exception {
        EntryM m1 = new EntryM("beige", "long", "thin", "mid", "low", "no",
                1, "box", "stretch", "no", "cotton", "loose", "grid",
                "high", "urban");
        EntryM m2 = new EntryM("red", "short", "thick", "high", "high", "yes",
                1, "box", "stiff", "yes", "wool", "tight", "solid",
                "high", "rustic");
        EntryM m3 = new EntryM("red", "short", "mid", "low ", "high", "no",
                1, "flowy", "mid", "yes", "synthetic", "mid", "line",
                "high", "minimalist");
        EntryM m4 = new EntryM("blue", "long", "thick", "low", "high", "yes ",
                1, "flowy", "stiff", "yes", "cotton", "loose", "solid",
                "low", "minimalist ");
        EntryM m5 = new EntryM("grey", "mid", "thick ", "mid", "low", "no",
                1, "hourglass", "stretch", "no", "wool", "loose", "graphic",
                "low", "rustic");
        EntryM m6 = new EntryM("grey", "long", "thin", "mid", "mid ", "no",
                1, "hourglass", "stretch", "no", "wool", "loose", "solid",
                "low", "rustic");



        List<EntryM> loe = new ArrayList<>();
        MLAlgorithm mla = new MLAlgorithm();
        loe.add(m1);
        loe.add(m2);
        loe.add(m3);
        loe.add(m4);
        loe.add(m5);
        loe.add(m6);

        ArffWriter w = new ArffWriter();
        String filename = w.createArffFromModelEntries(loe,"t1");

        assertTrue(FileUtils.contentEquals(new File("correct.arff"), new File(filename)));
    }

    @Test
    void test2() throws Exception {
        MLAlgorithm mla = new MLAlgorithm();
        Entry e1 = new Entry("1","item 1", "beige", "long", "thin", "mid", "low", "no",
                1, "box", "stretch", "no", "cotton", "loose", "grid",
                "high");
        Entry e2 = new Entry("2","item2","red", "short", "thick", "high", "high", "yes",
                1, "box", "stiff", "yes", "wool", "tight", "solid",
                "high");
        Entry e3 = new Entry("3","item3","red", "short", "mid", "low", "high", "no",
                1, "flowy", "mid", "yes", "synthetic", "mid", "lines",
                "high");
        Entry e4 = new Entry("4","item4","blue", "long", "thick", "low", "high", "yes",
                1, "flowy", "stiff", "yes", "denim", "loose", "solid",
                "low");
        List<Entry> loe = new ArrayList<>();
        loe.add(e1);
        loe.add(e2);
        loe.add(e3);
        loe.add(e4);

        mla.addToCatEntry(loe);

        assertEquals(loe,mla.getCatEntries());

        mla.naiveBayesClassification("default_garments.arff",loe);
        List<Entry> results = mla.getCatEntries();

        assertEquals("rustic", results.get(0).classifcication);
        assertEquals("urban", results.get(1).classifcication);
        assertEquals("urban", results.get(2).classifcication);
        assertEquals("rustic", results.get(3).classifcication);

    }

    @Test
    void test3() {
        CsvLoader csvLoader = new CsvLoader();
        try {
            assertTrue(FileUtils.directoryContains(new File("C:\\Users\\Malef\\IdeaProjects\\project_w4s0k"),new File("AQou.arff")));
            csvLoader.loadFile("test csv.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}