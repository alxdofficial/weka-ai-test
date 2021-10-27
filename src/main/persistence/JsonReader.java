package persistence;

import model.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// from example project



// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads loce from file and returns it;
    // throws IOException if an error occurs reading data from file
    public List<Entry> read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLoce(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses list of entries for classification from JSON object and returns it
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private List<Entry> parseLoce(JSONObject jsonObject) {
        List<Entry> loce = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("loce");
        for (Object json : jsonArray) {
            JSONObject e = (JSONObject) json;
            String id = e.getString("id");
            String itemName = e.getString("itemName");
            String color = e.getString("color");
            String length = e.getString("length");
            String thickness = e.getString("thickness");
            String warmth = e.getString("warmth");
            String fabricStitchDensity = e.getString("fabricStitchDensity");
            String shiny = e.getString("shiny");
            int numColors = e.getInt("numColors");
            String bodyLine = e.getString("bodyLine");
            String stiffness = e.getString("stiffness");
            String waterResistance = e.getString("waterResistance");
            String material = e.getString("material");
            String fit = e.getString("fit");
            String pattern = e.getString("pattern");
            String contrastVibrancy = e.getString("contrastVibrancy");

            Entry newEntry = new Entry(id, itemName, color, length, thickness, warmth, fabricStitchDensity,
                    shiny, numColors, bodyLine, stiffness, waterResistance, material, fit, pattern, contrastVibrancy);

            loce.add(newEntry);

        }
        return loce;
    }

}
