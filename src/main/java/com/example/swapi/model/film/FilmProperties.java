package com.example.swapi.model.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmProperties {
    private String title;
    private String release_date;
    private List<String> characters;

    public FilmProperties() {}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public List<String> getCharacters() {
        return characters;
    }
    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }
}
