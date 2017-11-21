package pl.sdacademy;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Library {
    private List<CD> CDs;

    public Library() {
        CDs = new ArrayList<>();
    }

    public Library(List<CD> CDs) {
        this.CDs = CDs;
    }

    public List<CD> searchCDsByGenre(Genre genre) {
        return CDs.stream()
                .filter(cd -> cd.getGenres()
                        .contains(genre))
                .collect(Collectors.toList());
    }

    List<CD> searchCDsByCDTitle(String title) {
        return CDs.stream()
                .filter(cd -> cd.getTitle()
                        .contains(title))
                .collect(Collectors.toList());
    }

    List<CD> searchCDsByTrackTitle(String title) {
//        return CDs.getTracks().stream().filter(titleCD -> titleCD.getTitle().contains(title));
        return CDs.stream().filter(cd -> !cd.searchTrackByTitle(title).isEmpty()).collect(Collectors.toList());
    }

//    List<CD> searchTracksByTrackTitle(String title){
//        List<CD> myList = new ArrayList<>();
//
//        return CDs.stream().forEach(cd -> cd.getTracks()
//                .stream().filter(fl -> fl.getTitle().contains(title))
//                .to;
//    }

    public void addCD(CD cd) {
        CDs.add(cd);
    }

    public void deleteCD(CD cd) {
        CDs.remove(cd);
    }


}
