package com.example.swapi.model.film;

import java.util.List;

public class Film {
    private String uid;
    private String title;
    private String releaseDate;
    private List<String> characters;

    public Film() {
    }

    public Film(String uid, String title, String releaseDate, List<String> characters) {
        this.uid = uid;
        this.title = title;
        this.releaseDate = releaseDate;
        this.characters = characters;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Film{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", characters=" + characters +
                '}';
    }
}
