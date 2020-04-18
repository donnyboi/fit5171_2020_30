package allaboutecm.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AlbumUnitTest {
    private Album album;

    @BeforeEach
    public void setUp() {
        album = new Album(1975, "ECM 1064/65", "The Köln Concert");
    }

    @Test
    @DisplayName("Album name cannot be null")
    public void albumNameCannotBeNull() {
        assertThrows(NullPointerException.class, () -> album.setAlbumName(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    \t"})
    @DisplayName("Album name cannot be empty or blank")
    public void albumNameConnotBeEmptyOrBlank(String arg) {
        assertThrows(IllegalArgumentException.class, () -> album.setAlbumName(arg));
    }

    @Test
    @DisplayName("Test for Duplicates")
    public void sameNameAndNumberMeansSameAlbum() {
        Album album1 = new Album(1975, "ECM 1064/65", "The Köln Concert");

        assertEquals(album, album1);
    }

    @Test
    @DisplayName("Check that release year hass a valid 4 digit value")
    public void releaseYearMustHave4Characters() {
        assertTrue(String.valueOf(album.getReleaseYear()).length()==4);
    }

    @Test
    @DisplayName("test album name getters and setters")
    public void testAlbumNameGetterAndSetter() {
        album.setAlbumName("The concert");
        assertEquals(album.getAlbumName(),"The concert");
    }

    @Test
    @DisplayName("Test the Getter and Setter and record number")
    public void testRecordNumberGetterAndSetter() {
        album.setRecordNumber("TestRecord");
        assertEquals(album.getRecordNumber(),"TestRecord");
    }

    @Test
    public void testMusicianGettersandSetters() {
        Musician musician = new Musician("Elton John");
        Set<Musician> musicians = new HashSet<Musician>();
        musicians.add(musician);
        album.setFeaturedMusicians(musicians);
        assertEquals(musicians, album.getFeaturedMusicians());
    }

    @Test
    public void testAlbumURLGetterandSetter() {
        try {
            URL base = new URL("http://www.java2s.com/");
            album.setAlbumURL(base);
            assertEquals(base, album.getAlbumURL());
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
    }

    @Test
    @DisplayName("Test getters and setters for Instrument")
    public void testInstrumentGettersandSetters() {
        MusicianInstrument musicianInstrument = new MusicianInstrument( new Musician("Hello Don"), new MusicalInstrument("Guitar") );
        Set<MusicianInstrument> musicianInstruments = new HashSet<MusicianInstrument>();
        musicianInstruments.add(musicianInstrument);
        album.setInstruments(musicianInstruments);
        assertEquals(musicianInstruments, album.getInstruments());
    }

    @Test
    @DisplayName("Test Release getters and setters")
    public void testReleaseYearGetterandSetter() {
        int releaseYear = 2009;
        album.setReleaseYear(releaseYear);
        assertEquals(releaseYear,album.getReleaseYear());
    }


    @AfterEach
    void tearDown() {
        System.out.println("Running: album tearDown");
        album = null;
        assertNull(album);
    }
}