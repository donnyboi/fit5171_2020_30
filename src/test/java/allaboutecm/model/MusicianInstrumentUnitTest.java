package allaboutecm.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicianInstrumentUnitTest {
    private MusicianInstrument musicianInstrument;

    @BeforeEach
    void setUp() {
        musicianInstrument = new MusicianInstrument( new Musician("Hello Don"), new MusicalInstrument("Guitar") );
    }

    @Test
    @DisplayName("Duplicate object")
    public void testForDuplicates() {
        MusicianInstrument musicianInstrument1 = new MusicianInstrument( new Musician("Hello Don"), new MusicalInstrument("Guitar") );
        assertEquals(musicianInstrument1,musicianInstrument);
    }

    @Test
    public void testMusiciansGettersandSetters() {
        Musician musician = new Musician("A@AP Rocky");
        musicianInstrument.setMusician(musician);
        assertEquals(musician, musicianInstrument.getMusician());
    }

    @Test
    public void testMusicalInstrumental() {
        MusicalInstrument musicalInstrument = new MusicalInstrument("Guitar");
        musicianInstrument.setMusicalInstrument(musicalInstrument);
        assertEquals(musicalInstrument, musicianInstrument.getMusicalInstrument());
    }



    @AfterEach
    void tearDown() {
        System.out.println("MusicianInstrument: teardown");
        musicianInstrument = null;
        assertNull(musicianInstrument);
    }
}