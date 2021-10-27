package persistence;
import model.Entry;
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

public class persistenceTest {
    @Test
    void missingFiletest() {
        JsonReader jr = new JsonReader("blah");
        try {
            jr.read();
            fail("should have exception");
        } catch (IOException e) {
            //
        }
    }


    @Test
    void emptyTest() {
        JsonReader jr = new JsonReader("./data/emptyLoce.json");
        try {
            assertEquals(new ArrayList(), jr.read());
        } catch (IOException e) {
            fail("should have no exception");
        }
    }

    @Test
    void normalTest() {
        JsonReader jr = new JsonReader("./data/loceTest.json");
        try {
            Entry e2 = new Entry("1","item1","red","long","thick","high",
                    "high","no",1,"hourglass","stiff",
                    "no","cotton","tight","solid","high");
            Entry e1 = new Entry("2","item2","grey","long","thin","high",
                    "high","yes",1,"hourglass","stretch","yes",
                    "synthetic","tight","solid","low");
            assertEquals(e1.itemName, jr.read().get(0).itemName);
            assertEquals(e2.itemName, jr.read().get(1).itemName);

        } catch (IOException e) {
            fail("should have no exception");
        }
    }

}
