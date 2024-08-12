package dsc.controller;

import java.util.List;

import dsc.model.Film;
import dsc.services.FilmService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class FilmController {
    @EJB
    private FilmService filmService;

    private String title;
    private String director;
    private int releaseYear;

    public void addFilm() {
        Film film = new Film(title, director, releaseYear);
        filmService.addFilm(film);
    }

    public void removeFilm() {
        filmService.removeFilm(title);
    }

    public void updateFilm() {
        Film film = new Film(title, director, releaseYear);
        filmService.updateFilm(film);
    }

    public Film findFilm() {
        return filmService.findFilm(title);
    }

    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
