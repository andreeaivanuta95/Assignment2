package com.example.swapi;

import com.example.swapi.model.film.Film;
import com.example.swapi.model.person.Person;
import com.example.swapi.service.FilmService;
import com.example.swapi.service.PersonService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SwapiTest {

    public static void main(String[] args) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://swapi.tech/api")
                .build();

        FilmService filmService = new FilmService(requestSpecification);
        PersonService personService = new PersonService(requestSpecification);

        // Use Case 1: Find the film with the latest release date.
        Film latestFilm = filmService.getLatestFilm();
        System.out.println("Latest film: " + latestFilm.getTitle());

        // Use Case 2: Find the tallest character among those in the latest film.
        Person tallestCharacter = null;
        int maxHeight = 0;
        if (latestFilm.getCharacters() != null) {
            for (String characterUrl : latestFilm.getCharacters()) {
                Person person = personService.getPersonByUrl(characterUrl);
                try {
                    int height = Integer.parseInt(person.getHeight());
                    if (height > maxHeight) {
                        maxHeight = height;
                        tallestCharacter = person;
                    }
                } catch (NumberFormatException e) {
                    // Skip non-numeric height values.
                }
            }
        }
        System.out.println("Tallest character in the film: " + tallestCharacter.getName() + " with height " + tallestCharacter.getHeight());

        // Use Case 3: Find the tallest person overall.
        Person tallestOverall = personService.getTallestPersonOverall();
        System.out.println("Tallest person overall: " + tallestOverall.getName() + " with height " + tallestOverall.getHeight());
    }
}
