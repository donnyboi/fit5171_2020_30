package allaboutecm.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class MusicianUnitTest {
    private Musician musician;
    private Album album;

    @BeforeEach
    public void setup() { musician = new Musician("Don Bopearachchi"); }



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

}
