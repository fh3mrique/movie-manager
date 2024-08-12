package dsc.services;

import java.util.List;

import dsc.model.Film;
import jakarta.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class FilmService {
	private List<Film> films = new ArrayList<>();

    public void addFilm(Film film) {
        films.add(film);
    }

    public void removeFilm(String title) {
        films.removeIf(film -> film.getTitle().equals(title));
    }

    public void updateFilm(Film updatedFilm) {
        for (Film film : films) {
            if (film.getTitle().equals(updatedFilm.getTitle())) {
                film.setDirector(updatedFilm.getDirector());
                film.setReleaseYear(updatedFilm.getReleaseYear());
                break;
            }
        }
    }

    public Film findFilm(String title) {
        return films.stream().filter(film -> film.getTitle().equals(title)).findFirst().orElse(null);
    }

    public List<Film> getAllFilms() {
        return films;
    }
}
