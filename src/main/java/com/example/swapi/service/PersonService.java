package com.example.swapi.service;

import com.example.swapi.PersonEndpoint;
import com.example.swapi.model.person.PeopleResponse;
import com.example.swapi.model.person.Person;
import com.example.swapi.model.person.PersonResponse;
import com.example.swapi.model.person.PersonResult;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PersonService {
    private RequestSpecification requestSpecification;

    public PersonService(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Person[] getAllPeople() {
        PeopleResponse response = given()
                .spec(requestSpecification)
                .queryParam("method", "GET")
                .get(PersonEndpoint.PEOPLE.getUrl())
                .getBody()
                .as(PeopleResponse.class);
        return response.getResults();
    }

    public Person getPersonByUrl(String url) {
        PersonResponse response = given()
                .spec(requestSpecification)
                .queryParam("method", "GET")
                .get(url)
                .getBody()
                .as(PersonResponse.class);

        PersonResult result = response.getResult();
        Person person = new Person();
        person.setUid(result.getUid());
        person.setName(result.getProperties().getName());
        person.setHeight(result.getProperties().getHeight());
        return person;
    }

    public Person getTallestPersonOverall() {
        List<Person> detailedPeople = new ArrayList<>();
        String nextUrl = PersonEndpoint.PEOPLE.getUrl();

        while (nextUrl != null && !nextUrl.isEmpty()) {
            PeopleResponse response = given()
                    .spec(requestSpecification)
                    .queryParam("method", "GET")
                    .get(nextUrl)
                    .getBody()
                    .as(PeopleResponse.class);

            for (Person summary : response.getResults()) {
                Person detailed = getPersonByUrl(summary.getUrl());
                if (detailed != null) {
                    detailedPeople.add(detailed);
                }
            }
            nextUrl = response.getNext();
        }

        Person tallest = null;
        for (Person person : detailedPeople) {
            try {
                int height = Integer.parseInt(person.getHeight());
                if (tallest == null || Integer.parseInt(tallest.getHeight()) < height) {
                    tallest = person;
                }
            } catch (NumberFormatException e) {
            }
        }
        return tallest;
    }
}
