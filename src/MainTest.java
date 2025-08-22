import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    public void areAnagramsTest() {
        assertEquals(true, Main.anagramOrNot("test", "sett"));
        assertEquals(true, Main.anagramOrNot("Test", "Sett"));
    }

    @Test
    public void haveDuplicatesTest() {
        List<Integer> tmlst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3));
        assertTrue(Main.hasDuplicates(tmlst));
    }
}