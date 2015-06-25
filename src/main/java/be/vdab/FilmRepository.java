package be.vdab;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jeansmits on 24/06/15.
 */
public class FilmRepository {
    public List<Film> findFilms(){
        return Arrays.asList(
                new Film("Star Wars of the Rings","de lathouwer"),
                new Film("The desolation of jurrasic avengers", "Vandamme")
        );
    }
}
