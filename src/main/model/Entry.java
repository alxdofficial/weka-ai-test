package model;

// a normal entry that the ml algorithm will try to predict
// the public access is because this currently isnt stored or accessed by anything except for being printed
// after the the predicitons are made. public will be modified to private once new functionality is added.

public class Entry {
    public final String id;
    public final String itemName;
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

    @SuppressWarnings({"checkstyle:VisibilityModifier", "checkstyle:SuppressWarnings"})
    public String classifcication;

    // EFFECTS create a new entry and trims leading and trailing spaces

    public Entry(String id, String itemName, String color, String length, String thickness, String warmth,
                 String fabricStitchDensity,
                 String shiny, int numClors, String bodyLine, String stiffness, String waterResistance, String material,
                 String fit, String pattern, String contrastVibrancy) {
        this.id = id.trim();
        this.itemName = itemName.trim();
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

    }


    public void label(String classifcication) {
        this.classifcication = classifcication;
    }
}
