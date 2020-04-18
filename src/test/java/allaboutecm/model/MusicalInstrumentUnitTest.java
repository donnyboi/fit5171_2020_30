package allaboutecm.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicalInstrumentUnitTest {
    private MusicalInstrument musicalInstrument;

    @BeforeEach
    void setUp() {
        musicalInstrument = new MusicalInstrument("Guitar");
    }

    @Test
    @DisplayName("Musical Instrument name cannot be null")
    public void musicalInstrumentCannotBeNull() {
        assertThrows(NullPointerException.class, () -> musicalInstrument.setName(null));
    }

    @Test
    @DisplayName("Duplicate object")
    public void testDupicateObject() {
        MusicalInstrument musicalInstrument1 = new MusicalInstrument("Guitar");
        assertEquals(musicalInstrument, musicalInstrument1);
    }

    @Test
    @DisplayName("Test Getter and Setter of Instrument")
    public void testInstrumentGetterandSetter() {
        String testString = "Piano";
        musicalInstrument.setName(testString);
        assertEquals(testString, musicalInstrument.getName());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running: tearDown");
        musicalInstrument = null;
        assertNull(musicalInstrument);
    }
}