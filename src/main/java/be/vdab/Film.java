package be.vdab;

/**
 * Created by jeansmits on 24/06/15.
 */
public class Film {
    private String title;
    private String director;

    public Film(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }
}
