package com.example.swapi;

public enum PersonEndpoint {
    PEOPLE("https://swapi.tech/api/people");

    private final String url;

    PersonEndpoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
