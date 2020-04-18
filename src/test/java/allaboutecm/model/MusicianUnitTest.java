package allaboutecm.model;

import com.sun.xml.internal.xsom.impl.util.Uri;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MusicianUnitTest {
    private Musician musician;
    private Album album;

    @BeforeEach
    public void setup() {
        musician = new Musician("Don Bopearachchi");
        album = new Album(1975, "ECM 1064/65", "The Köln Concert");
    }



    @Test
    @DisplayName("More than two words")
    public void musicianNameHasMoreThanTwoWord() {
        String word = musician.getName().trim();
        int count = word.isEmpty() ? 0 : word.split("\\s+").length;
        assertTrue(count > 1);
    }

    @Test
    @DisplayName("Album name cannot be null")
    public void musicianNameCannotBeNull() {
        assertThrows(NullPointerException.class, () -> musician.setName(null));
    }


    @Test
    @DisplayName("Check if musician exists")
    public void shouldReturnTrueWhenMusiciansHasTheSameName() {
        String musicianName = "A$AP Rocky";
        musician.setName(musicianName);
        Musician anotherMusician = new Musician(musicianName);
        assertTrue(musician.equals(anotherMusician));
    }

    @Test
    @DisplayName("Duplicate object")
    public void testDuplicateObject() {
        Musician musician1 = new Musician("Don Bopearachchi");
        assertEquals(musician, musician1);
    }

    @Test
    @DisplayName("Check if URL has a protocl")
    public void displayTrueForLinksWithoutProtocol() {
        assertThrows(MalformedURLException.class, () -> musician.setMusicianUrl(new URL("www.google.com/")));
    }

    @Test
    @DisplayName("Test Album Setter")
    public void testAlbumSetterForMusicianClass() {
        Set<Album> albums = new HashSet<Album>();
        albums.add(album);
        musician.setAlbums(albums);
        System.out.println(musician.getAlbums());
        assertEquals(albums, musician.getAlbums());
    }

    @Test
    @DisplayName("Test getters and setters for music URL")
    public void testMusicianURL () {
        try {
            URL base = new URL("http://www.java2s.com/");
            musician.setMusicianUrl(base);
            musician.getMusicianUrl();
            assertEquals(base, musician.getMusicianUrl());
        } catch (MalformedURLException ex) {
           System.out.println(ex);
        }

    }

    @AfterEach
    void tearDown() {
        System.out.println("Running: musician tearDown");
        musician = null;
        assertNull(musician);
    }
}
