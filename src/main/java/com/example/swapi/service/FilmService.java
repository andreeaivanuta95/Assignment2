package com.example.swapi.service;

import com.example.swapi.FilmEndpoint;
import com.example.swapi.model.film.Film;
import com.example.swapi.model.film.FilmResponse;
import com.example.swapi.model.film.FilmResult;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class FilmService {

    private RequestSpecification requestSpecification;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public FilmService(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Film[] getAllFilms() {
        FilmResponse response = given()
                .spec(requestSpecification)
                .queryParam("method", "GET")
                .get(FilmEndpoint.FILMS.getUrl())
                .getBody()
                .as(FilmResponse.class);

        FilmResult[] filmResults = response.getResult();
        Film[] films = new Film[filmResults.length];
        for (int i = 0; i < filmResults.length; i++) {
            FilmResult filmResult = filmResults[i];
            Film film = new Film();
            film.setUid(filmResult.getUid());
            film.setTitle(filmResult.getProperties().getTitle());
            film.setReleaseDate(filmResult.getProperties().getRelease_date());
            film.setCharacters(filmResult.getProperties().getCharacters());
            films[i] = film;
        }
        return films;
    }

    public Film getLatestFilm() {
        Film[] films = getAllFilms();
        Film latestFilm = null;
        LocalDate latestDate = null;
        for (Film film : films) {
            if (film.getReleaseDate() != null && !film.getReleaseDate().isEmpty()) {
                LocalDate releaseDate = LocalDate.parse(film.getReleaseDate(), formatter);
                if (latestDate == null || releaseDate.isAfter(latestDate)) {
                    latestDate = releaseDate;
                    latestFilm = film;
                }
            }
        }
        return latestFilm;
    }
}
