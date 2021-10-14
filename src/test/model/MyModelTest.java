package model;

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
    void test1() throws IOException {
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
        w.createArffFromModelEntries(loe);

    }

    @Test
    void test2() {
        String teststr = "12345678";
        System.out.println(teststr.substring(0,teststr.length() - 1));
    }


}