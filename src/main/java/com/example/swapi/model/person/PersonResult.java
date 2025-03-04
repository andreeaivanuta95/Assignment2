package com.example.swapi.model.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResult {
    private String uid;
    private PersonProperties properties;

    public PersonResult() {}

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public PersonProperties getProperties() {
        return properties;
    }
    public void setProperties(PersonProperties properties) {
        this.properties = properties;
    }
}