package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArffWriter {
    
    public ArffWriter() {
        
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public String createArffFromModelEntries(List<EntryM> loe) throws IOException {
        String fileName = "";
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        for (int i = 0; i < 4; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (alphaNumericString.length() * Math.random());
            fileName += String.valueOf(alphaNumericString.charAt(index));
        }
        fileName += ".arff";

        File newArff = new File(fileName);

        String colorUnique = "@attribute color {";
        String lengthUnique = "@attribute length {";
        String thicknessUnique = "@attribute width {";
        String warmthUnique = "@attribute warmth {";
        String fabricStitchDensityUnique = "@attribute 'fabric stitch density' {";
        String shinyUnique = "@attribute shiny? {";
        String numClorsUnique = "@attribute 'num of colors' numeric";
        String bodyLineUnique = "@attribute 'body contourline' {";
        String stiffnessUnique = "@attribute stiffness {";
        String waterResistanceUnique = "@attribute water-ready? {";
        String materialUnique = "@attribute material {";
        String fitUnique = "@attribute 'fit ' {";
        String patternUnique = "@attribute pattern {";
        String contrastVibrancyUnique = "@attribute contrast/vibrancy {";
        String classifcicationUnique = "@attribute class {";

        for (EntryM e : loe) {
            if (!colorUnique.contains(e.color.trim())) {
                colorUnique += "'" + e.color.trim() + "'" + ", ";
            }
            if (!lengthUnique.contains(e.length.trim())) {
                lengthUnique += "'" + e.length.trim() + "'" + ", ";
            }
            if (!thicknessUnique.contains(e.thickness.trim())) {
                thicknessUnique += "'" + e.thickness.trim() + "'" + ", ";
            }
            if (!warmthUnique.contains(e.warmth.trim())) {
                warmthUnique += "'" + e.warmth.trim() + "'" + ", ";
            }
            if (!fabricStitchDensityUnique.contains(e.fabricStitchDensity.trim())) {
                fabricStitchDensityUnique += "'" + e.fabricStitchDensity.trim() + "'" + ", ";
            }
            if (!shinyUnique.contains(e.shiny.trim())) {
                shinyUnique += "'" + e.shiny.trim() + "'" + ", ";
            }
            if (!bodyLineUnique.contains(e.bodyLine.trim())) {
                bodyLineUnique += "'" + e.bodyLine.trim() + "'" + ", ";
            }
            if (!stiffnessUnique.contains(e.stiffness.trim())) {
                stiffnessUnique += "'" + e.stiffness.trim() + "'" + ", ";
            }
            if (!waterResistanceUnique.contains(e.waterResistance.trim())) {
                waterResistanceUnique += "'" + e.waterResistance.trim() + "'" + ", ";
            }
            if (!materialUnique.contains(e.material.trim())) {
                materialUnique += "'" + e.material.trim() + "'" + ", ";
            }
            if (!fitUnique.contains(e.fit.trim())) {
                fitUnique += "'" + e.fit.trim() + "'" + ", ";
            }
            if (!patternUnique.contains(e.pattern.trim())) {
                patternUnique += "'" + e.pattern.trim() + "'" + ", ";
            }
            if (!contrastVibrancyUnique.contains(e.contrastVibrancy.trim())) {
                classifcicationUnique += "'" + e.contrastVibrancy.trim() + "'" + ", ";
            }
            if (!classifcicationUnique.contains(e.classifcication.trim())) {
                classifcicationUnique += "'" + e.classifcication.trim() + "'" + ", ";
            }
        }

        colorUnique.substring(0, colorUnique.length() - 1);
        colorUnique += "}";
        lengthUnique.substring(0, lengthUnique.length() - 2);
        lengthUnique += "}";
        thicknessUnique.substring(0, thicknessUnique.length() - 2);
        thicknessUnique += "}";
        warmthUnique.substring(0, warmthUnique.length() - 2);
        warmthUnique += "}";
        fabricStitchDensityUnique.substring(0, fabricStitchDensityUnique.length() - 2);
        fabricStitchDensityUnique += "}";
        shinyUnique.substring(0, shinyUnique.length() - 2);
        shinyUnique += "}";
        bodyLineUnique.substring(0, bodyLineUnique.length() - 2);
        bodyLineUnique += "}";
        stiffnessUnique.substring(0, stiffnessUnique.length() - 2);
        stiffnessUnique += "}";
        waterResistanceUnique.substring(0, waterResistanceUnique.length() - 2);
        waterResistanceUnique += "}";
        materialUnique.substring(0, materialUnique.length() - 2);
        materialUnique += "}";
        fitUnique.substring(0, fitUnique.length() - 2);
        fitUnique += "}";
        patternUnique.substring(0, patternUnique.length() - 2);
        patternUnique += "}";
        contrastVibrancyUnique.substring(0, contrastVibrancyUnique.length() - 2);
        contrastVibrancyUnique += "}";
        classifcicationUnique.substring(0, classifcicationUnique.length() - 2);
        classifcicationUnique += "}";

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("@relation '" + fileName + "'");
        writer.newLine();
        writer.write(colorUnique);
        writer.newLine();
        writer.write(lengthUnique);
        writer.newLine();
        writer.write(thicknessUnique);
        writer.newLine();
        writer.write(warmthUnique);
        writer.newLine();
        writer.write(fabricStitchDensityUnique);
        writer.newLine();
        writer.write(shinyUnique);
        writer.newLine();
        writer.write(numClorsUnique);
        writer.newLine();
        writer.write(stiffnessUnique);
        writer.newLine();
        writer.write(waterResistanceUnique);
        writer.newLine();
        writer.write(materialUnique);
        writer.newLine();
        writer.write(fitUnique);
        writer.newLine();
        writer.write(patternUnique);
        writer.newLine();
        writer.write(contrastVibrancyUnique);
        writer.newLine();
        writer.write(classifcicationUnique);
        writer.newLine();
        writer.newLine();
        writer.write("@data");
        writer.newLine();


        for (EntryM e : loe) {
            String line = e.color + "," + e.length + "," + e.thickness + "," + e.warmth + "," + e.fabricStitchDensity
                    + "," + e.shiny + "," + e.numClors + "," + e.bodyLine + "," + e.stiffness + "," + e.waterResistance
                    + "," + e.material + "," + e.fit + "," + e.pattern + "," + e.contrastVibrancy + ","
                    + e.classifcication;
            writer.write(line);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        return fileName;
    }        
}
