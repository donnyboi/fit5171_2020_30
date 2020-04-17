package allaboutecm.model;

import com.sun.xml.internal.xsom.impl.util.Uri;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import static org.junit.jupiter.api.Assertions.*;

public class MusicianUnitTest {
    private Musician musician;
    private Album album;

    @BeforeEach
    public void setup() { musician = new Musician("Don Bopearachchi"); }

    @Test
    @DisplayName("More than two words")
    public void musicianNameHasMoreThanTwoWord() {
        String word = musician.getName().trim();
        int count;
        if (word == null) { count = 0; }
        count = word.isEmpty() ? 0 : word.split("\\s+").length;
        assertTrue(count > 1);
    }

    @Test
    @DisplayName("Album name cannot be null")
    public void musicianNameCannotBeNull() {
        assertThrows(NullPointerException.class, () -> musician.setName(null));
    }

    @Test
    @DisplayName("Set a album name")
    public void setAlbumInfo() {}

    @Test
    @DisplayName("Check if musician exists")
    public void shouldReturnTrueWhenMusiciansHasTheSameName() {
        String musicianName = "A$AP Rocky";
        musician.setName(musicianName);
        Musician anotherMusician = new Musician(musicianName);
        assertTrue(musician.equals(anotherMusician));
    }

    @Test
    @DisplayName("Check if URL has a protocl")
    public void displayTrueForLinksWithoutProtocol() {
        assertThrows(MalformedURLException.class, () -> musician.setMusicianUrl(new URL("www.google.com/")));
    }

}
