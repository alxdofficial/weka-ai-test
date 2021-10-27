package persistence;

import model.Entry;
import org.json.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


// from example project


// Represents a writer that writes JSON representation of entries to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of list of entries to file
    public void write(List<Entry> loce) {

        JSONObject mainJson = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Entry e : loce) {
            JSONObject json = e.toJson();
            jsonArray.put(json);
        }
        mainJson.put("loce",jsonArray);
        saveToFile(mainJson.toString(TAB));


    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
