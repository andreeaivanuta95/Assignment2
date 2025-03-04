package com.example.swapi;

public enum FilmEndpoint {
    FILMS("https://swapi.tech/api/films");

    private final String url;

    FilmEndpoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
