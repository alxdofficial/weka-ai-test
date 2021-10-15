package model;

// a data entry with known classification that is meant to train a model
public class EntryM {

    // notice the public access here, this is intentional because this model entry object isnt meant to be stored.
    // it is created only to help the arff file writer create a arff file. once the file is created, the machine
    // learning model bases predictions on the file, not EntryM objects.
    public final String color;
    public final String length;
    public final String thickness;
    public final String warmth;
    public final String fabricStitchDensity;
    public final String shiny;
    public final int numClors;
    public final String bodyLine;
    public final String stiffness;
    public final String waterResistance;
    public final String material;
    public final String fit;
    public final String pattern;
    public final String contrastVibrancy;
    public final String classifcication;

    // EFFECTS create a new model entry and trims leading and trailing spaces
    public EntryM(String color, String length, String thickness, String warmth, String fabricStitchDensity,
                  String shiny, int numClors, String bodyLine, String stiffness, String waterResistance,
                  String material, String fit, String pattern, String contrastVibrancy, String classifcication) {

        this.color = color.trim();
        this.length = length.trim();
        this.thickness = thickness.trim();
        this.warmth = warmth.trim();
        this.fabricStitchDensity = fabricStitchDensity.trim();
        this.shiny = shiny.trim();
        this.numClors = numClors;
        this.bodyLine = bodyLine.trim();
        this.stiffness = stiffness.trim();
        this.waterResistance = waterResistance.trim();
        this.material = material.trim();
        this.fit = fit.trim();
        this.pattern = pattern.trim();
        this.contrastVibrancy = contrastVibrancy.trim();
        this.classifcication = classifcication.trim();

    }


}
