package com.example.swapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class PeopleApiContractTest {

    private static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://swapi.tech/api")
                .addHeader("Accept", "application/json")
                .build();
    }

    @Test
    public void peopleApiContractTest() {
        given()
                .spec(requestSpec)
                .when()
                .get("/people")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("people-schema.json"));
    }
}
