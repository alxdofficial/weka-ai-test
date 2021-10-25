package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArffWriter {
    
    public ArffWriter() {
        
    }

    //    EFFECTS: takes in a list of dataset entries and a file name.
    //    create arff file of the entries in the project directory or a user specified location.

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public String createArffFromModelEntries(List<EntryM> loe, String fn) throws IOException {
        //    generate filename
        String fileName = fn;
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


        // create empty file at location
        File newArff = new File(fileName);

        //prep strings for the header of the arff file
        String colorUnique = "@attribute color {";
        String lengthUnique = "@attribute length {";
        String thicknessUnique = "@attribute thicness {";
        String warmthUnique = "@attribute warmth {";
        String fabricStitchDensityUnique = "@attribute 'fabric stitch density' {";
        String shinyUnique = "@attribute shiny? {";
        String numClorsUnique = "@attribute 'num of colors' numeric";
        String bodyLineUnique = "@attribute 'body contour line' {";
        String stiffnessUnique = "@attribute stifness {";
        String waterResistanceUnique = "@attribute water-ready? {";
        String materialUnique = "@attribute material {";
        String fitUnique = "@attribute fit {";
        String patternUnique = "@attribute pattern {";
        String contrastVibrancyUnique = "@attribute contrast/vibrancy {";
        String classifcicationUnique = "@attribute class {";

        // look for all the values of every attribute the user has inputted in the dataset, then add unique
        // values to the headers of the arff file. this is because each attribute is a nominal type,
        // and every value in the data must first be declared.
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
                contrastVibrancyUnique += "'" + e.contrastVibrancy.trim() + "'" + ", ";
            }
            if (!classifcicationUnique.contains(e.classifcication.trim())) {
                classifcicationUnique += "'" + e.classifcication.trim() + "'" + ", ";
            }
        }

        // finish up header and correct the syntax
        colorUnique = colorUnique.substring(0, colorUnique.length() - 2);
        colorUnique += "}";
        lengthUnique = lengthUnique.substring(0, lengthUnique.length() - 2);
        lengthUnique += "}";
        thicknessUnique = thicknessUnique.substring(0, thicknessUnique.length() - 2);
        thicknessUnique += "}";
        warmthUnique = warmthUnique.substring(0, warmthUnique.length() - 2);
        warmthUnique += "}";
        fabricStitchDensityUnique = fabricStitchDensityUnique.substring(0, fabricStitchDensityUnique.length() - 2);
        fabricStitchDensityUnique += "}";
        shinyUnique = shinyUnique.substring(0, shinyUnique.length() - 2);
        shinyUnique += "}";
        bodyLineUnique = bodyLineUnique.substring(0, bodyLineUnique.length() - 2);
        bodyLineUnique += "}";
        stiffnessUnique = stiffnessUnique.substring(0, stiffnessUnique.length() - 2);
        stiffnessUnique += "}";
        waterResistanceUnique = waterResistanceUnique.substring(0, waterResistanceUnique.length() - 2);
        waterResistanceUnique += "}";
        materialUnique = materialUnique.substring(0, materialUnique.length() - 2);
        materialUnique += "}";
        fitUnique = fitUnique.substring(0, fitUnique.length() - 2);
        fitUnique += "}";
        patternUnique = patternUnique.substring(0, patternUnique.length() - 2);
        patternUnique += "}";
        contrastVibrancyUnique = contrastVibrancyUnique.substring(0, contrastVibrancyUnique.length() - 2);
        contrastVibrancyUnique += "}";
        classifcicationUnique = classifcicationUnique.substring(0, classifcicationUnique.length() - 2);
        classifcicationUnique += "}";


        // actually writing to strings crreate above to the empty file
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("@relation 'clothes.arff'");
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
        writer.write(bodyLineUnique);
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


        // for each data entry, format its values in order of the attributes, then make them comma seperated
        // the values in the entrys have already been trimmed
        for (EntryM e : loe) {
            String line = e.color + "," + e.length + "," + e.thickness + "," + e.warmth + "," + e.fabricStitchDensity
                    + "," + e.shiny + "," + e.numColors + "," + e.bodyLine + "," + e.stiffness + "," + e.waterResistance
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
