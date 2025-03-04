package com.example.swapi.model.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmResult {
    private String uid;
    private FilmProperties properties;

    public FilmResult() {}

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public FilmProperties getProperties() {
        return properties;
    }
    public void setProperties(FilmProperties properties) {
        this.properties = properties;
    }
}
