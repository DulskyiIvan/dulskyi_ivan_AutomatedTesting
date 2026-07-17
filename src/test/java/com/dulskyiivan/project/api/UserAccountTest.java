package com.dulskyiivan.project.api;

import com.dulskyiivan.project.pojo.ApiResponse;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAccountTest {

    private String email;
    private String password;

    @BeforeEach
    public void createTestUser() {

        email = "user" + System.currentTimeMillis() + "@test.com";
        password = "Password123!";

        Map<String, String> body = new HashMap<>();

        body.put("name", "User");
        body.put("email", email);
        body.put("password", password);
        body.put("title", "Mr");
        body.put("birth_date", "10");
        body.put("birth_month", "5");
        body.put("birth_year", "2000");
        body.put("firstname", "Ivan");
        body.put("lastname", "Dulskyi");
        body.put("company", "Test");
        body.put("address1", "Street");
        body.put("country", "Canada");
        body.put("zipcode", "12345");
        body.put("state", "Ontario");
        body.put("city", "Toronto");
        body.put("mobile_number", "123456789");


        given()
                .baseUri("https://automationexercise.com")
                .contentType(ContentType.URLENC)
                .formParams(body)
                .when()
                .post("/api/createAccount")
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteUserAccountTest() {

        Map<String, String> body = new HashMap<>();

        body.put("email", email);
        body.put("password", password);


        ApiResponse response =
                given()
                        .baseUri("https://automationexercise.com")
                        .contentType(ContentType.URLENC)
                        .formParams(body)
                        .when()
                        .delete("/api/deleteAccount")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ApiResponse.class, ObjectMapperType.JACKSON_2);


        assertEquals(200, response.getResponseCode());
        assertEquals("Account deleted!", response.getMessage());
    }

    @Test
    public void updateUserAccountTest() {

        Map<String, String> updateBody = new HashMap<>();

        updateBody.put("name", "Updated User");
        updateBody.put("email", email);
        updateBody.put("password", password);
        updateBody.put("title", "Mr");
        updateBody.put("birth_date", "10");
        updateBody.put("birth_month", "5");
        updateBody.put("birth_year", "2000");
        updateBody.put("firstname", "Updated");
        updateBody.put("lastname", "User");
        updateBody.put("company", "New Company");
        updateBody.put("address1", "New Street");
        updateBody.put("country", "Canada");
        updateBody.put("zipcode", "54321");
        updateBody.put("state", "Ontario");
        updateBody.put("city", "Toronto");
        updateBody.put("mobile_number", "987654321");


        ApiResponse response =
                given()
                        .baseUri("https://automationexercise.com")
                        .contentType(ContentType.URLENC)
                        .formParams(updateBody)
                        .when()
                        .put("/api/updateAccount")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ApiResponse.class, ObjectMapperType.JACKSON_2);


        assertEquals(200, response.getResponseCode());
        assertEquals("User updated!", response.getMessage());
    }

    @Test
    public void verifyLoginWithInvalidCredentials() {

        Map<String, String> body = new HashMap<>();

        body.put("email", "wrong.email@test.com");
        body.put("password", "wrongPassword123");


        ApiResponse response = given()
                .filter(new AllureRestAssured())
                .baseUri("https://automationexercise.com")
                .contentType(ContentType.URLENC)
                .formParams(body)
                .accept(ContentType.JSON)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(200)
                .extract()
                .as(ApiResponse.class, ObjectMapperType.JACKSON_2);

        assertEquals(404, response.getResponseCode());
        assertEquals("User not found!", response.getMessage());
    }
}


