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
    }

    @Test
    @DisplayName("Musical Instrument name cannot be null")
    public void musicalInstrumentCannotBeNull() {
        assertThrows(NullPointerException.class, () -> musicalInstrument.setName(null));
    }

    @AfterEach
    void tearDown() {
    }
}