package model;

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

    public Entry(String id, String itemName, String color, String length, String thickness, String warmth, String fabricStitchDensity,
                 String shiny, int numClors, String bodyLine, String stiffness, String waterResistance, String material,
                 String material1, String fit, String pattern, String contrastVibrancy) {
        this.id = id;
        this.itemName = itemName;
        this.color = color;
        this.length = length;
        this.thickness = thickness;
        this.warmth = warmth;
        this.fabricStitchDensity = fabricStitchDensity;
        this.shiny = shiny;
        this.numClors = numClors;
        this.bodyLine = bodyLine;
        this.stiffness = stiffness;
        this.waterResistance = waterResistance;
        this.material = material1;
        this.fit = fit;
        this.pattern = pattern;
        this.contrastVibrancy = contrastVibrancy;

    }


    public void label(String classifcication) {
        this.classifcication = classifcication;
    }
}
