package pl.sdacademy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    private LocalDate RELEASE_DATE = LocalDate.of(2017, 1, 1);
    private String AUTHOR = "author";
    private String TITLE = "title";
    private String BAND = "band";
    private String PUBLISHER = "publisher";
    private String NOTES = "notes";

    @Test
    void searchByGenreOnEmptyCDshouldReturnEmptyList() {
        Library lib = new Library();
        List<CD> cdList = lib.searchCDsByGenre(Genre.ROCK);
        assertTrue(cdList.isEmpty());
    }

    @Test
    void searchByGenreWithNonExistingGenreShouldReturnEmptyList() {
        Library lib = new Library();
        CD cd1 = new CD("BAND", "TITLE", "SHIET", RELEASE_DATE);
        cd1.addGenre(Genre.CLASSIC);
        cd1.addGenre(Genre.AFRICAN_HEAVY_METAL);

        CD cd2 = new CD("BAND", "TITLE", "SHIET", RELEASE_DATE);
        cd2.addGenre(Genre.AFRICAN_HEAVY_METAL);

        lib.addCD(cd1);
        lib.addCD(cd2);

        List<CD> cdList = lib.searchCDsByGenre(Genre.ROCK);
        assertTrue(cdList.isEmpty());

    }

    @Test
    void searchByGenreShouldReturnSomeResults() {
        Library lib = new Library();

        CD cd1 = new CD("BAND", "TITLE", "SHIET", RELEASE_DATE);
        cd1.addGenre(Genre.AFRICAN_HEAVY_METAL);

        CD cd2 = new CD("BAND", "TITLE", "SHIET", RELEASE_DATE);
        cd2.addGenre(Genre.AFRICAN_HEAVY_METAL);

        lib.addCD(cd1);
        lib.addCD(cd2);

        List<CD> cdList = lib.searchCDsByGenre(Genre.AFRICAN_HEAVY_METAL);
        assertTrue(cdList.size() == 2);
        assertEquals(cdList.get(0).getGenres(), cd1.getGenres());
        assertEquals(cdList.get(1).getGenres(), cd2.getGenres());
    }

    /**
     * wyszukiwanie płyty po tytule
     * wyszukania w pustej bibliotece nie powinno nic znalezc
     * w bibliotece sa dwie plyty o tym samym tytule i je znajdziemy
     * w bibliotece nie mam plyt o szukanym tytule wiec zwracam pusta liste
     */

    @Test
    void searchCDsByTitleInEmptyLibraryShouldReturnEmptyList() {
        Library lib = new Library();
        assertTrue(lib.searchCDsByCDTitle("Nope").isEmpty());
    }

    @Test
    void searchCDsByTitleInLibraryWithSpecificTitleShouldReturnThisCD() {
        Library lib = new Library();
        CD cd1 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        lib.addCD(cd1);
        assertEquals(lib.searchCDsByCDTitle("Nope").get(0).getTitle(), cd1.getTitle());
    }

    @Test
    void searchCDsByTitleInLibraryWith2SameCDsShouldReturnBothCDs() {
        Library lib = new Library();
        CD cd1 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        CD cd2 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        CD cd3 = new CD("nope", "Lul", "nope", RELEASE_DATE);

        lib.addCD(cd1);
        lib.addCD(cd2);
        lib.addCD(cd3);

        assertEquals(lib.searchCDsByCDTitle("Nope").size(), 2);
        assertEquals(lib.searchCDsByCDTitle("Nope").get(0).getTitle(), cd1.getTitle());
        assertEquals(lib.searchCDsByCDTitle("Nope").get(1).getTitle(), cd2.getTitle());
    }

    @Test
    void searchCDsByTitleInLibraryWithNoExistingCDsShouldReturnEmptyList() {
        Library lib = new Library();
        CD cd1 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        CD cd2 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        CD cd3 = new CD("nope", "Lul", "nope", RELEASE_DATE);

        lib.addCD(cd1);
        lib.addCD(cd2);
        lib.addCD(cd3);

        assertEquals(lib.searchCDsByCDTitle("xd").size(), 0);
    }

    @Test
    void searchCDsByTrackTitleInEmptyLibraryShouldReturnEmptyList() {
        Library lib = new Library();
        assertTrue(lib.searchCDsByTrackTitle("Nope").isEmpty());
    }

    @Test
    void searchCDsByTrackTitleInEmptyLibraryWithSpecificTracksShouldReturnSpecificCDs() {
        Library lib = new Library();
        CD cd1 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        CD cd2 = new CD("nope", "Nope", "nope", RELEASE_DATE);

        cd1.addTrack(new Track(AUTHOR, 40, "Load", NOTES));
        cd2.addTrack(new Track(AUTHOR, 40, "Load", NOTES));

        lib.addCD(cd1);
        lib.addCD(cd2);

        List<CD> result = lib.searchCDsByTrackTitle("Unlucky");

//        assertEquals(result.get(0),cd1);
//        assertEquals(result.get(1),cd2);
        assertTrue(result.isEmpty());
    }

    @Test
    void searchCDsByTrackTitleInNonEmptyLibraryWithAnyTracksShouldReturnContainingCDs() {
        Library lib = new Library();
        CD cd1 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        CD cd2 = new CD("nope", "Nope", "nope", RELEASE_DATE);
        CD cd3 = new CD("omg", "noob", "nope", RELEASE_DATE);

        cd1.addTrack(new Track(AUTHOR, 40, "Load", NOTES));
        cd2.addTrack(new Track(AUTHOR, 40, "Load", NOTES));
        cd3.addTrack(new Track(AUTHOR, 40, "ReLoad", NOTES));
        cd3.addTrack(new Track(AUTHOR, 40, "Jozin", NOTES));

        lib.addCD(cd1);
        lib.addCD(cd2);
        lib.addCD(cd3);

//        List<CD> result = lib.searchCDsByTrackTitle("Load");
//        assertEquals(result.size(),3);
//        assertEquals(result.get(0),cd1);
//        assertEquals(result.get(1),cd2);
//        assertEquals(result.get(2),cd3);

        List<CD> result = lib.searchCDsByTrackTitle("Jozin");
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), cd3);

    }
}
