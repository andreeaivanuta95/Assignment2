package com.example.swapi.model.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResponse {
    private String message;
    private PersonResult result;

    public PersonResponse() {}

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public PersonResult getResult() {
        return result;
    }
    public void setResult(PersonResult result) {
        this.result = result;
    }
}