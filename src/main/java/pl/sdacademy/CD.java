package pl.sdacademy;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * http://dominisz.pl
 * 16.11.2017
 */
@Data
public class CD {

    private String band;
    private String title;
    private String publisher;
    private LocalDate releaseDate;
    private Set<Genre> genres;
    private List<Track> tracks;

    public CD(String band, String title, String publisher, LocalDate releaseDate) {
        this.band = band;
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.genres = new HashSet<>();
        this.tracks = new ArrayList<>();
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void deleteGenre(Genre genre) {
        genres.remove(genre);
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void deleteTrack(int trackNumber) {
        tracks.remove(trackNumber);
    }

    public int getLength(){
        int sum = 0;
        for (Track track : tracks) {
            sum += track.getLength();
        }
        return sum;
        //tracks.stream().mapToInt(track -> track.getLength()).sum();
    }

    public int getTrackCount() {
        return tracks.size();
    }

    public List <Track> searchTrackByTitle(String title){
        return tracks.stream().filter(track -> track.getTitle().contains(title)).collect(Collectors.toList());
    }

}
