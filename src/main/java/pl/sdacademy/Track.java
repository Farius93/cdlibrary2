package pl.sdacademy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * http://dominisz.pl
 * 16.11.2017
 */
@Data
@AllArgsConstructor
public class Track {

    private String author;
    private int length;
    private String title;
    private String notes;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getLength() {
        return length;
    }


}
