package com.example.swapi.model.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmResponse {
    private String message;
    private FilmResult[] result;

    public FilmResponse() {}

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public FilmResult[] getResult() {
        return result;
    }
    public void setResult(FilmResult[] result) {
        this.result = result;
    }
}
